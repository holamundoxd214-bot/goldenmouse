package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B-\u0012\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJN\u0010\n\u001A\u00020\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00032\u0012\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000E0\u00062\u000E\b\u0002\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\u00032\u0014\b\u0002\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000E0\u0006R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchReadbackWait;", "", "now", "Lkotlin/Function0;", "", "pause", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "await", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidence;", "read", "matches", "", "allowed", "sameTarget", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchReadbackWait {
    public static final int $stable;
    private final Function0 now;
    private final Function1 pause;

    static {
    }

    public StretchReadbackWait(Function0 arg1, Function1 arg2, int arg3, DefaultConstructorMarker arg4) {
        com.TryJeanPc.goldenmouse.stretch.agent.StretchReadbackWait$2 v2;
        StretchReadbackWait$$ExternalSyntheticLambda2 v1;
        if((arg3 & 1) != 0) {
            v1 = new StretchReadbackWait$$ExternalSyntheticLambda2();
        }

        if((arg3 & 2) != 0) {
            v2 = com.TryJeanPc.goldenmouse.stretch.agent.StretchReadbackWait$2.INSTANCE;
        }

        this(((Function0)v1), ((Function1)v2));
    }

    public StretchReadbackWait() {
        this(null, null, 3, null);
    }

    public StretchReadbackWait(Function0 arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "now");
        Intrinsics.checkNotNullParameter(arg3, "pause");
        super();
        this.now = arg2;
        this.pause = arg3;
    }

    static final long _init_$lambda$0() {
        return System.nanoTime() / 1000000;
    }

    public final StretchOriginalEvidence await(Function0 arg10, Function1 arg11, Function0 arg12, Function1 arg13) {
        String v6;
        Throwable v5;
        int v4;
        String v3;
        Intrinsics.checkNotNullParameter(arg10, "read");
        Intrinsics.checkNotNullParameter(arg11, "matches");
        Intrinsics.checkNotNullParameter(arg12, "allowed");
        Intrinsics.checkNotNullParameter(arg13, "sameTarget");
        long v0 = this.now.invoke().longValue() + 2400;
        while(true) {
            v3 = "READBACK_REVOKED";
            if(!arg12.invoke().booleanValue()) {
                goto label_66;
            }

            Object v2 = arg10.invoke();
            if(!arg12.invoke().booleanValue()) {
                goto label_62;
            }

            v4 = 2;
            v5 = null;
            if(!arg13.invoke(v2).booleanValue()) {
                goto label_58;
            }

            v6 = "READBACK_DID_NOT_CONVERGE";
            if(Long.compare(this.now.invoke().longValue(), v0) > 0) {
                goto label_55;
            }

            if(arg11.invoke(v2).booleanValue()) {
                return ((StretchOriginalEvidence)v2);
            }

            long v2_1 = v0 - this.now.invoke().longValue();
            if(v2_1 <= 0) {
                break;
            }

            try {
                this.pause.invoke(Long.valueOf(Math.min(100, v2_1)));
                continue;
            }
            catch(InterruptedException v9) {
                Thread.currentThread().interrupt();
                throw v9;
            }
        }

        throw new StretchCompatibilityFailure(v6, v5, v4, ((DefaultConstructorMarker)v5));
    label_55:
        throw new StretchCompatibilityFailure(v6, v5, v4, ((DefaultConstructorMarker)v5));
    label_58:
        throw new StretchCompatibilityFailure("DISPLAY_TARGET_CHANGED", v5, v4, ((DefaultConstructorMarker)v5));
    label_62:
        throw new IllegalStateException(v3.toString());
    label_66:
        throw new IllegalStateException(v3.toString());
    }

    public static StretchOriginalEvidence await$default(StretchReadbackWait arg0, Function0 arg1, Function1 arg2, Function0 arg3, Function1 arg4, int arg5, Object arg6) {
        StretchReadbackWait$$ExternalSyntheticLambda1 v4;
        StretchReadbackWait$$ExternalSyntheticLambda0 v3;
        if((arg5 & 4) != 0) {
            v3 = new StretchReadbackWait$$ExternalSyntheticLambda0();
        }

        if((arg5 & 8) != 0) {
            v4 = new StretchReadbackWait$$ExternalSyntheticLambda1();
        }

        return arg0.await(arg1, arg2, ((Function0)v3), ((Function1)v4));
    }

    static final boolean await$lambda$1() {
        return 1;
    }

    static final boolean await$lambda$2(StretchOriginalEvidence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return 1;
    }
}

