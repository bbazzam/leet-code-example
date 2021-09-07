package leetcode.examples;

import org.junit.Test;

public class ReverseInteger {

    @Test
    public void example1(){
        int res = reverse(123);
        assert(res == 321);
    }
    @Test
    public void example2(){
        int res = reverse(-123);
        assert(res == -321);
    }
    @Test
    public void example3(){
        int res = reverse(0);
        assert(res == 0);
    }

    public int reverse(Integer x) {
        if (x == 0) {
            return 0;
        } else if (x < 0) {
            return -1*(reverseIt(Math.abs(x)));
        } else {
            return reverseIt(x);
        }
    }

    public int reverseIt(int x) {
        String s = String.valueOf(x);
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length / 2; i ++) {
            //swap
            char swap = charArray[i];
            charArray[i] = charArray[charArray.length -1 - i];
            charArray[charArray.length -1 - i] = swap;
        }
        try {
            return  Integer.valueOf(new String(charArray));
        } catch (Exception e) {
            return 0;
        }

    }

}
