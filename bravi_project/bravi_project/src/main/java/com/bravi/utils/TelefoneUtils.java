public class TelefoneUtils {

    public static boolean validarTelefone(String telefone) {
        telefone = telefone.replaceAll("[^\\d]", "");

        return telefone.length() == 10 || telefone.length() == 11;
    }

    public static String formatarTelefone(String telefone) {
        telefone = telefone.replaceAll("[^\\d]", "");

        if (telefone.length() != 10 && telefone.length() != 11) {
            throw new IllegalArgumentException("Telefone inválido. Deve conter 10 ou 11 dígitos.");
        }

        if (telefone.length() == 10) {
            return "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 6) + "-" + telefone.substring(6, 10);
        } else {
            return "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 7) + "-" + telefone.substring(7, 11);
        }
    }
}
