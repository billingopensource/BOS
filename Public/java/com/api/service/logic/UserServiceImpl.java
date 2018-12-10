package com.api.service.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.billing.login.model.User;
import com.api.repository.LoginRepository;
import com.api.service.UserService;



@Service
public class UserServiceImpl implements UserService {
    
     @Autowired 
     LoginRepository loginrepository;
     
     private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          User user = loginrepository.readUser(username);
          user.setAuthorities(getAuthorities(username));
         
          return user;
     }
     
     @Override
     public Collection<GrantedAuthority> getAuthorities(String username) {
          List<String> string_authorities = loginrepository.readAuthority(username);
          List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
          for (String authority : string_authorities) {
               authorities.add(new SimpleGrantedAuthority(authority));
          }
          return authorities;
     }
     
     @Override
     public User readUser(String username) {
          User user = loginrepository.readUser(username);
          //user.setAuthorities(user);
          return user;
     }

	@Override
	public PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return this.passwordEncoder;
	}


     
}
