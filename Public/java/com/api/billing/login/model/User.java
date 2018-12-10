package com.api.billing.login.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {
     private String username;
     private String password;
     private String name;
     private boolean isAccountNonExpired;
     private boolean isAccountNonLocked;
     private boolean isCredentialsNonExpired;
     private boolean isEnabled;
     private int customerNumber;
     private Collection<? extends GrantedAuthority> authorities;
     private String businessname;
     
     private int providernumber;
     
    
     public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	@Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
          return authorities;
     }

     @Override
     public String getPassword() {
          return password;
     }

     @Override
     public String getUsername() {
          return username;
     }

     @Override
     public boolean isAccountNonExpired() {
          return isAccountNonExpired;
     }

     @Override
     public boolean isAccountNonLocked() {
          return isAccountNonLocked;
     }

     @Override
     public boolean isCredentialsNonExpired() {
          return isCredentialsNonExpired;
     }

     @Override
     public boolean isEnabled() {
          return isEnabled;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public void setAccountNonExpired(boolean isAccountNonExpired) {
          this.isAccountNonExpired = isAccountNonExpired;
     }

     public void setAccountNonLocked(boolean isAccountNonLocked) {
          this.isAccountNonLocked = isAccountNonLocked;
     }

     public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
          this.isCredentialsNonExpired = isCredentialsNonExpired;
     }

     public void setEnabled(boolean isEnabled) {
          this.isEnabled = isEnabled;
     }

     public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
          this.authorities = authorities;
     }

	public int getProvidernumber() {
		return providernumber;
	}

	public void setProvidernumber(int providernumber) {
		this.providernumber = providernumber;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

     
     
     
     
}