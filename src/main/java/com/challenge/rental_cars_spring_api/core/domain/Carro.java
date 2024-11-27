package com.challenge.rental_cars_spring_api.core.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carro")
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "ano")
    private String ano;

    @Column(name = "qtd_passageiros")
    private Integer qtdPassageiros;

    @Column(name = "km")
    private Integer km;

    @Column(name = "fabricante")
    private String fabricante;

    @Column(name = "vlr_diaria")
    private BigDecimal vlrDiaria;
}
