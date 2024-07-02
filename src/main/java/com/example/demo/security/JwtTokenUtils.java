package com.example.demo.security;

import com.example.demo.entity.AppUser;
import com.example.demo.exception_handler.NotFoundException;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.DirectEncrypter;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.BadJOSEException;
import com.nimbusds.jose.proc.JWEDecryptionKeySelector;
import com.nimbusds.jose.proc.JWEKeySelector;
import com.nimbusds.jose.proc.SimpleSecurityContext;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class JwtTokenUtils {

    public static String secretKey = "841D8A6C80CBA4FCAD32D5367C18C53B";
    private static final long serialVersionUID = -1029281748694725202L;

    @Value("${login.expiration.time.in.minutes}")
    private Integer expirationTime;
    @Value("${appUser.login.type}")
    private String loginTypeValue;

    public String getToken(AppUser user) throws JOSEException {
        JWTClaimsSet.Builder claims = new JWTClaimsSet.Builder();
        claims.expirationTime(new Date(new Date().getTime() + (expirationTime - 1L) * 60 * 1000));//long format  add expire time
        String errorMessage = "requested credentials not found as per application properties";
        switch (loginTypeValue) {
            case "EMAIL" -> {
                if (user.getEmail()!=null) {
                    claims.claim("email", user.getEmail()).build();
                } else throw new NotFoundException(errorMessage);
            }
            case "USERNAME" -> {
                if (user.getFirstName()!=null) {
                    claims.claim("firstName", user.getFirstName()).build();
                } else throw new NotFoundException(errorMessage);
            }
            case "CONTACTNUMBER" -> {
                if (user.getMobileNo()!=null) {
                    claims.claim("mobileNo", user.getMobileNo()).build();
                } else throw new NotFoundException(errorMessage);
            }
        }
        Payload payload = new Payload(claims.build().toJSONObject());
        JWEHeader header = new JWEHeader(JWEAlgorithm.DIR, EncryptionMethod.A128CBC_HS256);
        DirectEncrypter encrypter = new DirectEncrypter(secretKey.getBytes(StandardCharsets.UTF_8));
        JWEObject jweObject = new JWEObject(header, payload);
        jweObject.encrypt(encrypter);
        String token = jweObject.serialize();
        DynamicTokenStore.tokenCreationTime = LocalDateTime.now();
        return token;
    }

    public String parseToken(String token) throws BadJOSEException, ParseException, JOSEException {
        ConfigurableJWTProcessor<SimpleSecurityContext> jwtProcessor = new DefaultJWTProcessor<SimpleSecurityContext>();
        JWKSource<SimpleSecurityContext> jweKeySource = new ImmutableSecret<SimpleSecurityContext>(secretKey.getBytes());
        JWEKeySelector<SimpleSecurityContext> jweKeySelector =
                new JWEDecryptionKeySelector<SimpleSecurityContext>(JWEAlgorithm.DIR, EncryptionMethod.A128CBC_HS256, jweKeySource);
        jwtProcessor.setJWEKeySelector(jweKeySelector);

        JWTClaimsSet claims = jwtProcessor.process(token, null);
        String userName = null;
        switch (loginTypeValue) {
            case "EMAIL" -> userName = (String) claims.getClaim("email");
            case "USERNAME" -> userName = (String) claims.getClaim("firstName");
            case "CONTACTNUMBER" -> userName = (String) claims.getClaim("mobileNo");
        }
        System.out.printf(userName + "******************************");
        return userName;
    }



}
