package manager.core.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
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
  

    public String getLoginToken(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return body.get("login").toString();

    }

    public String generateToken(UserDetails userDetails) {
    	Date hj = new Date();
    	Date dtExpiration = new Date(hj.getTime() + 60);
    	
    	Claims claims = Jwts.claims().setSubject("TokenSubject")
    			.setIssuer("TokenIssuer")
    			.setIssuedAt(hj)
    			.setExpiration(dtExpiration);

        return Jwts.builder()
                .setClaims(claims)
                .claim("username", userDetails.getUsername())
                .claim("password", userDetails.getPassword())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
	
