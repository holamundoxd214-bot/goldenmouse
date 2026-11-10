package kotlin.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u0015\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AH\u0086\u0080\u0004J\u0012\u0010\u001B\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\tH\u0082\u0080\u0004J\n\u0010\u001D\u001A\u00020\u0005H\u0082\u0080\u0004J\u001A\u0010\u001E\u001A\u00020\u00052\u0006\u0010\u001F\u001A\u00020\u00052\u0006\u0010 \u001A\u00020\u0005H\u0082\u0080\u0004J\u0012\u0010!\u001A\u00020\"2\u0006\u0010\u0019\u001A\u00020\u001AH\u0082\u0080\u0004J\n\u0010#\u001A\u00020\"H\u0082\u0080\u0004J\n\u0010$\u001A\u00020\"H\u0082\u0080\u0004R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0006\u001A\u00020\u0007X\u0082®\b¢\u0006\u0002\n\u0000R\u000F\u0010\b\u001A\u00020\tX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\n\u001A\u00020\u000BX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\f\u001A\u00020\rX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000E\u001A\u00020\u000FX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0010\u001A\u00020\u0011X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0013\u0010\u0012\u001A\u00060\u0013j\u0002`\u0014X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"Lkotlin/io/LineReader;", "", "<init>", "()V", "BUFFER_SIZE", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "bytes", "", "chars", "", "byteBuf", "Ljava/nio/ByteBuffer;", "charBuf", "Ljava/nio/CharBuffer;", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "decode", "endOfInput", "compactBytes", "decodeEndOfInput", "nBytes", "nChars", "updateCharset", "", "resetAll", "trimStringBuilder", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class LineReader {
    private static final int BUFFER_SIZE = 0x20;
    public static final LineReader INSTANCE;
    private static final ByteBuffer byteBuf;
    private static final byte[] bytes;
    private static final CharBuffer charBuf;
    private static final char[] chars;
    private static CharsetDecoder decoder;
    private static boolean directEOL;
    private static final StringBuilder sb;

    static {
        LineReader.INSTANCE = new LineReader();
        byte[] v1 = new byte[0x20];
        LineReader.bytes = v1;
        char[] v0 = new char[0x20];
        LineReader.chars = v0;
        ByteBuffer v1_1 = ByteBuffer.wrap(v1);
        Intrinsics.checkNotNullExpressionValue(v1_1, "wrap(...)");
        LineReader.byteBuf = v1_1;
        CharBuffer v0_1 = CharBuffer.wrap(v0);
        Intrinsics.checkNotNullExpressionValue(v0_1, "wrap(...)");
        LineReader.charBuf = v0_1;
        LineReader.sb = new StringBuilder();
    }

    private LineReader() {
        super();
    }

    private final int compactBytes() {
        ByteBuffer v2 = LineReader.byteBuf;
        v2.compact();
        int v0 = v2.position();
        v2.position(0);
        return v0;
    }

    private final int decode(boolean arg6) {
        while(true) {
            CharsetDecoder v0 = LineReader.decoder;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
                v0 = null;
            }

            ByteBuffer v1 = LineReader.byteBuf;
            CharBuffer v2 = LineReader.charBuf;
            CoderResult v0_1 = v0.decode(v1, v2, arg6);
            Intrinsics.checkNotNullExpressionValue(v0_1, "decode(...)");
            if(v0_1.isError()) {
                this.resetAll();
                v0_1.throwException();
            }

            int v1_1 = v2.position();
            if(!v0_1.isOverflow()) {
                return v1_1;
            }

            StringBuilder v0_2 = LineReader.sb;
            char[] v3 = LineReader.chars;
            --v1_1;
            v0_2.append(v3, 0, v1_1);
            v2.position(0);
            v2.limit(0x20);
            v2.put(v3[v1_1]);
        }
    }

    private final int decodeEndOfInput(int arg2, int arg3) {
        ByteBuffer v0 = LineReader.byteBuf;
        v0.limit(arg2);
        LineReader.charBuf.position(arg3);
        int v1 = this.decode(true);
        CharsetDecoder v2 = LineReader.decoder;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            v2 = null;
        }

        v2.reset();
        v0.position(0);
        return v1;
    }

    public final String readLine(InputStream arg10, Charset arg11) {
        String v10_2;
        String v0_5;
        StringBuilder v0_4;
        int v10_1;
        int v2;
        int v0_1;
        String v1;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg10, "inputStream");
            Intrinsics.checkNotNullParameter(arg11, "charset");
            CharsetDecoder v0 = LineReader.decoder;
            v1 = null;
            if(v0 != null) {
                if(v0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("decoder");
                    v0 = ((CharsetDecoder)v1);
                }

                if(Intrinsics.areEqual(v0.charset(), arg11)) {
                    goto label_16;
                }

                goto label_15;
            }
            else {
            label_15:
                this.updateCharset(arg11);
            }

        label_16:
            v0_1 = 0;
            v2 = 0;
            while(true) {
                int v3 = arg10.read();
                int v4 = 0x20;
                int v6 = 10;
                if(v3 == -1) {
                    break;
                }

                int v7 = v0_1 + 1;
                LineReader.bytes[v0_1] = ((byte)v3);
                if(v3 != v6 && v7 != v4) {
                    if(!LineReader.directEOL) {
                    }
                    else {
                        v0_1 = v7;
                        continue;
                    }
                }

                ByteBuffer v0_2 = LineReader.byteBuf;
                v0_2.limit(v7);
                LineReader.charBuf.position(v2);
                v2 = this.decode(false);
                if(v2 > 0 && LineReader.chars[v2 - 1] == v6) {
                    v0_2.position(0);
                    v10_1 = v2;
                    goto label_56;
                }

                v0_1 = this.compactBytes();
            }

            if(LineReader.sb.length() == 0) {
                goto label_27;
            }

            goto label_31;
        }
        catch(Throwable v10) {
            goto label_93;
        }

    label_27:
        if(v0_1 == 0 && v2 == 0) {
            __monitor_exit(this);
            return v1;
        }

        try {
        label_31:
            v10_1 = this.decodeEndOfInput(v0_1, v2);
        label_56:
            if(v10_1 > 0) {
                char[] v0_3 = LineReader.chars;
                if(v0_3[v10_1 - 1] == v6) {
                    int v1_1 = v10_1 - 1;
                    if(v1_1 > 0 && v0_3[v10_1 - 2] == 13) {
                        v10_1 += -2;
                        goto label_70;
                    }

                    v10_1 = v1_1;
                }
            }

        label_70:
            v0_4 = LineReader.sb;
            if(v0_4.length() != 0) {
                goto label_79;
            }

            v0_5 = new String(LineReader.chars, 0, v10_1);
        }
        catch(Throwable v10) {
            goto label_93;
        }

        __monitor_exit(this);
        return v0_5;
        try {
        label_79:
            v0_4.append(LineReader.chars, 0, v10_1);
            v10_2 = v0_4.toString();
            Intrinsics.checkNotNullExpressionValue(v10_2, "toString(...)");
            if(v0_4.length() > v4) {
                this.trimStringBuilder();
            }

            v0_4.setLength(0);
        }
        catch(Throwable v10) {
            goto label_93;
        }

        __monitor_exit(this);
        return v10_2;
        try {
        label_93:
            __monitor_exit(this);
        }
        catch(Throwable v10) {
            goto label_93;
        }

        throw v10;
    }

    private final void resetAll() {
        CharsetDecoder v1 = LineReader.decoder;
        if(v1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            v1 = null;
        }

        v1.reset();
        LineReader.byteBuf.position(0);
        LineReader.sb.setLength(0);
    }

    private final void trimStringBuilder() {
        StringBuilder v1 = LineReader.sb;
        v1.setLength(0x20);
        v1.trimToSize();
    }

    private final void updateCharset(Charset arg5) {
        CharsetDecoder v5 = arg5.newDecoder();
        Intrinsics.checkNotNullExpressionValue(v5, "newDecoder(...)");
        LineReader.decoder = v5;
        ByteBuffer v5_1 = LineReader.byteBuf;
        v5_1.clear();
        CharBuffer v0 = LineReader.charBuf;
        v0.clear();
        byte v1 = 10;
        v5_1.put(v1);
        v5_1.flip();
        CharsetDecoder v2 = LineReader.decoder;
        if(v2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            v2 = null;
        }

        boolean v3 = false;
        v2.decode(v5_1, v0, false);
        if(v0.position() == 1 && v0.get(0) == v1) {
            v3 = true;
        }

        LineReader.directEOL = v3;
        this.resetAll();
    }
}

