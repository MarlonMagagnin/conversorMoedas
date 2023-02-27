package controller;

import java.text.DecimalFormat;

import views.TelaConversorMoedas;

public class MoedasController {

	private static double valor = TelaConversorMoedas.getValorAConverter();
	private static String resultado;
	private static String cotacaoResultado;

	// metodos conversão real para todos
	public static void realDolar() {
		cotacaoResultado = String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getDolar()));
		resultado = String.valueOf(new DecimalFormat("$ 0.###").format(valor / Moedas.getDolar()));
	}

	public static void realEuro() {
		cotacaoResultado = String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getEuro()));
		resultado = String.valueOf(new DecimalFormat("€ 0.###").format(valor / Moedas.getEuro()));
	}

	public static void realLibrasEsterlinas() {
		cotacaoResultado = String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getLibrasEsterlinas()));
		resultado = String.valueOf(new DecimalFormat("£ 0.###").format(valor / Moedas.getLibrasEsterlinas()));
	}

	public static void realPesoArgentino() {
		cotacaoResultado = String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getPesoArgentino()));
		resultado = String.valueOf(new DecimalFormat("$ 0.###").format(valor / Moedas.getPesoArgentino()));
	}

	public static void realPesoChileno() {
		cotacaoResultado = String.valueOf(new DecimalFormat("R$ 0.###").format(Moedas.getPesoArgentino()));
		resultado = String.valueOf(new DecimalFormat("$ 0.###").format(valor / Moedas.getPesoChileno()));
	}

	// metodo conversao de todos para real
	public static void dolarReal() {
		cotacaoResultado = String.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getReal() / Moedas.getDolar()));
		resultado = String.valueOf(new DecimalFormat("R$ 0.###").format(valor * Moedas.getDolar()));
	}

	public static void euroReal() {
		cotacaoResultado = String.valueOf(new DecimalFormat("€ 0.###").format(Moedas.getReal() / Moedas.getEuro()));
		resultado = String.valueOf(new DecimalFormat("R$ 0.###").format(valor * Moedas.getEuro()));
	}

	public static void librasEsterlinasReal() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("£ 0.###").format(Moedas.getReal() / Moedas.getLibrasEsterlinas()));
		resultado = String.valueOf(new DecimalFormat("R$ 0.###").format(valor * Moedas.getLibrasEsterlinas()));
	}

	public static void pesoArgentinoReal() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getReal() / Moedas.getPesoArgentino()));
		resultado = String.valueOf(new DecimalFormat("R$ 0.###").format(valor * Moedas.getPesoArgentino()));
	}

	public static void pesoChilenoReal() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getReal() / Moedas.getPesoChileno()));
		resultado = String.valueOf(new DecimalFormat("R$ 0.###").format(valor * Moedas.getPesoChileno()));
	}

	// metodos de conversão de euro para restantes
	public static void euroDolar() {
		cotacaoResultado = String.valueOf(new DecimalFormat("€ 0.###").format(Moedas.getEuro() / Moedas.getDolar()));
		resultado = String
				.valueOf(new DecimalFormat("$ 0.###").format((valor * (Moedas.getEuro() / Moedas.getDolar()))));
	}

	public static void euroLibrasEsterlinas() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("€ 0.###").format(Moedas.getEuro() / Moedas.getLibrasEsterlinas()));
		resultado = String.valueOf(
				new DecimalFormat("£ 0.###").format(valor * (Moedas.getEuro() / Moedas.getLibrasEsterlinas())));
	}

	public static void euroPesoArgentino() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("€ 0.###").format(Moedas.getEuro() / Moedas.getPesoArgentino()));
		resultado = String.valueOf(
				new DecimalFormat("$ 0.###").format((valor * (Moedas.getEuro() / Moedas.getPesoArgentino()))));
	}

	public static void euroPesoChileno() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("€ 0.###").format(Moedas.getEuro() / Moedas.getPesoChileno()));
		resultado = String
				.valueOf(new DecimalFormat("$ 0.###").format((valor * (Moedas.getEuro() / Moedas.getPesoChileno()))));
	}

	// metodos de conversão de dolar para restantes
	public static void dolarEuro() {
		cotacaoResultado = String.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getDolar() / Moedas.getEuro()));
		resultado = String
				.valueOf(new DecimalFormat("€ 0.###").format((valor * (Moedas.getDolar() / Moedas.getEuro()))));
	}

	public static void dolarLibrasEsterlinas() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getDolar() / Moedas.getLibrasEsterlinas()));
		resultado = String.valueOf(
				new DecimalFormat("£ 0.###").format(valor * (Moedas.getDolar() / Moedas.getLibrasEsterlinas())));
	}

	public static void dolarPesoArgentino() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getDolar() / Moedas.getPesoArgentino()));
		resultado = String.valueOf(
				new DecimalFormat("$ 0.###").format((valor * (Moedas.getDolar() / Moedas.getPesoArgentino()))));
	}

	public static void dolarPesoChileno() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getDolar() / Moedas.getPesoChileno()));
		resultado = String
				.valueOf(new DecimalFormat("$ 0.###").format((valor * (Moedas.getDolar() / Moedas.getPesoChileno()))));
	}

	// metodos de conversão de libras esterlinas para restantes
	public static void librasEsterlinasEuro() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("£ 0.###").format(Moedas.getLibrasEsterlinas() / Moedas.getEuro()));
		resultado = String.valueOf(
				new DecimalFormat("€ 0.###").format((valor * (Moedas.getLibrasEsterlinas() / Moedas.getEuro()))));
	}

	public static void librasEsterlinasDolar() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("£ 0.###").format(Moedas.getLibrasEsterlinas() / Moedas.getDolar()));
		resultado = String.valueOf(
				new DecimalFormat("$ 0.###").format(valor * (Moedas.getLibrasEsterlinas() / Moedas.getDolar())));
	}

	public static void librasEsterlinasPesoArgentino() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("£ 0.###").format(Moedas.getLibrasEsterlinas() / Moedas.getPesoArgentino()));
		resultado = String.valueOf(new DecimalFormat("$ 0.###")
				.format((valor * (Moedas.getLibrasEsterlinas() / Moedas.getPesoArgentino()))));
	}

	public static void librasEsterlinasPesoChileno() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("£ 0.###").format(Moedas.getLibrasEsterlinas() / Moedas.getPesoChileno()));
		resultado = String.valueOf(new DecimalFormat("$ 0.###")
				.format((valor * (Moedas.getLibrasEsterlinas() / Moedas.getPesoChileno()))));
	}

	// metodos de conversão de peso argentino para restantes
	public static void pesoArgentinoEuro() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getPesoArgentino() / Moedas.getEuro()));
		resultado = String.valueOf(
				new DecimalFormat("€ 0.###").format((valor * (Moedas.getPesoArgentino() / Moedas.getEuro()))));
	}

	public static void pesoArgentinoDolar() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getPesoArgentino() / Moedas.getDolar()));
		resultado = String.valueOf(
				new DecimalFormat("$ 0.###").format(valor * (Moedas.getPesoArgentino() / Moedas.getDolar())));
	}

	public static void pesoArgentinolibrasEsterlinas() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("$ 0.###").format( Moedas.getLibrasEsterlinas() / Moedas.getPesoArgentino()));
		resultado = String.valueOf(new DecimalFormat("£ 0.###")
				.format((valor * (Moedas.getPesoArgentino() / Moedas.getLibrasEsterlinas()))));
	}

	public static void pesoArgentinoPesoChileno() {
		cotacaoResultado = String
				.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getPesoArgentino() / Moedas.getPesoChileno()));
		resultado = String.valueOf(new DecimalFormat("$ 0.###")
				.format((valor * (Moedas.getPesoArgentino() / Moedas.getPesoChileno()))));
	}

	// metodos de conversão de peso chileno para restantes
		public static void pesoChilenoEuro() {
			cotacaoResultado = String
					.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getPesoChileno() / Moedas.getEuro()));
			resultado = String.valueOf(
					new DecimalFormat("€ 0.###").format((valor * (Moedas.getPesoChileno() / Moedas.getEuro()))));
		}

		public static void pesoChilenoDolar() {
			cotacaoResultado = String
					.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getPesoChileno() / Moedas.getDolar()));
			resultado = String.valueOf(
					new DecimalFormat("$ 0.###").format(valor * (Moedas.getPesoChileno() / Moedas.getDolar())));
		}

		public static void pesoChilenolibrasEsterlinas() {
			cotacaoResultado = String
					.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getLibrasEsterlinas() / Moedas.getPesoChileno()));
			resultado = String.valueOf(new DecimalFormat("£ 0.###")
					.format((valor * (Moedas.getPesoChileno() / Moedas.getLibrasEsterlinas()))));
		}

		public static void pesoChilenoPesoArgentino() {
			cotacaoResultado = String
					.valueOf(new DecimalFormat("$ 0.###").format(Moedas.getPesoArgentino() / Moedas.getPesoChileno()));
			resultado = String.valueOf(new DecimalFormat("$ 0.###")
					.format((valor * (Moedas.getPesoChileno() / Moedas.getPesoArgentino()))));
		}
	public static void setResultado(String resultado) {
		MoedasController.resultado = resultado;
	}

	public static String getResultado() {
		return resultado;
	}

	public static void setCotacaoResultado(String cotacaoResultado) {
		MoedasController.cotacaoResultado = cotacaoResultado;
	}

	public static String getCotacaoResultado() {
		return cotacaoResultado;
	}

}
