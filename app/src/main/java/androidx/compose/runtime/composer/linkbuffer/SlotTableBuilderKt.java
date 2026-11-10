package androidx.compose.runtime.composer.linkbuffer;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010\u000B\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0002H\u0080\n\u001A\u0012\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u0007H\u0000\u001A!\u0010\b\u001A\u00060\u0002j\u0002`\t2\n\u0010\n\u001A\u00060\u0002j\u0002`\t2\u0006\u0010\u000B\u001A\u00020\fH\u0082\b¨\u0006\r"}, d2={"contains", "", "", "other", "buildTrace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableBuilder;", "lastSiblingOf", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "address", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SlotTableBuilderKt {
    public static final List buildTrace(SlotTableBuilder arg4) {
        if(!arg4.isClosed() && !arg4.isEmpty()) {
            return SlotTableAddresSpaceKt.buildTrace(arg4.getTable().getAddressSpace(), arg4.getParentGroup(), Integer.valueOf(arg4.getSlotIndex()), new BuilderTraceBuilder(arg4));
        }

        return CollectionsKt.emptyList();
    }

    public static final boolean contains(int arg0, int arg1) {
        if((arg0 & arg1) == arg1) {
            return 1;
        }

        return 0;
    }

    private static final int lastSiblingOf(int arg2, SlotTableAddressSpace arg3) {
        int v0 = -1;
        if(arg2 == v0) {
            return v0;
        }

        int[] v3 = arg3.getGroups();
        while(arg2 >= 0) {
            v0 = arg2;
            arg2 = v3[arg2 + 1];
        }

        return v0;
    }
}

