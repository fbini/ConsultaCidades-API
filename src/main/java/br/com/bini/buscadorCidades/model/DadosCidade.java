package br.com.bini.buscadorCidades.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosCidade(
        @JsonAlias("results") List<DadosLocalizacao> resultados
) {}