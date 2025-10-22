package br.com.bini.buscadorClimatico.principal;

import br.com.bini.buscadorClimatico.model.DadosCidade;
import br.com.bini.buscadorClimatico.service.ConsumoApi;
import br.com.bini.buscadorClimatico.service.ConverteDados;

import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);

    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConverteDados converteDados = new ConverteDados();

    private final String ENDERECO = "https://geocoding-api.open-meteo.com/v1/search?name=";

    public void exibeMenu(){
        System.out.println("Digite o nome da cidade: ");

        var nomeCidade = teclado.nextLine();

        var json = consumoApi.obterDados(ENDERECO + nomeCidade.replace(" ", "%20"));
        var dadosCidade = converteDados.obterDados(json, DadosCidade.class);

       if (dadosCidade.resultados() == null || dadosCidade.resultados().isEmpty()) {
           System.out.println("Cidade não encontrada");
       }
        System.out.println("\nResultados encontrados:");
        dadosCidade.resultados()
                //arrumar essa formatação
                .forEach(c -> System.out.printf(
                        "Cidade: %s | País: %s | Estado: %s | Lat: %.2f | Lon: %.2f | Fuso: %s%n",
                        c.nome(), c.pais(), c.estado(), c.lagitude(), c.longitude(), c.fusoHorario()
                ));
    }

}
