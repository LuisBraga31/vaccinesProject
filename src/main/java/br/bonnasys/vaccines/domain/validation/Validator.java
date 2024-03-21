package br.bonnasys.vaccines.domain.validation;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Validator {

    private final ValidationHandler handler;

    public abstract void validate();

    protected ValidationHandler validationHandler() {
        return this.handler;
    }

}
