/*
Copyright 2013 Midas Microsystems

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.midasmicrosystems.test;

import com.midasmicrosystems.NumToWords;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit Test for the NumToWords Class.
 * 
 * 
 * @author Adedayo Ominiyi(adedayoominiyi@gmail.com, ominiyi_freeman@yahoo.co.uk)
 */
public class NumToWordsTest {
    
    public NumToWordsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testConvertNumberToWord() {
        NumToWords numToWords = new NumToWords();
        
        assertEquals("Error", "one", numToWords.convertNumberToWord(1L));
        
        assertEquals("Error", "ten", numToWords.convertNumberToWord(10L));
        
        assertEquals("Error", "one hundred", numToWords.convertNumberToWord(100L));
        
        assertEquals("Error", "one thousand", numToWords.convertNumberToWord(1000L));
        assertEquals("Error", "seven thousand", numToWords.convertNumberToWord(7000L));
        assertEquals("Error", "ten thousand", numToWords.convertNumberToWord(10000L));
        assertEquals("Error", "seventy thousand", numToWords.convertNumberToWord(70000L));
        assertEquals("Error", "seventy-seven thousand", numToWords.convertNumberToWord(77000L));
        assertEquals("Error", "one hundred thousand", numToWords.convertNumberToWord(100000L));
        
        assertEquals("Error", "one million", numToWords.convertNumberToWord(1000000L));
        assertEquals("Error", "ten million", numToWords.convertNumberToWord(10000000L));
        assertEquals("Error", "one hundred million", numToWords.convertNumberToWord(100000000L));
        assertEquals("Error", "twenty-one million one hundred and eleven thousand one hundred and twenty-one", numToWords.convertNumberToWord(21111121L));
        assertEquals("Error", "seven hundred million and fifty-six", numToWords.convertNumberToWord(700000056L));
        assertEquals("Error", "nine hundred and sixty-seven million three hundred and thirty-two thousand two hundred and fourty-nine", numToWords.convertNumberToWord(967332249L));
        
        assertEquals("Error", "one billion", numToWords.convertNumberToWord(1000000000L));
        assertEquals("Error", "ten billion", numToWords.convertNumberToWord(10000000000L));
        assertEquals("Error", "seventy billion sixty-seven million five thousand six hundred and eighty-nine", numToWords.convertNumberToWord(70067005689L));
        assertEquals("Error", "one hundred billion", numToWords.convertNumberToWord(100000000000L));
        
        assertEquals("Error", "seven trillion six billion seven hundred million five hundred and sixty-eight thousand nine hundred and ninety", numToWords.convertNumberToWord(7006700568990L));
        assertEquals("Error", "seven hundred trillion six hundred and seventy billion fifty-six million eight hundred and ninety-nine thousand and thirty-four", numToWords.convertNumberToWord(700670056899034L));
        
        assertEquals("Error", "eighteen quadrillion four hundred and fourty-six trillion seven hundred and fourty-four billion seventy-three million seven hundred and nine thousand five hundred and fifty-one", numToWords.convertNumberToWord(18446744073709551L));
    }
}
