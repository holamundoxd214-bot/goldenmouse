package androidx.compose.material3;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001D\u0010\u0017\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001A\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u001B\u0010\u001CJ%\u0010\u001D\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u001E\u0010\u001CJ%\u0010\u001F\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b \u0010\u001CJ-\u0010!\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\"\u0010#J-\u0010$\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b%\u0010#R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\t¨\u0006&"}, d2={"Landroidx/compose/material3/TooltipPositionProviderImpl;", "Landroidx/compose/ui/window/PopupPositionProvider;", "type", "Landroidx/compose/material3/TooltipAnchorPosition;", "tooltipAnchorSpacing", "", "<init>", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getType-lOKsHw4", "()I", "I", "getTooltipAnchorSpacing", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "leftPositioning", "leftPositioning-oFUgxo0", "(Landroidx/compose/ui/unit/IntRect;J)J", "rightPositioning", "rightPositioning-uHY26d4", "(Landroidx/compose/ui/unit/IntRect;JJ)J", "abovePositioning", "abovePositioning-uHY26d4", "belowPositioning", "belowPositioning-uHY26d4", "startPositioning", "startPositioning-_JLpSYE", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/IntRect;JJ)J", "endPositioning", "endPositioning-_JLpSYE", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class TooltipPositionProviderImpl implements PopupPositionProvider {
    private final int tooltipAnchorSpacing;
    private final int type;

    public TooltipPositionProviderImpl(int arg1, int arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    private TooltipPositionProviderImpl(int arg1, int arg2) {
        super();
        this.type = arg1;
        this.tooltipAnchorSpacing = arg2;
    }

    public final long abovePositioning-uHY26d4(IntRect arg6, long arg7, long arg9) {
        int v2 = 0x20;
        int v3 = ((int)(arg7 >> v2));
        int v0 = arg6.getLeft() + (arg6.getWidth() - v3) / 2;
        if(v0 < 0) {
            v0 = arg6.getLeft();
        }
        else if(v0 + v3 > (((int)(arg9 >> v2)))) {
            v0 = arg6.getRight() - v3;
        }

        long v3_1 = 0xFFFFFFFFL;
        int v9 = arg6.getTop() - (((int)(arg7 & v3_1))) - this.tooltipAnchorSpacing;
        if(v9 < 0) {
            v9 = arg6.getBottom() + this.tooltipAnchorSpacing;
        }

        return IntOffset.constructor-impl((((long)v0)) << v2 | (((long)v9)) & v3_1);
    }

    public final long belowPositioning-uHY26d4(IntRect arg7, long arg8, long arg10) {
        int v2 = 0x20;
        int v3 = ((int)(arg8 >> v2));
        int v0 = arg7.getLeft() + (arg7.getWidth() - v3) / 2;
        if(v0 < 0) {
            v0 = arg7.getLeft();
        }
        else if(v0 + v3 > (((int)(arg10 >> v2)))) {
            v0 = arg7.getRight() - v3;
        }

        int v1 = arg7.getBottom() + this.tooltipAnchorSpacing;
        long v3_1 = 0xFFFFFFFFL;
        int v8 = ((int)(arg8 & v3_1));
        if(v1 + v8 > (((int)(arg10 & v3_1)))) {
            v1 = arg7.getTop() - v8 - this.tooltipAnchorSpacing;
        }

        return IntOffset.constructor-impl((((long)v0)) << v2 | (((long)v1)) & v3_1);
    }

    public long calculatePosition-llwVHH4(IntRect arg9, long arg10, LayoutDirection arg12, long arg13) {
        int v0 = this.type;
        if(TooltipAnchorPosition.equals-impl0(v0, TooltipAnchorPosition.Companion.getLeft-lOKsHw4())) {
            return this.leftPositioning-oFUgxo0(arg9, arg13);
        }

        if(TooltipAnchorPosition.equals-impl0(v0, TooltipAnchorPosition.Companion.getRight-lOKsHw4())) {
            return this.rightPositioning-uHY26d4(arg9, arg13, arg10);
        }

        IntRect v3 = arg9;
        long v6 = arg10;
        long v4 = arg13;
        if(TooltipAnchorPosition.equals-impl0(v0, TooltipAnchorPosition.Companion.getAbove-lOKsHw4())) {
            return this.abovePositioning-uHY26d4(v3, v4, v6);
        }

        if(TooltipAnchorPosition.equals-impl0(v0, TooltipAnchorPosition.Companion.getBelow-lOKsHw4())) {
            return this.belowPositioning-uHY26d4(v3, v4, v6);
        }

        if(TooltipAnchorPosition.equals-impl0(v0, TooltipAnchorPosition.Companion.getStart-lOKsHw4())) {
            return this.startPositioning-_JLpSYE(arg12, v3, v4, v6);
        }

        LayoutDirection v9 = arg12;
        if(TooltipAnchorPosition.equals-impl0(v0, TooltipAnchorPosition.Companion.getEnd-lOKsHw4())) {
            return this.endPositioning-_JLpSYE(v9, v3, v4, v6);
        }

        return this.abovePositioning-uHY26d4(v3, v4, v6);
    }

    public final long endPositioning-_JLpSYE(LayoutDirection arg2, IntRect arg3, long arg4, long arg6) {
        if(arg2 == LayoutDirection.Ltr) {
            return this.rightPositioning-uHY26d4(arg3, arg4, arg6);
        }

        return this.leftPositioning-oFUgxo0(arg3, arg4);
    }

    public final int getTooltipAnchorSpacing() {
        return this.tooltipAnchorSpacing;
    }

    public final int getType-lOKsHw4() {
        return this.type;
    }

    public final long leftPositioning-oFUgxo0(IntRect arg5, long arg6) {
        int v1 = 0x20;
        int v0 = arg5.getLeft() - ((((int)(arg6 >> v1))) + this.tooltipAnchorSpacing);
        if(v0 < 0) {
            v0 = arg5.getRight() + this.tooltipAnchorSpacing;
        }

        return IntOffset.constructor-impl((((long)v0)) << v1 | (((long)((arg5.getTop() + arg5.getBottom() - (((int)(arg6 & 0xFFFFFFFFL)))) / 2))) & 0xFFFFFFFFL);
    }

    public final long rightPositioning-uHY26d4(IntRect arg5, long arg6, long arg8) {
        int v0 = arg5.getRight() + this.tooltipAnchorSpacing;
        int v1 = 0x20;
        int v2 = ((int)(arg6 >> v1));
        if(v0 + v2 > (((int)(arg8 >> v1)))) {
            v0 = arg5.getLeft() - (v2 + this.tooltipAnchorSpacing);
        }

        return IntOffset.constructor-impl((((long)v0)) << v1 | (((long)((arg5.getTop() + arg5.getBottom() - (((int)(arg6 & 0xFFFFFFFFL)))) / 2))) & 0xFFFFFFFFL);
    }

    public final long startPositioning-_JLpSYE(LayoutDirection arg7, IntRect arg8, long arg9, long arg11) {
        if(arg7 == LayoutDirection.Ltr) {
            return this.leftPositioning-oFUgxo0(arg8, arg9);
        }

        return this.rightPositioning-uHY26d4(arg8, arg9, arg11);
    }
}

