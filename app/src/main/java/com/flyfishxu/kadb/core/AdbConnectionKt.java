package com.flyfishxu.kadb.core;

import com.flyfishxu.kadb.cert.AdbKeyPair;
import com.flyfishxu.kadb.cert.AndroidPubkey;
import com.flyfishxu.kadb.cert.platform.DefaultDeviceName_androidKt;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0002¨\u0006\u0004"}, d2={"adbPublicKey", "", "keyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class AdbConnectionKt {
    public static final byte[] access$adbPublicKey(AdbKeyPair arg0) {
        return AdbConnectionKt.adbPublicKey(arg0);
    }

    private static final byte[] adbPublicKey(AdbKeyPair arg2) {
        PublicKey v2 = arg2.getPublicKey();
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type java.security.interfaces.RSAPublicKey");
        return AndroidPubkey.encodeWithName(((RSAPublicKey)v2), DefaultDeviceName_androidKt.defaultDeviceName$default(null, 1, null));
    }
}

