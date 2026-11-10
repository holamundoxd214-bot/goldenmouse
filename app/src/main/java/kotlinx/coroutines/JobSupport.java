package kotlinx.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectInstance;

@Deprecated(level=DeprecationLevel.ERROR, message="This is internal API and may be removed in the future releases") @Metadata(d1={"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\n·\u0001¸\u0001¹\u0001º\u0001»\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u001A\u001A\u00020\u001B2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001H\u0004J\u001F\u0010\u001F\u001A\u00020 2\u0014\u0010!\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000E\u0012\u0004\u0012\u00020\u001B0\"H\u0082\bJ\u001C\u0010\'\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u001C\u001A\u00020(2\b\u0010)\u001A\u0004\u0018\u00010\u000EH\u0002J \u0010*\u001A\u0004\u0018\u00010+2\u0006\u0010\u001C\u001A\u00020(2\f\u0010,\u001A\b\u0012\u0004\u0012\u00020+0-H\u0002J\u001E\u0010.\u001A\u00020\u001B2\u0006\u0010/\u001A\u00020+2\f\u0010,\u001A\b\u0012\u0004\u0012\u00020+0-H\u0002J\u001A\u00100\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u0002012\b\u00102\u001A\u0004\u0018\u00010\u000EH\u0002J\u001A\u00103\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u0002012\b\u00102\u001A\u0004\u0018\u00010\u000EH\u0002J\u0018\u00104\u001A\u00020\u001B2\u0006\u00105\u001A\u0002062\u0006\u00107\u001A\u00020+H\u0002J\u0010\u00108\u001A\u00020\u00052\u0006\u00107\u001A\u00020+H\u0002J\u0016\u00109\u001A\u00020\u001B*\u0002062\b\u00107\u001A\u0004\u0018\u00010+H\u0002J/\u0010:\u001A\u00020\u001B2\u0006\u00105\u001A\u0002062\b\u00107\u001A\u0004\u0018\u00010+2\u0012\u0010;\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00050\"H\u0082\bJ\u0006\u0010=\u001A\u00020\u0005J\u0012\u0010>\u001A\u00020?2\b\u0010\u001C\u001A\u0004\u0018\u00010\u000EH\u0002J\b\u0010@\u001A\u00020\u001BH\u0014J\u000F\u0010A\u001A\u00060Bj\u0002`C¢\u0006\u0002\u0010DJ!\u0010E\u001A\u00060Bj\u0002`C*\u00020+2\n\b\u0002\u0010F\u001A\u0004\u0018\u00010GH\u0004¢\u0006\u0002\u0010HJ/\u0010N\u001A\u00020O2\'\u0010P\u001A#\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\bQ\u0012\b\bR\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001B0\"j\u0002`SJ?\u0010N\u001A\u00020O2\u0006\u0010T\u001A\u00020\u00052\u0006\u0010U\u001A\u00020\u00052\'\u0010P\u001A#\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\bQ\u0012\b\bR\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001B0\"j\u0002`SJ\u001D\u0010V\u001A\u00020O2\u0006\u0010U\u001A\u00020\u00052\u0006\u0010W\u001A\u00020<H\u0000¢\u0006\u0002\bXJ+\u0010Y\u001A\u00020\u00052\u0006\u0010W\u001A\u00020<2\u0018\u0010Z\u001A\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00050[H\u0082\bJ\u0010\u0010\\\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020]H\u0002J\u0010\u0010^\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020<H\u0002J\u000E\u0010_\u001A\u00020\u001BH\u0086@¢\u0006\u0002\u0010`J\b\u0010a\u001A\u00020\u0005H\u0002J\u000E\u0010b\u001A\u00020\u001BH\u0082@¢\u0006\u0002\u0010`J\u001E\u0010i\u001A\u00020\u001B2\n\u0010j\u001A\u0006\u0012\u0002\b\u00030k2\b\u0010l\u001A\u0004\u0018\u00010\u000EH\u0002J\u0015\u0010m\u001A\u00020\u001B2\u0006\u0010W\u001A\u00020<H\u0000¢\u0006\u0002\bnJ\u001D\u0010q\u001A\u00020\u001B2\u000E\u00107\u001A\n\u0018\u00010Bj\u0004\u0018\u0001`CH\u0016¢\u0006\u0002\u0010rJ\b\u0010s\u001A\u00020GH\u0014J\u0012\u0010q\u001A\u00020\u00052\b\u00107\u001A\u0004\u0018\u00010+H\u0017J\u0010\u0010t\u001A\u00020\u001B2\u0006\u00107\u001A\u00020+H\u0016J\u000E\u0010u\u001A\u00020\u001B2\u0006\u0010v\u001A\u00020\u0003J\u0010\u0010w\u001A\u00020\u00052\u0006\u00107\u001A\u00020+H\u0016J\u0010\u0010x\u001A\u00020\u00052\b\u00107\u001A\u0004\u0018\u00010+J\u0017\u0010y\u001A\u00020\u00052\b\u00107\u001A\u0004\u0018\u00010\u000EH\u0000¢\u0006\u0002\bzJ\u0014\u0010{\u001A\u0004\u0018\u00010\u000E2\b\u00107\u001A\u0004\u0018\u00010\u000EH\u0002J&\u0010|\u001A\u00020}2\n\b\u0002\u0010F\u001A\u0004\u0018\u00010G2\n\b\u0002\u00107\u001A\u0004\u0018\u00010+H\u0080\b¢\u0006\u0002\b~J\u0011\u0010\u007F\u001A\u00060Bj\u0002`CH\u0016¢\u0006\u0002\u0010DJ\u0013\u0010\u0080\u0001\u001A\u00020+2\b\u00107\u001A\u0004\u0018\u00010\u000EH\u0002J\u0015\u0010\u0081\u0001\u001A\u0004\u0018\u00010\u000E2\b\u00107\u001A\u0004\u0018\u00010\u000EH\u0002J\u0013\u0010\u0082\u0001\u001A\u0004\u0018\u0001062\u0006\u0010\u001C\u001A\u000201H\u0002J\u0019\u0010\u0083\u0001\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u0002012\u0006\u0010/\u001A\u00020+H\u0002J\u0019\u0010\u0084\u0001\u001A\u00020\u00052\b\u0010)\u001A\u0004\u0018\u00010\u000EH\u0000¢\u0006\u0003\b\u0085\u0001J\u001B\u0010\u0086\u0001\u001A\u0004\u0018\u00010\u000E2\b\u0010)\u001A\u0004\u0018\u00010\u000EH\u0000¢\u0006\u0003\b\u0087\u0001J\u001F\u0010\u0088\u0001\u001A\u0004\u0018\u00010\u000E2\b\u0010\u001C\u001A\u0004\u0018\u00010\u000E2\b\u0010)\u001A\u0004\u0018\u00010\u000EH\u0002J\u001D\u0010\u0089\u0001\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u001C\u001A\u0002012\b\u0010)\u001A\u0004\u0018\u00010\u000EH\u0002J&\u0010\u008D\u0001\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020(2\b\u0010\u008E\u0001\u001A\u00030\u008F\u00012\b\u0010)\u001A\u0004\u0018\u00010\u000EH\u0082\u0010J%\u0010\u0090\u0001\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020(2\b\u0010\u0091\u0001\u001A\u00030\u008F\u00012\b\u0010)\u001A\u0004\u0018\u00010\u000EH\u0002J\u0011\u0010\u0092\u0001\u001A\u0005\u0018\u00010\u008F\u0001*\u00030\u0093\u0001H\u0002J\u0010\u0010\u0098\u0001\u001A\u00020\u00102\u0007\u0010\u008E\u0001\u001A\u00020\u0002J\u0018\u0010\u0099\u0001\u001A\u00020\u001B2\u0007\u0010\u009A\u0001\u001A\u00020+H\u0010¢\u0006\u0003\b\u009B\u0001J\u0012\u0010T\u001A\u00020\u001B2\b\u00107\u001A\u0004\u0018\u00010+H\u0014J\u0012\u0010\u009F\u0001\u001A\u00020\u00052\u0007\u0010\u009A\u0001\u001A\u00020+H\u0014J\u0013\u0010 \u0001\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u000EH\u0014J\u0013\u0010¡\u0001\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u000EH\u0014J\t\u0010¢\u0001\u001A\u00020GH\u0016J\t\u0010£\u0001\u001A\u00020GH\u0007J\u000F\u0010¤\u0001\u001A\u00020GH\u0010¢\u0006\u0003\b¥\u0001J\u0013\u0010¦\u0001\u001A\u00020G2\b\u0010\u001C\u001A\u0004\u0018\u00010\u000EH\u0002J\t\u0010ª\u0001\u001A\u0004\u0018\u00010+J\u0011\u0010«\u0001\u001A\u0004\u0018\u00010\u000EH\u0000¢\u0006\u0003\b¬\u0001J\u0011\u0010­\u0001\u001A\u0004\u0018\u00010\u000EH\u0084@¢\u0006\u0002\u0010`J\u0011\u0010®\u0001\u001A\u0004\u0018\u00010\u000EH\u0082@¢\u0006\u0002\u0010`J\u001F\u0010´\u0001\u001A\u00020\u001B2\n\u0010j\u001A\u0006\u0012\u0002\b\u00030k2\b\u0010l\u001A\u0004\u0018\u00010\u000EH\u0002J \u0010µ\u0001\u001A\u0004\u0018\u00010\u000E2\b\u0010l\u001A\u0004\u0018\u00010\u000E2\t\u0010¶\u0001\u001A\u0004\u0018\u00010\u000EH\u0002R\u0015\u0010\b\u001A\u0006\u0012\u0002\b\u00030\t8F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\rX\u0082\u0004R\u0011\u0010\u000F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rX\u0082\u0004R(\u0010\u0012\u001A\u0004\u0018\u00010\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u00108@@@X\u0080\u000E¢\u0006\f\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001A\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001C\u001A\u0004\u0018\u00010\u000E8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u0014\u0010#\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010$R\u0011\u0010%\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b%\u0010$R\u0011\u0010&\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b&\u0010$R\u0016\u0010I\u001A\u0004\u0018\u00010+8DX\u0084\u0004¢\u0006\u0006\u001A\u0004\bJ\u0010KR\u0014\u0010L\u001A\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001A\u0004\bM\u0010$R\u0017\u0010c\u001A\u00020d8F¢\u0006\f\u0012\u0004\be\u0010f\u001A\u0004\bg\u0010hR\u0014\u0010o\u001A\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001A\u0004\bp\u0010$R\u001F\u0010\u008A\u0001\u001A\u0004\u0018\u00010+*\u0004\u0018\u00010\u000E8BX\u0082\u0004¢\u0006\b\u001A\u0006\b\u008B\u0001\u0010\u008C\u0001R\u001B\u0010\u0094\u0001\u001A\t\u0012\u0004\u0012\u00020\u00010\u0095\u00018F¢\u0006\b\u001A\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0016\u0010\u009C\u0001\u001A\u00020\u00058TX\u0094\u0004¢\u0006\u0007\u001A\u0005\b\u009C\u0001\u0010$R\u0016\u0010\u009D\u0001\u001A\u00020\u00058PX\u0090\u0004¢\u0006\u0007\u001A\u0005\b\u009E\u0001\u0010$R\u001B\u0010§\u0001\u001A\u00020\u0005*\u0002018BX\u0082\u0004¢\u0006\b\u001A\u0006\b§\u0001\u0010¨\u0001R\u0013\u0010©\u0001\u001A\u00020\u00058F¢\u0006\u0007\u001A\u0005\b©\u0001\u0010$R#\u0010¯\u0001\u001A\u0007\u0012\u0002\b\u00030°\u00018DX\u0084\u0004¢\u0006\u000F\u0012\u0005\b±\u0001\u0010f\u001A\u0006\b²\u0001\u0010³\u0001¨\u0006¼\u0001"}, d2={"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "active", "", "<init>", "(Z)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "_parentHandle", "Lkotlinx/coroutines/ChildHandle;", "value", "parentHandle", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parent", "getParent", "()Lkotlinx/coroutines/Job;", "initParentJob", "", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "loopOnState", "", "block", "Lkotlin/Function1;", "isActive", "()Z", "isCompleted", "isCancelled", "finalizeFinishingState", "Lkotlinx/coroutines/JobSupport$Finishing;", "proposedUpdate", "getFinalRootCause", "", "exceptions", "", "addSuppressedExceptions", "rootCause", "tryFinalizeSimpleState", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "notifyCancelling", "list", "Lkotlinx/coroutines/NodeList;", "cause", "cancelParent", "notifyCompletion", "notifyHandlers", "predicate", "Lkotlinx/coroutines/JobNode;", "start", "startInternal", "", "onStart", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()Ljava/util/concurrent/CancellationException;", "toCancellationException", "message", "", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "completionCause", "getCompletionCause", "()Ljava/lang/Throwable;", "completionCauseHandled", "getCompletionCauseHandled", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "handler", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "onCancelling", "invokeImmediately", "invokeOnCompletionInternal", "node", "invokeOnCompletionInternal$kotlinx_coroutines_core", "tryPutNodeIntoList", "tryAdd", "Lkotlin/Function2;", "promoteEmptyToNodeList", "Lkotlinx/coroutines/Empty;", "promoteSingleToNodeList", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinInternal", "joinSuspend", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "()V", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "registerSelectForOnJoin", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "removeNode", "removeNode$kotlinx_coroutines_core", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "cancellationExceptionMessage", "cancelInternal", "parentCancelled", "parentJob", "childCancelled", "cancelCoroutine", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelMakeCompleting", "defaultCancellationException", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "getChildJobCancellationCause", "createCauseException", "makeCancelling", "getOrPromoteCancellingList", "tryMakeCancelling", "makeCompleting", "makeCompleting$kotlinx_coroutines_core", "makeCompletingOnce", "makeCompletingOnce$kotlinx_coroutines_core", "tryMakeCompleting", "tryMakeCompletingSlowPath", "exceptionOrNull", "getExceptionOrNull", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "tryWaitForChild", "child", "Lkotlinx/coroutines/ChildHandleNode;", "continueCompleting", "lastChild", "nextChild", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "attachChild", "handleOnCompletionException", "exception", "handleOnCompletionException$kotlinx_coroutines_core", "isScopedCoroutine", "handlesException", "getHandlesException$kotlinx_coroutines_core", "handleJobException", "onCompletionInternal", "afterCompletion", "toString", "toDebugString", "nameString", "nameString$kotlinx_coroutines_core", "stateString", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "isCompletedExceptionally", "getCompletionExceptionOrNull", "getCompletedInternal", "getCompletedInternal$kotlinx_coroutines_core", "awaitInternal", "awaitSuspend", "onAwaitInternal", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwaitInternal$annotations", "getOnAwaitInternal", "()Lkotlinx/coroutines/selects/SelectClause1;", "onAwaitInternalRegFunc", "onAwaitInternalProcessResFunc", "result", "SelectOnJoinCompletionHandler", "Finishing", "ChildCompletion", "AwaitContinuation", "SelectOnAwaitCompletionHandler", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class JobSupport implements ChildJob, Job, ParentJob {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001D\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\u000EH\u0014R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class AwaitContinuation extends CancellableContinuationImpl {
        private final JobSupport job;

        public AwaitContinuation(Continuation arg2, JobSupport arg3) {
            super(arg2, 1);
            this.job = arg3;
        }

        public Throwable getContinuationCancellationCause(Job arg2) {
            Object v1 = this.job.getState$kotlinx_coroutines_core();
            if((v1 instanceof Finishing)) {
                Throwable v0 = v1.getRootCause();
                if(v0 != null) {
                    return v0;
                }
            }

            if((v1 instanceof CompletedExceptionally)) {
                return ((CompletedExceptionally)v1).cause;
            }

            return arg2.getCancellationException();
        }

        protected String nameString() {
            return "AwaitContinuation";
        }
    }

    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ\u0012\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0014"}, d2={"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "onCancelling", "", "getOnCancelling", "()Z", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class ChildCompletion extends JobNode {
        private final ChildHandleNode child;
        private final JobSupport parent;
        private final Object proposedUpdate;
        private final Finishing state;

        public ChildCompletion(JobSupport arg1, Finishing arg2, ChildHandleNode arg3, Object arg4) {
            super();
            this.parent = arg1;
            this.state = arg2;
            this.child = arg3;
            this.proposedUpdate = arg4;
        }

        public boolean getOnCancelling() {
            return 0;
        }

        public void invoke(Throwable arg3) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }
    }

    @Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B!\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ\u0016\u0010#\u001A\b\u0012\u0004\u0012\u00020\t0$2\b\u0010%\u001A\u0004\u0018\u00010\tJ\u000E\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020\tJ\u0018\u0010)\u001A\u0012\u0012\u0004\u0012\u00020\t0*j\b\u0012\u0004\u0012\u00020\t`+H\u0002J\b\u0010,\u001A\u00020-H\u0016R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\t\u0010\u000E\u001A\u00020\u000FX\u0082\u0004R$\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u00078F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0006\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0015X\u0082\u0004R(\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\u0010\u001A\u0004\u0018\u00010\t8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015X\u0082\u0004R(\u0010\u001B\u001A\u0004\u0018\u00010\u00012\b\u0010\u0010\u001A\u0004\u0018\u00010\u00018B@BX\u0082\u000E¢\u0006\f\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u0011\u0010 \u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b \u0010\u0011R\u0011\u0010!\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b!\u0010\u0011R\u0014\u0010\"\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010\u0011¨\u0006."}, d2={"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "isCompleting", "", "rootCause", "", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "getList", "()Lkotlinx/coroutines/NodeList;", "_isCompleting", "Lkotlinx/atomicfu/AtomicBoolean;", "value", "()Z", "setCompleting", "(Z)V", "_rootCause", "Lkotlinx/atomicfu/AtomicRef;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "(Ljava/lang/Throwable;)V", "_exceptionsHolder", "exceptionsHolder", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "isSealed", "isCancelling", "isActive", "sealLocked", "", "proposedException", "addExceptionLocked", "", "exception", "allocateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class Finishing implements Incomplete {
        private final NodeList list;

        static {
            Class v1 = Finishing.class;
            Finishing._isCompleting$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(v1, "_isCompleting$volatile");
            Class v0 = Object.class;
            Finishing._rootCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v1, v0, "_rootCause$volatile");
            Finishing._exceptionsHolder$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v1, v0, "_exceptionsHolder$volatile");
        }

        public Finishing(NodeList arg1, boolean arg2, Throwable arg3) {
            super();
            this.list = arg1;
            this._isCompleting$volatile = ((int)arg2);
            this._rootCause$volatile = arg3;
        }

        public final void addExceptionLocked(Throwable arg3) {
            Object v0_1;
            Throwable v0 = this.getRootCause();
            if(v0 == null) {
                this.setRootCause(arg3);
                return;
            }

            if(arg3 == v0) {
            }
            else {
                v0_1 = this.getExceptionsHolder();
                if(v0_1 == null) {
                    this.setExceptionsHolder(arg3);
                    return;
                }
                else if((v0_1 instanceof Throwable)) {
                    if(arg3 == (((Throwable)v0_1))) {
                        return;
                    }

                    goto label_14;
                }
                else {
                    goto label_19;
                }
            }

            return;
        label_14:
            ArrayList v1 = this.allocateList();
            v1.add(v0_1);
            v1.add(arg3);
            this.setExceptionsHolder(v1);
            return;
        label_19:
            if((v0_1 instanceof ArrayList)) {
                ((ArrayList)v0_1).add(arg3);
                return;
            }

            throw new IllegalStateException("State is " + v0_1.toString());
        }

        private final ArrayList allocateList() {
            return new ArrayList(4);
        }

        private final Object getExceptionsHolder() {
            return Finishing.get_exceptionsHolder$volatile$FU().get(this);
        }

        public NodeList getList() {
            return this.list;
        }

        public final Throwable getRootCause() {
            return Finishing.get_rootCause$volatile$FU().get(this);
        }

        private final Object get_exceptionsHolder$volatile() {
            return this._exceptionsHolder$volatile;
        }

        private static final AtomicReferenceFieldUpdater get_exceptionsHolder$volatile$FU() {
            return Finishing._exceptionsHolder$volatile$FU;
        }

        private final int get_isCompleting$volatile() {
            return this._isCompleting$volatile;
        }

        private static final AtomicIntegerFieldUpdater get_isCompleting$volatile$FU() {
            return Finishing._isCompleting$volatile$FU;
        }

        private final Object get_rootCause$volatile() {
            return this._rootCause$volatile;
        }

        private static final AtomicReferenceFieldUpdater get_rootCause$volatile$FU() {
            return Finishing._rootCause$volatile$FU;
        }

        public boolean isActive() {
            if(this.getRootCause() == null) {
                return 1;
            }

            return 0;
        }

        public final boolean isCancelling() {
            if(this.getRootCause() != null) {
                return 1;
            }

            return 0;
        }

        public final boolean isCompleting() {
            if(Finishing.get_isCompleting$volatile$FU().get(this) == 1) {
                return 1;
            }

            return 0;
        }

        public final boolean isSealed() {
            if(this.getExceptionsHolder() == JobSupportKt.access$getSEALED$p()) {
                return 1;
            }

            return 0;
        }

        public final List sealLocked(Throwable arg4) {
            ArrayList v0_1;
            Object v0 = this.getExceptionsHolder();
            if(v0 == null) {
                v0_1 = this.allocateList();
            }
            else if((v0 instanceof Throwable)) {
                ArrayList v1 = this.allocateList();
                v1.add(v0);
                v0_1 = v1;
            }
            else {
                if((v0 instanceof ArrayList)) {
                    goto label_12;
                }

                goto label_23;
            }

        label_12:
            Throwable v1_1 = this.getRootCause();
            if(v1_1 != null) {
                v0_1.add(0, v1_1);
            }

            if(arg4 != null && !Intrinsics.areEqual(arg4, v1_1)) {
                v0_1.add(arg4);
            }

            this.setExceptionsHolder(JobSupportKt.access$getSEALED$p());
            return ((List)v0_1);
        label_23:
            throw new IllegalStateException("State is " + v0.toString());
        }

        public final void setCompleting(boolean arg2) {
            Finishing.get_isCompleting$volatile$FU().set(this, ((int)arg2));
        }

        private final void setExceptionsHolder(Object arg2) {
            Finishing.get_exceptionsHolder$volatile$FU().set(this, arg2);
        }

        public final void setRootCause(Throwable arg2) {
            Finishing.get_rootCause$volatile$FU().set(this, arg2);
        }

        private final void set_exceptionsHolder$volatile(Object arg1) {
            this._exceptionsHolder$volatile = arg1;
        }

        private final void set_isCompleting$volatile(int arg1) {
            this._isCompleting$volatile = arg1;
        }

        private final void set_rootCause$volatile(Object arg1) {
            this._rootCause$volatile = arg1;
        }

        public String toString() {
            return "Finishing[cancelling=" + this.isCancelling() + ", completing=" + this.isCompleting() + ", rootCause=" + this.getRootCause() + ", exceptions=" + this.getExceptionsHolder() + ", list=" + this.getList() + ']';
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0016R\u0012\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000E"}, d2={"Lkotlinx/coroutines/JobSupport$SelectOnAwaitCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "onCancelling", "", "getOnCancelling", "()Z", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class SelectOnAwaitCompletionHandler extends JobNode {
        private final SelectInstance select;

        public SelectOnAwaitCompletionHandler(JobSupport arg1, SelectInstance arg2) {
            JobSupport.this = arg1;
            super();
            this.select = arg2;
        }

        public boolean getOnCancelling() {
            return 0;
        }

        public void invoke(Throwable arg2) {
            Object v2 = JobSupport.this.getState$kotlinx_coroutines_core();
            if((v2 instanceof CompletedExceptionally)) {
            }
            else {
                v2 = JobSupportKt.unboxState(v2);
            }

            this.select.trySelect(JobSupport.this, v2);
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0016R\u0012\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000E"}, d2={"Lkotlinx/coroutines/JobSupport$SelectOnJoinCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "<init>", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "onCancelling", "", "getOnCancelling", "()Z", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class SelectOnJoinCompletionHandler extends JobNode {
        private final SelectInstance select;

        public SelectOnJoinCompletionHandler(JobSupport arg1, SelectInstance arg2) {
            JobSupport.this = arg1;
            super();
            this.select = arg2;
        }

        public boolean getOnCancelling() {
            return 0;
        }

        public void invoke(Throwable arg2) {
            this.select.trySelect(JobSupport.this, Unit.INSTANCE);
        }
    }

    static {
        Class v0 = Object.class;
        Class v2 = JobSupport.class;
        JobSupport._state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v2, v0, "_state$volatile");
        JobSupport._parentHandle$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v2, v0, "_parentHandle$volatile");
    }

    public JobSupport(boolean arg1) {
        super();
        Empty v1 = arg1 ? JobSupportKt.access$getEMPTY_ACTIVE$p() : JobSupportKt.access$getEMPTY_NEW$p();
        this._state$volatile = v1;
    }

    public static final Object access$awaitSuspend(JobSupport arg0, Continuation arg1) {
        return arg0.awaitSuspend(arg1);
    }

    public static final String access$cancellationExceptionMessage(JobSupport arg0) {
        return arg0.cancellationExceptionMessage();
    }

    public static final void access$continueCompleting(JobSupport arg0, Finishing arg1, ChildHandleNode arg2, Object arg3) {
        arg0.continueCompleting(arg1, arg2, arg3);
    }

    public static final Object access$joinSuspend(JobSupport arg0, Continuation arg1) {
        return arg0.joinSuspend(arg1);
    }

    public static final Object access$onAwaitInternalProcessResFunc(JobSupport arg0, Object arg1, Object arg2) {
        return arg0.onAwaitInternalProcessResFunc(arg1, arg2);
    }

    public static final void access$onAwaitInternalRegFunc(JobSupport arg0, SelectInstance arg1, Object arg2) {
        arg0.onAwaitInternalRegFunc(arg1, arg2);
    }

    public static final void access$registerSelectForOnJoin(JobSupport arg0, SelectInstance arg1, Object arg2) {
        arg0.registerSelectForOnJoin(arg1, arg2);
    }

    private final void addSuppressedExceptions(Throwable arg4, List arg5) {
        if(arg5.size() <= 1) {
        }
        else {
            Set v3 = Collections.newSetFromMap(new IdentityHashMap(arg5.size()));
            Throwable v0 = !DebugKt.getRECOVER_STACK_TRACES() ? arg4 : StackTraceRecoveryKt.unwrapImpl(arg4);
            Iterator v5 = arg5.iterator();
            while(v5.hasNext()) {
                Object v1 = v5.next();
                if(!DebugKt.getRECOVER_STACK_TRACES()) {
                }
                else {
                    Throwable v1_1 = StackTraceRecoveryKt.unwrapImpl(((Throwable)v1));
                }

                if((((Throwable)v1)) == arg4) {
                    continue;
                }

                if((((Throwable)v1)) == v0) {
                    continue;
                }

                if((v1 instanceof CancellationException)) {
                    continue;
                }

                if(!v3.add(v1)) {
                    continue;
                }

                ExceptionsKt.addSuppressed(arg4, ((Throwable)v1));
            }
        }
    }

    protected void afterCompletion(Object arg1) {
    }

    public final ChildHandle attachChild(ChildJob arg5) {
        Object v4;
        NodeList v1_1;
        Throwable v2;
        ChildHandleNode v0 = new ChildHandleNode(arg5);
        v0.setJob(this);
        while(true) {
            Object v5 = this.getState$kotlinx_coroutines_core();
            if((v5 instanceof Empty)) {
                Object v1 = v5;
                if(!((Empty)v1).isActive()) {
                    this.promoteEmptyToNodeList(((Empty)v1));
                    continue;
                }
                else if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport.get_state$volatile$FU(), this, v5, v0)) {
                    continue;
                }
            }
            else {
                v2 = null;
                if((v5 instanceof Incomplete)) {
                    v1_1 = v5.getList();
                    if(v1_1 == null) {
                        Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        this.promoteSingleToNodeList(((JobNode)v5));
                        continue;
                    }
                    else {
                        break;
                    }
                }
                else {
                    goto label_64;
                }
            }

            goto label_61;
        }

        ChildHandleNode v5_1 = v0;
        if(v1_1.addLast(((LockFreeLinkedListNode)v5_1), 7)) {
        }
        else {
            boolean v5_2 = v1_1.addLast(((LockFreeLinkedListNode)v5_1), 3);
            v4 = this.getState$kotlinx_coroutines_core();
            if((v4 instanceof Finishing)) {
                v2 = ((Finishing)v4).getRootCause();
            }
            else {
                if(DebugKt.getASSERTIONS_ENABLED()) {
                    if(!(v4 instanceof Incomplete)) {
                    }
                    else {
                        throw new AssertionError();
                    }
                }

                if((v4 instanceof CompletedExceptionally)) {
                }
                else {
                    v4 = v2;
                }

                if(v4 == null) {
                    goto label_52;
                }

                v2 = ((CompletedExceptionally)v4).cause;
            }

        label_52:
            v0.invoke(v2);
            if(!v5_2) {
                goto label_62;
            }

            if(!DebugKt.getASSERTIONS_ENABLED()) {
                goto label_61;
            }

            if(v2 != null) {
                goto label_61;
            }

            throw new AssertionError();
        }

    label_61:
        return ((ChildHandle)v0);
    label_62:
        return NonDisposableHandle.INSTANCE;
    label_64:
        v4 = this.getState$kotlinx_coroutines_core();
        if((v4 instanceof CompletedExceptionally)) {
        }
        else {
            v4 = v2;
        }

        if(v4 != null) {
            v2 = ((CompletedExceptionally)v4).cause;
        }

        v0.invoke(v2);
        return NonDisposableHandle.INSTANCE;
    }

    protected final Object awaitInternal(Continuation arg3) {
        Object v0;
        do {
            v0 = this.getState$kotlinx_coroutines_core();
            if(!(v0 instanceof Incomplete)) {
                goto label_3;
            }
        }
        while(this.startInternal(v0) < 0);

        return this.awaitSuspend(arg3);
    label_3:
        if((v0 instanceof CompletedExceptionally)) {
            Throwable v2 = ((CompletedExceptionally)v0).cause;
            if(DebugKt.getRECOVER_STACK_TRACES()) {
                if(!(arg3 instanceof CoroutineStackFrame)) {
                    throw v2;
                }

                throw StackTraceRecoveryKt.access$recoverFromStackFrame(v2, ((CoroutineStackFrame)arg3));
            }

            throw v2;
        }

        return JobSupportKt.unboxState(v0);
    }

    private final Object awaitSuspend(Continuation arg7) {
        AwaitContinuation v0 = new AwaitContinuation(IntrinsicsKt.intercepted(arg7), this);
        v0.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(v0, JobKt.invokeOnCompletion$default(((Job)this), false, new ResumeAwaitOnCompletion(v0), 1, null));
        Object v6 = v0.getResult();
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg7);
        }

        return v6;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.2.0, binary compatibility with versions <= 1.1.x") public void cancel() {
        DefaultImpls.cancel(((Job)this));
    }

    public void cancel(CancellationException arg4) {
        JobCancellationException v4;
        if(arg4 == null) {
            v4 = new JobCancellationException(this.cancellationExceptionMessage(), null, this);
        }

        this.cancelInternal(((Throwable)v4));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Added since 1.2.0 for binary compatibility with versions <= 1.1.x") public boolean cancel(Throwable arg5) {
        JobCancellationException v5_1;
        String v1 = null;
        if(arg5 != null) {
            CancellationException v5 = JobSupport.toCancellationException$default(this, arg5, v1, 1, v1);
            if(v5 == null) {
                goto label_5;
            }
        }
        else {
        label_5:
            v5_1 = new JobCancellationException(this.cancellationExceptionMessage(), ((Throwable)v1), this);
        }

        this.cancelInternal(((Throwable)v5_1));
        return 1;
    }

    public final boolean cancelCoroutine(Throwable arg1) {
        return this.cancelImpl$kotlinx_coroutines_core(arg1);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(Object arg4) {
        Object v0_1;
        Symbol v0 = JobSupportKt.access$getCOMPLETING_ALREADY$p();
        if(this.getOnCancelComplete$kotlinx_coroutines_core()) {
            v0_1 = this.cancelMakeCompleting(arg4);
            if(v0_1 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return 1;
            }
        }

        if((((Symbol)v0_1)) == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            v0_1 = this.makeCancelling(arg4);
        }

        if((((Symbol)v0_1)) == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            return 1;
        }

        if((((Symbol)v0_1)) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return 1;
        }

        if((((Symbol)v0_1)) == JobSupportKt.access$getTOO_LATE_TO_CANCEL$p()) {
            return 0;
        }

        this.afterCompletion(v0_1);
        return 1;
    }

    public void cancelInternal(Throwable arg1) {
        this.cancelImpl$kotlinx_coroutines_core(arg1);
    }

    private final Object cancelMakeCompleting(Object arg7) {
        Object v0;
        do {
            v0 = this.getState$kotlinx_coroutines_core();
            if((v0 instanceof Incomplete)) {
                if(((v0 instanceof Finishing)) && (v0.isCompleting())) {
                    goto label_19;
                }

                v0 = this.tryMakeCompleting(v0, new CompletedExceptionally(this.createCauseException(arg7), false, 2, null));
                if(v0 == JobSupportKt.access$getCOMPLETING_RETRY$p()) {
                    continue;
                }

                return v0;
            }

            goto label_19;
        }
        while(true);

        return v0;
    label_19:
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    }

    private final boolean cancelParent(Throwable arg4) {
        if(this.isScopedCoroutine()) {
            return 1;
        }

        boolean v0 = arg4 instanceof CancellationException;
        ChildHandle v3 = this.getParentHandle$kotlinx_coroutines_core();
        if(v3 != null) {
            if(v3 == NonDisposableHandle.INSTANCE) {
            }
            else {
                if(!v3.childCancelled(arg4)) {
                    if(v0) {
                    }
                    else {
                        return 0;
                    }
                }

                return 1;
            }
        }

        return v0;
    }

    protected String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(Throwable arg3) {
        if((arg3 instanceof CancellationException)) {
            return 1;
        }

        if((this.cancelImpl$kotlinx_coroutines_core(arg3)) && (this.getHandlesException$kotlinx_coroutines_core())) {
            return 1;
        }

        return 0;
    }

    private final void completeStateFinalization(Incomplete arg4, Object arg5) {
        ChildHandle v0 = this.getParentHandle$kotlinx_coroutines_core();
        if(v0 != null) {
            v0.dispose();
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }

        Throwable v1 = null;
        if((arg5 instanceof CompletedExceptionally)) {
        }
        else {
            arg5 = v1;
        }

        if(arg5 != null) {
            v1 = ((CompletedExceptionally)arg5).cause;
        }

        if((arg4 instanceof JobNode)) {
            try {
                arg4.invoke(v1);
                return;
            }
            catch(Throwable v5) {
                this.handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + arg4 + " for " + this, v5));
                return;
            }
        }

        NodeList v4 = arg4.getList();
        if(v4 != null) {
            this.notifyCompletion(v4, v1);
        }
    }

    private final void continueCompleting(Finishing arg3, ChildHandleNode arg4, Object arg5) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.getState$kotlinx_coroutines_core() == arg3) {
            }
            else {
                throw new AssertionError();
            }
        }

        ChildHandleNode v0 = this.nextChild(((LockFreeLinkedListNode)arg4));
        if(v0 == null || !this.tryWaitForChild(arg3, v0, arg5)) {
            arg3.getList().close(2);
            arg4 = this.nextChild(((LockFreeLinkedListNode)arg4));
            if(arg4 != null && (this.tryWaitForChild(arg3, arg4, arg5))) {
                return;
            }

            goto label_21;
        }
        else {
        }

        return;
    label_21:
        this.afterCompletion(this.finalizeFinishingState(arg3, arg5));
    }

    private final Throwable createCauseException(Object arg3) {
        JobCancellationException v3;
        boolean v0 = arg3 == null ? true : arg3 instanceof Throwable;
        if(v0) {
            if(arg3 == null) {
                v3 = new JobCancellationException(this.cancellationExceptionMessage(), null, ((Job)this));
            }

            return v3;
        }

        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob)arg3).getChildJobCancellationCause();
    }

    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(String arg2, Throwable arg3) {
        if(arg2 == null) {
            arg2 = this.cancellationExceptionMessage();
        }

        return new JobCancellationException(arg2, arg3, ((Job)this));
    }

    public static JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport arg1, String arg2, Throwable arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            String v0 = null;
            if((arg4 & 1) != 0) {
                arg2 = v0;
            }

            if((arg4 & 2) != 0) {
                arg3 = ((Throwable)v0);
            }

            if(arg2 == null) {
                arg2 = arg1.cancellationExceptionMessage();
            }

            return new JobCancellationException(arg2, arg3, ((Job)arg1));
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
    }

    private final Object finalizeFinishingState(Finishing arg6, Object arg7) {
        CompletedExceptionally v7;
        Throwable v4;
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.getState$kotlinx_coroutines_core() == arg6) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(!arg6.isSealed()) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg6.isCompleting()) {
            }
            else {
                throw new AssertionError();
            }
        }

        DefaultConstructorMarker v1 = null;
        Object v0 = (arg7 instanceof CompletedExceptionally) ? arg7 : v1;
        Throwable v0_1 = v0 != null ? ((CompletedExceptionally)v0).cause : ((Throwable)v1);
        __monitor_enter(arg6);
        try {
            boolean v2 = arg6.isCancelling();
            List v3 = arg6.sealLocked(v0_1);
            v4 = this.getFinalRootCause(arg6, v3);
            if(v4 != null) {
                this.addSuppressedExceptions(v4, v3);
            }
        }
        catch(Throwable v5) {
            __monitor_exit(arg6);
            throw v5;
        }

        __monitor_exit(arg6);
        if(v4 == null) {
        }
        else if(v4 == v0_1) {
        }
        else {
            v7 = new CompletedExceptionally(v4, false, 2, v1);
        }

        if(v4 != null && ((this.cancelParent(v4)) || (this.handleJobException(v4)))) {
            Intrinsics.checkNotNull(v7, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            v7.makeHandled();
        }

        if(!v2) {
            this.onCancelling(v4);
        }

        this.onCompletionInternal(v7);
        boolean v0_2 = AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport.get_state$volatile$FU(), this, arg6, JobSupportKt.boxIncomplete(v7));
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(v0_2) {
            }
            else {
                throw new AssertionError();
            }
        }

        this.completeStateFinalization(((Incomplete)arg6), v7);
        return v7;
    }

    public Object fold(Object arg1, Function2 arg2) {
        return DefaultImpls.fold(((Job)this), arg1, arg2);
    }

    public Element get(Key arg1) {
        return DefaultImpls.get(((Job)this), arg1);
    }

    public final CancellationException getCancellationException() {
        Object v0 = this.getState$kotlinx_coroutines_core();
        String v2 = "Job is still new or active: ";
        if((v0 instanceof Finishing)) {
            Throwable v0_1 = ((Finishing)v0).getRootCause();
            if(v0_1 != null) {
                CancellationException v0_2 = this.toCancellationException(v0_1, DebugStringsKt.getClassSimpleName(this) + " is cancelling");
                if(v0_2 != null) {
                    return v0_2;
                }
            }

            throw new IllegalStateException(v2 + this.toString());
        }

        if(!(v0 instanceof Incomplete)) {
            v2 = null;
            if((v0 instanceof CompletedExceptionally)) {
                return JobSupport.toCancellationException$default(this, ((CompletedExceptionally)v0).cause, v2, 1, v2);
            }

            return new JobCancellationException(DebugStringsKt.getClassSimpleName(this) + " has completed normally", ((Throwable)v2), ((Job)this));
        }

        throw new IllegalStateException(v2 + this.toString());
    }

    public CancellationException getChildJobCancellationCause() {
        Throwable v1;
        Object v0 = this.getState$kotlinx_coroutines_core();
        Throwable v2 = null;
        if((v0 instanceof Finishing)) {
            v1 = v0.getRootCause();
        }
        else if((v0 instanceof CompletedExceptionally)) {
            v1 = v0.cause;
        }
        else if(!(v0 instanceof Incomplete)) {
            v1 = v2;
        }
        else {
            goto label_28;
        }

        if((v1 instanceof CancellationException)) {
            v2 = v1;
        }

        if(v2 == null) {
            JobCancellationException v2_1 = new JobCancellationException("Parent job is " + this.stateString(v0), v1, ((Job)this));
        }

        return ((CancellationException)v2);
    label_28:
        throw new IllegalStateException("Cannot be cancelling child in this state: " + v0.toString());
    }

    public final Sequence getChildren() {
        return SequencesKt.sequence(new JobSupport$children$1(this, null));
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object v1 = this.getState$kotlinx_coroutines_core();
        if(!(v1 instanceof Incomplete)) {
            if(!(v1 instanceof CompletedExceptionally)) {
                return JobSupportKt.unboxState(v1);
            }

            throw ((CompletedExceptionally)v1).cause;
        }

        throw new IllegalStateException("This job has not completed yet".toString());
    }

    protected final Throwable getCompletionCause() {
        Object v0 = this.getState$kotlinx_coroutines_core();
        String v2 = "Job is still new or active: ";
        if((v0 instanceof Finishing)) {
            Throwable v0_1 = ((Finishing)v0).getRootCause();
            if(v0_1 != null) {
                return v0_1;
            }

            throw new IllegalStateException(v2 + this.toString());
        }

        if(!(v0 instanceof Incomplete)) {
            if((v0 instanceof CompletedExceptionally)) {
                return ((CompletedExceptionally)v0).cause;
            }

            return null;
        }

        throw new IllegalStateException(v2 + this.toString());
    }

    protected final boolean getCompletionCauseHandled() {
        Object v1 = this.getState$kotlinx_coroutines_core();
        if(((v1 instanceof CompletedExceptionally)) && (((CompletedExceptionally)v1).getHandled())) {
            return 1;
        }

        return 0;
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object v0 = this.getState$kotlinx_coroutines_core();
        if(!(v0 instanceof Incomplete)) {
            return this.getExceptionOrNull(v0);
        }

        throw new IllegalStateException("This job has not completed yet".toString());
    }

    private final Throwable getExceptionOrNull(Object arg2) {
        Throwable v0 = null;
        if((arg2 instanceof CompletedExceptionally)) {
        }
        else {
            arg2 = v0;
        }

        if(arg2 != null) {
            return ((CompletedExceptionally)arg2).cause;
        }

        return v0;
    }

    private final Throwable getFinalRootCause(Finishing arg4, List arg5) {
        Object v5;
        Object v0;
        Throwable v1 = null;
        if(arg5.isEmpty()) {
            if(arg4.isCancelling()) {
                return new JobCancellationException(this.cancellationExceptionMessage(), v1, ((Job)this));
            }

            return v1;
        }

        List v3 = arg5;
        Iterator v4 = ((Iterable)v3).iterator();
        do {
            if(v4.hasNext()) {
                v0 = v4.next();
                if((v0 instanceof CancellationException)) {
                    continue;
                }

                break;
            }
            else {
                goto label_19;
            }
        }
        while(true);

        goto label_20;
    label_19:
        v0 = v1;
    label_20:
        if(v0 != null) {
            return ((Throwable)v0);
        }

        Object v4_1 = arg5.get(0);
        if((v4_1 instanceof TimeoutCancellationException)) {
            Iterator v3_1 = ((Iterable)v3).iterator();
            do {
                if(v3_1.hasNext()) {
                    v5 = v3_1.next();
                    v0 = v5;
                    if(v0 == v4_1) {
                        continue;
                    }

                    if(!(v0 instanceof TimeoutCancellationException)) {
                        continue;
                    }

                    break;
                }

                goto label_35;
            }
            while(true);

            Object v1_1 = v5;
        label_35:
            if(v1_1 == null) {
                goto label_37;
            }

            return ((Throwable)v1_1);
        }

    label_37:
        return ((Throwable)v4_1);
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return 1;
    }

    public final Key getKey() {
        return Job.Key;
    }

    protected final SelectClause1 getOnAwaitInternal() {
        JobSupport$onAwaitInternal$1 v1 = JobSupport$onAwaitInternal$1.INSTANCE;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Object v1_1 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1, 3);
        JobSupport$onAwaitInternal$2 v3 = JobSupport$onAwaitInternal$2.INSTANCE;
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, v1_1, TypeIntrinsics.beforeCheckcastToFunctionOfArity(v3, 3), null, 8, null);
    }

    protected static void getOnAwaitInternal$annotations() {
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return 0;
    }

    public final SelectClause0 getOnJoin() {
        JobSupport$onJoin$1 v1 = JobSupport$onJoin$1.INSTANCE;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new SelectClause0Impl(this, TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1, 3), null, 4, null);
    }

    public static void getOnJoin$annotations() {
    }

    private final NodeList getOrPromoteCancellingList(Incomplete arg3) {
        NodeList v0 = arg3.getList();
        if(v0 == null) {
            if((arg3 instanceof Empty)) {
                return new NodeList();
            }

            if((arg3 instanceof JobNode)) {
                this.promoteSingleToNodeList(((JobNode)arg3));
                return null;
            }

            throw new IllegalStateException("State should have list: " + arg3.toString());
        }

        return v0;
    }

    public Job getParent() {
        ChildHandle v0 = this.getParentHandle$kotlinx_coroutines_core();
        if(v0 != null) {
            return v0.getParent();
        }

        return null;
    }

    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return JobSupport.get_parentHandle$volatile$FU().get(this);
    }

    public final Object getState$kotlinx_coroutines_core() {
        return JobSupport.get_state$volatile$FU().get(this);
    }

    private final Object get_parentHandle$volatile() {
        return this._parentHandle$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_parentHandle$volatile$FU() {
        return JobSupport._parentHandle$volatile$FU;
    }

    private final Object get_state$volatile() {
        return this._state$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_state$volatile$FU() {
        return JobSupport._state$volatile$FU;
    }

    protected boolean handleJobException(Throwable arg1) {
        return 0;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable arg1) {
        throw arg1;
    }

    protected final void initParentJob(Job arg2) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.getParentHandle$kotlinx_coroutines_core() == null) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(arg2 == null) {
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
            return;
        }

        arg2.start();
        ChildHandle v2 = arg2.attachChild(this);
        this.setParentHandle$kotlinx_coroutines_core(v2);
        if(this.isCompleted()) {
            v2.dispose();
            this.setParentHandle$kotlinx_coroutines_core(NonDisposableHandle.INSTANCE);
        }
    }

    public final DisposableHandle invokeOnCompletion(Function1 arg2) {
        return this.invokeOnCompletionInternal$kotlinx_coroutines_core(true, new InvokeOnCompletion(arg2));
    }

    public final DisposableHandle invokeOnCompletion(boolean arg1, boolean arg2, Function1 arg3) {
        InvokeOnCancelling v1;
        if(arg1) {
            v1 = new InvokeOnCancelling(arg3);
        }
        else {
            InvokeOnCompletion v1_1 = new InvokeOnCompletion(arg3);
        }

        return this.invokeOnCompletionInternal$kotlinx_coroutines_core(arg2, ((JobNode)v1));
    }

    public final DisposableHandle invokeOnCompletionInternal$kotlinx_coroutines_core(boolean arg5, JobNode arg6) {
        boolean v0_1;
        Throwable v2;
        Object v1;
        arg6.setJob(this);
        do {
            Object v0 = this.getState$kotlinx_coroutines_core();
            if((v0 instanceof Empty)) {
                v1 = v0;
                if(!((Empty)v1).isActive()) {
                    this.promoteEmptyToNodeList(((Empty)v1));
                    continue;
                }
                else if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport.get_state$volatile$FU(), this, v0, arg6)) {
                    continue;
                }
            }
            else {
                v2 = null;
                if((v0 instanceof Incomplete)) {
                    v1 = v0;
                    NodeList v3 = ((Incomplete)v1).getList();
                    if(v3 == null) {
                        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        this.promoteSingleToNodeList(((JobNode)v0));
                        continue;
                    }
                    else {
                        if(arg6.getOnCancelling()) {
                            if((v1 instanceof Finishing)) {
                            }
                            else {
                                v1 = v2;
                            }

                            if(v1 != null) {
                                v2 = ((Finishing)v1).getRootCause();
                            }

                            if(v2 == null) {
                                v0_1 = v3.addLast(arg6, 5);
                                goto label_43;
                            }

                            if(arg5) {
                                arg6.invoke(v2);
                            }

                            return NonDisposableHandle.INSTANCE;
                        }
                        else {
                            v0_1 = v3.addLast(arg6, 1);
                        }

                    label_43:
                        if(!v0_1) {
                            continue;
                        }
                    }
                }
                else {
                    goto label_45;
                }
            }

            return arg6;
        }
        while(true);

        return arg6;
    label_45:
        if(arg5) {
            Object v4 = this.getState$kotlinx_coroutines_core();
            if((v4 instanceof CompletedExceptionally)) {
            }
            else {
                v4 = v2;
            }

            if(v4 != null) {
                v2 = ((CompletedExceptionally)v4).cause;
            }

            arg6.invoke(v2);
        }

        return NonDisposableHandle.INSTANCE;
    }

    public boolean isActive() {
        Object v1 = this.getState$kotlinx_coroutines_core();
        if(((v1 instanceof Incomplete)) && (((Incomplete)v1).isActive())) {
            return 1;
        }

        return 0;
    }

    public final boolean isCancelled() {
        Object v1 = this.getState$kotlinx_coroutines_core();
        if(!(v1 instanceof CompletedExceptionally) && (!(v1 instanceof Finishing) || !((Finishing)v1).isCancelling())) {
            return 0;
        }

        return 1;
    }

    private final boolean isCancelling(Incomplete arg1) {
        if(((arg1 instanceof Finishing)) && (((Finishing)arg1).isCancelling())) {
            return 1;
        }

        return 0;
    }

    public final boolean isCompleted() {
        return this.getState$kotlinx_coroutines_core() instanceof Incomplete ^ 1;
    }

    public final boolean isCompletedExceptionally() {
        return this.getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    protected boolean isScopedCoroutine() {
        return 0;
    }

    public final Object join(Continuation arg2) {
        if(!this.joinInternal()) {
            JobKt.ensureActive(arg2.getContext());
            return Unit.INSTANCE;
        }

        Object v1 = this.joinSuspend(arg2);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    private final boolean joinInternal() {
        do {
            Object v0 = this.getState$kotlinx_coroutines_core();
            if(!(v0 instanceof Incomplete)) {
                return 0;
            }
        }
        while(this.startInternal(v0) < 0);

        return 1;
    }

    private final Object joinSuspend(Continuation arg7) {
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg7), 1);
        v0.initCancellability();
        CancellableContinuationKt.disposeOnCancellation(v0, JobKt.invokeOnCompletion$default(((Job)this), false, new ResumeOnCompletion(v0), 1, null));
        Object v6 = v0.getResult();
        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg7);
        }

        if(v6 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v6;
        }

        return Unit.INSTANCE;
    }

    private final Void loopOnState(Function1 arg2) {
        while(true) {
            arg2.invoke(this.getState$kotlinx_coroutines_core());
        }
    }

    private final Object makeCancelling(Object arg7) {
        Throwable v7;
        Symbol v6_1;
        Object v3;
        Object v2;
        Throwable v0 = null;
        Throwable v1 = v0;
        do {
        label_2:
            v2 = this.getState$kotlinx_coroutines_core();
            if((v2 instanceof Finishing)) {
                goto label_5;
            }

            if(!(v2 instanceof Incomplete)) {
                goto label_63;
            }

            if(v1 == null) {
                v1 = this.createCauseException(arg7);
            }

            v3 = v2;
            if(((Incomplete)v3).isActive()) {
                if(!this.tryMakeCancelling(((Incomplete)v3), v1)) {
                    goto label_2;
                }

                return JobSupportKt.access$getCOMPLETING_ALREADY$p();
            }

            v3 = this.tryMakeCompleting(v2, new CompletedExceptionally(v1, false, 2, ((DefaultConstructorMarker)v0)));
            if(v3 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                goto label_54;
            }
        }
        while(v3 == JobSupportKt.access$getCOMPLETING_RETRY$p());

        return v3;
    label_54:
        throw new IllegalStateException("Cannot happen in " + v2.toString());
    label_63:
        return JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
    label_5:
        __monitor_enter(v2);
        try {
            if(!v2.isSealed()) {
                goto label_12;
            }

            v6_1 = JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
        }
        catch(Throwable v6) {
            goto label_31;
        }

        __monitor_exit(v2);
        return v6_1;
        try {
        label_12:
            boolean v3_1 = v2.isCancelling();
            if(arg7 != null || !v3_1) {
                if(v1 == null) {
                    v1 = this.createCauseException(arg7);
                }

                v2.addExceptionLocked(v1);
            }

            v7 = v2.getRootCause();
            if(v3_1) {
                goto label_24;
            }
        }
        catch(Throwable v6) {
        label_31:
            __monitor_exit(v2);
            throw v6;
        }

        v0 = v7;
    label_24:
        __monitor_exit(v2);
        if(v0 != null) {
            this.notifyCancelling(((Finishing)v2).getList(), v0);
        }

        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object arg4) {
        Object v0;
        do {
            v0 = this.tryMakeCompleting(this.getState$kotlinx_coroutines_core(), arg4);
            if(v0 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                return 0;
            }

            if(v0 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return 1;
            }
        }
        while(v0 == JobSupportKt.access$getCOMPLETING_RETRY$p());

        this.afterCompletion(v0);
        return 1;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object arg4) {
        Object v0;
        do {
            v0 = this.tryMakeCompleting(this.getState$kotlinx_coroutines_core(), arg4);
            if(v0 == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
                goto label_7;
            }
        }
        while(v0 == JobSupportKt.access$getCOMPLETING_RETRY$p());

        return v0;
    label_7:
        throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + arg4, this.getExceptionOrNull(arg4));
    }

    public CoroutineContext minusKey(Key arg1) {
        return DefaultImpls.minusKey(((Job)this), arg1);
    }

    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode arg1) {
        while(arg1.isRemoved()) {
            arg1 = arg1.getPrevNode();
        }

        do {
        label_4:
            arg1 = arg1.getNextNode();
            if(arg1.isRemoved()) {
                goto label_4;
            }

            if((arg1 instanceof ChildHandleNode)) {
                return ((ChildHandleNode)arg1);
            }
        }
        while(!(arg1 instanceof NodeList));

        return null;
    }

    private final void notifyCancelling(NodeList arg6, Throwable arg7) {
        this.onCancelling(arg7);
        arg6.close(4);
        Object v0 = ((LockFreeLinkedListHead)arg6).getNext();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException v1 = null;
        while(!Intrinsics.areEqual(v0, arg6)) {
            if(((v0 instanceof JobNode)) && (v0.getOnCancelling())) {
                try {
                    v0.invoke(arg7);
                }
                catch(Throwable v2) {
                    CompletionHandlerException v3 = v1;
                    if(v3 != null) {
                        ExceptionsKt.addSuppressed(((Throwable)v3), v2);
                        if(v3 == null) {
                            goto label_22;
                        }

                        goto label_33;
                    }

                label_22:
                    v1 = new CompletionHandlerException("Exception in completion handler " + v0 + " for " + this, v2);
                }
            }

        label_33:
            LockFreeLinkedListNode v0_1 = v0_1.getNextNode();
        }

        if(v1 != null) {
            this.handleOnCompletionException$kotlinx_coroutines_core(((Throwable)v1));
        }

        this.cancelParent(arg7);
    }

    private final void notifyCompletion(NodeList arg6, Throwable arg7) {
        arg6.close(1);
        Object v0 = ((LockFreeLinkedListHead)arg6).getNext();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException v1 = null;
        while(!Intrinsics.areEqual(v0, arg6)) {
            if((v0 instanceof JobNode)) {
                try {
                    v0.invoke(arg7);
                }
                catch(Throwable v2) {
                    CompletionHandlerException v3 = v1;
                    if(v3 != null) {
                        ExceptionsKt.addSuppressed(((Throwable)v3), v2);
                        if(v3 == null) {
                            goto label_19;
                        }

                        goto label_30;
                    }

                label_19:
                    v1 = new CompletionHandlerException("Exception in completion handler " + v0 + " for " + this, v2);
                }
            }

        label_30:
            LockFreeLinkedListNode v0_1 = v0_1.getNextNode();
        }

        if(v1 != null) {
            this.handleOnCompletionException$kotlinx_coroutines_core(((Throwable)v1));
        }
    }

    private final void notifyHandlers(NodeList arg6, Throwable arg7, Function1 arg8) {
        Object v0 = ((LockFreeLinkedListHead)arg6).getNext();
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException v1 = null;
        while(!Intrinsics.areEqual(v0, arg6)) {
            if(((v0 instanceof JobNode)) && (arg8.invoke(v0).booleanValue())) {
                try {
                    v0.invoke(arg7);
                }
                catch(Throwable v2) {
                    CompletionHandlerException v3 = v1;
                    if(v3 != null) {
                        ExceptionsKt.addSuppressed(((Throwable)v3), v2);
                        if(v3 == null) {
                            goto label_19;
                        }

                        goto label_30;
                    }

                label_19:
                    v1 = new CompletionHandlerException("Exception in completion handler " + v0 + " for " + this, v2);
                }
            }

        label_30:
            LockFreeLinkedListNode v0_1 = v0_1.getNextNode();
        }

        if(v1 != null) {
            this.handleOnCompletionException$kotlinx_coroutines_core(((Throwable)v1));
        }
    }

    private final Object onAwaitInternalProcessResFunc(Object arg1, Object arg2) {
        if(!(arg2 instanceof CompletedExceptionally)) {
            return arg2;
        }

        throw ((CompletedExceptionally)arg2).cause;
    }

    private final void onAwaitInternalRegFunc(SelectInstance arg4, Object arg5) {
        do {
            arg5 = this.getState$kotlinx_coroutines_core();
            if(!(arg5 instanceof Incomplete)) {
                goto label_3;
            }
        }
        while(this.startInternal(arg5) < 0);

        arg4.disposeOnCompletion(JobKt.invokeOnCompletion$default(this, false, new SelectOnAwaitCompletionHandler(this, arg4), 1, null));
        return;
    label_3:
        if((arg5 instanceof CompletedExceptionally)) {
        }
        else {
            arg5 = JobSupportKt.unboxState(arg5);
        }

        arg4.selectInRegistrationPhase(arg5);
    }

    protected void onCancelling(Throwable arg1) {
    }

    protected void onCompletionInternal(Object arg1) {
    }

    protected void onStart() {
    }

    public final void parentCancelled(ParentJob arg1) {
        this.cancelImpl$kotlinx_coroutines_core(arg1);
    }

    public CoroutineContext plus(CoroutineContext arg1) {
        return DefaultImpls.plus(((Job)this), arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Operator \'+\' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.") public Job plus(Job arg1) {
        return DefaultImpls.plus(((Job)this), arg1);
    }

    private final void promoteEmptyToNodeList(Empty arg3) {
        NodeList v0 = new NodeList();
        if(arg3.isActive()) {
        }
        else {
            InactiveNodeList v0_1 = new InactiveNodeList(v0);
        }

        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport.get_state$volatile$FU(), this, arg3, v0);
    }

    private final void promoteSingleToNodeList(JobNode arg3) {
        arg3.addOneIfEmpty(new NodeList());
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport.get_state$volatile$FU(), this, arg3, arg3.getNextNode());
    }

    private final void registerSelectForOnJoin(SelectInstance arg4, Object arg5) {
        if(!this.joinInternal()) {
            arg4.selectInRegistrationPhase(Unit.INSTANCE);
            return;
        }

        arg4.disposeOnCompletion(JobKt.invokeOnCompletion$default(this, false, new SelectOnJoinCompletionHandler(this, arg4), 1, null));
    }

    public final void removeNode$kotlinx_coroutines_core(JobNode arg4) {
        do {
            Object v0 = this.getState$kotlinx_coroutines_core();
            if(!(v0 instanceof JobNode)) {
                goto label_10;
            }
            else if((((JobNode)v0)) != arg4) {
            }
            else {
                if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport.get_state$volatile$FU(), this, v0, JobSupportKt.access$getEMPTY_ACTIVE$p())) {
                    continue;
                }

                return;
            }

            return;
        }
        while(true);

        return;
    label_10:
        if(((v0 instanceof Incomplete)) && ((Incomplete)v0).getList() != null) {
            arg4.remove();
        }
    }

    public final void setParentHandle$kotlinx_coroutines_core(ChildHandle arg2) {
        JobSupport.get_parentHandle$volatile$FU().set(this, arg2);
    }

    private final void set_parentHandle$volatile(Object arg1) {
        this._parentHandle$volatile = arg1;
    }

    private final void set_state$volatile(Object arg1) {
        this._state$volatile = arg1;
    }

    public final boolean start() {
        while(true) {
            int v0 = this.startInternal(this.getState$kotlinx_coroutines_core());
            if(v0 == 0) {
                return 0;
            }

            if(v0 == 1) {
                return 1;
            }
        }

        return 1;
    }

    private final int startInternal(Object arg5) {
        int v1 = -1;
        if((arg5 instanceof Empty)) {
            if(arg5.isActive()) {
                return 0;
            }

            if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport.get_state$volatile$FU(), this, arg5, JobSupportKt.access$getEMPTY_ACTIVE$p())) {
                return v1;
            }

            this.onStart();
            return 1;
        }

        if((arg5 instanceof InactiveNodeList)) {
            if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport.get_state$volatile$FU(), this, arg5, arg5.getList())) {
                return v1;
            }

            this.onStart();
            return 1;
        }

        return 0;
    }

    private final String stateString(Object arg2) {
        String v0 = "Active";
        if((arg2 instanceof Finishing)) {
            if(((Finishing)arg2).isCancelling()) {
                return "Cancelling";
            }

            if(((Finishing)arg2).isCompleting()) {
                return "Completing";
            }

            return v0;
        }

        if((arg2 instanceof Incomplete)) {
            if(((Incomplete)arg2).isActive()) {
                return v0;
            }

            return "New";
        }

        if((arg2 instanceof CompletedExceptionally)) {
            return "Cancelled";
        }

        return "Completed";
    }

    protected final CancellationException toCancellationException(Throwable arg2, String arg3) {
        Throwable v0 = (arg2 instanceof CancellationException) ? arg2 : null;
        if(v0 == null) {
            if(arg3 == null) {
                arg3 = this.cancellationExceptionMessage();
            }

            JobCancellationException v0_1 = new JobCancellationException(arg3, arg2, ((Job)this));
        }

        return ((CancellationException)v0);
    }

    public static CancellationException toCancellationException$default(JobSupport arg0, Throwable arg1, String arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg2 = null;
            }

            return arg0.toCancellationException(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    public final String toDebugString() {
        return this.nameString$kotlinx_coroutines_core() + '{' + this.stateString(this.getState$kotlinx_coroutines_core()) + '}';
    }

    public String toString() {
        return this.toDebugString() + '@' + DebugStringsKt.getHexAddress(this);
    }

    private final boolean tryFinalizeSimpleState(Incomplete arg3, Object arg4) {
        if((DebugKt.getASSERTIONS_ENABLED()) && !(arg3 instanceof Empty)) {
            if((arg3 instanceof JobNode)) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(!(arg4 instanceof CompletedExceptionally)) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport.get_state$volatile$FU(), this, arg3, JobSupportKt.boxIncomplete(arg4))) {
            return 0;
        }

        this.onCancelling(null);
        this.onCompletionInternal(arg4);
        this.completeStateFinalization(arg3, arg4);
        return 1;
    }

    private final boolean tryMakeCancelling(Incomplete arg5, Throwable arg6) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(!(arg5 instanceof Finishing)) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(arg5.isActive()) {
            }
            else {
                throw new AssertionError();
            }
        }

        NodeList v0 = this.getOrPromoteCancellingList(arg5);
        if(v0 == null) {
            return 0;
        }

        if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport.get_state$volatile$FU(), this, arg5, new Finishing(v0, false, arg6))) {
            return 0;
        }

        this.notifyCancelling(v0, arg6);
        return 1;
    }

    private final Object tryMakeCompleting(Object arg2, Object arg3) {
        if(!(arg2 instanceof Incomplete)) {
            return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        }

        if((((arg2 instanceof Empty)) || ((arg2 instanceof JobNode))) && (!(arg2 instanceof ChildHandleNode) && !(arg3 instanceof CompletedExceptionally))) {
            if(this.tryFinalizeSimpleState(((Incomplete)arg2), arg3)) {
                return arg3;
            }
            else {
                return JobSupportKt.access$getCOMPLETING_RETRY$p();
            }
        }

        return this.tryMakeCompletingSlowPath(((Incomplete)arg2), arg3);
    }

    private final Object tryMakeCompletingSlowPath(Incomplete arg7, Object arg8) {
        Symbol v6_1;
        NodeList v0 = this.getOrPromoteCancellingList(arg7);
        if(v0 == null) {
            return JobSupportKt.access$getCOMPLETING_RETRY$p();
        }

        Throwable v2 = null;
        Incomplete v1 = (arg7 instanceof Finishing) ? arg7 : ((Incomplete)v2);
        if(v1 == null) {
            Finishing v1_1 = new Finishing(v0, false, v2);
        }

        ObjectRef v3 = new ObjectRef();
        __monitor_enter(v1);
        try {
            if(!((Finishing)v1).isCompleting()) {
                goto label_23;
            }

            v6_1 = JobSupportKt.access$getCOMPLETING_ALREADY$p();
        }
        catch(Throwable v6) {
            goto label_78;
        }

        __monitor_exit(v1);
        return v6_1;
        try {
        label_23:
            ((Finishing)v1).setCompleting(true);
            if(v1 != arg7 && !AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport.get_state$volatile$FU(), this, arg7, v1)) {
                v6_1 = JobSupportKt.access$getCOMPLETING_RETRY$p();
                goto label_29;
            }

            goto label_31;
        }
        catch(Throwable v6) {
            goto label_78;
        }

    label_29:
        __monitor_exit(v1);
        return v6_1;
        try {
        label_31:
            if(DebugKt.getASSERTIONS_ENABLED()) {
                if(!((Finishing)v1).isSealed()) {
                }
                else {
                    throw new AssertionError();
                }
            }

            boolean v7 = ((Finishing)v1).isCancelling();
            Object v5 = (arg8 instanceof CompletedExceptionally) ? arg8 : v2;
            if(v5 != null) {
                ((Finishing)v1).addExceptionLocked(((CompletedExceptionally)v5).cause);
            }

            Throwable v5_1 = ((Finishing)v1).getRootCause();
            if(Boolean.valueOf((((int)v7)) ^ 1).booleanValue()) {
                v2 = v5_1;
            }

            v3.element = v2;
        }
        catch(Throwable v6) {
        label_78:
            __monitor_exit(v1);
            throw v6;
        }

        __monitor_exit(v1);
        Object v7_1 = v3.element;
        if(v7_1 != null) {
            this.notifyCancelling(v0, ((Throwable)v7_1));
        }

        NodeList v7_2 = v0;
        ChildHandleNode v2_1 = this.nextChild(((LockFreeLinkedListNode)v7_2));
        if(v2_1 != null && (this.tryWaitForChild(((Finishing)v1), v2_1, arg8))) {
            return JobSupportKt.COMPLETING_WAITING_CHILDREN;
        }

        v0.close(2);
        ChildHandleNode v7_3 = this.nextChild(((LockFreeLinkedListNode)v7_2));
        if(v7_3 != null && (this.tryWaitForChild(((Finishing)v1), v7_3, arg8))) {
            return JobSupportKt.COMPLETING_WAITING_CHILDREN;
        }

        return this.finalizeFinishingState(((Finishing)v1), arg8);
    }

    private final boolean tryPutNodeIntoList(JobNode arg5, Function2 arg6) {
        do {
        label_0:
            Object v0 = this.getState$kotlinx_coroutines_core();
            if((v0 instanceof Empty)) {
                Object v1 = v0;
                if(((Empty)v1).isActive()) {
                    if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport.get_state$volatile$FU(), this, v0, arg5)) {
                        goto label_0;
                    }

                    return 1;
                }

                this.promoteEmptyToNodeList(((Empty)v1));
                goto label_0;
            }

            if(!(v0 instanceof Incomplete)) {
                return 0;
            }

            NodeList v1_1 = v0.getList();
            if(v1_1 == null) {
                Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                this.promoteSingleToNodeList(((JobNode)v0));
                goto label_0;
            }
        }
        while(!arg6.invoke(v0, v1_1).booleanValue());

        return 1;
    }

    private final boolean tryWaitForChild(Finishing arg4, ChildHandleNode arg5, Object arg6) {
        do {
            if(JobKt.invokeOnCompletion(arg5.childJob, false, new ChildCompletion(this, arg4, arg5, arg6)) != NonDisposableHandle.INSTANCE) {
                return 1;
            }

            arg5 = this.nextChild(((LockFreeLinkedListNode)arg5));
        }
        while(arg5 != null);

        return 0;
    }
}

