package com.challenge.rental_cars_spring_api.access;

import com.challenge.rental_cars_spring_api.core.queries.CalcularAluguelQuery;
import com.challenge.rental_cars_spring_api.core.queries.dtos.ResultadoProcessamentoArquivoDTO;
import com.challenge.rental_cars_spring_api.exceptions.FormatoInvalidoDoArquivoException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alugueis")
public class AluguelRestController {

    private final CalcularAluguelQuery calcularAluguelQuery;

    @PostMapping(value = "/carregar-arquivo", consumes = "multipart/form-data")
    public ResponseEntity<ResultadoProcessamentoArquivoDTO> carregarArquivo(

            @RequestParam("file")MultipartFile file
    ) {

        if (!Objects.requireNonNull(file.getOriginalFilename()).endsWith(".rtn")) {
            throw new FormatoInvalidoDoArquivoException(
                    ".rtn",
                    "." + file.getOriginalFilename().split("\\.")[1]
            );
        }

        ResultadoProcessamentoArquivoDTO resultado = calcularAluguelQuery.processaArquivo(file);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultado);
    }

}
