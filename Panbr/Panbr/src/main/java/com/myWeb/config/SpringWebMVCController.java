package main.java.com.myWeb.config;



import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



public class SpringWebMVCController extends WebMvcConfigurerAdapter{

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("Resources");
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static");
		super.addResourceHandlers(registry);
	}

}
