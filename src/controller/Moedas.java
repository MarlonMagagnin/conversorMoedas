package controller;

public class Moedas {
	private static double dolar;
	private static double euro;
	private static double librasEsterlinas;
	private static double pesoArgentino;
	private static double pesoChileno;
	private static double dolarConvertido;
	private static double real = 1;
	
	public static double getDolar() {
		return dolar;
	}
	public static void setDolar(double dolar) {
		Moedas.dolar = dolar;
	}
	public static double getEuro() {
		return euro;
	}
	public static void setEuro(double euro) {
		Moedas.euro = euro;
	}
	public static double getLibrasEsterlinas() {
		return librasEsterlinas;
	}
	public static void setLibrasEsterlinas(double librasEsterlinas) {
		Moedas.librasEsterlinas = librasEsterlinas;
	}
	public static double getPesoArgentino() {
		return pesoArgentino;
	}
	public static void setPesoArgentino(double pesoArgentino) {
		Moedas.pesoArgentino = pesoArgentino;
	}
	public static double getPesoChileno() {
		return pesoChileno;
	}
	public static void setPesoChileno(double pesoChileno) {
		Moedas.pesoChileno = pesoChileno;
	}
	public static void setDolarConvertido(double dolarConvertido) {
		Moedas.dolarConvertido = dolarConvertido;
	}
	public static double getDolarConvertido() {
		return dolarConvertido;
	}
	public static void setReal(double real) {
		Moedas.real = real;
	}
	public static double getReal() {
		return real;
	}

}
