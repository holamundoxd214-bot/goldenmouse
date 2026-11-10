package com.TryJeanPc.goldenmouse.macro.editor;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u0011J\u000E\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0003J\u001E\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0016\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u0003R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\u0007\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0003@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\t\"\u0004\b\f\u0010\u0005R\u0011\u0010\r\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\t¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/editor/MacroTimelineScale;", "", "density", "", "<init>", "(F)V", "value", "zoom", "getZoom", "()F", "offsetPx", "getOffsetPx", "setOffsetPx", "pixelsPerMs", "getPixelsPerMs", "toPixel", "timeMs", "", "toTime", "pixel", "setZoom", "", "selectedTime", "viewportWidth", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroTimelineScale {
    public static final int $stable = 8;
    private final float density;
    private float offsetPx;
    private float zoom;

    static {
    }

    public MacroTimelineScale() {
        this(0f, 1, null);
    }

    public MacroTimelineScale(float arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = 1f;
        }

        this(arg1);
    }

    public MacroTimelineScale(float arg1) {
        super();
        this.density = arg1;
        this.zoom = 5f;
    }

    public final float getOffsetPx() {
        return this.offsetPx;
    }

    public final float getPixelsPerMs() {
        return this.density * 0.36f * this.zoom;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setOffsetPx(float arg1) {
        this.offsetPx = arg1;
    }

    public final void setZoom(float arg4, long arg5, float arg7) {
        float v0 = this.toPixel(arg5);
        if(0f > v0 || v0 > arg7) {
            v0 = arg7 / 2f;
        }
        else {
        }

        this.zoom = RangesKt.coerceIn(arg4, 1f, 10f);
        this.offsetPx = RangesKt.coerceAtLeast((((float)arg5)) * this.getPixelsPerMs() - v0, 0f);
    }

    public final float toPixel(long arg1) {
        return (((float)arg1)) * this.getPixelsPerMs() - this.offsetPx;
    }

    public final long toTime(float arg7) {
        return RangesKt.coerceIn(((long)((arg7 + this.offsetPx) / this.getPixelsPerMs())), 0, 0x5265BFF);
    }
}

