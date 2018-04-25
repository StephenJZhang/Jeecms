package com.jeecms.common;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.filters.RemoteIpFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
        
	    private static Logger log = LoggerFactory.getLogger(WebConfiguration.class);    
	
	    @Bean
	    public RemoteIpFilter remoteIpFilter() {
	    	log.info("创建RemoteIpFilter bean：{}",new Date(System.currentTimeMillis()));
	        return new RemoteIpFilter();
	    }
	    
	    @Bean
	    public FilterRegistrationBean testFilterRegistration() {
	    	log.info("创建FilterRegistrationBean：{}",new Date(System.currentTimeMillis()));
	        FilterRegistrationBean registration = new FilterRegistrationBean();
	        registration.setFilter(new MyFilter());
	        registration.addUrlPatterns("/*");
	        registration.addInitParameter("paramName", "paramValue");
	        registration.setName("MyFilter");
	        registration.setOrder(1);
	        return registration;
	    }
	    
	    public class MyFilter implements Filter {
	        @Override
	        public void destroy() {
	            // TODO Auto-generated method stub
	        }

	        @Override
	        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
	                throws IOException, ServletException {
	            // TODO Auto-generated method stub
	        	log.info("doFilter:{}",new Date(System.currentTimeMillis()));
	            HttpServletRequest request = (HttpServletRequest) srequest;
	            log.info("this is MyFilter,url :{}",request.getRequestURI());
	            filterChain.doFilter(srequest, sresponse);
	        }

	        @Override
	        public void init(FilterConfig arg0) throws ServletException {
	        	log.info("init myFilterL:{}",new Date(System.currentTimeMillis()));
	            // TODO Auto-generated method stub
	        }
	        
	    }
	    
	    
	    
}
