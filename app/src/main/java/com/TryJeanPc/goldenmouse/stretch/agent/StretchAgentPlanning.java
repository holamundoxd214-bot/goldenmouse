package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.GoldenStretchGeometryCalculator;
import com.TryJeanPc.goldenmouse.stretch.StretchCalculation$Valid;
import com.TryJeanPc.goldenmouse.stretch.StretchCalculation;
import com.TryJeanPc.goldenmouse.stretch.StretchDisplaySnapshot;
import com.TryJeanPc.goldenmouse.stretch.StretchGeometryPlan;
import com.TryJeanPc.goldenmouse.stretch.StretchProjection$Defined;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchOriginalDisplayState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u0018\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentPlanning;", "", "<init>", "()V", "geometry", "Lcom/TryJeanPc/goldenmouse/stretch/StretchCalculation;", "baseline", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentBaseline;", "factorHundredths", "", "sizeDraft", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchSizeDraft;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchAgentPlanning {
    public static final int $stable;
    public static final StretchAgentPlanning INSTANCE;

    static {
        StretchAgentPlanning.INSTANCE = new StretchAgentPlanning();
    }

    private StretchAgentPlanning() {
        super();
    }

    public final StretchCalculation geometry(StretchAgentBaseline arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg9, "baseline");
        StretchOriginalDisplayState v8 = arg9.getSnapshot().getOriginal();
        return new GoldenStretchGeometryCalculator().calculate(new StretchDisplaySnapshot(v8.getLogicalIdentity().getValue(), v8.getLogicalSize().getValue(), v8.getRotation().getValue(), v8.getReferenceSize().getValue(), null, 16, null), arg10);
    }

    public final StretchSizeDraft sizeDraft(StretchAgentBaseline arg2, int arg3) {
        StretchSize v2_1;
        Intrinsics.checkNotNullParameter(arg2, "baseline");
        StretchCalculation v1 = this.geometry(arg2, arg3);
        StretchSizeDraft v3 = null;
        if((v1 instanceof Valid)) {
        }
        else {
            v1 = ((StretchCalculation)v3);
        }

        if(v1 != null) {
            StretchGeometryPlan v1_1 = ((Valid)v1).getPlan();
            if(v1_1 == null) {
            }
            else if(!(v1_1.getProjection() instanceof Defined)) {
                return v3;
            }
            else {
                Integer v2 = v1_1.getRotation();
                if(v2 == null || v2.intValue() != 1) {
                    v2 = v1_1.getRotation();
                    if(v2 == null) {
                    }
                    else if(v2.intValue() == 3) {
                        goto label_31;
                    }

                    v2_1 = v1_1.getTargetLogical();
                }
                else {
                label_31:
                    v2_1 = new StretchSize(v1_1.getTargetLogical().getHeight(), v1_1.getTargetLogical().getWidth());
                }

                v3 = new StretchSizeDraft(v1_1.getTargetLogical(), v2_1, v1_1.getDisplay().getLogicalId());
            }
        }

        return v3;
    }
}

