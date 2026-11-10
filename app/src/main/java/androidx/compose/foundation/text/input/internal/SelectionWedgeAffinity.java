package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\bJ\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\n¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "", "startAffinity", "Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "endAffinity", "<init>", "(Landroidx/compose/foundation/text/input/internal/WedgeAffinity;Landroidx/compose/foundation/text/input/internal/WedgeAffinity;)V", "affinity", "(Landroidx/compose/foundation/text/input/internal/WedgeAffinity;)V", "getStartAffinity", "()Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "getEndAffinity", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SelectionWedgeAffinity {
    public static final int $stable;
    private final WedgeAffinity endAffinity;
    private final WedgeAffinity startAffinity;

    static {
    }

    public SelectionWedgeAffinity(WedgeAffinity arg1) {
        this(arg1, arg1);
    }

    public SelectionWedgeAffinity(WedgeAffinity arg1, WedgeAffinity arg2) {
        super();
        this.startAffinity = arg1;
        this.endAffinity = arg2;
    }

    public final WedgeAffinity component1() {
        return this.startAffinity;
    }

    public final WedgeAffinity component2() {
        return this.endAffinity;
    }

    public final SelectionWedgeAffinity copy(WedgeAffinity arg1, WedgeAffinity arg2) {
        return new SelectionWedgeAffinity(arg1, arg2);
    }

    public static SelectionWedgeAffinity copy$default(SelectionWedgeAffinity arg0, WedgeAffinity arg1, WedgeAffinity arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.startAffinity;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.endAffinity;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((SelectionWedgeAffinity)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SelectionWedgeAffinity)) {
            return 0;
        }

        if(this.startAffinity != ((SelectionWedgeAffinity)arg5).startAffinity) {
            return 0;
        }

        if(this.endAffinity != ((SelectionWedgeAffinity)arg5).endAffinity) {
            return 0;
        }

        return 1;
    }

    public final WedgeAffinity getEndAffinity() {
        return this.endAffinity;
    }

    public final WedgeAffinity getStartAffinity() {
        return this.startAffinity;
    }

    public int hashCode() {
        return this.startAffinity.hashCode() * 0x1F + this.endAffinity.hashCode();
    }

    public String toString() {
        return "SelectionWedgeAffinity(startAffinity=" + this.startAffinity + ", endAffinity=" + this.endAffinity + ')';
    }
}

