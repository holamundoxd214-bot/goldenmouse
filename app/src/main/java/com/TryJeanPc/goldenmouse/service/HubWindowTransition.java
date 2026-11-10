package com.TryJeanPc.goldenmouse.service;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\bJ)\u0010\u0010\u001A\u00020\u00052!\u0010\u0011\u001A\u001D\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\t0\u0007J\u0018\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u00052\b\b\u0002\u0010\u0014\u001A\u00020\bR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/service/HubWindowTransition;", "", "<init>", "()V", "generation", "", "completion", "Lkotlin/Function1;", "", "", "running", "getRunning", "()Z", "needsIcon", "hubAvailable", "otherUiOpen", "begin", "onFinished", "Lkotlin/ParameterName;", "name", "cancelled", "finish", "token", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class HubWindowTransition {
    public static final int $stable = 8;
    private Function1 completion;
    private long generation;

    static {
    }

    public HubWindowTransition() {
        super();
    }

    public final long begin(Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "onFinished");
        long v0 = this.generation + 1;
        this.generation = v0;
        this.completion = arg5;
        return v0;
    }

    public final boolean finish(long arg3, boolean arg5) {
        if(Long.compare(arg3, this.generation) != 0) {
            return 0;
        }

        Function1 v3 = this.completion;
        if(v3 == null) {
            return 0;
        }

        this.completion = null;
        v3.invoke(Boolean.valueOf(arg5));
        return 1;
    }

    public static boolean finish$default(HubWindowTransition arg0, long arg1, boolean arg3, int arg4, Object arg5) {
        return arg0.finish(arg1, false);
    }

    public final boolean getRunning() {
        if(this.completion != null) {
            return 1;
        }

        return 0;
    }

    public final boolean needsIcon(boolean arg1, boolean arg2) {
        if(!this.getRunning() && !arg1 && !arg2) {
            return 1;
        }

        return 0;
    }
}

