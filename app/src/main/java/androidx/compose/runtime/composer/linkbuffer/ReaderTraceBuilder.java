package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.composer.GroupSourceInformation;
import androidx.compose.runtime.tooling.ComposeStackTraceBuilder;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\tH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/ReaderTraceBuilder;", "Landroidx/compose/runtime/tooling/ComposeStackTraceBuilder;", "reader", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTableReader;)V", "sourceInformationOf", "Landroidx/compose/runtime/composer/GroupSourceInformation;", "anchor", "Landroidx/compose/runtime/Anchor;", "groupKeyOf", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ReaderTraceBuilder extends ComposeStackTraceBuilder {
    public static final int $stable = 8;
    private final SlotTableReader reader;

    static {
    }

    public ReaderTraceBuilder(SlotTableReader arg1) {
        super();
        this.reader = arg1;
    }

    public int groupKeyOf(Anchor arg1) {
        return this.reader.groupKey(LinkAnchorKt.asLinkAnchor(arg1).getAddress());
    }

    public GroupSourceInformation sourceInformationOf(Anchor arg1) {
        return this.reader.getTable().getAddressSpace().sourceInformationOf(LinkAnchorKt.asLinkAnchor(arg1).getAddress());
    }
}

