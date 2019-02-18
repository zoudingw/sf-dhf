package com.infinova.sfdhf.authConfig;

import com.infinova.sfdhf.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("myAuthenticationProvider")
public class MyAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    EncodePassword encodePassword;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if ( authentication.getCredentials() == null ) {
            this.logger.debug("Authentication failed: no credentials provided");
            throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials" , "Bad credentials"));
        } else {
            String presentedPassword = authentication.getCredentials().toString();
            if ( !this.encodePassword.matches(presentedPassword , userDetails.getPassword()) ) {
                this.logger.debug("Authentication failed: password does not match stored value");
                throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials" , "Bad credentials"));
            }
        }
    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        return myUserDetailService.loadUserByUsername(s);
    }
}
