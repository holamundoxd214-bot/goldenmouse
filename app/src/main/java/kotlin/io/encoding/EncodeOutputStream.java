package kotlin.io.encoding;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\nH\u0016J \u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\nH\u0016J\b\u0010\u0015\u001A\u00020\u0010H\u0016J\b\u0010\u0016\u001A\u00020\u0010H\u0016J\"\u0010\u0017\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\nH\u0082\u0080\u0004J\n\u0010\u001A\u001A\u00020\u0010H\u0082\u0080\u0004J\"\u0010\u001B\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\nH\u0082\u0080\u0004J\n\u0010\u001C\u001A\u00020\u0010H\u0082\u0080\u0004R\u000F\u0010\u0002\u001A\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0003\u001A\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\bX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\t\u001A\u00020\nX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000B\u001A\u00020\fX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\r\u001A\u00020\fX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000E\u001A\u00020\nX\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Lkotlin/io/encoding/EncodeOutputStream;", "Ljava/io/OutputStream;", "output", "base64", "Lkotlin/io/encoding/Base64;", "<init>", "(Ljava/io/OutputStream;Lkotlin/io/encoding/Base64;)V", "isClosed", "", "lineLength", "", "symbolBuffer", "", "byteBuffer", "byteBufferLength", "write", "", "b", "source", "offset", "length", "flush", "close", "copyIntoByteBuffer", "startIndex", "endIndex", "encodeByteBufferIntoOutput", "encodeIntoOutput", "checkOpen", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class EncodeOutputStream extends OutputStream {
    private final Base64 base64;
    private final byte[] byteBuffer;
    private int byteBufferLength;
    private boolean isClosed;
    private int lineLength;
    private final OutputStream output;
    private final byte[] symbolBuffer;

    public EncodeOutputStream(OutputStream arg2, Base64 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "output");
        Intrinsics.checkNotNullParameter(arg3, "base64");
        super();
        this.output = arg2;
        this.base64 = arg3;
        int v2 = arg3.isMimeScheme$kotlin_stdlib() ? arg3.getMimeLineLength$kotlin_stdlib() : -1;
        this.lineLength = v2;
        this.symbolBuffer = new byte[0x400];
        this.byteBuffer = new byte[3];
    }

    private final void checkOpen() {
        if(!this.isClosed) {
            return;
        }

        throw new IOException("The output stream is closed.");
    }

    public void close() {
        if(!this.isClosed) {
            this.isClosed = true;
            if(this.byteBufferLength != 0) {
                this.encodeByteBufferIntoOutput();
            }

            this.output.close();
        }
    }

    private final int copyIntoByteBuffer(byte[] arg5, int arg6, int arg7) {
        arg7 = Math.min(3 - this.byteBufferLength, arg7 - arg6);
        ArraysKt.copyInto(arg5, this.byteBuffer, this.byteBufferLength, arg6, arg6 + arg7);
        int v5 = this.byteBufferLength + arg7;
        this.byteBufferLength = v5;
        if(v5 == 3) {
            this.encodeByteBufferIntoOutput();
        }

        return arg7;
    }

    private final void encodeByteBufferIntoOutput() {
        if(this.encodeIntoOutput(this.byteBuffer, 0, this.byteBufferLength) == 4) {
            this.byteBufferLength = 0;
            return;
        }

        throw new IllegalStateException("Check failed.");
    }

    private final int encodeIntoOutput(byte[] arg7, int arg8, int arg9) {
        int v7 = this.base64.encodeIntoByteArray(arg7, this.symbolBuffer, 0, arg8, arg9);
        if(this.lineLength == 0) {
            this.output.write(Base64.Default.getMimeLineSeparatorSymbols$kotlin_stdlib());
            this.lineLength = this.base64.getMimeLineLength$kotlin_stdlib();
            if(v7 <= this.base64.getMimeLineLength$kotlin_stdlib()) {
            }
            else {
                throw new IllegalStateException("Check failed.");
            }
        }

        this.output.write(this.symbolBuffer, 0, v7);
        this.lineLength -= v7;
        return v7;
    }

    public void flush() {
        this.checkOpen();
        this.output.flush();
    }

    public void write(int arg4) {
        this.checkOpen();
        byte[] v0 = this.byteBuffer;
        int v1 = this.byteBufferLength;
        int v2 = v1 + 1;
        this.byteBufferLength = v2;
        v0[v1] = ((byte)arg4);
        if(v2 == 3) {
            this.encodeByteBufferIntoOutput();
        }
    }

    public void write(byte[] arg5, int arg6, int arg7) {
        int v2;
        String v1;
        Intrinsics.checkNotNullParameter(arg5, "source");
        this.checkOpen();
        if(arg6 >= 0 && arg7 >= 0) {
            int v0 = arg6 + arg7;
            if(v0 <= arg5.length) {
                if(arg7 == 0) {
                }
                else {
                    arg7 = this.byteBufferLength;
                    v1 = "Check failed.";
                    v2 = 3;
                    if(arg7 < v2) {
                        if(arg7 != 0) {
                            arg6 += this.copyIntoByteBuffer(arg5, arg6, v0);
                            if(this.byteBufferLength != 0) {
                                return;
                            }
                        }

                        goto label_20;
                    }
                    else {
                        goto label_49;
                    }
                }

                return;
                while(true) {
                label_20:
                    if(arg6 + 3 > v0) {
                        goto label_43;
                    }

                    arg7 = this.base64.isMimeScheme$kotlin_stdlib() ? this.lineLength : this.symbolBuffer.length;
                    arg7 = Math.min(arg7 / 4, (v0 - arg6) / v2);
                    int v3 = arg7 * 3 + arg6;
                    if(this.encodeIntoOutput(arg5, arg6, v3) != arg7 * 4) {
                        break;
                    }

                    arg6 = v3;
                }

                throw new IllegalStateException(v1);
            label_43:
                ArraysKt.copyInto(arg5, this.byteBuffer, 0, arg6, v0);
                this.byteBufferLength = v0 - arg6;
                return;
            label_49:
                throw new IllegalStateException(v1);
            }
        }

        throw new IndexOutOfBoundsException("offset: " + arg6 + ", length: " + arg7 + ", source size: " + arg5.length);
    }
}

