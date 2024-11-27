package com.challenge.rental_cars_spring_api.core.queries.dtos;

import lombok.Data;

@Data
public class ResultadoProcessamentoArquivoDTO {
    private String nomeArquivo;
    private Integer totalRegistros;
    private Integer totalRegistrosProcessados;
    private Integer totalRegistrosComErro;

    public ResultadoProcessamentoArquivoDTO(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        this.totalRegistros = 0;
        this.totalRegistrosProcessados = 0;
        this.totalRegistrosComErro = 0;
    }
}
