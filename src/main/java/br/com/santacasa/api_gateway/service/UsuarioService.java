package br.com.santacasa.api_gateway.service;

import br.com.santacasa.api_gateway.dtos.LoginRequest;
import br.com.santacasa.api_gateway.dtos.LoginResponse;
import br.com.santacasa.api_gateway.entities.Usuario;
import br.com.santacasa.api_gateway.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public Optional<Usuario> findByEmail(LoginRequest loginRequest){
        Optional<Usuario> user = usuarioRepository.findByEmail(loginRequest.email());
        if(user.isEmpty() || user.get().isLoginCorrect(loginRequest, passwordEncoder)){
            throw new BadCredentialsException("User or password is invalid!");
        }

        return user;
    }
}
