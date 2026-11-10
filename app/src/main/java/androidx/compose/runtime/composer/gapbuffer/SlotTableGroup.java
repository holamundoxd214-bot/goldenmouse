package androidx.compose.runtime.composer.gapbuffer;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B!\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010#\u001A\b\u0012\u0004\u0012\u00020\u00010$H\u0096\u0002J\b\u0010)\u001A\u00020*H\u0002J\u0012\u0010+\u001A\u0004\u0018\u00010\u00012\u0006\u0010,\u001A\u00020\u0013H\u0016J\u0013\u0010-\u001A\u00020\u00102\b\u0010.\u001A\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010/\u001A\u00020\u0006H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0014\u0010\u000F\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001A\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001A\u001A\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0015R\u001C\u0010\u001C\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b \u0010\u0015R\u001A\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010\u001ER\u0014\u0010%\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b&\u0010\rR\u0014\u0010\'\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b(\u0010\r¨\u00060"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/SlotTableGroup;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "table", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "group", "", "version", "<init>", "(Landroidx/compose/runtime/composer/gapbuffer/SlotTable;II)V", "getTable", "()Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "getGroup", "()I", "getVersion", "isEmpty", "", "()Z", "key", "", "getKey", "()Ljava/lang/Object;", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "node", "getNode", "data", "getData", "()Ljava/lang/Iterable;", "identity", "getIdentity", "compositionGroups", "getCompositionGroups", "iterator", "", "groupSize", "getGroupSize", "slotsSize", "getSlotsSize", "validateRead", "", "find", "identityToFind", "equals", "other", "hashCode", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class SlotTableGroup implements CompositionGroup, Iterable, KMappedMarker {
    private final int group;
    private final SlotTable table;
    private final int version;

    public SlotTableGroup(SlotTable arg1, int arg2, int arg3) {
        super();
        this.table = arg1;
        this.group = arg2;
        this.version = arg3;
    }

    public SlotTableGroup(SlotTable arg1, int arg2, int arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = arg1.getVersion$runtime();
        }

        this(arg1, arg2, arg3);
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof SlotTableGroup)) && ((SlotTableGroup)arg3).group == this.group && ((SlotTableGroup)arg3).version == this.version && (Intrinsics.areEqual(((SlotTableGroup)arg3).table, this.table))) {
            return 1;
        }

        return 0;
    }

    public CompositionGroup find(Object arg3) {
        if((arg3 instanceof GapAnchor)) {
            return SlotTableGroup.find$findAnchoredGroup(this, ((GapAnchor)arg3));
        }

        CompositionGroup v1 = null;
        if((arg3 instanceof SourceInformationSlotTableGroupIdentity)) {
            CompositionGroup v2 = this.find(((SourceInformationSlotTableGroupIdentity)arg3).getParentIdentity());
            if(v2 != null) {
                return SlotTableGroup.find$findRelativeGroup(v2, ((SourceInformationSlotTableGroupIdentity)arg3).getIndex());
            }
        }

        return v1;
    }

    private static final CompositionGroup find$findAnchoredGroup(SlotTableGroup arg3, GapAnchor arg4) {
        if(arg3.table.ownsAnchor(arg4)) {
            int v4 = arg3.table.anchorIndex(arg4);
            int v0 = arg3.group;
            if(v4 >= v0 && v4 - v0 < SlotTableKt.access$groupSize(arg3.table.getGroups(), arg3.group)) {
                return new SlotTableGroup(arg3.table, v4, arg3.version);
            }
        }

        return null;
    }

    private static final CompositionGroup find$findRelativeGroup(CompositionGroup arg0, int arg1) {
        return CollectionsKt.firstOrNull(CollectionsKt.drop(arg0.getCompositionGroups(), arg1));
    }

    public Iterable getCompositionGroups() {
        return this;
    }

    public Iterable getData() {
        GapGroupSourceInformation v0 = this.table.sourceInformationOf(this.group);
        if(v0 != null) {
            return new SourceInformationGroupDataIterator(this.table, this.group, v0);
        }

        return new DataIterator(this.table, this.group);
    }

    public final int getGroup() {
        return this.group;
    }

    public int getGroupSize() {
        return SlotTableKt.access$groupSize(this.table.getGroups(), this.group);
    }

    public Object getIdentity() {
        GapAnchor v1_1;
        this.validateRead();
        SlotReader v0 = this.table.openReader();
        try {
            v1_1 = v0.anchor(this.group);
        }
        catch(Throwable v1) {
            v0.close();
            throw v1;
        }

        v0.close();
        return v1_1;
    }

    public Object getKey() {
        int v0 = this.table.getGroups()[this.group * 5 + 1] & 0x20000000;
        SlotTable v1 = this.table;
        if(v0 != 0) {
            Object v2 = v1.getSlots()[SlotTableKt.access$objectKeyIndex(this.table.getGroups(), this.group)];
            Intrinsics.checkNotNull(v2);
            return v2;
        }

        return Integer.valueOf(v1.getGroups()[this.group * 5]);
    }

    public Object getNode() {
        if((this.table.getGroups()[this.group * 5 + 1] & 0x40000000) != 0) {
            return this.table.getSlots()[this.table.getGroups()[this.group * 5 + 4]];
        }

        return null;
    }

    public int getSlotsSize() {
        int v0 = this.group + this.getGroupSize();
        int v1 = this.table.getGroupsSize();
        SlotTable v2 = this.table;
        v0 = v0 < v1 ? v2.getGroups()[v0 * 5 + 4] : v2.getSlotsSize();
        return v0 - this.table.getGroups()[this.group * 5 + 4];
    }

    public String getSourceInfo() {
        GapGroupSourceInformation v1 = this.table.sourceInformationOf(this.group);
        if(v1 != null) {
            return v1.getSourceInformation();
        }

        return null;
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.group + this.table.hashCode() * 0x1F;
    }

    public boolean isEmpty() {
        if(SlotTableKt.access$groupSize(this.table.getGroups(), this.group) == 0) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        this.validateRead();
        GapGroupSourceInformation v0 = this.table.sourceInformationOf(this.group);
        if(v0 != null) {
            return new SourceInformationGroupIterator(this.table, this.group, v0, new AnchoredGroupPath(this.group));
        }

        return new GroupIterator(this.table, this.group + 1, this.group + SlotTableKt.access$groupSize(this.table.getGroups(), this.group));
    }

    private final void validateRead() {
        if(this.table.getVersion$runtime() != this.version) {
            SlotTableKt.throwConcurrentModificationException();
        }
    }
}

