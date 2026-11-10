package androidx.compose.runtime.composer.linkbuffer;

import androidx.collection.IntSet;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SlotStorage;
import androidx.compose.runtime.composer.RememberManager;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;

@Metadata(d1={"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0015\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\b\u0001\u0018\u0000 §\u00012\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0006¥\u0001¦\u0001§\u0001B/\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u001D\u001A\u00060\u001Ej\u0002`\u001FJ\b\u0010%\u001A\u00020&H\u0016J\"\u0010\'\u001A\u00020\u00002\u0017\u0010(\u001A\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020&0)¢\u0006\u0002\b+H\u0086\bJ-\u0010,\u001A\u0002H-\"\u0004\b\u0000\u0010-2\u0017\u0010(\u001A\u0013\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u0002H-0)¢\u0006\u0002\b+H\u0086\b¢\u0006\u0002\u0010.J-\u0010/\u001A\u0002H-\"\u0004\b\u0000\u0010-2\u0017\u0010(\u001A\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002H-0)¢\u0006\u0002\b+H\u0086\b¢\u0006\u0002\u0010.J\u0006\u00101\u001A\u000200J\u000E\u00102\u001A\u00020&2\u0006\u00103\u001A\u000200J\u0006\u00104\u001A\u00020\u001BJ\u000E\u00105\u001A\u00020&2\u0006\u00106\u001A\u00020\u001BJ\u0015\u00107\u001A\u00020\n2\n\u00108\u001A\u00060\u0006j\u0002`9H\u0086\u0002J\u0011\u00107\u001A\u00020\n2\u0006\u0010:\u001A\u00020;H\u0086\u0002J\u0012\u0010<\u001A\u00020\n2\n\u0010=\u001A\u00060\u0006j\u0002`>J\u0012\u0010?\u001A\u00020\n2\n\u00108\u001A\u00060\u0006j\u0002`9J\u0016\u0010@\u001A\u00020\n2\u0006\u0010A\u001A\u00020;2\u0006\u0010B\u001A\u00020;J\u0010\u0010C\u001A\u00020&2\u0006\u0010D\u001A\u00020EH\u0016J\u0010\u0010F\u001A\u00020&2\u0006\u0010D\u001A\u00020EH\u0016J.\u0010G\u001A\u000E\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020J0H2\n\u0010K\u001A\u0006\u0012\u0002\b\u00030L2\f\u0010M\u001A\b\u0012\u0004\u0012\u00020I0NH\u0016J\u0012\u0010O\u001A\u0004\u0018\u00010\u00042\u0006\u0010P\u001A\u00020QH\u0016J\u0018\u0010R\u001A\u00020\n2\u0006\u00108\u001A\u00020\u00062\u0006\u0010:\u001A\u00020SH\u0016J\u0018\u0010@\u001A\u00020\n2\u0006\u0010T\u001A\u00020S2\u0006\u0010U\u001A\u00020SH\u0016J\u0018\u0010V\u001A\u00020&2\u0006\u0010D\u001A\u00020E2\u0006\u0010W\u001A\u00020JH\u0016J\b\u0010X\u001A\u00020&H\u0016J\u0018\u0010Y\u001A\n\u0012\u0004\u0012\u00020[\u0018\u00010Z2\u0006\u0010\\\u001A\u00020\u0006H\u0016J\u0010\u0010]\u001A\u00020\n2\u0006\u0010^\u001A\u00020[H\u0016J\u0016\u0010_\u001A\u0004\u0018\u00010[2\n\u00108\u001A\u00060\u0006j\u0002`9H\u0002J\u001B\u0010`\u001A\u0004\u0018\u00010[2\n\u00108\u001A\u00060\u0006j\u0002`9H\u0000¢\u0006\u0002\baJA\u0010b\u001A\u00020&2\n\u00108\u001A\u00060\u0006j\u0002`92%\u0010c\u001A!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\bfJA\u0010g\u001A\u00020&2\n\u00108\u001A\u00060\u0006j\u0002`92%\u0010c\u001A!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\bhJA\u0010i\u001A\u00020&2\n\u00108\u001A\u00060\u0006j\u0002`92%\u0010c\u001A!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\bjJK\u0010k\u001A\u00020&2\n\u00108\u001A\u00060\u0006j\u0002`92\b\b\u0002\u0010l\u001A\u00020\n2%\u0010c\u001A!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\bmJ5\u0010n\u001A\u00020&2%\u0010c\u001A!\u0012\u0017\u0012\u00150\u0006j\u0002`9¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\boJ%\u0010p\u001A\u00020\n2\n\u0010U\u001A\u00060\u0006j\u0002`92\n\u0010T\u001A\u00060\u0006j\u0002`9H\u0000¢\u0006\u0002\bqJ3\u0010r\u001A\u00020&2#\u0010s\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010Q¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(t\u0012\u0004\u0012\u00020&0)H\u0080\b¢\u0006\u0002\buJT\u0010v\u001A\u00020&2\n\u00108\u001A\u00060\u0006j\u0002`928\u0010s\u001A4\u0012\u0015\u0012\u0013\u0018\u00010Q¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\bd\u0012\b\be\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020&0wH\u0080\b¢\u0006\u0002\byJ\u0006\u0010z\u001A\u00020\u0000J\b\u0010{\u001A\u00020&H\u0016J\b\u0010|\u001A\u00020&H\u0016J\b\u0010}\u001A\u00020~H\u0016J\u000E\u0010}\u001A\u00020~2\u0006\u0010\u007F\u001A\u00020\nJ\t\u0010\u0080\u0001\u001A\u00020&H\u0016J\u0011\u0010\u0085\u0001\u001A\t\u0012\u0004\u0012\u00020\u00040\u0086\u0001H\u0096\u0002J\u001B\u0010\u0087\u0001\u001A\u00020\u00062\n\u00108\u001A\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0088\u0001J\u001B\u0010\u0089\u0001\u001A\u00020\u00062\n\u00108\u001A\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u008A\u0001J\u001B\u0010\u008B\u0001\u001A\u00020\n2\n\u00108\u001A\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u008C\u0001J%\u0010\u008D\u0001\u001A\u0004\u0018\u00010Q2\n\u00108\u001A\u00060\u0006j\u0002`92\u0006\u0010x\u001A\u00020\u0006H\u0000¢\u0006\u0003\b\u008E\u0001J\u001D\u0010\u008F\u0001\u001A\u0004\u0018\u00010Q2\n\u00108\u001A\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0090\u0001J\u001D\u0010\u0091\u0001\u001A\u0004\u0018\u00010Q2\n\u00108\u001A\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0092\u0001J\u001D\u0010\u0093\u0001\u001A\u0004\u0018\u00010Q2\n\u00108\u001A\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0094\u0001J\u001B\u0010\u0095\u0001\u001A\u00020\u00062\n\u00108\u001A\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0096\u0001J\u001B\u0010\u0097\u0001\u001A\u00020\u00062\n\u00108\u001A\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u0098\u0001J\u001B\u0010\u0099\u0001\u001A\u00020\u00062\n\u00108\u001A\u00060\u0006j\u0002`9H\u0000¢\u0006\u0003\b\u009A\u0001J\u0011\u0010¡\u0001\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010Q0\u0003H\u0016J\u000F\u0010£\u0001\u001A\u00020QH\u0000¢\u0006\u0003\b¤\u0001R\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u001A\u0010\t\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\u000B\u001A\u00020\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0010\u0010\u001A\u001A\u0004\u0018\u00010\u001BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010!\u001A\u00020\u00062\u0006\u0010 \u001A\u00020\u0006@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u000FR\u0011\u0010#\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b$\u0010\u0015R\u001D\u0010\u0081\u0001\u001A\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\b\u001A\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0016\u0010\u0084\u0001\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0007\u001A\u0005\b\u0084\u0001\u0010\u0015R\u0018\u0010\u009B\u0001\u001A\u00030\u009C\u00018BX\u0082\u0004¢\u0006\b\u001A\u0006\b\u009D\u0001\u0010\u009E\u0001R \u0010\u009F\u0001\u001A\u000B\u0012\u0006\u0012\u0004\u0018\u00010Q0 \u00018BX\u0082\u0004¢\u0006\b\u001A\u0006\b¡\u0001\u0010¢\u0001¨\u0006¨\u0001"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "Landroidx/compose/runtime/SlotStorage;", "Landroidx/compose/runtime/tooling/CompositionData;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "root", "", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "recordSourceInformation", "", "recordCallByInformation", "<init>", "(ILandroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;ZZ)V", "getRoot", "()I", "setRoot", "(I)V", "getAddressSpace", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "getRecordSourceInformation", "()Z", "setRecordSourceInformation", "(Z)V", "getRecordCallByInformation", "setRecordCallByInformation", "currentEditor", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "openReaders", "rootHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "value", "version", "getVersion", "hasEditor", "getHasEditor", "dispose", "", "buildSubTable", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "Lkotlin/ExtensionFunctionType;", "edit", "T", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "read", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "openReader", "closeReader", "reader", "openEditor", "closeEditor", "editor", "contains", "group", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "anchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "containsFlags", "flags", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "hasRecomposeScopes", "inGroup", "groupAnchor", "childAnchor", "clear", "rememberManager", "Landroidx/compose/runtime/composer/RememberManager;", "deactivateAll", "extractNestedStates", "Landroidx/collection/ScatterMap;", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "applier", "Landroidx/compose/runtime/Applier;", "references", "Landroidx/collection/ObjectList;", "find", "identityToFind", "", "groupContainsAnchor", "Landroidx/compose/runtime/Anchor;", "parent", "child", "disposeUnusedMovableContent", "state", "invalidateAll", "invalidateGroupsWithKey", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "target", "ownsRecomposeScope", "scope", "findEffectiveRecomposeScope", "getRecomposeScopeOrNull", "getRecomposeScopeOrNull$runtime", "traverseSiblings", "visit", "Lkotlin/ParameterName;", "name", "traverseSiblings$runtime", "traverseGroupAndParents", "traverseGroupAndParents$runtime", "traverseChildren", "traverseChildren$runtime", "traverseGroup", "includeSiblingsOfStartGroup", "traverseGroup$runtime", "traverseTable", "traverseTable$runtime", "isGroupAChildOf", "isGroupAChildOf$runtime", "forEachSlot", "action", "slot", "forEachSlot$runtime", "forEachGroupSlot", "Lkotlin/Function2;", "index", "forEachGroupSlot$runtime", "newTableInSameAddressSpace", "collectSourceInformation", "collectCalledByInformation", "toDebugString", "", "includeSlots", "verifyWellFormed", "compositionGroups", "getCompositionGroups", "()Ljava/lang/Iterable;", "isEmpty", "iterator", "", "nextSiblingOf", "nextSiblingOf$runtime", "firstChildOf", "firstChildOf$runtime", "groupHasAux", "groupHasAux$runtime", "groupSlotAtIndex", "groupSlotAtIndex$runtime", "groupObjectKey", "groupObjectKey$runtime", "groupAux", "groupAux$runtime", "groupNode", "groupNode$runtime", "groupKeyOf", "groupKeyOf$runtime", "groupSlotRange", "groupSlotRange$runtime", "groupFlags", "groupFlags$runtime", "groups", "", "getGroups", "()[I", "slots", "", "getSlots", "()[Ljava/lang/Object;", "toDebugTree", "toDebugTree$runtime", "DebugGroup", "DebugSlotRange", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SlotTable extends SlotStorage implements CompositionData, Iterable, KMappedMarker {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\fH\u0086\b¨\u0006\r"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/SlotTable$Companion;", "", "<init>", "()V", "build", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "", "Lkotlin/ExtensionFunctionType;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final SlotTable build(SlotTableAddressSpace arg2, Function1 arg3) {
            SlotTableBuilder v1 = new SlotTableBuilder(arg2, false, false);
            v1.buildStart();
            arg3.invoke(v1);
            return v1.build();
        }

        public static SlotTable build$default(Companion arg0, SlotTableAddressSpace arg1, Function1 arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = new SlotTableAddressSpace();
            }

            SlotTableBuilder v0 = new SlotTableBuilder(arg1, false, false);
            v0.buildStart();
            arg2.invoke(v0);
            return v0.build();
        }
    }

    @Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010+\u001A\u00020,H\u0016R\u0015\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u001B\u0010\t\u001A\f\u0012\b\u0012\u00060\u0000R\u00020\u000B0\n8F¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0019\u0010\u000E\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\rR\u0011\u0010\u0010\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\bR\u0011\u0010\u0012\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\bR\u0015\u0010\u0014\u001A\u00060\u0015R\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001A\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u0013\u0010\u001B\u001A\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001AR\u0013\u0010\u001D\u001A\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001AR\u0011\u0010\u001F\u001A\u00020 8F¢\u0006\u0006\u001A\u0004\b\u001F\u0010!R\u0011\u0010\"\u001A\u00020 8F¢\u0006\u0006\u001A\u0004\b\"\u0010!R\u0011\u0010#\u001A\u00020 8F¢\u0006\u0006\u001A\u0004\b$\u0010!R\u0011\u0010%\u001A\u00020 8F¢\u0006\u0006\u001A\u0004\b%\u0010!R\u0011\u0010&\u001A\u00020 8F¢\u0006\u0006\u001A\u0004\b\'\u0010!R\u0011\u0010(\u001A\u00020 8F¢\u0006\u0006\u001A\u0004\b(\u0010!R\u0011\u0010)\u001A\u00020 8F¢\u0006\u0006\u001A\u0004\b*\u0010!¨\u0006-"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugGroup;", "", "address", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;I)V", "getAddress", "()I", "children", "", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "getChildren", "()Ljava/util/List;", "slots", "getSlots", "key", "getKey", "flags", "getFlags", "slotRange", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugSlotRange;", "getSlotRange", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugSlotRange;", "objectKey", "getObjectKey", "()Ljava/lang/Object;", "node", "getNode", "aux", "getAux", "isNode", "", "()Z", "isMovableContent", "hasMovableContent", "getHasMovableContent", "isSubComposition", "hasSubComposition", "getHasSubComposition", "isRecomposeRequired", "hasRecomposeRequired", "getHasRecomposeRequired", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DebugGroup {
        private final int address;

        public DebugGroup(SlotTable arg1, int arg2) {
            SlotTable.this = arg1;
            super();
            this.address = arg2;
        }

        public final int getAddress() {
            return this.address;
        }

        public final Object getAux() {
            if((this.getFlags() & 0x2000000) == 0x2000000) {
                return SlotTable.this.getSlots()[this.getSlotRange().getAddress() + Integer.bitCount(this.getFlags() & 0x1800000)];
            }

            return Composer.Companion.getEmpty();
        }

        public final List getChildren() {
            return SequencesKt.toList(SequencesKt.sequence(new SlotTable$DebugGroup$children$1(SlotTable.this, this, null)));
        }

        public final int getFlags() {
            return SlotTable.this.getGroups()[this.address + 4];
        }

        public final boolean getHasMovableContent() {
            if((this.getFlags() & 0x20000000) == 0x20000000) {
                return 1;
            }

            return 0;
        }

        public final boolean getHasRecomposeRequired() {
            if((this.getFlags() & 0x8000000) == 0x8000000) {
                return 1;
            }

            return 0;
        }

        public final boolean getHasSubComposition() {
            if((this.getFlags() & 0x80000000) == 0x80000000) {
                return 1;
            }

            return 0;
        }

        public final int getKey() {
            return SlotTable.this.getGroups()[this.address];
        }

        public final Object getNode() {
            if((this.getFlags() & 0x800000) == 0x800000) {
                Object[] v0 = SlotTable.this.getSlots();
                int v1 = this.getSlotRange().getAddress();
                this.getFlags();
                return v0[v1];
            }

            return Composer.Companion.getEmpty();
        }

        public final Object getObjectKey() {
            if((this.getFlags() & 0x1000000) == 0x1000000) {
                return SlotTable.this.getSlots()[this.getSlotRange().getAddress() + Integer.bitCount(this.getFlags() & 0x800000)];
            }

            return Composer.Companion.getEmpty();
        }

        public final DebugSlotRange getSlotRange() {
            return new DebugSlotRange(SlotTable.this, SlotTable.this.getGroups()[this.address + 5]);
        }

        public final List getSlots() {
            return SequencesKt.toList(SequencesKt.sequence(new SlotTable$DebugGroup$slots$1(this, SlotTable.this, null)));
        }

        public final boolean isMovableContent() {
            if((this.getFlags() & 0x10000000) == 0x10000000) {
                return 1;
            }

            return 0;
        }

        public final boolean isNode() {
            if((this.getFlags() & 0x800000) == 0x800000) {
                return 1;
            }

            return 0;
        }

        public final boolean isRecomposeRequired() {
            if((this.getFlags() & 0x4000000) == 0x4000000) {
                return 1;
            }

            return 0;
        }

        public final boolean isSubComposition() {
            if((this.getFlags() & 0x4000000) == 0x4000000) {
                return 1;
            }

            return 0;
        }

        public String toString() {
            SlotTable v0 = SlotTable.this;
            StringBuilder v1 = new StringBuilder("Group(");
            v1.append(this.getKey());
            if((this.getFlags() & 0xFC000000) != 0) {
                v1.append(", flags=");
                if(this.isMovableContent()) {
                    v1.append('C');
                }

                if(this.getHasMovableContent()) {
                    v1.append('c');
                }

                if(this.isSubComposition()) {
                    v1.append('S');
                }

                if(this.getHasSubComposition()) {
                    v1.append('s');
                }

                if(this.isRecomposeRequired()) {
                    v1.append('R');
                }

                if(!this.getHasRecomposeRequired()) {
                    goto label_36;
                }

                v1.append('r');
            }

        label_36:
            if((this.getFlags() & 0x1000000) == 0x1000000) {
                v1.append(", object key");
            }

            if((this.getFlags() & 0x2000000) == 0x2000000) {
                v1.append(", aux");
            }

            if(this.isNode()) {
                v1.append(", node");
            }

            int[] v2 = v0.getGroups();
            int v3 = this.address;
            String v4 = ", ";
            int v5 = -1;
            if(v2[v3 + 3] != v5) {
                v2 = v0.getAddressSpace().getGroups();
                v3 = v2[v3 + 3];
                int v6 = 0;
                while(v3 > 0) {
                    ++v6;
                    v3 = v2[v3 + 1];
                }

                v1.append(v4);
                v1.append(v6);
                String v2_1 = v6 == 1 ? " child" : " children";
                v1.append(v2_1);
            }

            if(v0.getGroups()[this.address + 5] != v5) {
                v1.append(v4);
                v1.append(this.getSlotRange().getSize());
                v1.append(" slots");
            }

            v1.append(')');
            return v1.toString();
        }
    }

    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\n\u0010\bR\u0011\u0010\u000B\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\f\u0010\bR\u0011\u0010\r\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\b¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/SlotTable$DebugSlotRange;", "", "range", "", "Landroidx/compose/runtime/composer/linkbuffer/SlotRange;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;I)V", "getRange", "()I", "address", "getAddress", "size", "getSize", "end", "getEnd", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class DebugSlotRange {
        private final int range;

        public DebugSlotRange(SlotTable arg1, int arg2) {
            SlotTable.this = arg1;
            super();
            this.range = arg2;
        }

        public final int getAddress() {
            return this.range >> 4;
        }

        public final int getEnd() {
            return this.getAddress() + this.getSize();
        }

        public final int getRange() {
            return this.range;
        }

        public final int getSize() {
            SlotTableAddressSpace v0 = SlotTable.this.getAddressSpace();
            int v3 = this.range;
            if(v3 == -1) {
                return 0;
            }

            int v1 = (v3 & 15) + 1;
            if(v1 > 15) {
                return SlotTableAddressSpace.access$getLargeSizes(v0).get(v3 >> 4);
            }

            return v1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final SlotTableAddressSpace addressSpace;
    private SlotTableEditor currentEditor;
    private int openReaders;
    private boolean recordCallByInformation;
    private boolean recordSourceInformation;
    private int root;
    private int version;

    static {
        SlotTable.Companion = new Companion(null);
        SlotTable.$stable = 8;
    }

    public SlotTable(int arg2, SlotTableAddressSpace arg3, boolean arg4, boolean arg5, int arg6, DefaultConstructorMarker arg7) {
        if((arg6 & 1) != 0) {
            arg2 = -1;
        }

        if((arg6 & 2) != 0) {
            arg3 = new SlotTableAddressSpace();
        }

        this(arg2, arg3, false, false);
    }

    public SlotTable() {
        this(0, null, false, false, 15, null);
    }

    public SlotTable(int arg1, SlotTableAddressSpace arg2, boolean arg3, boolean arg4) {
        super();
        this.root = arg1;
        this.addressSpace = arg2;
        this.recordSourceInformation = arg3;
        this.recordCallByInformation = arg4;
    }

    public static final int[] access$getGroups(SlotTable arg0) {
        return arg0.getGroups();
    }

    public static final Object[] access$getSlots(SlotTable arg0) {
        return arg0.getSlots();
    }

    public final SlotTable buildSubTable(Function1 arg3) {
        SlotTableBuilder v0 = new SlotTableBuilder(this.getAddressSpace(), false, false);
        v0.buildStart();
        arg3.invoke(v0);
        return v0.build();
    }

    public void clear(RememberManager arg1) {
        SlotTableEditor v0 = this.openEditor();
        try {
            SlotTableKt.removeCurrentGroup(v0, arg1);
        }
        catch(Throwable v1) {
            v0.close();
            throw v1;
        }

        v0.close();
    }

    public final void closeEditor(SlotTableEditor arg2) {
        int v2 = this.currentEditor == arg2 ? 1 : 0;
        if(v2 == 0) {
            ComposerKt.composeImmediateRuntimeError("Attempted to close an editor that was not the current editor");
        }

        this.currentEditor = null;
    }

    public final void closeReader(SlotTableReader arg1) {
        int v1 = arg1.getTable() != this || this.openReaders <= 0 ? 0 : 1;
        if(v1 == 0) {
            ComposerKt.composeImmediateRuntimeError("Unexpected reader close()");
        }

        --this.openReaders;
    }

    public void collectCalledByInformation() {
        this.recordCallByInformation = true;
    }

    public void collectSourceInformation() {
        this.recordSourceInformation = true;
    }

    public final boolean contains(int arg6) {
        int v3;
        if(arg6 >= 0) {
            if(!this.addressSpace.contains(arg6)) {
            }
            else {
                int[] v1 = this.addressSpace.getGroups();
                int v2 = v1[arg6 + 2];
                while(true) {
                    v3 = 1;
                    if(v2 <= 0) {
                        break;
                    }
                    else if(v2 == this.root) {
                        return 1;
                    }
                    else {
                        v2 = v1[v2 + 2];
                        continue;
                    }

                    return 0;
                }

                if(v2 != 0) {
                }
                else {
                    v3 = 0;
                }

                if(v3 != 0) {
                    return 0;
                }

                ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg6);
            }
        }

        return 0;
    }

    public final boolean contains(LinkAnchor arg2) {
        if((arg2.getValid()) && (this.addressSpace.ownsAnchor(arg2)) && (this.contains(arg2.getAddress()))) {
            return 1;
        }

        return 0;
    }

    public final boolean containsFlags(int arg3) {
        if(this.isEmpty()) {
            return 0;
        }

        if((this.addressSpace.getGroups()[this.root + 4] & arg3) == arg3) {
            return 1;
        }

        return 0;
    }

    public void deactivateAll(RememberManager arg1) {
        SlotTableEditor v0 = this.openEditor();
        try {
            SlotTableKt.deactivateCurrentGroup(v0, arg1);
        }
        catch(Throwable v1) {
            v0.close();
            throw v1;
        }

        v0.close();
    }

    public void dispose() {
        int v0 = this.root;
        int v1 = -1;
        if(v0 != v1) {
            this.addressSpace.freeGroupTree(v0);
            this.root = v1;
        }
    }

    public void disposeUnusedMovableContent(RememberManager arg1, MovableContentState arg2) {
        SlotTableEditor v0 = this.openEditor();
        try {
            SlotTableKt.removeCurrentGroup(v0, arg1);
        }
        catch(Throwable v1) {
            v0.close();
            throw v1;
        }

        v0.close();
    }

    public final Object edit(Function1 arg1) {
        Object v1_1;
        SlotTableEditor v0 = this.openEditor();
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

    public ScatterMap extractNestedStates(Applier arg7, ObjectList arg8) {
        MutableScatterMap v0 = ScatterMapKt.mutableScatterMapOf();
        SlotTableEditor v6 = this.openEditor();
        try {
            Object[] v1 = arg8.content;
            int v8 = arg8._size;
            int v2;
            for(v2 = 0; v2 < v8; ++v2) {
                Object v3 = v1[v2];
                LinkAnchor v4 = LinkAnchorKt.asLinkAnchor(((MovableContentStateReference)v3).getAnchor$runtime());
                if(v6.getTable().contains(v4)) {
                    v6.seek(v4);
                    v0.set(v3, SlotTableKt.access$extractMovableContentAtCurrent(((MovableContentStateReference)v3).getComposition$runtime(), ((MovableContentStateReference)v3), v6, arg7));
                }
            }
        }
        catch(Throwable v7) {
            goto label_22;
        }

        v6.close();
        return ((ScatterMap)v0);
    label_22:
        v6.close();
        throw v7;
    }

    public CompositionGroup find(Object arg4) {
        return new SlotTableGroup(this, this.root, this.version).find(arg4);
    }

    private final RecomposeScopeImpl findEffectiveRecomposeScope(int arg6) {
        int v2;
        int[] v0 = this.getAddressSpace().getGroups();
        int v1;
        for(v1 = arg6; true; v1 = v0[v1 + 2]) {
            v2 = 1;
            if(v1 <= 0) {
                break;
            }

            RecomposeScopeImpl v3 = this.getRecomposeScopeOrNull$runtime(v1);
            if(v3 != null) {
                if((v3.getUsed()) && v1 != arg6) {
                    return v3;
                }

                v3.setForcedRecompose(true);
            }
        }

        if(v1 != 0) {
        }
        else {
            v2 = 0;
        }

        if(v2 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg6);
        }

        return null;
    }

    public final int firstChildOf$runtime(int arg1) {
        return this.getGroups()[arg1 + 3];
    }

    public final void forEachGroupSlot$runtime(int arg5, Function2 arg6) {
        arg5 = this.getGroups()[arg5 + 5];
        if(arg5 != -1) {
            SlotTableAddressSpace v0 = this.getAddressSpace();
            int v1 = (arg5 & 15) + 1;
            arg5 >>= 4;
            if(v1 > 15) {
                v1 = SlotTableAddressSpace.access$getLargeSizes(v0).get(arg5);
            }

            int v0_1;
            for(v0_1 = 0; v0_1 < v1; ++v0_1) {
                Object v2 = this.getSlots()[arg5 + v0_1];
                if(Intrinsics.areEqual(v2, Composer.Companion.getEmpty())) {
                    return;
                }

                arg6.invoke(v2, Integer.valueOf(v0_1));
            }
        }
    }

    public final void forEachSlot$runtime(Function1 arg9) {
        if(this.getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot read while an editor is pending");
        }

        SlotTableAddressSpace v0 = this.getAddressSpace();
        int v1 = this.getRoot();
        if(v1 >= 0) {
            IntStack v2 = new IntStack();
            int[] v0_1 = v0.getGroups();
            while(true) {
                int v3 = this.getGroups()[v1 + 5];
                if(v3 != -1) {
                    SlotTableAddressSpace v4 = this.getAddressSpace();
                    int v5 = (v3 & 15) + 1;
                    v3 >>= 4;
                    if(v5 > 15) {
                        v5 = SlotTableAddressSpace.access$getLargeSizes(v4).get(v3);
                    }

                    int v4_1;
                    for(v4_1 = 0; v4_1 < v5; ++v4_1) {
                        Object v6 = this.getSlots()[v3 + v4_1];
                        if(Intrinsics.areEqual(v6, Composer.Companion.getEmpty())) {
                            break;
                        }

                        arg9.invoke(v6);
                    }
                }

                v3 = v0_1[v1 + 1];
                if(v3 >= 0) {
                    v2.push(v3);
                }

                v1 = v0_1[v1 + 3];
                if(v1 >= 0) {
                    continue;
                }

                if(v2.tos == 0) {
                    return;
                }

                v1 = v2.pop();
            }
        }
    }

    public final SlotTableAddressSpace getAddressSpace() {
        return this.addressSpace;
    }

    public Iterable getCompositionGroups() {
        return this;
    }

    private final int[] getGroups() {
        return this.addressSpace.getGroups();
    }

    public final boolean getHasEditor() {
        if(this.currentEditor != null) {
            return 1;
        }

        return 0;
    }

    public final RecomposeScopeImpl getRecomposeScopeOrNull$runtime(int arg7) {
        SlotTableAddressSpace v6 = this.addressSpace;
        int[] v0 = v6.getGroups();
        Object[] v1 = v6.getSlots();
        int v2 = v0[arg7 + 5];
        RecomposeScopeImpl v4 = null;
        if(v2 == -1) {
            return v4;
        }

        int v3 = (v2 & 15) + 1;
        v2 >>= 4;
        if(v3 > 15) {
            v3 = SlotTableAddressSpace.access$getLargeSizes(v6).get(v2);
        }

        v3 += v2;
        v2 += GroupFlagsKt.utilitySlotsCountForFlags(v0[arg7 + 4]);
        if(v2 <= v3) {
            Object v6_1 = v1[v2];
            if((v6_1 instanceof RecomposeScopeImpl)) {
                return ((RecomposeScopeImpl)v6_1);
            }
        }

        return v4;
    }

    public final boolean getRecordCallByInformation() {
        return this.recordCallByInformation;
    }

    public final boolean getRecordSourceInformation() {
        return this.recordSourceInformation;
    }

    public final int getRoot() {
        return this.root;
    }

    private final Object[] getSlots() {
        return this.addressSpace.getSlots();
    }

    public Iterable getSlots() {
        return new SlotTable$getSlots$1(this);
    }

    public final int getVersion() {
        return this.version;
    }

    public final Object groupAux$runtime(int arg4) {
        int v0 = this.getGroups()[arg4 + 4];
        if((v0 & 0x2000000) == 0x2000000) {
            return this.groupSlotAtIndex$runtime(arg4, Integer.bitCount(v0 & 0x1800000));
        }

        return null;
    }

    public boolean groupContainsAnchor(int arg2, Anchor arg3) {
        LinkAnchor v3 = LinkAnchorKt.asLinkAnchor(arg3);
        if((this.addressSpace.ownsAnchor(v3)) && (this.isGroupAChildOf$runtime(v3.getAddress(), arg2))) {
            return 1;
        }

        return 0;
    }

    public final int groupFlags$runtime(int arg1) {
        return this.getGroups()[arg1 + 4];
    }

    public final boolean groupHasAux$runtime(int arg1) {
        if((this.getGroups()[arg1 + 4] & 0x2000000) == 0x2000000) {
            return 1;
        }

        return 0;
    }

    public final int groupKeyOf$runtime(int arg1) {
        return this.getGroups()[arg1];
    }

    public final Object groupNode$runtime(int arg3) {
        if((this.getGroups()[arg3 + 4] & 0x800000) == 0x800000) {
            return this.groupSlotAtIndex$runtime(arg3, 0);
        }

        return null;
    }

    public final Object groupObjectKey$runtime(int arg4) {
        int v0 = this.getGroups()[arg4 + 4];
        if((v0 & 0x1000000) == 0x1000000) {
            return this.groupSlotAtIndex$runtime(arg4, Integer.bitCount(v0 & 0x800000));
        }

        return null;
    }

    public final Object groupSlotAtIndex$runtime(int arg5, int arg6) {
        arg5 += 5;
        Object v2 = null;
        if(this.getGroups()[arg5] == -1) {
            return v2;
        }

        if(arg6 < 0) {
            return v2;
        }

        arg5 = this.getGroups()[arg5];
        SlotTableAddressSpace v0 = this.addressSpace;
        int v1 = (arg5 & 15) + 1;
        arg5 >>= 4;
        if(v1 > 15) {
            v1 = SlotTableAddressSpace.access$getLargeSizes(v0).get(arg5);
        }

        if(arg6 >= v1) {
            return v2;
        }

        return this.getSlots()[arg5 + arg6];
    }

    public final int groupSlotRange$runtime(int arg1) {
        return this.getGroups()[arg1 + 5];
    }

    public final boolean hasRecomposeScopes(int arg6) {
        int[] v0 = this.addressSpace.getGroups();
        Object[] v1 = this.addressSpace.getSlots();
        SlotTableAddressSpace v5 = this.getAddressSpace();
        if(arg6 >= 0) {
            IntStack v2 = new IntStack();
            int[] v5_1 = v5.getGroups();
            int v3;
            for(v3 = arg6; SlotTableKt.access$recomposeScopeOrNullInRegion(v1, v0[v3 + 5]) == null; v3 = v2.pop()) {
                if(v3 != arg6) {
                    int v4 = v5_1[v3 + 1];
                    if(v4 >= 0) {
                        v2.push(v4);
                    }
                }

                v3 = v5_1[v3 + 3];
                if(v3 >= 0) {
                    continue;
                }

                if(v2.tos == 0) {
                    return 0;
                }
            }

            return 1;
        }

        return 0;
    }

    public boolean inGroup(Anchor arg1, Anchor arg2) {
        return this.inGroup(LinkAnchorKt.asLinkAnchor(arg1), LinkAnchorKt.asLinkAnchor(arg2));
    }

    public final boolean inGroup(LinkAnchor arg4, LinkAnchor arg5) {
        if(!arg4.getValid()) {
            return 0;
        }

        if(!arg5.getValid()) {
            return 0;
        }

        int v2 = 1;
        if(Intrinsics.areEqual(arg4, arg5)) {
            return 1;
        }

        SlotTableAddressSpace v3 = this.addressSpace;
        if(!v3.ownsAnchor(arg5)) {
            return 0;
        }

        if(!v3.ownsAnchor(arg4)) {
            return 0;
        }

        int v4 = arg4.getAddress();
        int v5 = arg5.getAddress();
        if(!v3.contains(v4)) {
            return 0;
        }

        if(!v3.contains(v5)) {
            return 0;
        }

        int[] v3_1 = v3.getGroups();
        int v0;
        for(v0 = v3_1[v5 + 2]; v0 > 0; v0 = v3_1[v0 + 2]) {
            if(v0 == v4) {
                return 1;
            }

            if(v4 <= 0) {
                return 0;
            }
        }

        if(v0 != 0) {
        }
        else {
            v2 = 0;
        }

        if(v2 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + v5);
        }

        return 0;
    }

    public void invalidateAll() {
        if(this.getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot read while an editor is pending");
        }

        SlotTableAddressSpace v0 = this.getAddressSpace();
        int v1 = this.getRoot();
        if(v1 >= 0) {
            IntStack v2 = new IntStack();
            int[] v0_1 = v0.getGroups();
            while(true) {
                int v3 = this.getGroups()[v1 + 5];
                if(v3 != -1) {
                    SlotTableAddressSpace v4 = this.getAddressSpace();
                    int v5 = (v3 & 15) + 1;
                    v3 >>= 4;
                    if(v5 > 15) {
                        v5 = SlotTableAddressSpace.access$getLargeSizes(v4).get(v3);
                    }

                    int v4_1;
                    for(v4_1 = 0; v4_1 < v5; ++v4_1) {
                        Object v6 = this.getSlots()[v3 + v4_1];
                        if(Intrinsics.areEqual(v6, Composer.Companion.getEmpty())) {
                            break;
                        }

                        if((v6 instanceof RecomposeScope)) {
                        }
                        else {
                            v6 = null;
                        }

                        if(v6 != null) {
                            ((RecomposeScope)v6).invalidate();
                        }
                    }
                }

                v3 = v0_1[v1 + 1];
                if(v3 >= 0) {
                    v2.push(v3);
                }

                v1 = v0_1[v1 + 3];
                if(v1 >= 0) {
                    continue;
                }

                if(v2.tos == 0) {
                    return;
                }

                v1 = v2.pop();
            }
        }
    }

    public List invalidateGroupsWithKey(int arg20) {
        Integer v12_4;
        int v12;
        SlotTable v0 = this;
        int v1 = arg20;
        int v3 = 0;
        int v4 = 1;
        DefaultConstructorMarker v5 = null;
        MutableIntSet v2 = new MutableIntSet(0, 1, v5);
        ArrayList v6 = new ArrayList();
        MutableIntSet v7 = new MutableIntSet(0, 1, v5);
        v7.add(v1);
        int v8 = -3;
        v7.add(v8);
        MutableIntObjectMap v9 = v0.addressSpace.getCalledByMap$runtime();
        if(v9 != null) {
            Object v1_1 = v9.get(v1);
            if(v1_1 != null) {
                v7.addAll(((IntSet)v1_1));
            }
        }

        v1 = v0.root;
        SlotTableAddressSpace v9_1 = v0.getAddressSpace();
        if(v1 >= 0) {
            IntStack v10 = new IntStack();
            int[] v9_2 = v9_1.getGroups();
            int v11;
            for(v11 = v1; true; v11 = v10.pop()) {
            label_27:
                v12 = v0.addressSpace.getGroups()[v11];
                if(v7.contains(v12)) {
                    if(v12 != v8) {
                        v2.plusAssign(v11);
                    }

                    if(v4 == 0) {
                        goto label_61;
                    }

                    RecomposeScopeImpl v12_1 = v0.findEffectiveRecomposeScope(v11);
                    if(v12_1 != null) {
                        ArrayList v13 = v6;
                        ((Collection)v13).add(v12_1);
                        Anchor v12_2 = v12_1.getAnchor();
                        if(v12_2 != null) {
                            LinkAnchor v12_3 = LinkAnchorKt.asLinkAnchor(v12_2);
                            if(v12_3 != null) {
                                v12_4 = Integer.valueOf(v12_3.getAddress());
                            }
                            else {
                                goto label_46;
                            }
                        }
                        else {
                        label_46:
                            v12_4 = ((Integer)v5);
                        }

                        if(v12_4 == null) {
                            goto label_61;
                        }

                        if(v12_4.intValue() != v11) {
                            goto label_61;
                        }

                        v12_1 = v0.findEffectiveRecomposeScope(v0.addressSpace.getGroups()[v11 + 2]);
                        if(v12_1 == null) {
                            goto label_61;
                        }

                        ((Collection)v13).add(v12_1);
                        goto label_61;
                    }

                    ((List)v6).clear();
                    v4 = 0;
                }

            label_61:
                if(v11 != v1) {
                    v12 = v9_2[v11 + 1];
                    if(v12 >= 0) {
                        v10.push(v12);
                    }
                }

                v11 = v9_2[v11 + 3];
                if(v11 >= 0) {
                    goto label_27;
                }

                if(v10.tos == 0) {
                    break;
                }
            }
        }

        SlotTableEditor v1_2 = v0.openEditor();
        try {
            int[] v0_2 = ((IntSet)v2).elements;
            long[] v2_1 = ((IntSet)v2).metadata;
            int v7_1 = v2_1.length - 2;
            if(v7_1 >= 0) {
                int v9_3 = 0;
                while(true) {
                    long v10_1 = v2_1[v9_3];
                    if((~v10_1 << 7 & v10_1 & -9187201950435737472L) != -9187201950435737472L) {
                        int v13_1 = 8;
                        v12 = 8 - (~(v9_3 - v7_1) >>> 0x1F);
                        int v14 = v3;
                        while(v14 < v12) {
                            if((0xFF & v10_1) < 0x80) {
                                arg20 = v4;
                                v1_2.seek((((long)UInt.constructor-impl(v0_2[(v9_3 << 3) + v14]))) & 0xFFFFFFFFL);
                                v1_2.bashGroup$runtime(v8);
                            }
                            else {
                                arg20 = v4;
                            }

                            v10_1 >>= v13_1;
                            ++v14;
                            v4 = arg20;
                        }

                        arg20 = v4;
                        if(v12 != v13_1) {
                            break;
                        }
                    }
                    else {
                        arg20 = v4;
                    }

                    if(v9_3 == v7_1) {
                        break;
                    }

                    ++v9_3;
                    v4 = arg20;
                    v3 = 0;
                }
            }
            else {
                arg20 = v4;
            }
        }
        catch(Throwable v0_1) {
            v1_2.close();
            throw v0_1;
        }

        v1_2.close();
        if(arg20 != 0) {
            return ((List)v6);
        }

        return ((List)v5);
    }

    public boolean isEmpty() {
        if(this.root == -1) {
            return 1;
        }

        return 0;
    }

    public final boolean isGroupAChildOf$runtime(int arg3, int arg4) {
        int v1;
        int[] v2 = this.getAddressSpace().getGroups();
        int v0;
        for(v0 = arg3; true; v0 = v2[v0 + 2]) {
            v1 = 1;
            if(v0 <= 0) {
                break;
            }

            if(v0 == arg4) {
                return 1;
            }
        }

        if(v0 != 0) {
        }
        else {
            v1 = 0;
        }

        if(v1 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg3);
        }

        return 0;
    }

    public Iterator iterator() {
        return new GroupIterator(this, this.root);
    }

    public final SlotTable newTableInSameAddressSpace() {
        return new SlotTable(0, this.addressSpace, this.recordSourceInformation, this.recordCallByInformation, 1, null);
    }

    public final int nextSiblingOf$runtime(int arg1) {
        return this.getGroups()[arg1 + 1];
    }

    public final SlotTableEditor openEditor() {
        if(this.getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when another writer is pending");
        }

        int v0 = this.openReaders <= 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when a reader is pending");
        }

        ++this.version;
        SlotTableEditor v0_1 = new SlotTableEditor(this);
        this.currentEditor = v0_1;
        return v0_1;
    }

    public final SlotTableReader openReader() {
        if(this.getHasEditor()) {
            ComposerKt.composeImmediateRuntimeError("Cannot read while a writer is pending");
        }

        ++this.openReaders;
        return new SlotTableReader(this);
    }

    public boolean ownsRecomposeScope(RecomposeScopeImpl arg3) {
        Anchor v3 = arg3.getAnchor();
        if(v3 != null) {
            LinkAnchor v3_1 = LinkAnchorKt.asLinkAnchor(v3);
            if((this.addressSpace.ownsAnchor(v3_1)) && (this.isGroupAChildOf$runtime(v3_1.getAddress(), this.root))) {
                return 1;
            }
        }

        return 0;
    }

    public final Object read(Function1 arg1) {
        Object v1_1;
        SlotTableReader v0 = this.openReader();
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

    public final long rootHandle() {
        return (((long)UInt.constructor-impl(this.root))) & 0xFFFFFFFFL | -4294967296L;
    }

    public final void setRecordCallByInformation(boolean arg1) {
        this.recordCallByInformation = arg1;
    }

    public final void setRecordSourceInformation(boolean arg1) {
        this.recordSourceInformation = arg1;
    }

    public final void setRoot(int arg1) {
        this.root = arg1;
    }

    public String toDebugString() {
        return this.toDebugString(true);
    }

    public final String toDebugString(boolean arg5) {
        StringBuilder v0 = new StringBuilder();
        v0.append("SlotTable(\n");
        int v1 = this.root;
        int[] v2 = this.getAddressSpace().getGroups();
        while(v1 >= 0) {
            SlotTable.toDebugString$lambda$0$dumpGroup(v0, this, arg5, v1, "  ");
            v1 = v2[v1 + 1];
        }

        v0.append(")");
        return v0.toString();
    }

    private static final void toDebugString$lambda$0$dumpGroup(StringBuilder arg7, SlotTable arg8, boolean arg9, int arg10, String arg11) {
        arg7.append(arg11);
        int[] v0 = arg8.addressSpace.getGroups();
        arg7.append("Group(" + arg10 + ") key: " + v0[arg10]);
        Object[] v1 = arg8.addressSpace.getSlots();
        int v2 = v0[arg10 + 5];
        int v0_1 = v0[arg10 + 4];
        int v3 = 0x7FFFFF & v0_1;
        if(v3 > 0) {
            arg7.append(" Nodes: ");
            arg7.append(v3);
        }

        if((0xFC000000 & v0_1) != 0) {
            arg7.append(" Marks: ");
            if((v0_1 & 0x10000000) == 0x10000000) {
                arg7.append('C');
            }

            if((v0_1 & 0x20000000) == 0x20000000) {
                arg7.append('c');
            }

            if((v0_1 & 0x40000000) == 0x40000000) {
                arg7.append('S');
            }

            if((v0_1 & 0x80000000) == 0x80000000) {
                arg7.append('s');
            }

            if((v0_1 & 0x4000000) == 0x4000000) {
                arg7.append('R');
            }

            if((v0_1 & 0x8000000) != 0x8000000) {
                goto label_60;
            }

            arg7.append('r');
        }

    label_60:
        char v3_1 = '\n';
        if(arg9) {
            int v4 = v2 >> 4;
            int v5 = -1;
            if(v2 != v5) {
                SlotTableAddressSpace v6 = arg8.addressSpace;
                if(v2 == v5) {
                    v2 = 0;
                }
                else {
                    v2 = (v2 & 15) + 1;
                    if(v2 > 15) {
                        v2 = SlotTableAddressSpace.access$getLargeSizes(v6).get(v4);
                    }
                }

                v2 += v4;
                if((v0_1 & 0x800000) == 0x800000) {
                    arg7.append(" Node: ");
                    arg7.append(SlotTableKt.access$summarize(v1[v4], v3_1));
                    ++v4;
                }

                if((v0_1 & 0x1000000) == 0x1000000) {
                    arg7.append(" Key: ");
                    arg7.append(SlotTableKt.access$summarize(v1[v4], v3_1));
                    ++v4;
                }

                if((v0_1 & 0x2000000) == 0x2000000) {
                    arg7.append(" Aux: ");
                    arg7.append(SlotTableKt.access$summarize(v1[v4], v3_1));
                    ++v4;
                }

                if(v4 >= v2) {
                    goto label_130;
                }

                arg7.append(" (" + v4 + '-' + v2 + ")[");
                while(v4 < v2) {
                    v0_1 = v4 + 1;
                    arg7.append(SlotTableKt.access$summarize(v1[v4], v3_1));
                    if(v0_1 < v2) {
                        arg7.append(", ");
                    }

                    v4 = v0_1;
                }

                arg7.append("]");
            }
        }

    label_130:
        arg7.append(':').append(v3_1);
        arg11 = arg11 + "  ";
        v0 = arg8.getAddressSpace().getGroups();
        for(arg10 = v0[arg10 + 3]; arg10 > 0; arg10 = v0[arg10 + 1]) {
            SlotTable.toDebugString$lambda$0$dumpGroup(arg7, arg8, arg9, arg10, arg11);
        }
    }

    public final Object toDebugTree$runtime() {
        Object v2_1;
        List v2 = SequencesKt.toList(SequencesKt.sequence(new SlotTable$toDebugTree$1(this, null)));
        if(v2.size() == 1) {
            v2_1 = CollectionsKt.first(v2);
        }

        return v2_1;
    }

    public final void traverseChildren$runtime(int arg2, Function1 arg3) {
        int[] v1 = this.getAddressSpace().getGroups();
        for(arg2 = v1[arg2 + 3]; arg2 > 0; arg2 = v1[arg2 + 1]) {
            arg3.invoke(Integer.valueOf(arg2));
        }
    }

    public final void traverseGroup$runtime(int arg4, boolean arg5, Function1 arg6) {
        SlotTableAddressSpace v3 = this.getAddressSpace();
        if(arg4 >= 0) {
            IntStack v0 = new IntStack();
            int[] v3_1 = v3.getGroups();
            int v1;
            for(v1 = arg4; true; v1 = v0.pop()) {
            label_6:
                arg6.invoke(Integer.valueOf(v1));
                if(v1 != arg4 || (arg5)) {
                    int v2 = v3_1[v1 + 1];
                    if(v2 >= 0) {
                        v0.push(v2);
                    }
                }

                v1 = v3_1[v1 + 3];
                if(v1 >= 0) {
                    goto label_6;
                }

                if(v0.tos == 0) {
                    return;
                }
            }
        }
    }

    public static void traverseGroup$runtime$default(SlotTable arg1, int arg2, boolean arg3, Function1 arg4, int arg5, Object arg6) {
        SlotTableAddressSpace v1 = arg1.getAddressSpace();
        if(arg2 >= 0) {
            IntStack v5 = new IntStack();
            int[] v1_1 = v1.getGroups();
            int v6;
            for(v6 = arg2; true; v6 = v5.pop()) {
            label_9:
                arg4.invoke(Integer.valueOf(v6));
                if(v6 != arg2 || 0 != 0) {
                    int v0 = v1_1[v6 + 1];
                    if(v0 >= 0) {
                        v5.push(v0);
                    }
                }

                v6 = v1_1[v6 + 3];
                if(v6 >= 0) {
                    goto label_9;
                }

                if(v5.tos == 0) {
                    return;
                }
            }
        }
    }

    public final void traverseGroupAndParents$runtime(int arg3, Function1 arg4) {
        int[] v2 = this.getAddressSpace().getGroups();
        int v0;
        for(v0 = arg3; v0 > 0; v0 = v2[v0 + 2]) {
            arg4.invoke(Integer.valueOf(v0));
        }

        int v2_1 = v0 != 0 ? 1 : 0;
        if(v2_1 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg3);
        }
    }

    public final void traverseSiblings$runtime(int arg2, Function1 arg3) {
        int[] v1 = this.getAddressSpace().getGroups();
        while(arg2 >= 0) {
            arg3.invoke(Integer.valueOf(arg2));
            arg2 = v1[arg2 + 1];
        }
    }

    public final void traverseTable$runtime(Function1 arg4) {
        SlotTableAddressSpace v0 = this.getAddressSpace();
        int v3 = this.getRoot();
        if(v3 >= 0) {
            IntStack v1 = new IntStack();
            int[] v0_1 = v0.getGroups();
            while(true) {
                arg4.invoke(Integer.valueOf(v3));
                int v2 = v0_1[v3 + 1];
                if(v2 >= 0) {
                    v1.push(v2);
                }

                v3 = v0_1[v3 + 3];
                if(v3 >= 0) {
                    continue;
                }

                if(v1.tos == 0) {
                    return;
                }

                v3 = v1.pop();
            }
        }
    }

    public void verifyWellFormed() {
        this.addressSpace.validate();
        int[] v2 = this.addressSpace.getGroups();
        Object[] v4 = this.addressSpace.getSlots();
        MutableIntSet v1 = IntSetKt.mutableIntSetOf();
        int v0 = this.root;
        int[] v7 = this.getAddressSpace().getGroups();
        int v6;
        for(v6 = v0; v6 >= 0; v6 = v7[v6 + 1]) {
            SlotTable.verifyWellFormed$validateGroup(v1, v2, this, v4, -1, v6);
        }
    }

    private static final int verifyWellFormed$validateGroup(MutableIntSet arg15, int[] arg16, SlotTable arg17, Object[] arg18, int arg19, int arg20) {
        String v2_1;
        int v0;
        int v13;
        String v12;
        char v11;
        int v4 = arg20;
        if(v4 == -1) {
            return 0;
        }

        if(!arg15.contains(v4)) {
            arg15.add(v4);
            if(v4 % 6 == 0) {
                if(arg16[v4 + 2] == arg19) {
                    SlotTable v2 = arg17;
                    Object[] v3 = arg18;
                    SlotTable.verifyWellFormed$validateSlotRange(v2, v3, v4, arg16[v4 + 5]);
                    int v6 = v4 + 4;
                    int v7 = arg16[v6] & 0xA8000000;
                    int[] v8 = v2.getAddressSpace().getGroups();
                    int v5 = v8[v4 + 3];
                    int v9 = 0;
                    int v10 = 0;
                    while(true) {
                        v11 = ' ';
                        v12 = "toString(...)";
                        v13 = 16;
                        if(v5 <= 0) {
                            break;
                        }

                        v9 += SlotTable.verifyWellFormed$validateGroup(arg15, arg16, v2, v3, v4, v5);
                        v0 = GroupFlagsKt.propagatingFlagsOf(arg16[v5 + 4]);
                        v10 |= v0;
                        if(v0 != 0) {
                            if((v7 & v0) != 0) {
                            }
                            else {
                                StringBuilder v1 = new StringBuilder("Group ").append(v5).append(" contains a flag that the parent, ").append(v4).append(", is not recorded as having, ");
                                v2_1 = Integer.toString(v0, CharsKt.checkRadix(v13));
                                Intrinsics.checkNotNullExpressionValue(v2_1, v12);
                                throw new IllegalStateException(v1.append(v2_1).append(v11).append(SlotTableKt.access$flagsNames(v0)).toString().toString());
                            }
                        }

                        v5 = v8[v5 + 1];
                        v2 = arg17;
                        v3 = arg18;
                    }

                    int v15 = arg16[v6];
                    v0 = 0x7FFFFF;
                    int v1_1 = v15 & v0;
                    v2_1 = ", expected ";
                    if(v1_1 == v9) {
                        if(v7 == v10) {
                            if((v15 & 0x800000) == 0x800000) {
                                return 1;
                            }

                            return v15 & v0;
                        }

                        StringBuilder v0_1 = new StringBuilder("Unexpected has mark flags for group ").append(v4).append(v2_1);
                        String v1_2 = Integer.toString(v10, CharsKt.checkRadix(v13));
                        Intrinsics.checkNotNullExpressionValue(v1_2, v12);
                        v0_1 = v0_1.append(v1_2).append(v11).append(SlotTableKt.access$flagsNames(v10)).append(", received ");
                        v1_2 = Integer.toString(v7, CharsKt.checkRadix(v13));
                        Intrinsics.checkNotNullExpressionValue(v1_2, v12);
                        throw new IllegalStateException(v0_1.append(v1_2).append(v11).append(SlotTableKt.access$flagsNames(v7)).toString().toString());
                    }

                    throw new IllegalStateException("Unexpected node count for group " + v4 + v2_1 + v9 + ", received: " + v1_1.toString());
                }

                throw new IllegalStateException("Invalid parent link in group " + v4.toString());
            }

            throw new IllegalStateException("Invalid group address: " + v4.toString());
        }

        throw new IllegalStateException("Circular group encountered at " + v4.toString());
    }

    private static final void verifyWellFormed$validateSlotRange(SlotTable arg2, Object[] arg3, int arg4, int arg5) {
        if(arg5 == -1) {
        }
        else {
            SlotTableAddressSpace v2 = arg2.addressSpace;
            int v0 = (arg5 & 15) + 1;
            arg5 >>= 4;
            if(v0 > 15) {
                SlotTableAddressSpace.access$getLargeSizes(v2).get(arg5);
            }

            if(arg5 >= 0 && arg5 < arg3.length) {
                return;
            }

            goto label_15;
        }

        return;
    label_15:
        throw new IllegalStateException("Slot index for group " + arg4 + " out of bounds: " + arg5.toString());
    }
}

