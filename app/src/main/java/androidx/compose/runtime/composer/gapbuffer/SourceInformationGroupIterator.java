package androidx.compose.runtime.composer.gapbuffer;

import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u0017\u001A\u00020\u0018H\u0096\u0002J\t\u0010\u0019\u001A\u00020\u0002H\u0096\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u000E\u0010\u0015\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/SourceInformationGroupIterator;", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "table", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "parent", "", "group", "Landroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;", "path", "Landroidx/compose/runtime/composer/gapbuffer/SourceInformationGroupPath;", "<init>", "(Landroidx/compose/runtime/composer/gapbuffer/SlotTable;ILandroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;Landroidx/compose/runtime/composer/gapbuffer/SourceInformationGroupPath;)V", "getTable", "()Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "getParent", "()I", "getGroup", "()Landroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;", "getPath", "()Landroidx/compose/runtime/composer/gapbuffer/SourceInformationGroupPath;", "version", "index", "hasNext", "", "next", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class SourceInformationGroupIterator implements Iterator, KMappedMarker {
    private final GapGroupSourceInformation group;
    private int index;
    private final int parent;
    private final SourceInformationGroupPath path;
    private final SlotTable table;
    private final int version;

    public SourceInformationGroupIterator(SlotTable arg1, int arg2, GapGroupSourceInformation arg3, SourceInformationGroupPath arg4) {
        super();
        this.table = arg1;
        this.parent = arg2;
        this.group = arg3;
        this.path = arg4;
        this.version = arg1.getVersion$runtime();
    }

    public final GapGroupSourceInformation getGroup() {
        return this.group;
    }

    public final int getParent() {
        return this.parent;
    }

    public final SourceInformationGroupPath getPath() {
        return this.path;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public boolean hasNext() {
        ArrayList v0 = this.group.getGroups();
        if(v0 != null && this.index < v0.size()) {
            return 1;
        }

        return 0;
    }

    public CompositionGroup next() {
        Object v0_1;
        ArrayList v0 = this.group.getGroups();
        if(v0 != null) {
            int v1 = this.index;
            this.index = v1 + 1;
            v0_1 = v0.get(v1);
        }
        else {
            v0_1 = null;
        }

        if((v0_1 instanceof GapAnchor)) {
            return new SlotTableGroup(this.table, ((GapAnchor)v0_1).getLocation$runtime(), this.version);
        }

        if((v0_1 instanceof GapGroupSourceInformation)) {
            return new SourceInformationSlotTableGroup(this.table, this.parent, ((GapGroupSourceInformation)v0_1), new RelativeGroupPath(this.path, this.index - 1));
        }

        ComposerKt.composeRuntimeError("Unexpected group information structure");
        throw new KotlinNothingValueException();
    }

    public Object next() {
        return this.next();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

