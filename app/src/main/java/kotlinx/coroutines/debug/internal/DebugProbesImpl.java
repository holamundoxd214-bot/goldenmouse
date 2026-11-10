package kotlinx.coroutines.debug.internal;

import _COROUTINE.ArtificialStackFrames;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata(d1={"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001~B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010&\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002J\r\u0010*\u001A\u00020%H\u0000¢\u0006\u0002\b+J\r\u0010,\u001A\u00020%H\u0000¢\u0006\u0002\b-J\b\u0010.\u001A\u00020%H\u0002J\b\u0010/\u001A\u00020%H\u0002J\u0015\u00100\u001A\u0002012\u0006\u00102\u001A\u000203H\u0000¢\u0006\u0002\b4J4\u00105\u001A\u00020%*\u0002032\u0012\u00106\u001A\u000E\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020)072\n\u00108\u001A\u000609j\u0002`:2\u0006\u0010;\u001A\u000201H\u0002J9\u0010A\u001A\b\u0012\u0004\u0012\u0002HC0B\"\b\b\u0000\u0010C*\u00020\u00012\u001E\b\u0004\u0010D\u001A\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u0002HC0EH\u0082\bJ\u0011\u0010G\u001A\b\u0012\u0004\u0012\u00020\u00010H¢\u0006\u0002\u0010IJ\u000E\u0010J\u001A\u0002012\u0006\u0010K\u001A\u00020LJ\f\u0010M\u001A\u000201*\u00020\u0001H\u0002J\f\u0010N\u001A\b\u0012\u0004\u0012\u00020L0BJ\f\u0010O\u001A\b\u0012\u0004\u0012\u00020P0BJ\u0010\u0010Q\u001A\u00020%2\u0006\u0010R\u001A\u00020SH\u0001J\u0010\u0010T\u001A\u00020\r*\u0006\u0012\u0002\b\u00030\fH\u0002J\u0010\u0010U\u001A\u00020%2\u0006\u0010R\u001A\u00020SH\u0002J\u001E\u0010V\u001A\u00020%2\u0006\u0010R\u001A\u00020S2\f\u0010W\u001A\b\u0012\u0004\u0012\u00020\u00050BH\u0002J\"\u0010X\u001A\b\u0012\u0004\u0012\u00020\u00050B2\u0006\u0010K\u001A\u00020L2\f\u0010Y\u001A\b\u0012\u0004\u0012\u00020\u00050BJ.\u0010Z\u001A\b\u0012\u0004\u0012\u00020\u00050B2\u0006\u0010[\u001A\u0002012\b\u0010\\\u001A\u0004\u0018\u00010\t2\f\u0010Y\u001A\b\u0012\u0004\u0012\u00020\u00050BH\u0002J=\u0010]\u001A\u000E\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020_0^2\u0006\u0010`\u001A\u00020_2\f\u0010a\u001A\b\u0012\u0004\u0012\u00020\u00050H2\f\u0010Y\u001A\b\u0012\u0004\u0012\u00020\u00050BH\u0002¢\u0006\u0002\u0010bJ1\u0010c\u001A\u00020_2\u0006\u0010d\u001A\u00020_2\f\u0010a\u001A\b\u0012\u0004\u0012\u00020\u00050H2\f\u0010Y\u001A\b\u0012\u0004\u0012\u00020\u00050BH\u0002¢\u0006\u0002\u0010eJ\u0019\u0010f\u001A\u00020%2\n\u0010g\u001A\u0006\u0012\u0002\b\u00030hH\u0000¢\u0006\u0002\biJ\u0019\u0010j\u001A\u00020%2\n\u0010g\u001A\u0006\u0012\u0002\b\u00030hH\u0000¢\u0006\u0002\bkJ\u001C\u0010l\u001A\u00020%2\n\u0010g\u001A\u0006\u0012\u0002\b\u00030h2\u0006\u0010[\u001A\u000201H\u0002J\u0018\u0010m\u001A\u00020%2\u0006\u0010g\u001A\u00020(2\u0006\u0010[\u001A\u000201H\u0002J\u000F\u0010n\u001A\u0004\u0018\u00010(*\u00020(H\u0082\u0010J(\u0010l\u001A\u00020%2\n\u0010o\u001A\u0006\u0012\u0002\b\u00030\f2\n\u0010g\u001A\u0006\u0012\u0002\b\u00030h2\u0006\u0010[\u001A\u000201H\u0002J\u0016\u0010o\u001A\b\u0012\u0002\b\u0003\u0018\u00010\f*\u0006\u0012\u0002\b\u00030hH\u0002J\u0013\u0010o\u001A\b\u0012\u0002\b\u0003\u0018\u00010\f*\u00020(H\u0082\u0010J\'\u0010p\u001A\b\u0012\u0004\u0012\u0002Hq0h\"\u0004\b\u0000\u0010q2\f\u0010r\u001A\b\u0012\u0004\u0012\u0002Hq0hH\u0000¢\u0006\u0002\bsJ\u0012\u0010t\u001A\u00020u*\b\u0012\u0004\u0012\u00020\u00050BH\u0002J,\u0010v\u001A\b\u0012\u0004\u0012\u0002Hq0h\"\u0004\b\u0000\u0010q2\f\u0010r\u001A\b\u0012\u0004\u0012\u0002Hq0h2\b\u0010g\u001A\u0004\u0018\u00010uH\u0002J\u0014\u0010w\u001A\u00020%2\n\u0010o\u001A\u0006\u0012\u0002\b\u00030\fH\u0002J%\u0010x\u001A\b\u0012\u0004\u0012\u00020\u00050B\"\b\b\u0000\u0010q*\u00020y2\u0006\u0010z\u001A\u0002HqH\u0002¢\u0006\u0002\u0010{R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\n\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\r0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u000E\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000F8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\t\u0010\u0012\u001A\u00020\u0013X\u0082\u0004R\u0011\u0010\u0014\u001A\u00020\r8G¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\t\u0010\u0017\u001A\u00020\u0018X\u0082\u0004R\u001A\u0010\u0019\u001A\u00020\rX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0016\"\u0004\b\u001B\u0010\u001CR\u001A\u0010\u001D\u001A\u00020\rX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u0016\"\u0004\b\u001F\u0010\u001CR\u001A\u0010 \u001A\u00020\rX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u001CR\u001C\u0010#\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010<\u001A\u000201*\u0002038BX\u0082\u0004¢\u0006\f\u0012\u0004\b=\u0010>\u001A\u0004\b?\u0010@R\u0018\u0010|\u001A\u00020\r*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b|\u0010}¨\u0006\u007F"}, d2={"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "<init>", "()V", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "dateFormat", "Ljava/text/SimpleDateFormat;", "weakRefCleanerThread", "Ljava/lang/Thread;", "capturedCoroutinesMap", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "", "capturedCoroutines", "", "getCapturedCoroutines", "()Ljava/util/Set;", "installations", "Lkotlinx/atomicfu/AtomicInt;", "isInstalled", "isInstalled$kotlinx_coroutines_debug", "()Z", "sequenceNumber", "Lkotlinx/atomicfu/AtomicLong;", "sanitizeStackTraces", "getSanitizeStackTraces$kotlinx_coroutines_core", "setSanitizeStackTraces$kotlinx_coroutines_core", "(Z)V", "enableCreationStackTraces", "getEnableCreationStackTraces$kotlinx_coroutines_core", "setEnableCreationStackTraces$kotlinx_coroutines_core", "ignoreCoroutinesWithEmptyContext", "getIgnoreCoroutinesWithEmptyContext", "setIgnoreCoroutinesWithEmptyContext", "dynamicAttach", "Lkotlin/Function1;", "", "getDynamicAttach", "callerInfoCache", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "install", "install$kotlinx_coroutines_core", "uninstall", "uninstall$kotlinx_coroutines_core", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "hierarchyToString", "", "job", "Lkotlinx/coroutines/Job;", "hierarchyToString$kotlinx_coroutines_core", "build", "map", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "indent", "debugString", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "getDebugString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "dumpCoroutinesInfoImpl", "", "R", "create", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "dumpCoroutinesInfoAsJsonAndReferences", "", "()[Ljava/lang/Object;", "enhanceStackTraceWithThreadDumpAsJson", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "toStringRepr", "dumpCoroutinesInfo", "dumpDebuggerInfo", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "dumpCoroutines", "out", "Ljava/io/PrintStream;", "isFinished", "dumpCoroutinesSynchronized", "printStackTrace", "frames", "enhanceStackTraceWithThreadDump", "coroutineTrace", "enhanceStackTraceWithThreadDumpImpl", "state", "thread", "findContinuationStartIndex", "Lkotlin/Pair;", "", "indexOfResumeWith", "actualTrace", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "findIndexOfFrame", "frameIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "probeCoroutineResumed", "frame", "Lkotlin/coroutines/Continuation;", "probeCoroutineResumed$kotlinx_coroutines_core", "probeCoroutineSuspended", "probeCoroutineSuspended$kotlinx_coroutines_core", "updateState", "updateRunningState", "realCaller", "owner", "probeCoroutineCreated", "T", "completion", "probeCoroutineCreated$kotlinx_coroutines_core", "toStackTraceFrame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "createOwner", "probeCoroutineCompleted", "sanitizeStackTrace", "", "throwable", "(Ljava/lang/Throwable;)Ljava/util/List;", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "CoroutineOwner", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DebugProbesImpl {
    @Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u001F\b\u0000\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0016J\u001B\u0010\u0012\u001A\u00020\u00132\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016R\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001A\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0016\u0010\r\u001A\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0012\u0010\u0019\u001A\u00020\u001AX\u0096\u0005¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2={"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;)V", "frame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getFrame", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CoroutineOwner implements Continuation, CoroutineStackFrame {
        public final Continuation delegate;
        public final DebugCoroutineInfoImpl info;

        public CoroutineOwner(Continuation arg1, DebugCoroutineInfoImpl arg2) {
            super();
            this.delegate = arg1;
            this.info = arg2;
        }

        public CoroutineStackFrame getCallerFrame() {
            StackTraceFrame v0 = this.getFrame();
            if(v0 != null) {
                return v0.getCallerFrame();
            }

            return null;
        }

        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        private final StackTraceFrame getFrame() {
            return this.info.getCreationStackBottom$kotlinx_coroutines_core();
        }

        public StackTraceElement getStackTraceElement() {
            StackTraceFrame v0 = this.getFrame();
            if(v0 != null) {
                return v0.getStackTraceElement();
            }

            return null;
        }

        public void resumeWith(Object arg2) {
            DebugProbesImpl.INSTANCE.probeCoroutineCompleted(this);
            this.delegate.resumeWith(arg2);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private static final StackTraceElement ARTIFICIAL_FRAME;
    public static final DebugProbesImpl INSTANCE;
    private static final ConcurrentWeakMap callerInfoCache;
    private static final ConcurrentWeakMap capturedCoroutinesMap;
    private static final SimpleDateFormat dateFormat;
    private static final Function1 dynamicAttach;
    private static boolean enableCreationStackTraces;
    private static boolean ignoreCoroutinesWithEmptyContext;
    private static boolean sanitizeStackTraces;
    private static Thread weakRefCleanerThread;

    static {
        DebugProbesImpl v0 = new DebugProbesImpl();
        DebugProbesImpl.INSTANCE = v0;
        DebugProbesImpl.ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineCreation();
        DebugProbesImpl.dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DebugProbesImpl.capturedCoroutinesMap = new ConcurrentWeakMap(false, 1, null);
        DebugProbesImpl.installations = new AtomicInteger(0);
        DebugProbesImpl.sequenceNumber = new AtomicLong(0);
        DebugProbesImpl.sanitizeStackTraces = true;
        DebugProbesImpl.ignoreCoroutinesWithEmptyContext = true;
        DebugProbesImpl.dynamicAttach = v0.getDynamicAttach();
        DebugProbesImpl.callerInfoCache = new ConcurrentWeakMap(true);
    }

    private DebugProbesImpl() {
        super();
    }

    public static final boolean access$isFinished(DebugProbesImpl arg0, CoroutineOwner arg1) {
        return arg0.isFinished(arg1);
    }

    public static final void access$probeCoroutineCompleted(DebugProbesImpl arg0, CoroutineOwner arg1) {
        arg0.probeCoroutineCompleted(arg1);
    }

    private final void build(Job arg7, Map arg8, StringBuilder arg9, String arg10) {
        Object v0 = arg8.get(arg7);
        char v1 = '\t';
        char v2 = '\n';
        if(v0 != null) {
            arg9.append(arg10 + this.getDebugString(arg7) + ", continuation is " + ((DebugCoroutineInfoImpl)v0).getState$kotlinx_coroutines_core() + " at line " + CollectionsKt.firstOrNull(((DebugCoroutineInfoImpl)v0).lastObservedStackTrace$kotlinx_coroutines_core()) + v2);
            arg10 = arg10 + v1;
        }
        else if(!(arg7 instanceof ScopeCoroutine)) {
            arg9.append(arg10 + this.getDebugString(arg7) + v2);
            arg10 = arg10 + v1;
        }

        Iterator v7 = arg7.getChildren().iterator();
        while(v7.hasNext()) {
            this.build(v7.next(), arg8, arg9, arg10);
        }
    }

    private final Continuation createOwner(Continuation arg5, StackTraceFrame arg6) {
        if(!this.isInstalled$kotlinx_coroutines_debug()) {
            return arg5;
        }

        CoroutineOwner v6 = new CoroutineOwner(arg5, new DebugCoroutineInfoImpl(arg5.getContext(), arg6, this.getSequenceNumber().incrementAndGet()));
        ConcurrentWeakMap v5 = DebugProbesImpl.capturedCoroutinesMap;
        v5.put(v6, Boolean.valueOf(true));
        if(!this.isInstalled$kotlinx_coroutines_debug()) {
            v5.clear();
        }

        return ((Continuation)v6);
    }

    public final void dumpCoroutines(PrintStream arg1) {
        __monitor_enter(arg1);
        try {
            DebugProbesImpl.INSTANCE.dumpCoroutinesSynchronized(arg1);
        }
        catch(Throwable v0) {
            __monitor_exit(arg1);
            throw v0;
        }

        __monitor_exit(arg1);
    }

    public final List dumpCoroutinesInfo() {
        if(this.isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(this.getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1()));
        }

        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    public final Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        Long v8_1;
        String v7_1;
        List v0 = this.dumpCoroutinesInfo();
        int v1 = v0.size();
        ArrayList v2 = new ArrayList(v1);
        ArrayList v3 = new ArrayList(v1);
        ArrayList v4 = new ArrayList(v1);
        Iterator v1_1 = v0.iterator();
        while(v1_1.hasNext()) {
            Object v5 = v1_1.next();
            CoroutineContext v6 = ((DebugCoroutineInfo)v5).getContext();
            Element v7 = v6.get(CoroutineName.Key);
            Object v8 = null;
            if(v7 != null) {
                v7_1 = ((CoroutineName)v7).getName();
                if(v7_1 != null) {
                    v7_1 = this.toStringRepr(v7_1);
                }
                else {
                    goto label_21;
                }
            }
            else {
            label_21:
                v7_1 = ((String)v8);
            }

            Element v9 = v6.get(CoroutineDispatcher.Key);
            String v9_1 = v9 != null ? this.toStringRepr(v9) : ((String)v8);
            StringBuilder v7_2 = new StringBuilder("\n                {\n                    \"name\": ").append(v7_1).append(",\n                    \"id\": ");
            Element v6_1 = v6.get(CoroutineId.Key);
            if(v6_1 != null) {
                v8_1 = Long.valueOf(((CoroutineId)v6_1).getId());
            }

            v4.add(StringsKt.trimIndent(v7_2.append(v8_1).append(",\n                    \"dispatcher\": ").append(v9_1).append(",\n                    \"sequenceNumber\": ").append(((DebugCoroutineInfo)v5).getSequenceNumber()).append(",\n                    \"state\": \"").append(((DebugCoroutineInfo)v5).getState()).append("\"\n                } \n                ").toString()));
            v3.add(((DebugCoroutineInfo)v5).getLastObservedFrame());
            v2.add(((DebugCoroutineInfo)v5).getLastObservedThread());
        }

        return new Object[]{"[" + CollectionsKt.joinToString$default(v4, null, null, null, 0, null, null, 0x3F, null) + ']', ((Collection)v2).toArray(new Thread[0]), ((Collection)v3).toArray(new CoroutineStackFrame[0]), ((Collection)v0).toArray(new DebugCoroutineInfo[0])};
    }

    private final List dumpCoroutinesInfoImpl(Function2 arg2) {
        if(this.isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(this.getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpCoroutinesInfoImpl$3(arg2)));
        }

        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    private final void dumpCoroutinesSynchronized(PrintStream arg9) {
        if(this.isInstalled$kotlinx_coroutines_debug()) {
            arg9.print("Coroutines dump " + DebugProbesImpl.dateFormat.format(Long.valueOf(System.currentTimeMillis())));
            Iterator v8 = SequencesKt.sortedWith(SequencesKt.filter(CollectionsKt.asSequence(this.getCapturedCoroutines()), new DebugProbesImpl$$ExternalSyntheticLambda0()), new DebugProbesImpl$dumpCoroutinesSynchronized$$inlined$sortedBy$1()).iterator();
            while(v8.hasNext()) {
                Object v0 = v8.next();
                DebugCoroutineInfoImpl v1 = ((CoroutineOwner)v0).info;
                List v2 = v1.lastObservedStackTrace$kotlinx_coroutines_core();
                DebugProbesImpl v3 = DebugProbesImpl.INSTANCE;
                List v4 = v3.enhanceStackTraceWithThreadDumpImpl(v1.getState$kotlinx_coroutines_core(), v1.lastObservedThread, v2);
                String v5 = !Intrinsics.areEqual(v1.getState$kotlinx_coroutines_core(), "RUNNING") || v4 != v2 ? v1.getState$kotlinx_coroutines_core() : v1.getState$kotlinx_coroutines_core() + " (Last suspension stacktrace, not an actual stacktrace)";
                arg9.print("\n\nCoroutine " + ((CoroutineOwner)v0).delegate + ", state: " + v5);
                if(v2.isEmpty()) {
                    arg9.print("\n\tat " + DebugProbesImpl.ARTIFICIAL_FRAME);
                    v3.printStackTrace(arg9, v1.getCreationStackTrace());
                    continue;
                }

                v3.printStackTrace(arg9, v4);
            }

            return;
        }

        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    static final boolean dumpCoroutinesSynchronized$lambda$14(CoroutineOwner arg1) {
        return DebugProbesImpl.INSTANCE.isFinished(arg1) ^ 1;
    }

    public final List dumpDebuggerInfo() {
        if(this.isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(this.getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1()));
        }

        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    public final List enhanceStackTraceWithThreadDump(DebugCoroutineInfo arg2, List arg3) {
        return this.enhanceStackTraceWithThreadDumpImpl(arg2.getState(), arg2.getLastObservedThread(), arg3);
    }

    public final String enhanceStackTraceWithThreadDumpAsJson(DebugCoroutineInfo arg11) {
        List v11 = this.enhanceStackTraceWithThreadDump(arg11, arg11.lastObservedStackTrace());
        ArrayList v0 = new ArrayList();
        Iterator v11_1 = v11.iterator();
        while(v11_1.hasNext()) {
            Object v1 = v11_1.next();
            StringBuilder v2 = new StringBuilder("\n                {\n                    \"declaringClass\": \"").append(((StackTraceElement)v1).getClassName()).append("\",\n                    \"methodName\": \"").append(((StackTraceElement)v1).getMethodName()).append("\",\n                    \"fileName\": ");
            String v3 = ((StackTraceElement)v1).getFileName();
            v3 = v3 != null ? this.toStringRepr(v3) : null;
            ((List)v0).add(StringsKt.trimIndent(v2.append(v3).append(",\n                    \"lineNumber\": ").append(((StackTraceElement)v1).getLineNumber()).append("\n                }\n                ").toString()));
        }

        return "[" + CollectionsKt.joinToString$default(v0, null, null, null, 0, null, null, 0x3F, null) + ']';
    }

    private final List enhanceStackTraceWithThreadDumpImpl(String arg7, Thread arg8, List arg9) {
        int v2;
        Object v7_1;
        if((Intrinsics.areEqual(arg7, "RUNNING")) && arg8 != null) {
            try {
                v7_1 = Result.constructor-impl(arg8.getStackTrace());
            }
            catch(Throwable v7) {
                v7_1 = Result.constructor-impl(ResultKt.createFailure(v7));
            }

            if(Result.isFailure-impl(v7_1)) {
                v7_1 = null;
            }

            if(v7_1 == null) {
                return arg9;
            }

            int v8 = v7_1.length;
            int v0 = 0;
            int v1;
            for(v1 = 0; true; ++v1) {
                v2 = -1;
                if(v1 >= v8) {
                    break;
                }

                StackTraceElement v3 = v7_1[v1];
                if((Intrinsics.areEqual(v3.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl")) && (Intrinsics.areEqual(v3.getMethodName(), "resumeWith")) && (Intrinsics.areEqual(v3.getFileName(), "ContinuationImpl.kt"))) {
                    goto label_41;
                }
            }

            v1 = v2;
        label_41:
            Pair v6 = this.findContinuationStartIndex(v1, ((StackTraceElement[])v7_1), arg9);
            v8 = v6.component1().intValue();
            int v6_1 = v6.component2().intValue();
            if(v8 == v2) {
                return arg9;
            }

            ArrayList v3_1 = new ArrayList(arg9.size() + v1 - v8 - 1 - v6_1);
            v1 -= v6_1;
            while(v0 < v1) {
                v3_1.add(v7_1[v0]);
                ++v0;
            }

            ++v8;
            v6_1 = arg9.size();
            while(v8 < v6_1) {
                v3_1.add(arg9.get(v8));
                ++v8;
            }

            return ((List)v3_1);
        }

        return arg9;
    }

    private final Pair findContinuationStartIndex(int arg5, StackTraceElement[] arg6, List arg7) {
        int v1;
        int v0;
        for(v0 = 0; true; ++v0) {
            v1 = -1;
            if(v0 >= 3) {
                break;
            }

            int v2 = DebugProbesImpl.INSTANCE.findIndexOfFrame(arg5 - 1 - v0, arg6, arg7);
            if(v2 != v1) {
                return TuplesKt.to(Integer.valueOf(v2), Integer.valueOf(v0));
            }
        }

        return TuplesKt.to(Integer.valueOf(v1), Integer.valueOf(0));
    }

    private final int findIndexOfFrame(int arg4, StackTraceElement[] arg5, List arg6) {
        Object v3 = ArraysKt.getOrNull(((Object[])arg5), arg4);
        arg4 = -1;
        if(v3 == null) {
            return arg4;
        }

        Iterator v5 = arg6.iterator();
        int v6;
        for(v6 = 0; v5.hasNext(); ++v6) {
            Object v0 = v5.next();
            if((Intrinsics.areEqual(((StackTraceElement)v0).getFileName(), ((StackTraceElement)v3).getFileName())) && (Intrinsics.areEqual(((StackTraceElement)v0).getClassName(), ((StackTraceElement)v3).getClassName())) && (Intrinsics.areEqual(((StackTraceElement)v0).getMethodName(), ((StackTraceElement)v3).getMethodName()))) {
                return v6;
            }
        }

        return arg4;
    }

    private final Set getCapturedCoroutines() {
        return DebugProbesImpl.capturedCoroutinesMap.keySet();
    }

    private final String getDebugString(Job arg1) {
        if((arg1 instanceof JobSupport)) {
            return ((JobSupport)arg1).toDebugString();
        }

        return arg1.toString();
    }

    private static void getDebugString$annotations(Job arg0) {
    }

    private final Function1 getDynamicAttach() {
        Function1 v1_2;
        Object v1_1;
        try {
            v1_1 = Class.forName("kotlinx.coroutines.debug.ByteBuddyDynamicAttach").getConstructors()[0].newInstance();
            Intrinsics.checkNotNull(v1_1, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            v1_1 = Result.constructor-impl(TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1_1, 1));
        }
        catch(Throwable v1) {
            v1_1 = Result.constructor-impl(ResultKt.createFailure(v1));
        }

        if(Result.isFailure-impl(v1_1)) {
            v1_2 = null;
        }

        return v1_2;
    }

    public final boolean getEnableCreationStackTraces$kotlinx_coroutines_core() {
        return DebugProbesImpl.enableCreationStackTraces;
    }

    public final boolean getIgnoreCoroutinesWithEmptyContext() {
        return DebugProbesImpl.ignoreCoroutinesWithEmptyContext;
    }

    private final AtomicInteger getInstallations() {
        return DebugProbesImpl.installations;
    }

    public final boolean getSanitizeStackTraces$kotlinx_coroutines_core() {
        return DebugProbesImpl.sanitizeStackTraces;
    }

    private final AtomicLong getSequenceNumber() {
        return DebugProbesImpl.sequenceNumber;
    }

    public final String hierarchyToString$kotlinx_coroutines_core(Job arg5) {
        if(this.isInstalled$kotlinx_coroutines_debug()) {
            Set v4 = this.getCapturedCoroutines();
            ArrayList v0 = new ArrayList();
            Iterator v4_1 = ((Iterable)v4).iterator();
            while(v4_1.hasNext()) {
                Object v1 = v4_1.next();
                if(v1.delegate.getContext().get(Job.Key) == null) {
                    continue;
                }

                ((Collection)v0).add(v1);
            }

            LinkedHashMap v1_1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(((Iterable)v0), 10)), 16));
            v4_1 = ((Iterable)v0).iterator();
            while(v4_1.hasNext()) {
                Object v0_1 = v4_1.next();
                ((Map)v1_1).put(JobKt.getJob(((CoroutineOwner)v0_1).delegate.getContext()), ((CoroutineOwner)v0_1).info);
            }

            StringBuilder v4_2 = new StringBuilder();
            DebugProbesImpl.INSTANCE.build(arg5, ((Map)v1_1), v4_2, "");
            return v4_2.toString();
        }

        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    public final void install$kotlinx_coroutines_core() {
        if(this.getInstallations().incrementAndGet() > 1) {
        }
        else {
            this.startWeakRefCleanerThread();
            if(AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core()) {
            }
            else {
                Function1 v2 = DebugProbesImpl.dynamicAttach;
                if(v2 != null) {
                    v2.invoke(Boolean.valueOf(true));
                }
            }
        }
    }

    private final boolean isFinished(CoroutineOwner arg3) {
        CoroutineContext v2 = arg3.info.getContext();
        if(v2 != null) {
            Element v2_1 = v2.get(Job.Key);
            if(v2_1 == null) {
            }
            else if(!((Job)v2_1).isCompleted()) {
                return 0;
            }
            else {
                DebugProbesImpl.capturedCoroutinesMap.remove(arg3);
                return 1;
            }
        }

        return 0;
    }

    public final boolean isInstalled$kotlinx_coroutines_debug() {
        if(this.getInstallations().get() > 0) {
            return 1;
        }

        return 0;
    }

    private final boolean isInternalMethod(StackTraceElement arg4) {
        return StringsKt.startsWith$default(arg4.getClassName(), "kotlinx.coroutines", false, 2, null);
    }

    private final CoroutineOwner owner(Continuation arg3) {
        CoroutineOwner v1 = null;
        if((arg3 instanceof CoroutineStackFrame)) {
        }
        else {
            arg3 = ((Continuation)v1);
        }

        if(arg3 != null) {
            return this.owner(((CoroutineStackFrame)arg3));
        }

        return v1;
    }

    private final CoroutineOwner owner(CoroutineStackFrame arg1) {
        while(true) {
            if((arg1 instanceof CoroutineOwner)) {
                return arg1;
            }

            arg1 = arg1.getCallerFrame();
            if(arg1 == null) {
                return null;
            }
        }

        return null;
    }

    private final void printStackTrace(PrintStream arg3, List arg4) {
        Iterator v2 = ((Iterable)arg4).iterator();
        while(v2.hasNext()) {
            arg3.print("\n\tat " + v2.next());
        }
    }

    private final void probeCoroutineCompleted(CoroutineOwner arg2) {
        DebugProbesImpl.capturedCoroutinesMap.remove(arg2);
        CoroutineStackFrame v2 = arg2.info.getLastObservedFrame$kotlinx_coroutines_core();
        if(v2 != null) {
            CoroutineStackFrame v1 = this.realCaller(v2);
            if(v1 == null) {
            }
            else {
                DebugProbesImpl.callerInfoCache.remove(v1);
            }
        }
    }

    public final Continuation probeCoroutineCreated$kotlinx_coroutines_core(Continuation arg3) {
        if(!this.isInstalled$kotlinx_coroutines_debug()) {
        }
        else {
            if((DebugProbesImpl.ignoreCoroutinesWithEmptyContext) && arg3.getContext() == EmptyCoroutineContext.INSTANCE) {
                return arg3;
            }

            if(this.owner(arg3) == null) {
                goto label_12;
            }
        }

        return arg3;
    label_12:
        StackTraceFrame v0 = DebugProbesImpl.enableCreationStackTraces ? this.toStackTraceFrame(this.sanitizeStackTrace(new Exception())) : null;
        return this.createOwner(arg3, v0);
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(Continuation arg2) {
        this.updateState(arg2, "RUNNING");
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(Continuation arg2) {
        this.updateState(arg2, "SUSPENDED");
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame arg1) {
        do {
            arg1 = arg1.getCallerFrame();
            if(arg1 == null) {
                return null;
            }
        }
        while(arg1.getStackTraceElement() == null);

        return arg1;
    }

    private final List sanitizeStackTrace(Throwable arg9) {
        int v4;
        ArrayList v1_1;
        StackTraceElement[] v9 = arg9.getStackTrace();
        int v0 = v9.length;
        int v2 = -1;
        int v1 = v9.length + v2;
        if(v1 >= 0) {
            while(true) {
                int v3 = v1 - 1;
                if(Intrinsics.areEqual(v9[v1].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                    break;
                }
                else if(v3 < 0) {
                }
                else {
                    v1 = v3;
                    continue;
                }

                goto label_18;
            }

            v2 = v1;
        }

    label_18:
        ++v2;
        if(!DebugProbesImpl.sanitizeStackTraces) {
            v0 -= v2;
            ArrayList v8 = new ArrayList(v0);
            for(v1 = 0; v1 < v0; ++v1) {
                v8.add(v9[v1 + v2]);
            }

            return ((List)v8);
        }

        ArrayList v3_1 = new ArrayList(v0 - v2 + 1);
    label_37:
        while(v2 < v0) {
            if(this.isInternalMethod(v9[v2])) {
                v1_1 = v3_1;
                ((Collection)v1_1).add(v9[v2]);
                v4 = v2 + 1;
                goto label_45;
            }

            v3_1.add(v9[v2]);
            ++v2;
        }

        return ((List)v3_1);
    label_45:
        while(v4 < v0) {
            if(!this.isInternalMethod(v9[v4])) {
                break;
            }

            ++v4;
        }

        int v5 = v4 - 1;
        int v6;
        for(v6 = v5; v6 > v2; --v6) {
            if(v9[v6].getFileName() != null) {
                break;
            }
        }

        if(v6 > v2 && v6 < v5) {
            ((Collection)v1_1).add(v9[v6]);
        }

        ((Collection)v1_1).add(v9[v5]);
        v2 = v4;
        goto label_37;
    }

    public final void setEnableCreationStackTraces$kotlinx_coroutines_core(boolean arg1) {
        DebugProbesImpl.enableCreationStackTraces = arg1;
    }

    public final void setIgnoreCoroutinesWithEmptyContext(boolean arg1) {
        DebugProbesImpl.ignoreCoroutinesWithEmptyContext = arg1;
    }

    public final void setSanitizeStackTraces$kotlinx_coroutines_core(boolean arg1) {
        DebugProbesImpl.sanitizeStackTraces = arg1;
    }

    private final void startWeakRefCleanerThread() {
        DebugProbesImpl.weakRefCleanerThread = ThreadsKt.thread$default(false, true, null, "Coroutines Debugger Cleaner", 0, new DebugProbesImpl$$ExternalSyntheticLambda1(), 21, null);
    }

    static final Unit startWeakRefCleanerThread$lambda$2() {
        DebugProbesImpl.callerInfoCache.runWeakRefQueueCleaningLoopUntilInterrupted();
        return Unit.INSTANCE;
    }

    private final void stopWeakRefCleanerThread() {
        Thread v1 = DebugProbesImpl.weakRefCleanerThread;
        if(v1 == null) {
            return;
        }

        DebugProbesImpl.weakRefCleanerThread = null;
        v1.interrupt();
        v1.join();
    }

    private final StackTraceFrame toStackTraceFrame(List arg3) {
        StackTraceFrame v0_1;
        CoroutineStackFrame v0 = null;
        if(!arg3.isEmpty()) {
            ListIterator v2 = arg3.listIterator(arg3.size());
            while(v2.hasPrevious()) {
                v0_1 = new StackTraceFrame(((CoroutineStackFrame)v0_1), v2.previous());
            }
        }

        return new StackTraceFrame(((CoroutineStackFrame)v0_1), DebugProbesImpl.ARTIFICIAL_FRAME);
    }

    private final String toStringRepr(Object arg1) {
        return DebugProbesImplKt.access$repr(arg1.toString());
    }

    public final void uninstall$kotlinx_coroutines_core() {
        if(this.isInstalled$kotlinx_coroutines_debug()) {
            if(this.getInstallations().decrementAndGet() != 0) {
            }
            else {
                this.stopWeakRefCleanerThread();
                DebugProbesImpl.capturedCoroutinesMap.clear();
                DebugProbesImpl.callerInfoCache.clear();
                if(AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core()) {
                }
                else {
                    Function1 v1 = DebugProbesImpl.dynamicAttach;
                    if(v1 != null) {
                        v1.invoke(Boolean.valueOf(false));
                    }
                }
            }

            return;
        }

        throw new IllegalStateException("Agent was not installed".toString());
    }

    private final void updateRunningState(CoroutineStackFrame arg5, String arg6) {
        DebugCoroutineInfoImpl v1_2;
        boolean v2;
        if(!this.isInstalled$kotlinx_coroutines_debug()) {
        }
        else {
            ConcurrentWeakMap v0 = DebugProbesImpl.callerInfoCache;
            Object v1 = v0.remove(arg5);
            if(v1 != null) {
                v2 = false;
            }
            else {
                CoroutineOwner v1_1 = this.owner(arg5);
                if(v1_1 != null) {
                    v1_2 = v1_1.info;
                    if(v1_2 == null) {
                        return;
                    }
                    else {
                        CoroutineStackFrame v2_1 = v1_2.getLastObservedFrame$kotlinx_coroutines_core();
                        v2_1 = v2_1 != null ? this.realCaller(v2_1) : null;
                        if(v2_1 != null) {
                            v0.remove(v2_1);
                        }

                        v2 = true;
                    }
                }
                else {
                    return;
                }
            }

            Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
            v1_2.updateState$kotlinx_coroutines_core(arg6, arg5, v2);
            CoroutineStackFrame v4 = this.realCaller(arg5);
            if(v4 == null) {
                return;
            }

            ((Map)v0).put(v4, v1_2);
        }
    }

    private final void updateState(Continuation arg3, String arg4) {
        CoroutineOwner v0;
        CoroutineStackFrame v3;
        if(!this.isInstalled$kotlinx_coroutines_debug()) {
        }
        else {
            if((DebugProbesImpl.ignoreCoroutinesWithEmptyContext) && arg3.getContext() == EmptyCoroutineContext.INSTANCE) {
                return;
            }

            if(Intrinsics.areEqual(arg4, "RUNNING")) {
                if((arg3 instanceof CoroutineStackFrame)) {
                }
                else {
                    v3 = null;
                }

                if(0 == 0) {
                    return;
                }

                this.updateRunningState(v3, arg4);
                return;
            }

            v0 = this.owner(arg3);
            if(v0 != null) {
                goto label_23;
            }
        }

        return;
    label_23:
        this.updateState(v0, arg3, arg4);
    }

    private final void updateState(CoroutineOwner arg1, Continuation arg2, String arg3) {
        if(!this.isInstalled$kotlinx_coroutines_debug()) {
            return;
        }

        arg1.info.updateState$kotlinx_coroutines_core(arg3, arg2, true);
    }
}

