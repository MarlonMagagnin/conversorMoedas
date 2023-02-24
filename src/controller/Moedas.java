package controller;

public class Moedas {
	private static Double dolar;
	private static double euro;
	private static double librasEsterlinas;
	private static double pesoArgentino;
	private static double pesoChileno;
	
	public static Double getDolar() {
		return dolar;
	}
	public static void setDolar(Double dolar) {
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
	

}
