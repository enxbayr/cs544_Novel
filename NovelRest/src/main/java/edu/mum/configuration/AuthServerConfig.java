package edu.mum.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;


@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    
    @Autowired    
    private BCryptPasswordEncoder passwordEncoder;
 
  	@Autowired
	private TokenStore tokenStore;

    // Need for password grant type
	@Autowired
	private AuthenticationManager authenticationManager;

    @Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
            .checkTokenAccess("isAuthenticated()");
    }

    // Need for password grant type
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore)
				.authenticationManager(authenticationManager);
	}

    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
        .withClient("SampleClientId")
        .secret(passwordEncoder.encode("secret"))
        .authorizedGrantTypes("authorization_code","refresh_token")
        .scopes("user_info")
        .autoApprove(true)
        .redirectUris("http://localhost:8083/MemberMVCOauthCode/login")
        .accessTokenValiditySeconds(30)   
        .and()
            .withClient("MemberMVCOauthPwd")
            .secret(passwordEncoder.encode("FooBar"))
            .authorizedGrantTypes("password", "refresh_token")
            .scopes("read")
            .accessTokenValiditySeconds(600)
            .and()           
            .withClient("ImplicitClientId")
			.secret(passwordEncoder.encode("FooBar"))
            .authorizedGrantTypes("implicit")
            .redirectUris("http://localhost:8181/MemberOauthImplicit/index.html")
           .scopes("read")
            .autoApprove(true);
/*
 accessTokenValiditySeconds = 60 * 60 * 12; // default 12 hours
 refreshTokenValiditySeconds = 60 * 60 * 24 * 30; // default 30 days
 */
    }

 
		
}
