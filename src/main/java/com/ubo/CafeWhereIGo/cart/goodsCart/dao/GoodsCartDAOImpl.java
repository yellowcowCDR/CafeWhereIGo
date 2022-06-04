package com.ubo.CafeWhereIGo.cart.goodsCart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubo.CafeWhereIGo.cart.goodsCart.vo.GoodsCartSearchResultVO;
import com.ubo.CafeWhereIGo.cart.goodsCart.vo.GoodsCartVO;

@Repository
public class GoodsCartDAOImpl implements GoodsCartDAO{
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertGoodsCart(GoodsCartVO goodsCart) {
		// TODO Auto-generated method stub
		sqlSession.insert("mapper.goodsCart.insertGoodsCart",goodsCart);
	}

	@Override
	public List<GoodsCartSearchResultVO> selectGoodsCartListByCafeId(int cafe_id) {
		// TODO Auto-generated method stub
		List<GoodsCartSearchResultVO> goodsCartList = sqlSession.selectList("mapper.goodsCart.selectGoodsCartByCafeId",cafe_id);
		return goodsCartList;
	}

	@Override
	public List<GoodsCartSearchResultVO> selectGoodsCartListByUserId(String user_id) {
		// TODO Auto-generated method stub
		List<GoodsCartSearchResultVO> goodsCartList = sqlSession.selectList("mapper.goodsCart.selectGoodsCartByUserId",user_id);
		return goodsCartList;
	}

	@Override
	public void updateGoodsCart(GoodsCartVO goodsCart) {
		// TODO Auto-generated method stub
		sqlSession.update("mapper.goodsCart.updateGoodsCart", goodsCart);
	}

	@Override
	public void deleteGoodsCart(int cart_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("mapper.goodsCart.deleteGoodsCart", cart_id);
	}
}
