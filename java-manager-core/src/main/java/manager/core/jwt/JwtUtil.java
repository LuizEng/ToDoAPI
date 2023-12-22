package manager.core.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            return true;

        } catch (Exception e) {
            return false;
        }
    }
    
    public Long getIdUsuarioToken(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return Long.valueOf(body.get("idUsuario").toString());

    }

    
    public Long getidTenantToken(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return Long.valueOf(body.get("idTenant").toString());

    }    

    public String getLoginToken(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return body.get("login").toString();

    }

    public String generateToken(String issuer, String subject, Long expiration, Long idUsuario, String login) {
    	Date hj = new Date();
    	Date dtExpiration = new Date(hj.getTime() + expiration);
    	
    	Claims claims = Jwts.claims().setSubject(subject)
    			.setIssuer(issuer)
    			.setIssuedAt(hj)
    			.setExpiration(dtExpiration);

        return Jwts.builder()
                .setClaims(claims)
                .claim("idUsuario", idUsuario)
                .claim("login", login)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
	
