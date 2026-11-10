package com.flyfishxu.kadb.shell;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001A\u00020\bJ\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fJ\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\rJ\u0006\u0010\u000E\u001A\u00020\nJ*\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0013\u001A\u00020\u00112\b\b\u0002\u0010\u0014\u001A\u00020\u0011J\b\u0010\u0015\u001A\u00020\nH\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Lcom/flyfishxu/kadb/shell/AdbPtyShellSession;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "shell", "Lcom/flyfishxu/kadb/shell/AdbShellStream;", "<init>", "(Lcom/flyfishxu/kadb/shell/AdbShellStream;)V", "read", "Lcom/flyfishxu/kadb/shell/AdbShellPacket;", "write", "", "input", "", "", "closeStdin", "resize", "rows", "", "cols", "xPixels", "yPixels", "close", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbPtyShellSession implements AutoCloseable {
    private final AdbShellStream shell;

    public AdbPtyShellSession(AdbShellStream arg2) {
        Intrinsics.checkNotNullParameter(arg2, "shell");
        super();
        this.shell = arg2;
    }

    public void close() {
        this.shell.close();
    }

    public final void closeStdin() throws IOException {
        this.shell.closeStdin();
    }

    public final AdbShellPacket read() throws IOException {
        return this.shell.read();
    }

    public final void resize(int arg1, int arg2, int arg3, int arg4) throws IOException {
        this.shell.resize(arg1, arg2, arg3, arg4);
    }

    public static void resize$default(AdbPtyShellSession arg1, int arg2, int arg3, int arg4, int arg5, int arg6, Object arg7) throws IOException {
        arg1.resize(arg2, arg3, 0, 0);
    }

    public final void write(String arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "input");
        this.shell.write(arg2);
    }

    public final void write(byte[] arg2) throws IOException {
        Intrinsics.checkNotNullParameter(arg2, "input");
        this.shell.write(arg2);
    }
}

