package org.sxyxhj.springcloudsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @program: spring-boot-demo
 * @description: OAuth2 配置类
 * @author: @sxyxhj
 * @create: 2020-12-01 22:12
 **/
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(){
// 配置授权码服务
        return new InMemoryAuthorizationCodeServices();
    }

    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory().withClient("client")
                .secret(getPasswordEncoder().encode("secret"))
                .authorizedGrantTypes("refresh_token","password","client_credentials","authorization_code")
                .scopes("app")
                .redirectUris("http://www.baidu.com")
                .accessTokenValiditySeconds(1200)
                .refreshTokenValiditySeconds(500000);

    }
    @Autowired
    private ClientDetailsService clientDetailsService;

    @Bean
    public AuthorizationServerTokenServices tokenServices(){
        DefaultTokenServices services = new DefaultTokenServices();
        services.setClientDetailsService(clientDetailsService);
        services.setSupportRefreshToken(true);
        services.setTokenStore(tokenStore);
        services.setAccessTokenValiditySeconds(7200);
        services.setRefreshTokenValiditySeconds(36000);
        return services;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()")
//allow check token
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .authorizationCodeServices(authorizationCodeServices)
                .tokenServices(tokenServices())
                .allowedTokenEndpointRequestMethods(HttpMethod.POST,HttpMethod.GET);
    }



}

    
