// 
// Decompiled by Procyon v0.5.36
// 

package vn.vnpt.cms.api.kernel.util;

import java.io.IOException;
import java.nio.ByteBuffer;

public final class HexStringBuilder implements Appendable
{
    private final Appendable appender;
    private static final char[] DIGITS;
    
    static {
        DIGITS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    }
    
    public HexStringBuilder(Appendable appender) {
        if (appender == null) {
            appender = new StringBuilder();
        }
        this.appender = appender;
    }
    
    public HexStringBuilder append(final short in) {
        return this.append(in, 4);
    }
    
    public HexStringBuilder append(final short in, final int length) {
        return this.append(in, length);
    }
    
    public HexStringBuilder append(final int in) {
        return this.append(in, 8);
    }
    
    public HexStringBuilder append(final Appendable a, final int in, final int length) {
        return this.append(in, length);
    }
    
    public HexStringBuilder append(final long in) {
        return this.append(in, 16);
    }
    
    public HexStringBuilder append(final long in, final int length) {
        try {
            for (int lim = (length << 2) - 4; lim >= 0; lim -= 4) {
                this.appender.append(HexStringBuilder.DIGITS[(byte)(in >> lim) & 0xF]);
            }
        }
        catch (IOException ex) {}
        return this;
    }
    
    public HexStringBuilder append(final byte[] bytes) {
        return this.append(ByteBuffer.wrap(bytes));
    }
    
    public HexStringBuilder append(final ByteBuffer bytes) {
        try {
            while (bytes.hasRemaining()) {
                final byte b = bytes.get();
                this.appender.append(HexStringBuilder.DIGITS[(byte)((b & 0xF0) >> 4)]);
                this.appender.append(HexStringBuilder.DIGITS[(byte)(b & 0xF)]);
            }
        }
        catch (IOException ex) {}
        return this;
    }
    
    @Override
    public String toString() {
        return this.appender.toString();
    }
    
    public HexStringBuilder() {
        this(null);
    }
    
    @Override
    public Appendable append(final CharSequence csq) throws IOException {
        this.appender.append(csq);
        return this;
    }
    
    @Override
    public Appendable append(final CharSequence csq, final int start, final int end) throws IOException {
        this.appender.append(csq, start, end);
        return this;
    }
    
    @Override
    public Appendable append(final char c) throws IOException {
        this.appender.append(c);
        return this;
    }
}
