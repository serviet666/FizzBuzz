package net.nico.fizzbuzz.controller;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
		String message = String.format("Le paramètre '%s' doit être un entier valide.", ex.getName());
		return ResponseEntity.badRequest().body(message);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleConstraintViolation(ConstraintViolationException ex) {
		String message = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
				.collect(Collectors.joining(", "));
		return ResponseEntity.badRequest().body(message);
	}

}
