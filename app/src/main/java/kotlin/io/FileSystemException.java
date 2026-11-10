package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B)\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001A\u0004\u0018\u00010\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0017\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"Lkotlin/io/FileSystemException;", "Ljava/io/IOException;", "file", "Ljava/io/File;", "other", "reason", "", "<init>", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getOther", "getReason", "()Ljava/lang/String;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public class FileSystemException extends IOException {
    private final File file;
    private final File other;
    private final String reason;

    public FileSystemException(File arg2, File arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg2, "file");
        super(ExceptionsKt.access$constructMessage(arg2, arg3, arg4));
        this.file = arg2;
        this.other = arg3;
        this.reason = arg4;
    }

    public FileSystemException(File arg2, File arg3, String arg4, int arg5, DefaultConstructorMarker arg6) {
        File v0 = null;
        if((arg5 & 2) != 0) {
            arg3 = v0;
        }

        if((arg5 & 4) != 0) {
            arg4 = ((String)v0);
        }

        this(arg2, arg3, arg4);
    }

    public final File getFile() {
        return this.file;
    }

    public final File getOther() {
        return this.other;
    }

    public final String getReason() {
        return this.reason;
    }
}

