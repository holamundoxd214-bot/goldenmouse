package androidx.compose.runtime.composer.gapbuffer;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SlotStorage;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u000B\n\u0002\u0010\u001C\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A2\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0082\b¢\u0006\u0002\u0010\u0006\u001A>\u0010\u0007\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\bj\b\u0012\u0004\u0012\u0002H\u0002`\t2\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000B0\u0005H\u0082\b¢\u0006\u0002\u0010\f\u001A7\u0010\r\u001A\u00020\u000E\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\bj\b\u0012\u0004\u0012\u0002H\u0002`\t2\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000B0\u0005H\u0082\b\u001A\u0014\u0010\u000F\u001A\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u000EH\u0002\u001A\u0014\u0010\u0012\u001A\u00020\u0013*\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u000EH\u0000\u001A\u0015\u00101\u001A\u00020\u000E*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0082\b\u001A\u0015\u00104\u001A\u00020\u000B*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0082\b\u001A\u0015\u00105\u001A\u00020\u000E*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0082\b\u001A\u0015\u00106\u001A\u00020\u000B*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0082\b\u001A\u0014\u00107\u001A\u00020\u000E*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0002\u001A\u0015\u00108\u001A\u00020\u000B*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0082\b\u001A\u0014\u00109\u001A\u00020\u0001*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0002\u001A\u0015\u0010:\u001A\u00020\u000B*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0082\b\u001A\u001C\u0010;\u001A\u00020\u0001*\u0002022\u0006\u00103\u001A\u00020\u000E2\u0006\u0010<\u001A\u00020\u000BH\u0002\u001A\u0015\u0010=\u001A\u00020\u000B*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0082\b\u001A\u001C\u0010>\u001A\u00020\u0001*\u0002022\u0006\u00103\u001A\u00020\u000E2\u0006\u0010<\u001A\u00020\u000BH\u0002\u001A\u0015\u0010?\u001A\u00020\u000B*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0082\b\u001A\u0014\u0010@\u001A\u00020\u000E*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0002\u001A\u0014\u0010A\u001A\u00020\u000E*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0002\u001A\u0011\u0010B\u001A\u00020\u000E2\u0006\u0010<\u001A\u00020\u000EH\u0082\b\u001A\u0015\u0010C\u001A\u00020\u000E*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0082\b\u001A\u001C\u0010D\u001A\b\u0012\u0004\u0012\u00020\u000E0E*\u0002022\b\b\u0002\u0010F\u001A\u00020\u000EH\u0002\u001A\u0015\u0010G\u001A\u00020\u000E*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0082\b\u001A\u001C\u0010H\u001A\u00020\u0001*\u0002022\u0006\u00103\u001A\u00020\u000E2\u0006\u0010<\u001A\u00020\u000EH\u0002\u001A\u001C\u0010I\u001A\b\u0012\u0004\u0012\u00020\u000E0E*\u0002022\b\b\u0002\u0010F\u001A\u00020\u000EH\u0002\u001A\u0015\u0010J\u001A\u00020\u000E*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0082\b\u001A\u001D\u0010K\u001A\u00020\u0001*\u0002022\u0006\u00103\u001A\u00020\u000E2\u0006\u0010<\u001A\u00020\u000EH\u0082\b\u001A\u001C\u0010L\u001A\b\u0012\u0004\u0012\u00020\u000E0E*\u0002022\b\b\u0002\u0010F\u001A\u00020\u000EH\u0002\u001A\u0014\u0010M\u001A\u00020\u000E*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0002\u001A\u001C\u0010N\u001A\u00020\u0001*\u0002022\u0006\u00103\u001A\u00020\u000E2\u0006\u0010<\u001A\u00020\u000EH\u0002\u001A \u0010O\u001A\b\u0012\u0004\u0012\u00020\u000E0E*\u0002022\f\u0010P\u001A\b\u0012\u0004\u0012\u00020\u000E0QH\u0002\u001A\u001C\u0010R\u001A\b\u0012\u0004\u0012\u00020\u000E0E*\u0002022\b\b\u0002\u0010F\u001A\u00020\u000EH\u0002\u001A\u0015\u0010S\u001A\u00020\u000E*\u0002022\u0006\u00103\u001A\u00020\u000EH\u0082\b\u001A\u001D\u0010T\u001A\u00020\u0001*\u0002022\u0006\u00103\u001A\u00020\u000E2\u0006\u0010U\u001A\u00020\u000EH\u0082\b\u001A\u001C\u0010V\u001A\b\u0012\u0004\u0012\u00020\u000E0E*\u0002022\b\b\u0002\u0010F\u001A\u00020\u000EH\u0002\u001AD\u0010W\u001A\u00020\u0001*\u0002022\u0006\u00103\u001A\u00020\u000E2\u0006\u0010C\u001A\u00020\u000E2\u0006\u00104\u001A\u00020\u000B2\u0006\u0010X\u001A\u00020\u000B2\u0006\u0010Y\u001A\u00020\u000B2\u0006\u0010J\u001A\u00020\u000E2\u0006\u0010S\u001A\u00020\u000EH\u0002\u001A\r\u0010Z\u001A\u00020\u000E*\u00020\u000BH\u0082\b\u001A\u001C\u0010[\u001A\u00020\u0001*\u0002022\u0006\u00103\u001A\u00020\u000E2\u0006\u0010C\u001A\u00020\u000EH\u0002\u001A;\u0010\\\u001A\u00020]*\u0012\u0012\u0004\u0012\u00020]0\bj\b\u0012\u0004\u0012\u00020]`\t2\u0006\u0010^\u001A\u00020\u000E2\u0006\u0010_\u001A\u00020\u000E2\f\u0010`\u001A\b\u0012\u0004\u0012\u00020]0aH\u0082\b\u001A.\u0010b\u001A\u0004\u0018\u00010]*\u0012\u0012\u0004\u0012\u00020]0\bj\b\u0012\u0004\u0012\u00020]`\t2\u0006\u0010^\u001A\u00020\u000E2\u0006\u0010_\u001A\u00020\u000EH\u0002\u001A,\u0010c\u001A\u00020\u000E*\u0012\u0012\u0004\u0012\u00020]0\bj\b\u0012\u0004\u0012\u00020]`\t2\u0006\u0010d\u001A\u00020\u000E2\u0006\u0010_\u001A\u00020\u000EH\u0002\u001A,\u0010e\u001A\u00020\u000E*\u0012\u0012\u0004\u0012\u00020]0\bj\b\u0012\u0004\u0012\u00020]`\t2\u0006\u0010^\u001A\u00020\u000E2\u0006\u0010_\u001A\u00020\u000EH\u0002\u001A\"\u0010g\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020i0h2\u0006\u0010C\u001A\u00020\u000E2\u0006\u0010<\u001A\u00020\u000EH\u0002\u001A\b\u0010j\u001A\u00020\u0001H\u0000\u001A\f\u0010k\u001A\u00020\u0014*\u00020lH\u0000\"\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0018\u001A\u00020\u000E*\u00020\u00198Â\u0002X\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001B\"\u000E\u0010\u001C\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001D\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001E\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u001F\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010 \u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010!\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\"\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010#\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010$\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010%\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010&\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\'\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010(\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010)\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010*\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010+\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010,\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010-\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010.\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010/\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u00100\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010f\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010m\u001A\u00020\u000E*\u00020n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bo\u0010p¨\u0006q"}, d2={"fastForEach", "", "T", "", "action", "Lkotlin/Function1;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastLastOrNull", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "predicate", "", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "fastIndexOf", "", "summarize", "", "size", "compositionGroupOf", "Landroidx/compose/runtime/tooling/CompositionGroup;", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "group", "EmptyLongArray", "", "firstBitSet", "", "getFirstBitSet", "(J)I", "parentAnchorPivot", "Key_Offset", "GroupInfo_Offset", "ParentAnchor_Offset", "Size_Offset", "DataAnchor_Offset", "Group_Fields_Size", "NodeBit_Mask", "NodeBit_Shift", "ObjectKey_Mask", "ObjectKey_Shift", "Aux_Mask", "Aux_Shift", "Mark_Mask", "Mark_Shift", "ContainsMark_Mask", "ContainsMark_Shift", "Slots_Shift", "NodeCount_Mask", "MinGroupGrowthSize", "MinSlotsGrowthSize", "groupInfo", "", "address", "isNode", "nodeIndex", "hasObjectKey", "objectKeyIndex", "hasAux", "addAux", "hasMark", "updateMark", "value", "containsMark", "updateContainsMark", "containsAnyMark", "auxIndex", "slotAnchor", "countOneBits", "key", "keys", "", "len", "nodeCount", "updateNodeCount", "nodeCounts", "parentAnchor", "updateParentAnchor", "parentAnchors", "groupSize", "updateGroupSize", "slice", "indices", "", "groupSizes", "dataAnchor", "updateDataAnchor", "anchor", "dataAnchors", "initGroup", "hasDataKey", "hasData", "toBit", "updateGroupKey", "getOrAdd", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "index", "effectiveSize", "block", "Lkotlin/Function0;", "find", "search", "location", "locationOf", "LIVE_EDIT_INVALID_KEY", "add", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "throwConcurrentModificationException", "asGapBufferSlotTable", "Landroidx/compose/runtime/SlotStorage;", "nextGroup", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "getNextGroup", "(Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;)I", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SlotTableKt {
    private static final int Aux_Mask = 0x10000000;
    private static final int Aux_Shift = 28;
    private static final int ContainsMark_Mask = 0x4000000;
    private static final int ContainsMark_Shift = 26;
    private static final int DataAnchor_Offset = 4;
    private static final long[] EmptyLongArray = null;
    private static final int GroupInfo_Offset = 1;
    private static final int Group_Fields_Size = 5;
    private static final int Key_Offset = 0;
    private static final int LIVE_EDIT_INVALID_KEY = -3;
    private static final int Mark_Mask = 0x8000000;
    private static final int Mark_Shift = 27;
    private static final int MinGroupGrowthSize = 0x20;
    private static final int MinSlotsGrowthSize = 0x20;
    private static final int NodeBit_Mask = 0x40000000;
    private static final int NodeBit_Shift = 30;
    private static final int NodeCount_Mask = 0x3FFFFFF;
    private static final int ObjectKey_Mask = 0x20000000;
    private static final int ObjectKey_Shift = 29;
    private static final int ParentAnchor_Offset = 2;
    private static final int Size_Offset = 3;
    private static final int Slots_Shift = 28;
    private static final int parentAnchorPivot = -2;

    static {
        SlotTableKt.EmptyLongArray = new long[0];
    }

    public static final void access$add(MutableIntObjectMap arg0, int arg1, int arg2) {
        SlotTableKt.add(arg0, arg1, arg2);
    }

    public static final void access$addAux(int[] arg0, int arg1) {
        SlotTableKt.addAux(arg0, arg1);
    }

    public static final int access$auxIndex(int[] arg0, int arg1) {
        return SlotTableKt.auxIndex(arg0, arg1);
    }

    public static final List access$dataAnchors(int[] arg0, int arg1) {
        return SlotTableKt.dataAnchors(arg0, arg1);
    }

    public static final GapAnchor access$find(ArrayList arg0, int arg1, int arg2) {
        return SlotTableKt.find(arg0, arg1, arg2);
    }

    public static final long[] access$getEmptyLongArray$p() {
        return SlotTableKt.EmptyLongArray;
    }

    public static final int access$getNextGroup(SlotWriter arg0) {
        return SlotTableKt.getNextGroup(arg0);
    }

    public static final int access$groupSize(int[] arg0, int arg1) {
        return SlotTableKt.groupSize(arg0, arg1);
    }

    public static final List access$groupSizes(int[] arg0, int arg1) {
        return SlotTableKt.groupSizes(arg0, arg1);
    }

    public static final void access$initGroup(int[] arg0, int arg1, int arg2, boolean arg3, boolean arg4, boolean arg5, int arg6, int arg7) {
        SlotTableKt.initGroup(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static final List access$keys(int[] arg0, int arg1) {
        return SlotTableKt.keys(arg0, arg1);
    }

    public static final int access$locationOf(ArrayList arg0, int arg1, int arg2) {
        return SlotTableKt.locationOf(arg0, arg1, arg2);
    }

    public static final List access$nodeCounts(int[] arg0, int arg1) {
        return SlotTableKt.nodeCounts(arg0, arg1);
    }

    public static final int access$objectKeyIndex(int[] arg0, int arg1) {
        return SlotTableKt.objectKeyIndex(arg0, arg1);
    }

    public static final List access$parentAnchors(int[] arg0, int arg1) {
        return SlotTableKt.parentAnchors(arg0, arg1);
    }

    public static final int access$search(ArrayList arg0, int arg1, int arg2) {
        return SlotTableKt.search(arg0, arg1, arg2);
    }

    public static final int access$slotAnchor(int[] arg0, int arg1) {
        return SlotTableKt.slotAnchor(arg0, arg1);
    }

    public static final String access$summarize(String arg0, int arg1) {
        return SlotTableKt.summarize(arg0, arg1);
    }

    public static final void access$updateContainsMark(int[] arg0, int arg1, boolean arg2) {
        SlotTableKt.updateContainsMark(arg0, arg1, arg2);
    }

    public static final void access$updateGroupKey(int[] arg0, int arg1, int arg2) {
        SlotTableKt.updateGroupKey(arg0, arg1, arg2);
    }

    public static final void access$updateGroupSize(int[] arg0, int arg1, int arg2) {
        SlotTableKt.updateGroupSize(arg0, arg1, arg2);
    }

    public static final void access$updateMark(int[] arg0, int arg1, boolean arg2) {
        SlotTableKt.updateMark(arg0, arg1, arg2);
    }

    public static final void access$updateNodeCount(int[] arg0, int arg1, int arg2) {
        SlotTableKt.updateNodeCount(arg0, arg1, arg2);
    }

    private static final void add(MutableIntObjectMap arg4, int arg5, int arg6) {
        MutableIntSet v0_1;
        Object v0 = arg4.get(arg5);
        if(v0 == null) {
            v0_1 = new MutableIntSet(0, 1, null);
            arg4.set(arg5, v0_1);
        }

        v0_1.add(arg6);
    }

    private static final void addAux(int[] arg2, int arg3) {
        arg3 = arg3 * 5 + 1;
        arg2[arg3] |= 0x10000000;
    }

    public static final SlotTable asGapBufferSlotTable(SlotStorage arg1) {
        if((arg1 instanceof SlotTable)) {
        }
        else {
            arg1 = null;
        }

        if(0 != 0) {
            return arg1;
        }

        ComposerKt.composeRuntimeError("Inconsistent composition");
        throw new KotlinNothingValueException();
    }

    private static final int auxIndex(int[] arg1, int arg2) {
        arg2 *= 5;
        if(arg2 >= arg1.length) {
            return arg1.length;
        }

        return arg1[arg2 + 4] + Integer.bitCount(arg1[arg2 + 1] >> 29);
    }

    public static final CompositionGroup compositionGroupOf(SlotTable arg2, int arg3) {
        return new SlotTableGroup(arg2, arg3, arg2.getVersion$runtime());
    }

    private static final boolean containsAnyMark(int[] arg1, int arg2) {
        if((arg1[arg2 * 5 + 1] & 0xC000000) != 0) {
            return 1;
        }

        return 0;
    }

    private static final boolean containsMark(int[] arg1, int arg2) {
        if((arg1[arg2 * 5 + 1] & 0x4000000) != 0) {
            return 1;
        }

        return 0;
    }

    private static final int countOneBits(int arg0) {
        return Integer.bitCount(arg0);
    }

    private static final int dataAnchor(int[] arg0, int arg1) {
        return arg0[arg1 * 5 + 4];
    }

    private static final List dataAnchors(int[] arg1, int arg2) {
        return SlotTableKt.slice(arg1, RangesKt.step(RangesKt.until(4, arg2), 5));
    }

    static List dataAnchors$default(int[] arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.length;
        }

        return SlotTableKt.dataAnchors(arg0, arg1);
    }

    private static final void fastForEach(Object[] arg3, Function1 arg4) {
        int v0 = arg3.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4.invoke(arg3[v1]);
        }
    }

    private static final int fastIndexOf(ArrayList arg3, Function1 arg4) {
        int v0 = arg3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(arg4.invoke(arg3.get(v1)).booleanValue()) {
                return v1;
            }
        }

        return -1;
    }

    private static final Object fastLastOrNull(ArrayList arg3, Function1 arg4) {
        int v0;
        for(v0 = arg3.size() - 1; v0 >= 0; --v0) {
            Object v1 = arg3.get(v0);
            if(arg4.invoke(v1).booleanValue()) {
                return v1;
            }
        }

        return null;
    }

    private static final GapAnchor find(ArrayList arg0, int arg1, int arg2) {
        arg1 = SlotTableKt.search(arg0, arg1, arg2);
        if(arg1 >= 0) {
            return arg0.get(arg1);
        }

        return null;
    }

    private static final int getFirstBitSet(long arg0) {
        return Long.numberOfTrailingZeros(arg0);
    }

    private static final int getNextGroup(SlotWriter arg2) {
        return arg2.getCurrentGroup() + arg2.groupSize(arg2.getCurrentGroup());
    }

    private static final GapAnchor getOrAdd(ArrayList arg0, int arg1, int arg2, Function0 arg3) {
        arg1 = SlotTableKt.search(arg0, arg1, arg2);
        if(arg1 < 0) {
            Object v2 = arg3.invoke();
            arg0.add(-(arg1 + 1), v2);
            return ((GapAnchor)v2);
        }

        return arg0.get(arg1);
    }

    private static final int groupInfo(int[] arg0, int arg1) {
        return arg0[arg1 * 5 + 1];
    }

    private static final int groupSize(int[] arg0, int arg1) {
        return arg0[arg1 * 5 + 3];
    }

    private static final List groupSizes(int[] arg1, int arg2) {
        return SlotTableKt.slice(arg1, RangesKt.step(RangesKt.until(3, arg2), 5));
    }

    static List groupSizes$default(int[] arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.length;
        }

        return SlotTableKt.groupSizes(arg0, arg1);
    }

    private static final boolean hasAux(int[] arg1, int arg2) {
        if((arg1[arg2 * 5 + 1] & 0x10000000) != 0) {
            return 1;
        }

        return 0;
    }

    private static final boolean hasMark(int[] arg1, int arg2) {
        if((arg1[arg2 * 5 + 1] & 0x8000000) != 0) {
            return 1;
        }

        return 0;
    }

    private static final boolean hasObjectKey(int[] arg1, int arg2) {
        if((arg1[arg2 * 5 + 1] & 0x20000000) != 0) {
            return 1;
        }

        return 0;
    }

    private static final void initGroup(int[] arg0, int arg1, int arg2, boolean arg3, boolean arg4, boolean arg5, int arg6, int arg7) {
        arg1 *= 5;
        arg0[arg1] = arg2;
        arg0[arg1 + 1] = (((int)arg3)) << 30 | (((int)arg4)) << 29 | (((int)arg5)) << 28;
        arg0[arg1 + 2] = arg6;
        arg0[arg1 + 3] = 0;
        arg0[arg1 + 4] = arg7;
    }

    private static final boolean isNode(int[] arg1, int arg2) {
        if((arg1[arg2 * 5 + 1] & 0x40000000) != 0) {
            return 1;
        }

        return 0;
    }

    private static final int key(int[] arg0, int arg1) {
        return arg0[arg1 * 5];
    }

    private static final List keys(int[] arg1, int arg2) {
        return SlotTableKt.slice(arg1, RangesKt.step(RangesKt.until(0, arg2), 5));
    }

    static List keys$default(int[] arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.length;
        }

        return SlotTableKt.keys(arg0, arg1);
    }

    private static final int locationOf(ArrayList arg0, int arg1, int arg2) {
        int v0 = SlotTableKt.search(arg0, arg1, arg2);
        if(v0 >= 0) {
            return v0;
        }

        return -(v0 + 1);
    }

    private static final int nodeCount(int[] arg0, int arg1) {
        return arg0[arg1 * 5 + 1] & 0x3FFFFFF;
    }

    private static final List nodeCounts(int[] arg5, int arg6) {
        List v5 = SlotTableKt.slice(arg5, RangesKt.step(RangesKt.until(1, arg6), 5));
        ArrayList v6 = new ArrayList(v5.size());
        int v0 = v5.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            v6.add(Integer.valueOf(v5.get(v1).intValue() & 0x3FFFFFF));
        }

        return ((List)v6);
    }

    static List nodeCounts$default(int[] arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.length;
        }

        return SlotTableKt.nodeCounts(arg0, arg1);
    }

    private static final int nodeIndex(int[] arg0, int arg1) {
        return arg0[arg1 * 5 + 4];
    }

    private static final int objectKeyIndex(int[] arg1, int arg2) {
        arg2 *= 5;
        return arg1[arg2 + 4] + Integer.bitCount(arg1[arg2 + 1] >> 30);
    }

    private static final int parentAnchor(int[] arg0, int arg1) {
        return arg0[arg1 * 5 + 2];
    }

    private static final List parentAnchors(int[] arg1, int arg2) {
        return SlotTableKt.slice(arg1, RangesKt.step(RangesKt.until(2, arg2), 5));
    }

    static List parentAnchors$default(int[] arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.length;
        }

        return SlotTableKt.parentAnchors(arg0, arg1);
    }

    private static final int search(ArrayList arg4, int arg5, int arg6) {
        int v2;
        int v0 = arg4.size() - 1;
        int v1 = 0;
        while(true) {
            if(v1 > v0) {
                goto label_18;
            }

            v2 = v1 + v0 >>> 1;
            int v3 = arg4.get(v2).getLocation$runtime();
            if(v3 < 0) {
                v3 += arg6;
            }

            v3 = Intrinsics.compare(v3, arg5);
            if(v3 < 0) {
                v1 = v2 + 1;
                continue;
            }

            if(v3 <= 0) {
                return v2;
            }

            v0 = v2 - 1;
        }

        return v2;
    label_18:
        return -(v1 + 1);
    }

    private static final List slice(int[] arg2, Iterable arg3) {
        ArrayList v0 = new ArrayList();
        Iterator v3 = arg3.iterator();
        while(v3.hasNext()) {
            ((List)v0).add(Integer.valueOf(arg2[v3.next().intValue()]));
        }

        return ((List)v0);
    }

    private static final int slotAnchor(int[] arg1, int arg2) {
        arg2 *= 5;
        return arg1[arg2 + 4] + Integer.bitCount(arg1[arg2 + 1] >> 28);
    }

    private static final String summarize(String arg12, int arg13) {
        arg12 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(arg12, "androidx.", "a.", false, 4, null), "compose.", "c.", false, 4, null), "runtime.", "r.", false, 4, null), "internal.", "ι.", false, 4, null), "ui.", "u.", false, 4, null), "Modifier", "μ", false, 4, null), "material.", "m.", false, 4, null), "Function", "λ", false, 4, null), "OpaqueKey", "κ", false, 4, null), "MutableState", "σ", false, 4, null);
        arg12 = arg12.substring(0, Math.min(arg13, arg12.length()));
        Intrinsics.checkNotNullExpressionValue(arg12, "substring(...)");
        return arg12;
    }

    public static final void throwConcurrentModificationException() {
        throw new ConcurrentModificationException();
    }

    private static final int toBit(boolean arg0) {
        return arg0;
    }

    private static final void updateContainsMark(int[] arg2, int arg3, boolean arg4) {
        arg3 = arg3 * 5 + 1;
        arg2[arg3] = (((int)arg4)) << 26 | arg2[arg3] & 0xFBFFFFFF;
    }

    private static final void updateDataAnchor(int[] arg0, int arg1, int arg2) {
        arg0[arg1 * 5 + 4] = arg2;
    }

    private static final void updateGroupKey(int[] arg0, int arg1, int arg2) {
        arg0[arg1 * 5] = arg2;
    }

    private static final void updateGroupSize(int[] arg0, int arg1, int arg2) {
        arg0[arg1 * 5 + 3] = arg2;
    }

    private static final void updateMark(int[] arg2, int arg3, boolean arg4) {
        arg3 = arg3 * 5 + 1;
        arg2[arg3] = (((int)arg4)) << 27 | arg2[arg3] & 0xF7FFFFFF;
    }

    private static final void updateNodeCount(int[] arg2, int arg3, int arg4) {
        arg3 = arg3 * 5 + 1;
        arg2[arg3] = arg4 | arg2[arg3] & 0xFC000000;
    }

    private static final void updateParentAnchor(int[] arg0, int arg1, int arg2) {
        arg0[arg1 * 5 + 2] = arg2;
    }
}

