package kotlinx.coroutines.channels;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

@Metadata(d1={"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004ì\u0001í\u0001B3\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001A\u001C\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010 \u001A\u00020\u00072\u0006\u0010!\u001A\u00028\u0000H\u0096@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001A\u00020\u00072\u0006\u0010!\u001A\u00028\u0000H\u0082@¢\u0006\u0002\u0010\"J4\u0010$\u001A\u00020\u00072\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u00042\u0006\u0010!\u001A\u00028\u00002\u0006\u0010\'\u001A\u00020\u0010H\u0082@¢\u0006\u0002\u0010(J\"\u0010)\u001A\u00020\u0007*\u00020*2\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u0004H\u0002J#\u0010+\u001A\u00020\u00072\u0006\u0010!\u001A\u00028\u00002\f\u0010,\u001A\b\u0012\u0004\u0012\u00020\u00070-H\u0002¢\u0006\u0002\u0010.J\u001D\u0010/\u001A\b\u0012\u0004\u0012\u00020\u0007002\u0006\u0010!\u001A\u00028\u0000H\u0016¢\u0006\u0004\b1\u00102J\u0018\u00103\u001A\u00020\u00192\u0006\u0010!\u001A\u00028\u0000H\u0090@¢\u0006\u0004\b4\u0010\"Jê\u0001\u00105\u001A\u0002H6\"\u0004\b\u0001\u001062\u0006\u0010!\u001A\u00028\u00002\b\u00107\u001A\u0004\u0018\u0001082\f\u00109\u001A\b\u0012\u0004\u0012\u0002H60:2<\u0010;\u001A8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001D¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(@\u0012\u0004\u0012\u0002H60<2\f\u0010A\u001A\b\u0012\u0004\u0012\u0002H60:2h\b\u0002\u0010B\u001Ab\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001D¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(@\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(\'\u0012\u0004\u0012\u0002H60CH\u0082\b¢\u0006\u0002\u0010DJ\u001D\u0010E\u001A\b\u0012\u0004\u0012\u00020\u0007002\u0006\u0010!\u001A\u00028\u0000H\u0004¢\u0006\u0004\bF\u00102JX\u0010G\u001A\u00020\u00072\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u00042\u0006\u0010!\u001A\u00028\u00002\u0006\u0010\'\u001A\u00020\u00102\u0006\u00107\u001A\u00020*2\f\u00109\u001A\b\u0012\u0004\u0012\u00020\u00070:2\f\u0010A\u001A\b\u0012\u0004\u0012\u00020\u00070:H\u0082\b¢\u0006\u0002\u0010HJE\u0010I\u001A\u00020\u00042\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u00042\u0006\u0010!\u001A\u00028\u00002\u0006\u0010\'\u001A\u00020\u00102\b\u00107\u001A\u0004\u0018\u0001082\u0006\u0010J\u001A\u00020\u0019H\u0002¢\u0006\u0002\u0010KJE\u0010L\u001A\u00020\u00042\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u00042\u0006\u0010!\u001A\u00028\u00002\u0006\u0010\'\u001A\u00020\u00102\b\u00107\u001A\u0004\u0018\u0001082\u0006\u0010J\u001A\u00020\u0019H\u0002¢\u0006\u0002\u0010KJ\u0010\u0010M\u001A\u00020\u00192\u0006\u0010N\u001A\u00020\u0010H\u0003J\u0010\u0010O\u001A\u00020\u00192\u0006\u0010P\u001A\u00020\u0010H\u0002J\r\u0010M\u001A\u00020\u0019H\u0010¢\u0006\u0002\bQJ\u0019\u0010R\u001A\u00020\u0019*\u0002082\u0006\u0010!\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010SJ\b\u0010T\u001A\u00020\u0007H\u0014J\b\u0010U\u001A\u00020\u0007H\u0014J\u000E\u0010V\u001A\u00028\u0000H\u0096@¢\u0006\u0002\u0010WJ,\u0010X\u001A\u00028\u00002\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u00042\u0006\u0010Y\u001A\u00020\u0010H\u0082@¢\u0006\u0002\u0010ZJ\"\u0010[\u001A\u00020\u0007*\u00020*2\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u0004H\u0002J\u0016\u0010\\\u001A\u00020\u00072\f\u0010,\u001A\b\u0012\u0004\u0012\u00028\u00000-H\u0002J\u0016\u0010]\u001A\b\u0012\u0004\u0012\u00028\u000000H\u0096@¢\u0006\u0004\b^\u0010WJ4\u0010_\u001A\b\u0012\u0004\u0012\u00028\u0000002\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u00042\u0006\u0010Y\u001A\u00020\u0010H\u0082@¢\u0006\u0004\b`\u0010ZJ\u001C\u0010a\u001A\u00020\u00072\u0012\u0010,\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000-H\u0002J\u0015\u0010b\u001A\b\u0012\u0004\u0012\u00028\u000000H\u0016¢\u0006\u0004\bc\u0010dJ\u0010\u0010e\u001A\u00020\u00072\u0006\u0010f\u001A\u00020\u0010H\u0004J÷\u0001\u0010g\u001A\u0002H6\"\u0004\b\u0001\u001062\b\u00107\u001A\u0004\u0018\u0001082!\u0010h\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(!\u0012\u0004\u0012\u0002H60\u00062Q\u0010;\u001AM\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001D¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(Y\u0012\u0004\u0012\u0002H60i2\f\u0010A\u001A\b\u0012\u0004\u0012\u0002H60:2S\b\u0002\u0010B\u001AM\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001D¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(Y\u0012\u0004\u0012\u0002H60iH\u0082\b¢\u0006\u0002\u0010jJ`\u0010k\u001A\u00020\u00072\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u00042\u0006\u0010Y\u001A\u00020\u00102\u0006\u00107\u001A\u00020*2!\u0010h\u001A\u001D\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010A\u001A\b\u0012\u0004\u0012\u00020\u00070:H\u0082\bJ2\u0010l\u001A\u0004\u0018\u0001082\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u00042\u0006\u0010Y\u001A\u00020\u00102\b\u00107\u001A\u0004\u0018\u000108H\u0002J2\u0010m\u001A\u0004\u0018\u0001082\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u00042\u0006\u0010Y\u001A\u00020\u00102\b\u00107\u001A\u0004\u0018\u000108H\u0002J\"\u0010n\u001A\u00020\u0019*\u0002082\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u0004H\u0002J\b\u0010o\u001A\u00020\u0007H\u0002J&\u0010p\u001A\u00020\u00192\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u00042\u0006\u0010q\u001A\u00020\u0010H\u0002J&\u0010r\u001A\u00020\u00192\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u00042\u0006\u0010q\u001A\u00020\u0010H\u0002J\u0012\u0010s\u001A\u00020\u00072\b\b\u0002\u0010t\u001A\u00020\u0010H\u0002J\u0015\u0010u\u001A\u00020\u00072\u0006\u0010v\u001A\u00020\u0010H\u0000¢\u0006\u0002\bwJ\u001F\u0010~\u001A\u00020\u00072\u000B\u0010\u007F\u001A\u0007\u0012\u0002\b\u00030\u0080\u00012\b\u0010!\u001A\u0004\u0018\u000108H\u0014J$\u0010\u0081\u0001\u001A\u00020\u00072\u0006\u0010!\u001A\u00028\u00002\u000B\u0010\u007F\u001A\u0007\u0012\u0002\b\u00030\u0080\u0001H\u0002¢\u0006\u0003\u0010\u0082\u0001J!\u0010\u0083\u0001\u001A\u0004\u0018\u0001082\t\u0010\u0084\u0001\u001A\u0004\u0018\u0001082\t\u0010\u0085\u0001\u001A\u0004\u0018\u000108H\u0002J!\u0010\u0091\u0001\u001A\u00020\u00072\u000B\u0010\u007F\u001A\u0007\u0012\u0002\b\u00030\u0080\u00012\t\u0010\u0084\u0001\u001A\u0004\u0018\u000108H\u0002J\u0016\u0010\u0092\u0001\u001A\u00020\u00072\u000B\u0010\u007F\u001A\u0007\u0012\u0002\b\u00030\u0080\u0001H\u0002J!\u0010\u0093\u0001\u001A\u0004\u0018\u0001082\t\u0010\u0084\u0001\u001A\u0004\u0018\u0001082\t\u0010\u0085\u0001\u001A\u0004\u0018\u000108H\u0002J!\u0010\u0094\u0001\u001A\u0004\u0018\u0001082\t\u0010\u0084\u0001\u001A\u0004\u0018\u0001082\t\u0010\u0085\u0001\u001A\u0004\u0018\u000108H\u0002J!\u0010\u0095\u0001\u001A\u0004\u0018\u0001082\t\u0010\u0084\u0001\u001A\u0004\u0018\u0001082\t\u0010\u0085\u0001\u001A\u0004\u0018\u000108H\u0002J\u0011\u0010\u009D\u0001\u001A\t\u0012\u0004\u0012\u00028\u00000\u009E\u0001H\u0096\u0002J\t\u0010¨\u0001\u001A\u00020\u0007H\u0014J\u0015\u0010©\u0001\u001A\u00020\u00192\n\u0010ª\u0001\u001A\u0005\u0018\u00010\u0099\u0001H\u0016J\u0013\u0010«\u0001\u001A\u00020\u00192\n\u0010ª\u0001\u001A\u0005\u0018\u00010\u0099\u0001J\u0007\u0010«\u0001\u001A\u00020\u0007J \u0010«\u0001\u001A\u00020\u00072\u0011\u0010ª\u0001\u001A\f\u0018\u00010¬\u0001j\u0005\u0018\u0001`­\u0001¢\u0006\u0003\u0010®\u0001J\u001B\u0010¯\u0001\u001A\u00020\u00192\n\u0010ª\u0001\u001A\u0005\u0018\u00010\u0099\u0001H\u0010¢\u0006\u0003\b°\u0001J\u001E\u0010±\u0001\u001A\u00020\u00192\n\u0010ª\u0001\u001A\u0005\u0018\u00010\u0099\u00012\u0007\u0010«\u0001\u001A\u00020\u0019H\u0014J\t\u0010²\u0001\u001A\u00020\u0007H\u0002J1\u0010³\u0001\u001A\u00020\u00072&\u0010´\u0001\u001A!\u0012\u0017\u0012\u0015\u0018\u00010\u0099\u0001¢\u0006\r\b=\u0012\t\b>\u0012\u0005\b\b(ª\u0001\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\t\u0010µ\u0001\u001A\u00020\u0007H\u0002J\t\u0010¶\u0001\u001A\u00020\u0007H\u0002J\t\u0010·\u0001\u001A\u00020\u0007H\u0002J\t\u0010¸\u0001\u001A\u00020\u0007H\u0002J\u0018\u0010º\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0007\u0010»\u0001\u001A\u00020\u0010H\u0002J\u0012\u0010¼\u0001\u001A\u00020\u00072\u0007\u0010»\u0001\u001A\u00020\u0010H\u0002J\u000F\u0010½\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000\u001DH\u0002J\u0018\u0010¾\u0001\u001A\u00020\u00102\r\u0010¿\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000\u001DH\u0002J\u0018\u0010À\u0001\u001A\u00020\u00072\r\u0010¿\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000\u001DH\u0002J \u0010Á\u0001\u001A\u00020\u00072\r\u0010¿\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010\u000F\u001A\u00020\u0010H\u0002J\r\u0010Â\u0001\u001A\u00020\u0007*\u00020*H\u0002J\r\u0010Ã\u0001\u001A\u00020\u0007*\u00020*H\u0002J\u0016\u0010Ä\u0001\u001A\u00020\u0007*\u00020*2\u0007\u0010Å\u0001\u001A\u00020\u0019H\u0002J\u001B\u0010Í\u0001\u001A\u00020\u00192\u0007\u0010Î\u0001\u001A\u00020\u00102\u0007\u0010Ê\u0001\u001A\u00020\u0019H\u0002J\u000F\u0010Ñ\u0001\u001A\u00020\u0019H\u0000¢\u0006\u0003\bÒ\u0001J\'\u0010Ó\u0001\u001A\u00020\u00192\f\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0006\u0010&\u001A\u00020\u00042\u0006\u0010v\u001A\u00020\u0010H\u0002J)\u0010Ô\u0001\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001D2\u0007\u0010Õ\u0001\u001A\u00020\u00102\r\u0010Ö\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000\u001DH\u0002J)\u0010×\u0001\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001D2\u0007\u0010Õ\u0001\u001A\u00020\u00102\r\u0010Ö\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000\u001DH\u0002J2\u0010Ø\u0001\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001D2\u0007\u0010Õ\u0001\u001A\u00020\u00102\r\u0010Ö\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000\u001D2\u0007\u0010Ù\u0001\u001A\u00020\u0010H\u0002J!\u0010Ú\u0001\u001A\u00020\u00072\u0007\u0010Õ\u0001\u001A\u00020\u00102\r\u0010Ö\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000\u001DH\u0002J\u0012\u0010Û\u0001\u001A\u00020\u00072\u0007\u0010Ü\u0001\u001A\u00020\u0010H\u0002J\u0012\u0010Ý\u0001\u001A\u00020\u00072\u0007\u0010Ü\u0001\u001A\u00020\u0010H\u0002J\n\u0010Þ\u0001\u001A\u00030ß\u0001H\u0016J\u0010\u0010à\u0001\u001A\u00030ß\u0001H\u0000¢\u0006\u0003\bá\u0001J\u0007\u0010â\u0001\u001A\u00020\u0007JD\u0010ã\u0001\u001A#\u0012\u0005\u0012\u00030\u0099\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000000\u0012\u0005\u0012\u00030\u009A\u0001\u0012\u0004\u0012\u00020\u00070ä\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00028\u0000`\bH\u0002J4\u0010å\u0001\u001A\u00020\u00072\b\u0010ª\u0001\u001A\u00030\u0099\u00012\f\u0010!\u001A\b\u0012\u0004\u0012\u00028\u0000002\b\u0010æ\u0001\u001A\u00030\u009A\u0001H\u0002¢\u0006\u0006\bç\u0001\u0010è\u0001JM\u0010é\u0001\u001A\u001E\u0012\u0005\u0012\u00030\u0099\u0001\u0012\u0006\u0012\u0004\u0018\u000108\u0012\u0005\u0012\u00030\u009A\u0001\u0012\u0004\u0012\u00020\u00070i*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00028\u0000`\b2\u0006\u0010!\u001A\u00028\u0000H\u0002¢\u0006\u0003\u0010ê\u0001J>\u0010é\u0001\u001A\u001D\u0012\u0005\u0012\u00030\u0099\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0005\u0012\u00030\u009A\u0001\u0012\u0004\u0012\u00020\u00070ä\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00028\u0000`\bH\u0002J+\u0010ë\u0001\u001A\u00020\u00072\b\u0010ª\u0001\u001A\u00030\u0099\u00012\u0006\u0010!\u001A\u00028\u00002\b\u0010æ\u0001\u001A\u00030\u009A\u0001H\u0002¢\u0006\u0003\u0010è\u0001R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0005\u001A\u001C\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\t\u0010\u000B\u001A\u00020\fX\u0082\u0004R\t\u0010\r\u001A\u00020\fX\u0082\u0004R\t\u0010\u000E\u001A\u00020\fX\u0082\u0004R\u0014\u0010\u000F\u001A\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001A\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0012R\t\u0010\u0017\u001A\u00020\fX\u0082\u0004R\u0014\u0010\u0018\u001A\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u001AR\u0015\u0010\u001B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001D0\u001CX\u0082\u0004R\u0015\u0010\u001E\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001D0\u001CX\u0082\u0004R\u0015\u0010\u001F\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001D0\u001CX\u0082\u0004R,\u0010x\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000y8VX\u0096\u0004¢\u0006\f\u0012\u0004\bz\u0010{\u001A\u0004\b|\u0010}R%\u0010\u0086\u0001\u001A\t\u0012\u0004\u0012\u00028\u00000\u0087\u00018VX\u0096\u0004¢\u0006\u000F\u0012\u0005\b\u0088\u0001\u0010{\u001A\u0006\b\u0089\u0001\u0010\u008A\u0001R+\u0010\u008B\u0001\u001A\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000\u0087\u00018VX\u0096\u0004¢\u0006\u000F\u0012\u0005\b\u008C\u0001\u0010{\u001A\u0006\b\u008D\u0001\u0010\u008A\u0001R\'\u0010\u008E\u0001\u001A\u000B\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0087\u00018VX\u0096\u0004¢\u0006\u000F\u0012\u0005\b\u008F\u0001\u0010{\u001A\u0006\b\u0090\u0001\u0010\u008A\u0001R\u008B\u0001\u0010\u0096\u0001\u001Aw\u0012\u0018\u0012\u0016\u0012\u0002\b\u00030\u0080\u0001¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(\u007F\u0012\u0016\u0012\u0014\u0018\u000108¢\u0006\r\b=\u0012\t\b>\u0012\u0005\b\b(\u0097\u0001\u0012\u0016\u0012\u0014\u0018\u000108¢\u0006\r\b=\u0012\t\b>\u0012\u0005\b\b(\u0098\u0001\u0012 \u0012\u001E\u0012\u0005\u0012\u00030\u0099\u0001\u0012\u0006\u0012\u0004\u0018\u000108\u0012\u0005\u0012\u00030\u009A\u0001\u0012\u0004\u0012\u00020\u00070i\u0018\u00010ij\u0005\u0018\u0001`\u009B\u0001X\u0082\u0004¢\u0006\t\n\u0000\u0012\u0005\b\u009C\u0001\u0010{R\u0012\u0010\u009F\u0001\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001080\u001CX\u0082\u0004R\u001A\u0010 \u0001\u001A\u0005\u0018\u00010\u0099\u00018DX\u0084\u0004¢\u0006\b\u001A\u0006\b¡\u0001\u0010¢\u0001R\u0018\u0010£\u0001\u001A\u00030\u0099\u00018DX\u0084\u0004¢\u0006\b\u001A\u0006\b¤\u0001\u0010¢\u0001R\u0018\u0010¥\u0001\u001A\u00030\u0099\u00018BX\u0082\u0004¢\u0006\b\u001A\u0006\b¦\u0001\u0010¢\u0001R\u0012\u0010§\u0001\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001080\u001CX\u0082\u0004R\u0016\u0010¹\u0001\u001A\u00020\u00198TX\u0094\u0004¢\u0006\u0007\u001A\u0005\b¹\u0001\u0010\u001AR\u001D\u0010Æ\u0001\u001A\u00020\u00198VX\u0097\u0004¢\u0006\u000E\u0012\u0005\bÇ\u0001\u0010{\u001A\u0005\bÆ\u0001\u0010\u001AR\u001B\u0010È\u0001\u001A\u00020\u0019*\u00020\u00108BX\u0082\u0004¢\u0006\b\u001A\u0006\bÈ\u0001\u0010É\u0001R\u001D\u0010Ê\u0001\u001A\u00020\u00198VX\u0097\u0004¢\u0006\u000E\u0012\u0005\bË\u0001\u0010{\u001A\u0005\bÊ\u0001\u0010\u001AR\u001B\u0010Ì\u0001\u001A\u00020\u0019*\u00020\u00108BX\u0082\u0004¢\u0006\b\u001A\u0006\bÌ\u0001\u0010É\u0001R\u001D\u0010Ï\u0001\u001A\u00020\u00198VX\u0097\u0004¢\u0006\u000E\u0012\u0005\bÐ\u0001\u0010{\u001A\u0005\bÏ\u0001\u0010\u001A¨\u0006î\u0001"}, d2={"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "capacity", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "sendersAndCloseStatus", "Lkotlinx/atomicfu/AtomicLong;", "receivers", "bufferEnd", "sendersCounter", "", "getSendersCounter$kotlinx_coroutines_core", "()J", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "bufferEndCounter", "getBufferEndCounter", "completedExpandBuffersAndPauseFlag", "isRendezvousOrUnlimited", "", "()Z", "sendSegment", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/channels/ChannelSegment;", "receiveSegment", "bufferEndSegment", "send", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSend", "sendOnNoWaiterSuspend", "segment", "index", "s", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareSenderForSuspension", "Lkotlinx/coroutines/Waiter;", "onClosedSendOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "R", "waiter", "", "onRendezvousOrBuffered", "Lkotlin/Function0;", "onSuspend", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "segm", "i", "onClosed", "onNoWaiterSuspend", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "shouldSendSuspend", "curSendersAndCloseStatus", "bufferOrRendezvousSend", "curSenders", "shouldSendSuspend$kotlinx_coroutines_core", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "onReceiveEnqueued", "onReceiveDequeued", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOnNoWaiterSuspend", "r", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareReceiverForSuspension", "onClosedReceiveOnNoWaiterSuspend", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "onClosedReceiveCatchingOnNoWaiterSuspend", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "receiveImpl", "onElementRetrieved", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "updateCellReceive", "updateCellReceiveSlow", "tryResumeSender", "expandBuffer", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "incCompletedExpandBufferAttempts", "nAttempts", "waitExpandBufferCompletion", "globalIndex", "waitExpandBufferCompletion$kotlinx_coroutines_core", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "onClosedSelectOnSend", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "processResultSelectSend", "ignoredParam", "selectResult", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "registerSelectForReceive", "onClosedSelectOnReceive", "processResultSelectReceive", "processResultSelectReceiveOrNull", "processResultSelectReceiveCatching", "onUndeliveredElementReceiveCancellationConstructor", "param", "internalResult", "", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "_closeCause", "closeCause", "getCloseCause", "()Ljava/lang/Throwable;", "sendException", "getSendException", "receiveException", "getReceiveException", "closeHandler", "onClosedIdempotent", "close", "cause", "cancel", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "closeOrCancelImpl", "invokeCloseHandler", "invokeOnClose", "handler", "markClosed", "markCancelled", "markCancellationStarted", "completeCloseOrCancel", "isConflatedDropOldest", "completeClose", "sendersCur", "completeCancel", "closeLinkedList", "markAllEmptyCellsAsClosed", "lastSegment", "removeUnprocessedElements", "cancelSuspendedReceiveRequests", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", "receiver", "isClosedForSend", "isClosedForSend$annotations", "isClosedForSend0", "(J)Z", "isClosedForReceive", "isClosedForReceive$annotations", "isClosedForReceive0", "isClosed", "sendersAndCloseStatusCur", "isEmpty", "isEmpty$annotations", "hasElements", "hasElements$kotlinx_coroutines_core", "isCellNonEmpty", "findSegmentSend", "id", "startFrom", "findSegmentReceive", "findSegmentBufferEnd", "currentBufferEndCounter", "moveSegmentBufferEndToSpecifiedOrLast", "updateSendersCounterIfLower", "value", "updateReceiversCounterIfLower", "toString", "", "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "checkSegmentStructureInvariants", "bindCancellationFunResult", "Lkotlin/reflect/KFunction3;", "onCancellationChannelResultImplDoNotCall", "context", "onCancellationChannelResultImplDoNotCall-5_sEAP8", "(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "bindCancellationFun", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/jvm/functions/Function3;", "onCancellationImplDoNotCall", "SendBroadcast", "BufferedChannelIterator", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class BufferedChannel implements Channel {
    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000E\u0010\n\u001A\u00020\tH\u0096B¢\u0006\u0002\u0010\u000BJ\b\u0010\f\u001A\u00020\tH\u0002J,\u0010\r\u001A\u00020\t2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014J\u001C\u0010\u0015\u001A\u00020\u00162\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0018\u001A\u00020\u0016H\u0002J\u000E\u0010\u0019\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001AJ\u0013\u0010\u001B\u001A\u00020\t2\u0006\u0010\u001C\u001A\u00028\u0000¢\u0006\u0002\u0010\u001DJ\u0006\u0010\u001E\u001A\u00020\u0016R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "<init>", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "receiveResult", "", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedHasNext", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", "", "r", "", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", "", "Lkotlinx/coroutines/internal/Segment;", "onClosedHasNextNoWaiterSuspend", "next", "()Ljava/lang/Object;", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class BufferedChannelIterator implements Waiter, ChannelIterator {
        private CancellableContinuationImpl continuation;
        private Object receiveResult;

        public BufferedChannelIterator(BufferedChannel arg1) {
            BufferedChannel.this = arg1;
            super();
            this.receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();
        }

        public static final Object access$hasNextOnNoWaiterSuspend(BufferedChannelIterator arg0, ChannelSegment arg1, int arg2, long arg3, Continuation arg5) {
            return arg0.hasNextOnNoWaiterSuspend(arg1, arg2, arg3, arg5);
        }

        public static final void access$onClosedHasNextNoWaiterSuspend(BufferedChannelIterator arg0) {
            arg0.onClosedHasNextNoWaiterSuspend();
        }

        public static final void access$setContinuation$p(BufferedChannelIterator arg0, CancellableContinuationImpl arg1) {
            arg0.continuation = arg1;
        }

        public static final void access$setReceiveResult$p(BufferedChannelIterator arg0, Object arg1) {
            arg0.receiveResult = arg1;
        }

        public Object hasNext(Continuation arg11) {
            int v5;
            ChannelSegment v4_1;
            long v6;
            boolean v2 = true;
            if(this.receiveResult == BufferedChannelKt.access$getNO_RECEIVE_RESULT$p() || this.receiveResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
                BufferedChannel v3 = BufferedChannel.this;
                Object v0 = BufferedChannel.getReceiveSegment$volatile$FU().get(v3);
                while(true) {
                    if(!v3.isClosedForReceive()) {
                        v6 = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(v3);
                        long v4 = v6 / (((long)BufferedChannelKt.SEGMENT_SIZE));
                        int v1 = ((int)(v6 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
                        if(((ChannelSegment)v0).id != v4) {
                            v4_1 = v3.findSegmentReceive(v4, ((ChannelSegment)v0));
                            if(v4_1 == null) {
                                continue;
                            }
                        }
                        else {
                            Object v4_2 = v0;
                        }

                        v5 = v1;
                        v0 = v3.updateCellReceive(v4_1, v5, v6, null);
                        if(v0 == BufferedChannelKt.access$getSUSPEND$p()) {
                            goto label_57;
                        }

                        if(v0 != BufferedChannelKt.access$getFAILED$p()) {
                            break;
                        }

                        if(v6 < v3.getSendersCounter$kotlinx_coroutines_core()) {
                            v4_1.cleanPrev();
                        }

                        ChannelSegment v0_1 = v4_1;
                        continue;
                    }
                    else {
                        goto label_13;
                    }
                }

                if(v0 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                    return this.hasNextOnNoWaiterSuspend(v4_1, v5, v6, arg11);
                }

                v4_1.cleanPrev();
                this.receiveResult = v0;
                goto label_55;
            label_57:
                throw new IllegalStateException("unreachable".toString());
            label_13:
                v2 = this.onClosedHasNext();
            }
            else {
            }

        label_55:
            return Boxing.boxBoolean(v2);
        }

        private final Object hasNextOnNoWaiterSuspend(ChannelSegment arg10, int arg11, long arg12, Continuation arg14) {
            Function1 v11_1;
            Boolean v9;
            Object v1_2;
            BufferedChannelIterator v13;
            Object v10;
            BufferedChannel v0 = BufferedChannel.this;
            CancellableContinuationImpl v6 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(arg14));
            try {
                this.continuation = v6;
                ChannelSegment v1 = arg10;
                int v2 = arg11;
                long v3 = arg12;
                v10 = v0.updateCellReceive(v1, v2, v3, this);
                if(v10 == BufferedChannelKt.access$getSUSPEND$p()) {
                    v0.prepareReceiverForSuspension(((Waiter)this), v1, v2);
                }
                else {
                    v13 = null;
                    if(v10 == BufferedChannelKt.access$getFAILED$p()) {
                        if(v3 < v0.getSendersCounter$kotlinx_coroutines_core()) {
                            v1.cleanPrev();
                        }

                        v10 = BufferedChannel.getReceiveSegment$volatile$FU().get(v0);
                        while(true) {
                            boolean v11 = v0.isClosedForReceive();
                            if(v11) {
                                this.onClosedHasNextNoWaiterSuspend();
                                goto label_83;
                            }

                            v3 = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(v0);
                            long v1_1 = v3 / (((long)BufferedChannelKt.SEGMENT_SIZE));
                            arg11 = ((int)(v3 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
                            if(((ChannelSegment)v10).id != v1_1) {
                                v1 = v0.findSegmentReceive(v1_1, ((ChannelSegment)v10));
                                if(v1 == null) {
                                    continue;
                                }
                            }
                            else {
                                v1_2 = v10;
                            }

                            v2 = arg11;
                            v10 = v0.updateCellReceive(((ChannelSegment)v1_2), v2, v3, this);
                            if(v10 == BufferedChannelKt.access$getSUSPEND$p()) {
                                if((this instanceof Waiter)) {
                                    v13 = this;
                                }

                                if(v13 == null) {
                                    goto label_83;
                                }

                                v0.prepareReceiverForSuspension(((Waiter)v13), ((ChannelSegment)v1_2), v2);
                                goto label_83;
                            }

                            if(v10 != BufferedChannelKt.access$getFAILED$p()) {
                                break;
                            }

                            if(v3 < v0.getSendersCounter$kotlinx_coroutines_core()) {
                                ((ChannelSegment)v1_2).cleanPrev();
                            }

                            arg10 = ((ChannelSegment)v1_2);
                        }

                        if(v10 != BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                            ((ChannelSegment)v1_2).cleanPrev();
                            this.receiveResult = v10;
                            this.continuation = ((CancellableContinuationImpl)v13);
                            v9 = Boxing.boxBoolean(true);
                            v11_1 = v0.onUndeliveredElement;
                            if(v11_1 == null) {
                                goto label_69;
                            }

                            goto label_68;
                        }

                        throw new IllegalStateException("unexpected".toString());
                    }
                    else {
                        v1.cleanPrev();
                        this.receiveResult = v10;
                        this.continuation = ((CancellableContinuationImpl)v13);
                        v9 = Boxing.boxBoolean(true);
                        v11_1 = v0.onUndeliveredElement;
                        if(v11_1 == null) {
                            goto label_69;
                        }

                        goto label_82;
                    }

                    goto label_69;
                }

                goto label_83;
            }
            catch(Throwable v0_1) {
                goto label_90;
            }

        label_82:
            try {
            label_68:
                Function3 v13_1 = v0.bindCancellationFun(v11_1, v10);
            label_69:
                v6.resume(v9, ((Function3)v13));
            }
            catch(Throwable v0_1) {
            label_90:
                v6.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw v0_1;
            }

        label_83:
            Object v9_1 = v6.getResult();
            if(v9_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(arg14);
            }

            return v9_1;
        }

        public void invokeOnCancellation(Segment arg1, int arg2) {
            CancellableContinuationImpl v0 = this.continuation;
            if(v0 != null) {
                v0.invokeOnCancellation(arg1, arg2);
            }
        }

        public Object next() {
            Object v0 = this.receiveResult;
            if(v0 != BufferedChannelKt.access$getNO_RECEIVE_RESULT$p()) {
                this.receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();
                if(v0 != BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return v0;
                }

                throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.this.getReceiveException());
            }

            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }

        @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.3.0, binary compatibility with versions <= 1.2.x") public Object next(Continuation arg1) {
            return DefaultImpls.next(((ChannelIterator)this), arg1);
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable v1 = BufferedChannel.this.getCloseCause();
            if(v1 == null) {
                return 0;
            }

            throw StackTraceRecoveryKt.recoverStackTrace(v1);
        }

        private final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl v0 = this.continuation;
            Intrinsics.checkNotNull(v0);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable v2 = BufferedChannel.this.getCloseCause();
            if(v2 == null) {
                ((Continuation)v0).resumeWith(Result.constructor-impl(Boolean.valueOf(false)));
                return;
            }

            if(DebugKt.getRECOVER_STACK_TRACES()) {
                if(!(v0 instanceof CoroutineStackFrame)) {
                }
                else {
                    v2 = StackTraceRecoveryKt.access$recoverFromStackFrame(v2, v0);
                }
            }

            ((Continuation)v0).resumeWith(Result.constructor-impl(ResultKt.createFailure(v2)));
        }

        public final boolean tryResumeHasNext(Object arg5) {
            Function3 v1_1;
            CancellableContinuationImpl v0 = this.continuation;
            Intrinsics.checkNotNull(v0);
            CancellableContinuationImpl v1 = null;
            this.continuation = v1;
            this.receiveResult = arg5;
            Boolean v2 = Boolean.valueOf(true);
            Function1 v3 = BufferedChannel.this.onUndeliveredElement;
            if(v3 != null) {
                v1_1 = BufferedChannel.this.bindCancellationFun(v3, arg5);
            }

            return BufferedChannelKt.access$tryResume0(((CancellableContinuation)v0), v2, v1_1);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl v0 = this.continuation;
            Intrinsics.checkNotNull(v0);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable v2 = BufferedChannel.this.getCloseCause();
            if(v2 == null) {
                ((Continuation)v0).resumeWith(Result.constructor-impl(Boolean.valueOf(false)));
                return;
            }

            if(DebugKt.getRECOVER_STACK_TRACES()) {
                if(!(v0 instanceof CoroutineStackFrame)) {
                }
                else {
                    v2 = StackTraceRecoveryKt.access$recoverFromStackFrame(v2, v0);
                }
            }

            ((Continuation)v0).resumeWith(Result.constructor-impl(ResultKt.createFailure(v2)));
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001D\u0010\t\u001A\u00020\n2\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001A\u00020\u000EH\u0096\u0001R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u000F"}, d2={"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) final class SendBroadcast implements Waiter {
        private final CancellableContinuation cont;

        public SendBroadcast(CancellableContinuation arg2) {
            super();
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = arg2;
            this.cont = arg2;
        }

        public final CancellableContinuation getCont() {
            return this.cont;
        }

        public void invokeOnCancellation(Segment arg1, int arg2) {
            this.$$delegate_0.invokeOnCancellation(arg1, arg2);
        }
    }

    private final int capacity;
    public final Function1 onUndeliveredElement;
    private final Function3 onUndeliveredElementReceiveCancellationConstructor;

    static {
        Class v1 = BufferedChannel.class;
        BufferedChannel.sendersAndCloseStatus$volatile$FU = AtomicLongFieldUpdater.newUpdater(v1, "sendersAndCloseStatus$volatile");
        BufferedChannel.receivers$volatile$FU = AtomicLongFieldUpdater.newUpdater(v1, "receivers$volatile");
        BufferedChannel.bufferEnd$volatile$FU = AtomicLongFieldUpdater.newUpdater(v1, "bufferEnd$volatile");
        BufferedChannel.completedExpandBuffersAndPauseFlag$volatile$FU = AtomicLongFieldUpdater.newUpdater(v1, "completedExpandBuffersAndPauseFlag$volatile");
        Class v0 = Object.class;
        BufferedChannel.sendSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v1, v0, "sendSegment$volatile");
        BufferedChannel.receiveSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v1, v0, "receiveSegment$volatile");
        BufferedChannel.bufferEndSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v1, v0, "bufferEndSegment$volatile");
        BufferedChannel._closeCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v1, v0, "_closeCause$volatile");
        BufferedChannel.closeHandler$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(v1, v0, "closeHandler$volatile");
    }

    public BufferedChannel(int arg9, Function1 arg10) {
        BufferedChannel$$ExternalSyntheticLambda1 v8;
        super();
        this.capacity = arg9;
        this.onUndeliveredElement = arg10;
        if(arg9 >= 0) {
            this.bufferEnd$volatile = BufferedChannelKt.access$initialBufferEnd(arg9);
            this.completedExpandBuffersAndPauseFlag$volatile = this.getBufferEndCounter();
            BufferedChannel v6 = this;
            ChannelSegment v2 = new ChannelSegment(0, null, v6, 3);
            v6.sendSegment$volatile = v2;
            v6.receiveSegment$volatile = v2;
            if(v6.isRendezvousOrUnlimited()) {
                v2 = BufferedChannelKt.access$getNULL_SEGMENT$p();
                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }

            v6.bufferEndSegment$volatile = v2;
            if(arg10 != null) {
                v8 = new BufferedChannel$$ExternalSyntheticLambda1(v6);
            }
            else {
                Function3 v8_1 = null;
            }

            v6.onUndeliveredElementReceiveCancellationConstructor = ((Function3)v8);
            v6._closeCause$volatile = BufferedChannelKt.access$getNO_CLOSE_CAUSE$p();
            return;
        }

        throw new IllegalArgumentException("Invalid channel capacity: " + arg9 + ", should be >=0".toString());
    }

    public BufferedChannel(int arg1, Function1 arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public static final Function3 access$bindCancellationFun(BufferedChannel arg0, Function1 arg1, Object arg2) {
        return arg0.bindCancellationFun(arg1, arg2);
    }

    public static final KFunction access$bindCancellationFun(BufferedChannel arg0, Function1 arg1) {
        return arg0.bindCancellationFun(arg1);
    }

    public static final KFunction access$bindCancellationFunResult(BufferedChannel arg0, Function1 arg1) {
        return arg0.bindCancellationFunResult(arg1);
    }

    public static final ChannelSegment access$findSegmentReceive(BufferedChannel arg0, long arg1, ChannelSegment arg3) {
        return arg0.findSegmentReceive(arg1, arg3);
    }

    public static final ChannelSegment access$findSegmentSend(BufferedChannel arg0, long arg1, ChannelSegment arg3) {
        return arg0.findSegmentSend(arg1, arg3);
    }

    public static final Throwable access$getReceiveException(BufferedChannel arg0) {
        return arg0.getReceiveException();
    }

    public static final AtomicReferenceFieldUpdater access$getReceiveSegment$volatile$FU() {
        return BufferedChannel.getReceiveSegment$volatile$FU();
    }

    public static final AtomicLongFieldUpdater access$getReceivers$volatile$FU() {
        return BufferedChannel.getReceivers$volatile$FU();
    }

    public static final AtomicReferenceFieldUpdater access$getSendSegment$volatile$FU() {
        return BufferedChannel.getSendSegment$volatile$FU();
    }

    public static final AtomicLongFieldUpdater access$getSendersAndCloseStatus$volatile$FU() {
        return BufferedChannel.getSendersAndCloseStatus$volatile$FU();
    }

    public static final boolean access$isClosedForSend0(BufferedChannel arg0, long arg1) {
        return arg0.isClosedForSend0(arg1);
    }

    public static final void access$onCancellationChannelResultImplDoNotCall-5_sEAP8(BufferedChannel arg0, Throwable arg1, Object arg2, CoroutineContext arg3) {
        arg0.onCancellationChannelResultImplDoNotCall-5_sEAP8(arg1, arg2, arg3);
    }

    public static final void access$onCancellationImplDoNotCall(BufferedChannel arg0, Throwable arg1, Object arg2, CoroutineContext arg3) {
        arg0.onCancellationImplDoNotCall(arg1, arg2, arg3);
    }

    public static final void access$onClosedReceiveCatchingOnNoWaiterSuspend(BufferedChannel arg0, CancellableContinuation arg1) {
        arg0.onClosedReceiveCatchingOnNoWaiterSuspend(arg1);
    }

    public static final void access$onClosedReceiveOnNoWaiterSuspend(BufferedChannel arg0, CancellableContinuation arg1) {
        arg0.onClosedReceiveOnNoWaiterSuspend(arg1);
    }

    public static final Object access$onClosedSend(BufferedChannel arg0, Object arg1, Continuation arg2) {
        return arg0.onClosedSend(arg1, arg2);
    }

    public static final void access$onClosedSendOnNoWaiterSuspend(BufferedChannel arg0, Object arg1, CancellableContinuation arg2) {
        arg0.onClosedSendOnNoWaiterSuspend(arg1, arg2);
    }

    public static final void access$prepareReceiverForSuspension(BufferedChannel arg0, Waiter arg1, ChannelSegment arg2, int arg3) {
        arg0.prepareReceiverForSuspension(arg1, arg2, arg3);
    }

    public static final void access$prepareSenderForSuspension(BufferedChannel arg0, Waiter arg1, ChannelSegment arg2, int arg3) {
        arg0.prepareSenderForSuspension(arg1, arg2, arg3);
    }

    public static final Object access$processResultSelectReceive(BufferedChannel arg0, Object arg1, Object arg2) {
        return arg0.processResultSelectReceive(arg1, arg2);
    }

    public static final Object access$processResultSelectReceiveCatching(BufferedChannel arg0, Object arg1, Object arg2) {
        return arg0.processResultSelectReceiveCatching(arg1, arg2);
    }

    public static final Object access$processResultSelectReceiveOrNull(BufferedChannel arg0, Object arg1, Object arg2) {
        return arg0.processResultSelectReceiveOrNull(arg1, arg2);
    }

    public static final Object access$processResultSelectSend(BufferedChannel arg0, Object arg1, Object arg2) {
        return arg0.processResultSelectSend(arg1, arg2);
    }

    public static final Object access$receiveCatchingOnNoWaiterSuspend-GKJJFZk(BufferedChannel arg0, ChannelSegment arg1, int arg2, long arg3, Continuation arg5) {
        return arg0.receiveCatchingOnNoWaiterSuspend-GKJJFZk(arg1, arg2, arg3, arg5);
    }

    public static final Object access$receiveOnNoWaiterSuspend(BufferedChannel arg0, ChannelSegment arg1, int arg2, long arg3, Continuation arg5) {
        return arg0.receiveOnNoWaiterSuspend(arg1, arg2, arg3, arg5);
    }

    public static final void access$registerSelectForReceive(BufferedChannel arg0, SelectInstance arg1, Object arg2) {
        arg0.registerSelectForReceive(arg1, arg2);
    }

    public static final Object access$sendOnNoWaiterSuspend(BufferedChannel arg0, ChannelSegment arg1, int arg2, Object arg3, long arg4, Continuation arg6) {
        return arg0.sendOnNoWaiterSuspend(arg1, arg2, arg3, arg4, arg6);
    }

    public static final Object access$updateCellReceive(BufferedChannel arg0, ChannelSegment arg1, int arg2, long arg3, Object arg5) {
        return arg0.updateCellReceive(arg1, arg2, arg3, arg5);
    }

    public static final int access$updateCellSend(BufferedChannel arg0, ChannelSegment arg1, int arg2, Object arg3, long arg4, Object arg6, boolean arg7) {
        return arg0.updateCellSend(arg1, arg2, arg3, arg4, arg6, arg7);
    }

    private final Function3 bindCancellationFun(Function1 arg1, Object arg2) {
        return new BufferedChannel$$ExternalSyntheticLambda2(arg1, arg2);
    }

    private final KFunction bindCancellationFun(Function1 arg1) {
        return new BufferedChannel$bindCancellationFun$2(this);
    }

    static final Unit bindCancellationFun$lambda$89(Function1 arg0, Object arg1, Throwable arg2, Object arg3, CoroutineContext arg4) {
        OnUndeliveredElementKt.callUndeliveredElement(arg0, arg1, arg4);
        return Unit.INSTANCE;
    }

    private final KFunction bindCancellationFunResult(Function1 arg1) {
        return new BufferedChannel$bindCancellationFunResult$1(this);
    }

    private final boolean bufferOrRendezvousSend(long arg5) {
        if(arg5 >= this.getBufferEndCounter()) {
            if(arg5 < this.getReceiversCounter$kotlinx_coroutines_core() + (((long)this.capacity))) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final void cancel() {
        this.cancelImpl$kotlinx_coroutines_core(null);
    }

    public final void cancel(CancellationException arg1) {
        this.cancelImpl$kotlinx_coroutines_core(((Throwable)arg1));
    }

    public final boolean cancel(Throwable arg1) {
        return this.cancelImpl$kotlinx_coroutines_core(arg1);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable arg2) {
        CancellationException v2;
        if(arg2 == null) {
            v2 = new CancellationException("Channel was cancelled");
        }

        return this.closeOrCancelImpl(((Throwable)v2), true);
    }

    private final void cancelSuspendedReceiveRequests(ChannelSegment arg9, long arg10) {
        Object v0 = InlineList.constructor-impl$default(null, 1, null);
        while(true) {
            int v2 = -1;
            if(arg9 != null) {
                int v3;
                for(v3 = BufferedChannelKt.SEGMENT_SIZE - 1; v2 < v3; --v3) {
                    if(arg9.id * (((long)BufferedChannelKt.SEGMENT_SIZE)) + (((long)v3)) < arg10) {
                        goto label_45;
                    }

                    do {
                        Object v4 = arg9.getState$kotlinx_coroutines_core(v3);
                        if(v4 == null || v4 == BufferedChannelKt.access$getIN_BUFFER$p()) {
                            if(!arg9.casState$kotlinx_coroutines_core(v3, v4, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                continue;
                            }

                            break;
                        }
                        else if((v4 instanceof WaiterEB)) {
                            if(!arg9.casState$kotlinx_coroutines_core(v3, v4, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                continue;
                            }

                            v0 = InlineList.plus-FjFbRPM(v0, ((WaiterEB)v4).waiter);
                            arg9.onCancelledRequest(v3, true);
                        }
                        else if((v4 instanceof Waiter)) {
                            if(!arg9.casState$kotlinx_coroutines_core(v3, v4, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                continue;
                            }

                            v0 = InlineList.plus-FjFbRPM(v0, v4);
                            arg9.onCancelledRequest(v3, true);
                        }

                        goto label_41;
                    }
                    while(true);

                    arg9.onSlotCleaned();
                label_41:
                }

                ConcurrentLinkedListNode v9 = ((ChannelSegment)v9).getPrev();
                continue;
            }

            break;
        }

    label_45:
        if(v0 != null) {
            if(!(v0 instanceof ArrayList)) {
                this.resumeReceiverOnClosedChannel(((Waiter)v0));
                return;
            }
            else {
                Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
                int v9_1;
                for(v9_1 = ((ArrayList)v0).size() - 1; v2 < v9_1; --v9_1) {
                    this.resumeReceiverOnClosedChannel(((ArrayList)v0).get(v9_1));
                }
            }
        }
    }

    public final void checkSegmentStructureInvariants() {
        Object v5;
        if(!this.isRendezvousOrUnlimited()) {
            if(BufferedChannel.getReceiveSegment$volatile$FU().get(this).id <= BufferedChannel.getBufferEndSegment$volatile$FU().get(this).id) {
                goto label_23;
            }

            goto label_181;
        }
        else if(BufferedChannel.getBufferEndSegment$volatile$FU().get(this) == BufferedChannelKt.access$getNULL_SEGMENT$p()) {
        }
        else {
            throw new IllegalStateException("bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: " + this.toString());
        }

    label_23:
        List v0 = CollectionsKt.listOf(new ChannelSegment[]{BufferedChannel.getReceiveSegment$volatile$FU().get(this), BufferedChannel.getSendSegment$volatile$FU().get(this), BufferedChannel.getBufferEndSegment$volatile$FU().get(this)});
        ArrayList v1 = new ArrayList();
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            Object v3 = v0_1.next();
            if(v3 == BufferedChannelKt.access$getNULL_SEGMENT$p()) {
                continue;
            }

            ((Collection)v1).add(v3);
        }

        v0_1 = ((Iterable)v1).iterator();
        if(!v0_1.hasNext()) {
            goto label_178;
        }

        Object v1_1 = v0_1.next();
        if(!v0_1.hasNext()) {
        }
        else {
            long v3_1 = v1_1.id;
            goto label_58;
        label_178:
            throw new NoSuchElementException();
            do {
            label_58:
                v5 = v0_1.next();
                long v6 = v5.id;
                if(v3_1 > v6) {
                    v1_1 = v5;
                    v3_1 = v6;
                }

                if(v0_1.hasNext()) {
                    continue;
                }

                break;
            }
            while(true);
        }

        if(((ChannelSegment)v1_1).getPrev() == null) {
            while(((ChannelSegment)v1_1).getNext() != null) {
                ConcurrentLinkedListNode v0_2 = ((ChannelSegment)v1_1).getNext();
                Intrinsics.checkNotNull(v0_2);
                if(((ChannelSegment)v0_2).getPrev() != null) {
                    v0_2 = ((ChannelSegment)v1_1).getNext();
                    Intrinsics.checkNotNull(v0_2);
                    if(((ChannelSegment)v0_2).getPrev() == v1_1) {
                    }
                    else {
                        throw new IllegalStateException("The `segment.next.prev === segment` invariant is violated.\nChannel state: " + this.toString());
                    }
                }

                int v0_3 = BufferedChannelKt.SEGMENT_SIZE;
                int v3_2 = 0;
                int v4 = 0;
                while(v3_2 < v0_3) {
                    v5 = ((ChannelSegment)v1_1).getState$kotlinx_coroutines_core(v3_2);
                    if(!Intrinsics.areEqual(v5, BufferedChannelKt.BUFFERED) && !(v5 instanceof Waiter)) {
                        String v7 = "Check failed.";
                        if(!Intrinsics.areEqual(v5, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) && !Intrinsics.areEqual(v5, BufferedChannelKt.access$getINTERRUPTED_SEND$p())) {
                            if(Intrinsics.areEqual(v5, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            }
                            else {
                                if(!Intrinsics.areEqual(v5, BufferedChannelKt.access$getPOISONED$p())) {
                                    if(Intrinsics.areEqual(v5, BufferedChannelKt.access$getDONE_RCV$p())) {
                                    }
                                    else {
                                        throw new IllegalStateException("Unexpected segment cell state: " + v5 + ".\nChannel state: " + this.toString());
                                    }
                                }

                                if(((ChannelSegment)v1_1).getElement$kotlinx_coroutines_core(v3_2) == null) {
                                    goto label_141;
                                }

                                throw new IllegalStateException(v7);
                            }
                        }

                        if(((ChannelSegment)v1_1).getElement$kotlinx_coroutines_core(v3_2) == null) {
                            ++v4;
                            goto label_141;
                        }

                        throw new IllegalStateException(v7);
                    }

                label_141:
                    ++v3_2;
                }

                if(v4 == BufferedChannelKt.SEGMENT_SIZE && v1_1 != BufferedChannel.getReceiveSegment$volatile$FU().get(this) && v1_1 != BufferedChannel.getSendSegment$volatile$FU().get(this)) {
                    if(v1_1 == BufferedChannel.getBufferEndSegment$volatile$FU().get(this)) {
                    }
                    else {
                        throw new IllegalStateException("Logically removed segment is reachable.\nChannel state: " + this.toString());
                    }
                }

                v0_2 = ((ChannelSegment)v1_1).getNext();
                Intrinsics.checkNotNull(v0_2);
                ConcurrentLinkedListNode v1_2 = v0_2;
            }

            return;
        }

        throw new IllegalStateException("All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: " + this.toString());
    label_181:
        throw new IllegalStateException("bufferEndSegment should not have lower id than receiveSegment.\nChannel state: " + this.toString());
    }

    public boolean close(Throwable arg2) {
        return this.closeOrCancelImpl(arg2, false);
    }

    private final ChannelSegment closeLinkedList() {
        Object v0 = BufferedChannel.getBufferEndSegment$volatile$FU().get(this);
        Object v1 = BufferedChannel.getSendSegment$volatile$FU().get(this);
        if(((ChannelSegment)v1).id > v0.id) {
            v0 = v1;
        }

        Object v6 = BufferedChannel.getReceiveSegment$volatile$FU().get(this);
        if(((ChannelSegment)v6).id > v0.id) {
            v0 = v6;
        }

        return ConcurrentLinkedListKt.close(((ConcurrentLinkedListNode)v0));
    }

    protected boolean closeOrCancelImpl(Throwable arg3, boolean arg4) {
        if(arg4) {
            this.markCancellationStarted();
        }

        boolean v3 = AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(BufferedChannel.get_closeCause$volatile$FU(), this, BufferedChannelKt.access$getNO_CLOSE_CAUSE$p(), arg3);
        if(arg4) {
            this.markCancelled();
        }
        else {
            this.markClosed();
        }

        this.completeCloseOrCancel();
        this.onClosedIdempotent();
        if(v3) {
            this.invokeCloseHandler();
        }

        return v3;
    }

    private final void completeCancel(long arg1) {
        this.removeUnprocessedElements(this.completeClose(arg1));
    }

    private final ChannelSegment completeClose(long arg6) {
        ChannelSegment v0 = this.closeLinkedList();
        if(this.isConflatedDropOldest()) {
            long v1 = this.markAllEmptyCellsAsClosed(v0);
            if(v1 != -1) {
                this.dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(v1);
            }
        }

        this.cancelSuspendedReceiveRequests(v0, arg6);
        return v0;
    }

    private final void completeCloseOrCancel() {
        this.isClosedForSend();
    }

    protected final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long arg11) {
        ChannelSegment v3;
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(this.isConflatedDropOldest()) {
            }
            else {
                throw new AssertionError();
            }
        }

        Object v0 = BufferedChannel.getReceiveSegment$volatile$FU().get(this);
        while(true) {
            long v4 = BufferedChannel.getReceivers$volatile$FU().get(this);
            if(arg11 < Math.max((((long)this.capacity)) + v4, this.getBufferEndCounter())) {
                return;
            }

            BufferedChannel v2 = this;
            if(BufferedChannel.getReceivers$volatile$FU().compareAndSet(this, v4, 1 + v4)) {
                long v6 = v4 / (((long)BufferedChannelKt.SEGMENT_SIZE));
                int v10 = ((int)(v4 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
                if(((ChannelSegment)v0).id != v6) {
                    ChannelSegment v1 = v2.findSegmentReceive(v6, ((ChannelSegment)v0));
                    if(v1 == null) {
                        goto label_64;
                    }
                    else {
                        v3 = v1;
                    }
                }
                else {
                    Object v3_1 = v0;
                }

                Object v10_1 = v2.updateCellReceive(v3, v10, v4, null);
                v4 = v4;
                if(v10_1 != BufferedChannelKt.access$getFAILED$p()) {
                    v3.cleanPrev();
                    Function1 v0_1 = v2.onUndeliveredElement;
                    if(v0_1 != null) {
                        UndeliveredElementException v10_2 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(v0_1, v10_1, null, 2, null);
                        if(v10_2 == null) {
                        }
                        else {
                            throw v10_2;
                        }
                    }
                }
                else if(v4 < v2.getSendersCounter$kotlinx_coroutines_core()) {
                    v3.cleanPrev();
                }

                this = v2;
                ChannelSegment v0_2 = v3;
                continue;
            }

        label_64:
            this = v2;
        }
    }

    private final void expandBuffer() {
        ChannelSegment v4_1;
        long v9;
        Object v7;
        long v2;
        if(this.isRendezvousOrUnlimited()) {
            return;
        }

        Object v4 = BufferedChannel.getBufferEndSegment$volatile$FU().get(this);
        while(true) {
            long v5 = BufferedChannel.getBufferEnd$volatile$FU().getAndIncrement(this);
            v2 = v5 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            v7 = null;
            v9 = 0;
            if(Long.compare(this.getSendersCounter$kotlinx_coroutines_core(), v5) <= 0) {
                break;
            }

            BufferedChannel v1 = this;
            if(Long.compare(((ChannelSegment)v4).id, v2) != 0) {
                ChannelSegment v11 = v1.findSegmentBufferEnd(v2, ((ChannelSegment)v4), v5);
                if(v11 == null) {
                }
                else {
                    v4_1 = v11;
                    goto label_32;
                }
            }
            else {
            label_32:
                if(v1.updateCellExpandBuffer(v4_1, ((int)(v5 % (((long)BufferedChannelKt.SEGMENT_SIZE)))), v5)) {
                    BufferedChannel.incCompletedExpandBufferAttempts$default(v1, v9, 1, v7);
                    return;
                }
                else {
                    BufferedChannel.incCompletedExpandBufferAttempts$default(v1, v9, 1, v7);
                }
            }

            this = v1;
        }

        if(v4_1.id < v2 && v4_1.getNext() != null) {
            this.moveSegmentBufferEndToSpecifiedOrLast(v2, v4_1);
        }

        BufferedChannel.incCompletedExpandBufferAttempts$default(this, v9, 1, v7);
    }

    private final ChannelSegment findSegmentBufferEnd(long arg13, ChannelSegment arg15, long arg16) {
        Object v4;
        Segment v3;
        Object v2;
        AtomicReferenceFieldUpdater v0 = BufferedChannel.getBufferEndSegment$volatile$FU();
        KFunction v1 = BufferedChannelKt.createSegmentFunction();
        while(true) {
        label_2:
            v2 = ConcurrentLinkedListKt.findSegmentInternal(arg15, arg13, ((Function2)v1));
            if(!SegmentOrClosed.isClosed-impl(v2)) {
                v3 = SegmentOrClosed.getSegment-impl(v2);
                while(true) {
                label_7:
                    v4 = v0.get(this);
                    if(((Segment)v4).id >= v3.id) {
                        goto label_11;
                    }
                    else if(!v3.tryIncPointers$kotlinx_coroutines_core()) {
                        goto label_2;
                    }
                    else {
                        goto label_15;
                    }
                }
            }

            goto label_25;
        }

    label_15:
        if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(v0, this, v4, v3)) {
            if(!v3.decPointers$kotlinx_coroutines_core()) {
                goto label_7;
            }

            v3.remove();
            goto label_7;
        label_11:
        }
        else if(((Segment)v4).decPointers$kotlinx_coroutines_core()) {
            ((Segment)v4).remove();
        }

    label_25:
        long v3_1 = 0;
        Object v5 = null;
        if(SegmentOrClosed.isClosed-impl(v2)) {
            this.completeCloseOrCancel();
            this.moveSegmentBufferEndToSpecifiedOrLast(arg13, arg15);
            BufferedChannel.incCompletedExpandBufferAttempts$default(this, v3_1, 1, v5);
            return ((ChannelSegment)v5);
        }

        Segment v0_1 = SegmentOrClosed.getSegment-impl(v2);
        if(((ChannelSegment)v0_1).id > arg13) {
            if(BufferedChannel.getBufferEnd$volatile$FU().compareAndSet(this, arg16 + 1, (((long)BufferedChannelKt.SEGMENT_SIZE)) * ((ChannelSegment)v0_1).id)) {
                this.incCompletedExpandBufferAttempts(((ChannelSegment)v0_1).id * (((long)BufferedChannelKt.SEGMENT_SIZE)) - arg16);
            }
            else {
                BufferedChannel.incCompletedExpandBufferAttempts$default(this, v3_1, 1, v5);
            }

            return ((ChannelSegment)v5);
        }

        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(((ChannelSegment)v0_1).id == arg13) {
                return ((ChannelSegment)v0_1);
            }

            throw new AssertionError();
        }

        return ((ChannelSegment)v0_1);
    }

    private final ChannelSegment findSegmentReceive(long arg10, ChannelSegment arg12) {
        Object v4;
        Segment v3;
        Object v2;
        AtomicReferenceFieldUpdater v0 = BufferedChannel.getReceiveSegment$volatile$FU();
        KFunction v1 = BufferedChannelKt.createSegmentFunction();
        while(true) {
        label_2:
            v2 = ConcurrentLinkedListKt.findSegmentInternal(arg12, arg10, ((Function2)v1));
            if(!SegmentOrClosed.isClosed-impl(v2)) {
                v3 = SegmentOrClosed.getSegment-impl(v2);
                while(true) {
                label_7:
                    v4 = v0.get(this);
                    if(((Segment)v4).id >= v3.id) {
                        goto label_11;
                    }
                    else if(!v3.tryIncPointers$kotlinx_coroutines_core()) {
                        goto label_2;
                    }
                    else {
                        goto label_15;
                    }
                }
            }

            goto label_25;
        }

    label_15:
        if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(v0, this, v4, v3)) {
            if(!v3.decPointers$kotlinx_coroutines_core()) {
                goto label_7;
            }

            v3.remove();
            goto label_7;
        label_11:
        }
        else if(((Segment)v4).decPointers$kotlinx_coroutines_core()) {
            ((Segment)v4).remove();
        }

    label_25:
        ChannelSegment v1_1 = null;
        if(SegmentOrClosed.isClosed-impl(v2)) {
            this.completeCloseOrCancel();
            if(arg12.id * (((long)BufferedChannelKt.SEGMENT_SIZE)) < this.getSendersCounter$kotlinx_coroutines_core()) {
                arg12.cleanPrev();
            }

            return v1_1;
        }

        Segment v12 = SegmentOrClosed.getSegment-impl(v2);
        if(!this.isRendezvousOrUnlimited() && arg10 <= this.getBufferEndCounter() / (((long)BufferedChannelKt.SEGMENT_SIZE))) {
            v0 = BufferedChannel.getBufferEndSegment$volatile$FU();
            while(true) {
                v2 = v0.get(this);
                Segment v5 = v12;
                if(((Segment)v2).id < v5.id && (v5.tryIncPointers$kotlinx_coroutines_core())) {
                    if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(v0, this, v2, v5)) {
                        if(!v5.decPointers$kotlinx_coroutines_core()) {
                            continue;
                        }

                        v5.remove();
                        continue;
                    }
                    else if(((Segment)v2).decPointers$kotlinx_coroutines_core()) {
                        ((Segment)v2).remove();
                    }
                }

                break;
            }
        }

        if(((ChannelSegment)v12).id > arg10) {
            this.updateReceiversCounterIfLower(((ChannelSegment)v12).id * (((long)BufferedChannelKt.SEGMENT_SIZE)));
            if(((ChannelSegment)v12).id * (((long)BufferedChannelKt.SEGMENT_SIZE)) < this.getSendersCounter$kotlinx_coroutines_core()) {
                ((ChannelSegment)v12).cleanPrev();
            }

            return v1_1;
        }

        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(((ChannelSegment)v12).id == arg10) {
                return ((ChannelSegment)v12);
            }

            throw new AssertionError();
        }

        return ((ChannelSegment)v12);
    }

    private final ChannelSegment findSegmentSend(long arg10, ChannelSegment arg12) {
        Object v4;
        Segment v3;
        Object v2;
        AtomicReferenceFieldUpdater v0 = BufferedChannel.getSendSegment$volatile$FU();
        KFunction v1 = BufferedChannelKt.createSegmentFunction();
        while(true) {
        label_2:
            v2 = ConcurrentLinkedListKt.findSegmentInternal(arg12, arg10, ((Function2)v1));
            if(!SegmentOrClosed.isClosed-impl(v2)) {
                v3 = SegmentOrClosed.getSegment-impl(v2);
                while(true) {
                label_7:
                    v4 = v0.get(this);
                    if(((Segment)v4).id >= v3.id) {
                        goto label_11;
                    }
                    else if(!v3.tryIncPointers$kotlinx_coroutines_core()) {
                        goto label_2;
                    }
                    else {
                        goto label_15;
                    }
                }
            }

            goto label_25;
        }

    label_15:
        if(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(v0, this, v4, v3)) {
            if(!v3.decPointers$kotlinx_coroutines_core()) {
                goto label_7;
            }

            v3.remove();
            goto label_7;
        label_11:
        }
        else if(((Segment)v4).decPointers$kotlinx_coroutines_core()) {
            ((Segment)v4).remove();
        }

    label_25:
        ChannelSegment v1_1 = null;
        if(SegmentOrClosed.isClosed-impl(v2)) {
            this.completeCloseOrCancel();
            if(arg12.id * (((long)BufferedChannelKt.SEGMENT_SIZE)) < this.getReceiversCounter$kotlinx_coroutines_core()) {
                arg12.cleanPrev();
            }

            return v1_1;
        }

        Segment v12 = SegmentOrClosed.getSegment-impl(v2);
        if(((ChannelSegment)v12).id > arg10) {
            this.updateSendersCounterIfLower(((ChannelSegment)v12).id * (((long)BufferedChannelKt.SEGMENT_SIZE)));
            if(((ChannelSegment)v12).id * (((long)BufferedChannelKt.SEGMENT_SIZE)) < this.getReceiversCounter$kotlinx_coroutines_core()) {
                ((ChannelSegment)v12).cleanPrev();
            }

            return v1_1;
        }

        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(((ChannelSegment)v12).id == arg10) {
                return ((ChannelSegment)v12);
            }

            throw new AssertionError();
        }

        return ((ChannelSegment)v12);
    }

    private final Object getAndUpdate$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg2, Object arg3, Function1 arg4) {
        Object v1;
        do {
            v1 = arg2.get(arg3);
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(arg2, arg3, v1, arg4.invoke(v1)));

        return v1;
    }

    private final long getBufferEnd$volatile() {
        return this.bufferEnd$volatile;
    }

    private static final AtomicLongFieldUpdater getBufferEnd$volatile$FU() {
        return BufferedChannel.bufferEnd$volatile$FU;
    }

    private final long getBufferEndCounter() {
        return BufferedChannel.getBufferEnd$volatile$FU().get(this);
    }

    private final Object getBufferEndSegment$volatile() {
        return this.bufferEndSegment$volatile;
    }

    private static final AtomicReferenceFieldUpdater getBufferEndSegment$volatile$FU() {
        return BufferedChannel.bufferEndSegment$volatile$FU;
    }

    protected final Throwable getCloseCause() {
        return BufferedChannel.get_closeCause$volatile$FU().get(this);
    }

    private final Object getCloseHandler$volatile() {
        return this.closeHandler$volatile;
    }

    private static final AtomicReferenceFieldUpdater getCloseHandler$volatile$FU() {
        return BufferedChannel.closeHandler$volatile$FU;
    }

    private final long getCompletedExpandBuffersAndPauseFlag$volatile() {
        return this.completedExpandBuffersAndPauseFlag$volatile;
    }

    private static final AtomicLongFieldUpdater getCompletedExpandBuffersAndPauseFlag$volatile$FU() {
        return BufferedChannel.completedExpandBuffersAndPauseFlag$volatile$FU;
    }

    public SelectClause1 getOnReceive() {
        BufferedChannel$onReceive$1 v1 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Object v1_1 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1, 3);
        BufferedChannel$onReceive$2 v3 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, ((Function3)v1_1), TypeIntrinsics.beforeCheckcastToFunctionOfArity(v3, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public static void getOnReceive$annotations() {
    }

    public SelectClause1 getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 v1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Object v1_1 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1, 3);
        BufferedChannel$onReceiveCatching$2 v3 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, ((Function3)v1_1), TypeIntrinsics.beforeCheckcastToFunctionOfArity(v3, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public static void getOnReceiveCatching$annotations() {
    }

    public SelectClause1 getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 v1 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Object v1_1 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1, 3);
        BufferedChannel$onReceiveOrNull$2 v3 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, ((Function3)v1_1), TypeIntrinsics.beforeCheckcastToFunctionOfArity(v3, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public static void getOnReceiveOrNull$annotations() {
    }

    public SelectClause2 getOnSend() {
        BufferedChannel$onSend$1 v1 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Object v1_1 = TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1, 3);
        BufferedChannel$onSend$2 v3 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause2Impl(this, v1_1, TypeIntrinsics.beforeCheckcastToFunctionOfArity(v3, 3), null, 8, null);
    }

    public static void getOnSend$annotations() {
    }

    private static void getOnUndeliveredElementReceiveCancellationConstructor$annotations() {
    }

    private final Throwable getReceiveException() {
        Throwable v1 = this.getCloseCause();
        if(v1 == null) {
            ClosedReceiveChannelException v1_1 = new ClosedReceiveChannelException("Channel was closed");
        }

        return v1;
    }

    private final Object getReceiveSegment$volatile() {
        return this.receiveSegment$volatile;
    }

    private static final AtomicReferenceFieldUpdater getReceiveSegment$volatile$FU() {
        return BufferedChannel.receiveSegment$volatile$FU;
    }

    private final long getReceivers$volatile() {
        return this.receivers$volatile;
    }

    private static final AtomicLongFieldUpdater getReceivers$volatile$FU() {
        return BufferedChannel.receivers$volatile$FU;
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return BufferedChannel.getReceivers$volatile$FU().get(this);
    }

    protected final Throwable getSendException() {
        ClosedSendChannelException v1_1;
        Throwable v1 = this.getCloseCause();
        if(v1 == null) {
            v1_1 = new ClosedSendChannelException("Channel was closed");
        }

        return ((Throwable)v1_1);
    }

    private final Object getSendSegment$volatile() {
        return this.sendSegment$volatile;
    }

    private static final AtomicReferenceFieldUpdater getSendSegment$volatile$FU() {
        return BufferedChannel.sendSegment$volatile$FU;
    }

    private final long getSendersAndCloseStatus$volatile() {
        return this.sendersAndCloseStatus$volatile;
    }

    private static final AtomicLongFieldUpdater getSendersAndCloseStatus$volatile$FU() {
        return BufferedChannel.sendersAndCloseStatus$volatile$FU;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return BufferedChannel.getSendersAndCloseStatus$volatile$FU().get(this) & 0xFFFFFFFFFFFFFFFL;
    }

    private final Object get_closeCause$volatile() {
        return this._closeCause$volatile;
    }

    private static final AtomicReferenceFieldUpdater get_closeCause$volatile$FU() {
        return BufferedChannel._closeCause$volatile$FU;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        ChannelSegment v0_1;
        while(true) {
            Object v0 = BufferedChannel.getReceiveSegment$volatile$FU().get(this);
            long v3 = this.getReceiversCounter$kotlinx_coroutines_core();
            if(Long.compare(this.getSendersCounter$kotlinx_coroutines_core(), v3) <= 0) {
                return 0;
            }

            long v5 = v3 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            if(((ChannelSegment)v0).id != v5) {
                v0_1 = this.findSegmentReceive(v5, ((ChannelSegment)v0));
                if(v0_1 == null) {
                    if(BufferedChannel.getReceiveSegment$volatile$FU().get(this).id >= v5) {
                        continue;
                    }

                    return 0;
                }
            }

            v0_1.cleanPrev();
            if(this.isCellNonEmpty(v0_1, ((int)(v3 % (((long)BufferedChannelKt.SEGMENT_SIZE)))), v3)) {
                return 1;
            }

            BufferedChannel.getReceivers$volatile$FU().compareAndSet(this, v3, 1 + v3);
        }

        return 0;
    }

    private final void incCompletedExpandBufferAttempts(long arg5) {
        long v0 = 0x4000000000000000L;
        long v2 = 0;
        if((BufferedChannel.getCompletedExpandBuffersAndPauseFlag$volatile$FU().addAndGet(this, arg5) & v0) != v2) {
            while((BufferedChannel.getCompletedExpandBuffersAndPauseFlag$volatile$FU().get(this) & v0) != v2) {
            }
        }
    }

    static void incCompletedExpandBufferAttempts$default(BufferedChannel arg0, long arg1, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg1 = 1;
            }

            arg0.incCompletedExpandBufferAttempts(arg1);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final void invokeCloseHandler() {
        Object v1;
        AtomicReferenceFieldUpdater v0 = BufferedChannel.getCloseHandler$volatile$FU();
        do {
            v1 = v0.get(this);
            Symbol v2 = v1 == null ? BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p() : BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p();
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(v0, this, v1, v2));

        if(v1 == null) {
            return;
        }

        TypeIntrinsics.beforeCheckcastToFunctionOfArity(v1, 1);
        ((Function1)v1).invoke(this.getCloseCause());
    }

    public void invokeOnClose(Function1 arg5) {
        Object v1;
        if(AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(BufferedChannel.getCloseHandler$volatile$FU(), this, null, arg5)) {
            return;
        }

        AtomicReferenceFieldUpdater v0 = BufferedChannel.getCloseHandler$volatile$FU();
        do {
            v1 = v0.get(this);
            if(v1 != BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p()) {
                goto label_17;
            }
        }
        while(!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(BufferedChannel.getCloseHandler$volatile$FU(), this, BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p(), BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p()));

        arg5.invoke(this.getCloseCause());
        return;
    label_17:
        if(v1 == BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p()) {
            throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
        }

        throw new IllegalStateException("Another handler is already registered: " + v1.toString());
    }

    private final boolean isCellNonEmpty(ChannelSegment arg4, int arg5, long arg6) {
        do {
            Object v0 = arg4.getState$kotlinx_coroutines_core(arg5);
            if(v0 != null) {
                if(v0 == BufferedChannelKt.access$getIN_BUFFER$p()) {
                }
                else if(v0 == BufferedChannelKt.BUFFERED) {
                    return 1;
                }
                else if(v0 == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) {
                    return 0;
                }
                else if(v0 == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return 0;
                }
                else if(v0 == BufferedChannelKt.access$getDONE_RCV$p()) {
                    return 0;
                }
                else if(v0 == BufferedChannelKt.access$getPOISONED$p()) {
                    return 0;
                }
                else if(v0 == BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
                    return 1;
                }
                else if(v0 == BufferedChannelKt.access$getRESUMING_BY_RCV$p()) {
                    return 0;
                }
                else if(arg6 == this.getReceiversCounter$kotlinx_coroutines_core()) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        }
        while(!arg4.casState$kotlinx_coroutines_core(arg5, v0, BufferedChannelKt.access$getPOISONED$p()));

        this.expandBuffer();
        return 0;
    }

    private final boolean isClosed(long arg7, boolean arg9) {
        int v0 = ((int)(arg7 >> 60));
        if(v0 != 0 && v0 != 1) {
            long v4 = 0xFFFFFFFFFFFFFFFL;
            if(v0 == 2) {
                this.completeClose(arg7 & v4);
                if(!arg9) {
                    return 1;
                }
                else if(!this.hasElements$kotlinx_coroutines_core()) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
            else if(v0 == 3) {
                this.completeCancel(arg7 & v4);
                return 1;
            }
            else {
                throw new IllegalStateException("unexpected close status: " + v0.toString());
            }
        }

        return 0;
    }

    public boolean isClosedForReceive() {
        return this.isClosedForReceive0(BufferedChannel.getSendersAndCloseStatus$volatile$FU().get(this));
    }

    public static void isClosedForReceive$annotations() {
    }

    private final boolean isClosedForReceive0(long arg2) {
        return this.isClosed(arg2, true);
    }

    public boolean isClosedForSend() {
        return this.isClosedForSend0(BufferedChannel.getSendersAndCloseStatus$volatile$FU().get(this));
    }

    public static void isClosedForSend$annotations() {
    }

    private final boolean isClosedForSend0(long arg2) {
        return this.isClosed(arg2, false);
    }

    protected boolean isConflatedDropOldest() {
        return 0;
    }

    public boolean isEmpty() {
        if(this.isClosedForReceive()) {
            return 0;
        }

        if(this.hasElements$kotlinx_coroutines_core()) {
            return 0;
        }

        return this.isClosedForReceive() ^ 1;
    }

    public static void isEmpty$annotations() {
    }

    private final boolean isRendezvousOrUnlimited() {
        long v0 = this.getBufferEndCounter();
        if(v0 != 0) {
            if(v0 == 0x7FFFFFFFFFFFFFFFL) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public ChannelIterator iterator() {
        return new BufferedChannelIterator(this);
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater arg1, Object arg2, Function1 arg3) {
        while(true) {
            arg3.invoke(arg1.get(arg2));
        }
    }

    private final void loop$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater arg3, Object arg4, Function1 arg5) {
        while(true) {
            arg5.invoke(Long.valueOf(arg3.get(arg4)));
        }
    }

    private final long markAllEmptyCellsAsClosed(ChannelSegment arg8) {
        long v1;
        do {
            int v0;
            for(v0 = BufferedChannelKt.SEGMENT_SIZE - 1; true; --v0) {
                v1 = -1;
                if(-1 >= v0) {
                    break;
                }

                long v3 = arg8.id * (((long)BufferedChannelKt.SEGMENT_SIZE)) + (((long)v0));
                if(v3 < this.getReceiversCounter$kotlinx_coroutines_core()) {
                    return v1;
                }

                do {
                    Object v1_1 = arg8.getState$kotlinx_coroutines_core(v0);
                    if(v1_1 == null || v1_1 == BufferedChannelKt.access$getIN_BUFFER$p()) {
                        if(!arg8.casState$kotlinx_coroutines_core(v0, v1_1, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            continue;
                        }

                        break;
                    }
                    else if(v1_1 == BufferedChannelKt.BUFFERED) {
                        return v3;
                    }

                    goto label_26;
                }
                while(true);

                arg8.onSlotCleaned();
            label_26:
            }

            ConcurrentLinkedListNode v8 = ((ChannelSegment)v8).getPrev();
        }
        while(v8 != null);

        return v1;
    }

    private final void markCancellationStarted() {
        AtomicLongFieldUpdater v0 = BufferedChannel.getSendersAndCloseStatus$volatile$FU();
        while(true) {
            long v2 = v0.get(this);
            if((((int)(v2 >> 60))) == 0) {
                BufferedChannel v1 = this;
                if(v0.compareAndSet(v1, v2, BufferedChannelKt.access$constructSendersAndCloseStatus(0xFFFFFFFFFFFFFFFL & v2, 1))) {
                }
                else {
                    this = v1;
                    continue;
                }
            }

            return;
        }
    }

    private final void markCancelled() {
        AtomicLongFieldUpdater v0 = BufferedChannel.getSendersAndCloseStatus$volatile$FU();
        while(true) {
            long v2 = v0.get(this);
            BufferedChannel v1 = this;
            if(v0.compareAndSet(v1, v2, BufferedChannelKt.access$constructSendersAndCloseStatus(0xFFFFFFFFFFFFFFFL & v2, 3))) {
                return;
            }

            this = v1;
        }
    }

    private final void markClosed() {
        BufferedChannel v1_1;
        AtomicLongFieldUpdater v0 = BufferedChannel.getSendersAndCloseStatus$volatile$FU();
        while(true) {
            long v2 = v0.get(this);
            int v1 = ((int)(v2 >> 60));
            long v4 = 0xFFFFFFFFFFFFFFFL;
            if(v1 == 0) {
                v4 = BufferedChannelKt.access$constructSendersAndCloseStatus(v4 & v2, 2);
            label_17:
                v1_1 = this;
                if(v0.compareAndSet(v1_1, v2, v4)) {
                    return;
                }

                goto label_21;
            }
            else if(v1 != 1) {
            }
            else {
                v4 = BufferedChannelKt.access$constructSendersAndCloseStatus(v4 & v2, 3);
                goto label_17;
            }

            return;
        label_21:
            this = v1_1;
        }
    }

    private final void moveSegmentBufferEndToSpecifiedOrLast(long arg6, ChannelSegment arg8) {
        ConcurrentLinkedListNode v8;
        while(arg8.id < arg6) {
            ConcurrentLinkedListNode v0 = arg8.getNext();
            if(v0 == null) {
            }
            else {
                v8 = v0;
                continue;
            }

            break;
        }

    label_7:
        while(((ChannelSegment)v8).isRemoved()) {
            ConcurrentLinkedListNode v6 = ((ChannelSegment)v8).getNext();
            if(v6 == null) {
            }
            else {
                v8 = v6;
                continue;
            }

            break;
        }

        AtomicReferenceFieldUpdater v6_1 = BufferedChannel.getBufferEndSegment$volatile$FU();
        while(true) {
            Object v7 = v6_1.get(this);
            ChannelSegment v2 = ((ChannelSegment)v8);
            if(((Segment)v7).id >= ((Segment)v2).id) {
                return;
            }

            if(!((Segment)v2).tryIncPointers$kotlinx_coroutines_core()) {
                goto label_7;
            }

            if(AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(v6_1, this, v7, v2)) {
                if(((Segment)v7).decPointers$kotlinx_coroutines_core()) {
                    ((Segment)v7).remove();
                }

                return;
            }

            if(!((Segment)v2).decPointers$kotlinx_coroutines_core()) {
                continue;
            }

            ((Segment)v2).remove();
        }
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'trySend\' method", replaceWith="<_subannotation>") public boolean offer(Object arg1) {
        return kotlinx.coroutines.channels.Channel$DefaultImpls.offer(((Channel)this), arg1);
    }

    private final void onCancellationChannelResultImplDoNotCall-5_sEAP8(Throwable arg1, Object arg2, CoroutineContext arg3) {
        Function1 v0 = this.onUndeliveredElement;
        Intrinsics.checkNotNull(v0);
        Object v1 = ChannelResult.getOrNull-impl(arg2);
        Intrinsics.checkNotNull(v1);
        OnUndeliveredElementKt.callUndeliveredElement(v0, v1, arg3);
    }

    private final void onCancellationImplDoNotCall(Throwable arg1, Object arg2, CoroutineContext arg3) {
        Function1 v0 = this.onUndeliveredElement;
        Intrinsics.checkNotNull(v0);
        OnUndeliveredElementKt.callUndeliveredElement(v0, arg2, arg3);
    }

    protected void onClosedIdempotent() {
    }

    private final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation arg2) {
        ((Continuation)arg2).resumeWith(Result.constructor-impl(ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause()))));
    }

    private final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation arg2) {
        ((Continuation)arg2).resumeWith(Result.constructor-impl(ResultKt.createFailure(this.getReceiveException())));
    }

    private final void onClosedSelectOnReceive(SelectInstance arg1) {
        arg1.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final void onClosedSelectOnSend(Object arg2, SelectInstance arg3) {
        Function1 v1 = this.onUndeliveredElement;
        if(v1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(v1, arg2, arg3.getContext());
        }

        arg3.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final Object onClosedSend(Object arg6, Continuation arg7) {
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg7), 1);
        v0.initCancellability();
        CancellableContinuationImpl v1 = v0;
        Function1 v2 = this.onUndeliveredElement;
        if(v2 != null) {
            UndeliveredElementException v6 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(v2, arg6, null, 2, null);
            if(v6 != null) {
                ExceptionsKt.addSuppressed(((Throwable)v6), this.getSendException());
                if(DebugKt.getRECOVER_STACK_TRACES()) {
                    if(!(v1 instanceof CoroutineStackFrame)) {
                    }
                    else {
                        Throwable v6_1 = StackTraceRecoveryKt.access$recoverFromStackFrame(((Throwable)v6), v1);
                    }
                }

                ((Continuation)v1).resumeWith(Result.constructor-impl(ResultKt.createFailure(((Throwable)v6))));
            }
            else {
                goto label_26;
            }
        }
        else {
        label_26:
            Throwable v5 = this.getSendException();
            if(DebugKt.getRECOVER_STACK_TRACES()) {
                if(!(v1 instanceof CoroutineStackFrame)) {
                }
                else {
                    v5 = StackTraceRecoveryKt.access$recoverFromStackFrame(v5, v1);
                }
            }

            ((Continuation)v1).resumeWith(Result.constructor-impl(ResultKt.createFailure(v5)));
        }

        Object v5_1 = v0.getResult();
        if(v5_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg7);
        }

        if(v5_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v5_1;
        }

        return Unit.INSTANCE;
    }

    private final void onClosedSendOnNoWaiterSuspend(Object arg3, CancellableContinuation arg4) {
        Function1 v0 = this.onUndeliveredElement;
        if(v0 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(v0, arg3, arg4.getContext());
        }

        Throwable v2 = this.getSendException();
        if(DebugKt.getRECOVER_STACK_TRACES()) {
            if(!(arg4 instanceof CoroutineStackFrame)) {
            }
            else {
                v2 = StackTraceRecoveryKt.access$recoverFromStackFrame(v2, arg4);
            }
        }

        ((Continuation)arg4).resumeWith(Result.constructor-impl(ResultKt.createFailure(v2)));
    }

    protected void onReceiveDequeued() {
    }

    protected void onReceiveEnqueued() {
    }

    static final Function3 onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56(BufferedChannel arg0, SelectInstance arg1, Object arg2, Object arg3) {
        return new BufferedChannel$$ExternalSyntheticLambda0(arg3, arg0, arg1);
    }

    static final Unit onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56$lambda$55(Object arg0, BufferedChannel arg1, SelectInstance arg2, Throwable arg3, Object arg4, CoroutineContext arg5) {
        if(arg0 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            OnUndeliveredElementKt.callUndeliveredElement(arg1.onUndeliveredElement, arg0, arg2.getContext());
        }

        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in the favour of \'tryReceive\'. Please note that the provided replacement does not rethrow channel\'s close cause as \'poll\' did, for the precise replacement please refer to the \'poll\' documentation", replaceWith="<_subannotation>") public Object poll() {
        return kotlinx.coroutines.channels.Channel$DefaultImpls.poll(((Channel)this));
    }

    private final void prepareReceiverForSuspension(Waiter arg1, ChannelSegment arg2, int arg3) {
        this.onReceiveEnqueued();
        arg1.invokeOnCancellation(((Segment)arg2), arg3);
    }

    private final void prepareSenderForSuspension(Waiter arg1, ChannelSegment arg2, int arg3) {
        arg1.invokeOnCancellation(((Segment)arg2), arg3 + BufferedChannelKt.SEGMENT_SIZE);
    }

    private final Object processResultSelectReceive(Object arg1, Object arg2) {
        if(arg2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return arg2;
        }

        throw this.getReceiveException();
    }

    private final Object processResultSelectReceiveCatching(Object arg1, Object arg2) {
        Object v0 = arg2 == BufferedChannelKt.getCHANNEL_CLOSED() ? ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause()) : ChannelResult.Companion.success-JP2dKIU(arg2);
        return ChannelResult.box-impl(v0);
    }

    private final Object processResultSelectReceiveOrNull(Object arg1, Object arg2) {
        if(arg2 == BufferedChannelKt.getCHANNEL_CLOSED()) {
            if(this.getCloseCause() == null) {
                return null;
            }

            throw this.getReceiveException();
        }

        return arg2;
    }

    private final Object processResultSelectSend(Object arg1, Object arg2) {
        if(arg2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return this;
        }

        throw this.getSendException();
    }

    public Object receive(Continuation arg1) {
        return BufferedChannel.receive$suspendImpl(this, arg1);
    }

    static Object receive$suspendImpl(BufferedChannel arg9, Continuation arg10) {
        Object v9;
        BufferedChannel v2;
        ChannelSegment v3;
        int v4;
        long v5;
        Object v0 = BufferedChannel.getReceiveSegment$volatile$FU().get(arg9);
        while(true) {
            if(arg9.isClosedForReceive()) {
                goto label_46;
            }

            v5 = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(arg9);
            long v1 = v5 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            v4 = ((int)(v5 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)v0).id != v1) {
                ChannelSegment v1_1 = arg9.findSegmentReceive(v1, ((ChannelSegment)v0));
                if(v1_1 == null) {
                    continue;
                }
                else {
                    v3 = v1_1;
                }
            }
            else {
                Object v3_1 = v0;
            }

            v2 = arg9;
            v9 = v2.updateCellReceive(v3, v4, v5, null);
            if(v9 == BufferedChannelKt.access$getSUSPEND$p()) {
                goto label_41;
            }

            if(v9 != BufferedChannelKt.access$getFAILED$p()) {
                break;
            }

            if(v5 < v2.getSendersCounter$kotlinx_coroutines_core()) {
                v3.cleanPrev();
            }

            arg9 = v2;
            ChannelSegment v0_1 = v3;
        }

        if(v9 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
            return v2.receiveOnNoWaiterSuspend(v3, v4, v5, arg10);
        }

        v3.cleanPrev();
        return v9;
    label_41:
        throw new IllegalStateException("unexpected".toString());
    label_46:
        throw StackTraceRecoveryKt.recoverStackTrace(arg9.getReceiveException());
    }

    public Object receiveCatching-JP2dKIU(Continuation arg1) {
        return BufferedChannel.receiveCatching-JP2dKIU$suspendImpl(this, arg1);
    }

    static Object receiveCatching-JP2dKIU$suspendImpl(BufferedChannel arg13, Continuation arg14) {
        BufferedChannel v1_2;
        Object v13;
        Object v8_1;
        int v3;
        long v4;
        Continuation v0;
        if((arg14 instanceof BufferedChannel$receiveCatching$1)) {
            v0 = arg14;
            int v2 = 0x80000000;
            if((((BufferedChannel$receiveCatching$1)v0).label & v2) != 0) {
                ((BufferedChannel$receiveCatching$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            BufferedChannel$receiveCatching$1 v0_1 = new BufferedChannel$receiveCatching$1(arg13, arg14);
        }

        Continuation v6 = v0;
        Object v14 = ((BufferedChannel$receiveCatching$1)v6).result;
        Object v0_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = ((BufferedChannel$receiveCatching$1)v6).label;
        if(v1 != 0) {
            if(v1 == 1) {
                ResultKt.throwOnFailure(v14);
                return ((ChannelResult)v14).unbox-impl();
            }

            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        ResultKt.throwOnFailure(v14);
        v14 = BufferedChannel.getReceiveSegment$volatile$FU().get(arg13);
        while(true) {
            if(arg13.isClosedForReceive()) {
                goto label_32;
            }

            v4 = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(arg13);
            long v7 = v4 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            v3 = ((int)(v4 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)v14).id != v7) {
                ChannelSegment v1_1 = arg13.findSegmentReceive(v7, ((ChannelSegment)v14));
                if(v1_1 == null) {
                    continue;
                }
                else {
                    ChannelSegment v8 = v1_1;
                }
            }
            else {
                v8_1 = v14;
            }

            BufferedChannel v7_1 = arg13;
            v13 = v7_1.updateCellReceive(((ChannelSegment)v8_1), v3, v4, null);
            v1_2 = v7_1;
            if(v13 == BufferedChannelKt.access$getSUSPEND$p()) {
                goto label_81;
            }

            if(v13 != BufferedChannelKt.access$getFAILED$p()) {
                break;
            }

            if(v4 < v1_2.getSendersCounter$kotlinx_coroutines_core()) {
                ((ChannelSegment)v8_1).cleanPrev();
            }

            arg13 = v1_2;
            ChannelSegment v14_1 = ((ChannelSegment)v8_1);
        }

        if(v13 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
            ((BufferedChannel$receiveCatching$1)v6).label = 1;
            v13 = v1_2.receiveCatchingOnNoWaiterSuspend-GKJJFZk(((ChannelSegment)v8_1), v3, v4, v6);
            if(v13 == v0_2) {
                return v0_2;
            }

            return v13;
        }

        ((ChannelSegment)v8_1).cleanPrev();
        return ChannelResult.Companion.success-JP2dKIU(v13);
    label_81:
        throw new IllegalStateException("unexpected".toString());
    label_32:
        return ChannelResult.Companion.closed-JP2dKIU(arg13.getCloseCause());
    }

    private final Object receiveCatchingOnNoWaiterSuspend-GKJJFZk(ChannelSegment arg11, int arg12, long arg13, Continuation arg15) {
        KFunction v12_1;
        Function1 v11_1;
        ChannelResult v10_2;
        Object v4_2;
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 v0_1;
        int v2;
        if((arg15 instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1)) {
            Continuation v0 = arg15;
            v2 = 0x80000000;
            if((((BufferedChannel$receiveCatchingOnNoWaiterSuspend$1)v0).label & v2) != 0) {
                ((BufferedChannel$receiveCatchingOnNoWaiterSuspend$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, arg15);
        }

        Object v15 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v15);
            v0_1.L$0 = this;
            v0_1.L$1 = arg11;
            v0_1.I$0 = arg12;
            v0_1.J$0 = arg13;
            v0_1.label = 1;
            CancellableContinuationImpl v15_1 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(((Continuation)v0_1)));
            try {
                Intrinsics.checkNotNull(v15_1, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel>>");
                ReceiveCatching v2_1 = new ReceiveCatching(v15_1);
                BufferedChannel v4 = this;
                ChannelSegment v5 = arg11;
                int v6 = arg12;
                long v7 = arg13;
                Object v10 = v4.updateCellReceive(v5, v6, v7, v2_1);
                BufferedChannel v3 = v4;
                if(v10 == BufferedChannelKt.access$getSUSPEND$p()) {
                    v3.prepareReceiverForSuspension(((Waiter)v2_1), v5, v6);
                }
                else {
                    ReceiveCatching v12 = null;
                    if(v10 == BufferedChannelKt.access$getFAILED$p()) {
                        if(v7 < v3.getSendersCounter$kotlinx_coroutines_core()) {
                            v5.cleanPrev();
                        }

                        v10 = BufferedChannel.getReceiveSegment$volatile$FU().get(v3);
                        while(true) {
                            boolean v11 = v3.isClosedForReceive();
                            if(v11) {
                                v3.onClosedReceiveCatchingOnNoWaiterSuspend(v15_1);
                                goto label_124;
                            }

                            long v6_1 = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(v3);
                            arg13 = v6_1 / (((long)BufferedChannelKt.SEGMENT_SIZE));
                            int v5_1 = ((int)(v6_1 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
                            if(((ChannelSegment)v10).id != arg13) {
                                arg11 = v3.findSegmentReceive(arg13, ((ChannelSegment)v10));
                                if(arg11 == null) {
                                    continue;
                                }
                                else {
                                    ChannelSegment v4_1 = arg11;
                                }
                            }
                            else {
                                v4_2 = v10;
                            }

                            v10 = v3.updateCellReceive(((ChannelSegment)v4_2), v5_1, v6_1, v2_1);
                            if(v10 == BufferedChannelKt.access$getSUSPEND$p()) {
                                if((v2_1 instanceof Waiter)) {
                                    v12 = v2_1;
                                }

                                if(v12 == null) {
                                    goto label_124;
                                }

                                v3.prepareReceiverForSuspension(((Waiter)v12), ((ChannelSegment)v4_2), v5_1);
                                goto label_124;
                            }

                            if(v10 != BufferedChannelKt.access$getFAILED$p()) {
                                break;
                            }

                            if(v6_1 < v3.getSendersCounter$kotlinx_coroutines_core()) {
                                ((ChannelSegment)v4_2).cleanPrev();
                            }

                            ChannelSegment v10_1 = ((ChannelSegment)v4_2);
                        }

                        if(v10 != BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                            ((ChannelSegment)v4_2).cleanPrev();
                            v10_2 = ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(v10));
                            v11_1 = v3.onUndeliveredElement;
                            if(v11_1 == null) {
                                goto label_109;
                            }

                            v12_1 = v3.bindCancellationFunResult(v11_1);
                            goto label_109;
                        }

                        throw new IllegalStateException("unexpected".toString());
                    }
                    else {
                        v5.cleanPrev();
                        v10_2 = ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(v10));
                        v11_1 = v3.onUndeliveredElement;
                        if(v11_1 == null) {
                            goto label_109;
                        }

                        v12_1 = v3.bindCancellationFunResult(v11_1);
                    }

                label_109:
                    v15_1.resume(v10_2, ((Function3)v12_1));
                }
            }
            catch(Throwable v0_2) {
                v15_1.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw v0_2;
            }

        label_124:
            v15 = v15_1.getResult();
            if(v15 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(((Continuation)v0_1));
            }

            if(v15 != v1) {
                goto label_130;
            }

            return v1;
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v15);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_130:
        return ((ChannelResult)v15).unbox-impl();
    }

    private final Object receiveImpl(Object arg10, Function1 arg11, Function3 arg12, Function0 arg13, Function3 arg14) {
        ChannelSegment v0_1;
        Object v9;
        ChannelSegment v3;
        int v4;
        long v5;
        Object v0 = BufferedChannel.getReceiveSegment$volatile$FU().get(this);
        while(true) {
            if(this.isClosedForReceive()) {
                goto label_4;
            }

            v5 = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(this);
            long v1 = v5 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            v4 = ((int)(v5 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)v0).id != v1) {
                ChannelSegment v1_1 = this.findSegmentReceive(v1, ((ChannelSegment)v0));
                if(v1_1 == null) {
                    continue;
                }
                else {
                    v3 = v1_1;
                }
            }
            else {
                Object v3_1 = v0;
            }

            BufferedChannel v2 = this;
            Object v7 = arg10;
            v9 = v2.updateCellReceive(v3, v4, v5, v7);
            v0_1 = v3;
            if(v9 == BufferedChannelKt.access$getSUSPEND$p()) {
                arg10 = (v7 instanceof Waiter) ? v7 : null;
                if(arg10 != null) {
                    v2.prepareReceiverForSuspension(((Waiter)arg10), v0_1, v4);
                }

                return arg12.invoke(v0_1, Integer.valueOf(v4), Long.valueOf(v5));
            }

            if(v9 != BufferedChannelKt.access$getFAILED$p()) {
                break;
            }

            if(v5 < v2.getSendersCounter$kotlinx_coroutines_core()) {
                v0_1.cleanPrev();
            }

            this = v2;
            arg10 = v7;
        }

        if(v9 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
            return arg14.invoke(v0_1, Integer.valueOf(v4), Long.valueOf(v5));
        }

        v0_1.cleanPrev();
        return arg11.invoke(v9);
    label_4:
        return arg13.invoke();
    }

    static Object receiveImpl$default(BufferedChannel arg7, Object arg8, Function1 arg9, Function3 arg10, Function0 arg11, Function3 arg12, int arg13, Object arg14) {
        ChannelSegment v13_1;
        Object v7;
        ChannelSegment v1;
        int v2;
        long v3;
        BufferedChannel$receiveImpl$1 v12;
        if(arg14 != null) {
            goto label_61;
        }

        if((arg13 & 16) != 0) {
            v12 = BufferedChannel$receiveImpl$1.INSTANCE;
        }

        Object v13 = BufferedChannel.getReceiveSegment$volatile$FU().get(arg7);
        while(true) {
            if(arg7.isClosedForReceive()) {
                goto label_8;
            }

            v3 = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(arg7);
            long v0 = v3 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            v2 = ((int)(v3 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)v13).id != v0) {
                ChannelSegment v14 = arg7.findSegmentReceive(v0, ((ChannelSegment)v13));
                if(v14 == null) {
                    continue;
                }
                else {
                    v1 = v14;
                }
            }
            else {
                Object v1_1 = v13;
            }

            BufferedChannel v0_1 = arg7;
            Object v5 = arg8;
            v7 = v0_1.updateCellReceive(v1, v2, v3, v5);
            v13_1 = v1;
            if(v7 == BufferedChannelKt.access$getSUSPEND$p()) {
                arg8 = (v5 instanceof Waiter) ? v5 : null;
                if(arg8 != null) {
                    v0_1.prepareReceiverForSuspension(((Waiter)arg8), v13_1, v2);
                }

                return arg10.invoke(v13_1, Integer.valueOf(v2), Long.valueOf(v3));
            }

            if(v7 != BufferedChannelKt.access$getFAILED$p()) {
                break;
            }

            if(v3 < v0_1.getSendersCounter$kotlinx_coroutines_core()) {
                v13_1.cleanPrev();
            }

            arg7 = v0_1;
            arg8 = v5;
        }

        if(v7 == BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
            return ((Function3)v12).invoke(v13_1, Integer.valueOf(v2), Long.valueOf(v3));
        }

        v13_1.cleanPrev();
        return arg9.invoke(v7);
    label_8:
        return arg11.invoke();
    label_61:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
    }

    private final void receiveImplOnNoWaiter(ChannelSegment arg5, int arg6, long arg7, Waiter arg9, Function1 arg10, Function0 arg11) {
        Object v0 = this.updateCellReceive(arg5, arg6, arg7, arg9);
        if(v0 == BufferedChannelKt.access$getSUSPEND$p()) {
            this.prepareReceiverForSuspension(arg9, arg5, arg6);
            return;
        }

        if(v0 != BufferedChannelKt.access$getFAILED$p()) {
            goto label_58;
        }

        if(arg7 < this.getSendersCounter$kotlinx_coroutines_core()) {
            arg5.cleanPrev();
        }

        Object v5 = BufferedChannel.getReceiveSegment$volatile$FU().get(this);
        while(true) {
            if(this.isClosedForReceive()) {
                goto label_14;
            }

            arg7 = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(this);
            long v0_1 = arg7 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            arg6 = ((int)(arg7 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)v5).id != v0_1) {
                ChannelSegment v0_2 = this.findSegmentReceive(v0_1, ((ChannelSegment)v5));
                if(v0_2 == null) {
                    continue;
                }
                else {
                    arg5 = v0_2;
                }
            }

            v0 = this.updateCellReceive(((ChannelSegment)v5), arg6, arg7, arg9);
            if(v0 == BufferedChannelKt.access$getSUSPEND$p()) {
                if((arg9 instanceof Waiter)) {
                }
                else {
                    arg9 = null;
                }

                if(0 != 0) {
                    this.prepareReceiverForSuspension(arg9, ((ChannelSegment)v5), arg6);
                }

                return;
            }

            if(v0 != BufferedChannelKt.access$getFAILED$p()) {
                break;
            }

            if(arg7 >= this.getSendersCounter$kotlinx_coroutines_core()) {
                continue;
            }

            ((ChannelSegment)v5).cleanPrev();
        }

        if(v0 != BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
            ((ChannelSegment)v5).cleanPrev();
            arg10.invoke(v0);
            return;
        }

        throw new IllegalStateException("unexpected".toString());
    label_14:
        arg11.invoke();
        return;
    label_58:
        arg5.cleanPrev();
        arg10.invoke(v0);
    }

    private final Object receiveOnNoWaiterSuspend(ChannelSegment arg10, int arg11, long arg12, Continuation arg14) {
        KFunction v11_1;
        Function1 v10_1;
        Object v3_1;
        Object v9;
        CancellableContinuationImpl v1 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(arg14));
        try {
            BufferedChannel v2 = this;
            ChannelSegment v3 = arg10;
            int v4 = arg11;
            long v5 = arg12;
            v9 = v2.updateCellReceive(v3, v4, v5, v1);
            if(v9 == BufferedChannelKt.access$getSUSPEND$p()) {
                v2.prepareReceiverForSuspension(v1, v3, v4);
            }
            else {
                CancellableContinuationImpl v11 = null;
                if(v9 == BufferedChannelKt.access$getFAILED$p()) {
                    if(v5 < v2.getSendersCounter$kotlinx_coroutines_core()) {
                        v3.cleanPrev();
                    }

                    v9 = BufferedChannel.getReceiveSegment$volatile$FU().get(v2);
                    while(true) {
                        boolean v10 = v2.isClosedForReceive();
                        if(v10) {
                            v2.onClosedReceiveOnNoWaiterSuspend(v1);
                            goto label_79;
                        }

                        v5 = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(v2);
                        arg12 = v5 / (((long)BufferedChannelKt.SEGMENT_SIZE));
                        v4 = ((int)(v5 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
                        if(((ChannelSegment)v9).id != arg12) {
                            arg10 = v2.findSegmentReceive(arg12, ((ChannelSegment)v9));
                            if(arg10 == null) {
                                continue;
                            }
                            else {
                                v3 = arg10;
                            }
                        }
                        else {
                            v3_1 = v9;
                        }

                        v9 = v2.updateCellReceive(((ChannelSegment)v3_1), v4, v5, v1);
                        if(v9 == BufferedChannelKt.access$getSUSPEND$p()) {
                            if((v1 instanceof Waiter)) {
                                v11 = v1;
                            }

                            if(v11 == null) {
                                goto label_79;
                            }

                            v2.prepareReceiverForSuspension(((Waiter)v11), ((ChannelSegment)v3_1), v4);
                            goto label_79;
                        }

                        if(v9 != BufferedChannelKt.access$getFAILED$p()) {
                            break;
                        }

                        if(v5 < v2.getSendersCounter$kotlinx_coroutines_core()) {
                            ((ChannelSegment)v3_1).cleanPrev();
                        }

                        ChannelSegment v9_1 = ((ChannelSegment)v3_1);
                    }

                    if(v9 != BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
                        ((ChannelSegment)v3_1).cleanPrev();
                        v10_1 = v2.onUndeliveredElement;
                        if(v10_1 == null) {
                            goto label_67;
                        }

                        v11_1 = v2.bindCancellationFun(v10_1);
                        goto label_67;
                    }

                    throw new IllegalStateException("unexpected".toString());
                }
                else {
                    v3.cleanPrev();
                    v10_1 = v2.onUndeliveredElement;
                    if(v10_1 == null) {
                        goto label_67;
                    }

                    v11_1 = v2.bindCancellationFun(v10_1);
                }

            label_67:
                v1.resume(v9, ((Function3)v11));
            }
        }
        catch(Throwable v0) {
            v1.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw v0;
        }

    label_79:
        v9 = v1.getResult();
        if(v9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg14);
        }

        return v9;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Deprecated in favor of \'receiveCatching\'. Please note that the provided replacement does not rethrow channel\'s close cause as \'receiveOrNull\' did, for the detailed replacement please refer to the \'receiveOrNull\' documentation", replaceWith="<_subannotation>") public Object receiveOrNull(Continuation arg1) {
        return kotlinx.coroutines.channels.Channel$DefaultImpls.receiveOrNull(((Channel)this), arg1);
    }

    private final void registerSelectForReceive(SelectInstance arg9, Object arg10) {
        ChannelSegment v10;
        Object v8;
        SelectInstance v6;
        Object v2_1;
        arg10 = BufferedChannel.getReceiveSegment$volatile$FU().get(this);
        while(true) {
            if(this.isClosedForReceive()) {
                goto label_4;
            }

            long v4 = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(this);
            long v0 = v4 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            int v3 = ((int)(v4 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)arg10).id != v0) {
                ChannelSegment v0_1 = this.findSegmentReceive(v0, ((ChannelSegment)arg10));
                if(v0_1 == null) {
                    continue;
                }
                else {
                    ChannelSegment v2 = v0_1;
                }
            }
            else {
                v2_1 = arg10;
            }

            BufferedChannel v1 = this;
            v6 = arg9;
            v8 = v1.updateCellReceive(((ChannelSegment)v2_1), v3, v4, v6);
            v10 = ((ChannelSegment)v2_1);
            if(v8 == BufferedChannelKt.access$getSUSPEND$p()) {
                arg9 = (v6 instanceof Waiter) ? v6 : null;
                if(arg9 != null) {
                    v1.prepareReceiverForSuspension(((Waiter)arg9), v10, v3);
                }

                return;
            }

            if(v8 != BufferedChannelKt.access$getFAILED$p()) {
                break;
            }

            if(v4 < v1.getSendersCounter$kotlinx_coroutines_core()) {
                v10.cleanPrev();
            }

            this = v1;
            arg9 = v6;
        }

        if(v8 != BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
            v10.cleanPrev();
            v6.selectInRegistrationPhase(v8);
            return;
        }

        throw new IllegalStateException("unexpected".toString());
    label_4:
        this.onClosedSelectOnReceive(arg9);
    }

    protected void registerSelectForSend(SelectInstance arg14, Object arg15) {
        ChannelSegment v0_1;
        Object v8;
        SelectInstance v11;
        BufferedChannel v5;
        ChannelSegment v6;
        int v7;
        Object v0 = BufferedChannel.getSendSegment$volatile$FU().get(this);
        while(true) {
            long v1 = BufferedChannel.getSendersAndCloseStatus$volatile$FU().getAndIncrement(this);
            long v9 = v1 & 0xFFFFFFFFFFFFFFFL;
            boolean v12 = this.isClosedForSend0(v1);
            v1 = v9 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            v7 = ((int)(v9 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)v0).id != v1) {
                ChannelSegment v1_1 = this.findSegmentSend(v1, ((ChannelSegment)v0));
                if(v1_1 == null) {
                    if(!v12) {
                        continue;
                    }

                    this.onClosedSelectOnSend(arg15, arg14);
                    return;
                }
                else {
                    v6 = v1_1;
                }
            }
            else {
                Object v6_1 = v0;
            }

            v5 = this;
            v11 = arg14;
            v8 = arg15;
            int v13 = v5.updateCellSend(v6, v7, v8, v9, v11, v12);
            v0_1 = v6;
            if(v13 == 0) {
                goto label_71;
            }

            if(v13 == 1) {
                goto label_68;
            }

            if(v13 == 2) {
                goto label_56;
            }

            if(v13 == 3) {
                goto label_51;
            }

            if(v13 == 4) {
                break;
            }

            if(v13 != 5) {
            }
            else {
                v0_1.cleanPrev();
            }

            this = v5;
            arg15 = v8;
            arg14 = v11;
        }

        if(v9 < v5.getReceiversCounter$kotlinx_coroutines_core()) {
            v0_1.cleanPrev();
        }

        v5.onClosedSelectOnSend(v8, v11);
        return;
    label_51:
        throw new IllegalStateException("unexpected".toString());
    label_56:
        if(v12) {
            v0_1.onSlotCleaned();
            v5.onClosedSelectOnSend(v8, v11);
            return;
        }

        arg14 = (v11 instanceof Waiter) ? v11 : null;
        if(arg14 != null) {
            v5.prepareSenderForSuspension(((Waiter)arg14), v0_1, v7);
        }

        return;
    label_68:
        v11.selectInRegistrationPhase(Unit.INSTANCE);
        return;
    label_71:
        v0_1.cleanPrev();
        v11.selectInRegistrationPhase(Unit.INSTANCE);
    }

    private final void removeUnprocessedElements(ChannelSegment arg12) {
        UndeliveredElementException v1_1;
        Object v9_1;
        Function1 v0 = this.onUndeliveredElement;
        Object v1 = null;
        Object v3 = InlineList.constructor-impl$default(v1, 1, ((DefaultConstructorMarker)v1));
        do {
            int v4;
            for(v4 = BufferedChannelKt.SEGMENT_SIZE - 1; true; --v4) {
                int v5 = -1;
                if(v5 >= v4) {
                    break;
                }

                long v6 = arg12.id * (((long)BufferedChannelKt.SEGMENT_SIZE)) + (((long)v4));
                do {
                    Object v8 = arg12.getState$kotlinx_coroutines_core(v4);
                    if(v8 != BufferedChannelKt.access$getDONE_RCV$p()) {
                        if(v8 != BufferedChannelKt.BUFFERED) {
                            if(v8 != BufferedChannelKt.access$getIN_BUFFER$p()) {
                                if(v8 == null) {
                                }
                                else {
                                    if(!(v8 instanceof Waiter)) {
                                        if((v8 instanceof WaiterEB)) {
                                        }
                                        else if(v8 == BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
                                            goto label_73;
                                        }
                                        else if(v8 == BufferedChannelKt.access$getRESUMING_BY_RCV$p()) {
                                            goto label_73;
                                        }
                                        else {
                                            if(v8 == BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
                                                continue;
                                            }

                                            goto label_69;
                                        }
                                    }

                                    if(v6 < this.getReceiversCounter$kotlinx_coroutines_core()) {
                                        goto label_73;
                                    }

                                    if((v8 instanceof WaiterEB)) {
                                        Waiter v9 = v8.waiter;
                                    }
                                    else {
                                        v9_1 = v8;
                                    }

                                    if(!arg12.casState$kotlinx_coroutines_core(v4, v8, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                        continue;
                                    }

                                    if(v0 != null) {
                                        v1_1 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(v0, arg12.getElement$kotlinx_coroutines_core(v4), v1_1);
                                    }

                                    v3 = InlineList.plus-FjFbRPM(v3, v9_1);
                                    arg12.cleanElement$kotlinx_coroutines_core(v4);
                                    arg12.onSlotCleaned();
                                    goto label_69;
                                }
                            }

                            if(!arg12.casState$kotlinx_coroutines_core(v4, v8, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                continue;
                            }

                            break;
                        }
                        else if(v6 >= this.getReceiversCounter$kotlinx_coroutines_core()) {
                            if(!arg12.casState$kotlinx_coroutines_core(v4, v8, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                continue;
                            }

                            if(v0 != null) {
                                v1_1 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(v0, arg12.getElement$kotlinx_coroutines_core(v4), v1_1);
                            }

                            arg12.cleanElement$kotlinx_coroutines_core(v4);
                            arg12.onSlotCleaned();
                        }
                        else {
                            goto label_73;
                        }

                        goto label_69;
                    }

                    goto label_73;
                }
                while(true);

                arg12.onSlotCleaned();
            label_69:
            }

            ConcurrentLinkedListNode v12 = ((ChannelSegment)v12).getPrev();
        }
        while(v12 != null);

    label_73:
        if(v3 != null) {
            if(!(v3 instanceof ArrayList)) {
                this.resumeSenderOnCancelledChannel(((Waiter)v3));
            }
            else {
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
                int v12_1;
                for(v12_1 = ((ArrayList)v3).size() - 1; v5 < v12_1; --v12_1) {
                    this.resumeSenderOnCancelledChannel(((ArrayList)v3).get(v12_1));
                }
            }
        }

        if(v1_1 == null) {
            return;
        }

        throw v1_1;
    }

    private final void resumeReceiverOnClosedChannel(Waiter arg2) {
        this.resumeWaiterOnClosedChannel(arg2, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter arg2) {
        this.resumeWaiterOnClosedChannel(arg2, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter arg2, boolean arg3) {
        if((arg2 instanceof SendBroadcast)) {
            ((SendBroadcast)arg2).getCont().resumeWith(Result.constructor-impl(Boolean.valueOf(false)));
            return;
        }

        if((arg2 instanceof CancellableContinuation)) {
            Throwable v1 = arg3 ? this.getReceiveException() : this.getSendException();
            ((Continuation)arg2).resumeWith(Result.constructor-impl(ResultKt.createFailure(v1)));
            return;
        }

        if((arg2 instanceof ReceiveCatching)) {
            ((ReceiveCatching)arg2).cont.resumeWith(Result.constructor-impl(ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause()))));
            return;
        }

        if((arg2 instanceof BufferedChannelIterator)) {
            ((BufferedChannelIterator)arg2).tryResumeHasNextOnClosedChannel();
            return;
        }

        if((arg2 instanceof SelectInstance)) {
            ((SelectInstance)arg2).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
            return;
        }

        throw new IllegalStateException("Unexpected waiter: " + arg2.toString());
    }

    public Object send(Object arg1, Continuation arg2) {
        return BufferedChannel.send$suspendImpl(this, arg1, arg2);
    }

    static Object send$suspendImpl(BufferedChannel arg13, Object arg14, Continuation arg15) {
        Object v8;
        BufferedChannel v5;
        Object v6_1;
        Object v13;
        int v7;
        long v9;
        Object v0 = BufferedChannel.getSendSegment$volatile$FU().get(arg13);
        while(true) {
            long v1 = BufferedChannel.getSendersAndCloseStatus$volatile$FU().getAndIncrement(arg13);
            v9 = v1 & 0xFFFFFFFFFFFFFFFL;
            boolean v12 = arg13.isClosedForSend0(v1);
            v1 = v9 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            v7 = ((int)(v9 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)v0).id != v1) {
                ChannelSegment v1_1 = arg13.findSegmentSend(v1, ((ChannelSegment)v0));
                if(v1_1 == null) {
                    if(!v12) {
                        continue;
                    }

                    v13 = arg13.onClosedSend(arg14, arg15);
                    if(v13 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return v13;
                    }
                }
                else {
                    ChannelSegment v6 = v1_1;
                    goto label_26;
                }
            }
            else {
                v6_1 = v0;
            label_26:
                v5 = arg13;
                v8 = arg14;
                int v13_1 = v5.updateCellSend(((ChannelSegment)v6_1), v7, v8, v9, null, v12);
                if(v13_1 == 0) {
                    goto label_72;
                }
                else if(v13_1 != 1) {
                    if(v13_1 == 2) {
                        goto label_59;
                    }
                    else if(v13_1 == 3) {
                        goto label_54;
                    }
                    else if(v13_1 != 4) {
                        if(v13_1 != 5) {
                        }
                        else {
                            ((ChannelSegment)v6_1).cleanPrev();
                        }

                        arg13 = v5;
                        ChannelSegment v0_1 = ((ChannelSegment)v6_1);
                        arg14 = v8;
                        continue;
                    }
                    else {
                        break;
                    }
                }
            }

            goto label_73;
        }

        if(v9 < v5.getReceiversCounter$kotlinx_coroutines_core()) {
            ((ChannelSegment)v6_1).cleanPrev();
        }

        v13 = v5.onClosedSend(v8, arg15);
        if(v13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            goto label_73;
        }

        return v13;
    label_54:
        v13 = v5.sendOnNoWaiterSuspend(((ChannelSegment)v6_1), v7, v8, v9, arg15);
        if(v13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            goto label_73;
        }

        return v13;
    label_59:
        Continuation v11 = arg15;
        if(v12) {
            ((ChannelSegment)v6_1).onSlotCleaned();
            v13 = v5.onClosedSend(v8, v11);
            if(v13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                goto label_73;
            }

            return v13;
        }

        if(!DebugKt.getASSERTIONS_ENABLED()) {
        }
        else {
            throw new AssertionError();
        label_72:
            ((ChannelSegment)v6_1).cleanPrev();
        }

    label_73:
        return Unit.INSTANCE;
    }

    public Object sendBroadcast$kotlinx_coroutines_core(Object arg1, Continuation arg2) {
        return BufferedChannel.sendBroadcast$suspendImpl(this, arg1, arg2);
    }

    static Object sendBroadcast$suspendImpl(BufferedChannel arg14, Object arg15, Continuation arg16) {
        BufferedChannel v4_2;
        Object v7;
        ChannelSegment v4_1;
        int v6;
        CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg16), 1);
        v0.initCancellability();
        CancellableContinuationImpl v1 = v0;
        if(arg14.onUndeliveredElement != null) {
            goto label_88;
        }

        SendBroadcast v10 = new SendBroadcast(((CancellableContinuation)v1));
        Object v3 = BufferedChannel.getSendSegment$volatile$FU().get(arg14);
        while(true) {
            long v4 = BufferedChannel.getSendersAndCloseStatus$volatile$FU().getAndIncrement(arg14);
            long v8 = v4 & 0xFFFFFFFFFFFFFFFL;
            boolean v11 = arg14.isClosedForSend0(v4);
            v4 = v8 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            v6 = ((int)(v8 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(Long.compare(((ChannelSegment)v3).id, v4) != 0) {
                v4_1 = arg14.findSegmentSend(v4, ((ChannelSegment)v3));
                if(v4_1 == null) {
                    if(!v11) {
                        continue;
                    }

                    goto label_66;
                }
                else {
                    ChannelSegment v5 = v4_1;
                    v7 = arg15;
                    v4_2 = arg14;
                    goto label_39;
                }
            }
            else {
                Object v5_1 = v3;
                v4_2 = arg14;
                v7 = arg15;
            label_39:
                int v3_1 = v4_2.updateCellSend(((ChannelSegment)v5_1), v6, v7, v8, v10, v11);
                v4_1 = ((ChannelSegment)v5_1);
                if(v3_1 == 0) {
                    goto label_78;
                }
                else if(v3_1 != 1) {
                    if(v3_1 == 2) {
                        goto label_64;
                    }
                    else if(v3_1 == 3) {
                        goto label_59;
                    }
                    else if(v3_1 != 4) {
                        if(v3_1 != 5) {
                        }
                        else {
                            v4_1.cleanPrev();
                        }

                        ChannelSegment v3_2 = v4_1;
                        continue;
                    }
                    else {
                        break;
                    }
                }

                goto label_79;
            }

            goto label_83;
        }

        if(v8 >= arg14.getReceiversCounter$kotlinx_coroutines_core()) {
            goto label_66;
        }

        v4_1.cleanPrev();
        goto label_66;
    label_59:
        throw new IllegalStateException("unexpected".toString());
    label_64:
        if(v11) {
            v4_1.onSlotCleaned();
        label_66:
            ((Continuation)v1).resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
            goto label_83;
        }

        if((v10 instanceof Waiter)) {
        }
        else {
            v10 = null;
        }

        if(v10 == null) {
        }
        else {
            arg14.prepareSenderForSuspension(((Waiter)v10), v4_1, v6);
            goto label_83;
        label_78:
            v4_1.cleanPrev();
        label_79:
            ((Continuation)v1).resumeWith(Result.constructor-impl(Boxing.boxBoolean(true)));
        }

    label_83:
        Object v14 = v0.getResult();
        if(v14 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg16);
        }

        return v14;
    label_88:
        throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`".toString());
    }

    private final Object sendImpl(Object arg11, Object arg12, Function0 arg13, Function2 arg14, Function0 arg15, Function4 arg16) {
        int v2_2;
        ChannelSegment v1_1;
        long v4;
        Object v1 = BufferedChannel.getSendSegment$volatile$FU().get(this);
        while(true) {
            long v2 = BufferedChannel.getSendersAndCloseStatus$volatile$FU().getAndIncrement(this);
            v4 = 0xFFFFFFFFFFFFFFFL & v2;
            boolean v7 = this.isClosedForSend0(v2);
            v2 = v4 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            int v6 = ((int)(v4 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)v1).id != v2) {
                ChannelSegment v2_1 = this.findSegmentSend(v2, ((ChannelSegment)v1));
                if(v2_1 == null) {
                    if(!v7) {
                        continue;
                    }

                    return arg15.invoke();
                }
                else {
                    v1_1 = v2_1;
                }
            }

            v2_2 = v6;
            int v8 = this.updateCellSend(v1_1, v2_2, arg11, v4, arg12, v7);
            if(v8 == 0) {
                goto label_67;
            }

            if(v8 == 1) {
                goto label_65;
            }

            if(v8 == 2) {
                goto label_51;
            }

            if(v8 == 3) {
                goto label_46;
            }

            if(v8 == 4) {
                break;
            }

            if(v8 != 5) {
                continue;
            }

            v1_1.cleanPrev();
        }

        if(v4 < this.getReceiversCounter$kotlinx_coroutines_core()) {
            v1_1.cleanPrev();
        }

        return arg15.invoke();
    label_46:
        return arg16.invoke(v1_1, Integer.valueOf(v2_2), arg11, Long.valueOf(v4));
    label_51:
        if(v7) {
            v1_1.onSlotCleaned();
            return arg15.invoke();
        }

        Object v3 = (arg12 instanceof Waiter) ? arg12 : null;
        if(v3 != null) {
            this.prepareSenderForSuspension(((Waiter)v3), v1_1, v2_2);
        }

        return arg14.invoke(v1_1, Integer.valueOf(v2_2));
    label_65:
        return arg13.invoke();
    label_67:
        v1_1.cleanPrev();
        return arg13.invoke();
    }

    static Object sendImpl$default(BufferedChannel arg11, Object arg12, Object arg13, Function0 arg14, Function2 arg15, Function0 arg16, Function4 arg17, int arg18, Object arg19) {
        int v2_2;
        ChannelSegment v1_1;
        long v4;
        Function4 v8_1;
        if(arg19 != null) {
            goto label_76;
        }

        if((arg18 & 0x20) != 0) {
            BufferedChannel$sendImpl$1 v8 = BufferedChannel$sendImpl$1.INSTANCE;
        }
        else {
            v8_1 = arg17;
        }

        Object v1 = BufferedChannel.getSendSegment$volatile$FU().get(arg11);
        while(true) {
            long v2 = BufferedChannel.getSendersAndCloseStatus$volatile$FU().getAndIncrement(arg11);
            v4 = 0xFFFFFFFFFFFFFFFL & v2;
            boolean v7 = arg11.isClosedForSend0(v2);
            v2 = v4 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            int v6 = ((int)(v4 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)v1).id != v2) {
                ChannelSegment v2_1 = arg11.findSegmentSend(v2, ((ChannelSegment)v1));
                if(v2_1 == null) {
                    if(!v7) {
                        continue;
                    }

                    return arg16.invoke();
                }
                else {
                    v1_1 = v2_1;
                }
            }

            v2_2 = v6;
            int v9 = arg11.updateCellSend(v1_1, v2_2, arg12, v4, arg13, v7);
            if(v9 == 0) {
                goto label_73;
            }

            if(v9 == 1) {
                goto label_71;
            }

            if(v9 == 2) {
                goto label_57;
            }

            if(v9 == 3) {
                goto label_53;
            }

            if(v9 == 4) {
                break;
            }

            if(v9 != 5) {
                continue;
            }

            v1_1.cleanPrev();
        }

        if(v4 < arg11.getReceiversCounter$kotlinx_coroutines_core()) {
            v1_1.cleanPrev();
        }

        return arg16.invoke();
    label_53:
        return v8_1.invoke(v1_1, Integer.valueOf(v2_2), arg12, Long.valueOf(v4));
    label_57:
        if(v7) {
            v1_1.onSlotCleaned();
            return arg16.invoke();
        }

        Object v3 = (arg13 instanceof Waiter) ? arg13 : null;
        if(v3 != null) {
            arg11.prepareSenderForSuspension(((Waiter)v3), v1_1, v2_2);
        }

        return arg15.invoke(v1_1, Integer.valueOf(v2_2));
    label_71:
        return arg14.invoke();
    label_73:
        v1_1.cleanPrev();
        return arg14.invoke();
    label_76:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
    }

    private final void sendImplOnNoWaiter(ChannelSegment arg16, int arg17, Object arg18, long arg19, Waiter arg21, Function0 arg22, Function0 arg23) {
        Waiter v6_1;
        int v2_2;
        ChannelSegment v1_1;
        int v7 = this.updateCellSend(arg16, arg17, arg18, arg19, arg21, false);
        if(v7 == 0) {
            goto label_99;
        }

        if(v7 == 1) {
            goto label_97;
        }

        int v9 = 2;
        if(v7 == v9) {
            goto label_92;
        }

        int v10 = 4;
        if(v7 == v10) {
            goto label_87;
        }

        String v11 = "unexpected";
        int v12 = 5;
        if(v7 != v12) {
            goto label_83;
        }

        arg16.cleanPrev();
        Object v1 = BufferedChannel.getSendSegment$volatile$FU().get(this);
        while(true) {
            long v2 = BufferedChannel.getSendersAndCloseStatus$volatile$FU().getAndIncrement(this);
            long v4 = 0xFFFFFFFFFFFFFFFL & v2;
            boolean v7_1 = this.isClosedForSend0(v2);
            v2 = v4 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            int v6 = ((int)(v4 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)v1).id != v2) {
                ChannelSegment v2_1 = this.findSegmentSend(v2, ((ChannelSegment)v1));
                if(v2_1 == null) {
                    if(!v7_1) {
                        continue;
                    }

                    arg23.invoke();
                }
                else {
                    v1_1 = v2_1;
                    goto label_41;
                }
            }
            else {
            label_41:
                v2_2 = v6;
                v6_1 = arg21;
                int v13 = this.updateCellSend(v1_1, v2_2, arg18, v4, v6_1, v7_1);
                if(v13 == 0) {
                    goto label_80;
                }
                else if(v13 == 1) {
                    goto label_78;
                }
                else if(v13 == v9) {
                    goto label_65;
                }
                else if(v13 == 3) {
                    goto label_61;
                }
                else if(v13 != v10) {
                    if(v13 != v12) {
                    }
                    else {
                        v1_1.cleanPrev();
                    }

                    continue;
                }
                else {
                    break;
                }
            }

            return;
        }

        if(v4 < this.getReceiversCounter$kotlinx_coroutines_core()) {
            v1_1.cleanPrev();
        }

        arg23.invoke();
        return;
    label_61:
        throw new IllegalStateException(v11.toString());
    label_65:
        if(v7_1) {
            v1_1.onSlotCleaned();
            arg23.invoke();
            return;
        }

        Waiter v3 = (v6_1 instanceof Waiter) ? v6_1 : null;
        if(v3 == null) {
        }
        else {
            this.prepareSenderForSuspension(v3, v1_1, v2_2);
            return;
        label_78:
            arg22.invoke();
            return;
        label_80:
            v1_1.cleanPrev();
            arg22.invoke();
        }

        return;
    label_83:
        throw new IllegalStateException(v11.toString());
    label_87:
        if(arg19 < this.getReceiversCounter$kotlinx_coroutines_core()) {
            arg16.cleanPrev();
        }

        arg23.invoke();
        return;
    label_92:
        this.prepareSenderForSuspension(arg21, arg16, arg17);
        return;
    label_97:
        arg22.invoke();
        return;
    label_99:
        arg16.cleanPrev();
        arg22.invoke();
    }

    private final Object sendOnNoWaiterSuspend(ChannelSegment arg17, int arg18, Object arg19, long arg20, Continuation arg22) {
        int v15;
        int v6;
        Object v3;
        BufferedChannel v0_1;
        CancellableContinuationImpl v8 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(arg22));
        try {
            v0_1 = this;
            v3 = arg19;
            v6 = v0_1.updateCellSend(arg17, arg18, v3, arg20, v8, false);
            if(v6 != 0) {
            }
            else {
                goto label_114;
            }
        }
        catch(Throwable v0) {
            goto label_130;
        }

        if(v6 != 1) {
            int v10 = 2;
            if(v6 != v10) {
                int v11 = 4;
                if(v6 != v11) {
                    String v12 = "unexpected";
                    if(v6 == 5) {
                        try {
                            arg17.cleanPrev();
                            Object v1 = BufferedChannel.getSendSegment$volatile$FU().get(v0_1);
                            while(true) {
                                AtomicLongFieldUpdater v2 = BufferedChannel.getSendersAndCloseStatus$volatile$FU();
                                long v4 = v2.getAndIncrement(v0_1);
                                long v6_1 = 0xFFFFFFFFFFFFFFFL & v4;
                                boolean v2_1 = v0_1.isClosedForSend0(v4);
                                v4 = v6_1 / (((long)BufferedChannelKt.SEGMENT_SIZE));
                                v15 = ((int)(v6_1 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
                                if(((ChannelSegment)v1).id != v4) {
                                    ChannelSegment v4_1 = v0_1.findSegmentSend(v4, ((ChannelSegment)v1));
                                    if(v4_1 != null) {
                                        ChannelSegment v1_1 = v4_1;
                                    }
                                    else if(!v2_1) {
                                        continue;
                                    }
                                    else {
                                        goto label_41;
                                    }
                                }

                                v4 = v6_1;
                                boolean v7 = v2_1;
                                v6 = v0_1.updateCellSend(((ChannelSegment)v1), v15, v3, v4, v8, v7);
                                v15 = v15;
                                if(v6 == 0) {
                                    goto label_91;
                                }

                                if(v6 == 1) {
                                    goto label_85;
                                }

                                if(v6 == v10) {
                                    goto label_73;
                                }

                                if(v6 == 3) {
                                    goto label_69;
                                }

                                if(v6 == v11) {
                                    break;
                                }

                                int v2_2 = 5;
                                if(v6 != v2_2) {
                                }
                                else {
                                    ((ChannelSegment)v1).cleanPrev();
                                }
                            }

                            if(v4 >= v0_1.getReceiversCounter$kotlinx_coroutines_core()) {
                                goto label_41;
                            }

                            ((ChannelSegment)v1).cleanPrev();
                            goto label_41;
                        label_69:
                            throw new IllegalStateException(v12.toString());
                        label_73:
                            if(v7) {
                                ((ChannelSegment)v1).onSlotCleaned();
                                goto label_41;
                            }

                            CancellableContinuationImpl v2_3 = (v8 instanceof Waiter) ? v8 : null;
                            if(v2_3 == null) {
                                goto label_120;
                            }

                            v0_1.prepareSenderForSuspension(((Waiter)v2_3), ((ChannelSegment)v1), v15);
                            goto label_120;
                        label_85:
                            CancellableContinuationImpl v0_2 = v8;
                            Unit v1_2 = Unit.INSTANCE;
                            goto label_112;
                        label_91:
                            ((ChannelSegment)v1).cleanPrev();
                            v0_2 = v8;
                            v1_2 = Unit.INSTANCE;
                            goto label_112;
                        label_96:
                            throw new IllegalStateException(v12.toString());
                        label_100:
                            if(arg20 < v0_1.getReceiversCounter$kotlinx_coroutines_core()) {
                                arg17.cleanPrev();
                            }

                        label_41:
                            v0_1.onClosedSendOnNoWaiterSuspend(v3, v8);
                            goto label_120;
                        label_104:
                            v0_1.prepareSenderForSuspension(v8, arg17, arg18);
                            goto label_120;
                        label_109:
                            v0_2 = v8;
                            v1_2 = Unit.INSTANCE;
                            goto label_112;
                        label_114:
                            arg17.cleanPrev();
                            v0_2 = v8;
                            v1_2 = Unit.INSTANCE;
                        label_112:
                            v1 = Result.constructor-impl(v1_2);
                            ((Continuation)v0_2).resumeWith(v1);
                            goto label_120;
                        }
                        catch(Throwable v0) {
                        label_130:
                            v8.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                            throw v0;
                        }
                    }
                    else {
                        goto label_96;
                    }
                }
                else {
                    goto label_100;
                }

                goto label_41;
            }
            else {
                goto label_104;
            }
        }
        else {
            goto label_109;
        }

    label_120:
        Object v0_3 = v8.getResult();
        if(v0_3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(arg22);
        }

        if(v0_3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v0_3;
        }

        return Unit.INSTANCE;
    }

    private final void setBufferEnd$volatile(long arg1) {
        this.bufferEnd$volatile = arg1;
    }

    private final void setBufferEndSegment$volatile(Object arg1) {
        this.bufferEndSegment$volatile = arg1;
    }

    private final void setCloseHandler$volatile(Object arg1) {
        this.closeHandler$volatile = arg1;
    }

    private final void setCompletedExpandBuffersAndPauseFlag$volatile(long arg1) {
        this.completedExpandBuffersAndPauseFlag$volatile = arg1;
    }

    private final void setReceiveSegment$volatile(Object arg1) {
        this.receiveSegment$volatile = arg1;
    }

    private final void setReceivers$volatile(long arg1) {
        this.receivers$volatile = arg1;
    }

    private final void setSendSegment$volatile(Object arg1) {
        this.sendSegment$volatile = arg1;
    }

    private final void setSendersAndCloseStatus$volatile(long arg1) {
        this.sendersAndCloseStatus$volatile = arg1;
    }

    private final void set_closeCause$volatile(Object arg1) {
        this._closeCause$volatile = arg1;
    }

    private final boolean shouldSendSuspend(long arg3) {
        if(this.isClosedForSend0(arg3)) {
            return 0;
        }

        return this.bufferOrRendezvousSend(arg3 & 0xFFFFFFFFFFFFFFFL) ^ 1;
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return this.shouldSendSuspend(BufferedChannel.getSendersAndCloseStatus$volatile$FU().get(this));
    }

    public String toString() {
        String v4_2;
        long v10;
        long v8;
        Object v4_1;
        BufferedChannel v0 = this;
        StringBuilder v1 = new StringBuilder();
        int v2 = ((int)(BufferedChannel.getSendersAndCloseStatus$volatile$FU().get(v0) >> 60));
        int v3 = 3;
        int v4 = 2;
        if(v2 == v4) {
            v1.append("closed,");
        }
        else if(v2 != v3) {
        }
        else {
            v1.append("cancelled,");
        }

        char v5 = ',';
        v1.append("capacity=" + v0.capacity + v5);
        v1.append("data=[");
        ChannelSegment[] v2_1 = new ChannelSegment[v3];
        int v6 = 0;
        v2_1[0] = BufferedChannel.getReceiveSegment$volatile$FU().get(v0);
        v2_1[1] = BufferedChannel.getSendSegment$volatile$FU().get(v0);
        v2_1[v4] = BufferedChannel.getBufferEndSegment$volatile$FU().get(v0);
        List v2_2 = CollectionsKt.listOf(((Object[])v2_1));
        ArrayList v3_1 = new ArrayList();
        Iterator v2_3 = ((Iterable)v2_2).iterator();
        while(v2_3.hasNext()) {
            v4_1 = v2_3.next();
            if(v4_1 == BufferedChannelKt.access$getNULL_SEGMENT$p()) {
                continue;
            }

            ((Collection)v3_1).add(v4_1);
        }

        v2_3 = ((Iterable)v3_1).iterator();
        if(!v2_3.hasNext()) {
            goto label_198;
        }

        Object v3_2 = v2_3.next();
        if(!v2_3.hasNext()) {
        }
        else {
            v8 = v3_2.id;
            goto label_62;
        label_198:
            throw new NoSuchElementException();
            do {
            label_62:
                v4_1 = v2_3.next();
                v10 = v4_1.id;
                if(v8 > v10) {
                    v3_2 = v4_1;
                    v8 = v10;
                }

                if(v2_3.hasNext()) {
                    continue;
                }

                break;
            }
            while(true);
        }

        v10 = v0.getReceiversCounter$kotlinx_coroutines_core();
        long v12 = v0.getSendersCounter$kotlinx_coroutines_core();
        while(true) {
            int v0_1 = BufferedChannelKt.SEGMENT_SIZE;
            for(v2 = v6; v2 < v0_1; ++v2) {
                v8 = ((ChannelSegment)v3_2).id * (((long)BufferedChannelKt.SEGMENT_SIZE)) + (((long)v2));
                v4 = Long.compare(v8, v12);
                if(v4 >= 0 && v8 >= v10) {
                    goto label_184;
                }

                Object v14 = ((ChannelSegment)v3_2).getState$kotlinx_coroutines_core(v2);
                Object v15 = ((ChannelSegment)v3_2).getElement$kotlinx_coroutines_core(v2);
                if((v14 instanceof CancellableContinuation)) {
                    v6 = Long.compare(v8, v10);
                    if(v6 < 0 && v4 >= 0) {
                        v4_2 = "receive";
                        goto label_160;
                    }

                    if(v4 < 0 && v6 >= 0) {
                        v4_2 = "send";
                        goto label_160;
                    }

                    v4_2 = "cont";
                    goto label_160;
                }
                else {
                    if((v14 instanceof SelectInstance)) {
                        v6 = Long.compare(v8, v10);
                        if(v6 < 0 && v4 >= 0) {
                            v4_2 = "onReceive";
                            goto label_160;
                        }

                        if(v4 < 0 && v6 >= 0) {
                            v4_2 = "onSend";
                            goto label_160;
                        }

                        v4_2 = "select";
                        goto label_160;
                    }

                    if((v14 instanceof ReceiveCatching)) {
                        v4_2 = "receiveCatching";
                        goto label_160;
                    }

                    if((v14 instanceof SendBroadcast)) {
                        v4_2 = "sendBroadcast";
                        goto label_160;
                    }

                    if((v14 instanceof WaiterEB)) {
                        v4_2 = "EB(" + v14 + ')';
                        goto label_160;
                    }

                    if(!Intrinsics.areEqual(v14, BufferedChannelKt.access$getRESUMING_BY_RCV$p())) {
                        if(Intrinsics.areEqual(v14, BufferedChannelKt.access$getRESUMING_BY_EB$p())) {
                        }
                        else if(v14 == null) {
                            goto label_178;
                        }
                        else if(Intrinsics.areEqual(v14, BufferedChannelKt.access$getIN_BUFFER$p())) {
                            goto label_178;
                        }
                        else if(Intrinsics.areEqual(v14, BufferedChannelKt.access$getDONE_RCV$p())) {
                            goto label_178;
                        }
                        else if(Intrinsics.areEqual(v14, BufferedChannelKt.access$getPOISONED$p())) {
                            goto label_178;
                        }
                        else if(Intrinsics.areEqual(v14, BufferedChannelKt.access$getINTERRUPTED_RCV$p())) {
                            goto label_178;
                        }
                        else if(Intrinsics.areEqual(v14, BufferedChannelKt.access$getINTERRUPTED_SEND$p())) {
                            goto label_178;
                        }
                        else if(Intrinsics.areEqual(v14, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            goto label_178;
                        }
                        else {
                            v4_2 = v14.toString();
                            goto label_160;
                        }
                    }

                    v4_2 = "resuming_sender";
                label_160:
                    if(v15 != null) {
                        v1.append("(" + v4_2 + v5 + v15 + "),");
                        goto label_178;
                    }

                    v1.append(v4_2 + v5);
                }

            label_178:
            }

            ConcurrentLinkedListNode v3_3 = ((ChannelSegment)v3_3).getNext();
            if(v3_3 == null) {
            label_184:
                if(StringsKt.last(v1) == v5) {
                    Intrinsics.checkNotNullExpressionValue(v1.deleteCharAt(v1.length() - 1), "deleteCharAt(...)");
                }

                v1.append("]");
                return v1.toString();
            }

            v6 = 0;
        }
    }

    public final String toStringDebug$kotlinx_coroutines_core() {
        String v5_1;
        Object v5;
        StringBuilder v0 = new StringBuilder();
        char v2 = ',';
        v0.append("S=" + this.getSendersCounter$kotlinx_coroutines_core() + ",R=" + this.getReceiversCounter$kotlinx_coroutines_core() + ",B=" + this.getBufferEndCounter() + ",B\'=" + BufferedChannel.getCompletedExpandBuffersAndPauseFlag$volatile$FU().get(this) + ",C=" + (((int)(BufferedChannel.getSendersAndCloseStatus$volatile$FU().get(this) >> 60))) + v2);
        int v1 = ((int)(BufferedChannel.getSendersAndCloseStatus$volatile$FU().get(this) >> 60));
        int v3 = 3;
        int v4 = 2;
        if(v1 == 1) {
            v0.append("CANCELLATION_STARTED,");
        }
        else if(v1 == v4) {
            v0.append("CLOSED,");
        }
        else if(v1 != v3) {
        }
        else {
            v0.append("CANCELLED,");
        }

        v0.append("SEND_SEGM=" + DebugStringsKt.getHexAddress(BufferedChannel.getSendSegment$volatile$FU().get(this)) + ",RCV_SEGM=" + DebugStringsKt.getHexAddress(BufferedChannel.getReceiveSegment$volatile$FU().get(this)));
        if(!this.isRendezvousOrUnlimited()) {
            v0.append(",EB_SEGM=" + DebugStringsKt.getHexAddress(BufferedChannel.getBufferEndSegment$volatile$FU().get(this)));
        }

        v0.append("  ");
        ChannelSegment[] v1_1 = new ChannelSegment[v3];
        v1_1[0] = BufferedChannel.getReceiveSegment$volatile$FU().get(this);
        v1_1[1] = BufferedChannel.getSendSegment$volatile$FU().get(this);
        v1_1[v4] = BufferedChannel.getBufferEndSegment$volatile$FU().get(this);
        List v10 = CollectionsKt.listOf(((Object[])v1_1));
        ArrayList v1_2 = new ArrayList();
        Iterator v10_1 = ((Iterable)v10).iterator();
        while(v10_1.hasNext()) {
            Object v3_1 = v10_1.next();
            if(v3_1 == BufferedChannelKt.access$getNULL_SEGMENT$p()) {
                continue;
            }

            ((Collection)v1_2).add(v3_1);
        }

        v10_1 = ((Iterable)v1_2).iterator();
        if(!v10_1.hasNext()) {
            goto label_208;
        }

        Object v1_3 = v10_1.next();
        if(!v10_1.hasNext()) {
        }
        else {
            long v3_2 = v1_3.id;
            goto label_111;
        label_208:
            throw new NoSuchElementException();
            do {
            label_111:
                v5 = v10_1.next();
                long v7 = v5.id;
                if(v3_2 > v7) {
                    v1_3 = v5;
                    v3_2 = v7;
                }

                if(v10_1.hasNext()) {
                    continue;
                }

                break;
            }
            while(true);
        }

        do {
            StringBuilder v10_2 = new StringBuilder().append(DebugStringsKt.getHexAddress(v1_3)).append("=[");
            String v3_3 = ((ChannelSegment)v1_3).isRemoved() ? "*" : "";
            v10_2 = v10_2.append(v3_3).append(((ChannelSegment)v1_3).id).append(",prev=");
            ConcurrentLinkedListNode v3_4 = ((ChannelSegment)v1_3).getPrev();
            String v4_1 = null;
            v3_3 = v3_4 != null ? DebugStringsKt.getHexAddress(v3_4) : v4_1;
            v0.append(v10_2.append(v3_3).append(v2).toString());
            int v10_3 = BufferedChannelKt.SEGMENT_SIZE;
            for(v3 = 0; v3 < v10_3; ++v3) {
                v5 = ((ChannelSegment)v1_3).getState$kotlinx_coroutines_core(v3);
                Object v7_1 = ((ChannelSegment)v1_3).getElement$kotlinx_coroutines_core(v3);
                if((v5 instanceof CancellableContinuation)) {
                    v5_1 = "cont";
                }
                else if((v5 instanceof SelectInstance)) {
                    v5_1 = "select";
                }
                else if((v5 instanceof ReceiveCatching)) {
                    v5_1 = "receiveCatching";
                }
                else if((v5 instanceof SendBroadcast)) {
                    v5_1 = "send(broadcast)";
                }
                else if((v5 instanceof WaiterEB)) {
                    v5_1 = "EB(" + v5 + ')';
                }
                else {
                    v5_1 = String.valueOf(v5);
                }

                v0.append("[" + v3 + "]=(" + v5_1 + v2 + v7_1 + "),");
            }

            v10_2 = new StringBuilder("next=");
            v3_4 = ((ChannelSegment)v1_3).getNext();
            if(v3_4 != null) {
                v4_1 = DebugStringsKt.getHexAddress(v3_4);
            }

            v0.append(v10_2.append(v4_1).append("]  ").toString());
            ConcurrentLinkedListNode v1_4 = ((ChannelSegment)v1_4).getNext();
        }
        while(v1_4 != null);

        return v0.toString();
    }

    public Object tryReceive-PtdJZtk() {
        ChannelSegment v0_3;
        Object v10;
        int v2_1;
        BufferedChannel v0_2;
        ChannelSegment v1_1;
        long v0 = BufferedChannel.getReceivers$volatile$FU().get(this);
        long v2 = BufferedChannel.getSendersAndCloseStatus$volatile$FU().get(this);
        if(this.isClosedForReceive0(v2)) {
            return ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause());
        }

        if(v0 >= (v2 & 0xFFFFFFFFFFFFFFFL)) {
            return ChannelResult.Companion.failure-PtdJZtk();
        }

        Symbol v5 = BufferedChannelKt.access$getINTERRUPTED_RCV$p();
        Object v0_1 = BufferedChannel.getReceiveSegment$volatile$FU().get(this);
        while(true) {
            if(this.isClosedForReceive()) {
                goto label_21;
            }

            long v3 = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(this);
            long v1 = v3 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            int v6 = ((int)(v3 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)v0_1).id != v1) {
                v1_1 = this.findSegmentReceive(v1, ((ChannelSegment)v0_1));
                if(v1_1 == null) {
                    continue;
                }
                else {
                    v0_2 = this;
                    v2_1 = v6;
                }
            }
            else {
                Object v1_2 = v0_1;
                v2_1 = v6;
                v0_2 = this;
            }

            v10 = v0_2.updateCellReceive(v1_1, v2_1, v3, v5);
            ChannelSegment v9 = v1_1;
            BufferedChannel v1_3 = v0_2;
            v0_3 = v9;
            if(v10 == BufferedChannelKt.access$getSUSPEND$p()) {
                if((v5 instanceof Waiter)) {
                }
                else {
                    v5 = null;
                }

                if(v5 != null) {
                    v1_3.prepareReceiverForSuspension(((Waiter)v5), v0_3, v2_1);
                }

                v1_3.waitExpandBufferCompletion$kotlinx_coroutines_core(v3);
                v0_3.onSlotCleaned();
                return ChannelResult.Companion.failure-PtdJZtk();
            }

            if(v10 != BufferedChannelKt.access$getFAILED$p()) {
                break;
            }

            if(v3 < v1_3.getSendersCounter$kotlinx_coroutines_core()) {
                v0_3.cleanPrev();
            }

            this = v1_3;
        }

        if(v10 != BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()) {
            v0_3.cleanPrev();
            return ChannelResult.Companion.success-JP2dKIU(v10);
        }

        throw new IllegalStateException("unexpected".toString());
    label_21:
        return ChannelResult.Companion.closed-JP2dKIU(this.getCloseCause());
    }

    private final boolean tryResumeReceiver(Object arg3, Object arg4) {
        KFunction v1_1;
        Function1 v0;
        if((arg3 instanceof SelectInstance)) {
            return ((SelectInstance)arg3).trySelect(this, arg4);
        }

        Function3 v1 = null;
        if((arg3 instanceof ReceiveCatching)) {
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuationImpl v3 = ((ReceiveCatching)arg3).cont;
            ChannelResult v4 = ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(arg4));
            v0 = this.onUndeliveredElement;
            if(v0 != null) {
                v1_1 = this.bindCancellationFunResult(v0);
            }

            return BufferedChannelKt.access$tryResume0(((CancellableContinuation)v3), v4, v1);
        }

        if((arg3 instanceof BufferedChannelIterator)) {
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((BufferedChannelIterator)arg3).tryResumeHasNext(arg4);
        }

        if((arg3 instanceof CancellableContinuation)) {
            Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            v0 = this.onUndeliveredElement;
            if(v0 != null) {
                v1_1 = this.bindCancellationFun(v0);
            }

            return BufferedChannelKt.access$tryResume0(((CancellableContinuation)arg3), arg4, v1);
        }

        throw new IllegalStateException("Unexpected receiver type: " + arg3.toString());
    }

    private final boolean tryResumeSender(Object arg5, ChannelSegment arg6, int arg7) {
        int v1 = 2;
        Function3 v2 = null;
        if((arg5 instanceof CancellableContinuation)) {
            Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.tryResume0$default(((CancellableContinuation)arg5), Unit.INSTANCE, v2, v1, v2);
        }

        if((arg5 instanceof SelectInstance)) {
            Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult v4 = ((SelectImplementation)arg5).trySelectDetailed(this, Unit.INSTANCE);
            if(v4 == TrySelectDetailedResult.REREGISTER) {
                arg6.cleanElement$kotlinx_coroutines_core(arg7);
            }

            if(v4 == TrySelectDetailedResult.SUCCESSFUL) {
                return 1;
            }

            return 0;
        }

        if((arg5 instanceof SendBroadcast)) {
            return BufferedChannelKt.tryResume0$default(((SendBroadcast)arg5).getCont(), Boolean.valueOf(true), v2, v1, v2);
        }

        throw new IllegalStateException("Unexpected waiter: " + arg5.toString());
    }

    public Object trySend-JP2dKIU(Object arg11) {
        ChannelSegment v0_2;
        BufferedChannel v11;
        Object v1_2;
        int v2;
        BufferedChannel v0_1;
        if(this.shouldSendSuspend(BufferedChannel.getSendersAndCloseStatus$volatile$FU().get(this))) {
            return ChannelResult.Companion.failure-PtdJZtk();
        }

        Symbol v6 = BufferedChannelKt.access$getINTERRUPTED_SEND$p();
        Object v0 = BufferedChannel.getSendSegment$volatile$FU().get(this);
        while(true) {
            long v1 = BufferedChannel.getSendersAndCloseStatus$volatile$FU().getAndIncrement(this);
            long v4 = v1 & 0xFFFFFFFFFFFFFFFL;
            boolean v7 = this.isClosedForSend0(v1);
            v1 = v4 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            int v3 = ((int)(v4 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)v0).id != v1) {
                ChannelSegment v1_1 = this.findSegmentSend(v1, ((ChannelSegment)v0));
                if(v1_1 == null) {
                    if(!v7) {
                        continue;
                    }

                    return ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
                }
                else {
                    v0_1 = this;
                    v2 = v3;
                }
            }
            else {
                v1_2 = v0;
                v2 = v3;
                v0_1 = this;
            }

            Object v3_1 = arg11;
            int v10 = v0_1.updateCellSend(((ChannelSegment)v1_2), v2, v3_1, v4, v6, v7);
            v11 = v0_1;
            v0_2 = ((ChannelSegment)v1_2);
            if(v10 == 0) {
                goto label_89;
            }

            if(v10 == 1) {
                goto label_85;
            }

            if(v10 == 2) {
                goto label_69;
            }

            if(v10 == 3) {
                goto label_64;
            }

            if(v10 == 4) {
                break;
            }

            if(v10 != 5) {
            }
            else {
                v0_2.cleanPrev();
            }

            this = v11;
            arg11 = v3_1;
        }

        if(v4 < v11.getReceiversCounter$kotlinx_coroutines_core()) {
            v0_2.cleanPrev();
        }

        return ChannelResult.Companion.closed-JP2dKIU(v11.getSendException());
    label_64:
        throw new IllegalStateException("unexpected".toString());
    label_69:
        if(v7) {
            v0_2.onSlotCleaned();
            return ChannelResult.Companion.closed-JP2dKIU(v11.getSendException());
        }

        if((v6 instanceof Waiter)) {
        }
        else {
            v6 = null;
        }

        if(v6 != null) {
            v11.prepareSenderForSuspension(((Waiter)v6), v0_2, v2);
        }

        v0_2.onSlotCleaned();
        return ChannelResult.Companion.failure-PtdJZtk();
    label_85:
        return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
    label_89:
        v0_2.cleanPrev();
        return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
    }

    protected final Object trySendDropOldest-JP2dKIU(Object arg11) {
        ChannelSegment v0_2;
        BufferedChannel v11;
        int v2;
        BufferedChannel v0_1;
        ChannelSegment v1_1;
        Symbol v6 = BufferedChannelKt.BUFFERED;
        Object v0 = BufferedChannel.getSendSegment$volatile$FU().get(this);
        while(true) {
            long v1 = BufferedChannel.getSendersAndCloseStatus$volatile$FU().getAndIncrement(this);
            long v4 = v1 & 0xFFFFFFFFFFFFFFFL;
            boolean v7 = this.isClosedForSend0(v1);
            v1 = v4 / (((long)BufferedChannelKt.SEGMENT_SIZE));
            int v3 = ((int)(v4 % (((long)BufferedChannelKt.SEGMENT_SIZE))));
            if(((ChannelSegment)v0).id != v1) {
                v1_1 = this.findSegmentSend(v1, ((ChannelSegment)v0));
                if(v1_1 == null) {
                    if(!v7) {
                        continue;
                    }

                    return ChannelResult.Companion.closed-JP2dKIU(this.getSendException());
                }
                else {
                    v0_1 = this;
                    v2 = v3;
                }
            }
            else {
                Object v1_2 = v0;
                v2 = v3;
                v0_1 = this;
            }

            Object v3_1 = arg11;
            int v10 = v0_1.updateCellSend(v1_1, v2, v3_1, v4, v6, v7);
            v11 = v0_1;
            v0_2 = v1_1;
            if(v10 == 0) {
                goto label_89;
            }

            if(v10 == 1) {
                goto label_85;
            }

            if(v10 == 2) {
                goto label_62;
            }

            if(v10 == 3) {
                goto label_57;
            }

            if(v10 == 4) {
                break;
            }

            if(v10 != 5) {
            }
            else {
                v0_2.cleanPrev();
            }

            this = v11;
            arg11 = v3_1;
        }

        if(v4 < v11.getReceiversCounter$kotlinx_coroutines_core()) {
            v0_2.cleanPrev();
        }

        return ChannelResult.Companion.closed-JP2dKIU(v11.getSendException());
    label_57:
        throw new IllegalStateException("unexpected".toString());
    label_62:
        if(v7) {
            v0_2.onSlotCleaned();
            return ChannelResult.Companion.closed-JP2dKIU(v11.getSendException());
        }

        if((v6 instanceof Waiter)) {
        }
        else {
            v6 = null;
        }

        if(v6 != null) {
            v11.prepareSenderForSuspension(((Waiter)v6), v0_2, v2);
        }

        v11.dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(v0_2.id * (((long)BufferedChannelKt.SEGMENT_SIZE)) + (((long)v2)));
        return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
    label_85:
        return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
    label_89:
        v0_2.cleanPrev();
        return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
    }

    private final void update$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater arg7, Object arg8, Function1 arg9) {
        while(true) {
            long v2 = arg7.get(arg8);
            AtomicLongFieldUpdater v0 = arg7;
            Object v1 = arg8;
            if(v0.compareAndSet(v1, v2, arg9.invoke(Long.valueOf(v2)).longValue())) {
                return;
            }

            arg7 = v0;
            arg8 = v1;
        }
    }

    private final boolean updateCellExpandBuffer(ChannelSegment arg4, int arg5, long arg6) {
        Object v0 = arg4.getState$kotlinx_coroutines_core(arg5);
        if(((v0 instanceof Waiter)) && arg6 >= BufferedChannel.getReceivers$volatile$FU().get(this) && (arg4.casState$kotlinx_coroutines_core(arg5, v0, BufferedChannelKt.access$getRESUMING_BY_EB$p()))) {
            if(this.tryResumeSender(v0, arg4, arg5)) {
                arg4.setState$kotlinx_coroutines_core(arg5, BufferedChannelKt.BUFFERED);
                return 1;
            }
            else {
                arg4.setState$kotlinx_coroutines_core(arg5, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                arg4.onCancelledRequest(arg5, false);
                return 0;
            }
        }

        return this.updateCellExpandBufferSlow(arg4, arg5, arg6);
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment arg7, int arg8, long arg9) {
        Object v0;
        while(true) {
            v0 = arg7.getState$kotlinx_coroutines_core(arg8);
            if((v0 instanceof Waiter)) {
                if(arg9 < BufferedChannel.getReceivers$volatile$FU().get(this)) {
                    if(!arg7.casState$kotlinx_coroutines_core(arg8, v0, new WaiterEB(v0))) {
                        continue;
                    }

                    return 1;
                }

                if(!arg7.casState$kotlinx_coroutines_core(arg8, v0, BufferedChannelKt.access$getRESUMING_BY_EB$p())) {
                    continue;
                }

                if(this.tryResumeSender(v0, arg7, arg8)) {
                    arg7.setState$kotlinx_coroutines_core(arg8, BufferedChannelKt.BUFFERED);
                    return 1;
                }

                arg7.setState$kotlinx_coroutines_core(arg8, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                arg7.onCancelledRequest(arg8, false);
                return 0;
            }

            if(v0 == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) {
                return 0;
            }

            if(v0 == null) {
                if(!arg7.casState$kotlinx_coroutines_core(arg8, v0, BufferedChannelKt.access$getIN_BUFFER$p())) {
                    continue;
                }

                return 1;
            }

            if(v0 == BufferedChannelKt.BUFFERED) {
                return 1;
            }

            if(v0 != BufferedChannelKt.access$getPOISONED$p() && v0 != BufferedChannelKt.access$getDONE_RCV$p()) {
                if(v0 == BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                }
                else if(v0 == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return 1;
                }
                else if(v0 == BufferedChannelKt.access$getRESUMING_BY_RCV$p()) {
                    continue;
                }
                else {
                    break;
                }
            }

            return 1;
        }

        throw new IllegalStateException("Unexpected cell state: " + v0.toString());
        return 1;
    }

    private final Object updateCellReceive(ChannelSegment arg7, int arg8, long arg9, Object arg11) {
        Object v0 = arg7.getState$kotlinx_coroutines_core(arg8);
        if(v0 == null) {
            if(arg9 >= (BufferedChannel.getSendersAndCloseStatus$volatile$FU().get(this) & 0xFFFFFFFFFFFFFFFL)) {
                if(arg11 == null) {
                    return BufferedChannelKt.access$getSUSPEND_NO_WAITER$p();
                }
                else if(arg7.casState$kotlinx_coroutines_core(arg8, v0, arg11)) {
                    this.expandBuffer();
                    return BufferedChannelKt.access$getSUSPEND$p();
                }
            }
        }
        else if(v0 == BufferedChannelKt.BUFFERED && (arg7.casState$kotlinx_coroutines_core(arg8, v0, BufferedChannelKt.access$getDONE_RCV$p()))) {
            this.expandBuffer();
            return arg7.retrieveElement$kotlinx_coroutines_core(arg8);
        }

        return this.updateCellReceiveSlow(arg7, arg8, arg9, arg11);
    }

    private final Object updateCellReceiveSlow(ChannelSegment arg6, int arg7, long arg8, Object arg10) {
        do {
        label_0:
            Object v0 = arg6.getState$kotlinx_coroutines_core(arg7);
            if(v0 != null) {
                if(v0 == BufferedChannelKt.access$getIN_BUFFER$p()) {
                }
                else if(v0 == BufferedChannelKt.BUFFERED) {
                    if(!arg6.casState$kotlinx_coroutines_core(arg7, v0, BufferedChannelKt.access$getDONE_RCV$p())) {
                        goto label_0;
                    }

                    this.expandBuffer();
                    return arg6.retrieveElement$kotlinx_coroutines_core(arg7);
                }
                else if(v0 == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) {
                    return BufferedChannelKt.access$getFAILED$p();
                }
                else if(v0 == BufferedChannelKt.access$getPOISONED$p()) {
                    return BufferedChannelKt.access$getFAILED$p();
                }
                else if(v0 == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    this.expandBuffer();
                    return BufferedChannelKt.access$getFAILED$p();
                }
                else {
                    if(v0 == BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
                        goto label_0;
                    }

                    if(!arg6.casState$kotlinx_coroutines_core(arg7, v0, BufferedChannelKt.access$getRESUMING_BY_RCV$p())) {
                        goto label_0;
                    }

                    boolean v8 = v0 instanceof WaiterEB;
                    if(v8) {
                        Waiter v0_1 = ((WaiterEB)v0).waiter;
                    }

                    if(this.tryResumeSender(v0, arg6, arg7)) {
                        arg6.setState$kotlinx_coroutines_core(arg7, BufferedChannelKt.access$getDONE_RCV$p());
                        this.expandBuffer();
                        return arg6.retrieveElement$kotlinx_coroutines_core(arg7);
                    }

                    arg6.setState$kotlinx_coroutines_core(arg7, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                    arg6.onCancelledRequest(arg7, false);
                    if(v8) {
                        this.expandBuffer();
                    }

                    return BufferedChannelKt.access$getFAILED$p();
                }
            }

            if(arg8 < (BufferedChannel.getSendersAndCloseStatus$volatile$FU().get(this) & 0xFFFFFFFFFFFFFFFL)) {
                if(!arg6.casState$kotlinx_coroutines_core(arg7, v0, BufferedChannelKt.access$getPOISONED$p())) {
                    goto label_0;
                }

                this.expandBuffer();
                return BufferedChannelKt.access$getFAILED$p();
            }

            if(arg10 == null) {
                return BufferedChannelKt.access$getSUSPEND_NO_WAITER$p();
            }
        }
        while(!arg6.casState$kotlinx_coroutines_core(arg7, v0, arg10));

        this.expandBuffer();
        return BufferedChannelKt.access$getSUSPEND$p();
    }

    private final int updateCellSend(ChannelSegment arg4, int arg5, Object arg6, long arg7, Object arg9, boolean arg10) {
        arg4.storeElement$kotlinx_coroutines_core(arg5, arg6);
        if(arg10) {
            return this.updateCellSendSlow(arg4, arg5, arg6, arg7, arg9, arg10);
        }

        Object v0 = arg4.getState$kotlinx_coroutines_core(arg5);
        if(v0 == null) {
            Object v2 = null;
            if(this.bufferOrRendezvousSend(arg7)) {
                if(arg4.casState$kotlinx_coroutines_core(arg5, v2, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            }
            else if(arg9 == null) {
                return 3;
            }
            else if(arg4.casState$kotlinx_coroutines_core(arg5, v2, arg9)) {
                return 2;
            }
        }
        else if((v0 instanceof Waiter)) {
            arg4.cleanElement$kotlinx_coroutines_core(arg5);
            if(this.tryResumeReceiver(v0, arg6)) {
                arg4.setState$kotlinx_coroutines_core(arg5, BufferedChannelKt.access$getDONE_RCV$p());
                this.onReceiveDequeued();
                return 0;
            }
            else {
                if(arg4.getAndSetState$kotlinx_coroutines_core(arg5, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) != BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                    arg4.onCancelledRequest(arg5, true);
                }

                return 5;
            }
        }

        return this.updateCellSendSlow(arg4, arg5, arg6, arg7, arg9, arg10);
    }

    private final int updateCellSendSlow(ChannelSegment arg6, int arg7, Object arg8, long arg9, Object arg11, boolean arg12) {
        int v1;
        Object v0;
        do {
        label_0:
            v0 = arg6.getState$kotlinx_coroutines_core(arg7);
            v1 = 4;
            if(v0 == null) {
                Object v4 = null;
                if((this.bufferOrRendezvousSend(arg9)) && !arg12) {
                    if(!arg6.casState$kotlinx_coroutines_core(arg7, v4, BufferedChannelKt.BUFFERED)) {
                        goto label_0;
                    }

                    return 1;
                }

                if(arg12) {
                    if(!arg6.casState$kotlinx_coroutines_core(arg7, v4, BufferedChannelKt.access$getINTERRUPTED_SEND$p())) {
                        goto label_0;
                    }

                    arg6.onCancelledRequest(arg7, false);
                    return v1;
                }

                if(arg11 == null) {
                    return 3;
                }

                if(!arg6.casState$kotlinx_coroutines_core(arg7, v4, arg11)) {
                    goto label_0;
                }

                return 2;
            }

            if(v0 != BufferedChannelKt.access$getIN_BUFFER$p()) {
                goto label_32;
            }
        }
        while(!arg6.casState$kotlinx_coroutines_core(arg7, v0, BufferedChannelKt.BUFFERED));

        return 1;
    label_32:
        int v10 = 5;
        if(v0 == BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
            arg6.cleanElement$kotlinx_coroutines_core(arg7);
            return v10;
        }

        if(v0 == BufferedChannelKt.access$getPOISONED$p()) {
            arg6.cleanElement$kotlinx_coroutines_core(arg7);
            return v10;
        }

        if(v0 == BufferedChannelKt.getCHANNEL_CLOSED()) {
            arg6.cleanElement$kotlinx_coroutines_core(arg7);
            this.completeCloseOrCancel();
            return v1;
        }

        if((DebugKt.getASSERTIONS_ENABLED()) && !(v0 instanceof Waiter)) {
            if((v0 instanceof WaiterEB)) {
            }
            else {
                throw new AssertionError();
            }
        }

        arg6.cleanElement$kotlinx_coroutines_core(arg7);
        if((v0 instanceof WaiterEB)) {
            Waiter v0_1 = ((WaiterEB)v0).waiter;
        }

        if(this.tryResumeReceiver(v0_1, arg8)) {
            arg6.setState$kotlinx_coroutines_core(arg7, BufferedChannelKt.access$getDONE_RCV$p());
            this.onReceiveDequeued();
            return 0;
        }

        if(arg6.getAndSetState$kotlinx_coroutines_core(arg7, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) != BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
            arg6.onCancelledRequest(arg7, true);
        }

        return v10;
    }

    private final void updateReceiversCounterIfLower(long arg8) {
        AtomicLongFieldUpdater v0 = BufferedChannel.getReceivers$volatile$FU();
        while(true) {
            long v3 = v0.get(this);
            if(v3 < arg8) {
                BufferedChannel v2 = this;
                long v5 = arg8;
                if(!BufferedChannel.getReceivers$volatile$FU().compareAndSet(v2, v3, v5)) {
                    this = v2;
                    arg8 = v5;
                    continue;
                }
            }
            else {
            }

            return;
        }
    }

    private final void updateSendersCounterIfLower(long arg8) {
        AtomicLongFieldUpdater v0 = BufferedChannel.getSendersAndCloseStatus$volatile$FU();
        while(true) {
            long v3 = v0.get(this);
            long v1 = 0xFFFFFFFFFFFFFFFL & v3;
            if(v1 < arg8) {
                long v5 = BufferedChannelKt.access$constructSendersAndCloseStatus(v1, ((int)(v3 >> 60)));
                BufferedChannel v2 = this;
                if(!BufferedChannel.getSendersAndCloseStatus$volatile$FU().compareAndSet(v2, v3, v5)) {
                    this = v2;
                    continue;
                }
            }
            else {
            }

            return;
        }
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long arg19) {
        long v2_1;
        long v7;
        BufferedChannel v1 = this;
        if(v1.isRendezvousOrUnlimited()) {
        }
        else {
            while(v1.getBufferEndCounter() <= arg19) {
                v1 = this;
            }

            int v0 = BufferedChannelKt.access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p();
            int v2;
            for(v2 = 0; true; ++v2) {
                v7 = 0x3FFFFFFFFFFFFFFFL;
                if(v2 >= v0) {
                    break;
                }

                long v3 = v1.getBufferEndCounter();
                if(v3 == (v7 & BufferedChannel.getCompletedExpandBuffersAndPauseFlag$volatile$FU().get(v1)) && v3 == v1.getBufferEndCounter()) {
                    return;
                }
            }

            AtomicLongFieldUpdater v0_1 = BufferedChannel.getCompletedExpandBuffersAndPauseFlag$volatile$FU();
            while(true) {
                v2_1 = v0_1.get(v1);
                if(!v0_1.compareAndSet(v1, v2_1, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(v2_1 & v7, true))) {
                    v1 = this;
                    continue;
                }

                break;
            }

            while(true) {
                v2_1 = v1.getBufferEndCounter();
                long v4 = BufferedChannel.getCompletedExpandBuffersAndPauseFlag$volatile$FU().get(v1);
                long v10 = v4 & v7;
                v0 = (0x4000000000000000L & v4) != 0 ? 1 : 0;
                if(v2_1 == v10 && v2_1 == v1.getBufferEndCounter()) {
                    v0_1 = BufferedChannel.getCompletedExpandBuffersAndPauseFlag$volatile$FU();
                    break;
                }

                if(v0 == 0) {
                    v1 = this;
                    BufferedChannel.getCompletedExpandBuffersAndPauseFlag$volatile$FU().compareAndSet(v1, v4, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(v10, true));
                    continue;
                }

                v1 = this;
            }

            while(true) {
                v2_1 = v0_1.get(v1);
                boolean v2_2 = v0_1.compareAndSet(v1, v2_1, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(v2_1 & v7, false));
                AtomicLongFieldUpdater v1_1 = v0_1;
                if(v2_2) {
                    return;
                }

                v0_1 = v1_1;
                v1 = this;
            }
        }
    }
}

