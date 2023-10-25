package com.amanda.teste;

import org.junit.Test;
import static org.junit.Assert.*;
public class ConversorDecimalToRomanosTest {
    @Test
    public void testSubtracao() {
        // Teste de conversão de números decimais para romanos com subtração.
        assertEquals("IV", ConversorRomanos.decimalParaRomano(4));     // 4
        assertEquals("IX", ConversorRomanos.decimalParaRomano(9));     // 9
        assertEquals("XL", ConversorRomanos.decimalParaRomano(40));    // 40
        assertEquals("XC", ConversorRomanos.decimalParaRomano(90));    // 90
        assertEquals("CD", ConversorRomanos.decimalParaRomano(400));   // 400
        assertEquals("CM", ConversorRomanos.decimalParaRomano(900));   // 900
        assertEquals("CMXC", ConversorRomanos.decimalParaRomano(990)); // 990
        assertEquals("CMXCIV", ConversorRomanos.decimalParaRomano(994));// 994
        assertEquals("CMXCIX", ConversorRomanos.decimalParaRomano(999));// 999
        assertEquals("CDXC", ConversorRomanos.decimalParaRomano(490)); // 490
    }

    @Test
    public void testAdicao() {
        // Teste de conversão de números decimais para romanos com adição.
        assertEquals("XIII", ConversorRomanos.decimalParaRomano(13));     // 13
        assertEquals("XXV", ConversorRomanos.decimalParaRomano(25));      // 25
        assertEquals("XXXVIII", ConversorRomanos.decimalParaRomano(38));  // 38
        assertEquals("LXII", ConversorRomanos.decimalParaRomano(62));     // 62
        assertEquals("LXXX", ConversorRomanos.decimalParaRomano(80));     // 80
        assertEquals("CXXV", ConversorRomanos.decimalParaRomano(125));    // 125
        assertEquals("CCXL", ConversorRomanos.decimalParaRomano(240));    // 240
        assertEquals("DCCC", ConversorRomanos.decimalParaRomano(800));    // 800
        assertEquals("CM", ConversorRomanos.decimalParaRomano(900));      // 900
        assertEquals("MCMXCVI", ConversorRomanos.decimalParaRomano(1996));// 1996
    }

    @Test
    public void testValoresNegativos() {
        // Teste para verificar se uma exceção é lançada quando o valor decimal é menor que zero.
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.decimalParaRomano(-1));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.decimalParaRomano(-5));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.decimalParaRomano(-10));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.decimalParaRomano(-50));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.decimalParaRomano(-100));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.decimalParaRomano(-500));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.decimalParaRomano(-1000));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.decimalParaRomano(-3999));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.decimalParaRomano(-5000));
    }

    @Test
    public void testValorMaiorQueMaximo() {
        // Teste para verificar se um valor decimal maior que o maior valor correspondente em algarismos romanos lança uma exceção.
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.decimalParaRomano(4000));  // (maior que 3999).
        //
    }
}
