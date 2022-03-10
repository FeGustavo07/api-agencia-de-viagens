package com.dreamtrip.destinos.execeptions;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class ValidacaoExecption extends RuntimeException{

    @Getter
    private final List<String> errosDeValidacao;

    public ValidacaoExecption(List<String> errosDeValidacao) {
        super(errosDeValidacao.stream().collect(Collectors.joining(";")));
        this.errosDeValidacao = errosDeValidacao;
    }

    public ValidacaoExecption(String mensagemDeErro) {
        super(mensagemDeErro);
        errosDeValidacao = List.of(mensagemDeErro);
    }

}
