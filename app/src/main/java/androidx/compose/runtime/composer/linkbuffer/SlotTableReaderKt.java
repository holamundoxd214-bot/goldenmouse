package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.ComposerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u001A\u0012\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000\u001A$\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0000¨\u0006\t"}, d2={"buildTrace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "traceForGroup", "group", "", "child", "", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SlotTableReaderKt {
    public static final List buildTrace(SlotTableReader arg4) {
        if(!arg4.isClosed() && !arg4.isEmpty()) {
            return SlotTableAddresSpaceKt.buildTrace(arg4.getTable().getAddressSpace(), arg4.getParentGroup(), Integer.valueOf(arg4.getSlotIndex()), new ReaderTraceBuilder(arg4));
        }

        return CollectionsKt.emptyList();
    }

    public static final List traceForGroup(SlotTableReader arg7, int arg8, Object arg9) {
        ReaderTraceBuilder v0 = new ReaderTraceBuilder(arg7);
        SlotTableAddressSpace v1 = arg7.getTable().getAddressSpace();
        int[] v2 = v1.getGroups();
        int v3;
        for(v3 = arg8; v3 > 0; v3 = v2[v3 + 2]) {
            v0.processEdge(arg7.groupKey(v3), arg7.groupObjectKey(v3), v1.sourceInformationOf(v3), arg9);
            LinkAnchor v9 = v1.anchorOfAddress(v3);
        }

        int v7 = v3 != 0 ? 1 : 0;
        if(v7 == 0) {
            ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + arg8);
        }

        return v0.trace();
    }
}

