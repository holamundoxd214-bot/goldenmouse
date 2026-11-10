package okio;

import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0014J\b\u0010\f\u001A\u00020\u000BH\u0014J(\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\u000EH\u0014J(\u0010\u0014\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0013\u001A\u00020\u000EH\u0014J\b\u0010\u0015\u001A\u00020\tH\u0014J\b\u0010\u0016\u001A\u00020\tH\u0014R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Lokio/JvmFileHandle;", "Lokio/FileHandle;", "readWrite", "", "randomAccessFile", "Ljava/io/RandomAccessFile;", "<init>", "(ZLjava/io/RandomAccessFile;)V", "protectedResize", "", "size", "", "protectedSize", "protectedRead", "", "fileOffset", "array", "", "arrayOffset", "byteCount", "protectedWrite", "protectedFlush", "protectedClose", "okio"}, k=1, mv={2, 1, 0}, xi=0x30) public final class JvmFileHandle extends FileHandle {
    private final RandomAccessFile randomAccessFile;

    public JvmFileHandle(boolean arg2, RandomAccessFile arg3) {
        Intrinsics.checkNotNullParameter(arg3, "randomAccessFile");
        super(arg2);
        this.randomAccessFile = arg3;
    }

    protected void protectedClose() {
        __monitor_enter(this);
        try {
            this.randomAccessFile.close();
        }
        catch(Throwable v0) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_6;
            }

            throw v0;
        }

        __monitor_exit(this);
    }

    protected void protectedFlush() {
        __monitor_enter(this);
        try {
            this.randomAccessFile.getFD().sync();
        }
        catch(Throwable v0) {
            try {
            label_7:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_7;
            }

            throw v0;
        }

        __monitor_exit(this);
    }

    protected int protectedRead(long arg2, byte[] arg4, int arg5, int arg6) {
        int v0;
        int v3;
        int v2_1;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg4, "array");
            this.randomAccessFile.seek(arg2);
            v2_1 = 0;
            while(true) {
            label_6:
                if(v2_1 < arg6) {
                    v3 = this.randomAccessFile.read(arg4, arg5, arg6 - v2_1);
                    v0 = -1;
                    if(v3 == v0) {
                        break;
                    }
                    else {
                        goto label_15;
                    }
                }

                goto label_17;
            }
        }
        catch(Throwable v2) {
            goto label_20;
        }

        if(v2_1 == 0) {
            __monitor_exit(this);
            return v0;
        label_15:
            v2_1 += v3;
            goto label_6;
        }

    label_17:
        __monitor_exit(this);
        return v2_1;
        try {
        label_20:
            __monitor_exit(this);
        }
        catch(Throwable v2) {
            goto label_20;
        }

        throw v2;
    }

    protected void protectedResize(long arg8) {
        JvmFileHandle v1;
        byte[] v4;
        int v6;
        long v2;
        __monitor_enter(this);
        try {
            v2 = this.size();
            long v0_1 = arg8 - v2;
            if(v0_1 > 0) {
                v6 = ((int)v0_1);
                v4 = new byte[v6];
                v1 = this;
            }
            else {
                goto label_11;
            }
        }
        catch(Throwable v0) {
            goto label_17;
        }

        try {
            v1.protectedWrite(v2, v4, 0, v6);
            goto label_14;
        label_11:
            v1 = this;
            v1.randomAccessFile.setLength(arg8);
        }
        catch(Throwable v0) {
            goto label_18;
        }

    label_14:
        __monitor_exit(v1);
        return;
    label_17:
        v1 = this;
    label_18:
        Throwable v7 = v0;
        try {
            __monitor_exit(v1);
        }
        catch(Throwable v0) {
            goto label_18;
        }

        throw v7;
    }

    protected long protectedSize() {
        long v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.randomAccessFile.length();
        }
        catch(Throwable v0) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_6;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    protected void protectedWrite(long arg2, byte[] arg4, int arg5, int arg6) {
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg4, "array");
            this.randomAccessFile.seek(arg2);
            this.randomAccessFile.write(arg4, arg5, arg6);
        }
        catch(Throwable v2) {
            try {
            label_10:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_10;
            }

            throw v2;
        }

        __monitor_exit(this);
    }
}

