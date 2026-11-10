package com.flyfishxu.kadb.pair;

import android.os.Build$VERSION;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.lsposed.hiddenapibypass.HiddenApiBypass;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0010\u0010\u0000\u001A\u0006\u0012\u0002\b\u00030\u0001*\u00020\u0002H\u0001¨\u0006\u0003"}, d2={"getConscryptClass", "Ljava/lang/Class;", "Lcom/flyfishxu/kadb/pair/PairingConnectionCtx;", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class PairingConnectionCtx_androidKt {
    public static final Class getConscryptClass(PairingConnectionCtx arg2) {
        Class v2;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(SslUtils.INSTANCE.getCustomConscrypt()) {
            v2 = Class.forName("org.conscrypt.Conscrypt");
            Intrinsics.checkNotNull(v2);
            return v2;
        }

        if(Build$VERSION.SDK_INT >= 29) {
            try {
                HiddenApiBypass.addHiddenApiExemptions(new String[]{"Lcom/android/org/conscrypt/Conscrypt;"});
                v2 = Class.forName("com.android.org.conscrypt.Conscrypt");
            }
            catch(Exception v2_1) {
                v2_1.printStackTrace();
                throw new ClassNotFoundException("Cannot load Conscrypt class via HiddenApiBypass.", ((Throwable)v2_1));
            }

            Intrinsics.checkNotNull(v2);
            return v2;
        }

        throw new NoSuchAlgorithmException("TLSv1.3 isn\'t supported on your platform. Use custom Conscrypt library instead.");
    }
}

