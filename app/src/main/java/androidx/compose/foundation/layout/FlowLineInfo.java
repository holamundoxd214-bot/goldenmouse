package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0000¢\u0006\u0004\b\u0019\u0010\u001AR\u001A\u0010\u0002\u001A\u00020\u0003X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001A\u0010\u0004\u001A\u00020\u0003X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000B\"\u0004\b\u000F\u0010\rR\u001C\u0010\u0005\u001A\u00020\u0006X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u0014\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001C\u0010\u0007\u001A\u00020\u0006X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u0014\u001A\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/layout/FlowLineInfo;", "", "lineIndex", "", "positionInLine", "maxMainAxisSize", "Landroidx/compose/ui/unit/Dp;", "maxCrossAxisSize", "<init>", "(IIFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLineIndex$foundation_layout", "()I", "setLineIndex$foundation_layout", "(I)V", "getPositionInLine$foundation_layout", "setPositionInLine$foundation_layout", "getMaxMainAxisSize-D9Ej5fM$foundation_layout", "()F", "setMaxMainAxisSize-0680j_4$foundation_layout", "(F)V", "F", "getMaxCrossAxisSize-D9Ej5fM$foundation_layout", "setMaxCrossAxisSize-0680j_4$foundation_layout", "update", "", "update-4j6BHR0$foundation_layout", "(IIFF)V", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FlowLineInfo {
    public static final int $stable = 8;
    private int lineIndex;
    private float maxCrossAxisSize;
    private float maxMainAxisSize;
    private int positionInLine;

    static {
    }

    public FlowLineInfo(int arg2, int arg3, float arg4, float arg5, int arg6, DefaultConstructorMarker arg7) {
        if((arg6 & 4) != 0) {
            arg4 = Dp.constructor-impl(0f);
        }

        if((arg6 & 8) != 0) {
            arg5 = Dp.constructor-impl(0f);
        }

        this(0, 0, arg4, arg5, null);
    }

    public FlowLineInfo(int arg1, int arg2, float arg3, float arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    private FlowLineInfo(int arg1, int arg2, float arg3, float arg4) {
        super();
        this.lineIndex = arg1;
        this.positionInLine = arg2;
        this.maxMainAxisSize = arg3;
        this.maxCrossAxisSize = arg4;
    }

    public final int getLineIndex$foundation_layout() {
        return this.lineIndex;
    }

    public final float getMaxCrossAxisSize-D9Ej5fM$foundation_layout() {
        return this.maxCrossAxisSize;
    }

    public final float getMaxMainAxisSize-D9Ej5fM$foundation_layout() {
        return this.maxMainAxisSize;
    }

    public final int getPositionInLine$foundation_layout() {
        return this.positionInLine;
    }

    public final void setLineIndex$foundation_layout(int arg1) {
        this.lineIndex = arg1;
    }

    public final void setMaxCrossAxisSize-0680j_4$foundation_layout(float arg1) {
        this.maxCrossAxisSize = arg1;
    }

    public final void setMaxMainAxisSize-0680j_4$foundation_layout(float arg1) {
        this.maxMainAxisSize = arg1;
    }

    public final void setPositionInLine$foundation_layout(int arg1) {
        this.positionInLine = arg1;
    }

    public final void update-4j6BHR0$foundation_layout(int arg1, int arg2, float arg3, float arg4) {
        this.lineIndex = arg1;
        this.positionInLine = arg2;
        this.maxMainAxisSize = arg3;
        this.maxCrossAxisSize = arg4;
    }
}

