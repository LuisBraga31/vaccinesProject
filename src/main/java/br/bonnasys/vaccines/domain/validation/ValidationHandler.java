package br.bonnasys.vaccines.domain.validation;

import java.util.List;

public interface ValidationHandler {

    ValidationHandler append(Error err);

    // Esperar uma função  a ser validada, T é o tipo daquele momento
    <T> T validate(Validation<T> validation);

    List<Error> getErrors();

    record Error(String message){}

    interface Validation<T> {
        T validate();
    }

}
