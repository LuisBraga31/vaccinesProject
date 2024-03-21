package br.bonnasys.vaccines.domain.validation.handler;

import br.bonnasys.vaccines.domain.validation.ValidationHandler;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Notification implements ValidationHandler {

    private final List<Error> errors;

    @Override
    public ValidationHandler append(Error err) {
        this.errors.add(err);
        return this;
    }

    @Override
    public <T> T validate(Validation<T> validation) {
        try {
            return validation.validate();
        } catch (Exception e) {
            this.errors.add(new Error(e.getMessage()));
        }
        return null;
    }

    @Override
    public List<Error> getErrors() {
        return null;
    }
}
