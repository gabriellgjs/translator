package com.translatorapi.controllers;

import com.translatorapi.domain.entities.Translation;
import com.translatorapi.dtos.TranslatorDTO;
import com.translatorapi.exceptions.ResponseValidationException;
import com.translatorapi.services.TranslatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/translate")
public class TranslatorController {
  @Autowired
  private TranslatorService translatorService;

  @PostMapping()
  public ResponseEntity<Translation> translateRoute(@RequestBody @Valid TranslatorDTO request) {
    return new ResponseEntity<>( this.translatorService.translate(request), HttpStatus.OK);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ResponseValidationException> onHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
    Map<String, String> errors = new HashMap<>();

    errors.put("message", ex.getMessage());

    ResponseValidationException threatResponse = new ResponseValidationException(HttpStatus.BAD_REQUEST, "Erro na request", errors);

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ResponseValidationException> onMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    ResponseValidationException threatResponse = new ResponseValidationException(HttpStatus.BAD_REQUEST, "Erros de validações", errors);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(threatResponse);
  }
}
