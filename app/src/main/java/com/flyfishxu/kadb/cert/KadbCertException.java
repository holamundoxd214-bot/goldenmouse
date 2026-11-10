package com.flyfishxu.kadb.cert;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \r2\u00060\u0001j\u0002`\u0002:\u0005\t\n\u000B\f\rB\u001D\b\u0004\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0004\u000E\u000F\u0010\u0011¨\u0006\u0012"}, d2={"Lcom/flyfishxu/kadb/cert/KadbCertException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "PrivateKeyParseFailed", "StoreReadFailed", "StoreWriteFailed", "PolicyViolation", "Companion", "Lcom/flyfishxu/kadb/cert/KadbCertException$PolicyViolation;", "Lcom/flyfishxu/kadb/cert/KadbCertException$PrivateKeyParseFailed;", "Lcom/flyfishxu/kadb/cert/KadbCertException$StoreReadFailed;", "Lcom/flyfishxu/kadb/cert/KadbCertException$StoreWriteFailed;", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class KadbCertException extends RuntimeException {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, d2={"Lcom/flyfishxu/kadb/cert/KadbCertException$Companion;", "", "<init>", "()V", "fromPrivateKeyParseError", "Lcom/flyfishxu/kadb/cert/KadbCertException;", "error", "", "fromPrivateKeyParseError$kadb", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final KadbCertException fromPrivateKeyParseError$kadb(Throwable arg1) {
            Intrinsics.checkNotNullParameter(arg1, "error");
            if((arg1 instanceof KadbCertException)) {
                return arg1;
            }

            return new PrivateKeyParseFailed(arg1);
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lcom/flyfishxu/kadb/cert/KadbCertException$PolicyViolation;", "Lcom/flyfishxu/kadb/cert/KadbCertException;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class PolicyViolation extends KadbCertException {
        public PolicyViolation(String arg1, Throwable arg2, int arg3, DefaultConstructorMarker arg4) {
            if((arg3 & 2) != 0) {
                arg2 = null;
            }

            this(arg1, arg2);
        }

        public PolicyViolation(String arg2, Throwable arg3) {
            Intrinsics.checkNotNullParameter(arg2, "message");
            super(arg2, arg3, null);
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"Lcom/flyfishxu/kadb/cert/KadbCertException$PrivateKeyParseFailed;", "Lcom/flyfishxu/kadb/cert/KadbCertException;", "cause", "", "<init>", "(Ljava/lang/Throwable;)V", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class PrivateKeyParseFailed extends KadbCertException {
        public PrivateKeyParseFailed(Throwable arg3) {
            super("Failed to parse private key", arg3, null);
        }

        public PrivateKeyParseFailed() {
            this(null, 1, null);
        }

        public PrivateKeyParseFailed(Throwable arg1, int arg2, DefaultConstructorMarker arg3) {
            if((arg2 & 1) != 0) {
                arg1 = null;
            }

            this(arg1);
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"Lcom/flyfishxu/kadb/cert/KadbCertException$StoreReadFailed;", "Lcom/flyfishxu/kadb/cert/KadbCertException;", "cause", "", "<init>", "(Ljava/lang/Throwable;)V", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class StoreReadFailed extends KadbCertException {
        public StoreReadFailed(Throwable arg3) {
            super("Failed to read identity from store", arg3, null);
        }

        public StoreReadFailed() {
            this(null, 1, null);
        }

        public StoreReadFailed(Throwable arg1, int arg2, DefaultConstructorMarker arg3) {
            if((arg2 & 1) != 0) {
                arg1 = null;
            }

            this(arg1);
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"Lcom/flyfishxu/kadb/cert/KadbCertException$StoreWriteFailed;", "Lcom/flyfishxu/kadb/cert/KadbCertException;", "cause", "", "<init>", "(Ljava/lang/Throwable;)V", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class StoreWriteFailed extends KadbCertException {
        public StoreWriteFailed(Throwable arg3) {
            super("Failed to write identity to store", arg3, null);
        }

        public StoreWriteFailed() {
            this(null, 1, null);
        }

        public StoreWriteFailed(Throwable arg1, int arg2, DefaultConstructorMarker arg3) {
            if((arg2 & 1) != 0) {
                arg1 = null;
            }

            this(arg1);
        }
    }

    public static final Companion Companion;

    static {
        KadbCertException.Companion = new Companion(null);
    }

    private KadbCertException(String arg1, Throwable arg2) {
        super(arg1, arg2);
    }

    public KadbCertException(String arg1, Throwable arg2, int arg3, DefaultConstructorMarker arg4) {
        arg4 = null;
        if((arg3 & 2) != 0) {
            arg2 = ((Throwable)arg4);
        }

        this(arg1, arg2, arg4);
    }

    public KadbCertException(String arg1, Throwable arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }
}

