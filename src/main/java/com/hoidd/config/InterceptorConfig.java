package com.hoidd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hoidd.core.interceptor.DriverApiInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Bean
	public DriverApiInterceptor getDriverApiInterceptor() {
		return new DriverApiInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getDriverApiInterceptor()).addPathPatterns("/api/driver/update");

		registry.addInterceptor(getDriverApiInterceptor()).addPathPatterns("/api/driver/get-detail-driver");

		registry.addInterceptor(getDriverApiInterceptor()).addPathPatterns("/api/driver/upload-avatar");
		
		registry.addInterceptor(getDriverApiInterceptor()).addPathPatterns("/api/driver/vehicle");
		
		registry.addInterceptor(getDriverApiInterceptor()).addPathPatterns("/api/driver/location/*");


	}

	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
			 "classpath:/static/",
			// "classpath:/upload/**",
			"file:uploads" };

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	}
}
