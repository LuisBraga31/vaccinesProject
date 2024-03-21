package br.bonnasys.vaccines.domain.validation.handler;

import br.bonnasys.vaccines.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(Error err) {
        throw new RuntimeException(err.message());
    }

    @Override
    public <T> T validate(Validation<T> validation) {
        try {
            return validation.validate();
        } catch (final Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Error> getErrors() {
        return null;
    }
}
