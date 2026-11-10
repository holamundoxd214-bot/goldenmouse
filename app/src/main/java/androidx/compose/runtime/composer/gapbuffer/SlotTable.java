package androidx.compose.runtime.composer.gapbuffer;

import androidx.collection.IntSet;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.GapComposerKt;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SlotStorage;
import androidx.compose.runtime.collection.ExtensionsKt;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010(\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010<\u001A\u00020=2\u0006\u0010>\u001A\u00020?H\u0016J7\u0010@\u001A\u0002HA\"\u0004\b\u0000\u0010A2!\u0010B\u001A\u001D\u0012\u0013\u0012\u00110D¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(G\u0012\u0004\u0012\u0002HA0CH\u0086\b¢\u0006\u0002\u0010HJ7\u0010I\u001A\u0002HA\"\u0004\b\u0000\u0010A2!\u0010B\u001A\u001D\u0012\u0013\u0012\u00110J¢\u0006\f\bE\u0012\b\bF\u0012\u0004\b\b(\u001D\u0012\u0004\u0012\u0002HA0CH\u0086\b¢\u0006\u0002\u0010HJ\u0006\u0010K\u001A\u00020DJ\u0006\u0010L\u001A\u00020JJ\u000E\u0010M\u001A\u00020&2\u0006\u0010N\u001A\u00020\fJ\u0012\u0010O\u001A\u0004\u0018\u00010&2\u0006\u0010N\u001A\u00020\fH\u0002J\u000E\u0010P\u001A\u00020\f2\u0006\u0010M\u001A\u00020&J\u000E\u0010Q\u001A\u00020\u001C2\u0006\u0010M\u001A\u00020&J\u0018\u0010R\u001A\u00020\u001C2\u0006\u0010S\u001A\u00020\f2\u0006\u0010M\u001A\u00020TH\u0016J\u0018\u0010U\u001A\u00020\u001C2\u0006\u0010V\u001A\u00020T2\u0006\u0010W\u001A\u00020TH\u0016J=\u0010X\u001A\u00020=2\u0006\u0010G\u001A\u00020D2&\u0010,\u001A\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u0001`/H\u0000¢\u0006\u0002\bYJ\u008F\u0001\u0010X\u001A\u00020=2\u0006\u0010\u001D\u001A\u00020J2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\f2\u000E\u0010\u0012\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0016\u001A\u00020\f2\u0016\u0010$\u001A\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`\'2&\u0010,\u001A\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u0001`/2\u000E\u00104\u001A\n\u0012\u0004\u0012\u000206\u0018\u000105H\u0000¢\u0006\u0004\bY\u0010ZJ\u0087\u0001\u0010[\u001A\u00020=2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\f2\u000E\u0010\u0012\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0016\u001A\u00020\f2\u0016\u0010$\u001A\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`\'2&\u0010,\u001A\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u0001`/2\u000E\u00104\u001A\n\u0012\u0004\u0012\u000206\u0018\u000105H\u0000¢\u0006\u0004\b\\\u0010]J\u0018\u0010^\u001A\n\u0012\u0004\u0012\u00020`\u0018\u00010_2\u0006\u0010a\u001A\u00020\fH\u0016J\u0010\u0010b\u001A\u00020\u001C2\u0006\u0010c\u001A\u00020`H\u0016J\u0006\u0010d\u001A\u00020\u001CJ\u0010\u0010e\u001A\u0004\u0018\u00010.2\u0006\u0010S\u001A\u00020\fJ\u0012\u0010f\u001A\u0004\u0018\u00010`2\u0006\u0010S\u001A\u00020\fH\u0002J\b\u0010g\u001A\u00020=H\u0016J\b\u0010h\u001A\u00020=H\u0002J\u0010\u0010\u0013\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0003H\u0016J\b\u0010i\u001A\u00020=H\u0016J\b\u0010j\u001A\u00020=H\u0016J\u0010\u0010k\u001A\u00020=2\u0006\u0010>\u001A\u00020?H\u0016J\b\u0010l\u001A\u00020=H\u0016J.\u0010m\u001A\u000E\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020p0n2\n\u0010q\u001A\u0006\u0012\u0002\b\u00030r2\f\u0010s\u001A\b\u0012\u0004\u0012\u00020o0tH\u0016J\u0018\u0010u\u001A\u00020=2\u0006\u0010>\u001A\u00020?2\u0006\u0010v\u001A\u00020pH\u0016J\b\u0010w\u001A\u00020=H\u0016J\b\u0010x\u001A\u00020yH\u0016J \u0010z\u001A\u00020\f*\u00060{j\u0002`|2\u0006\u0010N\u001A\u00020\f2\u0006\u0010}\u001A\u00020\fH\u0002J\u000E\u0010~\u001A\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u000E\u0010\u007F\u001A\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u000F\u0010\u0080\u0001\u001A\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u000F\u0010\u0081\u0001\u001A\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u000F\u0010\u0082\u0001\u001A\b\u0012\u0004\u0012\u00020\f0_H\u0002J\u001F\u0010\u0083\u0001\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110_2\u0006\u0010S\u001A\u00020\fH\u0000¢\u0006\u0003\b\u0084\u0001J\"\u0010\u0085\u0001\u001A\u0004\u0018\u00010\u00112\u0006\u0010S\u001A\u00020\f2\u0007\u0010\u0086\u0001\u001A\u00020\fH\u0000¢\u0006\u0003\b\u0087\u0001J\u0011\u0010\u008B\u0001\u001A\t\u0012\u0004\u0012\u00020\u00040\u008C\u0001H\u0096\u0002J\u0014\u0010\u008D\u0001\u001A\u0004\u0018\u00010\u00042\u0007\u0010\u008E\u0001\u001A\u00020\u0011H\u0016R\u001E\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\b@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u001E\u0010\r\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020\f@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR0\u0010\u0012\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u000E\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010@BX\u0086\u000E¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0013\u0010\u0014R\u001E\u0010\u0016\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020\f@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u000FR\u000E\u0010\u0018\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001A\u00060\u0011j\u0002`\u001AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001BR\u001E\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u0007\u001A\u00020\u001C@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u001A\u0010 \u001A\u00020\fX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\u000F\"\u0004\b\"\u0010#R*\u0010$\u001A\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`\'X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+R:\u0010,\u001A\"\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020.\u0018\u0001`/X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001A\n\u0012\u0004\u0012\u000206\u0018\u000105X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b7\u00108\"\u0004\b9\u0010:R\u0014\u0010;\u001A\u00020\u001C8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b;\u0010\u001FR\u001D\u0010\u0088\u0001\u001A\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\b\u001A\u0006\b\u0089\u0001\u0010\u008A\u0001¨\u0006\u008F\u0001"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "Landroidx/compose/runtime/SlotStorage;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "<init>", "()V", "value", "", "groups", "getGroups", "()[I", "", "groupsSize", "getGroupsSize", "()I", "", "", "slots", "getSlots", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "slotsSize", "getSlotsSize", "readers", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "", "writer", "getWriter$runtime", "()Z", "version", "getVersion$runtime", "setVersion$runtime", "(I)V", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "Lkotlin/collections/ArrayList;", "getAnchors$runtime", "()Ljava/util/ArrayList;", "setAnchors$runtime", "(Ljava/util/ArrayList;)V", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;", "Lkotlin/collections/HashMap;", "getSourceInformationMap$runtime", "()Ljava/util/HashMap;", "setSourceInformationMap$runtime", "(Ljava/util/HashMap;)V", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "getCalledByMap$runtime", "()Landroidx/collection/MutableIntObjectMap;", "setCalledByMap$runtime", "(Landroidx/collection/MutableIntObjectMap;)V", "isEmpty", "clear", "", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "read", "T", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "Lkotlin/ParameterName;", "name", "reader", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "write", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "openReader", "openWriter", "anchor", "index", "tryAnchor", "anchorIndex", "ownsAnchor", "groupContainsAnchor", "group", "Landroidx/compose/runtime/Anchor;", "inGroup", "parent", "child", "close", "close$runtime", "(Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "setTo", "setTo$runtime", "([II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "invalidateGroupsWithKey", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "target", "ownsRecomposeScope", "scope", "containsMark", "sourceInformationOf", "findEffectiveRecomposeScope", "verifyWellFormed", "validateRecomposeScopeAnchors", "collectCalledByInformation", "collectSourceInformation", "deactivateAll", "dispose", "extractNestedStates", "Landroidx/collection/ScatterMap;", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "applier", "Landroidx/compose/runtime/Applier;", "references", "Landroidx/collection/ObjectList;", "disposeUnusedMovableContent", "state", "invalidateAll", "toDebugString", "", "emitGroup", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "level", "keys", "nodes", "parentIndexes", "dataIndexes", "groupSizes", "slotsOf", "slotsOf$runtime", "slot", "slotIndex", "slot$runtime", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "iterator", "", "find", "identityToFind", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SlotTable extends SlotStorage implements CompositionData, Iterable, KMappedMarker {
    public static final int $stable = 8;
    private ArrayList anchors;
    private MutableIntObjectMap calledByMap;
    private int[] groups;
    private int groupsSize;
    private final Object lock;
    private int readers;
    private Object[] slots;
    private int slotsSize;
    private HashMap sourceInformationMap;
    private int version;
    private boolean writer;

    static {
    }

    public SlotTable() {
        super();
        this.groups = new int[0];
        this.slots = new Object[0];
        this.lock = new Object();
        this.anchors = new ArrayList();
    }

    public final GapAnchor anchor(int arg4) {
        if(this.writer) {
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to create an anchor location instead");
        }

        int v1 = 0;
        if(arg4 >= 0 && arg4 < this.groupsSize) {
            v1 = 1;
        }

        if(v1 == 0) {
            PreconditionsKt.throwIllegalArgumentException("Parameter index is out of range");
        }

        ArrayList v1_1 = this.anchors;
        int v3 = SlotTableKt.access$search(v1_1, arg4, this.groupsSize);
        if(v3 < 0) {
            GapAnchor v2 = new GapAnchor(arg4);
            v1_1.add(-(v3 + 1), v2);
            return v2;
        }

        return v1_1.get(v3);
    }

    public final int anchorIndex(GapAnchor arg1) {
        if(this.writer) {
            ComposerKt.composeImmediateRuntimeError("Use active SlotWriter to determine anchor location instead");
        }

        if(!arg1.getValid()) {
            PreconditionsKt.throwIllegalArgumentException("Anchor refers to a group that was removed");
        }

        return arg1.getLocation$runtime();
    }

    public void clear(RememberManager arg2) {
        SlotWriter v1 = this.openWriter();
        try {
            ComposerKt.removeCurrentGroup(v1, arg2);
        }
        catch(Throwable v2) {
            v1.close(false);
            throw v2;
        }

        v1.close(true);
    }

    public final void close$runtime(SlotReader arg2, HashMap arg3) {
        int v2 = arg2.getTable$runtime() != this || this.readers <= 0 ? 0 : 1;
        if(v2 == 0) {
            ComposerKt.composeImmediateRuntimeError("Unexpected reader close()");
        }

        --this.readers;
        if(arg3 != null) {
            Object v2_1 = this.lock;
            __monitor_enter(v2_1);
            try {
                HashMap v0 = this.sourceInformationMap;
                if(v0 != null) {
                    v0.putAll(((Map)arg3));
                }
                else {
                    this.sourceInformationMap = arg3;
                }
            }
            catch(Throwable v1) {
                __monitor_exit(v2_1);
                throw v1;
            }

            __monitor_exit(v2_1);
            return;
        }
    }

    public final void close$runtime(SlotWriter arg9, int[] arg10, int arg11, Object[] arg12, int arg13, ArrayList arg14, HashMap arg15, MutableIntObjectMap arg16) {
        int v1 = arg9.getTable$runtime() != this || !this.writer ? 0 : 1;
        if(v1 == 0) {
            PreconditionsKt.throwIllegalArgumentException("Unexpected writer close()");
        }

        this.writer = false;
        this.setTo$runtime(arg10, arg11, arg12, arg13, arg14, arg15, arg16);
    }

    public void collectCalledByInformation() {
        this.calledByMap = new MutableIntObjectMap(0, 1, null);
    }

    public void collectSourceInformation() {
        this.sourceInformationMap = new HashMap();
    }

    public final boolean containsMark() {
        if(this.groupsSize > 0 && (this.groups[1] & 0x4000000) != 0) {
            return 1;
        }

        return 0;
    }

    private final List dataIndexes() {
        return SlotTableKt.access$dataAnchors(this.groups, this.groupsSize * 5);
    }

    public void deactivateAll(RememberManager arg2) {
        SlotWriter v1 = this.openWriter();
        try {
            GapComposerKt.deactivateCurrentGroup(v1, arg2);
        }
        catch(Throwable v2) {
            v1.close(false);
            throw v2;
        }

        v1.close(true);
    }

    public void dispose() {
    }

    public void disposeUnusedMovableContent(RememberManager arg1, MovableContentState arg2) {
        SlotWriter v0 = this.openWriter();
        try {
            ComposerKt.removeCurrentGroup(v0, arg1);
        }
        catch(Throwable v1) {
            v0.close(false);
            throw v1;
        }

        v0.close(true);
    }

    private final int emitGroup(StringBuilder arg10, int arg11, int arg12) {
        int v2;
        int v0;
        int v3;
        int v1;
        for(v1 = 0; v1 < arg12; ++v1) {
            arg10.append(' ');
        }

        arg10.append("Group(");
        arg10.append(arg11);
        arg10.append(")");
        GapGroupSourceInformation v1_1 = this.sourceInformationOf(arg11);
        if(v1_1 != null) {
            String v1_2 = v1_1.getSourceInformation();
            if(v1_2 != null) {
                v3 = 2;
                Object v4 = null;
                if(!StringsKt.startsWith$default(v1_2, "C(", false, v3, v4) && !StringsKt.startsWith$default(v1_2, "CC(", false, v3, v4)) {
                    goto label_42;
                }

                v0 = StringsKt.indexOf$default(v1_2, "(", 0, false, 6, null) + 1;
                v2 = StringsKt.indexOf$default(v1_2, ')', 0, false, 6, null);
                arg10.append(" ");
                String v0_1 = v1_2.substring(v0, v2);
                Intrinsics.checkNotNullExpressionValue(v0_1, "substring(...)");
                arg10.append(v0_1);
                arg10.append("()");
            }
        }

    label_42:
        arg10.append(" key=");
        v1 = arg11 * 5;
        arg10.append(this.groups[v1]);
        v0 = SlotTableKt.access$groupSize(this.groups, arg11);
        arg10.append(", nodes=");
        v3 = v1 + 1;
        arg10.append(this.groups[v3] & 0x3FFFFFF);
        arg10.append(", size=");
        arg10.append(v0);
        if((this.groups[v3] & 0x8000000) != 0) {
            arg10.append(", mark");
        }

        if((this.groups[v3] & 0x4000000) != 0) {
            arg10.append(", contains mark");
        }

        v2 = SlotTable.emitGroup$dataIndex(this, arg11);
        int v4_1 = arg11 + 1;
        int v5 = SlotTable.emitGroup$dataIndex(this, v4_1);
        char v6 = '\n';
        if(v2 < 0 || v2 > v5 || v5 > this.slotsSize) {
            arg10.append(", *invalid data offsets " + v2 + '-' + v5 + '*');
            goto label_169;
        label_144:
            while(v2 < v5) {
                if(v2 != v1) {
                    arg10.append(", ");
                }

                arg10.append(SlotTableKt.access$summarize(String.valueOf(this.slots[v2]), v6));
                ++v2;
            }

            arg10.append("]");
        }
        else {
            if((this.groups[v3] & 0x20000000) != 0) {
                arg10.append(" objectKey=" + SlotTableKt.access$summarize(String.valueOf(this.slots[SlotTableKt.access$objectKeyIndex(this.groups, arg11)]), v6));
            }

            if((this.groups[v3] & 0x40000000) != 0) {
                arg10.append(" node=" + SlotTableKt.access$summarize(String.valueOf(this.slots[this.groups[v1 + 4]]), v6));
            }

            if((this.groups[v3] & 0x10000000) != 0) {
                arg10.append(" aux=" + SlotTableKt.access$summarize(String.valueOf(this.slots[SlotTableKt.access$auxIndex(this.groups, arg11)]), v6));
            }

            v1 = SlotTableKt.access$slotAnchor(this.groups, arg11);
            if(v1 >= v5) {
                goto label_169;
            }

            arg10.append(", slots=[");
            arg10.append(v1);
            arg10.append(": ");
            v2 = v1;
            goto label_144;
        }

    label_169:
        arg10.append(v6);
        arg11 += v0;
        while(v4_1 < arg11) {
            v4_1 += this.emitGroup(arg10, v4_1, arg12 + 1);
        }

        return v0;
    }

    private static final int emitGroup$dataIndex(SlotTable arg1, int arg2) {
        if(arg2 >= arg1.groupsSize) {
            return arg1.slotsSize;
        }

        return arg1.groups[arg2 * 5 + 4];
    }

    public ScatterMap extractNestedStates(Applier arg9, ObjectList arg10) {
        Object v5;
        int v10;
        Object[] v1_1;
        MutableObjectList v0_1;
        Object[] v0 = arg10.content;
        int v1 = arg10._size;
        int v3 = 0;
        while(true) {
            if(v3 < v1) {
                if(!this.ownsAnchor(GapAnchorKt.asGapAnchor(v0[v3].getAnchor$runtime()))) {
                    v0_1 = new MutableObjectList(0, 1, null);
                    v1_1 = arg10.content;
                    v10 = arg10._size;
                    v3 = 0;
                    break;
                }
                else {
                    ++v3;
                    continue;
                }
            }

            goto label_31;
        }

        while(v3 < v10) {
            v5 = v1_1[v3];
            if(this.ownsAnchor(GapAnchorKt.asGapAnchor(v5.getAnchor$runtime()))) {
                v0_1.add(v5);
            }

            ++v3;
        }

        MutableObjectList v10_1 = v0_1;
    label_31:
        arg10 = ExtensionsKt.sortedBy(((ObjectList)v10_1), new SlotTable$$ExternalSyntheticLambda0(this));
        if(arg10.isEmpty()) {
            return ScatterMapKt.emptyScatterMap();
        }

        MutableScatterMap v0_2 = ScatterMapKt.mutableScatterMapOf();
        SlotWriter v8 = this.openWriter();
        try {
            v1_1 = arg10.content;
            v10 = arg10._size;
            for(v3 = 0; v3 < v10; ++v3) {
                v5 = v1_1[v3];
                int v6 = v8.anchorIndex(GapAnchorKt.asGapAnchor(((MovableContentStateReference)v5).getAnchor$runtime()));
                int v7 = v8.parent(v6);
                SlotTable.extractNestedStates$lambda$2$closeToGroupContaining(v8, v7);
                SlotTable.extractNestedStates$lambda$2$openParent(v8, v7);
                v8.advanceBy(v6 - v8.getCurrentGroup());
                v0_2.set(v5, ComposerKt.extractMovableContentAtCurrent(((MovableContentStateReference)v5).getComposition$runtime(), ((MovableContentStateReference)v5), v8, arg9));
            }

            SlotTable.extractNestedStates$lambda$2$closeToGroupContaining(v8, 0x7FFFFFFF);
        }
        catch(Throwable v9) {
            goto label_65;
        }

        v8.close(true);
        return ((ScatterMap)v0_2);
    label_65:
        v8.close(false);
        throw v9;
    }

    static final Integer extractNestedStates$lambda$1(SlotTable arg0, MovableContentStateReference arg1) {
        return Integer.valueOf(arg0.anchorIndex(GapAnchorKt.asGapAnchor(arg1.getAnchor$runtime())));
    }

    private static final void extractNestedStates$lambda$2$closeToGroupContaining(SlotWriter arg1, int arg2) {
        while(arg1.getParent() >= 0) {
            if(arg1.getCurrentGroupEnd() > arg2) {
                return;
            }

            arg1.skipToGroupEnd();
            arg1.endGroup();
        }
    }

    private static final void extractNestedStates$lambda$2$openParent(SlotWriter arg1, int arg2) {
        SlotTable.extractNestedStates$lambda$2$closeToGroupContaining(arg1, arg2);
        while(arg1.getCurrentGroup() != arg2) {
            if(arg1.isGroupEnd()) {
                break;
            }

            if(arg2 < SlotTableKt.access$getNextGroup(arg1)) {
                arg1.startGroup();
            }
            else {
                arg1.skipGroup();
            }
        }

        arg2 = arg1.getCurrentGroup() == arg2 ? 1 : 0;
        if(arg2 == 0) {
            ComposerKt.composeImmediateRuntimeError("Unexpected slot table structure");
        }

        arg1.startGroup();
    }

    public CompositionGroup find(Object arg7) {
        return new SlotTableGroup(this, 0, 0, 4, null).find(arg7);
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int arg5) {
        int v0;
        for(v0 = arg5; v0 > 0; v0 = this.groups[v0 * 5 + 2]) {
            Iterator v1 = new DataIterator(this, v0).iterator();
            while(v1.hasNext()) {
                Object v2 = v1.next();
                if(!(v2 instanceof RecomposeScopeImpl)) {
                    continue;
                }

                if((((RecomposeScopeImpl)v2).getUsed()) && v0 != arg5) {
                    return ((RecomposeScopeImpl)v2);
                }

                ((RecomposeScopeImpl)v2).setForcedRecompose(true);
            }
        }

        return null;
    }

    public final ArrayList getAnchors$runtime() {
        return this.anchors;
    }

    public final MutableIntObjectMap getCalledByMap$runtime() {
        return this.calledByMap;
    }

    public Iterable getCompositionGroups() {
        return this;
    }

    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public Iterable getSlots() {
        return new SlotTable$getSlots$1(this);
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final HashMap getSourceInformationMap$runtime() {
        return this.sourceInformationMap;
    }

    public final int getVersion$runtime() {
        return this.version;
    }

    public final boolean getWriter$runtime() {
        return this.writer;
    }

    public boolean groupContainsAnchor(int arg4, Anchor arg5) {
        if(this.writer) {
            ComposerKt.composeImmediateRuntimeError("Writer is active");
        }

        int v2 = arg4 < 0 || arg4 >= this.groupsSize ? 0 : 1;
        if(v2 == 0) {
            ComposerKt.composeImmediateRuntimeError("Invalid group index");
        }

        GapAnchor v5 = GapAnchorKt.asGapAnchor(arg5);
        if(this.ownsAnchor(v5)) {
            int v3 = SlotTableKt.access$groupSize(this.groups, arg4) + arg4;
            int v5_1 = v5.getLocation$runtime();
            if(arg4 <= v5_1 && v5_1 < v3) {
                return 1;
            }
        }

        return 0;
    }

    private final List groupSizes() {
        return SlotTableKt.access$groupSizes(this.groups, this.groupsSize * 5);
    }

    public boolean inGroup(Anchor arg2, Anchor arg3) {
        int v2 = GapAnchorKt.asGapAnchor(arg2).getLocation$runtime();
        int v1 = SlotTableKt.access$groupSize(this.groups, v2) + v2;
        int v3 = GapAnchorKt.asGapAnchor(arg3).getLocation$runtime();
        if(v2 <= v3 && v3 < v1) {
            return 1;
        }

        return 0;
    }

    public void invalidateAll() {
        Object[] v4 = this.slots;
        int v0 = v4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = v4[v1];
            if((v2 instanceof RecomposeScope)) {
            }
            else {
                v2 = null;
            }

            if(v2 != null) {
                ((RecomposeScope)v2).invalidate();
            }
        }
    }

    public List invalidateGroupsWithKey(int arg11) {
        ArrayList v3 = new ArrayList();
        ArrayList v6 = new ArrayList();
        BooleanRef v4 = new BooleanRef();
        v4.element = true;
        DefaultConstructorMarker v8 = null;
        MutableIntSet v2 = new MutableIntSet(0, 1, v8);
        v2.add(arg11);
        v2.add(-3);
        MutableIntObjectMap v1 = this.calledByMap;
        if(v1 != null) {
            Object v11 = v1.get(arg11);
            if(v11 != null) {
                v2.addAll(((IntSet)v11));
            }
        }

        SlotReader v1_1 = this.openReader();
        SlotTable v5 = this;
        try {
            SlotTable.invalidateGroupsWithKey$lambda$2$scanGroup(v1_1, v2, ((List)v3), v4, v5, ((List)v6));
        }
        catch(Throwable v0) {
            v1_1.close();
            throw v0;
        }

        v1_1.close();
        SlotWriter v10 = v5.openWriter();
        try {
            v10.startGroup();
            arg11 = v3.size();
            int v1_2;
            for(v1_2 = 0; v1_2 < arg11; ++v1_2) {
                Object v2_1 = ((List)v3).get(v1_2);
                if(((GapAnchor)v2_1).toIndexFor(v10) >= v10.getCurrentGroup()) {
                    v10.seek(((GapAnchor)v2_1));
                    v10.bashCurrentGroup();
                }
            }

            v10.skipToGroupEnd();
            v10.endGroup();
        }
        catch(Throwable v0) {
            goto label_50;
        }

        v10.close(true);
        if(v4.element) {
            return ((List)v6);
        }

        return ((List)v8);
    label_50:
        v10.close(false);
        throw v0;
    }

    private static final void invalidateGroupsWithKey$lambda$2$scanGroup(SlotReader arg2, MutableIntSet arg3, List arg4, BooleanRef arg5, SlotTable arg6, List arg7) {
        int v0 = arg2.getGroupKey();
        if(arg3.contains(v0)) {
            if(v0 != -3) {
                arg4.add(SlotReader.anchor$default(arg2, 0, 1, null));
            }

            if(arg5.element) {
                RecomposeScopeImpl v3 = arg6.findEffectiveRecomposeScope(arg2.getCurrentGroup());
                if(v3 != null) {
                    arg7.add(v3);
                    Anchor v3_1 = v3.getAnchor();
                    if(v3_1 != null) {
                        GapAnchor v3_2 = GapAnchorKt.asGapAnchor(v3_1);
                        if(v3_2 != null && v3_2.getLocation$runtime() == arg2.getCurrentGroup()) {
                            v3 = arg6.findEffectiveRecomposeScope(arg2.getParent());
                            if(v3 != null) {
                                arg7.add(v3);
                            }
                        }
                    }
                }
                else {
                    arg5.element = false;
                    arg7.clear();
                }
            }

            arg2.skipGroup();
            return;
        }

        arg2.startGroup();
        while(!arg2.isGroupEnd()) {
            SlotTable.invalidateGroupsWithKey$lambda$2$scanGroup(arg2, arg3, arg4, arg5, arg6, arg7);
        }

        arg2.endGroup();
    }

    public boolean isEmpty() {
        if(this.groupsSize == 0) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    private final List keys() {
        return SlotTableKt.access$keys(this.groups, this.groupsSize * 5);
    }

    private final List nodes() {
        return SlotTableKt.access$nodeCounts(this.groups, this.groupsSize * 5);
    }

    public final SlotReader openReader() {
        if(!this.writer) {
            ++this.readers;
            return new SlotReader(this);
        }

        throw new IllegalStateException("Cannot read while a writer is pending".toString());
    }

    public final SlotWriter openWriter() {
        if(this.writer) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when another writer is pending");
        }

        int v0 = this.readers <= 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when a reader is pending");
        }

        this.writer = true;
        ++this.version;
        return new SlotWriter(this);
    }

    public final boolean ownsAnchor(GapAnchor arg4) {
        if(arg4.getValid()) {
            int v0 = SlotTableKt.access$search(this.anchors, arg4.getLocation$runtime(), this.groupsSize);
            if(v0 >= 0 && (Intrinsics.areEqual(this.anchors.get(v0), arg4))) {
                return 1;
            }
        }

        return 0;
    }

    public boolean ownsRecomposeScope(RecomposeScopeImpl arg2) {
        Anchor v2 = arg2.getAnchor();
        if(v2 != null && (this.ownsAnchor(GapAnchorKt.asGapAnchor(v2)))) {
            return 1;
        }

        return 0;
    }

    private final List parentIndexes() {
        return SlotTableKt.access$parentAnchors(this.groups, this.groupsSize * 5);
    }

    public final Object read(Function1 arg1) {
        Object v1_1;
        SlotReader v0 = this.openReader();
        try {
            v1_1 = arg1.invoke(v0);
        }
        catch(Throwable v1) {
            v0.close();
            throw v1;
        }

        v0.close();
        return v1_1;
    }

    public final void setAnchors$runtime(ArrayList arg1) {
        this.anchors = arg1;
    }

    public final void setCalledByMap$runtime(MutableIntObjectMap arg1) {
        this.calledByMap = arg1;
    }

    public final void setSourceInformationMap$runtime(HashMap arg1) {
        this.sourceInformationMap = arg1;
    }

    public final void setTo$runtime(int[] arg1, int arg2, Object[] arg3, int arg4, ArrayList arg5, HashMap arg6, MutableIntObjectMap arg7) {
        this.groups = arg1;
        this.groupsSize = arg2;
        this.slots = arg3;
        this.slotsSize = arg4;
        this.anchors = arg5;
        this.sourceInformationMap = arg6;
        this.calledByMap = arg7;
    }

    public final void setVersion$runtime(int arg1) {
        this.version = arg1;
    }

    public final Object slot$runtime(int arg3, int arg4) {
        int v0 = SlotTableKt.access$slotAnchor(this.groups, arg3);
        ++arg3;
        arg3 = arg3 < this.groupsSize ? this.groups[arg3 * 5 + 4] : this.slots.length;
        arg3 -= v0;
        if(arg4 >= 0 && arg4 < arg3) {
            return this.slots[v0 + arg4];
        }

        return Composer.Companion.getEmpty();
    }

    public final List slotsOf$runtime(int arg4) {
        int[] v0 = this.groups;
        int v1 = v0[arg4 * 5 + 4];
        ++arg4;
        arg4 = arg4 < this.groupsSize ? v0[arg4 * 5 + 4] : this.slots.length;
        return ArraysKt.toList(this.slots).subList(v1, arg4);
    }

    public final GapGroupSourceInformation sourceInformationOf(int arg3) {
        HashMap v0 = this.sourceInformationMap;
        GapGroupSourceInformation v1 = null;
        if(v0 != null) {
            GapAnchor v2 = this.tryAnchor(arg3);
            if(v2 != null) {
                return v0.get(v2);
            }
        }

        return v1;
    }

    public String toDebugString() {
        if(this.writer) {
            return super.toString();
        }

        StringBuilder v0 = new StringBuilder();
        v0.append(super.toString());
        v0.append('\n');
        int v1 = this.groupsSize;
        if(v1 > 0) {
            int v3;
            for(v3 = 0; v3 < v1; v3 += this.emitGroup(v0, v3, 0)) {
            }
        }
        else {
            v0.append("<EMPTY>");
        }

        return v0.toString();
    }

    private final GapAnchor tryAnchor(int arg2) {
        if(this.writer) {
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to crate an anchor for location instead");
        }

        if(arg2 >= 0) {
            int v0 = this.groupsSize;
            if(arg2 < v0) {
                return SlotTableKt.access$find(this.anchors, arg2, v0);
            }
        }

        return null;
    }

    private final void validateRecomposeScopeAnchors() {
        Object[] v0 = this.slots;
        ArrayList v1 = new ArrayList();
        int v2 = v0.length;
        int v3 = 0;
        int v4;
        for(v4 = 0; v4 < v2; ++v4) {
            Object v5 = v0[v4];
            if((v5 instanceof RecomposeScopeImpl)) {
            }
            else {
                v5 = null;
            }

            if(v5 != null) {
                ((Collection)v1).add(v5);
            }
        }

        int v0_1 = v1.size();
        while(v3 < v0_1) {
            Object v2_1 = ((List)v1).get(v3);
            Anchor v4_1 = ((RecomposeScopeImpl)v2_1).getAnchor();
            if(v4_1 != null) {
                GapAnchor v4_2 = GapAnchorKt.asGapAnchor(v4_1);
                if(v4_2 != null && !this.slotsOf$runtime(v4_2.toIndexFor(this)).contains(v2_1)) {
                    PreconditionsKt.throwIllegalStateException("Misaligned anchor " + v4_2 + " in scope " + v2_1 + " encountered, scope found at " + ArraysKt.indexOf(this.slots, v2_1));
                }
            }

            ++v3;
        }
    }

    public void verifyWellFormed() {
        int v5;
        int v1;
        IntRef v0 = new IntRef();
        int v2 = -1;
        if(this.groupsSize > 0) {
            while(v0.element < this.groupsSize) {
                SlotTable.verifyWellFormed$validateGroup(v0, this, v2, v0.element + SlotTableKt.access$groupSize(this.groups, v0.element));
            }

            v1 = v0.element == this.groupsSize ? 1 : 0;
            if(v1 != 0) {
                goto label_35;
            }

            PreconditionsKt.throwIllegalStateException("Incomplete group at root " + v0.element + " expected to be " + this.groupsSize);
        }

    label_35:
        int v0_1 = this.slotsSize;
        v1 = this.slots.length;
        while(v0_1 < v1) {
            v5 = this.slots[v0_1] == null ? 1 : 0;
            if(v5 == 0) {
                PreconditionsKt.throwIllegalStateException("Non null value in the slot gap at index " + v0_1);
            }

            ++v0_1;
        }

        ArrayList v0_2 = this.anchors;
        v1 = v0_2.size();
        v5 = 0;
        while(v5 < v1) {
            int v6 = ((List)v0_2).get(v5).toIndexFor(this);
            int v7 = v6 < 0 || v6 > this.groupsSize ? 0 : 1;
            if(v7 == 0) {
                PreconditionsKt.throwIllegalArgumentException("Invalid anchor, location out of bound");
            }

            v2 = v2 < v6 ? 1 : 0;
            if(v2 == 0) {
                PreconditionsKt.throwIllegalArgumentException("Anchor is out of order");
            }

            ++v5;
            v2 = v6;
        }

        HashMap v0_3 = this.sourceInformationMap;
        if(v0_3 != null) {
            Iterator v0_4 = ((Map)v0_3).entrySet().iterator();
            while(v0_4.hasNext()) {
                Object v1_1 = v0_4.next();
                Object v2_1 = ((Map$Entry)v1_1).getKey();
                v1_1 = ((Map$Entry)v1_1).getValue();
                if(!((GapAnchor)v2_1).getValid()) {
                    PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
                }

                if(!this.ownsAnchor(((GapAnchor)v2_1))) {
                    PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
                }

                SlotTable.verifyWellFormed$verifySourceGroup(this, ((GapGroupSourceInformation)v1_1));
            }
        }

        this.validateRecomposeScopeAnchors();
    }

    private static final int verifyWellFormed$validateGroup(IntRef arg11, SlotTable arg12, int arg13, int arg14) {
        int v0 = arg11.element;
        int v1 = v0 + 1;
        arg11.element = v1;
        int v3 = v0 * 5;
        int v2 = arg12.groups[v3 + 2];
        int v4 = 0;
        int v6 = v2 == arg13 ? 1 : 0;
        if(v6 == 0) {
            PreconditionsKt.throwIllegalStateException("Invalid parent index detected at " + v0 + ", expected parent index to be " + arg13 + " found " + v2);
        }

        v2 = SlotTableKt.access$groupSize(arg12.groups, v0) + v0;
        v6 = v2 <= arg12.groupsSize ? 1 : 0;
        if(v6 == 0) {
            PreconditionsKt.throwIllegalStateException("A group extends past the end of the table at " + v0);
        }

        arg14 = v2 <= arg14 ? 1 : 0;
        if(arg14 == 0) {
            PreconditionsKt.throwIllegalStateException("A group extends past its parent group at " + v0);
        }

        int[] v14 = arg12.groups;
        v6 = v3 + 4;
        int v7 = v14[v6];
        arg14 = v0 >= arg12.groupsSize - 1 ? arg12.slotsSize : v14[v1 * 5 + 4];
        v1 = arg14 <= arg12.slots.length ? 1 : 0;
        if(v1 == 0) {
            PreconditionsKt.throwIllegalStateException("Slots for " + v0 + " extend past the end of the slot table");
        }

        v1 = v7 <= arg14 ? 1 : 0;
        if(v1 == 0) {
            PreconditionsKt.throwIllegalStateException("Invalid data anchor at " + v0);
        }

        v1 = SlotTableKt.access$slotAnchor(arg12.groups, v0) <= arg14 ? 1 : 0;
        if(v1 == 0) {
            PreconditionsKt.throwIllegalStateException("Slots start out of range at " + v0);
        }

        ++v3;
        v1 = arg12.groups[v3];
        int v8 = 0x40000000;
        int v9 = (v1 & v8) != 0 ? 1 : 0;
        int v10 = (0x20000000 & v1) != 0 ? 1 : 0;
        v9 += v10;
        v1 = (v1 & 0x10000000) != 0 ? 1 : 0;
        arg14 = arg14 - v7 >= v9 + v1 ? 1 : 0;
        if(arg14 == 0) {
            PreconditionsKt.throwIllegalStateException("Not enough slots added for group " + v0);
        }

        v14 = arg12.groups;
        v1 = (v14[v3] & v8) != 0 ? 1 : 0;
        arg14 = v1 == 0 || arg12.slots[v14[v6]] != null ? 1 : 0;
        if(arg14 == 0) {
            PreconditionsKt.throwIllegalStateException("No node recorded for a node group at " + v0);
        }

        for(arg14 = 0; arg11.element < v2; arg14 += SlotTable.verifyWellFormed$validateGroup(arg11, arg12, v0, v2)) {
        }

        int[] v2_1 = arg12.groups;
        v6 = v2_1[v3] & 0x3FFFFFF;
        v2 = SlotTableKt.access$groupSize(v2_1, v0);
        v7 = v6 == arg14 ? 1 : 0;
        String v8_1 = ", received ";
        String v9_1 = ", expected ";
        if(v7 == 0) {
            PreconditionsKt.throwIllegalStateException("Incorrect node count detected at " + v0 + v9_1 + v6 + v8_1 + arg14);
        }

        int v11 = arg11.element - v0;
        v6 = v2 == v11 ? 1 : 0;
        if(v6 == 0) {
            PreconditionsKt.throwIllegalStateException("Incorrect slot count detected at " + v0 + v9_1 + v2 + v8_1 + v11);
        }

        int[] v11_1 = arg12.groups;
        if((v11_1[v3] & 0xC000000) != 0) {
            if(v0 <= 0 || (v11_1[arg13 * 5 + 1] & 0x4000000) != 0) {
                v4 = 1;
            }

            if(v4 != 0) {
                goto label_230;
            }

            PreconditionsKt.throwIllegalStateException("Expected group " + arg13 + " to record it contains a mark because " + v0 + " does");
        }

    label_230:
        if(v1 != 0) {
            return 1;
        }

        return arg14;
    }

    private static final void verifyWellFormed$verifySourceGroup(SlotTable arg4, GapGroupSourceInformation arg5) {
        ArrayList v5 = arg5.getGroups();
        if(v5 != null) {
            int v0 = v5.size();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                Object v2 = ((List)v5).get(v1);
                if((v2 instanceof GapAnchor)) {
                    if(!((GapAnchor)v2).getValid()) {
                        PreconditionsKt.throwIllegalArgumentException("Source map contains invalid anchor");
                    }

                    if(arg4.ownsAnchor(((GapAnchor)v2))) {
                        goto label_21;
                    }

                    PreconditionsKt.throwIllegalArgumentException("Source map anchor is not owned by the slot table");
                }
                else {
                    if(!(v2 instanceof GapGroupSourceInformation)) {
                        goto label_21;
                    }

                    SlotTable.verifyWellFormed$verifySourceGroup(arg4, ((GapGroupSourceInformation)v2));
                }

            label_21:
            }
        }
    }

    public final Object write(Function1 arg2) {
        Object v2_1;
        SlotWriter v1 = this.openWriter();
        try {
            v2_1 = arg2.invoke(v1);
        }
        catch(Throwable v2) {
            v1.close(false);
            throw v2;
        }

        v1.close(true);
        return v2_1;
    }
}

