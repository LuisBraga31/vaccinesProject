package br.bonnasys.vaccines.domain.exception;

public class StockInsufficientException extends RuntimeException{
    public StockInsufficientException(Integer amount, Integer stock) {
        super("Estoque possui [%d] e não foi possível remover [%d]".formatted(stock, amount), null, true, false);
    }
}
