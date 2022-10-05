package com.adocao.api.validator;

import com.adocao.api.controller.request.AddPetRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Component
public class AddPetValidator {

    public void validate(AddPetRequest request) {
        if (Objects.isNull(request)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request não pode ser nulo.");
        }
    }
}
