package androidx.compose.runtime;

import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.GroupKind;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.GapAnchorKt;
import androidx.compose.runtime.composer.gapbuffer.KeyInfo;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.ChangeList;
import androidx.compose.runtime.composer.gapbuffer.changelist.ChangeListKt;
import androidx.compose.runtime.composer.gapbuffer.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.FixupList;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.ComposeStackTraceBuilderKt;
import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.compose.runtime.tooling.CompositionErrorContextKt;
import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.runtime.tooling.ObjectLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000·\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\f\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u000B*\u0001?\b\u0001\u0018\u00002\u00020\u0001:\u0004\u0087\u0003\u0088\u0003BQ\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\f\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010r\u001A\u00020s2\u0006\u0010t\u001A\u00020\u001EH\u0017J\b\u0010u\u001A\u00020sH\u0017J\u0010\u0010v\u001A\u00020s2\u0006\u0010t\u001A\u00020\u001EH\u0017J\b\u0010w\u001A\u00020sH\u0017J\b\u0010x\u001A\u00020sH\u0017J\b\u0010y\u001A\u00020sH\u0017J\u001B\u0010~\u001A\u00020s2\u0006\u0010t\u001A\u00020\u001E2\t\u0010\u007F\u001A\u0005\u0018\u00010\u0080\u0001H\u0017J\t\u0010\u0081\u0001\u001A\u00020sH\u0017J\t\u0010\u0082\u0001\u001A\u00020sH\u0002J\t\u0010\u0083\u0001\u001A\u00020sH\u0002J\t\u0010\u0084\u0001\u001A\u00020sH\u0002J\u000F\u0010\u0085\u0001\u001A\u00020sH\u0010¢\u0006\u0003\b\u0086\u0001J\t\u0010\u0094\u0001\u001A\u00020sH\u0016J\u001A\u0010\u0095\u0001\u001A\u00030\u0096\u00012\u000E\u0010\u0097\u0001\u001A\t\u0012\u0004\u0012\u00020s0\u0098\u0001H\u0016J\u000F\u0010\u0099\u0001\u001A\u00020sH\u0010¢\u0006\u0003\b\u009A\u0001J\u000F\u0010\u009B\u0001\u001A\u00020sH\u0010¢\u0006\u0003\b\u009C\u0001J\u000E\u0010\'\u001A\u00020(H\u0010¢\u0006\u0003\b\u009D\u0001J\u0011\u0010\u009E\u0001\u001A\u00020s2\u0006\u0010t\u001A\u00020\u001EH\u0002J\u001C\u0010\u009E\u0001\u001A\u00020s2\u0006\u0010t\u001A\u00020\u001E2\t\u0010\u007F\u001A\u0005\u0018\u00010\u0080\u0001H\u0002J\t\u0010\u009F\u0001\u001A\u00020sH\u0002J\t\u0010 \u0001\u001A\u00020sH\u0002J\t\u0010¡\u0001\u001A\u00020sH\u0016J\t\u0010¢\u0001\u001A\u00020sH\u0016J!\u0010£\u0001\u001A\u00020s\"\u0005\b\u0000\u0010¤\u00012\u000F\u0010¥\u0001\u001A\n\u0012\u0005\u0012\u0003H¤\u00010\u0098\u0001H\u0016J\t\u0010¦\u0001\u001A\u00020sH\u0016J\t\u0010§\u0001\u001A\u00020sH\u0016J\u001C\u0010¨\u0001\u001A\u00020s2\u0006\u0010t\u001A\u00020\u001E2\t\u0010\u007F\u001A\u0005\u0018\u00010\u0080\u0001H\u0016J\t\u0010©\u0001\u001A\u00020sH\u0016J\t\u0010ª\u0001\u001A\u00020sH\u0016J\t\u0010«\u0001\u001A\u00020sH\u0016J\u000F\u0010¬\u0001\u001A\u00020sH\u0010¢\u0006\u0003\b­\u0001J\u000F\u0010®\u0001\u001A\u00020sH\u0010¢\u0006\u0003\b¯\u0001J\u0012\u0010³\u0001\u001A\u00020s2\u0007\u0010´\u0001\u001A\u00020\u001EH\u0016JJ\u0010µ\u0001\u001A\u00020s\"\u0005\b\u0000\u0010¶\u0001\"\u0005\b\u0001\u0010¤\u00012\u0007\u0010C\u001A\u0003H¶\u00012\"\u0010·\u0001\u001A\u001D\u0012\u0005\u0012\u0003H¤\u0001\u0012\u0005\u0012\u0003H¶\u0001\u0012\u0004\u0012\u00020s0¸\u0001¢\u0006\u0003\b¹\u0001H\u0016¢\u0006\u0003\u0010º\u0001J\"\u0010»\u0001\u001A\u00030\u0080\u00012\n\u0010¼\u0001\u001A\u0005\u0018\u00010\u0080\u00012\n\u0010½\u0001\u001A\u0005\u0018\u00010\u0080\u0001H\u0017J\f\u0010¾\u0001\u001A\u0005\u0018\u00010\u0080\u0001H\u0001J\f\u0010¿\u0001\u001A\u0005\u0018\u00010\u0080\u0001H\u0001J\u0014\u0010À\u0001\u001A\u00020(2\t\u0010C\u001A\u0005\u0018\u00010\u0080\u0001H\u0017J\u0014\u0010Á\u0001\u001A\u00020(2\t\u0010C\u001A\u0005\u0018\u00010\u0080\u0001H\u0017J\u0012\u0010À\u0001\u001A\u00020(2\u0007\u0010C\u001A\u00030Â\u0001H\u0017J\u0012\u0010À\u0001\u001A\u00020(2\u0007\u0010C\u001A\u00030Ã\u0001H\u0017J\u0012\u0010À\u0001\u001A\u00020(2\u0007\u0010C\u001A\u00030Ä\u0001H\u0017J\u0011\u0010À\u0001\u001A\u00020(2\u0006\u0010C\u001A\u00020(H\u0017J\u0012\u0010À\u0001\u001A\u00020(2\u0007\u0010C\u001A\u00030Å\u0001H\u0017J\u0012\u0010À\u0001\u001A\u00020(2\u0007\u0010C\u001A\u00030\u008D\u0001H\u0017J\u0012\u0010À\u0001\u001A\u00020(2\u0007\u0010C\u001A\u00030Æ\u0001H\u0017J\u0011\u0010À\u0001\u001A\u00020(2\u0006\u0010C\u001A\u00020\u001EH\u0017J2\u0010Ç\u0001\u001A\u0003H¤\u0001\"\u0005\b\u0000\u0010¤\u00012\u0007\u0010È\u0001\u001A\u00020(2\u000F\u0010·\u0001\u001A\n\u0012\u0005\u0012\u0003H¤\u00010\u0098\u0001H\u0087\b¢\u0006\u0003\u0010É\u0001J\u0014\u0010Ê\u0001\u001A\u00020s2\t\u0010C\u001A\u0005\u0018\u00010\u0080\u0001H\u0002J\u0014\u0010Ë\u0001\u001A\u00020s2\t\u0010C\u001A\u0005\u0018\u00010\u0080\u0001H\u0001J\u0014\u0010Ì\u0001\u001A\u00020s2\t\u0010C\u001A\u0005\u0018\u00010\u0080\u0001H\u0001J\t\u0010Í\u0001\u001A\u00020\u001EH\u0002J\u0019\u0010Ó\u0001\u001A\u00020s2\u000E\u0010Ô\u0001\u001A\t\u0012\u0004\u0012\u00020s0\u0098\u0001H\u0016J\t\u0010Õ\u0001\u001A\u000200H\u0002J\u0012\u0010Õ\u0001\u001A\u0002002\u0007\u0010Ú\u0001\u001A\u00020\u001EH\u0002J\u001B\u0010Û\u0001\u001A\u0002002\u0007\u0010Ü\u0001\u001A\u0002002\u0007\u0010Ý\u0001\u001A\u000200H\u0002J\u0016\u0010Þ\u0001\u001A\u00020s2\u000B\u0010C\u001A\u0007\u0012\u0002\b\u00030ß\u0001H\u0017J\u0012\u0010à\u0001\u001A\u00020s2\u0007\u0010á\u0001\u001A\u000200H\u0002J\t\u0010â\u0001\u001A\u00020sH\u0017J&\u0010ã\u0001\u001A\u00020s2\u0015\u0010ä\u0001\u001A\u0010\u0012\u000B\b\u0001\u0012\u0007\u0012\u0002\b\u00030ß\u00010å\u0001H\u0017¢\u0006\u0003\u0010æ\u0001J\t\u0010ç\u0001\u001A\u00020sH\u0017J\'\u0010è\u0001\u001A\u0003H¤\u0001\"\u0005\b\u0000\u0010¤\u00012\u000E\u0010t\u001A\n\u0012\u0005\u0012\u0003H¤\u00010é\u0001H\u0017¢\u0006\u0003\u0010ê\u0001J\t\u0010ë\u0001\u001A\u00020\u0005H\u0016J\t\u0010ï\u0001\u001A\u00020sH\u0002J\t\u0010ð\u0001\u001A\u00020sH\u0002J\t\u0010ñ\u0001\u001A\u00020sH\u0002J\u001E\u0010ò\u0001\u001A\u00020s2\u0007\u0010ó\u0001\u001A\u00020(2\n\u0010ô\u0001\u001A\u0005\u0018\u00010\u0080\u0001H\u0002J<\u0010õ\u0001\u001A\u00020s2\u0006\u0010t\u001A\u00020\u001E2\n\u0010ö\u0001\u001A\u0005\u0018\u00010\u0080\u00012\b\u0010÷\u0001\u001A\u00030ø\u00012\n\u0010ô\u0001\u001A\u0005\u0018\u00010\u0080\u0001H\u0002¢\u0006\u0006\bù\u0001\u0010ú\u0001J\u001D\u0010û\u0001\u001A\u00020s2\u0007\u0010ó\u0001\u001A\u00020(2\t\u0010ü\u0001\u001A\u0004\u0018\u00010\u001AH\u0002J\u001B\u0010ý\u0001\u001A\u00020s2\u0007\u0010þ\u0001\u001A\u00020\u001E2\u0007\u0010\u0087\u0001\u001A\u00020(H\u0002J\u0012\u0010ÿ\u0001\u001A\u00020s2\u0007\u0010ó\u0001\u001A\u00020(H\u0002J\t\u0010\u0080\u0002\u001A\u00020sH\u0002J\u0012\u0010\u0081\u0002\u001A\u00020\u001E2\u0007\u0010\u0082\u0002\u001A\u00020\u001EH\u0002J\u001B\u0010\u0083\u0002\u001A\u00020s2\u0007\u0010Ú\u0001\u001A\u00020\u001E2\u0007\u0010\u0084\u0002\u001A\u00020\u001EH\u0002J-\u0010\u0085\u0002\u001A\u00020\u001E2\u0007\u0010\u0086\u0002\u001A\u00020\u001E2\u0007\u0010Ú\u0001\u001A\u00020\u001E2\u0007\u0010\u0087\u0002\u001A\u00020\u001E2\u0007\u0010\u0088\u0002\u001A\u00020\u001EH\u0002J\u0012\u0010\u0089\u0002\u001A\u00020\u001E2\u0007\u0010Ú\u0001\u001A\u00020\u001EH\u0002J\u0012\u0010\u008A\u0002\u001A\u00020\u001E2\u0007\u0010Ú\u0001\u001A\u00020\u001EH\u0002J\u001B\u0010\u008B\u0002\u001A\u00020s2\u0007\u0010Ú\u0001\u001A\u00020\u001E2\u0007\u0010\u008C\u0002\u001A\u00020\u001EH\u0002J\t\u0010\u008D\u0002\u001A\u00020sH\u0002J$\u0010\u008E\u0002\u001A\u00020s2\u0007\u0010\u008F\u0002\u001A\u00020\u001E2\u0007\u0010\u0090\u0002\u001A\u00020\u001E2\u0007\u0010\u0091\u0002\u001A\u00020\u001EH\u0002J\u001B\u0010\u0092\u0002\u001A\u00020s2\u0007\u0010Ú\u0001\u001A\u00020\u001E2\u0007\u0010\u0093\u0002\u001A\u00020\u001EH\u0002J6\u0010\u0094\u0002\u001A\b0\u008D\u0001j\u0003`\u008E\u00012\u0007\u0010Ú\u0001\u001A\u00020\u001E2\u0007\u0010\u0087\u0002\u001A\u00020\u001E2\r\u0010\u0095\u0002\u001A\b0\u008D\u0001j\u0003`\u008E\u0001H\u0002¢\u0006\u0003\u0010\u0096\u0002J\u0016\u0010\u0097\u0002\u001A\u00020\u001E*\u00020M2\u0007\u0010Ú\u0001\u001A\u00020\u001EH\u0002J$\u0010\u0098\u0002\u001A\u00020(2\u0007\u0010\u0099\u0002\u001A\u00020B2\n\u0010\u009A\u0002\u001A\u0005\u0018\u00010\u0080\u0001H\u0010¢\u0006\u0003\b\u009B\u0002J\u000F\u0010\u009C\u0002\u001A\u00020\u001EH\u0011¢\u0006\u0003\b\u009D\u0002J\t\u0010\u009E\u0002\u001A\u00020sH\u0017J\t\u0010\u009F\u0002\u001A\u00020sH\u0002J\u001B\u0010 \u0002\u001A\u00020(2\u0007\u0010¡\u0002\u001A\u00020(2\u0007\u0010¢\u0002\u001A\u00020\u001EH\u0017J\t\u0010£\u0002\u001A\u00020sH\u0017J\u0012\u0010¤\u0002\u001A\u00020s2\u0007\u0010À\u0001\u001A\u00020(H\u0017J\u0012\u0010¥\u0002\u001A\u00030¦\u00022\u0006\u0010t\u001A\u00020\u001EH\u0017J\t\u0010§\u0002\u001A\u00020sH\u0002J\u0012\u0010¨\u0002\u001A\u00020s2\u0007\u0010\u0099\u0002\u001A\u00020BH\u0002J\f\u0010©\u0002\u001A\u0005\u0018\u00010ª\u0002H\u0017J\"\u0010«\u0002\u001A\u0012\u0012\u0005\u0012\u00030­\u0002\u0012\u0004\u0012\u00020s\u0018\u00010¬\u00022\u0007\u0010\u0099\u0002\u001A\u00020BH\u0002J\"\u0010®\u0002\u001A\u00020s2\u000B\u0010C\u001A\u0007\u0012\u0002\b\u00030¯\u00022\n\u0010°\u0002\u001A\u0005\u0018\u00010\u0080\u0001H\u0017J:\u0010±\u0002\u001A\u00020s2\u0011\u0010²\u0002\u001A\f\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010¯\u00022\u0007\u0010³\u0002\u001A\u0002002\n\u0010°\u0002\u001A\u0005\u0018\u00010\u0080\u00012\u0007\u0010´\u0002\u001A\u00020(H\u0002J*\u0010µ\u0002\u001A\u00020s2\u001F\u0010¶\u0002\u001A\u001A\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030¹\u0002\u0012\u0007\u0012\u0005\u0018\u00010¹\u00020¸\u00020·\u0002H\u0017J*\u0010º\u0002\u001A\u00020s2\u001F\u0010¶\u0002\u001A\u001A\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030¹\u0002\u0012\u0007\u0012\u0005\u0018\u00010¹\u00020¸\u00020·\u0002H\u0002J1\u0010»\u0002\u001A\u0003H¼\u0002\"\u0005\b\u0000\u0010¼\u00022\u0006\u0010L\u001A\u00020M2\u000F\u0010·\u0001\u001A\n\u0012\u0005\u0012\u0003H¼\u00020\u0098\u0001H\u0082\b¢\u0006\u0003\u0010½\u0002Jr\u0010¾\u0002\u001A\u0003H¼\u0002\"\u0005\b\u0000\u0010¼\u00022\f\b\u0002\u0010¿\u0002\u001A\u0005\u0018\u00010À\u00022\f\b\u0002\u0010Á\u0002\u001A\u0005\u0018\u00010À\u00022\u000B\b\u0002\u0010\u0082\u0002\u001A\u0004\u0018\u00010\u001E2\u001F\b\u0002\u0010+\u001A\u0019\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020B\u0012\u0007\u0012\u0005\u0018\u00010\u0080\u00010¸\u00020·\u00022\u000F\u0010·\u0001\u001A\n\u0012\u0005\u0012\u0003H¼\u00020\u0098\u0001H\u0002¢\u0006\u0003\u0010Â\u0002J\u0013\u0010Ã\u0002\u001A\u00020s2\b\u0010Ã\u0002\u001A\u00030Ä\u0002H\u0017J\u001B\u0010Å\u0002\u001A\u00020s2\u0006\u0010t\u001A\u00020\u001E2\b\u0010Ã\u0002\u001A\u00030Ä\u0002H\u0017J\t\u0010Æ\u0002\u001A\u00020sH\u0017J\t\u0010Ç\u0002\u001A\u00020sH\u0016J\u001B\u0010È\u0002\u001A\u00030É\u00022\t\u0010C\u001A\u0005\u0018\u00010\u0080\u0001H\u0010¢\u0006\u0003\bÊ\u0002J\f\u0010Ë\u0002\u001A\u0005\u0018\u00010É\u0002H\u0002J+\u0010Ì\u0002\u001A\n\u0012\u0005\u0012\u00030Í\u00020·\u00022\u0007\u0010Ú\u0001\u001A\u00020\u001E2\t\u0010Î\u0002\u001A\u0004\u0018\u00010\u001EH\u0002¢\u0006\u0003\u0010Ï\u0002J\u0017\u0010Ð\u0002\u001A\n\u0012\u0005\u0012\u00030Í\u00020·\u0002H\u0010¢\u0006\u0003\bÑ\u0002JJ\u0010Ò\u0002\u001A\u00020s2\u0015\u0010Ó\u0002\u001A\u0010\u0012\u0004\u0012\u00020B\u0012\u0005\u0012\u00030\u0080\u00010Ô\u00022\u0014\u0010²\u0002\u001A\u000F\u0012\u0004\u0012\u00020s0\u0098\u0001¢\u0006\u0003\bÕ\u00022\t\u0010Ö\u0002\u001A\u0004\u0018\u00010iH\u0010¢\u0006\u0006\b×\u0002\u0010Ø\u0002J\u001F\u0010Ù\u0002\u001A\u00020s2\u000E\u0010·\u0001\u001A\t\u0012\u0004\u0012\u00020s0\u0098\u0001H\u0010¢\u0006\u0003\bÚ\u0002J4\u0010Û\u0002\u001A\u00020(2\u0015\u0010Ó\u0002\u001A\u0010\u0012\u0004\u0012\u00020B\u0012\u0005\u0012\u00030\u0080\u00010Ô\u00022\t\u0010Ö\u0002\u001A\u0004\u0018\u00010iH\u0010¢\u0006\u0006\bÜ\u0002\u0010Ý\u0002J)\u0010Þ\u0002\u001A\u00020s2\u0015\u0010Ó\u0002\u001A\u0010\u0012\u0004\u0012\u00020B\u0012\u0005\u0012\u00030\u0080\u00010Ô\u0002H\u0010¢\u0006\u0006\bß\u0002\u0010à\u0002JA\u0010á\u0002\u001A\u00020s2\u0015\u0010Ó\u0002\u001A\u0010\u0012\u0004\u0012\u00020B\u0012\u0005\u0012\u00030\u0080\u00010Ô\u00022\u0016\u0010²\u0002\u001A\u0011\u0012\u0004\u0012\u00020s\u0018\u00010\u0098\u0001¢\u0006\u0003\bÕ\u0002H\u0002¢\u0006\u0006\bâ\u0002\u0010ã\u0002J\u0019\u0010é\u0002\u001A\u0005\u0018\u00010\u0080\u0001*\u00020M2\u0007\u0010\u0082\u0002\u001A\u00020\u001EH\u0002J\t\u0010ê\u0002\u001A\u00020sH\u0002J\t\u0010ë\u0002\u001A\u00020sH\u0002J\u0012\u0010ì\u0002\u001A\u00020s2\u0007\u0010í\u0002\u001A\u00020dH\u0002J\t\u0010î\u0002\u001A\u00020sH\u0002J\u0012\u0010ï\u0002\u001A\u00020s2\u0007\u0010ð\u0002\u001A\u00020\u001EH\u0002J\t\u0010ñ\u0002\u001A\u00020sH\u0002J\t\u0010ò\u0002\u001A\u00020sH\u0002J\t\u0010ó\u0002\u001A\u00020sH\u0002J\u000F\u0010ô\u0002\u001A\u00020sH\u0010¢\u0006\u0003\bõ\u0002J2\u0010ö\u0002\u001A\u00020s2\u0007\u0010÷\u0002\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\u001E2\t\u0010\u007F\u001A\u0005\u0018\u00010\u0080\u00012\n\u0010ô\u0001\u001A\u0005\u0018\u00010\u0080\u0001H\u0082\bJ\u001B\u0010ø\u0002\u001A\u00020s2\u0007\u0010÷\u0002\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\u001EH\u0082\bJ2\u0010ù\u0002\u001A\u00020s2\u0007\u0010÷\u0002\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\u001E2\t\u0010\u007F\u001A\u0005\u0018\u00010\u0080\u00012\n\u0010ô\u0001\u001A\u0005\u0018\u00010\u0080\u0001H\u0082\bJ\u001B\u0010ú\u0002\u001A\u00020s2\u0007\u0010÷\u0002\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\u001EH\u0082\bJ\u000F\u0010û\u0002\u001A\u00020\u001EH\u0010¢\u0006\u0003\bü\u0002J\f\u0010\u0084\u0003\u001A\u0005\u0018\u00010\u0080\u0001H\u0016J\u0014\u0010\u0085\u0003\u001A\u00020s2\t\u0010C\u001A\u0005\u0018\u00010\u0080\u0001H\u0016J\u0013\u0010\u0086\u0003\u001A\u00020s2\b\u0010\u0099\u0002\u001A\u00030þ\u0002H\u0016R\u0018\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001A0\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001BR\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001A\u0004\u0018\u00010$X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u0004\u0018\u00010&X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020(X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020(X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020(X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010+\u001A\b\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u000200X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u00101\u001A\n\u0012\u0004\u0012\u000200\u0018\u000102X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00103\u001A\u00020(X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00104\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00105\u001A\u00020(X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00106\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00107\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00108\u001A\u00020\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u00109\u001A\u00020(X\u0090\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0010\u0010>\u001A\u00020?X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@R\u0016\u0010A\u001A\b\u0012\u0004\u0012\u00020B0\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001BR\u001E\u0010D\u001A\u00020(2\u0006\u0010C\u001A\u00020(@RX\u0090\u000E¢\u0006\b\n\u0000\u001A\u0004\bE\u0010;R\u001E\u0010F\u001A\u00020(2\u0006\u0010C\u001A\u00020(@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\bG\u0010;R\u0014\u0010H\u001A\u00020(8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\bI\u0010;R\u0014\u0010J\u001A\u00020(8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\bK\u0010;R\u001A\u0010L\u001A\u00020MX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001A\u0010R\u001A\u00020\u0007X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000E\u0010W\u001A\u00020XX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010Y\u001A\u00020(X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001A\u0004\u0018\u000100X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010[\u001A\u0004\u0018\u00010\\X\u0090\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b]\u0010^\"\u0004\b_\u0010`R\u000E\u0010a\u001A\u00020bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010c\u001A\u00020dX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010e\u001A\u00020fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010g\u001A\u00020(X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010h\u001A\u0004\u0018\u00010iX\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010j\u001A\u0004\u0018\u00010k8PX\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\bl\u0010mR\u0014\u0010n\u001A\u00020oX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\bp\u0010qR\u001A\u0010z\u001A\u00020(8VX\u0097\u0004¢\u0006\f\u0012\u0004\b{\u0010|\u001A\u0004\b}\u0010;R)\u0010\u0087\u0001\u001A\u00020(2\u0006\u0010C\u001A\u00020(8\u0016@RX\u0097\u000E¢\u0006\u0010\n\u0000\u0012\u0005\b\u0088\u0001\u0010|\u001A\u0005\b\u0089\u0001\u0010;R\u001D\u0010\u008A\u0001\u001A\u00020(8VX\u0097\u0004¢\u0006\u000E\u0012\u0005\b\u008B\u0001\u0010|\u001A\u0005\b\u008C\u0001\u0010;R9\u0010\u008F\u0001\u001A\b0\u008D\u0001j\u0003`\u008E\u00012\f\u0010C\u001A\b0\u008D\u0001j\u0003`\u008E\u00018\u0016@RX\u0097\u000E¢\u0006\u0014\n\u0003\u0010\u0093\u0001\u0012\u0005\b\u0090\u0001\u0010|\u001A\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0017\u0010°\u0001\u001A\u00020\u001E8VX\u0096\u0004¢\u0006\b\u001A\u0006\b±\u0001\u0010²\u0001R\u0012\u0010Î\u0001\u001A\u0005\u0018\u00010Ï\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010Ð\u0001\u001A\u00030Ï\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\bÑ\u0001\u0010Ò\u0001R\u0018\u0010Ö\u0001\u001A\u00030×\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\bØ\u0001\u0010Ù\u0001R\u0019\u0010ì\u0001\u001A\u0004\u0018\u00010B8PX\u0090\u0004¢\u0006\b\u001A\u0006\bí\u0001\u0010î\u0001R\u0013\u0010ä\u0002\u001A\u00020(8F¢\u0006\u0007\u001A\u0005\bå\u0002\u0010;R\u001E\u0010æ\u0002\u001A\u0005\u0018\u00010\u0080\u0001*\u00020M8BX\u0082\u0004¢\u0006\b\u001A\u0006\bç\u0002\u0010è\u0002R\u001A\u0010ý\u0002\u001A\u0005\u0018\u00010þ\u00028VX\u0096\u0004¢\u0006\b\u001A\u0006\bÿ\u0002\u0010\u0080\u0003R\u001A\u0010\u0081\u0003\u001A\u0005\u0018\u00010\u0080\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\b\u0082\u0003\u0010\u0083\u0003¨\u0006\u0089\u0003"}, d2={"Landroidx/compose/runtime/GapComposer;", "Landroidx/compose/runtime/InternalComposer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "Landroidx/compose/runtime/Changes;", "lateChanges", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "composition", "Landroidx/compose/runtime/CompositionImpl;", "<init>", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/composer/gapbuffer/SlotTable;Ljava/util/Set;Landroidx/compose/runtime/Changes;Landroidx/compose/runtime/Changes;Landroidx/compose/runtime/CompositionObserverHolder;Landroidx/compose/runtime/CompositionImpl;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "getComposition", "()Landroidx/compose/runtime/CompositionImpl;", "pendingStack", "Landroidx/compose/runtime/Stack;", "Landroidx/compose/runtime/GapPending;", "Ljava/util/ArrayList;", "pending", "nodeIndex", "", "groupNodeCount", "rGroupIndex", "parentStateStack", "Landroidx/compose/runtime/IntStack;", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Landroidx/collection/MutableIntIntMap;", "forceRecomposeScopes", "", "forciblyRecompose", "nodeExpected", "invalidations", "", "Landroidx/compose/runtime/Invalidation;", "entersStack", "rootProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "providerUpdates", "Landroidx/collection/MutableIntObjectMap;", "providersInvalid", "providersInvalidStack", "reusing", "reusingGroup", "childrenComposing", "compositionToken", "sourceMarkersEnabled", "getSourceMarkersEnabled$runtime", "()Z", "setSourceMarkersEnabled$runtime", "(Z)V", "derivedStateObserver", "androidx/compose/runtime/GapComposer$derivedStateObserver$1", "Landroidx/compose/runtime/GapComposer$derivedStateObserver$1;", "invalidateStack", "Landroidx/compose/runtime/RecomposeScopeImpl;", "value", "isComposing", "isComposing$runtime", "isDisposed", "isDisposed$runtime", "areChildrenComposing", "getAreChildrenComposing$runtime", "hasPendingChanges", "getHasPendingChanges$runtime", "reader", "Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "getReader$runtime", "()Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "setReader$runtime", "(Landroidx/compose/runtime/composer/gapbuffer/SlotReader;)V", "insertTable", "getInsertTable$runtime", "()Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "setInsertTable$runtime", "(Landroidx/compose/runtime/composer/gapbuffer/SlotTable;)V", "writer", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "writerHasAProvider", "providerCache", "deferredChanges", "Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;", "getDeferredChanges$runtime", "()Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;", "setDeferredChanges$runtime", "(Landroidx/compose/runtime/composer/gapbuffer/changelist/ChangeList;)V", "changeListWriter", "Landroidx/compose/runtime/composer/gapbuffer/changelist/ComposerChangeListWriter;", "insertAnchor", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "insertFixups", "Landroidx/compose/runtime/composer/gapbuffer/changelist/FixupList;", "pausable", "shouldPauseCallback", "Landroidx/compose/runtime/ShouldPauseCallback;", "errorContext", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "getErrorContext$runtime", "()Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "startReplaceableGroup", "", "key", "endReplaceableGroup", "startReplaceGroup", "endReplaceGroup", "startDefaults", "endDefaults", "defaultsInvalid", "getDefaultsInvalid$annotations", "()V", "getDefaultsInvalid", "startMovableGroup", "dataKey", "", "endMovableGroup", "startRoot", "endRoot", "abortRoot", "changesApplied", "changesApplied$runtime", "inserting", "getInserting$annotations", "getInserting", "skipping", "getSkipping$annotations", "getSkipping", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "compositeKeyHashCode", "getCompositeKeyHashCode$annotations", "getCompositeKeyHashCode", "()J", "J", "collectParameterInformation", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "Lkotlin/Function0;", "dispose", "dispose$runtime", "deactivate", "deactivate$runtime", "forceRecomposeScopes$runtime", "startGroup", "endGroup", "skipGroup", "startNode", "startReusableNode", "createNode", "T", "factory", "useNode", "endNode", "startReusableGroup", "endReusableGroup", "disableReusing", "enableReusing", "startReuseFromRoot", "startReuseFromRoot$runtime", "endReuseFromRoot", "endReuseFromRoot$runtime", "currentMarker", "getCurrentMarker", "()I", "endToMarker", "marker", "apply", "V", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "joinKey", "left", "right", "nextSlot", "nextSlotForCache", "changed", "changedInstance", "", "", "", "", "", "cache", "invalid", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "updateSlot", "updateValue", "updateCachedValue", "rememberObserverGroupIndex", "_compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "compositionData", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "recordSideEffect", "effect", "currentCompositionLocalScope", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "group", "updateProviderMapGroup", "parentScope", "currentProviders", "startProvider", "Landroidx/compose/runtime/ProvidedValue;", "recordProviderUpdate", "providers", "endProvider", "startProviders", "values", "", "([Landroidx/compose/runtime/ProvidedValue;)V", "endProviders", "consume", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "buildContext", "currentRecomposeScope", "getCurrentRecomposeScope$runtime", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "ensureWriter", "createFreshInsertTable", "forceFreshInsertTable", "startReaderGroup", "isNode", "data", "start", "objectKey", "kind", "Landroidx/compose/runtime/composer/GroupKind;", "start-AzEfcrM", "(ILjava/lang/Object;ILjava/lang/Object;)V", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", "end", "recomposeToGroupEnd", "insertedGroupVirtualIndex", "index", "updateNodeCountOverrides", "newCount", "nodeIndexOf", "groupLocation", "recomposeGroup", "recomposeIndex", "rGroupIndexOf", "updatedNodeCount", "updateNodeCount", "count", "clearUpdatedNodeCounts", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "doRecordDownsFor", "nearestCommonRoot", "compositeKeyOf", "recomposeKey", "(IIJ)J", "groupCompositeKeyPart", "tryImminentInvalidation", "scope", "instance", "tryImminentInvalidation$runtime", "parentKey", "parentKey$runtime", "skipCurrentGroup", "skipReaderToGroupEnd", "shouldExecute", "parametersChanged", "flags", "skipToGroupEnd", "deactivateToEndGroup", "startRestartGroup", "Landroidx/compose/runtime/Composer;", "addRecomposeScope", "enterRecomposeScope", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "exitRecomposeScope", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "invokeMovableContentLambda", "content", "locals", "force", "insertMovableContentReferences", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContentGuarded", "withReader", "R", "(Landroidx/compose/runtime/composer/gapbuffer/SlotReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recomposeMovableContent", "from", "Landroidx/compose/runtime/ControlledComposition;", "to", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "sourceInformation", "", "sourceInformationMarkerStart", "sourceInformationMarkerEnd", "disableSourceInformation", "stackTraceForValue", "Landroidx/compose/runtime/tooling/ComposeStackTrace;", "stackTraceForValue$runtime", "currentStackTrace", "stackTraceForGroup", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "dataOffset", "(ILjava/lang/Integer;)Ljava/util/List;", "parentStackTrace", "parentStackTrace$runtime", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/Composable;", "shouldPause", "composeContent--ZbOJvo$runtime", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/ShouldPauseCallback;)V", "prepareCompose", "prepareCompose$runtime", "recompose", "recompose-aFTiNEg$runtime", "(Landroidx/collection/MutableScatterMap;Landroidx/compose/runtime/ShouldPauseCallback;)Z", "updateComposerInvalidations", "updateComposerInvalidations-RY85e9Y$runtime", "(Landroidx/collection/MutableScatterMap;)V", "doCompose", "doCompose-aFTiNEg", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;)V", "hasInvalidations", "getHasInvalidations", "node", "getNode", "(Landroidx/compose/runtime/composer/gapbuffer/SlotReader;)Ljava/lang/Object;", "nodeAt", "validateNodeExpected", "validateNodeNotExpected", "recordInsert", "anchor", "recordDelete", "reportFreeMovableContent", "groupBeingRemoved", "reportAllMovableContent", "finalizeCompose", "cleanUpCompose", "verifyConsistent", "verifyConsistent$runtime", "updateCompositeKeyWhenWeEnterGroup", "groupKey", "updateCompositeKeyWhenWeEnterGroupKeyHash", "updateCompositeKeyWhenWeExitGroup", "updateCompositeKeyWhenWeExitGroupKeyHash", "stacksSize", "stacksSize$runtime", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "rememberedValue", "updateRememberedValue", "recordUsed", "CompositionContextHolder", "CompositionContextImpl", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class GapComposer extends InternalComposer {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001A\u00020\nH\u0016J\b\u0010\u000B\u001A\u00020\nH\u0016J\b\u0010\f\u001A\u00020\nH\u0016R\u0015\u0010\u0002\u001A\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\r"}, d2={"Landroidx/compose/runtime/GapComposer$CompositionContextHolder;", "Landroidx/compose/runtime/RememberObserver;", "ref", "Landroidx/compose/runtime/GapComposer$CompositionContextImpl;", "Landroidx/compose/runtime/GapComposer;", "<init>", "(Landroidx/compose/runtime/GapComposer$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/GapComposer$CompositionContextImpl;", "onRemembered", "", "onAbandoned", "onForgotten", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CompositionContextHolder implements RememberObserver {
        public static final int $stable = 8;
        private final CompositionContextImpl ref;

        static {
        }

        public CompositionContextHolder(CompositionContextImpl arg1) {
            super();
            this.ref = arg1;
        }

        public final CompositionContextImpl getRef() {
            return this.ref;
        }

        public void onAbandoned() {
            this.ref.dispose();
        }

        public void onForgotten() {
            this.ref.dispose();
        }

        public void onRemembered() {
        }
    }

    @Metadata(d1={"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ\u0006\u0010$\u001A\u00020%J\u0015\u0010&\u001A\u00020%2\u0006\u0010\'\u001A\u00020(H\u0010¢\u0006\u0002\b)J\u0015\u0010*\u001A\u00020%2\u0006\u0010\'\u001A\u00020(H\u0010¢\u0006\u0002\b+J\u0015\u0010,\u001A\u00020%2\u0006\u0010-\u001A\u00020.H\u0010¢\u0006\u0002\b/J\u0015\u00100\u001A\u00020%2\u0006\u0010-\u001A\u00020.H\u0010¢\u0006\u0002\b1J\u0015\u00102\u001A\u00020%2\u0006\u00103\u001A\u000204H\u0010¢\u0006\u0002\b5J*\u0010:\u001A\u00020%2\u0006\u0010-\u001A\u00020.2\u0011\u0010;\u001A\r\u0012\u0004\u0012\u00020%0<¢\u0006\u0002\b=H\u0011¢\u0006\u0004\b>\u0010?J8\u0010@\u001A\b\u0012\u0004\u0012\u0002040A2\u0006\u0010-\u001A\u00020.2\u0006\u0010B\u001A\u00020C2\u0011\u0010;\u001A\r\u0012\u0004\u0012\u00020%0<¢\u0006\u0002\b=H\u0011¢\u0006\u0004\bD\u0010EJ1\u0010F\u001A\b\u0012\u0004\u0012\u0002040A2\u0006\u0010-\u001A\u00020.2\u0006\u0010B\u001A\u00020C2\f\u0010G\u001A\b\u0012\u0004\u0012\u0002040AH\u0010¢\u0006\u0002\bHJ\u0015\u0010I\u001A\u00020%2\u0006\u0010-\u001A\u00020.H\u0010¢\u0006\u0002\bJJ\u0015\u0010K\u001A\u00020%2\u0006\u00103\u001A\u000204H\u0010¢\u0006\u0002\bLJ\r\u0010P\u001A\u00020NH\u0010¢\u0006\u0002\bVJ\u000E\u0010W\u001A\u00020%2\u0006\u00103\u001A\u00020NJ\u001B\u0010X\u001A\u00020%2\f\u0010Y\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0010¢\u0006\u0002\bZJ\r\u0010[\u001A\u00020%H\u0010¢\u0006\u0002\b\\J\r\u0010]\u001A\u00020%H\u0010¢\u0006\u0002\b^J\u0015\u0010_\u001A\u00020%2\u0006\u0010`\u001A\u00020aH\u0010¢\u0006\u0002\bbJ\u0015\u0010c\u001A\u00020%2\u0006\u0010`\u001A\u00020aH\u0010¢\u0006\u0002\bdJ\u0017\u0010e\u001A\u0004\u0018\u00010f2\u0006\u0010`\u001A\u00020aH\u0010¢\u0006\u0002\bgJ)\u0010h\u001A\u00020%2\u0006\u0010`\u001A\u00020a2\u0006\u0010i\u001A\u00020f2\n\u0010j\u001A\u0006\u0012\u0002\b\u00030kH\u0010¢\u0006\u0002\blJ\u0015\u0010m\u001A\u00020%2\u0006\u0010-\u001A\u00020.H\u0010¢\u0006\u0002\bnJ\u0016\u0010r\u001A\u00020s2\f\u0010t\u001A\b\u0012\u0004\u0012\u00020%0<H\u0016R\u001A\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004X\u0090\u0004¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001A\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0007\u001A\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001A\u0004\u0018\u00010\tX\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0015X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u0017\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001D0\u001C¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u0010R\u0014\u0010\"\u001A\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\u0010R\u0014\u00106\u001A\u0002078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b8\u00109R+\u0010O\u001A\u00020N2\u0006\u0010M\u001A\u00020N8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\bT\u0010U\u001A\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0014\u0010-\u001A\u00020o8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\bp\u0010q¨\u0006u"}, d2={"Landroidx/compose/runtime/GapComposer$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compositeKeyHashCode", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "collectingParameterInformation", "", "collectingSourceInformation", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "<init>", "(Landroidx/compose/runtime/GapComposer;JZZLandroidx/compose/runtime/CompositionObserverHolder;)V", "getCompositeKeyHashCode$runtime", "()J", "J", "getCollectingParameterInformation$runtime", "()Z", "getCollectingSourceInformation$runtime", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "inspectionTables", "", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "()Ljava/util/Set;", "setInspectionTables", "(Ljava/util/Set;)V", "composers", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/GapComposer;", "getComposers", "()Landroidx/collection/MutableScatterSet;", "collectingCallByInformation", "getCollectingCallByInformation$runtime", "stackTraceEnabled", "getStackTraceEnabled$runtime", "dispose", "", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime", "unregisterComposer", "unregisterComposer$runtime", "registerComposition", "composition", "Landroidx/compose/runtime/ControlledComposition;", "registerComposition$runtime", "unregisterComposition", "unregisterComposition$runtime", "reportPausedScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "reportPausedScope$runtime", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "composeInitial", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitialPaused", "Landroidx/collection/ScatterSet;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "composeInitialPaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Lkotlin/jvm/functions/Function2;)Landroidx/collection/ScatterSet;", "recomposePaused", "invalidScopes", "recomposePaused$runtime", "invalidate", "invalidate$runtime", "invalidateScope", "invalidateScope$runtime", "<set-?>", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompositionLocalScope$runtime", "updateCompositionLocalScope", "recordInspectionTable", "table", "recordInspectionTable$runtime", "startComposing", "startComposing$runtime", "doneComposing", "doneComposing$runtime", "insertMovableContent", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContent$runtime", "deletedMovableContent", "deletedMovableContent$runtime", "movableContentStateResolve", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve$runtime", "movableContentStateReleased", "data", "applier", "Landroidx/compose/runtime/Applier;", "movableContentStateReleased$runtime", "reportRemovedComposition", "reportRemovedComposition$runtime", "Landroidx/compose/runtime/Composition;", "getComposition$runtime", "()Landroidx/compose/runtime/Composition;", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final boolean collectingSourceInformation;
        private final MutableScatterSet composers;
        private final long compositeKeyHashCode;
        private final MutableState compositionLocalScope$delegate;
        private Set inspectionTables;
        private final CompositionObserverHolder observerHolder;

        public CompositionContextImpl(GapComposer arg1, long arg2, boolean arg4, boolean arg5, CompositionObserverHolder arg6) {
            GapComposer.this = arg1;
            super();
            this.compositeKeyHashCode = arg2;
            this.collectingParameterInformation = arg4;
            this.collectingSourceInformation = arg5;
            this.observerHolder = arg6;
            this.composers = ScatterSetKt.mutableScatterSetOf();
            this.compositionLocalScope$delegate = SnapshotStateKt.mutableStateOf(PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf(), SnapshotStateKt.referentialEqualityPolicy());
        }

        public void composeInitial$runtime(ControlledComposition arg1, Function2 arg2) {
            GapComposer.this.parentContext.composeInitial$runtime(arg1, arg2);
        }

        public ScatterSet composeInitialPaused$runtime(ControlledComposition arg1, ShouldPauseCallback arg2, Function2 arg3) {
            return GapComposer.this.parentContext.composeInitialPaused$runtime(arg1, arg2, arg3);
        }

        public void deletedMovableContent$runtime(MovableContentStateReference arg1) {
            GapComposer.this.parentContext.deletedMovableContent$runtime(arg1);
        }

        public final void dispose() {
            if(this.composers.isNotEmpty()) {
                Set v0 = this.inspectionTables;
                if(v0 != null) {
                    MutableScatterSet v1 = this.composers;
                    Object[] v2 = ((ScatterSet)v1).elements;
                    long[] v1_1 = ((ScatterSet)v1).metadata;
                    int v3 = v1_1.length - 2;
                    if(v3 >= 0) {
                        int v5;
                        for(v5 = 0; true; ++v5) {
                            long v6 = v1_1[v5];
                            if((~v6 << 7 & v6 & -9187201950435737472L) != -9187201950435737472L) {
                                int v9 = 8;
                                int v8 = 8 - (~(v5 - v3) >>> 0x1F);
                                int v10;
                                for(v10 = 0; v10 < v8; ++v10) {
                                    if((0xFF & v6) < 0x80) {
                                        Object v11 = v2[(v5 << 3) + v10];
                                        Iterator v12 = v0.iterator();
                                        while(v12.hasNext()) {
                                            v12.next().remove(((GapComposer)v11).getCompositionData());
                                        }
                                    }

                                    v6 >>= v9;
                                }

                                if(v8 != v9) {
                                    break;
                                }
                            }

                            if(v5 == v3) {
                                break;
                            }
                        }
                    }
                }

                this.composers.clear();
            }
        }

        public void doneComposing$runtime() {
            --GapComposer.this.childrenComposing;
        }

        public boolean getCollectingCallByInformation$runtime() {
            return GapComposer.this.parentContext.getCollectingCallByInformation$runtime();
        }

        public boolean getCollectingParameterInformation$runtime() {
            return this.collectingParameterInformation;
        }

        public boolean getCollectingSourceInformation$runtime() {
            return this.collectingSourceInformation;
        }

        public final MutableScatterSet getComposers() {
            return this.composers;
        }

        public long getCompositeKeyHashCode$runtime() {
            return this.compositeKeyHashCode;
        }

        public Composition getComposition$runtime() {
            return GapComposer.this.getComposition();
        }

        private final PersistentCompositionLocalMap getCompositionLocalScope() {
            return this.compositionLocalScope$delegate.getValue();
        }

        public PersistentCompositionLocalMap getCompositionLocalScope$runtime() {
            return this.getCompositionLocalScope();
        }

        public CoroutineContext getEffectCoroutineContext() {
            return GapComposer.this.parentContext.getEffectCoroutineContext();
        }

        public final Set getInspectionTables() {
            return this.inspectionTables;
        }

        public CompositionObserverHolder getObserverHolder$runtime() {
            return this.observerHolder;
        }

        public boolean getStackTraceEnabled$runtime() {
            return GapComposer.this.parentContext.getStackTraceEnabled$runtime();
        }

        public void insertMovableContent$runtime(MovableContentStateReference arg1) {
            GapComposer.this.parentContext.insertMovableContent$runtime(arg1);
        }

        public void invalidate$runtime(ControlledComposition arg3) {
            GapComposer.this.parentContext.invalidate$runtime(GapComposer.this.getComposition());
            GapComposer.this.parentContext.invalidate$runtime(arg3);
        }

        public void invalidateScope$runtime(RecomposeScopeImpl arg1) {
            GapComposer.this.parentContext.invalidateScope$runtime(arg1);
        }

        public void movableContentStateReleased$runtime(MovableContentStateReference arg1, MovableContentState arg2, Applier arg3) {
            GapComposer.this.parentContext.movableContentStateReleased$runtime(arg1, arg2, arg3);
        }

        public MovableContentState movableContentStateResolve$runtime(MovableContentStateReference arg1) {
            return GapComposer.this.parentContext.movableContentStateResolve$runtime(arg1);
        }

        public ScatterSet recomposePaused$runtime(ControlledComposition arg1, ShouldPauseCallback arg2, ScatterSet arg3) {
            return GapComposer.this.parentContext.recomposePaused$runtime(arg1, arg2, arg3);
        }

        public void recordInspectionTable$runtime(Set arg2) {
            Set v0 = this.inspectionTables;
            if(v0 == null) {
                HashSet v0_1 = new HashSet();
                this.inspectionTables = ((Set)v0_1);
            }

            v0.add(arg2);
        }

        public void registerComposer$runtime(Composer arg2) {
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.GapComposer");
            super.registerComposer$runtime(arg2);
            this.composers.add(arg2);
        }

        public void registerComposition$runtime(ControlledComposition arg1) {
            GapComposer.this.parentContext.registerComposition$runtime(arg1);
        }

        public void reportPausedScope$runtime(RecomposeScopeImpl arg1) {
            GapComposer.this.parentContext.reportPausedScope$runtime(arg1);
        }

        public void reportRemovedComposition$runtime(ControlledComposition arg1) {
            GapComposer.this.parentContext.reportRemovedComposition$runtime(arg1);
        }

        public CancellationHandle scheduleFrameEndCallback(Function0 arg1) {
            return GapComposer.this.parentContext.scheduleFrameEndCallback(arg1);
        }

        private final void setCompositionLocalScope(PersistentCompositionLocalMap arg1) {
            this.compositionLocalScope$delegate.setValue(arg1);
        }

        public final void setInspectionTables(Set arg1) {
            this.inspectionTables = arg1;
        }

        public void startComposing$runtime() {
            ++GapComposer.this.childrenComposing;
        }

        public void unregisterComposer$runtime(Composer arg4) {
            Set v0 = this.inspectionTables;
            if(v0 != null) {
                Iterator v0_1 = ((Iterable)v0).iterator();
                while(v0_1.hasNext()) {
                    Object v1 = v0_1.next();
                    Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type androidx.compose.runtime.GapComposer");
                    ((Set)v1).remove(arg4.getCompositionData());
                }
            }

            if((arg4 instanceof GapComposer)) {
                this.composers.remove(arg4);
            }
        }

        public void unregisterComposition$runtime(ControlledComposition arg1) {
            GapComposer.this.parentContext.unregisterComposition$runtime(arg1);
        }

        public final void updateCompositionLocalScope(PersistentCompositionLocalMap arg1) {
            this.setCompositionLocalScope(arg1);
        }
    }

    public static final int $stable = 8;
    private CompositionData _compositionData;
    private final Set abandonSet;
    private final Applier applier;
    private final CoroutineContext applyCoroutineContext;
    private final ComposerChangeListWriter changeListWriter;
    private Changes changes;
    private int childrenComposing;
    private long compositeKeyHashCode;
    private final CompositionImpl composition;
    private int compositionToken;
    private ChangeList deferredChanges;
    private final GapComposer$derivedStateObserver$1 derivedStateObserver;
    private final IntStack entersStack;
    private final CompositionErrorContextImpl errorContext;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private GapAnchor insertAnchor;
    private FixupList insertFixups;
    private SlotTable insertTable;
    private boolean inserting;
    private final ArrayList invalidateStack;
    private final List invalidations;
    private boolean isComposing;
    private boolean isDisposed;
    private Changes lateChanges;
    private int[] nodeCountOverrides;
    private MutableIntIntMap nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parentContext;
    private final IntStack parentStateStack;
    private boolean pausable;
    private GapPending pending;
    private final ArrayList pendingStack;
    private PersistentCompositionLocalMap providerCache;
    private MutableIntObjectMap providerUpdates;
    private boolean providersInvalid;
    private final IntStack providersInvalidStack;
    private int rGroupIndex;
    private SlotReader reader;
    private boolean reusing;
    private int reusingGroup;
    private PersistentCompositionLocalMap rootProvider;
    private ShouldPauseCallback shouldPauseCallback;
    private final SlotTable slotTable;
    private boolean sourceMarkersEnabled;
    private SlotWriter writer;
    private boolean writerHasAProvider;

    public static Unit $r8$lambda$Wq-dEv6xGnNYQDG4zq-vF4I4KDM(GapComposer arg0, MovableContentStateReference arg1) {
        return GapComposer.insertMovableContentGuarded$lambda$0$0$1$0$0$0$0(arg0, arg1);
    }

    public static ComposeStackTrace $r8$lambda$_TJ_W6a1hzg6MAYt1ghQ9fk2J5M(GapComposer arg0) {
        return GapComposer.doCompose_aFTiNEg$lambda$1$1(arg0);
    }

    public static Unit $r8$lambda$xdEknx7hB5DqeRit6nECrWw5JbA(GapComposer arg0, ChangeList arg1, SlotReader arg2, MovableContentStateReference arg3) {
        return GapComposer.insertMovableContentGuarded$lambda$0$0$0$0(arg0, arg1, arg2, arg3);
    }

    static {
    }

    public GapComposer(Applier arg1, CompositionContext arg2, SlotTable arg3, Set arg4, Changes arg5, Changes arg6, CompositionObserverHolder arg7, CompositionImpl arg8) {
        EmptyCoroutineContext v2_1;
        GapAnchor v3;
        super();
        this.applier = arg1;
        this.parentContext = arg2;
        this.slotTable = arg3;
        this.abandonSet = arg4;
        this.changes = arg5;
        this.lateChanges = arg6;
        this.observerHolder = arg7;
        this.composition = arg8;
        ArrayList v1 = null;
        this.pendingStack = Stack.constructor-impl$default(v1, 1, ((DefaultConstructorMarker)v1));
        this.parentStateStack = new IntStack();
        this.invalidations = new ArrayList();
        this.entersStack = new IntStack();
        this.rootProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
        this.providersInvalidStack = new IntStack();
        this.reusingGroup = -1;
        boolean v5 = (arg2.getCollectingSourceInformation$runtime()) || (arg2.getCollectingCallByInformation$runtime()) ? true : false;
        this.sourceMarkersEnabled = v5;
        this.derivedStateObserver = new GapComposer$derivedStateObserver$1(this);
        this.invalidateStack = Stack.constructor-impl$default(v1, 1, ((DefaultConstructorMarker)v1));
        SlotReader v1_1 = arg3.openReader();
        v1_1.close();
        this.reader = v1_1;
        SlotTable v1_2 = new SlotTable();
        if(arg2.getCollectingSourceInformation$runtime()) {
            v1_2.collectSourceInformation();
        }

        if(arg2.getCollectingCallByInformation$runtime()) {
            v1_2.collectCalledByInformation();
        }

        this.insertTable = v1_2;
        SlotWriter v1_3 = v1_2.openWriter();
        v1_3.close(true);
        this.writer = v1_3;
        this.changeListWriter = new ComposerChangeListWriter(this, ChangeListKt.asGapBufferChangeList(this.changes));
        v1_1 = this.insertTable.openReader();
        try {
            v3 = v1_1.anchor(0);
        }
        catch(Throwable v0) {
            v1_1.close();
            throw v0;
        }

        v1_1.close();
        this.insertAnchor = v3;
        this.insertFixups = new FixupList();
        this.errorContext = new CompositionErrorContextImpl(this);
        CoroutineContext v1_4 = arg2.getEffectCoroutineContext();
        CompositionErrorContextImpl v2 = this.getErrorContext$runtime();
        if(v2 != null) {
        }
        else {
            v2_1 = EmptyCoroutineContext.INSTANCE;
        }

        this.applyCoroutineContext = v1_4.plus(((CoroutineContext)v2_1));
    }

    private final void abortRoot() {
        this.cleanUpCompose();
        Stack.clear-impl(this.pendingStack);
        this.parentStateStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates = null;
        this.insertFixups.clear();
        this.compositeKeyHashCode = 0;
        this.childrenComposing = 0;
        this.nodeExpected = false;
        this.inserting = false;
        this.reusing = false;
        this.isComposing = false;
        this.forciblyRecompose = false;
        this.reusingGroup = -1;
        if(!this.reader.getClosed()) {
            this.reader.close();
        }

        if(!this.writer.getClosed()) {
            this.forceFreshInsertTable();
        }
    }

    public static final int access$getChildrenComposing$p(GapComposer arg0) {
        return arg0.childrenComposing;
    }

    public static final CompositionContext access$getParentContext$p(GapComposer arg0) {
        return arg0.parentContext;
    }

    public static final void access$setChildrenComposing$p(GapComposer arg0, int arg1) {
        arg0.childrenComposing = arg1;
    }

    private final void addRecomposeScope() {
        boolean v0_2;
        String v1 = "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl";
        if(this.getInserting()) {
            CompositionImpl v2 = this.getComposition();
            Intrinsics.checkNotNull(v2, v1);
            RecomposeScopeImpl v0 = new RecomposeScopeImpl(((RecomposeScopeOwner)v2));
            Stack.push-impl(this.invalidateStack, v0);
            this.updateValue(v0);
            this.enterRecomposeScope(v0);
            return;
        }

        Invalidation v0_1 = GapComposerKt.access$removeLocation(this.invalidations, this.reader.getParent());
        Object v2_1 = this.reader.next();
        if(Intrinsics.areEqual(v2_1, Composer.Companion.getEmpty())) {
            CompositionImpl v3 = this.getComposition();
            Intrinsics.checkNotNull(v3, v1);
            RecomposeScopeImpl v2_2 = new RecomposeScopeImpl(((RecomposeScopeOwner)v3));
            this.updateValue(v2_2);
        }
        else {
            Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
        }

        if(v0_1 == null) {
            v0_2 = ((RecomposeScopeImpl)v2_1).getForcedRecompose();
            if(v0_2) {
                ((RecomposeScopeImpl)v2_1).setForcedRecompose(false);
            }

            if(v0_2) {
                goto label_40;
            }

            v0_2 = false;
        }
        else {
        label_40:
            v0_2 = true;
        }

        ((RecomposeScopeImpl)v2_1).setRequiresRecompose(v0_2);
        Stack.push-impl(this.invalidateStack, v2_1);
        this.enterRecomposeScope(((RecomposeScopeImpl)v2_1));
        if(((RecomposeScopeImpl)v2_1).getPaused()) {
            ((RecomposeScopeImpl)v2_1).setPaused(false);
            ((RecomposeScopeImpl)v2_1).setResuming(true);
            this.changeListWriter.startResumingScope(((RecomposeScopeImpl)v2_1));
            if(!this.reusing && (((RecomposeScopeImpl)v2_1).getReusing())) {
                this.reusing = true;
                this.reusingGroup = this.reader.getParent();
                ((RecomposeScopeImpl)v2_1).setResetReusing(true);
            }
        }
    }

    public void apply(Object arg2, Function2 arg3) {
        if(this.getInserting()) {
            this.insertFixups.updateNode(arg2, arg3);
            return;
        }

        this.changeListWriter.updateNode(arg2, arg3);
    }

    public CompositionContext buildContext() {
        GapComposer v3;
        this.startGroup(206, ComposerKt.getReference());
        Object v1 = null;
        if(this.getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, v1);
        }

        Object v0 = this.nextSlot();
        if((v0 instanceof RememberObserverHolder)) {
            v1 = v0;
        }

        if(v1 == null) {
            v3 = this;
            ReusableGapRememberObserverHolder v1_1 = new ReusableGapRememberObserverHolder(new CompositionContextHolder(new CompositionContextImpl(v3, this.getCompositeKeyHashCode(), this.forceRecomposeScopes, this.getSourceMarkersEnabled$runtime(), this.getComposition().getObserverHolder$runtime())), -1);
            v3.updateValue(v1_1);
        }
        else {
            v3 = this;
        }

        RememberObserver v9 = ((RememberObserverHolder)v1).getWrapped();
        Intrinsics.checkNotNull(v9, "null cannot be cast to non-null type androidx.compose.runtime.GapComposer.CompositionContextHolder");
        ((CompositionContextHolder)v9).getRef().updateCompositionLocalScope(v3.currentCompositionLocalScope());
        v3.endGroup();
        return ((CompositionContextHolder)v9).getRef();
    }

    @ComposeCompilerApi public final Object cache(boolean arg3, Function0 arg4) {
        Object v0 = this.nextSlotForCache();
        if(v0 != Composer.Companion.getEmpty()) {
            if(arg3) {
            }
            else {
                return v0;
            }
        }

        Object v3 = arg4.invoke();
        this.updateCachedValue(v3);
        return v3;
    }

    @ComposeCompilerApi public boolean changed(Object arg2) {
        if(!Intrinsics.areEqual(this.nextSlot(), arg2)) {
            this.updateValue(arg2);
            return 1;
        }

        return 0;
    }

    @ComposeCompilerApi public boolean changed(byte arg3) {
        Object v0 = this.nextSlot();
        if(((v0 instanceof Byte)) && arg3 == ((Number)v0).byteValue()) {
            return 0;
        }

        this.updateValue(Byte.valueOf(arg3));
        return 1;
    }

    @ComposeCompilerApi public boolean changed(char arg3) {
        Object v0 = this.nextSlot();
        if(((v0 instanceof Character)) && arg3 == ((Character)v0).charValue()) {
            return 0;
        }

        this.updateValue(Character.valueOf(arg3));
        return 1;
    }

    @ComposeCompilerApi public boolean changed(double arg3) {
        Object v0 = this.nextSlot();
        if(((v0 instanceof Double)) && arg3 == ((Number)v0).doubleValue()) {
            return 0;
        }

        this.updateValue(Double.valueOf(arg3));
        return 1;
    }

    @ComposeCompilerApi public boolean changed(float arg3) {
        Object v0 = this.nextSlot();
        if(((v0 instanceof Float)) && arg3 == ((Number)v0).floatValue()) {
            return 0;
        }

        this.updateValue(Float.valueOf(arg3));
        return 1;
    }

    @ComposeCompilerApi public boolean changed(int arg3) {
        Object v0 = this.nextSlot();
        if(((v0 instanceof Integer)) && arg3 == ((Number)v0).intValue()) {
            return 0;
        }

        this.updateValue(Integer.valueOf(arg3));
        return 1;
    }

    @ComposeCompilerApi public boolean changed(long arg3) {
        Object v0 = this.nextSlot();
        if(((v0 instanceof Long)) && arg3 == ((Number)v0).longValue()) {
            return 0;
        }

        this.updateValue(Long.valueOf(arg3));
        return 1;
    }

    @ComposeCompilerApi public boolean changed(short arg3) {
        Object v0 = this.nextSlot();
        if(((v0 instanceof Short)) && arg3 == ((Number)v0).shortValue()) {
            return 0;
        }

        this.updateValue(Short.valueOf(arg3));
        return 1;
    }

    @ComposeCompilerApi public boolean changed(boolean arg3) {
        Object v0 = this.nextSlot();
        if(((v0 instanceof Boolean)) && arg3 == ((Boolean)v0).booleanValue()) {
            return 0;
        }

        this.updateValue(Boolean.valueOf(arg3));
        return 1;
    }

    @ComposeCompilerApi public boolean changedInstance(Object arg2) {
        if(this.nextSlot() != arg2) {
            this.updateValue(arg2);
            return 1;
        }

        return 0;
    }

    public void changesApplied$runtime() {
        this.providerUpdates = null;
    }

    private final void cleanUpCompose() {
        this.pending = null;
        this.nodeIndex = 0;
        this.groupNodeCount = 0;
        this.compositeKeyHashCode = 0;
        this.nodeExpected = false;
        this.changeListWriter.resetTransientState();
        Stack.clear-impl(this.invalidateStack);
        this.clearUpdatedNodeCounts();
    }

    private final void clearUpdatedNodeCounts() {
        this.nodeCountOverrides = null;
        this.nodeCountVirtualOverrides = null;
    }

    public void collectParameterInformation() {
        this.forceRecomposeScopes = true;
        this.setSourceMarkersEnabled$runtime(true);
        this.slotTable.collectSourceInformation();
        this.insertTable.collectSourceInformation();
        this.writer.updateToTableMaps();
    }

    public void composeContent--ZbOJvo$runtime(MutableScatterMap arg2, Function2 arg3, ShouldPauseCallback arg4) {
        if(!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }

        this.shouldPauseCallback = arg4;
        arg4 = null;
        try {
            this.doCompose-aFTiNEg(arg2, arg3);
        }
        catch(Throwable v2) {
            this.shouldPauseCallback = arg4;
            throw v2;
        }

        this.shouldPauseCallback = arg4;
    }

    private final long compositeKeyOf(int arg10, int arg11, long arg12) {
        int v5;
        long v9;
        int v0 = 3;
        long v2 = 0;
        int v4 = 0;
        while(arg10 >= 0) {
            if(arg10 == arg11) {
                v9 = Long.rotateLeft(arg12, v4);
            }
            else {
                v5 = this.groupCompositeKeyPart(this.reader, arg10);
                if(v5 == 0x78CC281) {
                    v9 = Long.rotateLeft(((long)v5), v4);
                }
                else {
                    goto label_16;
                }
            }

            return v9 ^ v2;
        label_16:
            int v6 = this.reader.hasObjectKey(arg10) ? 0 : this.rGroupIndexOf(arg10);
            v2 = v2 ^ Long.rotateLeft(((long)v5), v0) ^ Long.rotateLeft(((long)v6), v4);
            v0 = (v0 + 6) % 0x40;
            v4 = (v4 + 6) % 0x40;
            arg10 = this.reader.parent(arg10);
        }

        return v2;
    }

    public Object consume(CompositionLocal arg1) {
        return CompositionLocalMapKt.read(this.currentCompositionLocalScope(), arg1);
    }

    private final void createFreshInsertTable() {
        if(!this.writer.getClosed()) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }

        this.forceFreshInsertTable();
    }

    public void createNode(Function0 arg4) {
        this.validateNodeExpected();
        if(!this.getInserting()) {
            ComposerKt.composeImmediateRuntimeError("createNode() can only be called when inserting");
        }

        int v0 = this.parentStateStack.peek();
        GapAnchor v1 = this.writer.anchor(this.writer.getParent());
        ++this.groupNodeCount;
        this.insertFixups.createAndInsertNode(arg4, v0, v1);
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap v0 = this.providerCache;
        if(v0 != null) {
            return v0;
        }

        return this.currentCompositionLocalScope(this.reader.getParent());
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope(int arg6) {
        Object v0_2;
        Object v6;
        String v1 = "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap";
        int v2 = 202;
        if((this.getInserting()) && (this.writerHasAProvider)) {
            int v0;
            for(v0 = this.writer.getParent(); v0 > 0; v0 = this.writer.parent(v0)) {
                if(this.writer.groupKey(v0) == v2 && (Intrinsics.areEqual(this.writer.groupObjectKey(v0), ComposerKt.getCompositionLocalMap()))) {
                    v6 = this.writer.groupAux(v0);
                    Intrinsics.checkNotNull(v6, v1);
                    this.providerCache = ((PersistentCompositionLocalMap)v6);
                    return ((PersistentCompositionLocalMap)v6);
                }
            }
        }

        if(this.reader.getSize() > 0) {
            while(arg6 > 0) {
                if(this.reader.groupKey(arg6) == v2 && (Intrinsics.areEqual(this.reader.groupObjectKey(arg6), ComposerKt.getCompositionLocalMap()))) {
                    MutableIntObjectMap v0_1 = this.providerUpdates;
                    if(v0_1 != null) {
                        v0_2 = v0_1.get(arg6);
                        if(v0_2 == null) {
                            goto label_41;
                        }
                    }
                    else {
                    label_41:
                        v6 = this.reader.groupAux(arg6);
                        Intrinsics.checkNotNull(v6, v1);
                        v0_2 = v6;
                    }

                    this.providerCache = ((PersistentCompositionLocalMap)v0_2);
                    return ((PersistentCompositionLocalMap)v0_2);
                }

                arg6 = this.reader.parent(arg6);
            }
        }

        PersistentCompositionLocalMap v6_1 = this.rootProvider;
        this.providerCache = v6_1;
        return v6_1;
    }

    private final ComposeStackTrace currentStackTrace() {
        if(this.parentContext.getStackTraceEnabled$runtime()) {
            List v0 = CollectionsKt.createListBuilder();
            v0.addAll(ComposeStackTraceBuilderKt.buildTrace$default(this.writer, null, 0, null, 7, null));
            v0.addAll(ComposeStackTraceBuilderKt.buildTrace(this.reader));
            v0.addAll(this.parentStackTrace$runtime());
            return new ComposeStackTrace(CollectionsKt.build(v0), this.getSourceMarkersEnabled$runtime());
        }

        return null;
    }

    public void deactivate$runtime() {
        Stack.clear-impl(this.invalidateStack);
        this.invalidations.clear();
        this.changes.clear();
        this.providerUpdates = null;
    }

    @ComposeCompilerApi public void deactivateToEndGroup(boolean arg3) {
        int v0 = this.groupNodeCount == 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling deactivateToEndGroup");
        }

        if(!this.getInserting()) {
            if(!arg3) {
                this.skipReaderToGroupEnd();
                return;
            }
            else {
                int v3 = this.reader.getCurrentGroup();
                v0 = this.reader.getCurrentEnd();
                this.changeListWriter.deactivateCurrentGroup();
                GapComposerKt.access$removeRange(this.invalidations, v3, v0);
                this.reader.skipToGroupEnd();
            }
        }
    }

    public void disableReusing() {
        this.reusing = false;
    }

    public void disableSourceInformation() {
        this.setSourceMarkersEnabled$runtime(false);
    }

    public void dispose$runtime() {
        Object v0 = Trace.INSTANCE.beginSection("Compose:Composer.dispose");
        try {
            this.parentContext.unregisterComposer$runtime(this);
            this.deactivate$runtime();
            this.getApplier().clear();
            this.isDisposed = true;
        }
        catch(Throwable v3) {
            Trace.INSTANCE.endSection(v0);
            throw v3;
        }

        Trace.INSTANCE.endSection(v0);
    }

    private final void doCompose-aFTiNEg(MutableScatterMap arg7, Function2 arg8) {
        MutableVector v5;
        GapComposer$derivedStateObserver$1 v4;
        Object v3;
        if(this.isComposing$runtime()) {
            ComposerKt.composeImmediateRuntimeError("Reentrant composition is not supported");
        }

        CompositionObserver v0 = this.observerHolder.current();
        Object v1 = Trace.INSTANCE.beginSection("Compose:recompose");
        try {
            this.compositionToken = Long.hashCode(SnapshotKt.currentSnapshot().getSnapshotId());
            this.providerUpdates = null;
            this.updateComposerInvalidations-RY85e9Y$runtime(arg7);
            this.nodeIndex = 0;
            this.isComposing = true;
            if(v0 != null) {
                v0.onBeginComposition(this.getComposition());
            }
        }
        catch(Throwable v6) {
            goto label_95;
        }

        try {
            this.startRoot();
            v3 = this.nextSlot();
            if((((Function2)v3)) != arg8 && arg8 != null) {
                this.updateValue(arg8);
            }

            v4 = this.derivedStateObserver;
            v5 = SnapshotStateKt.derivedStateObservers();
        }
        catch(Throwable v8) {
            goto label_79;
        }

        try {
            v5.add(v4);
            int v4_1 = 200;
            if(arg8 != null) {
                this.startGroup(v4_1, ComposerKt.getInvocation());
                Expect_jvmKt.invokeComposable(this, arg8);
                this.endGroup();
            }
            else {
                if(((this.forciblyRecompose) || (this.providersInvalid)) && (v3 != null && !Intrinsics.areEqual(v3, Composer.Companion.getEmpty()))) {
                    this.startGroup(v4_1, ComposerKt.getInvocation());
                    Expect_jvmKt.invokeComposable(this, TypeIntrinsics.beforeCheckcastToFunctionOfArity(v3, 2));
                    this.endGroup();
                    goto label_58;
                }

                this.skipCurrentGroup();
            }

            goto label_58;
        }
        catch(Throwable v8) {
            try {
                v5.removeAt(v5.getSize() - 1);
                throw v8;
            label_58:
                v5.removeAt(v5.getSize() - 1);
                this.endRoot();
                if(v0 == null) {
                    goto label_65;
                }

                goto label_63;
            }
            catch(Throwable v8) {
                try {
                label_79:
                    throw ComposeStackTraceKt.attachComposeStackTrace(v8, new GapComposer$$ExternalSyntheticLambda5(this));
                }
                catch(Throwable v8) {
                    if(v0 != null) {
                        try {
                            v0.onEndComposition(this.getComposition());
                        label_87:
                            this.isComposing = false;
                            this.invalidations.clear();
                            this.abortRoot();
                            this.createFreshInsertTable();
                            throw v8;
                        label_63:
                            v0.onEndComposition(this.getComposition());
                        label_65:
                            this.isComposing = false;
                            this.invalidations.clear();
                            this.createFreshInsertTable();
                            goto label_70;
                        }
                        catch(Throwable v6) {
                        label_95:
                            Trace.INSTANCE.endSection(v1);
                            throw v6;
                        }
                    }

                    goto label_87;
                }
            }
        }

    label_70:
        Trace.INSTANCE.endSection(v1);
    }

    private static final ComposeStackTrace doCompose_aFTiNEg$lambda$1$1(GapComposer arg0) {
        return arg0.currentStackTrace();
    }

    private final void doRecordDownsFor(int arg2, int arg3) {
        if(arg2 > 0 && arg2 != arg3) {
            this.doRecordDownsFor(this.reader.parent(arg2), arg3);
            if(this.reader.isNode(arg2)) {
                this.changeListWriter.moveDown(this.nodeAt(this.reader, arg2));
            }
        }
    }

    public void enableReusing() {
        boolean v0 = this.reusingGroup >= 0 ? true : false;
        this.reusing = v0;
    }

    private final void end(boolean arg21) {
        List v19;
        List v17;
        long v6_1;
        long v3_2;
        Object v3_1;
        Object v7;
        int v6;
        int v3;
        GapComposer v0 = this;
        int v1 = v0.parentStateStack.peek2() - 1;
        int v4 = 0xCF;
        int v5 = 3;
        if(v0.getInserting()) {
            v3 = v0.writer.getParent();
            v6 = v0.writer.groupKey(v3);
            v7 = v0.writer.groupObjectKey(v3);
            v3_1 = v0.writer.groupAux(v3);
            if(v7 == null) {
                if(v3_1 != null && v6 == v4 && !Intrinsics.areEqual(v3_1, Composer.Companion.getEmpty())) {
                    v0.compositeKeyHashCode = Long.rotateRight((((long)v3_1.hashCode())) ^ Long.rotateRight(v0.getCompositeKeyHashCode() ^ (((long)v1)), v5), v5);
                    goto label_94;
                }

                v3_2 = Long.rotateRight(v0.getCompositeKeyHashCode() ^ (((long)v1)), v5);
                v6_1 = ((long)v6);
            }
            else {
                v1 = (v7 instanceof Enum) ? ((Enum)v7).ordinal() : v7.hashCode();
                v3_2 = Long.rotateRight(v0.getCompositeKeyHashCode(), v5);
                v6_1 = ((long)v1);
            }

            v0.compositeKeyHashCode = Long.rotateRight(v3_2 ^ v6_1, v5);
        }
        else {
            v3 = v0.reader.getParent();
            v6 = v0.reader.groupKey(v3);
            v7 = v0.reader.groupObjectKey(v3);
            v3_1 = v0.reader.groupAux(v3);
            if(v7 == null) {
                if(v3_1 != null && v6 == v4 && !Intrinsics.areEqual(v3_1, Composer.Companion.getEmpty())) {
                    v0.compositeKeyHashCode = Long.rotateRight((((long)v3_1.hashCode())) ^ Long.rotateRight(v0.getCompositeKeyHashCode() ^ (((long)v1)), v5), v5);
                    goto label_94;
                }

                v3_2 = Long.rotateRight(v0.getCompositeKeyHashCode() ^ (((long)v1)), v5);
                v6_1 = ((long)v6);
            }
            else {
                v1 = (v7 instanceof Enum) ? ((Enum)v7).ordinal() : v7.hashCode();
                v3_2 = Long.rotateRight(v0.getCompositeKeyHashCode(), v5);
                v6_1 = ((long)v1);
            }

            v0.compositeKeyHashCode = Long.rotateRight(v3_2 ^ v6_1, v5);
        }

    label_94:
        v1 = v0.groupNodeCount;
        GapPending v3_3 = v0.pending;
        if(v3_3 != null && v3_3.getKeyInfos().size() > 0) {
            List v5_1 = v3_3.getKeyInfos();
            List v6_2 = v3_3.getUsed();
            Set v7_1 = ListUtilsKt.fastToSet(v6_2);
            MutableScatterSet v8 = ScatterSetKt.mutableScatterSetOf();
            int v9 = v6_2.size();
            int v10 = v5_1.size();
            int v11 = 0;
            int v12 = 0;
            int v13 = 0;
            while(v11 < v10) {
                Object v14 = v5_1.get(v11);
                if(!v7_1.contains(v14)) {
                    v0.changeListWriter.removeNode(v3_3.nodePositionOf(((KeyInfo)v14)) + v3_3.getStartIndex(), ((KeyInfo)v14).getNodes());
                    v3_3.updateNodeCount(((KeyInfo)v14).getLocation(), 0);
                    v0.changeListWriter.moveReaderRelativeTo(((KeyInfo)v14).getLocation());
                    v0.reader.reposition(((KeyInfo)v14).getLocation());
                    v0.recordDelete();
                    v0.reader.skipGroup();
                    v17 = v5_1;
                    GapComposerKt.access$removeRange(v0.invalidations, ((KeyInfo)v14).getLocation(), ((KeyInfo)v14).getLocation() + v0.reader.groupSize(((KeyInfo)v14).getLocation()));
                    goto label_140;
                }
                else {
                    v17 = v5_1;
                    if(v8.contains(v14)) {
                    label_140:
                        ++v11;
                    }
                    else if(v12 < v9) {
                        Object v2 = v6_2.get(v12);
                        if(v2 != v14) {
                            v4 = v3_3.nodePositionOf(((KeyInfo)v2));
                            v8.add(v2);
                            if(v4 != v13) {
                                v5 = v3_3.updatedNodeCountOf(((KeyInfo)v2));
                                v19 = v6_2;
                                v0.changeListWriter.moveNode(v3_3.getStartIndex() + v4, v13 + v3_3.getStartIndex(), v5);
                                v3_3.registerMoveNode(v4, v13, v5);
                            }
                            else {
                                v19 = v6_2;
                            }
                        }
                        else {
                            v19 = v6_2;
                            ++v11;
                        }

                        ++v12;
                        v13 += v3_3.updatedNodeCountOf(((KeyInfo)v2));
                        v5_1 = v17;
                        v6_2 = v19;
                        continue;
                    }
                }

                v5_1 = v17;
            }

            v0.changeListWriter.endNodeMovement();
            if(v5_1.size() <= 0) {
                goto label_185;
            }

            v0.changeListWriter.moveReaderRelativeTo(v0.reader.getGroupEnd());
            v0.reader.skipToGroupEnd();
        }

    label_185:
        boolean v2_1 = v0.getInserting();
        if(!v2_1) {
            v3 = v0.reader.getRemainingSlots();
            if(v3 > 0) {
                v0.changeListWriter.trimValues(v3);
            }
        }

        v3 = v0.nodeIndex;
        while(!v0.reader.isGroupEnd()) {
            v4 = v0.reader.getCurrentGroup();
            v0.recordDelete();
            v0.changeListWriter.removeNode(v3, v0.reader.skipGroup());
            GapComposerKt.access$removeRange(v0.invalidations, v4, v0.reader.getCurrentGroup());
        }

        if(v2_1) {
            if(arg21) {
                v0.insertFixups.endNodeInsert();
                v1 = 1;
            }

            v0.reader.endEmpty();
            v3 = v0.writer.getParent();
            v0.writer.endGroup();
            if(v0.reader.getInEmpty()) {
                goto label_255;
            }

            v3 = v0.insertedGroupVirtualIndex(v3);
            v0.writer.endInsert();
            v0.writer.close(true);
            v0.recordInsert(v0.insertAnchor);
            v0.inserting = false;
            if(v0.slotTable.isEmpty()) {
                goto label_255;
            }

            v0.updateNodeCount(v3, 0);
            v0.updateNodeCountOverrides(v3, v1);
        }
        else {
            if(arg21) {
                v0.changeListWriter.moveUp();
            }

            v0.changeListWriter.endCurrentGroup();
            v3 = v0.reader.getParent();
            if(v1 != v0.updatedNodeCount(v3)) {
                v0.updateNodeCountOverrides(v3, v1);
            }

            if(arg21) {
                v1 = 1;
            }

            v0.reader.endGroup();
            v0.changeListWriter.endNodeMovement();
        }

    label_255:
        v0.exitGroup(v1, v2_1);
    }

    @ComposeCompilerApi public void endDefaults() {
        this.endGroup();
        RecomposeScopeImpl v1 = this.getCurrentRecomposeScope$runtime();
        if(v1 != null && (v1.getUsed())) {
            v1.setDefaultsInScope(true);
        }
    }

    private final void endGroup() {
        this.end(false);
    }

    @ComposeCompilerApi public void endMovableGroup() {
        this.endGroup();
    }

    public void endNode() {
        this.end(true);
    }

    public void endProvider() {
        this.endGroup();
        this.endGroup();
        this.providersInvalid = GapComposerKt.access$asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    public void endProviders() {
        this.endGroup();
        this.endGroup();
        this.providersInvalid = GapComposerKt.access$asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @ComposeCompilerApi public void endReplaceGroup() {
        this.endGroup();
    }

    @ComposeCompilerApi public void endReplaceableGroup() {
        this.endGroup();
    }

    @ComposeCompilerApi public ScopeUpdateScope endRestartGroup() {
        Object v1_2;
        ScopeUpdateScope v1 = null;
        Object v0 = Stack.isNotEmpty-impl(this.invalidateStack) ? Stack.pop-impl(this.invalidateStack) : v1;
        if(v0 != null) {
            ((RecomposeScopeImpl)v0).setRequiresRecompose(false);
            Function1 v3 = this.exitRecomposeScope(((RecomposeScopeImpl)v0));
            if(v3 != null) {
                this.changeListWriter.endCompositionScope(v3, this.getComposition());
            }

            if(!((RecomposeScopeImpl)v0).getResuming()) {
                goto label_32;
            }

            ((RecomposeScopeImpl)v0).setResuming(false);
            this.changeListWriter.endResumingScope(((RecomposeScopeImpl)v0));
            ((RecomposeScopeImpl)v0).setReusing(false);
            if(!((RecomposeScopeImpl)v0).getResetReusing()) {
                goto label_32;
            }

            ((RecomposeScopeImpl)v0).setResetReusing(false);
            if(this.reusingGroup != this.reader.getParent()) {
                goto label_32;
            }

            this.reusing = false;
            this.reusingGroup = -1;
        }

    label_32:
        if(v0 != null && !((RecomposeScopeImpl)v0).getSkipped$runtime() && ((((RecomposeScopeImpl)v0).getUsed()) || (this.forceRecomposeScopes))) {
            if(((RecomposeScopeImpl)v0).getAnchor() == null) {
                GapAnchor v1_1 = this.getInserting() ? this.writer.anchor(this.writer.getParent()) : this.reader.anchor(this.reader.getParent());
                ((RecomposeScopeImpl)v0).setAnchor(((Anchor)v1_1));
            }

            ((RecomposeScopeImpl)v0).setDefaultsInvalid(false);
            v1_2 = v0;
        }

        this.end(false);
        return ((ScopeUpdateScope)v1_2);
    }

    public void endReusableGroup() {
        if((this.reusing) && this.reader.getParent() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }

        this.end(false);
    }

    public void endReuseFromRoot$runtime() {
        int v0 = (this.isComposing$runtime()) || this.reusingGroup != 0 ? 0 : 1;
        if(v0 == 0) {
            PreconditionsKt.throwIllegalArgumentException("Cannot disable reuse from root if it was caused by other groups");
        }

        this.reusingGroup = -1;
        this.reusing = false;
    }

    private final void endRoot() {
        this.endGroup();
        this.parentContext.doneComposing$runtime();
        this.endGroup();
        this.changeListWriter.endRoot();
        this.finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
        this.providersInvalid = GapComposerKt.access$asBool(this.providersInvalidStack.pop());
    }

    public void endToMarker(int arg3) {
        int v1;
        SlotWriter v0;
        if(arg3 < 0) {
            arg3 = -arg3;
            v0 = this.writer;
            while(true) {
                v1 = v0.getParent();
                if(v1 > arg3) {
                    this.end(v0.isNode(v1));
                    continue;
                }

                return;
            }
        }
        else {
            if(this.getInserting()) {
                v0 = this.writer;
                while(this.getInserting()) {
                    this.end(v0.isNode(v0.getParent()));
                }
            }

            SlotReader v0_1 = this.reader;
            while(true) {
                v1 = v0_1.getParent();
                if(v1 <= arg3) {
                    return;
                }

                this.end(v0_1.isNode(v1));
            }
        }
    }

    private final void ensureWriter() {
        if(this.writer.getClosed()) {
            SlotWriter v0 = this.insertTable.openWriter();
            this.writer = v0;
            v0.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void enterGroup(boolean arg3, GapPending arg4) {
        Stack.push-impl(this.pendingStack, this.pending);
        this.pending = arg4;
        this.parentStateStack.push(this.groupNodeCount);
        this.parentStateStack.push(this.rGroupIndex);
        this.parentStateStack.push(this.nodeIndex);
        if(arg3) {
            this.nodeIndex = 0;
        }

        this.groupNodeCount = 0;
        this.rGroupIndex = 0;
    }

    private final void enterRecomposeScope(RecomposeScopeImpl arg2) {
        arg2.start(this.compositionToken);
        CompositionObserver v1 = this.observerHolder.current();
        if(v1 != null) {
            v1.onScopeEnter(((RecomposeScope)arg2));
        }
    }

    private final void exitGroup(int arg2, boolean arg3) {
        Object v0 = Stack.pop-impl(this.pendingStack);
        if(v0 != null && !arg3) {
            ((GapPending)v0).setGroupIndex(((GapPending)v0).getGroupIndex() + 1);
        }

        this.pending = ((GapPending)v0);
        this.nodeIndex = this.parentStateStack.pop() + arg2;
        this.rGroupIndex = this.parentStateStack.pop();
        this.groupNodeCount = this.parentStateStack.pop() + arg2;
    }

    private final Function1 exitRecomposeScope(RecomposeScopeImpl arg3) {
        CompositionObserver v0 = this.observerHolder.current();
        if(v0 != null) {
            v0.onScopeExit(arg3);
        }

        return arg3.end(this.compositionToken);
    }

    private final void finalizeCompose() {
        this.changeListWriter.finalizeComposition();
        if(!Stack.isEmpty-impl(this.pendingStack)) {
            ComposerKt.composeImmediateRuntimeError("Start/end imbalance");
        }

        this.cleanUpCompose();
    }

    private final void forceFreshInsertTable() {
        SlotTable v0 = new SlotTable();
        if(this.getSourceMarkersEnabled$runtime()) {
            v0.collectSourceInformation();
        }

        if(this.parentContext.getCollectingCallByInformation$runtime()) {
            v0.collectCalledByInformation();
        }

        this.insertTable = v0;
        SlotWriter v0_1 = v0.openWriter();
        v0_1.close(true);
        this.writer = v0_1;
    }

    public boolean forceRecomposeScopes$runtime() {
        if(!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = true;
            this.forciblyRecompose = true;
            return 1;
        }

        return 0;
    }

    public Applier getApplier() {
        return this.applier;
    }

    public CoroutineContext getApplyCoroutineContext() {
        return this.applyCoroutineContext;
    }

    public boolean getAreChildrenComposing$runtime() {
        if(this.childrenComposing > 0) {
            return 1;
        }

        return 0;
    }

    public long getCompositeKeyHashCode() {
        return this.compositeKeyHashCode;
    }

    public static void getCompositeKeyHashCode$annotations() {
    }

    public CompositionImpl getComposition() {
        return this.composition;
    }

    public ControlledComposition getComposition() {
        return this.getComposition();
    }

    public CompositionData getCompositionData() {
        CompositionData v0 = this._compositionData;
        if(v0 == null) {
            GapCompositionDataImpl v0_1 = new GapCompositionDataImpl(this.getComposition());
            this._compositionData = ((CompositionData)v0_1);
        }

        return v0;
    }

    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return this.currentCompositionLocalScope();
    }

    public int getCurrentMarker() {
        if(this.getInserting()) {
            return -this.writer.getParent();
        }

        return this.reader.getParent();
    }

    public RecomposeScopeImpl getCurrentRecomposeScope$runtime() {
        ArrayList v0 = this.invalidateStack;
        if(this.childrenComposing == 0 && (Stack.isNotEmpty-impl(v0))) {
            return Stack.peek-impl(v0);
        }

        return null;
    }

    public boolean getDefaultsInvalid() {
        if((this.getSkipping()) && !this.providersInvalid) {
            RecomposeScopeImpl v2 = this.getCurrentRecomposeScope$runtime();
            if(v2 != null && (v2.getDefaultsInvalid())) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    @ComposeCompilerApi public static void getDefaultsInvalid$annotations() {
    }

    public Changes getDeferredChanges$runtime() {
        return this.getDeferredChanges$runtime();
    }

    public ChangeList getDeferredChanges$runtime() {
        return this.deferredChanges;
    }

    public CompositionErrorContextImpl getErrorContext$runtime() {
        if(this.parentContext.getStackTraceEnabled$runtime()) {
            return this.errorContext;
        }

        return null;
    }

    public final boolean getHasInvalidations() {
        return this.invalidations.isEmpty() ^ 1;
    }

    public boolean getHasPendingChanges$runtime() {
        return this.changes.isNotEmpty();
    }

    public final SlotTable getInsertTable$runtime() {
        return this.insertTable;
    }

    public boolean getInserting() {
        return this.inserting;
    }

    @ComposeCompilerApi public static void getInserting$annotations() {
    }

    private final Object getNode(SlotReader arg1) {
        return arg1.node(arg1.getParent());
    }

    public final SlotReader getReader$runtime() {
        return this.reader;
    }

    public RecomposeScope getRecomposeScope() {
        return this.getCurrentRecomposeScope$runtime();
    }

    public Object getRecomposeScopeIdentity() {
        RecomposeScopeImpl v0 = this.getCurrentRecomposeScope$runtime();
        if(v0 != null) {
            return v0.getAnchor();
        }

        return null;
    }

    public boolean getSkipping() {
        if(!this.getInserting() && !this.reusing && !this.providersInvalid) {
            RecomposeScopeImpl v0 = this.getCurrentRecomposeScope$runtime();
            if(v0 != null && !v0.getRequiresRecompose() && !this.forciblyRecompose) {
                return 1;
            }
        }

        return 0;
    }

    @ComposeCompilerApi public static void getSkipping$annotations() {
    }

    public boolean getSourceMarkersEnabled$runtime() {
        return this.sourceMarkersEnabled;
    }

    private final int groupCompositeKeyPart(SlotReader arg2, int arg3) {
        if(arg2.hasObjectKey(arg3)) {
            Object v1 = arg2.groupObjectKey(arg3);
            if(v1 != null) {
                if((v1 instanceof Enum)) {
                    return ((Enum)v1).ordinal();
                }

                if((v1 instanceof MovableContent)) {
                    return 0x78CC281;
                }

                return v1.hashCode();
            }

            return 0;
        }

        int v1_1 = arg2.groupKey(arg3);
        if(v1_1 == 0xCF) {
            Object v2 = arg2.groupAux(arg3);
            if(v2 != null) {
                if(Intrinsics.areEqual(v2, Composer.Companion.getEmpty())) {
                }
                else {
                    v1_1 = v2.hashCode();
                }
            }
        }

        return v1_1;
    }

    public void insertMovableContent(MovableContent arg3, Object arg4) {
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        this.invokeMovableContentLambda(arg3, this.currentCompositionLocalScope(), arg4, false);
    }

    private final void insertMovableContentGuarded(List arg23) {
        MutableIntObjectMap v18_2;
        List v5_2;
        Integer v4_3;
        ControlledComposition v3_1;
        GapComposer$$ExternalSyntheticLambda2 v6_3;
        ChangeList v20;
        Integer v19_1;
        ControlledComposition v18_1;
        ControlledComposition v2_2;
        boolean v11_1;
        ComposerChangeListWriter v8_2;
        MutableIntObjectMap v9_1;
        int[] v13_1;
        ChangeList v6_2;
        ComposerChangeListWriter v12_2;
        ChangeList v7_4;
        SlotReader v16;
        MutableIntObjectMap v5_1;
        int[] v4_2;
        SlotReader v8_1;
        List v15_1;
        GapAnchor v7_2;
        SlotTable v12_1;
        SlotTable v7_1;
        MovableContentState v6_1;
        int v21;
        int v17;
        ChangeList v19;
        ComposerChangeListWriter v18;
        SlotReader v15;
        IntRef v14;
        DefaultConstructorMarker v8;
        int v6;
        SlotTable v5;
        GapAnchor v4;
        Object v3;
        Object v2_1;
        int v13;
        int v12;
        int v11;
        GapComposer v1 = this;
        List v0 = arg23;
        ComposerChangeListWriter v9 = v1.changeListWriter;
        ChangeList v2 = ChangeListKt.asGapBufferChangeList(v1.lateChanges);
        ChangeList v10 = v9.getChangeList();
        try {
            v9.setChangeList(v2);
            v1.changeListWriter.resetSlots();
            v11 = v0.size();
            v12 = 0;
            v13 = 0;
        }
        catch(Throwable v0_1) {
            goto label_236;
        }

        while(true) {
            if(v13 >= v11) {
                goto label_220;
            }

            try {
                v2_1 = v0.get(v13);
                v3 = ((Pair)v2_1).component1();
                v2_1 = ((Pair)v2_1).component2();
                v4 = GapAnchorKt.asGapAnchor(((MovableContentStateReference)v3).getAnchor$runtime());
                v5 = SlotTableKt.asGapBufferSlotTable(((MovableContentStateReference)v3).getSlotStorage$runtime());
                v6 = v5.anchorIndex(v4);
                v8 = null;
                v14 = new IntRef(v12, 1, v8);
                v1.changeListWriter.determineMovableContentNodeIndex(v14, v4);
                if(v2_1 == null) {
                }
                else {
                    goto label_65;
                }
            }
            catch(Throwable v0_1) {
                goto label_217;
            }

            try {
                if(Intrinsics.areEqual(v5, v1.insertTable)) {
                    v1.createFreshInsertTable();
                }

                v15 = v5.openReader();
            }
            catch(Throwable v0_1) {
                goto label_236;
            }

            try {
                v15.reposition(v6);
                v1.changeListWriter.moveReaderToAbsolute(v6);
                v2 = new ChangeList();
                GapComposer.recomposeMovableContent$default(v1, null, null, null, null, new GapComposer$$ExternalSyntheticLambda1(v1, v2, v15, ((MovableContentStateReference)v3)), 15, null);
                v1.changeListWriter.includeOperationsIn(v2, v14);
                goto label_56;
            }
            catch(Throwable v0_1) {
                try {
                    v15.close();
                    throw v0_1;
                label_56:
                    v15.close();
                    v18 = v9;
                    v19 = v10;
                    v17 = v11;
                    v21 = v13;
                    goto label_156;
                }
                catch(Throwable v0_1) {
                    goto label_236;
                }
            }

            try {
            label_65:
                v6_1 = v1.parentContext.movableContentStateResolve$runtime(((MovableContentStateReference)v2_1));
                if(v6_1 != null) {
                }
                else {
                    goto label_72;
                }
            }
            catch(Throwable v0_1) {
                goto label_217;
            }

            try {
                SlotStorage v7 = v6_1.getSlotStorage$runtime();
                if(v7 != null) {
                    v7_1 = SlotTableKt.asGapBufferSlotTable(v7);
                }
                else {
                label_72:
                    v7_1 = ((SlotTable)v8);
                }

                v12_1 = v7_1 == null ? SlotTableKt.asGapBufferSlotTable(((MovableContentStateReference)v2_1).getSlotStorage$runtime()) : v7_1;
                if(v7_1 != null) {
                    v7_2 = v7_1.anchor(0);
                    if(v7_2 != null) {
                    }
                    else {
                        goto label_83;
                    }
                }
                else {
                    goto label_83;
                }

                goto label_84;
            }
            catch(Throwable v0_1) {
                goto label_236;
            }

            try {
            label_83:
                Anchor v7_3 = ((MovableContentStateReference)v2_1).getAnchor$runtime();
            label_84:
                v7_2 = GapAnchorKt.asGapAnchor(v7_3);
                v15_1 = GapComposerKt.access$collectNodesFrom(v12_1, v7_2);
                if(!v15_1.isEmpty()) {
                    goto label_89;
                }

                goto label_100;
            }
            catch(Throwable v0_1) {
                goto label_217;
            }

            try {
            label_89:
                v1.changeListWriter.copyNodesToNewAnchorLocation(v15_1, v14);
                if(Intrinsics.areEqual(v5, v1.slotTable)) {
                    int v4_1 = v1.slotTable.anchorIndex(v4);
                    v1.updateNodeCount(v4_1, v1.updatedNodeCount(v4_1) + v15_1.size());
                }
            }
            catch(Throwable v0_1) {
                goto label_236;
            }

            try {
            label_100:
                v1.changeListWriter.copySlotTableToAnchorLocation(v6_1, v1.parentContext, ((MovableContentStateReference)v2_1), ((MovableContentStateReference)v3));
                v8_1 = v12_1.openReader();
            }
            catch(Throwable v0_1) {
            label_217:
                v18 = v9;
                v19 = v10;
                break;
            }

            try {
                v15 = v1.reader;
                v4_2 = v1.nodeCountOverrides;
                v5_1 = v1.providerUpdates;
                v1.nodeCountOverrides = null;
                v1.providerUpdates = null;
            }
            catch(Throwable v0_1) {
                v16 = v8_1;
                v18 = v9;
                v19 = v10;
                goto label_214;
            }

            try {
                v1.reader = v8_1;
                v6 = v12_1.anchorIndex(GapAnchorKt.asGapAnchor(((Anchor)v7_2)));
                v8_1.reposition(v6);
                v1.changeListWriter.moveReaderToAbsolute(v6);
                v7_4 = new ChangeList();
                v12_2 = v1.changeListWriter;
                v6_2 = v12_2.getChangeList();
            }
            catch(Throwable v0_1) {
                v13_1 = v4_2;
                v16 = v8_1;
                v18 = v9;
                v19 = v10;
                v9_1 = v5_1;
                goto label_204;
            }

            try {
                v12_2.setChangeList(v7_4);
                v16 = v8_1;
            }
            catch(Throwable v0_1) {
                v13_1 = v4_2;
                v16 = v8_1;
                goto label_190;
            }

            try {
                v8_2 = v1.changeListWriter;
                v17 = v11;
                v11_1 = v8_2.getImplicitRootStart();
                goto label_126;
            }
            catch(Throwable v0_1) {
                v13_1 = v4_2;
            }

        label_190:
            v18 = v9;
            v19 = v10;
            v9_1 = v5_1;
            v10 = v6_2;
            goto label_194;
            try {
            label_126:
                v8_2.setImplicitRootStart(false);
                Object v0_2 = v2_1;
                v2_2 = ((MovableContentStateReference)v0_2).getComposition$runtime();
                v18_1 = ((MovableContentStateReference)v3).getComposition$runtime();
                v19_1 = Integer.valueOf(v16.getCurrentGroup());
                v0 = ((MovableContentStateReference)v0_2).getInvalidations$runtime();
                v20 = v6_2;
            }
            catch(Throwable v0_1) {
                v13_1 = v4_2;
                v18 = v9;
                v19 = v10;
                v9_1 = v5_1;
                v10 = v6_2;
                goto label_180;
            }

            try {
                v6_3 = new GapComposer$$ExternalSyntheticLambda2(v1, ((MovableContentStateReference)v3));
                v21 = v13;
                v3_1 = v18_1;
                v13_1 = v4_2;
                v18 = v9;
                v4_3 = v19_1;
                v9_1 = v5_1;
                v19 = v10;
                v10 = v20;
                v5_2 = v0;
            }
            catch(Throwable v0_1) {
                Integer v13_2 = v4_3;
                v18_2 = v9_1;
                v19 = v10;
                v10 = v20;
                List v9_2 = v5_2;
                goto label_180;
            }

            try {
                v1.recomposeMovableContent(v2_2, v3_1, v4_3, v5_2, ((Function0)v6_3));
                goto label_146;
            }
            catch(Throwable v0_1) {
            }

            try {
            label_180:
                v8_2.setImplicitRootStart(v11_1);
                throw v0_1;
            label_146:
                v8_2.setImplicitRootStart(v11_1);
                goto label_147;
            }
            catch(Throwable v0_1) {
            }

            try {
            label_194:
                v12_2.setChangeList(v10);
                throw v0_1;
            label_147:
                v12_2.setChangeList(v10);
                v1.changeListWriter.includeOperationsIn(v7_4, v14);
                goto label_151;
            }
            catch(Throwable v0_1) {
            }

            try {
            label_204:
                v1.reader = v15;
                v1.nodeCountOverrides = v13_1;
                v1.providerUpdates = v9_1;
                throw v0_1;
            label_151:
                v1.reader = v15;
                v1.nodeCountOverrides = v13_1;
                v1.providerUpdates = v9_1;
                goto label_155;
            }
            catch(Throwable v0_1) {
            }

            try {
            label_214:
                v16.close();
                throw v0_1;
            label_155:
                v16.close();
            label_156:
                v1.changeListWriter.skipToEndOfCurrentGroup();
                v13 = v21 + 1;
                v0 = arg23;
                v11 = v17;
                v9 = v18;
                v10 = v19;
                v12 = 0;
                continue;
            label_220:
                v18 = v9;
                v19 = v10;
                v1.changeListWriter.endMovableContentPlacement();
                v1.changeListWriter.moveReaderToAbsolute(0);
                goto label_227;
            }
            catch(Throwable v0_1) {
                break;
            }
        }

        ComposerChangeListWriter v1_1 = ((ComposerChangeListWriter)v18_2);
        v2 = v19;
        goto label_238;
    label_227:
        v18.setChangeList(v19);
        return;
    label_236:
        v1_1 = v9;
        v2 = v10;
    label_238:
        v1_1.setChangeList(v2);
        throw v0_1;
    }

    private static final Unit insertMovableContentGuarded$lambda$0$0$0$0(GapComposer arg8, ChangeList arg9, SlotReader arg10, MovableContentStateReference arg11) {
        boolean v4;
        ComposerChangeListWriter v10_1;
        MutableIntObjectMap v3;
        int[] v2;
        SlotReader v9;
        ComposerChangeListWriter v0 = arg8.changeListWriter;
        ChangeList v1 = v0.getChangeList();
        try {
            v0.setChangeList(arg9);
            v9 = arg8.reader;
            v2 = arg8.nodeCountOverrides;
            v3 = arg8.providerUpdates;
            arg8.nodeCountOverrides = null;
            arg8.providerUpdates = null;
        }
        catch(Throwable v8) {
            goto label_36;
        }

        try {
            arg8.reader = arg10;
            v10_1 = arg8.changeListWriter;
            v4 = v10_1.getImplicitRootStart();
        }
        catch(Throwable v10) {
            goto label_31;
        }

        try {
            v10_1.setImplicitRootStart(false);
            arg8.invokeMovableContentLambda(arg11.getContent$runtime(), arg11.getLocals$runtime(), arg11.getParameter$runtime(), true);
            goto label_19;
        }
        catch(Throwable v11) {
            try {
                v10_1.setImplicitRootStart(v4);
                throw v11;
            label_19:
                v10_1.setImplicitRootStart(v4);
                goto label_21;
            }
            catch(Throwable v10) {
                try {
                label_31:
                    arg8.reader = v9;
                    arg8.nodeCountOverrides = v2;
                    arg8.providerUpdates = v3;
                    throw v10;
                label_21:
                    arg8.reader = v9;
                    arg8.nodeCountOverrides = v2;
                    arg8.providerUpdates = v3;
                }
                catch(Throwable v8) {
                label_36:
                    v0.setChangeList(v1);
                    throw v8;
                }
            }
        }

        v0.setChangeList(v1);
        return Unit.INSTANCE;
    }

    private static final Unit insertMovableContentGuarded$lambda$0$0$1$0$0$0$0(GapComposer arg3, MovableContentStateReference arg4) {
        arg3.invokeMovableContentLambda(arg4.getContent$runtime(), arg4.getLocals$runtime(), arg4.getParameter$runtime(), true);
        return Unit.INSTANCE;
    }

    public void insertMovableContentReferences(List arg3) {
        Object v0 = Trace.INSTANCE.beginSection("Compose:insertMovableContent");
        try {
            this.insertMovableContentGuarded(arg3);
            goto label_4;
        }
        catch(Throwable v3) {
            try {
                this.abortRoot();
                throw v3;
            label_4:
                this.cleanUpCompose();
            }
            catch(Throwable v2) {
                Trace.INSTANCE.endSection(v0);
                throw v2;
            }
        }

        Trace.INSTANCE.endSection(v0);
    }

    private final int insertedGroupVirtualIndex(int arg1) {
        return -2 - arg1;
    }

    private final void invokeMovableContentLambda(MovableContent arg13, PersistentCompositionLocalMap arg14, Object arg15, boolean arg16) {
        this.startMovableGroup(0x78CC281, arg13);
        this.updateSlot(arg15);
        long v9 = this.getCompositeKeyHashCode();
        long v0 = 0x78CC281;
        Object v11 = null;
        try {
            this.compositeKeyHashCode = v0;
            boolean v1 = false;
            if(this.getInserting()) {
                SlotWriter.markGroup$default(this.writer, 0, 1, v11);
            }

            if(this.getInserting()) {
            }
            else if(!Intrinsics.areEqual(this.reader.getGroupAux(), arg14)) {
                v1 = true;
            }

            if(v1) {
                this.recordProviderUpdate(arg14);
            }

            this.start-AzEfcrM(202, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.getGroup-9udXigM(), arg14);
            this.providerCache = ((PersistentCompositionLocalMap)v11);
            if(!this.getInserting() || (arg16)) {
                boolean v0_2 = this.providersInvalid;
                this.providersInvalid = v1;
                Expect_jvmKt.invokeComposable(this, ComposableLambdaKt.composableLambdaInstance(-59194059, true, new GapComposer$$ExternalSyntheticLambda3(arg13, arg15)));
                this.providersInvalid = v0_2;
            }
            else {
                this.writerHasAProvider = true;
                this.parentContext.insertMovableContent$runtime(new MovableContentStateReference(arg13, arg15, this.getComposition(), this.insertTable, this.writer.anchor(this.writer.parent(this.writer.getParent())), CollectionsKt.emptyList(), this.currentCompositionLocalScope(), null));
            }
        }
        catch(Throwable v0_1) {
            Throwable v13 = v0_1;
            try {
                throw ComposeStackTraceKt.attachComposeStackTrace(v13, new GapComposer$$ExternalSyntheticLambda4(this));
            }
            catch(Throwable v0_1) {
                this.endGroup();
                this.providerCache = ((PersistentCompositionLocalMap)v11);
                this.compositeKeyHashCode = v9;
                this.endMovableGroup();
                throw v0_1;
            }
        }

        this.endGroup();
        this.providerCache = ((PersistentCompositionLocalMap)v11);
        this.compositeKeyHashCode = v9;
        this.endMovableGroup();
    }

    static final Unit invokeMovableContentLambda$lambda$0(MovableContent arg4, Object arg5, Composer arg6, int arg7) {
        ComposerKt.sourceInformation(arg6, "C2265@91036L18:GapComposer.kt#9igjgp");
        boolean v0 = (arg7 & 3) != 2 ? true : false;
        if(arg6.shouldExecute(v0, arg7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-59194059, arg7, -1, "androidx.compose.runtime.GapComposer.invokeMovableContentLambda.<anonymous> (GapComposer.kt:2265)");
            }

            arg4.getContent().invoke(arg5, arg6, Integer.valueOf(0));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_26;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_26:
        return Unit.INSTANCE;
    }

    static final ComposeStackTrace invokeMovableContentLambda$lambda$1(GapComposer arg0) {
        return arg0.currentStackTrace();
    }

    public boolean isComposing$runtime() {
        return this.isComposing;
    }

    public final boolean isDisposed$runtime() {
        return this.isDisposed;
    }

    @ComposeCompilerApi public Object joinKey(Object arg1, Object arg2) {
        JoinedKey v0_1;
        Object v0 = GapComposerKt.access$getKey(this.reader.getGroupObjectKey(), arg1, arg2);
        if(v0 == null) {
            v0_1 = new JoinedKey(arg1, arg2);
        }

        return v0_1;
    }

    public final Object nextSlot() {
        if(this.getInserting()) {
            this.validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }

        Object v0 = this.reader.next();
        if((this.reusing) && !(v0 instanceof ReusableRememberObserverHolder)) {
            return Composer.Companion.getEmpty();
        }

        return v0;
    }

    public final Object nextSlotForCache() {
        if(this.getInserting()) {
            this.validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }

        Object v0 = this.reader.next();
        if((this.reusing) && !(v0 instanceof ReusableRememberObserverHolder)) {
            return Composer.Companion.getEmpty();
        }

        if((v0 instanceof RememberObserverHolder)) {
            return ((RememberObserverHolder)v0).getWrapped();
        }

        return v0;
    }

    private final Object nodeAt(SlotReader arg1, int arg2) {
        return arg1.node(arg2);
    }

    private final int nodeIndexOf(int arg3, int arg4, int arg5, int arg6) {
        int v0;
        for(v0 = this.reader.parent(arg4); v0 != arg5; v0 = this.reader.parent(v0)) {
            if(this.reader.isNode(v0)) {
                break;
            }
        }

        if(this.reader.isNode(v0)) {
            arg6 = 0;
        }

        if(v0 == arg4) {
            return 0;
        }

        arg5 = this.updatedNodeCount(v0) - this.reader.nodeCount(arg4);
        do {
        label_20:
            if(arg6 < arg5 && v0 != arg3) {
                ++v0;
                while(true) {
                label_23:
                    if(v0 < arg3) {
                        arg4 = this.reader.groupSize(v0) + v0;
                        if(arg3 < arg4) {
                            goto label_20;
                        }

                        goto label_28;
                    }

                    return arg6;
                }
            }

            return arg6;
        }
        while(true);

    label_28:
        v0 = this.reader.isNode(v0) ? 1 : this.updatedNodeCount(v0);
        arg6 += v0;
        v0 = arg4;
        goto label_23;
        return arg6;
    }

    public int parentKey$runtime() {
        if(this.getInserting()) {
            return this.writer.groupKey(this.writer.getParent());
        }

        return this.reader.groupKey(this.reader.getParent());
    }

    public List parentStackTrace$runtime() {
        List v3_2;
        Composition v0 = this.parentContext.getComposition$runtime();
        if((v0 instanceof CompositionImpl)) {
        }
        else {
            v0 = null;
        }

        if(v0 == null) {
            return CollectionsKt.emptyList();
        }

        Integer v3 = ComposeStackTraceBuilderKt.findSubcompositionContextGroup(SlotTableKt.asGapBufferSlotTable(((CompositionImpl)v0).getSlotStorage$runtime()), this.parentContext);
        if(v3 != null) {
            SlotReader v1 = SlotTableKt.asGapBufferSlotTable(((CompositionImpl)v0).getSlotStorage$runtime()).openReader();
            try {
                v3_2 = ComposeStackTraceBuilderKt.traceForGroup(v1, v3.intValue(), Integer.valueOf(0));
            }
            catch(Throwable v3_1) {
                v1.close();
                throw v3_1;
            }

            v1.close();
            return CollectionsKt.plus(((Collection)v3_2), ((CompositionImpl)v0).getComposer$runtime().parentStackTrace$runtime());
        }

        return CollectionsKt.emptyList();
    }

    public void prepareCompose$runtime(Function0 arg2) {
        if(this.isComposing$runtime()) {
            ComposerKt.composeImmediateRuntimeError("Preparing a composition while composing is not supported");
        }

        this.isComposing = true;
        try {
            arg2.invoke();
        }
        catch(Throwable v2) {
            this.isComposing = false;
            throw v2;
        }

        this.isComposing = false;
    }

    private final int rGroupIndexOf(int arg4) {
        int v0 = this.reader.parent(arg4) + 1;
        int v1 = 0;
        while(v0 < arg4) {
            if(!this.reader.hasObjectKey(v0)) {
                ++v1;
            }

            v0 += this.reader.groupSize(v0);
        }

        return v1;
    }

    public boolean recompose-aFTiNEg$runtime(MutableScatterMap arg2, ShouldPauseCallback arg3) {
        if(!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }

        if(ScopeMap.getSize-impl(arg2) <= 0 && (this.invalidations.isEmpty())) {
            if(this.forciblyRecompose) {
            }
            else {
                return 0;
            }
        }

        this.shouldPauseCallback = arg3;
        Function2 v3 = null;
        try {
            this.doCompose-aFTiNEg(arg2, v3);
        }
        catch(Throwable v2) {
            this.shouldPauseCallback = ((ShouldPauseCallback)v3);
            throw v2;
        }

        this.shouldPauseCallback = ((ShouldPauseCallback)v3);
        return this.changes.isNotEmpty();
    }

    private final Object recomposeMovableContent(ControlledComposition arg7, ControlledComposition arg8, Integer arg9, List arg10, Function0 arg11) {
        Object v7_1;
        boolean v0 = this.isComposing$runtime();
        int v1 = this.nodeIndex;
        try {
            this.isComposing = true;
            int v2 = 0;
            this.nodeIndex = 0;
            int v3 = arg10.size();
            while(v2 < v3) {
                Object v4 = arg10.get(v2);
                Object v5 = ((Pair)v4).component1();
                v4 = ((Pair)v4).component2();
                if(v4 != null) {
                    this.tryImminentInvalidation$runtime(((RecomposeScopeImpl)v5), v4);
                }
                else {
                    this.tryImminentInvalidation$runtime(((RecomposeScopeImpl)v5), null);
                }

                ++v2;
            }

            if(arg7 != null) {
                int v9 = arg9 != null ? arg9.intValue() : -1;
                v7_1 = arg7.delegateInvalidations(arg8, v9, arg11);
                if(v7_1 != null) {
                    goto label_27;
                }

                goto label_26;
            }
            else {
            label_26:
                v7_1 = arg11.invoke();
            }
        }
        catch(Throwable v7) {
            goto label_31;
        }

    label_27:
        this.isComposing = v0;
        this.nodeIndex = v1;
        return v7_1;
    label_31:
        this.isComposing = v0;
        this.nodeIndex = v1;
        throw v7;
    }

    static Object recomposeMovableContent$default(GapComposer arg1, ControlledComposition arg2, ControlledComposition arg3, Integer arg4, List arg5, Function0 arg6, int arg7, Object arg8) {
        ControlledComposition v0 = null;
        if((arg7 & 1) != 0) {
            arg2 = v0;
        }

        if((arg7 & 2) != 0) {
            arg3 = v0;
        }

        if((arg7 & 4) != 0) {
            arg4 = ((Integer)v0);
        }

        if((arg7 & 8) != 0) {
            arg5 = CollectionsKt.emptyList();
        }

        return arg1.recomposeMovableContent(arg2, arg3, arg4, arg5, arg6);
    }

    private final void recomposeToGroupEnd() {
        boolean v0 = this.isComposing$runtime();
        this.isComposing = true;
        int v2 = this.reader.getParent();
        int v3 = this.reader.groupSize(v2) + v2;
        int v4 = this.nodeIndex;
        long v5 = this.getCompositeKeyHashCode();
        int v7 = this.groupNodeCount;
        int v8 = this.rGroupIndex;
        Invalidation v9 = GapComposerKt.access$firstInRange(this.invalidations, this.reader.getCurrentGroup(), v3);
        int v10 = 0;
        int v11 = v2;
        while(v9 != null) {
            int v12 = v9.getLocation();
            RecomposeScopeImpl v13 = v9.getScope();
            GapComposerKt.access$removeLocation(this.invalidations, v12);
            if(v9.isInvalid()) {
                this.reader.reposition(v12);
                int v9_1 = this.reader.getCurrentGroup();
                this.recordUpsAndDowns(v11, v9_1, v2);
                this.nodeIndex = this.nodeIndexOf(v12, v9_1, v2, v4);
                this.rGroupIndex = this.rGroupIndexOf(v9_1);
                this.compositeKeyHashCode = this.compositeKeyOf(this.reader.parent(v9_1), v2, v5);
                this.providerCache = null;
                v13.compose(this);
                this.providerCache = null;
                this.reader.restoreParent(v2);
                v10 = 1;
                v11 = v9_1;
            }
            else {
                Stack.push-impl(this.invalidateStack, v13);
                CompositionObserver v9_2 = this.observerHolder.current();
                if(v9_2 != null) {
                    try {
                        v9_2.onScopeEnter(v13);
                        v13.rereadTrackedInstances();
                    }
                    catch(Throwable v15) {
                        v9_2.onScopeExit(((RecomposeScope)v13));
                        throw v15;
                    }

                    v9_2.onScopeExit(((RecomposeScope)v13));
                }
                else {
                    v13.rereadTrackedInstances();
                }

                Stack.pop-impl(this.invalidateStack);
            }

            v9 = GapComposerKt.access$firstInRange(this.invalidations, this.reader.getCurrentGroup(), v3);
        }

        if(v10 != 0) {
            this.recordUpsAndDowns(v11, v2, v2);
            this.reader.skipToGroupEnd();
            int v1 = this.updatedNodeCount(v2);
            this.nodeIndex = v4 + v1;
            this.groupNodeCount = v7 + v1;
            this.rGroupIndex = v8;
        }
        else {
            this.skipReaderToGroupEnd();
        }

        this.compositeKeyHashCode = v5;
        this.isComposing = v0;
    }

    private final void recordDelete() {
        this.reportFreeMovableContent(this.reader.getCurrentGroup());
        this.changeListWriter.removeCurrentGroup();
    }

    private final void recordInsert(GapAnchor arg4) {
        boolean v0 = this.insertFixups.isEmpty();
        ComposerChangeListWriter v1 = this.changeListWriter;
        if(v0) {
            v1.insertSlots(arg4, this.insertTable);
            return;
        }

        v1.insertSlots(arg4, this.insertTable, this.insertFixups);
        this.insertFixups = new FixupList();
    }

    private final void recordProviderUpdate(PersistentCompositionLocalMap arg5) {
        MutableIntObjectMap v0 = this.providerUpdates;
        if(v0 == null) {
            v0 = new MutableIntObjectMap(0, 1, null);
            this.providerUpdates = v0;
        }

        v0.set(this.reader.getCurrentGroup(), arg5);
    }

    public void recordSideEffect(Function0 arg1) {
        this.changeListWriter.sideEffect(arg1);
    }

    private final void recordUpsAndDowns(int arg3, int arg4, int arg5) {
        SlotReader v0 = this.reader;
        arg5 = GapComposerKt.access$nearestCommonRootOf(v0, arg3, arg4, arg5);
        while(arg3 > 0) {
            if(arg3 == arg5) {
                break;
            }

            if(v0.isNode(arg3)) {
                this.changeListWriter.moveUp();
            }

            arg3 = v0.parent(arg3);
        }

        this.doRecordDownsFor(arg4, arg5);
    }

    public void recordUsed(RecomposeScope arg1) {
        RecomposeScopeImpl v1;
        if((arg1 instanceof RecomposeScopeImpl)) {
        }
        else {
            v1 = null;
        }

        if(0 != 0) {
            v1.setUsed(true);
        }
    }

    private final int rememberObserverGroupIndex() {
        return this.rGroupIndex - 1;
    }

    public Object rememberedValue() {
        return this.nextSlotForCache();
    }

    private final void reportAllMovableContent() {
        ChangeList v3;
        ComposerChangeListWriter v2;
        if(this.slotTable.containsMark()) {
            this.getComposition().updateMovingInvalidations$runtime();
            ChangeList v0 = new ChangeList();
            this.setDeferredChanges$runtime(v0);
            SlotReader v1 = this.slotTable.openReader();
            try {
                this.reader = v1;
                v2 = this.changeListWriter;
                v3 = v2.getChangeList();
            }
            catch(Throwable v4) {
                goto label_26;
            }

            try {
                v2.setChangeList(v0);
                this.reportFreeMovableContent(0);
                this.changeListWriter.releaseMovableContent();
                goto label_18;
            }
            catch(Throwable v4) {
                try {
                    v2.setChangeList(v3);
                    throw v4;
                label_18:
                    v2.setChangeList(v3);
                }
                catch(Throwable v4) {
                label_26:
                    v1.close();
                    throw v4;
                }
            }

            v1.close();
            return;
        }
    }

    private final void reportFreeMovableContent(int arg4) {
        boolean v0 = this.reader.isNode(arg4);
        if(v0) {
            this.changeListWriter.endNodeMovement();
            this.changeListWriter.moveDown(this.reader.node(arg4));
        }

        GapComposer.reportFreeMovableContent$reportGroup(this, arg4, arg4, v0, 0);
        this.changeListWriter.endNodeMovement();
        if(v0) {
            this.changeListWriter.moveUp();
        }
    }

    private static final MovableContentStateReference reportFreeMovableContent$createMovableContentReferenceForGroup(GapComposer arg11, int arg12, List arg13) {
        Object v0 = arg11.reader.groupObjectKey(arg12);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        Object v3 = v0;
        Object v4 = arg11.reader.groupGet(arg12, 0);
        GapAnchor v0_1 = arg11.reader.anchor(arg12);
        int v1 = arg11.reader.groupSize(arg12) + arg12;
        ArrayList v8 = new ArrayList();
        List v2 = arg11.invalidations;
        int v5;
        for(v5 = GapComposerKt.access$findInsertLocation(v2, arg12); v5 < v2.size(); ++v5) {
            Object v6 = v2.get(v5);
            if(((Invalidation)v6).getLocation() >= v1) {
                break;
            }

            v8.add(TuplesKt.to(((Invalidation)v6).getScope(), ((Invalidation)v6).getInstances()));
        }

        return new MovableContentStateReference(((MovableContent)v3), v4, arg11.getComposition(), arg11.slotTable, v0_1, ((List)v8), arg11.currentCompositionLocalScope(arg12), arg13);
    }

    private static final MovableContentStateReference reportFreeMovableContent$movableContentReferenceFor(GapComposer arg4, int arg5) {
        int v0 = arg4.reader.groupKey(arg5);
        Object v1 = arg4.reader.groupObjectKey(arg5);
        List v3 = null;
        if(v0 == 0x78CC281 && ((v1 instanceof MovableContent))) {
            if(arg4.reader.containsMark(arg5)) {
                ArrayList v0_1 = new ArrayList();
                GapComposer.reportFreeMovableContent$movableContentReferenceFor$traverseGroups(arg4, ((List)v0_1), arg5);
                if(!v0_1.isEmpty()) {
                    ArrayList v3_1 = v0_1;
                }
            }

            return GapComposer.reportFreeMovableContent$createMovableContentReferenceForGroup(arg4, arg5, v3);
        }

        return ((MovableContentStateReference)v3);
    }

    private static final void reportFreeMovableContent$movableContentReferenceFor$traverseGroups(GapComposer arg2, List arg3, int arg4) {
        int v0 = arg2.reader.groupSize(arg4) + arg4;
        ++arg4;
        while(arg4 < v0) {
            if(arg2.reader.hasMark(arg4)) {
                MovableContentStateReference v1 = GapComposer.reportFreeMovableContent$movableContentReferenceFor(arg2, arg4);
                if(v1 != null) {
                    arg3.add(v1);
                }
            }
            else if(arg2.reader.containsMark(arg4)) {
                GapComposer.reportFreeMovableContent$movableContentReferenceFor$traverseGroups(arg2, arg3, arg4);
            }

            arg4 += arg2.reader.groupSize(arg4);
        }
    }

    private static final int reportFreeMovableContent$reportGroup(GapComposer arg17, int arg18, int arg19, boolean arg20, int arg21) {
        int v5;
        GapComposer v0 = arg17;
        int v1 = arg18;
        int v2 = arg19;
        int v3 = arg21;
        SlotReader v4 = v0.reader;
        if(v4.hasMark(v2)) {
            v5 = v4.groupKey(v2);
            Object v8 = v4.groupObjectKey(v2);
            if(v5 == 0x78CC281 && ((v8 instanceof MovableContent))) {
                MovableContentStateReference v5_1 = GapComposer.reportFreeMovableContent$movableContentReferenceFor(v0, v2);
                if(v5_1 != null) {
                    v0.parentContext.deletedMovableContent$runtime(v5_1);
                    v0.changeListWriter.recordSlotEditing();
                    v0.changeListWriter.releaseMovableGroupAtCurrent(v0.getComposition(), v0.parentContext, v5_1);
                }

                if((arg20) && v2 != v1) {
                    v0.changeListWriter.endNodeMovementAndDeleteNode(v3, v2);
                    return 0;
                }

                return v4.nodeCount(v2);
            }

            if(v5 == 206 && (Intrinsics.areEqual(v8, ComposerKt.getReference()))) {
                Object v1_1 = v4.groupGet(v2, 0);
                RememberObserver v5_2 = null;
                if((v1_1 instanceof RememberObserverHolder)) {
                }
                else {
                    v1_1 = v5_2;
                }

                RememberObserver v1_2 = v1_1 != null ? ((RememberObserverHolder)v1_1).getWrapped() : v5_2;
                if((v1_2 instanceof CompositionContextHolder)) {
                    v5_2 = v1_2;
                }

                if(v5_2 != null) {
                    MutableScatterSet v1_3 = ((CompositionContextHolder)v5_2).getRef().getComposers();
                    Object[] v3_1 = ((ScatterSet)v1_3).elements;
                    long[] v1_4 = ((ScatterSet)v1_3).metadata;
                    v5 = v1_4.length - 2;
                    if(v5 >= 0) {
                        int v7;
                        for(v7 = 0; true; ++v7) {
                            long v8_1 = v1_4[v7];
                            if((~v8_1 << 7 & v8_1 & -9187201950435737472L) != -9187201950435737472L) {
                                int v11 = 8;
                                int v10 = 8 - (~(v7 - v5) >>> 0x1F);
                                int v12;
                                for(v12 = 0; v12 < v10; ++v12) {
                                    if((0xFF & v8_1) < 0x80) {
                                        Object v13 = v3_1[(v7 << 3) + v12];
                                        ((GapComposer)v13).reportAllMovableContent();
                                        v0.parentContext.reportRemovedComposition$runtime(((GapComposer)v13).getComposition());
                                    }

                                    v8_1 >>= v11;
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

                return v4.nodeCount(v2);
            }

            if(v4.isNode(v2)) {
                return 1;
            }

            return v4.nodeCount(v2);
        }

        if(v4.containsMark(v2)) {
            v5 = v4.groupSize(v2) + v2;
            int v8_2 = v2 + 1;
            int v9 = 0;
            while(v8_2 < v5) {
                boolean v10_1 = v4.isNode(v8_2);
                if(v10_1) {
                    v0.changeListWriter.endNodeMovement();
                    v0.changeListWriter.moveDown(v4.node(v8_2));
                }

                boolean v11_1 = (v10_1) || (arg20) ? true : false;
                v12 = v10_1 ? 0 : v3 + v9;
                v9 += GapComposer.reportFreeMovableContent$reportGroup(v0, v1, v8_2, v11_1, v12);
                if(v10_1) {
                    v0.changeListWriter.endNodeMovement();
                    v0.changeListWriter.moveUp();
                }

                v8_2 += v4.groupSize(v8_2);
            }

            if(v4.isNode(v2)) {
                return 1;
            }

            return v9;
        }

        if(v4.isNode(v2)) {
            return 1;
        }

        return v4.nodeCount(v2);
    }

    public CancellationHandle scheduleFrameEndCallback(Function0 arg1) {
        return this.parentContext.scheduleFrameEndCallback(arg1);
    }

    public void setDeferredChanges$runtime(ChangeList arg1) {
        this.deferredChanges = arg1;
    }

    public final void setInsertTable$runtime(SlotTable arg1) {
        this.insertTable = arg1;
    }

    public final void setReader$runtime(SlotReader arg1) {
        this.reader = arg1;
    }

    public void setSourceMarkersEnabled$runtime(boolean arg1) {
        this.sourceMarkersEnabled = arg1;
    }

    @ComposeCompilerApi public boolean shouldExecute(boolean arg3, int arg4) {
        if((arg4 & 1) == 0 && ((this.getInserting()) || (this.reusing))) {
            ShouldPauseCallback v3 = this.shouldPauseCallback;
            if(v3 == null) {
                return 1;
            }

            RecomposeScopeImpl v4 = this.getCurrentRecomposeScope$runtime();
            if(v4 == null) {
                return 1;
            }

            if((v3.shouldPause()) && !v4.getResuming()) {
                v4.setUsed(true);
                v4.setReusing(this.reusing);
                v4.setPaused(true);
                this.changeListWriter.rememberPausingScope(v4);
                this.parentContext.reportPausedScope$runtime(v4);
                return 0;
            }

            return 1;
        }

        if(!arg3) {
            if(!this.getSkipping()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    @ComposeCompilerApi public void skipCurrentGroup() {
        long v7;
        if(this.invalidations.isEmpty()) {
            this.skipGroup();
            return;
        }

        SlotReader v0 = this.reader;
        int v1 = v0.getGroupKey();
        Object v2 = v0.getGroupObjectKey();
        Object v3 = v0.getGroupAux();
        int v4 = this.rGroupIndex;
        int v5 = 0xCF;
        int v6 = 3;
        if(v2 == null) {
            if(v3 != null && v1 == v5 && !Intrinsics.areEqual(v3, Composer.Companion.getEmpty())) {
                this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), v6) ^ (((long)v3.hashCode())), v6) ^ (((long)v4));
                goto label_49;
            }

            v7 = Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), v6) ^ (((long)v1)), v6) ^ (((long)v4));
            goto label_48;
        }
        else {
            int v7_1 = (v2 instanceof Enum) ? v2.ordinal() : v2.hashCode();
            v7 = Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), v6) ^ (((long)v7_1)), v6);
        label_48:
            this.compositeKeyHashCode = v7;
        }

    label_49:
        this.startReaderGroup(v0.isNode(), null);
        this.recomposeToGroupEnd();
        v0.endGroup();
        if(v2 == null) {
            if(v3 != null && v1 == v5 && !Intrinsics.areEqual(v3, Composer.Companion.getEmpty())) {
                this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.getCompositeKeyHashCode() ^ (((long)v4)), v6) ^ (((long)v3.hashCode())), v6);
                return;
            }

            this.compositeKeyHashCode = Long.rotateRight((((long)v1)) ^ Long.rotateRight(this.getCompositeKeyHashCode() ^ (((long)v4)), v6), v6);
            return;
        }

        if((v2 instanceof Enum)) {
            this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.getCompositeKeyHashCode(), v6) ^ (((long)((Enum)v2).ordinal())), v6);
            return;
        }

        this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.getCompositeKeyHashCode(), v6) ^ (((long)v2.hashCode())), v6);
    }

    private final void skipGroup() {
        this.groupNodeCount += this.reader.skipGroup();
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    @ComposeCompilerApi public void skipToGroupEnd() {
        int v0 = this.groupNodeCount == 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling skipAndEndGroup");
        }

        if(!this.getInserting()) {
            RecomposeScopeImpl v0_1 = this.getCurrentRecomposeScope$runtime();
            if(v0_1 != null) {
                v0_1.scopeSkipped();
            }

            if(this.invalidations.isEmpty()) {
                this.skipReaderToGroupEnd();
                return;
            }

            this.recomposeToGroupEnd();
        }
    }

    @ComposeCompilerApi public void sourceInformation(String arg2) {
        if((this.getInserting()) && (this.getSourceMarkersEnabled$runtime())) {
            this.writer.recordGroupSourceInformation(arg2);
        }
    }

    @ComposeCompilerApi public void sourceInformationMarkerEnd() {
        if((this.getInserting()) && (this.getSourceMarkersEnabled$runtime())) {
            this.writer.recordGrouplessCallSourceInformationEnd();
        }
    }

    @ComposeCompilerApi public void sourceInformationMarkerStart(int arg2, String arg3) {
        if((this.getInserting()) && (this.getSourceMarkersEnabled$runtime())) {
            this.writer.recordGrouplessCallSourceInformationStart(arg2, arg3);
        }
    }

    private final List stackTraceForGroup(int arg1, Integer arg2) {
        List v1_1;
        SlotReader v0 = this.slotTable.openReader();
        try {
            v1_1 = ComposeStackTraceBuilderKt.traceForGroup(v0, arg1, arg2);
        }
        catch(Throwable v1) {
            v0.close();
            throw v1;
        }

        v0.close();
        return v1_1;
    }

    static final boolean stackTraceForValue$lambda$0(Object arg2, Object arg3) {
        if(arg3 != arg2) {
            Object v1 = null;
            if((arg3 instanceof RememberObserverHolder)) {
            }
            else {
                arg3 = v1;
            }

            if(arg3 != null) {
                RememberObserver v1_1 = ((RememberObserverHolder)arg3).getWrapped();
            }

            if(v1_1 == arg2) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    public ComposeStackTrace stackTraceForValue$runtime(Object arg3) {
        List v3_1;
        ObjectLocation v3 = ComposeStackTraceBuilderKt.findLocation(this.slotTable, new GapComposer$$ExternalSyntheticLambda0(arg3));
        if(v3 != null) {
            v3_1 = CollectionsKt.plus(this.stackTraceForGroup(v3.component1(), v3.component2()), this.parentStackTrace$runtime());
            if(v3_1 != null) {
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v3_1 = CollectionsKt.emptyList();
        }

        return new ComposeStackTrace(v3_1, this.getSourceMarkersEnabled$runtime());
    }

    public int stacksSize$runtime() {
        return this.entersStack.tos + Stack.getSize-impl(this.invalidateStack) + this.providersInvalidStack.tos + Stack.getSize-impl(this.pendingStack) + this.parentStateStack.tos;
    }

    private final void start-AzEfcrM(int arg13, Object arg14, int arg15, Object arg16) {
        KeyInfo v0_1;
        SlotWriter v4_2;
        long v4_1;
        Object v0 = arg14;
        int v2 = arg15;
        Object v3 = arg16;
        this.validateNodeNotExpected();
        int v4 = this.rGroupIndex;
        int v5 = 3;
        if(v0 == null) {
            if(v3 != null && arg13 == 0xCF && !Intrinsics.areEqual(v3, Composer.Companion.getEmpty())) {
                this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), v5) ^ (((long)v3.hashCode())), v5) ^ (((long)v4));
                goto label_44;
            }

            v4_1 = Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), v5) ^ (((long)arg13)), v5) ^ (((long)v4));
            goto label_43;
        }
        else {
            v4 = (v0 instanceof Enum) ? v0.ordinal() : arg14.hashCode();
            v4_1 = Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), v5) ^ (((long)v4)), v5);
        label_43:
            this.compositeKeyHashCode = v4_1;
        }

    label_44:
        if(v0 == null) {
            ++this.rGroupIndex;
        }

        int v6 = 0;
        boolean v7 = v2 != GroupKind.Companion.getGroup-9udXigM() ? true : false;
        int v8 = -1;
        GapPending v9 = null;
        if(this.getInserting()) {
            this.reader.beginEmpty();
            v2 = this.writer.getCurrentGroup();
            if(v7) {
                this.writer.startNode(arg13, Composer.Companion.getEmpty());
            }
            else {
                v4_2 = this.writer;
                if(v3 != null) {
                    if(v0 == null) {
                        v0 = Composer.Companion.getEmpty();
                    }

                    v4_2.startData(arg13, v0, v3);
                }
                else {
                    if(v0 == null) {
                        v0 = Composer.Companion.getEmpty();
                    }

                    v4_2.startGroup(arg13, v0);
                }
            }

            GapPending v6_1 = this.pending;
            if(v6_1 != null) {
                v0_1 = new KeyInfo(arg13, Integer.valueOf(v8), this.insertedGroupVirtualIndex(v2), -1, 0);
                v6_1.registerInsert(v0_1, this.nodeIndex - v6_1.getStartIndex());
                v6_1.recordUsed(v0_1);
            }

            this.enterGroup(v7, v9);
            return;
        }

        if(v2 != GroupKind.Companion.getNode-9udXigM()) {
            goto label_108;
        }
        else if(this.reusing) {
            v2 = 1;
        }
        else {
        label_108:
            v2 = 0;
        }

        if(this.pending == null) {
            v5 = this.reader.getGroupKey();
            if(v2 == 0 && v5 == arg13 && (Intrinsics.areEqual(arg14, this.reader.getGroupObjectKey()))) {
                this.startReaderGroup(v7, v3);
                goto label_127;
            }

            this.pending = new GapPending(this.reader.extractKeys(), this.nodeIndex);
        }

    label_127:
        GapPending v10 = this.pending;
        if(v10 != null) {
            KeyInfo v5_1 = v10.getNext(arg13, arg14);
            if(v2 == 0 && v5_1 != null) {
                v10.recordUsed(v5_1);
                int v0_2 = v5_1.getLocation();
                this.nodeIndex = v10.nodePositionOf(v5_1) + v10.getStartIndex();
                int v1 = v10.slotPositionOf(v5_1);
                v2 = v1 - v10.getGroupIndex();
                v10.registerMoveSlot(v1, v10.getGroupIndex());
                this.changeListWriter.moveReaderRelativeTo(v0_2);
                this.reader.reposition(v0_2);
                if(v2 > 0) {
                    this.changeListWriter.moveCurrentGroup(v2);
                }

                this.startReaderGroup(v7, v3);
                goto label_203;
            }

            this.reader.beginEmpty();
            this.inserting = true;
            this.providerCache = ((PersistentCompositionLocalMap)v9);
            this.ensureWriter();
            this.writer.beginInsert();
            v2 = this.writer.getCurrentGroup();
            if(v7) {
                this.writer.startNode(arg13, Composer.Companion.getEmpty());
            }
            else {
                v4_2 = this.writer;
                if(v3 != null) {
                    if(v0 == null) {
                        v0 = Composer.Companion.getEmpty();
                    }

                    v4_2.startData(arg13, v0, v3);
                }
                else {
                    if(v0 == null) {
                        v0 = Composer.Companion.getEmpty();
                    }

                    v4_2.startGroup(arg13, v0);
                }
            }

            this.insertAnchor = this.writer.anchor(v2);
            v0_1 = new KeyInfo(arg13, Integer.valueOf(v8), this.insertedGroupVirtualIndex(v2), -1, 0);
            v10.registerInsert(v0_1, this.nodeIndex - v10.getStartIndex());
            v10.recordUsed(v0_1);
            ArrayList v0_3 = new ArrayList();
            if(v7) {
            }
            else {
                v6 = this.nodeIndex;
            }

            v9 = new GapPending(((List)v0_3), v6);
        }

    label_203:
        this.enterGroup(v7, v9);
    }

    @ComposeCompilerApi public void startDefaults() {
        this.start-AzEfcrM(0xFFFFFF81, null, GroupKind.Companion.getGroup-9udXigM(), null);
    }

    private final void startGroup(int arg3, Object arg4) {
        this.start-AzEfcrM(arg3, arg4, GroupKind.Companion.getGroup-9udXigM(), null);
    }

    private final void startGroup(int arg3) {
        this.start-AzEfcrM(arg3, null, GroupKind.Companion.getGroup-9udXigM(), null);
    }

    @ComposeCompilerApi public void startMovableGroup(int arg3, Object arg4) {
        this.start-AzEfcrM(arg3, arg4, GroupKind.Companion.getGroup-9udXigM(), null);
    }

    public void startNode() {
        this.start-AzEfcrM(0x7D, null, GroupKind.Companion.getNode-9udXigM(), null);
        this.nodeExpected = true;
    }

    public void startProvider(ProvidedValue arg9) {
        ValueHolder v1_1;
        PersistentCompositionLocalMap v0 = this.currentCompositionLocalScope();
        this.startGroup(201, ComposerKt.getProvider());
        Object v1 = this.rememberedValue();
        if(Intrinsics.areEqual(v1, Composer.Companion.getEmpty())) {
            v1_1 = null;
        }
        else {
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
        }

        CompositionLocal v2 = arg9.getCompositionLocal();
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        Intrinsics.checkNotNull(arg9, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
        ValueHolder v3 = v2.updatedStateOf$runtime(arg9, v1_1);
        boolean v1_2 = Intrinsics.areEqual(v3, v1_1);
        if(!v1_2) {
            this.updateRememberedValue(v3);
        }

        boolean v5 = true;
        boolean v6 = false;
        if(this.getInserting()) {
            if((arg9.getCanOverride()) || !CompositionLocalMapKt.contains(v0, v2)) {
                v0 = v0.putValue(v2, v3);
            }

            this.writerHasAProvider = true;
        }
        else {
            Object v4 = this.reader.groupAux(this.reader.getCurrentGroup());
            Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            if(!this.getSkipping() || !v1_2) {
                if(!arg9.getCanOverride()) {
                    if(!CompositionLocalMapKt.contains(v0, v2)) {
                    }
                    else {
                    label_46:
                        if((v1_2) && !this.providersInvalid) {
                        }
                        else if(this.providersInvalid) {
                            goto label_56;
                        }

                        Object v0_1 = v4;
                        goto label_56;
                    }
                }

                v0 = v0.putValue(v2, v3);
            }
            else {
                goto label_46;
            }

        label_56:
            if(!this.reusing) {
                if((((PersistentCompositionLocalMap)v4)) != v0) {
                }
                else {
                    v5 = false;
                }
            }

            v6 = v5;
        }

        if((v6) && !this.getInserting()) {
            this.recordProviderUpdate(v0);
        }

        this.providersInvalidStack.push(GapComposerKt.access$asInt(this.providersInvalid));
        this.providersInvalid = v6;
        this.providerCache = v0;
        this.start-AzEfcrM(202, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.getGroup-9udXigM(), v0);
    }

    public void startProviders(ProvidedValue[] arg7) {
        PersistentCompositionLocalMap v7;
        PersistentCompositionLocalMap v0 = this.currentCompositionLocalScope();
        this.startGroup(201, ComposerKt.getProvider());
        boolean v2 = true;
        boolean v3 = false;
        if(this.getInserting()) {
            v7 = this.updateProviderMapGroup(v0, CompositionLocalMapKt.updateCompositionMap$default(arg7, v0, null, 4, null));
            this.writerHasAProvider = true;
        }
        else {
            Object v1 = this.reader.groupGet(0);
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            Object v5 = this.reader.groupGet(1);
            Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            v7 = CompositionLocalMapKt.updateCompositionMap(arg7, v0, ((PersistentCompositionLocalMap)v5));
            if((this.getSkipping()) && !this.reusing) {
                if(!Intrinsics.areEqual(v5, v7)) {
                }
                else {
                    this.skipGroup();
                    Object v7_1 = v1;
                    goto label_40;
                }
            }

            v7 = this.updateProviderMapGroup(v0, v7);
            if(!this.reusing) {
                if(!Intrinsics.areEqual(v7, v1)) {
                }
                else {
                    v2 = false;
                }
            }

            v3 = v2;
        }

    label_40:
        if((v3) && !this.getInserting()) {
            this.recordProviderUpdate(v7);
        }

        this.providersInvalidStack.push(GapComposerKt.access$asInt(this.providersInvalid));
        this.providersInvalid = v3;
        this.providerCache = v7;
        this.start-AzEfcrM(202, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.getGroup-9udXigM(), v7);
    }

    private final void startReaderGroup(boolean arg1, Object arg2) {
        if(arg1) {
            this.reader.startNode();
            return;
        }

        if(arg2 != null && this.reader.getGroupAux() != arg2) {
            this.changeListWriter.updateAuxData(arg2);
        }

        this.reader.startGroup();
    }

    @ComposeCompilerApi public void startReplaceGroup(int arg9) {
        Object v1 = null;
        if(this.pending != null) {
            this.start-AzEfcrM(arg9, v1, GroupKind.Companion.getGroup-9udXigM(), v1);
            return;
        }

        this.validateNodeNotExpected();
        this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), 3) ^ (((long)arg9)), 3) ^ (((long)this.rGroupIndex));
        ++this.rGroupIndex;
        SlotReader v0 = this.reader;
        if(this.getInserting()) {
            v0.beginEmpty();
            this.writer.startGroup(arg9, Composer.Companion.getEmpty());
            this.enterGroup(false, ((GapPending)v1));
            return;
        }

        if(v0.getGroupKey() == arg9 && !v0.getHasObjectKey()) {
            v0.startGroup();
            this.enterGroup(false, ((GapPending)v1));
            return;
        }

        if(!v0.isGroupEnd()) {
            int v3 = this.nodeIndex;
            int v5 = v0.getCurrentGroup();
            this.recordDelete();
            this.changeListWriter.removeNode(v3, v0.skipGroup());
            GapComposerKt.access$removeRange(this.invalidations, v5, v0.getCurrentGroup());
        }

        v0.beginEmpty();
        this.inserting = true;
        this.providerCache = ((PersistentCompositionLocalMap)v1);
        this.ensureWriter();
        SlotWriter v0_1 = this.writer;
        v0_1.beginInsert();
        int v2 = v0_1.getCurrentGroup();
        v0_1.startGroup(arg9, Composer.Companion.getEmpty());
        this.insertAnchor = v0_1.anchor(v2);
        this.enterGroup(false, ((GapPending)v1));
    }

    @ComposeCompilerApi public void startReplaceableGroup(int arg3) {
        this.start-AzEfcrM(arg3, null, GroupKind.Companion.getGroup-9udXigM(), null);
    }

    @ComposeCompilerApi public Composer startRestartGroup(int arg1) {
        this.startReplaceGroup(arg1);
        this.addRecomposeScope();
        return this;
    }

    public void startReusableGroup(int arg3, Object arg4) {
        if(!this.getInserting() && this.reader.getGroupKey() == arg3 && !Intrinsics.areEqual(this.reader.getGroupAux(), arg4) && this.reusingGroup < 0) {
            this.reusingGroup = this.reader.getCurrentGroup();
            this.reusing = true;
        }

        this.start-AzEfcrM(arg3, null, GroupKind.Companion.getGroup-9udXigM(), arg4);
    }

    public void startReusableNode() {
        this.start-AzEfcrM(0x7D, null, GroupKind.Companion.getReusableNode-9udXigM(), null);
        this.nodeExpected = true;
    }

    public void startReuseFromRoot$runtime() {
        this.reusingGroup = 0;
        this.reusing = true;
    }

    private final void startRoot() {
        this.rGroupIndex = 0;
        this.reader = this.slotTable.openReader();
        this.startGroup(100);
        this.parentContext.startComposing$runtime();
        PersistentCompositionLocalMap v0 = this.parentContext.getCompositionLocalScope$runtime();
        this.providersInvalidStack.push(GapComposerKt.access$asInt(this.providersInvalid));
        this.providersInvalid = this.changed(v0);
        this.providerCache = null;
        if(!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation$runtime();
        }

        if(!this.getSourceMarkersEnabled$runtime()) {
            this.setSourceMarkersEnabled$runtime(this.parentContext.getCollectingSourceInformation$runtime());
        }

        if(this.getSourceMarkersEnabled$runtime()) {
            CompositionLocal v1 = CompositionErrorContextKt.getLocalCompositionErrorContext();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
            v0 = v0.putValue(v1, new StaticValueHolder(this.getErrorContext$runtime()));
        }

        this.rootProvider = v0;
        Object v0_1 = CompositionLocalMapKt.read(v0, InspectionTablesKt.getLocalInspectionTables());
        if(v0_1 != null) {
            ((Set)v0_1).add(this.getCompositionData());
            this.parentContext.recordInspectionTable$runtime(((Set)v0_1));
        }

        this.startGroup(Long.hashCode(this.parentContext.getCompositeKeyHashCode$runtime()));
    }

    public boolean tryImminentInvalidation$runtime(RecomposeScopeImpl arg4, Object arg5) {
        Anchor v0 = arg4.getAnchor();
        if(v0 == null) {
            return 0;
        }

        int v0_1 = GapAnchorKt.asGapAnchor(v0).toIndexFor(this.reader.getTable$runtime());
        if((this.isComposing$runtime()) && v0_1 >= this.reader.getCurrentGroup()) {
            GapComposerKt.access$insertIfMissing(this.invalidations, v0_1, arg4, arg5);
            return 1;
        }

        return 0;
    }

    public final void updateCachedValue(Object arg4) {
        GapRememberObserverHolder v4;
        if((arg4 instanceof RememberObserver)) {
            GapRememberObserverHolder v0 = new GapRememberObserverHolder(arg4, this.rememberObserverGroupIndex());
            if(this.getInserting()) {
                this.changeListWriter.remember(v0);
            }

            this.abandonSet.add(arg4);
            v4 = v0;
        }

        this.updateValue(v4);
    }

    public void updateComposerInvalidations-RY85e9Y$runtime(MutableScatterMap arg18) {
        GapComposer v0 = this;
        int v1;
        for(v1 = CollectionsKt.getLastIndex(v0.invalidations); -1 < v1; --v1) {
            Object v3 = v0.invalidations.get(v1);
            Anchor v4 = ((Invalidation)v3).getScope().getAnchor();
            GapAnchor v2 = v4 != null ? GapAnchorKt.asGapAnchor(v4) : null;
            if(v2 == null || !v2.getValid()) {
                v0.invalidations.remove(v1);
            }
            else if(((Invalidation)v3).getLocation() != v2.getLocation$runtime()) {
                ((Invalidation)v3).setLocation(v2.getLocation$runtime());
            }
        }

        Object[] v3_1 = arg18.keys;
        Object[] v4_1 = arg18.values;
        long[] v1_1 = arg18.metadata;
        int v5 = v1_1.length - 2;
        if(v5 >= 0) {
            int v7;
            for(v7 = 0; true; ++v7) {
                long v8 = v1_1[v7];
                if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                    int v11 = 8;
                    int v10 = 8 - (~(v7 - v5) >>> 0x1F);
                    int v12;
                    for(v12 = 0; v12 < v10; ++v12) {
                        if((0xFF & v8) < 0x80) {
                            int v13 = (v7 << 3) + v12;
                            Object v14 = v3_1[v13];
                            Object v13_1 = v4_1[v13];
                            Intrinsics.checkNotNull(v14, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                            Anchor v15 = ((RecomposeScopeImpl)v14).getAnchor();
                            if(v15 != null) {
                                GapAnchor v15_1 = GapAnchorKt.asGapAnchor(v15);
                                if(v15_1 != null) {
                                    int v15_2 = v15_1.getLocation$runtime();
                                    List v2_1 = v0.invalidations;
                                    if(v13_1 == ScopeInvalidated.INSTANCE) {
                                        v13_1 = null;
                                    }

                                    v2_1.add(new Invalidation(((RecomposeScopeImpl)v14), v15_2, v13_1));
                                }
                            }
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

        CollectionsKt.sortWith(v0.invalidations, GapComposerKt.access$getInvalidationLocationAscending$p());
    }

    private final void updateCompositeKeyWhenWeEnterGroup(int arg4, int arg5, Object arg6, Object arg7) {
        int v0 = 3;
        if(arg6 == null) {
            if(arg7 != null && arg4 == 0xCF && !Intrinsics.areEqual(arg7, Composer.Companion.getEmpty())) {
                this.compositeKeyHashCode = (((long)arg5)) ^ Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), v0) ^ (((long)arg7.hashCode())), v0);
                return;
            }

            this.compositeKeyHashCode = (((long)arg5)) ^ Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), v0) ^ (((long)arg4)), v0);
            return;
        }

        if((arg6 instanceof Enum)) {
            this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), v0) ^ (((long)((Enum)arg6).ordinal())), v0);
            return;
        }

        this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), v0) ^ (((long)arg6.hashCode())), v0);
    }

    private final void updateCompositeKeyWhenWeEnterGroupKeyHash(int arg6, int arg7) {
        this.compositeKeyHashCode = (((long)arg7)) ^ Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), 3) ^ (((long)arg6)), 3);
    }

    private final void updateCompositeKeyWhenWeExitGroup(int arg4, int arg5, Object arg6, Object arg7) {
        int v0 = 3;
        if(arg6 == null) {
            if(arg7 != null && arg4 == 0xCF && !Intrinsics.areEqual(arg7, Composer.Companion.getEmpty())) {
                this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.getCompositeKeyHashCode() ^ (((long)arg5)), v0) ^ (((long)arg7.hashCode())), v0);
                return;
            }

            this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.getCompositeKeyHashCode() ^ (((long)arg5)), v0) ^ (((long)arg4)), v0);
            return;
        }

        if((arg6 instanceof Enum)) {
            this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.getCompositeKeyHashCode(), v0) ^ (((long)((Enum)arg6).ordinal())), v0);
            return;
        }

        this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.getCompositeKeyHashCode(), v0) ^ (((long)arg6.hashCode())), v0);
    }

    private final void updateCompositeKeyWhenWeExitGroupKeyHash(int arg5, int arg6) {
        this.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(this.getCompositeKeyHashCode() ^ (((long)arg6)), 3) ^ (((long)arg5)), 3);
    }

    private final void updateNodeCount(int arg8, int arg9) {
        if(this.updatedNodeCount(arg8) != arg9) {
            if(arg8 < 0) {
                MutableIntIntMap v0 = this.nodeCountVirtualOverrides;
                if(v0 == null) {
                    v0 = new MutableIntIntMap(0, 1, null);
                    this.nodeCountVirtualOverrides = v0;
                }

                v0.set(arg8, arg9);
                return;
            }
            else {
                int[] v0_1 = this.nodeCountOverrides;
                if(v0_1 == null) {
                    int[] v1 = new int[this.reader.getSize()];
                    ArraysKt.fill$default(v1, -1, 0, 0, 6, null);
                    this.nodeCountOverrides = v1;
                    v0_1 = v1;
                }

                v0_1[arg8] = arg9;
            }
        }
    }

    private final void updateNodeCountOverrides(int arg6, int arg7) {
        int v0 = this.updatedNodeCount(arg6);
        if(v0 != arg7) {
            arg7 -= v0;
            v0 = Stack.getSize-impl(this.pendingStack) - 1;
            while(true) {
                int v1 = -1;
                if(arg6 != v1) {
                    int v2 = this.updatedNodeCount(arg6) + arg7;
                    this.updateNodeCount(arg6, v2);
                    int v3;
                    for(v3 = v0; v1 < v3; --v3) {
                        Object v4 = Stack.peek-impl(this.pendingStack, v3);
                        if(v4 != null && (((GapPending)v4).updateNodeCount(arg6, v2))) {
                            v0 = v3 - 1;
                            break;
                        }
                    }

                    SlotReader v1_1 = this.reader;
                    if(arg6 < 0) {
                        arg6 = v1_1.getParent();
                        continue;
                    }

                    if(v1_1.isNode(arg6)) {
                        return;
                    }

                    arg6 = this.reader.parent(arg6);
                    continue;
                }

                return;
            }
        }
    }

    private final PersistentCompositionLocalMap updateProviderMapGroup(PersistentCompositionLocalMap arg3, PersistentCompositionLocalMap arg4) {
        Builder v3 = arg3.builder();
        v3.putAll(arg4);
        arg3 = v3.build();
        this.startGroup(204, ComposerKt.getProviderMaps());
        this.updateSlot(arg3);
        this.updateSlot(arg4);
        this.endGroup();
        return arg3;
    }

    public void updateRememberedValue(Object arg1) {
        this.updateCachedValue(arg1);
    }

    private final void updateSlot(Object arg1) {
        this.nextSlot();
        this.updateValue(arg1);
    }

    public final void updateValue(Object arg4) {
        if(this.getInserting()) {
            this.writer.update(arg4);
            return;
        }

        if(this.reader.getHadNext()) {
            int v0 = this.reader.getGroupSlotIndex() - 1;
            boolean v1 = this.changeListWriter.getPastParent();
            ComposerChangeListWriter v2 = this.changeListWriter;
            if(v1) {
                v2.updateAnchoredValue(arg4, this.reader.anchor(this.reader.getParent()), v0);
                return;
            }

            v2.updateValue(arg4, v0);
            return;
        }

        this.changeListWriter.appendValue(this.reader.anchor(this.reader.getParent()), arg4);
    }

    private final int updatedNodeCount(int arg3) {
        if(arg3 < 0) {
            MutableIntIntMap v2 = this.nodeCountVirtualOverrides;
            if(v2 != null && (v2.containsKey(arg3))) {
                return v2.get(arg3);
            }

            return 0;
        }

        int[] v0 = this.nodeCountOverrides;
        if(v0 != null) {
            int v0_1 = v0[arg3];
            if(v0_1 >= 0) {
                return v0_1;
            }
        }

        return this.reader.nodeCount(arg3);
    }

    public void useNode() {
        this.validateNodeExpected();
        if(this.getInserting()) {
            ComposerKt.composeImmediateRuntimeError("useNode() called while inserting");
        }

        Object v0 = this.getNode(this.reader);
        this.changeListWriter.moveDown(v0);
        if((this.reusing) && ((v0 instanceof ComposeNodeLifecycleCallback))) {
            this.changeListWriter.useNode(v0);
        }
    }

    private final void validateNodeExpected() {
        if(!this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected");
        }

        this.nodeExpected = false;
    }

    private final void validateNodeNotExpected() {
        if(this.nodeExpected) {
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected");
        }
    }

    public void verifyConsistent$runtime() {
        this.insertTable.verifyWellFormed();
    }

    private final Object withReader(SlotReader arg5, Function0 arg6) {
        Object v5_1;
        SlotReader v0 = this.reader;
        int[] v1 = this.nodeCountOverrides;
        MutableIntObjectMap v2 = this.providerUpdates;
        this.nodeCountOverrides = null;
        this.providerUpdates = null;
        try {
            this.reader = arg5;
            v5_1 = arg6.invoke();
        }
        catch(Throwable v5) {
            this.reader = v0;
            this.nodeCountOverrides = v1;
            this.providerUpdates = v2;
            throw v5;
        }

        this.reader = v0;
        this.nodeCountOverrides = v1;
        this.providerUpdates = v2;
        return v5_1;
    }
}

