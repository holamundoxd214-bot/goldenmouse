package com.flyfishxu.kadb.cert;

import com.flyfishxu.kadb.core.AdbMessage;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0000¢\u0006\u0002\b\u0014R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0015"}, d2={"Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "", "privateKey", "Ljava/security/PrivateKey;", "publicKey", "Ljava/security/PublicKey;", "certificate", "Ljava/security/cert/Certificate;", "<init>", "(Ljava/security/PrivateKey;Ljava/security/PublicKey;Ljava/security/cert/Certificate;)V", "getPrivateKey", "()Ljava/security/PrivateKey;", "getPublicKey", "()Ljava/security/PublicKey;", "getCertificate", "()Ljava/security/cert/Certificate;", "signPayload", "", "message", "Lcom/flyfishxu/kadb/core/AdbMessage;", "signPayload$kadb", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbKeyPair {
    private final Certificate certificate;
    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public AdbKeyPair(PrivateKey arg2, PublicKey arg3, Certificate arg4) {
        Intrinsics.checkNotNullParameter(arg2, "privateKey");
        Intrinsics.checkNotNullParameter(arg3, "publicKey");
        Intrinsics.checkNotNullParameter(arg4, "certificate");
        super();
        this.privateKey = arg2;
        this.publicKey = arg3;
        this.certificate = arg4;
    }

    public final Certificate getCertificate() {
        return this.certificate;
    }

    public final PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public final PublicKey getPublicKey() {
        return this.publicKey;
    }

    public final byte[] signPayload$kadb(AdbMessage arg3) {
        Intrinsics.checkNotNullParameter(arg3, "message");
        Cipher v0 = Cipher.getInstance("RSA/ECB/NoPadding");
        v0.init(1, this.privateKey);
        v0.update(AndroidPubkey.INSTANCE.getSIGNATURE_PADDING());
        byte[] v2 = v0.doFinal(arg3.getPayload(), 0, arg3.getPayloadLength());
        Intrinsics.checkNotNullExpressionValue(v2, "doFinal(...)");
        return v2;
    }
}

