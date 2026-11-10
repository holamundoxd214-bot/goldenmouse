package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001*B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0019\u0010\fJ\u0010\u0010\u001A\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001B\u0010\fJ\u0010\u0010\u001C\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001D\u0010\fJ\u0010\u0010\u001E\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001F\u0010\fJ\t\u0010 \u001A\u00020\bHÆ\u0003JB\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001A\u00020\b2\b\u0010%\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001A\u00020\'HÖ\u0001J\t\u0010(\u001A\u00020)HÖ\u0001R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000E\u0010\fR\u0013\u0010\u0005\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000F\u0010\fR\u0013\u0010\u0006\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\u0011¨\u0006+"}, d2={"Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "isLayoutDirectionAware", "", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-D9Ej5fM", "()F", "F", "getTop-D9Ej5fM", "getEnd-D9Ej5fM", "getBottom-D9Ej5fM", "()Z", "roundToTouchBoundsExpansion", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "density", "Landroidx/compose/ui/unit/Density;", "roundToTouchBoundsExpansion-TW6G1oQ", "(Landroidx/compose/ui/unit/Density;)J", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component4-D9Ej5fM", "component5", "copy", "copy-lDy3nrA", "(FFFFZ)Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "equals", "other", "hashCode", "", "toString", "", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DpTouchBoundsExpansion {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u0007¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Landroidx/compose/ui/node/DpTouchBoundsExpansion$Companion;", "", "<init>", "()V", "Absolute", "Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "Absolute-a9UjIt4", "(FFFF)Landroidx/compose/ui/node/DpTouchBoundsExpansion;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final DpTouchBoundsExpansion Absolute-a9UjIt4(float arg8, float arg9, float arg10, float arg11) {
            return new DpTouchBoundsExpansion(arg8, arg9, arg10, arg11, false, null);
        }

        public static DpTouchBoundsExpansion Absolute-a9UjIt4$default(Companion arg1, float arg2, float arg3, float arg4, float arg5, int arg6, Object arg7) {
            if((arg6 & 1) != 0) {
                arg2 = Dp.constructor-impl(0f);
            }

            if((arg6 & 2) != 0) {
                arg3 = Dp.constructor-impl(0f);
            }

            if((arg6 & 4) != 0) {
                arg4 = Dp.constructor-impl(0f);
            }

            if((arg6 & 8) != 0) {
                arg5 = Dp.constructor-impl(0f);
            }

            return arg1.Absolute-a9UjIt4(arg2, arg3, arg4, arg5);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final float bottom;
    private final float end;
    private final boolean isLayoutDirectionAware;
    private final float start;
    private final float top;

    static {
        DpTouchBoundsExpansion.Companion = new Companion(null);
    }

    private DpTouchBoundsExpansion(float arg2, float arg3, float arg4, float arg5, boolean arg6) {
        super();
        this.start = arg2;
        this.top = arg3;
        this.end = arg4;
        this.bottom = arg5;
        this.isLayoutDirectionAware = arg6;
        int v6 = 1;
        int v2 = Float.compare(arg2, 0f) >= 0 ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Left must be non-negative");
        }

        v2 = arg3 >= 0f ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Top must be non-negative");
        }

        v2 = arg4 >= 0f ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Right must be non-negative");
        }

        if(arg5 >= 0f) {
        }
        else {
            v6 = 0;
        }

        if(v6 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Bottom must be non-negative");
        }
    }

    public DpTouchBoundsExpansion(float arg1, float arg2, float arg3, float arg4, boolean arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    public final float component1-D9Ej5fM() {
        return this.start;
    }

    public final float component2-D9Ej5fM() {
        return this.top;
    }

    public final float component3-D9Ej5fM() {
        return this.end;
    }

    public final float component4-D9Ej5fM() {
        return this.bottom;
    }

    public final boolean component5() {
        return this.isLayoutDirectionAware;
    }

    public final DpTouchBoundsExpansion copy-lDy3nrA(float arg8, float arg9, float arg10, float arg11, boolean arg12) {
        return new DpTouchBoundsExpansion(arg8, arg9, arg10, arg11, arg12, null);
    }

    public static DpTouchBoundsExpansion copy-lDy3nrA$default(DpTouchBoundsExpansion arg0, float arg1, float arg2, float arg3, float arg4, boolean arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.start;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.top;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.end;
        }

        if((arg6 & 8) != 0) {
            arg4 = arg0.bottom;
        }

        if((arg6 & 16) != 0) {
            arg5 = arg0.isLayoutDirectionAware;
        }

        return arg0.copy-lDy3nrA(arg1, arg2, arg3, arg4, arg5);
    }

    public boolean equals(Object arg5) {
        if(this == (((DpTouchBoundsExpansion)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DpTouchBoundsExpansion)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.start, ((DpTouchBoundsExpansion)arg5).start)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.top, ((DpTouchBoundsExpansion)arg5).top)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.end, ((DpTouchBoundsExpansion)arg5).end)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.bottom, ((DpTouchBoundsExpansion)arg5).bottom)) {
            return 0;
        }

        if(this.isLayoutDirectionAware != ((DpTouchBoundsExpansion)arg5).isLayoutDirectionAware) {
            return 0;
        }

        return 1;
    }

    public final float getBottom-D9Ej5fM() {
        return this.bottom;
    }

    public final float getEnd-D9Ej5fM() {
        return this.end;
    }

    public final float getStart-D9Ej5fM() {
        return this.start;
    }

    public final float getTop-D9Ej5fM() {
        return this.top;
    }

    public int hashCode() {
        return (((Dp.hashCode-impl(this.start) * 0x1F + Dp.hashCode-impl(this.top)) * 0x1F + Dp.hashCode-impl(this.end)) * 0x1F + Dp.hashCode-impl(this.bottom)) * 0x1F + Boolean.hashCode(this.isLayoutDirectionAware);
    }

    public final boolean isLayoutDirectionAware() {
        return this.isLayoutDirectionAware;
    }

    public final long roundToTouchBoundsExpansion-TW6G1oQ(Density arg7) {
        return TouchBoundsExpansion.constructor-impl(TouchBoundsExpansion.Companion.pack$ui(arg7.roundToPx-0680j_4(this.start), arg7.roundToPx-0680j_4(this.top), arg7.roundToPx-0680j_4(this.end), arg7.roundToPx-0680j_4(this.bottom), this.isLayoutDirectionAware));
    }

    public String toString() {
        return "DpTouchBoundsExpansion(start=" + Dp.toString-impl(this.start) + ", top=" + Dp.toString-impl(this.top) + ", end=" + Dp.toString-impl(this.end) + ", bottom=" + Dp.toString-impl(this.bottom) + ", isLayoutDirectionAware=" + this.isLayoutDirectionAware + ')';
    }
}

