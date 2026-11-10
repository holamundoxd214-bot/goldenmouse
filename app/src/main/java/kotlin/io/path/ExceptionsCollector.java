package kotlin.io.path;

import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0013\bF\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0011H\u0086\u0080\u0004J\u0012\u0010\u0019\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0011H\u0086\u0080\u0004J\u0016\u0010\u001A\u001A\u00020\u00172\n\u0010\u001B\u001A\u00060\fj\u0002`\rH\u0086\u0080\u0004R\u000F\u0010\u0002\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001F\u0010\u0007\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0003@BX\u0086\u008E\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001F\u0010\n\u001A\f\u0012\b\u0012\u00060\fj\u0002`\r0\u000BX\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u001D\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001C"}, d2={"Lkotlin/io/path/ExceptionsCollector;", "", "limit", "", "<init>", "(I)V", "value", "totalExceptions", "getTotalExceptions", "()I", "collectedExceptions", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getCollectedExceptions", "()Ljava/util/List;", "path", "Ljava/nio/file/Path;", "getPath", "()Ljava/nio/file/Path;", "setPath", "(Ljava/nio/file/Path;)V", "enterEntry", "", "name", "exitEntry", "collect", "exception", "kotlin-stdlib-jdk7"}, k=1, mv={2, 3, 0}, xi=0x30) final class ExceptionsCollector {
    private final List collectedExceptions;
    private final int limit;
    private Path path;
    private int totalExceptions;

    public ExceptionsCollector() {
        this(0, 1, null);
    }

    public ExceptionsCollector(int arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 0x40;
        }

        this(arg1);
    }

    public ExceptionsCollector(int arg1) {
        super();
        this.limit = arg1;
        this.collectedExceptions = new ArrayList();
    }

    public final void collect(Exception arg3) {
        Throwable v3;
        Intrinsics.checkNotNullParameter(arg3, "exception");
        ++this.totalExceptions;
        if(this.collectedExceptions.size() < this.limit) {
            if(this.path != null) {
                v3 = new FileSystemException(String.valueOf(this.path)).initCause(((Throwable)arg3));
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type java.nio.file.FileSystemException");
            }

            this.collectedExceptions.add(v3);
        }
    }

    public final void enterEntry(Path arg2) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        Path v0 = this.path;
        arg2 = v0 != null ? v0.resolve(arg2) : null;
        this.path = arg2;
    }

    public final void exitEntry(Path arg3) {
        Intrinsics.checkNotNullParameter(arg3, "name");
        Path v0 = this.path;
        Path v1 = null;
        if(v0 != null) {
            v0 = v0.getFileName();
        }
        else {
            Object v0_1 = v1;
        }

        if(Intrinsics.areEqual(arg3, v0_1)) {
            arg3 = this.path;
            if(arg3 != null) {
                v1 = arg3.getParent();
            }

            this.path = v1;
            return;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final List getCollectedExceptions() {
        return this.collectedExceptions;
    }

    public final Path getPath() {
        return this.path;
    }

    public final int getTotalExceptions() {
        return this.totalExceptions;
    }

    public final void setPath(Path arg1) {
        this.path = arg1;
    }
}

