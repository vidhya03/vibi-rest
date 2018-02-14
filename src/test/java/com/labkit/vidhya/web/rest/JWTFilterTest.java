package com.labkit.vidhya.web.rest;

import com.labkit.vidhya.security.AuthoritiesConstants;
import com.labkit.vidhya.security.jwt.JWTFilter;
import com.labkit.vidhya.security.jwt.TokenProvider;
import io.github.jhipster.config.JHipsterProperties;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;

public class JWTFilterTest {

    private TokenProvider tokenProvider;

    private JWTFilter jwtFilter;

    @Before
    public void setup() {
        JHipsterProperties jHipsterProperties = new JHipsterProperties();
        tokenProvider = new TokenProvider(jHipsterProperties);
        ReflectionTestUtils.setField(tokenProvider, "secretKey", "my-secret-token-to-change-in-production");
        ReflectionTestUtils.setField(tokenProvider, "tokenValidityInMilliseconds", 86400);// # Token is valid 24 hours
        ReflectionTestUtils.setField(tokenProvider, "tokenValidityInMillisecondsForRememberMe", 2592000);
        jwtFilter = new JWTFilter(tokenProvider);
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    @Test
    public void testJWTFilter() throws Exception {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
            "user",
            "user",
            Collections.singletonList(new SimpleGrantedAuthority(AuthoritiesConstants.USER))
        );
        String jwt = tokenProvider.createToken(authentication, true);
        System.out.println("jwt = " + jwt);
//        verifying the jwt with secret keys
    }
}
