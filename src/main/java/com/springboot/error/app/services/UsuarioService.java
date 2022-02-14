package com.springboot.error.app.services;

import com.springboot.error.app.models.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

  List<Usuario> listar();
  Optional<Usuario> obtenerPorId(Integer id);

}
