package br.com.bini.buscadorCidades.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLocalizacao(
        @JsonAlias("name") String nome,
        @JsonAlias("country") String pais,
        @JsonAlias("admin1") String estado,
        @JsonAlias("country_code") String dominio,
        @JsonAlias("timezone") String fusoHorario,
        @JsonAlias("population") int populacao,

        @JsonAlias("latitude") double latitude,
        @JsonAlias("longitude") double longitude,
        @JsonAlias("elevation") int elevacao
) { }
