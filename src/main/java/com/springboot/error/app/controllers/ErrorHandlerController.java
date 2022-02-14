package com.springboot.error.app.controllers;

import com.springboot.error.app.errors.UserNotFoundException;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

  @ExceptionHandler(ArithmeticException.class)
  public String arithmeticException(Exception ex, Model model) {

    model.addAttribute("error", "Error de aritmética");
    model.addAttribute("message", ex.getMessage());
    model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
    model.addAttribute("timestamp", new Date());

    return "error/arithmeticError";
  }

  @ExceptionHandler(NumberFormatException.class)
  public String numberFormatException(Exception ex, Model model) {

    model.addAttribute("error", "Error: Formato de número inválido");
    model.addAttribute("message", ex.getMessage());
    model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
    model.addAttribute("timestamp", new Date());

    return "error/numberFormatError";
  }

  @ExceptionHandler(UserNotFoundException.class)
  public String userNotFoundException(Exception ex, Model model) {

    model.addAttribute("error", "Error: Usuario no encontrado");
    model.addAttribute("message", ex.getMessage());
    model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
    model.addAttribute("timestamp", new Date());

    return "error/userNotFoundError";
  }

}
