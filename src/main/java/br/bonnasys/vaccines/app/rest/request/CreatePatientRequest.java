package br.bonnasys.vaccines.app.rest.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreatePatientRequest {

    @NotNull
    private String name;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    @NotNull
    private LocalDate birthdate;
}
