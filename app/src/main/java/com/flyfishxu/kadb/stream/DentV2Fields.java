package com.flyfishxu.kadb.stream;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\u0005\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\u0006\u0010\r\u001A\u00020\u0005\u0012\u0006\u0010\u000E\u001A\u00020\u0005\u0012\u0006\u0010\u000F\u001A\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0014R\u0011\u0010\n\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0014R\u0011\u0010\u000B\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0016R\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0016R\u0011\u0010\r\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0016R\u0011\u0010\u000E\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u0016R\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b \u0010!¨\u0006\""}, d2={"Lcom/flyfishxu/kadb/stream/DentV2Fields;", "", "errorCode", "", "dev", "", "ino", "mode", "nlink", "uid", "gid", "size", "atimeSec", "mtimeSec", "ctimeSec", "name", "", "<init>", "(IJJIIIIJJJJLjava/lang/String;)V", "getErrorCode", "()I", "getDev", "()J", "getIno", "getMode", "getNlink", "getUid", "getGid", "getSize", "getAtimeSec", "getMtimeSec", "getCtimeSec", "getName", "()Ljava/lang/String;", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) final class DentV2Fields {
    private final long atimeSec;
    private final long ctimeSec;
    private final long dev;
    private final int errorCode;
    private final int gid;
    private final long ino;
    private final int mode;
    private final long mtimeSec;
    private final String name;
    private final int nlink;
    private final long size;
    private final int uid;

    public DentV2Fields(int arg3, long arg4, long arg6, int arg8, int arg9, int arg10, int arg11, long arg12, long arg14, long arg16, long arg18, String arg20) {
        Intrinsics.checkNotNullParameter(arg20, "name");
        super();
        this.errorCode = arg3;
        this.dev = arg4;
        this.ino = arg6;
        this.mode = arg8;
        this.nlink = arg9;
        this.uid = arg10;
        this.gid = arg11;
        this.size = arg12;
        this.atimeSec = arg14;
        this.mtimeSec = arg16;
        this.ctimeSec = arg18;
        this.name = arg20;
    }

    public final long getAtimeSec() {
        return this.atimeSec;
    }

    public final long getCtimeSec() {
        return this.ctimeSec;
    }

    public final long getDev() {
        return this.dev;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final int getGid() {
        return this.gid;
    }

    public final long getIno() {
        return this.ino;
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

    public final int getNlink() {
        return this.nlink;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getUid() {
        return this.uid;
    }
}

