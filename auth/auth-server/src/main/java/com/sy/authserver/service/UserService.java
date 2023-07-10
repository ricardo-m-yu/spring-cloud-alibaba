package com.sy.authserver.service;

import com.sy.authserver.domain.OidcUserInfoDetail;
import com.sy.authserver.domain.UserInfo;
import com.sy.authserver.mapper.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.getByUsername(username);
    }

    public Map<String, Object> getUserInfoMap(String username) throws UsernameNotFoundException {
        return userMapper.getUserInfoMap(username);
    }
}
