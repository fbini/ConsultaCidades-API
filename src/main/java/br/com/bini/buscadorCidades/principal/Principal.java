package br.com.bini.buscadorCidades.principal;

import br.com.bini.buscadorCidades.model.DadosCidade;
import br.com.bini.buscadorCidades.service.ConsumoApi;
import br.com.bini.buscadorCidades.service.ConverteDados;

import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);

    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConverteDados converteDados = new ConverteDados();

    private final String ENDERECO = "https://geocoding-api.open-meteo.com/v1/search?name=";

    public void exibeMenu() {
        System.out.println("Digite o nome da cidade: ");

        var nomeCidade = teclado.nextLine();

        var json = consumoApi.obterDados(ENDERECO + nomeCidade.replace(" ", "%20"));
        var dadosCidade = converteDados.obterDados(json, DadosCidade.class);

        if (dadosCidade == null || dadosCidade.resultados() == null || dadosCidade.resultados().isEmpty()) {
            System.out.println("Nenhuma cidade encontrada para o nome informado: " + nomeCidade);
        } else {
            dadosCidade.resultados().forEach(cidade -> {
                System.out.println("Cidade: " + cidade.nome());
                System.out.println("País: " + cidade.pais());
                System.out.println("Estado: " + cidade.estado());
                System.out.println("Domínio: " + cidade.dominio());
                System.out.println("Fuso horário: " + cidade.fusoHorario());
                System.out.println("População: " + cidade.populacao());

                System.out.println("Latitude: " + cidade.latitude());
                System.out.println("Longitude: " + cidade.longitude());
                System.out.println("Elevação: " + cidade.elevacao());

                System.out.println("------------------------------------");
            });
        }

    }
}