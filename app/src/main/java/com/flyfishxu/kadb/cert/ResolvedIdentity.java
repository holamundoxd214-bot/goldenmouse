package com.flyfishxu.kadb.cert;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0007HÆ\u0003J\'\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001A\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001A\u00020\u001AHÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001B"}, d2={"Lcom/flyfishxu/kadb/cert/ResolvedIdentity;", "", "privateKeyPem", "", "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "snapshot", "Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;", "<init>", "([BLcom/flyfishxu/kadb/cert/AdbKeyPair;Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;)V", "getPrivateKeyPem", "()[B", "getKeyPair", "()Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "getSnapshot", "()Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class ResolvedIdentity {
    private final AdbKeyPair keyPair;
    private final byte[] privateKeyPem;
    private final KadbIdentitySnapshot snapshot;

    public ResolvedIdentity(byte[] arg2, AdbKeyPair arg3, KadbIdentitySnapshot arg4) {
        Intrinsics.checkNotNullParameter(arg2, "privateKeyPem");
        Intrinsics.checkNotNullParameter(arg3, "keyPair");
        Intrinsics.checkNotNullParameter(arg4, "snapshot");
        super();
        this.privateKeyPem = arg2;
        this.keyPair = arg3;
        this.snapshot = arg4;
    }

    public final byte[] component1() {
        return this.privateKeyPem;
    }

    public final AdbKeyPair component2() {
        return this.keyPair;
    }

    public final KadbIdentitySnapshot component3() {
        return this.snapshot;
    }

    public final ResolvedIdentity copy(byte[] arg1, AdbKeyPair arg2, KadbIdentitySnapshot arg3) {
        Intrinsics.checkNotNullParameter(arg1, "privateKeyPem");
        Intrinsics.checkNotNullParameter(arg2, "keyPair");
        Intrinsics.checkNotNullParameter(arg3, "snapshot");
        return new ResolvedIdentity(arg1, arg2, arg3);
    }

    public static ResolvedIdentity copy$default(ResolvedIdentity arg0, byte[] arg1, AdbKeyPair arg2, KadbIdentitySnapshot arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.privateKeyPem;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.keyPair;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.snapshot;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((ResolvedIdentity)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ResolvedIdentity)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.privateKeyPem, ((ResolvedIdentity)arg5).privateKeyPem)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.keyPair, ((ResolvedIdentity)arg5).keyPair)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.snapshot, ((ResolvedIdentity)arg5).snapshot)) {
            return 0;
        }

        return 1;
    }

    public final AdbKeyPair getKeyPair() {
        return this.keyPair;
    }

    public final byte[] getPrivateKeyPem() {
        return this.privateKeyPem;
    }

    public final KadbIdentitySnapshot getSnapshot() {
        return this.snapshot;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.privateKeyPem) * 0x1F + this.keyPair.hashCode()) * 0x1F + this.snapshot.hashCode();
    }

    public String toString() {
        return "ResolvedIdentity(privateKeyPem=" + Arrays.toString(this.privateKeyPem) + ", keyPair=" + this.keyPair + ", snapshot=" + this.snapshot + ")";
    }
}

