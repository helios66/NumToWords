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
package com.midasmicrosystems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Responsible for converting a given number to its word representation.
 *
 *
 * @author Adedayo Ominiyi(adedayoominiyi@gmail.com,
 * ominiyi_freeman@yahoo.co.uk)
 */
public class NumToWords {

    private final Map<Integer, String> placeHolders = new HashMap<Integer, String>() {
        {
            put(1, "thousand");
            put(2, "million");
            put(3, "billion");
            put(4, "trillion");
            put(5, "quadrillion");
            put(6, "quintillion");
        }
    };

    public String convertNumberToWord(long number) {
        StringBuilder stringRep = new StringBuilder();

        final int splitSize = 3;
        // Split the number into chunks of 3.
        List<String> chunks = splitStringIntoChunks(reverseString(String.valueOf(number)), splitSize);

        // Treat the chunks in reverse.
        int chunksSize = chunks.size();
        for (int i = (chunksSize - 1); i >= 0; i--) {
            boolean wordAppended = false;
            String strAtChunk = chunks.get(i);

            int threeDigitNumber = Integer.parseInt(strAtChunk, 10);

            int hundredth = threeDigitNumber / 100;
            if (hundredth > 0) {
                wordAppended = true;
                stringRep.append((" " + getWordRepresentationForNumber(hundredth)));
                stringRep.append(" hundred");
            }

            int tenth = threeDigitNumber % 100;
            // Pad with 'and' as necessary
            if ((tenth > 0) && (i == 0)) {
                if (hundredth > 0 || chunksSize > 1) {
                    stringRep.append(" and");

                }
            } else if ((tenth > 0) && (i > 0) && hundredth > 0) {
                stringRep.append(" and");
            }
            if ((tenth > 0) && (tenth <= 19)) {
                wordAppended = true;
                stringRep.append((" " + getWordRepresentationForNumber(tenth)));
            } else {
                // tenth is greater than or equal to twenty
                tenth = tenth / 10;
                if (tenth > 0) {
                    wordAppended = true;
                    stringRep.append((" " + getWordRepresentationForNumber(tenth * 10)));
                }
                int unit = (threeDigitNumber % 100) % 10;
                if (unit > 0 && tenth > 0) {
                    stringRep.append('-');
                }
                if (unit > 0) {
                    wordAppended = true;
                    stringRep.append(getWordRepresentationForNumber(unit));
                }
            }

            if (wordAppended) {
                stringRep.append((placeHolders.get(i) == null ? "" : (" " + placeHolders.get(i))));
            }
        }
        return stringRep.toString().trim();
    }

    private List splitStringIntoChunks(String originalString, int chunkSize) {
        int originalStringLength = originalString.length();
        List<String> chunks = new ArrayList<>();
        for (int i = 0; i < originalStringLength; i = i + chunkSize) {
            // Reverse the pieces before adding it to the collection so the 
            // numbers are in the right order.
            chunks.add(reverseString(originalString.substring(
                    i, Math.min(originalStringLength, (i + chunkSize)))));
        }

        return chunks;
    }

    private String reverseString(String originalString) {
        return new StringBuilder(originalString).reverse().toString();
    }

    private String getWordRepresentationForNumber(int number) {
        switch (number) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            case 20:
                return "twenty";
            case 30:
                return "thirty";
            case 40:
                return "fourty";
            case 50:
                return "fifty";
            case 60:
                return "sixty";
            case 70:
                return "seventy";
            case 80:
                return "eighty";
            case 90:
                return "ninety";
        }
        throw new IllegalArgumentException();
    }
}
