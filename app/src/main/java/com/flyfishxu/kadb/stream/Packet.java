package com.flyfishxu.kadb.stream;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Lcom/flyfishxu/kadb/stream/Packet;", "", "id", "", "arg", "", "<init>", "(Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getArg", "()I", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) final class Packet {
    private final int arg;
    private final String id;

    public Packet(String arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "id");
        super();
        this.id = arg2;
        this.arg = arg3;
    }

    public final int getArg() {
        return this.arg;
    }

    public final String getId() {
        return this.id;
    }
}

