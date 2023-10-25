package com.amanda.teste;

public class ConversorRomanos {
    public static void main(String[] args) {
        System.out.println("Decimal para romanos: "+ConversorRomanos.decimalParaRomano(1989));
        System.out.println("Romanos para decimal: "+ConversorRomanos.romanoParaDecimal("MCMLXXXIV"));
    }
    private static final String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[] decimais = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    /**
     * Converte um número decimal em algarismos romanos.
     ** @param decimal O número decimal a ser convertido.
     * @return O número em algarismos romanos.
     * @throws IllegalArgumentException Se o número decimal for menor ou igual a 0 ou maior que 3999.
     */
    public static String decimalParaRomano(int decimal) throws IllegalArgumentException {
        if (decimal <= 0 || decimal > 3999) {
            throw new IllegalArgumentException("O número decimal informado não pode ser convertido para romanos. " +
                    "O valor decimal que pode ser convertido deve ser maior que 0 e =< 3999.");
        }

        StringBuilder romano = new StringBuilder();
        for (int i = 0; i < decimais.length; i++) {
            while (decimal >= decimais[i]) {
                romano.append(romanos[i]);
                decimal -= decimais[i];
            }
        }
        return romano.toString();

    }

    // Conversão de Romando Para Decimal
    public static int romanoParaDecimal(String romano) throws IllegalArgumentException {
        if (!romano.matches("[IVXLCDM]+")) {
            throw new IllegalArgumentException("O número romano informado não é válido.");
        }

        int decimal = 0;
        int valorAtual = 0;
        int valorAnterior = 0;
        int contadorLetrasIguais = 1; // Inicializamos o contador de letras iguais

        for (int i = romano.length() - 1; i >= 0; i--) {
            valorAtual = getValorRomano(romano.charAt(i));
            if (valorAtual >= valorAnterior) {
                decimal = decimal + valorAtual;
                // Verificar se a letra atual é igual à letra anterior
                if (valorAtual == valorAnterior) {
                    contadorLetrasIguais++;
                    // Se tiver 4 ou mais letras iguais seguidas, lançar uma exceção
                    if (contadorLetrasIguais >= 4) {
                        throw new IllegalArgumentException("Há 4 ou mais letras iguais seguidas.");
                    }
                } else {
                    contadorLetrasIguais = 1; // Reiniciar o contador
                }
            } else {
                //O símbolo I só pode anteceder o V então romano.charAt(i+1) != 'V'
                // Se não, altere para romano.charAt(i+1) == 'I'
                if (i != romano.length() - 1) {
                    if (romano.charAt(i) == 'I' && (romano.charAt(i + 1) != 'V')) {
                        throw new IllegalArgumentException("O símbolo I só pode anteceder o V e não é permitido utilizar repetições.");
                    }
                    if (romano.charAt(i) == 'X' && (romano.charAt(i + 1) != 'L' && romano.charAt(i + 1) != 'C')) {
                        throw new IllegalArgumentException("O símbolo X só pode anteceder o L e C e não é permitido utilizar repetições.");
                    }
                    if (romano.charAt(i) == 'L' && (romano.charAt(i + 1) == 'M' || romano.charAt(i + 1) == 'D' || romano.charAt(i + 1) == 'C')) {
                        throw new IllegalArgumentException("O símbolo L nunca será utilizado antes de uma letra que represente quantidades maiores.");
                    }
                    if (romano.charAt(i) == 'C' && (romano.charAt(i + 1) != 'D' && romano.charAt(i + 1) != 'M')) {
                        throw new IllegalArgumentException("O símbolo C pode ser utilizado antecedendo as D e M e nesse caso não é permitido usar repetições.");
                    }
                }
                decimal = decimal - valorAtual;
            }
            valorAnterior = valorAtual;
        }
        if (decimal>3999) {
            throw new IllegalArgumentException("O número romano informado não é válido. " +
                    "O maior valor decimal que pode ser convertido é 3999");
        }
        return decimal;
    }

    private static int getValorRomano(char romano) {
        for (int i = 0; i < romanos.length; i++) {
            if (romanos[i].length() == 1 && romanos[i].charAt(0) == romano) {
                return decimais[i];
            }
        }
        return -1;
    }
}