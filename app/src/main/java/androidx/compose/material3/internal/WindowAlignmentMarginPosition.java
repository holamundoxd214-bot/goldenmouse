package androidx.compose.material3.internal;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2={"Landroidx/compose/material3/internal/WindowAlignmentMarginPosition;", "", "<init>", "()V", "Horizontal", "Vertical", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowAlignmentMarginPosition {
    @Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0012\u001A\u00020\u0003HÂ\u0003J\t\u0010\u0013\u001A\u00020\u0005HÂ\u0003J\u001D\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001A\u00020\u0005HÖ\u0001J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/compose/material3/internal/WindowAlignmentMarginPosition$Horizontal;", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "margin", "", "<init>", "(Landroidx/compose/ui/Alignment$Horizontal;I)V", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "position-95KtPRI", "(Landroidx/compose/ui/unit/IntRect;JILandroidx/compose/ui/unit/LayoutDirection;)I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Horizontal implements androidx.compose.material3.internal.MenuPosition$Horizontal {
        public static final int $stable;
        private final androidx.compose.ui.Alignment$Horizontal alignment;
        private final int margin;

        static {
        }

        public Horizontal(androidx.compose.ui.Alignment$Horizontal arg1, int arg2) {
            super();
            this.alignment = arg1;
            this.margin = arg2;
        }

        private final androidx.compose.ui.Alignment$Horizontal component1() {
            return this.alignment;
        }

        private final int component2() {
            return this.margin;
        }

        public final Horizontal copy(androidx.compose.ui.Alignment$Horizontal arg1, int arg2) {
            return new Horizontal(arg1, arg2);
        }

        public static Horizontal copy$default(Horizontal arg0, androidx.compose.ui.Alignment$Horizontal arg1, int arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.alignment;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.margin;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Horizontal)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Horizontal)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.alignment, ((Horizontal)arg5).alignment)) {
                return 0;
            }

            if(this.margin != ((Horizontal)arg5).margin) {
                return 0;
            }

            return 1;
        }

        public int hashCode() {
            return this.alignment.hashCode() * 0x1F + Integer.hashCode(this.margin);
        }

        public int position-95KtPRI(IntRect arg1, long arg2, int arg4, LayoutDirection arg5) {
            int v1 = ((int)(arg2 >> 0x20));
            if(arg4 >= v1 - this.margin * 2) {
                return Alignment.Companion.getCenterHorizontally().align(arg4, v1, arg5);
            }

            return RangesKt.coerceIn(this.alignment.align(arg4, v1, arg5), this.margin, v1 - this.margin - arg4);
        }

        public String toString() {
            return "Horizontal(alignment=" + this.alignment + ", margin=" + this.margin + ')';
        }
    }

    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\'\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\t\u0010\u0010\u001A\u00020\u0003HÂ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÂ\u0003J\u001D\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/compose/material3/internal/WindowAlignmentMarginPosition$Vertical;", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "margin", "", "<init>", "(Landroidx/compose/ui/Alignment$Vertical;I)V", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuHeight", "position-JVtK1S4", "(Landroidx/compose/ui/unit/IntRect;JI)I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Vertical implements androidx.compose.material3.internal.MenuPosition$Vertical {
        public static final int $stable;
        private final androidx.compose.ui.Alignment$Vertical alignment;
        private final int margin;

        static {
        }

        public Vertical(androidx.compose.ui.Alignment$Vertical arg1, int arg2) {
            super();
            this.alignment = arg1;
            this.margin = arg2;
        }

        private final androidx.compose.ui.Alignment$Vertical component1() {
            return this.alignment;
        }

        private final int component2() {
            return this.margin;
        }

        public final Vertical copy(androidx.compose.ui.Alignment$Vertical arg1, int arg2) {
            return new Vertical(arg1, arg2);
        }

        public static Vertical copy$default(Vertical arg0, androidx.compose.ui.Alignment$Vertical arg1, int arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.alignment;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.margin;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Vertical)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Vertical)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.alignment, ((Vertical)arg5).alignment)) {
                return 0;
            }

            if(this.margin != ((Vertical)arg5).margin) {
                return 0;
            }

            return 1;
        }

        public int hashCode() {
            return this.alignment.hashCode() * 0x1F + Integer.hashCode(this.margin);
        }

        public int position-JVtK1S4(IntRect arg3, long arg4, int arg6) {
            int v3 = ((int)(arg4 & 0xFFFFFFFFL));
            if(arg6 >= v3 - this.margin * 2) {
                return Alignment.Companion.getCenterVertically().align(arg6, v3);
            }

            return RangesKt.coerceIn(this.alignment.align(arg6, v3), this.margin, v3 - this.margin - arg6);
        }

        public String toString() {
            return "Vertical(alignment=" + this.alignment + ", margin=" + this.margin + ')';
        }
    }

    public static final int $stable;
    public static final WindowAlignmentMarginPosition INSTANCE;

    static {
        WindowAlignmentMarginPosition.INSTANCE = new WindowAlignmentMarginPosition();
    }

    private WindowAlignmentMarginPosition() {
        super();
    }
}

