package com.amanda.teste;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Unit test for simple App.
 */
public class ConversorRomanosToDecimalTest
{

    public void testConversaoSubtracao() {
        assertEquals(4, ConversorRomanos.romanoParaDecimal("IV"));
        assertEquals(9, ConversorRomanos.romanoParaDecimal("IX"));
        assertEquals(40, ConversorRomanos.romanoParaDecimal("XL"));
        assertEquals(49, ConversorRomanos.romanoParaDecimal("XLIX"));
        assertEquals(90, ConversorRomanos.romanoParaDecimal("XC"));
        assertEquals(99, ConversorRomanos.romanoParaDecimal("XCIX"));
        assertEquals(400, ConversorRomanos.romanoParaDecimal("CD"));
        assertEquals(499, ConversorRomanos.romanoParaDecimal("CDXCIX"));
        assertEquals(900, ConversorRomanos.romanoParaDecimal("CM"));
        assertEquals(999, ConversorRomanos.romanoParaDecimal("CMXCIX"));
        assertEquals(3994, ConversorRomanos.romanoParaDecimal("MMMCMXCIV"));
        assertEquals(3995, ConversorRomanos.romanoParaDecimal("MMMCMXCV"));
        assertEquals(3996, ConversorRomanos.romanoParaDecimal("MMMCMXCVI"));
        assertEquals(3997, ConversorRomanos.romanoParaDecimal("MMMCMXCVII"));
        assertEquals(3998, ConversorRomanos.romanoParaDecimal("MMMCMXCVIII"));
    }

    @Test
    public void testConversaoAdicao() {
        assertEquals(1, ConversorRomanos.romanoParaDecimal("I"));
        assertEquals(4, ConversorRomanos.romanoParaDecimal("IV"));
        assertEquals(6, ConversorRomanos.romanoParaDecimal("VI"));
        assertEquals(8, ConversorRomanos.romanoParaDecimal("VIII"));
        assertEquals(10, ConversorRomanos.romanoParaDecimal("X"));
        assertEquals(11, ConversorRomanos.romanoParaDecimal("XI"));
        assertEquals(12, ConversorRomanos.romanoParaDecimal("XII"));
        assertEquals(20, ConversorRomanos.romanoParaDecimal("XX"));
        assertEquals(21, ConversorRomanos.romanoParaDecimal("XXI"));
        assertEquals(50, ConversorRomanos.romanoParaDecimal("L"));
        assertEquals(55, ConversorRomanos.romanoParaDecimal("LV"));
        assertEquals(60, ConversorRomanos.romanoParaDecimal("LX"));
        assertEquals(70, ConversorRomanos.romanoParaDecimal("LXX"));
        assertEquals(80, ConversorRomanos.romanoParaDecimal("LXXX"));
        assertEquals(100, ConversorRomanos.romanoParaDecimal("C"));
    }

    @Test
    public void testRepeticoesMaioresQueTres() {
        // Teste para verificar se a repetição de caracteres maiores que três é proibida.
        // Espera-se que o método lance uma exceção.
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.romanoParaDecimal("IIII"));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.romanoParaDecimal("XXXX"));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.romanoParaDecimal("CCCC"));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.romanoParaDecimal("MMMM"));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.romanoParaDecimal("DDDD"));
    }

    @Test
    public void testRegrasIXLC() {
        // Teste para verificar se as regras específicas para I, X, L e C estão sendo respeitadas, incluindo subtração e não repetição.
        assertEquals(4, ConversorRomanos.romanoParaDecimal("IV"));    // 4
        assertEquals(60, ConversorRomanos.romanoParaDecimal("LX"));    // 60
        assertEquals(40, ConversorRomanos.romanoParaDecimal("XL"));   // 40
        assertEquals(90, ConversorRomanos.romanoParaDecimal("XC"));   // 90
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.romanoParaDecimal("IIII"));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.romanoParaDecimal("IXX"));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.romanoParaDecimal("LC"));
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.romanoParaDecimal("CLM"));
    }

    @Test
    public void testValorZero() {
        // Teste para verificar se uma mensagem é informada quando o valor decimal é igual a zero.
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.romanoParaDecimal("O valor '0' não pode ser convertido"));  // Valor romano inválido.
    }

    @Test
    public void testValorMaiorQueMaximo() {
        // Teste para verificar se um valor decimal maior que o maior valor correspondente em algarismos romanos lança uma exceção.
        assertThrows(IllegalArgumentException.class, () -> ConversorRomanos.romanoParaDecimal("MMMDDXCI"));  // maior que 3999.
    //
    }
}
