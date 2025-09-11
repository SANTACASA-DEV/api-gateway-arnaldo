package br.com.santacasa.api_gateway.infra.security;

import br.com.santacasa.api_gateway.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

//        String path = request.getRequestURI();
//        if (path.equals("/auth/login") || path.equals("/auth/register") || path.equals("/")) {
//            System.out.println("✅ Rota pública permitida: " + path);
//            filterChain.doFilter(request, response);
//            return;
//        }

        var token = this.recoverToken(request);
        System.out.println("🔑 Token recebido: " + (token != null ? "Sim" : "Não"));

        if(token != null){
            try {

                var matricula = tokenService.validateToken(token);
                System.out.println("👤 Matricula do token: " + matricula);

                UserDetails user = userRepository.findByMatricula(matricula);

                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);

                System.out.println("✅ Autenticação bem-sucedida para: " + user.getUsername());
            }catch (Exception e){
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.getWriter().write("Token inválido: " + e.getMessage());

            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null){
            return  null;
        }
        return authHeader.replace("Bearer ", "");
    }
}