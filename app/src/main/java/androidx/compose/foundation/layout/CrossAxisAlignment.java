package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000 \u00152\u00020\u0001:\u0004\u0015\u0016\u0017\u0018B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005H ¢\u0006\u0002\b\rJ\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00052\u0006\u0010\n\u001A\u00020\u000BH\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u000E\u001A\u00020\u000F8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011\u0082\u0001\u0003\u0019\u001A\u001B¨\u0006\u001C"}, d2={"Landroidx/compose/foundation/layout/CrossAxisAlignment;", "", "<init>", "()V", "align", "", "size", "itemCrossAxisSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout", "isRelative", "", "isRelative$foundation_layout", "()Z", "calculateAlignmentLinePosition", "calculateAlignmentLinePosition$foundation_layout", "(Landroidx/compose/ui/layout/Placeable;)Ljava/lang/Integer;", "Companion", "AlignmentLineCrossAxisAlignment", "VerticalCrossAxisAlignment", "HorizontalCrossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment$AlignmentLineCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$HorizontalCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$VerticalCrossAxisAlignment;", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class CrossAxisAlignment {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0010¢\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0017\u001A\u00020\rH\u0010¢\u0006\u0002\b\u0018R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\t8PX\u0090\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/layout/CrossAxisAlignment$AlignmentLineCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "alignmentLineProvider", "Landroidx/compose/foundation/layout/AlignmentLineProvider;", "<init>", "(Landroidx/compose/foundation/layout/AlignmentLineProvider;)V", "getAlignmentLineProvider", "()Landroidx/compose/foundation/layout/AlignmentLineProvider;", "isRelative", "", "isRelative$foundation_layout", "()Z", "calculateAlignmentLinePosition", "", "placeable", "Landroidx/compose/ui/layout/Placeable;", "calculateAlignmentLinePosition$foundation_layout", "(Landroidx/compose/ui/layout/Placeable;)Ljava/lang/Integer;", "align", "size", "itemCrossAxisSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeCrossAxisAlignmentLine", "align$foundation_layout", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class AlignmentLineCrossAxisAlignment extends CrossAxisAlignment {
        private final AlignmentLineProvider alignmentLineProvider;

        public AlignmentLineCrossAxisAlignment(AlignmentLineProvider arg2) {
            super(null);
            this.alignmentLineProvider = arg2;
        }

        public int align$foundation_layout(int arg1, int arg2, LayoutDirection arg3, Placeable arg4, int arg5) {
            int v0 = this.alignmentLineProvider.calculateAlignmentLinePosition(arg4);
            if(v0 != 0x80000000) {
                arg5 -= v0;
                if(arg3 == LayoutDirection.Rtl) {
                    return arg1 - arg2 - arg5;
                }

                return arg5;
            }

            return 0;
        }

        public Integer calculateAlignmentLinePosition$foundation_layout(Placeable arg1) {
            return Integer.valueOf(this.alignmentLineProvider.calculateAlignmentLinePosition(arg1));
        }

        public final AlignmentLineProvider getAlignmentLineProvider() {
            return this.alignmentLineProvider;
        }

        public boolean isRelative$foundation_layout() {
            return 1;
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u0015\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\nH\u0000¢\u0006\u0002\b\u000BJ\u0015\u0010\f\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\rH\u0000¢\u0006\u0002\b\u000EJ\u0015\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u0010H\u0000¢\u0006\u0002\b\u0011¨\u0006\u0012"}, d2={"Landroidx/compose/foundation/layout/CrossAxisAlignment$Companion;", "", "<init>", "()V", "AlignmentLine", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "Relative", "alignmentLineProvider", "Landroidx/compose/foundation/layout/AlignmentLineProvider;", "Relative$foundation_layout", "vertical", "Landroidx/compose/ui/Alignment$Vertical;", "vertical$foundation_layout", "horizontal", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontal$foundation_layout", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final CrossAxisAlignment AlignmentLine(AlignmentLine arg2) {
            return new AlignmentLineCrossAxisAlignment(new Value(arg2));
        }

        public final CrossAxisAlignment Relative$foundation_layout(AlignmentLineProvider arg1) {
            return new AlignmentLineCrossAxisAlignment(arg1);
        }

        public final CrossAxisAlignment horizontal$foundation_layout(Horizontal arg1) {
            return new HorizontalCrossAxisAlignment(arg1);
        }

        public final CrossAxisAlignment vertical$foundation_layout(Vertical arg1) {
            return new VerticalCrossAxisAlignment(arg1);
        }
    }

    @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\tH\u0010¢\u0006\u0002\b\u0011J\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001A\u00020\tHÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/layout/CrossAxisAlignment$HorizontalCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "horizontal", "Landroidx/compose/ui/Alignment$Horizontal;", "<init>", "(Landroidx/compose/ui/Alignment$Horizontal;)V", "getHorizontal", "()Landroidx/compose/ui/Alignment$Horizontal;", "align", "", "size", "itemCrossAxisSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class HorizontalCrossAxisAlignment extends CrossAxisAlignment {
        private final Horizontal horizontal;

        public HorizontalCrossAxisAlignment(Horizontal arg2) {
            super(null);
            this.horizontal = arg2;
        }

        public int align$foundation_layout(int arg1, int arg2, LayoutDirection arg3, Placeable arg4, int arg5) {
            return this.horizontal.align(arg2, arg1, arg3);
        }

        public final Horizontal component1() {
            return this.horizontal;
        }

        public final HorizontalCrossAxisAlignment copy(Horizontal arg1) {
            return new HorizontalCrossAxisAlignment(arg1);
        }

        public static HorizontalCrossAxisAlignment copy$default(HorizontalCrossAxisAlignment arg0, Horizontal arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.horizontal;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((HorizontalCrossAxisAlignment)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof HorizontalCrossAxisAlignment)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.horizontal, ((HorizontalCrossAxisAlignment)arg4).horizontal)) {
                return 0;
            }

            return 1;
        }

        public final Horizontal getHorizontal() {
            return this.horizontal;
        }

        public int hashCode() {
            return this.horizontal.hashCode();
        }

        public String toString() {
            return "HorizontalCrossAxisAlignment(horizontal=" + this.horizontal + ')';
        }
    }

    @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\tH\u0010¢\u0006\u0002\b\u0011J\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001A\u00020\tHÖ\u0001J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/layout/CrossAxisAlignment$VerticalCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "vertical", "Landroidx/compose/ui/Alignment$Vertical;", "<init>", "(Landroidx/compose/ui/Alignment$Vertical;)V", "getVertical", "()Landroidx/compose/ui/Alignment$Vertical;", "align", "", "size", "itemCrossAxisSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class VerticalCrossAxisAlignment extends CrossAxisAlignment {
        private final Vertical vertical;

        public VerticalCrossAxisAlignment(Vertical arg2) {
            super(null);
            this.vertical = arg2;
        }

        public int align$foundation_layout(int arg1, int arg2, LayoutDirection arg3, Placeable arg4, int arg5) {
            return this.vertical.align(arg2, arg1);
        }

        public final Vertical component1() {
            return this.vertical;
        }

        public final VerticalCrossAxisAlignment copy(Vertical arg1) {
            return new VerticalCrossAxisAlignment(arg1);
        }

        public static VerticalCrossAxisAlignment copy$default(VerticalCrossAxisAlignment arg0, Vertical arg1, int arg2, Object arg3) {
            if((arg2 & 1) != 0) {
                arg1 = arg0.vertical;
            }

            return arg0.copy(arg1);
        }

        public boolean equals(Object arg4) {
            if(this == (((VerticalCrossAxisAlignment)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof VerticalCrossAxisAlignment)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.vertical, ((VerticalCrossAxisAlignment)arg4).vertical)) {
                return 0;
            }

            return 1;
        }

        public final Vertical getVertical() {
            return this.vertical;
        }

        public int hashCode() {
            return this.vertical.hashCode();
        }

        public String toString() {
            return "VerticalCrossAxisAlignment(vertical=" + this.vertical + ')';
        }
    }

    public static final int $stable;
    public static final Companion Companion;

    static {
        CrossAxisAlignment.Companion = new Companion(null);
    }

    private CrossAxisAlignment() {
        super();
    }

    public CrossAxisAlignment(DefaultConstructorMarker arg1) {
        this();
    }

    public abstract int align$foundation_layout(int arg1, int arg2, LayoutDirection arg3, Placeable arg4, int arg5);

    public Integer calculateAlignmentLinePosition$foundation_layout(Placeable arg1) {
        return null;
    }

    public boolean isRelative$foundation_layout() {
        return 0;
    }
}

