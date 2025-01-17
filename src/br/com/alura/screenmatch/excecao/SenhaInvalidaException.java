package br.com.alura.screenmatch.excecao;

public class SenhaInvalidaException extends RuntimeException {

    private String mensagem;

    public SenhaInvalidaException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
