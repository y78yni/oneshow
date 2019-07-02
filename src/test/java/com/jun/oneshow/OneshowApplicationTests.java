//package com.jun.oneshow;
//
//import com.jun.oneshow.entity.User;
//import com.jun.oneshow.mapper.UserMapper;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class OneshowApplicationTests {
//
//	@Autowired
//	private UserMapper userMapper;
//
//	@Test
//	public void testSelect() {
//		System.out.println(("----- selectAll method test ------"));
//		List<User> userList = userMapper.selectList(null);
//		Assert.assertEquals(5, userList.size());
//		userList.forEach(System.out::println);
//	}
//	//这个是引入xml的自定义方法，xml文件不是必须
//	@Test
//	public void testSelect2() {
//		System.out.println(("----- select222All method test ------"));
//		List<User> userList = userMapper.list();
//		Assert.assertEquals(5, userList.size());
//		userList.forEach(System.out::println);
//	}
//
//}
