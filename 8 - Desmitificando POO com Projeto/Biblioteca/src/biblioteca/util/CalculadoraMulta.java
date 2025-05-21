package biblioteca.util;

import java.text.NumberFormat;
import java.util.Locale;

public final class CalculadoraMulta {
    
    // Impede instanciação (classe utilitária)
    private CalculadoraMulta() {}
    
    /**
     * Calcula multa com possível desconto
     * @param diasAtraso Quantidade de dias em atraso
     * @param valorDiario Valor da multa por dia (ex: 0.50 para alunos)
     * @param percentualDesconto Desconto a ser aplicado (0 a 100)
     * @return Valor da multa formatado em Reais (R$)
     */
    public static String calcularMultaFormatada(int diasAtraso, double valorDiario, double percentualDesconto) {
        if (diasAtraso <= 0) return "R$ 0,00";
        
        double multa = diasAtraso * valorDiario;
        double desconto = multa * (percentualDesconto / 100);
        double valorFinal = multa - desconto;
        
        return formatarMoeda(valorFinal);
    }
    
    /**
     * Formata valor monetário em Reais (R$)
     */
    public static String formatarMoeda(double valor) {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valor);
    }
    
    /**
     * Valida se há atraso significativo
     */
    public static boolean isAtrasoSignificativo(int diasAtraso, int limiteTolerancia) {
        return diasAtraso > limiteTolerancia;
    }
}