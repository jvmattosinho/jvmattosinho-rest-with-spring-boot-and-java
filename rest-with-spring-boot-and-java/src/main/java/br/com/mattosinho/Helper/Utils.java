package br.com.mattosinho.Helper;

public class Utils {
	
	public static double convertToDouble(String strNumero) {
		if (strNumero == null) return 0D;
		String number = strNumero.replace(",", ".");
		if (eNumerico(strNumero)) return Double.parseDouble(number);
		return 0D;
	}

	public static boolean eNumerico(String strNumero) {
		if (strNumero == null) return false;
		String number = strNumero.replace(",", ".");
		return number.matches("[+-]?[0-9]*\\.?[0-9]+");
	}

}
