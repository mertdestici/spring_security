package com.spring.spring_security.config;

import com.spring.spring_security.service.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

@ComponentScan
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
        WebAuthenticationDetails auth = (WebAuthenticationDetails) authenticationSuccessEvent.getAuthentication().getDetails();
        loginAttemptService.loginSucceeded(auth.getRemoteAddress());
    }
}
