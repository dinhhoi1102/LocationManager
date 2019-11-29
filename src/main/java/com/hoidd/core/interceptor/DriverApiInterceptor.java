package com.hoidd.core.interceptor;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoidd.core.payload.ApiResponse;
import com.hoidd.entity.Technician;
//import com.hoidd.service.driver.account.repository.AccountRepo;

@Component
public class DriverApiInterceptor extends HandlerInterceptorAdapter {
//	
//	@Autowired
//	AccountRepo accountRepo;

//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//
//		String token = request.getHeader("token");
//		Optional<Driver> driverOpt  = accountRepo.findByToken(token);
//		Driver driver;
//		if(!driverOpt.isPresent()) {
//			ObjectMapper mapper = new ObjectMapper();
//			ApiResponse<Object> myResponse = new ApiResponse<>().getErrorResponse("Token invalid");
//			response.setContentType("application/json");
//			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//			response.getWriter().write(mapper.writeValueAsString(myResponse));
//			return false;
//		}
//		driver = driverOpt.get();
//		request.setAttribute("driver", driver);
//
//		return super.preHandle(request, response, handler);
//	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

}
