package com.springboot.error.app.controllers;

import com.springboot.error.app.errors.UserNotFoundException;
import com.springboot.error.app.models.Usuario;
import com.springboot.error.app.services.UsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping({"", "/", "/index"})
  public String index(Model model) {

    // Probar ArithmeticException en ErrorHandlerController
    // Integer num = 100/0;

    // Probar NumberFormatException en ErrorHandlerController
    Integer num = Integer.parseInt("test");
    return "index";
  }

  @GetMapping("/ver/{id}")
  public String ver(@PathVariable Integer id, Model model) {
    /*
    Optional<Usuario> usuario = usuarioService.obtenerPorId(id);

    if (usuario.isEmpty()) {
      throw new UserNotFoundException(id.toString());
    }
     */

    Usuario usuario = usuarioService.obtenerPorId(id).orElseThrow(() -> new UserNotFoundException(id.toString()));

    model.addAttribute("usuario", usuario);
    model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));

    return "ver";
  }

}
