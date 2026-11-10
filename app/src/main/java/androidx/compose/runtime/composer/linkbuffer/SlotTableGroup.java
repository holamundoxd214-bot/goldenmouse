package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B%\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\n\u0010\u0005\u001A\u00060\u0006j\u0002`\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010$\u001A\b\u0012\u0004\u0012\u00020\u00010%H\u0096\u0002J\b\u0010*\u001A\u00020+H\u0002J\u0012\u0010,\u001A\u0004\u0018\u00010\u00012\u0006\u0010-\u001A\u00020\u0014H\u0016J\u0013\u0010.\u001A\u00020\u00112\b\u0010/\u001A\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u00100\u001A\u00020\u0006H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0015\u0010\u0005\u001A\u00060\u0006j\u0002`\u0007¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\b\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001A\u0004\u0018\u00010\u00188VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001AR\u0016\u0010\u001B\u001A\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u0016R\u001C\u0010\u001D\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u0016R\u001A\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\u001FR\u0014\u0010&\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010\u000ER\u0014\u0010(\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b)\u0010\u000E¨\u00061"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/SlotTableGroup;", "Landroidx/compose/runtime/tooling/CompositionGroup;", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "group", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "version", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;II)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "getGroup", "()I", "getVersion", "isEmpty", "", "()Z", "key", "", "getKey", "()Ljava/lang/Object;", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "node", "getNode", "data", "getData", "()Ljava/lang/Iterable;", "identity", "getIdentity", "compositionGroups", "getCompositionGroups", "iterator", "", "groupSize", "getGroupSize", "slotsSize", "getSlotsSize", "validateRead", "", "find", "identityToFind", "equals", "other", "hashCode", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class SlotTableGroup implements CompositionGroup, Iterable, KMappedMarker {
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
            arg3 = arg1.getVersion();
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
        if((arg3 instanceof LinkAnchor)) {
            return SlotTableGroup.find$findAnchoredGroup(this, ((LinkAnchor)arg3));
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

    private static final CompositionGroup find$findAnchoredGroup(SlotTableGroup arg3, LinkAnchor arg4) {
        SlotTableAddressSpace v0 = arg3.table.getAddressSpace();
        if(v0.ownsAnchor(arg4)) {
            int v4 = arg4.getAddress();
            if(v4 == arg3.group) {
                return arg3;
            }
            else {
                int[] v0_1 = v0.getGroups();
                int v1 = v0_1[v4 + 2];
                while(true) {
                    if(v1 <= 0) {
                        break;
                    }
                    else if(v1 == arg3.group) {
                        return new SlotTableGroup(arg3.table, v4, arg3.version);
                    }
                    else {
                        v1 = v0_1[v1 + 2];
                        continue;
                    }

                    return null;
                }

                int v3 = v1 != 0 ? 1 : 0;
                if(v3 != 0) {
                    return null;
                }

                ComposerKt.composeImmediateRuntimeError("Traversing parent of group not in the slot table: " + v4);
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
        LinkGroupSourceInformation v0 = this.table.getAddressSpace().sourceInformationOf(this.group);
        if(v0 != null) {
            return new SourceInformationGroupDataIterator(this.table, this.group, v0);
        }

        return new DataIterator(this.table, this.group);
    }

    public final int getGroup() {
        return this.group;
    }

    public int getGroupSize() {
        SlotTableAddressSpace v0 = this.table.getAddressSpace();
        int v5 = this.group;
        int v1 = 0;
        if(v5 >= 0) {
            IntStack v2 = new IntStack();
            int[] v0_1 = v0.getGroups();
            int v3;
            for(v3 = v5; true; v3 = v2.pop()) {
            label_9:
                ++v1;
                if(v3 != v5) {
                    int v4 = v0_1[v3 + 1];
                    if(v4 >= 0) {
                        v2.push(v4);
                    }
                }

                v3 = v0_1[v3 + 3];
                if(v3 >= 0) {
                    goto label_9;
                }

                if(v2.tos == 0) {
                    return v1;
                }
            }
        }

        return 0;
    }

    public Object getIdentity() {
        this.validateRead();
        return this.table.getAddressSpace().anchorOfAddress(this.group);
    }

    public Object getKey() {
        Object v0 = this.table.groupObjectKey$runtime(this.group);
        if(v0 == null) {
            return Integer.valueOf(this.table.groupKeyOf$runtime(this.group));
        }

        return v0;
    }

    public Object getNode() {
        return this.table.groupNode$runtime(this.group);
    }

    public int getSlotsSize() {
        SlotTableAddressSpace v0 = this.table.getAddressSpace();
        int v1 = this.group;
        if(v1 >= 0) {
            IntStack v3 = new IntStack();
            int[] v0_1 = v0.getGroups();
            int v4 = v1;
            int v5 = 0;
            while(true) {
                int v6 = this.table.getAddressSpace().getGroups()[v4 + 5];
                int v7 = -1;
                if(v6 != v7) {
                    SlotTableAddressSpace v8 = this.table.getAddressSpace();
                    if(v6 == v7) {
                        v7 = 0;
                    }
                    else {
                        v7 = (v6 & 15) + 1;
                        if(v7 > 15) {
                            v7 = v8.getLargeSizes().get(v6 >> 4);
                        }
                    }

                    v5 += v7;
                }

                if(v4 != v1) {
                    v6 = v0_1[v4 + 1];
                    if(v6 >= 0) {
                        v3.push(v6);
                    }
                }

                v4 = v0_1[v4 + 3];
                if(v4 >= 0) {
                    continue;
                }

                if(v3.tos == 0) {
                    return v5;
                }

                v4 = v3.pop();
            }
        }

        return 0;
    }

    public String getSourceInfo() {
        boolean v0 = this.table.groupHasAux$runtime(this.group);
        SlotTable v1 = this.table;
        String v2 = null;
        if(v0) {
            Object v3 = v1.groupAux$runtime(this.group);
            if((v3 instanceof String)) {
                return ((String)v3);
            }

            return v2;
        }

        LinkGroupSourceInformation v3_1 = v1.getAddressSpace().sourceInformationOf(this.group);
        if(v3_1 != null) {
            return v3_1.getSourceInformation();
        }

        return v2;
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
        if(this.table.firstChildOf$runtime(this.group) == -1) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        this.validateRead();
        LinkGroupSourceInformation v0 = this.table.getAddressSpace().sourceInformationOf(this.group);
        if(v0 != null) {
            return new SourceInformationGroupIterator(this.table, this.group, v0, new AnchoredGroupPath(this.group));
        }

        return new GroupIterator(this.table, this.table.firstChildOf$runtime(this.group));
    }

    private final void validateRead() {
        if(this.table.getVersion() != this.version) {
            SlotTableKt.throwConcurrentModificationException();
        }
    }
}

