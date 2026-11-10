package com.flyfishxu.kadb.shell;

import com.flyfishxu.kadb.stream.AdbStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.BufferedSink;
import okio.BufferedSource;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001A\u00020\bJ\u0006\u0010\t\u001A\u00020\nJ\u000E\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EJ\u000E\u0010\u000B\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0010J\u0006\u0010\u0011\u001A\u00020\fJ*\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00142\b\b\u0002\u0010\u0016\u001A\u00020\u00142\b\b\u0002\u0010\u0017\u001A\u00020\u0014J\u001A\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u00142\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u0010J\b\u0010\u001A\u001A\u00020\fH\u0016J\u0010\u0010\u001B\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u0014H\u0002J\u0018\u0010\u001C\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u001D\u001A\u00020\u0014H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Lcom/flyfishxu/kadb/shell/AdbShellStream;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "stream", "Lcom/flyfishxu/kadb/stream/AdbStream;", "<init>", "(Lcom/flyfishxu/kadb/stream/AdbStream;)V", "readAll", "Lcom/flyfishxu/kadb/shell/AdbShellResponse;", "read", "Lcom/flyfishxu/kadb/shell/AdbShellPacket;", "write", "", "string", "", "input", "", "closeStdin", "resize", "rows", "", "cols", "xPixels", "yPixels", "id", "payload", "close", "checkId", "checkLength", "length", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbShellStream implements AutoCloseable {
    private final AdbStream stream;

    public AdbShellStream(AdbStream arg2) {
        Intrinsics.checkNotNullParameter(arg2, "stream");
        super();
        this.stream = arg2;
    }

    private final int checkId(int arg2) {
        if(arg2 != 1 && arg2 != 2) {
            if(arg2 == 3) {
            }
            else {
                throw new IllegalStateException("Invalid shell packet id: " + arg2.toString());
            }
        }

        return arg2;
    }

    private final int checkLength(int arg1, int arg2) {
        if(arg2 >= 0) {
            if(arg1 == 3) {
                if(arg2 == 1) {
                }
                else {
                    throw new IllegalStateException("Shell exit packet does not have payload length == 1: " + arg2.toString());
                }
            }

            return arg2;
        }

        throw new IllegalStateException("Shell packet length must be >= 0: " + arg2.toString());
    }

    public void close() {
        this.stream.close();
    }

    public final void closeStdin() throws IOException {
        AdbShellStream.write$default(this, 4, null, 2, null);
    }

    public final AdbShellPacket read() throws IOException {
        BufferedSource v0 = this.stream.getSource();
        int v1 = this.checkId(v0.readByte());
        byte[] v4 = v0.readByteArray(((long)this.checkLength(v1, v0.readIntLe())));
        if(v1 != 1) {
            if(v1 != 2) {
                if(v1 == 3) {
                    return new Exit(v4);
                }

                throw new IllegalArgumentException("Invalid shell packet id: " + v1);
            }

            return new StdError(v4);
        }

        return new StdOut(v4);
    }

    public final AdbShellResponse readAll() throws IOException {
        AdbShellPacket v2;
        StringBuilder v0 = new StringBuilder();
        StringBuilder v1 = new StringBuilder();
        while(true) {
            v2 = this.read();
            if((v2 instanceof Exit)) {
                goto label_7;
            }

            if((v2 instanceof StdOut)) {
                v0.append(new String(((StdOut)v2).getPayload(), Charsets.UTF_8));
                continue;
            }

            if(!(v2 instanceof StdError)) {
                break;
            }

            v1.append(new String(((StdError)v2).getPayload(), Charsets.UTF_8));
        }

        throw new NoWhenBranchMatchedException();
    label_7:
        int v5 = UByte.constructor-impl(((Exit)v2).getPayload()[0]) & 0xFF;
        String v0_1 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v0_1, "toString(...)");
        String v1_1 = v1.toString();
        Intrinsics.checkNotNullExpressionValue(v1_1, "toString(...)");
        return new AdbShellResponse(v0_1, v1_1, v5);
    }

    public final void resize(int arg2, int arg3, int arg4, int arg5) throws IOException {
        this.write(5, StringsKt.encodeToByteArray(arg2 + "x" + arg3 + "," + arg4 + "x" + arg5));
    }

    public static void resize$default(AdbShellStream arg1, int arg2, int arg3, int arg4, int arg5, int arg6, Object arg7) throws IOException {
        arg1.resize(arg2, arg3, 0, 0);
    }

    public final void write(String arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "string");
        byte[] v2 = arg2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(v2, "getBytes(...)");
        this.write(v2);
    }

    public final void write(byte[] arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "input");
        this.write(0, arg2);
    }

    public final void write(int arg1, byte[] arg2) throws IOException {
        BufferedSink v0 = this.stream.getSink();
        v0.writeByte(arg1);
        arg1 = arg2 != null ? arg2.length : 0;
        v0.writeIntLe(arg1);
        if(arg2 != null) {
            v0.write(arg2);
        }

        v0.flush();
    }

    public static void write$default(AdbShellStream arg0, int arg1, byte[] arg2, int arg3, Object arg4) throws IOException {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        arg0.write(arg1, arg2);
    }
}

