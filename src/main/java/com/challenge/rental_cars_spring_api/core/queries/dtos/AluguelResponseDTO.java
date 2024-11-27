package com.challenge.rental_cars_spring_api.core.queries.dtos;

import java.math.BigDecimal;
import java.util.List;

public record AluguelResponseDTO(BigDecimal totalNaoPago, List<AluguelItemResponseDTO> alugueis) {
    public static AluguelResponseDTO from(List<AluguelItemResponseDTO> alugueis) {
        BigDecimal totalNaoPago = alugueis.stream()
                .filter(aluguel -> aluguel.pago().equals("NAO"))
                .map(AluguelItemResponseDTO::valor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new AluguelResponseDTO(totalNaoPago, alugueis);
    }
}
