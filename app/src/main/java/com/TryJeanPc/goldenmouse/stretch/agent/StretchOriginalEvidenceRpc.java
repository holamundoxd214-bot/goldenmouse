package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.Parcel;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoveryCodec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nJ\u0016\u0010\u000B\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\nJ\u0016\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\t\u001A\u00020\nJ\u0016\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\rJ\u000E\u0010\u0016\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\u0014R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidenceRpc;", "", "<init>", "()V", "TRANSACTION", "", "VERSION", "accepts", "", "request", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentRequest;", "eligible", "current", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentReply;", "boundTo", "evidence", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "writeReply", "", "parcel", "Landroid/os/Parcel;", "reply", "readReply", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchOriginalEvidenceRpc {
    public static final int $stable = 0;
    public static final StretchOriginalEvidenceRpc INSTANCE = null;
    public static final int TRANSACTION = 3;
    public static final int VERSION = 1;

    static {
        StretchOriginalEvidenceRpc.INSTANCE = new StretchOriginalEvidenceRpc();
    }

    private StretchOriginalEvidenceRpc() {
        super();
    }

    public final boolean accepts(StretchAgentRequest arg2) {
        Intrinsics.checkNotNullParameter(arg2, "request");
        Integer v1 = arg2.getOriginalEvidenceVersion();
        if(v1 == null) {
        }
        else if(v1.intValue() == 1 && arg2.getAction() == StretchAgentAction.STATUS) {
            return 1;
        }

        return 0;
    }

    public final boolean boundTo(StretchOriginalEvidence arg2, StretchAgentRequest arg3) {
        Intrinsics.checkNotNullParameter(arg2, "evidence");
        Intrinsics.checkNotNullParameter(arg3, "request");
        if((Intrinsics.areEqual(arg2.getAgentGeneration(), arg3.getAgentGeneration())) && (Intrinsics.areEqual(arg2.getOwnerGeneration(), arg3.getOwnerGeneration())) && (Intrinsics.areEqual(arg2.getSnapshot().getSessionId(), arg3.getSessionId())) && (Intrinsics.areEqual(arg2.getSnapshotDigest(), arg3.getSnapshotDigest())) && (Intrinsics.areEqual(arg2.getSnapshot().getOriginal().getPhysicalIdentity().getValue(), arg3.getPhysicalIdentity()))) {
            return 1;
        }

        return 0;
    }

    public final boolean eligible(StretchAgentReply arg4, StretchAgentRequest arg5) {
        Intrinsics.checkNotNullParameter(arg4, "current");
        Intrinsics.checkNotNullParameter(arg5, "request");
        StretchAgentBaseline v0 = arg4.getBaseline();
        if(v0 == null) {
            return 0;
        }

        if((this.accepts(arg5)) && arg4.getCode() == StretchAgentCode.ACCEPTED && (Intrinsics.areEqual(arg4.getAgentGeneration(), arg5.getAgentGeneration())) && (Intrinsics.areEqual(v0.getSnapshot().getSessionId(), arg5.getSessionId())) && (Intrinsics.areEqual(arg5.getSnapshotDigest(), StretchRecoveryCodec.INSTANCE.snapshotDigest(v0.getSnapshot()))) && (Intrinsics.areEqual(arg5.getPhysicalIdentity(), v0.getSnapshot().getOriginal().getPhysicalIdentity().getValue()))) {
            return 1;
        }

        return 0;
    }

    public final StretchAgentReply readReply(Parcel arg10) {
        StretchOriginalEvidence v9_2;
        Intrinsics.checkNotNullParameter(arg10, "parcel");
        StretchAgentReply v0 = StretchAgentWire.INSTANCE.readReply(arg10);
        String v1 = "Failed requirement.";
        if(arg10.readInt() == 1) {
            int v9 = arg10.readInt();
            if(v9 == 0) {
                v9_2 = null;
            }
            else if(v9 == 1) {
                StretchOriginalEvidenceCodec v9_1 = StretchOriginalEvidenceCodec.INSTANCE;
                String v10 = arg10.readString();
                if(v10 != null) {
                    v9_2 = v9_1.decode(v10);
                }
                else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            else {
                throw new IllegalStateException("Invalid evidence presence".toString());
            }

            StretchOriginalEvidence v6 = v9_2;
            if(v6 != null) {
                if(Intrinsics.areEqual(v6.getAgentGeneration(), v0.getAgentGeneration())) {
                }
                else {
                    throw new IllegalArgumentException(v1.toString());
                }
            }

            return StretchAgentReply.copy$default(v0, null, null, null, null, null, v6, 0x1F, null);
        }

        throw new IllegalArgumentException(v1.toString());
    }

    public final void writeReply(Parcel arg2, StretchAgentReply arg3) {
        Intrinsics.checkNotNullParameter(arg2, "parcel");
        Intrinsics.checkNotNullParameter(arg3, "reply");
        StretchAgentWire.INSTANCE.writeReply(arg2, arg3);
        int v1 = 1;
        arg2.writeInt(1);
        if(arg3.getOriginalEvidence() == null) {
            v1 = 0;
        }

        arg2.writeInt(v1);
        StretchOriginalEvidence v1_1 = arg3.getOriginalEvidence();
        if(v1_1 != null) {
            arg2.writeString(StretchOriginalEvidenceCodec.INSTANCE.encode(v1_1));
        }

        StretchAgentWire.INSTANCE.bounded(arg2);
    }
}

