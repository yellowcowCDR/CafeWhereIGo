package com.ubo.CafeWhereIGo.articlephoto.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.articlephoto.vo.ArticlePhotoVO;

@Repository("ArticlePhotoDAO")
public class ArticlePhotoDAOImpl implements ArticlePhotoDAO{
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
	public void modify(ArticlePhotoVO articlePhotoVO) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.articlephoto.update", articlePhotoVO);
	}

	@Override
	public List<ArticlePhotoVO> getArticlePhotoList(int article_id) {
		// TODO Auto-generated method stub
		List<ArticlePhotoVO> articlePhotoList = sqlSession.selectList("mapper.articlephoto.download", article_id);
		return articlePhotoList;
	}
	
	
}
