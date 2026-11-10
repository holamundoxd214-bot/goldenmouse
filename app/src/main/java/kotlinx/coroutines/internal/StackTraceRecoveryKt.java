package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.CoroutineDebuggingKt;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

@Metadata(d1={"\u0000d\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001A\u001F\u0010\t\u001A\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000B2\u0006\u0010\f\u001A\u0002H\nH\u0000¢\u0006\u0002\u0010\r\u001A\u001B\u0010\u000E\u001A\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000B*\u0002H\nH\u0002¢\u0006\u0002\u0010\r\u001A,\u0010\t\u001A\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000B2\u0006\u0010\f\u001A\u0002H\n2\n\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u0010H\u0080\b¢\u0006\u0002\u0010\u0011\u001A+\u0010\u0012\u001A\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000B2\u0006\u0010\f\u001A\u0002H\n2\n\u0010\u000F\u001A\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0002\u0010\u0015\u001A9\u0010\u0016\u001A\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000B2\u0006\u0010\u0017\u001A\u0002H\n2\u0006\u0010\u0018\u001A\u0002H\n2\u0010\u0010\u0019\u001A\f\u0012\b\u0012\u00060\u0004j\u0002`\u001B0\u001AH\u0002¢\u0006\u0002\u0010\u001C\u001A1\u0010\u001D\u001A\u0018\u0012\u0004\u0012\u0002H\n\u0012\u000E\u0012\f\u0012\b\u0012\u00060\u0004j\u0002`\u001B0\u001F0\u001E\"\b\b\u0000\u0010\n*\u00020\u000B*\u0002H\nH\u0002¢\u0006\u0002\u0010 \u001A1\u0010!\u001A\u00020\"2\u0010\u0010#\u001A\f\u0012\b\u0012\u00060\u0004j\u0002`\u001B0\u001F2\u0010\u0010\u0018\u001A\f\u0012\b\u0012\u00060\u0004j\u0002`\u001B0\u001AH\u0002¢\u0006\u0002\u0010$\u001A\u0016\u0010%\u001A\u00020&2\u0006\u0010\f\u001A\u00020\u000BH\u0080H¢\u0006\u0002\u0010\'\u001A \u0010(\u001A\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000B2\u0006\u0010\f\u001A\u0002H\nH\u0081\b¢\u0006\u0002\u0010\r\u001A\u001F\u0010)\u001A\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000B2\u0006\u0010\f\u001A\u0002H\nH\u0001¢\u0006\u0002\u0010\r\u001A\u001E\u0010*\u001A\f\u0012\b\u0012\u00060\u0004j\u0002`\u001B0\u001A2\n\u0010\u000F\u001A\u00060\u0013j\u0002`\u0014H\u0002\u001A\u0010\u0010+\u001A\u00020,*\u00060\u0004j\u0002`\u001BH\u0000\u001A#\u0010-\u001A\u00020.*\f\u0012\b\u0012\u00060\u0004j\u0002`\u001B0\u001F2\u0006\u0010/\u001A\u00020\u0001H\u0002¢\u0006\u0002\u00100\u001A\u001C\u00101\u001A\u00020,*\u00060\u0004j\u0002`\u001B2\n\u00102\u001A\u00060\u0004j\u0002`\u001BH\u0002\u001A\u0014\u00105\u001A\u00020\"*\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u000BH\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0005\u001A\n \u0006*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0018\u0010\b\u001A\n \u0006*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007*\f\b\u0000\u00103\"\u00020\u00132\u00020\u0013*\f\b\u0000\u00104\"\u00020\u00042\u00020\u0004¨\u00066"}, d2={"baseContinuationImplClass", "", "stackTraceRecoveryClass", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "stackTraceRecoveryClassName", "recoverStackTrace", "E", "", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "sanitizeStackTrace", "continuation", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "recoverFromStackFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "createFinalException", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "Lkotlinx/coroutines/internal/StackTraceElement;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "causeAndStacktrace", "Lkotlin/Pair;", "", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "mergeRecoveredTraces", "", "recoveredStacktrace", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unwrap", "unwrapImpl", "createStackTrace", "isArtificial", "", "firstFrameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "elementWiseEquals", "e", "CoroutineStackFrame", "StackTraceElement", "initCause", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class StackTraceRecoveryKt {
    private static final StackTraceElement ARTIFICIAL_FRAME = null;
    private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    private static final String baseContinuationImplClassName = null;
    private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    private static final String stackTraceRecoveryClassName;

    static {
        Object v1_1;
        Object v2_1;
        String v0 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        String v1 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        StackTraceRecoveryKt.ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineBoundary();
        try {
            v2_1 = Result.constructor-impl(Class.forName(v1).getCanonicalName());
        }
        catch(Throwable v2) {
            v2_1 = Result.constructor-impl(ResultKt.createFailure(v2));
        }

        if(Result.exceptionOrNull-impl(v2_1) == null) {
            v1_1 = v2_1;
        }

        StackTraceRecoveryKt.baseContinuationImplClassName = ((String)v1_1);
        try {
            v1_1 = Result.constructor-impl(Class.forName(v0).getCanonicalName());
        }
        catch(Throwable v1_2) {
            v1_1 = Result.constructor-impl(ResultKt.createFailure(v1_2));
        }

        if(Result.exceptionOrNull-impl(v1_1) == null) {
            Object v0_1 = v1_1;
        }

        StackTraceRecoveryKt.stackTraceRecoveryClassName = v0;
    }

    public static final Throwable access$recoverFromStackFrame(Throwable arg0, CoroutineStackFrame arg1) {
        return StackTraceRecoveryKt.recoverFromStackFrame(arg0, arg1);
    }

    private static final Pair causeAndStacktrace(Throwable arg6) {
        Throwable v0 = arg6.getCause();
        if(v0 != null && (Intrinsics.areEqual(v0.getClass(), arg6.getClass()))) {
            StackTraceElement[] v2 = arg6.getStackTrace();
            int v3 = v2.length;
            int v4 = 0;
            while(true) {
                if(v4 >= v3) {
                    break;
                }
                else if(StackTraceRecoveryKt.isArtificial(v2[v4])) {
                    return TuplesKt.to(v0, v2);
                }
                else {
                    ++v4;
                    continue;
                }

                goto label_21;
            }

            return TuplesKt.to(arg6, new StackTraceElement[0]);
        }

    label_21:
        return TuplesKt.to(arg6, new StackTraceElement[0]);
    }

    private static final Throwable createFinalException(Throwable arg5, Throwable arg6, ArrayDeque arg7) {
        arg7.addFirst(StackTraceRecoveryKt.ARTIFICIAL_FRAME);
        StackTraceElement[] v5 = arg5.getStackTrace();
        int v0 = StackTraceRecoveryKt.firstFrameIndex(v5, StackTraceRecoveryKt.baseContinuationImplClassName);
        int v2 = 0;
        if(v0 == -1) {
            arg6.setStackTrace(((Collection)arg7).toArray(new StackTraceElement[0]));
            return arg6;
        }

        StackTraceElement[] v1 = new StackTraceElement[arg7.size() + v0];
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            v1[v3] = v5[v3];
        }

        Iterator v5_1 = ((Iterable)arg7).iterator();
        while(v5_1.hasNext()) {
            v1[v2 + v0] = v5_1.next();
            ++v2;
        }

        arg6.setStackTrace(v1);
        return arg6;
    }

    private static final ArrayDeque createStackTrace(CoroutineStackFrame arg2) {
        ArrayDeque v0 = new ArrayDeque();
        StackTraceElement v1 = arg2.getStackTraceElement();
        if(v1 != null) {
            v0.add(v1);
        }

        while(true) {
            if((arg2 instanceof CoroutineStackFrame)) {
            }
            else {
                arg2 = null;
            }

            if(arg2 != null) {
                arg2 = arg2.getCallerFrame();
                if(arg2 == null) {
                }
                else {
                    v1 = arg2.getStackTraceElement();
                    if(v1 == null) {
                        continue;
                    }

                    v0.add(v1);
                    continue;
                }
            }

            return v0;
        }

        return v0;
    }

    private static final boolean elementWiseEquals(StackTraceElement arg2, StackTraceElement arg3) {
        if(arg2.getLineNumber() == arg3.getLineNumber() && (Intrinsics.areEqual(arg2.getMethodName(), arg3.getMethodName())) && (Intrinsics.areEqual(arg2.getFileName(), arg3.getFileName())) && (Intrinsics.areEqual(arg2.getClassName(), arg3.getClassName()))) {
            return 1;
        }

        return 0;
    }

    private static final int firstFrameIndex(StackTraceElement[] arg3, String arg4) {
        int v0 = arg3.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(Intrinsics.areEqual(arg4, arg3[v1].getClassName())) {
                return v1;
            }
        }

        return -1;
    }

    public static final void initCause(Throwable arg0, Throwable arg1) {
        arg0.initCause(arg1);
    }

    public static final boolean isArtificial(StackTraceElement arg4) {
        return StringsKt.startsWith$default(arg4.getClassName(), CoroutineDebuggingKt.getARTIFICIAL_FRAME_PACKAGE_NAME(), false, 2, null);
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] arg4, ArrayDeque arg5) {
        int v0 = arg4.length;
        int v1 = 0;
        while(true) {
            if(v1 >= v0) {
                break;
            }
            else if(StackTraceRecoveryKt.isArtificial(arg4[v1])) {
            }
            else {
                ++v1;
                continue;
            }

            goto label_10;
        }

        v1 = -1;
    label_10:
        ++v1;
        v0 = arg4.length - 1;
        if(v1 <= v0) {
            while(true) {
                if(StackTraceRecoveryKt.elementWiseEquals(arg4[v0], arg5.getLast())) {
                    arg5.removeLast();
                }

                arg5.addFirst(arg4[v0]);
                if(v0 == v1) {
                    return;
                }

                --v0;
            }
        }
    }

    public static final Object recoverAndThrow(Throwable arg1, Continuation arg2) {
        if(DebugKt.getRECOVER_STACK_TRACES()) {
            if(!(arg2 instanceof CoroutineStackFrame)) {
                throw arg1;
            }

            throw StackTraceRecoveryKt.recoverFromStackFrame(arg1, ((CoroutineStackFrame)arg2));
        }

        throw arg1;
    }

    private static final Object recoverAndThrow$$forInline(Throwable arg1, Continuation arg2) {
        if(DebugKt.getRECOVER_STACK_TRACES()) {
            if(!(arg2 instanceof CoroutineStackFrame)) {
                throw arg1;
            }

            throw StackTraceRecoveryKt.recoverFromStackFrame(arg1, ((CoroutineStackFrame)arg2));
        }

        throw arg1;
    }

    private static final Throwable recoverFromStackFrame(Throwable arg4, CoroutineStackFrame arg5) {
        ArrayDeque v5;
        Pair v0 = StackTraceRecoveryKt.causeAndStacktrace(arg4);
        Object v1 = v0.component1();
        Object v0_1 = v0.component2();
        Throwable v2 = ExceptionsConstructorKt.tryCopyException(((Throwable)v1));
        if(v2 == null) {
        }
        else {
            v5 = StackTraceRecoveryKt.createStackTrace(arg5);
            if(v5.isEmpty()) {
                return arg4;
            }

            goto label_10;
        }

        return arg4;
    label_10:
        if((((Throwable)v1)) != arg4) {
            StackTraceRecoveryKt.mergeRecoveredTraces(((StackTraceElement[])v0_1), v5);
        }

        return StackTraceRecoveryKt.createFinalException(((Throwable)v1), v2, v5);
    }

    public static final Throwable recoverStackTrace(Throwable arg1) {
        Throwable v0;
        if(!DebugKt.getRECOVER_STACK_TRACES()) {
        }
        else {
            v0 = ExceptionsConstructorKt.tryCopyException(arg1);
            if(v0 == null) {
                return arg1;
            }

            goto label_6;
        }

        return arg1;
    label_6:
        return StackTraceRecoveryKt.sanitizeStackTrace(v0);
    }

    public static final Throwable recoverStackTrace(Throwable arg1, Continuation arg2) {
        if(DebugKt.getRECOVER_STACK_TRACES()) {
            if(!(arg2 instanceof CoroutineStackFrame)) {
            }
            else {
                arg1 = StackTraceRecoveryKt.recoverFromStackFrame(arg1, ((CoroutineStackFrame)arg2));
            }
        }

        return arg1;
    }

    private static final Throwable sanitizeStackTrace(Throwable arg7) {
        int v4;
        StackTraceElement[] v0 = arg7.getStackTrace();
        int v1 = v0.length;
        int v3 = -1;
        int v2 = v0.length + v3;
        if(v2 >= 0) {
            while(true) {
                v4 = v2 - 1;
                if(Intrinsics.areEqual(StackTraceRecoveryKt.stackTraceRecoveryClassName, v0[v2].getClassName())) {
                    break;
                }
                else if(v4 < 0) {
                    goto label_17;
                }
                else {
                    v2 = v4;
                    continue;
                }
            }
        }
        else {
        label_17:
            v2 = v3;
        }

        v4 = v2 + 1;
        int v5 = StackTraceRecoveryKt.firstFrameIndex(v0, StackTraceRecoveryKt.baseContinuationImplClassName);
        int v6 = 0;
        v3 = v5 == v3 ? 0 : v1 - v5;
        v1 = v1 - v2 - v3;
        StackTraceElement[] v2_1 = new StackTraceElement[v1];
        while(v6 < v1) {
            StackTraceElement v3_1 = v6 == 0 ? StackTraceRecoveryKt.ARTIFICIAL_FRAME : v0[v4 + v6 - 1];
            v2_1[v6] = v3_1;
            ++v6;
        }

        arg7.setStackTrace(v2_1);
        return arg7;
    }

    public static final Throwable unwrap(Throwable arg1) {
        if(!DebugKt.getRECOVER_STACK_TRACES()) {
            return arg1;
        }

        return StackTraceRecoveryKt.unwrapImpl(arg1);
    }

    public static final Throwable unwrapImpl(Throwable arg5) {
        Throwable v0 = arg5.getCause();
        if(v0 != null) {
            if(!Intrinsics.areEqual(v0.getClass(), arg5.getClass())) {
            }
            else {
                StackTraceElement[] v1 = arg5.getStackTrace();
                int v2 = v1.length;
                int v3 = 0;
                while(v3 < v2) {
                    if(StackTraceRecoveryKt.isArtificial(v1[v3])) {
                        return v0;
                    }
                    else {
                        ++v3;
                        continue;
                    }

                    return arg5;
                }
            }
        }

        return arg5;
    }
}

