// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.util;

import java.io.IOException;
import java.nio.ByteBuffer;

public final class Hex
{
    private static final char[] DIGITS;
    
    static {
        DIGITS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    }
    
    private Hex() {
    }
    
    public static Appendable append(final Appendable a, final short in) {
        return append(a, (long)in, 4);
    }
    
    public static Appendable append(final Appendable a, final short in, final int length) {
        return append(a, (long)in, length);
    }
    
    public static Appendable append(final Appendable a, final int in) {
        return append(a, (long)in, 8);
    }
    
    public static Appendable append(final Appendable a, final int in, final int length) {
        return append(a, (long)in, length);
    }
    
    public static Appendable append(final Appendable a, final long in) {
        return append(a, in, 16);
    }
    
    public static Appendable append(final Appendable a, final long in, final int length) {
        try {
            for (int lim = (length << 2) - 4; lim >= 0; lim -= 4) {
                a.append(Hex.DIGITS[(byte)(in >> lim) & 0xF]);
            }
        }
        catch (IOException ex) {}
        return a;
    }
    
    public static Appendable append(final Appendable a, final byte[] bytes) {
        return append(a, ByteBuffer.wrap(bytes));
    }
    
    public static Appendable append(final Appendable a, final ByteBuffer bytes) {
        try {
            while (bytes.hasRemaining()) {
                final byte b = bytes.get();
                a.append(Hex.DIGITS[(byte)((b & 0xF0) >> 4)]);
                a.append(Hex.DIGITS[(byte)(b & 0xF)]);
            }
        }
        catch (IOException ex) {}
        return a;
    }
    
    public static long parseLong(final CharSequence s) {
        long out = 0L;
        byte shifts = 0;
        for (int i = 0; i < s.length() && shifts < 16; ++i) {
            final char c = s.charAt(i);
            if (c > '/' && c < ':') {
                ++shifts;
                out <<= 4;
                out |= c - '0';
            }
            else if (c > '@' && c < 'G') {
                ++shifts;
                out <<= 4;
                out |= c - '7';
            }
            else if (c > '`' && c < 'g') {
                ++shifts;
                out <<= 4;
                out |= c - 'W';
            }
        }
        return out;
    }
    
    public static short parseShort(final String s) {
        short out = 0;
        byte shifts = 0;
        for (int i = 0; i < s.length() && shifts < 4; ++i) {
            final char c = s.charAt(i);
            if (c > '/' && c < ':') {
                ++shifts;
                out <<= 4;
                out |= (short)(c - '0');
            }
            else if (c > '@' && c < 'G') {
                ++shifts;
                out <<= 4;
                out |= (short)(c - '7');
            }
            else if (c > '`' && c < 'g') {
                ++shifts;
                out <<= 4;
                out |= (short)(c - 'W');
            }
        }
        return out;
    }
    
    public static byte[] parseData(final String hexString) throws NumberFormatException {
        if (hexString == null) {
            throw new NullPointerException("Null string");
        }
        if (hexString.length() % 2 != 0) {
            throw new NumberFormatException("Not well form string");
        }
        final byte[] bs = new byte[hexString.length() / 2];
        for (int i = 0; i < bs.length; ++i) {
            bs[i] = hex2byte(hexString.charAt(2 * i), hexString.charAt(2 * i + 1));
        }
        return bs;
    }
    
    public static byte digit(final char digit) throws IllegalArgumentException {
        if (digit >= '0' && digit <= '9') {
            return (byte)(digit - '0');
        }
        if (digit >= 'A' && digit <= 'F') {
            return (byte)(digit - 'A' + 10);
        }
        if (digit >= 'a' && digit <= 'f') {
            return (byte)(digit - 'a' + 10);
        }
        throw new IllegalArgumentException(String.valueOf(digit) + " is not valid digit hex char");
    }
    
    private static byte hex2byte(final char high, final char low) {
        final byte highb = digit(high);
        final byte lowb = digit(low);
        return (byte)((highb << 4 & 0xF0) | (lowb & 0xF));
    }
}
