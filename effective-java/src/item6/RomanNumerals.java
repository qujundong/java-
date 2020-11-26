package item6;

import java.util.regex.Pattern;

public class RomanNumerals {

    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    static boolean isRomanNumeralNEG(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
    static boolean isRomanNumeralPOS(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        String string = "MCMXCIV";
        for(int i = 0; i < 1000000; i ++)
            isRomanNumeralNEG(string);
        System.out.println("the negtive simple time long : " + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i ++)
            isRomanNumeralPOS(string);
        System.out.println("the positive simple time long : " + (System.currentTimeMillis() - start2));
    }
}
/*
the negtive simple time long : 820
the positive simple time long : 111
 */