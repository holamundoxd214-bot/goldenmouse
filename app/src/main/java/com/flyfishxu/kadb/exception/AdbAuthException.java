package com.flyfishxu.kadb.exception;

import java.io.IOException;
import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Lcom/flyfishxu/kadb/exception/AdbAuthException;", "Ljava/io/IOException;", "<init>", "()V", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbAuthException extends IOException {
    public AdbAuthException() {
        super("Need adb authority");
    }
}

