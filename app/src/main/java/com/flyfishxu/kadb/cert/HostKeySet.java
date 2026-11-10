package com.flyfishxu.kadb.cert;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0014\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001A\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001A\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0017"}, d2={"Lcom/flyfishxu/kadb/cert/HostKeySet;", "", "defaultKeyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "keyPairs", "", "<init>", "(Lcom/flyfishxu/kadb/cert/AdbKeyPair;Ljava/util/List;)V", "getDefaultKeyPair", "()Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "getKeyPairs", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class HostKeySet {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Lcom/flyfishxu/kadb/cert/HostKeySet$Companion;", "", "<init>", "()V", "single", "Lcom/flyfishxu/kadb/cert/HostKeySet;", "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final HostKeySet single(AdbKeyPair arg2) {
            Intrinsics.checkNotNullParameter(arg2, "keyPair");
            return new HostKeySet(arg2, CollectionsKt.listOf(arg2));
        }
    }

    public static final Companion Companion;
    private final AdbKeyPair defaultKeyPair;
    private final List keyPairs;

    static {
        HostKeySet.Companion = new Companion(null);
    }

    public HostKeySet(AdbKeyPair arg2, List arg3) {
        Intrinsics.checkNotNullParameter(arg2, "defaultKeyPair");
        Intrinsics.checkNotNullParameter(arg3, "keyPairs");
        super();
        this.defaultKeyPair = arg2;
        this.keyPairs = arg3;
        if(!arg3.isEmpty()) {
            if(CollectionsKt.first(arg3) == arg2) {
                return;
            }

            throw new IllegalArgumentException("Default key pair must be the first entry in key set".toString());
        }

        throw new IllegalArgumentException("HostKeySet must contain at least one key pair".toString());
    }

    public final AdbKeyPair component1() {
        return this.defaultKeyPair;
    }

    public final List component2() {
        return this.keyPairs;
    }

    public final HostKeySet copy(AdbKeyPair arg1, List arg2) {
        Intrinsics.checkNotNullParameter(arg1, "defaultKeyPair");
        Intrinsics.checkNotNullParameter(arg2, "keyPairs");
        return new HostKeySet(arg1, arg2);
    }

    public static HostKeySet copy$default(HostKeySet arg0, AdbKeyPair arg1, List arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.defaultKeyPair;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.keyPairs;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((HostKeySet)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof HostKeySet)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.defaultKeyPair, ((HostKeySet)arg5).defaultKeyPair)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.keyPairs, ((HostKeySet)arg5).keyPairs)) {
            return 0;
        }

        return 1;
    }

    public final AdbKeyPair getDefaultKeyPair() {
        return this.defaultKeyPair;
    }

    public final List getKeyPairs() {
        return this.keyPairs;
    }

    public int hashCode() {
        return this.defaultKeyPair.hashCode() * 0x1F + this.keyPairs.hashCode();
    }

    public String toString() {
        return "HostKeySet(defaultKeyPair=" + this.defaultKeyPair + ", keyPairs=" + this.keyPairs + ")";
    }
}

