package br.bonnasys.vaccines.domain.usecase.patient.retrieve.search;

import org.springframework.data.domain.Pageable;

public record SearchPatientCommand(String name, String email, Pageable page) {
}
