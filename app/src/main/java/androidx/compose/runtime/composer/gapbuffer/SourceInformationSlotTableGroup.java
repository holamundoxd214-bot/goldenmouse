package androidx.compose.runtime.composer.gapbuffer;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010)\u001A\b\u0012\u0004\u0012\u00020\u00010*H\u0096\u0002J\u0013\u0010+\u001A\u00020\'2\b\u0010,\u001A\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010-\u001A\u00020\u0006H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001A\u0004\u0018\u00010\u001A8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0016\u0010\u001D\u001A\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u0018R\u001C\u0010\u001F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b \u0010!R\u001A\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b#\u0010!R\u0014\u0010$\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b%\u0010\u0018R\u0014\u0010&\u001A\u00020\'8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b&\u0010(¨\u0006."}, d2={"Landroidx/compose/runtime/composer/gapbuffer/SourceInformationSlotTableGroup;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "table", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "parent", "", "sourceInformation", "Landroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;", "identityPath", "Landroidx/compose/runtime/composer/gapbuffer/SourceInformationGroupPath;", "<init>", "(Landroidx/compose/runtime/composer/gapbuffer/SlotTable;ILandroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;Landroidx/compose/runtime/composer/gapbuffer/SourceInformationGroupPath;)V", "getTable", "()Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "getParent", "()I", "getSourceInformation", "()Landroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;", "getIdentityPath", "()Landroidx/compose/runtime/composer/gapbuffer/SourceInformationGroupPath;", "key", "", "getKey", "()Ljava/lang/Object;", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "node", "getNode", "data", "getData", "()Ljava/lang/Iterable;", "compositionGroups", "getCompositionGroups", "identity", "getIdentity", "isEmpty", "", "()Z", "iterator", "", "equals", "other", "hashCode", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class SourceInformationSlotTableGroup implements CompositionGroup, Iterable, KMappedMarker {
    private final Iterable compositionGroups;
    private final SourceInformationGroupPath identityPath;
    private final Object key;
    private final int parent;
    private final GapGroupSourceInformation sourceInformation;
    private final SlotTable table;

    public SourceInformationSlotTableGroup(SlotTable arg1, int arg2, GapGroupSourceInformation arg3, SourceInformationGroupPath arg4) {
        super();
        this.table = arg1;
        this.parent = arg2;
        this.sourceInformation = arg3;
        this.identityPath = arg4;
        this.key = Integer.valueOf(arg3.getKey());
        this.compositionGroups = this;
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof SourceInformationSlotTableGroup)) && ((SourceInformationSlotTableGroup)arg3).parent == this.parent && (Intrinsics.areEqual(((SourceInformationSlotTableGroup)arg3).table, this.table)) && (Intrinsics.areEqual(((SourceInformationSlotTableGroup)arg3).identityPath, this.identityPath))) {
            return 1;
        }

        return 0;
    }

    public Iterable getCompositionGroups() {
        return this.compositionGroups;
    }

    public Iterable getData() {
        return new SourceInformationGroupDataIterator(this.table, this.parent, this.sourceInformation);
    }

    public Object getIdentity() {
        return this.identityPath.getIdentity(this.table);
    }

    public final SourceInformationGroupPath getIdentityPath() {
        return this.identityPath;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getNode() {
        return null;
    }

    public final int getParent() {
        return this.parent;
    }

    public String getSourceInfo() {
        return this.sourceInformation.getSourceInformation();
    }

    public final GapGroupSourceInformation getSourceInformation() {
        return this.sourceInformation;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public int hashCode() {
        return (this.parent * 0x1F + this.table.hashCode()) * 0x1F + this.identityPath.hashCode();
    }

    public boolean isEmpty() {
        ArrayList v2 = this.sourceInformation.getGroups();
        int v1 = 0;
        if(v2 != null && !v2.isEmpty()) {
            v1 = 1;
        }

        return v1 ^ 1;
    }

    public Iterator iterator() {
        return new SourceInformationGroupIterator(this.table, this.parent, this.sourceInformation, this.identityPath);
    }
}

