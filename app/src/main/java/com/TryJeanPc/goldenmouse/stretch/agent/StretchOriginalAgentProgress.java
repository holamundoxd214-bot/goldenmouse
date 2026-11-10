package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0002\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\u0005H\u0002J\'\u0010\n\u001A\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\n\u001A\u00020\u00042\f\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\f0\u000E¢\u0006\u0002\u0010\u000FJ\u001C\u0010\u0010\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u00042\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00060\u000ER \u0010\u0002\u001A\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentProgress;", "", "notify", "Lkotlin/Function2;", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;", "", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "emit", "step", "done", "T", "read", "Lkotlin/Function0;", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "cleanup", "release", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchOriginalAgentProgress {
    public static final int $stable;
    private final Function2 notify;

    static {
    }

    public StretchOriginalAgentProgress(Function2 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "notify");
        super();
        this.notify = arg2;
    }

    public final void cleanup(StretchOriginalAgentStep arg3, Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "step");
        Intrinsics.checkNotNullParameter(arg4, "release");
        try {
            this.emit(arg3, false);
            goto label_12;
        }
        catch(StretchOriginalProgressFailure ) {
            try {
            label_12:
                arg4.invoke();
                if(1 == 0) {
                    return;
                }
            }
            catch(Throwable v4) {
                if(1 != 0) {
                    try {
                        this.emit(arg3, true);
                        goto label_19;
                    }
                    catch(StretchOriginalProgressFailure ) {
                    label_19:
                        throw v4;
                    }
                }

                goto label_19;
            }

            try {
                this.emit(arg3, true);
                return;
            }
            catch(StretchOriginalProgressFailure ) {
                return;
            }
        }
        catch(Throwable v2) {
            arg4.invoke();
            throw v2;
        }
    }

    private final void emit(StretchOriginalAgentStep arg1, boolean arg2) {
        try {
            this.notify.invoke(arg1, Boolean.valueOf(arg2));
            return;
        }
        catch(Exception v0) {
            throw new StretchOriginalProgressFailure(v0);
        }
    }

    public final Object step(StretchOriginalAgentStep arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "step");
        Intrinsics.checkNotNullParameter(arg3, "read");
        this.emit(arg2, false);
        Object v3 = arg3.invoke();
        this.emit(arg2, true);
        return v3;
    }
}

