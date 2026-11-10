package androidx.compose.runtime.composer.linkbuffer;

import androidx.collection.IntSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.LinkComposerKt;
import androidx.compose.runtime.RememberObserverHolder;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0001zB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001B\u001A\u00020\t2\n\u0010%\u001A\u00060\tj\u0002`&J\u0014\u0010\u001D\u001A\u0004\u0018\u00010\u00012\n\u0010%\u001A\u00060\tj\u0002`&J\u0014\u0010 \u001A\u0004\u0018\u00010\u00012\n\u0010%\u001A\u00060\tj\u0002`&J\u001E\u0010\'\u001A\u00020(2\f\b\u0002\u0010%\u001A\u00060\tj\u0002`&2\b\u0010)\u001A\u0004\u0018\u00010\u0001J\u0012\u0010*\u001A\u00020\t2\n\u0010%\u001A\u00060\tj\u0002`&J\u0012\u0010\u0014\u001A\u00020\u00152\n\u0010%\u001A\u00060\tj\u0002`&J\u0012\u0010+\u001A\u00020\t2\n\u0010,\u001A\u00060\tj\u0002`&J\u0012\u0010-\u001A\u00020\t2\n\u0010%\u001A\u00060\tj\u0002`&J\u0012\u0010.\u001A\u00020\t2\n\u0010%\u001A\u00060\tj\u0002`&J\n\u0010/\u001A\u000600j\u0002`1J\u0016\u0010\u0012\u001A\u00060\tj\u0002`&2\n\u00102\u001A\u00060\tj\u0002`&J\u0006\u00103\u001A\u00020(J\u0006\u00104\u001A\u00020(J\u0006\u00105\u001A\u00020(J\u0010\u00106\u001A\u00020(2\b\b\u0002\u00107\u001A\u00020\u0015J\u001A\u00108\u001A\u00020(2\u0006\u00109\u001A\u00020\u00032\n\u0010/\u001A\u000600j\u0002`1J\u0014\u0010:\u001A\u00020(2\n\u0010%\u001A\u00060\tj\u0002`&H\u0002J\u000E\u0010;\u001A\u00020(2\u0006\u0010<\u001A\u00020\tJ\u0012\u0010;\u001A\u00020(2\n\u0010/\u001A\u000600j\u0002`1J(\u0010=\u001A\u00020(2\u0006\u0010>\u001A\u00020\u00032\n\u0010?\u001A\u000600j\u0002`12\f\b\u0002\u0010@\u001A\u000600j\u0002`1J,\u0010=\u001A\u000600j\u0002`12\u0006\u0010A\u001A\u00020\u00002\n\u0010?\u001A\u000600j\u0002`12\f\b\u0002\u0010@\u001A\u000600j\u0002`1J\u0006\u0010B\u001A\u00020\tJ\u0006\u0010C\u001A\u00020(J\u000E\u0010D\u001A\u00020(2\u0006\u0010E\u001A\u00020FJ\u0012\u0010D\u001A\u00020(2\n\u0010/\u001A\u000600j\u0002`1J\u0010\u0010G\u001A\u00020(2\b\u0010 \u001A\u0004\u0018\u00010\u0001J\u0010\u0010H\u001A\u00020(2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001J\u001E\u0010I\u001A\u0004\u0018\u00010\u00012\n\u0010J\u001A\u00060\tj\u0002`K2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001J\u001A\u0010L\u001A\u0004\u0018\u00010\u00012\u0006\u0010M\u001A\u00020\t2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001J\u0010\u0010N\u001A\u00020(2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001J\u000E\u0010O\u001A\u00020(2\u0006\u0010P\u001A\u00020\tJ\u0012\u0010Q\u001A\u00020\u00152\n\u0010R\u001A\u000600j\u0002`1J\"\u0010S\u001A\u00020\u00032\u0017\u0010T\u001A\u0013\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020(0U¢\u0006\u0002\bWH\u0086\bJ\u0015\u0010X\u001A\u00020(2\u0006\u0010Y\u001A\u00020\tH\u0000¢\u0006\u0002\bZJ\u001A\u0010[\u001A\u00020(2\n\u0010\\\u001A\u00060\tj\u0002`&2\u0006\u0010]\u001A\u00020^J5\u0010_\u001A\u00020(2\n\u0010\\\u001A\u00060\tj\u0002`&2\n\u0010`\u001A\u00060\tj\u0002`&2\u0006\u0010a\u001A\u00020\t2\u0006\u0010]\u001A\u00020^H\u0000¢\u0006\u0002\bbJ\u0012\u0010c\u001A\u00020(2\n\u0010d\u001A\u00060\tj\u0002`eJ\u001A\u0010f\u001A\u00020(2\u0006\u0010g\u001A\u00020h2\n\u0010d\u001A\u00060\tj\u0002`eJ\u0006\u0010i\u001A\u00020(J4\u0010j\u001A\u00020(2\n\u0010%\u001A\u00060\tj\u0002`&2\u0006\u0010k\u001A\u00020\t2\u0006\u0010l\u001A\u00020\t2\u0006\u0010m\u001A\u00020\t2\u0006\u0010n\u001A\u00020\u0015H\u0002Jd\u0010o\u001A\u00020(*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010p2\u0006\u0010q\u001A\u00020\t2\u0006\u0010r\u001A\u00020\t28\u0010T\u001A4\u0012\u0013\u0012\u00110\t¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(M\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020(0sH\u0082\b¢\u0006\u0002\u0010vJ`\u0010o\u001A\u00020(*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010p2\n\u0010w\u001A\u00060\tj\u0002`x28\u0010T\u001A4\u0012\u0013\u0012\u00110\t¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(M\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020(0sH\u0082\b¢\u0006\u0002\u0010yR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u000F\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0016R\u0011\u0010\u0017\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0016R\u001E\u0010\u0019\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u0015@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0016R\u0011\u0010\u001A\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0016R\u0011\u0010\u001B\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u0011R\u0013\u0010\u001D\u001A\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0013\u0010 \u001A\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001A\u0004\b!\u0010\u001FR\u0011\u0010\"\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b\"\u0010\u0016R\u001E\u0010#\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\t@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u0011¨\u0006{"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor;", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "parent", "", "current", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "getAddressSpace$runtime", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "currentGroup", "getCurrentGroup", "()I", "parentGroup", "getParentGroup", "isNode", "", "()Z", "isGroupEnd", "value", "isClosed", "isEmpty", "groupKey", "getGroupKey", "objectKey", "getObjectKey", "()Ljava/lang/Object;", "node", "getNode", "isParentGroupANode", "previousSibling", "getPreviousSibling", "group", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "updateNode", "", "newValue", "flagsOf", "nodeCountOf", "groups", "parentOf", "firstChildOf", "handle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "groupAddress", "close", "startGroup", "endGroup", "removeGroup", "freeGroup", "insertGroupFrom", "insertTable", "insertGroup", "moveGroup", "offset", "moveFrom", "sourceTable", "sourceHandle", "destination", "sourceEditor", "skipGroup", "skipToGroupEnd", "seek", "anchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "updateParentNode", "updateAux", "setAbsolute", "slotAddress", "Landroidx/compose/runtime/composer/linkbuffer/SlotAddress;", "setRelative", "index", "appendSlot", "trimSlots", "slots", "containsHandle", "groupHandle", "buildInsertTable", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "Lkotlin/ExtensionFunctionType;", "bashGroup", "newKey", "bashGroup$runtime", "visitSlotsInRememberOrder", "inGroup", "callback", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor$VisitSlotsInRememberOrderCallback;", "visitTailSlotsInRememberOrder", "firstTailGroupToVisit", "tailSlots", "visitTailSlotsInRememberOrder$runtime", "removeAllInstancesOfFlags", "flags", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "addFlagsToAllGroupsIn", "groupSet", "Landroidx/collection/IntSet;", "reset", "propagateChanges", "nodeCountDelta", "flagsToRemove", "flagsToAdd", "removingGroup", "forEachSlotInRangeIndexed", "", "start", "end", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "([Ljava/lang/Object;IILkotlin/jvm/functions/Function2;)V", "slotRange", "Landroidx/compose/runtime/composer/linkbuffer/SlotRange;", "([Ljava/lang/Object;ILkotlin/jvm/functions/Function2;)V", "VisitSlotsInRememberOrderCallback", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SlotTableEditor {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J&\u0010\u0002\u001A\u00020\u00032\n\u0010\u0004\u001A\u00060\u0005j\u0002`\u00062\u0006\u0010\u0007\u001A\u00020\u00052\b\u0010\b\u001A\u0004\u0018\u00010\u0001H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/SlotTableEditor$VisitSlotsInRememberOrderCallback;", "", "visit", "", "group", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "slotIndex", "slot", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface VisitSlotsInRememberOrderCallback {
        boolean visit(int arg1, int arg2, Object arg3);
    }

    public static final int $stable = 8;
    private final SlotTableAddressSpace addressSpace;
    private int current;
    private boolean isClosed;
    private int parent;
    private int previousSibling;
    private final SlotTable table;

    static {
    }

    public SlotTableEditor(SlotTable arg3) {
        super();
        this.table = arg3;
        this.parent = -1;
        this.current = arg3.getRoot();
        this.addressSpace = arg3.getAddressSpace();
        this.previousSibling = -1;
    }

    public final void addFlagsToAllGroupsIn(IntSet arg18, int arg19) {
        int[] v1 = arg18.elements;
        long[] v0 = arg18.metadata;
        int v2 = v0.length - 2;
        if(v2 >= 0) {
            int v4;
            for(v4 = 0; true; ++v4) {
                long v5 = v0[v4];
                if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                    int v8 = 8;
                    int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                    int v9;
                    for(v9 = 0; v9 < v7; ++v9) {
                        if((0xFF & v5) < 0x80) {
                            this.propagateChanges(v1[(v4 << 3) + v9], 0, 0, arg19, false);
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

    public final void appendSlot(Object arg6) {
        int[] v0 = this.addressSpace.getGroups();
        int v1 = this.parent;
        int v0_1 = v0[v1 + 5];
        SlotTableAddressSpace v2 = this.addressSpace;
        if(v0_1 == -1) {
            v2.writeSlot(v1, 0, arg6);
            return;
        }

        int v3 = (v0_1 & 15) + 1;
        v0_1 >>= 4;
        if(v3 > 15) {
            v3 = v2.getLargeSizes().get(v0_1);
        }

        this.addressSpace.writeSlot(v1, v3, arg6);
    }

    public final void bashGroup$runtime(int arg2) {
        this.addressSpace.getGroups()[this.getCurrentGroup()] = arg2;
    }

    public final SlotTable buildInsertTable(Function1 arg3) {
        SlotTableBuilder v0 = new SlotTableBuilder(this.getAddressSpace$runtime(), false, false);
        v0.buildStart();
        arg3.invoke(v0);
        return v0.build();
    }

    public final void close() {
        if(!this.isClosed) {
            this.isClosed = true;
            this.table.closeEditor(this);
        }
    }

    public final boolean containsHandle(long arg10) {
        int v5;
        int v0 = GroupHandleKt.getGroup(arg10);
        int v1 = -1;
        if(v0 != v1) {
        }
        else {
            v0 = GroupHandleKt.getContext(arg10);
        }

        if(v0 == v1) {
            return 0;
        }

        int v11 = this.table.getRoot();
        int[] v2 = this.addressSpace.getGroups();
        int[] v3 = this.addressSpace.getGroups();
        int v4;
        for(v4 = v0; true; v4 = v3[v6]) {
            v5 = 1;
            if(v4 <= 0) {
                break;
            }

            if(v4 == v11) {
                return 1;
            }

            if(v4 <= 0) {
                return 0;
            }

            int v6 = v4 + 2;
            if(v2[v6] == v1) {
                int[] v7 = this.addressSpace.getGroups();
                int v8 = v11;
                while(v8 >= 0) {
                    if(v8 == v4) {
                        return 1;
                    }
                    else {
                        v8 = v7[v8 + 1];
                        continue;
                    }

                    break;
                }
            }
        }

        if(v4 != 0) {
        }
        else {
            v5 = 0;
        }

        if(v5 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + v0);
        }

        return 0;
    }

    public final void endGroup() {
        int v0 = this.parent;
        int[] v1 = this.addressSpace.getGroups();
        if(v0 + 6 > v1.length) {
            return;
        }

        int v2 = v1[v0 + 1];
        this.parent = v1[v0 + 2];
        this.previousSibling = v0;
        this.current = v2;
    }

    public final int firstChildOf(int arg1) {
        return this.addressSpace.getGroups()[arg1 + 3];
    }

    public final int flagsOf(int arg1) {
        return this.addressSpace.getGroups()[arg1 + 4];
    }

    private final void forEachSlotInRangeIndexed(Object[] arg3, int arg4, int arg5, Function2 arg6) {
        int v2;
        for(v2 = arg4; v2 < arg5; ++v2) {
            arg6.invoke(Integer.valueOf(v2 - arg4), arg3[v2]);
        }
    }

    private final void forEachSlotInRangeIndexed(Object[] arg4, int arg5, Function2 arg6) {
        if(arg5 != -1) {
            SlotTableAddressSpace v3 = this.addressSpace;
            int v0 = (arg5 & 15) + 1;
            arg5 >>= 4;
            if(v0 > 15) {
                v0 = v3.getLargeSizes().get(arg5);
            }

            v0 += arg5;
            int v3_1;
            for(v3_1 = arg5; v3_1 < v0; ++v3_1) {
                arg6.invoke(Integer.valueOf(v3_1 - arg5), arg4[v3_1]);
            }
        }
    }

    public final SlotTableAddressSpace getAddressSpace$runtime() {
        return this.addressSpace;
    }

    public final int getCurrentGroup() {
        return this.current;
    }

    public final int getGroupKey() {
        return this.addressSpace.getGroups()[this.current];
    }

    public final Object getNode() {
        return this.node(this.current);
    }

    public final Object getObjectKey() {
        return this.objectKey(this.current);
    }

    public final int getParentGroup() {
        return this.parent;
    }

    public final int getPreviousSibling() {
        return this.previousSibling;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final int groupKey(int arg1) {
        return this.addressSpace.getGroups()[arg1];
    }

    public final long handle() {
        return (((long)this.previousSibling)) << 0x20 | (((long)UInt.constructor-impl(this.current))) & 0xFFFFFFFFL;
    }

    private final void insertGroup(int arg11) {
        int v0 = this.previousSibling;
        int v1 = this.parent;
        int[] v2 = this.addressSpace.getGroups();
        int v3 = 1;
        int v4 = -1;
        if(v0 != v4) {
            v2[v0 + 1] = arg11;
        }
        else if(v1 == v4) {
            this.table.setRoot(arg11);
        }
        else {
            v2[v1 + 3] = arg11;
        }

        v2[arg11 + 2] = v1;
        v2[arg11 + 1] = this.current;
        v0 = v2[arg11 + 4];
        if((v0 & 0x800000) == 0x800000) {
        }
        else {
            v3 = v0 & 0x7FFFFF;
        }

        this.current = arg11;
        this.propagateChanges(arg11, v3, 0, GroupFlagsKt.propagatingFlagsOf(v0), false);
    }

    public final void insertGroupFrom(SlotTable arg3, long arg4) {
        if(Intrinsics.areEqual(arg3.getAddressSpace(), this.table.getAddressSpace())) {
            SlotTableEditor v3 = arg3.openEditor();
            try {
                v3.seek(arg4);
                v3.removeGroup(false);
            }
            catch(Throwable v2) {
                v3.close();
                throw v2;
            }

            v3.close();
            this.insertGroup(GroupHandleKt.getGroup(arg4));
            return;
        }

        throw new IllegalArgumentException("Cannot insert a group from an unrelated table".toString());
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public final boolean isEmpty() {
        return this.table.isEmpty();
    }

    public final boolean isGroupEnd() {
        if(this.current == -1) {
            return 1;
        }

        return 0;
    }

    public final boolean isNode() {
        if((this.addressSpace.getGroups()[this.current + 4] & 0x800000) == 0x800000) {
            return 1;
        }

        return 0;
    }

    public final boolean isNode(int arg1) {
        if((this.flagsOf(arg1) & 0x800000) == 0x800000) {
            return 1;
        }

        return 0;
    }

    public final boolean isParentGroupANode() {
        if((this.addressSpace.getGroups()[this.parent + 4] & 0x800000) == 0x800000) {
            return 1;
        }

        return 0;
    }

    public final long moveFrom(SlotTableEditor arg9, long arg10, long arg12) {
        long v2;
        int v10;
        arg9.seek(arg10);
        if(!Intrinsics.areEqual(arg9.addressSpace, this.addressSpace)) {
            v10 = this.addressSpace.copyTreeFrom(arg9.addressSpace, GroupHandleKt.getGroup(arg10));
            arg9.removeGroup(true);
        }
        else {
            v10 = GroupHandleKt.getGroup(arg10);
            arg9.removeGroup(false);
        }

        long v0 = -1;
        if(arg12 != v0) {
            v2 = this.handle();
            this.seek(arg12);
        }
        else {
            v2 = v0;
        }

        int v9 = this.previousSibling;
        this.insertGroup(v10);
        this.previousSibling = v9;
        this.current = v10;
        long v11 = (((long)v9)) << 0x20 | (((long)UInt.constructor-impl(v10))) & 0xFFFFFFFFL;
        if(v2 != v0) {
            this.seek(v2);
        }

        if(this.table.getRecordSourceInformation()) {
            this.addressSpace.recordMovedSourceInformation(v10, v9);
        }

        return v11;
    }

    public final void moveFrom(SlotTable arg2, long arg3, long arg5) {
        SlotTableEditor v2 = arg2.openEditor();
        try {
            this.moveFrom(v2, arg3, arg5);
        }
        catch(Throwable v0) {
            v2.close();
            throw v0;
        }

        v2.close();
    }

    public static long moveFrom$default(SlotTableEditor arg6, SlotTableEditor arg7, long arg8, long arg10, int arg12, Object arg13) {
        if((arg12 & 4) != 0) {
            arg10 = -1;
        }

        return arg6.moveFrom(arg7, arg8, arg10);
    }

    public static void moveFrom$default(SlotTableEditor arg6, SlotTable arg7, long arg8, long arg10, int arg12, Object arg13) {
        if((arg12 & 4) != 0) {
            arg10 = -1;
        }

        arg6.moveFrom(arg7, arg8, arg10);
    }

    public final void moveGroup(int arg9) {
        if(arg9 == 0) {
            return;
        }

        int v0 = this.current;
        int v1 = this.previousSibling;
        int[] v2 = this.addressSpace.getGroups();
        int v3 = 0;
        int v4 = v0;
        int v5 = v1;
        while(true) {
            int v6 = -1;
            if(v3 >= arg9) {
                goto label_30;
            }

            v5 = v2[v4 + 1];
            if(v5 == v6) {
                break;
            }

            ++v3;
            int v7 = v5;
            v5 = v4;
            v4 = v7;
        }

        throw new IllegalStateException("Offset(" + arg9 + ") too large".toString());
    label_30:
        arg9 = v4 + 1;
        v2[v5 + 1] = v2[arg9];
        v2[arg9] = v0;
        if(v1 == v6) {
            v2[this.parent + 3] = v4;
        }
        else {
            v2[v1 + 1] = v4;
        }

        this.current = v4;
    }

    public final void moveGroup(long arg8) {
        int v5;
        int v0 = this.current;
        int v1 = this.previousSibling;
        int v2 = GroupHandleKt.getGroup(arg8);
        int v8 = GroupHandleKt.getContext(arg8);
        int[] v9 = this.addressSpace.getGroups();
        int v3 = this.parent;
        int v4 = -1;
        if(v8 == v4 && v9[v3 + 3] != v2 || v8 != v4 && v9[v8 + 1] != v2) {
            for(v8 = v0; v8 != v4; v8 = v5) {
                v5 = v9[v8 + 1];
                if(v5 == v2) {
                    break;
                }
            }

            if(v8 != v4) {
                goto label_36;
            }

            throw new IllegalStateException("Could not find the group previous to current(" + v0 + ')'.toString());
        }

    label_36:
        v5 = v2 + 1;
        v9[v8 + 1] = v9[v5];
        v9[v5] = v0;
        if(v1 == v4) {
            v9[v3 + 3] = v2;
        }
        else {
            v9[v1 + 1] = v2;
        }

        this.current = v2;
    }

    public final Object node(int arg4) {
        int[] v0 = this.addressSpace.getGroups();
        if((v0[arg4 + 4] & 0x800000) == 0x800000) {
            return this.addressSpace.getSlots()[v0[arg4 + 5] >> 4];
        }

        return null;
    }

    public final int nodeCountOf(int arg2) {
        int v1 = this.addressSpace.getGroups()[arg2 + 4];
        if((v1 & 0x800000) == 0x800000) {
            return 1;
        }

        return v1 & 0x7FFFFF;
    }

    public final Object objectKey(int arg5) {
        int[] v0 = this.addressSpace.getGroups();
        int v1 = v0[arg5 + 4];
        if((v1 & 0x1000000) == 0x1000000) {
            return this.addressSpace.getSlots()[(v0[arg5 + 5] >> 4) + Integer.bitCount(0x800000 & v1)];
        }

        return Composer.Companion.getEmpty();
    }

    public final int parentGroup(int arg1) {
        return this.addressSpace.getGroups()[arg1 + 2];
    }

    public final int parentOf(int arg1) {
        return this.addressSpace.getGroups()[arg1 + 2];
    }

    private final void propagateChanges(int arg11, int arg12, int arg13, int arg14, boolean arg15) {
        int v6;
        int v3;
        int[] v0 = this.addressSpace.getGroups();
        int[] v1 = this.addressSpace.getGroups();
        int v2;
        for(v2 = v1[arg11 + 2]; true; v2 = v1[v2 + 2]) {
            v3 = 0;
            if(v2 <= 0) {
                break;
            }

            int v4 = v2 + 4;
            int v5 = v0[v4];
            if(0 != 0) {
                v5 = v5 & 0xFF800000 | 0x7FFFFF & v5;
                v0[v4] = v5;
            }

            if(arg13 != 0) {
                v6 = arg13 >> 1 | arg13;
                int[] v7 = this.addressSpace.getGroups();
                int v8;
                for(v8 = v7[v2 + 3]; v8 > 0; v8 = v7[v8 + 1]) {
                    if((!arg15 || v8 != arg11) && (v0[v8 + 4] & v6) != 0) {
                        goto label_43;
                    }
                }

                v6 = arg13;
            }
            else {
            label_43:
                v6 = 0;
            }

            if(v6 != 0 || 0 != 0) {
                int v7_1 = ~v6 & v5 | 0;
                if(v7_1 != v5) {
                    v0[v4] = v7_1;
                    arg13 = v6;
                }
            }

            if(0 == 0 && arg13 == 0 && 0 == 0) {
                return;
            }
        }

        if(v2 != 0) {
            v3 = 1;
        }

        if(v3 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg11);
        }
    }

    public final void removeAllInstancesOfFlags(int arg7) {
        arg7 |= GroupFlagsKt.propagatingFlagsOf(arg7);
        SlotTableAddressSpace v0 = this.addressSpace;
        int[] v1 = v0.getGroups();
        int v6 = this.table.getRoot();
        if(v6 >= 0) {
            IntStack v2 = new IntStack();
            int[] v0_1 = v0.getGroups();
            while(true) {
                int v3 = v6 + 4;
                int v4 = v1[v3];
                if((arg7 & v4) == 0) {
                    v3 = 0;
                }
                else {
                    v1[v3] = v4 & ~arg7;
                    v3 = 1;
                }

                v4 = v0_1[v6 + 1];
                if(v4 >= 0) {
                    v2.push(v4);
                }

                v6 = v0_1[v6 + 3];
                if(v3 != 0 && v6 >= 0) {
                    continue;
                }

                if(v2.tos == 0) {
                    return;
                }

                v6 = v2.pop();
            }
        }
    }

    public final void removeGroup(boolean arg9) {
        int[] v0 = this.addressSpace.getGroups();
        int v2 = this.current;
        int v1 = v0[v2 + 4];
        int v3 = (v1 & 0x800000) == 0x800000 ? 1 : 0x7FFFFF & v1;
        int v4 = GroupFlagsKt.propagatingFlagsOf(v1);
        SlotTableEditor v1_1 = this;
        v1_1.propagateChanges(v2, -v3, v4, 0, true);
        int v8 = v0[v2 + 1];
        v3 = v1_1.previousSibling;
        v4 = -1;
        if(v3 == v4) {
            v3 = v1_1.parent;
            if(v3 == v4) {
                v1_1.table.setRoot(v8);
            }
            else {
                v0[v3 + 3] = v8;
            }
        }
        else {
            v0[v3 + 1] = v8;
        }

        if(arg9) {
            v1_1.addressSpace.freeGroupTree(v2);
        }

        v1_1.current = v8;
    }

    public static void removeGroup$default(SlotTableEditor arg0, boolean arg1, int arg2, Object arg3) {
        arg0.removeGroup(true);
    }

    public final void reset() {
        this.parent = -1;
        this.previousSibling = -1;
        this.current = this.table.getRoot();
    }

    public final void seek(LinkAnchor arg5) {
        this.seek((((long)UInt.constructor-impl(arg5.getAddress()))) & 0xFFFFFFFFL);
    }

    public final void seek(long arg7) {
        this.containsHandle(arg7);
        int v0 = GroupHandleKt.getContext(arg7);
        int[] v1 = this.addressSpace.getGroups();
        int v7 = GroupHandleKt.getGroup(arg7);
        int v8 = -1;
        int v2 = v7 == v8 ? v0 : v1[v7 + 2];
        if(v7 == v8) {
            v0 = v8;
        }

        this.parent = v2;
        this.current = v7;
        if(v0 == v8) {
            if(v2 == v8) {
                if(this.table.getRoot() != v7) {
                    goto label_28;
                }
            }
            else if(v1[v2 + 3] != v7) {
                goto label_28;
            }
        }
        else if(v1[v0 + 1] != v7) {
        label_28:
            v0 = v2 == v8 ? this.table.getRoot() : v1[v2 + 3];
            int[] v3 = this.addressSpace.getGroups();
            int v4 = v8;
            while(v0 >= 0) {
                if(v0 == v7) {
                    break;
                }

                v4 = v0;
                v0 = v3[v0 + 1];
            }

            v0 = v4;
        }

        if(v0 == v8 && v2 == v8) {
            this.table.getRoot();
        }

        this.previousSibling = v0;
    }

    public final Object setAbsolute(int arg2, Object arg3) {
        Object[] v1 = this.addressSpace.getSlots();
        Object v0 = v1[arg2];
        v1[arg2] = arg3;
        return v0;
    }

    public final Object setRelative(int arg3, Object arg4) {
        return this.setAbsolute((this.addressSpace.getGroups()[this.parent + 5] >> 4) + arg3, arg4);
    }

    public final int skipGroup() {
        int v0 = this.current;
        if(v0 != -1) {
            this.previousSibling = v0;
            this.current = this.addressSpace.getGroups()[v0 + 1];
            int v3 = this.addressSpace.getGroups()[v0 + 4];
            if((v3 & 0x800000) == 0x800000) {
                return 1;
            }

            return v3 & 0x7FFFFF;
        }

        throw new IllegalStateException("Skipping past the end of a group".toString());
    }

    public final void skipToGroupEnd() {
        int v0 = this.current;
        int v1 = -1;
        if(v0 != v1) {
            int v2 = this.previousSibling;
            int[] v3 = this.addressSpace.getGroups();
            while(v0 != v1) {
                v2 = v0;
                v0 = v3[v0 + 1];
            }

            this.previousSibling = v2;
            this.current = v1;
        }
    }

    public final void startGroup() {
        int v0 = this.current;
        int v1 = v0 > 0 ? 1 : 0;
        if(v1 == 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a group because current does not refer to a child of a group");
        }

        this.parent = v0;
        int[] v1_1 = this.addressSpace.getGroups();
        if(v0 + 6 > v1_1.length) {
            return;
        }

        this.current = v1_1[v0 + 3];
        this.previousSibling = -1;
    }

    public final void trimSlots(int arg8) {
        int v3;
        SlotTableAddressSpace v0 = this.addressSpace;
        int v7 = this.parent;
        int[] v1 = v0.getGroups();
        int v2 = v1[v7 + 5];
        int v4 = 0;
        if(v2 == -1) {
            v3 = 0;
        }
        else {
            v3 = (v2 & 15) + 1;
            if(v3 > 15) {
                v3 = v0.getLargeSizes().get(v2 >> 4);
            }
        }

        v3 -= arg8;
        if(v3 >= GroupFlagsKt.utilitySlotsCountForFlags(v1[v7 + 4])) {
            v4 = 1;
        }

        if(v4 == 0) {
            ComposerKt.composeImmediateRuntimeError("Attempted to trim more slots than the group has");
        }

        v0.resizeSlotRangeAtGroup(v7, v3);
    }

    public final void updateAux(Object arg4) {
        int[] v0 = this.addressSpace.getGroups();
        this.addressSpace.getSlots()[(v0[this.current + 5] >> 4) + Integer.bitCount(0x1800000 & v0[this.current + 4])] = arg4;
    }

    public final void updateNode(int arg3, Object arg4) {
        this.addressSpace.getSlots()[this.addressSpace.getGroups()[arg3 + 5] >> 4] = arg4;
    }

    public static void updateNode$default(SlotTableEditor arg0, int arg1, Object arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.getCurrentGroup();
        }

        arg0.updateNode(arg1, arg2);
    }

    public final void updateParentNode(Object arg4) {
        this.addressSpace.getSlots()[this.addressSpace.getGroups()[this.parent + 5] >> 4] = arg4;
    }

    public final void visitSlotsInRememberOrder(int arg12, VisitSlotsInRememberOrderCallback arg13) {
        if(arg12 < 0) {
        }
        else {
            int[] v0 = this.addressSpace.getGroups();
            Object[] v1 = this.addressSpace.getSlots();
            int v2 = v0[arg12 + 5];
            int v3 = -1;
            if(v2 != v3) {
                SlotTableAddressSpace v5 = this.addressSpace;
                int v6 = (v2 & 15) + 1;
                v2 >>= 4;
                if(v6 > 15) {
                    v6 = v5.getLargeSizes().get(v2);
                }

                v6 += v2;
                int v5_1;
                for(v5_1 = v2; v5_1 < v6; ++v5_1) {
                    int v7 = v5_1 - v2;
                    Object v8 = v1[v5_1];
                    if((v8 instanceof RememberObserverHolder)) {
                        int v9 = LinkComposerKt.asLinkRememberObserverHolder(v8).getAfter().getAddress();
                        while(v3 != v9) {
                            v3 = v3 < 0 ? v0[arg12 + 3] : v0[v3 + 1];
                            int v10 = v3 >= 0 ? 1 : 0;
                            if(v10 == 0) {
                                ComposerKt.composeImmediateRuntimeError("A RememberObserver cannot be forgotten correctly because its group ordering metadata is inconsistent with the rest of the SlotTable");
                            }

                            this.visitSlotsInRememberOrder(v3, arg13);
                        }
                    }

                    if(arg13.visit(arg12, v7, v8)) {
                        v1[v7 + v2] = Composer.Companion.getEmpty();
                    }
                }
            }

            for(arg12 = v3 < 0 ? v0[arg12 + 3] : v0[v3 + 1]; arg12 >= 0; arg12 = v0[arg12 + 1]) {
                this.visitSlotsInRememberOrder(arg12, arg13);
            }
        }
    }

    public final void visitTailSlotsInRememberOrder$runtime(int arg18, int arg19, int arg20, VisitSlotsInRememberOrderCallback arg21) {
        SlotTableEditor v0 = this;
        int v1 = arg18;
        int v2 = arg19;
        VisitSlotsInRememberOrderCallback v3 = arg21;
        if(v1 < 0) {
        }
        else {
            int[] v4 = v0.addressSpace.getGroups();
            Object[] v5 = v0.addressSpace.getSlots();
            int v6 = v4[v1 + 5];
            int v7 = v6 >> 4;
            SlotTableAddressSpace v8 = v0.addressSpace;
            int v9 = -1;
            if(v6 == v9) {
                v6 = 0;
            }
            else {
                v6 = (v6 & 15) + 1;
                if(v6 > 15) {
                    v6 = v8.getLargeSizes().get(v7);
                }
            }

            v6 = v6 + v7 - arg20;
            int v8_1 = v6 + arg20;
            int v12 = v6;
            int v13 = 0;
            while(v12 < v8_1) {
                int v14 = v12 - v6;
                Object v15 = v5[v12];
                if((v15 instanceof RememberObserverHolder)) {
                    int v10 = LinkComposerKt.asLinkRememberObserverHolder(v15).getAfter().getAddress();
                    while(v9 != v10) {
                        v9 = v9 < 0 ? v4[v1 + 3] : v4[v9 + 1];
                        int v16 = v9 >= 0 ? 1 : 0;
                        if(v16 == 0) {
                            ComposerKt.composeImmediateRuntimeError("A RememberObserver cannot be forgotten correctly because its group ordering metadata is inconsistent with the rest of the SlotTable");
                        }

                        v16 = v2 == v9 ? 1 : 0;
                        v13 |= v16;
                        if(v13 == 0) {
                            continue;
                        }

                        v0.visitSlotsInRememberOrder(v9, v3);
                    }
                }

                if(v3.visit(v1, v14, v15)) {
                    v5[v14 + v7] = Composer.Companion.getEmpty();
                }

                ++v12;
            }

            for(v1 = v9 < 0 ? v4[v1 + 3] : v4[v9 + 1]; v1 >= 0; v1 = v4[v1 + 1]) {
                int v5_1 = v2 == v1 ? 1 : 0;
                v13 |= v5_1;
                if(v13 != 0) {
                    v0.visitSlotsInRememberOrder(v1, v3);
                }
            }
        }
    }
}

