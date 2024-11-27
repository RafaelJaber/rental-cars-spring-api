package com.challenge.rental_cars_spring_api.core.queries.dtos;

import com.challenge.rental_cars_spring_api.core.domain.Aluguel;

import java.math.BigDecimal;
import java.util.Date;

public record AluguelItemResponseDTO (
        Date dataAluguel,
        String modeloCarro,
        Integer kmCarro,
        String nomeCliente,
        String telefoneCliente,
        Date dataDevolucao,
        BigDecimal valor,
        String pago
) {
    public static AluguelItemResponseDTO from(Aluguel aluguel) {
        return new AluguelItemResponseDTO(
                aluguel.getDataAluguel(),
                aluguel.getCarro().getModelo(),
                aluguel.getCarro().getKm(),
                aluguel.getCliente().getNome(),
                aluguel.getCliente().getTelefone(),
                aluguel.getDataDevolucao(),
                aluguel.getValor(),
                aluguel.getPago() ? "SIM" : "NAO"
        );
    }
}
