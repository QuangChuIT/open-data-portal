// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.textbase;

import java.util.Random;

public class StringGenerator
{
    private static final Random random;
    private static final char[] chars;
    private static final char[] digits;
    
    static {
        random = new Random();
        digits = "0123456789".toCharArray();
        chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }
    
    public static String randomCharacters(final int length) {
        final char[] buf = new char[length];
        for (int idx = 0; idx < length; ++idx) {
            buf[idx] = StringGenerator.chars[StringGenerator.random.nextInt(StringGenerator.chars.length)];
        }
        return new String(buf);
    }
    
    public static void main(final String[] args) {
        char[] chars;
        for (int length = (chars = StringGenerator.chars).length, i = 0; i < length; ++i) {
            final char s = chars[i];
            System.out.print(s);
        }
    }
    
    public static String randomDigits(final int length) {
        if (length <= 0) {
            return "";
        }
        final char[] buf = new char[length];
        for (int idx = 0; idx < length; ++idx) {
            buf[idx] = StringGenerator.digits[StringGenerator.random.nextInt(StringGenerator.digits.length)];
        }
        return new String(buf);
    }
}
