package br.com.cjr.apirest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cjr.apirest.config.security.TokenService;
import br.com.cjr.apirest.model.dto.TokenDto;
import br.com.cjr.apirest.model.form.LoginRequest;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@Autowired
	private TokenService tokenService; 
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginRequest request){
		UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha());
		
		try {
			Authentication authentication =  authenticationManager.authenticate(login);
			String token = tokenService.gerarToken(authentication);
			System.out.println(token);
			
			TokenDto tokenDto = new TokenDto(token, "Bearer");
			
			return ResponseEntity.ok(tokenDto);
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
}
