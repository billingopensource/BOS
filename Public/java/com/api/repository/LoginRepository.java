package com.api.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.api.billing.login.model.User;



@Mapper
@Repository
public interface LoginRepository  {
    public User readUser(String username);
    public List<String> readAuthority(String username);
    
}
