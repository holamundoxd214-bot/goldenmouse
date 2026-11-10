package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001:\u0001\u001DB!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000E\u001A\u00020\u00002\b\u0010\u000F\u001A\u0004\u0018\u00010\u0000J\r\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u001E"}, d2={"Landroidx/compose/foundation/text/selection/Selection;", "", "start", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "end", "handlesCrossed", "", "<init>", "(Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;Z)V", "getStart", "()Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getEnd", "getHandlesCrossed", "()Z", "merge", "other", "toTextRange", "Landroidx/compose/ui/text/TextRange;", "toTextRange-d9O1mEE", "()J", "component1", "component2", "component3", "copy", "equals", "hashCode", "", "toString", "", "AnchorInfo", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Selection {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0007HÆ\u0003J\'\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "", "selectableId", "", "<init>", "(Landroidx/compose/ui/text/style/ResolvedTextDirection;IJ)V", "getDirection", "()Landroidx/compose/ui/text/style/ResolvedTextDirection;", "getOffset", "()I", "getSelectableId", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnchorInfo {
        public static final int $stable;
        private final ResolvedTextDirection direction;
        private final int offset;
        private final long selectableId;

        static {
        }

        public AnchorInfo(ResolvedTextDirection arg1, int arg2, long arg3) {
            super();
            this.direction = arg1;
            this.offset = arg2;
            this.selectableId = arg3;
        }

        public final ResolvedTextDirection component1() {
            return this.direction;
        }

        public final int component2() {
            return this.offset;
        }

        public final long component3() {
            return this.selectableId;
        }

        public final AnchorInfo copy(ResolvedTextDirection arg1, int arg2, long arg3) {
            return new AnchorInfo(arg1, arg2, arg3);
        }

        public static AnchorInfo copy$default(AnchorInfo arg0, ResolvedTextDirection arg1, int arg2, long arg3, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.direction;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.offset;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.selectableId;
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg6) {
            if(this == (((AnchorInfo)arg6))) {
                return 1;
            }

            if(!(arg6 instanceof AnchorInfo)) {
                return 0;
            }

            if(this.direction != ((AnchorInfo)arg6).direction) {
                return 0;
            }

            if(this.offset != ((AnchorInfo)arg6).offset) {
                return 0;
            }

            if(this.selectableId != ((AnchorInfo)arg6).selectableId) {
                return 0;
            }

            return 1;
        }

        public final ResolvedTextDirection getDirection() {
            return this.direction;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final long getSelectableId() {
            return this.selectableId;
        }

        public int hashCode() {
            return (this.direction.hashCode() * 0x1F + Integer.hashCode(this.offset)) * 0x1F + Long.hashCode(this.selectableId);
        }

        public String toString() {
            return "AnchorInfo(direction=" + this.direction + ", offset=" + this.offset + ", selectableId=" + this.selectableId + ')';
        }
    }

    public static final int $stable;
    private final AnchorInfo end;
    private final boolean handlesCrossed;
    private final AnchorInfo start;

    static {
    }

    public Selection(AnchorInfo arg1, AnchorInfo arg2, boolean arg3) {
        super();
        this.start = arg1;
        this.end = arg2;
        this.handlesCrossed = arg3;
    }

    public Selection(AnchorInfo arg1, AnchorInfo arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, false);
    }

    public final AnchorInfo component1() {
        return this.start;
    }

    public final AnchorInfo component2() {
        return this.end;
    }

    public final boolean component3() {
        return this.handlesCrossed;
    }

    public final Selection copy(AnchorInfo arg1, AnchorInfo arg2, boolean arg3) {
        return new Selection(arg1, arg2, arg3);
    }

    public static Selection copy$default(Selection arg0, AnchorInfo arg1, AnchorInfo arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.start;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.end;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.handlesCrossed;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((Selection)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Selection)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.start, ((Selection)arg5).start)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.end, ((Selection)arg5).end)) {
            return 0;
        }

        if(this.handlesCrossed != ((Selection)arg5).handlesCrossed) {
            return 0;
        }

        return 1;
    }

    public final AnchorInfo getEnd() {
        return this.end;
    }

    public final boolean getHandlesCrossed() {
        return this.handlesCrossed;
    }

    public final AnchorInfo getStart() {
        return this.start;
    }

    public int hashCode() {
        return (this.start.hashCode() * 0x1F + this.end.hashCode()) * 0x1F + Boolean.hashCode(this.handlesCrossed);
    }

    public final Selection merge(Selection arg9) {
        if(arg9 == null) {
            return this;
        }

        boolean v0 = this.handlesCrossed;
        if(!v0) {
            if(arg9.handlesCrossed) {
            }
            else {
                return Selection.copy$default(this, null, arg9.end, false, 5, null);
            }
        }

        Selection v2 = this;
        AnchorInfo v9 = arg9.handlesCrossed ? arg9.start : arg9.end;
        AnchorInfo v0_1 = v0 ? v2.end : v2.start;
        return new Selection(v9, v0_1, true);
    }

    public String toString() {
        return "Selection(start=" + this.start + ", end=" + this.end + ", handlesCrossed=" + this.handlesCrossed + ')';
    }

    public final long toTextRange-d9O1mEE() {
        return TextRangeKt.TextRange(this.start.getOffset(), this.end.getOffset());
    }
}

