package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB!\b\u0016\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\u000BJ\u0012\u00107\u001A\u00020\u00152\n\u00108\u001A\u00060\u0015j\u0002`\u0019J\u0014\u00109\u001A\u0004\u0018\u00010\u00012\n\u00108\u001A\u00060\u0015j\u0002`\u0019J\u0014\u0010:\u001A\u0004\u0018\u00010\u00012\n\u00108\u001A\u00060\u0015j\u0002`\u0019J\u0012\u0010;\u001A\u00020\u00152\n\u00108\u001A\u00060\u0015j\u0002`<J\u0006\u0010=\u001A\u00020\u0005J\n\u0010>\u001A\u000603j\u0002`4J\u0012\u0010\u0014\u001A\u00020\u00152\n\u00108\u001A\u00060\u0015j\u0002`\u0019J\u0006\u0010?\u001A\u00020@J\u0006\u0010A\u001A\u00020@J\u0006\u0010B\u001A\u00020@J\u001D\u0010C\u001A\u00020@2\u0006\u0010D\u001A\u00020\u00152\n\b\u0002\u0010E\u001A\u0004\u0018\u00010\u0001H\u0086\bJ%\u0010F\u001A\u00020@2\u0006\u0010D\u001A\u00020\u00152\b\u0010E\u001A\u0004\u0018\u00010\u00012\b\u0010G\u001A\u0004\u0018\u00010\u0001H\u0086\bJ%\u0010H\u001A\u00020@2\u0006\u0010D\u001A\u00020\u00152\b\u0010E\u001A\u0004\u0018\u00010\u00012\b\u0010I\u001A\u0004\u0018\u00010\u0001H\u0086\bJ:\u0010J\u001A\u00020@2\u0006\u0010D\u001A\u00020\u00152\n\u0010K\u001A\u00060\u0015j\u0002`L2\b\u0010E\u001A\u0004\u0018\u00010\u00012\b\u0010I\u001A\u0004\u0018\u00010\u00012\b\u0010G\u001A\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010M\u001A\u00020\u0015J\u0010\u0010N\u001A\u00020@2\b\u0010&\u001A\u0004\u0018\u00010\u0001J\u0010\u0010O\u001A\u00020@2\b\u0010&\u001A\u0004\u0018\u00010\u0001J\u0012\u0010P\u001A\u00020@2\n\u0010K\u001A\u00060\u0015j\u0002`LJ\u001A\u0010Q\u001A\u00020@2\u0006\u0010R\u001A\u00020S2\n\u0010T\u001A\u000603j\u0002`4J\u000E\u0010U\u001A\u00020@2\u0006\u0010V\u001A\u00020WJ\u0016\u0010X\u001A\u00020@2\u0006\u0010D\u001A\u00020\u00152\u0006\u0010V\u001A\u00020WJ\u0006\u0010Y\u001A\u00020@J\u0006\u0010Z\u001A\u00020@J\u0006\u0010[\u001A\u00020\u0003J\b\u0010\\\u001A\u00020@H\u0002J\u0010\u0010]\u001A\u00020\u00152\u0006\u0010^\u001A\u00020\u0015H\u0002J\u0014\u0010_\u001A\u00020@2\n\u0010^\u001A\u00060\u0015j\u0002`\u0019H\u0002J\b\u0010`\u001A\u00020@H\u0002J\b\u0010a\u001A\u00020@H\u0002J\u0012\u0010b\u001A\u00020@2\b\u0010&\u001A\u0004\u0018\u00010\u0001H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0006\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000F\"\u0004\b\u0013\u0010\u0011R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001A\u00060\u0015j\u0002`\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\u001C\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001DX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001ER\u000E\u0010\u001F\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010\'\u001A\u00020\u00052\u0006\u0010&\u001A\u00020\u0005@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010\u000FR\u0011\u0010(\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b(\u0010\u000FR\u0011\u0010)\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b*\u0010+R\u0011\u0010,\u001A\u00020-8F¢\u0006\u0006\u001A\u0004\b.\u0010/R\u0011\u00100\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b1\u0010+R\u0015\u00102\u001A\u000603j\u0002`48F¢\u0006\u0006\u001A\u0004\b5\u00106¨\u0006c"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "recordSourceInformation", "", "recordCallByInformation", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;ZZ)V", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;ZZ)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "getRecordSourceInformation", "()Z", "setRecordSourceInformation", "(Z)V", "getRecordCallByInformation", "setRecordCallByInformation", "parent", "", "parentStack", "Landroidx/compose/runtime/IntStack;", "previousSibling", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "previousSiblingStack", "nodeCount", "slots", "", "[Ljava/lang/Object;", "slotStart", "slotCurrent", "slotEnd", "inReservedRange", "slotReserveStart", "slotReserveEnd", "slotReserveUsedUpTo", "value", "isClosed", "isEmpty", "parentGroup", "getParentGroup", "()I", "parentAnchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "getParentAnchor", "()Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "slotIndex", "getSlotIndex", "parentHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "getParentHandle", "()J", "groupKey", "address", "groupObjectKey", "groupAux", "flagsOf", "Landroidx/compose/runtime/composer/linkbuffer/SlotAddress;", "isNode", "lastRoot", "buildStart", "", "collectSourceInformation", "collectCallByInformation", "startGroup", "key", "objectKey", "startNodeGroup", "node", "startDataGroup", "aux", "startNewGroup", "flags", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "endGroup", "append", "insertAux", "addFlags", "moveFrom", "sourceEditor", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "sourceHandle", "recordGroupSourceInformation", "sourceInformation", "", "recordGrouplessCallSourceInformationStart", "recordGrouplessCallSourceInformationEnd", "close", "build", "buildEnd", "saveSlotRange", "group", "restoreFromSlotRange", "reserveSlotSlotRegion", "returnReservedSlotRegion", "slowAppend", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SlotTableBuilder {
    public static final int $stable = 8;
    private final SlotTableAddressSpace addressSpace;
    private boolean inReservedRange;
    private boolean isClosed;
    private int nodeCount;
    private int parent;
    private final IntStack parentStack;
    private int previousSibling;
    private final IntStack previousSiblingStack;
    private boolean recordCallByInformation;
    private boolean recordSourceInformation;
    private int slotCurrent;
    private int slotEnd;
    private int slotReserveEnd;
    private int slotReserveStart;
    private int slotReserveUsedUpTo;
    private int slotStart;
    private Object[] slots;
    private final SlotTable table;

    static {
    }

    public SlotTableBuilder(SlotTableAddressSpace arg8, boolean arg9, boolean arg10) {
        this(new SlotTable(0, arg8, arg9, arg10, 1, null), arg9, arg10);
    }

    public SlotTableBuilder(SlotTable arg3, boolean arg4, boolean arg5) {
        super();
        this.table = arg3;
        this.recordSourceInformation = arg4;
        this.recordCallByInformation = arg5;
        SlotTableAddressSpace v4 = arg3.getAddressSpace();
        this.addressSpace = v4;
        int v5 = -1;
        this.parent = v5;
        this.parentStack = new IntStack();
        int v3 = arg3.getRoot();
        if(v3 == v5) {
        }
        else {
            int[] v4_1 = v4.getGroups();
            while(true) {
                int v1 = v5;
                v5 = v3;
                v3 = v1;
                if(v5 < 0) {
                    break;
                }

                v3 = v4_1[v5 + 1];
            }

            v5 = v3;
        }

        this.previousSibling = v5;
        this.previousSiblingStack = new IntStack();
        this.slots = this.addressSpace.getSlots();
    }

    public static final void access$startNewGroup(SlotTableBuilder arg0, int arg1, int arg2, Object arg3, Object arg4, Object arg5) {
        arg0.startNewGroup(arg1, arg2, arg3, arg4, arg5);
    }

    public final void addFlags(int arg7) {
        int[] v0 = this.addressSpace.getGroups();
        int v1 = this.parent;
        arg7 |= v0[v1 + 4];
        v0[v1 + 4] = arg7;
        arg7 = GroupFlagsKt.propagatingFlagsOf(arg7);
        if(arg7 != 0) {
            SlotTableAddressSpace v1_1 = this.addressSpace;
            int v6 = this.parent;
            int[] v1_2 = v1_1.getGroups();
            int v2 = v1_2[v6 + 2];
            while(true) {
                if(v2 > 0) {
                    int v3 = v2 + 4;
                    int v4 = v0[v3];
                    if((arg7 & v4) == arg7) {
                        return;
                    }
                    else {
                        v0[v3] = v4 | arg7;
                        v2 = v1_2[v2 + 2];
                        continue;
                    }
                }
                else {
                    break;
                }

                return;
            }

            arg7 = v2 != 0 ? 1 : 0;
            if(arg7 != 0) {
                return;
            }

            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + v6);
        }
    }

    public final void append(Object arg4) {
        int v0 = this.slotCurrent;
        if(v0 < this.slotEnd) {
            Object[] v1 = this.slots;
            this.slotCurrent = v0 + 1;
            v1[v0] = arg4;
            return;
        }

        this.slowAppend(arg4);
    }

    public final SlotTable build() {
        this.buildEnd();
        this.close();
        return this.table;
    }

    private final void buildEnd() {
        int v0 = this.parent;
        if(v0 != -1) {
            this.saveSlotRange(v0);
        }

        this.returnReservedSlotRegion();
    }

    public final void buildStart() {
        this.reserveSlotSlotRegion();
    }

    public final void close() {
        this.isClosed = true;
    }

    public final void collectCallByInformation() {
        this.recordCallByInformation = true;
        this.table.setRecordCallByInformation(true);
    }

    public final void collectSourceInformation() {
        this.recordSourceInformation = true;
        this.table.setRecordSourceInformation(true);
    }

    public final int endGroup() {
        int v0 = this.parent;
        int[] v1 = this.addressSpace.getGroups();
        int v3 = v0 + 4;
        v1[v3] = this.nodeCount | v1[v3] & 0xFF800000;
        this.saveSlotRange(v0);
        v0 = this.parentStack.pop();
        this.parent = v0;
        int v2 = this.previousSiblingStack.pop();
        int v4 = 1;
        int v5 = -1;
        if(v2 != v5) {
            v0 = v1[v2 + 1];
        }
        else if(v0 == v5) {
            v0 = this.table.getRoot();
        }
        else {
            v0 = v1[v0 + 3];
        }

        this.previousSibling = v0;
        this.restoreFromSlotRange(this.parent);
        v0 = v1[v3];
        v5 = 0x7FFFFF;
        if((v0 & 0x800000) == 0x800000) {
        }
        else {
            v4 = v0 & v5;
        }

        this.nodeCount = (v1[this.parent + 4] & v5) + v4;
        return v4;
    }

    public final int flagsOf(int arg1) {
        return this.addressSpace.getGroups()[arg1 + 4];
    }

    public final LinkAnchor getParentAnchor() {
        return this.addressSpace.anchorOfAddress(this.getParentGroup());
    }

    public final int getParentGroup() {
        return this.parent;
    }

    public final long getParentHandle() {
        int v0 = this.previousSiblingStack.tos == 0 ? -1 : this.previousSiblingStack.peek();
        return (((long)v0)) << 0x20 | (((long)UInt.constructor-impl(this.parent))) & 0xFFFFFFFFL;
    }

    public final boolean getRecordCallByInformation() {
        return this.recordCallByInformation;
    }

    public final boolean getRecordSourceInformation() {
        return this.recordSourceInformation;
    }

    public final int getSlotIndex() {
        return this.slotCurrent - this.slotStart;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final Object groupAux(int arg5) {
        int[] v0 = this.addressSpace.getGroups();
        int v1 = v0[arg5 + 4];
        if((v1 & 0x2000000) == 0x2000000) {
            return this.slots[(v0[arg5 + 5] >> 4) + Integer.bitCount(0x1800000 & v1)];
        }

        return Composer.Companion.getEmpty();
    }

    public final int groupKey(int arg1) {
        return this.addressSpace.getGroups()[arg1];
    }

    public final Object groupObjectKey(int arg5) {
        int[] v0 = this.addressSpace.getGroups();
        int v1 = v0[arg5 + 4];
        if((v1 & 0x1000000) == 0x1000000) {
            return this.slots[(v0[arg5 + 5] >> 4) + Integer.bitCount(0x800000 & v1)];
        }

        return null;
    }

    public final void insertAux(Object arg5) {
        int v0 = this.getParentGroup();
        int[] v1 = this.addressSpace.getGroups();
        v0 += 4;
        int v2 = v1[v0] | 0x2000000;
        v1[v0] = v2;
        this.append(arg5);
        v0 = this.slotStart + Integer.bitCount(0x1800000 & v2);
        int v1_1 = v0 + 1;
        if(v1_1 != this.slotCurrent) {
            Object[] v2_1 = this.addressSpace.getSlots();
            ArraysKt.copyInto(v2_1, v2_1, v1_1, v0, this.slotCurrent - 1);
            v2_1[v0] = arg5;
        }
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public final boolean isEmpty() {
        if(this.parent == -1) {
            return 1;
        }

        return 0;
    }

    public final boolean isNode() {
        int v0 = this.parent;
        if(v0 != -1 && (this.addressSpace.getGroups()[v0 + 4] & 0x800000) == 0x800000) {
            return 1;
        }

        return 0;
    }

    public final long lastRoot() {
        int v0 = this.table.getRoot();
        int v1 = -1;
        if(v0 != v1) {
            SlotTableAddressSpace v2 = this.addressSpace;
            int v8 = this.table.getRoot();
            int[] v2_1 = v2.getGroups();
            v8 = v2_1[v8 + 1];
            while(v8 >= 0) {
                int v7 = v0;
                v0 = v8;
                v8 = v2_1[v8 + 1];
                v1 = v7;
            }
        }

        return (((long)v1)) << 0x20 | (((long)UInt.constructor-impl(v0))) & 0xFFFFFFFFL;
    }

    public final void moveFrom(SlotTableEditor arg7, long arg8) {
        Intrinsics.areEqual(arg7.getAddressSpace$runtime(), this.addressSpace);
        long v0 = arg7.handle();
        arg7.seek(arg8);
        int v2 = 0;
        arg7.removeGroup(false);
        arg7.seek(v0);
        int v7 = GroupHandleKt.getGroup(arg8);
        int[] v8 = this.addressSpace.getGroups();
        int v9 = this.parent;
        int v0_1 = this.previousSibling;
        int v3 = -1;
        if(v0_1 != v3) {
            v8[v0_1 + 1] = v7;
        }
        else if(v9 == v3) {
            this.table.setRoot(v7);
        }
        else {
            v8[v9 + 3] = v7;
        }

        v8[v7 + 2] = v9;
        v8[v7 + 1] = v3;
        this.previousSibling = v7;
        v0_1 = this.nodeCount;
        v7 = v8[v7 + 4];
        v3 = (v7 & 0x800000) == 0x800000 ? 1 : 0x7FFFFF & v7;
        this.nodeCount = v0_1 + v3;
        v7 = GroupFlagsKt.propagatingFlagsOf(v7);
        if(v7 != 0) {
            int[] v6 = this.addressSpace.getGroups();
            v0_1 = v9;
            while(true) {
                if(v0_1 > 0) {
                    v3 = v0_1 + 4;
                    int v4 = v8[v3];
                    if((v4 & v7) != v7) {
                        v8[v3] = v4 | v7;
                        v0_1 = v6[v0_1 + 2];
                        continue;
                    }
                }
                else {
                    break;
                }

                return;
            }

            if(v0_1 != 0) {
                v2 = 1;
            }

            if(v2 != 0) {
                return;
            }

            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + v9);
        }
    }

    public final int parent(int arg1) {
        return this.addressSpace.getGroups()[arg1 + 2];
    }

    public final void recordGroupSourceInformation(String arg3) {
        if(this.recordSourceInformation) {
            this.addressSpace.recordSourceInformation(this.parent, arg3, -1);
        }
    }

    public final void recordGrouplessCallSourceInformationEnd() {
        if(this.recordSourceInformation) {
            this.addressSpace.recordSourceInformation(this.parent, null, -1).endGrouplessCall(this.slotCurrent - this.slotStart);
        }
    }

    public final void recordGrouplessCallSourceInformationStart(int arg5, String arg6) {
        if(this.recordCallByInformation) {
            this.addressSpace.recordCalledBy(arg5, this.groupKey(this.parent));
        }

        if(this.recordSourceInformation) {
            this.addressSpace.recordSourceInformation(this.parent, null, -1).startGrouplessCall(arg5, arg6, this.slotCurrent - this.slotStart);
        }
    }

    private final void reserveSlotSlotRegion() {
        long v0 = this.addressSpace.reserveSlots();
        int v2 = ((int)v0);
        this.slotReserveStart = v2;
        this.slotReserveUsedUpTo = v2;
        this.slotReserveEnd = ((int)(v0 >>> 0x20));
    }

    private final void restoreFromSlotRange(int arg4) {
        arg4 = this.addressSpace.getGroups()[arg4 + 5];
        if(arg4 != -1) {
            SlotTableAddressSpace v0 = this.addressSpace;
            int v2 = (arg4 & 15) + 1;
            arg4 >>= 4;
            if(v2 > 15) {
                v2 = v0.getLargeSizes().get(arg4);
            }

            this.slotStart = arg4;
            arg4 += v2;
            this.slotEnd = arg4;
            this.slotCurrent = arg4;
            this.inReservedRange = false;
            return;
        }

        arg4 = this.slotReserveUsedUpTo;
        this.slotStart = arg4;
        this.slotCurrent = arg4;
        this.slotEnd = this.slotReserveEnd;
        this.inReservedRange = true;
    }

    private final void returnReservedSlotRegion() {
        int v0 = this.slotReserveStart;
        int v1 = this.slotReserveEnd;
        if(v0 != v1) {
            this.addressSpace.restoreSlots(this.slotReserveUsedUpTo, v1);
            this.slotReserveStart = 0;
            this.slotReserveUsedUpTo = 0;
            this.slotReserveEnd = 0;
        }
    }

    private final int saveSlotRange(int arg7) {
        int v0;
        if(arg7 < 0) {
            return 0;
        }

        int[] v1 = this.addressSpace.getGroups();
        int v2 = this.slotCurrent;
        int v3 = this.slotStart;
        if(v2 > v3) {
            if(this.inReservedRange) {
                v0 = v2 - v3;
                int v4 = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(v3, v0);
                if(v0 > 15) {
                    this.addressSpace.recordLargeBlock(v3, v0);
                }

                this.slotReserveUsedUpTo = v2;
                v1[arg7 + 5] = v4;
                return v0;
            }

            v2 -= v3;
            v0 = this.slotEnd - v3;
            if(v0 != v2) {
                this.addressSpace.resizeSlotRangeAtGroup(arg7, v0, v2);
            }

            return v2;
        }

        v1[arg7 + 5] = -1;
        return 0;
    }

    public final void setRecordCallByInformation(boolean arg1) {
        this.recordCallByInformation = arg1;
    }

    public final void setRecordSourceInformation(boolean arg1) {
        this.recordSourceInformation = arg1;
    }

    private final void slowAppend(Object arg4) {
        int v0 = this.parent;
        int v1 = this.saveSlotRange(v0);
        this.returnReservedSlotRegion();
        this.addressSpace.writeSlot(v0, v1, arg4);
        this.slots = this.addressSpace.getSlots();
        this.reserveSlotSlotRegion();
        this.restoreFromSlotRange(v0);
    }

    public final void startDataGroup(int arg8, Object arg9, Object arg10) {
        int v0 = arg9 == Composer.Companion.getEmpty() ? 0x2000000 : 0x3000000;
        this.startNewGroup(arg8, v0, arg9, arg10, null);
    }

    public final void startGroup(int arg8, Object arg9) {
        int v0 = arg9 == Composer.Companion.getEmpty() ? 0 : 0x1000000;
        this.startNewGroup(arg8, v0, arg9, null, null);
    }

    public static void startGroup$default(SlotTableBuilder arg6, int arg7, Object arg8, int arg9, Object arg10) {
        if((arg9 & 2) != 0) {
            arg8 = Composer.Companion.getEmpty();
        }

        Object v3 = arg8;
        int v8 = v3 == Composer.Companion.getEmpty() ? 0 : 0x1000000;
        arg6.startNewGroup(arg7, v8, v3, null, null);
    }

    private final void startNewGroup(int arg7, int arg8, Object arg9, Object arg10, Object arg11) {
        int v0 = this.parent;
        SlotTableAddressSpace v1 = this.addressSpace;
        int v2 = SlotTableAddresSpaceKt.groupAllocate(v1.getGroups(), arg7, v0, arg8);
        if(v2 < 0) {
            v1.growGroups();
            v2 = SlotTableAddresSpaceKt.groupAllocate(v1.getGroups(), arg7, v0, arg8);
        }

        int[] v7 = this.addressSpace.getGroups();
        int v1_1 = this.previousSibling;
        int v3 = -1;
        if(v1_1 != v3) {
            v7[v1_1 + 1] = v2;
        }
        else if(v0 == v3) {
            this.table.setRoot(v2);
        }
        else {
            v7[v0 + 3] = v2;
        }

        this.parentStack.push(v0);
        this.previousSiblingStack.push(v1_1);
        this.parent = v2;
        this.previousSibling = v3;
        if(v0 != v3) {
            v3 = v0 + 4;
            v7[v3] = this.nodeCount | v7[v3] & 0xFF800000;
        }

        this.nodeCount = 0;
        this.saveSlotRange(v0);
        v1_1 = this.slotReserveUsedUpTo;
        this.slotStart = v1_1;
        this.slotCurrent = v1_1;
        this.slotEnd = this.slotReserveEnd;
        this.inReservedRange = true;
        if((arg8 & 0x800000) == 0x800000) {
            this.append(arg11);
        }

        if((arg8 & 0x1000000) == 0x1000000) {
            this.append(arg9);
        }

        if((arg8 & 0x2000000) == 0x2000000) {
            this.append(arg10);
        }

        arg8 = this.slotCurrent;
        int v9 = this.slotStart;
        if(arg8 > v9) {
            v7[v2 + 5] = SlotTableAddresSpaceKt.slotRangeFromAddressAndSize(v9, arg8 - v9);
        }

        if((this.recordSourceInformation) && v0 >= 0) {
            this.addressSpace.recordSourceInformation(v0, null, v2).reportGroup(this.addressSpace.anchorOfAddress(v2));
        }
    }

    public final void startNodeGroup(int arg8, Object arg9, Object arg10) {
        int v0 = arg9 == Composer.Companion.getEmpty() ? 0x800000 : 0x1800000;
        this.startNewGroup(arg8, v0, arg9, null, arg10);
    }
}

