package br.bonnasys.vaccines.domain.usecase.patient.retrieve.search;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class SearchPatientUseCaseImplTest {

    @Autowired
    private SearchPatientUseCase searchPatientUseCase;

    @Test
    void givenAnValidPageableWhenCallSearchPatientUseCaseThenReturnPatient(){

    }
}