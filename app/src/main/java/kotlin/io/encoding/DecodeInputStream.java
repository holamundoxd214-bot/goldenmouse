package kotlin.io.encoding;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u000B\b\u0003\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0014\u001A\u00020\u000FH\u0016J \u0010\u0014\u001A\u00020\u000F2\u0006\u0010\u0015\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\u000FH\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016J*\u0010\u001A\u001A\u00020\u000F2\u0006\u0010\u001B\u001A\u00020\u000B2\u0006\u0010\u001C\u001A\u00020\u000F2\u0006\u0010\u001D\u001A\u00020\u000F2\u0006\u0010\u001E\u001A\u00020\u000FH\u0082\u0080\u0004J\"\u0010\u001F\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u000B2\u0006\u0010\u001C\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\u000FH\u0082\u0080\u0004J\n\u0010 \u001A\u00020\u0019H\u0082\u0080\u0004J\n\u0010!\u001A\u00020\u0019H\u0082\u0080\u0004J\u0012\u0010\"\u001A\u00020\u000F2\u0006\u0010\u001E\u001A\u00020\u000FH\u0082\u0080\u0004J\n\u0010#\u001A\u00020\u000FH\u0082\u0080\u0004R\u000F\u0010\u0002\u001A\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0003\u001A\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\bX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\t\u001A\u00020\bX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\n\u001A\u00020\u000BX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\f\u001A\u00020\u000BX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\r\u001A\u00020\u000BX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000E\u001A\u00020\u000FX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0010\u001A\u00020\u000FX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0011\u001A\u00020\u000F8BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006$"}, d2={"Lkotlin/io/encoding/DecodeInputStream;", "Ljava/io/InputStream;", "input", "base64", "Lkotlin/io/encoding/Base64;", "<init>", "(Ljava/io/InputStream;Lkotlin/io/encoding/Base64;)V", "isClosed", "", "isEOF", "singleByteBuffer", "", "symbolBuffer", "byteBuffer", "byteBufferStartIndex", "", "byteBufferEndIndex", "byteBufferLength", "getByteBufferLength", "()I", "read", "destination", "offset", "length", "close", "", "decodeSymbolBufferInto", "dst", "dstOffset", "dstEndIndex", "symbolBufferLength", "copyByteBufferInto", "resetByteBufferIfEmpty", "shiftByteBufferToStartIfNeeded", "handlePaddingSymbol", "readNextSymbol", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class DecodeInputStream extends InputStream {
    private final Base64 base64;
    private final byte[] byteBuffer;
    private int byteBufferEndIndex;
    private int byteBufferStartIndex;
    private final InputStream input;
    private boolean isClosed;
    private boolean isEOF;
    private final byte[] singleByteBuffer;
    private final byte[] symbolBuffer;

    public DecodeInputStream(InputStream arg2, Base64 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        Intrinsics.checkNotNullParameter(arg3, "base64");
        super();
        this.input = arg2;
        this.base64 = arg3;
        this.singleByteBuffer = new byte[1];
        this.symbolBuffer = new byte[0x400];
        this.byteBuffer = new byte[0x400];
    }

    public void close() {
        if(!this.isClosed) {
            this.isClosed = true;
            this.input.close();
        }
    }

    private final void copyByteBufferInto(byte[] arg4, int arg5, int arg6) {
        ArraysKt.copyInto(this.byteBuffer, arg4, arg5, this.byteBufferStartIndex, this.byteBufferStartIndex + arg6);
        this.byteBufferStartIndex += arg6;
        this.resetByteBufferIfEmpty();
    }

    private final int decodeSymbolBufferInto(byte[] arg7, int arg8, int arg9, int arg10) {
        this.byteBufferEndIndex += this.base64.decodeIntoByteArray(this.symbolBuffer, this.byteBuffer, this.byteBufferEndIndex, 0, arg10);
        arg9 = Math.min(this.getByteBufferLength(), arg9 - arg8);
        this.copyByteBufferInto(arg7, arg8, arg9);
        this.shiftByteBufferToStartIfNeeded();
        return arg9;
    }

    private final int getByteBufferLength() {
        return this.byteBufferEndIndex - this.byteBufferStartIndex;
    }

    private final int handlePaddingSymbol(int arg4) {
        this.symbolBuffer[arg4] = 61;
        int v1 = 2;
        if((arg4 & 3) == v1) {
            int v0 = this.readNextSymbol();
            if(v0 >= 0) {
                this.symbolBuffer[arg4 + 1] = ((byte)v0);
            }

            return arg4 + v1;
        }

        return arg4 + 1;
    }

    public int read() {
        int v0 = this.byteBufferStartIndex;
        if(v0 < this.byteBufferEndIndex) {
            int v1 = this.byteBuffer[v0] & 0xFF;
            this.byteBufferStartIndex = v0 + 1;
            this.resetByteBufferIfEmpty();
            return v1;
        }

        v0 = this.read(this.singleByteBuffer, 0, 1);
        int v3 = -1;
        if(v0 != v3) {
            if(v0 == 1) {
                return this.singleByteBuffer[0] & 0xFF;
            }

            throw new IllegalStateException("Unreachable".toString());
        }

        return v3;
    }

    public int read(byte[] arg10, int arg11, int arg12) {
        Intrinsics.checkNotNullParameter(arg10, "destination");
        if(arg11 >= 0 && arg12 >= 0) {
            int v0 = arg11 + arg12;
            if(v0 <= arg10.length) {
                if(!this.isClosed) {
                    int v2 = -1;
                    if(this.isEOF) {
                        return v2;
                    }
                    else if(arg12 == 0) {
                        return 0;
                    }
                    else if(this.getByteBufferLength() >= arg12) {
                        this.copyByteBufferInto(arg10, arg11, arg12);
                        return arg12;
                    }
                    else {
                        arg12 = (arg12 - this.getByteBufferLength() + 2) / 3 * 4;
                        int v3 = arg11;
                        while(true) {
                            boolean v4 = this.isEOF;
                            if(!v4 && arg12 > 0) {
                                int v4_1 = Math.min(this.symbolBuffer.length, arg12);
                                int v5 = 0;
                                while(true) {
                                    boolean v6 = this.isEOF;
                                    if(!v6 && v5 < v4_1) {
                                        int v6_1 = this.readNextSymbol();
                                        if(v6_1 == v2) {
                                            this.isEOF = true;
                                        }
                                        else if(v6_1 != 61) {
                                            this.symbolBuffer[v5] = ((byte)v6_1);
                                            ++v5;
                                        }
                                        else {
                                            v5 = this.handlePaddingSymbol(v5);
                                            this.isEOF = true;
                                        }

                                        continue;
                                    }

                                    break;
                                }

                                if(!v6) {
                                    if(v5 == v4_1) {
                                    }
                                    else {
                                        throw new IllegalStateException("Check failed.");
                                    }
                                }

                                arg12 -= v5;
                                v3 += this.decodeSymbolBufferInto(arg10, v3, v0, v5);
                                continue;
                            }

                            break;
                        }

                        if(v3 == arg11 && (v4)) {
                            return v2;
                        }

                        return v3 - arg11;
                    }
                }
                else {
                    throw new IOException("The input stream is closed.");
                }
            }
        }

        throw new IndexOutOfBoundsException("offset: " + arg11 + ", length: " + arg12 + ", buffer size: " + arg10.length);
    }

    private final int readNextSymbol() {
        int v0;
        if(!this.base64.isMimeScheme$kotlin_stdlib()) {
            return this.input.read();
        }

        do {
            v0 = this.input.read();
            if(v0 == -1) {
                return v0;
            }
        }
        while(!Base64Kt.isInMimeAlphabet(v0));

        return v0;
    }

    private final void resetByteBufferIfEmpty() {
        if(this.byteBufferStartIndex == this.byteBufferEndIndex) {
            this.byteBufferStartIndex = 0;
            this.byteBufferEndIndex = 0;
        }
    }

    private final void shiftByteBufferToStartIfNeeded() {
        byte[] v0 = this.byteBuffer;
        int v1 = v0.length;
        int v2 = this.byteBufferEndIndex;
        if(this.symbolBuffer.length / 4 * 3 > v1 - v2) {
            ArraysKt.copyInto(v0, v0, 0, this.byteBufferStartIndex, v2);
            this.byteBufferEndIndex -= this.byteBufferStartIndex;
            this.byteBufferStartIndex = 0;
        }
    }
}

