// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.util;

public class NumberUtil
{
    public static short asUnsigned(final byte b) {
        short ret = b;
        if (ret < 0) {
            ret += 256;
        }
        return ret;
    }
    
    public static int asUnsigned(final short b) {
        int ret = b;
        if (ret < 0) {
            ret += 65536;
        }
        return ret;
    }
    
    public static int asUnsigned(final char b) {
        int ret = b;
        if (ret < 0) {
            ret += 65536;
        }
        return ret;
    }
    
    public static long asUnsigned(final int b) {
        long ret = b;
        if (ret < 0L) {
            ret += 4294967296L;
        }
        return ret;
    }
    
    public static int max(final int... args) {
        int max = Integer.MIN_VALUE;
        for (final int i : args) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }
    
    public static void main(final String[] args) {
        final short s = 7;
        final byte b = -1;
        System.out.println(String.format("%1$x", asUnsigned(b) << 8));
        final int v = b & 0xFFFFFFEF;
        final byte x = 16;
        System.out.println(s & 0xFF);
        System.out.println(String.format("%1$x", -33));
        System.out.println("byte " + asUnsigned((byte)(-1)));
        System.out.println("short " + (asUnsigned((short)(-1)) & 0xF));
        System.out.println("int " + asUnsigned(-1));
    }
}
