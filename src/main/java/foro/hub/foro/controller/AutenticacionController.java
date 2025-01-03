package foro.hub.foro.controller;

import foro.hub.foro.domain.usuarios.Usuario;
import foro.hub.foro.domain.usuarios.UsuarioDto;
import foro.hub.foro.infra.security.JWTokenDto;
import foro.hub.foro.infra.security.TokenService;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioDto usuarioDto){
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(usuarioDto.login(),
                usuarioDto.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return (ResponseEntity) ResponseEntity.ok(new JWTokenDto(JWTtoken));
    }
}
