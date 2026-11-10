package androidx.compose.ui.window;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000B¨\u0006\u0017"}, d2={"Landroidx/compose/ui/window/AlignmentOffsetPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "<init>", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getOffset-nOcc-ac", "()J", "J", "calculatePosition", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AlignmentOffsetPositionProvider implements PopupPositionProvider {
    public static final int $stable;
    private final Alignment alignment;
    private final long offset;

    static {
    }

    private AlignmentOffsetPositionProvider(Alignment arg1, long arg2) {
        super();
        this.alignment = arg1;
        this.offset = arg2;
    }

    public AlignmentOffsetPositionProvider(Alignment arg1, long arg2, DefaultConstructorMarker arg4) {
        this(arg1, arg2);
    }

    public long calculatePosition-llwVHH4(IntRect arg7, long arg8, LayoutDirection arg10, long arg11) {
        LayoutDirection v5 = arg10;
        arg8 = this.alignment.align-KFBX0sM(IntSize.Companion.getZero-YbymL2g(), arg7.getSize-YbymL2g(), v5);
        long v10 = IntOffset.unaryMinus-nOcc-ac(this.alignment.align-KFBX0sM(IntSize.Companion.getZero-YbymL2g(), arg11, v5));
        int v12 = IntOffset.getX-impl(this.offset);
        int v0 = v5 == LayoutDirection.Ltr ? 1 : -1;
        return IntOffset.plus-qkQi6aY(IntOffset.plus-qkQi6aY(IntOffset.plus-qkQi6aY(arg7.getTopLeft-nOcc-ac(), arg8), v10), IntOffset.constructor-impl((((long)(v12 * v0))) << 0x20 | (((long)IntOffset.getY-impl(this.offset))) & 0xFFFFFFFFL));
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final long getOffset-nOcc-ac() {
        return this.offset;
    }
}

