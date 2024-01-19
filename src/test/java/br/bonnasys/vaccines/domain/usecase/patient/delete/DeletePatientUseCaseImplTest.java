package br.bonnasys.vaccines.domain.usecase.patient.delete;

import br.bonnasys.vaccines.domain.model.Patient;
import br.bonnasys.vaccines.domain.repository.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class DeletePatientUseCaseImplTest {

    @Autowired
    private DeletePatientUseCase deletePatientUseCase;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void check() {
        String name = "Henrique Gonçalves";
        String phone = "(99) 9999-8888";
        String email = "henrique.goncalves@gmail.com";
        LocalDate birthdate = LocalDate.now().minusYears(32);
        Patient patient = new Patient(name, phone, email, birthdate);

        Patient createdPatient = patientRepository.save(patient);
        String patientId = createdPatient.getId();

        deletePatientUseCase.execute(patientId);

        patientRepository.findById(patientId).ifPresent(pt -> {
            Assertions.fail("Paciente não foi excluido com sucesso");
        });
    }

}