package com.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.api.billing.login.model.User;
import com.api.service.UserService;




@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
     @Autowired UserService userService;
     
     
     
     
     
     @Override
     protected void configure(HttpSecurity http) throws Exception {
         /* http
               .csrf().disable()
               .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
               .formLogin().loginPage("/login");
        */
    	/* http
 		.csrf().disable()
         .authorizeRequests()
             .antMatchers(
                     "/**",
                     "/js/**",
                     "/css/**",
                     "/img/**",
                     "/webjars/**").permitAll()
             .antMatchers("/user/**").hasRole("USER")
             .anyRequest().authenticated()
         .and()
         .authorizeRequests()
             .antMatchers(
                     "/**",
                     "/js/**",
                     "/css/**",
                     "/img/**",
                     "/webjars/**").permitAll()
             .antMatchers("/admin/**").hasRole("ADMIN")
             .anyRequest().authenticated()
         .and()
         .formLogin()
             .loginPage("/login")
             .permitAll()
             .usernameParameter("username")
             .passwordParameter("password")
             .successHandler(new CustomAuthenticationSuccess())
         .and()
         .logout()
             .invalidateHttpSession(true)
             .clearAuthentication(true)
             .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
             .logoutSuccessUrl("/login?logout")
             .permitAll(); */
    	 /*http .csrf().disable() 
    	 .authorizeRequests() 
    	 .anyRequest().authenticated() 
    	 .and() 
    	 .formLogin();
*/
    	 http
  		.csrf().disable().anonymous()
  		.and()
          .authorizeRequests()
              .antMatchers(
                      "/**",
                      "/js/**",
                      "/css/**",
                      "/img/**",
                      "/webjars/**").permitAll()
              .antMatchers("/login").permitAll()
              .antMatchers("/**").authenticated()
              .antMatchers("/admin/**").hasRole("ADMIN")
              .anyRequest().authenticated()
          .and()
          .formLogin()
              .loginPage("/login")
              .permitAll()
              .usernameParameter("username")
              .passwordParameter("password")
              .successHandler(new CustomAuthenticationSuccess())
          .and()
          .logout()
              .invalidateHttpSession(true)
              .clearAuthentication(true)
              .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
              .logoutSuccessUrl("/login?logout")
              .permitAll();
    	 
    	 http.sessionManagement().invalidSessionUrl("/login");
     }


     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	 
    	 auth.userDetailsService(userService).passwordEncoder(userService.passwordEncoder()) ; 

     }
        
     
     @Bean
     @Override
     public AuthenticationManager authenticationManagerBean() throws Exception {
          return super.authenticationManagerBean();
     }
}