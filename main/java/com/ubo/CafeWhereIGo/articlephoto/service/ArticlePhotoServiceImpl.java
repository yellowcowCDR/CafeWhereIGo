package com.ubo.CafeWhereIGo.articlephoto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ubo.CafeWhereIGo.articlephoto.dao.ArticlePhotoDAO;

@Transactional
@Service("articlePhotoServiceImpl")
public class ArticlePhotoServiceImpl implements ArticlePhotoService {
	@Autowired
	ArticlePhotoDAO  articlePhotoDAO;
	
	
}
