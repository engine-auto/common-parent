package com.auto;

import java.util.concurrent.CountDownLatch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@SpringBootApplication
//@ImportResource("classpath:providers.xml")
@ServletComponentScan
@MapperScan("com.auto.mapper")
public class Application implements EmbeddedServletContainerCustomizer {

	@RequestMapping("/hello")
	public String hello() {
		return "hello World!!!";
	}

//	@Bean
//	public ServletRegistrationBean druidServlet() {
//		ServletRegistrationBean reg = new ServletRegistrationBean();
//		reg.setServlet(new StatViewServlet());
//		reg.addUrlMappings("/druid/*");
//		reg.addInitParameter("allow", "10.99.8.104");
//		reg.addInitParameter("deny", "127.0.0.2");
//		reg.addInitParameter("loginUsername", "root");
//		reg.addInitParameter("loginPassword", "root");
//		return reg;
//	}
//
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean() {
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//		filterRegistrationBean.setFilter(new WebStatFilter());
//		filterRegistrationBean.addUrlPatterns("/*");
//		filterRegistrationBean.addInitParameter("exclusions",
//				"*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//		return filterRegistrationBean;
//	}

	@Bean
	public CountDownLatch closeLatch() {
		return new CountDownLatch(1);
	}

	public static void main(String[] args) throws Exception {
//		ApplicationContext ctx = new SpringApplicationBuilder()
//				.sources(Application.class).web(false).run(args);
		SpringApplication application = new SpringApplication(Application.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);

//		CountDownLatch closeLatch = ctx.getBean(CountDownLatch.class);
//		closeLatch.await();
	}


    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8081);
    }
}
