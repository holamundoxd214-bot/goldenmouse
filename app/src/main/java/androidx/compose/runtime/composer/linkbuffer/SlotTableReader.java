package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001C\u00100\u001A\u0004\u0018\u00010\u00012\n\u00101\u001A\u00060\u0010j\u0002`\u00132\u0006\u0010\u001F\u001A\u00020\u0010J\u001C\u00102\u001A\u0004\u0018\u00010\u00012\n\u00101\u001A\u00060\u0010j\u0002`\u00132\u0006\u0010\u001F\u001A\u00020\u0010J\u0012\u00103\u001A\u00020\u00102\n\u00101\u001A\u00060\u0010j\u0002`\u0013J\u0014\u00106\u001A\u0004\u0018\u00010\u00012\n\u0010?\u001A\u00060\u0010j\u0002`\u0013J\u0012\u0010@\u001A\u00020$2\n\u00101\u001A\u00060\u0010j\u0002`\u0013J\u0014\u0010;\u001A\u0004\u0018\u00010\u00012\n\u00101\u001A\u00060\u0010j\u0002`\u0013J\u0014\u0010=\u001A\u0004\u0018\u00010\u00012\n\u0010?\u001A\u00060\u0010j\u0002`\u0013J\u0012\u0010C\u001A\u00020$2\n\u0010?\u001A\u00060\u0010j\u0002`\u0013J\u0014\u0010]\u001A\u0004\u0018\u00010\u00012\n\u0010?\u001A\u00060\u0010j\u0002`\u0013J\u0014\u0010^\u001A\u0004\u0018\u00010\u00012\n\u0010?\u001A\u00060\u0010j\u0002`\u0013J\u0012\u0010_\u001A\u00020\u00102\n\u0010?\u001A\u00060\u0010j\u0002`\u0013J\u0012\u0010`\u001A\u00020\u00102\n\u0010?\u001A\u00060\u0010j\u0002`\u0013J\u0012\u0010a\u001A\u00020\u00102\n\u0010?\u001A\u00060\u0010j\u0002`\u0013J\u0012\u0010b\u001A\u00020\u00102\n\u0010?\u001A\u00060\u0010j\u0002`\u0013J\n\u0010c\u001A\u00060Oj\u0002`PJ\n\u0010d\u001A\u00060Oj\u0002`PJ\u0012\u0010e\u001A\u00020$2\n\u0010?\u001A\u00060\u0010j\u0002`\u0013J\u0012\u0010f\u001A\u00020$2\n\u0010?\u001A\u00060\u0010j\u0002`\u0013J\u0016\u0010g\u001A\u00060\u0010j\u0002`h2\n\u00101\u001A\u00060\u0010j\u0002`\u0013J\n\u0010i\u001A\u00060\u0010j\u0002`hJ\u0006\u0010j\u001A\u00020kJ\u0006\u0010l\u001A\u00020kJ\u0006\u0010m\u001A\u00020kJ\u0006\u0010n\u001A\u00020kJ\u0006\u0010o\u001A\u00020\u0010J\u0006\u0010p\u001A\u00020kJ\u0012\u0010q\u001A\u00020k2\n\u0010\u000F\u001A\u00060\u0010j\u0002`\u0013J\b\u0010r\u001A\u0004\u0018\u00010\u0001J\u0012\u00109\u001A\u00020\u00102\n\u0010?\u001A\u00060\u0010j\u0002`\u0013J\u0010\u00100\u001A\u0004\u0018\u00010\u00012\u0006\u0010s\u001A\u00020\u0010J\u0006\u0010t\u001A\u00020kJ\u0006\u0010u\u001A\u00020kJ\u0012\u0010v\u001A\u00020k2\n\u0010?\u001A\u00060\u0010j\u0002`\u0013J\u0012\u0010v\u001A\u00020k2\n\u0010c\u001A\u00060Oj\u0002`PJ\f\u0010w\u001A\b\u0012\u0004\u0012\u00020y0xJ \u0010z\u001A\u00020k2\f\b\u0002\u0010{\u001A\u00060\u0010j\u0002`\u00132\n\u0010|\u001A\u00060\u0010j\u0002`hJ\u0012\u0010}\u001A\u00020k2\n\u0010|\u001A\u00060\u0010j\u0002`hJ\u001E\u0010}\u001A\u00020k2\n\u0010?\u001A\u00060\u0010j\u0002`\u00132\n\u0010|\u001A\u00060\u0010j\u0002`hJK\u0010~\u001A\u00020k2\n\u0010\u007F\u001A\u00060\u0010j\u0002`\u00132\t\b\u0002\u0010\u0080\u0001\u001A\u00020$2)\u0010\u0081\u0001\u001A$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000E\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020$0\u0082\u0001H\u0086\bJÂ\u0001\u0010\u0085\u0001\u001A\u00020k2\n\u0010?\u001A\u00060\u0010j\u0002`\u00132)\u0010\u0086\u0001\u001A$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000E\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020$0\u0082\u00012)\u0010\u0087\u0001\u001A$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000E\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020$0\u0082\u00012)\u0010\u0088\u0001\u001A$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000E\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020k0\u0082\u00012)\u0010\u0089\u0001\u001A$\u0012\u0019\u0012\u00170\u0010j\u0002`\u0013¢\u0006\u000E\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020k0\u0082\u0001H\u0086\bJA\u0010\u008A\u0001\u001A\u00020k2\n\u0010?\u001A\u00060\u0010j\u0002`\u00132)\u0010\u0087\u0001\u001A$\u0012\u0019\u0012\u00170Oj\u0002`P¢\u0006\u000E\b\u0083\u0001\u0012\t\b\u0084\u0001\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020k0\u0082\u0001H\u0086\bJ\u0018\u0010\u008B\u0001\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0082\b¢\u0006\u0003\u0010\u008C\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R,\u0010\u0014\u001A\u00060\u0010j\u0002`\u00132\n\u0010\u0012\u001A\u00060\u0010j\u0002`\u00138B@BX\u0082\u000E¢\u0006\f\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001A\u0010\u0019\u001A\u00020\u0010X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0016\"\u0004\b\u001B\u0010\u0018R\u001A\u0010\u001C\u001A\u00020\u0010X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0016\"\u0004\b\u001E\u0010\u0018R\u0011\u0010\u001F\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b \u0010\u0016R\u000E\u0010!\u001A\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010%\u001A\u00020$2\u0006\u0010\u0012\u001A\u00020$@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u001E\u0010(\u001A\u00020$2\u0006\u0010\u0012\u001A\u00020$@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b(\u0010\'R\u0011\u0010)\u001A\u00020$8F¢\u0006\u0006\u001A\u0004\b)\u0010\'R\u000E\u0010*\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R,\u0010+\u001A\u00060\u0010j\u0002`\u00132\n\u0010\u0012\u001A\u00060\u0010j\u0002`\u00138F@BX\u0086\u000E¢\u0006\f\u001A\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u0011\u0010.\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b/\u0010\u0016R\u0011\u00104\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b5\u0010\u0016R\u0013\u00106\u001A\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001A\u0004\b7\u00108R\u0011\u00109\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b:\u0010\u0016R\u0013\u0010;\u001A\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001A\u0004\b<\u00108R\u0013\u0010=\u001A\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001A\u0004\b>\u00108R\u0011\u0010@\u001A\u00020$8F¢\u0006\u0006\u001A\u0004\bA\u0010\'R\u0011\u0010B\u001A\u00020$8F¢\u0006\u0006\u001A\u0004\bB\u0010\'R\u0011\u0010C\u001A\u00020$8F¢\u0006\u0006\u001A\u0004\bC\u0010\'R\u0011\u0010D\u001A\u00020$8F¢\u0006\u0006\u001A\u0004\bE\u0010\'R\u0015\u0010F\u001A\u00060\u0010j\u0002`\u00138F¢\u0006\u0006\u001A\u0004\bG\u0010\u0016R\u0015\u0010H\u001A\u00060\u0010j\u0002`\u00138F¢\u0006\u0006\u001A\u0004\bI\u0010\u0016R\u0011\u0010J\u001A\u00020K8F¢\u0006\u0006\u001A\u0004\bL\u0010MR\u0015\u0010N\u001A\u00060Oj\u0002`P8F¢\u0006\u0006\u001A\u0004\bQ\u0010RR\u0013\u0010S\u001A\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001A\u0004\bT\u00108R\u0011\u00103\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\bU\u0010\u0016R\u0011\u0010V\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\bW\u0010\u0016R\u0015\u0010X\u001A\u00060\u0010j\u0002`Y8F¢\u0006\u0006\u001A\u0004\bZ\u0010\u0016R\u0011\u0010[\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b\\\u0010\u0016¨\u0006\u008D\u0001"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "groups", "", "slots", "", "[Ljava/lang/Object;", "parent", "", "_current", "value", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "current", "getCurrent", "()I", "setCurrent", "(I)V", "slotCurrent", "getSlotCurrent", "setSlotCurrent", "slotEnd", "getSlotEnd", "setSlotEnd", "slotIndex", "getSlotIndex", "previousSlotCurrentOffset", "Landroidx/compose/runtime/IntStack;", "emptyCount", "", "hadNext", "getHadNext", "()Z", "isClosed", "isEmpty", "_previousSibling", "previousSibling", "getPreviousSibling", "setPreviousSibling", "remainingSlots", "getRemainingSlots", "get", "address", "getOrNull", "nodeCount", "parentCurrentSlotOffset", "getParentCurrentSlotOffset", "groupAux", "getGroupAux", "()Ljava/lang/Object;", "groupKey", "getGroupKey", "groupObjectKey", "getGroupObjectKey", "groupNode", "getGroupNode", "group", "hasObjectKey", "getHasObjectKey", "isGroupEnd", "isNode", "inEmpty", "getInEmpty", "currentGroup", "getCurrentGroup", "parentGroup", "getParentGroup", "parentAnchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "getParentAnchor", "()Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "parentHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "getParentHandle", "()J", "parentNode", "getParentNode", "getNodeCount", "parentNodeCount", "getParentNodeCount", "groupReferenceSlotStartAddress", "Landroidx/compose/runtime/composer/linkbuffer/SlotAddress;", "getGroupReferenceSlotStartAddress", "nextParentSlotAddress", "getNextParentSlotAddress", "node", "maybeNode", "parentOf", "firstChildOf", "nextSiblingOf", "childNodeCountOf", "handle", "rootHandle", "recomposeRequired", "hasRecomposeRequired", "flagsOf", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "parentGroupFlags", "close", "", "startGroup", "startNode", "endGroup", "skipGroup", "skipToGroupEnd", "restoreParent", "next", "index", "beginEmpty", "endEmpty", "reposition", "extractKeys", "", "Landroidx/compose/runtime/composer/linkbuffer/KeyInfo;", "addFlag", "groupAddress", "flags", "removeFlag", "traverseGroupPartially", "start", "includeSiblingsOfStartGroup", "visit", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "traverseChildrenConditionally", "enter", "block", "exit", "skip", "traverseChildrenByHandle", "upToDateSlots", "()[Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SlotTableReader {
    public static final int $stable = 8;
    private int _current;
    private int _previousSibling;
    private SlotTableAddressSpace addressSpace;
    private int emptyCount;
    private int[] groups;
    private boolean hadNext;
    private boolean isClosed;
    private int parent;
    private final IntStack previousSlotCurrentOffset;
    private int slotCurrent;
    private int slotEnd;
    private Object[] slots;
    private final SlotTable table;

    static {
    }

    public SlotTableReader(SlotTable arg2) {
        super();
        this.table = arg2;
        SlotTableAddressSpace v0 = arg2.getAddressSpace();
        this.addressSpace = v0;
        this.groups = v0.getGroups();
        this.slots = arg2.getAddressSpace().getSlots();
        this.parent = -1;
        this._current = arg2.getRoot();
        this.previousSlotCurrentOffset = new IntStack();
        this._previousSibling = -1;
    }

    public static final SlotTableAddressSpace access$getAddressSpace$p(SlotTableReader arg0) {
        return arg0.addressSpace;
    }

    public final void addFlag(int arg8, int arg9) {
        int v0 = GroupFlagsKt.propagatingFlagsOf(arg9);
        int[] v1 = this.addressSpace.getGroups();
        int[] v7 = this.table.getAddressSpace().getGroups();
        int v2;
        for(v2 = arg8; v2 > 0; v2 = v7[v2 + 2]) {
            int v3 = v2 + 4;
            int v4 = v1[v3];
            int v5 = v2 == arg8 ? arg9 : v0;
            if((v5 & v4) == v5) {
                return;
            }

            v1[v3] = v4 | v5;
        }

        int v7_1 = v2 != 0 ? 1 : 0;
        if(v7_1 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg8);
        }
    }

    public static void addFlag$default(SlotTableReader arg0, int arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.getParentGroup();
        }

        arg0.addFlag(arg1, arg2);
    }

    public final void beginEmpty() {
        ++this.emptyCount;
    }

    public final int childNodeCountOf(int arg1) {
        return this.groups[arg1 + 4] & 0x7FFFFF;
    }

    public final void close() {
        if(!this.isClosed) {
            this.isClosed = true;
            this.table.closeReader(this);
        }
    }

    public final void endEmpty() {
        int v0 = this.emptyCount > 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Unbalanced begin/end empty");
        }

        int v2 = -1;
        v0 = this.emptyCount + v2;
        this.emptyCount = v0;
        if(v0 == 0) {
            this.slots = this.addressSpace.getSlots();
            int[] v0_1 = this.addressSpace.getGroups();
            this.groups = v0_1;
            int v3 = this.slotEnd - this.slotCurrent;
            v0 = v0_1[this.parent + 5];
            if(v0 != v2) {
                SlotTableAddressSpace v2_1 = this.addressSpace;
                int v4 = (v0 & 15) + 1;
                v0 >>= 4;
                if(v4 > 15) {
                    v4 = v2_1.getLargeSizes().get(v0);
                }

                v0 += v4;
                this.slotCurrent = v0 - v3;
                this.slotEnd = v0;
            }
        }
    }

    public final void endGroup() {
        int v0 = this.parent;
        int[] v1 = this.groups;
        if(v0 + 6 > v1.length) {
            return;
        }

        int v2 = v1[v0 + 1];
        int v1_1 = v1[v0 + 2];
        this.parent = v1_1;
        this.setPreviousSibling(v0);
        this.setCurrent(v2);
        v0 = this.groups[v1_1 + 5];
        v1_1 = v0 >> 4;
        SlotTableAddressSpace v2_1 = this.addressSpace;
        if(v0 == -1) {
            v0 = 0;
        }
        else {
            v0 = (v0 & 15) + 1;
            if(v0 > 15) {
                v0 = v2_1.getLargeSizes().get(v1_1);
            }
        }

        v1_1 += v0;
        this.slotEnd = v1_1;
        this.slotCurrent = v1_1 - this.previousSlotCurrentOffset.popOr(0);
    }

    public final List extractKeys() {
        SlotTableReader v0 = this;
        ArrayList v1 = new ArrayList();
        if(v0.getInEmpty()) {
        }
        else {
            int v2 = v0.getPreviousSibling();
            int[] v3 = v0.groups;
            Object[] v4 = v0.slots;
            SlotTable v5 = v0.table;
            int v0_1 = v0.getCurrentGroup();
            int[] v5_1 = v5.getAddressSpace().getGroups();
            int v12 = v2;
            v2 = v0_1;
            v0_1 = v12;
            for(v12 = 0; v2 >= 0; v12 = v13) {
                int v8 = v3[v2 + 4];
                int v9 = v3[v2 + 5] >> 4;
                int v7 = v3[v2];
                int v13 = 0x800000;
                Object v9_1 = (v8 & 0x1000000) == 0x1000000 ? v4[v9 + Integer.bitCount(v8 & v13)] : null;
                long v10 = (((long)v0_1)) << 0x20 | (((long)UInt.constructor-impl(v2))) & 0xFFFFFFFFL;
                v0_1 = (v8 & v13) == v13 ? 1 : 0x7FFFFF & v8;
                v13 = v12 + 1;
                ((List)v1).add(new KeyInfo(v7, v9_1, v10, v0_1, v12));
                v12 = v2;
                v2 = v5_1[v2 + 1];
                v0_1 = v12;
            }
        }

        return ((List)v1);
    }

    public final int firstChildOf(int arg1) {
        return this.groups[arg1 + 3];
    }

    public final int flagsOf(int arg1) {
        return this.groups[arg1 + 4];
    }

    public final Object get(int arg5, int arg6) {
        if(arg6 >= 0) {
            int[] v0 = this.groups;
            Object[] v1 = this.slots;
            int v2 = v0[arg5 + 5];
            if(v2 != -1) {
                arg5 = v0[arg5 + 4];
                SlotTableAddressSpace v4 = this.addressSpace;
                int v0_1 = (v2 & 15) + 1;
                v2 >>= 4;
                if(v0_1 > 15) {
                    v0_1 = v4.getLargeSizes().get(v2);
                }

                arg6 += GroupFlagsKt.utilitySlotsCountForFlags(arg5);
                if(arg6 >= v0_1) {
                    goto label_23;
                }

                return v1[v2 + arg6];
            }
        }

    label_23:
        return Composer.Companion.getEmpty();
    }

    public final Object get(int arg2) {
        return this.get(this.getCurrent(), arg2);
    }

    private final int getCurrent() {
        return this._current;
    }

    public final int getCurrentGroup() {
        return this.getCurrent();
    }

    public final Object getGroupAux() {
        return this.groupAux(this.getCurrent());
    }

    public final int getGroupKey() {
        int v0 = this.getCurrent();
        if(v0 != -1) {
            return this.addressSpace.getGroups()[v0];
        }

        return 0;
    }

    public final Object getGroupNode() {
        return this.groupNode(this.getCurrent());
    }

    public final Object getGroupObjectKey() {
        return this.groupObjectKey(this.getCurrent());
    }

    public final int getGroupReferenceSlotStartAddress() {
        return this.groups[this.parent + 5] >> 4;
    }

    public final boolean getHadNext() {
        return this.hadNext;
    }

    public final boolean getHasObjectKey() {
        return this.hasObjectKey(this.getCurrent());
    }

    public final boolean getInEmpty() {
        if(this.emptyCount > 0) {
            return 1;
        }

        return 0;
    }

    public final int getNextParentSlotAddress() {
        return this.slotCurrent;
    }

    public final int getNodeCount() {
        return this.groups[this.getCurrent() + 4] & 0x7FFFFF;
    }

    public final Object getOrNull(int arg1, int arg2) {
        Object v0 = this.get(arg1, arg2);
        Object v1 = null;
        if(v0 != null) {
            if(Intrinsics.areEqual(v0, Composer.Companion.getEmpty())) {
                return v1;
            }

            return v0;
        }

        return v1;
    }

    public final LinkAnchor getParentAnchor() {
        return this.addressSpace.anchorOfAddress(this.getParentGroup());
    }

    public final int getParentCurrentSlotOffset() {
        int v0 = this.groups[this.parent + 5];
        if(v0 == -1) {
            return 0;
        }

        return this.slotCurrent - (v0 >> 4);
    }

    public final int getParentGroup() {
        return this.parent;
    }

    public final long getParentHandle() {
        return (((long)UInt.constructor-impl(this.parent))) & 0xFFFFFFFFL;
    }

    public final Object getParentNode() {
        return this.groupNode(this.parent);
    }

    public final int getParentNodeCount() {
        int v0 = this.parent;
        if(v0 != -1) {
            int v2 = this.groups[v0 + 4];
            if((v2 & 0x800000) == 0x800000) {
                return 1;
            }

            return v2 & 0x7FFFFF;
        }

        return 0;
    }

    public final int getPreviousSibling() {
        return this._previousSibling;
    }

    public final int getRemainingSlots() {
        return this.slotEnd - this.slotCurrent;
    }

    public final int getSlotCurrent() {
        return this.slotCurrent;
    }

    public final int getSlotEnd() {
        return this.slotEnd;
    }

    public final int getSlotIndex() {
        int v0 = this.parent;
        if(v0 >= 0) {
            return this.slotCurrent - (this.groups[v0 + 5] >> 4);
        }

        return 0;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final Object groupAux(int arg4) {
        int[] v0 = this.groups;
        int v1 = v0[arg4 + 4];
        arg4 = v0[arg4 + 5];
        if((v1 & 0x2000000) == 0x2000000) {
            if(this.emptyCount > 0) {
                this.slots = this.addressSpace.getSlots();
            }

            return this.slots[(arg4 >> 4) + Integer.bitCount(0x1800000 & v1)];
        }

        return Composer.Companion.getEmpty();
    }

    public final int groupKey(int arg1) {
        return this.groups[arg1];
    }

    public final Object groupNode(int arg3) {
        int[] v0 = this.groups;
        int v1 = v0[arg3 + 4];
        arg3 = v0[arg3 + 5];
        if((v1 & 0x800000) == 0x800000) {
            if(this.emptyCount > 0) {
                this.slots = this.addressSpace.getSlots();
            }

            return this.slots[arg3 >> 4];
        }

        return null;
    }

    public final Object groupObjectKey(int arg4) {
        int[] v0 = this.groups;
        int v1 = v0[arg4 + 4];
        arg4 = v0[arg4 + 5];
        if((v1 & 0x1000000) == 0x1000000) {
            if(this.emptyCount > 0) {
                this.slots = this.addressSpace.getSlots();
            }

            return this.slots[(arg4 >> 4) + Integer.bitCount(0x800000 & v1)];
        }

        return null;
    }

    public final long handle() {
        return GroupHandleKt.makeGroupHandle(this.parent, this.getPreviousSibling(), this.getCurrent());
    }

    public final boolean hasObjectKey(int arg1) {
        if((this.groups[arg1 + 4] & 0x1000000) == 0x1000000) {
            return 1;
        }

        return 0;
    }

    public final boolean hasRecomposeRequired(int arg1) {
        if((this.groups[arg1 + 4] & 0xC000000) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public final boolean isEmpty() {
        return this.table.isEmpty();
    }

    public final boolean isGroupEnd() {
        if(this.getCurrent() == -1 && !this.getInEmpty()) {
            return 1;
        }

        return 0;
    }

    public final boolean isNode(int arg1) {
        if((this.groups[arg1 + 4] & 0x800000) == 0x800000) {
            return 1;
        }

        return 0;
    }

    public final boolean isNode() {
        if((this.groups[this.getCurrent() + 4] & 0x800000) == 0x800000) {
            return 1;
        }

        return 0;
    }

    public final Object maybeNode(int arg3) {
        if((this.groups[arg3 + 4] & 0x800000) == 0x800000) {
            if(this.emptyCount > 0) {
                this.slots = this.addressSpace.getSlots();
            }

            return this.slots[this.groups[arg3 + 5] >> 4];
        }

        return Composer.Companion.getEmpty();
    }

    public final Object next() {
        if(!this.getInEmpty()) {
            int v0 = this.slotCurrent;
            if(v0 >= this.slotEnd) {
            }
            else {
                this.hadNext = true;
                Object[] v1 = this.slots;
                this.slotCurrent = v0 + 1;
                return v1[v0];
            }
        }

        this.hadNext = false;
        return Composer.Companion.getEmpty();
    }

    public final int nextSiblingOf(int arg1) {
        return this.groups[arg1 + 1];
    }

    public final Object node(int arg2) {
        return this.slots[this.groups[arg2 + 5] >> 4];
    }

    public final int nodeCount(int arg2) {
        int v1 = this.groups[arg2 + 4];
        if((v1 & 0x800000) == 0x800000) {
            return 1;
        }

        return v1 & 0x7FFFFF;
    }

    public final int parentGroupFlags() {
        return this.flagsOf(this.parent);
    }

    public final int parentOf(int arg1) {
        return this.groups[arg1 + 2];
    }

    public final boolean recomposeRequired(int arg1) {
        if((this.groups[arg1 + 4] & 0x4000000) == 0x4000000) {
            return 1;
        }

        return 0;
    }

    public final void removeFlag(int arg2) {
        this.removeFlag(this.parent, arg2);
    }

    public final void removeFlag(int arg10, int arg11) {
        int[] v0 = this.addressSpace.getGroups();
        int v1 = arg10 + 4;
        int v2 = v0[v1];
        if((arg11 & v2) == arg11) {
            v2 &= ~arg11;
            v0[v1] = v2;
            v1 = GroupFlagsKt.propagatingFlagsOf(arg11);
            if((v2 & v1) != 0) {
            }
            else {
                arg11 |= v1;
                int[] v2_1 = this.addressSpace.getGroups();
                int v3 = v2_1[arg10 + 2];
                while(true) {
                    if(v3 > 0) {
                        int v4 = v3 + 4;
                        int v5 = v0[v4];
                        if((v5 & v1) != 0) {
                            int[] v6 = this.addressSpace.getGroups();
                            int v7 = v6[v3 + 3];
                            while(true) {
                                if(v7 <= 0) {
                                    break;
                                }
                                else if((v0[v7 + 4] & arg11) != 0) {
                                }
                                else {
                                    v7 = v6[v7 + 1];
                                    continue;
                                }

                                return;
                            }

                            v0[v4] = v5 & ~v1;
                            v3 = v2_1[v3 + 2];
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    return;
                }

                int v9 = v3 != 0 ? 1 : 0;
                if(v9 != 0) {
                    return;
                }

                ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg10);
            }
        }
    }

    public final void reposition(long arg2) {
        if(this.getInEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Cannot reposition while in an empty region");
        }

        this.setCurrent(GroupHandleKt.getGroup(arg2));
        this.setPreviousSibling(GroupHandleKt.getContext(arg2));
        this.parent = this.groups[this.getCurrent() + 2];
    }

    public final void reposition(int arg5) {
        this.reposition((((long)UInt.constructor-impl(arg5))) & 0xFFFFFFFFL);
    }

    public final void restoreParent(int arg2) {
        this.setPreviousSibling(0);
        this.parent = arg2;
        this.slotCurrent = 0;
        this.slotEnd = 0;
    }

    public final long rootHandle() {
        return (((long)UInt.constructor-impl(this.table.getRoot()))) & 0xFFFFFFFFL | -4294967296L;
    }

    private final void setCurrent(int arg1) {
        this._current = arg1;
    }

    private final void setPreviousSibling(int arg1) {
        this._previousSibling = arg1;
    }

    public final void setSlotCurrent(int arg1) {
        this.slotCurrent = arg1;
    }

    public final void setSlotEnd(int arg1) {
        this.slotEnd = arg1;
    }

    public final int skipGroup() {
        int v0 = this.getCurrent();
        int[] v1 = this.groups;
        if(v0 + 6 > v1.length) {
            return 0;
        }

        int v2 = v1[v0 + 4];
        if((v2 & 0x800000) == 0x800000) {
            v2 = 1;
        }
        else {
            v2 &= 0x7FFFFF;
        }

        this.setCurrent(v1[v0 + 1]);
        this.setPreviousSibling(v0);
        return v2;
    }

    public final void skipToGroupEnd() {
        this.setCurrent(-1);
        this.setPreviousSibling(0);
        this.slotCurrent = 0;
        this.slotEnd = 0;
    }

    public final void startGroup() {
        int v0 = this.getCurrent();
        this.parent = v0;
        int[] v1 = this.groups;
        if(v0 + 6 > v1.length) {
            return;
        }

        this.setCurrent(v1[v0 + 3]);
        int v2 = -1;
        this.setPreviousSibling(v2);
        this.previousSlotCurrentOffset.push(this.slotEnd - this.slotCurrent);
        int v3 = v1[v0 + 5];
        if(v3 != v2) {
            v0 = v1[v0 + 4];
            int v1_1 = v3 >> 4;
            this.slotCurrent = GroupFlagsKt.utilitySlotsCountForFlags(v0) + v1_1;
            SlotTableAddressSpace v0_1 = this.addressSpace;
            if(v3 == v2) {
                v0 = 0;
            }
            else {
                v3 = (v3 & 15) + 1;
                v0 = v3 > 15 ? v0_1.getLargeSizes().get(v1_1) : v3;
            }

            this.slotEnd = v1_1 + v0;
            return;
        }

        this.slotCurrent = v2;
        this.slotEnd = v2;
    }

    public final void startNode() {
        if(!this.isNode()) {
            ComposerKt.composeImmediateRuntimeError("Expected a node group");
        }

        this.startGroup();
    }

    public final void traverseChildrenByHandle(int arg7, Function1 arg8) {
        long v2 = 0xFFFFFFFFL;
        long v0 = (((long)UInt.constructor-impl(this.firstChildOf(arg7)))) & v2;
        long v4 = -4294967296L;
        while(true) {
            v0 |= v4;
            if(GroupHandleKt.getGroup(v0) == -1) {
                return;
            }

            arg8.invoke(Long.valueOf(v0));
            v4 = (((long)GroupHandleKt.getGroup(v0))) << 0x20;
            v0 = (((long)UInt.constructor-impl(this.nextSiblingOf(GroupHandleKt.getGroup(v0))))) & v2;
        }
    }

    public final void traverseChildrenConditionally(int arg7, Function1 arg8, Function1 arg9, Function1 arg10, Function1 arg11) {
        int v0 = this.firstChildOf(arg7);
        while(true) {
        label_1:
            int v1 = -1;
            if(v0 != v1) {
                boolean v2 = arg9.invoke(Integer.valueOf(v0)).booleanValue();
                int v3 = this.firstChildOf(v0);
                if(!v2 && v3 != v1 && (arg8.invoke(Integer.valueOf(v0)).booleanValue())) {
                    v0 = v3;
                    continue;
                }

                break;
            }

            return;
        }

        if(v3 == v1 && !v2) {
            arg11.invoke(Integer.valueOf(v0));
        }

        int v2_1 = v0;
        for(v0 = this.nextSiblingOf(v0); true; v0 = this.nextSiblingOf(v2_1)) {
            if(v0 != v1) {
                goto label_1;
            }

            v2_1 = this.parentOf(v2_1);
            if(v2_1 == v1) {
                return;
            }

            if(v2_1 == arg7) {
                return;
            }

            arg10.invoke(Integer.valueOf(v2_1));
        }
    }

    public final void traverseGroupPartially(int arg5, boolean arg6, Function1 arg7) {
        SlotTableAddressSpace v4 = this.addressSpace;
        if(arg5 >= 0) {
            IntStack v0 = new IntStack();
            int[] v4_1 = v4.getGroups();
            int v1;
            for(v1 = arg5; true; v1 = v0.pop()) {
            label_6:
                boolean v2 = arg7.invoke(Integer.valueOf(v1)).booleanValue();
                if(v1 != arg5 || (arg6)) {
                    int v3 = v4_1[v1 + 1];
                    if(v3 >= 0) {
                        v0.push(v3);
                    }
                }

                v1 = v4_1[v1 + 3];
                if((v2) && v1 >= 0) {
                    goto label_6;
                }

                if(v0.tos == 0) {
                    return;
                }
            }
        }
    }

    public static void traverseGroupPartially$default(SlotTableReader arg2, int arg3, boolean arg4, Function1 arg5, int arg6, Object arg7) {
        SlotTableAddressSpace v2 = arg2.addressSpace;
        if(arg3 >= 0) {
            IntStack v6 = new IntStack();
            int[] v2_1 = v2.getGroups();
            int v7;
            for(v7 = arg3; true; v7 = v6.pop()) {
            label_9:
                boolean v0 = arg5.invoke(Integer.valueOf(v7)).booleanValue();
                if(v7 != arg3 || 0 != 0) {
                    int v1 = v2_1[v7 + 1];
                    if(v1 >= 0) {
                        v6.push(v1);
                    }
                }

                v7 = v2_1[v7 + 3];
                if((v0) && v7 >= 0) {
                    goto label_9;
                }

                if(v6.tos == 0) {
                    return;
                }
            }
        }
    }

    private final Object[] upToDateSlots() {
        if(this.emptyCount > 0) {
            this.slots = this.addressSpace.getSlots();
        }

        return this.slots;
    }
}

