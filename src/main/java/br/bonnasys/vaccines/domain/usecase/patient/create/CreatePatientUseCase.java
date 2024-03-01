package br.bonnasys.vaccines.domain.usecase.patient.create;

import br.bonnasys.vaccines.domain.model.Patient;

// Permits serve para indicar quais clases podem implementar essa interface
//public sealed interface CreatePatientUseCase permits CreatePatientUseCaseImpl{
public interface CreatePatientUseCase {
    Patient execute(CreatePatientCommand command);
}
