package androidx.compose.runtime.composer.gapbuffer;

import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/AnchoredGroupPath;", "Landroidx/compose/runtime/composer/gapbuffer/SourceInformationGroupPath;", "group", "", "<init>", "(I)V", "getGroup", "()I", "getIdentity", "", "table", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "equals", "", "other", "hashCode", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class AnchoredGroupPath extends SourceInformationGroupPath {
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

    public Object getIdentity(SlotTable arg1) {
        return arg1.anchor(this.group);
    }

    public int hashCode() {
        return this.group * 0x1F;
    }
}

