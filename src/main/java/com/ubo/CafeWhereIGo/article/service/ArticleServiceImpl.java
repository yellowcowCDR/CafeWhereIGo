package com.ubo.CafeWhereIGo.article.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubo.CafeWhereIGo.article.dao.ArticleDAO;
import com.ubo.CafeWhereIGo.article.vo.ArticleVO;
import com.ubo.CafeWhereIGo.article.vo.ArticleSearchConditionVO;
import com.ubo.CafeWhereIGo.articleReply.dao.ArticleReplyDAO;
import com.ubo.CafeWhereIGo.articleReply.vo.ArticleReplyVO;
import com.ubo.CafeWhereIGo.articlephoto.dao.ArticlePhotoDAO;
import com.ubo.CafeWhereIGo.articlephoto.vo.ArticlePhotoVO;
import com.ubo.CafeWhereIGo.likedArticle.vo.LikedArticleVO;

@Transactional
@Service("articleService")
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleDAO articleDAO;
	
	@Autowired
	private ArticleReplyDAO articleReplyDAO;
	
	@Autowired
	private ArticlePhotoDAO articlePhotoDAO;
	
	@Override
	public int registerArticle(ArticleVO articleVO, List<ArticlePhotoVO> articlePhotoVOList) {
		articleDAO.insertArticle(articleVO);
		int articleNo = articleDAO.getLastArticleNo();
		for(int i=0; i<articlePhotoVOList.size();i++) {
			articlePhotoVOList.get(i).setArticle_article_id(articleNo);
		}
		articlePhotoDAO.upload(articlePhotoVOList);
		return articleNo;
	}

	@Override
	public List<ArticleVO> getArticleList(int startArticleNO, int endArticleNO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteArticle(int articleNO) {
		// TODO Auto-generated method stub
		articlePhotoDAO.deletePhotos(articleNO);
		articleDAO.deleteArticle(articleNO);
	}

	@Override
	public void modifyArticle(ArticleVO articleVO,List<ArticlePhotoVO> articlePhotoVOList) {
		// TODO Auto-generated method stub
		articlePhotoDAO.upload(articlePhotoVOList);
		articleDAO.updateArticle(articleVO);
	}

	@Override
	public List<ArticleVO> getArticleList(ArticleSearchConditionVO condition) {
		// TODO Auto-generated method stub
		List<ArticleVO> articleList=articleDAO.selectAllArticle(condition);
		for(int i=0; i<articleList.size();i++) {
			ArticleVO article = articleList.get(i);
			int article_id=article.getArticle_id();
			int likeCount = articleDAO.getArticleLikeCount(article_id);
			article.setLikeCount(likeCount);
		}
		return articleList;
	}
	
	@Override
	public List<ArticleVO> searchArticle(ArticleSearchConditionVO searchConditionVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String,Object> getArticle(int article_id) {
		// TODO Auto-generated method stub
		ArticleVO articleVO = articleDAO.selectArticle(article_id);
		List<ArticlePhotoVO> articlePhotoList = articlePhotoDAO.getArticlePhotoList(article_id);
		
		Map<String,Object> articleMap = new HashMap<String,Object>();
		articleMap.put("article",articleVO);
		articleMap.put("articlePhotoList", articlePhotoList);
		articleDAO.addViewCount(article_id);
		return articleMap;
	}
	
	@Override
	public void add_liked_article(LikedArticleVO likedArticleVO) {
		// TODO Auto-generated method stub
		boolean isLiked = articleDAO.isLiked(likedArticleVO);
		if(isLiked) {
			articleDAO.articleLikeCancel(likedArticleVO);
		}else {
			articleDAO.articleLike(likedArticleVO);
		}
		
	}
	
	@Override
	public boolean isLiked(LikedArticleVO likedArticleVO) {
		boolean isLiked = articleDAO.isLiked(likedArticleVO);
		return isLiked;
	}

	@Override
	public void delete_liked_article(LikedArticleVO likedArticleVO) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add_view_count(int article_id) {
		// TODO Auto-generated method stub
		articleDAO.addViewCount(article_id);
	}
	
	
	
	@Override
	public int get_liked_count(int article_id) {
		// TODO Auto-generated method stub
		return articleDAO.getArticleLikeCount(article_id);
	}

	@Override
	public int getNextArticleNo() {
		int nextArticleNo=articleDAO.getNextArticleNo();
		return nextArticleNo;
	}
	@Override
	public int getLastArticleNo() {
		int nextArticleNo=articleDAO.getNextArticleNo();
		return nextArticleNo;
	}

	@Override
	public void addReply(ArticleReplyVO articleReplyVO) {
		// TODO Auto-generated method stub
		articleDAO.addReply(articleReplyVO);
		
	}

	@Override
	public List<ArticleReplyVO> getReplies(int article_id) {
		// TODO Auto-generated method stub
		List<ArticleReplyVO> replies = articleDAO.getReplies(article_id);
		return replies;
	}

	@Override
	public void deleteReply(int reply_id) {
		// TODO Auto-generated method stub
		articleDAO.deleteReply(reply_id);
	}

	@Override
	public void updateReply(ArticleReplyVO articleReplyVO) {
		// TODO Auto-generated method stub
		articleReplyDAO.updateReply(articleReplyVO);
	}
	
	@Override
	public List<ArticlePhotoVO> getFiles(int article_id) {
		// TODO Auto-generated method stub
		List<ArticlePhotoVO> files = articlePhotoDAO.getFiles(article_id);
		
		return files;
	}
	
	@Override
	public boolean isFileExists(int article_photo_id) {
		boolean isFileExists=articlePhotoDAO.isFileExists(article_photo_id);
		return isFileExists;
	}
	
	@Override
	public void updateOne(ArticlePhotoVO articlePhotoVO) {
		// TODO Auto-generated method stub
		articlePhotoDAO.modifyOne(articlePhotoVO);
	}

	@Override
	public void deleteWithPhotoId(int article_photo_id) {
		// TODO Auto-generated method stub
		articlePhotoDAO.deleteWithPhotoId(article_photo_id);
	}
	
}
