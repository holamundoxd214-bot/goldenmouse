package com.TryJeanPc.goldenmouse.stretch.agent;

import java.io.Closeable;
import java.io.FileInputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001A\u00020\u0005¨\u0006\u0006"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchBootIdentity;", "", "<init>", "()V", "read", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AndroidStretchBootIdentity {
    public static final int $stable;
    public static final AndroidStretchBootIdentity INSTANCE;

    static {
        AndroidStretchBootIdentity.INSTANCE = new AndroidStretchBootIdentity();
    }

    private AndroidStretchBootIdentity() {
        super();
    }

    public final String read() {
        String v1_1;
        String v5;
        int v4;
        byte[] v2;
        FileInputStream v0_1;
        FileInputStream v7 = new FileInputStream("/proc/sys/kernel/random/boot_id");
        try {
            v0_1 = v7;
            int v1 = 65;
            v2 = new byte[v1];
            v4 = 0;
        }
        catch(Throwable v0) {
            goto label_48;
        }

        while(true) {
            v5 = "Failed requirement.";
            if(v4 < v1) {
                int v6 = 65 - v4;
                try {
                    v6 = v0_1.read(v2, v4, v6);
                    if(v6 >= 0) {
                        if(v6 > 0) {
                            v4 += v6;
                            continue;
                        }
                        else {
                            throw new IllegalArgumentException(v5.toString());
                        }
                    }

                label_20:
                    if(1 <= v4 && v4 < v1) {
                        String v0_2 = StringsKt.trimEnd(new String(v2, 0, v4, Charsets.US_ASCII), new char[]{'\n'});
                        v1_1 = UUID.fromString(v0_2).toString();
                        if(Intrinsics.areEqual(v1_1, v0_2)) {
                            break;
                        }
                        else {
                            goto label_39;
                        }
                    }

                    goto label_43;
                }
                catch(Throwable v0) {
                    goto label_48;
                }
            }

            goto label_20;
        }

        CloseableKt.closeFinally(((Closeable)v7), null);
        Intrinsics.checkNotNullExpressionValue(v1_1, "use(...)");
        return v1_1;
        try {
        label_39:
            throw new IllegalArgumentException(v5.toString());
        label_43:
            throw new IllegalArgumentException(v5.toString());
        }
        catch(Throwable v0) {
            try {
            label_48:
                throw v0;
            }
            catch(Throwable v1_2) {
                CloseableKt.closeFinally(((Closeable)v7), v0);
                throw v1_2;
            }
        }
    }
}

