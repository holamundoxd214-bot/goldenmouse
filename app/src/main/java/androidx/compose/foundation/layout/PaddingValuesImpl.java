package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u001A\u0010\fJ\u0017\u0010\u001B\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u001C\u0010\u0018J\u000F\u0010\u001D\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u001E\u0010\fJ\u0013\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001A\u00020$H\u0016J\b\u0010%\u001A\u00020&H\u0016R\u001E\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\fR\u001E\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\u000E\u0010\n\u001A\u0004\b\u000F\u0010\fR\u001E\u0010\u0005\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\u0010\u0010\n\u001A\u0004\b\u0011\u0010\fR\u001E\u0010\u0006\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\r\u0012\u0004\b\u0012\u0010\n\u001A\u0004\b\u0013\u0010\f¨\u0006\'"}, d2={"Landroidx/compose/foundation/layout/PaddingValuesImpl;", "Landroidx/compose/foundation/layout/PaddingValues;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-D9Ej5fM$annotations", "()V", "getStart-D9Ej5fM", "()F", "F", "getTop-D9Ej5fM$annotations", "getTop-D9Ej5fM", "getEnd-D9Ej5fM$annotations", "getEnd-D9Ej5fM", "getBottom-D9Ej5fM$annotations", "getBottom-D9Ej5fM", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PaddingValuesImpl implements PaddingValues {
    public static final int $stable;
    private final float bottom;
    private final float end;
    private final float start;
    private final float top;

    static {
    }

    public PaddingValuesImpl(float arg1, float arg2, float arg3, float arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    private PaddingValuesImpl(float arg3, float arg4, float arg5, float arg6) {
        super();
        this.start = arg3;
        this.top = arg4;
        this.end = arg5;
        this.bottom = arg6;
        int v0 = 1;
        int v3 = Float.compare(arg3, 0f) >= 0 ? 1 : 0;
        int v4 = arg4 >= 0f ? 1 : 0;
        v3 &= v4;
        v4 = arg5 >= 0f ? 1 : 0;
        v3 &= v4;
        if(arg6 >= 0f) {
        }
        else {
            v0 = 0;
        }

        if((v3 & v0) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
    }

    public PaddingValuesImpl(float arg8, float arg9, float arg10, float arg11, int arg12, DefaultConstructorMarker arg13) {
        if((arg12 & 1) != 0) {
            arg8 = Dp.constructor-impl(0f);
        }

        float v2 = arg8;
        if((arg12 & 2) != 0) {
            arg9 = Dp.constructor-impl(0f);
        }

        float v3 = arg9;
        if((arg12 & 4) != 0) {
            arg10 = Dp.constructor-impl(0f);
        }

        float v4 = arg10;
        if((arg12 & 8) != 0) {
            arg11 = Dp.constructor-impl(0f);
        }

        this(v2, v3, v4, arg11, null);
    }

    public float calculateBottomPadding-D9Ej5fM() {
        return this.bottom;
    }

    public float calculateLeftPadding-u2uoSUM(LayoutDirection arg2) {
        if(arg2 == LayoutDirection.Ltr) {
            return this.start;
        }

        return this.end;
    }

    public float calculateRightPadding-u2uoSUM(LayoutDirection arg2) {
        if(arg2 == LayoutDirection.Ltr) {
            return this.end;
        }

        return this.start;
    }

    public float calculateTopPadding-D9Ej5fM() {
        return this.top;
    }

    public boolean equals(Object arg4) {
        if(!(arg4 instanceof PaddingValuesImpl)) {
            return 0;
        }

        if((Dp.equals-impl0(this.start, ((PaddingValuesImpl)arg4).start)) && (Dp.equals-impl0(this.top, ((PaddingValuesImpl)arg4).top)) && (Dp.equals-impl0(this.end, ((PaddingValuesImpl)arg4).end)) && (Dp.equals-impl0(this.bottom, ((PaddingValuesImpl)arg4).bottom))) {
            return 1;
        }

        return 0;
    }

    public final float getBottom-D9Ej5fM() {
        return this.bottom;
    }

    public static void getBottom-D9Ej5fM$annotations() {
    }

    public final float getEnd-D9Ej5fM() {
        return this.end;
    }

    public static void getEnd-D9Ej5fM$annotations() {
    }

    public final float getStart-D9Ej5fM() {
        return this.start;
    }

    public static void getStart-D9Ej5fM$annotations() {
    }

    public final float getTop-D9Ej5fM() {
        return this.top;
    }

    public static void getTop-D9Ej5fM$annotations() {
    }

    public int hashCode() {
        return ((Dp.hashCode-impl(this.start) * 0x1F + Dp.hashCode-impl(this.top)) * 0x1F + Dp.hashCode-impl(this.end)) * 0x1F + Dp.hashCode-impl(this.bottom);
    }

    public String toString() {
        return "PaddingValues(start=" + Dp.toString-impl(this.start) + ", top=" + Dp.toString-impl(this.top) + ", end=" + Dp.toString-impl(this.end) + ", bottom=" + Dp.toString-impl(this.bottom) + ')';
    }
}

