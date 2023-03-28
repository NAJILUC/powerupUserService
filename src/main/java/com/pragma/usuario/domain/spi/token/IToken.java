package com.pragma.usuario.domain.spi.token;

public interface IToken {

    String getBearerToken();

    String getUserAuthenticatedEmail(String token);

    Long getUserAuthenticatedId(String token);
}
