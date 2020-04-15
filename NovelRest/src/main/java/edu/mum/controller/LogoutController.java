package edu.mum.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
@FrameworkEndpoint
public class LogoutController {

	@Autowired
	AuthorizationServerTokenServices authorizationServerTokenServices;

	@Autowired
	ConsumerTokenServices consumerTokenServices;

//	DefaultTokenServices  DefaultTokenServices ;

	@RequestMapping("/doLogout")
	public String exit(@RequestParam("token") String tokenId, HttpServletRequest request,
			@RequestHeader("referer") String referer) {
		// token can be revoked here
		System.out.println("Server LOGOUT");
		System.out.println("tokenId : " + tokenId);
		System.out.println("Referer : " + referer);
		consumerTokenServices.revokeToken(tokenId);

		new SecurityContextLogoutHandler().logout(request, null, null);
		return "redirect:" + referer;

	}
}

/*
 * String authorization = request.getHeader("AccessToken"); if (authorization !=
 * null && authorization.contains("Bearer")) { String tokenId =
 * authorization.substring("Bearer".length() + 1);
 * System.out.println("tokenId : " + tokenId); //
 * consumerTokenServices.revokeToken(tokenId); //
 * tokenStore.removeRefreshToken(token); }
 */
//	    	OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
//OAuth2AccessToken accessToken = authorizationServerTokenServices.getAccessToken(oAuth2Authentication);
//consumerTokenServices.revokeToken(accessToken.getValue());
