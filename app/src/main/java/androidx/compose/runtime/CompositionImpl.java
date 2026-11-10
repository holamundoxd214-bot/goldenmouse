package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableKt;
import androidx.compose.runtime.composer.linkbuffer.changelist.ChangeList;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionErrorContext;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.ObservableComposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u001B\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010!\u001A\u00020\u001DH\u0002J\b\u0010R\u001A\u00020OH\u0002J\b\u0010S\u001A\u000206H\u0002J \u0010e\u001A\u00020Z2\u0011\u0010f\u001A\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010_J \u0010g\u001A\u00020Z2\u0011\u0010f\u001A\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010_J \u0010h\u001A\u00020i2\u0011\u0010f\u001A\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010jJ \u0010k\u001A\u00020i2\u0011\u0010f\u001A\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0016¢\u0006\u0002\u0010jJ\u001D\u0010l\u001A\u00020Z2\u000E\u0010m\u001A\n\u0012\u0004\u0012\u00020o\u0018\u00010nH\u0000¢\u0006\u0002\bpJ \u0010q\u001A\u00020Z2\u0011\u0010f\u001A\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0002¢\u0006\u0002\u0010_J(\u0010r\u001A\u00020i2\u0006\u0010s\u001A\u00020;2\u0011\u0010f\u001A\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0002¢\u0006\u0002\u0010tJ \u0010u\u001A\u00020Z2\u0011\u0010f\u001A\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0002¢\u0006\u0002\u0010_J\b\u0010v\u001A\u00020ZH\u0002J\b\u0010w\u001A\u00020;H\u0002J\u0010\u0010x\u001A\u00020y2\u0006\u0010z\u001A\u00020{H\u0016J\u000E\u0010|\u001A\u00020Z2\u0006\u0010}\u001A\u00020GJ\b\u0010~\u001A\u00020ZH\u0002J\b\u0010\u007F\u001A\u00020ZH\u0002J\t\u0010\u0080\u0001\u001A\u00020ZH\u0002J!\u0010\u0081\u0001\u001A\u00020Z2\u0011\u0010f\u001A\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[H\u0017¢\u0006\u0002\u0010_J\u000F\u0010\u0082\u0001\u001A\u00020ZH\u0000¢\u0006\u0003\b\u0083\u0001J\t\u0010\u0084\u0001\u001A\u00020ZH\u0016J\u0018\u0010\u0087\u0001\u001A\u00020Z2\r\u0010\u0088\u0001\u001A\b\u0012\u0004\u0012\u00020\u00110\'H\u0016J\u0018\u0010\u0089\u0001\u001A\u00020;2\r\u0010\u0088\u0001\u001A\b\u0012\u0004\u0012\u00020\u00110\'H\u0016J\u0018\u0010\u008A\u0001\u001A\u00020Z2\r\u0010\u008B\u0001\u001A\b\u0012\u0004\u0012\u00020Z0YH\u0016J,\u0010\u008C\u0001\u001A\u0015\u0012\u0011\u0012\u000F\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110\u008D\u0001022\b\u0010\u008E\u0001\u001A\u00030\u008F\u0001H\u0000¢\u0006\u0003\b\u0090\u0001J:\u0010\u0091\u0001\u001A\u0015\u0012\u0011\u0012\u000F\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110\u008D\u0001022\u0015\u0010\u0092\u0001\u001A\u0010\u0012\u0005\u0012\u00030\u008F\u0001\u0012\u0004\u0012\u00020;0\u0093\u0001H\u0080\b¢\u0006\u0003\b\u0094\u0001J\u001B\u0010\u0095\u0001\u001A\u00020Z2\u0007\u0010\u0096\u0001\u001A\u00020\u00112\u0007\u0010\u0097\u0001\u001A\u00020;H\u0002J!\u0010\u0095\u0001\u001A\u00020Z2\r\u0010\u0088\u0001\u001A\b\u0012\u0004\u0012\u00020\u00110\'2\u0007\u0010\u0097\u0001\u001A\u00020;H\u0002J\t\u0010\u0098\u0001\u001A\u00020ZH\u0002J\u0012\u0010\u0099\u0001\u001A\u00020Z2\u0007\u0010\u0096\u0001\u001A\u00020\u0011H\u0016J\u0012\u0010\u009A\u0001\u001A\u00020Z2\u0007\u0010\u0096\u0001\u001A\u00020\u0011H\u0002J\u0012\u0010\u009B\u0001\u001A\u00020Z2\u0007\u0010\u0096\u0001\u001A\u00020\u0011H\u0016J\t\u0010\u009C\u0001\u001A\u00020;H\u0016J)\u0010\u009D\u0001\u001A\u00020Z2\u001E\u0010\u009E\u0001\u001A\u0019\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030\u009F\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u009F\u00010\u008D\u000102H\u0016J\u0012\u0010 \u0001\u001A\u00020Z2\u0007\u0010U\u001A\u00030¡\u0001H\u0016J\u0011\u0010¢\u0001\u001A\u00020Z2\u0006\u00105\u001A\u000206H\u0002J\t\u0010£\u0001\u001A\u00020ZH\u0016J\t\u0010¤\u0001\u001A\u00020ZH\u0016J\t\u0010¥\u0001\u001A\u00020ZH\u0016JL\u0010¦\u0001\u001A\u0003H§\u0001\"\u0005\b\u0000\u0010§\u000122\u0010\u008B\u0001\u001A-\u0012!\u0012\u001F\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#¢\u0006\u000E\b¨\u0001\u0012\t\b©\u0001\u0012\u0004\b\b(5\u0012\u0005\u0012\u0003H§\u00010\u0093\u0001H\u0082\b¢\u0006\u0003\u0010ª\u0001J(\u0010«\u0001\u001A\u0003H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000E\u0010\u008B\u0001\u001A\t\u0012\u0005\u0012\u0003H§\u00010YH\u0082\b¢\u0006\u0003\u0010¬\u0001J\t\u0010­\u0001\u001A\u00020ZH\u0016J\t\u0010®\u0001\u001A\u00020ZH\u0016J\t\u0010¯\u0001\u001A\u00020ZH\u0016J;\u0010°\u0001\u001A\u0003H±\u0001\"\u0005\b\u0000\u0010±\u00012\t\u0010²\u0001\u001A\u0004\u0018\u00010\u00012\u0007\u0010³\u0001\u001A\u00020G2\u000E\u0010\u008B\u0001\u001A\t\u0012\u0005\u0012\u0003H±\u00010YH\u0016¢\u0006\u0003\u0010´\u0001J\u0015\u0010µ\u0001\u001A\u0004\u0018\u00010B2\b\u0010A\u001A\u0004\u0018\u00010BH\u0016J\u001E\u0010¶\u0001\u001A\u00030·\u00012\u0007\u0010¸\u0001\u001A\u00020$2\t\u0010¹\u0001\u001A\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010º\u0001\u001A\u00020Z2\u0007\u0010¸\u0001\u001A\u00020$H\u0016J)\u0010»\u0001\u001A\u0005\u0018\u0001H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000E\u0010}\u001A\n\u0012\u0005\u0012\u0003H§\u00010¼\u0001H\u0016¢\u0006\u0003\u0010½\u0001J\u001D\u0010¾\u0001\u001A\u00020;2\u0007\u0010¸\u0001\u001A\u00020$2\t\u0010¹\u0001\u001A\u0004\u0018\u00010\u0011H\u0002J(\u0010¿\u0001\u001A\u00030·\u00012\u0007\u0010¸\u0001\u001A\u00020$2\b\u0010\u008E\u0001\u001A\u00030\u008F\u00012\t\u0010¹\u0001\u001A\u0004\u0018\u00010\u0011H\u0002J!\u0010À\u0001\u001A\u00020Z2\u0007\u0010¹\u0001\u001A\u00020\u00112\u0007\u0010¸\u0001\u001A\u00020$H\u0000¢\u0006\u0003\bÁ\u0001J\u001B\u0010Â\u0001\u001A\u00020Z2\n\u0010U\u001A\u0006\u0012\u0002\b\u00030.H\u0000¢\u0006\u0003\bÃ\u0001J\u001E\u0010Ä\u0001\u001A\u000E\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#H\u0002¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J(\u0010Ç\u0001\u001A\u0003H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000E\u0010\u008B\u0001\u001A\t\u0012\u0005\u0012\u0003H§\u00010YH\u0082\b¢\u0006\u0003\u0010¬\u0001J\n\u0010z\u001A\u0004\u0018\u00010{H\u0002J\t\u0010È\u0001\u001A\u00020ZH\u0016J\u000F\u0010É\u0001\u001A\u00020GH\u0000¢\u0006\u0003\bÊ\u0001R\u0013\u0010\u0007\u001A\u00020\b8\u0007¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0012\u0010\t\u001A\u0006\u0012\u0002\b\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000F\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011`\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\u0014\u001A\u00060\u0011j\u0002`\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u001A\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001A\u0010\u001BR\u001A\u0010\u001C\u001A\u00020\u001DX\u0080\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u001E\u0010\u001B\u001A\u0004\b\u001F\u0010 R\u001C\u0010\"\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001A\u0010&\u001A\b\u0012\u0004\u0012\u00020\u00110\'8AX\u0080\u0004¢\u0006\u0006\u001A\u0004\b(\u0010)R\u0014\u0010*\u001A\b\u0012\u0004\u0012\u00020$0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001A\b\u0012\u0004\u0012\u00020$0+X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010-\u001A\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030.0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001A\u0010/\u001A\b\u0012\u0004\u0012\u00020\u00110\'8AX\u0080\u0004¢\u0006\u0006\u001A\u0004\b0\u0010)R\u001A\u00101\u001A\b\u0012\u0004\u0012\u00020$028AX\u0080\u0004¢\u0006\u0006\u001A\u0004\b3\u00104R\u000E\u00105\u001A\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00107\u001A\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u00108\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001C\u00109\u001A\u000E\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00110#X\u0082\u000E¢\u0006\u0004\n\u0002\u0010%R \u0010:\u001A\u00020;X\u0080\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010\u001B\u001A\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0010\u0010A\u001A\u0004\u0018\u00010BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010C\u001A\u0004\u0018\u00010DX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010E\u001A\u0004\u0018\u00010\u0000X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010F\u001A\u00020GX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010H\u001A\u00020IX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bJ\u0010KR\u000E\u0010L\u001A\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010N\u001A\u00020OX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bP\u0010QR\u0011\u0010T\u001A\u00020;¢\u0006\b\n\u0000\u001A\u0004\bT\u0010>R\u000E\u0010U\u001A\u00020GX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010V\u001A\u00020;8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bW\u0010>R\'\u0010X\u001A\r\u0012\u0004\u0012\u00020Z0Y¢\u0006\u0002\b[X\u0086\u000E¢\u0006\u0010\n\u0002\u0010`\u001A\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0014\u0010a\u001A\u00020;8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\ba\u0010>R\u0014\u0010b\u001A\u00020;8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bb\u0010>R\u0014\u0010c\u001A\u00020;8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bd\u0010>R\u0016\u0010\u0085\u0001\u001A\u00020;8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u0086\u0001\u0010>¨\u0006Ë\u0001"}, d2={"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", "Landroidx/compose/runtime/CompositionServices;", "Landroidx/compose/runtime/PausableComposition;", "Landroidx/compose/runtime/tooling/ObservableComposition;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "<init>", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;)V", "getParent", "()Landroidx/compose/runtime/CompositionContext;", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Landroidx/compose/runtime/internal/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "getAbandonSet$annotations", "()V", "slotStorage", "Landroidx/compose/runtime/SlotStorage;", "getSlotStorage$runtime$annotations", "getSlotStorage$runtime", "()Landroidx/compose/runtime/SlotStorage;", "createSlotStorage", "observations", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/collection/MutableScatterMap;", "observedObjects", "", "getObservedObjects$runtime", "()Ljava/util/Set;", "invalidatedScopes", "Landroidx/collection/MutableScatterSet;", "conditionallyInvalidatedScopes", "derivedStates", "Landroidx/compose/runtime/DerivedState;", "derivedStateDependencies", "getDerivedStateDependencies$runtime", "conditionalScopes", "", "getConditionalScopes$runtime", "()Ljava/util/List;", "changes", "Landroidx/compose/runtime/Changes;", "lateChanges", "observationsProcessed", "invalidations", "pendingInvalidScopes", "", "getPendingInvalidScopes$runtime$annotations", "getPendingInvalidScopes$runtime", "()Z", "setPendingInvalidScopes$runtime", "(Z)V", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "pendingPausedComposition", "Landroidx/compose/runtime/PausedCompositionImpl;", "invalidationDelegate", "invalidationDelegateGroup", "", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "rememberManager", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "composer", "Landroidx/compose/runtime/InternalComposer;", "getComposer$runtime", "()Landroidx/compose/runtime/InternalComposer;", "createComposer", "createChangeList", "isRoot", "state", "areChildrenComposing", "getAreChildrenComposing", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "isComposing", "isDisposed", "hasPendingChanges", "getHasPendingChanges", "setContent", "content", "setContentWithReuse", "setPausableContent", "Landroidx/compose/runtime/PausedComposition;", "(Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/PausedComposition;", "setPausableContentWithReuse", "pausedCompositionFinished", "ignoreSet", "Landroidx/collection/ScatterSet;", "Landroidx/compose/runtime/RememberObserverHolder;", "pausedCompositionFinished$runtime", "composeInitial", "composeInitialPaused", "reusable", "(ZLkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/PausedComposition;", "composeInitialWithReuse", "ensureRunning", "clearDeactivated", "setObserver", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observer", "Landroidx/compose/runtime/tooling/CompositionObserver;", "invalidateGroupsWithKey", "key", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "drainPendingModificationsOutOfBandLocked", "composeContent", "updateMovingInvalidations", "updateMovingInvalidations$runtime", "dispose", "hasInvalidations", "getHasInvalidations", "recordModificationsOf", "values", "observesAnyOf", "prepareCompose", "block", "extractInvalidationsOf", "Lkotlin/Pair;", "anchor", "Landroidx/compose/runtime/Anchor;", "extractInvalidationsOf$runtime", "extractInvalidationsOfGroup", "inGroup", "Lkotlin/Function1;", "extractInvalidationsOfGroup$runtime", "addPendingInvalidationsLocked", "value", "forgetConditionalScopes", "cleanUpDerivedStateObservations", "recordReadOf", "invalidateScopeOfLocked", "recordWriteOf", "recompose", "insertMovableContent", "references", "Landroidx/compose/runtime/MovableContentStateReference;", "disposeUnusedMovableContent", "Landroidx/compose/runtime/MovableContentState;", "applyChangesInLocked", "applyChanges", "applyLateChanges", "changesApplied", "guardInvalidationsLocked", "T", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "guardChanges", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "abandonChanges", "invalidateAll", "verifyConsistent", "delegateInvalidations", "R", "to", "groupIndex", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getAndSetShouldPauseCallback", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "recomposeScopeReleased", "getCompositionService", "Landroidx/compose/runtime/CompositionServiceKey;", "(Landroidx/compose/runtime/CompositionServiceKey;)Ljava/lang/Object;", "tryImminentInvalidation", "invalidateChecked", "removeObservation", "removeObservation$runtime", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime", "takeInvalidations", "takeInvalidations-afanTW4", "()Landroidx/collection/MutableScatterMap;", "trackAbandonedValues", "deactivate", "composerStacksSizes", "composerStacksSizes$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CompositionImpl implements CompositionServices, ControlledComposition, PausableComposition, RecomposeScopeOwner, ReusableComposition, ObservableComposition {
    public static final int $stable = 8;
    private final Set abandonSet;
    private final Applier applier;
    private final Changes changes;
    private Function2 composable;
    private final InternalComposer composer;
    private final MutableScatterSet conditionallyInvalidatedScopes;
    private final MutableScatterMap derivedStates;
    private final MutableScatterSet invalidatedScopes;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private MutableScatterMap invalidations;
    private final boolean isRoot;
    private final Changes lateChanges;
    private final Object lock;
    private final MutableScatterMap observations;
    private final MutableScatterMap observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference pendingModifications;
    private PausedCompositionImpl pendingPausedComposition;
    private final RememberEventDispatcher rememberManager;
    private ShouldPauseCallback shouldPause;
    private final SlotStorage slotStorage;
    private int state;

    static {
    }

    public CompositionImpl(CompositionContext arg7, Applier arg8) {
        super();
        this.parent = arg7;
        this.applier = arg8;
        Object v0 = null;
        this.pendingModifications = new AtomicReference(v0);
        this.lock = new Object();
        this.abandonSet = new MutableScatterSet(0, 1, ((DefaultConstructorMarker)v0)).asMutableSet();
        SlotStorage v8 = this.createSlotStorage();
        if(arg7.getCollectingCallByInformation$runtime()) {
            v8.collectCalledByInformation();
        }

        if(arg7.getCollectingSourceInformation$runtime()) {
            v8.collectSourceInformation();
        }

        this.slotStorage = v8;
        this.observations = ScopeMap.constructor-impl$default(((MutableScatterMap)v0), 1, ((DefaultConstructorMarker)v0));
        this.invalidatedScopes = new MutableScatterSet(0, 1, ((DefaultConstructorMarker)v0));
        this.conditionallyInvalidatedScopes = new MutableScatterSet(0, 1, ((DefaultConstructorMarker)v0));
        this.derivedStates = ScopeMap.constructor-impl$default(((MutableScatterMap)v0), 1, ((DefaultConstructorMarker)v0));
        this.changes = this.createChangeList();
        this.lateChanges = this.createChangeList();
        this.observationsProcessed = ScopeMap.constructor-impl$default(((MutableScatterMap)v0), 1, ((DefaultConstructorMarker)v0));
        this.invalidations = ScopeMap.constructor-impl$default(((MutableScatterMap)v0), 1, ((DefaultConstructorMarker)v0));
        CompositionContext v3 = arg7;
        this.observerHolder = new CompositionObserverHolder(null, false, v3, 3, null);
        this.rememberManager = new RememberEventDispatcher();
        InternalComposer v7 = this.createComposer();
        v3.registerComposer$runtime(v7);
        this.composer = v7;
        this.isRoot = v3 instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$954879418$runtime();
    }

    public void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        if(!this.abandonSet.isEmpty()) {
            RememberEventDispatcher v0 = this.rememberManager;
            Set v1 = this.abandonSet;
            CompositionErrorContextImpl v2 = this.composer.getErrorContext$runtime();
            try {
                v0.prepare(v1, ((CompositionErrorContext)v2));
                v0.dispatchAbandons();
            }
            catch(Throwable v2_1) {
                v0.clear();
                throw v2_1;
            }

            v0.clear();
            return;
        }
    }

    public static final MutableScatterMap access$getInvalidations$p(CompositionImpl arg0) {
        return arg0.invalidations;
    }

    public static final Object access$getLock$p(CompositionImpl arg0) {
        return arg0.lock;
    }

    public static final MutableScatterMap access$getObservations$p(CompositionImpl arg0) {
        return arg0.observations;
    }

    private final void addPendingInvalidationsLocked(Object arg17, boolean arg18) {
        CompositionImpl v0 = this;
        Object v1 = arg17;
        Object v2 = v0.observations.get(v1);
        if(v2 != null) {
            if((v2 instanceof MutableScatterSet)) {
                Object[] v3 = ((ScatterSet)v2).elements;
                long[] v2_1 = ((ScatterSet)v2).metadata;
                int v4 = v2_1.length - 2;
                if(v4 >= 0) {
                    int v6;
                    for(v6 = 0; true; ++v6) {
                        long v7 = v2_1[v6];
                        if((~v7 << 7 & v7 & -9187201950435737472L) != -9187201950435737472L) {
                            int v10 = 8;
                            int v9 = 8 - (~(v6 - v4) >>> 0x1F);
                            int v11;
                            for(v11 = 0; v11 < v9; ++v11) {
                                if((0xFF & v7) < 0x80) {
                                    Object v12 = v3[(v6 << 3) + v11];
                                    if(!ScopeMap.remove-impl(v0.observationsProcessed, v1, v12) && ((RecomposeScopeImpl)v12).invalidateForResult(v1) != InvalidationResult.IGNORED) {
                                        if((((RecomposeScopeImpl)v12).isConditional()) && !arg18) {
                                            v0.conditionallyInvalidatedScopes.add(v12);
                                            goto label_50;
                                        }

                                        v0.invalidatedScopes.add(v12);
                                    }
                                }

                            label_50:
                                v7 >>= v10;
                            }

                            if(v9 != v10) {
                                return;
                            }
                        }

                        if(v6 == v4) {
                            return;
                        }
                    }
                }
            }
            else {
                if(ScopeMap.remove-impl(v0.observationsProcessed, v1, v2)) {
                    return;
                }

                if(((RecomposeScopeImpl)v2).invalidateForResult(v1) == InvalidationResult.IGNORED) {
                    return;
                }

                if((((RecomposeScopeImpl)v2).isConditional()) && !arg18) {
                    v0.conditionallyInvalidatedScopes.add(v2);
                    return;
                }

                v0.invalidatedScopes.add(v2);
            }
        }
    }

    private final void addPendingInvalidationsLocked(Set arg35, boolean arg36) {
        boolean v0_2;
        int v30;
        String v29_1;
        int v25_2;
        long[] v24_1;
        boolean v6_2;
        long v32;
        int v31;
        int v29;
        int v27;
        long v35_1;
        long[] v26;
        long[] v25_1;
        long[] v6_1;
        long v9_3;
        long[] v3_2;
        Object[] v5_1;
        int v28;
        int v6;
        int v12;
        int v11;
        int v35;
        long v25;
        long v22;
        int v21;
        int v8;
        int v7;
        long v18;
        long v16;
        int v14;
        CompositionImpl v0 = this;
        Set v1 = arg35;
        boolean v2 = arg36;
        Object v4 = null;
        int v9 = 7;
        long v10 = -9187201950435737472L;
        int v13 = 8;
        if((v1 instanceof ScatterSetWrapper)) {
            ScatterSet v1_1 = ((ScatterSetWrapper)v1).getSet$runtime();
            Object[] v3 = v1_1.elements;
            long[] v1_2 = v1_1.metadata;
            v14 = v1_2.length - 2;
            if(v14 >= 0) {
                int v15 = 0;
                v16 = 0x80;
                while(true) {
                    long v5 = v1_2[v15];
                    v18 = 0xFF;
                    if((~v5 << v9 & v5 & v10) != v10) {
                        v7 = 8 - (~(v15 - v14) >>> 0x1F);
                        v8 = 0;
                        while(v8 < v7) {
                            if((v5 & v18) < v16) {
                                v21 = v9;
                                Object v9_1 = v3[(v15 << 3) + v8];
                                v22 = v10;
                                if((v9_1 instanceof RecomposeScopeImpl)) {
                                    ((RecomposeScopeImpl)v9_1).invalidateForResult(v4);
                                    v25 = v5;
                                    v35 = v14;
                                }
                                else {
                                    v0.addPendingInvalidationsLocked(v9_1, v2);
                                    v9_1 = v0.derivedStates.get(v9_1);
                                    if(v9_1 != null) {
                                        if((v9_1 instanceof MutableScatterSet)) {
                                            Object[] v10_1 = ((ScatterSet)v9_1).elements;
                                            long[] v9_2 = ((ScatterSet)v9_1).metadata;
                                            v11 = v9_2.length - 2;
                                            if(v11 >= 0) {
                                                v25 = v5;
                                                v12 = 0;
                                                while(true) {
                                                    long v4_1 = v9_2[v12];
                                                    v6 = v13;
                                                    v35 = v14;
                                                    if((~v4_1 << v21 & v4_1 & v22) != v22) {
                                                        v13 = 8 - (~(v12 - v11) >>> 0x1F);
                                                        v14 = 0;
                                                        while(v14 < v13) {
                                                            if((v4_1 & v18) < v16) {
                                                                v28 = v6;
                                                                v0.addPendingInvalidationsLocked(v10_1[(v12 << 3) + v14], v2);
                                                            }
                                                            else {
                                                                v28 = v6;
                                                            }

                                                            v4_1 >>= v28;
                                                            ++v14;
                                                            v6 = v28;
                                                        }

                                                        if(v13 != v6) {
                                                            goto label_97;
                                                        }
                                                    }

                                                    if(v12 == v11) {
                                                        goto label_97;
                                                    }

                                                    ++v12;
                                                    v14 = v35;
                                                    v13 = 8;
                                                }
                                            }
                                        }
                                        else {
                                            v25 = v5;
                                            v35 = v14;
                                            v0.addPendingInvalidationsLocked(v9_1, v2);
                                            goto label_97;
                                        }
                                    }

                                    v25 = v5;
                                    v35 = v14;
                                }

                            label_97:
                                v6 = 8;
                            }
                            else {
                                v25 = v5;
                                v21 = v9;
                                v22 = v10;
                                v35 = v14;
                                v6 = v13;
                            }

                            ++v8;
                            v14 = v35;
                            v13 = v6;
                            v9 = v21;
                            v10 = v22;
                            v5 = v25 >> v6;
                            v4 = null;
                        }

                        v21 = v9;
                        v22 = v10;
                        v35 = v14;
                        if(v7 != v13) {
                            break;
                        }

                        v14 = v35;
                    }
                    else {
                        v21 = v9;
                        v22 = v10;
                    }

                    if(v15 == v14) {
                        break;
                    }

                    ++v15;
                    v9 = v21;
                    v10 = v22;
                    v4 = null;
                    v13 = 8;
                }
            }
            else {
                v21 = v9;
                v22 = v10;
                v16 = 0x80;
                v18 = 0xFF;
            }
        }
        else {
            v21 = v9;
            v22 = v10;
            v16 = 0x80;
            v18 = 0xFF;
            Iterator v1_3 = ((Iterable)v1).iterator();
            while(true) {
            label_139:
                if(!v1_3.hasNext()) {
                    goto label_191;
                }

                Object v3_1 = v1_3.next();
                if((v3_1 instanceof RecomposeScopeImpl)) {
                    ((RecomposeScopeImpl)v3_1).invalidateForResult(null);
                    continue;
                }

                v0.addPendingInvalidationsLocked(v3_1, v2);
                v3_1 = v0.derivedStates.get(v3_1);
                if(v3_1 == null) {
                    continue;
                }

                if((v3_1 instanceof MutableScatterSet)) {
                    v5_1 = ((ScatterSet)v3_1).elements;
                    v3_2 = ((ScatterSet)v3_1).metadata;
                    v7 = v3_2.length - 2;
                    if(v7 < 0) {
                        continue;
                    }

                    v8 = 0;
                    break;
                }

                v0.addPendingInvalidationsLocked(v3_1, v2);
            }

            while(true) {
                v9_3 = v3_2[v8];
                if((~v9_3 << v21 & v9_3 & v22) != v22) {
                    v13 = 8 - (~(v8 - v7) >>> 0x1F);
                    for(v11 = 0; v11 < v13; ++v11) {
                        if((v9_3 & v18) < v16) {
                            v0.addPendingInvalidationsLocked(v5_1[(v8 << 3) + v11], v2);
                        }

                        v9_3 >>= 8;
                    }

                    if(v13 != 8) {
                        goto label_139;
                    }
                }

                if(v8 == v7) {
                    goto label_139;
                }

                ++v8;
            }
        }

    label_191:
        MutableScatterSet v1_4 = v0.conditionallyInvalidatedScopes;
        MutableScatterSet v3_3 = v0.invalidatedScopes;
        String v4_2 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>";
        String v5_2 = "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap";
        if((v2) && (v1_4.isNotEmpty())) {
            MutableScatterMap v2_1 = v0.observations;
            long[] v7_1 = v2_1.metadata;
            v8 = v7_1.length - 2;
            if(v8 >= 0) {
                v9 = 0;
                while(true) {
                    v10 = v7_1[v9];
                    if((~v10 << v21 & v10 & v22) != v22) {
                        v13 = 8 - (~(v9 - v8) >>> 0x1F);
                        v12 = 0;
                        while(v12 < v13) {
                            if((v10 & v18) < v16) {
                                v14 = (v9 << 3) + v12;
                                Object v15_1 = v2_1.values[v14];
                                if((v15_1 instanceof MutableScatterSet)) {
                                    Intrinsics.checkNotNull(v15_1, v4_2);
                                    Object[] v24 = ((MutableScatterSet)v15_1).elements;
                                    v6_1 = v15_1.metadata;
                                    v25_1 = v7_1;
                                    v7 = v6_1.length - 2;
                                    if(v7 >= 0) {
                                        v26 = v6_1;
                                        v35_1 = v10;
                                        v6 = 0;
                                        while(true) {
                                            v10 = v26[v6];
                                            v27 = v8;
                                            v29 = v9;
                                            if((~v10 << v21 & v10 & v22) != v22) {
                                                v8 = 8 - (~(v6 - v7) >>> 0x1F);
                                                for(v9 = 0; v9 < v8; v9 = v31 + 1) {
                                                    if((v10 & v18) < v16) {
                                                        v31 = v9;
                                                        v9 = (v6 << 3) + v31;
                                                        v32 = v10;
                                                        Object v10_2 = v24[v9];
                                                        if(!v1_4.contains(v10_2) && !v3_3.contains(v10_2)) {
                                                            goto label_271;
                                                        }

                                                        ((MutableScatterSet)v15_1).removeElementAt(v9);
                                                    }
                                                    else {
                                                        v31 = v9;
                                                        v32 = v10;
                                                    }

                                                label_271:
                                                    v10 = v32 >> 8;
                                                }

                                                if(v8 != 8) {
                                                    break;
                                                }
                                            }

                                            if(v6 == v7) {
                                                break;
                                            }

                                            ++v6;
                                            v8 = v27;
                                            v9 = v29;
                                        }
                                    }
                                    else {
                                        v27 = v8;
                                        v29 = v9;
                                        v35_1 = v10;
                                    }

                                    v6_2 = ((MutableScatterSet)v15_1).isEmpty();
                                }
                                else {
                                    v25_1 = v7_1;
                                    v27 = v8;
                                    v29 = v9;
                                    v35_1 = v10;
                                    Intrinsics.checkNotNull(v15_1, v5_2);
                                    if(!v1_4.contains(v15_1)) {
                                        if(v3_3.contains(v15_1)) {
                                        }
                                        else {
                                            v6_2 = false;
                                            goto label_301;
                                        }
                                    }

                                    v6_2 = true;
                                }

                            label_301:
                                if(!v6_2) {
                                    goto label_308;
                                }

                                v2_1.removeValueAt(v14);
                            }
                            else {
                                v25_1 = v7_1;
                                v27 = v8;
                                v29 = v9;
                                v35_1 = v10;
                            }

                        label_308:
                            v10 = v35_1 >> 8;
                            ++v12;
                            v7_1 = v25_1;
                            v8 = v27;
                            v9 = v29;
                        }

                        v25_1 = v7_1;
                        v27 = v8;
                        v29 = v9;
                        if(v13 != 8) {
                            break;
                        }

                        v8 = v27;
                        v7 = v29;
                    }
                    else {
                        v25_1 = v7_1;
                        v7 = v9;
                    }

                    if(v7 == v8) {
                        break;
                    }

                    v9 = v7 + 1;
                    v7_1 = v25_1;
                }
            }

            v1_4.clear();
            v0.cleanUpDerivedStateObservations();
            return;
        }

        if(v3_3.isNotEmpty()) {
            MutableScatterMap v1_5 = v0.observations;
            long[] v2_2 = v1_5.metadata;
            v7 = v2_2.length - 2;
            if(v7 >= 0) {
                v8 = 0;
                while(true) {
                    v9_3 = v2_2[v8];
                    if((~v9_3 << v21 & v9_3 & v22) != v22) {
                        v13 = 8 - (~(v8 - v7) >>> 0x1F);
                        v11 = 0;
                        while(v11 < v13) {
                            if((v9_3 & v18) < v16) {
                                v12 = (v8 << 3) + v11;
                                Object v14_1 = v1_5.values[v12];
                                if((v14_1 instanceof MutableScatterSet)) {
                                    Intrinsics.checkNotNull(v14_1, v4_2);
                                    Object[] v15_2 = ((MutableScatterSet)v14_1).elements;
                                    v6_1 = v14_1.metadata;
                                    int v0_1 = v6_1.length - 2;
                                    v24_1 = v2_2;
                                    if(v0_1 >= 0) {
                                        v35_1 = v9_3;
                                        int v2_3 = 0;
                                        while(true) {
                                            v9_3 = v6_1[v2_3];
                                            v26 = v6_1;
                                            v25_2 = v7;
                                            if((~v9_3 << v21 & v9_3 & v22) != v22) {
                                                v7 = 8 - (~(v2_3 - v0_1) >>> 0x1F);
                                                v6 = 0;
                                                while(v6 < v7) {
                                                    if((v9_3 & v18) < v16) {
                                                        v29_1 = v4_2;
                                                        int v4_3 = (v2_3 << 3) + v6;
                                                        v30 = v6;
                                                        if(v3_3.contains(v15_2[v4_3])) {
                                                            ((MutableScatterSet)v14_1).removeElementAt(v4_3);
                                                        }
                                                    }
                                                    else {
                                                        v29_1 = v4_2;
                                                        v30 = v6;
                                                    }

                                                    v9_3 >>= 8;
                                                    v6 = v30 + 1;
                                                    v4_2 = v29_1;
                                                }

                                                v29_1 = v4_2;
                                                if(v7 != 8) {
                                                    break;
                                                }
                                            }
                                            else {
                                                v29_1 = v4_2;
                                            }

                                            if(v2_3 == v0_1) {
                                                break;
                                            }

                                            ++v2_3;
                                            v7 = v25_2;
                                            v6_1 = v26;
                                            v4_2 = v29_1;
                                        }
                                    }
                                    else {
                                        v29_1 = v4_2;
                                        v25_2 = v7;
                                        v35_1 = v9_3;
                                    }

                                    v0_2 = ((MutableScatterSet)v14_1).isEmpty();
                                }
                                else {
                                    v24_1 = v2_2;
                                    v29_1 = v4_2;
                                    v25_2 = v7;
                                    v35_1 = v9_3;
                                    Intrinsics.checkNotNull(v14_1, v5_2);
                                    v0_2 = v3_3.contains(v14_1);
                                }

                                if(!v0_2) {
                                    goto label_438;
                                }

                                v1_5.removeValueAt(v12);
                            }
                            else {
                                v24_1 = v2_2;
                                v29_1 = v4_2;
                                v25_2 = v7;
                                v35_1 = v9_3;
                            }

                        label_438:
                            v9_3 = v35_1 >> 8;
                            ++v11;
                            v2_2 = v24_1;
                            v7 = v25_2;
                            v4_2 = v29_1;
                        }

                        v24_1 = v2_2;
                        v29_1 = v4_2;
                        v25_2 = v7;
                        if(v13 != 8) {
                            break;
                        }

                        v7 = v25_2;
                    }
                    else {
                        v24_1 = v2_2;
                        v29_1 = v4_2;
                    }

                    if(v8 == v7) {
                        break;
                    }

                    ++v8;
                    v2_2 = v24_1;
                    v4_2 = v29_1;
                }
            }

            this.cleanUpDerivedStateObservations();
            v3_3.clear();
        }
    }

    public void applyChanges() {
        CompositionErrorContextImpl v4;
        Set v3;
        RememberEventDispatcher v2;
        Unit v5;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.applyChangesInLocked(this.changes);
            this.drainPendingModificationsLocked();
            v5 = Unit.INSTANCE;
            goto label_6;
        }
        catch(Throwable v1) {
            try {
                if(!((CompositionImpl)v5).abandonSet.isEmpty()) {
                    v2 = ((CompositionImpl)v5).rememberManager;
                    v3 = ((CompositionImpl)v5).abandonSet;
                    v4 = ((CompositionImpl)v5).composer.getErrorContext$runtime();
                    goto label_17;
                }

                goto label_24;
            }
            catch(Throwable v1) {
                goto label_26;
            }

            try {
            label_17:
                v2.prepare(v3, ((CompositionErrorContext)v4));
            }
            catch(Throwable v1) {
                goto label_26;
            }
            catch(Throwable v1) {
                goto label_22;
            }

            try {
                v2.dispatchAbandons();
                goto label_19;
            }
            catch(Throwable v1) {
                try {
                label_22:
                    v2.clear();
                    throw v1;
                label_19:
                    v2.clear();
                label_24:
                    throw v1;
                }
                catch(Throwable v1) {
                    try {
                    label_26:
                        ((CompositionImpl)v5).abandonChanges();
                        throw v1;
                    label_6:
                    }
                    catch(Throwable v5_1) {
                        __monitor_exit(v0);
                        throw v5_1;
                    }
                }
            }
        }

        __monitor_exit(v0);
    }

    private final void applyChangesInLocked(Changes arg31) {
        boolean v4_2;
        int v4_1;
        long[] v29;
        long v25;
        long v21;
        int v17;
        int v0_4;
        RememberEventDispatcher v3_1;
        Object v2_2;
        RecordingApplier v0_2;
        CompositionImpl v1 = this;
        v1.rememberManager.prepare(v1.abandonSet, v1.composer.getErrorContext$runtime());
        try {
            if(arg31.isEmpty()) {
            }
            else {
                goto label_22;
            }
        }
        catch(Throwable v0) {
            goto label_221;
        }

        try {
            if((v1.lateChanges.isEmpty()) && v1.pendingPausedComposition == null) {
                v1.rememberManager.dispatchAbandons();
            }

            goto label_15;
        }
        catch(Throwable v0) {
            v1.rememberManager.clear();
            throw v0;
        }

        try {
        label_22:
            PausedCompositionImpl v0_1 = v1.pendingPausedComposition;
            if(v0_1 != null) {
                v0_2 = v0_1.getPausableApplier$runtime();
                if(v0_2 != null) {
                }
                else {
                    goto label_27;
                }
            }
            else {
            label_27:
                Applier v0_3 = v1.applier;
            }

            PausedCompositionImpl v2 = v1.pendingPausedComposition;
            if(v2 != null) {
                RecordingApplier v2_1 = v2.getPausableApplier$runtime();
            }
            else {
                v2_2 = null;
            }

            String v2_3 = Intrinsics.areEqual(v0_2, v2_2) ? "Compose:recordChanges" : "Compose:applyChanges";
            v2_2 = Trace.INSTANCE.beginSection(v2_3);
        }
        catch(Throwable v0) {
            goto label_221;
        }

        try {
            PausedCompositionImpl v3 = v1.pendingPausedComposition;
            if(v3 != null) {
                v3_1 = v3.getRememberManager$runtime();
                if(v3_1 == null) {
                    goto label_44;
                }
            }
            else {
            label_44:
                v3_1 = v1.rememberManager;
            }

            ((Applier)v0_2).onBeginChanges();
            arg31.execute(v1.slotStorage, ((Applier)v0_2), ((RememberManager)v3_1), v1.composer.getErrorContext$runtime());
            ((Applier)v0_2).onEndChanges();
            goto label_53;
        }
        catch(Throwable v0) {
            try {
                Trace.INSTANCE.endSection(v2_2);
                throw v0;
            label_53:
                Trace.INSTANCE.endSection(v2_2);
                v1.rememberManager.dispatchRememberObservers();
                v1.rememberManager.dispatchSideEffects();
                if(v1.pendingInvalidScopes) {
                    v2_2 = Trace.INSTANCE.beginSection("Compose:unobserve");
                    v0_4 = 0;
                    goto label_65;
                }

                goto label_204;
            }
            catch(Throwable v0) {
                goto label_221;
            }
        }

        try {
        label_65:
            v1.pendingInvalidScopes = false;
            MutableScatterMap v3_2 = v1.observations;
            long[] v4 = v3_2.metadata;
            int v5 = v4.length - 2;
            if(v5 >= 0) {
                int v6 = 0;
                while(true) {
                    long v7 = v4[v6];
                    int v11 = 7;
                    long v12 = -9187201950435737472L;
                    if((~v7 << v11 & v7 & v12) != v12) {
                        int v10 = 8;
                        int v9 = 8 - (~(v6 - v5) >>> 0x1F);
                        int v14 = v0_4;
                        while(v14 < v9) {
                            long v15 = 0xFF;
                            long v19 = 0x80;
                            if((v7 & v15) < v19) {
                                v0_4 = (v6 << 3) + v14;
                                v17 = v11;
                                Object v11_1 = v3_2.values[v0_4];
                                v21 = v12;
                                if((v11_1 instanceof MutableScatterSet)) {
                                    Intrinsics.checkNotNull(v11_1, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                    Object[] v12_1 = ((MutableScatterSet)v11_1).elements;
                                    long[] v13 = v11_1.metadata;
                                    long v23 = v15;
                                    int v15_1 = v13.length - 2;
                                    if(v15_1 >= 0) {
                                        v25 = v7;
                                        int v16 = v10;
                                        v10 = 0;
                                        while(true) {
                                            v7 = v13[v10];
                                            Object[] v18 = v12_1;
                                            long[] v27 = v13;
                                            if((~v7 << v17 & v7 & v21) != v21) {
                                                int v12_2 = 8 - (~(v10 - v15_1) >>> 0x1F);
                                                int v13_1 = 0;
                                                while(v13_1 < v12_2) {
                                                    if((v7 & v23) < v19) {
                                                        v29 = v4;
                                                        v4_1 = (v10 << 3) + v13_1;
                                                        if(!v18[v4_1].getValid()) {
                                                            ((MutableScatterSet)v11_1).removeElementAt(v4_1);
                                                        }
                                                    }
                                                    else {
                                                        v29 = v4;
                                                    }

                                                    v7 >>= v16;
                                                    ++v13_1;
                                                    v4 = v29;
                                                }

                                                v29 = v4;
                                                if(v12_2 != v16) {
                                                    break;
                                                }
                                            }
                                            else {
                                                v29 = v4;
                                            }

                                            if(v10 == v15_1) {
                                                break;
                                            }

                                            ++v10;
                                            v12_1 = v18;
                                            v13 = v27;
                                            v4 = v29;
                                            v16 = 8;
                                        }
                                    }
                                    else {
                                        v29 = v4;
                                        v25 = v7;
                                    }

                                    v4_2 = ((MutableScatterSet)v11_1).isEmpty();
                                }
                                else {
                                    v29 = v4;
                                    v25 = v7;
                                    Intrinsics.checkNotNull(v11_1, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                    if(!((RecomposeScopeImpl)v11_1).getValid()) {
                                        v4_2 = true;
                                        goto label_168;
                                    }

                                    v4_2 = false;
                                }

                            label_168:
                                if(v4_2) {
                                    v3_2.removeValueAt(v0_4);
                                }

                                v4_1 = 8;
                            }
                            else {
                                v29 = v4;
                                v25 = v7;
                                v17 = v11;
                                v21 = v12;
                                v4_1 = v10;
                            }

                            v7 = v25 >> v4_1;
                            ++v14;
                            v10 = v4_1;
                            v11 = v17;
                            v12 = v21;
                            v4 = v29;
                        }

                        v29 = v4;
                        if(v9 != v10) {
                            break;
                        }
                    }
                    else {
                        v29 = v4;
                    }

                    if(v6 == v5) {
                        break;
                    }

                    ++v6;
                    v4 = v29;
                    v0_4 = 0;
                }
            }

            v1.cleanUpDerivedStateObservations();
            goto label_197;
        }
        catch(Throwable v0) {
            try {
                Trace.INSTANCE.endSection(v2_2);
                throw v0;
            label_197:
                Trace.INSTANCE.endSection(v2_2);
            }
            catch(Throwable v0) {
                try {
                label_221:
                    if((v1.lateChanges.isEmpty()) && v1.pendingPausedComposition == null) {
                        v1.rememberManager.dispatchAbandons();
                    }
                }
                catch(Throwable v0) {
                    v1.rememberManager.clear();
                    throw v0;
                }

                v1.rememberManager.clear();
                throw v0;
            }
        }

        try {
        label_204:
            if(!v1.lateChanges.isEmpty()) {
                goto label_15;
            }

            if(v1.pendingPausedComposition != null) {
                goto label_15;
            }

            v1.rememberManager.dispatchAbandons();
        }
        catch(Throwable v0) {
            v1.rememberManager.clear();
            throw v0;
        }

    label_15:
        v1.rememberManager.clear();
    }

    public void applyLateChanges() {
        CompositionErrorContextImpl v4;
        Set v3;
        RememberEventDispatcher v2;
        Unit v5;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.lateChanges.isNotEmpty()) {
                this.applyChangesInLocked(this.lateChanges);
            }

            v5 = Unit.INSTANCE;
            goto label_8;
        }
        catch(Throwable v1) {
            try {
                if(!((CompositionImpl)v5).abandonSet.isEmpty()) {
                    v2 = ((CompositionImpl)v5).rememberManager;
                    v3 = ((CompositionImpl)v5).abandonSet;
                    v4 = ((CompositionImpl)v5).composer.getErrorContext$runtime();
                    goto label_19;
                }

                goto label_26;
            }
            catch(Throwable v1) {
                goto label_28;
            }

            try {
            label_19:
                v2.prepare(v3, ((CompositionErrorContext)v4));
            }
            catch(Throwable v1) {
                goto label_28;
            }
            catch(Throwable v1) {
                goto label_24;
            }

            try {
                v2.dispatchAbandons();
                goto label_21;
            }
            catch(Throwable v1) {
                try {
                label_24:
                    v2.clear();
                    throw v1;
                label_21:
                    v2.clear();
                label_26:
                    throw v1;
                }
                catch(Throwable v1) {
                    try {
                    label_28:
                        ((CompositionImpl)v5).abandonChanges();
                        throw v1;
                    label_8:
                    }
                    catch(Throwable v5_1) {
                        __monitor_exit(v0);
                        throw v5_1;
                    }
                }
            }
        }

        __monitor_exit(v0);
    }

    public void changesApplied() {
        CompositionErrorContextImpl v4;
        Set v3_1;
        RememberEventDispatcher v2_2;
        Unit v5;
        CompositionErrorContextImpl v3;
        Set v2;
        RememberEventDispatcher v1_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.composer.changesApplied$runtime();
            if(!this.abandonSet.isEmpty()) {
                v1_1 = this.rememberManager;
                v2 = this.abandonSet;
                v3 = this.composer.getErrorContext$runtime();
                goto label_11;
            }

            goto label_18;
        }
        catch(Throwable v1) {
            goto label_23;
        }

        try {
        label_11:
            v1_1.prepare(v2, ((CompositionErrorContext)v3));
        }
        catch(Throwable v1) {
            goto label_23;
        }
        catch(Throwable v2_1) {
            goto label_16;
        }

        try {
            v1_1.dispatchAbandons();
            goto label_13;
        }
        catch(Throwable v2_1) {
            try {
            label_16:
                v1_1.clear();
                throw v2_1;
            label_13:
                v1_1.clear();
            label_18:
                v5 = Unit.INSTANCE;
                goto label_19;
            }
            catch(Throwable v1) {
                try {
                label_23:
                    if(!((CompositionImpl)v5).abandonSet.isEmpty()) {
                        v2_2 = ((CompositionImpl)v5).rememberManager;
                        v3_1 = ((CompositionImpl)v5).abandonSet;
                        v4 = ((CompositionImpl)v5).composer.getErrorContext$runtime();
                        goto label_30;
                    }

                    goto label_37;
                }
                catch(Throwable v1) {
                    goto label_39;
                }

                try {
                label_30:
                    v2_2.prepare(v3_1, ((CompositionErrorContext)v4));
                }
                catch(Throwable v1) {
                    goto label_39;
                }
                catch(Throwable v1) {
                    goto label_35;
                }

                try {
                    v2_2.dispatchAbandons();
                    goto label_32;
                }
                catch(Throwable v1) {
                    try {
                    label_35:
                        v2_2.clear();
                        throw v1;
                    label_32:
                        v2_2.clear();
                    label_37:
                        throw v1;
                    }
                    catch(Throwable v1) {
                        try {
                        label_39:
                            ((CompositionImpl)v5).abandonChanges();
                            throw v1;
                        label_19:
                        }
                        catch(Throwable v5_1) {
                            __monitor_exit(v0);
                            throw v5_1;
                        }
                    }
                }
            }
        }

        __monitor_exit(v0);
    }

    private final void cleanUpDerivedStateObservations() {
        boolean v2_2;
        int v27;
        int v29;
        int v2_1;
        long[] v28;
        long v21;
        int v18;
        long v19;
        int v4;
        long v16;
        CompositionImpl v0 = this;
        MutableScatterMap v1 = v0.derivedStates;
        long[] v2 = v1.metadata;
        int v3 = v2.length - 2;
        long v6 = 0xFF;
        int v8 = 7;
        long v9 = -9187201950435737472L;
        int v11 = 8;
        if(v3 >= 0) {
            int v13 = 0;
            while(true) {
                long v14 = v2[v13];
                v16 = 0x80;
                if((~v14 << v8 & v14 & v9) != v9) {
                    v4 = 8 - (~(v13 - v3) >>> 0x1F);
                    int v5 = 0;
                    while(v5 < v4) {
                        if((v14 & v6) < v16) {
                            v19 = v6;
                            int v6_1 = (v13 << 3) + v5;
                            Object v7 = v1.values[v6_1];
                            v18 = v8;
                            if((v7 instanceof MutableScatterSet)) {
                                Intrinsics.checkNotNull(v7, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                Object[] v8_1 = ((MutableScatterSet)v7).elements;
                                v21 = v9;
                                long[] v9_1 = v7.metadata;
                                int v10 = v9_1.length - 2;
                                if(v10 >= 0) {
                                    int v23 = v11;
                                    int v24 = 0;
                                    while(true) {
                                        long v11_1 = v9_1[v24];
                                        Object[] v25 = v8_1;
                                        long[] v26 = v9_1;
                                        if((~v11_1 << v18 & v11_1 & v21) != v21) {
                                            v8 = 8 - (~(v24 - v10) >>> 0x1F);
                                            int v9_2 = 0;
                                            while(v9_2 < v8) {
                                                if((v11_1 & v19) < v16) {
                                                    v28 = v2;
                                                    v2_1 = (v24 << 3) + v9_2;
                                                    v29 = v5;
                                                    v27 = v9_2;
                                                    if(!ScopeMap.contains-impl(v0.observations, v25[v2_1])) {
                                                        ((MutableScatterSet)v7).removeElementAt(v2_1);
                                                    }
                                                }
                                                else {
                                                    v28 = v2;
                                                    v29 = v5;
                                                    v27 = v9_2;
                                                }

                                                v11_1 >>= v23;
                                                v9_2 = v27 + 1;
                                                v2 = v28;
                                                v5 = v29;
                                            }

                                            v28 = v2;
                                            v29 = v5;
                                            if(v8 != v23) {
                                                break;
                                            }
                                        }
                                        else {
                                            v28 = v2;
                                            v29 = v5;
                                        }

                                        int v12 = v24;
                                        if(v12 == v10) {
                                            break;
                                        }

                                        v24 = v12 + 1;
                                        v8_1 = v25;
                                        v9_1 = v26;
                                        v2 = v28;
                                        v5 = v29;
                                        v23 = 8;
                                    }
                                }
                                else {
                                    v28 = v2;
                                    v29 = v5;
                                }

                                v2_2 = ((MutableScatterSet)v7).isEmpty();
                            }
                            else {
                                v28 = v2;
                                v29 = v5;
                                v21 = v9;
                                Intrinsics.checkNotNull(v7, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                if(!ScopeMap.contains-impl(v0.observations, v7)) {
                                    v2_2 = true;
                                    goto label_115;
                                }

                                v2_2 = false;
                            }

                        label_115:
                            if(v2_2) {
                                v1.removeValueAt(v6_1);
                            }

                            v2_1 = 8;
                        }
                        else {
                            v28 = v2;
                            v29 = v5;
                            v19 = v6;
                            v18 = v8;
                            v21 = v9;
                            v2_1 = v11;
                        }

                        v14 >>= v2_1;
                        v5 = v29 + 1;
                        v11 = v2_1;
                        v8 = v18;
                        v6 = v19;
                        v9 = v21;
                        v2 = v28;
                    }

                    v28 = v2;
                    v19 = v6;
                    v18 = v8;
                    v21 = v9;
                    if(v4 != v11) {
                        break;
                    }
                }
                else {
                    v28 = v2;
                    v19 = v6;
                    v18 = v8;
                    v21 = v9;
                }

                if(v13 == v3) {
                    break;
                }

                ++v13;
                v8 = v18;
                v6 = v19;
                v9 = v21;
                v2 = v28;
                v11 = 8;
            }
        }
        else {
            v19 = v6;
            v18 = v8;
            v21 = v9;
            v16 = 0x80;
        }

        if(v0.conditionallyInvalidatedScopes.isNotEmpty()) {
            MutableScatterSet v0_1 = v0.conditionallyInvalidatedScopes;
            Object[] v1_1 = v0_1.elements;
            v2 = v0_1.metadata;
            v3 = v2.length - 2;
            if(v3 >= 0) {
                for(v4 = 0; true; ++v4) {
                    long v5_1 = v2[v4];
                    if((~v5_1 << v18 & v5_1 & v21) != v21) {
                        v11 = 8 - (~(v4 - v3) >>> 0x1F);
                        int v7_1;
                        for(v7_1 = 0; v7_1 < v11; ++v7_1) {
                            if((v5_1 & v19) < v16) {
                                v8 = (v4 << 3) + v7_1;
                                if(!v1_1[v8].isConditional()) {
                                    v0_1.removeElementAt(v8);
                                }
                            }

                            v5_1 >>= 8;
                        }

                        if(v11 != 8) {
                            return;
                        }
                    }

                    if(v4 == v3) {
                        return;
                    }
                }
            }
        }
    }

    private final boolean clearDeactivated() {
        boolean v3;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            v3 = true;
            if(this.state == 1) {
            }
            else {
                v3 = false;
            }

            if(v3) {
                this.state = 0;
            }
        }
        catch(Throwable v4) {
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        return v3;
    }

    public void composeContent(Function2 arg5) {
        CompositionErrorContextImpl v2;
        Set v1_1;
        RememberEventDispatcher v0_1;
        Unit v4;
        MutableScatterMap v1;
        Object v0;
        try {
            v0 = this.lock;
            __monitor_enter(v0);
        }
        catch(Throwable v5) {
            goto label_19;
        }

        try {
            this.drainPendingModificationsForCompositionLocked();
            v1 = this.takeInvalidations-afanTW4();
        }
        catch(Throwable v5) {
            goto label_16;
        }

        try {
            this.composer.composeContent--ZbOJvo$runtime(v1, arg5, this.shouldPause);
            goto label_8;
        }
        catch(Throwable v5) {
            try {
                this.invalidations = v1;
                throw v5;
            label_8:
                goto label_9;
            }
            catch(Throwable v5) {
                try {
                label_16:
                    __monitor_exit(v0);
                    throw v5;
                label_9:
                    __monitor_exit(v0);
                    v4 = Unit.INSTANCE;
                    return;
                }
                catch(Throwable v5) {
                    try {
                    label_19:
                        if(!((CompositionImpl)v4).abandonSet.isEmpty()) {
                            v0_1 = ((CompositionImpl)v4).rememberManager;
                            v1_1 = ((CompositionImpl)v4).abandonSet;
                            v2 = ((CompositionImpl)v4).composer.getErrorContext$runtime();
                            goto label_26;
                        }

                        goto label_33;
                    }
                    catch(Throwable v5) {
                        goto label_35;
                    }

                    try {
                    label_26:
                        v0_1.prepare(v1_1, ((CompositionErrorContext)v2));
                    }
                    catch(Throwable v5) {
                        goto label_35;
                    }
                    catch(Throwable v5) {
                        goto label_31;
                    }

                    try {
                        v0_1.dispatchAbandons();
                        goto label_28;
                    }
                    catch(Throwable v5) {
                        try {
                        label_31:
                            v0_1.clear();
                            throw v5;
                        label_28:
                            v0_1.clear();
                        label_33:
                            throw v5;
                        }
                        catch(Throwable v5) {
                        label_35:
                            ((CompositionImpl)v4).abandonChanges();
                            throw v5;
                        }
                    }
                }
            }
        }
    }

    private final void composeInitial(Function2 arg2) {
        this.composable = arg2;
        this.parent.composeInitial$runtime(((ControlledComposition)this), arg2);
    }

    private final PausedComposition composeInitialPaused(boolean arg11, Function2 arg12) {
        int v0 = this.pendingPausedComposition == null ? 1 : 0;
        if(v0 == 0) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }

        PausedCompositionImpl v1 = new PausedCompositionImpl(this, this.parent, this.composer, this.abandonSet, arg12, arg11, this.applier, this.lock);
        this.pendingPausedComposition = v1;
        return ((PausedComposition)v1);
    }

    private final void composeInitialWithReuse(Function2 arg2) {
        this.composer.startReuseFromRoot$runtime();
        this.composeInitial(arg2);
        this.composer.endReuseFromRoot$runtime();
    }

    public final int composerStacksSizes$runtime() {
        return this.composer.stacksSize$runtime();
    }

    private final Changes createChangeList() {
        if(ComposeRuntimeFlags.isLinkBufferComposerEnabled) {
            return new ChangeList();
        }

        return new androidx.compose.runtime.composer.gapbuffer.changelist.ChangeList();
    }

    private final InternalComposer createComposer() {
        boolean v0 = ComposeRuntimeFlags.isLinkBufferComposerEnabled;
        Applier v2 = this.applier;
        if(v0) {
            return new LinkComposer(v2, this.parent, this.abandonSet, SlotTableKt.asLinkBufferSlotTable(this.slotStorage), this.changes, this.lateChanges, this.observerHolder, this);
        }

        return new GapComposer(v2, this.parent, androidx.compose.runtime.composer.gapbuffer.SlotTableKt.asGapBufferSlotTable(this.slotStorage), this.abandonSet, this.changes, this.lateChanges, this.observerHolder, this);
    }

    private final SlotStorage createSlotStorage() {
        if(ComposeRuntimeFlags.isLinkBufferComposerEnabled) {
            return new SlotTable(0, null, false, false, 15, null);
        }

        return new androidx.compose.runtime.composer.gapbuffer.SlotTable();
    }

    public void deactivate() {
        CompositionErrorContextImpl v6;
        Set v5;
        RememberEventDispatcher v4;
        Object v3;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            int v1 = this.pendingPausedComposition == null ? 1 : 0;
            if(v1 == 0) {
                PreconditionsKt.throwIllegalStateException("Deactivate is not supported while pausable composition is in progress");
            }

            boolean v1_1 = this.slotStorage.isEmpty();
            if(!v1_1 || !this.abandonSet.isEmpty()) {
                v3 = Trace.INSTANCE.beginSection("Compose:deactivate");
                goto label_20;
            }

            goto label_39;
        }
        catch(Throwable v7) {
            goto label_63;
        }

        try {
        label_20:
            v4 = this.rememberManager;
            v5 = this.abandonSet;
            v6 = this.composer.getErrorContext$runtime();
        }
        catch(Throwable v7) {
            goto label_59;
        }

        try {
            v4.prepare(v5, ((CompositionErrorContext)v6));
        }
        catch(Throwable v7) {
            goto label_59;
        }
        catch(Throwable v7) {
            goto label_56;
        }

        try {
            if(!v1_1) {
                this.applier.onBeginChanges();
                this.slotStorage.deactivateAll(this.rememberManager);
                this.applier.onEndChanges();
                v4.dispatchRememberObservers();
            }

            v4.dispatchAbandons();
            goto label_35;
        }
        catch(Throwable v7) {
            try {
            label_56:
                v4.clear();
                throw v7;
            label_35:
                v4.clear();
                goto label_37;
            }
            catch(Throwable v7) {
                try {
                label_59:
                    Trace.INSTANCE.endSection(v3);
                    throw v7;
                label_37:
                    Trace.INSTANCE.endSection(v3);
                label_39:
                    ScopeMap.clear-impl(this.observations);
                    ScopeMap.clear-impl(this.derivedStates);
                    ScopeMap.clear-impl(this.invalidations);
                    this.changes.clear();
                    this.lateChanges.clear();
                    this.composer.deactivate$runtime();
                    this.state = 1;
                }
                catch(Throwable v7) {
                label_63:
                    __monitor_exit(v0);
                    throw v7;
                }
            }
        }

        __monitor_exit(v0);
    }

    public Object delegateInvalidations(ControlledComposition arg2, int arg3, Function0 arg4) {
        Object v4_1;
        if(arg2 != null && !Intrinsics.areEqual(arg2, this) && arg3 >= 0) {
            this.invalidationDelegate = ((CompositionImpl)arg2);
            this.invalidationDelegateGroup = arg3;
            CompositionImpl v3 = null;
            try {
                v4_1 = arg4.invoke();
            }
            catch(Throwable v4) {
                this.invalidationDelegate = v3;
                this.invalidationDelegateGroup = 0;
                throw v4;
            }

            this.invalidationDelegate = v3;
            this.invalidationDelegateGroup = 0;
            return v4_1;
        }

        return arg4.invoke();
    }

    public void dispose() {
        CompositionErrorContextImpl v4;
        Set v3;
        RememberEventDispatcher v2_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.composer.isComposing$runtime()) {
                PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
            }

            int v2 = 3;
            if(this.state != v2) {
                this.state = v2;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.getLambda$1918065384$runtime();
                Changes v1 = this.composer.getDeferredChanges$runtime();
                if(v1 != null) {
                    this.applyChangesInLocked(v1);
                }

                boolean v1_1 = this.slotStorage.isEmpty();
                if(!v1_1 || !this.abandonSet.isEmpty()) {
                    v2_1 = this.rememberManager;
                    v3 = this.abandonSet;
                    v4 = this.composer.getErrorContext$runtime();
                    goto label_28;
                }

                goto label_42;
            }

            goto label_48;
        }
        catch(Throwable v5) {
            goto label_54;
        }

        try {
        label_28:
            v2_1.prepare(v3, ((CompositionErrorContext)v4));
        }
        catch(Throwable v5) {
            goto label_54;
        }
        catch(Throwable v5) {
            goto label_46;
        }

        try {
            if(!v1_1) {
                this.applier.onBeginChanges();
                this.slotStorage.clear(this.rememberManager);
                this.applier.clear();
                this.applier.onEndChanges();
                v2_1.dispatchRememberObservers();
            }

            v2_1.dispatchAbandons();
            goto label_41;
        }
        catch(Throwable v5) {
            try {
            label_46:
                v2_1.clear();
                throw v5;
            label_41:
                v2_1.clear();
            label_42:
                this.composer.dispose$runtime();
            label_48:
            }
            catch(Throwable v5) {
            label_54:
                __monitor_exit(v0);
                throw v5;
            }
        }

        __monitor_exit(v0);
        this.parent.unregisterComposition$runtime(((ControlledComposition)this));
    }

    public void disposeUnusedMovableContent(MovableContentState arg4) {
        RememberEventDispatcher v0 = this.rememberManager;
        Set v1 = this.abandonSet;
        CompositionErrorContextImpl v2 = this.composer.getErrorContext$runtime();
        try {
            v0.prepare(v1, ((CompositionErrorContext)v2));
            arg4.getSlotStorage$runtime().disposeUnusedMovableContent(this.rememberManager, arg4);
            v0.dispatchRememberObservers();
        }
        catch(Throwable v3) {
            v0.clear();
            throw v3;
        }

        v0.clear();
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object v0 = this.pendingModifications.getAndSet(CompositionKt.access$getPendingApplyNoModifications$p());
        if(v0 != null) {
            if(Intrinsics.areEqual(v0, CompositionKt.access$getPendingApplyNoModifications$p())) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            else if((v0 instanceof Set)) {
                this.addPendingInvalidationsLocked(((Set)v0), true);
                return;
            }
            else if((v0 instanceof Object[])) {
                int v1 = v0.length;
                int v3;
                for(v3 = 0; v3 < v1; ++v3) {
                    this.addPendingInvalidationsLocked(v0[v3], true);
                }
            }
            else {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object v0 = this.pendingModifications.getAndSet(null);
        if(!Intrinsics.areEqual(v0, CompositionKt.access$getPendingApplyNoModifications$p())) {
            if((v0 instanceof Set)) {
                this.addPendingInvalidationsLocked(((Set)v0), false);
                return;
            }
            else if((v0 instanceof Object[])) {
                int v1 = v0.length;
                int v3;
                for(v3 = 0; v3 < v1; ++v3) {
                    this.addPendingInvalidationsLocked(v0[v3], false);
                }
            }
            else if(v0 != null) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
            else if(this.pendingPausedComposition == null) {
                ComposerKt.composeImmediateRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
                return;
            }
        }
    }

    private final void drainPendingModificationsOutOfBandLocked() {
        Object v0 = this.pendingModifications.getAndSet(SetsKt.emptySet());
        if(!Intrinsics.areEqual(v0, CompositionKt.access$getPendingApplyNoModifications$p())) {
            if(v0 == null) {
            }
            else if((v0 instanceof Set)) {
                this.addPendingInvalidationsLocked(((Set)v0), false);
                return;
            }
            else if((v0 instanceof Object[])) {
                int v1 = v0.length;
                int v3;
                for(v3 = 0; v3 < v1; ++v3) {
                    this.addPendingInvalidationsLocked(v0[v3], false);
                }
            }
            else {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
        }
    }

    private final void ensureRunning() {
        String v0_1;
        int v0 = this.state;
        int v1 = 0;
        int v3 = v0 == 0 ? 1 : 0;
        if(v3 == 0) {
            if(v0 == 1) {
                v0_1 = "The composition should be activated before setting content.";
            }
            else if(v0 == 2) {
                v0_1 = "A previous pausable composition for this composition was cancelled. This composition must be disposed.";
            }
            else if(v0 != 3) {
                v0_1 = "";
            }
            else {
                v0_1 = "The composition is disposed";
            }

            PreconditionsKt.throwIllegalStateException(v0_1);
        }

        if(this.pendingPausedComposition == null) {
            v1 = 1;
        }

        if(v1 == 0) {
            PreconditionsKt.throwIllegalStateException("A pausable composition is in progress");
        }
    }

    public final List extractInvalidationsOf$runtime(Anchor arg35) {
        boolean v4_2;
        long v32;
        int v30;
        int v31;
        int v9;
        long v25;
        long[] v24;
        long v22;
        int v18;
        CompositionImpl v0 = this;
        Anchor v1 = arg35;
        if(ScopeMap.getSize-impl(v0.invalidations) > 0) {
            ArrayList v2 = new ArrayList();
            SlotStorage v3 = v0.slotStorage;
            MutableScatterMap v0_1 = v0.invalidations;
            long[] v4 = v0_1.metadata;
            int v5 = v4.length - 2;
            if(v5 >= 0) {
                int v7 = 0;
                while(true) {
                    long v8 = v4[v7];
                    int v12 = 7;
                    long v13 = -9187201950435737472L;
                    if((~v8 << v12 & v8 & v13) != v13) {
                        int v11 = 8;
                        int v10 = 8 - (~(v7 - v5) >>> 0x1F);
                        int v15 = 0;
                        while(v15 < v10) {
                            long v16 = 0xFF;
                            long v20 = 0x80;
                            if((v8 & v16) < v20) {
                                int v6 = (v7 << 3) + v15;
                                v18 = v12;
                                Object v12_1 = v0_1.keys[v6];
                                v22 = v13;
                                Object v13_1 = v0_1.values[v6];
                                Intrinsics.checkNotNull(v12_1, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                                if((v13_1 instanceof MutableScatterSet)) {
                                    Intrinsics.checkNotNull(v13_1, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                    Object[] v14 = ((MutableScatterSet)v13_1).elements;
                                    int v19 = v11;
                                    long[] v11_1 = v13_1.metadata;
                                    v24 = v4;
                                    int v4_1 = v11_1.length - 2;
                                    v25 = v8;
                                    if(v4_1 >= 0) {
                                        Object[] v27 = v14;
                                        v9 = v15;
                                        int v8_1 = 0;
                                        while(true) {
                                            long v14_1 = v11_1[v8_1];
                                            long[] v29 = v11_1;
                                            Object v28 = v12_1;
                                            if((~v14_1 << v18 & v14_1 & v22) != v22) {
                                                v11 = 8 - (~(v8_1 - v4_1) >>> 0x1F);
                                                v12 = 0;
                                                while(v12 < v11) {
                                                    if((v14_1 & v16) < v20) {
                                                        v31 = v9;
                                                        v9 = (v8_1 << 3) + v12;
                                                        v30 = v12;
                                                        v12_1 = v27[v9];
                                                        v32 = v14_1;
                                                        Object v14_2 = v28;
                                                        Anchor v15_1 = ((RecomposeScopeImpl)v14_2).getAnchor();
                                                        if(v15_1 != null && (v3.inGroup(v1, v15_1))) {
                                                            ((List)v2).add(TuplesKt.to(v14_2, v12_1));
                                                            ((MutableScatterSet)v13_1).removeElementAt(v9);
                                                        }
                                                    }
                                                    else {
                                                        v31 = v9;
                                                        v30 = v12;
                                                        v32 = v14_1;
                                                    }

                                                    v14_1 = v32 >> v19;
                                                    v12 = v30 + 1;
                                                    v9 = v31;
                                                }

                                                v31 = v9;
                                                if(v11 != v19) {
                                                    break;
                                                }
                                            }
                                            else {
                                                v31 = v9;
                                            }

                                            if(v8_1 == v4_1) {
                                                break;
                                            }

                                            ++v8_1;
                                            v12_1 = v28;
                                            v11_1 = v29;
                                            v9 = v31;
                                            v19 = 8;
                                        }
                                    }
                                    else {
                                        v31 = v15;
                                    }

                                    v4_2 = ((MutableScatterSet)v13_1).isEmpty();
                                }
                                else {
                                    v24 = v4;
                                    v25 = v8;
                                    v31 = v15;
                                    Intrinsics.checkNotNull(v13_1, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                    v12_1 = v12_1;
                                    Anchor v4_3 = ((RecomposeScopeImpl)v12_1).getAnchor();
                                    if(v4_3 != null && (v3.inGroup(v1, v4_3))) {
                                        ((List)v2).add(TuplesKt.to(v12_1, v13_1));
                                        v4_2 = true;
                                        goto label_129;
                                    }

                                    v4_2 = false;
                                }

                            label_129:
                                if(v4_2) {
                                    v0_1.removeValueAt(v6);
                                }

                                v9 = 8;
                            }
                            else {
                                v24 = v4;
                                v25 = v8;
                                v18 = v12;
                                v22 = v13;
                                v31 = v15;
                                v9 = v11;
                            }

                            v15 = v31 + 1;
                            v11 = v9;
                            v8 = v25 >> v9;
                            v12 = v18;
                            v13 = v22;
                            v4 = v24;
                        }

                        v24 = v4;
                        if(v10 != v11) {
                            break;
                        }
                    }
                    else {
                        v24 = v4;
                    }

                    if(v7 == v5) {
                        break;
                    }

                    ++v7;
                    v4 = v24;
                }
            }

            return ((List)v2);
        }

        return CollectionsKt.emptyList();
    }

    public final List extractInvalidationsOfGroup$runtime(Function1 arg34) {
        boolean v3_2;
        int v32;
        Object v29;
        int v7_1;
        long v30;
        int v27;
        long v25;
        long[] v18;
        long v21;
        int v17;
        Function1 v0 = arg34;
        if(ScopeMap.getSize-impl(this.invalidations) > 0) {
            ArrayList v1 = new ArrayList();
            MutableScatterMap v2 = this.invalidations;
            long[] v3 = v2.metadata;
            int v4 = v3.length - 2;
            if(v4 >= 0) {
                int v6 = 0;
                while(true) {
                    long v7 = v3[v6];
                    int v11 = 7;
                    long v12 = -9187201950435737472L;
                    if((~v7 << v11 & v7 & v12) != v12) {
                        int v10 = 8;
                        int v9 = 8 - (~(v6 - v4) >>> 0x1F);
                        int v14 = 0;
                        while(v14 < v9) {
                            long v15 = 0xFF;
                            long v19 = 0x80;
                            if((v7 & v15) < v19) {
                                int v5 = (v6 << 3) + v14;
                                v17 = v11;
                                Object v11_1 = v2.keys[v5];
                                v21 = v12;
                                Object v12_1 = v2.values[v5];
                                Intrinsics.checkNotNull(v11_1, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
                                if((v12_1 instanceof MutableScatterSet)) {
                                    Intrinsics.checkNotNull(v12_1, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                    Object[] v13 = ((MutableScatterSet)v12_1).elements;
                                    long v23 = v15;
                                    long[] v15_1 = v12_1.metadata;
                                    int v16 = v10;
                                    v10 = v15_1.length - 2;
                                    v18 = v3;
                                    v25 = v7;
                                    if(v10 >= 0) {
                                        int v3_1 = 0;
                                        while(true) {
                                            v7 = v15_1[v3_1];
                                            Object[] v28 = v13;
                                            v27 = v14;
                                            if((~v7 << v17 & v7 & v21) != v21) {
                                                int v13_1 = 8 - (~(v3_1 - v10) >>> 0x1F);
                                                v14 = 0;
                                                while(v14 < v13_1) {
                                                    if((v7 & v23) < v19) {
                                                        v30 = v7;
                                                        v7_1 = (v3_1 << 3) + v14;
                                                        Object v8 = v28[v7_1];
                                                        v29 = v11_1;
                                                        v11_1 = v29;
                                                        v32 = v14;
                                                        Anchor v14_1 = ((RecomposeScopeImpl)v11_1).getAnchor();
                                                        if(v14_1 != null && (v0.invoke(v14_1).booleanValue())) {
                                                            ((List)v1).add(TuplesKt.to(v11_1, v8));
                                                            ((MutableScatterSet)v12_1).removeElementAt(v7_1);
                                                        }
                                                    }
                                                    else {
                                                        v30 = v7;
                                                        v29 = v11_1;
                                                        v32 = v14;
                                                    }

                                                    v7 = v30 >> v16;
                                                    v14 = v32 + 1;
                                                    v11_1 = v29;
                                                }

                                                v29 = v11_1;
                                                if(v13_1 != v16) {
                                                    break;
                                                }
                                            }
                                            else {
                                                v29 = v11_1;
                                            }

                                            if(v3_1 == v10) {
                                                break;
                                            }

                                            ++v3_1;
                                            v14 = v27;
                                            v13 = v28;
                                            v11_1 = v29;
                                            v16 = 8;
                                        }
                                    }
                                    else {
                                        v27 = v14;
                                    }

                                    v3_2 = ((MutableScatterSet)v12_1).isEmpty();
                                }
                                else {
                                    v18 = v3;
                                    v25 = v7;
                                    v27 = v14;
                                    Intrinsics.checkNotNull(v12_1, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                    v11_1 = v11_1;
                                    Anchor v3_3 = ((RecomposeScopeImpl)v11_1).getAnchor();
                                    if(v3_3 != null && (v0.invoke(v3_3).booleanValue())) {
                                        ((List)v1).add(TuplesKt.to(v11_1, v12_1));
                                        v3_2 = true;
                                        goto label_128;
                                    }

                                    v3_2 = false;
                                }

                            label_128:
                                if(v3_2) {
                                    v2.removeValueAt(v5);
                                }

                                v7_1 = 8;
                            }
                            else {
                                v18 = v3;
                                v25 = ((long)v7_1);
                                v17 = v11;
                                v21 = v12;
                                v27 = v14;
                                v7_1 = v10;
                            }

                            v14 = v27 + 1;
                            v10 = v7_1;
                            v7 = v25 >> v7_1;
                            v11 = v17;
                            v3 = v18;
                            v12 = v21;
                        }

                        v18 = v3;
                        if(v9 != v10) {
                            break;
                        }
                    }
                    else {
                        v18 = v3;
                    }

                    if(v6 == v4) {
                        break;
                    }

                    ++v6;
                    v3 = v18;
                }
            }

            return ((List)v1);
        }

        return CollectionsKt.emptyList();
    }

    private static void getAbandonSet$annotations() {
    }

    public ShouldPauseCallback getAndSetShouldPauseCallback(ShouldPauseCallback arg2) {
        ShouldPauseCallback v0 = this.shouldPause;
        this.shouldPause = arg2;
        return v0;
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime();
    }

    public final Function2 getComposable() {
        return this.composable;
    }

    public final InternalComposer getComposer$runtime() {
        return this.composer;
    }

    public Object getCompositionService(CompositionServiceKey arg2) {
        if(Intrinsics.areEqual(arg2, CompositionKt.getObservableCompositionServiceKey())) {
            return this;
        }

        return null;
    }

    public final List getConditionalScopes$runtime() {
        return CollectionsKt.toList(this.conditionallyInvalidatedScopes.asSet());
    }

    public final Set getDerivedStateDependencies$runtime() {
        return this.derivedStates.asMap().keySet();
    }

    public boolean getHasInvalidations() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(ScopeMap.getSize-impl(this.invalidations) <= 0) {
                goto label_7;
            }
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        boolean v1_1 = true;
        goto label_8;
    label_7:
        v1_1 = false;
    label_8:
        __monitor_exit(v0);
        return v1_1;
    }

    public boolean getHasPendingChanges() {
        boolean v1_1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1_1 = this.composer.getHasPendingChanges$runtime();
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    public final Set getObservedObjects$runtime() {
        return this.observations.asMap().keySet();
    }

    public final CompositionObserverHolder getObserverHolder$runtime() {
        return this.observerHolder;
    }

    public final CompositionContext getParent() {
        return this.parent;
    }

    public final boolean getPendingInvalidScopes$runtime() {
        return this.pendingInvalidScopes;
    }

    public static void getPendingInvalidScopes$runtime$annotations() {
    }

    public final SlotStorage getSlotStorage$runtime() {
        return this.slotStorage;
    }

    public static void getSlotStorage$runtime$annotations() {
    }

    private final Object guardChanges(Function0 arg4) {
        CompositionErrorContextImpl v2;
        Set v1;
        RememberEventDispatcher v0;
        Object v3;
        try {
            v3 = arg4.invoke();
            return v3;
        }
        catch(Throwable v4) {
            try {
                if(!((CompositionImpl)v3).abandonSet.isEmpty()) {
                    v0 = ((CompositionImpl)v3).rememberManager;
                    v1 = ((CompositionImpl)v3).abandonSet;
                    v2 = ((CompositionImpl)v3).composer.getErrorContext$runtime();
                    goto label_10;
                }

                goto label_17;
            }
            catch(Throwable v4) {
                goto label_19;
            }

            try {
            label_10:
                v0.prepare(v1, ((CompositionErrorContext)v2));
            }
            catch(Throwable v4) {
                goto label_19;
            }
            catch(Throwable v4) {
                goto label_15;
            }

            try {
                v0.dispatchAbandons();
                goto label_12;
            }
            catch(Throwable v4) {
                try {
                label_15:
                    v0.clear();
                    throw v4;
                label_12:
                    v0.clear();
                label_17:
                    throw v4;
                }
                catch(Throwable v4) {
                label_19:
                    ((CompositionImpl)v3).abandonChanges();
                    throw v4;
                }
            }
        }
    }

    private final Object guardInvalidationsLocked(Function1 arg3) {
        Object v2;
        MutableScatterMap v0 = this.takeInvalidations-afanTW4();
        try {
            v2 = arg3.invoke(ScopeMap.box-impl(v0));
            return v2;
        }
        catch(Throwable v3) {
            ((CompositionImpl)v2).invalidations = v0;
            throw v3;
        }
    }

    public void insertMovableContent(List arg5) {
        CompositionErrorContextImpl v2_1;
        Set v1_1;
        RememberEventDispatcher v0_1;
        Unit v4;
        int v0 = arg5.size();
        int v1 = 0;
        int v2 = 0;
        while(true) {
            if(v2 >= v0) {
                break;
            }
            else if(!Intrinsics.areEqual(arg5.get(v2).getFirst().getComposition$runtime(), this)) {
            }
            else {
                ++v2;
                continue;
            }

            goto label_14;
        }

        v1 = 1;
    label_14:
        if(v1 == 0) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }

        try {
            this.composer.insertMovableContentReferences(arg5);
            v4 = Unit.INSTANCE;
            return;
        }
        catch(Throwable v5) {
            try {
                if(!((CompositionImpl)v4).abandonSet.isEmpty()) {
                    v0_1 = ((CompositionImpl)v4).rememberManager;
                    v1_1 = ((CompositionImpl)v4).abandonSet;
                    v2_1 = ((CompositionImpl)v4).composer.getErrorContext$runtime();
                    goto label_29;
                }

                goto label_36;
            }
            catch(Throwable v5) {
                goto label_38;
            }

            try {
            label_29:
                v0_1.prepare(v1_1, ((CompositionErrorContext)v2_1));
            }
            catch(Throwable v5) {
                goto label_38;
            }
            catch(Throwable v5) {
                goto label_34;
            }

            try {
                v0_1.dispatchAbandons();
                goto label_31;
            }
            catch(Throwable v5) {
                try {
                label_34:
                    v0_1.clear();
                    throw v5;
                label_31:
                    v0_1.clear();
                label_36:
                    throw v5;
                }
                catch(Throwable v5) {
                label_38:
                    ((CompositionImpl)v4).abandonChanges();
                    throw v5;
                }
            }
        }
    }

    public InvalidationResult invalidate(RecomposeScopeImpl arg4, Object arg5) {
        if(arg4.getDefaultsInScope()) {
            arg4.setDefaultsInvalid(true);
        }

        Anchor v0 = arg4.getAnchor();
        if(v0 != null) {
            if(!v0.getValid()) {
            }
            else if(!this.slotStorage.ownsRecomposeScope(arg4)) {
                Object v0_1 = this.lock;
                __monitor_enter(v0_1);
                try {
                    this = this.invalidationDelegate;
                }
                catch(Throwable v3) {
                    __monitor_exit(v0_1);
                    throw v3;
                }

                __monitor_exit(v0_1);
                if(this != null && (this.tryImminentInvalidation(arg4, arg5))) {
                    return InvalidationResult.IMMINENT;
                }

                return InvalidationResult.IGNORED;
            }
            else {
                if(!arg4.getCanRecompose()) {
                    return InvalidationResult.IGNORED;
                }

                InvalidationResult v0_2 = this.invalidateChecked(arg4, v0, arg5);
                if(v0_2 != InvalidationResult.IGNORED) {
                    CompositionObserver v3_1 = this.observer();
                    if(v3_1 != null) {
                        v3_1.onScopeInvalidated(((RecomposeScope)arg4), arg5);
                    }
                }

                return v0_2;
            }
        }

        return InvalidationResult.IGNORED;
    }

    public void invalidateAll() {
        this.slotStorage.invalidateAll();
    }

    private final InvalidationResult invalidateChecked(RecomposeScopeImpl arg21, Anchor arg22, Object arg23) {
        int v16;
        InvalidationResult v0_2;
        CompositionImpl v6;
        CompositionImpl v0 = this;
        RecomposeScopeImpl v1 = arg21;
        Anchor v2 = arg22;
        Object v3 = arg23;
        Object v4 = v0.lock;
        __monitor_enter(v4);
        try {
            CompositionImpl v5 = v0.invalidationDelegate;
            v6 = null;
            if(v5 != null) {
                if(v0.slotStorage.groupContainsAnchor(v0.invalidationDelegateGroup, v2)) {
                }
                else {
                    v5 = v6;
                }

                v6 = v5;
            }

            if(v6 == null) {
                if(v0.tryImminentInvalidation(v1, v3)) {
                    v0_2 = InvalidationResult.IMMINENT;
                    goto label_20;
                }
                else {
                    goto label_22;
                }
            }

            goto label_84;
        }
        catch(Throwable v0_1) {
            goto label_98;
        }

    label_20:
        __monitor_exit(v4);
        return v0_2;
    label_22:
        if(v3 == null) {
            try {
                ScopeMap.set-impl(v0.invalidations, v1, ScopeInvalidated.INSTANCE);
                goto label_84;
            label_27:
                boolean v5_1 = v3 instanceof DerivedState;
                goto label_28;
            }
            catch(Throwable v0_1) {
                goto label_98;
            }
        }
        else {
            goto label_27;
        label_28:
            MutableScatterMap v7 = v0.invalidations;
            if(!v5_1) {
                try {
                    ScopeMap.set-impl(v7, v1, ScopeInvalidated.INSTANCE);
                    goto label_84;
                label_33:
                    Object v5_2 = v7.get(v1);
                    if(v5_2 != null) {
                        if((v5_2 instanceof MutableScatterSet)) {
                            Object[] v7_1 = ((ScatterSet)v5_2).elements;
                            long[] v5_3 = ((ScatterSet)v5_2).metadata;
                            int v8 = v5_3.length - 2;
                            if(v8 >= 0) {
                                int v10;
                                for(v10 = 0; true; ++v10) {
                                    long v11 = v5_3[v10];
                                    if((~v11 << 7 & v11 & -9187201950435737472L) != -9187201950435737472L) {
                                        int v14 = 8;
                                        int v13 = 8 - (~(v10 - v8) >>> 0x1F);
                                        int v15 = 0;
                                        while(v15 < v13) {
                                            if((v11 & 0xFF) < 0x80) {
                                                v16 = v14;
                                                if(v7_1[(v10 << 3) + v15] == ScopeInvalidated.INSTANCE) {
                                                    goto label_84;
                                                }
                                            }
                                            else {
                                                v16 = v14;
                                            }

                                            v11 >>= v16;
                                            ++v15;
                                            v14 = v16;
                                        }

                                        if(v13 != v14) {
                                            break;
                                        }
                                    }

                                    if(v10 == v8) {
                                        break;
                                    }
                                }
                            }
                        }
                        else {
                            if(v5_2 != ScopeInvalidated.INSTANCE) {
                                goto label_82;
                            }

                            goto label_84;
                        }
                    }

                label_82:
                    ScopeMap.add-impl(v0.invalidations, v1, v3);
                }
                catch(Throwable v0_1) {
                label_98:
                    __monitor_exit(v4);
                    throw v0_1;
                }
            }
            else {
                goto label_33;
            }
        }

    label_84:
        __monitor_exit(v4);
        if(v6 != null) {
            return v6.invalidateChecked(v1, v2, v3);
        }

        v0.parent.invalidate$runtime(v0);
        if(v0.isComposing()) {
            return InvalidationResult.DEFERRED;
        }

        return InvalidationResult.SCHEDULED;
    }

    public final void invalidateGroupsWithKey(int arg5) {
        List v5;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            v5 = this.slotStorage.invalidateGroupsWithKey(arg5);
        }
        catch(Throwable v4) {
            __monitor_exit(v0);
            throw v4;
        }

        __monitor_exit(v0);
        if(v5 != null) {
            int v0_1 = v5.size();
            int v1 = 0;
            while(true) {
                if(v1 >= v0_1) {
                    return;
                }
                else if(v5.get(v1).invalidateForResult(null) == InvalidationResult.IGNORED) {
                }
                else {
                    ++v1;
                    continue;
                }

                goto label_19;
            }

            return;
        }

    label_19:
        if(this.composer.forceRecomposeScopes$runtime()) {
            this.parent.invalidate$runtime(((ControlledComposition)this));
        }
    }

    private final void invalidateScopeOfLocked(Object arg15) {
        Object v0 = this.observations.get(arg15);
        if(v0 != null) {
            if((v0 instanceof MutableScatterSet)) {
                Object[] v1 = ((ScatterSet)v0).elements;
                long[] v0_1 = ((ScatterSet)v0).metadata;
                int v2 = v0_1.length - 2;
                if(v2 >= 0) {
                    int v4;
                    for(v4 = 0; true; ++v4) {
                        long v5 = v0_1[v4];
                        if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                            int v8 = 8;
                            int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                            int v9;
                            for(v9 = 0; v9 < v7; ++v9) {
                                if((0xFF & v5) < 0x80) {
                                    Object v10 = v1[(v4 << 3) + v9];
                                    if(((RecomposeScopeImpl)v10).invalidateForResult(arg15) == InvalidationResult.IMMINENT) {
                                        ScopeMap.add-impl(this.observationsProcessed, arg15, v10);
                                    }
                                }

                                v5 >>= v8;
                            }

                            if(v7 != v8) {
                                return;
                            }
                        }

                        if(v4 == v2) {
                            return;
                        }
                    }
                }
            }
            else {
                if(((RecomposeScopeImpl)v0).invalidateForResult(arg15) != InvalidationResult.IMMINENT) {
                    return;
                }

                ScopeMap.add-impl(this.observationsProcessed, arg15, v0);
            }
        }
    }

    public boolean isComposing() {
        return this.composer.isComposing$runtime();
    }

    public boolean isDisposed() {
        if(this.state == 3) {
            return 1;
        }

        return 0;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    private final CompositionObserver observer() {
        return this.observerHolder.current();
    }

    public boolean observesAnyOf(Set arg15) {
        if((arg15 instanceof ScatterSetWrapper)) {
            ScatterSet v15 = ((ScatterSetWrapper)arg15).getSet$runtime();
            Object[] v0 = v15.elements;
            long[] v15_1 = v15.metadata;
            int v3 = v15_1.length - 2;
            if(v3 >= 0) {
                int v4;
                for(v4 = 0; true; ++v4) {
                    long v5 = v15_1[v4];
                    if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                        int v8 = 8;
                        int v7 = 8 - (~(v4 - v3) >>> 0x1F);
                        int v9;
                        for(v9 = 0; v9 < v7; ++v9) {
                            if((0xFF & v5) < 0x80) {
                                Object v10 = v0[(v4 << 3) + v9];
                                if(!ScopeMap.contains-impl(this.observations, v10) && !ScopeMap.contains-impl(this.derivedStates, v10)) {
                                    goto label_40;
                                }

                                return 1;
                            }

                        label_40:
                            v5 >>= v8;
                        }

                        if(v7 != v8) {
                            return 0;
                        }
                    }

                    if(v4 == v3) {
                        return 0;
                    }
                }
            }
        }
        else {
            Iterator v15_2 = ((Iterable)arg15).iterator();
            do {
                if(!v15_2.hasNext()) {
                    return 0;
                }

                Object v0_1 = v15_2.next();
                if(ScopeMap.contains-impl(this.observations, v0_1)) {
                    return 1;
                }
            }
            while(!ScopeMap.contains-impl(this.derivedStates, v0_1));

            return 1;
        }

        return 0;
    }

    public final void pausedCompositionFinished$runtime(ScatterSet arg2) {
        this.pendingPausedComposition = null;
        if(arg2 != null) {
            this.rememberManager.ignoreForgotten(arg2);
            this.state = 2;
        }
    }

    public void prepareCompose(Function0 arg1) {
        this.composer.prepareCompose$runtime(arg1);
    }

    public boolean recompose() {
        CompositionErrorContextImpl v4;
        Set v3;
        RememberEventDispatcher v2_2;
        boolean v2_1;
        MutableScatterMap v1_2;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            PausedCompositionImpl v1 = this.pendingPausedComposition;
            if(v1 != null && !v1.isRecomposing$runtime()) {
                v1.markIncomplete$runtime();
                v1.getPausableApplier$runtime().markRecomposePending();
                goto label_9;
            }

            goto label_12;
        }
        catch(Throwable v5) {
            goto label_44;
        }

    label_9:
        __monitor_exit(v0);
        return 0;
        try {
        label_12:
            this.drainPendingModificationsForCompositionLocked();
        }
        catch(Throwable v5) {
            goto label_44;
        }

        try {
            v1_2 = this.takeInvalidations-afanTW4();
        }
        catch(Throwable v1_1) {
            goto label_25;
        }

        try {
            v2_1 = this.composer.recompose-aFTiNEg$runtime(v1_2, this.shouldPause);
            if(!v2_1) {
                this.drainPendingModificationsLocked();
            }
        }
        catch(Throwable v2) {
            try {
                this.invalidations = v1_2;
                throw v2;
            }
            catch(Throwable v1_1) {
                try {
                label_25:
                    if(!this.abandonSet.isEmpty()) {
                        v2_2 = this.rememberManager;
                        v3 = this.abandonSet;
                        v4 = this.composer.getErrorContext$runtime();
                        goto label_32;
                    }

                    goto label_39;
                }
                catch(Throwable v1_1) {
                    goto label_41;
                }

                try {
                label_32:
                    v2_2.prepare(v3, ((CompositionErrorContext)v4));
                }
                catch(Throwable v1_1) {
                    goto label_41;
                }
                catch(Throwable v1_1) {
                    goto label_37;
                }

                try {
                    v2_2.dispatchAbandons();
                    goto label_34;
                }
                catch(Throwable v1_1) {
                    try {
                    label_37:
                        v2_2.clear();
                        throw v1_1;
                    label_34:
                        v2_2.clear();
                    label_39:
                        throw v1_1;
                    }
                    catch(Throwable v1_1) {
                        try {
                        label_41:
                            this.abandonChanges();
                            throw v1_1;
                        }
                        catch(Throwable v5) {
                        label_44:
                            __monitor_exit(v0);
                            throw v5;
                        }
                    }
                }
            }
        }

        __monitor_exit(v0);
        return v2_1;
    }

    public void recomposeScopeReleased(RecomposeScopeImpl arg2) {
        this.pendingInvalidScopes = true;
        CompositionObserver v1 = this.observer();
        if(v1 != null) {
            v1.onScopeDisposed(((RecomposeScope)arg2));
        }
    }

    public void recordModificationsOf(Set arg4) {
        do {
            Object v0 = this.pendingModifications.get();
            if(v0 == null || (Intrinsics.areEqual(v0, CompositionKt.access$getPendingApplyNoModifications$p()))) {
                Set v1_2 = arg4;
            }
            else if((v0 instanceof Set)) {
                Set[] v1 = new Set[]{v0, arg4};
            }
            else if((v0 instanceof Object[])) {
                Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                Object[] v1_1 = ArraysKt.plus(v0, arg4);
            }
            else {
                throw new IllegalStateException("corrupt pendingModifications: " + this.pendingModifications.toString());
            }
        }
        while(!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingModifications, v0, v1_2));

        if(v0 == null) {
            Object v4 = this.lock;
            __monitor_enter(v4);
            try {
                this.drainPendingModificationsLocked();
            }
            catch(Throwable v3) {
                __monitor_exit(v4);
                throw v3;
            }

            __monitor_exit(v4);
            return;
        }
    }

    public void recordReadOf(Object arg21) {
        int v18;
        int v17;
        CompositionImpl v0 = this;
        Object v1 = arg21;
        if(!v0.getAreChildrenComposing()) {
            RecomposeScopeImpl v2 = v0.composer.getCurrentRecomposeScope$runtime();
            if(v2 != null) {
                int v3 = 1;
                v2.setUsed(true);
                boolean v4 = v2.recordRead(v1);
                CompositionObserver v5 = v0.observer();
                if(v5 != null) {
                    v5.onReadInScope(v2, v1);
                }

                if(v4) {
                    return;
                }

                if((v1 instanceof StateObjectImpl)) {
                    v1.recordReadIn-h_f27i8$runtime(ReaderKind.constructor-impl(1));
                }

                ScopeMap.add-impl(v0.observations, v1, v2);
                if(!(v1 instanceof DerivedState)) {
                    return;
                }

                Object v4_1 = v1;
                Record v5_1 = ((DerivedState)v4_1).getCurrentRecord();
                ScopeMap.removeScope-impl(v0.derivedStates, v1);
                ObjectIntMap v6 = v5_1.getDependencies();
                Object[] v7 = v6.keys;
                long[] v6_1 = v6.metadata;
                int v8 = v6_1.length - 2;
                if(v8 >= 0) {
                    int v10 = 0;
                    while(true) {
                        long v11 = v6_1[v10];
                        if((~v11 << 7 & v11 & -9187201950435737472L) != -9187201950435737472L) {
                            int v14 = 8;
                            int v13 = 8 - (~(v10 - v8) >>> 0x1F);
                            int v15 = 0;
                            while(v15 < v13) {
                                if((v11 & 0xFF) < 0x80) {
                                    v17 = v3;
                                    Object v3_1 = v7[(v10 << 3) + v15];
                                    if((v3_1 instanceof StateObjectImpl)) {
                                        v18 = v14;
                                        v3_1.recordReadIn-h_f27i8$runtime(ReaderKind.constructor-impl(v17));
                                    }
                                    else {
                                        v18 = v14;
                                    }

                                    ScopeMap.add-impl(v0.derivedStates, v3_1, v1);
                                }
                                else {
                                    v17 = v3;
                                    v18 = v14;
                                }

                                v11 >>= v18;
                                ++v15;
                                v3 = v17;
                                v14 = v18;
                            }

                            v17 = v3;
                            if(v13 != v14) {
                                break;
                            }
                        }
                        else {
                            v17 = v3;
                        }

                        if(v10 == v8) {
                            break;
                        }

                        ++v10;
                        v3 = v17;
                    }
                }

                v2.recordDerivedStateValue(((DerivedState)v4_1), v5_1.getCurrentValue());
            }
        }
    }

    public void recordWriteOf(Object arg15) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.invalidateScopeOfLocked(arg15);
            arg15 = this.derivedStates.get(arg15);
            if(arg15 != null) {
                if((arg15 instanceof MutableScatterSet)) {
                    Object[] v1 = ((ScatterSet)arg15).elements;
                    long[] v15 = ((ScatterSet)arg15).metadata;
                    int v2 = v15.length - 2;
                    if(v2 >= 0) {
                        int v4;
                        for(v4 = 0; true; ++v4) {
                            long v5 = v15[v4];
                            if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                                int v8 = 8;
                                int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                                int v9;
                                for(v9 = 0; v9 < v7; ++v9) {
                                    if((0xFF & v5) < 0x80) {
                                        this.invalidateScopeOfLocked(v1[(v4 << 3) + v9]);
                                    }

                                    v5 >>= v8;
                                }

                                if(v7 != v8) {
                                    break;
                                }
                            }

                            if(v4 == v2) {
                                break;
                            }
                        }
                    }
                }
                else {
                    this.invalidateScopeOfLocked(arg15);
                }
            }
        }
        catch(Throwable v14) {
            __monitor_exit(v0);
            throw v14;
        }

        __monitor_exit(v0);
    }

    public final void removeDerivedStateObservation$runtime(DerivedState arg2) {
        if(!ScopeMap.contains-impl(this.observations, arg2)) {
            ScopeMap.removeScope-impl(this.derivedStates, arg2);
        }
    }

    public final void removeObservation$runtime(Object arg1, RecomposeScopeImpl arg2) {
        ScopeMap.remove-impl(this.observations, arg1, arg2);
    }

    public final void setComposable(Function2 arg1) {
        this.composable = arg1;
    }

    public void setContent(Function2 arg2) {
        boolean v0 = this.clearDeactivated();
        this.ensureRunning();
        if(v0) {
            this.composeInitialWithReuse(arg2);
            return;
        }

        this.composeInitial(arg2);
    }

    public void setContentWithReuse(Function2 arg1) {
        this.clearDeactivated();
        this.ensureRunning();
        this.composeInitialWithReuse(arg1);
    }

    public CompositionObserverHandle setObserver(CompositionObserver arg4) {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.observerHolder.setObserver(arg4);
            this.observerHolder.setRoot(true);
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
        return new CompositionImpl$setObserver$2(this, arg4);
    }

    public PausedComposition setPausableContent(Function2 arg2) {
        return this.composeInitialPaused(this.clearDeactivated(), arg2);
    }

    public PausedComposition setPausableContentWithReuse(Function2 arg2) {
        this.clearDeactivated();
        this.ensureRunning();
        return this.composeInitialPaused(true, arg2);
    }

    public final void setPendingInvalidScopes$runtime(boolean arg1) {
        this.pendingInvalidScopes = arg1;
    }

    private final MutableScatterMap takeInvalidations-afanTW4() {
        MutableScatterMap v0 = this.invalidations;
        this.invalidations = ScopeMap.constructor-impl$default(null, 1, null);
        return v0;
    }

    private final Object trackAbandonedValues(Function0 arg3) {
        Object v2;
        try {
            v2 = arg3.invoke();
            return v2;
        }
        catch(Throwable v3) {
            if(!((CompositionImpl)v2).abandonSet.isEmpty()) {
                RememberEventDispatcher v0 = ((CompositionImpl)v2).rememberManager;
                Set v1 = ((CompositionImpl)v2).abandonSet;
                CompositionErrorContextImpl v2_1 = ((CompositionImpl)v2).composer.getErrorContext$runtime();
                try {
                    v0.prepare(v1, ((CompositionErrorContext)v2_1));
                    v0.dispatchAbandons();
                }
                catch(Throwable v2_2) {
                    v0.clear();
                    throw v2_2;
                }

                v0.clear();
            }

            throw v3;
        }
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl arg2, Object arg3) {
        if((this.isComposing()) && (this.composer.tryImminentInvalidation$runtime(arg2, arg3))) {
            return 1;
        }

        return 0;
    }

    public final void updateMovingInvalidations$runtime() {
        Unit v3_1;
        MutableScatterMap v1;
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.drainPendingModificationsOutOfBandLocked();
            v1 = this.takeInvalidations-afanTW4();
        }
        catch(Throwable v3) {
            goto label_14;
        }

        try {
            this.composer.updateComposerInvalidations-RY85e9Y$runtime(v1);
            v3_1 = Unit.INSTANCE;
            goto label_7;
        }
        catch(Throwable v2) {
            try {
                ((CompositionImpl)v3_1).invalidations = v1;
                throw v2;
            label_7:
            }
            catch(Throwable v3) {
            label_14:
                __monitor_exit(v0);
                throw v3;
            }
        }

        __monitor_exit(v0);
    }

    public void verifyConsistent() {
        Object v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(!this.isComposing()) {
                this.composer.verifyConsistent$runtime();
                this.slotStorage.verifyWellFormed();
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }
}

