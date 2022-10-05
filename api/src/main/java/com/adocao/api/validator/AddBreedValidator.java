package com.adocao.api.validator;

import com.adocao.api.controller.request.AddBreedRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Component
public class AddBreedValidator {

    public void validate(AddBreedRequest request) {
        if (Objects.isNull(request)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request não pode ser nulo.");
        }
    }
}
