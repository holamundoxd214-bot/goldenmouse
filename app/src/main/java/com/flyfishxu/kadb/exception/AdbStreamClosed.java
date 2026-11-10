package com.flyfishxu.kadb.exception;

import java.io.IOException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"Lcom/flyfishxu/kadb/exception/AdbStreamClosed;", "Ljava/io/IOException;", "localId", "", "<init>", "(I)V", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbStreamClosed extends IOException {
    public AdbStreamClosed(int arg2) {
        String v2 = String.format("ADB stream is closed for localId: %x", Arrays.copyOf(new Object[]{Integer.valueOf(arg2)}, 1));
        Intrinsics.checkNotNullExpressionValue(v2, "format(...)");
        super(v2);
    }
}

