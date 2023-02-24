package controller;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;


public class ConsumirAPI {

	public static void cotacao() throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().GET()
				.uri(URI.create("https://economia.awesomeapi.com.br/json/last/USD-BRL,EUR-BRL,GBP-BRL,CLP-BRL,ARS-BRL"))
				.timeout(java.time.Duration.ofSeconds(15))
				.build();
		HttpClient httpClient = HttpClient.newBuilder()
				.connectTimeout(Duration.ofSeconds(15))
				.followRedirects(Redirect.NORMAL)
				.build();
		
		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		
		//recebendo dados da api e guardando em uma váriavel
		String cotacaoTotal = response.body();
		//System.out.println(cotacaoTotal);
	
		//separando a String onde tem as virgulas para criar outras Strings
		String[] cotacaoMoedaTotal = cotacaoTotal.split(",");
		
		//separando a posição da moeda e separando o valor
		String[] cotacaoDolarValor = cotacaoMoedaTotal[7].split(":");
		// convertendo o valor de string para double
		double cotacaoDolar = Double.parseDouble(cotacaoDolarValor[1].replaceAll("\"", ""));
		System.out.println(cotacaoDolar);
		
		//separando a posição da moeda e separando o valor
		String[] cotacaoEuroValor = cotacaoMoedaTotal[18].split(":");
		// convertendo o valor de string para double
		double cotacaoEuro = Double.parseDouble(cotacaoEuroValor[1].replaceAll("\"", ""));
		System.out.println(cotacaoEuro);
		
		//separando a posição da moeda e separando o valor
		String[] cotacaoLibraValor = cotacaoMoedaTotal[29].split(":");
		// convertendo o valor de string para double
		double cotacaoLibra = Double.parseDouble(cotacaoLibraValor[1].replaceAll("\"", ""));
		System.out.println(cotacaoLibra);
		
		//separando a posição da moeda e separando o valor
		String [] cotacaoPesoChilenoValor = cotacaoMoedaTotal[40].split(":");
		// convertendo o valor de string para double
		double cotacaoPesoChileno = Double.parseDouble(cotacaoPesoChilenoValor[1].replaceAll("\"", ""));
		System.out.println(cotacaoPesoChileno);
		
		//separando a posição da moeda e separando o valor
		String [] cotcaoPesoArgentinoValor = cotacaoMoedaTotal[51].split(":");
		// convertendo o valor de string para double
		double cotacaoPesoArgentino = Double.parseDouble(cotcaoPesoArgentinoValor[1].replaceAll("\"", ""));
		System.out.println(cotacaoPesoArgentino);
		
		//setando valores para as variaveis 
		Moedas.setDolar(cotacaoDolar);
		Moedas.setEuro(cotacaoEuro);
		Moedas.setLibrasEsterlinas(cotacaoLibra);
		Moedas.setPesoChileno(cotacaoPesoChileno);
		Moedas.setPesoArgentino(cotacaoPesoArgentino);
	}

}
