package br.bonnasys.vaccines.domain.usecase.patient.create;


import br.bonnasys.vaccines.domain.model.Patient;
import br.bonnasys.vaccines.domain.repository.PatientRepository;
import br.bonnasys.vaccines.support.annotation.UnitTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@UnitTest
class CreatePatientUseCaseImplTest {

    @Autowired
    private CreatePatientUseCase createPatientUseCase;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    void givenValidCommandWhenCallsCreatePatientUseCaseThenAssertFields() {
        String name = "Rick Sanches";
        String email = "rick.sanches@email.com";
        String phone = "(99) 99999-9999";
        LocalDate birthdate = LocalDate.now()
                .minusDays(12)
                .minusMonths(1)
                .minusYears(45);

        CreatePatientCommand command = new CreatePatientCommand(name, phone, email, birthdate);

        Patient patient = createPatientUseCase.execute(command);
        String patientId = patient.getId();

        Patient createdPatient = patientRepository.findById(patientId).orElseThrow();

        Assertions.assertEquals(name, createdPatient.getName());
        Assertions.assertEquals(phone, createdPatient.getPhone());
        Assertions.assertEquals(email, createdPatient.getEmail());
        Assertions.assertEquals(birthdate, createdPatient.getBirthdate());
        Assertions.assertTrue(createdPatient.getHistory().isEmpty());
        Assertions.assertNull(createdPatient.getUpdatedAt());
        Assertions.assertNotNull(createdPatient.getCreatedAt());

    }
}