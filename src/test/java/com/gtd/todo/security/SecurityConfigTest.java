package com.gtd.todo.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({HttpSecurity.class, CsrfConfigurer.class, HeadersConfigurer.FrameOptionsConfig.class})
public class SecurityConfigTest  {

    private SecurityConfig securityConfig;

    private HttpSecurity httpSecurity;
    private ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry;
    private ExpressionUrlAuthorizationConfigurer.AuthorizedUrl authorizedUrl;
    private CsrfConfigurer<HttpSecurity> csrfConfigurer;
    private HeadersConfigurer<HttpSecurity> headersConfigurer;
    private HeadersConfigurer.FrameOptionsConfig frameOptionsConfig;

    @Before
    public void setup() throws Exception {
        securityConfig = new SecurityConfig();

        httpSecurity = mock(HttpSecurity.class);
        expressionInterceptUrlRegistry = mock(ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry.class);
        authorizedUrl = mock(ExpressionUrlAuthorizationConfigurer.AuthorizedUrl.class);
        csrfConfigurer = mock(CsrfConfigurer.class);
        headersConfigurer = mock(HeadersConfigurer.class);
        frameOptionsConfig = mock(HeadersConfigurer.FrameOptionsConfig.class);

        when(httpSecurity.authorizeRequests()).thenReturn(expressionInterceptUrlRegistry);
        when(expressionInterceptUrlRegistry.antMatchers(anyString())).thenReturn(authorizedUrl);
        when(authorizedUrl.permitAll()).thenReturn(expressionInterceptUrlRegistry);
        when(httpSecurity.csrf()).thenReturn(csrfConfigurer);
        when(csrfConfigurer.disable()).thenReturn(httpSecurity);
        when(httpSecurity.headers()).thenReturn(headersConfigurer);
        when(headersConfigurer.frameOptions()).thenReturn(frameOptionsConfig);
        when(frameOptionsConfig.disable()).thenReturn(headersConfigurer);
        securityConfig.configure(httpSecurity);

    }

    @Test
    public void testSecurityConfig() throws Exception {
        securityConfig.configure(httpSecurity);
        assertEquals(httpSecurity.csrf().disable(), httpSecurity);
        verify(httpSecurity, atLeastOnce()).csrf();
        verify(httpSecurity, atLeastOnce()).authorizeRequests();
        verify(expressionInterceptUrlRegistry, atLeast(2)).antMatchers(anyString());
    }

}
