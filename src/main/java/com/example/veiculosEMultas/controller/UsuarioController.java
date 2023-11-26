package com.example.veiculosEMultas.controller;

import com.example.veiculosEMultas.dto.AutenticacaoRequest;
import com.example.veiculosEMultas.dto.AutenticacaoResponse;
import com.example.veiculosEMultas.dto.UsuarioRequest;
import com.example.veiculosEMultas.dto.UsuarioResponse;
import com.example.veiculosEMultas.model.Usuario;
import com.example.veiculosEMultas.service.AutenticacaoService;
import com.example.veiculosEMultas.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private ModelMapper mapper;


    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> consultar() {
        var usuarios = usuarioService.consultar();
        var resp = usuarios.stream().map(u -> mapper.map(u, UsuarioResponse.class)).toList();
        return ResponseEntity.ok(resp);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> inserir(@RequestBody @Valid UsuarioRequest request) {
        var usuario = mapper.map(request, Usuario.class);
        usuario = usuarioService.inserir(usuario);
        var resp = mapper.map(usuario, UsuarioResponse.class);
        return ResponseEntity.created(URI.create(usuario.getId().toString())).body(resp);
    }

    @PostMapping("/autenticar")
    public ResponseEntity<AutenticacaoResponse> login(@RequestBody @Valid AutenticacaoRequest request) {
        var token = autenticacaoService.autenticar(request.getEmail(), request.getSenha());
        return ResponseEntity.ok(new AutenticacaoResponse(token));
    }

}