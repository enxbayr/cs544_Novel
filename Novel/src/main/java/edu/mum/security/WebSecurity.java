package edu.mum.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import edu.mum.service.impl.UserCredentialsServiceImpl;

public class WebSecurity extends WebSecurityConfiguration {
	
	@Autowired
    private UserCredentialsServiceImpl credentialService;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
     BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(credentialService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

                http.cors()
                        .and()
                        .csrf().disable()
                        .authorizeRequests()
                        .anyRequest().authenticated()
                        .and()
                        .addFilter(new JWTAuthenticationFilter(authenticationManager(),applicationProperties))
                        .addFilter(new JWTAuthorizationFilter(authenticationManager(),applicationProperties))
                // this disables session creation on spring security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


}
