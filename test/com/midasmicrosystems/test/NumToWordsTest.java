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
        
        assertEquals("Error", numToWords.convertNumberToWord(100L), "one hundred");
        assertEquals("Error", numToWords.convertNumberToWord(21111121L), "twenty-one million one hundred and eleven thousand one hundred and twenty-one");
        assertEquals("Error", numToWords.convertNumberToWord(967332249L), "nine hundred and sixty-seven million three hundred and thirty-two thousand two hundred and fourty-nine");
        assertEquals("Error", numToWords.convertNumberToWord(18446744073709551L), "eighteen quadrillion four hundred and fourty-six trillion seven hundred and fourty-four billion seventy-three million seven hundred and nine thousand five hundred and fifty-one");
    }
}
