package model.dao;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Util {
    public static String formatarDataHora(LocalDateTime data) {
        if (data == null) return "Sem data definida";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return data.format(fmt);
    }
    
    public static boolean validaAno(int ano){
        if(ano > 1885 && ano < 2026){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Ano inválida! [1885-2026]");
            return false;
        }
        
    }
    
    public class ValidadorCPF {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1; indice >= 0; indice--) {
            int digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - (soma % 11);
        return soma > 9 ? 0 : soma;
    }

    public static boolean CPFValido(String cpf) {
        if (cpf == null) {
            return false;
        }

        String cpfLimpo = cpf.trim().replaceAll("\\D", "");

        if (cpfLimpo.length() != 11 ||
            cpfLimpo.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            Integer digito1 = calcularDigito(cpfLimpo.substring(0, 9), pesoCPF);
            
            String cpfSemDigito = cpfLimpo.substring(0, 9) + digito1;

            Integer digito2 = calcularDigito(cpfSemDigito, pesoCPF);

            return cpfLimpo.equals(cpfSemDigito + digito2);
        } catch (Exception e) {
            return false;
        }
    }
}
}


