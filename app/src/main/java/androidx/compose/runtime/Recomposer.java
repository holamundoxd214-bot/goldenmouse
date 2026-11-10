package androidx.compose.runtime;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectList;
import androidx.collection.ObjectListKt;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import androidx.compose.runtime.internal.Utils_androidKt;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure;
import androidx.compose.runtime.snapshots.TransparentObserverMutableSnapshot;
import androidx.compose.runtime.snapshots.TransparentObserverSnapshot;
import androidx.compose.runtime.tooling.ComposeStackTraceMode;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.CompositionObserverKt;
import androidx.compose.runtime.tooling.CompositionRegistrationObserver;
import androidx.compose.runtime.tooling.ObservableComposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1={"\u0000æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 â\u00012\u00020\u0001:\nÞ\u0001ß\u0001à\u0001á\u0001â\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010O\u001A\n\u0012\u0004\u0012\u000201\u0018\u000100H\u0002J\b\u0010P\u001A\u000201H\u0002J\u0006\u0010^\u001A\u00020_J\b\u0010`\u001A\u000205H\u0002J\u0010\u0010a\u001A\u0002012\u0006\u0010b\u001A\u00020\u0014H\u0002J\u000E\u0010c\u001A\u000201H\u0086@¢\u0006\u0002\u0010dJ&\u0010e\u001A\u0002012\u0006\u0010f\u001A\u00020\u00162\n\b\u0002\u0010g\u001A\u0004\u0018\u00010\u00192\b\b\u0002\u0010h\u001A\u000205H\u0002J\u0017\u0010i\u001A\u0002012\f\u0010j\u001A\b\u0012\u0004\u0012\u0002010kH\u0082\bJ\u000E\u0010l\u001A\b\u0012\u0004\u0012\u00020\u00190\u001BH\u0002J\u000E\u0010m\u001A\b\u0012\u0004\u0012\u00020\u00190\u001BH\u0002J\b\u0010n\u001A\u000201H\u0002J\u0010\u0010o\u001A\u0002012\u0006\u0010p\u001A\u00020\u0019H\u0002J\u0010\u0010q\u001A\u0002012\u0006\u0010p\u001A\u00020\u0019H\u0002J\u0010\u0010r\u001A\u0002012\u0006\u0010p\u001A\u00020\u0019H\u0002J\u0010\u0010s\u001A\u0002012\u0006\u0010p\u001A\u00020\u0019H\u0002J\u0015\u0010t\u001A\u00020u2\u0006\u0010v\u001A\u00020LH\u0000¢\u0006\u0002\bwJ\n\u0010x\u001A\u0004\u0018\u000108H\u0002J\b\u0010y\u001A\u000201H\u0002J\u0010\u0010z\u001A\u0002012\u0006\u0010p\u001A\u00020\u0019H\u0002J\u000E\u0010}\u001A\u000201H\u0082@¢\u0006\u0002\u0010dJT\u0010~\u001A\u0002012C\u0010j\u001A?\b\u0001\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0017\u0012\u00150\u0081\u0001¢\u0006\u000F\b\u0082\u0001\u0012\n\b\u0083\u0001\u0012\u0005\b\b(\u0084\u0001\u0012\u000B\u0012\t\u0012\u0004\u0012\u0002010\u0085\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u007F¢\u0006\u0003\b\u0086\u0001H\u0082@¢\u0006\u0003\u0010\u0087\u0001J\u0007\u0010\u0088\u0001\u001A\u000201J\u0007\u0010\u0089\u0001\u001A\u000201J\u000F\u0010\u008A\u0001\u001A\u000201H\u0086@¢\u0006\u0002\u0010dJ\u0019\u0010\u008B\u0001\u001A\u00030\u008C\u00012\r\u0010\u008D\u0001\u001A\b\u0012\u0004\u0012\u0002010kH\u0016J/\u0010\u008E\u0001\u001A\u0002012\u0006\u0010p\u001A\u00020\u00192\u0013\u0010\u008F\u0001\u001A\u000E\u0012\u0004\u0012\u0002010k¢\u0006\u0003\b\u0090\u0001H\u0011¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J@\u0010\u0093\u0001\u001A\t\u0012\u0004\u0012\u00020>0\u0094\u00012\u0006\u0010p\u001A\u00020\u00192\b\u0010\u0095\u0001\u001A\u00030\u0096\u00012\u0013\u0010\u008F\u0001\u001A\u000E\u0012\u0004\u0012\u0002010k¢\u0006\u0003\b\u0090\u0001H\u0011¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J8\u0010\u0099\u0001\u001A\t\u0012\u0004\u0012\u00020>0\u0094\u00012\u0006\u0010p\u001A\u00020\u00192\b\u0010\u0095\u0001\u001A\u00030\u0096\u00012\u000E\u0010\u009A\u0001\u001A\t\u0012\u0004\u0012\u00020>0\u0094\u0001H\u0010¢\u0006\u0003\b\u009B\u0001J\u0018\u0010\u009C\u0001\u001A\u0002012\u0007\u0010\u009D\u0001\u001A\u00020>H\u0010¢\u0006\u0003\b\u009E\u0001J\u0011\u0010\u009F\u0001\u001A\u0002012\u0006\u0010p\u001A\u00020\u0019H\u0002J$\u0010 \u0001\u001A\u0004\u0018\u00010\u00192\u0006\u0010p\u001A\u00020\u00192\u000F\u0010¡\u0001\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001DH\u0002J/\u0010¢\u0001\u001A\b\u0012\u0004\u0012\u00020\u00190\u001B2\r\u0010£\u0001\u001A\b\u0012\u0004\u0012\u00020\"0\u001B2\u000F\u0010¡\u0001\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001DH\u0002J\t\u0010¤\u0001\u001A\u000201H\u0002J\u001E\u0010¥\u0001\u001A\u000F\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002010¦\u00012\u0006\u0010p\u001A\u00020\u0019H\u0002J/\u0010§\u0001\u001A\u000F\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002010¦\u00012\u0006\u0010p\u001A\u00020\u00192\u000F\u0010¡\u0001\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001DH\u0002J@\u0010¨\u0001\u001A\u0003H©\u0001\"\u0005\b\u0000\u0010©\u00012\u0006\u0010p\u001A\u00020\u00192\u000F\u0010¡\u0001\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001D2\r\u0010j\u001A\t\u0012\u0005\u0012\u0003H©\u00010kH\u0082\b¢\u0006\u0003\u0010ª\u0001J\u0013\u0010«\u0001\u001A\u0002012\b\u0010¬\u0001\u001A\u00030­\u0001H\u0002J\u000F\u0010²\u0001\u001A\u000201H\u0086@¢\u0006\u0002\u0010dJ\u0007\u0010³\u0001\u001A\u000201J\u0007\u0010´\u0001\u001A\u000201J \u0010À\u0001\u001A\u0002012\u000F\u0010Á\u0001\u001A\n\u0012\u0005\u0012\u00030Ã\u00010Â\u0001H\u0010¢\u0006\u0003\bÄ\u0001J\u0017\u0010Å\u0001\u001A\u0002012\u0006\u0010p\u001A\u00020\u0019H\u0010¢\u0006\u0003\bÆ\u0001J\u0017\u0010Ç\u0001\u001A\u0002012\u0006\u0010p\u001A\u00020\u0019H\u0010¢\u0006\u0003\bÈ\u0001J\u0017\u0010É\u0001\u001A\u0002012\u0006\u0010p\u001A\u00020\u0019H\u0010¢\u0006\u0003\bÊ\u0001J\u0018\u0010Ë\u0001\u001A\u0002012\u0007\u0010\u009D\u0001\u001A\u00020>H\u0010¢\u0006\u0003\bÌ\u0001J\u0018\u0010Í\u0001\u001A\u0002012\u0007\u0010Î\u0001\u001A\u00020\"H\u0010¢\u0006\u0003\bÏ\u0001J\u0018\u0010Ð\u0001\u001A\u0002012\u0007\u0010Î\u0001\u001A\u00020\"H\u0010¢\u0006\u0003\bÑ\u0001J/\u0010Ò\u0001\u001A\u0002012\u0007\u0010Î\u0001\u001A\u00020\"2\u0007\u0010Ó\u0001\u001A\u00020+2\f\u0010Ô\u0001\u001A\u0007\u0012\u0002\b\u00030Õ\u0001H\u0010¢\u0006\u0003\bÖ\u0001J\u0017\u0010×\u0001\u001A\u0002012\u0006\u0010p\u001A\u00020\u0019H\u0010¢\u0006\u0003\bØ\u0001J\u001A\u0010Ù\u0001\u001A\u0004\u0018\u00010+2\u0007\u0010Î\u0001\u001A\u00020\"H\u0010¢\u0006\u0003\bÚ\u0001R\u001E\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0007@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u00060\u0010j\u0002`\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001A\u001A\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00100\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00190\u001FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001A\b\u0012\u0004\u0012\u00020\"0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010#\u001A\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100%\u0012\u0004\u0012\u00020\"0$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u000E\u0010\'\u001A\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010)\u001A\u000E\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020+0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010,\u001A\u000E\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R\u0016\u0010-\u001A\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010.\u001A\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010/\u001A\n\u0012\u0004\u0012\u000201\u0018\u000100X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00102\u001A\u000203X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00104\u001A\u000205X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u00106\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010807X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00109\u001A\u000205X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010:\u001A\b\u0012\u0004\u0012\u00020;07X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010<\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020>\u0018\u00010\u001D0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010?\u001A\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bA\u0010BR\u0014\u0010C\u001A\u0002058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bD\u0010ER\u0014\u0010F\u001A\u0002058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bG\u0010ER\u0014\u0010H\u001A\u0002058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bI\u0010ER\u001C\u0010J\u001A\n\u0012\u0004\u0012\u00020L\u0018\u00010KX\u0082\u000E¢\u0006\b\n\u0000\u0012\u0004\bM\u0010NR\u0014\u0010Q\u001A\u0002058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bR\u0010ER \u0010S\u001A\b\u0012\u0004\u0012\u00020;0T8FX\u0087\u0004¢\u0006\f\u0012\u0004\bU\u0010N\u001A\u0004\bV\u0010WR\u0017\u0010X\u001A\b\u0012\u0004\u0012\u00020;0Y8F¢\u0006\u0006\u001A\u0004\bZ\u0010[R\u0012\u0010\\\u001A\u00060]R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010{\u001A\u0002058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b|\u0010ER\u0013\u0010®\u0001\u001A\u0002058F¢\u0006\u0007\u001A\u0005\b¯\u0001\u0010ER\u0016\u0010°\u0001\u001A\u0002058BX\u0082\u0004¢\u0006\u0007\u001A\u0005\b±\u0001\u0010ER\u001B\u0010µ\u0001\u001A\u00070\u0007j\u0003`¶\u00018PX\u0090\u0004¢\u0006\u0007\u001A\u0005\b·\u0001\u0010\nR\u0016\u0010¸\u0001\u001A\u0002058PX\u0090\u0004¢\u0006\u0007\u001A\u0005\b¹\u0001\u0010ER\u0016\u0010º\u0001\u001A\u0002058PX\u0090\u0004¢\u0006\u0007\u001A\u0005\b»\u0001\u0010ER\u0016\u0010¼\u0001\u001A\u0002058PX\u0090\u0004¢\u0006\u0007\u001A\u0005\b½\u0001\u0010ER\u0016\u0010¾\u0001\u001A\u0002058PX\u0090\u0004¢\u0006\u0007\u001A\u0005\b¿\u0001\u0010ER\u0019\u0010p\u001A\u0005\u0018\u00010Û\u00018PX\u0090\u0004¢\u0006\b\u001A\u0006\bÜ\u0001\u0010Ý\u0001¨\u0006ã\u0001"}, d2={"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "value", "", "changeCount", "getChangeCount", "()J", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "nextFrameEndCallbackQueue", "Landroidx/compose/runtime/NextFrameEndCallbackQueue;", "stateLock", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "runnerJob", "Lkotlinx/coroutines/Job;", "closeCause", "", "_knownCompositions", "", "Landroidx/compose/runtime/ControlledComposition;", "_knownCompositionsCache", "", "snapshotInvalidations", "Landroidx/collection/MutableScatterSet;", "compositionInvalidations", "Landroidx/compose/runtime/collection/MutableVector;", "compositionsAwaitingApply", "movableContentAwaitingInsert", "Landroidx/compose/runtime/MovableContentStateReference;", "movableContentRemoved", "Landroidx/compose/runtime/collection/MultiValueMap;", "Landroidx/compose/runtime/MovableContent;", "Landroidx/collection/MutableScatterMap;", "movableContentNestedStatesAvailable", "Landroidx/compose/runtime/NestedContentMap;", "movableContentStatesAvailable", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/MovableContentState;", "movableContentNestedExtractionsPending", "failedCompositions", "compositionsRemoved", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "concurrentCompositionsOutstanding", "", "isClosed", "", "errorState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "frameClockPaused", "_state", "Landroidx/compose/runtime/Recomposer$State;", "pausedScopes", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaitersLocked", "()Z", "hasNextFrameEndAwaitersLocked", "getHasNextFrameEndAwaitersLocked", "hasBroadcastFrameClockAwaiters", "getHasBroadcastFrameClockAwaiters", "registrationObservers", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;", "getRegistrationObservers$annotations", "()V", "deriveStateLocked", "onNewFrameAwaiter", "shouldKeepRecomposing", "getShouldKeepRecomposing", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "getState", "()Lkotlinx/coroutines/flow/Flow;", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "recordComposerModifications", "registerRunnerJob", "callingJob", "runRecomposeAndApplyChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processCompositionError", "e", "failedInitialComposition", "recoverable", "withTransparentSnapshot", "block", "Lkotlin/Function0;", "knownCompositions", "knownCompositionsLocked", "clearKnownCompositionsLocked", "removeKnownCompositionLocked", "composition", "addKnownCompositionLocked", "registerCompositionLocked", "unregisterCompositionLocked", "addCompositionRegistrationObserver", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "addCompositionRegistrationObserver$runtime", "resetErrorState", "retryFailedCompositions", "recordFailedCompositionLocked", "hasSchedulingWork", "getHasSchedulingWork", "awaitWorkAvailable", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "close", "join", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "composeInitial", "content", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitialPaused", "Landroidx/collection/ScatterSet;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "composeInitialPaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Lkotlin/jvm/functions/Function2;)Landroidx/collection/ScatterSet;", "recomposePaused", "invalidScopes", "recomposePaused$runtime", "reportPausedScope", "scope", "reportPausedScope$runtime", "performInitialMovableContentInserts", "performRecompose", "modifiedValues", "performInsertValues", "references", "discardUnusedMovableContentState", "readObserverOf", "Lkotlin/Function1;", "writeObserverOf", "composing", "T", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "hasPendingWork", "getHasPendingWork", "hasFrameWorkLocked", "getHasFrameWorkLocked", "awaitIdle", "pauseCompositionFrameClock", "resumeCompositionFrameClock", "compositeKeyHashCode", "Landroidx/compose/runtime/CompositeKeyHashCode;", "getCompositeKeyHashCode$runtime", "collectingCallByInformation", "getCollectingCallByInformation$runtime", "collectingParameterInformation", "getCollectingParameterInformation$runtime", "collectingSourceInformation", "getCollectingSourceInformation$runtime", "stackTraceEnabled", "getStackTraceEnabled$runtime", "recordInspectionTable", "table", "", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime", "registerComposition", "registerComposition$runtime", "unregisterComposition", "unregisterComposition$runtime", "invalidate", "invalidate$runtime", "invalidateScope", "invalidateScope$runtime", "insertMovableContent", "reference", "insertMovableContent$runtime", "deletedMovableContent", "deletedMovableContent$runtime", "movableContentStateReleased", "data", "applier", "Landroidx/compose/runtime/Applier;", "movableContentStateReleased$runtime", "reportRemovedComposition", "reportRemovedComposition$runtime", "movableContentStateResolve", "movableContentStateResolve$runtime", "Landroidx/compose/runtime/Composition;", "getComposition$runtime", "()Landroidx/compose/runtime/Composition;", "State", "RecomposerInfoImpl", "HotReloadable", "RecomposerErrorState", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Recomposer extends CompositionContext {
    @Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u000BH\u0000¢\u0006\u0002\b\u0017J\u0014\u0010\u0018\u001A\u00020\u00152\n\u0010\u0019\u001A\u00060\u0007R\u00020\bH\u0002J\u0014\u0010\u001A\u001A\u00020\u00152\n\u0010\u0019\u001A\u00060\u0007R\u00020\bH\u0002J\r\u0010\u001B\u001A\u00020\u0001H\u0000¢\u0006\u0002\b\u001CJ\u0015\u0010\u001D\u001A\u00020\u00152\u0006\u0010\u001E\u001A\u00020\u0001H\u0000¢\u0006\u0002\b\u001FJ\u0015\u0010 \u001A\u00020\u00152\u0006\u0010!\u001A\u00020\"H\u0000¢\u0006\u0002\b#J\u0013\u0010$\u001A\b\u0012\u0004\u0012\u00020&0%H\u0000¢\u0006\u0002\b\'J\u0013\u0010(\u001A\b\u0012\u0004\u0012\u00020)0%H\u0000¢\u0006\u0002\b*J\r\u0010+\u001A\u00020\u0015H\u0000¢\u0006\u0002\b,R\u001E\u0010\u0004\u001A\u0012\u0012\u000E\u0012\f\u0012\b\u0012\u00060\u0007R\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001A\u0012\u0012\u0004\u0012\u00020\u000B0\nj\b\u0012\u0004\u0012\u00020\u000B`\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001D\u0010\u000E\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000F8F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006-"}, d2={"Landroidx/compose/runtime/Recomposer$Companion;", "", "<init>", "()V", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "setHotReloadEnabled", "", "value", "setHotReloadEnabled$runtime", "addRunning", "info", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime", "getRecomposerErrors", "Landroidx/compose/runtime/RecomposerErrorInformation;", "getRecomposerErrors$runtime", "clearErrors", "clearErrors$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final void access$addRunning(Companion arg0, RecomposerInfoImpl arg1) {
            arg0.addRunning(arg1);
        }

        public static final void access$removeRunning(Companion arg0, RecomposerInfoImpl arg1) {
            arg0.removeRunning(arg1);
        }

        private final void addRunning(RecomposerInfoImpl arg3) {
            do {
                Object v2 = Recomposer._runningRecomposers.getValue();
                PersistentSet v0 = ((PersistentSet)v2).add(arg3);
                if(v2 == v0) {
                    return;
                }
            }
            while(!Recomposer._runningRecomposers.compareAndSet(v2, v0));
        }

        public final void clearErrors$runtime() {
            Object v2 = Recomposer._runningRecomposers.getValue();
            ArrayList v0 = new ArrayList();
            Iterator v2_1 = ((Iterable)v2).iterator();
            while(v2_1.hasNext()) {
                RecomposerErrorState v1 = v2_1.next().resetErrorState();
                if(v1 == null) {
                    continue;
                }

                ((Collection)v0).add(v1);
            }
        }

        public final List getCurrentErrors$runtime() {
            Object v3 = Recomposer._runningRecomposers.getValue();
            ArrayList v0 = new ArrayList();
            Iterator v3_1 = ((Iterable)v3).iterator();
            while(v3_1.hasNext()) {
                RecomposerErrorInformation v1 = v3_1.next().getCurrentError();
                if((v1 instanceof RecomposerErrorInfo)) {
                }
                else {
                    v1 = null;
                }

                if(v1 == null) {
                    continue;
                }

                ((Collection)v0).add(v1);
            }

            return ((List)v0);
        }

        public final List getRecomposerErrors$runtime() {
            Object v2 = Recomposer._runningRecomposers.getValue();
            ArrayList v0 = new ArrayList();
            Iterator v2_1 = ((Iterable)v2).iterator();
            while(v2_1.hasNext()) {
                RecomposerErrorInformation v1 = v2_1.next().getCurrentError();
                if(v1 == null) {
                    continue;
                }

                ((Collection)v0).add(v1);
            }

            return ((List)v0);
        }

        public final StateFlow getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void invalidateGroupsWithKey$runtime(int arg3) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(true));
            Iterator v2 = Recomposer._runningRecomposers.getValue().iterator();
            while(v2.hasNext()) {
                Object v0 = v2.next();
                RecomposerErrorInformation v1 = ((RecomposerInfoImpl)v0).getCurrentError();
                if(v1 != null && !v1.isRecoverable()) {
                    continue;
                }

                ((RecomposerInfoImpl)v0).resetErrorState();
                ((RecomposerInfoImpl)v0).invalidateGroupsWithKey(arg3);
                ((RecomposerInfoImpl)v0).retryFailedCompositions();
            }
        }

        public final void loadStateAndComposeForHotReload$runtime(Object arg5) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(true));
            Iterator v4 = Recomposer._runningRecomposers.getValue().iterator();
            while(v4.hasNext()) {
                v4.next().resetErrorState();
            }

            Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.runtime.Recomposer.HotReloadable>");
            Object v4_1 = arg5;
            int v0 = ((Collection)v4_1).size();
            int v1 = 0;
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                ((List)arg5).get(v2).resetContent();
            }

            int v4_2 = ((Collection)v4_1).size();
            while(v1 < v4_2) {
                ((List)arg5).get(v1).recompose();
                ++v1;
            }

            v4 = Recomposer._runningRecomposers.getValue().iterator();
            while(v4.hasNext()) {
                v4.next().retryFailedCompositions();
            }
        }

        private final void removeRunning(RecomposerInfoImpl arg3) {
            do {
                Object v2 = Recomposer._runningRecomposers.getValue();
                PersistentSet v0 = ((PersistentSet)v2).remove(arg3);
                if(v2 == v0) {
                    return;
                }
            }
            while(!Recomposer._runningRecomposers.compareAndSet(v2, v0));
        }

        public final Object saveStateAndDisposeForHotReload$runtime() {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(true));
            Object v2 = Recomposer._runningRecomposers.getValue();
            ArrayList v0 = new ArrayList();
            Iterator v2_1 = ((Iterable)v2).iterator();
            while(v2_1.hasNext()) {
                CollectionsKt.addAll(((Collection)v0), v2_1.next().saveStateAndDisposeForHotReload());
            }

            return v0;
        }

        public final void setHotReloadEnabled$runtime(boolean arg1) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(arg1));
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000B\u001A\u00020\bJ\u0006\u0010\f\u001A\u00020\bJ\u0006\u0010\r\u001A\u00020\bR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001B\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "<init>", "(Landroidx/compose/runtime/CompositionImpl;)V", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "resetContent", "recompose", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class HotReloadable {
        private Function2 composable;
        private final CompositionImpl composition;

        public HotReloadable(CompositionImpl arg1) {
            super();
            this.composition = arg1;
            this.composable = arg1.getComposable();
        }

        public final void clearContent() {
            if(this.composition.isRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.getLambda$-1091980426$runtime());
            }
        }

        public final void recompose() {
            if(this.composition.isRoot()) {
                this.composition.setContent(this.composable);
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }
    }

    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001A\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u000BR\u0014\u0010\f\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000B¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "Landroidx/compose/runtime/RecomposerErrorInformation;", "cause", "", "isRecoverable", "", "<init>", "(Ljava/lang/Throwable;Z)V", "getCause", "()Ljava/lang/Throwable;", "()Z", "recoverable", "getRecoverable", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class RecomposerErrorState implements RecomposerErrorInfo, RecomposerErrorInformation {
        private final Throwable cause;
        private final boolean isRecoverable;

        public RecomposerErrorState(Throwable arg1, boolean arg2) {
            super();
            this.cause = arg1;
            this.isRecoverable = arg2;
        }

        public Throwable getCause() {
            return this.cause;
        }

        public boolean getRecoverable() {
            return this.isRecoverable();
        }

        public boolean isRecoverable() {
            return this.isRecoverable;
        }
    }

    @Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001FH\u0016J\u000E\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#J\f\u0010$\u001A\b\u0012\u0004\u0012\u00020&0%J\b\u0010\'\u001A\u0004\u0018\u00010(J\u0006\u0010)\u001A\u00020!R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\"\u0010\u0011\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u001C\u0010\u0018\u001A\u0004\u0018\u00010\u00138FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0015\u001A\u0004\b\u001A\u0010\u001B¨\u0006*"}, d2={"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "<init>", "(Landroidx/compose/runtime/Recomposer;)V", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "hasPendingWork", "", "getHasPendingWork", "()Z", "changeCount", "", "getChangeCount", "()J", "errorState", "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/compose/runtime/RecomposerErrorInformation;", "getErrorState$annotations", "()V", "getErrorState", "()Lkotlinx/coroutines/flow/StateFlow;", "currentError", "getCurrentError$annotations", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInformation;", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionRegistrationObserver;", "invalidateGroupsWithKey", "", "key", "", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl(Recomposer arg1) {
            Recomposer.this = arg1;
            super();
        }

        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        public final RecomposerErrorInformation getCurrentError() {
            Object v0 = Recomposer.this.stateLock;
            Recomposer v1 = Recomposer.this;
            __monitor_enter(v0);
            try {
                __monitor_exit(v0);
                return v1.errorState.getValue();
            }
            catch(Throwable v1_1) {
                __monitor_exit(v0);
                throw v1_1;
            }
        }

        public static void getCurrentError$annotations() {
        }

        public StateFlow getErrorState() {
            return Recomposer.this.errorState;
        }

        public static void getErrorState$annotations() {
        }

        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        public Flow getState() {
            return Recomposer.this.getCurrentState();
        }

        public final void invalidateGroupsWithKey(int arg7) {
            List v6 = Recomposer.this.knownCompositions();
            ArrayList v0 = new ArrayList(v6.size());
            int v1 = v6.size();
            int v2 = 0;
            int v3;
            for(v3 = 0; v3 < v1; ++v3) {
                Object v4 = v6.get(v3);
                if((v4 instanceof CompositionImpl)) {
                }
                else {
                    v4 = null;
                }

                if(v4 != null) {
                    v0.add(v4);
                }
            }

            int v6_1 = v0.size();
            while(v2 < v6_1) {
                ((List)v0).get(v2).invalidateGroupsWithKey(arg7);
                ++v2;
            }
        }

        public CompositionObserverHandle observe(CompositionRegistrationObserver arg1) {
            return CompositionObserverKt.observe(Recomposer.this, arg1);
        }

        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }

        public final List saveStateAndDisposeForHotReload() {
            List v6 = Recomposer.this.knownCompositions();
            ArrayList v0 = new ArrayList(v6.size());
            int v1 = v6.size();
            int v2 = 0;
            int v3;
            for(v3 = 0; v3 < v1; ++v3) {
                Object v4 = v6.get(v3);
                if((v4 instanceof CompositionImpl)) {
                }
                else {
                    v4 = null;
                }

                if(v4 != null) {
                    v0.add(v4);
                }
            }

            ArrayList v6_1 = new ArrayList(((List)v0).size());
            v1 = v0.size();
            while(v2 < v1) {
                HotReloadable v5 = new HotReloadable(((List)v0).get(v2));
                v5.clearContent();
                v6_1.add(v5);
                ++v2;
            }

            return ((List)v6_1);
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2={"Landroidx/compose/runtime/Recomposer$State;", "", "<init>", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public enum State {
        public static final enum State Idle;
        public static final enum State Inactive;
        public static final enum State InactivePendingWork;
        public static final enum State PendingWork;
        public static final enum State ShutDown;
        public static final enum State ShuttingDown;

        private static final State[] $values() {
            return new State[]{State.ShutDown, State.ShuttingDown, State.Inactive, State.InactivePendingWork, State.Idle, State.PendingWork};
        }

        static {
            State.ShutDown = new State("ShutDown", 0);
            State.ShuttingDown = new State("ShuttingDown", 1);
            State.Inactive = new State("Inactive", 2);
            State.InactivePendingWork = new State("InactivePendingWork", 3);
            State.Idle = new State("Idle", 4);
            State.PendingWork = new State("PendingWork", 5);
            State[] v0 = State.$values();
            State.$VALUES = v0;
            State.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private State(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return State.$ENTRIES;
        }

        public static State valueOf(String arg1) {
            return Enum.valueOf(State.class, arg1);
        }

        public static State[] values() {
            return State.$VALUES.clone();
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final AtomicReference _hotReloadEnabled;
    private final List _knownCompositions;
    private List _knownCompositionsCache;
    private static final MutableStateFlow _runningRecomposers;
    private final MutableStateFlow _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final MutableVector compositionInvalidations;
    private final List compositionsAwaitingApply;
    private MutableScatterSet compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private MutableStateFlow errorState;
    private List failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final List movableContentAwaitingInsert;
    private final MutableScatterMap movableContentNestedExtractionsPending;
    private final NestedContentMap movableContentNestedStatesAvailable;
    private final MutableScatterMap movableContentRemoved;
    private final MutableScatterMap movableContentStatesAvailable;
    private final NextFrameEndCallbackQueue nextFrameEndCallbackQueue;
    private final SnapshotThreadLocal pausedScopes;
    private final RecomposerInfoImpl recomposerInfo;
    private MutableObjectList registrationObservers;
    private Job runnerJob;
    private MutableScatterSet snapshotInvalidations;
    private final Object stateLock;
    private CancellableContinuation workContinuation;

    public static Unit $r8$lambda$eceaQSYc82y9aBBnViExjN4bA40(MutableScatterSet arg0, ControlledComposition arg1) {
        return Recomposer.performRecompose$lambda$0$0(arg0, arg1);
    }

    public static Unit $r8$lambda$jmcZyV8LtsSic2EMN7b9F59xiVM(Recomposer arg0, Throwable arg1, Throwable arg2) {
        return Recomposer.effectJob$lambda$0$0$0$0(arg0, arg1, arg2);
    }

    public static Unit $r8$lambda$pPhCxr3Z23Vutd2UklWUunXH7fY(Recomposer arg0, Throwable arg1) {
        return Recomposer.effectJob$lambda$0$0(arg0, arg1);
    }

    static {
        Recomposer.Companion = new Companion(null);
        Recomposer.$stable = 8;
        Recomposer._runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
        Recomposer._hotReloadEnabled = new AtomicReference(Boolean.valueOf(false));
    }

    public Recomposer(CoroutineContext arg7) {
        super();
        BroadcastFrameClock v0 = new BroadcastFrameClock(new Recomposer$$ExternalSyntheticLambda2(this));
        this.broadcastFrameClock = v0;
        this.nextFrameEndCallbackQueue = new NextFrameEndCallbackQueue(new Recomposer$$ExternalSyntheticLambda3(this));
        this.stateLock = new Object();
        this._knownCompositions = new ArrayList();
        this.snapshotInvalidations = new MutableScatterSet(0, 1, null);
        this.compositionInvalidations = new MutableVector(new ControlledComposition[16], 0);
        this.compositionsAwaitingApply = new ArrayList();
        this.movableContentAwaitingInsert = new ArrayList();
        this.movableContentRemoved = MultiValueMap.constructor-impl$default(null, 1, null);
        this.movableContentNestedStatesAvailable = new NestedContentMap();
        this.movableContentStatesAvailable = ScatterMapKt.mutableScatterMapOf();
        this.movableContentNestedExtractionsPending = MultiValueMap.constructor-impl$default(null, 1, null);
        this.errorState = StateFlowKt.MutableStateFlow(null);
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        this.pausedScopes = new SnapshotThreadLocal();
        CompletableJob v1 = JobKt.Job(arg7.get(Job.Key));
        v1.invokeOnCompletion(new Recomposer$$ExternalSyntheticLambda4(this));
        this.effectJob = v1;
        this.effectCoroutineContext = arg7.plus(((CoroutineContext)v0)).plus(((CoroutineContext)v1));
        this.recomposerInfo = new RecomposerInfoImpl(this);
    }

    public static final Object access$awaitWorkAvailable(Recomposer arg0, Continuation arg1) {
        return arg0.awaitWorkAvailable(arg1);
    }

    public static final CancellableContinuation access$deriveStateLocked(Recomposer arg0) {
        return arg0.deriveStateLocked();
    }

    public static final void access$discardUnusedMovableContentState(Recomposer arg0) {
        arg0.discardUnusedMovableContentState();
    }

    public static final BroadcastFrameClock access$getBroadcastFrameClock$p(Recomposer arg0) {
        return arg0.broadcastFrameClock;
    }

    public static final MutableVector access$getCompositionInvalidations$p(Recomposer arg0) {
        return arg0.compositionInvalidations;
    }

    public static final MutableStateFlow access$getErrorState$p(Recomposer arg0) {
        return arg0.errorState;
    }

    public static final boolean access$getHasBroadcastFrameClockAwaiters(Recomposer arg0) {
        return arg0.getHasBroadcastFrameClockAwaiters();
    }

    public static final boolean access$getHasSchedulingWork(Recomposer arg0) {
        return arg0.getHasSchedulingWork();
    }

    public static final List access$getMovableContentAwaitingInsert$p(Recomposer arg0) {
        return arg0.movableContentAwaitingInsert;
    }

    public static final NextFrameEndCallbackQueue access$getNextFrameEndCallbackQueue$p(Recomposer arg0) {
        return arg0.nextFrameEndCallbackQueue;
    }

    public static final RecomposerInfoImpl access$getRecomposerInfo$p(Recomposer arg0) {
        return arg0.recomposerInfo;
    }

    public static final MutableObjectList access$getRegistrationObservers$p(Recomposer arg0) {
        return arg0.registrationObservers;
    }

    public static final Job access$getRunnerJob$p(Recomposer arg0) {
        return arg0.runnerJob;
    }

    public static final boolean access$getShouldKeepRecomposing(Recomposer arg0) {
        return arg0.getShouldKeepRecomposing();
    }

    public static final MutableScatterSet access$getSnapshotInvalidations$p(Recomposer arg0) {
        return arg0.snapshotInvalidations;
    }

    public static final Object access$getStateLock$p(Recomposer arg0) {
        return arg0.stateLock;
    }

    public static final AtomicReference access$get_hotReloadEnabled$cp() {
        return Recomposer._hotReloadEnabled;
    }

    public static final MutableStateFlow access$get_runningRecomposers$cp() {
        return Recomposer._runningRecomposers;
    }

    public static final MutableStateFlow access$get_state$p(Recomposer arg0) {
        return arg0._state;
    }

    public static final List access$knownCompositions(Recomposer arg0) {
        return arg0.knownCompositions();
    }

    public static final List access$knownCompositionsLocked(Recomposer arg0) {
        return arg0.knownCompositionsLocked();
    }

    public static final List access$performInsertValues(Recomposer arg0, List arg1, MutableScatterSet arg2) {
        return arg0.performInsertValues(arg1, arg2);
    }

    public static final ControlledComposition access$performRecompose(Recomposer arg0, ControlledComposition arg1, MutableScatterSet arg2) {
        return arg0.performRecompose(arg1, arg2);
    }

    public static final Object access$recompositionRunner(Recomposer arg0, Function3 arg1, Continuation arg2) {
        return arg0.recompositionRunner(arg1, arg2);
    }

    public static final boolean access$recordComposerModifications(Recomposer arg0) {
        return arg0.recordComposerModifications();
    }

    public static final void access$recordFailedCompositionLocked(Recomposer arg0, ControlledComposition arg1) {
        arg0.recordFailedCompositionLocked(arg1);
    }

    public static final void access$registerRunnerJob(Recomposer arg0, Job arg1) {
        arg0.registerRunnerJob(arg1);
    }

    public static final RecomposerErrorState access$resetErrorState(Recomposer arg0) {
        return arg0.resetErrorState();
    }

    public static final void access$retryFailedCompositions(Recomposer arg0) {
        arg0.retryFailedCompositions();
    }

    public static final void access$setChangeCount$p(Recomposer arg0, long arg1) {
        arg0.changeCount = arg1;
    }

    public static final void access$setCompositionsRemoved$p(Recomposer arg0, MutableScatterSet arg1) {
        arg0.compositionsRemoved = arg1;
    }

    public static final void access$setRunnerJob$p(Recomposer arg0, Job arg1) {
        arg0.runnerJob = arg1;
    }

    public static final void access$setWorkContinuation$p(Recomposer arg0, CancellableContinuation arg1) {
        arg0.workContinuation = arg1;
    }

    public final CompositionObserverHandle addCompositionRegistrationObserver$runtime(CompositionRegistrationObserver arg7) {
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            MutableObjectList v1 = this.registrationObservers;
            int v2 = 0;
            if(v1 == null) {
                v1 = new MutableObjectList(0, 1, null);
                this.registrationObservers = v1;
            }

            v1.add(arg7);
            List v1_1 = this._knownCompositions;
            int v3 = v1_1.size();
            while(v2 < v3) {
                Object v4 = v1_1.get(v2);
                if((v4 instanceof ObservableComposition)) {
                    arg7.onCompositionRegistered(((ObservableComposition)v4));
                }

                ++v2;
            }
        }
        catch(Throwable v6) {
            goto label_27;
        }

        __monitor_exit(v0);
        return new Recomposer$addCompositionRegistrationObserver$2(this, arg7);
    label_27:
        __monitor_exit(v0);
        throw v6;
    }

    private final void addKnownCompositionLocked(ControlledComposition arg2) {
        this._knownCompositions.add(arg2);
        this._knownCompositionsCache = null;
    }

    private final void applyAndCheck(MutableSnapshot arg2) {
        try {
            if((arg2.apply() instanceof Failure)) {
                goto label_5;
            }
        }
        catch(Throwable v1) {
            goto label_11;
        }

        arg2.dispose();
        return;
        try {
        label_5:
            throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
        }
        catch(Throwable v1) {
        label_11:
            arg2.dispose();
            throw v1;
        }
    }

    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    public final Object awaitIdle(Continuation arg3) {
        Object v2 = FlowKt.collect(FlowKt.takeWhile(this.getCurrentState(), new Recomposer$awaitIdle$2(null)), arg3);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    private final Object awaitWorkAvailable(Continuation arg5) {
        if(!this.getHasSchedulingWork()) {
            CancellableContinuationImpl v0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(arg5), 1);
            v0.initCancellability();
            CancellableContinuationImpl v1 = v0;
            Object v2 = this.stateLock;
            __monitor_enter(v2);
            try {
                if(this.getHasSchedulingWork()) {
                }
                else {
                    this.workContinuation = ((CancellableContinuation)v1);
                    v1 = null;
                }
            }
            catch(Throwable v4) {
                __monitor_exit(v2);
                throw v4;
            }

            __monitor_exit(v2);
            if(v1 != null) {
                ((Continuation)v1).resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }

            Object v4_1 = v0.getResult();
            if(v4_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(arg5);
            }

            if(v4_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v4_1;
            }

            return Unit.INSTANCE;
        }

        return Unit.INSTANCE;
    }

    static final Unit broadcastFrameClock$lambda$0(Recomposer arg0) {
        arg0.onNewFrameAwaiter();
        return Unit.INSTANCE;
    }

    public final void cancel() {
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            if(this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
        DefaultImpls.cancel$default(this.effectJob, null, 1, null);
    }

    private final void clearKnownCompositionsLocked() {
        List v0 = this.knownCompositionsLocked();
        int v1 = v0.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            this.unregisterCompositionLocked(v0.get(v2));
        }

        this._knownCompositions.clear();
        this._knownCompositionsCache = CollectionsKt.emptyList();
    }

    public final void close() {
        if(this.effectJob.complete()) {
            Object v0 = this.stateLock;
            __monitor_enter(v0);
            try {
                this.isClosed = true;
            }
            catch(Throwable v2) {
                __monitor_exit(v0);
                throw v2;
            }

            __monitor_exit(v0);
            return;
        }
    }

    public void composeInitial$runtime(ControlledComposition arg8, Function2 arg9) {
        Snapshot v5;
        MutableSnapshot v2_1;
        MutableSnapshot v1_1;
        int v4;
        boolean v0 = arg8.isComposing();
        Object v1 = this.stateLock;
        __monitor_enter(v1);
        try {
            if(this._state.getValue().compareTo(State.ShuttingDown) > 0) {
                boolean v2 = this.knownCompositionsLocked().contains(arg8);
                v4 = (((int)v2)) ^ 1;
                if(!v2) {
                    this.registerCompositionLocked(arg8);
                }
            }
            else {
                goto label_15;
            }

            goto label_16;
        }
        catch(Throwable v0_1) {
            __monitor_exit(v1);
            throw v0_1;
        }

    label_15:
        v4 = 1;
    label_16:
        __monitor_exit(v1);
        try {
            v1_1 = Snapshot.Companion.takeMutableSnapshot(this.readObserverOf(arg8), this.writeObserverOf(arg8, null));
        }
        catch(Throwable v0_1) {
            goto label_80;
        }

        try {
            v2_1 = v1_1;
            v5 = ((Snapshot)v2_1).makeCurrent();
        }
        catch(Throwable v0_1) {
            goto label_76;
        }

        try {
            arg8.composeContent(arg9);
            goto label_26;
        }
        catch(Throwable v0_1) {
            Throwable v9 = v0_1;
            try {
                ((Snapshot)v2_1).restoreCurrent(v5);
                throw v9;
            label_26:
                ((Snapshot)v2_1).restoreCurrent(v5);
                goto label_27;
            }
            catch(Throwable v0_1) {
            label_76:
                v9 = v0_1;
                try {
                    this.applyAndCheck(v1_1);
                    throw v9;
                label_27:
                    this.applyAndCheck(v1_1);
                }
                catch(Throwable v0_1) {
                label_80:
                    v9 = v0_1;
                    if(v4 != 0) {
                        v1 = this.stateLock;
                        __monitor_enter(v1);
                        try {
                            this.unregisterCompositionLocked(arg8);
                        }
                        catch(Throwable v0_1) {
                            __monitor_exit(v1);
                            throw v0_1;
                        }

                        __monitor_exit(v1);
                    }

                    this.processCompositionError(v9, arg8, true);
                    return;
                }
            }
        }

        Object v9_1 = this.stateLock;
        __monitor_enter(v9_1);
        try {
            if(this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                this.unregisterCompositionLocked(arg8);
            }
            else if(!this.knownCompositionsLocked().contains(arg8)) {
                this.addKnownCompositionLocked(arg8);
            }
        }
        catch(Throwable v0_1) {
            __monitor_exit(v9_1);
            throw v0_1;
        }

        __monitor_exit(v9_1);
        if(!v0) {
            Snapshot.Companion.notifyObjectsInitialized();
        }

        try {
            this.performInitialMovableContentInserts(arg8);
        }
        catch(Throwable v0_1) {
            this.processCompositionError(v0_1, arg8, true);
            return;
        }

        try {
            arg8.applyChanges();
            arg8.applyLateChanges();
            if(v0) {
                return;
            }
        }
        catch(Throwable v0_1) {
            Recomposer.processCompositionError$default(this, v0_1, null, false, 6, null);
            return;
        }

        Snapshot.Companion.notifyObjectsInitialized();
    }

    public ScatterSet composeInitialPaused$runtime(ControlledComposition arg2, ShouldPauseCallback arg3, Function2 arg4) {
        Object v4_1;
        Object v0 = null;
        try {
            arg3 = arg2.getAndSetShouldPauseCallback(arg3);
        }
        catch(Throwable v2) {
            goto label_17;
        }

        try {
            this.composeInitial$runtime(arg2, arg4);
            v4_1 = this.pausedScopes.get();
            if(v4_1 != null) {
            }
            else {
                ScatterSet v4_2 = ScatterSetKt.emptyScatterSet();
            }

            goto label_8;
        }
        catch(Throwable v4) {
            try {
                arg2.getAndSetShouldPauseCallback(arg3);
                throw v4;
            label_8:
                arg2.getAndSetShouldPauseCallback(arg3);
            }
            catch(Throwable v2) {
            label_17:
                this.pausedScopes.set(v0);
                throw v2;
            }
        }

        this.pausedScopes.set(v0);
        return ((ScatterSet)v4_1);
    }

    private final Object composing(ControlledComposition arg3, MutableScatterSet arg4, Function0 arg5) {
        Object v5_1;
        Snapshot v0;
        MutableSnapshot v4_1;
        MutableSnapshot v3 = Snapshot.Companion.takeMutableSnapshot(this.readObserverOf(arg3), this.writeObserverOf(arg3, arg4));
        try {
            v4_1 = v3;
            v0 = ((Snapshot)v4_1).makeCurrent();
        }
        catch(Throwable v4) {
            goto label_14;
        }

        try {
            v5_1 = arg5.invoke();
            goto label_7;
        }
        catch(Throwable v5) {
            try {
                ((Snapshot)v4_1).restoreCurrent(v0);
                throw v5;
            label_7:
                ((Snapshot)v4_1).restoreCurrent(v0);
            }
            catch(Throwable v4) {
            label_14:
                this.applyAndCheck(v3);
                throw v4;
            }
        }

        this.applyAndCheck(v3);
        return v5_1;
    }

    private static final void deletedMovableContent$lambda$0$recordNestedStatesOf(Recomposer arg6, MovableContentStateReference arg7, MovableContentStateReference arg8) {
        List v8 = arg8.getNestedReferences$runtime();
        if(v8 != null) {
            int v0 = v8.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                Object v2 = v8.get(v1);
                arg6.movableContentNestedStatesAvailable.add(((MovableContentStateReference)v2).getContent$runtime(), new NestedMovableContent(((MovableContentStateReference)v2), arg7));
                Recomposer.deletedMovableContent$lambda$0$recordNestedStatesOf(arg6, arg7, ((MovableContentStateReference)v2));
            }
        }
    }

    public void deletedMovableContent$runtime(MovableContentStateReference arg4) {
        CancellableContinuation v3_1;
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            MultiValueMap.add-impl(this.movableContentRemoved, arg4.getContent$runtime(), arg4);
            if(arg4.getNestedReferences$runtime() != null) {
                Recomposer.deletedMovableContent$lambda$0$recordNestedStatesOf(this, arg4, arg4);
            }

            v3_1 = this.deriveStateLocked();
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
        if(v3_1 != null) {
            ((Continuation)v3_1).resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
    }

    private final CancellableContinuation deriveStateLocked() {
        State v0_1;
        CancellableContinuation v0;
        DefaultConstructorMarker v3 = null;
        if(this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            this.clearKnownCompositionsLocked();
            this.snapshotInvalidations = new MutableScatterSet(0, 1, v3);
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.movableContentAwaitingInsert.clear();
            this.failedCompositions = ((List)v3);
            v0 = this.workContinuation;
            if(v0 != null) {
                kotlinx.coroutines.CancellableContinuation$DefaultImpls.cancel$default(v0, ((Throwable)v3), 1, v3);
            }

            this.workContinuation = ((CancellableContinuation)v3);
            this.errorState.setValue(v3);
            return ((CancellableContinuation)v3);
        }

        if(this.errorState.getValue() != null) {
            v0_1 = State.Inactive;
        }
        else if(this.runnerJob == null) {
            this.snapshotInvalidations = new MutableScatterSet(0, 1, v3);
            this.compositionInvalidations.clear();
            if(!this.getHasBroadcastFrameClockAwaitersLocked()) {
                if(this.getHasNextFrameEndAwaitersLocked()) {
                }
                else {
                    v0_1 = State.Inactive;
                    goto label_73;
                }
            }

            v0_1 = State.InactivePendingWork;
        }
        else {
            if(this.compositionInvalidations.getSize() != 0) {
            }
            else if(!this.snapshotInvalidations.isNotEmpty() && (this.compositionsAwaitingApply.isEmpty()) && (this.movableContentAwaitingInsert.isEmpty()) && this.concurrentCompositionsOutstanding <= 0 && !this.getHasBroadcastFrameClockAwaitersLocked() && !this.getHasNextFrameEndAwaitersLocked()) {
                if(MultiValueMap.isNotEmpty-impl(this.movableContentRemoved)) {
                }
                else {
                    v0_1 = State.Idle;
                    goto label_73;
                }
            }

            v0_1 = State.PendingWork;
        }

    label_73:
        this._state.setValue(v0_1);
        if(v0_1 == State.PendingWork) {
            v0 = this.workContinuation;
            this.workContinuation = ((CancellableContinuation)v3);
            return v0;
        }

        return ((CancellableContinuation)v3);
    }

    private final void discardUnusedMovableContentState() {
        MutableObjectList v3;
        int v2;
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            v2 = 0;
            if(MultiValueMap.isNotEmpty-impl(this.movableContentRemoved)) {
                ObjectList v1 = MultiValueMap.values-impl(this.movableContentRemoved);
                MultiValueMap.clear-impl(this.movableContentRemoved);
                this.movableContentNestedStatesAvailable.clear();
                MultiValueMap.clear-impl(this.movableContentNestedExtractionsPending);
                v3 = new MutableObjectList(v1.getSize());
                Object[] v4 = v1.content;
                int v1_1 = v1._size;
                int v5;
                for(v5 = 0; v5 < v1_1; ++v5) {
                    v3.add(TuplesKt.to(v4[v5], this.movableContentStatesAvailable.get(v4[v5])));
                }

                this.movableContentStatesAvailable.clear();
            }
            else {
                ObjectList v3_1 = ObjectListKt.emptyObjectList();
            }
        }
        catch(Throwable v8) {
            __monitor_exit(v0);
            throw v8;
        }

        __monitor_exit(v0);
        Object[] v8_1 = ((ObjectList)v3).content;
        int v0_1 = ((ObjectList)v3)._size;
        while(v2 < v0_1) {
            Object v1_2 = v8_1[v2];
            Object v3_2 = ((Pair)v1_2).component1();
            v1_2 = ((Pair)v1_2).component2();
            if(v1_2 != null) {
                ((MovableContentStateReference)v3_2).getComposition$runtime().disposeUnusedMovableContent(((MovableContentState)v1_2));
            }

            ++v2;
        }
    }

    private static final Unit effectJob$lambda$0$0(Recomposer arg6, Throwable arg7) {
        CancellableContinuation v0_1;
        CancellableContinuation v3;
        CancellationException v0 = ExceptionsKt.CancellationException("Recomposer effect job completed", arg7);
        Object v1 = arg6.stateLock;
        __monitor_enter(v1);
        try {
            Job v2 = arg6.runnerJob;
            v3 = null;
            if(v2 != null) {
                arg6._state.setValue(State.ShuttingDown);
                if(!arg6.isClosed) {
                    v2.cancel(v0);
                    goto label_17;
                }
                else {
                    v0_1 = arg6.workContinuation;
                    if(v0_1 != null) {
                    }
                    else {
                    label_17:
                        v0_1 = v3;
                    }
                }

                arg6.workContinuation = v3;
                v2.invokeOnCompletion(new Recomposer$$ExternalSyntheticLambda0(arg6, arg7));
                v3 = v0_1;
            }
            else {
                arg6.closeCause = ((Throwable)v0);
                arg6._state.setValue(State.ShutDown);
            }
        }
        catch(Throwable v6) {
            __monitor_exit(v1);
            throw v6;
        }

        __monitor_exit(v1);
        if(v3 != null) {
            ((Continuation)v3).resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }

        return Unit.INSTANCE;
    }

    private static final Unit effectJob$lambda$0$0$0$0(Recomposer arg3, Throwable arg4, Throwable arg5) {
        Object v0 = arg3.stateLock;
        __monitor_enter(v0);
        Throwable v1 = null;
        if(arg4 == null) {
            goto label_12;
        }
        else if(arg5 != null) {
            try {
                if(!(arg5 instanceof CancellationException)) {
                }
                else {
                    arg5 = v1;
                }

                if(arg5 == null) {
                }
                else {
                    kotlin.ExceptionsKt.addSuppressed(arg4, arg5);
                    goto label_13;
                label_12:
                    arg4 = v1;
                }

            label_13:
                arg3.closeCause = arg4;
                arg3._state.setValue(State.ShutDown);
                goto label_18;
            }
            catch(Throwable v3) {
                __monitor_exit(v0);
                throw v3;
            }
        }

        goto label_13;
    label_18:
        __monitor_exit(v0);
        return Unit.INSTANCE;
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    public boolean getCollectingCallByInformation$runtime() {
        return Recomposer._hotReloadEnabled.get().booleanValue();
    }

    public boolean getCollectingParameterInformation$runtime() {
        return 0;
    }

    public boolean getCollectingSourceInformation$runtime() {
        return ComposeStackTraceMode.equals-impl0(ComposerKt.getComposeStackTraceMode(), ComposeStackTraceMode.Companion.getSourceInformation-MD5MrJc());
    }

    public long getCompositeKeyHashCode$runtime() {
        return 1000;
    }

    public Composition getComposition$runtime() {
        return null;
    }

    public final StateFlow getCurrentState() {
        return this._state;
    }

    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    private final boolean getHasBroadcastFrameClockAwaiters() {
        boolean v1_1;
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            v1_1 = this.getHasBroadcastFrameClockAwaitersLocked();
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        if(!this.frameClockPaused && (this.broadcastFrameClock.getHasAwaiters())) {
            return 1;
        }

        return 0;
    }

    private final boolean getHasFrameWorkLocked() {
        if(this.compositionInvalidations.getSize() != 0) {
        }
        else if(!this.getHasBroadcastFrameClockAwaitersLocked() && !this.getHasNextFrameEndAwaitersLocked()) {
            if(MultiValueMap.isNotEmpty-impl(this.movableContentRemoved)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final boolean getHasNextFrameEndAwaitersLocked() {
        if(!this.frameClockPaused && (this.nextFrameEndCallbackQueue.getHasAwaiters())) {
            return 1;
        }

        return 0;
    }

    public final boolean getHasPendingWork() {
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            if(this.snapshotInvalidations.isNotEmpty()) {
                goto label_24;
            }
            else if(this.compositionInvalidations.getSize() != 0) {
                goto label_24;
            }
            else if(this.concurrentCompositionsOutstanding > 0) {
                goto label_24;
            }
            else if(!this.compositionsAwaitingApply.isEmpty()) {
                goto label_24;
            }
            else if(this.getHasBroadcastFrameClockAwaitersLocked()) {
                goto label_24;
            }
            else if(this.getHasNextFrameEndAwaitersLocked()) {
                goto label_24;
            }
            else if(!MultiValueMap.isNotEmpty-impl(this.movableContentRemoved)) {
                goto label_22;
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        goto label_24;
    label_22:
        boolean v2_1 = false;
        goto label_25;
    label_24:
        v2_1 = true;
    label_25:
        __monitor_exit(v0);
        return v2_1;
    }

    private final boolean getHasSchedulingWork() {
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            if(this.snapshotInvalidations.isNotEmpty()) {
                goto label_16;
            }
            else if(this.compositionInvalidations.getSize() != 0) {
                goto label_16;
            }
            else if(this.getHasBroadcastFrameClockAwaitersLocked()) {
                goto label_16;
            }
            else if(!this.getHasNextFrameEndAwaitersLocked()) {
                goto label_14;
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        goto label_16;
    label_14:
        boolean v2_1 = false;
        goto label_17;
    label_16:
        v2_1 = true;
    label_17:
        __monitor_exit(v0);
        return v2_1;
    }

    private static void getRegistrationObservers$annotations() {
    }

    private final boolean getShouldKeepRecomposing() {
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            boolean v1 = this.isClosed;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
        if(v1) {
            Iterator v2_1 = this.effectJob.getChildren().iterator();
            do {
                if(v2_1.hasNext()) {
                    if(!v2_1.next().isActive()) {
                        continue;
                    }

                    return 1;
                }
                else {
                    return 0;
                }
            }
            while(true);

            return 1;
        }

        return 1;
    }

    public boolean getStackTraceEnabled$runtime() {
        return ComposeStackTraceMode.equals-impl0(ComposerKt.getComposeStackTraceMode(), ComposeStackTraceMode.Companion.getNone-MD5MrJc()) ^ 1;
    }

    public final Flow getState() {
        return this.getCurrentState();
    }

    @Deprecated(message="Replaced by currentState as a StateFlow", replaceWith="<_subannotation>") public static void getState$annotations() {
    }

    public void insertMovableContent$runtime(MovableContentStateReference arg3) {
        CancellableContinuation v2_1;
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            this.movableContentAwaitingInsert.add(arg3);
            v2_1 = this.deriveStateLocked();
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
        if(v2_1 != null) {
            ((Continuation)v2_1).resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
    }

    public void invalidate$runtime(ControlledComposition arg3) {
        CancellableContinuation v2_1;
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            if(!this.compositionInvalidations.contains(arg3)) {
                this.compositionInvalidations.add(arg3);
                v2_1 = this.deriveStateLocked();
            }
            else {
                goto label_9;
            }

            goto label_10;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

    label_9:
        v2_1 = null;
    label_10:
        __monitor_exit(v0);
        if(v2_1 != null) {
            ((Continuation)v2_1).resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
    }

    public void invalidateScope$runtime(RecomposeScopeImpl arg3) {
        CancellableContinuation v2_1;
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            this.snapshotInvalidations.add(arg3);
            v2_1 = this.deriveStateLocked();
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
        if(v2_1 != null) {
            ((Continuation)v2_1).resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
    }

    public final Object join(Continuation arg3) {
        Object v2 = FlowKt.first(this.getCurrentState(), new Recomposer$join$2(null), arg3);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    private final List knownCompositions() {
        List v1_1;
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            v1_1 = this.knownCompositionsLocked();
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    private final List knownCompositionsLocked() {
        List v0 = this._knownCompositionsCache;
        if(v0 != null) {
            return v0;
        }

        v0 = this._knownCompositions;
        if(v0.isEmpty()) {
            v0 = CollectionsKt.emptyList();
        }
        else {
            ArrayList v0_1 = new ArrayList(((Collection)v0));
        }

        this._knownCompositionsCache = v0;
        return v0;
    }

    public void movableContentStateReleased$runtime(MovableContentStateReference arg18, MovableContentState arg19, Applier arg20) {
        Recomposer v0 = this;
        MovableContentStateReference v1 = arg18;
        Object v2 = v0.stateLock;
        __monitor_enter(v2);
        try {
            MovableContentState v4 = arg19;
            v0.movableContentStatesAvailable.set(v1, v4);
            ObjectList v1_1 = MultiValueMap.get-impl(v0.movableContentNestedExtractionsPending, v1);
            if(v1_1.isNotEmpty()) {
                ScatterMap v1_2 = v4.getSlotStorage$runtime().extractNestedStates(arg20, v1_1);
                Object[] v3 = v1_2.keys;
                Object[] v4_1 = v1_2.values;
                long[] v1_3 = v1_2.metadata;
                int v5 = v1_3.length - 2;
                if(v5 >= 0) {
                    int v7;
                    for(v7 = 0; true; ++v7) {
                        long v8 = v1_3[v7];
                        if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                            int v11 = 8;
                            int v10 = 8 - (~(v7 - v5) >>> 0x1F);
                            int v12;
                            for(v12 = 0; v12 < v10; ++v12) {
                                if((0xFF & v8) < 0x80) {
                                    int v13 = (v7 << 3) + v12;
                                    v0.movableContentStatesAvailable.set(v3[v13], v4_1[v13]);
                                }

                                v8 >>= v11;
                            }

                            if(v10 != v11) {
                                break;
                            }
                        }

                        if(v7 == v5) {
                            break;
                        }
                    }
                }
            }
        }
        catch(Throwable v0_1) {
            __monitor_exit(v2);
            throw v0_1;
        }

        __monitor_exit(v2);
    }

    public MovableContentState movableContentStateResolve$runtime(MovableContentStateReference arg2) {
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            __monitor_exit(v0);
            return this.movableContentStatesAvailable.remove(arg2);
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }
    }

    static final Unit nextFrameEndCallbackQueue$lambda$0(Recomposer arg0) {
        arg0.onNewFrameAwaiter();
        return Unit.INSTANCE;
    }

    private final void onNewFrameAwaiter() {
        CancellableContinuation v1;
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            v1 = this.deriveStateLocked();
            if(this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                goto label_15;
            }
        }
        catch(Throwable v4) {
            goto label_20;
        }

        __monitor_exit(v0);
        if(v1 != null) {
            ((Continuation)v1).resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }

        return;
        try {
        label_15:
            throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", this.closeCause);
        }
        catch(Throwable v4) {
        label_20:
            __monitor_exit(v0);
            throw v4;
        }
    }

    public final void pauseCompositionFrameClock() {
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            this.frameClockPaused = true;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    private final void performInitialMovableContentInserts(ControlledComposition arg6) {
        int v3;
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            List v1 = this.movableContentAwaitingInsert;
            int v2 = v1.size();
            v3 = 0;
            while(true) {
            label_6:
                if(v3 >= v2) {
                    goto label_26;
                }

                if(!Intrinsics.areEqual(v1.get(v3).getComposition$runtime(), arg6)) {
                    goto label_24;
                }

                break;
            }
        }
        catch(Throwable v5) {
            goto label_29;
        }

        __monitor_exit(v0);
        ArrayList v0_1 = new ArrayList();
        Recomposer.performInitialMovableContentInserts$fillToInsert(((List)v0_1), this, arg6);
        goto label_16;
    label_24:
        ++v3;
        goto label_6;
    label_26:
        __monitor_exit(v0);
        return;
    label_16:
        while(!v0_1.isEmpty()) {
            this.performInsertValues(((List)v0_1), null);
            Recomposer.performInitialMovableContentInserts$fillToInsert(((List)v0_1), this, arg6);
        }

        return;
    label_29:
        __monitor_exit(v0);
        throw v5;
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List arg3, Recomposer arg4, ControlledComposition arg5) {
        arg3.clear();
        Object v0 = arg4.stateLock;
        __monitor_enter(v0);
        try {
            Iterator v4 = arg4.movableContentAwaitingInsert.iterator();
            while(v4.hasNext()) {
                Object v1 = v4.next();
                if(!Intrinsics.areEqual(((MovableContentStateReference)v1).getComposition$runtime(), arg5)) {
                    continue;
                }

                arg3.add(v1);
                v4.remove();
            }
        }
        catch(Throwable v3) {
            goto label_18;
        }

        __monitor_exit(v0);
        return;
    label_18:
        __monitor_exit(v0);
        throw v3;
    }

    private final List performInsertValues(List arg18, MutableScatterSet arg19) {
        Object v2_2;
        ArrayList v0_5;
        int v2_1;
        int v0_4;
        HashMap v16;
        Object v4;
        Iterator v18;
        ArrayList v11;
        Object v10;
        Snapshot v9_2;
        MutableSnapshot v7_1;
        MutableSnapshot v6_1;
        ArrayList v9_1;
        Recomposer v1 = this;
        List v0 = arg18;
        HashMap v2 = new HashMap(v0.size());
        int v3 = v0.size();
        int v5;
        for(v5 = 0; v5 < v3; ++v5) {
            Object v6 = v0.get(v5);
            ControlledComposition v7 = v6.getComposition$runtime();
            HashMap v8 = v2;
            Object v9 = ((Map)v8).get(v7);
            if(v9 == null) {
                v9_1 = new ArrayList();
                ((Map)v8).put(v7, v9_1);
            }

            v9_1.add(v6);
        }

        Iterator v0_1 = ((Map)v2).entrySet().iterator();
        while(true) {
            if(!v0_1.hasNext()) {
                goto label_190;
            }

            Object v3_1 = v0_1.next();
            Object v5_1 = ((Map$Entry)v3_1).getKey();
            v3_1 = ((Map$Entry)v3_1).getValue();
            if(((ControlledComposition)v5_1).isComposing()) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }

            v6_1 = Snapshot.Companion.takeMutableSnapshot(v1.readObserverOf(((ControlledComposition)v5_1)), v1.writeObserverOf(((ControlledComposition)v5_1), arg19));
            try {
                v7_1 = v6_1;
                v9_2 = ((Snapshot)v7_1).makeCurrent();
            }
            catch(Throwable v0_2) {
                goto label_188;
            }

            try {
                v10 = v1.stateLock;
                __monitor_enter(v10);
            }
            catch(Throwable v0_2) {
                goto label_185;
            }

            try {
                v11 = new ArrayList(((List)v3_1).size());
                int v12 = v3_1.size();
                int v13 = 0;
                while(v13 < v12) {
                    Object v14 = ((List)v3_1).get(v13);
                    ArrayList v15 = v11;
                    v18 = v0_1;
                    Object v0_3 = MultiValueMap.removeLast-impl(v1.movableContentRemoved, ((MovableContentStateReference)v14).getContent$runtime());
                    v4 = v0_3;
                    if(v4 != null) {
                        v16 = v2;
                        v1.movableContentNestedStatesAvailable.usedContainer(((MovableContentStateReference)v4));
                    }
                    else {
                        v16 = v2;
                    }

                    ((Collection)v15).add(TuplesKt.to(v14, v0_3));
                    ++v13;
                    v0_1 = v18;
                    v2 = v16;
                }

                v18 = v0_1;
                v16 = v2;
                v0_4 = v11.size();
                v2_1 = 0;
                while(true) {
                label_72:
                    if(v2_1 < v0_4) {
                        v3_1 = ((List)v11).get(v2_1);
                        if(((Pair)v3_1).getSecond() == null && (v1.movableContentNestedStatesAvailable.contains(((Pair)v3_1).getFirst().getContent$runtime()))) {
                            v0_5 = new ArrayList(((List)v11).size());
                            v2_1 = v11.size();
                            v3 = 0;
                            goto label_87;
                        }

                        break;
                    }

                    goto label_111;
                }
            }
            catch(Throwable v0_2) {
                break;
            }

            ++v2_1;
            goto label_72;
            try {
            label_87:
                while(v3 < v2_1) {
                    v4 = ((List)v11).get(v3);
                    ArrayList v12_1 = v0_5;
                    if(((Pair)v4).getSecond() == null) {
                        NestedMovableContent v13_1 = v1.movableContentNestedStatesAvailable.removeLast(((Pair)v4).getFirst().getContent$runtime());
                        if(v13_1 == null) {
                        }
                        else {
                            MovableContentStateReference v14_1 = v13_1.getContent();
                            MultiValueMap.add-impl(v1.movableContentNestedExtractionsPending, v13_1.getContainer(), v14_1);
                            Pair v4_1 = TuplesKt.to(((Pair)v4).getFirst(), v14_1);
                        }
                    }

                    ((Collection)v12_1).add(v4);
                    ++v3;
                }

                v11 = v0_5;
            }
            catch(Throwable v0_2) {
                break;
            }

            try {
            label_111:
                __monitor_exit(v10);
                v0_4 = v11.size();
                v2_1 = 0;
                while(true) {
                    if(v2_1 < v0_4) {
                        if(((List)v11).get(v2_1).getSecond() == null) {
                            ++v2_1;
                            continue;
                        }
                        else {
                            break;
                        }
                    }

                    goto label_174;
                }

                v0_4 = v11.size();
                v2_1 = 0;
                while(true) {
                    if(v2_1 < v0_4) {
                        if(((List)v11).get(v2_1).getSecond() != null) {
                            ++v2_1;
                            continue;
                        }
                        else {
                            break;
                        }
                    }

                    goto label_174;
                }

                v0_5 = new ArrayList(((List)v11).size());
                v2_1 = v11.size();
                for(v3 = 0; v3 < v2_1; ++v3) {
                    v4 = ((List)v11).get(v3);
                    v4 = ((Pair)v4).getSecond() == null ? ((Pair)v4).getFirst() : null;
                    if(v4 != null) {
                        v0_5.add(v4);
                    }
                }

                v2_2 = v1.stateLock;
                __monitor_enter(v2_2);
            }
            catch(Throwable v0_2) {
                goto label_185;
            }

            try {
                CollectionsKt.addAll(v1.movableContentAwaitingInsert, ((Iterable)v0_5));
                goto label_153;
            }
            catch(Throwable v0_2) {
                try {
                    __monitor_exit(v2_2);
                    throw v0_2;
                label_153:
                    __monitor_exit(v2_2);
                    v0_5 = new ArrayList(((List)v11).size());
                    v2_1 = v11.size();
                    for(v3 = 0; v3 < v2_1; ++v3) {
                        v4 = ((List)v11).get(v3);
                        if(v4.getSecond() != null) {
                            v0_5.add(v4);
                        }
                    }

                    v11 = v0_5;
                label_174:
                    ((ControlledComposition)v5_1).insertMovableContent(((List)v11));
                }
                catch(Throwable v0_2) {
                    goto label_185;
                }
            }

            try {
                ((Snapshot)v7_1).restoreCurrent(v9_2);
            }
            catch(Throwable v0_2) {
                goto label_188;
            }

            v1.applyAndCheck(v6_1);
            v0_1 = v18;
            v2 = v16;
        }

        try {
            __monitor_exit(v10);
            throw v0_2;
        }
        catch(Throwable v0_2) {
            try {
            label_185:
                ((Snapshot)v7_1).restoreCurrent(v9_2);
                throw v0_2;
            }
            catch(Throwable v0_2) {
            label_188:
                v1.applyAndCheck(v6_1);
                throw v0_2;
            }
        }

    label_190:
        return CollectionsKt.toList(v2.keySet());
    }

    private final ControlledComposition performRecompose(ControlledComposition arg7, MutableScatterSet arg8) {
        Snapshot v4;
        MutableSnapshot v3;
        ControlledComposition v1 = null;
        if(!arg7.isComposing() && !arg7.isDisposed()) {
            MutableScatterSet v0 = this.compositionsRemoved;
            if(v0 != null && (v0.contains(arg7))) {
                return v1;
            }

            MutableSnapshot v0_1 = Snapshot.Companion.takeMutableSnapshot(this.readObserverOf(arg7), this.writeObserverOf(arg7, arg8));
            try {
                v3 = v0_1;
                v4 = ((Snapshot)v3).makeCurrent();
                if(arg8 != null) {
                    goto label_18;
                }

                goto label_26;
            }
            catch(Throwable v7) {
                goto label_35;
            }

            try {
            label_18:
                if(arg8.isNotEmpty()) {
                    arg7.prepareCompose(new Recomposer$$ExternalSyntheticLambda6(arg8, arg7));
                }

            label_26:
                boolean v8 = arg7.recompose();
                goto label_27;
            label_25:
            }
            catch(Throwable v7) {
                goto label_25;
            }

            try {
                ((Snapshot)v3).restoreCurrent(v4);
                throw v7;
            label_27:
                ((Snapshot)v3).restoreCurrent(v4);
            }
            catch(Throwable v7) {
            label_35:
                this.applyAndCheck(v0_1);
                throw v7;
            }

            this.applyAndCheck(v0_1);
            if(v8) {
                return arg7;
            }

            return v1;
        }

        return v1;
    }

    private static final Unit performRecompose$lambda$0$0(MutableScatterSet arg13, ControlledComposition arg14) {
        Object[] v0 = ((ScatterSet)arg13).elements;
        long[] v13 = ((ScatterSet)arg13).metadata;
        int v1 = v13.length - 2;
        if(v1 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                long v4 = v13[v3];
                if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                    int v7 = 8;
                    int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                    int v8;
                    for(v8 = 0; v8 < v6; ++v8) {
                        if((0xFF & v4) < 0x80) {
                            arg14.recordWriteOf(v0[(v3 << 3) + v8]);
                        }

                        v4 >>= v7;
                    }

                    if(v6 != v7) {
                        break;
                    }
                }

                if(v3 == v1) {
                    break;
                }
            }
        }

        return Unit.INSTANCE;
    }

    private final void processCompositionError(Throwable arg6, ControlledComposition arg7, boolean arg8) {
        Object v8;
        if((Recomposer._hotReloadEnabled.get().booleanValue()) && !(arg6 instanceof ComposeRuntimeError)) {
            Object v0 = this.stateLock;
            __monitor_enter(v0);
            try {
                Utils_androidKt.logError("Error was captured in composition while live edit was enabled.", arg6);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations = new MutableScatterSet(0, 1, null);
                this.movableContentAwaitingInsert.clear();
                MultiValueMap.clear-impl(this.movableContentRemoved);
                this.movableContentStatesAvailable.clear();
                this.errorState.setValue(new RecomposerErrorState(arg6, arg8));
                if(arg7 != null) {
                    this.recordFailedCompositionLocked(arg7);
                }

                if(this.deriveStateLocked() != null) {
                    ComposerKt.composeImmediateRuntimeError("expected to go to inactive state due to composition error");
                }
            }
            catch(Throwable v5) {
                __monitor_exit(v0);
                throw v5;
            }

            __monitor_exit(v0);
            return;
        }

        Object v7 = this.stateLock;
        __monitor_enter(v7);
        try {
            Utils_androidKt.logError("Error was captured in composition.", arg6);
            v8 = this.errorState.getValue();
            if(v8 != null) {
                goto label_56;
            }

            this.errorState.setValue(new RecomposerErrorState(arg6, false));
        }
        catch(Throwable v5) {
            goto label_59;
        }

        __monitor_exit(v7);
        throw arg6;
        try {
        label_56:
            throw ((RecomposerErrorState)v8).getCause();
        }
        catch(Throwable v5) {
        label_59:
            __monitor_exit(v7);
            throw v5;
        }
    }

    static void processCompositionError$default(Recomposer arg0, Throwable arg1, ControlledComposition arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        arg0.processCompositionError(arg1, arg2, false);
    }

    private final Function1 readObserverOf(ControlledComposition arg1) {
        return new Recomposer$$ExternalSyntheticLambda1(arg1);
    }

    static final Unit readObserverOf$lambda$0(ControlledComposition arg0, Object arg1) {
        arg0.recordReadOf(arg1);
        return Unit.INSTANCE;
    }

    public ScatterSet recomposePaused$runtime(ControlledComposition arg2, ShouldPauseCallback arg3, ScatterSet arg4) {
        MutableScatterSet v0 = null;
        try {
            this.recordComposerModifications();
            arg2.recordModificationsOf(ScatterSetWrapperKt.wrapIntoSet(arg4));
            arg3 = arg2.getAndSetShouldPauseCallback(arg3);
        }
        catch(Throwable v2) {
            goto label_24;
        }

        try {
            ControlledComposition v4_1 = this.performRecompose(arg2, v0);
            if(v4_1 != null) {
                this.performInitialMovableContentInserts(arg2);
                v4_1.applyChanges();
                v4_1.applyLateChanges();
            }

            Object v4_2 = this.pausedScopes.get();
            if(v4_2 != null) {
            }
            else {
                arg4 = ScatterSetKt.emptyScatterSet();
            }

            goto label_15;
        }
        catch(Throwable v4) {
            try {
                arg2.getAndSetShouldPauseCallback(arg3);
                throw v4;
            label_15:
                arg2.getAndSetShouldPauseCallback(arg3);
            }
            catch(Throwable v2) {
            label_24:
                this.pausedScopes.set(v0);
                throw v2;
            }
        }

        this.pausedScopes.set(v0);
        return arg4;
    }

    private final Object recompositionRunner(Function3 arg5, Continuation arg6) {
        Object v4 = BuildersKt.withContext(this.broadcastFrameClock, new Recomposer$recompositionRunner$2(this, arg5, MonotonicFrameClockKt.getMonotonicFrameClock(arg6.getContext()), null), arg6);
        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4;
        }

        return Unit.INSTANCE;
    }

    private final boolean recordComposerModifications() {
        int v6;
        Set v2;
        List v1;
        boolean v7_1;
        CollectionsKt.emptyList();
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            if(!this.snapshotInvalidations.isEmpty()) {
                goto label_9;
            }

            v7_1 = this.getHasFrameWorkLocked();
        }
        catch(Throwable v7) {
            goto label_58;
        }

        __monitor_exit(v0);
        return v7_1;
        try {
        label_9:
            v1 = this.knownCompositionsLocked();
            v2 = ScatterSetWrapperKt.wrapIntoSet(this.snapshotInvalidations);
            v6 = 0;
            this.snapshotInvalidations = new MutableScatterSet(0, 1, null);
        }
        catch(Throwable v7) {
        label_58:
            __monitor_exit(v0);
            throw v7;
        }

        __monitor_exit(v0);
        try {
            int v0_2 = v1.size();
            while(true) {
            label_22:
                if(v6 < v0_2) {
                    v1.get(v6).recordModificationsOf(v2);
                    if(this._state.getValue().compareTo(State.ShuttingDown) > 0) {
                        break;
                    }
                }

                goto label_32;
            }
        }
        catch(Throwable v0_1) {
            goto label_48;
        }

        ++v6;
        goto label_22;
    label_32:
        v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            if(this.deriveStateLocked() != null) {
                goto label_39;
            }

            v7_1 = this.getHasFrameWorkLocked();
        }
        catch(Throwable v7) {
            goto label_45;
        }

        __monitor_exit(v0);
        return v7_1;
        try {
        label_39:
            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
        }
        catch(Throwable v7) {
        label_45:
            __monitor_exit(v0);
            throw v7;
        }

    label_48:
        Object v1_1 = this.stateLock;
        __monitor_enter(v1_1);
        try {
            this.snapshotInvalidations.addAll(((Iterable)v2));
        }
        catch(Throwable v7) {
            __monitor_exit(v1_1);
            throw v7;
        }

        __monitor_exit(v1_1);
        throw v0_1;
    }

    private final void recordFailedCompositionLocked(ControlledComposition arg3) {
        List v0 = this.failedCompositions;
        if(v0 == null) {
            ArrayList v0_1 = new ArrayList();
            this.failedCompositions = ((List)v0_1);
        }

        if(!v0.contains(arg3)) {
            ((Collection)v0).add(arg3);
        }

        this.removeKnownCompositionLocked(arg3);
    }

    public void recordInspectionTable$runtime(Set arg1) {
    }

    public void registerComposition$runtime(ControlledComposition arg1) {
    }

    private final void registerCompositionLocked(ControlledComposition arg5) {
        MutableObjectList v4 = this.registrationObservers;
        if(v4 != null) {
            Object[] v0 = ((ObjectList)v4).content;
            int v4_1 = ((ObjectList)v4)._size;
            int v1;
            for(v1 = 0; v1 < v4_1; ++v1) {
                Object v2 = v0[v1];
                if((arg5 instanceof ObservableComposition)) {
                    ((CompositionRegistrationObserver)v2).onCompositionRegistered(arg5);
                }
            }
        }
    }

    private final void registerRunnerJob(Job arg4) {
        Throwable v1;
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            v1 = this.closeCause;
            if(v1 != null) {
                goto label_29;
            }

            if(this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                goto label_24;
            }

            if(this.runnerJob != null) {
                goto label_19;
            }

            this.runnerJob = arg4;
            if(this.deriveStateLocked() != null) {
                ComposerKt.composeImmediateRuntimeError("called outside of runRecomposeAndApplyChanges");
            }
        }
        catch(Throwable v3) {
            goto label_31;
        }

        __monitor_exit(v0);
        return;
        try {
        label_19:
            throw new IllegalStateException("Recomposer already running".toString());
        label_24:
            throw new IllegalStateException("Recomposer shut down".toString());
        label_29:
            throw v1;
        }
        catch(Throwable v3) {
        label_31:
            __monitor_exit(v0);
            throw v3;
        }
    }

    private final void removeKnownCompositionLocked(ControlledComposition arg2) {
        if(this._knownCompositions.remove(arg2)) {
            this._knownCompositionsCache = null;
            this.unregisterCompositionLocked(arg2);
        }
    }

    public void reportPausedScope$runtime(RecomposeScopeImpl arg2) {
        MutableScatterSet v0_1;
        Object v0 = this.pausedScopes.get();
        if(v0 == null) {
            v0_1 = ScatterSetKt.mutableScatterSetOf();
            this.pausedScopes.set(v0_1);
        }

        v0_1.add(arg2);
    }

    public void reportRemovedComposition$runtime(ControlledComposition arg3) {
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            MutableScatterSet v1 = this.compositionsRemoved;
            if(v1 == null) {
                v1 = ScatterSetKt.mutableScatterSetOf();
                this.compositionsRemoved = v1;
            }

            v1.add(arg3);
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    private final RecomposerErrorState resetErrorState() {
        Object v2;
        Object v1;
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            v1 = this.errorState.getValue();
            v2 = null;
            if(v1 != null) {
                this.errorState.setValue(v2);
                CancellableContinuation v2_1 = this.deriveStateLocked();
            }
        }
        catch(Throwable v4) {
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        if((((CancellableContinuation)v2)) != null) {
            ((Continuation)v2).resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }

        return ((RecomposerErrorState)v1);
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation v2_1;
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            if(this.frameClockPaused) {
                this.frameClockPaused = false;
                v2_1 = this.deriveStateLocked();
            }
            else {
                goto label_8;
            }

            goto label_9;
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

    label_8:
        v2_1 = null;
    label_9:
        __monitor_exit(v0);
        if(v2_1 != null) {
            ((Continuation)v2_1).resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
    }

    private final void retryFailedCompositions() {
        Object v3;
        Object v2_1;
        int v0_1;
        List v1;
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            v1 = this.failedCompositions;
            this.failedCompositions = null;
        }
        catch(Throwable v6) {
            __monitor_exit(v0);
            throw v6;
        }

        __monitor_exit(v0);
        if(v1 == null) {
        }
        else {
            do {
                v0_1 = 0;
                try {
                    if(!v1.isEmpty()) {
                        v2_1 = CollectionsKt.removeLast(v1);
                        if(!(v2_1 instanceof CompositionImpl)) {
                            continue;
                        }

                        v2_1.invalidateAll();
                        v2_1.setContent(((CompositionImpl)v2_1).getComposable());
                        if(this.errorState.getValue() == null) {
                            continue;
                        }
                    }

                    break;
                }
                catch(Throwable v2) {
                    if(!v1.isEmpty()) {
                        v3 = this.stateLock;
                        __monitor_enter(v3);
                        try {
                            int v4 = v1.size();
                            goto label_50;
                        }
                        catch(Throwable v6) {
                            goto label_59;
                        }
                    }

                    goto label_61;
                }
            }
            while(true);

            if(v1.isEmpty()) {
                return;
            }

            v2_1 = this.stateLock;
            __monitor_enter(v2_1);
            try {
                int v3_1 = v1.size();
                goto label_30;
            }
            catch(Throwable v6) {
                goto label_39;
            }

            try {
            label_50:
                while(v0_1 < v4) {
                    this.recordFailedCompositionLocked(v1.get(v0_1));
                    ++v0_1;
                }
            }
            catch(Throwable v6) {
                goto label_59;
            }

            __monitor_exit(v3);
            goto label_61;
        label_59:
            __monitor_exit(v3);
            throw v6;
        label_61:
            throw v2;
            try {
            label_30:
                while(v0_1 < v3_1) {
                    this.recordFailedCompositionLocked(v1.get(v0_1));
                    ++v0_1;
                }
            }
            catch(Throwable v6) {
                goto label_39;
            }

            __monitor_exit(v2_1);
            return;
        label_39:
            __monitor_exit(v2_1);
            throw v6;
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation arg3) {
        Object v2 = this.recompositionRunner(new Recomposer$runRecomposeAndApplyChanges$2(this, null), arg3);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public CancellationHandle scheduleFrameEndCallback(Function0 arg1) {
        return this.nextFrameEndCallbackQueue.scheduleFrameEndCallback(arg1);
    }

    public void unregisterComposition$runtime(ControlledComposition arg3) {
        Object v0 = this.stateLock;
        __monitor_enter(v0);
        try {
            this.removeKnownCompositionLocked(arg3);
            this.compositionInvalidations.remove(arg3);
            this.compositionsAwaitingApply.remove(arg3);
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    private final void unregisterCompositionLocked(ControlledComposition arg5) {
        MutableObjectList v4 = this.registrationObservers;
        if(v4 != null) {
            Object[] v0 = ((ObjectList)v4).content;
            int v4_1 = ((ObjectList)v4)._size;
            int v1;
            for(v1 = 0; v1 < v4_1; ++v1) {
                Object v2 = v0[v1];
                if((arg5 instanceof ObservableComposition)) {
                    ((CompositionRegistrationObserver)v2).onCompositionUnregistered(arg5);
                }
            }
        }
    }

    private final void withTransparentSnapshot(Function0 arg8) {
        TransparentObserverSnapshot v1_1;
        Snapshot v7 = Snapshot.Companion.getCurrent();
        if((v7 instanceof MutableSnapshot)) {
            TransparentObserverMutableSnapshot v1 = new TransparentObserverMutableSnapshot(v7, null, null, true, false);
        }
        else {
            v1_1 = new TransparentObserverSnapshot(v7, null, true, false);
        }

        try {
            v7 = ((Snapshot)v1_1).makeCurrent();
        }
        catch(Throwable v0) {
            goto label_29;
        }

        try {
            arg8.invoke();
            goto label_20;
        }
        catch(Throwable v0) {
            Throwable v8 = v0;
            try {
                ((Snapshot)v1_1).restoreCurrent(v7);
                throw v8;
            label_20:
                ((Snapshot)v1_1).restoreCurrent(v7);
            }
            catch(Throwable v0) {
            label_29:
                ((Snapshot)v1_1).dispose();
                throw v0;
            }
        }

        ((Snapshot)v1_1).dispose();
    }

    private final Function1 writeObserverOf(ControlledComposition arg1, MutableScatterSet arg2) {
        return new Recomposer$$ExternalSyntheticLambda5(arg1, arg2);
    }

    static final Unit writeObserverOf$lambda$0(ControlledComposition arg0, MutableScatterSet arg1, Object arg2) {
        arg0.recordWriteOf(arg2);
        if(arg1 != null) {
            arg1.add(arg2);
        }

        return Unit.INSTANCE;
    }
}

