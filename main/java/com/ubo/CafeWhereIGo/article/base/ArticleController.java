package com.ubo.CafeWhereIGo.article.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ubo.CafeWhereIGo.article.service.ArticleService;
import com.ubo.CafeWhereIGo.article.vo.ArticleVO;
import com.ubo.CafeWhereIGo.articleReply.vo.ArticleReplyVO;
import com.ubo.CafeWhereIGo.articlephoto.vo.ArticlePhotoVO;
import com.ubo.CafeWhereIGo.likedArticle.vo.LikedArticleVO;
import com.ubo.CafeWhereIGo.user.vo.UserVO;

@Controller("articleController")
public class ArticleController {	
	protected static String CURR_IMAGE_REPO_PATH = "C:\\cafe\\file_repo\\photo\\articlePhoto";
	Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/article/download.do")
	protected void download(@RequestParam("fileName") String fileName,
		                 	@RequestParam("article_id") String article_id,
			                 HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String filePath=CURR_IMAGE_REPO_PATH+"\\"+article_id+"\\"+fileName;
		File image=new File(filePath);
		if(image.exists()) {
			response.setHeader("Cache-Control","no-cache");
			response.addHeader("Content-disposition", "attachment; fileName="+fileName);
			FileInputStream in=new FileInputStream(image); 
			byte[] buffer=new byte[1024*8];
			while(true){
				int count=in.read(buffer); //버퍼에 읽어들인 문자개수
				if(count==-1)  //버퍼의 마지막에 도달했는지 체크
					break;
				out.write(buffer,0,count);
			}
			in.close();
		}
		out.close();
	}
	
	@RequestMapping(value= "/*/addArticleForm.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView addArticleForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String uri = request.getRequestURI().toString();
		String articleType = getArticleType(uri);
		String viewName = "/"+articleType+"/addArticleForm";
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@RequestMapping(value= "/*/modifyArticleForm.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView modifyArticleForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String uri = request.getRequestURI().toString();
		String articleType = getArticleType(uri);
		String viewName = "/"+articleType+"/modifyArticleForm";
		mav.setViewName(viewName);
		
		return mav;
	}
	
	@RequestMapping(value="/*/addArticle.do" ,method = RequestMethod.POST)
	public ModelAndView addArticle(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		
		ArticleVO articleVO = new ArticleVO();
		ArticlePhotoVO articlePhotoVO;
		List<ArticlePhotoVO> articlePhotoVOList = new ArrayList<ArticlePhotoVO>();
		
		Enumeration enu=multipartRequest.getParameterNames();
		
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value=multipartRequest.getParameter(name);
			if(name.equals("cafe_name")) {
				articleVO.setCafe_name(value);
			}else if(name.equals("article_title")) {
				articleVO.setArticle_title(value);
			}else if(name.equals("article_body")) {
				articleVO.setArticle_content(value);
			}
			
		}
		HttpSession session = multipartRequest.getSession();
		UserVO userInfo = (UserVO)session.getAttribute("loginSession");
		String writer_id = userInfo.getUser_id();
		articleVO.setUser_user_id(writer_id);
		
		//article type 설정
		String uri = multipartRequest.getRequestURI().toString();
		String articleType = getArticleType(uri);
		articleVO.setArticleType(articleType);
		
		
		
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String orginalFilename = mFile.getOriginalFilename();
			if(!orginalFilename.equals("") && orginalFilename!=null)
			{
				fileList.add(mFile.getOriginalFilename());
			}
		}
		for(int i=0; i<fileList.size();i++) {
			String filename = fileList.get(i);
			
			articlePhotoVO = new ArticlePhotoVO();
			articlePhotoVO.setFilename(filename);
			
			articlePhotoVOList.add(articlePhotoVO);
		}
		int article_id = articleService.registerArticle(articleVO, articlePhotoVOList);
		
		if(fileList != null && fileList.size()>0) {
			fileProcess(multipartRequest, article_id);
		}
		ModelAndView mav = new ModelAndView();
		
		
		String viewName = "redirect:/"+articleType+"/search.do";
		mav.setViewName(viewName);
		
		return mav;
	}
	@RequestMapping(value= "/*/deleteArticle.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView deleteArticle(@RequestParam("article_id") int article_id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		deletePhotos(article_id);
		articleService.deleteArticle(article_id);
		ModelAndView mav = new ModelAndView();
		
		String uri = request.getRequestURI().toString();
		String articleType = getArticleType(uri);
		String viewName = "redirect:/"+articleType+"/search.do";
		mav.setViewName(viewName);
		
		return mav;
	}
	@RequestMapping(value= "/*/search.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ModelAndView mav=new ModelAndView();
		String uri = request.getRequestURI().toString();
		String articleType = getArticleType(uri);
		List<ArticleVO> articleList = articleService.getArticleList(articleType);
		for(int i=0; i<articleList.size(); i++) {
			System.out.println("article title: " + articleList.get(i).getArticle_title());
		}
		String viewName = "/"+articleType+"/search";
		mav.setViewName(viewName);
		mav.addObject("articleList", articleList);
		return mav;
	}
	
	@RequestMapping(value= "/*/detail.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView detail(@RequestParam("article_id") int article_id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		
		UserVO userInfo = (UserVO) session.getAttribute("loginSession");
		String user_id = userInfo.getUser_id();
		List<ArticleReplyVO> replies = articleService.getReplies(article_id); 
		
		LikedArticleVO likedArticleVO = new LikedArticleVO(user_id, article_id);
		boolean isLiked = articleService.isLiked(likedArticleVO);
		
		Map<String,Object> articleMap = articleService.getArticle(article_id);
		articleMap.put("replies", replies);
		ModelAndView mav=new ModelAndView();
		String uri = request.getRequestURI().toString();
		String articleType = getArticleType(uri);
		String viewName = "/"+articleType+"/detail";
		mav.setViewName(viewName);
		mav.addObject("articleMap", articleMap);
		mav.addObject("isLiked", isLiked);
		return mav;
	}
	
	protected List<String> fileProcess(MultipartHttpServletRequest multipartRequest, int article_id) throws Exception{ 
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		final String CURR_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"\\"+article_id;
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String originalFileName = mFile.getOriginalFilename();
			if(!originalFileName.equals("") || originalFileName!=null) {
				fileList.add(originalFileName);
				File file = new File(CURR_IMAGE_DIR+"\\"+fileName);
				if(mFile.getSize()>0) {
					if(!file.exists()) {
						if(file.getParentFile().mkdirs()) {
							file.createNewFile();
						}
					}
					mFile.transferTo((new File(CURR_IMAGE_DIR+"\\"+originalFileName)));
				}
			
			}
		}
		
		//빈 파일 삭제
		File dir = new File(CURR_IMAGE_DIR);
		File filelist[] = dir.listFiles();
		
		for(File file:filelist) {
			if(isDummyFile(file.getName())) {
				file.delete();
			}
		}
		
		return fileList;
	}
	
	protected boolean isDummyFile(String name) {
		boolean filenameValidation = false;
		StringTokenizer tokenizer = new StringTokenizer(name,".");
		
		if(tokenizer.countTokens()<=1) {
			filenameValidation=true;
		}
		return filenameValidation;
	}
	
	private void deletePhotos(int article_id) {
		final String CURR_IMAGE_DIR = CURR_IMAGE_REPO_PATH+"\\"+article_id;
		logger.debug("delete Image Dir: " + CURR_IMAGE_DIR);
		File dir = new File(CURR_IMAGE_DIR);
		
		File files[] = dir.listFiles();
		if(files != null && files.length>0) {
			for(File file : files) {
				logger.debug("delte Image Filename: " + file.getName());
				file.delete();
			}
			dir.delete();
		}
		
	}
	
	protected String getArticleType(String uri) {
		String articleType = null;
		
		StringTokenizer tokens = new StringTokenizer(uri,"/");
		ArrayList<String> tokenList = new ArrayList<String>();
		while(tokens.hasMoreTokens()) {
			tokenList.add(tokens.nextToken());
		}
		if(tokenList.size()>2) {
			articleType=tokenList.get(1);
		}
		
		return articleType;
	}
	
	@RequestMapping(value="/*/addReply.do", method={RequestMethod.POST})
	protected ResponseEntity addReply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String user_id = request.getParameter("user_id");
		int article_id = Integer.parseInt(request.getParameter("article_id"));
		String replyText = request.getParameter("replyText");
		
		ArticleReplyVO articleReply = new ArticleReplyVO(user_id, article_id, replyText);
		
		articleService.addReply(articleReply);
		
		String result = "ok";
		ResponseEntity resEntity =new ResponseEntity(result, HttpStatus.OK);
		
		return resEntity;
	}
	@RequestMapping(value="/*/deleteReply.do", method={RequestMethod.POST})
	protected ResponseEntity deleteReply(@RequestParam("reply_id") int reply_id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		articleService.deleteReply(reply_id);
		System.out.println("reply_id:" +reply_id);
		String result = "ok";
		ResponseEntity resEntity =new ResponseEntity(result, HttpStatus.OK);
		
		return resEntity;
	}
	@RequestMapping(value="/*/like.do", method={RequestMethod.POST})
	protected ResponseEntity like(@RequestParam("article_id") int article_id, @RequestParam("user_id") String user_id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		LikedArticleVO likedArticleVO = new LikedArticleVO(user_id, article_id); 
		articleService.add_liked_article(likedArticleVO);
		
		String result = "ok";
		ResponseEntity resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;	
	}

	
}
