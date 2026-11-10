package androidx.compose.runtime.composer.gapbuffer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\u0012\u001A\u00020\u0004H\u0016R\u0011\u0010\u0002\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0013"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/RelativeGroupPath;", "Landroidx/compose/runtime/composer/gapbuffer/SourceInformationGroupPath;", "parent", "index", "", "<init>", "(Landroidx/compose/runtime/composer/gapbuffer/SourceInformationGroupPath;I)V", "getParent", "()Landroidx/compose/runtime/composer/gapbuffer/SourceInformationGroupPath;", "getIndex", "()I", "getIdentity", "", "table", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "equals", "", "other", "hashCode", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class RelativeGroupPath extends SourceInformationGroupPath {
    private final int index;
    private final SourceInformationGroupPath parent;

    public RelativeGroupPath(SourceInformationGroupPath arg2, int arg3) {
        super(null);
        this.parent = arg2;
        this.index = arg3;
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof RelativeGroupPath)) && (Intrinsics.areEqual(((RelativeGroupPath)arg3).parent, this.parent)) && ((RelativeGroupPath)arg3).index == this.index) {
            return 1;
        }

        return 0;
    }

    public Object getIdentity(SlotTable arg3) {
        return new SourceInformationSlotTableGroupIdentity(this.parent.getIdentity(arg3), this.index);
    }

    public final int getIndex() {
        return this.index;
    }

    public final SourceInformationGroupPath getParent() {
        return this.parent;
    }

    public int hashCode() {
        return this.index * 0x1F + this.parent.hashCode();
    }
}

