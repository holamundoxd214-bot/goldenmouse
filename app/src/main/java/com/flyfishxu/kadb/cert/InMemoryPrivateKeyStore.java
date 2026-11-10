package com.flyfishxu.kadb.cert;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\b\u0010\u000B\u001A\u00020\nH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lcom/flyfishxu/kadb/cert/InMemoryPrivateKeyStore;", "Lcom/flyfishxu/kadb/cert/KadbPrivateKeyStore;", "<init>", "()V", "lock", "", "privateKeyPem", "", "readPrivateKeyPem", "writePrivateKeyPemAtomic", "", "clear", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class InMemoryPrivateKeyStore implements KadbPrivateKeyStore {
    private final Object lock;
    private byte[] privateKeyPem;

    public InMemoryPrivateKeyStore() {
        super();
        this.lock = new Object();
    }

    public void clear() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        byte[] v1 = null;
        try {
            this.privateKeyPem = v1;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public byte[] readPrivateKeyPem() {
        byte[] v2_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            v2_1 = this.privateKeyPem;
            if(v2_1 != null) {
                v2_1 = Arrays.copyOf(v2_1, v2_1.length);
                Intrinsics.checkNotNullExpressionValue(v2_1, "copyOf(...)");
            }
            else {
                goto label_9;
            }

            goto label_10;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

    label_9:
        v2_1 = null;
    label_10:
        __monitor_exit(v0);
        return v2_1;
    }

    public void writePrivateKeyPemAtomic(byte[] arg3) {
        Intrinsics.checkNotNullParameter(arg3, "privateKeyPem");
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            arg3 = Arrays.copyOf(arg3, arg3.length);
            Intrinsics.checkNotNullExpressionValue(arg3, "copyOf(...)");
            this.privateKeyPem = arg3;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }
}

