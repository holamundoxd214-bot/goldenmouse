package com.flyfishxu.kadb.pair;

import com.flyfish233.crypto.spake2.Spake2Context;
import com.flyfish233.crypto.spake2.Spake2Role;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0016\u0010\u000E\u001A\u0004\u0018\u00010\u000F*\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001A\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001A\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001A\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0003\"\u0014\u0010\b\u001A\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B\"\u0014\u0010\f\u001A\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000B¨\u0006\u0012"}, d2={"CLIENT_NAME", "", "getCLIENT_NAME", "()[B", "SERVER_NAME", "getSERVER_NAME", "INFO", "getINFO", "HKDF_KEY_LENGTH", "", "getHKDF_KEY_LENGTH", "()I", "GCM_IV_LENGTH", "getGCM_IV_LENGTH", "createAlice", "Lcom/flyfishxu/kadb/pair/PairingAuthCtx;", "Lcom/flyfishxu/kadb/pair/PairingAuthCtx$Companion;", "password", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class PairingAuthCtx_androidKt {
    public static final int access$getGCM_IV_LENGTH() {
        return PairingAuthCtx_androidKt.getGCM_IV_LENGTH();
    }

    public static final PairingAuthCtx createAlice(Companion arg3, byte[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "password");
        Spake2Context v3 = new Spake2Context(Spake2Role.Alice, PairingAuthCtx_androidKt.getCLIENT_NAME(), PairingAuthCtx_androidKt.getSERVER_NAME());
        try {
            return new PairingAuthCtx(v3, arg4);
        }
        catch(IllegalStateException ) {
            return null;
        }
    }

    private static final byte[] getCLIENT_NAME() {
        return PairingAuthCtxKt.getBytes("adb pair client\u0000", "UTF-8");
    }

    private static final int getGCM_IV_LENGTH() {
        return 12;
    }

    public static final int getHKDF_KEY_LENGTH() {
        return 16;
    }

    public static final byte[] getINFO() {
        return PairingAuthCtxKt.getBytes("adb pairing_auth aes-128-gcm key", "UTF-8");
    }

    private static final byte[] getSERVER_NAME() {
        return PairingAuthCtxKt.getBytes("adb pair server\u0000", "UTF-8");
    }
}

