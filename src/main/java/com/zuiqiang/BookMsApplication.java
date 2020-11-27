package com.zuiqiang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@MapperScan(basePackages = "com.zuiqiang.*.dao")
@SpringBootApplication
public class BookMsApplication {
	public static String pathAll=System.getProperty("user.dir")+"//src//main//resources//static";
	//public static String pathAll="C:\\pache-tomcat-8.0.8\\apache-tomcat-8.0.8\\webapps\\library";
	public static void main(String[] args) {
		System.out.println("C:\\\\apache-tomcat-8.0.8\\\\apache-tomcat-8.0.8\\\\webapps\\\\library");
		SpringApplication.run(BookMsApplication.class, args);
	}

	// 配置跨域
	@Bean
	public CorsFilter corsFilter() {
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(source);
	}

}
