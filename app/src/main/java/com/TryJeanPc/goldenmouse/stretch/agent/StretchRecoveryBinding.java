package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.StretchDisplayIdentity;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchOriginalDisplayState;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\b\u0081\b\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J1\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001A\u00020\u000F2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001B\u001A\u00020\u0013HÖ\u0001J\t\u0010\u001C\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u001E"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRecoveryBinding;", "", "session", "", "agent", "owner", "digest", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSession", "()Ljava/lang/String;", "getAgent", "getOwner", "getDigest", "matches", "", "record", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCandidateRecord;", "ownerUid", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchRecoveryBinding {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRecoveryBinding$Companion;", "", "<init>", "()V", "from", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchRecoveryBinding;", "e", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final StretchRecoveryBinding from(StretchOriginalEvidence arg18) {
            StretchOriginalEvidence v5 = arg18;
            Intrinsics.checkNotNullParameter(v5, "e");
            StretchOriginalDisplayState v0 = v5.getSnapshot().getOriginal();
            StretchCompositorState v1 = v5.getCompositor().getState();
            if(v1 != null) {
                String v16 = "Failed requirement.";
                if((v5.getStable()) && (v5.getCompositor().getStable())) {
                    Object v2 = v0.getLogicalIdentity().getValue();
                    if(v2 != null && ((StretchDisplayIdentity)v2).getLogicalId() == 0) {
                        if(Intrinsics.areEqual(v0.getPhysicalIdentity().getValue(), v1.getPhysicalIdentity())) {
                            v2 = v0.getRotation().getValue();
                            int v3 = v1.getProjection().getRotation();
                            if(v2 != null && ((Integer)v2).intValue() == v3 && (Intrinsics.areEqual(v0.getReferenceSize().getValue(), v1.getDisplaySize()))) {
                                if(StretchCandidateRecordCodec.INSTANCE.valid(new StretchCandidateRecord(1, 10000, v5, CandidatePhase.CAPTURED, null, null, null, null, null, null, null, 0x7F0, null))) {
                                    return new StretchRecoveryBinding(arg18.getSnapshot().getSessionId(), arg18.getAgentGeneration(), arg18.getOwnerGeneration(), arg18.getSnapshotDigest());
                                }
                                else {
                                    throw new IllegalArgumentException(v16.toString());
                                }
                            }
                        }

                        throw new IllegalArgumentException(v16.toString());
                    }
                }

                throw new IllegalArgumentException(v16.toString());
            }

            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final String agent;
    private final String digest;
    private final String owner;
    private final String session;

    static {
        StretchRecoveryBinding.Companion = new Companion(null);
    }

    public StretchRecoveryBinding(String arg3, String arg4, String arg5, String arg6) {
        Intrinsics.checkNotNullParameter(arg3, "session");
        Intrinsics.checkNotNullParameter(arg4, "agent");
        Intrinsics.checkNotNullParameter(arg5, "owner");
        Intrinsics.checkNotNullParameter(arg6, "digest");
        super();
        this.session = arg3;
        this.agent = arg4;
        this.owner = arg5;
        this.digest = arg6;
        List v3 = CollectionsKt.listOf(new String[]{arg3, arg4, arg5, arg6});
        if(!(v3 instanceof Collection) || !v3.isEmpty()) {
            Iterator v3_1 = ((Iterable)v3).iterator();
            while(true) {
                if(!v3_1.hasNext()) {
                    break;
                }
                else if(StretchAgentProtocolKt.validAgentText(v3_1.next())) {
                    continue;
                }

                goto label_44;
            }

        label_37:
            if(new Regex("[0-9a-f]{64}").matches(this.digest)) {
                return;
            }
        }
        else {
            goto label_37;
        }

    label_44:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final String component1() {
        return this.session;
    }

    public final String component2() {
        return this.agent;
    }

    public final String component3() {
        return this.owner;
    }

    public final String component4() {
        return this.digest;
    }

    public final StretchRecoveryBinding copy(String arg1, String arg2, String arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg1, "session");
        Intrinsics.checkNotNullParameter(arg2, "agent");
        Intrinsics.checkNotNullParameter(arg3, "owner");
        Intrinsics.checkNotNullParameter(arg4, "digest");
        return new StretchRecoveryBinding(arg1, arg2, arg3, arg4);
    }

    public static StretchRecoveryBinding copy$default(StretchRecoveryBinding arg0, String arg1, String arg2, String arg3, String arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.session;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.agent;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.owner;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.digest;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((StretchRecoveryBinding)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof StretchRecoveryBinding)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.session, ((StretchRecoveryBinding)arg5).session)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.agent, ((StretchRecoveryBinding)arg5).agent)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.owner, ((StretchRecoveryBinding)arg5).owner)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.digest, ((StretchRecoveryBinding)arg5).digest)) {
            return 0;
        }

        return 1;
    }

    public final String getAgent() {
        return this.agent;
    }

    public final String getDigest() {
        return this.digest;
    }

    public final String getOwner() {
        return this.owner;
    }

    public final String getSession() {
        return this.session;
    }

    public int hashCode() {
        return ((this.session.hashCode() * 0x1F + this.agent.hashCode()) * 0x1F + this.owner.hashCode()) * 0x1F + this.digest.hashCode();
    }

    public final boolean matches(StretchCandidateRecord arg3, int arg4) {
        Object v2_1;
        Intrinsics.checkNotNullParameter(arg3, "record");
        boolean v1 = false;
        if(arg3.getOwnerUid() == arg4) {
            try {
                v2_1 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(StretchRecoveryBinding.Companion.from(arg3.getEvidence()), this)));
            }
            catch(Throwable v2) {
                v2_1 = Result.constructor-impl(ResultKt.createFailure(v2));
            }

            Boolean v3 = Boolean.valueOf(false);
            if(Result.isFailure-impl(v2_1)) {
                Boolean v2_2 = v3;
            }

            if(!v2_2.booleanValue()) {
                return v1;
            }

            v1 = true;
        }

        return v1;
    }

    public String toString() {
        return "StretchRecoveryBinding(session=" + this.session + ", agent=" + this.agent + ", owner=" + this.owner + ", digest=" + this.digest + ")";
    }
}

