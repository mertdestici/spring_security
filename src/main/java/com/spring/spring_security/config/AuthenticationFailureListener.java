package com.spring.spring_security.config;

import com.spring.spring_security.service.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent authenticationFailureBadCredentialsEvent) {
        WebAuthenticationDetails auth = (WebAuthenticationDetails) authenticationFailureBadCredentialsEvent.getAuthentication().getDetails();
        loginAttemptService.loginFailed(auth.getRemoteAddress());
    }
}
