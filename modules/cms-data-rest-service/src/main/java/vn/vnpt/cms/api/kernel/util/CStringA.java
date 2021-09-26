// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.util;

import java.nio.ByteBuffer;

public class CStringA
{
    private final ByteBuffer buffer;
    
    public CStringA(final int length) {
        this(new byte[length], 0, length);
    }
    
    public CStringA(final byte[] buf, final int offs, final int length) {
        this.buffer = ByteBuffer.wrap(buf, offs, length).slice();
    }
    
    public CStringA copy(final String s) {
        if (s == null) {
            throw new NullPointerException("null s");
        }
        if (s.length() + 1 > this.buffer.capacity()) {
            throw new RuntimeException("string length over capacibility");
        }
        this.buffer.clear();
        this.buffer.put(s.getBytes());
        this.buffer.put((byte)0);
        return this;
    }
    
    public CStringA cat(final String s) {
        if (s == null) {
            throw new NullPointerException("null s");
        }
        this.buffer.clear();
        while (this.buffer.get() != 0) {}
        if (s.length() + 1 > this.buffer.remaining()) {
            throw new RuntimeException("string length over capacibility");
        }
        this.buffer.put(s.getBytes());
        this.buffer.put((byte)0);
        return this;
    }
    
    public String str() {
        this.buffer.clear();
        return readAnsiCString(this.buffer);
    }
    
    public static String readAnsiCString(final ByteBuffer buf) {
        final StringBuilder s = new StringBuilder();
        byte b = 0;
        while (buf.hasRemaining()) {
            b = buf.get();
            if (b == 0) {
                break;
            }
            s.append((char) NumberUtil.asUnsigned(b));
        }
        return s.toString();
    }
    
    public static void writeAnsiCString(final ByteBuffer buf, final String s) {
        if (buf.remaining() == 0) {
            return;
        }
        for (int i = 0; i < s.length() && buf.remaining() != 1; ++i) {
            buf.put((byte)s.charAt(i));
        }
        buf.put((byte)0);
    }
}
