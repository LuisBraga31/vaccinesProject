package br.bonnasys.vaccines.domain.usecase.patient.update;

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

@ActiveProfiles("Test")
@SpringBootTest
class UpdatePatientUseCaseImplTest {

    @Autowired
    private UpdatePatientUseCase updatePatientUseCase;
    @Autowired
    private PatientRepository repository;

    @Test
    void givenValidMapWhenCallsUpdatePatientUseCaseThenAssertFields() {
        String name = "Henrique Gonçalves";
        String newName = "Henrique Tilapia";

        String phone = "(99) 9999-8888";
        String email = "henrique.goncalves@gmail.com";
        LocalDate birthdate = LocalDate.now().minusYears(32);
        Patient patient = new Patient(name, phone, email, birthdate);

        Patient createdPatient = repository.save(patient);

        Map<String, Object> fields = new HashMap<>();
        fields.put("name", newName);

        String patientId = createdPatient.getId();

        updatePatientUseCase.execute(patientId, fields);

        Patient retrievedPatient = repository.findById(patientId).orElseThrow();
        Assertions.assertNotEquals(name, retrievedPatient.getName());
        Assertions.assertEquals(newName, retrievedPatient.getName());


    }

    @Test
    void givenInvalidMapWhenCallsUpdatePatientUseCaseThenShouldNotThrowsException() {
        String name = "Pedro José";
        String phone = "(99) 9999-8888";
        String email = "pedro.jose@gmail.com";
        LocalDate birthdate = LocalDate.now().minusYears(32);
        Patient patient = new Patient(name, phone, email, birthdate);

        Patient createdPatient = repository.save(patient);

        Map<String, Object> fields = new HashMap<>();
        String newName = "Henrique Tilapia";
        String newPhone = "(00) 33333-0000";
        fields.put("name", newName);
        fields.put("idade", newName);
        fields.put("telefone", newName);
        fields.put("email", newName);
        fields.put("cellphone", newName);
        fields.put("phone", newPhone);


        String patientId = createdPatient.getId();

        updatePatientUseCase.execute(patientId, fields);

        Patient retrievedPatient = repository.findById(patientId).orElseThrow();
        Assertions.assertNotEquals(name, retrievedPatient.getName());
        Assertions.assertEquals(newName, retrievedPatient.getName());


    }

}