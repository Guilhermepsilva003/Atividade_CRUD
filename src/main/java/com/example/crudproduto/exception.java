package com.example.crudproduto;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class exception extends RuntimeException {
    public exception(String message) { super(message); }
}
