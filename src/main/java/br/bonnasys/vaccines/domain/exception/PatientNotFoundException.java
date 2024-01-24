package br.bonnasys.vaccines.domain.exception;

public class PatientNotFoundException extends RuntimeException{
    public PatientNotFoundException() {
        super("Patient not found", null, true, false);
    }

}
