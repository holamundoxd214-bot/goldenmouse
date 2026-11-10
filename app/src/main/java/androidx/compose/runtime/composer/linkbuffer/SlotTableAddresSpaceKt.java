package androidx.compose.runtime.composer.linkbuffer;

import androidx.collection.IntSetKt;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.tooling.ComposeStackTraceBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0019\u0010\u0014\u001A\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u0017H\u0080\b\u001A\u0019\u0010\u0018\u001A\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u0017H\u0080\b\u001A\u0019\u0010\u0019\u001A\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u0017H\u0080\b\u001A\u0019\u0010\u001A\u001A\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u0017H\u0080\b\u001A\u0019\u0010\u001B\u001A\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u0017H\u0080\b\u001A\u0019\u0010\u001C\u001A\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u0017H\u0080\b\u001A!\u0010\u0014\u001A\u00020\u001D*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u00172\u0006\u0010\u001E\u001A\u00020\u0001H\u0080\b\u001A!\u0010\u0018\u001A\u00020\u001D*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u00172\u0006\u0010\u001E\u001A\u00020\u0001H\u0080\b\u001A!\u0010\u0019\u001A\u00020\u001D*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u00172\u0006\u0010\u001E\u001A\u00020\u0001H\u0080\b\u001A!\u0010\u001A\u001A\u00020\u001D*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u00172\u0006\u0010\u001E\u001A\u00020\u0001H\u0080\b\u001A!\u0010\u001B\u001A\u00020\u001D*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u00172\u0006\u0010\u001E\u001A\u00020\u0001H\u0080\b\u001A\u0019\u0010\u001F\u001A\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u0017H\u0080\b\u001A\u0019\u0010 \u001A\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u0017H\u0080\b\u001A!\u0010 \u001A\u00020\u0001*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u00172\u0006\u0010\u001E\u001A\u00020\u0001H\u0080\b\u001A!\u0010\u001C\u001A\u00020\u001D*\u00020\u00152\n\u0010\u0016\u001A\u00060\u0001j\u0002`\u00172\u0006\u0010\u001E\u001A\u00020\u0001H\u0080\b\u001A2\u0010!\u001A\u00020\u001D*\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"2\n\u0010$\u001A\u00060\u0001j\u0002`%2\n\u0010&\u001A\u00060\u0001j\u0002`%H\u0082\b¢\u0006\u0002\u0010\'\u001A\u0010\u0010(\u001A\u00020\u00152\u0006\u0010)\u001A\u00020\u0001H\u0002\u001A\u0016\u0010*\u001A\u00020\u001D*\u0004\u0018\u00010\u00152\u0006\u0010+\u001A\u00020\u0001H\u0002\u001A\u001D\u0010,\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"2\u0006\u0010)\u001A\u00020\u0001H\u0002¢\u0006\u0002\u0010-\u001A2\u0010.\u001A\u00060\u0001j\u0002`\u0017*\u0004\u0018\u00010\u00152\u0006\u0010/\u001A\u00020\u00012\n\u00100\u001A\u00060\u0001j\u0002`\u00172\n\u00101\u001A\u00060\u0001j\u0002`2H\u0002\u001A\f\u00103\u001A\u00020\u0001*\u00020\u0015H\u0002\u001A\u0015\u00104\u001A\u00020\u00012\n\u00105\u001A\u00060\u0001j\u0002`6H\u0080\b\u001A\u0015\u00107\u001A\u00020\u00012\n\u00105\u001A\u00060\u0001j\u0002`6H\u0080\b\u001A\u0011\u00108\u001A\u0002092\u0006\u0010:\u001A\u00020\u0001H\u0080\b\u001A\u001C\u0010;\u001A\u00020\u00012\n\u0010\u0016\u001A\u00060\u0001j\u0002`%2\u0006\u0010:\u001A\u00020\u0001H\u0000\u001A0\u0010<\u001A\b\u0012\u0004\u0012\u00020>0=*\u00020?2\n\u0010@\u001A\u00060\u0001j\u0002`\u00172\b\u0010A\u001A\u0004\u0018\u00010#2\u0006\u0010B\u001A\u00020CH\u0000\u001A*\u0010D\u001A\u000209*\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"2\u0006\u0010$\u001A\u00020\u00012\u0006\u0010:\u001A\u00020\u0001H\u0082\b¢\u0006\u0002\u0010E\u001A\u0012\u0010F\u001A\u0002092\b\u0010\u001E\u001A\u0004\u0018\u00010#H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000F\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010G\u001A\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000*\f\b\u0000\u0010\u0011\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010\u0012\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010\u0013\"\u00020\u00012\u00020\u0001¨\u0006H"}, d2={"NULL_ADDRESS", "", "LAZY_ADDRESS", "SLOT_TABLE_GROUP_SIZE", "SLOT_TABLE_GROUP_KEY_OFFSET", "SLOT_TABLE_GROUP_NEXT_OFFSET", "SLOT_TABLE_GROUP_PARENT_OFFSET", "SLOT_TABLE_GROUP_CHILD_OFFSET", "SLOT_TABLE_GROUP_FLAGS_OFFSET", "SLOT_TABLE_GROUP_SLOTS_OFFSET", "SLOT_TABLE_SLOT_SHIFT", "SLOT_TABLE_SLOT_SMALL_SIZE_MASK", "SLOT_TABLE_SLOT_LARGE_SENTINEL", "SLOT_TABLE_SLOT_MAX_SMALL_SIZE", "SLOT_TABLE_SLOT_MOVE_BUFFER_SIZE", "SLOT_TABLE_INITIAL_GROUPS_SIZE", "SLOT_TABLE_INITIAL_SLOTS_SIZE", "GroupAddress", "SlotAddress", "SlotRange", "groupKey", "", "address", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "groupNext", "groupParent", "groupChild", "groupFlags", "groupSlotRange", "", "value", "groupNodeCount", "groupChildNodeCount", "clearRange", "", "", "start", "Landroidx/compose/runtime/composer/linkbuffer/SlotAddress;", "end", "([Ljava/lang/Object;II)V", "newGroupsArray", "capacity", "initGroups", "offset", "newSlotsArray", "(I)[Ljava/lang/Object;", "groupAllocate", "key", "parent", "flags", "Landroidx/compose/runtime/composer/linkbuffer/GroupFlags;", "validateFreeList", "slotAddressOf", "slotRange", "Landroidx/compose/runtime/composer/linkbuffer/SlotRange;", "slotSmallSizeOf", "isLargeSlotRangeSize", "", "size", "slotRangeFromAddressAndSize", "buildTrace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "group", "child", "traceBuilder", "Landroidx/compose/runtime/tooling/ComposeStackTraceBuilder;", "allUnallocated", "([Ljava/lang/Object;II)Z", "isUnallocated", "Unallocated", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SlotTableAddresSpaceKt {
    public static final int LAZY_ADDRESS = 0;
    public static final int NULL_ADDRESS = -1;
    private static final int SLOT_TABLE_GROUP_CHILD_OFFSET = 3;
    private static final int SLOT_TABLE_GROUP_FLAGS_OFFSET = 4;
    private static final int SLOT_TABLE_GROUP_KEY_OFFSET = 0;
    private static final int SLOT_TABLE_GROUP_NEXT_OFFSET = 1;
    private static final int SLOT_TABLE_GROUP_PARENT_OFFSET = 2;
    public static final int SLOT_TABLE_GROUP_SIZE = 6;
    private static final int SLOT_TABLE_GROUP_SLOTS_OFFSET = 5;
    private static final int SLOT_TABLE_INITIAL_GROUPS_SIZE = 0x300;
    private static final int SLOT_TABLE_INITIAL_SLOTS_SIZE = 0x100;
    private static final int SLOT_TABLE_SLOT_LARGE_SENTINEL = 15;
    public static final int SLOT_TABLE_SLOT_MAX_SMALL_SIZE = 15;
    private static final int SLOT_TABLE_SLOT_MOVE_BUFFER_SIZE = 8;
    public static final int SLOT_TABLE_SLOT_SHIFT = 4;
    private static final int SLOT_TABLE_SLOT_SMALL_SIZE_MASK = 15;
    private static final Object Unallocated;

    static {
        SlotTableAddresSpaceKt.Unallocated = new SlotTableAddresSpaceKt$Unallocated$1();
    }

    public static final Object access$getUnallocated$p() {
        return SlotTableAddresSpaceKt.Unallocated;
    }

    public static final int access$groupAllocate(int[] arg0, int arg1, int arg2, int arg3) {
        return SlotTableAddresSpaceKt.groupAllocate(arg0, arg1, arg2, arg3);
    }

    public static final void access$initGroups(int[] arg0, int arg1) {
        SlotTableAddresSpaceKt.initGroups(arg0, arg1);
    }

    public static final int[] access$newGroupsArray(int arg0) {
        return SlotTableAddresSpaceKt.newGroupsArray(arg0);
    }

    public static final Object[] access$newSlotsArray(int arg0) {
        return SlotTableAddresSpaceKt.newSlotsArray(arg0);
    }

    public static final int access$validateFreeList(int[] arg0) {
        return SlotTableAddresSpaceKt.validateFreeList(arg0);
    }

    private static final boolean allUnallocated(Object[] arg3, int arg4, int arg5) {
        arg5 += arg4;
        if(arg5 >= arg3.length) {
            return 0;
        }

        while(arg4 < arg5) {
            if(arg3[arg4] != SlotTableAddresSpaceKt.Unallocated) {
                return 0;
            }

            ++arg4;
        }

        return 1;
    }

    public static final List buildTrace(SlotTableAddressSpace arg6, int arg7, Object arg8, ComposeStackTraceBuilder arg9) {
        int[] v0 = arg6.getGroups();
        int v1;
        for(v1 = arg7; v1 > 0; v1 = v0[v1 + 2]) {
            int v2 = arg6.getGroups()[v1 + 4];
            Object v2_1 = (v2 & 0x1000000) == 0x1000000 ? arg6.getSlots()[(arg6.getGroups()[v1 + 5] >> 4) + Integer.bitCount(v2 & 0x800000)] : null;
            arg9.processEdge(arg6.getGroups()[v1], v2_1, arg6.sourceInformationOf(v1), arg8);
            LinkAnchor v8 = arg6.anchorOfAddress(v1);
        }

        int v6 = v1 != 0 ? 1 : 0;
        if(v6 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg7);
        }

        return arg9.trace();
    }

    private static final void clearRange(Object[] arg1, int arg2, int arg3) {
        if(arg3 == arg2 + 1) {
            arg1[arg2] = SlotTableAddresSpaceKt.Unallocated;
            return;
        }

        ArraysKt.fill(arg1, SlotTableAddresSpaceKt.Unallocated, arg2, arg3);
    }

    private static final int groupAllocate(int[] arg4, int arg5, int arg6, int arg7) {
        int v0 = -1;
        if(arg4 != null) {
            if(arg4.length < 6) {
            }
            else {
                int v1 = 3;
                int v2 = arg4[v1];
                if(v2 >= arg4.length) {
                    v2 = arg4[1];
                    if(v2 < 0) {
                        return v0;
                    }
                    else {
                        arg4[1] = arg4[v2 + 1];
                    }
                }
                else {
                    arg4[v1] = v2 + 6;
                }

                arg4[v2] = arg5;
                arg4[v2 + 2] = arg6;
                arg4[v2 + 1] = v0;
                arg4[v2 + 3] = v0;
                arg4[v2 + 4] = arg7;
                arg4[v2 + 5] = v0;
                return v2;
            }
        }

        return v0;
    }

    public static final int groupChild(int[] arg0, int arg1) {
        return arg0[arg1 + 3];
    }

    public static final void groupChild(int[] arg0, int arg1, int arg2) {
        arg0[arg1 + 3] = arg2;
    }

    public static final int groupChildNodeCount(int[] arg0, int arg1) {
        return arg0[arg1 + 4] & 0x7FFFFF;
    }

    public static final int groupChildNodeCount(int[] arg2, int arg3, int arg4) {
        arg3 += 4;
        arg4 |= arg2[arg3] & 0xFF800000;
        arg2[arg3] = arg4;
        return arg4;
    }

    public static final int groupFlags(int[] arg0, int arg1) {
        return arg0[arg1 + 4];
    }

    public static final void groupFlags(int[] arg0, int arg1, int arg2) {
        arg0[arg1 + 4] = arg2;
    }

    public static final int groupKey(int[] arg0, int arg1) {
        return arg0[arg1];
    }

    public static final void groupKey(int[] arg0, int arg1, int arg2) {
        arg0[arg1] = arg2;
    }

    public static final int groupNext(int[] arg0, int arg1) {
        return arg0[arg1 + 1];
    }

    public static final void groupNext(int[] arg0, int arg1, int arg2) {
        arg0[arg1 + 1] = arg2;
    }

    public static final int groupNodeCount(int[] arg1, int arg2) {
        int v1 = arg1[arg2 + 4];
        if((v1 & 0x800000) == 0x800000) {
            return 1;
        }

        return v1 & 0x7FFFFF;
    }

    public static final int groupParent(int[] arg0, int arg1) {
        return arg0[arg1 + 2];
    }

    public static final void groupParent(int[] arg0, int arg1, int arg2) {
        arg0[arg1 + 2] = arg2;
    }

    public static final int groupSlotRange(int[] arg0, int arg1) {
        return arg0[arg1 + 5];
    }

    public static final void groupSlotRange(int[] arg0, int arg1, int arg2) {
        arg0[arg1 + 5] = arg2;
    }

    private static final void initGroups(int[] arg2, int arg3) {
        if(arg2 == null) {
            return;
        }

        arg2[1] = -1;
        arg2[3] = arg3;
    }

    public static final boolean isLargeSlotRangeSize(int arg1) {
        if(arg1 > 15) {
            return 1;
        }

        return 0;
    }

    public static final boolean isUnallocated(Object arg1) {
        return Intrinsics.areEqual(arg1, SlotTableAddresSpaceKt.Unallocated);
    }

    private static final int[] newGroupsArray(int arg2) {
        int[] v2 = new int[arg2];
        v2[1] = -1;
        SlotTableAddresSpaceKt.initGroups(v2, 6);
        return v2;
    }

    private static final Object[] newSlotsArray(int arg6) {
        Object[] v0 = new Object[arg6];
        ArraysKt.fill$default(v0, SlotTableAddresSpaceKt.Unallocated, 0, 0, 6, null);
        return v0;
    }

    public static final int slotAddressOf(int arg0) {
        return arg0 >> 4;
    }

    public static final int slotRangeFromAddressAndSize(int arg1, int arg2) {
        arg1 <<= 4;
        int v0 = 15;
        if(arg2 > v0) {
        }
        else {
            v0 = arg2 - 1;
        }

        return arg1 | v0;
    }

    public static final int slotSmallSizeOf(int arg0) {
        return (arg0 & 15) + 1;
    }

    private static final int validateFreeList(int[] arg5) {
        int v1 = arg5[1];
        MutableIntSet v2 = IntSetKt.mutableIntSetOf();
        while(true) {
            if(v1 >= 1) {
                if(!v2.contains(v1)) {
                    v2.add(v1);
                    int v3 = arg5[v1 + 1];
                    if(v3 != -1) {
                        if(v3 % 6 == 0 && v3 >= 0) {
                            v1 = v3;
                            continue;
                        }

                        break;
                    }
                }
                else {
                    goto label_25;
                }
            }

            goto label_34;
        }

        throw new IllegalStateException("Invalid free link at " + v1.toString());
    label_25:
        throw new IllegalStateException("Loop at " + v1.toString());
    label_34:
        return v2.getSize();
    }
}

