package main.java.com.myWeb;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import main.java.com.myWeb.config.filter.RewriteFilter;
import main.java.com.myWeb.domain.Entity.User;
import main.java.com.myWeb.domain.dao.UserDao;

@SpringBootApplication

public class SpringBootMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainApplication.class, args);
	}

	@Bean

	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return (container -> {

			ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/errors/401.html");

			ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/errors/404.html");

			ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errors/500.html");

			container.addErrorPages(error401Page, error404Page, error500Page);

		});

	}
	
//	@Bean
//    InitializingBean saveData(UserDao repo){
//        return ()->{
//        	Date date = new Date();
//
//			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
//
//			String  formattedDate= dateFormat.format(date);
//
//            repo.save(new User("aa1", "aa@126.com", "aa", "aa123456", formattedDate));
//            repo.save(new User("bb2", "bb@126.com", "bb", "bb123456", formattedDate));
//            repo.save( new User("cc3", "cc@126.com", "cc", "cc123456", formattedDate));
//          
//        };
//    }

//	@Bean
//
//	public FilterRegistrationBean testFilterRegistration() {
//
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//
//		registration.setFilter(new RewriteFilter());// 注册rewrite过滤器
//
//		registration.addUrlPatterns("/*");
//
//		registration.addInitParameter(RewriteFilter.REWRITE_TO, "/index.html");
//
//		registration.addInitParameter(RewriteFilter.REWRITE_PATTERNS, "/ui/*");
//
//		registration.setName("rewriteFilter");
//
//		registration.setOrder(1);
//
//		return registration;
//
//	}

}
