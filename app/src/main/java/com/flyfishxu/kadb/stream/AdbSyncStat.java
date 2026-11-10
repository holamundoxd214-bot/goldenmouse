package com.flyfishxu.kadb.stream;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u000E"}, d2={"Lcom/flyfishxu/kadb/stream/AdbSyncStat;", "", "mode", "", "size", "", "mtimeSec", "<init>", "(IJJ)V", "getMode", "()I", "getSize", "()J", "getMtimeSec", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbSyncStat {
    private final int mode;
    private final long mtimeSec;
    private final long size;

    public AdbSyncStat(int arg1, long arg2, long arg4) {
        super();
        this.mode = arg1;
        this.size = arg2;
        this.mtimeSec = arg4;
    }

    public final int getMode() {
        return this.mode;
    }

    public final long getMtimeSec() {
        return this.mtimeSec;
    }

    public final long getSize() {
        return this.size;
    }
}

