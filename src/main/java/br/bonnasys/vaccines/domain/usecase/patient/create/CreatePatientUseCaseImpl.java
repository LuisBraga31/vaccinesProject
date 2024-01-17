package br.bonnasys.vaccines.domain.usecase.patient.create;

import br.bonnasys.vaccines.domain.model.Patient;
import br.bonnasys.vaccines.domain.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@AllArgsConstructor
public final class CreatePatientUseCaseImpl implements CreatePatientUseCase {

    private final PatientRepository patientRepository;

    @Override
    public Patient execute(CreatePatientCommand command) {
        Patient patient = new Patient(command.name(), command.phone(), command.email(), command.birthdate());

        informPatientRegistration(command);
        return patientRepository.save(patient);

    }

    private void informPatientRegistration(CreatePatientCommand command) {

        String fullName = command.name();
        String[] fullNameArray = fullName.split(" ");
        String firstName = fullNameArray[0];
        String lastName = fullNameArray[1];
        LocalDate birthdate = command.birthdate();
        Integer years = LocalDate.now().getYear() - birthdate.getYear();

        String registration = """
                --------------------------------------
                 Solicitação:            create
                 Nome Paciente:          %s
                 Sobrenome Paciente:     %s
                 Telefone de Contato:    %s
                 Idade do Paciente:      %d
                --------------------------------------
                """.formatted(firstName, lastName, command.phone(), years);

        log.info(registration);

    }

}
