package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\fJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J.\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\n¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/gestures/AnimationData;", "", "zoom", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "degrees", "<init>", "(FJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getZoom", "()F", "getOffset-F1C5BW0", "()J", "J", "getDegrees", "component1", "component2", "component2-F1C5BW0", "component3", "copy", "copy-d-4ec7I", "(FJF)Landroidx/compose/foundation/gestures/AnimationData;", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AnimationData {
    private final float degrees;
    private final long offset;
    private final float zoom;

    private AnimationData(float arg1, long arg2, float arg4) {
        super();
        this.zoom = arg1;
        this.offset = arg2;
        this.degrees = arg4;
    }

    public AnimationData(float arg1, long arg2, float arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg4);
    }

    public final float component1() {
        return this.zoom;
    }

    public final long component2-F1C5BW0() {
        return this.offset;
    }

    public final float component3() {
        return this.degrees;
    }

    public final AnimationData copy-d-4ec7I(float arg7, long arg8, float arg10) {
        return new AnimationData(arg7, arg8, arg10, null);
    }

    public static AnimationData copy-d-4ec7I$default(AnimationData arg0, float arg1, long arg2, float arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.zoom;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.offset;
        }

        if((arg5 & 4) != 0) {
            arg4 = arg0.degrees;
        }

        return arg0.copy-d-4ec7I(arg1, arg2, arg4);
    }

    public boolean equals(Object arg8) {
        if(this == (((AnimationData)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof AnimationData)) {
            return 0;
        }

        if(Float.compare(this.zoom, ((AnimationData)arg8).zoom) != 0) {
            return 0;
        }

        if(!Offset.equals-impl0(this.offset, ((AnimationData)arg8).offset)) {
            return 0;
        }

        if(Float.compare(this.degrees, ((AnimationData)arg8).degrees) != 0) {
            return 0;
        }

        return 1;
    }

    public final float getDegrees() {
        return this.degrees;
    }

    public final long getOffset-F1C5BW0() {
        return this.offset;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public int hashCode() {
        return (Float.hashCode(this.zoom) * 0x1F + Offset.hashCode-impl(this.offset)) * 0x1F + Float.hashCode(this.degrees);
    }

    public String toString() {
        return "AnimationData(zoom=" + this.zoom + ", offset=" + Offset.toString-impl(this.offset) + ", degrees=" + this.degrees + ')';
    }
}

