package com.flyfishxu.kadb.stream;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000F\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0011R\u0015\u0010\t\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2={"Lcom/flyfishxu/kadb/stream/AdbSyncDirEntry;", "", "name", "", "mode", "", "size", "", "mtimeSec", "errorCode", "<init>", "(Ljava/lang/String;IJJLjava/lang/Integer;)V", "getName", "()Ljava/lang/String;", "getMode", "()I", "getSize", "()J", "getMtimeSec", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbSyncDirEntry {
    private final Integer errorCode;
    private final int mode;
    private final long mtimeSec;
    private final String name;
    private final long size;

    public AdbSyncDirEntry(String arg2, int arg3, long arg4, long arg6, Integer arg8) {
        Intrinsics.checkNotNullParameter(arg2, "name");
        super();
        this.name = arg2;
        this.mode = arg3;
        this.size = arg4;
        this.mtimeSec = arg6;
        this.errorCode = arg8;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final int getMode() {
        return this.mode;
    }

    public final long getMtimeSec() {
        return this.mtimeSec;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSize() {
        return this.size;
    }
}

