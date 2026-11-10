package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B%\b\u0000\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ)\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0015\u001A\u00020\u00162\n\u0010\u001E\u001A\u0006\u0012\u0002\b\u00030\u001F2\u0006\u0010 \u001A\u00020!H\u0000¢\u0006\u0002\b\"J\u0013\u0010-\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0000¢\u0006\u0002\b.J\u000E\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\"\u0010/\u001A\u00020\u001D*\b\u0012\u0004\u0012\u00020\u0012002\b\u0010\u001E\u001A\u0004\u0018\u00010&H\u0082P¢\u0006\u0002\u00101J\b\u00102\u001A\u00020\u0016H\u0016R\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0010\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u00118F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u00168@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001A\u00020\u00168\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010#\u001A\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u001A\u0010%\u001A\n\u0012\u0004\u0012\u00020&\u0018\u00010\r8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R(\u0010(\u001A\u0004\u0018\u00010&2\b\u0010\'\u001A\u0004\u0018\u00010&8@@@X\u0080\u000E¢\u0006\f\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00063"}, d2={"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "creationStackBottom", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "sequenceNumber", "", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/debug/internal/StackTraceFrame;J)V", "getCreationStackBottom$kotlinx_coroutines_core", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "_context", "Ljava/lang/ref/WeakReference;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "creationStackTrace", "", "Ljava/lang/StackTraceElement;", "getCreationStackTrace", "()Ljava/util/List;", "state", "", "getState$kotlinx_coroutines_core", "()Ljava/lang/String;", "_state", "unmatchedResume", "", "updateState", "", "frame", "Lkotlin/coroutines/Continuation;", "shouldBeMatched", "", "updateState$kotlinx_coroutines_core", "lastObservedThread", "Ljava/lang/Thread;", "_lastObservedFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "value", "lastObservedFrame", "getLastObservedFrame$kotlinx_coroutines_core", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "setLastObservedFrame$kotlinx_coroutines_core", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "lastObservedStackTrace", "lastObservedStackTrace$kotlinx_coroutines_core", "yieldFrames", "Lkotlin/sequences/SequenceScope;", "(Lkotlin/sequences/SequenceScope;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DebugCoroutineInfoImpl {
    private final WeakReference _context;
    public volatile WeakReference _lastObservedFrame;
    public volatile String _state;
    private final StackTraceFrame creationStackBottom;
    public volatile Thread lastObservedThread;
    public final long sequenceNumber;
    private int unmatchedResume;

    public DebugCoroutineInfoImpl(CoroutineContext arg1, StackTraceFrame arg2, long arg3) {
        super();
        this.creationStackBottom = arg2;
        this.sequenceNumber = arg3;
        this._context = new WeakReference(arg1);
        this._state = "CREATED";
    }

    public static final Object access$yieldFrames(DebugCoroutineInfoImpl arg0, SequenceScope arg1, CoroutineStackFrame arg2, Continuation arg3) {
        return arg0.yieldFrames(arg1, arg2, arg3);
    }

    private final List creationStackTrace() {
        StackTraceFrame v0 = this.creationStackBottom;
        if(v0 == null) {
            return CollectionsKt.emptyList();
        }

        return SequencesKt.toList(SequencesKt.sequence(new DebugCoroutineInfoImpl$creationStackTrace$1(this, v0, null)));
    }

    public final CoroutineContext getContext() {
        return this._context.get();
    }

    public final StackTraceFrame getCreationStackBottom$kotlinx_coroutines_core() {
        return this.creationStackBottom;
    }

    public final List getCreationStackTrace() {
        return this.creationStackTrace();
    }

    public final CoroutineStackFrame getLastObservedFrame$kotlinx_coroutines_core() {
        WeakReference v0 = this._lastObservedFrame;
        if(v0 != null) {
            return v0.get();
        }

        return null;
    }

    public final String getState$kotlinx_coroutines_core() {
        return this._state;
    }

    public final List lastObservedStackTrace$kotlinx_coroutines_core() {
        CoroutineStackFrame v2 = this.getLastObservedFrame$kotlinx_coroutines_core();
        if(v2 == null) {
            return CollectionsKt.emptyList();
        }

        ArrayList v0 = new ArrayList();
        while(v2 != null) {
            StackTraceElement v1 = v2.getStackTraceElement();
            if(v1 != null) {
                v0.add(v1);
            }

            v2 = v2.getCallerFrame();
        }

        return ((List)v0);
    }

    public final void setLastObservedFrame$kotlinx_coroutines_core(CoroutineStackFrame arg2) {
        WeakReference v0 = arg2 != null ? new WeakReference(arg2) : null;
        this._lastObservedFrame = v0;
    }

    public String toString() {
        return "DebugCoroutineInfo(state=" + this.getState$kotlinx_coroutines_core() + ",context=" + this.getContext() + ')';
    }

    public final void updateState$kotlinx_coroutines_core(String arg3, Continuation arg4, boolean arg5) {
        CoroutineStackFrame v4;
        __monitor_enter(this);
        try {
            if((Intrinsics.areEqual(this._state, "RUNNING")) && (Intrinsics.areEqual(arg3, "RUNNING")) && (arg5)) {
                ++this.unmatchedResume;
            }
            else if(this.unmatchedResume > 0 && (Intrinsics.areEqual(arg3, "SUSPENDED"))) {
                --this.unmatchedResume;
                goto label_21;
            }

            goto label_23;
        }
        catch(Throwable v3) {
            goto label_48;
        }

    label_21:
        __monitor_exit(this);
        return;
        try {
        label_23:
            if((Intrinsics.areEqual(this._state, arg3)) && (Intrinsics.areEqual(arg3, "SUSPENDED")) && this.getLastObservedFrame$kotlinx_coroutines_core() != null) {
                goto label_31;
            }

            goto label_33;
        }
        catch(Throwable v3) {
            goto label_48;
        }

    label_31:
        __monitor_exit(this);
        return;
        try {
        label_33:
            this._state = arg3;
            Thread v0 = null;
            if((arg4 instanceof CoroutineStackFrame)) {
            }
            else {
                v4 = ((CoroutineStackFrame)v0);
            }

            this.setLastObservedFrame$kotlinx_coroutines_core(v4);
            if(Intrinsics.areEqual(arg3, "RUNNING")) {
                v0 = Thread.currentThread();
            }

            this.lastObservedThread = v0;
        }
        catch(Throwable v3) {
            try {
            label_48:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_48;
            }

            throw v3;
        }

        __monitor_exit(this);
    }

    private final Object yieldFrames(SequenceScope arg6, CoroutineStackFrame arg7, Continuation arg8) {
        Object v7;
        Object v6;
        Object v5;
        int v2;
        Continuation v0;
        if((arg8 instanceof DebugCoroutineInfoImpl$yieldFrames$1)) {
            v0 = arg8;
            v2 = 0x80000000;
            if((((DebugCoroutineInfoImpl$yieldFrames$1)v0).label & v2) != 0) {
                ((DebugCoroutineInfoImpl$yieldFrames$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            DebugCoroutineInfoImpl$yieldFrames$1 v0_1 = new DebugCoroutineInfoImpl$yieldFrames$1(this, arg8);
        }

        Object v8 = ((DebugCoroutineInfoImpl$yieldFrames$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((DebugCoroutineInfoImpl$yieldFrames$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            goto label_29;
        label_44:
            Object v4 = v7;
            v7 = v6;
            v6 = v4;
        label_47:
            arg7 = arg7.getCallerFrame();
            if(arg7 != null) {
            }
            else {
                return Unit.INSTANCE;
            }
        }
        else if(v2 == 1) {
            v5 = ((DebugCoroutineInfoImpl$yieldFrames$1)v0).L$2;
            v6 = ((DebugCoroutineInfoImpl$yieldFrames$1)v0).L$1;
            v7 = ((DebugCoroutineInfoImpl$yieldFrames$1)v0).L$0;
            ResultKt.throwOnFailure(v8);
            goto label_44;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_29:
        if(arg7 == null) {
            return Unit.INSTANCE;
        }

        StackTraceElement v8_1 = arg7.getStackTraceElement();
        if(v8_1 == null) {
            goto label_47;
        }

        ((DebugCoroutineInfoImpl$yieldFrames$1)v0).L$0 = v6;
        ((DebugCoroutineInfoImpl$yieldFrames$1)v0).L$1 = arg7;
        ((DebugCoroutineInfoImpl$yieldFrames$1)v0).L$2 = v5;
        ((DebugCoroutineInfoImpl$yieldFrames$1)v0).label = 1;
        if(((SequenceScope)v6).yield(v8_1, v0) == v1) {
            return v1;
        }

        CoroutineStackFrame v4_1 = arg7;
        SequenceScope v7_1 = ((SequenceScope)v6);
        CoroutineStackFrame v6_1 = v4_1;
        goto label_44;
    }
}

