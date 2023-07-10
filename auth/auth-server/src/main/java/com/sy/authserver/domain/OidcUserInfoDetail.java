package com.sy.authserver.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Data
public class OidcUserInfoDetail extends OidcUserInfo {

    @Serial
    private static final long serialVersionUID = 7755162995496909499L;

    private Long id;

    private String username;

    private String password;

    private String name;

    private Boolean enabled;
    private Boolean accountNonExpired;
    private Boolean credentialsNonExpired;
    private Boolean accountNonLocked;
    private List<?> authorities;

    /**
     * Constructs a {@code OidcUserInfo} using the provided parameters.
     *
     * @param claims the claims about the authentication of the End-User
     */
    public OidcUserInfoDetail(Map<String, Object> claims) {
        super(claims);
    }
}
