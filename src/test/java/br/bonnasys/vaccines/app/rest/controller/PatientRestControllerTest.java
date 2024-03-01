package br.bonnasys.vaccines.app.rest.controller;

import br.bonnasys.vaccines.app.mapper.PatientMapper;
import br.bonnasys.vaccines.app.rest.PatientApi;
import br.bonnasys.vaccines.domain.usecase.patient.create.CreatePatientUseCase;
import br.bonnasys.vaccines.domain.usecase.patient.retrieve.get.GetPatientByIdUseCase;
import br.bonnasys.vaccines.support.annotation.ControllerTest;
import br.bonnasys.vaccines.support.builder.PatientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ControllerTest(controllers = PatientApi.class)
class PatientRestControllerTest {

    @MockBean
    private GetPatientByIdUseCase getPatientByIdUseCase;
    @MockBean
    private CreatePatientUseCase createPatientUseCase;
    @MockBean
    private PatientMapper patientMapper;

    @Autowired
    public MockMvc mvc;

    @Test
    void dummy() throws Exception {

        Mockito.when(createPatientUseCase.execute(Mockito.any()))
                .thenReturn(PatientBuilder.any().withId().build());
        final String payload = """
                {
                    "name": "Luis",
                    "phone": "999999999",
                    "email": "luisbraga@gmail.com",
                    "birthdate": "2000-07-31"
                }
                """;
        final var aRequest = MockMvcRequestBuilders
                .post("/patients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        final var aResponse= this.mvc.perform(aRequest)
                .andDo(print());

    }

}