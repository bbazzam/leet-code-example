package leetcode.examples;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Zigzag
{


    @Test
    public void test() {

        String result = convert("PAYPALISHIRING", 3);
        System.out.println(result);
        assertTrue(result.equals("PAHNAPLSIIGYIR"));
    }

    @Test
    public void test2() {

        String result = convert("PAYPALISHIRING", 4);
        System.out.println(result);
        assertTrue(result.equals("PINALSIGYAHRPI"));

    }
    @Test
    public void test3() {

        String result = convert("AB", 1);
        System.out.println(result);
        assertTrue(result.equals("AB"));

    }

    @Test
    public void test4() {

        String result = convert("ABCD", 2);
        System.out.println(result);
        assertTrue(result.equals("ACBD"));

    }
    @Test
    public void test5() {

        String result = convert("SONYISHIRING", 3);
        System.out.println(result);
        assertTrue(result.equals("SIROYSIIGNHN"));

    }

    @Test
    public void test6() {

        String result = convert("SONYISHIRING", 4);
        System.out.println(result);
        assertTrue(result.equals("SIROYSIIGNHN"));

    }

//  --------------------------------
//    Code Starts
//  --------------------------------

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        int colIndex = 0;
        Integer stringIndex = 0;

        for (int i = 0 ; i < numRows; i++ ){
            rows[i] = new StringBuilder();
        }

        int up = 0;
        for (; stringIndex < s.length(); stringIndex++) {
            if (stringIndex == 0 || up <= 0) {  // At Top Drive down
                down(rows, s, stringIndex, numRows);
                if (numRows == 2) { // Zig Zag 2 rows so only down no middle
                    stringIndex += numRows -1;
                    continue;
                }
                stringIndex += numRows;
                up = numRows - 2;
            }

            if ((stringIndex < s.length() && up >= 0)) {
                rows[up].append(s.charAt(stringIndex));
                up -=  1;
            }
        }

        StringBuilder response =new StringBuilder();
        for (int i = 0 ; i < numRows; i++ ){
            response.append(rows[i].toString());
        }

        return response.toString();
    }

    public void down(StringBuilder[] rows, String s, int stringIndex, int numRows) {
        int rowIndex = 0;
        int maxdown = stringIndex + numRows;
        for (int i = stringIndex; i < s.length() && i < maxdown;  i++) {
            rows[rowIndex++].append(s.charAt(i));
        }
    }

}


