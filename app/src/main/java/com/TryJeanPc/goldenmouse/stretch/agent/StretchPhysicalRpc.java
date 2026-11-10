package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fJ\u000E\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\nR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalRpc;", "", "<init>", "()V", "TRANSACTION", "", "VERSION", "writeReply", "", "p", "Landroid/os/Parcel;", "r", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalReply;", "readReply", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchPhysicalRpc {
    public static final int $stable = 0;
    public static final StretchPhysicalRpc INSTANCE = null;
    public static final int TRANSACTION = 4;
    public static final int VERSION = 1;

    static {
        StretchPhysicalRpc.INSTANCE = new StretchPhysicalRpc();
    }

    private StretchPhysicalRpc() {
        super();
    }

    public final StretchPhysicalReply readReply(Parcel arg11) {
        Intrinsics.checkNotNullParameter(arg11, "p");
        String v1 = "Failed requirement.";
        if(arg11.readInt() == 1) {
            String v3 = StretchAgentWire.INSTANCE.text(arg11);
            String v4 = StretchAgentWire.INSTANCE.text(arg11);
            String v5 = StretchAgentWire.INSTANCE.text(arg11);
            int v10 = arg11.readInt();
            if(v10 != -1 && (v10 < 0 || v10 >= CandidatePhase.getEntries().size())) {
                throw new IllegalArgumentException(v1.toString());
            }

            boolean v7 = StretchPhysicalRpc.readReply$flag(arg11);
            boolean v8 = StretchPhysicalRpc.readReply$flag(arg11);
            String v0 = arg11.readString();
            if(v0 == null) {
                v0 = null;
            }
            else if(StretchAgentProtocolKt.validAgentText(v0)) {
            }
            else {
                throw new IllegalArgumentException(v1.toString());
            }

            StretchAgentWire.INSTANCE.exhausted(arg11);
            return new StretchPhysicalReply(v3, v4, v5, CollectionsKt.getOrNull(CandidatePhase.getEntries(), v10), v7, v8, v0);
        }

        throw new IllegalArgumentException(v1.toString());
    }

    private static final boolean readReply$flag(Parcel arg1) {
        int v1 = arg1.readInt();
        if(v1 >= 0 && v1 < 2) {
            if(v1 == 1) {
                return 1;
            }
            else {
                return 0;
            }
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void writeReply(Parcel arg1, StretchPhysicalReply arg2) {
        Intrinsics.checkNotNullParameter(arg1, "p");
        Intrinsics.checkNotNullParameter(arg2, "r");
        arg1.writeInt(1);
        arg1.writeString(arg2.getOperationId());
        arg1.writeString(arg2.getAgentGeneration());
        arg1.writeString(arg2.getCode());
        CandidatePhase v0 = arg2.getPhase();
        int v0_1 = v0 != null ? v0.ordinal() : -1;
        arg1.writeInt(v0_1);
        arg1.writeInt(arg2.getJournalRetained());
        arg1.writeInt(arg2.getRecoveryPending());
        arg1.writeString(arg2.getErrorType());
        StretchAgentWire.INSTANCE.bounded(arg1);
    }
}

