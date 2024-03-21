package br.bonnasys.vaccines.domain.model.validator;

import br.bonnasys.vaccines.domain.model.Vaccine;
import br.bonnasys.vaccines.domain.validation.ValidationHandler;
import br.bonnasys.vaccines.domain.validation.Validator;

public class VaccineValidator extends Validator {

    private final Vaccine vaccine;

    public VaccineValidator(ValidationHandler handler, Vaccine vaccine) {
        super(handler);
        this.vaccine = vaccine;
    }

    @Override
    public void validate() {
        checkNameConstraint();
        checkProducerConstraint();
    }

    private void checkNameConstraint() {
        String vaccineName = vaccine.getName();

        if(vaccineName == null) {
            this.validationHandler().append(new ValidationHandler.Error("'name' should not be null"));
            return;
        }
        if(vaccineName.isBlank()) {
            this.validationHandler().append(new ValidationHandler.Error("'name' should not be empty"));
            return;
        }
    }

    private void checkProducerConstraint() {
        String vaccineProducer = vaccine.getProducer();

        if(vaccineProducer == null) {
            this.validationHandler().append(new ValidationHandler.Error("'producer' should not be null"));
            return;
        }
        if(vaccineProducer.isBlank()) {
            this.validationHandler().append(new ValidationHandler.Error("'producer' should not be empty"));
            return;
        }
    }

}
