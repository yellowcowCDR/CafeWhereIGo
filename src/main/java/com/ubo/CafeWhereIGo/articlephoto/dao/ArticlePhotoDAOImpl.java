package com.ubo.CafeWhereIGo.articlephoto.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.articlephoto.vo.ArticlePhotoVO;

@Repository("ArticlePhotoDAO")
public class ArticlePhotoDAOImpl implements ArticlePhotoDAO{
	final static Logger logger = LoggerFactory.getLogger(ArticlePhotoDAOImpl.class);
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void upload(ArticlePhotoVO articlePhotoVO) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.articlephoto.uploadOne", articlePhotoVO);
	}

	@Override
	public void upload(List<ArticlePhotoVO> articlePhotoVOList) {
		// TODO Auto-generated method stub
		for(int i=0; i<articlePhotoVOList.size(); i++) {
			sqlSession.insert("mapper.articlephoto.uploadOne", articlePhotoVOList.get(i));
		}
		
	}

	@Override
	public void deletePhotos(int article_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.articlephoto.delete", article_id);
	}

	
	@Override
	public void deleteWithPhotoId(int article_photo_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.articlephoto.deleteWithPhotoId", article_photo_id);
	}

	@Override
	public void modify(ArticlePhotoVO articlePhotoVO) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.articlephoto.update", articlePhotoVO);
	}
	
	@Override
	public void modifyOne(ArticlePhotoVO articlePotoVO) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.articlephoto.updateOne", articlePotoVO);
	}

	@Override
	public List<ArticlePhotoVO> getArticlePhotoList(int article_id) {
		// TODO Auto-generated method stub
		List<ArticlePhotoVO> articlePhotoList = sqlSession.selectList("mapper.articlephoto.download", article_id);
		logger.debug("[@ArticlePhotoDAO] article_id : " + article_id);
		for(int i=0;i<articlePhotoList.size();i++) {
			logger.debug("[@ArticlePhotoDAO] is Photo null? : " + (articlePhotoList.get(i)==null));
		}
		return articlePhotoList;
	}

	
	@Override
	public List<ArticlePhotoVO> getFiles(int article_id) {
		// TODO Auto-generated method stub
		List<ArticlePhotoVO> files = (List<ArticlePhotoVO>) sqlSession.selectList("mapper.articlephoto.selectFiles", article_id);
		
		return files;
	}

	@Override
	public boolean isFileExists(int article_photo_id) {
		// TODO Auto-generated method stub
		boolean isFileExists = (Boolean) sqlSession.selectOne("mapper.articlephoto.isFileExists", article_photo_id);
		
		return isFileExists;
	}
	
	
}
