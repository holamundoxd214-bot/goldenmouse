package androidx.compose.material3.internal;

import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2={"Landroidx/compose/material3/internal/AnchorAlignmentOffsetPosition;", "", "<init>", "()V", "Horizontal", "Vertical", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnchorAlignmentOffsetPosition {
    @Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\t\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0013\u001A\u00020\u0003HÂ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÂ\u0003J\t\u0010\u0015\u001A\u00020\u0006HÂ\u0003J\'\u0010\u0016\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u001AHÖ\u0003J\t\u0010\u001B\u001A\u00020\u0006HÖ\u0001J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Landroidx/compose/material3/internal/AnchorAlignmentOffsetPosition$Horizontal;", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "menuAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "anchorAlignment", "offset", "", "<init>", "(Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;I)V", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "position-95KtPRI", "(Landroidx/compose/ui/unit/IntRect;JILandroidx/compose/ui/unit/LayoutDirection;)I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Horizontal implements androidx.compose.material3.internal.MenuPosition$Horizontal {
        public static final int $stable;
        private final androidx.compose.ui.Alignment$Horizontal anchorAlignment;
        private final androidx.compose.ui.Alignment$Horizontal menuAlignment;
        private final int offset;

        static {
        }

        public Horizontal(androidx.compose.ui.Alignment$Horizontal arg1, androidx.compose.ui.Alignment$Horizontal arg2, int arg3) {
            super();
            this.menuAlignment = arg1;
            this.anchorAlignment = arg2;
            this.offset = arg3;
        }

        private final androidx.compose.ui.Alignment$Horizontal component1() {
            return this.menuAlignment;
        }

        private final androidx.compose.ui.Alignment$Horizontal component2() {
            return this.anchorAlignment;
        }

        private final int component3() {
            return this.offset;
        }

        public final Horizontal copy(androidx.compose.ui.Alignment$Horizontal arg1, androidx.compose.ui.Alignment$Horizontal arg2, int arg3) {
            return new Horizontal(arg1, arg2, arg3);
        }

        public static Horizontal copy$default(Horizontal arg0, androidx.compose.ui.Alignment$Horizontal arg1, androidx.compose.ui.Alignment$Horizontal arg2, int arg3, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg1 = arg0.menuAlignment;
            }

            if((arg4 & 2) != 0) {
                arg2 = arg0.anchorAlignment;
            }

            if((arg4 & 4) != 0) {
                arg3 = arg0.offset;
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg5) {
            if(this == (((Horizontal)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Horizontal)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.menuAlignment, ((Horizontal)arg5).menuAlignment)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.anchorAlignment, ((Horizontal)arg5).anchorAlignment)) {
                return 0;
            }

            if(this.offset != ((Horizontal)arg5).offset) {
                return 0;
            }

            return 1;
        }

        public int hashCode() {
            return (this.menuAlignment.hashCode() * 0x1F + this.anchorAlignment.hashCode()) * 0x1F + Integer.hashCode(this.offset);
        }

        public int position-95KtPRI(IntRect arg2, long arg3, int arg5, LayoutDirection arg6) {
            int v3 = this.anchorAlignment.align(0, arg2.getWidth(), arg6);
            int v4 = -this.menuAlignment.align(0, arg5, arg6);
            LayoutDirection v5 = LayoutDirection.Ltr;
            int v1 = this.offset;
            if(arg6 == v5) {
            }
            else {
                v1 = -v1;
            }

            return arg2.getLeft() + v3 + v4 + v1;
        }

        public String toString() {
            return "Horizontal(menuAlignment=" + this.menuAlignment + ", anchorAlignment=" + this.anchorAlignment + ", offset=" + this.offset + ')';
        }
    }

    @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\'\u0010\t\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\t\u0010\u0011\u001A\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÂ\u0003J\t\u0010\u0013\u001A\u00020\u0006HÂ\u0003J\'\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001A\u00020\u0006HÖ\u0001J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Landroidx/compose/material3/internal/AnchorAlignmentOffsetPosition$Vertical;", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "menuAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "anchorAlignment", "offset", "", "<init>", "(Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Vertical;I)V", "position", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuHeight", "position-JVtK1S4", "(Landroidx/compose/ui/unit/IntRect;JI)I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Vertical implements androidx.compose.material3.internal.MenuPosition$Vertical {
        public static final int $stable;
        private final androidx.compose.ui.Alignment$Vertical anchorAlignment;
        private final androidx.compose.ui.Alignment$Vertical menuAlignment;
        private final int offset;

        static {
        }

        public Vertical(androidx.compose.ui.Alignment$Vertical arg1, androidx.compose.ui.Alignment$Vertical arg2, int arg3) {
            super();
            this.menuAlignment = arg1;
            this.anchorAlignment = arg2;
            this.offset = arg3;
        }

        private final androidx.compose.ui.Alignment$Vertical component1() {
            return this.menuAlignment;
        }

        private final androidx.compose.ui.Alignment$Vertical component2() {
            return this.anchorAlignment;
        }

        private final int component3() {
            return this.offset;
        }

        public final Vertical copy(androidx.compose.ui.Alignment$Vertical arg1, androidx.compose.ui.Alignment$Vertical arg2, int arg3) {
            return new Vertical(arg1, arg2, arg3);
        }

        public static Vertical copy$default(Vertical arg0, androidx.compose.ui.Alignment$Vertical arg1, androidx.compose.ui.Alignment$Vertical arg2, int arg3, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg1 = arg0.menuAlignment;
            }

            if((arg4 & 2) != 0) {
                arg2 = arg0.anchorAlignment;
            }

            if((arg4 & 4) != 0) {
                arg3 = arg0.offset;
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg5) {
            if(this == (((Vertical)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Vertical)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.menuAlignment, ((Vertical)arg5).menuAlignment)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.anchorAlignment, ((Vertical)arg5).anchorAlignment)) {
                return 0;
            }

            if(this.offset != ((Vertical)arg5).offset) {
                return 0;
            }

            return 1;
        }

        public int hashCode() {
            return (this.menuAlignment.hashCode() * 0x1F + this.anchorAlignment.hashCode()) * 0x1F + Integer.hashCode(this.offset);
        }

        public int position-JVtK1S4(IntRect arg2, long arg3, int arg5) {
            return arg2.getTop() + this.anchorAlignment.align(0, arg2.getHeight()) + -this.menuAlignment.align(0, arg5) + this.offset;
        }

        public String toString() {
            return "Vertical(menuAlignment=" + this.menuAlignment + ", anchorAlignment=" + this.anchorAlignment + ", offset=" + this.offset + ')';
        }
    }

    public static final int $stable;
    public static final AnchorAlignmentOffsetPosition INSTANCE;

    static {
        AnchorAlignmentOffsetPosition.INSTANCE = new AnchorAlignmentOffsetPosition();
    }

    private AnchorAlignmentOffsetPosition() {
        super();
    }
}

