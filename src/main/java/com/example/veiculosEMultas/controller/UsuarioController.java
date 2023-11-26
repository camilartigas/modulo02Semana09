package com.example.veiculosEMultas.controller;

import com.example.veiculosEMultas.dto.UsuarioRequest;
import com.example.veiculosEMultas.model.Usuario;
import com.example.veiculosEMultas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarNovoUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        Usuario novoUsuario = usuarioService.criarNovoUsuario(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }
}
