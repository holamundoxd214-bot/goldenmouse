package kotlin.io.path;

import java.nio.file.FileSystemException;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\bV\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\t¨\u0006\n"}, d2={"Lkotlin/io/path/IllegalFileNameException;", "Ljava/nio/file/FileSystemException;", "file", "Ljava/nio/file/Path;", "other", "message", "", "<init>", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/String;)V", "(Ljava/nio/file/Path;)V", "kotlin-stdlib-jdk7"}, k=1, mv={2, 3, 0}, xi=0x30) public final class IllegalFileNameException extends FileSystemException {
    public IllegalFileNameException(Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "file");
        this(arg2, null, null);
    }

    public IllegalFileNameException(Path arg2, Path arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg2, "file");
        String v2 = arg2.toString();
        String v3 = arg3 != null ? arg3.toString() : null;
        super(v2, v3, arg4);
    }
}

