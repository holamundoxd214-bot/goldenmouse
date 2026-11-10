package kotlinx.coroutines.selects;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

@Metadata(d1={"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001IB\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000E\u0010\u001B\u001A\u00028\u0000H\u0091@¢\u0006\u0002\u0010\u001CJ\u000E\u0010\u001D\u001A\u00028\u0000H\u0082@¢\u0006\u0002\u0010\u001CJ0\u0010\u001E\u001A\u00020\u001F*\u00020 2\u001C\u0010!\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0006\u0012\u0004\u0018\u00010\r0\"H\u0096\u0002¢\u0006\u0002\u0010$JB\u0010\u001E\u001A\u00020\u001F\"\u0004\b\u0001\u0010%*\b\u0012\u0004\u0012\u0002H%0&2\"\u0010!\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0006\u0012\u0004\u0018\u00010\r0\'H\u0096\u0002¢\u0006\u0002\u0010(JV\u0010\u001E\u001A\u00020\u001F\"\u0004\b\u0001\u0010)\"\u0004\b\u0002\u0010%*\u000E\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H%0*2\u0006\u0010+\u001A\u0002H)2\"\u0010!\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0006\u0012\u0004\u0018\u00010\r0\'H\u0096\u0002¢\u0006\u0002\u0010,J \u0010-\u001A\u00020\u001F*\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010.\u001A\u00020\u000FH\u0001J\u0010\u0010/\u001A\u00020\u001F2\u0006\u00100\u001A\u00020\rH\u0002J\u0010\u00101\u001A\u00020\u001F2\u0006\u00102\u001A\u000203H\u0016J\u001C\u00104\u001A\u00020\u001F2\n\u00105\u001A\u0006\u0012\u0002\b\u0003062\u0006\u00107\u001A\u00020\u0019H\u0016J\u0012\u00108\u001A\u00020\u001F2\b\u0010\u001A\u001A\u0004\u0018\u00010\rH\u0016J\u000E\u00109\u001A\u00020\u001FH\u0082@¢\u0006\u0002\u0010\u001CJ\u0010\u0010:\u001A\u00020\u001F2\u0006\u00100\u001A\u00020\rH\u0002J\u001A\u0010;\u001A\u00020\u000F2\u0006\u00100\u001A\u00020\r2\b\u0010<\u001A\u0004\u0018\u00010\rH\u0016J\u0018\u0010=\u001A\u00020>2\u0006\u00100\u001A\u00020\r2\b\u0010<\u001A\u0004\u0018\u00010\rJ\u001A\u0010?\u001A\u00020\u00192\u0006\u00100\u001A\u00020\r2\b\u0010\u001A\u001A\u0004\u0018\u00010\rH\u0002J\u001C\u0010@\u001A\u000E\u0018\u00010\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00100\u001A\u00020\rH\u0002J\u000E\u0010A\u001A\u00028\u0000H\u0082@¢\u0006\u0002\u0010\u001CJ*\u0010B\u001A\u00028\u00002\u0010\u0010C\u001A\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u001A\u001A\u0004\u0018\u00010\rH\u0082@¢\u0006\u0002\u0010DJ\u001A\u0010E\u001A\u00020\u001F2\u0010\u0010F\u001A\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u0012\u0010\u001E\u001A\u00020\u001F2\b\u0010G\u001A\u0004\u0018\u00010HH\u0016R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u000F\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004R\u0014\u0010\u000E\u001A\u00020\u000F8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u000F8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001A\u00020\u000F8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011R \u0010\u0014\u001A\u0014\u0012\u000E\u0012\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001A\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006J"}, d2={"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "context", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "state", "Lkotlinx/atomicfu/AtomicRef;", "", "inRegistrationPhase", "", "getInRegistrationPhase", "()Z", "isSelected", "isCancelled", "clauses", "", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "disposableHandleOrSegment", "indexInSegment", "", "internalResult", "doSelect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doSelectSuspend", "invoke", "", "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "register", "reregister", "checkClauseObject", "clauseObject", "disposeOnCompletion", "disposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "selectInRegistrationPhase", "waitUntilSelected", "reregisterClause", "trySelect", "result", "trySelectDetailed", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectInternal", "findClause", "complete", "processResultAndInvokeBlockRecoveringException", "clause", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanup", "selectedClause", "cause", "", "ClauseData", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class SelectImplementation implements CancelHandler, SelectBuilder, SelectInstanceInternal {
    @Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\u0004\u0018\u00002\u00020\u0001BÆ\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012U\u0010\u0003\u001AQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000B\u0012U\u0010\f\u001AQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000E\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000F\u001A\u00020\u0001\u0012u\u0010\u0010\u001Aq\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0004\u0018\u00010\u0004j\u0004\u0018\u0001`\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u001A\u001A\u00020\u001B2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u001CJ\u0012\u0010\u001D\u001A\u0004\u0018\u00010\u00012\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001J\u0018\u0010\u001F\u001A\u00028\u00002\b\u0010 \u001A\u0004\u0018\u00010\u0001H\u0086@¢\u0006\u0002\u0010!J\u0006\u0010\"\u001A\u00020\nJ8\u0010#\u001A\u001E\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\u00042\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\u00072\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001R\u0010\u0010\u0002\u001A\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R]\u0010\u0003\u001AQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R]\u0010\f\u001AQ\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u007F\u0010\u0010\u001Aq\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\n0\u0004\u0018\u00010\u0004j\u0004\u0018\u0001`\u00148\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001A\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001A\u00020\u00198\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006$"}, d2={"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "clauseObject", "regFunc", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "param", "", "Lkotlinx/coroutines/selects/RegistrationFunction;", "processResFunc", "clauseResult", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "block", "onCancellationConstructor", "internalResult", "", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "<init>", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "disposableHandleOrSegment", "indexInSegment", "", "tryRegisterAsWaiter", "", "Lkotlinx/coroutines/selects/SelectImplementation;", "processResult", "result", "invokeBlock", "argument", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "createOnCancellationAction", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ClauseData {
        private final Object block;
        public final Object clauseObject;
        public Object disposableHandleOrSegment;
        public int indexInSegment;
        public final Function3 onCancellationConstructor;
        private final Object param;
        private final Function3 processResFunc;
        private final Function3 regFunc;

        public ClauseData(SelectImplementation arg1, Object arg2, Function3 arg3, Function3 arg4, Object arg5, Object arg6, Function3 arg7) {
            SelectImplementation.this = arg1;
            super();
            this.clauseObject = arg2;
            this.regFunc = arg3;
            this.processResFunc = arg4;
            this.param = arg5;
            this.block = arg6;
            this.onCancellationConstructor = arg7;
            this.indexInSegment = -1;
        }

        public final Function3 createOnCancellationAction(SelectInstance arg2, Object arg3) {
            Function3 v0 = this.onCancellationConstructor;
            if(v0 != null) {
                return v0.invoke(arg2, this.param, arg3);
            }

            return null;
        }

        public final void dispose() {
            Object v3_1;
            Object v0 = this.disposableHandleOrSegment;
            SelectImplementation v1 = SelectImplementation.this;
            Throwable v3 = null;
            if((v0 instanceof Segment)) {
                ((Segment)v0).onCancellation(this.indexInSegment, v3, v1.getContext());
                return;
            }

            if((v0 instanceof DisposableHandle)) {
                v3_1 = v0;
            }

            if(v3_1 != null) {
                ((DisposableHandle)v3_1).dispose();
            }
        }

        public final Object invokeBlock(Object arg3, Continuation arg4) {
            Object v0 = this.block;
            if(this.param == SelectKt.getPARAM_CLAUSE_0()) {
                Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((Function1)v0).invoke(arg4);
            }

            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2)v0).invoke(arg3, arg4);
        }

        public final Object processResult(Object arg3) {
            return this.processResFunc.invoke(this.clauseObject, this.param, arg3);
        }

        public final boolean tryRegisterAsWaiter(SelectImplementation arg3) {
            if((DebugKt.getASSERTIONS_ENABLED()) && !arg3.getInRegistrationPhase()) {
                if(arg3.isCancelled()) {
                }
                else {
                    throw new AssertionError();
                }
            }

            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(arg3.internalResult == SelectKt.access$getNO_RESULT$p()) {
                }
                else {
                    throw new AssertionError();
                }
            }

            this.regFunc.invoke(this.clauseObject, arg3, this.param);
            if(arg3.internalResult == SelectKt.access$getNO_RESULT$p()) {
                return 1;
            }

            return 0;
        }
    }

    private List clauses;
    private final CoroutineContext context;
    private Object disposableHandleOrSegment;
    private int indexInSegment;
    private Object internalResult;

    static {
        SelectImplementation.state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state$volatile");
    }

    public SelectImplementation(CoroutineContext arg2) {
        super();
        this.context = arg2;
        this.state$volatile = SelectKt.access$getSTATE_REG$p();
        this.clauses = new ArrayList(2);
        this.indexInSegment = -1;
        this.internalResult = SelectKt.access$getNO_RESULT$p();
    }

    public static final Object access$complete(SelectImplementation arg0, Continuation arg1) {
        return arg0.complete(arg1);
    }

    public static final Object access$doSelectSuspend(SelectImplementation arg0, Continuation arg1) {
        return arg0.doSelectSuspend(arg1);
    }

    public static final boolean access$getInRegistrationPhase(SelectImplementation arg0) {
        return arg0.getInRegistrationPhase();
    }

    public static final Object access$getInternalResult$p(SelectImplementation arg0) {
        return arg0.internalResult;
    }

    public static final AtomicReferenceFieldUpdater access$getState$volatile$FU() {
        return SelectImplementation.getState$volatile$FU();
    }

    public static final boolean access$isCancelled(SelectImplementation arg0) {
        return arg0.isCancelled();
    }

    public static final Object access$processResultAndInvokeBlockRecoveringException(SelectImplementation arg0, ClauseData arg1, Object arg2, Continuation arg3) {
        return arg0.processResultAndInvokeBlockRecoveringException(arg1, arg2, arg3);
    }

    public static final void access$reregisterClause(SelectImplementation arg0, Object arg1) {
        arg0.reregisterClause(arg1);
    }

    public static final Object access$waitUntilSelected(SelectImplementation arg0, Continuation arg1) {
        return arg0.waitUntilSelected(arg1);
    }

    private final void checkClauseObject(Object arg2) {
        List v1 = this.clauses;
        Intrinsics.checkNotNull(v1);
        if(((v1 instanceof Collection)) && (v1.isEmpty())) {
            return;
        }

        Iterator v1_1 = ((Iterable)v1).iterator();
        while(true) {
            if(!v1_1.hasNext()) {
                return;
            }

            if(v1_1.next().clauseObject == arg2) {
                break;
            }
        }

        throw new IllegalStateException("Cannot use select clauses on the same object: " + arg2.toString());
    }

    private final void cleanup(ClauseData arg3) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(Intrinsics.areEqual(SelectImplementation.getState$volatile$FU().get(this), arg3)) {
            }
            else {
                throw new AssertionError();
            }
        }

        List v0 = this.clauses;
        if(v0 == null) {
            return;
        }

        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            if((((ClauseData)v1)) == arg3) {
                continue;
            }

            ((ClauseData)v1).dispose();
        }

        SelectImplementation.getState$volatile$FU().set(this, SelectKt.access$getSTATE_COMPLETED$p());
        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = null;
    }

    private final Object complete(Continuation arg4) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.isSelected()) {
            }
            else {
                throw new AssertionError();
            }
        }

        Object v0 = SelectImplementation.getState$volatile$FU().get(this);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        Object v1 = this.internalResult;
        this.cleanup(((ClauseData)v0));
        if(!DebugKt.getRECOVER_STACK_TRACES()) {
            return ((ClauseData)v0).invokeBlock(((ClauseData)v0).processResult(v1), arg4);
        }

        return this.processResultAndInvokeBlockRecoveringException(((ClauseData)v0), v1, arg4);
    }

    public void disposeOnCompletion(DisposableHandle arg1) {
        this.disposableHandleOrSegment = arg1;
    }

    public Object doSelect(Continuation arg1) {
        return SelectImplementation.doSelect$suspendImpl(this, arg1);
    }

    static Object doSelect$suspendImpl(SelectImplementation arg1, Continuation arg2) {
        if(arg1.isSelected()) {
            return arg1.complete(arg2);
        }

        return arg1.doSelectSuspend(arg2);
    }

    private final Object doSelectSuspend(Continuation arg6) {
        Object v5;
        int v2;
        Continuation v0;
        if((arg6 instanceof SelectImplementation$doSelectSuspend$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((SelectImplementation$doSelectSuspend$1)v0).label & v2) != 0) {
                ((SelectImplementation$doSelectSuspend$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            SelectImplementation$doSelectSuspend$1 v0_1 = new SelectImplementation$doSelectSuspend$1(this, arg6);
        }

        Object v6 = ((SelectImplementation$doSelectSuspend$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((SelectImplementation$doSelectSuspend$1)v0).label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            ((SelectImplementation$doSelectSuspend$1)v0).L$0 = this;
            ((SelectImplementation$doSelectSuspend$1)v0).label = 1;
            if(this.waitUntilSelected(v0) == v1) {
            }
            else {
            label_36:
                ((SelectImplementation$doSelectSuspend$1)v0).L$0 = null;
                ((SelectImplementation$doSelectSuspend$1)v0).label = v3;
                v5 = ((SelectImplementation)v5).complete(v0);
                if(v5 == v1) {
                    return v1;
                }

                return v5;
            }
        }
        else if(v2 == 1) {
            v5 = ((SelectImplementation$doSelectSuspend$1)v0).L$0;
            ResultKt.throwOnFailure(v6);
            goto label_36;
        }
        else if(v2 == v3) {
            ResultKt.throwOnFailure(v6);
            return v6;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return v1;
    }

    private final ClauseData findClause(Object arg4) {
        Object v1;
        List v3 = this.clauses;
        ClauseData v0 = null;
        if(v3 == null) {
            return v0;
        }

        Iterator v3_1 = ((Iterable)v3).iterator();
        do {
            if(v3_1.hasNext()) {
                v1 = v3_1.next();
                if(v1.clauseObject != arg4) {
                    continue;
                }

                break;
            }

            goto label_12;
        }
        while(true);

        Object v0_1 = v1;
    label_12:
        if(v0_1 != null) {
            return ((ClauseData)v0_1);
        }

        throw new IllegalStateException("Clause with object " + arg4 + " is not found".toString());
    }

    public CoroutineContext getContext() {
        return this.context;
    }

    private final boolean getInRegistrationPhase() {
        Object v1 = SelectImplementation.getState$volatile$FU().get(this);
        if(v1 != SelectKt.access$getSTATE_REG$p()) {
            if((v1 instanceof List)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final Object getState$volatile() {
        return this.state$volatile;
    }

    private static final AtomicReferenceFieldUpdater getState$volatile$FU() {
        return SelectImplementation.state$volatile$FU;
    }

    public void invoke(Throwable arg3) {
        Iterator v3_2;
        AtomicReferenceFieldUpdater v3 = SelectImplementation.getState$volatile$FU();
        do {
            Object v0 = v3.get(this);
            if(v0 != SelectKt.access$getSTATE_COMPLETED$p()) {
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(v3, this, v0, SelectKt.access$getSTATE_CANCELLED$p())) {
                    continue;
                }

                break;
            }
            else {
                goto label_4;
            }
        }
        while(true);

        List v3_1 = this.clauses;
        if(v3_1 != null) {
            v3_2 = ((Iterable)v3_1).iterator();
            goto label_12;
        label_4:
        }

        return;
    label_12:
        while(v3_2.hasNext()) {
            v3_2.next().dispose();
        }

        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = null;
    }

    public void invoke(SelectClause0 arg9, Function1 arg10) {
        SelectImplementation.register$default(this, new ClauseData(this, arg9.getClauseObject(), arg9.getRegFunc(), arg9.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), arg10, arg9.getOnCancellationConstructor()), false, 1, null);
    }

    public void invoke(SelectClause1 arg9, Function2 arg10) {
        SelectImplementation.register$default(this, new ClauseData(this, arg9.getClauseObject(), arg9.getRegFunc(), arg9.getProcessResFunc(), null, arg10, arg9.getOnCancellationConstructor()), false, 1, null);
    }

    public void invoke(SelectClause2 arg9, Object arg10, Function2 arg11) {
        SelectImplementation.register$default(this, new ClauseData(this, arg9.getClauseObject(), arg9.getRegFunc(), arg9.getProcessResFunc(), arg10, arg11, arg9.getOnCancellationConstructor()), false, 1, null);
    }

    public void invoke(SelectClause2 arg1, Function2 arg2) {
        DefaultImpls.invoke(((SelectBuilder)this), arg1, arg2);
    }

    public void invokeOnCancellation(Segment arg1, int arg2) {
        this.disposableHandleOrSegment = arg1;
        this.indexInSegment = arg2;
    }

    private final boolean isCancelled() {
        if(SelectImplementation.getState$volatile$FU().get(this) == SelectKt.access$getSTATE_CANCELLED$p()) {
            return 1;
        }

        return 0;
    }

    private final boolean isSelected() {
        return SelectImplementation.getState$volatile$FU().get(this) instanceof ClauseData;
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg1, Object arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(arg1.get(arg2));
        }
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Replaced with the same extension function", replaceWith="<_subannotation>") public void onTimeout(long arg1, Function1 arg3) {
        DefaultImpls.onTimeout(((SelectBuilder)this), arg1, arg3);
    }

    private final Object processResultAndInvokeBlockRecoveringException(ClauseData arg4, Object arg5, Continuation arg6) {
        SelectImplementation$processResultAndInvokeBlockRecoveringException$1 v0_1;
        if((arg6 instanceof SelectImplementation$processResultAndInvokeBlockRecoveringException$1)) {
            Continuation v0 = arg6;
            int v2 = 0x80000000;
            if((((SelectImplementation$processResultAndInvokeBlockRecoveringException$1)v0).label & v2) != 0) {
                ((SelectImplementation$processResultAndInvokeBlockRecoveringException$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new SelectImplementation$processResultAndInvokeBlockRecoveringException$1(this, arg6);
        }

        Object v3 = v0_1.result;
        Object v6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = v0_1.label;
        if(v1 != 0) {
            if(v1 == 1) {
                try {
                    ResultKt.throwOnFailure(v3);
                    return v3;
                }
                catch(Throwable v3_1) {
                    goto label_34;
                }
            }

            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        ResultKt.throwOnFailure(v3);
        try {
            v3 = arg4.processResult(arg5);
            v0_1.label = 1;
            v3 = arg4.invokeBlock(v3, ((Continuation)v0_1));
            if(v3 != v6) {
                return v3;
            }
        }
        catch(Throwable v3_1) {
        label_34:
            if(DebugKt.getRECOVER_STACK_TRACES()) {
                if(!((((Continuation)v0_1)) instanceof CoroutineStackFrame)) {
                    throw v3_1;
                }

                throw StackTraceRecoveryKt.recoverFromStackFrame(v3_1, ((CoroutineStackFrame)v0_1));
            }

            throw v3_1;
        }

        return v6;
    }

    public final void register(ClauseData arg3, boolean arg4) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(SelectImplementation.getState$volatile$FU().get(this) != SelectKt.access$getSTATE_CANCELLED$p()) {
            }
            else {
                throw new AssertionError();
            }
        }

        if((SelectImplementation.getState$volatile$FU().get(this) instanceof ClauseData)) {
            return;
        }

        if(!arg4) {
            this.checkClauseObject(arg3.clauseObject);
        }

        if(arg3.tryRegisterAsWaiter(this)) {
            if(!arg4) {
                List v4 = this.clauses;
                Intrinsics.checkNotNull(v4);
                ((Collection)v4).add(arg3);
            }

            arg3.disposableHandleOrSegment = this.disposableHandleOrSegment;
            arg3.indexInSegment = this.indexInSegment;
            this.disposableHandleOrSegment = null;
            this.indexInSegment = -1;
            return;
        }

        SelectImplementation.getState$volatile$FU().set(this, arg3);
    }

    public static void register$default(SelectImplementation arg0, ClauseData arg1, boolean arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            arg0.register(arg1, false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }

    private final void reregisterClause(Object arg2) {
        ClauseData v2 = this.findClause(arg2);
        Intrinsics.checkNotNull(v2);
        v2.disposableHandleOrSegment = null;
        v2.indexInSegment = -1;
        this.register(v2, true);
    }

    public void selectInRegistrationPhase(Object arg1) {
        this.internalResult = arg1;
    }

    private final void setState$volatile(Object arg1) {
        this.state$volatile = arg1;
    }

    public boolean trySelect(Object arg1, Object arg2) {
        if(this.trySelectInternal(arg1, arg2) == 0) {
            return 1;
        }

        return 0;
    }

    public final TrySelectDetailedResult trySelectDetailed(Object arg1, Object arg2) {
        return SelectKt.access$TrySelectDetailedResult(this.trySelectInternal(arg1, arg2));
    }

    private final int trySelectInternal(Object arg6, Object arg7) {
        Object v0;
        do {
            v0 = SelectImplementation.getState$volatile$FU().get(this);
            int v2 = 2;
            if((v0 instanceof CancellableContinuation)) {
                ClauseData v1 = this.findClause(arg6);
                if(v1 == null) {
                    continue;
                }

                Function3 v3 = v1.createOnCancellationAction(this, arg7);
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SelectImplementation.getState$volatile$FU(), this, v0, v1)) {
                    continue;
                }

                this.internalResult = arg7;
                if(SelectKt.access$tryResume(((CancellableContinuation)v0), v3)) {
                    return 0;
                }

                this.internalResult = SelectKt.access$getNO_RESULT$p();
                return v2;
            }

            if(!Intrinsics.areEqual(v0, SelectKt.access$getSTATE_COMPLETED$p())) {
                if((v0 instanceof ClauseData)) {
                }
                else if(Intrinsics.areEqual(v0, SelectKt.access$getSTATE_CANCELLED$p())) {
                    return v2;
                }
                else if(Intrinsics.areEqual(v0, SelectKt.access$getSTATE_REG$p())) {
                    if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SelectImplementation.getState$volatile$FU(), this, v0, CollectionsKt.listOf(arg6))) {
                        continue;
                    }

                    return 1;
                }
                else if((v0 instanceof List)) {
                    if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SelectImplementation.getState$volatile$FU(), this, v0, CollectionsKt.plus(v0, arg6))) {
                        continue;
                    }

                    return 1;
                }
                else {
                    goto label_48;
                }
            }

            return 3;
        }
        while(true);

        return 1;
    label_48:
        throw new IllegalStateException("Unexpected state: " + v0.toString());
        return 3;
    }

    private final void update$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg2, Object arg3, Function1 arg4) {
        do {
            Object v1 = arg2.get(arg3);
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(arg2, arg3, v1, arg4.invoke(v1)));
    }

    private final Object waitUntilSelected(Continuation arg7) {
        Object v3;
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg7), 1);
        v0.initCancellability();
        CancellableContinuationImpl v1 = v0;
        AtomicReferenceFieldUpdater v2 = SelectImplementation.getState$volatile$FU();
        do {
        label_7:
            v3 = v2.get(this);
            if(v3 == SelectKt.access$getSTATE_REG$p()) {
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SelectImplementation.getState$volatile$FU(), this, v3, v1)) {
                    continue;
                }

                CancellableContinuationKt.invokeOnCancellation(((CancellableContinuation)v1), ((CancelHandler)this));
            }
            else if((v3 instanceof List)) {
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SelectImplementation.getState$volatile$FU(), this, v3, SelectKt.access$getSTATE_REG$p())) {
                    continue;
                }

                break;
            }
            else {
                goto label_28;
            }

            goto label_35;
        }
        while(true);

        Iterator v3_1 = ((Iterable)v3).iterator();
        goto label_23;
    label_28:
        if((v3 instanceof ClauseData)) {
            ((CancellableContinuation)v1).resume(Unit.INSTANCE, ((ClauseData)v3).createOnCancellationAction(this, this.internalResult));
        }
        else {
            goto label_44;
        }

    label_35:
        Object v6 = v0.getResult();
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg7);
        }

        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    label_44:
        throw new IllegalStateException("unexpected state: " + v3.toString());
        while(true) {
        label_23:
            if(!v3_1.hasNext()) {
                goto label_7;
            }

            this.reregisterClause(v3_1.next());
        }
    }
}

