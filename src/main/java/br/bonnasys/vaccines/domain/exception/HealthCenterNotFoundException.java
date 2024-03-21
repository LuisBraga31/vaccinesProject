package br.bonnasys.vaccines.domain.exception;

public class HealthCenterNotFoundException extends RuntimeException{
    public HealthCenterNotFoundException() {
        super("Centro não encontrado", null, true, false);
    }
}
