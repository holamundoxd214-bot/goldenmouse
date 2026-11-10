package androidx.compose.runtime;

import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.composer.GroupKind;
import androidx.compose.runtime.composer.ThrowingRememberManagerStub;
import androidx.compose.runtime.composer.linkbuffer.GroupHandleKt;
import androidx.compose.runtime.composer.linkbuffer.KeyInfo;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchor;
import androidx.compose.runtime.composer.linkbuffer.LinkAnchorKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableBuilder;
import androidx.compose.runtime.composer.linkbuffer.SlotTableBuilderKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTableEditor;
import androidx.compose.runtime.composer.linkbuffer.SlotTableKt;
import androidx.compose.runtime.composer.linkbuffer.SlotTableReader;
import androidx.compose.runtime.composer.linkbuffer.SlotTableReaderKt;
import androidx.compose.runtime.composer.linkbuffer.changelist.ChangeList;
import androidx.compose.runtime.composer.linkbuffer.changelist.ChangeListKt;
import androidx.compose.runtime.composer.linkbuffer.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.composer.linkbuffer.changelist.ComposerChangeListWriterAddressMode;
import androidx.compose.runtime.composer.linkbuffer.changelist.FixupList;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.Expect_jvmKt;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.ComposeStackTrace;
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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@ComposeCompilerApi @Metadata(d1={"\u0000³\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\r\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001V\b\u0001\u0018\u00002\u00020\u0001:\u0004ó\u0002ô\u0002BQ\u0012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\f\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010m\u001A\u00020nH\u0016J\b\u0010o\u001A\u00020nH\u0016J\b\u0010p\u001A\u00020nH\u0016J\r\u0010+\u001A\u00020,H\u0010¢\u0006\u0002\b|J\u001E\u0010\u007F\u001A\u00020n2\u000E\u0010\u0080\u0001\u001A\t\u0012\u0004\u0012\u00020n0\u0081\u0001H\u0010¢\u0006\u0003\b\u0082\u0001J\u0013\u0010\u008A\u0001\u001A\u00020n2\b\u0010\u008B\u0001\u001A\u00030\u0084\u0001H\u0016JJ\u0010\u008E\u0001\u001A\u00020n\"\u0005\b\u0000\u0010\u008F\u0001\"\u0005\b\u0001\u0010\u0090\u00012\u0007\u0010Y\u001A\u0003H\u008F\u00012\"\u0010\u0080\u0001\u001A\u001D\u0012\u0005\u0012\u0003H\u0090\u0001\u0012\u0005\u0012\u0003H\u008F\u0001\u0012\u0004\u0012\u00020n0\u0091\u0001¢\u0006\u0003\b\u0092\u0001H\u0016¢\u0006\u0003\u0010\u0093\u0001J\t\u0010\u0099\u0001\u001A\u00020\u0005H\u0017J\u0013\u0010\u009A\u0001\u001A\u00020,2\b\u0010Y\u001A\u0004\u0018\u00010\u001BH\u0016J\u0013\u0010\u009B\u0001\u001A\u00020,2\b\u0010Y\u001A\u0004\u0018\u00010\u001BH\u0016J\u0012\u0010\u009A\u0001\u001A\u00020,2\u0007\u0010Y\u001A\u00030\u009C\u0001H\u0016J\u0012\u0010\u009A\u0001\u001A\u00020,2\u0007\u0010Y\u001A\u00030\u009D\u0001H\u0016J\u0012\u0010\u009A\u0001\u001A\u00020,2\u0007\u0010Y\u001A\u00030\u009E\u0001H\u0016J\u0011\u0010\u009A\u0001\u001A\u00020,2\u0006\u0010Y\u001A\u00020,H\u0016J\u0012\u0010\u009A\u0001\u001A\u00020,2\u0007\u0010Y\u001A\u00030\u009F\u0001H\u0016J\u0011\u0010\u009A\u0001\u001A\u00020,2\u0006\u0010Y\u001A\u00020cH\u0016J\u0012\u0010\u009A\u0001\u001A\u00020,2\u0007\u0010Y\u001A\u00030 \u0001H\u0016J\u0011\u0010\u009A\u0001\u001A\u00020,2\u0006\u0010Y\u001A\u00020#H\u0016J\t\u0010¡\u0001\u001A\u00020nH\u0016JH\u0010¢\u0001\u001A\u00020n2\u0013\u0010£\u0001\u001A\u000E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u001B0\u00192\u0014\u0010¤\u0001\u001A\u000F\u0012\u0004\u0012\u00020n0\u0081\u0001¢\u0006\u0003\b¥\u00012\t\u0010¦\u0001\u001A\u0004\u0018\u00010wH\u0011¢\u0006\u0006\b§\u0001\u0010¨\u0001J(\u0010¬\u0001\u001A\u0003H\u0090\u0001\"\u0005\b\u0000\u0010\u0090\u00012\u000F\u0010­\u0001\u001A\n\u0012\u0005\u0012\u0003H\u0090\u00010®\u0001H\u0017¢\u0006\u0003\u0010¯\u0001J!\u0010°\u0001\u001A\u00020n\"\u0005\b\u0000\u0010\u0090\u00012\u000F\u0010±\u0001\u001A\n\u0012\u0005\u0012\u0003H\u0090\u00010\u0081\u0001H\u0016J\u000F\u0010º\u0001\u001A\u00020nH\u0010¢\u0006\u0003\b»\u0001J\u0012\u0010¼\u0001\u001A\u00020n2\u0007\u0010\u009A\u0001\u001A\u00020,H\u0016J\u000F\u0010½\u0001\u001A\u00020nH\u0010¢\u0006\u0003\b¾\u0001J\t\u0010¿\u0001\u001A\u00020nH\u0016J\t\u0010À\u0001\u001A\u00020nH\u0016J\t\u0010Á\u0001\u001A\u00020nH\u0017J\t\u0010Â\u0001\u001A\u00020nH\u0017J\t\u0010Ã\u0001\u001A\u00020nH\u0016J\f\u0010Ä\u0001\u001A\u0005\u0018\u00010Å\u0001H\u0016J\t\u0010Æ\u0001\u001A\u00020nH\u0017J\t\u0010Ç\u0001\u001A\u00020nH\u0016J\u000F\u0010È\u0001\u001A\u00020nH\u0010¢\u0006\u0003\bÉ\u0001J\t\u0010Ê\u0001\u001A\u00020nH\u0016J\u0017\u0010Ë\u0001\u001A\u00020n2\f\u0010Ì\u0001\u001A\u00070#j\u0003`·\u0001H\u0016J!\u0010Ï\u0001\u001A\u00020n2\u000B\u0010Y\u001A\u0007\u0012\u0002\b\u00030Ð\u00012\t\u0010Ñ\u0001\u001A\u0004\u0018\u00010\u001BH\u0017J*\u0010Ò\u0001\u001A\u00020n2\u001F\u0010Ó\u0001\u001A\u001A\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030Ö\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010Õ\u00010Ô\u0001H\u0017J\u001F\u0010×\u0001\u001A\u00020\u001B2\t\u0010Ø\u0001\u001A\u0004\u0018\u00010\u001B2\t\u0010Ù\u0001\u001A\u0004\u0018\u00010\u001BH\u0016J\u000F\u0010Ú\u0001\u001A\u00020#H\u0011¢\u0006\u0003\bÛ\u0001J\u0017\u0010Ü\u0001\u001A\n\u0012\u0005\u0012\u00030Ý\u00010Ô\u0001H\u0010¢\u0006\u0003\bÞ\u0001J2\u0010ß\u0001\u001A\u00020,2\u0013\u0010£\u0001\u001A\u000E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u001B0\u00192\t\u0010¦\u0001\u001A\u0004\u0018\u00010wH\u0011¢\u0006\u0006\bà\u0001\u0010á\u0001J\u0019\u0010â\u0001\u001A\u00020n2\u000E\u0010ã\u0001\u001A\t\u0012\u0004\u0012\u00020n0\u0081\u0001H\u0017J\u000B\u0010ä\u0001\u001A\u0004\u0018\u00010\u001BH\u0016J\u001B\u0010å\u0001\u001A\u00020,2\u0007\u0010æ\u0001\u001A\u00020,2\u0007\u0010ç\u0001\u001A\u00020#H\u0017J\t\u0010è\u0001\u001A\u00020nH\u0017J\t\u0010é\u0001\u001A\u00020nH\u0017J\u001A\u0010ê\u0001\u001A\u00030ë\u00012\u000E\u0010ì\u0001\u001A\t\u0012\u0004\u0012\u00020n0\u0081\u0001H\u0016J\u0013\u0010í\u0001\u001A\u00020n2\b\u0010í\u0001\u001A\u00030î\u0001H\u0016J\t\u0010ï\u0001\u001A\u00020nH\u0016J\u001C\u0010ð\u0001\u001A\u00020n2\u0007\u0010­\u0001\u001A\u00020#2\b\u0010í\u0001\u001A\u00030î\u0001H\u0016J\u000F\u0010ñ\u0001\u001A\u00020#H\u0010¢\u0006\u0003\bò\u0001J\u001A\u0010ó\u0001\u001A\u00030ô\u00012\b\u0010Y\u001A\u0004\u0018\u00010\u001BH\u0010¢\u0006\u0003\bõ\u0001J\t\u0010ö\u0001\u001A\u00020nH\u0016J\t\u0010÷\u0001\u001A\u00020nH\u0016J\u0016\u0010ø\u0001\u001A\u00020n2\u000B\u0010Y\u001A\u0007\u0012\u0002\b\u00030ù\u0001H\u0017J&\u0010ú\u0001\u001A\u00020n2\u0015\u0010û\u0001\u001A\u0010\u0012\u000B\b\u0001\u0012\u0007\u0012\u0002\b\u00030ù\u00010ü\u0001H\u0017¢\u0006\u0003\u0010ý\u0001J\u0012\u0010þ\u0001\u001A\u00020n2\u0007\u0010­\u0001\u001A\u00020#H\u0016J\u0012\u0010ÿ\u0001\u001A\u00020n2\u0007\u0010­\u0001\u001A\u00020#H\u0016J\u0013\u0010\u0080\u0002\u001A\u00030\u0081\u00022\u0007\u0010­\u0001\u001A\u00020#H\u0016J\u001D\u0010\u0082\u0002\u001A\u00020n2\u0007\u0010­\u0001\u001A\u00020#2\t\u0010\u0083\u0002\u001A\u0004\u0018\u00010\u001BH\u0016J\t\u0010\u0084\u0002\u001A\u00020nH\u0016J\u000F\u0010\u0085\u0002\u001A\u00020nH\u0010¢\u0006\u0003\b\u0086\u0002J\u001D\u0010\u0087\u0002\u001A\u00020n2\u0007\u0010­\u0001\u001A\u00020#2\t\u0010\u0083\u0002\u001A\u0004\u0018\u00010\u001BH\u0016J#\u0010\u0088\u0002\u001A\u00020,2\u0007\u0010\u008B\u0001\u001A\u00020\u001A2\t\u0010\u0089\u0002\u001A\u0004\u0018\u00010\u001BH\u0010¢\u0006\u0003\b\u008A\u0002J\'\u0010\u008B\u0002\u001A\u00020n2\u0013\u0010£\u0001\u001A\u000E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u001B0\u0019H\u0010¢\u0006\u0006\b\u008C\u0002\u0010\u008D\u0002J\u0013\u0010\u008E\u0002\u001A\u00020n2\b\u0010Y\u001A\u0004\u0018\u00010\u001BH\u0016J\t\u0010\u008F\u0002\u001A\u00020nH\u0016J\u000F\u0010\u0090\u0002\u001A\u00020nH\u0010¢\u0006\u0003\b\u0091\u0002J\u0011\u0010\u0092\u0002\u001A\u0004\u0018\u00010\u001BH\u0000¢\u0006\u0003\b\u0093\u0002J\u0011\u0010\u0094\u0002\u001A\u0004\u0018\u00010\u001BH\u0000¢\u0006\u0003\b\u0095\u0002J\u0013\u0010\u0096\u0002\u001A\u00020n2\b\u0010Y\u001A\u0004\u0018\u00010\u001BH\u0001J\t\u0010\u0097\u0002\u001A\u00020nH\u0002J\t\u0010\u0098\u0002\u001A\u00020nH\u0002J\t\u0010\u0099\u0002\u001A\u00020nH\u0002J\t\u0010\u009A\u0002\u001A\u00020nH\u0002J\f\u0010\u009B\u0002\u001A\u0005\u0018\u00010ô\u0001H\u0002J?\u0010\u009C\u0002\u001A\u00020n2\u0013\u0010£\u0001\u001A\u000E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u001B0\u00192\u0016\u0010¤\u0001\u001A\u0011\u0012\u0004\u0012\u00020n\u0018\u00010\u0081\u0001¢\u0006\u0003\b¥\u0001H\u0003¢\u0006\u0006\b\u009D\u0002\u0010\u009E\u0002J\u0012\u0010\u009F\u0002\u001A\u00020n2\u0007\u0010 \u0002\u001A\u00020,H\u0002J\t\u0010¡\u0002\u001A\u00020nH\u0002J\t\u0010¢\u0002\u001A\u00020nH\u0002J\u000F\u0010£\u0002\u001A\u00020nH\u0010¢\u0006\u0003\b¤\u0002J\u001D\u0010¥\u0002\u001A\u00020n2\u0007\u0010 \u0002\u001A\u00020,2\t\u0010¦\u0002\u001A\u0004\u0018\u00010\u001FH\u0002J\t\u0010§\u0002\u001A\u00020nH\u0002J\u001A\u0010¨\u0002\u001A\u00020n2\u0007\u0010©\u0002\u001A\u00020#2\u0006\u0010}\u001A\u00020,H\u0002J\t\u0010ª\u0002\u001A\u00020nH\u0002J\t\u0010«\u0002\u001A\u00020nH\u0002J\t\u0010¬\u0002\u001A\u000201H\u0002J\u0017\u0010¬\u0002\u001A\u0002012\f\u0010­\u0002\u001A\u00070#j\u0003`·\u0001H\u0002J*\u0010®\u0002\u001A\u00020n2\u001F\u0010Ó\u0001\u001A\u001A\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030Ö\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010Õ\u00010Ô\u0001H\u0003Jt\u0010¯\u0002\u001A\u0003H°\u0002\"\u0005\b\u0000\u0010°\u00022\f\b\u0002\u0010±\u0002\u001A\u0005\u0018\u00010²\u00022\f\b\u0002\u0010³\u0002\u001A\u0005\u0018\u00010²\u00022\u000E\b\u0002\u0010´\u0002\u001A\u00070#j\u0003`·\u00012\u001E\b\u0002\u0010\u0018\u001A\u0018\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u00020\u001A\u0012\u0006\u0012\u0004\u0018\u00010\u001B0Õ\u00010Ô\u00012\u000F\u0010\u0080\u0001\u001A\n\u0012\u0005\u0012\u0003H°\u00020\u0081\u0001H\u0002¢\u0006\u0003\u0010µ\u0002J8\u0010¶\u0002\u001A\u00020n2\u0010\u0010¤\u0001\u001A\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u001B0Ð\u00012\u0007\u0010·\u0002\u001A\u0002012\t\u0010Ñ\u0001\u001A\u0004\u0018\u00010\u001B2\u0007\u0010¸\u0002\u001A\u00020,H\u0003J\u0017\u0010¹\u0002\u001A\u00020,2\f\u0010­\u0002\u001A\u00070cj\u0003`º\u0002H\u0002J\t\u0010»\u0002\u001A\u00020nH\u0003J\t\u0010¼\u0002\u001A\u00020nH\u0002J\u0017\u0010½\u0002\u001A\u00020n2\f\u0010¾\u0002\u001A\u00070cj\u0003`º\u0002H\u0002J\u0012\u0010¿\u0002\u001A\u00020n2\u0007\u0010À\u0002\u001A\u000201H\u0002J\t\u0010Á\u0002\u001A\u00020nH\u0002J\u0017\u0010Â\u0002\u001A\u00020n2\f\u0010Ã\u0002\u001A\u00070cj\u0003`º\u0002H\u0002J\u0012\u0010Ä\u0002\u001A\u00020n2\u0007\u0010½\u0001\u001A\u00020,H\u0002J\u0017\u0010Å\u0002\u001A\u00020\u001A2\f\u0010­\u0002\u001A\u00070#j\u0003`·\u0001H\u0002J\u0017\u0010Æ\u0002\u001A\u00020,2\f\u0010­\u0002\u001A\u00070#j\u0003`·\u0001H\u0002J\u0017\u0010Ç\u0002\u001A\u00020#2\f\u0010­\u0002\u001A\u00070#j\u0003`·\u0001H\u0002J\t\u0010È\u0002\u001A\u00020nH\u0002J\t\u0010É\u0002\u001A\u00020nH\u0002J;\u0010Ê\u0002\u001A\u00020n2\u0007\u0010­\u0001\u001A\u00020#2\t\u0010Ë\u0002\u001A\u0004\u0018\u00010\u001B2\b\u0010Ì\u0002\u001A\u00030Í\u00022\t\u0010Î\u0002\u001A\u0004\u0018\u00010\u001BH\u0002¢\u0006\u0006\bÏ\u0002\u0010Ð\u0002J\u0013\u0010Ñ\u0002\u001A\u00020n2\u0007\u0010­\u0001\u001A\u00020#H\u0082\bJ\u001D\u0010Ñ\u0002\u001A\u00020n2\u0007\u0010­\u0001\u001A\u00020#2\t\u0010\u0083\u0002\u001A\u0004\u0018\u00010\u001BH\u0002J\u001D\u0010Ò\u0002\u001A\u00020n2\u0007\u0010 \u0002\u001A\u00020,2\t\u0010Î\u0002\u001A\u0004\u0018\u00010\u001BH\u0002J\t\u0010Ó\u0002\u001A\u00020nH\u0002J+\u0010Ô\u0002\u001A\n\u0012\u0005\u0012\u00030Ý\u00010Ô\u00012\u0007\u0010­\u0002\u001A\u00020#2\t\u0010Õ\u0002\u001A\u0004\u0018\u00010#H\u0002¢\u0006\u0003\u0010Ö\u0002J\u0019\u0010×\u0002\u001A\u00020n2\b\u0010Y\u001A\u0004\u0018\u00010\u001BH\u0000¢\u0006\u0003\bØ\u0002J \u0010Ù\u0002\u001A\u00020n2\f\u0010Ú\u0002\u001A\u00070cj\u0003`Û\u00022\u0007\u0010Ü\u0002\u001A\u00020#H\u0002J \u0010Ý\u0002\u001A\u00020n2\f\u0010Þ\u0002\u001A\u00070cj\u0003`Û\u00022\u0007\u0010ß\u0002\u001A\u00020#H\u0002J\u001B\u0010à\u0002\u001A\u0002012\u0007\u0010á\u0002\u001A\u0002012\u0007\u0010â\u0002\u001A\u000201H\u0002J\u0013\u0010ã\u0002\u001A\u00020n2\b\u0010Y\u001A\u0004\u0018\u00010\u001BH\u0002J\u0017\u0010ä\u0002\u001A\u00020#2\f\u0010Þ\u0002\u001A\u00070cj\u0003`Û\u0002H\u0002J\u0011\u0010å\u0002\u001A\u0004\u0018\u00010\u001B*\u0004\u0018\u00010\u001BH\u0002J1\u0010æ\u0002\u001A\u0003H°\u0002\"\u0005\b\u0000\u0010°\u00022\u0006\u00109\u001A\u00020:2\u000F\u0010\u0080\u0001\u001A\n\u0012\u0005\u0012\u0003H°\u00020\u0081\u0001H\u0082\b¢\u0006\u0003\u0010ç\u0002J\u0012\u0010è\u0002\u001A\u00020n2\u0007\u0010\u008B\u0001\u001A\u00020\u001AH\u0002J\"\u0010é\u0002\u001A\u0012\u0012\u0005\u0012\u00030ë\u0002\u0012\u0004\u0012\u00020n\u0018\u00010ê\u00022\u0007\u0010\u008B\u0001\u001A\u00020\u001AH\u0002J1\u0010ì\u0002\u001A\u00020n2\u0007\u0010í\u0002\u001A\u00020#2\u0006\u0010%\u001A\u00020#2\t\u0010\u0083\u0002\u001A\u0004\u0018\u00010\u001B2\t\u0010Î\u0002\u001A\u0004\u0018\u00010\u001BH\u0082\bJ\u001B\u0010î\u0002\u001A\u00020n2\u0007\u0010í\u0002\u001A\u00020#2\u0006\u0010%\u001A\u00020#H\u0082\bJ1\u0010ï\u0002\u001A\u00020n2\u0007\u0010í\u0002\u001A\u00020#2\u0006\u0010%\u001A\u00020#2\t\u0010\u0083\u0002\u001A\u0004\u0018\u00010\u001B2\t\u0010Î\u0002\u001A\u0004\u0018\u00010\u001BH\u0082\bJ\u001B\u0010ð\u0002\u001A\u00020n2\u0007\u0010í\u0002\u001A\u00020#2\u0006\u0010%\u001A\u00020#H\u0082\bJ\t\u0010ñ\u0002\u001A\u00020nH\u0002J\t\u0010ò\u0002\u001A\u00020nH\u0002R\u0018\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u001C\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u001B0\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001CR\u0018\u0010\u001D\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001F0\u001EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001A\u0004\u0018\u00010\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020#X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020#X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020#X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001A\u0004\u0018\u00010)X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010*\u001A\u0004\u0018\u00010)X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020,X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010-\u001A\u00020,X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020,X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u00020\'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00100\u001A\u000201X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u00102\u001A\n\u0012\u0004\u0012\u000201\u0018\u000103X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00104\u001A\u00020,X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00105\u001A\u00020\'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u00106\u001A\u00020,X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00107\u001A\u00020#X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00108\u001A\u0004\u0018\u000101X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u00109\u001A\u00020:X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000E\u0010?\u001A\u00020@X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010A\u001A\u00020,X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010B\u001A\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001A\u0004\u0018\u00010EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010F\u001A\u00020#X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010G\u001A\u00020HX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010I\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bJ\u0010KR\u0014\u0010L\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bM\u0010KR\u000E\u0010N\u001A\u00020#X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010O\u001A\u00020#X\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010P\u001A\u00020,X\u0090\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0010\u0010U\u001A\u00020VX\u0082\u0004¢\u0006\u0004\n\u0002\u0010WR\u0016\u0010X\u001A\b\u0012\u0004\u0012\u00020\u001A0\u001EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u001E\u0010Z\u001A\u00020,2\u0006\u0010Y\u001A\u00020,@RX\u0090\u000E¢\u0006\b\n\u0000\u001A\u0004\b[\u0010RR\u001E\u0010\\\u001A\u00020,2\u0006\u0010Y\u001A\u00020,@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b]\u0010RR\u0014\u0010^\u001A\u00020,8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b_\u0010RR\u0016\u0010`\u001A\u0004\u0018\u00010\u001A8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\ba\u0010bR0\u0010e\u001A\u00060cj\u0002`d2\n\u0010Y\u001A\u00060cj\u0002`d8\u0016@RX\u0097\u000E¢\u0006\u0010\n\u0002\u0010j\u0012\u0004\bf\u0010g\u001A\u0004\bh\u0010iR\u0014\u0010k\u001A\u00020,8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bl\u0010RR\u001C\u0010q\u001A\u0004\u0018\u00010\fX\u0090\u000E¢\u0006\u000E\n\u0000\u001A\u0004\br\u0010s\"\u0004\bt\u0010uR\u0010\u0010v\u001A\u0004\u0018\u00010wX\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010x\u001A\u0004\u0018\u00010y8PX\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\bz\u0010{R\u001E\u0010}\u001A\u00020,2\u0006\u0010Y\u001A\u00020,@RX\u0096\u000E¢\u0006\b\n\u0000\u001A\u0004\b~\u0010RR\u001A\u0010\u0083\u0001\u001A\u0005\u0018\u00010\u0084\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0019\u0010\u0087\u0001\u001A\u0004\u0018\u00010\u001B8VX\u0096\u0004¢\u0006\b\u001A\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0016\u0010\u008C\u0001\u001A\u00020,8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u008D\u0001\u0010RR!\u0010\u0094\u0001\u001A\u00030\u0095\u00018\u0016X\u0097\u0004¢\u0006\u0011\n\u0000\u0012\u0005\b\u0096\u0001\u0010g\u001A\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0017\u0010©\u0001\u001A\u00020E8VX\u0096\u0004¢\u0006\b\u001A\u0006\bª\u0001\u0010«\u0001R\u0018\u0010²\u0001\u001A\u00030³\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\b´\u0001\u0010µ\u0001R\u001C\u0010¶\u0001\u001A\u00070#j\u0003`·\u00018VX\u0096\u0004¢\u0006\b\u001A\u0006\b¸\u0001\u0010¹\u0001R\u0016\u0010Í\u0001\u001A\u00020,8PX\u0090\u0004¢\u0006\u0007\u001A\u0005\bÎ\u0001\u0010R¨\u0006õ\u0002"}, d2={"Landroidx/compose/runtime/LinkComposer;", "Landroidx/compose/runtime/InternalComposer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "slotTable", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "changes", "Landroidx/compose/runtime/Changes;", "lateChanges", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "composition", "Landroidx/compose/runtime/CompositionImpl;", "<init>", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Ljava/util/Set;Landroidx/compose/runtime/composer/linkbuffer/SlotTable;Landroidx/compose/runtime/Changes;Landroidx/compose/runtime/Changes;Landroidx/compose/runtime/CompositionObserverHolder;Landroidx/compose/runtime/CompositionImpl;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "getComposition", "()Landroidx/compose/runtime/CompositionImpl;", "invalidations", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "", "Landroidx/collection/MutableScatterMap;", "pendingStack", "Landroidx/compose/runtime/Stack;", "Landroidx/compose/runtime/LinkPending;", "Ljava/util/ArrayList;", "pending", "nodeIndex", "", "groupNodeCount", "rGroupIndex", "parentStateStack", "Landroidx/compose/runtime/IntStack;", "nodeCountOverrides", "Landroidx/collection/MutableIntIntMap;", "nodeCountVirtualOverrides", "forceRecomposeScopes", "", "forciblyRecompose", "nodeExpected", "entersStack", "rootProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "providerUpdates", "Landroidx/collection/MutableIntObjectMap;", "providersInvalid", "providersInvalidStack", "reusing", "reusingGroup", "providerCache", "reader", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "getReader$runtime", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "setReader$runtime", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;)V", "builder", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "builderHasAProvider", "changeListWriter", "Landroidx/compose/runtime/composer/linkbuffer/changelist/ComposerChangeListWriter;", "_compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "lastPlacedChildGroup", "insertFixups", "Landroidx/compose/runtime/composer/linkbuffer/changelist/FixupList;", "insertTable", "getInsertTable$runtime", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "readerTable", "getReaderTable$runtime", "childrenComposing", "compositionToken", "sourceMarkersEnabled", "getSourceMarkersEnabled$runtime", "()Z", "setSourceMarkersEnabled$runtime", "(Z)V", "derivedStateObserver", "androidx/compose/runtime/LinkComposer$derivedStateObserver$1", "Landroidx/compose/runtime/LinkComposer$derivedStateObserver$1;", "invalidateStack", "value", "isComposing", "isComposing$runtime", "isDisposed", "isDisposed$runtime", "areChildrenComposing", "getAreChildrenComposing$runtime", "currentRecomposeScope", "getCurrentRecomposeScope$runtime", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "compositeKeyHashCode", "getCompositeKeyHashCode$annotations", "()V", "getCompositeKeyHashCode", "()J", "J", "defaultsInvalid", "getDefaultsInvalid", "disableReusing", "", "disableSourceInformation", "enableReusing", "deferredChanges", "getDeferredChanges$runtime", "()Landroidx/compose/runtime/Changes;", "setDeferredChanges$runtime", "(Landroidx/compose/runtime/Changes;)V", "shouldPauseCallback", "Landroidx/compose/runtime/ShouldPauseCallback;", "errorContext", "Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "getErrorContext$runtime", "()Landroidx/compose/runtime/tooling/CompositionErrorContextImpl;", "forceRecomposeScopes$runtime", "inserting", "getInserting", "prepareCompose", "block", "Lkotlin/Function0;", "prepareCompose$runtime", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "recordUsed", "scope", "skipping", "getSkipping", "apply", "V", "T", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext$annotations", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "buildContext", "changed", "changedInstance", "", "", "", "", "", "collectParameterInformation", "composeContent", "invalidationsRequested", "content", "Landroidx/compose/runtime/Composable;", "shouldPause", "composeContent--ZbOJvo$runtime", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/ShouldPauseCallback;)V", "compositionData", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "consume", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createNode", "factory", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentMarker", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "getCurrentMarker", "()I", "deactivate", "deactivate$runtime", "deactivateToEndGroup", "dispose", "dispose$runtime", "endDefaults", "endNode", "endProvider", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReplaceGroup", "endReusableGroup", "endReuseFromRoot", "endReuseFromRoot$runtime", "endMovableGroup", "endToMarker", "marker", "hasPendingChanges", "getHasPendingChanges$runtime", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentReferences", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "joinKey", "left", "right", "parentKey", "parentKey$runtime", "parentStackTrace", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "parentStackTrace$runtime", "recompose", "recompose-aFTiNEg$runtime", "(Landroidx/collection/MutableScatterMap;Landroidx/compose/runtime/ShouldPauseCallback;)Z", "recordSideEffect", "effect", "rememberedValue", "shouldExecute", "parametersChanged", "flags", "skipCurrentGroup", "skipToGroupEnd", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "stacksSize", "stacksSize$runtime", "stackTraceForValue", "Landroidx/compose/runtime/tooling/ComposeStackTrace;", "stackTraceForValue$runtime", "startDefaults", "startNode", "startProvider", "Landroidx/compose/runtime/ProvidedValue;", "startProviders", "values", "", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReplaceableGroup", "startReplaceGroup", "startRestartGroup", "Landroidx/compose/runtime/Composer;", "startReusableGroup", "dataKey", "startReusableNode", "startReuseFromRoot", "startReuseFromRoot$runtime", "startMovableGroup", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime", "updateComposerInvalidations", "updateComposerInvalidations-RY85e9Y$runtime", "(Landroidx/collection/MutableScatterMap;)V", "updateRememberedValue", "useNode", "verifyConsistent", "verifyConsistent$runtime", "nextSlot", "nextSlot$runtime", "nextSlotForCache", "nextSlotForCache$runtime", "updateValue", "abortRoot", "addRecomposeScope", "cleanUpCompose", "clearUpdatedNodeCounts", "currentStackTrace", "doCompose", "doCompose-aFTiNEg", "(Landroidx/collection/MutableScatterMap;Lkotlin/jvm/functions/Function2;)V", "end", "isNode", "endGroup", "endRoot", "changesApplied", "changesApplied$runtime", "enterGroup", "newPending", "executeChangesImmediatelyWithoutApplier", "exitGroup", "expectedNodeCount", "ensureBuilder", "finalizeCompose", "currentCompositionLocalScope", "group", "insertMovableContentGuarded", "recomposeMovableContent", "R", "from", "Landroidx/compose/runtime/ControlledComposition;", "to", "address", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;ILjava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "invokeMovableContentLambda", "locals", "force", "isGroupAfterCurrentReaderPosition", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "recomposeToGroupEnd", "recordDelete", "recordInsert", "source", "recordProviderUpdate", "providers", "reportAllMovableContent", "reportFreeMovableContent", "groupBeingRemoved", "resetInsertBuilder", "requireRecomposeScope", "requiresRecomposition", "rGroupIndexOf", "skipGroup", "skipReaderToGroupEnd", "start", "objectKey", "kind", "Landroidx/compose/runtime/composer/GroupKind;", "data", "start-AzEfcrM", "(ILjava/lang/Object;ILjava/lang/Object;)V", "startGroup", "startReaderGroup", "startRoot", "stackTraceForGroup", "dataOffset", "(ILjava/lang/Integer;)Ljava/util/List;", "updateCachedValue", "updateCachedValue$runtime", "updateChildNodeCount", "virtualGroup", "Landroidx/compose/runtime/VirtualGroupHandle;", "count", "updateNodeCountOverrides", "virtualHandle", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateSlot", "updatedNodeCount", "unwrapRememberObserverHolder", "withReader", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "enterRecomposeScope", "exitRecomposeScope", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "updateCompositeKeyWhenWeEnterGroup", "groupKey", "updateCompositeKeyWhenWeEnterGroupKeyHash", "updateCompositeKeyWhenWeExitGroup", "updateCompositeKeyWhenWeExitGroupKeyHash", "validateNodeExpected", "validateNodeNotExpected", "CompositionContextImpl", "CompositionContextHolder", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LinkComposer extends InternalComposer {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u00060\u0003R\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001A\u00020\nH\u0016J\b\u0010\u000B\u001A\u00020\nH\u0016J\b\u0010\f\u001A\u00020\nH\u0016R\u0015\u0010\u0002\u001A\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\r"}, d2={"Landroidx/compose/runtime/LinkComposer$CompositionContextHolder;", "Landroidx/compose/runtime/RememberObserver;", "ref", "Landroidx/compose/runtime/LinkComposer$CompositionContextImpl;", "Landroidx/compose/runtime/LinkComposer;", "<init>", "(Landroidx/compose/runtime/LinkComposer$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/LinkComposer$CompositionContextImpl;", "onRemembered", "", "onAbandoned", "onForgotten", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CompositionContextHolder implements RememberObserver {
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

    @Metadata(d1={"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B-\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ\u0006\u0010\"\u001A\u00020#J\u0015\u0010$\u001A\u00020#2\u0006\u0010%\u001A\u00020&H\u0010¢\u0006\u0002\b\'J\u0015\u0010(\u001A\u00020#2\u0006\u0010%\u001A\u00020&H\u0010¢\u0006\u0002\b)J\u0015\u0010*\u001A\u00020#2\u0006\u0010+\u001A\u00020,H\u0010¢\u0006\u0002\b-J\u0015\u0010.\u001A\u00020#2\u0006\u0010+\u001A\u00020,H\u0010¢\u0006\u0002\b/J\u0015\u00100\u001A\u00020#2\u0006\u00101\u001A\u000202H\u0010¢\u0006\u0002\b3J*\u00108\u001A\u00020#2\u0006\u0010+\u001A\u00020,2\u0011\u00109\u001A\r\u0012\u0004\u0012\u00020#0:¢\u0006\u0002\b;H\u0011¢\u0006\u0004\b<\u0010=J8\u0010>\u001A\b\u0012\u0004\u0012\u0002020?2\u0006\u0010+\u001A\u00020,2\u0006\u0010@\u001A\u00020A2\u0011\u00109\u001A\r\u0012\u0004\u0012\u00020#0:¢\u0006\u0002\b;H\u0011¢\u0006\u0004\bB\u0010CJ1\u0010D\u001A\b\u0012\u0004\u0012\u0002020?2\u0006\u0010+\u001A\u00020,2\u0006\u0010@\u001A\u00020A2\f\u0010E\u001A\b\u0012\u0004\u0012\u0002020?H\u0010¢\u0006\u0002\bFJ\u0015\u0010G\u001A\u00020#2\u0006\u0010+\u001A\u00020,H\u0010¢\u0006\u0002\bHJ\u0015\u0010I\u001A\u00020#2\u0006\u00101\u001A\u000202H\u0010¢\u0006\u0002\bJJ\r\u0010N\u001A\u00020LH\u0010¢\u0006\u0002\bTJ\u000E\u0010U\u001A\u00020#2\u0006\u00101\u001A\u00020LJ\u001B\u0010V\u001A\u00020#2\f\u0010W\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0010¢\u0006\u0002\bXJ\r\u0010Y\u001A\u00020#H\u0010¢\u0006\u0002\bZJ\r\u0010[\u001A\u00020#H\u0010¢\u0006\u0002\b\\J\u0015\u0010]\u001A\u00020#2\u0006\u0010^\u001A\u00020_H\u0010¢\u0006\u0002\b`J\u0015\u0010a\u001A\u00020#2\u0006\u0010^\u001A\u00020_H\u0010¢\u0006\u0002\bbJ\u0017\u0010c\u001A\u0004\u0018\u00010d2\u0006\u0010^\u001A\u00020_H\u0010¢\u0006\u0002\beJ)\u0010f\u001A\u00020#2\u0006\u0010^\u001A\u00020_2\u0006\u0010g\u001A\u00020d2\n\u0010h\u001A\u0006\u0012\u0002\b\u00030iH\u0010¢\u0006\u0002\bjJ\u0015\u0010k\u001A\u00020#2\u0006\u0010+\u001A\u00020,H\u0010¢\u0006\u0002\blJ\u0016\u0010p\u001A\u00020q2\f\u0010r\u001A\b\u0012\u0004\u0012\u00020#0:H\u0016R\u001A\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004X\u0090\u0004¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001A\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0007\u001A\u00020\u0006X\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001A\u0004\u0018\u00010\tX\u0090\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0015X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u0017\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001C0\u0015¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0018R\u0014\u0010\u001E\u001A\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u0010R\u0014\u0010 \u001A\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u0010R\u0014\u00104\u001A\u0002058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b6\u00107R+\u0010M\u001A\u00020L2\u0006\u0010K\u001A\u00020L8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\bR\u0010S\u001A\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0014\u0010+\u001A\u00020m8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\bn\u0010o¨\u0006s"}, d2={"Landroidx/compose/runtime/LinkComposer$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compositeKeyHashCode", "", "Landroidx/compose/runtime/CompositeKeyHashCode;", "collectingParameterInformation", "", "collectingSourceInformation", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "<init>", "(Landroidx/compose/runtime/LinkComposer;JZZLandroidx/compose/runtime/CompositionObserverHolder;)V", "getCompositeKeyHashCode$runtime", "()J", "J", "getCollectingParameterInformation$runtime", "()Z", "getCollectingSourceInformation$runtime", "getObserverHolder$runtime", "()Landroidx/compose/runtime/CompositionObserverHolder;", "inspectionTables", "", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "()Ljava/util/Set;", "setInspectionTables", "(Ljava/util/Set;)V", "composers", "Landroidx/compose/runtime/LinkComposer;", "getComposers", "collectingCallByInformation", "getCollectingCallByInformation$runtime", "stackTraceEnabled", "getStackTraceEnabled$runtime", "dispose", "", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime", "unregisterComposer", "unregisterComposer$runtime", "registerComposition", "composition", "Landroidx/compose/runtime/ControlledComposition;", "registerComposition$runtime", "unregisterComposition", "unregisterComposition$runtime", "reportPausedScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "reportPausedScope$runtime", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "composeInitial", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitialPaused", "Landroidx/collection/ScatterSet;", "shouldPause", "Landroidx/compose/runtime/ShouldPauseCallback;", "composeInitialPaused$runtime", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ShouldPauseCallback;Lkotlin/jvm/functions/Function2;)Landroidx/collection/ScatterSet;", "recomposePaused", "invalidScopes", "recomposePaused$runtime", "invalidate", "invalidate$runtime", "invalidateScope", "invalidateScope$runtime", "<set-?>", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompositionLocalScope$runtime", "updateCompositionLocalScope", "recordInspectionTable", "table", "recordInspectionTable$runtime", "startComposing", "startComposing$runtime", "doneComposing", "doneComposing$runtime", "insertMovableContent", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContent$runtime", "deletedMovableContent", "deletedMovableContent$runtime", "movableContentStateResolve", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve$runtime", "movableContentStateReleased", "data", "applier", "Landroidx/compose/runtime/Applier;", "movableContentStateReleased$runtime", "reportRemovedComposition", "reportRemovedComposition$runtime", "Landroidx/compose/runtime/Composition;", "getComposition$runtime", "()Landroidx/compose/runtime/Composition;", "scheduleFrameEndCallback", "Landroidx/compose/runtime/CancellationHandle;", "action", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CompositionContextImpl extends CompositionContext {
        private final boolean collectingParameterInformation;
        private final boolean collectingSourceInformation;
        private final Set composers;
        private final long compositeKeyHashCode;
        private final MutableState compositionLocalScope$delegate;
        private Set inspectionTables;
        private final CompositionObserverHolder observerHolder;

        public CompositionContextImpl(LinkComposer arg1, long arg2, boolean arg4, boolean arg5, CompositionObserverHolder arg6) {
            LinkComposer.this = arg1;
            super();
            this.compositeKeyHashCode = arg2;
            this.collectingParameterInformation = arg4;
            this.collectingSourceInformation = arg5;
            this.observerHolder = arg6;
            this.composers = new LinkedHashSet();
            this.compositionLocalScope$delegate = SnapshotStateKt.mutableStateOf(PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf(), SnapshotStateKt.referentialEqualityPolicy());
        }

        public void composeInitial$runtime(ControlledComposition arg1, Function2 arg2) {
            LinkComposer.this.parentContext.composeInitial$runtime(arg1, arg2);
        }

        public ScatterSet composeInitialPaused$runtime(ControlledComposition arg1, ShouldPauseCallback arg2, Function2 arg3) {
            return LinkComposer.this.parentContext.composeInitialPaused$runtime(arg1, arg2, arg3);
        }

        public void deletedMovableContent$runtime(MovableContentStateReference arg1) {
            LinkComposer.this.parentContext.deletedMovableContent$runtime(arg1);
        }

        public final void dispose() {
            if(!this.composers.isEmpty()) {
                Set v0 = this.inspectionTables;
                if(v0 != null) {
                    Iterator v1 = this.composers.iterator();
                label_7:
                    if(v1.hasNext()) {
                        Object v2 = v1.next();
                        Iterator v3 = v0.iterator();
                        while(true) {
                            if(!v3.hasNext()) {
                                goto label_7;
                            }

                            v3.next().remove(((LinkComposer)v2).getCompositionData());
                        }
                    }
                }

                this.composers.clear();
            }
        }

        public void doneComposing$runtime() {
            --LinkComposer.this.childrenComposing;
        }

        public boolean getCollectingCallByInformation$runtime() {
            return LinkComposer.this.parentContext.getCollectingCallByInformation$runtime();
        }

        public boolean getCollectingParameterInformation$runtime() {
            return this.collectingParameterInformation;
        }

        public boolean getCollectingSourceInformation$runtime() {
            return this.collectingSourceInformation;
        }

        public final Set getComposers() {
            return this.composers;
        }

        public long getCompositeKeyHashCode$runtime() {
            return this.compositeKeyHashCode;
        }

        public Composition getComposition$runtime() {
            return LinkComposer.this.getComposition();
        }

        private final PersistentCompositionLocalMap getCompositionLocalScope() {
            return this.compositionLocalScope$delegate.getValue();
        }

        public PersistentCompositionLocalMap getCompositionLocalScope$runtime() {
            return this.getCompositionLocalScope();
        }

        public CoroutineContext getEffectCoroutineContext() {
            return LinkComposer.this.parentContext.getEffectCoroutineContext();
        }

        public final Set getInspectionTables() {
            return this.inspectionTables;
        }

        public CompositionObserverHolder getObserverHolder$runtime() {
            return this.observerHolder;
        }

        public boolean getStackTraceEnabled$runtime() {
            return LinkComposer.this.parentContext.getStackTraceEnabled$runtime();
        }

        public void insertMovableContent$runtime(MovableContentStateReference arg1) {
            LinkComposer.this.parentContext.insertMovableContent$runtime(arg1);
        }

        public void invalidate$runtime(ControlledComposition arg3) {
            LinkComposer.this.parentContext.invalidate$runtime(LinkComposer.this.getComposition());
            LinkComposer.this.parentContext.invalidate$runtime(arg3);
        }

        public void invalidateScope$runtime(RecomposeScopeImpl arg1) {
            LinkComposer.this.parentContext.invalidateScope$runtime(arg1);
        }

        public void movableContentStateReleased$runtime(MovableContentStateReference arg1, MovableContentState arg2, Applier arg3) {
            LinkComposer.this.parentContext.movableContentStateReleased$runtime(arg1, arg2, arg3);
        }

        public MovableContentState movableContentStateResolve$runtime(MovableContentStateReference arg1) {
            return LinkComposer.this.parentContext.movableContentStateResolve$runtime(arg1);
        }

        public ScatterSet recomposePaused$runtime(ControlledComposition arg1, ShouldPauseCallback arg2, ScatterSet arg3) {
            return LinkComposer.this.parentContext.recomposePaused$runtime(arg1, arg2, arg3);
        }

        public void recordInspectionTable$runtime(Set arg2) {
            HashSet v0_1;
            Set v0 = this.inspectionTables;
            if(v0 == null) {
                v0_1 = new HashSet();
                this.inspectionTables = ((Set)v0_1);
            }

            ((Set)v0_1).add(arg2);
        }

        public void registerComposer$runtime(Composer arg1) {
            super.registerComposer$runtime(arg1);
            this.composers.add(LinkComposerKt.asLinkComposer(arg1));
        }

        public void registerComposition$runtime(ControlledComposition arg1) {
            LinkComposer.this.parentContext.registerComposition$runtime(arg1);
        }

        public void reportPausedScope$runtime(RecomposeScopeImpl arg1) {
            LinkComposer.this.parentContext.reportPausedScope$runtime(arg1);
        }

        public void reportRemovedComposition$runtime(ControlledComposition arg1) {
            LinkComposer.this.parentContext.reportRemovedComposition$runtime(arg1);
        }

        public CancellationHandle scheduleFrameEndCallback(Function0 arg1) {
            return LinkComposer.this.parentContext.scheduleFrameEndCallback(arg1);
        }

        private final void setCompositionLocalScope(PersistentCompositionLocalMap arg1) {
            this.compositionLocalScope$delegate.setValue(arg1);
        }

        public final void setInspectionTables(Set arg1) {
            this.inspectionTables = arg1;
        }

        public void startComposing$runtime() {
            ++LinkComposer.this.childrenComposing;
        }

        public void unregisterComposer$runtime(Composer arg4) {
            Set v0 = this.inspectionTables;
            if(v0 != null) {
                Iterator v0_1 = ((Iterable)v0).iterator();
                while(v0_1.hasNext()) {
                    v0_1.next().remove(LinkComposerKt.asLinkComposer(arg4).getCompositionData());
                }
            }

            TypeIntrinsics.asMutableCollection(this.composers).remove(arg4);
        }

        public void unregisterComposition$runtime(ControlledComposition arg1) {
            LinkComposer.this.parentContext.unregisterComposition$runtime(arg1);
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
    private SlotTableBuilder builder;
    private boolean builderHasAProvider;
    private final ComposerChangeListWriter changeListWriter;
    private Changes changes;
    private int childrenComposing;
    private long compositeKeyHashCode;
    private final CompositionImpl composition;
    private int compositionToken;
    private Changes deferredChanges;
    private final LinkComposer$derivedStateObserver$1 derivedStateObserver;
    private final IntStack entersStack;
    private final CompositionErrorContextImpl errorContext;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private FixupList insertFixups;
    private boolean inserting;
    private final ArrayList invalidateStack;
    private final MutableScatterMap invalidations;
    private boolean isComposing;
    private boolean isDisposed;
    private int lastPlacedChildGroup;
    private Changes lateChanges;
    private MutableIntIntMap nodeCountOverrides;
    private MutableIntIntMap nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parentContext;
    private final IntStack parentStateStack;
    private LinkPending pending;
    private final ArrayList pendingStack;
    private PersistentCompositionLocalMap providerCache;
    private MutableIntObjectMap providerUpdates;
    private boolean providersInvalid;
    private final IntStack providersInvalidStack;
    private int rGroupIndex;
    private SlotTableReader reader;
    private boolean reusing;
    private int reusingGroup;
    private PersistentCompositionLocalMap rootProvider;
    private ShouldPauseCallback shouldPauseCallback;
    private final SlotTable slotTable;
    private boolean sourceMarkersEnabled;

    public static Unit $r8$lambda$8lelPrksnfR3M4v8PO6dwxrDBig(LinkComposer arg0, ChangeList arg1, SlotTableReader arg2, long arg3, MovableContentStateReference arg5) {
        return LinkComposer.insertMovableContentGuarded$lambda$0$0$0$0(arg0, arg1, arg2, arg3, arg5);
    }

    public static Unit $r8$lambda$M18eGercFFfwh-IBCmI38SLLt5Y(LinkComposer arg0, MovableContentStateReference arg1) {
        return LinkComposer.insertMovableContentGuarded$lambda$0$0$1$0$0$0$0$0(arg0, arg1);
    }

    public static Unit $r8$lambda$r-5XeYX1OwAeB0mjGBQs6VhaVXQ(MovableContent arg0, Object arg1, Composer arg2, int arg3) {
        return LinkComposer.invokeMovableContentLambda$lambda$0$0(arg0, arg1, arg2, arg3);
    }

    public static ComposeStackTrace $r8$lambda$rE_x9qrh1q1H6nWEFcp7wup8uKw(LinkComposer arg0) {
        return LinkComposer.doCompose_aFTiNEg$lambda$1$1(arg0);
    }

    static {
    }

    public LinkComposer(Applier arg1, CompositionContext arg2, Set arg3, SlotTable arg4, Changes arg5, Changes arg6, CompositionObserverHolder arg7, CompositionImpl arg8) {
        EmptyCoroutineContext v2_1;
        super();
        this.applier = arg1;
        this.parentContext = arg2;
        this.abandonSet = arg3;
        this.slotTable = arg4;
        this.changes = arg5;
        this.lateChanges = arg6;
        this.observerHolder = arg7;
        this.composition = arg8;
        MutableScatterMap v1 = null;
        this.invalidations = ScopeMap.constructor-impl$default(v1, 1, ((DefaultConstructorMarker)v1));
        this.pendingStack = Stack.constructor-impl$default(((ArrayList)v1), 1, ((DefaultConstructorMarker)v1));
        this.parentStateStack = new IntStack();
        this.entersStack = new IntStack();
        this.rootProvider = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
        this.providersInvalidStack = new IntStack();
        this.reusingGroup = -1;
        SlotTableReader v6 = arg4.openReader();
        v6.close();
        this.reader = v6;
        boolean v7 = false;
        SlotTableBuilder v6_1 = new SlotTableBuilder(arg4.getAddressSpace(), false, false);
        v6_1.close();
        this.builder = v6_1;
        this.changeListWriter = new ComposerChangeListWriter(this, ChangeListKt.asLinkBufferChangeList(this.changes));
        this.lastPlacedChildGroup = -1;
        this.insertFixups = new FixupList();
        if((arg2.getCollectingSourceInformation$runtime()) || (arg2.getCollectingCallByInformation$runtime())) {
            v7 = true;
        }

        this.sourceMarkersEnabled = v7;
        this.derivedStateObserver = new LinkComposer$derivedStateObserver$1(this);
        this.invalidateStack = Stack.constructor-impl$default(((ArrayList)v1), 1, ((DefaultConstructorMarker)v1));
        this.errorContext = new CompositionErrorContextImpl(this);
        CoroutineContext v1_1 = arg2.getEffectCoroutineContext();
        CompositionErrorContextImpl v2 = this.getErrorContext$runtime();
        if(v2 != null) {
        }
        else {
            v2_1 = EmptyCoroutineContext.INSTANCE;
        }

        this.applyCoroutineContext = v1_1.plus(((CoroutineContext)v2_1));
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
        if(!this.reader.isClosed()) {
            this.reader.close();
        }

        this.resetInsertBuilder(false);
    }

    public static final int access$getChildrenComposing$p(LinkComposer arg0) {
        return arg0.childrenComposing;
    }

    public static final CompositionContext access$getParentContext$p(LinkComposer arg0) {
        return arg0.parentContext;
    }

    public static final void access$setChildrenComposing$p(LinkComposer arg0, int arg1) {
        arg0.childrenComposing = arg1;
    }

    private final void addRecomposeScope() {
        if(this.getInserting()) {
            RecomposeScopeImpl v0 = new RecomposeScopeImpl(this.getComposition());
            Stack.push-impl(this.invalidateStack, v0);
            this.updateValue(v0);
            this.enterRecomposeScope(v0);
            return;
        }

        int v0_1 = this.reader.getParentGroup();
        RecomposeScopeImpl v1 = LinkComposerKt.getRecomposeScopeOrNull(this.reader, v0_1);
        Object v1_1 = v1 != null ? ScopeMap.remove-impl(this.invalidations, v1) : null;
        boolean v0_2 = this.reader.recomposeRequired(v0_1);
        if(v0_2) {
            this.reader.removeFlag(0x4000000);
        }

        Object v2 = this.reader.next();
        if(Intrinsics.areEqual(v2, Composer.Companion.getEmpty())) {
            RecomposeScopeImpl v2_1 = new RecomposeScopeImpl(this.getComposition());
            this.updateValue(v2_1);
        }
        else {
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
        }

        if((v0_2) || v1_1 != null) {
        label_49:
            v0_2 = true;
        }
        else {
            v0_2 = ((RecomposeScopeImpl)v2).getForcedRecompose();
            if(v0_2) {
                ((RecomposeScopeImpl)v2).setForcedRecompose(false);
            }

            if(v0_2) {
                goto label_49;
            }

            v0_2 = false;
        }

        ((RecomposeScopeImpl)v2).setRequiresRecompose(v0_2);
        Stack.push-impl(this.invalidateStack, v2);
        this.enterRecomposeScope(((RecomposeScopeImpl)v2));
        if(((RecomposeScopeImpl)v2).getPaused()) {
            ((RecomposeScopeImpl)v2).setPaused(false);
            ((RecomposeScopeImpl)v2).setResuming(true);
            this.changeListWriter.startResumingScope(((RecomposeScopeImpl)v2));
            if(!this.reusing && (((RecomposeScopeImpl)v2).getReusing())) {
                this.reusing = true;
                this.reusingGroup = this.reader.getParentGroup();
                ((RecomposeScopeImpl)v2).setResetReusing(true);
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
        ReusableLinkRememberObserverHolder v0_1;
        LinkComposer v3;
        this.startGroup(206, ComposerKt.getReference());
        if(this.getInserting()) {
            this.builder.addFlags(0x40000000);
        }

        Object v0 = this.nextSlot$runtime();
        if((v0 instanceof ReusableRememberObserverHolder)) {
        }
        else {
            v0 = null;
        }

        if(v0 == null) {
            v3 = this;
            v0_1 = new ReusableLinkRememberObserverHolder(new CompositionContextHolder(new CompositionContextImpl(v3, this.getCompositeKeyHashCode(), this.forceRecomposeScopes, this.getSourceMarkersEnabled$runtime(), this.getComposition().getObserverHolder$runtime())), LinkAnchorKt.getNullAnchor());
            v3.updateValue(v0_1);
        }
        else {
            v3 = this;
        }

        RememberObserver v9 = ((ReusableRememberObserverHolder)v0_1).getWrapped();
        Intrinsics.checkNotNull(v9, "null cannot be cast to non-null type androidx.compose.runtime.LinkComposer.CompositionContextHolder");
        ((CompositionContextHolder)v9).getRef().updateCompositionLocalScope(v3.currentCompositionLocalScope());
        v3.endGroup();
        return ((CompositionContextHolder)v9).getRef();
    }

    public boolean changed(Object arg2) {
        if(!Intrinsics.areEqual(this.nextSlot$runtime(), arg2)) {
            this.updateValue(arg2);
            return 1;
        }

        return 0;
    }

    public boolean changed(byte arg3) {
        Object v0 = this.nextSlot$runtime();
        if(((v0 instanceof Byte)) && arg3 == ((Number)v0).byteValue()) {
            return 0;
        }

        this.updateValue(Byte.valueOf(arg3));
        return 1;
    }

    public boolean changed(char arg3) {
        Object v0 = this.nextSlot$runtime();
        if(((v0 instanceof Character)) && arg3 == ((Character)v0).charValue()) {
            return 0;
        }

        this.updateValue(Character.valueOf(arg3));
        return 1;
    }

    public boolean changed(double arg3) {
        Object v0 = this.nextSlot$runtime();
        if(((v0 instanceof Double)) && (Intrinsics.areEqual(arg3, ((Double)v0)))) {
            return 0;
        }

        this.updateValue(Double.valueOf(arg3));
        return 1;
    }

    public boolean changed(float arg3) {
        Object v0 = this.nextSlot$runtime();
        if(((v0 instanceof Float)) && (Intrinsics.areEqual(arg3, ((Float)v0)))) {
            return 0;
        }

        this.updateValue(Float.valueOf(arg3));
        return 1;
    }

    public boolean changed(int arg3) {
        Object v0 = this.nextSlot$runtime();
        boolean v1 = v0 instanceof Integer;
        if(v1) {
            if(!v1) {
            }
            else if(arg3 == ((Number)v0).intValue()) {
                return 0;
            }
        }

        this.updateValue(Integer.valueOf(arg3));
        return 1;
    }

    public boolean changed(long arg3) {
        Object v0 = this.nextSlot$runtime();
        boolean v1 = v0 instanceof Long;
        if(v1) {
            if(!v1) {
            }
            else if(arg3 == ((Number)v0).longValue()) {
                return 0;
            }
        }

        this.updateValue(Long.valueOf(arg3));
        return 1;
    }

    public boolean changed(short arg3) {
        Object v0 = this.nextSlot$runtime();
        if(((v0 instanceof Short)) && arg3 == ((Number)v0).shortValue()) {
            return 0;
        }

        this.updateValue(Short.valueOf(arg3));
        return 1;
    }

    public boolean changed(boolean arg3) {
        Object v0 = this.nextSlot$runtime();
        if(((v0 instanceof Boolean)) && arg3 == ((Boolean)v0).booleanValue()) {
            return 0;
        }

        this.updateValue(Boolean.valueOf(arg3));
        return 1;
    }

    public boolean changedInstance(Object arg2) {
        if(this.nextSlot$runtime() != arg2) {
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
        this.builder.collectSourceInformation();
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

    public Object consume(CompositionLocal arg1) {
        return CompositionLocalMapKt.read(this.currentCompositionLocalScope(), arg1);
    }

    public void createNode(Function0 arg5) {
        this.validateNodeExpected();
        if(!this.getInserting()) {
            ComposerKt.composeImmediateRuntimeError("createNode() can only be called when inserting");
        }

        int v0 = this.parentStateStack.peek();
        ++this.groupNodeCount;
        long v1 = this.builder.getParentHandle();
        if(this.changeListWriter.isInAnchorMode()) {
            this.insertFixups.createAndInsertNodeByAnchor(arg5, v0, this.builder.getTable().getAddressSpace().anchorOfAddress(GroupHandleKt.getGroup(v1)));
            return;
        }

        this.insertFixups.createAndInsertNode(arg5, v0, this.builder.getParentHandle());
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope() {
        PersistentCompositionLocalMap v0 = this.providerCache;
        if(v0 != null) {
            return v0;
        }

        return this.currentCompositionLocalScope(this.reader.getParentGroup());
    }

    private final PersistentCompositionLocalMap currentCompositionLocalScope(int arg6) {
        Object v0_2;
        Object v6;
        String v1 = "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap";
        int v2 = 202;
        if((this.getInserting()) && (this.builderHasAProvider)) {
            int v0;
            for(v0 = this.builder.getParentGroup(); v0 >= 0; v0 = this.builder.parent(v0)) {
                if(this.builder.groupKey(v0) == v2 && (Intrinsics.areEqual(this.builder.groupObjectKey(v0), ComposerKt.getCompositionLocalMap()))) {
                    v6 = this.builder.groupAux(v0);
                    Intrinsics.checkNotNull(v6, v1);
                    this.providerCache = ((PersistentCompositionLocalMap)v6);
                    return ((PersistentCompositionLocalMap)v6);
                }
            }
        }

        if(!this.reader.isEmpty()) {
            while(arg6 >= 0) {
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

                arg6 = this.reader.parentOf(arg6);
            }
        }

        PersistentCompositionLocalMap v6_1 = this.rootProvider;
        this.providerCache = v6_1;
        return v6_1;
    }

    private final ComposeStackTrace currentStackTrace() {
        if(this.getSourceMarkersEnabled$runtime()) {
            List v0 = CollectionsKt.createListBuilder();
            v0.addAll(SlotTableBuilderKt.buildTrace(this.builder));
            v0.addAll(SlotTableReaderKt.buildTrace(this.reader));
            v0.addAll(this.parentStackTrace$runtime());
            return new ComposeStackTrace(CollectionsKt.build(v0), this.getSourceMarkersEnabled$runtime());
        }

        return null;
    }

    public void deactivate$runtime() {
        Stack.clear-impl(this.invalidateStack);
        ScopeMap.clear-impl(this.invalidations);
        this.changes.clear();
        this.providerUpdates = null;
    }

    public void deactivateToEndGroup(boolean arg2) {
        int v0 = this.groupNodeCount == 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling deactivateToEndGroup");
        }

        if(!this.getInserting()) {
            if(!arg2) {
                this.skipReaderToGroupEnd();
                return;
            }
            else {
                this.changeListWriter.deactivateCurrentGroup();
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
        this.slotTable.dispose();
        this.parentContext.unregisterComposer$runtime(this);
        this.deactivate$runtime();
        this.getApplier().clear();
        this.isDisposed = true;
    }

    private final void doCompose-aFTiNEg(MutableScatterMap arg7, Function2 arg8) {
        MutableVector v5;
        LinkComposer$derivedStateObserver$1 v4;
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
            goto label_91;
        }

        try {
            this.startRoot();
            v3 = this.nextSlot$runtime();
            if((((Function2)v3)) != arg8 && arg8 != null) {
                this.updateValue(arg8);
            }

            v4 = this.derivedStateObserver;
            v5 = SnapshotStateKt.derivedStateObservers();
        }
        catch(Throwable v8) {
            goto label_77;
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
                label_77:
                    throw ComposeStackTraceKt.attachComposeStackTrace(v8, new LinkComposer$$ExternalSyntheticLambda0(this));
                }
                catch(Throwable v8) {
                    if(v0 != null) {
                        try {
                            v0.onEndComposition(this.getComposition());
                        label_85:
                            this.isComposing = false;
                            this.abortRoot();
                            this.resetInsertBuilder(true);
                            throw v8;
                        label_63:
                            v0.onEndComposition(this.getComposition());
                        label_65:
                            this.isComposing = false;
                            this.resetInsertBuilder(false);
                            goto label_68;
                        }
                        catch(Throwable v6) {
                        label_91:
                            Trace.INSTANCE.endSection(v1);
                            throw v6;
                        }
                    }

                    goto label_85;
                }
            }
        }

    label_68:
        Trace.INSTANCE.endSection(v1);
    }

    private static final ComposeStackTrace doCompose_aFTiNEg$lambda$1$1(LinkComposer arg0) {
        return arg0.currentStackTrace();
    }

    public void enableReusing() {
        boolean v0 = this.reusingGroup >= 0 ? true : false;
        this.reusing = v0;
    }

    private final void end(boolean arg23) {
        List v20;
        List v19;
        long v6_1;
        long v3_2;
        Object v3_1;
        Object v7;
        int v6;
        int v3;
        LinkComposer v0 = this;
        int v1 = v0.parentStateStack.peek2() - 1;
        int v4 = 0xCF;
        int v5 = 3;
        if(v0.getInserting()) {
            v3 = v0.builder.getParentGroup();
            v6 = v0.builder.groupKey(v3);
            v7 = v0.builder.groupObjectKey(v3);
            v3_1 = v0.builder.groupAux(v3);
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
            v3 = v0.reader.getParentGroup();
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
        LinkPending v3_3 = v0.pending;
        if(v3_3 != null && !v3_3.getKeyInfos().isEmpty()) {
            List v5_1 = v3_3.getKeyInfos();
            List v6_2 = v3_3.getUsed();
            Set v7_1 = ListUtilsKt.fastToSet(v6_2);
            LinkedHashSet v8 = new LinkedHashSet();
            int v9 = v6_2.size();
            int v10 = v5_1.size();
            int v11 = 0;
            int v12 = 0;
            int v13 = 0;
            while(v11 < v10) {
                Object v14 = v5_1.get(v11);
                if(!v7_1.contains(v14)) {
                    v0.changeListWriter.removeNode(v3_3.nodePositionOf(((KeyInfo)v14)) + v3_3.getStartIndex(), ((KeyInfo)v14).getNodes());
                    v3_3.updateNodeCount(GroupHandleKt.getGroup(((KeyInfo)v14).getHandle()), 0);
                    v0.reader.reposition(((KeyInfo)v14).getHandle());
                    v0.recordDelete();
                    v0.reader.skipGroup();
                }
                else if(((Set)v8).contains(v14)) {
                }
                else {
                    goto label_136;
                }

                ++v11;
                continue;
            label_136:
                if(v12 >= v9) {
                    continue;
                }

                Object v2 = v6_2.get(v12);
                if(v2 != v14) {
                    v4 = v3_3.nodePositionOf(((KeyInfo)v2));
                    ((Set)v8).add(v2);
                    if(v4 != v13) {
                        int v14_1 = v3_3.updatedNodeCountOf(((KeyInfo)v2));
                        v19 = v5_1;
                        v20 = v6_2;
                        v0.changeListWriter.moveNode(v4 + v3_3.getStartIndex(), v13 + v3_3.getStartIndex(), v14_1);
                        v3_3.registerMoveNode(v4, v13, v14_1);
                    }
                    else {
                        v19 = v5_1;
                        v20 = v6_2;
                    }
                }
                else {
                    v19 = v5_1;
                    v20 = v6_2;
                    ++v11;
                }

                ++v12;
                v13 += v3_3.updatedNodeCountOf(((KeyInfo)v2));
                v5_1 = v19;
                v6_2 = v20;
            }

            v0.changeListWriter.endNodeMovement();
            if(v5_1.isEmpty()) {
                goto label_173;
            }

            v0.reader.skipToGroupEnd();
        }

    label_173:
        boolean v2_1 = v0.getInserting();
        if(!v2_1) {
            v3 = v0.nodeIndex;
            v4 = v0.reader.getPreviousSibling();
            SlotTable v5_2 = v0.getReaderTable$runtime();
            v6 = v0.reader.getCurrentGroup();
            int[] v5_3 = v5_2.getAddressSpace().getGroups();
            while(true) {
                int v21 = v6;
                v6 = v4;
                v4 = v21;
                if(v4 < 0) {
                    break;
                }

                v0.reportFreeMovableContent(GroupHandleKt.makeGroupHandle(v0.reader.getParentGroup(), v6, v4));
                v0.changeListWriter.removeNode(v3, v0.reader.nodeCount(v4));
                v0.changeListWriter.endNodeMovement();
                v6 = v5_3[v4 + 1];
            }

            v0.changeListWriter.removeTailGroupsAndValues(v0.reader.getCurrentGroup(), v0.reader.getRemainingSlots());
        }

        if(v2_1) {
            if(arg23) {
                v0.insertFixups.endNodeInsert();
                v1 = 1;
            }

            v0.lastPlacedChildGroup = v0.builder.getParentGroup();
            v0.reader.endEmpty();
            v0.builder.endGroup();
            if(v0.reader.getInEmpty()) {
                goto label_252;
            }

            v3_2 = v0.builder.lastRoot();
            v0.recordInsert(v3_2);
            v0.inserting = false;
            if(v0.getReaderTable$runtime().isEmpty()) {
                goto label_252;
            }

            v3_2 = LinkComposerKt.access$toInsertAddress(v3_2);
            v0.updateChildNodeCount(v3_2, 0);
            v0.updateNodeCountOverrides(v3_2, v1);
        }
        else {
            if(arg23) {
                v0.changeListWriter.moveUp();
            }

            v3_2 = v0.reader.getParentHandle();
            if(v1 != v0.updatedNodeCount(v3_2)) {
                v0.updateNodeCountOverrides(v3_2, v1);
            }

            int v16 = arg23 ? 1 : v1;
            v0.lastPlacedChildGroup = GroupHandleKt.getGroup(v3_2);
            v0.reader.endGroup();
            v0.changeListWriter.endNodeMovement();
            v1 = v16;
        }

    label_252:
        v0.exitGroup(v1, v2_1);
    }

    public void endDefaults() {
        this.endGroup();
        RecomposeScopeImpl v1 = this.getCurrentRecomposeScope$runtime();
        if(v1 != null && (v1.getUsed())) {
            v1.setDefaultsInScope(true);
        }
    }

    private final void endGroup() {
        this.end(false);
    }

    public void endMovableGroup() {
        this.endGroup();
    }

    public void endNode() {
        this.end(true);
    }

    public void endProvider() {
        this.endGroup();
        this.endGroup();
        this.providersInvalid = LinkComposerKt.access$asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    public void endProviders() {
        this.endGroup();
        this.endGroup();
        this.providersInvalid = LinkComposerKt.access$asBool(this.providersInvalidStack.pop());
        this.providerCache = null;
    }

    @ComposeCompilerApi public void endReplaceGroup() {
        this.endGroup();
    }

    public void endReplaceableGroup() {
        this.endGroup();
    }

    public ScopeUpdateScope endRestartGroup() {
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

            if(this.reusingGroup != this.reader.getParentGroup()) {
                goto label_32;
            }

            ((RecomposeScopeImpl)v0).setResetReusing(false);
            this.reusingGroup = -1;
            this.reusing = false;
        }

    label_32:
        if(v0 != null && !((RecomposeScopeImpl)v0).getSkipped$runtime() && ((((RecomposeScopeImpl)v0).getUsed()) || (this.forceRecomposeScopes))) {
            if(((RecomposeScopeImpl)v0).getAnchor() == null) {
                LinkAnchor v1_1 = this.getInserting() ? this.builder.getParentAnchor() : this.reader.getParentAnchor();
                ((RecomposeScopeImpl)v0).setAnchor(((Anchor)v1_1));
            }

            ((RecomposeScopeImpl)v0).setDefaultsInvalid(false);
            v1_2 = v0;
        }

        this.end(false);
        return ((ScopeUpdateScope)v1_2);
    }

    public void endReusableGroup() {
        if((this.reusing) && this.reader.getParentGroup() == this.reusingGroup) {
            this.reusingGroup = -1;
            this.reusing = false;
        }

        this.end(false);
    }

    public void endReuseFromRoot$runtime() {
        int v0 = this.reusingGroup;
        int v1 = 100;
        v0 = v0 < 0 ? v1 : this.reader.groupKey(v0);
        v0 = (this.isComposing$runtime()) || v0 != v1 ? 0 : 1;
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
        this.finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
        this.providersInvalid = LinkComposerKt.access$asBool(this.providersInvalidStack.pop());
    }

    public void endToMarker(int arg8) {
        int[] v1_1;
        SlotTableBuilder v4;
        String v0 = "Traversing parent of group not in the slot table: ";
        DefaultConstructorMarker v1 = null;
        int v2 = 1;
        if(arg8 < 0) {
            arg8 = -arg8;
            v4 = this.builder;
            MutableIntSet v5 = new MutableIntSet(0, 1, v1);
            v1_1 = this.getReaderTable$runtime().getAddressSpace().getGroups();
            int v6;
            for(v6 = arg8; v6 > 0; v6 = v1_1[v6 + 2]) {
                v5.add(v6);
            }

            if(v6 != 0) {
            }
            else {
                v2 = 0;
            }

            if(v2 == 0) {
                ComposerKt.composeImmediateRuntimeError(v0 + arg8);
            }

            while(!v5.contains(v4.getParentGroup())) {
                this.end(v4.isNode());
            }
        }
        else {
            if(this.getInserting()) {
                v4 = this.builder;
                while(this.getInserting()) {
                    this.end(v4.isNode());
                }
            }

            MutableIntSet v4_1 = new MutableIntSet(0, 1, v1);
            v1_1 = this.getReaderTable$runtime().getAddressSpace().getGroups();
            int v5_1;
            for(v5_1 = arg8; v5_1 > 0; v5_1 = v1_1[v5_1 + 2]) {
                v4_1.add(v5_1);
            }

            int v1_2 = v5_1 != 0 ? 1 : 0;
            if(v1_2 == 0) {
                ComposerKt.composeImmediateRuntimeError(v0 + arg8);
            }

            SlotTableReader v8 = this.reader;
            int v0_1;
            for(v0_1 = v8.getParentGroup(); !v4_1.contains(v0_1); v0_1 = v8.getParentGroup()) {
                boolean v0_2 = (v8.flagsOf(v0_1) & 0x800000) == 0x800000 ? true : false;
                this.end(v0_2);
            }
        }
    }

    private final void ensureBuilder() {
        if(this.builder.isClosed()) {
            SlotTableBuilder v0 = new SlotTableBuilder(this.slotTable.getAddressSpace(), this.slotTable.getRecordSourceInformation(), this.slotTable.getRecordCallByInformation());
            this.builder = v0;
            v0.buildStart();
            this.builderHasAProvider = false;
            this.providerCache = null;
        }
    }

    private final void enterGroup(boolean arg3, LinkPending arg4) {
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
        this.lastPlacedChildGroup = -1;
    }

    private final void enterRecomposeScope(RecomposeScopeImpl arg2) {
        arg2.start(this.compositionToken);
        CompositionObserver v1 = this.observerHolder.current();
        if(v1 != null) {
            v1.onScopeEnter(((RecomposeScope)arg2));
        }
    }

    private final void executeChangesImmediatelyWithoutApplier() {
        SlotTableEditor v0 = this.slotTable.openEditor();
        try {
            ChangeListKt.asLinkBufferChangeList(this.changes).executeAndFlushAllPendingChanges(ThrowingApplierStub.INSTANCE, v0, ThrowingRememberManagerStub.INSTANCE, this.getErrorContext$runtime());
        }
        catch(Throwable v4) {
            v0.close();
            throw v4;
        }

        v0.close();
    }

    private final void exitGroup(int arg2, boolean arg3) {
        Object v0 = Stack.pop-impl(this.pendingStack);
        if(v0 != null && !arg3) {
            ((LinkPending)v0).setGroupIndex(((LinkPending)v0).getGroupIndex() + 1);
        }

        this.pending = ((LinkPending)v0);
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

    public static void getApplyCoroutineContext$annotations() {
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
            LinkCompositionDataImpl v0_1 = new LinkCompositionDataImpl(this.getComposition());
            this._compositionData = ((CompositionData)v0_1);
        }

        return v0;
    }

    public CompositionLocalMap getCurrentCompositionLocalMap() {
        return this.currentCompositionLocalScope();
    }

    public int getCurrentMarker() {
        if(this.getInserting()) {
            return -this.builder.getParentGroup();
        }

        return this.reader.getParentGroup();
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

    public Changes getDeferredChanges$runtime() {
        return this.deferredChanges;
    }

    public CompositionErrorContextImpl getErrorContext$runtime() {
        if(this.getSourceMarkersEnabled$runtime()) {
            return this.errorContext;
        }

        return null;
    }

    public boolean getHasPendingChanges$runtime() {
        return this.changes.isNotEmpty();
    }

    public final SlotTable getInsertTable$runtime() {
        return this.builder.getTable();
    }

    public boolean getInserting() {
        return this.inserting;
    }

    public final SlotTableReader getReader$runtime() {
        return this.reader;
    }

    public final SlotTable getReaderTable$runtime() {
        return this.reader.getTable();
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

    public boolean getSourceMarkersEnabled$runtime() {
        return this.sourceMarkersEnabled;
    }

    public void insertMovableContent(MovableContent arg3, Object arg4) {
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        this.invokeMovableContentLambda(arg3, this.currentCompositionLocalScope(), arg4, false);
    }

    private final void insertMovableContentGuarded(List arg31) {
        MovableContentState v10_1;
        List v7_4;
        int v4_4;
        LinkComposer$$ExternalSyntheticLambda2 v6_4;
        MutableIntObjectMap v26_1;
        MovableContentState v21_1;
        ComposerChangeListWriterAddressMode v26;
        ComposerChangeListWriterAddressMode v14_2;
        ComposerChangeListWriterAddressMode v3_6;
        long v24;
        long v22;
        ComposerChangeListWriterAddressMode v2_6;
        ComposerChangeListWriter v7_2;
        ComposerChangeListWriter v21;
        SlotTableReader v0_5;
        ComposerChangeListWriter v12_1;
        int v0_4;
        Object v17_1;
        boolean v8_2;
        ComposerChangeListWriter v5_1;
        MutableIntObjectMap v2_5;
        ChangeList v4_3;
        ComposerChangeListWriter v3_5;
        MutableIntObjectMap v14_1;
        MutableIntIntMap v13_1;
        SlotTableReader v9_1;
        SlotTableReader v8_1;
        List v4_2;
        long v16_1;
        int v3_4;
        SlotTable v2_4;
        MovableContentState v7_1;
        int v18;
        int v19;
        ChangeList v20;
        ComposerChangeListWriter v17;
        List v5;
        ControlledComposition v3_1;
        ControlledComposition v2_2;
        Object v8;
        int v7;
        LinkComposer$$ExternalSyntheticLambda1 v6_1;
        ChangeList v2_1;
        SlotTableReader v16;
        SlotTableReader v3;
        SlotTableReader v4_1;
        IntRef v15;
        long v2;
        long v4;
        Object v6;
        Object v0_2;
        int v14;
        int v13;
        int v12;
        LinkComposer v1 = this;
        List v9 = arg31;
        ComposerChangeListWriter v10 = v1.changeListWriter;
        ChangeList v0 = ChangeListKt.asLinkBufferChangeList(v1.lateChanges);
        ChangeList v11 = v10.getChangeList();
        try {
            v10.setChangeList(v0);
            v1.changeListWriter.resetSlots();
            v12 = v9.size();
            v13 = 0;
            v14 = 0;
        }
        catch(Throwable v0_1) {
            goto label_330;
        }

        while(v14 < v12) {
            try {
                v0_2 = v9.get(v14);
                v6 = ((Pair)v0_2).component1();
                v0_2 = ((Pair)v0_2).component2();
                v4 = 0xFFFFFFFFL;
                v2 = (((long)UInt.constructor-impl(LinkAnchorKt.asLinkAnchor(((MovableContentStateReference)v6).getAnchor$runtime()).getAddress()))) & v4;
                v15 = new IntRef(v13, 1, null);
                v1.changeListWriter.determineMovableContentNodeIndex(v15, v2);
                if(v0_2 == null) {
                }
                else {
                    goto label_77;
                }
            }
            catch(Throwable v0_1) {
                goto label_312;
            }

            try {
                SlotTable v0_3 = SlotTableKt.asLinkBufferSlotTable(((MovableContentStateReference)v6).getSlotStorage$runtime());
                if(Intrinsics.areEqual(v0_3, v1.builder.getTable())) {
                    v1.resetInsertBuilder(((boolean)v13));
                }

                v4_1 = v0_3.openReader();
            }
            catch(Throwable v0_1) {
                goto label_330;
            }

            try {
                v4_1.reposition(v2);
                long v28 = v2;
                v3 = v4_1;
                v4 = v28;
            }
            catch(Throwable v0_1) {
                v16 = ((SlotTableReader)v4);
                goto label_75;
            }

            try {
                v2_1 = new ChangeList();
                v6_1 = new LinkComposer$$ExternalSyntheticLambda1(v1, v2_1, v3, v4, ((MovableContentStateReference)v6));
                v0 = v2_1;
                v16 = v3;
                v7 = 15;
                v8 = null;
                v2_2 = null;
                v3_1 = null;
                v5 = null;
                v1 = this;
            }
            catch(Throwable v0_1) {
                v16 = ((SlotTableReader)v3_1);
                goto label_75;
            }

            try {
                LinkComposer.recomposeMovableContent$default(v1, v2_2, v3_1, 0, v5, ((Function0)v6_1), v7, v8);
                v1.changeListWriter.includeOperationsIn(v0, v15);
                goto label_62;
            }
            catch(Throwable v0_1) {
                try {
                label_75:
                    v16.close();
                    throw v0_1;
                label_62:
                    v16.close();
                    v17 = v10;
                    v20 = v11;
                    v19 = v12;
                    v18 = v14;
                    goto label_209;
                }
                catch(Throwable v0_1) {
                    goto label_330;
                }
            }

            try {
            label_77:
                v7_1 = v1.parentContext.movableContentStateResolve$runtime(((MovableContentStateReference)v0_2));
                if(v7_1 != null) {
                }
                else {
                    goto label_84;
                }
            }
            catch(Throwable v0_1) {
                goto label_312;
            }

            try {
                SlotStorage v2_3 = v7_1.getSlotStorage$runtime();
                if(v2_3 != null) {
                    v2_4 = SlotTableKt.asLinkBufferSlotTable(v2_3);
                    if(v2_4 == null) {
                        goto label_84;
                    }
                }
                else {
                    goto label_84;
                }

                goto label_86;
            }
            catch(Throwable v0_1) {
                goto label_330;
            }

            try {
            label_84:
                v2_4 = SlotTableKt.asLinkBufferSlotTable(((MovableContentStateReference)v0_2).getSlotStorage$runtime());
            }
            catch(Throwable v0_1) {
                goto label_312;
            }

        label_86:
            if(v7_1 != null) {
                try {
                    SlotStorage v3_2 = v7_1.getSlotStorage$runtime();
                    if(v3_2 != null) {
                        SlotTable v3_3 = SlotTableKt.asLinkBufferSlotTable(v3_2);
                        if(v3_3 != null) {
                            v3_4 = v3_3.getRoot();
                        }
                        else {
                            goto label_93;
                        }
                    }
                    else {
                        goto label_93;
                    }

                    goto label_96;
                }
                catch(Throwable v0_1) {
                    goto label_330;
                }
            }
            else {
                try {
                label_93:
                    v3_4 = LinkAnchorKt.asLinkAnchor(((MovableContentStateReference)v0_2).getAnchor$runtime()).getAddress();
                label_96:
                    v16_1 = v4;
                    v4_2 = LinkComposerKt.access$collectNodesFrom(v2_4, v3_4);
                    if(!v4_2.isEmpty()) {
                        goto label_101;
                    }
                    else {
                        goto label_125;
                    }
                }
                catch(Throwable v0_1) {
                    goto label_312;
                }
            }

            goto label_96;
            try {
            label_101:
                v1.changeListWriter.copyNodesToNewAnchorLocation(v4_2, v15);
                if(Intrinsics.areEqual(((MovableContentStateReference)v6).getSlotStorage$runtime(), v1.slotTable)) {
                    v18 = v14;
                    v1.updateChildNodeCount((((long)UInt.constructor-impl(LinkAnchorKt.asLinkAnchor(((MovableContentStateReference)v6).getAnchor$runtime()).getAddress()))) & v16_1, v1.updatedNodeCount((((long)UInt.constructor-impl(LinkAnchorKt.asLinkAnchor(((MovableContentStateReference)v6).getAnchor$runtime()).getAddress()))) & v16_1) + v4_2.size());
                }
                else {
                    goto label_125;
                }

                goto label_126;
            }
            catch(Throwable v0_1) {
                goto label_330;
            }

        label_125:
            v18 = v14;
            try {
            label_126:
                v1.changeListWriter.copySlotTableToAnchorLocation(v7_1, v1.parentContext, ((MovableContentStateReference)v0_2), ((MovableContentStateReference)v6));
                v8_1 = v2_4.openReader();
            }
            catch(Throwable v0_1) {
            label_312:
                v17 = v10;
                v20 = v11;
                goto label_326;
            }

            try {
                v9_1 = v1.reader;
                v13_1 = v1.nodeCountOverrides;
                v14_1 = v1.providerUpdates;
                v1.nodeCountOverrides = null;
                v1.providerUpdates = null;
            }
            catch(Throwable v0_1) {
                v16 = v8_1;
                v17 = v10;
                v20 = v11;
                goto label_309;
            }

            try {
                v1.reader = v8_1;
                v8_1.reposition(v3_4);
                v2_1 = new ChangeList();
                v3_5 = v1.changeListWriter;
                v4_3 = v3_5.getChangeList();
            }
            catch(Throwable v0_1) {
                v16 = v8_1;
                v17 = v10;
                v20 = v11;
                v2_5 = v14_1;
                goto label_299;
            }

            try {
                v3_5.setChangeList(v2_1);
                v5_1 = v1.changeListWriter;
                v16 = v8_1;
            }
            catch(Throwable v0_1) {
                v16 = v8_1;
                goto label_285;
            }

            try {
                v8_2 = v5_1.getImplicitRootStart();
                v17_1 = v0_2;
                goto label_148;
            }
            catch(Throwable v0_1) {
            }

        label_285:
            v17 = v10;
            v20 = v11;
            v2_5 = v14_1;
            v10 = v3_5;
            v11 = v4_3;
            goto label_290;
            try {
            label_148:
                v5_1.setImplicitRootStart(false);
                v0_4 = v12;
                v12_1 = v1.changeListWriter;
                v19 = v0_4;
                v0_5 = v1.reader;
                v20 = v2_1;
                v21 = v3_5;
            }
            catch(Throwable v0_1) {
                v7_2 = v5_1;
                v17 = v10;
                v20 = v11;
                v2_5 = v14_1;
                v10 = v3_5;
                goto label_276;
            }

            try {
                ComposerChangeListWriter.access$setEditorCurrentPosition$p(v12_1, v0_5.handle());
                ComposerChangeListWriterAddressMode v0_6 = ComposerChangeListWriterAddressMode.RelativeAddressing;
                v2_6 = v12_1.getAddressMode$runtime();
                v22 = ComposerChangeListWriter.access$getEditorCurrentPosition$p(v12_1);
                v12_1.setAddressMode$runtime(v0_6);
                v24 = -1;
                goto label_162;
            }
            catch(Throwable v0_1) {
                v7_2 = v5_1;
                v17 = v10;
                v20 = v11;
                v2_5 = v14_1;
                v10 = v21;
            }

        label_276:
            v11 = v4_3;
            goto label_277;
            try {
            label_162:
                ((MovableContentStateReference)v17_1).transferPendingInvalidations$runtime();
                v3_6 = v2_6;
            }
            catch(Throwable v0_1) {
                MutableIntObjectMap v7_3 = v14_1;
                v14_2 = v2_6;
                v2_5 = v7_3;
                v7_2 = v5_1;
                v17 = v10;
                v20 = v11;
                v10 = v21;
                goto label_252;
            }

            try {
                v2_2 = ((MovableContentStateReference)v17_1).getComposition$runtime();
                v26 = v3_6;
            }
            catch(Throwable v0_1) {
                v7_2 = v5_1;
                v17 = v10;
                v20 = v11;
                v2_5 = v14_1;
                v10 = v21;
                v14_2 = v3_6;
                goto label_252;
            }

            try {
                v3_1 = ((MovableContentStateReference)v6).getComposition$runtime();
                v0_4 = v1.reader.getCurrentGroup();
                List v17_2 = ((MovableContentStateReference)v17_1).getInvalidations$runtime();
                int v27 = v0_4;
                LinkComposer$$ExternalSyntheticLambda2 v0_7 = new LinkComposer$$ExternalSyntheticLambda2(v1, ((MovableContentStateReference)v6));
                MovableContentState v6_2 = v7_1;
                v7_2 = v5_1;
                v5 = v17_2;
                v17 = v10;
                v10 = v21;
                v21_1 = v6_2;
                ComposerChangeListWriterAddressMode v6_3 = v26;
                v26_1 = v14_1;
                v14_2 = v6_3;
                v6_4 = v0_7;
                v0 = v20;
                v20 = v11;
                v11 = v4_3;
                v4_4 = v27;
                goto label_187;
            }
            catch(Throwable v0_1) {
                v7_4 = v5;
                v17 = v10;
                v20 = v11;
                v2_6 = v14_2;
                v10_1 = v21_1;
                v14_1 = v26_1;
            }

        label_252:
            v11 = ((ChangeList)v4_4);
            goto label_253;
            try {
            label_187:
                v1.recomposeMovableContent(v2_2, v3_1, v4_4, v5, ((Function0)v6_4));
                goto label_188;
            }
            catch(Throwable v0_1) {
                v2_5 = v26_1;
            }

            try {
            label_253:
                v12_1.setAddressMode$runtime(((ComposerChangeListWriterAddressMode)v14_1));
                long v3_7 = (((ComposerChangeListWriterAddressMode)v14_1)) == ComposerChangeListWriterAddressMode.RelativeAddressing ? v22 : v24;
                ComposerChangeListWriter.access$setEditorCurrentPosition$p(v12_1, v3_7);
                throw v0_1;
            }
            catch(Throwable v0_1) {
                goto label_277;
            }

            try {
            label_188:
                v12_1.setAddressMode$runtime(v14_2);
                v2 = v14_2 == ComposerChangeListWriterAddressMode.RelativeAddressing ? v22 : v24;
                ComposerChangeListWriter.access$setEditorCurrentPosition$p(v12_1, v2);
                goto label_195;
            }
            catch(Throwable v0_1) {
                v2_5 = v26_1;
            }

            try {
            label_277:
                ((ComposerChangeListWriter)v7_4).setImplicitRootStart(v8_2);
                throw v0_1;
            }
            catch(Throwable v0_1) {
                goto label_290;
            }

            try {
            label_195:
                v7_2.setImplicitRootStart(v8_2);
                goto label_196;
            }
            catch(Throwable v0_1) {
                v2_5 = v26_1;
            }

            try {
            label_290:
                ((ComposerChangeListWriter)v10_1).setChangeList(v11);
                throw v0_1;
            }
            catch(Throwable v0_1) {
                goto label_299;
            }

            try {
            label_196:
                v10.setChangeList(v11);
                v1.changeListWriter.includeOperationsIn(v0, v15);
                goto label_200;
            }
            catch(Throwable v0_1) {
                v2_5 = v26_1;
            }

            try {
            label_299:
                v1.reader = v9_1;
                v1.nodeCountOverrides = v13_1;
                v1.providerUpdates = v2_5;
                throw v0_1;
            label_200:
                v1.reader = v9_1;
                v1.nodeCountOverrides = v13_1;
                v1.providerUpdates = v26_1;
                goto label_205;
            }
            catch(Throwable v0_1) {
            }

            try {
            label_309:
                v16.close();
                throw v0_1;
            label_205:
                v16.close();
                v1.changeListWriter.disposeResolvedMovableState(v21_1);
            }
            catch(Throwable v0_1) {
                goto label_326;
            }

        label_209:
            v14 = v18 + 1;
            v9 = arg31;
            v10 = v17;
            v12 = v19;
            v11 = v20;
            v13 = 0;
        }

        try {
            v17 = v10;
            v20 = v11;
            v1.resetInsertBuilder(((boolean)v13));
            v1.changeListWriter.endMovableContentPlacement();
            goto label_321;
        }
        catch(Throwable v0_1) {
        }

    label_326:
        ComposerChangeListWriter v1_1 = v17;
        v2_1 = v20;
        goto label_332;
    label_321:
        v17.setChangeList(v20);
        return;
    label_330:
        v1_1 = v10;
        v2_1 = v11;
    label_332:
        v1_1.setChangeList(v2_1);
        throw v0_1;
    }

    private static final Unit insertMovableContentGuarded$lambda$0$0$0$0(LinkComposer arg16, ChangeList arg17, SlotTableReader arg18, long arg19, MovableContentStateReference arg21) {
        long v11;
        ComposerChangeListWriterAddressMode v10;
        ComposerChangeListWriter v9;
        boolean v8;
        ComposerChangeListWriter v7;
        SlotTableReader v0_2;
        MutableIntObjectMap v6;
        MutableIntIntMap v5;
        SlotTableReader v4;
        LinkComposer v1 = arg16;
        ComposerChangeListWriter v2 = v1.changeListWriter;
        ChangeList v3 = v2.getChangeList();
        ChangeList v0 = arg17;
        try {
            v2.setChangeList(v0);
            v4 = v1.reader;
            v5 = v1.nodeCountOverrides;
            v6 = v1.providerUpdates;
            v1.nodeCountOverrides = null;
            v1.providerUpdates = null;
            v0_2 = arg18;
        }
        catch(Throwable v0_1) {
            goto label_60;
        }

        try {
            v1.reader = v0_2;
            v7 = v1.changeListWriter;
            v8 = v7.getImplicitRootStart();
        }
        catch(Throwable v0_1) {
            goto label_55;
        }

        try {
            v7.setImplicitRootStart(false);
            v9 = v1.changeListWriter;
            ComposerChangeListWriter.access$setEditorCurrentPosition$p(v9, arg19);
            ComposerChangeListWriterAddressMode v0_3 = ComposerChangeListWriterAddressMode.RelativeAddressing;
            v10 = v9.getAddressMode$runtime();
            v11 = ComposerChangeListWriter.access$getEditorCurrentPosition$p(v9);
            v9.setAddressMode$runtime(v0_3);
        }
        catch(Throwable v0_1) {
            goto label_52;
        }

        try {
            v1.invokeMovableContentLambda(arg21.getContent$runtime(), arg21.getLocals$runtime(), arg21.getParameter$runtime(), true);
            goto label_29;
        }
        catch(Throwable v0_1) {
            try {
                v9.setAddressMode$runtime(v10);
                if(v10 == ComposerChangeListWriterAddressMode.RelativeAddressing) {
                }
                else {
                    v11 = -1;
                }

                ComposerChangeListWriter.access$setEditorCurrentPosition$p(v9, v11);
                throw v0_1;
            label_29:
                v9.setAddressMode$runtime(v10);
                if(v10 == ComposerChangeListWriterAddressMode.RelativeAddressing) {
                }
                else {
                    v11 = -1;
                }

                ComposerChangeListWriter.access$setEditorCurrentPosition$p(v9, v11);
                goto label_35;
            }
            catch(Throwable v0_1) {
                try {
                label_52:
                    v7.setImplicitRootStart(v8);
                    throw v0_1;
                label_35:
                    v7.setImplicitRootStart(v8);
                    goto label_37;
                }
                catch(Throwable v0_1) {
                    try {
                    label_55:
                        v1.reader = v4;
                        v1.nodeCountOverrides = v5;
                        v1.providerUpdates = v6;
                        throw v0_1;
                    label_37:
                        v1.reader = v4;
                        v1.nodeCountOverrides = v5;
                        v1.providerUpdates = v6;
                    }
                    catch(Throwable v0_1) {
                    label_60:
                        v2.setChangeList(v3);
                        throw v0_1;
                    }
                }
            }
        }

        v2.setChangeList(v3);
        return Unit.INSTANCE;
    }

    private static final Unit insertMovableContentGuarded$lambda$0$0$1$0$0$0$0$0(LinkComposer arg3, MovableContentStateReference arg4) {
        arg3.invokeMovableContentLambda(arg4.getContent$runtime(), arg4.getLocals$runtime(), arg4.getParameter$runtime(), true);
        return Unit.INSTANCE;
    }

    public void insertMovableContentReferences(List arg1) {
        try {
            this.insertMovableContentGuarded(arg1);
        }
        catch(Throwable v1) {
            this.abortRoot();
            throw v1;
        }

        this.cleanUpCompose();
    }

    private final void invokeMovableContentLambda(MovableContent arg17, PersistentCompositionLocalMap arg18, Object arg19, boolean arg20) {
        long v14;
        ComposerChangeListWriterAddressMode v9;
        long v7;
        ComposerChangeListWriter v2;
        boolean v0_2;
        LinkComposer v1 = this;
        MovableContent v3 = arg17;
        PersistentCompositionLocalMap v0 = arg18;
        Object v4 = arg19;
        v1.startMovableGroup(0x78CC281, v3);
        v1.updateSlot(v4);
        long v11 = v1.getCompositeKeyHashCode();
        long v5 = 0x78CC281;
        PersistentCompositionLocalMap v13 = null;
        try {
            v1.compositeKeyHashCode = v5;
            if(v1.getInserting()) {
                v1.builder.addFlags(0x10000000);
            }

            boolean v5_1 = false;
            if(v1.getInserting()) {
            }
            else if(!Intrinsics.areEqual(v1.reader.getGroupAux(), v0)) {
                v5_1 = true;
            }

            if(v5_1) {
                v1.recordProviderUpdate(v0);
            }

            v1.start-AzEfcrM(202, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.getGroup-9udXigM(), v0);
            v1.providerCache = v13;
            if(!v1.getInserting() || (arg20)) {
                v0_2 = v1.providersInvalid;
                v1.providersInvalid = v5_1;
                v1.changeListWriter.seekTo(v1.reader.handle(), true);
                v2 = v1.changeListWriter;
                v7 = -1;
                ComposerChangeListWriter.access$setEditorCurrentPosition$p(v2, v7);
                ComposerChangeListWriterAddressMode v5_2 = ComposerChangeListWriterAddressMode.AnchorAddressing;
                v9 = v2.getAddressMode$runtime();
                v14 = ComposerChangeListWriter.access$getEditorCurrentPosition$p(v2);
                v2.setAddressMode$runtime(v5_2);
                goto label_70;
            }
            else {
                v1.builderHasAProvider = true;
                v1.parentContext.insertMovableContent$runtime(new MovableContentStateReference(v3, v4, v1.getComposition(), v1.builder.getTable(), v1.builder.getTable().getAddressSpace().anchorOfAddress(v1.builder.parent(v1.builder.getParentGroup())), CollectionsKt.emptyList(), v1.currentCompositionLocalScope(), null));
            }

            goto label_82;
        }
        catch(Throwable v0_1) {
            goto label_95;
        }

        try {
        label_70:
            Expect_jvmKt.invokeComposable(v1, ComposableLambdaKt.composableLambdaInstance(0xB6047699, true, new LinkComposer$$ExternalSyntheticLambda4(v3, v4)));
            goto label_76;
        }
        catch(Throwable v0_1) {
            try {
                v2.setAddressMode$runtime(v9);
                if(v9 == ComposerChangeListWriterAddressMode.RelativeAddressing) {
                    v7 = v14;
                }

                ComposerChangeListWriter.access$setEditorCurrentPosition$p(v2, v7);
                throw v0_1;
            label_76:
                v2.setAddressMode$runtime(v9);
                if(v9 == ComposerChangeListWriterAddressMode.RelativeAddressing) {
                    v7 = v14;
                }

                ComposerChangeListWriter.access$setEditorCurrentPosition$p(v2, v7);
                v1.providersInvalid = v0_2;
            }
            catch(Throwable v0_1) {
                try {
                label_95:
                    throw ComposeStackTraceKt.attachComposeStackTrace(v0_1, new LinkComposer$$ExternalSyntheticLambda5(v1));
                }
                catch(Throwable v0_1) {
                    v1.endGroup();
                    v1.providerCache = v13;
                    v1.compositeKeyHashCode = v11;
                    v1.endMovableGroup();
                    throw v0_1;
                }
            }
        }

    label_82:
        v1.endGroup();
        v1.providerCache = v13;
        v1.compositeKeyHashCode = v11;
        v1.endMovableGroup();
    }

    private static final Unit invokeMovableContentLambda$lambda$0$0(MovableContent arg4, Object arg5, Composer arg6, int arg7) {
        ComposerKt.sourceInformation(arg6, "C2031@81096L18:LinkComposer.kt#9igjgp");
        boolean v0 = (arg7 & 3) != 2 ? true : false;
        if(arg6.shouldExecute(v0, arg7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xB6047699, arg7, -1, "androidx.compose.runtime.LinkComposer.invokeMovableContentLambda.<anonymous>.<anonymous> (LinkComposer.kt:2031)");
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

    static final ComposeStackTrace invokeMovableContentLambda$lambda$1(LinkComposer arg0) {
        return arg0.currentStackTrace();
    }

    public boolean isComposing$runtime() {
        return this.isComposing;
    }

    public final boolean isDisposed$runtime() {
        return this.isDisposed;
    }

    private final boolean isGroupAfterCurrentReaderPosition(long arg5) {
        long v0 = this.reader.handle();
        if(Long.compare(v0, -1) == 0) {
            return 1;
        }

        if(LinkComposerKt.access$firstGroupInTopologicalOrder(this.getReaderTable$runtime(), arg5, v0) == v0) {
            return 1;
        }

        return 0;
    }

    public Object joinKey(Object arg2, Object arg3) {
        JoinedKey v1_1;
        Object v1 = this.getInserting() ? null : this.reader.getGroupObjectKey();
        v1 = LinkComposerKt.access$getKey(v1, arg2, arg3);
        if(v1 == null) {
            v1_1 = new JoinedKey(arg2, arg3);
        }

        return v1_1;
    }

    public final Object nextSlot$runtime() {
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

    public final Object nextSlotForCache$runtime() {
        if(this.getInserting()) {
            this.validateNodeNotExpected();
            return Composer.Companion.getEmpty();
        }

        Object v0 = this.reader.next();
        if((this.reusing) && !(v0 instanceof ReusableRememberObserverHolder)) {
            return Composer.Companion.getEmpty();
        }

        if((v0 instanceof RememberObserverHolder)) {
            this.changeListWriter.updateRememberOrdering(LinkComposerKt.asLinkRememberObserverHolder(v0), this.getReaderTable$runtime().getAddressSpace().anchorOfAddress(this.lastPlacedChildGroup));
        }

        return v0;
    }

    public int parentKey$runtime() {
        if(this.getInserting()) {
            return this.builder.groupKey(this.builder.getParentGroup());
        }

        return this.reader.groupKey(this.reader.getParentGroup());
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

        Integer v3 = LinkComposerKt.findSubcompositionContextGroup(SlotTableKt.asLinkBufferSlotTable(((CompositionImpl)v0).getSlotStorage$runtime()), this.parentContext);
        if(v3 != null) {
            SlotTableReader v1 = SlotTableKt.asLinkBufferSlotTable(((CompositionImpl)v0).getSlotStorage$runtime()).openReader();
            try {
                v3_2 = SlotTableReaderKt.traceForGroup(v1, v3.intValue(), Integer.valueOf(0));
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

    private final int rGroupIndexOf(int arg5) {
        int v0 = this.reader.parentOf(arg5);
        v0 = v0 < 0 ? this.getReaderTable$runtime().getRoot() : this.reader.firstChildOf(v0);
        int[] v1 = this.getReaderTable$runtime().getAddressSpace().getGroups();
        int v2 = 0;
        while(v0 >= 0) {
            if(v0 == arg5) {
            }
            else {
                if(!this.reader.hasObjectKey(v0)) {
                    ++v2;
                }

                v0 = v1[v0 + 1];
                continue;
            }

            return v2;
        }

        return v2;
    }

    public boolean recompose-aFTiNEg$runtime(MutableScatterMap arg2, ShouldPauseCallback arg3) {
        if(!this.changes.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }

        if(ScopeMap.getSize-impl(arg2) <= 0) {
            if(!ScopeMap.isNotEmpty-impl(this.invalidations)) {
                if(this.slotTable.getRoot() >= 0 && (this.requiresRecomposition(this.slotTable.getRoot()))) {
                    goto label_19;
                }

                if(!this.forciblyRecompose) {
                    return 0;
                }
            }
            else {
            }

            goto label_19;
        }
        else {
        label_19:
            this.shouldPauseCallback = arg3;
            Function2 v3 = null;
            try {
                this.changeListWriter.startComposition();
                this.doCompose-aFTiNEg(arg2, v3);
            }
            catch(Throwable v2) {
                this.shouldPauseCallback = ((ShouldPauseCallback)v3);
                throw v2;
            }

            this.shouldPauseCallback = ((ShouldPauseCallback)v3);
            if(ChangeListKt.asLinkBufferChangeList(this.changes).hasChangesRequiringApplication()) {
                return 1;
            }

            if(!this.changes.isNotEmpty()) {
                return 0;
            }

            this.executeChangesImmediatelyWithoutApplier();
        }

        return 0;
    }

    private final Object recomposeMovableContent(ControlledComposition arg7, ControlledComposition arg8, int arg9, List arg10, Function0 arg11) {
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
                v7_1 = arg7.delegateInvalidations(arg8, arg9, arg11);
                if(v7_1 == null) {
                    goto label_22;
                }
            }
            else {
            label_22:
                v7_1 = arg11.invoke();
            }
        }
        catch(Throwable v7) {
            goto label_27;
        }

        this.isComposing = v0;
        this.nodeIndex = v1;
        return v7_1;
    label_27:
        this.isComposing = v0;
        this.nodeIndex = v1;
        throw v7;
    }

    static Object recomposeMovableContent$default(LinkComposer arg1, ControlledComposition arg2, ControlledComposition arg3, int arg4, List arg5, Function0 arg6, int arg7, Object arg8) {
        ControlledComposition v0 = null;
        if((arg7 & 1) != 0) {
            arg2 = v0;
        }

        if((arg7 & 2) != 0) {
            arg3 = v0;
        }

        if((arg7 & 4) != 0) {
            arg4 = -1;
        }

        if((arg7 & 8) != 0) {
            arg5 = CollectionsKt.emptyList();
        }

        return arg1.recomposeMovableContent(arg2, arg3, arg4, arg5, arg6);
    }

    private final void recomposeToGroupEnd() {
        long v11_1;
        Object v14;
        int v11;
        int v24;
        int v23;
        long v17;
        int v16;
        LinkComposer v0 = this;
        boolean v1 = v0.isComposing$runtime();
        int v2 = 1;
        v0.isComposing = true;
        SlotTableReader v3 = v0.reader;
        int v4 = v3.getParentGroup();
        int v5 = v0.nodeIndex;
        long v6 = v0.getCompositeKeyHashCode();
        int v8 = v0.groupNodeCount;
        int v9 = v0.rGroupIndex;
        int v10 = v3.firstChildOf(v4);
        int v12;
        for(v12 = 0; true; v12 = v24) {
            int v15 = -1;
            if(v10 == v15) {
                break;
            }

            if(v3.recomposeRequired(v10)) {
                v3.reposition(v10);
                v16 = v2;
                RecomposeScopeImpl v2_1 = v0.requireRecomposeScope(v10);
                v17 = 0xFFFFFFFFL;
                if(v2_1.isInvalidFor(ScopeMap.get-impl(v0.invalidations, v2_1))) {
                    v0.providerCache = null;
                    v0.rGroupIndexOf(v10);
                    v2_1.compose(v0);
                    v0.providerCache = null;
                    v2 = v16;
                    v12 = v2;
                }
                else {
                    Stack.push-impl(v0.invalidateStack, v2_1);
                    CompositionObserver v13 = v0.observerHolder.current();
                    if(v13 != null) {
                        try {
                            v13.onScopeEnter(v2_1);
                            v2_1.rereadTrackedInstances();
                        }
                        catch(Throwable v0_1) {
                            v13.onScopeExit(((RecomposeScope)v2_1));
                            throw v0_1;
                        }

                        v13.onScopeExit(((RecomposeScope)v2_1));
                    }
                    else {
                        v2_1.rereadTrackedInstances();
                    }

                    Stack.pop-impl(v0.invalidateStack);
                    goto label_52;
                }
            }
            else {
                v16 = v2;
                v17 = 0xFFFFFFFFL;
            label_52:
                v2 = 0;
            }

            int v13_1 = v3.firstChildOf(v10);
            if(v2 != 0 || v13_1 == v15) {
                v23 = v2;
                v24 = v12;
                v11 = v15;
            label_163:
                if(v13_1 == v11 && v23 == 0) {
                    v11 = v0.nodeIndex;
                    v12 = v3.isNode(v10) ? v16 : v0.updatedNodeCount((((long)UInt.constructor-impl(v10))) & v17);
                    v0.nodeIndex = v11 + v12;
                    if(v3.hasObjectKey(v10)) {
                        goto label_181;
                    }

                    ++v0.rGroupIndex;
                }

            label_181:
                v11 = v10;
                v10 = v3.nextSiblingOf(v10);
                while(true) {
                    v12 = -1;
                    if(v10 != v12) {
                        goto label_266;
                    }

                    v11 = v3.parentOf(v11);
                    if(v11 != v12) {
                        if(v11 == v4) {
                        }
                        else {
                            if(v3.isNode(v11)) {
                                v0.changeListWriter.moveUp();
                            }

                            v0.rGroupIndex = v0.parentStateStack.pop();
                            v0.nodeIndex = v0.parentStateStack.pop() + v0.updatedNodeCount((((long)UInt.constructor-impl(v11))) & v17);
                            v10 = v3.groupKey(v11);
                            v13_1 = v0.rGroupIndex;
                            v14 = v3.groupObjectKey(v11);
                            Object v15_1 = v3.groupAux(v11);
                            if(v14 == null) {
                                int v14_1 = 0xCF;
                                if(v15_1 != null && v10 == v14_1 && !Intrinsics.areEqual(v15_1, Composer.Companion.getEmpty())) {
                                    v0.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(v0.getCompositeKeyHashCode() ^ (((long)v13_1)), 3) ^ (((long)v15_1.hashCode())), 3);
                                    goto label_256;
                                }

                                v0.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(v0.getCompositeKeyHashCode() ^ (((long)v13_1)), 3) ^ (((long)v10)), 3);
                            }
                            else {
                                v15 = 3;
                                v2 = (v14 instanceof Enum) ? ((Enum)v14).ordinal() : v14.hashCode();
                                v0.compositeKeyHashCode = Long.rotateRight(Long.rotateRight(v0.getCompositeKeyHashCode(), v15) ^ (((long)v2)), v15);
                            }

                        label_256:
                            if(!v3.hasObjectKey(v11)) {
                                ++v0.rGroupIndex;
                            }

                            v10 = v3.nextSiblingOf(v11);
                            continue;
                        }
                    }

                    break;
                }

                v12 = v24;
                goto label_270;
            }
            else {
                boolean v20 = v3.hasRecomposeRequired(v10);
                if(v20) {
                    if((v3.groupObjectKey(v10) instanceof MovableContent)) {
                        v0.compositeKeyHashCode = 0x78CC281;
                        v23 = v2;
                        v24 = v12;
                    }
                    else {
                        v15 = v12;
                        v11 = v3.groupKey(v10);
                        v12 = v0.rGroupIndex;
                        v14 = v3.groupObjectKey(v10);
                        v23 = v2;
                        Object v2_2 = v3.groupAux(v10);
                        if(v14 == null) {
                            if(v2_2 != null && v11 == 0xCF && !Intrinsics.areEqual(v2_2, Composer.Companion.getEmpty())) {
                                v24 = v15;
                                v0.compositeKeyHashCode = (((long)v12)) ^ Long.rotateLeft(Long.rotateLeft(v0.getCompositeKeyHashCode(), 3) ^ (((long)v2_2.hashCode())), 3);
                                goto label_118;
                            }

                            v24 = v15;
                            v11_1 = (((long)v12)) ^ Long.rotateLeft(Long.rotateLeft(v0.getCompositeKeyHashCode(), 3) ^ (((long)v11)), 3);
                        }
                        else {
                            v24 = v15;
                            v2 = 3;
                            v11 = (v14 instanceof Enum) ? ((Enum)v14).ordinal() : v14.hashCode();
                            v11_1 = Long.rotateLeft((((long)v11)) ^ Long.rotateLeft(v0.getCompositeKeyHashCode(), v2), v2);
                        }

                        v0.compositeKeyHashCode = v11_1;
                    }

                label_118:
                    v0.parentStateStack.push(v0.nodeIndex);
                    v0.parentStateStack.push(v0.rGroupIndex);
                    if(v3.isNode(v10)) {
                        v0.changeListWriter.moveDown(v3.node(v10));
                        v2 = 0;
                        v0.nodeIndex = 0;
                    }
                    else {
                        v2 = 0;
                    }

                    v0.rGroupIndex = v2;
                }
                else {
                    v23 = v2;
                    v24 = v12;
                    v11 = v0.nodeIndex;
                    v12 = v3.isNode(v10) ? v16 : v0.updatedNodeCount((((long)UInt.constructor-impl(v10))) & v17);
                    v0.nodeIndex = v11 + v12;
                    if(v3.hasObjectKey(v10)) {
                        goto label_154;
                    }

                    ++v0.rGroupIndex;
                }

            label_154:
                if(v20) {
                    v10 = v13_1;
                    goto label_266;
                }

                v11 = -1;
                goto label_163;
            }

        label_266:
            v2 = v16;
        }

        v17 = 0xFFFFFFFFL;
    label_270:
        v3.restoreParent(v4);
        if(v12 != 0) {
            v3.skipToGroupEnd();
            v2 = v0.updatedNodeCount((((long)UInt.constructor-impl(v4))) & v17);
            v0.nodeIndex = v5 + v2;
            v0.groupNodeCount = v8 + v2;
            v0.rGroupIndex = v9;
        }
        else {
            v0.skipReaderToGroupEnd();
        }

        v0.compositeKeyHashCode = v6;
        v0.isComposing = v1;
    }

    private final void recordDelete() {
        this.reportFreeMovableContent(this.reader.handle());
        this.changeListWriter.removeGroup();
    }

    private final void recordInsert(long arg4) {
        boolean v0 = this.insertFixups.isEmpty();
        ComposerChangeListWriter v1 = this.changeListWriter;
        if(v0) {
            v1.insertSlots(this.builder.getTable(), arg4);
            return;
        }

        v1.insertSlots(this.builder.getTable(), arg4, this.insertFixups);
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

    public Object rememberedValue() {
        return this.unwrapRememberObserverHolder(this.nextSlotForCache$runtime());
    }

    private final void reportAllMovableContent() {
        ChangeList v3;
        ComposerChangeListWriter v2;
        if(this.slotTable.containsFlags(0x20000000)) {
            this.getComposition().updateMovingInvalidations$runtime();
            ChangeList v0 = new ChangeList();
            this.setDeferredChanges$runtime(v0);
            SlotTableReader v1 = this.slotTable.openReader();
            try {
                this.reader = v1;
                v2 = this.changeListWriter;
                v3 = v2.getChangeList();
            }
            catch(Throwable v6) {
                goto label_26;
            }

            try {
                v2.setChangeList(v0);
                this.reportFreeMovableContent(v1.rootHandle());
                goto label_18;
            }
            catch(Throwable v6) {
                try {
                    v2.setChangeList(v3);
                    throw v6;
                label_18:
                    v2.setChangeList(v3);
                }
                catch(Throwable v6) {
                label_26:
                    v1.close();
                    throw v6;
                }
            }

            v1.close();
            return;
        }
    }

    private final void reportFreeMovableContent(long arg6) {
        int v0 = GroupHandleKt.getGroup(arg6);
        boolean v1 = (this.reader.flagsOf(v0) & 0x800000) == 0x800000 ? true : false;
        if(v1) {
            this.changeListWriter.endNodeMovement();
            this.changeListWriter.moveDown(this.reader.node(v0));
        }

        LinkComposer.reportFreeMovableContent$reportGroup(this, arg6, v1, 0);
        this.changeListWriter.endNodeMovement();
        if(v1) {
            this.changeListWriter.moveUp();
        }
    }

    private static final MovableContentStateReference reportFreeMovableContent$createMovableContentReferenceForGroup(LinkComposer arg11, int arg12, List arg13) {
        Object v0 = arg11.reader.groupObjectKey(arg12);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        return new MovableContentStateReference(v0, arg11.reader.get(arg12, 0), arg11.getComposition(), arg11.getReaderTable$runtime(), arg11.getReaderTable$runtime().getAddressSpace().anchorOfAddress(arg12), LinkComposerKt.findInvalidations-Vpaz1Sg(arg11.reader, arg12, arg11.invalidations), arg11.currentCompositionLocalScope(arg12), arg13);
    }

    private static final MovableContentStateReference reportFreeMovableContent$movableContentReferenceFor(LinkComposer arg9, int arg10) {
        int v6_1;
        int v0 = arg9.reader.flagsOf(arg10);
        int v1 = 0x10000000;
        List v3 = null;
        if((v0 & v1) == v1) {
            int v2 = 0x20000000;
            if((v0 & v2) == v2) {
                List v0_1 = CollectionsKt.createListBuilder();
                SlotTableReader v3_1 = arg9.reader;
                int v4 = v3_1.firstChildOf(arg10);
                while(true) {
                label_12:
                    int v5 = -1;
                    if(v4 != v5) {
                        if((arg9.reader.flagsOf(v4) & v1) == v1) {
                            MovableContentStateReference v6 = LinkComposer.reportFreeMovableContent$movableContentReferenceFor(arg9, v4);
                            if(v6 != null) {
                                v0_1.add(v6);
                            }

                            v6_1 = 1;
                        }
                        else {
                            v6_1 = 0;
                        }

                        int v7 = v3_1.firstChildOf(v4);
                        if(v6_1 == 0 && v7 != v5 && (arg9.reader.flagsOf(v4) & v2) == v2) {
                            v4 = v7;
                            continue;
                        }

                        break;
                    }

                    goto label_44;
                }

                v6_1 = v4;
                for(v4 = v3_1.nextSiblingOf(v4); true; v4 = v3_1.nextSiblingOf(v6_1)) {
                    if(v4 != v5) {
                        goto label_12;
                    }

                    v6_1 = v3_1.parentOf(v6_1);
                    if(v6_1 == v5) {
                        break;
                    }

                    if(v6_1 == arg10) {
                        break;
                    }
                }

            label_44:
                v3 = CollectionsKt.build(v0_1);
            }

            return LinkComposer.reportFreeMovableContent$createMovableContentReferenceForGroup(arg9, arg10, v3);
        }

        return ((MovableContentStateReference)v3);
    }

    private static final int reportFreeMovableContent$reportGroup(LinkComposer arg16, long arg17, boolean arg19, int arg20) {
        int v0_1;
        LinkComposer v0 = arg16;
        int v1 = arg20;
        int v2 = GroupHandleKt.getGroup(arg17);
        int v3 = 0;
        if(v2 < 0) {
            return 0;
        }

        int v4 = v0.reader.flagsOf(v2);
        int v7 = 0x7FFFFF;
        int v8 = 0x800000;
        if((v4 & 0x10000000) == 0x10000000) {
            MovableContentStateReference v5 = LinkComposer.reportFreeMovableContent$movableContentReferenceFor(v0, v2);
            if(v5 != null) {
                v0.parentContext.deletedMovableContent$runtime(v5);
                v0.changeListWriter.releaseMovableGroup(v0.getComposition(), v0.parentContext, v5);
            }

            if(arg19) {
                v0.changeListWriter.endNodeMovementAndDeleteNode(v1, v2);
                goto label_138;
            }

            v0_1 = v0.reader.flagsOf(v2);
            if((v0_1 & v8) != v8) {
                goto label_32;
            }

            goto label_30;
        }
        else {
            if((v4 & 0x40000000) == 0x40000000) {
                Object v1_1 = v0.reader.get(v2, 0);
                RememberObserver v5_1 = null;
                if((v1_1 instanceof RememberObserverHolder)) {
                }
                else {
                    v1_1 = v5_1;
                }

                RememberObserver v1_2 = v1_1 != null ? ((RememberObserverHolder)v1_1).getWrapped() : v5_1;
                if((v1_2 instanceof CompositionContextHolder)) {
                    v5_1 = v1_2;
                }

                if(v5_1 != null) {
                    Iterator v1_3 = ((CompositionContextHolder)v5_1).getRef().getComposers().iterator();
                    while(v1_3.hasNext()) {
                        Object v3_1 = v1_3.next();
                        ((LinkComposer)v3_1).reportAllMovableContent();
                        v0.parentContext.reportRemovedComposition$runtime(((LinkComposer)v3_1).getComposition());
                    }
                }

                v0_1 = v0.reader.flagsOf(v2);
                if((v0_1 & v8) != v8) {
                    goto label_32;
                }

                goto label_30;
            }

            if((v4 & 0x20000000) == 0x20000000) {
            }
            else {
                if((v4 & 0x80000000) == 0x80000000) {
                    goto label_76;
                }

                goto label_133;
            }

        label_76:
            SlotTableReader v5_2 = v0.reader;
            long v10 = 0xFFFFFFFFL;
            long v6 = (((long)UInt.constructor-impl(v5_2.firstChildOf(v2)))) & v10 | -4294967296L;
            v2 = 0;
            while(GroupHandleKt.getGroup(v6) != -1) {
                int v12 = GroupHandleKt.getGroup(v6);
                int v13 = (v0.reader.flagsOf(v12) & v8) == v8 ? 1 : 0;
                if(v13 != 0) {
                    v0.changeListWriter.endNodeMovement();
                    v0.changeListWriter.moveDown(v0.reader.node(v12));
                }

                boolean v12_1 = v13 != 0 || (arg19) ? true : false;
                int v14 = v13 != 0 ? 0 : v1 + v2;
                v2 += LinkComposer.reportFreeMovableContent$reportGroup(v0, v6, v12_1, v14);
                if(v13 != 0) {
                    v0.changeListWriter.endNodeMovement();
                    v0.changeListWriter.moveUp();
                }

                v6 = (((long)UInt.constructor-impl(v5_2.nextSiblingOf(GroupHandleKt.getGroup(v6))))) & v10 | (((long)GroupHandleKt.getGroup(v6))) << 0x20;
            }

            v3 = v2;
            goto label_138;
        label_133:
            v0_1 = v0.reader.flagsOf(v2);
            if((v0_1 & v8) == v8) {
            label_30:
                v3 = 1;
                goto label_138;
            }

        label_32:
            v3 = v0_1 & v7;
        }

    label_138:
        if((v4 & v8) == v8) {
            return 1;
        }

        return v3;
    }

    private final RecomposeScopeImpl requireRecomposeScope(int arg2) {
        Object v1 = this.reader.get(arg2, 0);
        if(Intrinsics.areEqual(v1, Composer.Companion.getEmpty())) {
            ComposerKt.composeImmediateRuntimeError("Cannot obtain RecomposeScope. Group does not have a corresponding slot.");
        }

        if(!(v1 instanceof RecomposeScopeImpl)) {
            ComposerKt.composeImmediateRuntimeError("Expected a RecomposeScope in the first non-utility slot, found " + v1 + '.');
        }

        return ((RecomposeScopeImpl)v1);
    }

    private final boolean requiresRecomposition(int arg1) {
        return this.reader.hasRecomposeRequired(arg1);
    }

    private final void resetInsertBuilder(boolean arg3) {
        if(!this.builder.isClosed()) {
            SlotTable v0 = this.builder.build();
            if(arg3) {
                v0.dispose();
            }
        }

        SlotTableBuilder v3 = new SlotTableBuilder(this.slotTable.getAddressSpace(), false, false);
        v3.close();
        this.builder = v3;
    }

    public CancellationHandle scheduleFrameEndCallback(Function0 arg1) {
        return this.parentContext.scheduleFrameEndCallback(arg1);
    }

    public void setDeferredChanges$runtime(Changes arg1) {
        this.deferredChanges = arg1;
    }

    public final void setReader$runtime(SlotTableReader arg1) {
        this.reader = arg1;
    }

    public void setSourceMarkersEnabled$runtime(boolean arg1) {
        this.sourceMarkersEnabled = arg1;
    }

    public boolean shouldExecute(boolean arg3, int arg4) {
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
        if(!this.requiresRecomposition(this.reader.getCurrentGroup())) {
            this.skipGroup();
            return;
        }

        SlotTableReader v0 = this.reader;
        int v1 = v0.getGroupKey();
        Object v2 = v0.getGroupObjectKey();
        Object v3 = v0.getGroupAux();
        int v4 = this.rGroupIndex;
        int v5 = 0xCF;
        int v6 = 3;
        if(v2 == null) {
            if(v3 != null && v1 == v5 && !Intrinsics.areEqual(v3, Composer.Companion.getEmpty())) {
                this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), v6) ^ (((long)v3.hashCode())), v6) ^ (((long)v4));
                goto label_50;
            }

            v7 = Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), v6) ^ (((long)v1)), v6) ^ (((long)v4));
            goto label_49;
        }
        else {
            int v7_1 = (v2 instanceof Enum) ? v2.ordinal() : v2.hashCode();
            v7 = Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), v6) ^ (((long)v7_1)), v6);
        label_49:
            this.compositeKeyHashCode = v7;
        }

    label_50:
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
        this.groupNodeCount = this.reader.getParentNodeCount();
        this.reader.skipToGroupEnd();
    }

    public void skipToGroupEnd() {
        int v0 = this.groupNodeCount == 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling skipAndEndGroup");
        }

        if(!this.getInserting()) {
            RecomposeScopeImpl v0_1 = this.getCurrentRecomposeScope$runtime();
            if(v0_1 != null) {
                v0_1.scopeSkipped();
            }

            if(this.reader.getCurrentGroup() >= 0) {
                if(!this.requiresRecomposition(this.reader.getParentGroup())) {
                }
                else {
                    this.recomposeToGroupEnd();
                    return;
                }
            }

            this.skipReaderToGroupEnd();
        }
    }

    public void sourceInformation(String arg2) {
        if((this.getInserting()) && (this.getSourceMarkersEnabled$runtime())) {
            this.builder.recordGroupSourceInformation(arg2);
        }
    }

    public void sourceInformationMarkerEnd() {
        if((this.getInserting()) && (this.getSourceMarkersEnabled$runtime())) {
            this.builder.recordGrouplessCallSourceInformationEnd();
        }
    }

    public void sourceInformationMarkerStart(int arg2, String arg3) {
        if((this.getInserting()) && (this.getSourceMarkersEnabled$runtime())) {
            this.builder.recordGrouplessCallSourceInformationStart(arg2, arg3);
        }
    }

    private final List stackTraceForGroup(int arg2, Integer arg3) {
        List v2_1;
        if(!this.getSourceMarkersEnabled$runtime()) {
            return CollectionsKt.emptyList();
        }

        SlotTableReader v1 = this.slotTable.openReader();
        try {
            v2_1 = SlotTableReaderKt.traceForGroup(v1, arg2, arg3);
        }
        catch(Throwable v2) {
            v1.close();
            throw v2;
        }

        v1.close();
        return v2_1;
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

            if(v1 == arg2) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    public ComposeStackTrace stackTraceForValue$runtime(Object arg3) {
        List v3_1;
        if(!this.getSourceMarkersEnabled$runtime()) {
            return new ComposeStackTrace(CollectionsKt.emptyList(), false);
        }

        ObjectLocation v3 = SlotTableKt.findLocation(this.slotTable, new LinkComposer$$ExternalSyntheticLambda3(arg3));
        if(v3 != null) {
            v3_1 = CollectionsKt.plus(this.stackTraceForGroup(v3.component1(), v3.component2()), this.parentStackTrace$runtime());
            if(v3_1 != null) {
            }
            else {
                goto label_19;
            }
        }
        else {
        label_19:
            v3_1 = CollectionsKt.emptyList();
        }

        return new ComposeStackTrace(v3_1, this.getSourceMarkersEnabled$runtime());
    }

    public int stacksSize$runtime() {
        return this.entersStack.tos + Stack.getSize-impl(this.invalidateStack) + this.providersInvalidStack.tos + Stack.getSize-impl(this.pendingStack) + this.parentStateStack.tos;
    }

    private final void start-AzEfcrM(int arg18, Object arg19, int arg20, Object arg21) {
        int v16;
        int v1_3;
        KeyInfo v1_2;
        LinkPending v8;
        Object v4_1;
        SlotTableBuilder v1_1;
        Object v6_2;
        long v6_1;
        LinkComposer v0 = this;
        int v2 = arg18;
        Object v1 = arg19;
        int v3 = arg20;
        Object v5 = arg21;
        v0.validateNodeNotExpected();
        int v4 = v0.rGroupIndex;
        int v6 = 3;
        if(v1 == null) {
            if(v5 != null && v2 == 0xCF && !Intrinsics.areEqual(v5, Composer.Companion.getEmpty())) {
                v0.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(v0.getCompositeKeyHashCode(), v6) ^ (((long)v5.hashCode())), v6) ^ (((long)v4));
                goto label_46;
            }

            v6_1 = Long.rotateLeft(Long.rotateLeft(v0.getCompositeKeyHashCode(), v6) ^ (((long)v2)), v6) ^ (((long)v4));
            goto label_45;
        }
        else {
            v4 = (v1 instanceof Enum) ? v1.ordinal() : v1.hashCode();
            v6_1 = Long.rotateLeft(Long.rotateLeft(v0.getCompositeKeyHashCode(), v6) ^ (((long)v4)), v6);
        label_45:
            v0.compositeKeyHashCode = v6_1;
        }

    label_46:
        if(v1 == null) {
            ++v0.rGroupIndex;
        }

        boolean v9 = v3 != GroupKind.Companion.getGroup-9udXigM() ? true : false;
        int v7 = -1;
        int v10 = 0x2000000;
        int v11 = 0x3000000;
        int v12 = 0x1000000;
        int v13 = 0x800000;
        int v14 = 0x1800000;
        LinkPending v15 = null;
        if(v0.getInserting()) {
            v0.reader.beginEmpty();
            v6_2 = v1;
            v1_1 = v0.builder;
            if(v9) {
                v4_1 = Composer.Companion.getEmpty();
                v6_2 = Composer.Companion.getEmpty();
                v3 = v4_1 == Composer.Companion.getEmpty() ? v13 : v14;
                SlotTableBuilder.access$startNewGroup(v1_1, v2, v3, v4_1, null, v6_2);
            }
            else {
                if(v5 != null) {
                    v4_1 = v6_2 == null ? Composer.Companion.getEmpty() : v6_2;
                    v3 = v4_1 == Composer.Companion.getEmpty() ? v10 : v11;
                    SlotTableBuilder.access$startNewGroup(v1_1, arg18, v3, v4_1, v5, null);
                    goto label_117;
                }

                v4_1 = v6_2 == null ? Composer.Companion.getEmpty() : v6_2;
                v3 = v4_1 == Composer.Companion.getEmpty() ? 0 : v12;
                SlotTableBuilder.access$startNewGroup(v1_1, arg18, v3, v4_1, null, null);
            }

        label_117:
            v8 = v0.pending;
            if(v8 != null) {
                v1_2 = new KeyInfo(arg18, Integer.valueOf(v7), LinkComposerKt.access$toInsertAddress(v1_1.getParentHandle()), -1, 0);
                v8.registerInsert(v1_2, v0.nodeIndex - v8.getStartIndex());
                v8.recordUsed(v1_2);
            }

            v0.enterGroup(v9, v15);
            return;
        }

        v6_2 = v1;
        if(v3 != GroupKind.Companion.getNode-9udXigM()) {
            goto label_144;
        }
        else if(v0.reusing) {
            v1_3 = 1;
        }
        else {
        label_144:
            v1_3 = 0;
        }

        if(v0.pending == null) {
            v3 = v0.reader.getGroupKey();
            if(v1_3 == 0 && v3 == v2 && (Intrinsics.areEqual(v6_2, v0.reader.getGroupObjectKey()))) {
                v0.startReaderGroup(v9, v5);
                goto label_165;
            }

            v16 = v7;
            v0.pending = new LinkPending(v0.reader.extractKeys(), v0.nodeIndex);
        }
        else {
        label_165:
            v16 = v7;
        }

        v8 = v0.pending;
        if(v8 != null) {
            KeyInfo v3_1 = v8.getNext(v2, v6_2);
            if(v1_3 == 0 && v3_1 != null) {
                v8.recordUsed(v3_1);
                long v1_4 = v3_1.getHandle();
                v0.nodeIndex = v8.nodePositionOf(v3_1) + v8.getStartIndex();
                v4 = v8.slotPositionOf(v3_1);
                v6 = v4 - v8.getGroupIndex();
                v8.registerMoveSlot(v4, v8.getGroupIndex());
                if(v6 > 0) {
                    v0.reader.reposition(v8.groupHandleOfNextUnmovedGroup());
                    v0.changeListWriter.moveGroup(v6);
                }

                v8.markGroupLocationReconciled(v3_1.getIndex());
                v0.reader.reposition(v1_4);
                v0.startReaderGroup(v9, v5);
                goto label_270;
            }

            v0.reader.beginEmpty();
            v0.inserting = true;
            v0.providerCache = ((PersistentCompositionLocalMap)v15);
            v0.ensureBuilder();
            v1_1 = v0.builder;
            if(v9) {
                v4_1 = Composer.Companion.getEmpty();
                v6_2 = Composer.Companion.getEmpty();
                v3 = v4_1 == Composer.Companion.getEmpty() ? v13 : v14;
                SlotTableBuilder.access$startNewGroup(v1_1, v2, v3, v4_1, null, v6_2);
            }
            else {
                if(v5 != null) {
                    v4_1 = v6_2 == null ? Composer.Companion.getEmpty() : v6_2;
                    v3 = v4_1 == Composer.Companion.getEmpty() ? v10 : v11;
                    SlotTableBuilder.access$startNewGroup(v1_1, arg18, v3, v4_1, v5, null);
                    goto label_213;
                }

                v4_1 = v6_2 == null ? Composer.Companion.getEmpty() : v6_2;
                v3 = v4_1 == Composer.Companion.getEmpty() ? 0 : v12;
                SlotTableBuilder.access$startNewGroup(v1_1, arg18, v3, v4_1, null, null);
            }

        label_213:
            SlotTableBuilder v2_1 = v1_1;
            v1_2 = new KeyInfo(arg18, Integer.valueOf(v16), LinkComposerKt.access$toInsertAddress(v2_1.getParentHandle()), -1, 0);
            v8.registerInsert(v1_2, v0.nodeIndex - v8.getStartIndex());
            v8.recordUsed(v1_2);
            ArrayList v1_5 = new ArrayList();
            int v8_1 = v9 ? 0 : v0.nodeIndex;
            v15 = new LinkPending(((List)v1_5), v8_1);
        }

    label_270:
        v0.enterGroup(v9, v15);
    }

    public void startDefaults() {
        this.start-AzEfcrM(0xFFFFFF81, null, GroupKind.Companion.getGroup-9udXigM(), null);
    }

    private final void startGroup(int arg3, Object arg4) {
        this.start-AzEfcrM(arg3, arg4, GroupKind.Companion.getGroup-9udXigM(), null);
    }

    private final void startGroup(int arg3) {
        this.start-AzEfcrM(arg3, null, GroupKind.Companion.getGroup-9udXigM(), null);
    }

    public void startMovableGroup(int arg3, Object arg4) {
        this.start-AzEfcrM(arg3, arg4, GroupKind.Companion.getGroup-9udXigM(), null);
    }

    public void startNode() {
        this.start-AzEfcrM(0x7D, null, GroupKind.Companion.getNode-9udXigM(), null);
        this.nodeExpected = true;
    }

    public void startProvider(ProvidedValue arg9) {
        Object v0_1;
        PersistentCompositionLocalMap v0 = this.currentCompositionLocalScope();
        this.startGroup(201, ComposerKt.getProvider());
        Object v1 = this.rememberedValue();
        if(Intrinsics.areEqual(v1, Composer.Companion.getEmpty())) {
            ValueHolder v1_1 = null;
        }
        else {
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
        }

        CompositionLocal v2 = arg9.getCompositionLocal();
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        Intrinsics.checkNotNull(arg9, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
        ValueHolder v3 = v2.updatedStateOf$runtime(arg9, ((ValueHolder)v1));
        boolean v1_2 = Intrinsics.areEqual(v3, v1);
        if(!v1_2) {
            this.updateRememberedValue(v3);
        }

        boolean v5 = true;
        boolean v6 = false;
        if(this.getInserting()) {
            if((arg9.getCanOverride()) || !CompositionLocalMapKt.contains(v0, v2)) {
                v0 = v0.putValue(v2, v3);
            }

            this.builderHasAProvider = true;
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

                        v0_1 = v4;
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
                if((((PersistentCompositionLocalMap)v4)) != (((PersistentCompositionLocalMap)v0_1))) {
                }
                else {
                    v5 = false;
                }
            }

            v6 = v5;
        }

        if((v6) && !this.getInserting()) {
            this.recordProviderUpdate(((PersistentCompositionLocalMap)v0_1));
        }

        this.providersInvalidStack.push(LinkComposerKt.access$asInt(this.providersInvalid));
        this.providersInvalid = v6;
        this.providerCache = ((PersistentCompositionLocalMap)v0_1);
        this.start-AzEfcrM(202, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.getGroup-9udXigM(), v0_1);
    }

    public void startProviders(ProvidedValue[] arg7) {
        PersistentCompositionLocalMap v7;
        PersistentCompositionLocalMap v0 = this.currentCompositionLocalScope();
        this.startGroup(201, ComposerKt.getProvider());
        boolean v2 = true;
        boolean v3 = false;
        if(this.getInserting()) {
            v7 = this.updateProviderMapGroup(v0, CompositionLocalMapKt.updateCompositionMap$default(arg7, v0, null, 4, null));
            this.builderHasAProvider = true;
        }
        else {
            Object v1 = this.reader.get(0);
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            Object v5 = this.reader.get(1);
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

        this.providersInvalidStack.push(LinkComposerKt.access$asInt(this.providersInvalid));
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

    public void startReplaceGroup(int arg10) {
        int v2;
        Object v3;
        SlotTableBuilder v0_1;
        Object v6 = null;
        if(this.pending != null) {
            this.start-AzEfcrM(arg10, v6, GroupKind.Companion.getGroup-9udXigM(), v6);
            return;
        }

        this.validateNodeNotExpected();
        this.compositeKeyHashCode = Long.rotateLeft(Long.rotateLeft(this.getCompositeKeyHashCode(), 3) ^ (((long)arg10)), 3) ^ (((long)this.rGroupIndex));
        ++this.rGroupIndex;
        SlotTableReader v0 = this.reader;
        int v4 = 0x1000000;
        if(this.getInserting()) {
            v0.beginEmpty();
            v0_1 = this.builder;
            v3 = Composer.Companion.getEmpty();
            v2 = v3 == Composer.Companion.getEmpty() ? 0 : v4;
            SlotTableBuilder.access$startNewGroup(v0_1, arg10, v2, v3, null, null);
            this.enterGroup(false, ((LinkPending)v6));
            return;
        }

        if(v0.getGroupKey() == arg10 && !v0.getHasObjectKey()) {
            v0.startGroup();
            this.enterGroup(false, ((LinkPending)v6));
            return;
        }

        if(!v0.isGroupEnd()) {
            int v3_1 = this.nodeIndex;
            this.recordDelete();
            this.changeListWriter.removeNode(v3_1, v0.skipGroup());
        }

        v0.beginEmpty();
        this.inserting = true;
        this.providerCache = ((PersistentCompositionLocalMap)v6);
        this.ensureBuilder();
        v0_1 = this.builder;
        v3 = Composer.Companion.getEmpty();
        v2 = v3 == Composer.Companion.getEmpty() ? 0 : v4;
        SlotTableBuilder.access$startNewGroup(v0_1, arg10, v2, v3, null, null);
        this.enterGroup(false, ((LinkPending)v6));
    }

    public void startReplaceableGroup(int arg3) {
        this.start-AzEfcrM(arg3, null, GroupKind.Companion.getGroup-9udXigM(), null);
    }

    public Composer startRestartGroup(int arg1) {
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
        this.reusingGroup = this.slotTable.getRoot();
        this.reusing = true;
    }

    private final void startRoot() {
        this.rGroupIndex = 0;
        this.reader = this.slotTable.openReader();
        Object v2 = null;
        this.start-AzEfcrM(100, v2, GroupKind.Companion.getGroup-9udXigM(), v2);
        this.parentContext.startComposing$runtime();
        PersistentCompositionLocalMap v0 = this.parentContext.getCompositionLocalScope$runtime();
        this.providersInvalidStack.push(LinkComposerKt.access$asInt(this.providersInvalid));
        this.providersInvalid = this.changed(v0);
        this.providerCache = ((PersistentCompositionLocalMap)v2);
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

        this.start-AzEfcrM(Long.hashCode(this.parentContext.getCompositeKeyHashCode$runtime()), v2, GroupKind.Companion.getGroup-9udXigM(), v2);
    }

    public boolean tryImminentInvalidation$runtime(RecomposeScopeImpl arg7, Object arg8) {
        Anchor v0 = arg7.getAnchor();
        if(v0 == null) {
            return 0;
        }

        int v0_1 = LinkAnchorKt.asLinkAnchor(v0).getAddress();
        if(v0_1 >= 0) {
            if(!this.isComposing$runtime()) {
            }
            else if(this.isGroupAfterCurrentReaderPosition((((long)UInt.constructor-impl(v0_1))) & 0xFFFFFFFFL)) {
                this.reader.addFlag(v0_1, 0x4000000);
                if(arg8 == null || (Intrinsics.areEqual(arg8, ScopeInvalidated.INSTANCE))) {
                    ScopeMap.set-impl(this.invalidations, arg7, ScopeInvalidated.INSTANCE);
                }
                else {
                    MutableScatterMap v1 = this.invalidations;
                    if((arg8 instanceof ScatterSet)) {
                        Intrinsics.checkNotNull(arg8, "null cannot be cast to non-null type androidx.collection.ScatterSet<kotlin.Any>");
                        ScopeMap.addAll-impl(v1, arg7, ((ScatterSet)arg8));
                    }
                    else if(!Intrinsics.areEqual(ScopeMap.get-impl(v1, arg7), ScopeInvalidated.INSTANCE)) {
                        ScopeMap.add-impl(this.invalidations, arg7, arg8);
                    }
                }

                return 1;
            }
        }

        return 0;
    }

    private final Object unwrapRememberObserverHolder(Object arg1) {
        if((arg1 instanceof RememberObserverHolder)) {
            return ((RememberObserverHolder)arg1).getWrapped();
        }

        return arg1;
    }

    public final void updateCachedValue$runtime(Object arg5) {
        LinkRememberObserverHolder v5;
        if((arg5 instanceof RememberObserver)) {
            LinkRememberObserverHolder v0 = new LinkRememberObserverHolder(arg5, this.getReaderTable$runtime().getAddressSpace().anchorOfAddress(this.lastPlacedChildGroup));
            if(this.getInserting()) {
                this.changeListWriter.remember(v0);
            }

            this.abandonSet.add(arg5);
            v5 = v0;
        }

        this.updateValue(v5);
    }

    private final void updateChildNodeCount(long arg5, int arg7) {
        MutableIntIntMap v0;
        if(this.updatedNodeCount(arg5) != arg7) {
            DefaultConstructorMarker v1 = null;
            if(LinkComposerKt.access$isInsertHandle(arg5)) {
                v0 = this.nodeCountVirtualOverrides;
                if(v0 == null) {
                    v0 = new MutableIntIntMap(0, 1, v1);
                    this.nodeCountVirtualOverrides = v0;
                }

                v0.set(GroupHandleKt.getGroup(arg5), arg7);
                return;
            }
            else {
                v0 = this.nodeCountOverrides;
                if(v0 == null) {
                    v0 = new MutableIntIntMap(0, 1, v1);
                    this.nodeCountOverrides = v0;
                }

                LinkComposerKt.access$isInsertHandle(arg5);
                v0.set(GroupHandleKt.getGroup(arg5), arg7);
            }
        }
    }

    public void updateComposerInvalidations-RY85e9Y$runtime(MutableScatterMap arg17) {
        LinkComposer v0 = this;
        Object[] v2 = arg17.keys;
        Object[] v3 = arg17.values;
        long[] v1 = arg17.metadata;
        int v4 = v1.length - 2;
        if(v4 >= 0) {
            int v6;
            for(v6 = 0; true; ++v6) {
                long v7 = v1[v6];
                if((~v7 << 7 & v7 & -9187201950435737472L) != -9187201950435737472L) {
                    int v10 = 8;
                    int v9 = 8 - (~(v6 - v4) >>> 0x1F);
                    int v11;
                    for(v11 = 0; v11 < v9; ++v11) {
                        if((0xFF & v7) < 0x80) {
                            int v12 = (v6 << 3) + v11;
                            Object v13 = v2[v12];
                            Object v12_1 = v3[v12];
                            Intrinsics.checkNotNull(v13, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                            Anchor v14 = v13.getAnchor();
                            LinkAnchor v14_1 = v14 != null ? LinkAnchorKt.asLinkAnchor(v14) : null;
                            if(v14_1 == null) {
                                goto label_67;
                            }

                            if(!v14_1.getValid()) {
                                goto label_67;
                            }

                            int v14_2 = v14_1.getAddress();
                            int v5 = 0x4000000;
                            v0.reader.addFlag(v14_2, v5);
                            if(Intrinsics.areEqual(v12_1, ScopeInvalidated.INSTANCE)) {
                                ScopeMap.set-impl(v0.invalidations, v13, ScopeInvalidated.INSTANCE);
                            }
                            else if((v12_1 instanceof MutableScatterSet)) {
                                Intrinsics.checkNotNull(v12_1, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<kotlin.Any>");
                                ScopeMap.addAll-impl(v0.invalidations, v13, ((ScatterSet)v12_1));
                            }
                            else {
                                ScopeMap.add-impl(v0.invalidations, v13, v12_1);
                            }

                            v0.reader.addFlag(v14_2, v5);
                        }

                    label_67:
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

    private final void updateNodeCountOverrides(long arg7, int arg9) {
        int v0 = this.updatedNodeCount(arg7);
        if(v0 != arg9) {
            arg9 -= v0;
            v0 = Stack.getSize-impl(this.pendingStack) - 1;
            while(true) {
                int v2 = -1;
                if(GroupHandleKt.getGroup(arg7) != v2) {
                    int v1 = this.updatedNodeCount(arg7) + arg9;
                    this.updateChildNodeCount(arg7, v1);
                    int v3;
                    for(v3 = v0; v2 < v3; --v3) {
                        Object v4 = Stack.peek-impl(this.pendingStack, v3);
                        if(v4 != null && (((LinkPending)v4).updateNodeCount(GroupHandleKt.getGroup(arg7), v1))) {
                            v0 = v3 - 1;
                            break;
                        }
                    }

                    if(LinkComposerKt.access$isInsertHandle(arg7)) {
                        arg7 = this.reader.getParentHandle();
                        continue;
                    }

                    int[] v1_1 = this.getReaderTable$runtime().getAddressSpace().getGroups();
                    int v7 = GroupHandleKt.getGroup(arg7);
                    if((v1_1[v7 + 4] & 0x800000) == 0x800000) {
                        return;
                    }

                    arg7 = (((long)UInt.constructor-impl(v1_1[v7 + 2]))) & 0xFFFFFFFFL;
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
        this.updateCachedValue$runtime(arg1);
    }

    private final void updateSlot(Object arg1) {
        this.nextSlot$runtime();
        this.updateValue(arg1);
    }

    public final void updateValue(Object arg3) {
        if(this.getInserting()) {
            this.builder.append(arg3);
            return;
        }

        boolean v0 = this.reader.getHadNext();
        ComposerChangeListWriter v1 = this.changeListWriter;
        if(v0) {
            v1.updateValue(this.reader.getParentCurrentSlotOffset() - 1, arg3);
            return;
        }

        v1.appendValue(arg3);
    }

    private final int updatedNodeCount(long arg2) {
        if(LinkComposerKt.access$isInsertHandle(arg2)) {
            MutableIntIntMap v1 = this.nodeCountVirtualOverrides;
            if(v1 != null) {
                return v1.getOrDefault(GroupHandleKt.getGroup(arg2), 0);
            }

            return 0;
        }

        LinkComposerKt.access$isInsertHandle(arg2);
        int v2 = GroupHandleKt.getGroup(arg2);
        MutableIntIntMap v3 = this.nodeCountOverrides;
        if(v3 != null) {
            int v3_1 = v3.getOrDefault(v2, -1);
            if(v3_1 >= 0) {
                return v3_1;
            }
        }

        return this.getReaderTable$runtime().getAddressSpace().getGroups()[v2 + 4] & 0x7FFFFF;
    }

    public void useNode() {
        this.validateNodeExpected();
        if(this.getInserting()) {
            ComposerKt.composeImmediateRuntimeError("useNode() called while inserting");
        }

        Object v0 = this.reader.getParentNode();
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
        if(!this.isComposing$runtime()) {
            this.getInsertTable$runtime().verifyWellFormed();
        }
    }

    private final Object withReader(SlotTableReader arg5, Function0 arg6) {
        Object v5_1;
        SlotTableReader v0 = this.reader;
        MutableIntIntMap v1 = this.nodeCountOverrides;
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

