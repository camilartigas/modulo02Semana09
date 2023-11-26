package com.example.veiculosEMultas.service;

import com.example.veiculosEMultas.dto.UsuarioRequest;
import com.example.veiculosEMultas.model.Role;
import com.example.veiculosEMultas.model.Usuario;
import com.example.veiculosEMultas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario criarNovoUsuario(UsuarioRequest usuarioRequest) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(usuarioRequest.getNome());
        novoUsuario.setEmail(usuarioRequest.getEmail());
        novoUsuario.setSenha(usuarioRequest.getSenha());

        Role role = Role.valueOf(usuarioRequest.getRole().toUpperCase());
        novoUsuario.setRole(role);

        return usuarioRepository.save(novoUsuario);
    }
}
