package test.java;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import main.java.com.myWeb.SpringBootMainApplication;
import main.java.com.myWeb.domain.Entity.User;
import main.java.com.myWeb.domain.dao.UserDao;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class UserDaoTests {
	
	@Autowired
	private UserDao userDao;

	
	@Test
	public void test() throws Exception {

		Date date = new Date();

		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

		String formattedDate = dateFormat.format(date);

//		userDao.save(new User("aa1", "aa@126.com", "aa", "aa123456", formattedDate));
//
//		userDao.save(new User("bb2", "bb@126.com", "bb", "bb123456", formattedDate));
//
//		userDao.save(new User("cc3", "cc@126.com", "cc", "cc123456", formattedDate));

		Assert.assertEquals(9, userDao.findAll().size());

		Assert.assertEquals("bb", userDao.findByUserNameOrEmail("bb", "cc@126.com").getNickName());

		userDao.delete(userDao.findByUserName("aa1"));

	}
}
