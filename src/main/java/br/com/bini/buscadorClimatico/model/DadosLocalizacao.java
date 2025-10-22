package br.com.bini.buscadorClimatico.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLocalizacao(
        @JsonAlias("name") String nome,
        @JsonAlias("country") String pais,
        @JsonAlias("admin1") String estado,
        @JsonAlias("latitude") double lagitude,
        @JsonAlias ("longitude") double longitude,
        @JsonAlias("timezone") String fusoHorario
) { }
