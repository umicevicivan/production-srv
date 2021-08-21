package com.fpis.productionsrv.controller;

import com.fpis.productionsrv.entity.AuthRequest;
import com.fpis.productionsrv.entity.TokenDto;
import com.fpis.productionsrv.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Radim";
    }

    @PostMapping()
    public ResponseEntity generateToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        TokenDto token = new TokenDto();
        token.setBearer(jwtUtil.generateToken(authRequest.getUserName()));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(token);
    }
}
