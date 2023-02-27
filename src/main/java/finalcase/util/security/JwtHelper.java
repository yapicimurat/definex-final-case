package finalcase.util.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import finalcase.constant.Security;

import java.util.Date;

public final class JwtHelper {

    public static String generateJWT(final String username){
        final Algorithm algorithm = Algorithm.HMAC256(Security.SECRET_KEY);

        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() +
                        Security.CURRENT_EXPIRED_DAY * 24 * 60 * 60 * 1000))
                .sign(algorithm);
    }

    public static DecodedJWT decodeJwtToken(final String jwtToken) throws JWTVerificationException {
        final Algorithm algorithm = Algorithm.HMAC256(Security.SECRET_KEY);
        final JWTVerifier verifier = JWT.require(algorithm).build();

        return verifier.verify(jwtToken);
    }
}
