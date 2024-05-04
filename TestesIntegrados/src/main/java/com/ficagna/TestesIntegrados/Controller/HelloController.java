package com.ficagna.TestesIntegrados.Controller;

import com.ficagna.TestesIntegrados.Dominio.Hello;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public ResponseEntity<String> saudacao() {
        Hello hello = new Hello();

        return new ResponseEntity(hello.saudacao(), HttpStatus.OK);
    }

    @PostMapping("bye")
    public ResponseEntity<String> bye() {
        Hello hello = new Hello();

        return new ResponseEntity(hello.bye(), HttpStatus.OK);
    }

    @PostMapping("saudacao")
    public ResponseEntity<String> saudar(@RequestBody Usuario usuario) {
        Hello hello = new Hello();

        return new ResponseEntity(hello.saudacao(usuario.getNome()), HttpStatus.OK);
    }
}
