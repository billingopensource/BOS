package com.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccess implements AuthenticationSuccessHandler{
  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();;


  
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
	//set our response to OK status
      System.out.println("----------------------------" + request.getParameter("username"));
      boolean admin = false;
      //String userid = request.getParameter("username");
      //Session session =  request.getSession();
      //HttpSession session = httpSessionFactory.getObject();

      
      for (GrantedAuthority auth : authentication.getAuthorities()) {
          if ("ADMIN".equals(auth.getAuthority())){
          	admin = true;
          }
      }

      
      if(admin){
    	  redirectStrategy.sendRedirect(request, response, "/report/main");
      }else{
    	  //request.getRequestDispatcher("/report/main").forward(request, response);
    	  redirectStrategy.sendRedirect(request, response, "/report/main");
      }
	}
  

 }