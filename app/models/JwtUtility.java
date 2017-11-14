package models;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import io.jsonwebtoken.*;
import java.util.Date;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;
import io.jsonwebtoken.Jwts;
import javax.persistence.GeneratedValue;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtility{
        @GeneratedValue
        private  UUID id;

        public JwtUtility(){

        }
public String  makeToken(){

       SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[60];
        random.nextBytes(bytes);
        String token = bytes.toString();
        System.out.println(token);
        return token;
     //  return id.toString();
}


        }