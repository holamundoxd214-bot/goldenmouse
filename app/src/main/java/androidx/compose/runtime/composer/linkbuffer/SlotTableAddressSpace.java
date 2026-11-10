package androidx.compose.runtime.composer.linkbuffer;

import androidx.collection.IntIntMapKt;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.ArraysKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001D\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 \u008C\u00012\u00020\u0001:\u0002\u008C\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001D\b\u0016\u0012\b\b\u0001\u0010\b\u001A\u00020\t\u0012\b\b\u0001\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0006\u0010\u000BB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\fJ\u0006\u0010/\u001A\u000200J-\u00101\u001A\u00060\tj\u0002`22\u0006\u00103\u001A\u00020\t2\n\u00104\u001A\u00060\tj\u0002`22\n\u00105\u001A\u00060\tj\u0002`6H\u0086\bJ\u0012\u00107\u001A\u0002002\n\u00108\u001A\u00060\tj\u0002`2J\u0014\u00109\u001A\u0002002\n\u00108\u001A\u00060\tj\u0002`2H\u0002J\u0014\u0010:\u001A\u0002002\n\u00108\u001A\u00060\tj\u0002`2H\u0002J\u0006\u0010;\u001A\u00020<J\u0016\u0010=\u001A\u0002002\u0006\u0010>\u001A\u00020\t2\u0006\u0010?\u001A\u00020\tJ\u0016\u0010@\u001A\u0002002\u0006\u00108\u001A\u00020\t2\u0006\u0010A\u001A\u00020\tJ\u001C\u0010B\u001A\u0004\u0018\u00010\u00012\n\u0010C\u001A\u00060\tj\u0002`22\u0006\u0010D\u001A\u00020\tJ(\u0010E\u001A\u00060\tj\u0002`F2\n\u0010C\u001A\u00060\tj\u0002`22\u0006\u0010D\u001A\u00020\t2\b\u0010G\u001A\u0004\u0018\u00010\u0001J\u0014\u0010H\u001A\u0004\u0018\u00010 2\n\u0010C\u001A\u00060\tj\u0002`2J(\u0010I\u001A\u00020 2\n\u00104\u001A\u00060\tj\u0002`22\b\u0010J\u001A\u0004\u0018\u00010K2\n\u0010C\u001A\u00060\tj\u0002`2J\u0016\u0010L\u001A\u0002002\u0006\u00103\u001A\u00020\t2\u0006\u0010M\u001A\u00020\tJ\u0010\u0010N\u001A\u00020\t2\u0006\u0010A\u001A\u00020\tH\u0002J&\u0010O\u001A\u00060\tj\u0002`F2\n\u0010C\u001A\u00060\tj\u0002`22\u0006\u0010A\u001A\u00020\t2\u0006\u0010P\u001A\u00020\tJ\u001E\u0010O\u001A\u00060\tj\u0002`F2\n\u0010C\u001A\u00060\tj\u0002`22\u0006\u0010P\u001A\u00020\tJ\u001E\u0010Q\u001A\u00060\tj\u0002`22\u0006\u0010R\u001A\u00020\u00002\n\u0010S\u001A\u00060\tj\u0002`2J\u001E\u0010T\u001A\u0002002\n\u0010C\u001A\u00060\tj\u0002`22\n\u0010U\u001A\u00060\tj\u0002`2J\u0012\u0010V\u001A\u00020\u001D2\n\u00108\u001A\u00060\tj\u0002`2J\u000E\u0010W\u001A\u00020X2\u0006\u0010Y\u001A\u00020\u001DJ(\u0010Z\u001A\u0004\u0018\u00010\u001D2\u0006\u0010R\u001A\u00020\u00002\n\u0010[\u001A\u00060\tj\u0002`22\n\u0010\\\u001A\u00060\tj\u0002`2J\u0018\u0010]\u001A\u0002002\u0006\u0010R\u001A\u00020\u00002\b\u0010Y\u001A\u0004\u0018\u00010\u001DJ%\u0010^\u001A\u00020\t2\n\u0010_\u001A\u00060\tj\u0002`22\n\u0010`\u001A\u00060\tj\u0002`2H\u0000¢\u0006\u0002\baJA\u0010b\u001A\u0002002\n\u0010C\u001A\u00060\tj\u0002`22%\u0010c\u001A!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bgJA\u0010h\u001A\u0002002\n\u0010C\u001A\u00060\tj\u0002`22%\u0010c\u001A!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\biJA\u0010j\u001A\u0002002\n\u00104\u001A\u00060\tj\u0002`22%\u0010c\u001A!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bkJA\u0010l\u001A\u0002002\n\u0010C\u001A\u00060\tj\u0002`22%\u0010c\u001A!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bmJK\u0010n\u001A\u0002002\n\u0010C\u001A\u00060\tj\u0002`22\b\b\u0002\u0010o\u001A\u00020X2%\u0010c\u001A!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bpJK\u0010q\u001A\u0002002\n\u0010>\u001A\u00060\tj\u0002`22\b\b\u0002\u0010r\u001A\u00020X2%\u0010c\u001A!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bsJK\u0010t\u001A\u0002002\n\u0010>\u001A\u00060\tj\u0002`22\b\b\u0002\u0010r\u001A\u00020X2%\u0010c\u001A!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020X0dH\u0080\b¢\u0006\u0002\buJA\u0010v\u001A\u0002002\n\u00104\u001A\u00060\tj\u0002`22%\u0010c\u001A!\u0012\u0017\u0012\u00150\tj\u0002`2¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002000dH\u0080\b¢\u0006\u0002\bwJ\u0015\u0010x\u001A\u00020X2\n\u0010C\u001A\u00060\tj\u0002`2H\u0086\u0002J$\u0010y\u001A\u00020\t2\n\u0010C\u001A\u00060\tj\u0002`22\u0006\u0010z\u001A\u00020\t2\u0006\u0010P\u001A\u00020\tH\u0002J(\u0010{\u001A\u00060\tj\u0002`F2\n\u0010|\u001A\u00060\tj\u0002`F2\u0006\u0010z\u001A\u00020\t2\u0006\u0010P\u001A\u00020\tH\u0002J(\u0010}\u001A\u00060\tj\u0002`F2\n\u0010C\u001A\u00060\tj\u0002`22\u0006\u0010z\u001A\u00020\t2\u0006\u0010P\u001A\u00020\tH\u0002J\u0015\u0010~\u001A\u00020\t2\n\u0010\u007F\u001A\u00060\tj\u0002`FH\u0086\bJ[\u0010\u0080\u0001\u001A\u0003H\u0081\u0001\"\u0005\b\u0000\u0010\u0081\u00012\u0006\u0010\u007F\u001A\u00020\t29\u0010\u0082\u0001\u001A4\u0012\u0013\u0012\u00110\t¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(8\u0012\u0013\u0012\u00110\t¢\u0006\f\be\u0012\b\bf\u0012\u0004\b\b(A\u0012\u0005\u0012\u0003H\u0081\u00010\u0083\u0001H\u0086\b¢\u0006\u0003\u0010\u0084\u0001J\u0015\u0010\u0085\u0001\u001A\u0002002\n\u0010\u007F\u001A\u00060\tj\u0002`FH\u0002J\u0019\u0010\u0086\u0001\u001A\u0002002\u0006\u00108\u001A\u00020\t2\u0006\u0010A\u001A\u00020\tH\u0002J\t\u0010\u0087\u0001\u001A\u000200H\u0002J\u0007\u0010\u0088\u0001\u001A\u00020KJ\u0012\u0010\u0089\u0001\u001A\u0002002\u0007\u0010\u008A\u0001\u001A\u00020\tH\u0002J\r\u0010\u008B\u0001\u001A\u000200*\u00020\u0003H\u0002R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R$\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0015\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001D0\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R2\u0010\u001E\u001A\u0010\u0012\u0004\u0012\u00020\u001D\u0012\u0004\u0012\u00020 \u0018\u00010\u001F8\u0006@\u0006X\u0087\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\f\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001A\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010(R\"\u0010)\u001A\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001CX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u0006\u008D\u0001"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "", "groups", "", "slots", "", "<init>", "([I[Ljava/lang/Object;)V", "groupsCapacity", "", "slotsCapacity", "(II)V", "()V", "getGroups", "()[I", "setGroups", "([I)V", "getSlots", "()[Ljava/lang/Object;", "setSlots", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "_largeSizes", "Landroidx/collection/MutableIntIntMap;", "unallocatedStart", "unallocatedEnd", "freeSlotCount", "anchors", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "sourceInformationMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/composer/linkbuffer/LinkGroupSourceInformation;", "getSourceInformationMap$annotations", "getSourceInformationMap", "()Landroidx/collection/MutableScatterMap;", "setSourceInformationMap", "(Landroidx/collection/MutableScatterMap;)V", "largeSizes", "getLargeSizes", "()Landroidx/collection/MutableIntIntMap;", "calledByMap", "Landroidx/collection/MutableIntSet;", "getCalledByMap$runtime", "()Landroidx/collection/MutableIntObjectMap;", "setCalledByMap$runtime", "(Landroidx/collection/MutableIntObjectMap;)V", "validate", "", "allocateGroup", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "key", "parent", "flags", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "freeGroupTree", "address", "removeSourceInformation", "freeGroup", "reserveSlots", "", "restoreSlots", "start", "end", "recordLargeBlock", "size", "readSlot", "group", "offset", "writeSlot", "Landroidx/compose/runtime/composer/linkbuffer/SlotRange;", "value", "sourceInformationOf", "recordSourceInformation", "sourceInformation", "", "recordCalledBy", "parentKey", "allocateSlots", "resizeSlotRangeAtGroup", "newSize", "copyTreeFrom", "sourceSpace", "sourceAddress", "recordMovedSourceInformation", "previous", "anchorOfAddress", "ownsAnchor", "", "anchor", "moveAnchorFrom", "oldAddress", "newAddress", "moveSourceInformation", "distanceFrom", "groupAddress", "common", "distanceFrom$runtime", "traverseSiblings", "visit", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "traverseSiblings$runtime", "traverseSiblingsAfter", "traverseSiblingsAfter$runtime", "traverseChildren", "traverseChildren$runtime", "traverseParents", "traverseParents$runtime", "traverseGroupAndParents", "includeGroup", "traverseGroupAndParents$runtime", "traverseGroup", "includeSiblingsOfStartGroup", "traverseGroup$runtime", "traverseGroupPartially", "traverseGroupPartially$runtime", "traverseAllChildren", "traverseAllChildren$runtime", "contains", "growSlotRangeAtGroup", "currentSize", "shrinkSlotRange", "range", "shrinkSlotRangeAtGroup", "slotSize", "slotRange", "slotAddressAndSize", "R", "block", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "freeSlots", "freeSlotsAt", "growGroups", "toDebugString", "compactAndMaybeGrow", "required", "validateSlotReferences", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SlotTableAddressSpace {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace$Companion;", "", "<init>", "()V", "EmptyGroupData", "", "EmptySlotData", "", "[Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final int[] EmptyGroupData;
    private static final Object[] EmptySlotData;
    private MutableIntIntMap _largeSizes;
    private MutableIntObjectMap anchors;
    private MutableIntObjectMap calledByMap;
    private int freeSlotCount;
    private int[] groups;
    private Object[] slots;
    private MutableScatterMap sourceInformationMap;
    private int unallocatedEnd;
    private int unallocatedStart;

    static {
        SlotTableAddressSpace.Companion = new Companion(null);
        SlotTableAddressSpace.$stable = 8;
        SlotTableAddressSpace.EmptyGroupData = SlotTableAddresSpaceKt.newGroupsArray(6);
        SlotTableAddressSpace.EmptySlotData = SlotTableAddresSpaceKt.newSlotsArray(0);
    }

    public SlotTableAddressSpace() {
        this(SlotTableAddressSpace.EmptyGroupData, SlotTableAddressSpace.EmptySlotData);
    }

    public SlotTableAddressSpace(int[] arg1, Object[] arg2) {
        super();
        this.groups = arg1;
        this.slots = arg2;
        this.unallocatedEnd = arg2.length;
        this.anchors = IntObjectMapKt.mutableIntObjectMapOf();
    }

    public SlotTableAddressSpace(int arg1, int arg2) {
        this(SlotTableAddresSpaceKt.newGroupsArray(arg1), SlotTableAddresSpaceKt.newSlotsArray(arg2));
    }

    public static final MutableIntIntMap access$getLargeSizes(SlotTableAddressSpace arg0) {
        return arg0.getLargeSizes();
    }

    public static final void access$growGroups(SlotTableAddressSpace arg0) {
        arg0.growGroups();
    }

    public final int allocateGroup(int arg2, int arg3, int arg4) {
        int v0 = SlotTableAddresSpaceKt.groupAllocate(this.getGroups(), arg2, arg3, arg4);
        if(v0 < 0) {
            this.growGroups();
            return SlotTableAddresSpaceKt.groupAllocate(this.getGroups(), arg2, arg3, arg4);
        }

        return v0;
    }

    private final int allocateSlots(int arg5) {
        int v0 = this.unallocatedStart;
        int v2 = v0 + arg5;
        int v3 = 15;
        if(v2 <= this.unallocatedEnd) {
            this.unallocatedStart = v2;
            if(arg5 > v3) {
                this.getLargeSizes().set(v0, arg5);
            }

            ArraysKt.fill(this.slots, Composer.Companion.getEmpty(), v0, v2);
            return SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(v0, arg5);
        }

        this.compactAndMaybeGrow(arg5);
        v0 = this.unallocatedStart;
        v2 = v0 + arg5;
        if(v2 <= this.unallocatedEnd) {
            this.unallocatedStart = v2;
            if(arg5 > v3) {
                this.getLargeSizes().set(v0, arg5);
            }

            ArraysKt.fill(this.slots, Composer.Companion.getEmpty(), v0, v2);
            return SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(v0, arg5);
        }

        ComposerKt.composeRuntimeError("compactAndMaybeGrow did not grow enough");
        throw new KotlinNothingValueException();
    }

    public final LinkAnchor anchorOfAddress(int arg3) {
        LinkAnchor v0_2;
        if(arg3 != -1) {
            if(arg3 != 0) {
                int v0 = arg3 >= 0 ? 1 : 0;
                if(v0 == 0) {
                    ComposerKt.composeImmediateRuntimeError("Invalid anchor address " + arg3);
                }

                MutableIntObjectMap v2 = this.anchors;
                Object v0_1 = v2.get(arg3);
                if(v0_1 == null) {
                    v0_2 = new LinkAnchor(arg3);
                    v2.set(arg3, v0_2);
                }

                return v0_2;
            }

            return LinkAnchorKt.getLazyAnchor();
        }

        return LinkAnchorKt.getNullAnchor();
    }

    private final void compactAndMaybeGrow(int arg14) {
        Object[] v0 = this.slots;
        int v1 = v0.length;
        int v3 = v0.length - (this.unallocatedEnd - this.unallocatedStart + this.freeSlotCount);
        int v2 = 1;
        arg14 = 1 << 0x20 - Integer.numberOfLeadingZeros(arg14 + v3 + (v0.length >> 5));
        if(arg14 < v1) {
            arg14 = v1;
        }

        Object[] v14 = arg14 != v1 ? SlotTableAddresSpaceKt.newSlotsArray(RangesKt.coerceAtLeast(arg14, 0x100)) : v0;
        MutableIntIntMap v1_1 = IntIntMapKt.mutableIntIntMapOf();
        int v4 = this.groups[3];
        SlotMoveManager v5 = new SlotMoveManager(v0, v14);
        int v0_1 = 6;
        v4 = ProgressionUtilKt.getProgressionLastElement(v0_1, v4 - 1, v0_1);
        int v7 = 0;
        if(v0_1 <= v4) {
            while(true) {
                int v9 = v0_1 + 5;
                int v8 = this.groups[v9];
                if(v8 != -1) {
                    int v10 = (v8 & 15) + 1;
                    v8 >>= 4;
                    int v11 = 15;
                    if(v10 > v11) {
                        v10 = this.getLargeSizes().get(v8);
                    }

                    v5.move(v7, v8, v8 + v10);
                    if(v10 > v11) {
                        v1_1.set(v7, v10);
                    }

                    this.groups[v9] = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(v7, v10);
                    v7 += v10;
                }

                if(v0_1 == v4) {
                    break;
                }

                v0_1 += 6;
            }
        }

        if(v7 == v3) {
        }
        else {
            v2 = 0;
        }

        if(v2 == 0) {
            ComposerKt.composeImmediateRuntimeError("Unexpected slot compaction result, computed we had " + v3 + " slots, but copied " + v7 + " slots");
        }

        this.slots = v5.done();
        if(v1_1.isNotEmpty()) {
        }
        else {
            v1_1 = null;
        }

        this._largeSizes = v1_1;
        this.unallocatedStart = v7;
        this.unallocatedEnd = v14.length;
        this.freeSlotCount = 0;
    }

    public final boolean contains(int arg2) {
        if(arg2 > 0 && arg2 < this.groups[3]) {
            return 1;
        }

        return 0;
    }

    public final int copyTreeFrom(SlotTableAddressSpace arg2, int arg3) {
        return SlotTableAddressSpace.copyTreeFrom$copyGroup(arg2, this, -1, arg3);
    }

    private static final int copyTreeFrom$copyGroup(SlotTableAddressSpace arg8, SlotTableAddressSpace arg9, int arg10, int arg11) {
        int[] v0 = arg8.groups;
        Object[] v1 = arg8.slots;
        int v2 = v0[arg11 + 4];
        int v3 = v0[arg11];
        int v4 = SlotTableAddresSpaceKt.groupAllocate(arg9.getGroups(), v3, arg10, v2);
        if(v4 < 0) {
            arg9.growGroups();
            v4 = SlotTableAddresSpaceKt.groupAllocate(arg9.getGroups(), v3, arg10, v2);
        }

        arg9.moveSourceInformation(arg8, arg9.moveAnchorFrom(arg8, arg11, v4));
        arg10 = v0[arg11 + 5];
        v2 = -1;
        if(arg10 != v2) {
            v3 = (arg10 & 15) + 1;
            arg10 >>= 4;
            if(v3 > 15) {
                v3 = arg8.getLargeSizes().get(arg10);
            }

            int v5 = arg9.allocateSlots(v3);
            ArraysKt.copyInto(v1, arg9.slots, v5 >> 4, arg10, v3 + arg10);
            arg9.groups[v4 + 5] = v5;
        }

        arg10 = v0[arg11 + 3];
        for(arg11 = v2; arg10 != v2; arg11 = v1_1) {
            int v1_1 = SlotTableAddressSpace.copyTreeFrom$copyGroup(arg8, arg9, v4, arg10);
            if(arg11 == v2) {
                arg9.groups[v4 + 3] = v1_1;
            }
            else {
                arg9.groups[arg11 + 1] = v1_1;
            }

            arg10 = v0[arg10 + 1];
        }

        return v4;
    }

    public final int distanceFrom$runtime(int arg2, int arg3) {
        int[] v1 = this.groups;
        int v0 = 0;
        while(arg2 != arg3) {
            if(arg2 < 0) {
                return v0;
            }

            ++v0;
            arg2 = v1[arg2 + 2];
        }

        return v0;
    }

    private final void freeGroup(int arg9) {
        int[] v0 = this.groups;
        if(arg9 + 6 > v0.length) {
        }
        else {
            int v1 = arg9 + 4;
            int v3 = 0x7FFFFF;
            int v2 = (v0[v1] & v3) == v3 ? 1 : 0;
            if(v2 != 0) {
                ComposerKt.composeImmediateRuntimeError("Recursive loop in group structure detected at " + arg9);
            }

            Object v2_1 = this.anchors.get(arg9);
            int v5 = -1;
            if(v2_1 != null) {
                ((LinkAnchor)v2_1).setAddress(v5);
                this.anchors.remove(arg9);
                MutableScatterMap v6 = this.sourceInformationMap;
                if(v6 != null) {
                    v6.remove(v2_1);
                }
            }

            v2 = arg9 + 5;
            this.freeSlots(v0[v2]);
            v0[v2] = v5;
            for(v2 = v0[arg9 + 3]; v2 != v5; v2 = v6_1) {
                if(v2 + 6 > v0.length) {
                    return;
                }

                int v6_1 = v0[v2 + 1];
                this.freeGroup(v2);
            }

            v0[arg9 + 1] = v0[1];
            v0[arg9 + 2] = v5;
            v0[1] = arg9;
            v0[v1] = v3;
            return;
        }
    }

    public final void freeGroupTree(int arg1) {
        this.removeSourceInformation(arg1);
        this.freeGroup(arg1);
    }

    private final void freeSlots(int arg3) {
        if(arg3 != -1) {
            int v0 = (arg3 & 15) + 1;
            arg3 >>= 4;
            if(v0 > 15) {
                v0 = this.getLargeSizes().get(arg3);
            }

            this.freeSlotsAt(arg3, v0);
        }
    }

    private final void freeSlotsAt(int arg4, int arg5) {
        Object[] v0 = this.slots;
        int v1 = arg4 + arg5;
        if(v1 == arg4 + 1) {
            v0[arg4] = SlotTableAddresSpaceKt.Unallocated;
        }
        else {
            ArraysKt.fill(v0, SlotTableAddresSpaceKt.Unallocated, arg4, v1);
        }

        this.freeSlotCount += arg5;
        if(arg5 > 15) {
            this.getLargeSizes().remove(arg4);
        }
    }

    public final MutableIntObjectMap getCalledByMap$runtime() {
        return this.calledByMap;
    }

    public final int[] getGroups() {
        return this.groups;
    }

    private final MutableIntIntMap getLargeSizes() {
        MutableIntIntMap v0 = this._largeSizes;
        if(v0 == null) {
            v0 = IntIntMapKt.mutableIntIntMapOf();
            this._largeSizes = v0;
        }

        return v0;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public final MutableScatterMap getSourceInformationMap() {
        return this.sourceInformationMap;
    }

    public static void getSourceInformationMap$annotations() {
    }

    private final void growGroups() {
        int[] v0 = this.groups;
        int v1 = v0.length;
        v0 = Arrays.copyOf(this.groups, RangesKt.coerceAtLeast(v0.length * 2, 0x300));
        Intrinsics.checkNotNullExpressionValue(v0, "copyOf(...)");
        this.groups = v0;
        SlotTableAddresSpaceKt.initGroups(v0, v1);
    }

    private final int growSlotRangeAtGroup(int arg10, int arg11, int arg12) {
        int v5;
        int v0 = this.unallocatedStart;
        int v1 = this.unallocatedEnd;
        arg10 += 5;
        int v2 = this.groups[arg10] >> 4;
        int v3 = v2 + arg11;
        int v4 = 15;
        if(v3 == v0) {
            v5 = v2 + arg12;
            if(v5 <= v1) {
                this.unallocatedStart = v0 + (arg12 - arg11);
                if(arg12 > v4) {
                    this.getLargeSizes().set(v2, arg12);
                }

                arg11 = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(v2, arg12);
                Object[] v12 = this.slots;
                if(v5 == v3 + 1) {
                    v12[v3] = SlotTableAddresSpaceKt.Unallocated;
                }
                else {
                    ArraysKt.fill(v12, SlotTableAddresSpaceKt.Unallocated, v3, v5);
                }

                this.groups[arg10] = arg11;
                return arg11;
            }
        }

        v0 = arg12 - arg11;
        Object[] v1_1 = this.slots;
        v5 = v3 + v0;
        if(v5 >= v1_1.length) {
        }
        else {
            int v6 = v3;
            while(true) {
                if(v6 >= v5) {
                    break;
                }
                else if(v1_1[v6] == SlotTableAddresSpaceKt.Unallocated) {
                    ++v6;
                    continue;
                }

                goto label_40;
            }

            if(arg12 > v4) {
                this.getLargeSizes().set(v2, arg12);
            }

            arg11 = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(v2, arg12);
            v1_1 = this.slots;
            v2 += arg12;
            if(v2 == v3 + 1) {
                v1_1[v3] = SlotTableAddresSpaceKt.Unallocated;
            }
            else {
                ArraysKt.fill(v1_1, SlotTableAddresSpaceKt.Unallocated, v3, v2);
            }

            this.groups[arg10] = arg11;
            this.freeSlotCount -= v0;
            return arg11;
        }

    label_40:
        v0 = arg12 + 8;
        arg12 = this.shrinkSlotRange(this.allocateSlots(v0), v0, arg12);
        v0 = arg12 >> 4;
        v1 = this.groups[arg10] >> 4;
        if(v0 != v1) {
            ArraysKt.copyInto(this.slots, this.slots, v0, v1, v1 + arg11);
            this.freeSlotsAt(v1, arg11);
        }

        this.groups[arg10] = arg12;
        return arg12;
    }

    public final LinkAnchor moveAnchorFrom(SlotTableAddressSpace arg2, int arg3, int arg4) {
        this.anchors.containsKey(arg4);
        Object v2 = arg2.anchors.remove(arg3);
        if(v2 != null) {
            ((LinkAnchor)v2).setAddress(arg4);
            this.anchors.set(arg4, v2);
            return ((LinkAnchor)v2);
        }

        return null;
    }

    public final void moveSourceInformation(SlotTableAddressSpace arg3, LinkAnchor arg4) {
        Object v0;
        MutableScatterMap v3;
        if(arg4 == null) {
        }
        else {
            v3 = arg3.sourceInformationMap;
            if(v3 == null) {
            }
            else {
                v0 = v3.get(arg4);
                if(v0 == null) {
                    return;
                }

                goto label_8;
            }
        }

        return;
    label_8:
        MutableScatterMap v1 = this.sourceInformationMap;
        if(v1 == null) {
            v1 = ScatterMapKt.mutableScatterMapOf();
            this.sourceInformationMap = v1;
        }
        else {
            v1.contains(arg4);
        }

        v1.set(arg4, v0);
        v3.remove(arg4);
    }

    public final boolean ownsAnchor(LinkAnchor arg2) {
        if(this.anchors.get(arg2.getAddress()) == arg2) {
            return 1;
        }

        return 0;
    }

    public final Object readSlot(int arg2, int arg3) {
        return this.slots[(this.groups[arg2 + 5] >> 4) + arg3];
    }

    public final void recordCalledBy(int arg2, int arg3) {
        MutableIntSet v1_1;
        MutableIntObjectMap v0 = this.calledByMap;
        if(v0 == null) {
            v0 = IntObjectMapKt.mutableIntObjectMapOf();
            this.calledByMap = v0;
        }

        Object v1 = v0.get(arg2);
        if(v1 == null) {
            v1_1 = IntSetKt.mutableIntSetOf();
            v0.set(arg2, v1_1);
        }

        v1_1.add(arg3);
    }

    public final void recordLargeBlock(int arg1, int arg2) {
        this.getLargeSizes().set(arg1, arg2);
    }

    public final void recordMovedSourceInformation(int arg4, int arg5) {
        Object v0_1;
        MutableScatterMap v0 = this.sourceInformationMap;
        if(v0 == null) {
        }
        else {
            Object v1 = this.anchors.get(this.groups[arg4 + 2]);
            if(v1 == null) {
            }
            else {
                v0_1 = v0.get(v1);
                if(v0_1 == null) {
                    return;
                }

                goto label_13;
            }
        }

        return;
    label_13:
        LinkAnchor v5 = arg5 != -1 ? this.anchorOfAddress(arg5) : null;
        ((LinkGroupSourceInformation)v0_1).addGroupAfter(v5, this.anchorOfAddress(arg4));
    }

    public final LinkGroupSourceInformation recordSourceInformation(int arg5, String arg6, int arg7) {
        LinkGroupSourceInformation v2_1;
        MutableScatterMap v0 = this.sourceInformationMap;
        if(v0 == null) {
            v0 = ScatterMapKt.mutableScatterMapOf();
            this.sourceInformationMap = v0;
        }

        LinkAnchor v1 = this.anchorOfAddress(arg5);
        Object v2 = v0.get(v1);
        if(v2 == null) {
            v2_1 = new LinkGroupSourceInformation(0, arg6, 0);
            if(arg6 == null) {
                for(arg5 = this.groups[arg5 + 3]; arg5 != arg7; arg5 = this.groups[arg5 + 1]) {
                    if(arg5 == -1) {
                        break;
                    }

                    v2_1.reportGroup(this.anchorOfAddress(arg5));
                }
            }

            v0.set(v1, v2_1);
        }

        return v2_1;
    }

    private final void removeSourceInformation(int arg4) {
        Object v3;
        Object v1;
        MutableScatterMap v0 = this.sourceInformationMap;
        if(v0 == null) {
        }
        else {
            v1 = this.anchors.get(arg4);
            if(v1 == null) {
            }
            else {
                v3 = this.anchors.get(this.groups[arg4 + 2]);
                if(v3 == null) {
                }
                else {
                    v3 = v0.get(v3);
                    if(v3 == null) {
                        return;
                    }

                    goto label_17;
                }
            }
        }

        return;
    label_17:
        ((LinkGroupSourceInformation)v3).removeGroup(((LinkAnchor)v1));
    }

    public final long reserveSlots() {
        int v0 = this.unallocatedStart;
        int v1 = this.unallocatedEnd;
        this.unallocatedStart = v1;
        return ((((long)UInt.constructor-impl(v1))) & 0xFFFFFFFFL) << 0x20 | (((long)UInt.constructor-impl(v0))) & 0xFFFFFFFFL;
    }

    public final int resizeSlotRangeAtGroup(int arg4, int arg5) {
        int v0 = this.groups[arg4 + 5];
        int v1 = -1;
        if(v0 == v1) {
            if(arg5 != 0) {
            }
            else {
                return v0;
            }
        }

        if(v0 == v1) {
            v0 = 0;
        }
        else {
            v1 = (v0 & 15) + 1;
            v0 = v1 > 15 ? this.getLargeSizes().get(v0 >> 4) : v1;
        }

        return this.resizeSlotRangeAtGroup(arg4, v0, arg5);
    }

    public final int resizeSlotRangeAtGroup(int arg1, int arg2, int arg3) {
        if(arg3 == arg2) {
            return this.groups[arg1 + 5];
        }

        if(arg3 > arg2) {
            return this.growSlotRangeAtGroup(arg1, arg2, arg3);
        }

        return this.shrinkSlotRangeAtGroup(arg1, arg2, arg3);
    }

    public final void restoreSlots(int arg2, int arg3) {
        if(arg3 == this.unallocatedEnd) {
            this.unallocatedStart = arg2;
        }
    }

    public final void setCalledByMap$runtime(MutableIntObjectMap arg1) {
        this.calledByMap = arg1;
    }

    public final void setGroups(int[] arg1) {
        this.groups = arg1;
    }

    public final void setSlots(Object[] arg1) {
        this.slots = arg1;
    }

    public final void setSourceInformationMap(MutableScatterMap arg1) {
        this.sourceInformationMap = arg1;
    }

    private final int shrinkSlotRange(int arg2, int arg3, int arg4) {
        int v0 = arg2 >> 4;
        if(arg4 == 0) {
            arg4 = -1;
            if(arg2 != arg4) {
                this.freeSlotsAt(v0, arg3);
            }

            return arg4;
        }

        arg3 -= arg4;
        arg2 = v0 + arg4;
        if(arg3 > 0) {
            this.freeSlotsAt(arg2, arg3);
        }

        if(arg4 > 15) {
            this.getLargeSizes().set(v0, arg4);
        }

        return SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(v0, arg4);
    }

    private final int shrinkSlotRangeAtGroup(int arg2, int arg3, int arg4) {
        arg2 += 5;
        arg3 = this.shrinkSlotRange(this.groups[arg2], arg3, arg4);
        this.groups[arg2] = arg3;
        return arg3;
    }

    public final Object slotAddressAndSize(int arg3, Function2 arg4) {
        int v0 = (arg3 & 15) + 1;
        arg3 >>= 4;
        if(v0 > 15) {
            v0 = this.getLargeSizes().get(arg3);
        }

        return arg4.invoke(Integer.valueOf(arg3), Integer.valueOf(v0));
    }

    public final int slotSize(int arg3) {
        if(arg3 == -1) {
            return 0;
        }

        int v0 = (arg3 & 15) + 1;
        if(v0 > 15) {
            return this.getLargeSizes().get(arg3 >> 4);
        }

        return v0;
    }

    public final LinkGroupSourceInformation sourceInformationOf(int arg3) {
        MutableScatterMap v0 = this.sourceInformationMap;
        LinkGroupSourceInformation v1 = null;
        if(v0 != null) {
            Object v2 = this.anchors.get(arg3);
            if(v2 != null) {
                return v0.get(v2);
            }
        }

        return v1;
    }

    public final String toDebugString() {
        StringBuilder v0 = new StringBuilder("SlotTableAddressSpace:\n  Group size: ");
        int[] v1 = this.groups;
        v0.append(v1.length);
        v0.append("\n  Slots size: ");
        v0.append(this.slots.length);
        v0.append("\n\n Groups:\n  Unallocated groups: ");
        int v3 = (v1.length - v1[3]) / 6;
        v0.append(v3);
        char v2 = '\n';
        v0.append(v2);
        int v4 = v1[1];
        int v5 = 0;
        while(v4 != -1) {
            ++v5;
            v4 = v1[v4 + 1];
        }

        v0.append("  Free groups:        ");
        v0.append(v5);
        v0.append("\n  Total free groups:  ");
        v5 += v3;
        v0.append(v5);
        v0.append("\n  Used group%:        ");
        v0.append((((double)(v1.length / 6 - v5))) / (((double)(v1.length / 6))));
        v0.append("\n\n Slots:\n  Unallocated slots: ");
        int v1_1 = this.unallocatedEnd - this.unallocatedStart;
        v0.append(v1_1);
        v0.append("\n  Slot used%:    ");
        v0.append((((double)(this.slots.length - this.freeSlotCount - v1_1))) / (((double)this.slots.length)));
        v0.append(v2);
        return v0.toString();
    }

    public final void traverseAllChildren$runtime(int arg3, Function1 arg4) {
        if(arg3 >= 0) {
            arg3 = this.getGroups()[arg3 + 3];
            if(arg3 >= 0) {
                IntStack v0 = new IntStack();
                int[] v2 = this.getGroups();
                while(true) {
                    arg4.invoke(Integer.valueOf(arg3));
                    int v1 = v2[arg3 + 1];
                    if(v1 >= 0) {
                        v0.push(v1);
                    }

                    arg3 = v2[arg3 + 3];
                    if(arg3 >= 0) {
                        continue;
                    }

                    if(v0.tos == 0) {
                        return;
                    }

                    arg3 = v0.pop();
                }
            }
        }
    }

    public final void traverseChildren$runtime(int arg2, Function1 arg3) {
        int[] v1 = this.getGroups();
        for(arg2 = v1[arg2 + 3]; arg2 > 0; arg2 = v1[arg2 + 1]) {
            arg3.invoke(Integer.valueOf(arg2));
        }
    }

    public final void traverseGroup$runtime(int arg4, boolean arg5, Function1 arg6) {
        if(arg4 < 0) {
            return;
        }

        IntStack v0 = new IntStack();
        int[] v3 = this.getGroups();
        int v1;
        for(v1 = arg4; true; v1 = v0.pop()) {
        label_6:
            arg6.invoke(Integer.valueOf(v1));
            if(v1 != arg4 || (arg5)) {
                int v2 = v3[v1 + 1];
                if(v2 >= 0) {
                    v0.push(v2);
                }
            }

            v1 = v3[v1 + 3];
            if(v1 >= 0) {
                goto label_6;
            }

            if(v0.tos == 0) {
                return;
            }
        }
    }

    public static void traverseGroup$runtime$default(SlotTableAddressSpace arg1, int arg2, boolean arg3, Function1 arg4, int arg5, Object arg6) {
        if(arg2 < 0) {
            return;
        }

        IntStack v5 = new IntStack();
        int[] v1 = arg1.getGroups();
        int v6;
        for(v6 = arg2; true; v6 = v5.pop()) {
        label_9:
            arg4.invoke(Integer.valueOf(v6));
            if(v6 != arg2 || 0 != 0) {
                int v0 = v1[v6 + 1];
                if(v0 >= 0) {
                    v5.push(v0);
                }
            }

            v6 = v1[v6 + 3];
            if(v6 >= 0) {
                goto label_9;
            }

            if(v5.tos == 0) {
                return;
            }
        }
    }

    public final void traverseGroupAndParents$runtime(int arg2, boolean arg3, Function1 arg4) {
        int[] v1 = this.getGroups();
        int v3;
        for(v3 = !arg3 ? v1[arg2 + 2] : arg2; v3 > 0; v3 = v1[v3 + 2]) {
            arg4.invoke(Integer.valueOf(v3));
        }

        int v1_1 = v3 != 0 ? 1 : 0;
        if(v1_1 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg2);
        }
    }

    public static void traverseGroupAndParents$runtime$default(SlotTableAddressSpace arg0, int arg1, boolean arg2, Function1 arg3, int arg4, Object arg5) {
        int v5 = 1;
        int[] v0 = arg0.getGroups();
        int v2;
        for(v2 = 1 == 0 ? v0[arg1 + 2] : arg1; v2 > 0; v2 = v0[v2 + 2]) {
            arg3.invoke(Integer.valueOf(v2));
        }

        if(v2 != 0) {
        }
        else {
            v5 = 0;
        }

        if(v5 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg1);
        }
    }

    public final void traverseGroupPartially$runtime(int arg5, boolean arg6, Function1 arg7) {
        if(arg5 < 0) {
            return;
        }

        IntStack v0 = new IntStack();
        int[] v4 = this.getGroups();
        int v1;
        for(v1 = arg5; true; v1 = v0.pop()) {
        label_6:
            boolean v2 = arg7.invoke(Integer.valueOf(v1)).booleanValue();
            if(v1 != arg5 || (arg6)) {
                int v3 = v4[v1 + 1];
                if(v3 >= 0) {
                    v0.push(v3);
                }
            }

            v1 = v4[v1 + 3];
            if((v2) && v1 >= 0) {
                goto label_6;
            }

            if(v0.tos == 0) {
                return;
            }
        }
    }

    public static void traverseGroupPartially$runtime$default(SlotTableAddressSpace arg2, int arg3, boolean arg4, Function1 arg5, int arg6, Object arg7) {
        if(arg3 < 0) {
            return;
        }

        IntStack v6 = new IntStack();
        int[] v2 = arg2.getGroups();
        int v7;
        for(v7 = arg3; true; v7 = v6.pop()) {
        label_9:
            boolean v0 = arg5.invoke(Integer.valueOf(v7)).booleanValue();
            if(v7 != arg3 || 0 != 0) {
                int v1 = v2[v7 + 1];
                if(v1 >= 0) {
                    v6.push(v1);
                }
            }

            v7 = v2[v7 + 3];
            if((v0) && v7 >= 0) {
                goto label_9;
            }

            if(v6.tos == 0) {
                return;
            }
        }
    }

    public final void traverseParents$runtime(int arg3, Function1 arg4) {
        int[] v2 = this.getGroups();
        int v0;
        for(v0 = v2[arg3 + 2]; v0 > 0; v0 = v2[v0 + 2]) {
            arg4.invoke(Integer.valueOf(v0));
        }

        int v2_1 = v0 != 0 ? 1 : 0;
        if(v2_1 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg3);
        }
    }

    public final void traverseSiblings$runtime(int arg2, Function1 arg3) {
        int[] v1 = this.getGroups();
        while(arg2 >= 0) {
            arg3.invoke(Integer.valueOf(arg2));
            arg2 = v1[arg2 + 1];
        }
    }

    public final void traverseSiblingsAfter$runtime(int arg2, Function1 arg3) {
        int[] v1 = this.getGroups();
        for(arg2 = v1[arg2 + 1]; arg2 >= 0; arg2 = v1[arg2 + 1]) {
            arg3.invoke(Integer.valueOf(arg2));
        }
    }

    public final void validate() {
        SlotTableAddresSpaceKt.validateFreeList(this.groups);
        this.validateSlotReferences(this.groups);
    }

    private final void validateSlotReferences(int[] arg9) {
        MutableIntIntMap v0 = IntIntMapKt.mutableIntIntMapOf();
        int v1 = this.slots.length;
        int v3 = 6;
        int v2 = ProgressionUtilKt.getProgressionLastElement(v3, arg9[3] - 1, v3);
        if(v3 <= v2) {
            while(true) {
                int v4 = arg9[v3 + 5];
                if(v4 != -1) {
                    int v5 = (v4 & 15) + 1;
                    v4 >>= 4;
                    if(v5 > 15) {
                        v5 = this.getLargeSizes().get(v4);
                    }

                    String v6 = "Group ";
                    if(v4 >= 0) {
                        v5 += v4;
                        if(v5 <= v1) {
                            while(true) {
                                if(v4 >= v5) {
                                    goto label_73;
                                }

                                if(v0.containsKey(v4)) {
                                    break;
                                }

                                v0.set(v4, v3);
                                ++v4;
                            }

                            int v0_1 = v0.get(v4);
                            throw new IllegalStateException(v6 + v3 + " contains a slot address (" + SlotTableAddressSpace.validateSlotReferences$slotRangeTextOf(this, arg9, v3) + ") that overlaps with group " + v0_1 + "\'s address (" + SlotTableAddressSpace.validateSlotReferences$slotRangeTextOf(this, arg9, v0_1) + ')'.toString());
                        }

                        throw new IllegalStateException(v6 + v3 + " slot range extends beyond the slot size".toString());
                    }

                    throw new IllegalStateException(v6 + v3 + " has an invalid slot address".toString());
                }

            label_73:
                if(v3 == v2) {
                    break;
                }

                v3 += 6;
            }
        }

        int v9 = this.slots.length - v0.getSize() - (this.unallocatedEnd - this.unallocatedStart);
        if(this.freeSlotCount == v9) {
            return;
        }

        throw new IllegalStateException("Unexpected freeSlotCount, " + this.freeSlotCount + ", expected " + v9.toString());
    }

    private static final String validateSlotReferences$slotRangeTextOf(SlotTableAddressSpace arg1, int[] arg2, int arg3) {
        int v2 = arg2[arg3 + 5];
        arg3 = (v2 & 15) + 1;
        v2 >>= 4;
        if(arg3 > 15) {
            arg3 = arg1.getLargeSizes().get(v2);
        }

        return v2 + '-' + (v2 + arg3);
    }

    public final int writeSlot(int arg5, int arg6, Object arg7) {
        int[] v0 = this.groups;
        int v1 = arg5 + 5;
        int v2 = v0[v1];
        if(v2 == -1) {
            arg5 = this.allocateSlots(arg6 + 1);
            v0[v1] = arg5;
        }
        else {
            int v0_1 = (v2 & 15) + 1;
            v1 = v2 >> 4;
            if(v0_1 > 15) {
                v0_1 = this.getLargeSizes().get(v1);
            }

            if(arg6 >= v0_1) {
                v2 = this.growSlotRangeAtGroup(arg5, v0_1, arg6 + 1);
            }

            arg5 = v2;
        }

        this.slots[(arg5 >> 4) + arg6] = arg7;
        return arg5;
    }
}

