package br.com.Bravi.utils;

public class CEPUtils {

    public static boolean validarCEP(String cep) {
        cep = cep.replaceAll("[^\\d]", "");

        return cep.length() == 8;
    }

    public static String formatarCEP(String cep) {
        cep = cep.replaceAll("[^\\d]", "");

        if (cep.length() != 8) {
            throw new IllegalArgumentException("CEP inválido. Deve conter 8 dígitos.");
        }

        return cep.substring(0, 5) + "-" + cep.substring(5, 8);
    }
}
