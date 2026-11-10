package androidx.compose.material3.internal;

import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007J\u0010\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007J\u0010\u0010\t\u001A\u00020\u00052\b\b\u0002\u0010\n\u001A\u00020\u0007J\u0010\u0010\u000B\u001A\u00020\u00052\b\b\u0002\u0010\n\u001A\u00020\u0007J\u0010\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u0006\u001A\u00020\u0007J\u0010\u0010\u000E\u001A\u00020\r2\b\b\u0002\u0010\u0006\u001A\u00020\u0007J\u0010\u0010\u000F\u001A\u00020\r2\b\b\u0002\u0010\u0006\u001A\u00020\u0007J\u0010\u0010\u0010\u001A\u00020\r2\b\b\u0002\u0010\n\u001A\u00020\u0007J\u0010\u0010\u0011\u001A\u00020\r2\b\b\u0002\u0010\n\u001A\u00020\u0007¨\u0006\u0014"}, d2={"Landroidx/compose/material3/internal/MenuPosition;", "", "<init>", "()V", "startToAnchorStart", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "offset", "", "endToAnchorEnd", "leftToWindowLeft", "margin", "rightToWindowRight", "topToAnchorBottom", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToAnchorTop", "centerToAnchorTop", "topToWindowTop", "bottomToWindowBottom", "Vertical", "Horizontal", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MenuPosition {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bç\u0080\u0001\u0018\u00002\u00020\u0001J/\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\nH&¢\u0006\u0004\b\u000B\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2={"Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "", "position", "", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "position-95KtPRI", "(Landroidx/compose/ui/unit/IntRect;JILandroidx/compose/ui/unit/LayoutDirection;)I", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Horizontal {
        int position-95KtPRI(IntRect arg1, long arg2, int arg3, LayoutDirection arg4);
    }

    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bç\u0080\u0001\u0018\u00002\u00020\u0001J\'\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0003H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/compose/material3/internal/MenuPosition$Vertical;", "", "position", "", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuHeight", "position-JVtK1S4", "(Landroidx/compose/ui/unit/IntRect;JI)I", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Vertical {
        int position-JVtK1S4(IntRect arg1, long arg2, int arg3);
    }

    public static final int $stable;
    public static final MenuPosition INSTANCE;

    static {
        MenuPosition.INSTANCE = new MenuPosition();
    }

    private MenuPosition() {
        super();
    }

    public final Vertical bottomToAnchorTop(int arg3) {
        return new androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical(Alignment.Companion.getBottom(), Alignment.Companion.getTop(), arg3);
    }

    public static Vertical bottomToAnchorTop$default(MenuPosition arg0, int arg1, int arg2, Object arg3) {
        return arg0.bottomToAnchorTop(0);
    }

    public final Vertical bottomToWindowBottom(int arg2) {
        return new androidx.compose.material3.internal.WindowAlignmentMarginPosition$Vertical(Alignment.Companion.getBottom(), arg2);
    }

    public static Vertical bottomToWindowBottom$default(MenuPosition arg0, int arg1, int arg2, Object arg3) {
        return arg0.bottomToWindowBottom(0);
    }

    public final Vertical centerToAnchorTop(int arg3) {
        return new androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical(Alignment.Companion.getCenterVertically(), Alignment.Companion.getTop(), arg3);
    }

    public static Vertical centerToAnchorTop$default(MenuPosition arg0, int arg1, int arg2, Object arg3) {
        return arg0.centerToAnchorTop(0);
    }

    public final Horizontal endToAnchorEnd(int arg3) {
        return new androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal(Alignment.Companion.getEnd(), Alignment.Companion.getEnd(), arg3);
    }

    public static Horizontal endToAnchorEnd$default(MenuPosition arg0, int arg1, int arg2, Object arg3) {
        return arg0.endToAnchorEnd(0);
    }

    public final Horizontal leftToWindowLeft(int arg2) {
        return new androidx.compose.material3.internal.WindowAlignmentMarginPosition$Horizontal(AbsoluteAlignment.INSTANCE.getLeft(), arg2);
    }

    public static Horizontal leftToWindowLeft$default(MenuPosition arg0, int arg1, int arg2, Object arg3) {
        return arg0.leftToWindowLeft(0);
    }

    public final Horizontal rightToWindowRight(int arg2) {
        return new androidx.compose.material3.internal.WindowAlignmentMarginPosition$Horizontal(AbsoluteAlignment.INSTANCE.getRight(), arg2);
    }

    public static Horizontal rightToWindowRight$default(MenuPosition arg0, int arg1, int arg2, Object arg3) {
        return arg0.rightToWindowRight(0);
    }

    public final Horizontal startToAnchorStart(int arg3) {
        return new androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Horizontal(Alignment.Companion.getStart(), Alignment.Companion.getStart(), arg3);
    }

    public static Horizontal startToAnchorStart$default(MenuPosition arg0, int arg1, int arg2, Object arg3) {
        return arg0.startToAnchorStart(0);
    }

    public final Vertical topToAnchorBottom(int arg3) {
        return new androidx.compose.material3.internal.AnchorAlignmentOffsetPosition$Vertical(Alignment.Companion.getTop(), Alignment.Companion.getBottom(), arg3);
    }

    public static Vertical topToAnchorBottom$default(MenuPosition arg0, int arg1, int arg2, Object arg3) {
        return arg0.topToAnchorBottom(0);
    }

    public final Vertical topToWindowTop(int arg2) {
        return new androidx.compose.material3.internal.WindowAlignmentMarginPosition$Vertical(Alignment.Companion.getTop(), arg2);
    }

    public static Vertical topToWindowTop$default(MenuPosition arg0, int arg1, int arg2, Object arg3) {
        return arg0.topToWindowTop(0);
    }
}

