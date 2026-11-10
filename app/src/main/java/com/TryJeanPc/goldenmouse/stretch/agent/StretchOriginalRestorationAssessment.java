package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatumState;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\b¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalRestorationAssessment;", "", "<init>", "()V", "pendingReasons", "", "", "before", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "after", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchOriginalRestorationAssessment {
    public static final int $stable;
    public static final StretchOriginalRestorationAssessment INSTANCE;

    static {
        StretchOriginalRestorationAssessment.INSTANCE = new StretchOriginalRestorationAssessment();
    }

    private StretchOriginalRestorationAssessment() {
        super();
    }

    public final Set pendingReasons(StretchOriginalEvidence arg6, StretchOriginalEvidence arg7) {
        Intrinsics.checkNotNullParameter(arg6, "before");
        int v5 = 2;
        String[] v0 = new String[v5];
        v0[0] = "COMPOSITOR_RESTORE_NOT_ACCREDITED";
        v0[1] = "PHYSICAL_VALIDATION_REQUIRED";
        Set v0_1 = SetsKt.mutableSetOf(((Object[])v0));
        if(arg7 == null) {
            v0_1.add("NO_READBACK");
        }
        else {
            if(!Intrinsics.areEqual(arg6.getSnapshot().getSessionId(), arg7.getSnapshot().getSessionId()) || !Intrinsics.areEqual(arg6.getAgentGeneration(), arg7.getAgentGeneration()) || !Intrinsics.areEqual(arg6.getOwnerGeneration(), arg7.getOwnerGeneration())) {
                v0_1.add("STALE_READBACK");
            }

            if(!Intrinsics.areEqual(arg6.getSnapshot().getOriginal().getPhysicalIdentity(), arg7.getSnapshot().getOriginal().getPhysicalIdentity())) {
                v0_1.add("DISPLAY_MISMATCH");
            }

            if(!arg6.getStable() || !arg7.getStable() || arg6.getViewport().getViewport() == null || !Intrinsics.areEqual(arg6.getViewport(), arg7.getViewport())) {
                v0_1.add("VIEWPORT_UNVERIFIED");
            }

            if(arg6.getScaling().getState() != RecoveryDatumState.KNOWN || !Intrinsics.areEqual(arg6.getScaling(), arg7.getScaling())) {
                v0_1.add("SCALING_UNVERIFIED");
            }

            RecoveryDatumState[] v5_1 = new RecoveryDatumState[v5];
            v5_1[0] = RecoveryDatumState.KNOWN;
            v5_1[1] = RecoveryDatumState.ABSENT;
            if((SetsKt.setOf(((Object[])v5_1)).contains(arg6.getSizeOverride().getState())) && (Intrinsics.areEqual(arg6.getSizeOverride(), arg7.getSizeOverride()))) {
                goto label_86;
            }

            v0_1.add("OVERRIDE_UNVERIFIED");
        }

    label_86:
        return CollectionsKt.toSet(((Iterable)v0_1));
    }
}

