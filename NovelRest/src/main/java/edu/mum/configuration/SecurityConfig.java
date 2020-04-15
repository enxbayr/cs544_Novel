package edu.mum.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
   private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception { // @formatter:off
        http.cors()
        .and()
        .requestMatchers()
            .antMatchers("/login**", "/oauth/authorize", "/doLogout")
            .antMatchers(HttpMethod.OPTIONS)
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage( "/login" )
            .failureUrl("/loginfailed")
            .permitAll();
    } // @formatter:on

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // @formatter:off
        auth.jdbcAuthentication()
        .dataSource( dataSource )
        .passwordEncoder( passwordEncoder() )
        .usersByUsernameQuery("select username,password,enabled from credentials where username=?")
        .authoritiesByUsernameQuery( "select u1.username, u2.authority from credentials u1, authority u2 where u1.username = u2.username and u1.username =?" );
   }  
    
    // Need for password grant type
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

}
