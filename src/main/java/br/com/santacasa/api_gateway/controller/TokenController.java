package br.com.santacasa.api_gateway.controller;

import br.com.santacasa.api_gateway.dtos.LoginRequest;
import br.com.santacasa.api_gateway.dtos.LoginResponse;
import br.com.santacasa.api_gateway.entities.Usuario;
import br.com.santacasa.api_gateway.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Optional;

@RestController
public class TokenController {
    private final JwtEncoder jwtEnconder;

    private UsuarioService service;

    public TokenController(JwtEncoder jwtEncoder, UsuarioService service, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.jwtEnconder = jwtEncoder;
        this.service = service;
        }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        Optional<Usuario> user = service.findByEmail(loginRequest);

        var agora = Instant.now();
        var tempoExpiracao = 300L;
        var claims = JwtClaimsSet.builder()
                .issuer("mybackend")
                .subject(user.get().getUsuarioId().toString())
                .expiresAt(agora.plusSeconds(tempoExpiracao))
                .build();
        var jwtValue = jwtEnconder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(jwtValue, tempoExpiracao));
    }
}