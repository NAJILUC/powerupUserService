package com.pragma.usuario.infrastructure.out.jpa.token;

import com.pragma.usuario.domain.spi.token.IToken;
import com.pragma.usuario.infrastructure.security.TokenUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class TokenAdapter implements IToken {
    @Override
    public String getBearerToken() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
    }

    @Override
    public String getUserAuthenticatedEmail(String token) {
        return TokenUtils.getUserAuthenticatedEmail(token.replace("Bearer ",""));
    }

    @Override
    public Long getUserAuthenticatedId(String token) {
        return TokenUtils.getUserAuthenticatedId(token.replace("Bearer ",""));
    }
}
