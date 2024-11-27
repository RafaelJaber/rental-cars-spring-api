package com.challenge.rental_cars_spring_api.access;

import com.challenge.rental_cars_spring_api.core.queries.ProcessarArquivoAluguelQuery;
import com.challenge.rental_cars_spring_api.core.queries.ListarAlugueisQuery;
import com.challenge.rental_cars_spring_api.core.queries.dtos.AluguelResponseDTO;
import com.challenge.rental_cars_spring_api.core.queries.dtos.ResultadoProcessamentoArquivoDTO;
import com.challenge.rental_cars_spring_api.exceptions.FormatoInvalidoDoArquivoException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alugueis")
public class AluguelRestController {

    private final ProcessarArquivoAluguelQuery processarArquivoAluguelQuery;
    private final ListarAlugueisQuery listarAlugueisQuery;

    @GetMapping
    public ResponseEntity<AluguelResponseDTO> listarAlugueis() {
        AluguelResponseDTO response = listarAlugueisQuery.execute();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

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

        ResultadoProcessamentoArquivoDTO resultado = processarArquivoAluguelQuery.processaArquivo(file);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultado);
    }

}
