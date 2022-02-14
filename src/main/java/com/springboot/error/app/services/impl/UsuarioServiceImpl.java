package com.springboot.error.app.services.impl;

import com.springboot.error.app.models.Usuario;
import com.springboot.error.app.services.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  private List<Usuario> lista;

  public UsuarioServiceImpl() {
    this.lista = new ArrayList<>();
    this.lista.add(new Usuario(1, "Abel", "Antúnez"));
    this.lista.add(new Usuario(2, "Pepe", "García"));
    this.lista.add(new Usuario(3, "Manolo", "Pérez"));
    this.lista.add(new Usuario(4, "Fernando", "Castillo"));
    this.lista.add(new Usuario(5, "Laura", "Gómez"));
    this.lista.add(new Usuario(6, "Juan", "Puertas"));
    this.lista.add(new Usuario(7, "María", "Martínez"));
  }

  @Override
  public List<Usuario> listar() {
    return this.lista;
  }

  @Override
  public Optional<Usuario> obtenerPorId(Integer id) {

    return this.lista.stream().filter(u -> u.getId().equals(id)).findAny();
  }
}
