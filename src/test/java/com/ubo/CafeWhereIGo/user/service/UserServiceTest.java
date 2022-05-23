package com.ubo.CafeWhereIGo.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ubo.CafeWhereIGo.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/mybatis-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		})
@WebAppConfiguration
public class UserServiceTest {
	@Autowired
	UserVO userVO;
	
	@Autowired 
	UserService userService;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Test
	public void sqlSessionTest() {
		assertNotNull(sqlSession);
	}
	
	@Test
	public void testLogin() throws Exception{
		String user_id="sm1234";
		String raw_pw="asdf";
		String encoded_pw=bcryptPasswordEncoder.encode(raw_pw);
		String encodedPassword = userService.getUserPassword(user_id);
		
		boolean isLoginSucceed=bcryptPasswordEncoder.matches(raw_pw, encodedPassword);
		assertTrue(isLoginSucceed);
		
		UserVO userVO = new UserVO(user_id, encodedPassword);
		UserVO userInfo=(UserVO)userService.login(userVO);
		assertEquals(userInfo.getUser_name(),"최대현");
	}

//	@Test
//	public void testOverlapped() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRegister() {
//		fail("Not yet implemented");
//	}

}
