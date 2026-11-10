package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BJ\u000E\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\tJ\u0016\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\n\u001A\u00020\u000BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalProgressWire;", "", "<init>", "()V", "CALLBACK_TRANSACTION", "", "write", "", "p", "Landroid/os/Parcel;", "frame", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalCheckpoint;", "read", "send", "callback", "Landroid/os/IBinder;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchOriginalProgressWire {
    public static final int $stable = 0;
    public static final int CALLBACK_TRANSACTION = 2;
    public static final StretchOriginalProgressWire INSTANCE;

    static {
        StretchOriginalProgressWire.INSTANCE = new StretchOriginalProgressWire();
    }

    private StretchOriginalProgressWire() {
        super();
    }

    public final StretchOriginalCheckpoint read(Parcel arg20) {
        Parcel v0 = arg20;
        Intrinsics.checkNotNullParameter(v0, "p");
        int v3 = v0.readInt();
        String v4 = StretchAgentWire.INSTANCE.text(v0);
        StretchAgentRequest v5 = StretchAgentRequest.copy$default(StretchAgentWire.INSTANCE.readRequest(v0), 0, null, null, null, null, 0, null, null, null, 0, Integer.valueOf(v0.readInt()), 0x3FF, null);
        int v6 = v0.readInt();
        Object v7 = CollectionsKt.getOrNull(StretchOriginalAgentStep.getEntries(), v0.readInt());
        if(v7 != null) {
            int v1 = v0.readInt();
            boolean v2 = true;
            if(v1 != 0) {
                if(v1 == 1) {
                }
                else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }

            StretchAgentWire.INSTANCE.exhausted(v0);
            StretchOriginalCheckpoint v0_1 = null;
            if(v1 == 1) {
            }
            else {
                v2 = false;
            }

            super(v3, v4, v5, v6, ((StretchOriginalAgentStep)v7), v2);
            return v0_1;
        }

        throw new IllegalStateException("Invalid progress step".toString());
    }

    public final void send(IBinder arg6, StretchOriginalCheckpoint arg7) {
        Intrinsics.checkNotNullParameter(arg6, "callback");
        Intrinsics.checkNotNullParameter(arg7, "frame");
        Parcel v0 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v0, "obtain(...)");
        Parcel v2 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(v2, "obtain(...)");
        long v3 = Binder.clearCallingIdentity();
        try {
            v0.writeInterfaceToken("com.TryJeanPc.goldenmouse.stretch.agent.v2.peer");
            this.write(v0, arg7);
            boolean v5_1 = arg6.transact(2, v0, v2, 0);
        }
        catch(Throwable v5) {
            goto label_39;
        }

        String v6 = "Failed requirement.";
        if(!v5_1) {
            goto label_34;
        }

        try {
            StretchAgentWire.INSTANCE.bounded(v2);
            v2.readException();
            if(v2.readInt() != 1) {
                goto label_30;
            }

            StretchAgentWire.INSTANCE.exhausted(v2);
        }
        catch(Throwable v5) {
            goto label_39;
        }

        Binder.restoreCallingIdentity(v3);
        v0.recycle();
        v2.recycle();
        return;
        try {
        label_30:
            throw new IllegalArgumentException(v6.toString());
        label_34:
            throw new IllegalArgumentException(v6.toString());
        }
        catch(Throwable v5) {
        label_39:
            Binder.restoreCallingIdentity(v3);
            v0.recycle();
            v2.recycle();
            throw v5;
        }
    }

    public final void write(Parcel arg2, StretchOriginalCheckpoint arg3) {
        Intrinsics.checkNotNullParameter(arg2, "p");
        Intrinsics.checkNotNullParameter(arg3, "frame");
        arg2.writeInt(arg3.getVersion());
        arg2.writeString(arg3.getChallenge());
        Integer v1 = arg3.getRequest().getOriginalEvidenceVersion();
        if(v1 != null) {
            arg2.writeInt(((Number)v1).intValue());
            StretchAgentWire.INSTANCE.writeRequest(arg2, arg3.getRequest());
            arg2.writeInt(arg3.getSequence());
            arg2.writeInt(arg3.getStep().ordinal());
            arg2.writeInt(arg3.getFinished());
            StretchAgentWire.INSTANCE.bounded(arg2);
            return;
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }
}

