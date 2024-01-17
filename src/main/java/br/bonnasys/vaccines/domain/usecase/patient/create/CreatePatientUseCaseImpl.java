package br.bonnasys.vaccines.domain.usecase.patient.create;

import br.bonnasys.vaccines.domain.model.Patient;
import br.bonnasys.vaccines.domain.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreatePatientUseCaseImpl implements CreatePatientUseCase {

    private final PatientRepository patientRepository;

    @Override
    public Patient execute(CreatePatientCommand command) {
        Patient patient = new Patient();

        patient.setName(command.name());
        patient.setEmail(command.email());
        patient.setPhone(command.phone());
        patient.setBirthdate(command.birthdate());

        return patientRepository.save(patient);
    }
}
