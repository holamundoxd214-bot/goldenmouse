package androidx.compose.runtime.composer.gapbuffer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.PreconditionsKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010!\u001A\u00020\u000B2\u0006\u0010,\u001A\u00020\u000BJ\u000E\u0010-\u001A\u00020\u00162\u0006\u0010,\u001A\u00020\u000BJ\u000E\u0010.\u001A\u00020\u000B2\u0006\u0010,\u001A\u00020\u000BJ\u0010\u00100\u001A\u0004\u0018\u00010\u00012\u0006\u0010,\u001A\u00020\u000BJ\u000E\u00104\u001A\u00020\u000B2\u0006\u0010,\u001A\u00020\u000BJ\u000E\u00106\u001A\u00020\u000B2\u0006\u00107\u001A\u00020\u000BJ\u000E\u00108\u001A\u00020\u000B2\u0006\u0010,\u001A\u00020\u000BJ\u000E\u0010:\u001A\u00020\u000B2\u0006\u0010,\u001A\u00020\u000BJ\u000E\u0010>\u001A\u00020\u00162\u0006\u0010,\u001A\u00020\u000BJ\u0010\u0010@\u001A\u0004\u0018\u00010\u00012\u0006\u0010,\u001A\u00020\u000BJ\u0010\u0010C\u001A\u0004\u0018\u00010\u00012\u0006\u0010,\u001A\u00020\u000BJ\u000E\u0010:\u001A\u00020\u000B2\u0006\u0010G\u001A\u00020\u0012J\u000E\u0010H\u001A\u00020\u00162\u0006\u0010,\u001A\u00020\u000BJ\u000E\u0010I\u001A\u00020\u00162\u0006\u0010,\u001A\u00020\u000BJ\u000E\u0010N\u001A\u00020\u000B2\u0006\u0010,\u001A\u00020\u000BJ\u0010\u0010Q\u001A\u0004\u0018\u00010\u00012\u0006\u0010,\u001A\u00020\u000BJ\u0010\u0010R\u001A\u0004\u0018\u00010\u00012\u0006\u0010,\u001A\u00020\u000BJ\u0018\u0010R\u001A\u0004\u0018\u00010\u00012\u0006\u00107\u001A\u00020\u000B2\u0006\u0010,\u001A\u00020\u000BJ\b\u0010S\u001A\u0004\u0018\u00010\u0001J\u0006\u0010V\u001A\u00020WJ\u0006\u0010X\u001A\u00020WJ\u0006\u0010Y\u001A\u00020WJ\u0006\u0010Z\u001A\u00020WJ\u0006\u0010[\u001A\u00020WJ\u0006\u0010\\\u001A\u00020\u000BJ\u0006\u0010]\u001A\u00020WJ\u000E\u0010^\u001A\u00020W2\u0006\u0010,\u001A\u00020\u000BJ\u000E\u0010_\u001A\u00020W2\u0006\u0010,\u001A\u00020\u000BJ\u0006\u0010`\u001A\u00020WJ\f\u0010a\u001A\b\u0012\u0004\u0012\u00020c0bJ\b\u0010d\u001A\u00020eH\u0016J\u0010\u0010G\u001A\u00020\u00122\b\b\u0002\u0010,\u001A\u00020\u000BJ\u0016\u00100\u001A\u0004\u0018\u00010\u0001*\u00020\t2\u0006\u0010,\u001A\u00020\u000BH\u0002J\u0016\u0010f\u001A\u0004\u0018\u00010\u0001*\u00020\t2\u0006\u0010,\u001A\u00020\u000BH\u0002J\u0016\u0010g\u001A\u0004\u0018\u00010\u0001*\u00020\t2\u0006\u0010,\u001A\u00020\u000BH\u0002R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u000E\u0010\u000F\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0010\u001A\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0015\u001A\u00020\u0016@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u001A\u0010\u001A\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u001E\u0010\u001F\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u000B@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u001CR\u001E\u0010!\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u000B@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u001CR\u000E\u0010#\u001A\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010(\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b)\u0010\u001CR\u0011\u0010*\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b+\u0010\u001CR\u0011\u0010-\u001A\u00020\u00168F¢\u0006\u0006\u001A\u0004\b-\u0010\u0019R\u0011\u0010.\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b/\u0010\u001CR\u0011\u00101\u001A\u00020\u00168F¢\u0006\u0006\u001A\u0004\b1\u0010\u0019R\u0011\u00102\u001A\u00020\u00168F¢\u0006\u0006\u001A\u0004\b3\u0010\u0019R\u0011\u00104\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b5\u0010\u001CR\u0011\u00108\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b9\u0010\u001CR\u0011\u0010:\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b;\u0010\u001CR\u0011\u0010<\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b=\u0010\u001CR\u0011\u0010>\u001A\u00020\u00168F¢\u0006\u0006\u001A\u0004\b?\u0010\u0019R\u0013\u0010@\u001A\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001A\u0004\bA\u0010BR\u0013\u0010C\u001A\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001A\u0004\bD\u0010BR\u0013\u0010E\u001A\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001A\u0004\bF\u0010BR\u0011\u0010J\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\bK\u0010\u001CR\u0011\u0010L\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\bM\u0010\u001CR\u0011\u0010O\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\bP\u0010\u001CR\u001E\u0010T\u001A\u00020\u00162\u0006\u0010\u0015\u001A\u00020\u0016@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\bU\u0010\u0019¨\u0006h"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/SlotReader;", "", "table", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "<init>", "(Landroidx/compose/runtime/composer/gapbuffer/SlotTable;)V", "getTable$runtime", "()Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "groups", "", "groupsSize", "", "slots", "", "[Ljava/lang/Object;", "slotsSize", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "Landroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;", "Lkotlin/collections/HashMap;", "value", "", "closed", "getClosed", "()Z", "currentGroup", "getCurrentGroup", "()I", "setCurrentGroup", "(I)V", "currentEnd", "getCurrentEnd", "parent", "getParent", "currentSlotStack", "Landroidx/compose/runtime/IntStack;", "emptyCount", "currentSlot", "currentSlotEnd", "size", "getSize", "slot", "getSlot", "index", "isNode", "nodeCount", "getNodeCount", "node", "isGroupEnd", "inEmpty", "getInEmpty", "groupSize", "getGroupSize", "slotSize", "group", "groupEnd", "getGroupEnd", "groupKey", "getGroupKey", "groupSlotIndex", "getGroupSlotIndex", "hasObjectKey", "getHasObjectKey", "groupObjectKey", "getGroupObjectKey", "()Ljava/lang/Object;", "groupAux", "getGroupAux", "groupNode", "getGroupNode", "anchor", "hasMark", "containsMark", "parentNodes", "getParentNodes", "remainingSlots", "getRemainingSlots", "parentOf", "groupSlotCount", "getGroupSlotCount", "get", "groupGet", "next", "hadNext", "getHadNext", "beginEmpty", "", "endEmpty", "close", "startGroup", "startNode", "skipGroup", "skipToGroupEnd", "reposition", "restoreParent", "endGroup", "extractKeys", "", "Landroidx/compose/runtime/composer/gapbuffer/KeyInfo;", "toString", "", "aux", "objectKey", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SlotReader {
    public static final int $stable = 8;
    private boolean closed;
    private int currentEnd;
    private int currentGroup;
    private int currentSlot;
    private int currentSlotEnd;
    private final IntStack currentSlotStack;
    private int emptyCount;
    private final int[] groups;
    private final int groupsSize;
    private boolean hadNext;
    private int parent;
    private Object[] slots;
    private final int slotsSize;
    private HashMap sourceInformationMap;
    private final SlotTable table;

    static {
    }

    public SlotReader(SlotTable arg3) {
        super();
        this.table = arg3;
        this.groups = arg3.getGroups();
        int v0 = arg3.getGroupsSize();
        this.groupsSize = v0;
        this.slots = arg3.getSlots();
        this.slotsSize = arg3.getSlotsSize();
        this.currentEnd = v0;
        this.parent = -1;
        this.currentSlotStack = new IntStack();
    }

    public final GapAnchor anchor(int arg3) {
        ArrayList v0 = this.table.getAnchors$runtime();
        int v2 = SlotTableKt.access$search(v0, arg3, this.groupsSize);
        if(v2 < 0) {
            GapAnchor v1 = new GapAnchor(arg3);
            v0.add(-(v2 + 1), v1);
            return v1;
        }

        return v0.get(v2);
    }

    public static GapAnchor anchor$default(SlotReader arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.currentGroup;
        }

        return arg0.anchor(arg1);
    }

    private final Object aux(int[] arg3, int arg4) {
        if((arg3[arg4 * 5 + 1] & 0x10000000) != 0) {
            return this.slots[SlotTableKt.access$auxIndex(arg3, arg4)];
        }

        return Composer.Companion.getEmpty();
    }

    public final void beginEmpty() {
        ++this.emptyCount;
    }

    public final void close() {
        this.closed = true;
        this.table.close$runtime(this, this.sourceInformationMap);
        this.slots = new Object[0];
    }

    public final boolean containsMark(int arg2) {
        if((this.groups[arg2 * 5 + 1] & 0x4000000) != 0) {
            return 1;
        }

        return 0;
    }

    public final void endEmpty() {
        int v0 = this.emptyCount > 0 ? 1 : 0;
        if(v0 == 0) {
            PreconditionsKt.throwIllegalArgumentException("Unbalanced begin/end empty");
        }

        --this.emptyCount;
    }

    public final void endGroup() {
        if(this.emptyCount == 0) {
            int v0 = this.currentGroup == this.currentEnd ? 1 : 0;
            if(v0 == 0) {
                ComposerKt.composeImmediateRuntimeError("endGroup() not called at the end of a group");
            }

            int[] v0_1 = this.groups;
            int v1 = v0_1[this.parent * 5 + 2];
            this.parent = v1;
            v0 = v1 < 0 ? this.groupsSize : SlotTableKt.access$groupSize(v0_1, v1) + v1;
            this.currentEnd = v0;
            v0 = this.currentSlotStack.pop();
            if(v0 < 0) {
                this.currentSlot = 0;
                this.currentSlotEnd = 0;
                return;
            }

            this.currentSlot = v0;
            v0 = v1 >= this.groupsSize - 1 ? this.slotsSize : this.groups[(v1 + 1) * 5 + 4];
            this.currentSlotEnd = v0;
        }
    }

    public final List extractKeys() {
        ArrayList v0 = new ArrayList();
        if(this.emptyCount > 0) {
        }
        else {
            int v2 = 0;
            int v6 = this.currentGroup;
            while(true) {
                int v8 = v2;
                if(v6 < this.currentEnd) {
                    int[] v1 = this.groups;
                    v2 = v6 * 5;
                    int v4 = v1[v2];
                    Object v5 = this.objectKey(v1, v6);
                    int v7 = 1;
                    int v1_1 = this.groups[v2 + 1];
                    if((0x40000000 & v1_1) != 0) {
                    }
                    else {
                        v7 = v1_1 & 0x3FFFFFF;
                    }

                    v2 = v8 + 1;
                    ((List)v0).add(new KeyInfo(v4, v5, v6, v7, v8));
                    v6 += SlotTableKt.access$groupSize(this.groups, v6);
                    continue;
                }

                break;
            }
        }

        return ((List)v0);
    }

    public final Object get(int arg2) {
        int v0 = this.currentSlot + arg2;
        if(v0 < this.currentSlotEnd) {
            return this.slots[v0];
        }

        return Composer.Companion.getEmpty();
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getCurrentEnd() {
        return this.currentEnd;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final Object getGroupAux() {
        int v0 = this.currentGroup;
        if(v0 < this.currentEnd) {
            return this.aux(this.groups, v0);
        }

        return Integer.valueOf(0);
    }

    public final int getGroupEnd() {
        return this.currentEnd;
    }

    public final int getGroupKey() {
        int v0 = this.currentGroup;
        if(v0 < this.currentEnd) {
            return this.groups[v0 * 5];
        }

        return 0;
    }

    public final Object getGroupNode() {
        int v0 = this.currentGroup;
        if(v0 < this.currentEnd) {
            return this.node(this.groups, v0);
        }

        return null;
    }

    public final Object getGroupObjectKey() {
        int v0 = this.currentGroup;
        if(v0 < this.currentEnd) {
            return this.objectKey(this.groups, v0);
        }

        return null;
    }

    public final int getGroupSize() {
        return SlotTableKt.access$groupSize(this.groups, this.currentGroup);
    }

    public final int getGroupSlotCount() {
        int v0 = this.currentGroup;
        int v1 = SlotTableKt.access$slotAnchor(this.groups, v0);
        ++v0;
        int v3 = v0 < this.groupsSize ? this.groups[v0 * 5 + 4] : this.slotsSize;
        return v3 - v1;
    }

    public final int getGroupSlotIndex() {
        return this.currentSlot - SlotTableKt.access$slotAnchor(this.groups, this.parent);
    }

    public final boolean getHadNext() {
        return this.hadNext;
    }

    public final boolean getHasObjectKey() {
        int v0 = this.currentGroup;
        if(v0 < this.currentEnd && (this.groups[v0 * 5 + 1] & 0x20000000) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean getInEmpty() {
        if(this.emptyCount > 0) {
            return 1;
        }

        return 0;
    }

    public final int getNodeCount() {
        return this.groups[this.currentGroup * 5 + 1] & 0x3FFFFFF;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getParentNodes() {
        int v0 = this.parent;
        if(v0 >= 0) {
            return this.groups[v0 * 5 + 1] & 0x3FFFFFF;
        }

        return 0;
    }

    public final int getRemainingSlots() {
        return this.currentSlotEnd - this.currentSlot;
    }

    public final int getSize() {
        return this.groupsSize;
    }

    public final int getSlot() {
        return this.currentSlot - SlotTableKt.access$slotAnchor(this.groups, this.parent);
    }

    public final SlotTable getTable$runtime() {
        return this.table;
    }

    public final Object groupAux(int arg2) {
        return this.aux(this.groups, arg2);
    }

    public final int groupEnd(int arg1) {
        return arg1 + SlotTableKt.access$groupSize(this.groups, arg1);
    }

    public final Object groupGet(int arg3, int arg4) {
        int v0 = SlotTableKt.access$slotAnchor(this.groups, arg3);
        ++arg3;
        arg3 = arg3 < this.groupsSize ? this.groups[arg3 * 5 + 4] : this.slotsSize;
        v0 += arg4;
        if(v0 < arg3) {
            return this.slots[v0];
        }

        return Composer.Companion.getEmpty();
    }

    public final Object groupGet(int arg2) {
        return this.groupGet(this.currentGroup, arg2);
    }

    public final int groupKey(int arg1) {
        return this.groups[arg1 * 5];
    }

    public final int groupKey(GapAnchor arg2) {
        if(arg2.getValid()) {
            return this.groups[this.table.anchorIndex(arg2) * 5];
        }

        return 0;
    }

    public final Object groupObjectKey(int arg2) {
        return this.objectKey(this.groups, arg2);
    }

    public final int groupSize(int arg1) {
        return SlotTableKt.access$groupSize(this.groups, arg1);
    }

    public final boolean hasMark(int arg2) {
        if((this.groups[arg2 * 5 + 1] & 0x8000000) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean hasObjectKey(int arg2) {
        if((this.groups[arg2 * 5 + 1] & 0x20000000) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isGroupEnd() {
        if(!this.getInEmpty()) {
            if(this.currentGroup == this.currentEnd) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean isNode(int arg2) {
        if((this.groups[arg2 * 5 + 1] & 0x40000000) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isNode() {
        if((this.groups[this.currentGroup * 5 + 1] & 0x40000000) != 0) {
            return 1;
        }

        return 0;
    }

    public final Object next() {
        if(this.emptyCount <= 0) {
            int v0 = this.currentSlot;
            if(v0 >= this.currentSlotEnd) {
            }
            else {
                this.hadNext = true;
                Object[] v1 = this.slots;
                this.currentSlot = v0 + 1;
                return v1[v0];
            }
        }

        this.hadNext = false;
        return Composer.Companion.getEmpty();
    }

    public final Object node(int arg4) {
        int[] v0 = this.groups;
        if((v0[arg4 * 5 + 1] & 0x40000000) != 0) {
            return this.node(v0, arg4);
        }

        return null;
    }

    private final Object node(int[] arg3, int arg4) {
        arg4 *= 5;
        if((arg3[arg4 + 1] & 0x40000000) != 0) {
            return this.slots[arg3[arg4 + 4]];
        }

        return Composer.Companion.getEmpty();
    }

    public final int nodeCount(int arg1) {
        return this.groups[arg1 * 5 + 1] & 0x3FFFFFF;
    }

    private final Object objectKey(int[] arg3, int arg4) {
        if((arg3[arg4 * 5 + 1] & 0x20000000) != 0) {
            return this.slots[SlotTableKt.access$objectKeyIndex(arg3, arg4)];
        }

        return null;
    }

    public final int parent(int arg1) {
        return this.groups[arg1 * 5 + 2];
    }

    public final int parentOf(int arg3) {
        int v0 = arg3 < 0 || arg3 >= this.groupsSize ? 0 : 1;
        if(v0 == 0) {
            PreconditionsKt.throwIllegalArgumentException("Invalid group index " + arg3);
        }

        return this.groups[arg3 * 5 + 2];
    }

    public final void reposition(int arg4) {
        int v0 = this.emptyCount == 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot reposition while in an empty region");
        }

        this.currentGroup = arg4;
        v0 = this.groupsSize;
        arg4 = arg4 < v0 ? this.groups[arg4 * 5 + 2] : -1;
        if(arg4 != this.parent) {
            this.parent = arg4;
            this.currentEnd = arg4 < 0 ? v0 : arg4 + SlotTableKt.access$groupSize(this.groups, arg4);
            this.currentSlot = 0;
            this.currentSlotEnd = 0;
        }
    }

    public final void restoreParent(int arg6) {
        int v0 = SlotTableKt.access$groupSize(this.groups, arg6) + arg6;
        int v1 = this.currentGroup;
        int v3 = v1 < arg6 || v1 > v0 ? 0 : 1;
        if(v3 == 0) {
            ComposerKt.composeImmediateRuntimeError("Index " + arg6 + " is not a parent of " + v1);
        }

        this.parent = arg6;
        this.currentEnd = v0;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
    }

    public final void setCurrentGroup(int arg1) {
        this.currentGroup = arg1;
    }

    public final int skipGroup() {
        int v1 = 1;
        int v0 = this.emptyCount == 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot skip while in an empty region");
        }

        int[] v0_1 = this.groups;
        int v2 = this.currentGroup;
        if((v0_1[v2 * 5 + 1] & 0x40000000) != 0) {
        }
        else {
            v1 = v0_1[v2 * 5 + 1] & 0x3FFFFFF;
        }

        this.currentGroup = v2 + SlotTableKt.access$groupSize(v0_1, v2);
        return v1;
    }

    public final void skipToGroupEnd() {
        int v0 = this.emptyCount == 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot skip the enclosing group while in an empty region");
        }

        this.currentGroup = this.currentEnd;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
    }

    public final int slotSize(int arg3) {
        int v0 = SlotTableKt.access$slotAnchor(this.groups, arg3);
        ++arg3;
        int v2 = arg3 < this.groupsSize ? this.groups[arg3 * 5 + 4] : this.slotsSize;
        return v2 - v0;
    }

    public final void startGroup() {
        if(this.emptyCount <= 0) {
            int v0 = this.parent;
            int v1 = this.currentGroup;
            int v2 = this.groups[v1 * 5 + 2] == v0 ? 1 : 0;
            if(v2 == 0) {
                PreconditionsKt.throwIllegalArgumentException("Invalid slot table detected");
            }

            HashMap v2_1 = this.sourceInformationMap;
            if(v2_1 != null) {
                Object v0_1 = v2_1.get(this.anchor(v0));
                if(v0_1 != null) {
                    ((GapGroupSourceInformation)v0_1).reportGroup(this.table, v1);
                }
            }

            IntStack v0_2 = this.currentSlotStack;
            v2 = this.currentSlot;
            int v4 = this.currentSlotEnd;
            if(v2 != 0 || v4 != 0) {
                v0_2.push(v2);
            }
            else {
                v0_2.push(-1);
            }

            this.parent = v1;
            this.currentEnd = SlotTableKt.access$groupSize(this.groups, v1) + v1;
            v0 = v1 + 1;
            this.currentGroup = v0;
            this.currentSlot = SlotTableKt.access$slotAnchor(this.groups, v1);
            v0 = v1 >= this.groupsSize - 1 ? this.slotsSize : this.groups[v0 * 5 + 4];
            this.currentSlotEnd = v0;
        }
    }

    public final void startNode() {
        if(this.emptyCount <= 0) {
            int v2 = 1;
            if((this.groups[this.currentGroup * 5 + 1] & 0x40000000) != 0) {
            }
            else {
                v2 = 0;
            }

            if(v2 == 0) {
                PreconditionsKt.throwIllegalArgumentException("Expected a node group");
            }

            this.startGroup();
        }
    }

    public String toString() {
        return "SlotReader(current=" + this.currentGroup + ", key=" + this.getGroupKey() + ", parent=" + this.parent + ", end=" + this.currentEnd + ')';
    }
}

