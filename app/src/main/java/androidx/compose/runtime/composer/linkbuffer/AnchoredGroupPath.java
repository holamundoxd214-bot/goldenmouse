package androidx.compose.runtime.composer.linkbuffer;

import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0003H\u0016R\u0015\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/AnchoredGroupPath;", "Landroidx/compose/runtime/composer/linkbuffer/SourceInformationGroupPath;", "group", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "<init>", "(I)V", "getGroup", "()I", "getIdentity", "", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "equals", "", "other", "hashCode", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class AnchoredGroupPath extends SourceInformationGroupPath {
    private final int group;

    public AnchoredGroupPath(int arg2) {
        super(null);
        this.group = arg2;
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof AnchoredGroupPath)) && ((AnchoredGroupPath)arg2).group == this.group) {
            return 1;
        }

        return 0;
    }

    public final int getGroup() {
        return this.group;
    }

    public Object getIdentity(SlotTableAddressSpace arg1) {
        return arg1.anchorOfAddress(this.group);
    }

    public int hashCode() {
        return this.group * 0x1F;
    }
}

