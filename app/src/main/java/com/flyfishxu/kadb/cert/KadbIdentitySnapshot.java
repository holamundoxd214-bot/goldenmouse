package com.flyfishxu.kadb.cert;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0012\u001A\u00020\u0000H\u0000¢\u0006\u0002\b\u0013J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001A\u00020\bHÆ\u0003J1\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0014\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001C\u001A\u00020\u001DHÖ\u0081\u0004J\n\u0010\u001E\u001A\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001F"}, d2={"Lcom/flyfishxu/kadb/cert/KadbIdentitySnapshot;", "", "privateKeyPem", "", "certificatePem", "fingerprintSha256", "", "notAfterEpochMillis", "", "<init>", "([B[BLjava/lang/String;J)V", "getPrivateKeyPem", "()[B", "getCertificatePem", "getFingerprintSha256", "()Ljava/lang/String;", "getNotAfterEpochMillis", "()J", "deepCopy", "deepCopy$kadb", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class KadbIdentitySnapshot {
    private final byte[] certificatePem;
    private final String fingerprintSha256;
    private final long notAfterEpochMillis;
    private final byte[] privateKeyPem;

    public KadbIdentitySnapshot(byte[] arg2, byte[] arg3, String arg4, long arg5) {
        Intrinsics.checkNotNullParameter(arg2, "privateKeyPem");
        Intrinsics.checkNotNullParameter(arg3, "certificatePem");
        Intrinsics.checkNotNullParameter(arg4, "fingerprintSha256");
        super();
        this.privateKeyPem = arg2;
        this.certificatePem = arg3;
        this.fingerprintSha256 = arg4;
        this.notAfterEpochMillis = arg5;
    }

    public final byte[] component1() {
        return this.privateKeyPem;
    }

    public final byte[] component2() {
        return this.certificatePem;
    }

    public final String component3() {
        return this.fingerprintSha256;
    }

    public final long component4() {
        return this.notAfterEpochMillis;
    }

    public final KadbIdentitySnapshot copy(byte[] arg7, byte[] arg8, String arg9, long arg10) {
        Intrinsics.checkNotNullParameter(arg7, "privateKeyPem");
        Intrinsics.checkNotNullParameter(arg8, "certificatePem");
        Intrinsics.checkNotNullParameter(arg9, "fingerprintSha256");
        return new KadbIdentitySnapshot(arg7, arg8, arg9, arg10);
    }

    public static KadbIdentitySnapshot copy$default(KadbIdentitySnapshot arg0, byte[] arg1, byte[] arg2, String arg3, long arg4, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.privateKeyPem;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.certificatePem;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.fingerprintSha256;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.notAfterEpochMillis;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public final KadbIdentitySnapshot deepCopy$kadb() {
        byte[] v3 = Arrays.copyOf(this.privateKeyPem, this.privateKeyPem.length);
        Intrinsics.checkNotNullExpressionValue(v3, "copyOf(...)");
        byte[] v4 = Arrays.copyOf(this.certificatePem, this.certificatePem.length);
        Intrinsics.checkNotNullExpressionValue(v4, "copyOf(...)");
        return KadbIdentitySnapshot.copy$default(this, v3, v4, null, 0, 12, null);
    }

    public boolean equals(Object arg6) {
        if(this == (((KadbIdentitySnapshot)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof KadbIdentitySnapshot)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.privateKeyPem, ((KadbIdentitySnapshot)arg6).privateKeyPem)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.certificatePem, ((KadbIdentitySnapshot)arg6).certificatePem)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.fingerprintSha256, ((KadbIdentitySnapshot)arg6).fingerprintSha256)) {
            return 0;
        }

        if(this.notAfterEpochMillis != ((KadbIdentitySnapshot)arg6).notAfterEpochMillis) {
            return 0;
        }

        return 1;
    }

    public final byte[] getCertificatePem() {
        return this.certificatePem;
    }

    public final String getFingerprintSha256() {
        return this.fingerprintSha256;
    }

    public final long getNotAfterEpochMillis() {
        return this.notAfterEpochMillis;
    }

    public final byte[] getPrivateKeyPem() {
        return this.privateKeyPem;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.privateKeyPem) * 0x1F + Arrays.hashCode(this.certificatePem)) * 0x1F + this.fingerprintSha256.hashCode()) * 0x1F + Long.hashCode(this.notAfterEpochMillis);
    }

    public String toString() {
        return "KadbIdentitySnapshot(privateKeyPem=" + Arrays.toString(this.privateKeyPem) + ", certificatePem=" + Arrays.toString(this.certificatePem) + ", fingerprintSha256=" + this.fingerprintSha256 + ", notAfterEpochMillis=" + this.notAfterEpochMillis + ")";
    }
}

