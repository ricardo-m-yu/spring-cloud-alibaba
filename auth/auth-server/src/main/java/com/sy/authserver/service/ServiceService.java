package com.sy.authserver.service;

import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;

@Service
public class ServiceService {

    @Resource
    private JdbcRegisteredClientRepository registeredClientRepository;

    public void initClient() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("oidc-client")
                .clientSecret(encoder.encode("secret"))
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .redirectUri("http://www.baidu.com")
                .redirectUri("http://localhost:9001/login/oauth2/code/oidc-client")
                .redirectUri("http://localhost:9001/api/login/welcome")
                .postLogoutRedirectUri("http://127.0.0.1:8080/")
                .scope(OidcScopes.OPENID)
                .scope(OidcScopes.PROFILE)
                .scope("message.read")
                .scope("message.write")
                .scope("all")
                //设置token配置
                .tokenSettings(
                        TokenSettings.builder().
                                accessTokenTimeToLive(Duration.ofMinutes(60)).
                                reuseRefreshTokens(true).
                                refreshTokenTimeToLive(Duration.ofMinutes(720)).
                                build()
                )
                // 设置 Client 需要页面审核授权
//                .clientSettings(ClientSettings.builder()
//                        .requireAuthorizationConsent(true)
//                                .build())
                .build();
        RegisteredClient userClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("user-client")
                .clientSecret(encoder.encode("secret2"))
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_POST)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .redirectUri("http://www.baidu.com")
                .redirectUri("http://localhost:9001/login/oauth2/code/oidc-client")
                .redirectUri("http://localhost:9001/api/login/welcome")
                .postLogoutRedirectUri("http://127.0.0.1:8080/")
                .scope(OidcScopes.OPENID)
                .scope(OidcScopes.PROFILE)
                .scope("message.read")
                .scope("message.write")
                .scope("all")
                //设置token配置
                .tokenSettings(
                        TokenSettings.builder().
                                accessTokenTimeToLive(Duration.ofMinutes(60)).
                                reuseRefreshTokens(true).
                                refreshTokenTimeToLive(Duration.ofMinutes(720)).
                                build()
                )
                // 设置 Client 需要页面审核授权
//                .clientSettings(ClientSettings.builder()
//                        .requireAuthorizationConsent(true)
//                                .build())
                .build();
        registeredClientRepository.save(userClient);
        registeredClientRepository.save(oidcClient);
    }
}
