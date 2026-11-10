package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0005H\u0016J\u0010\u0010\u000E\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u0005H\u0016J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0016J%\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0016\u001A\u00020\fH\u0010¢\u0006\u0002\b\u0017J%\u0010\u0018\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0016\u001A\u00020\fH\u0010¢\u0006\u0002\b\u0019J7\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\f2\u0006\u0010\u001D\u001A\u00020\f2\u0006\u0010\u001E\u001A\u00020\f2\u0006\u0010\u001F\u001A\u00020\f2\u0006\u0010 \u001A\u00020\u0001H\u0010¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0016J\u0011\u0010$\u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\fH\u0082\bR\u0014\u0010\b\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\n¨\u0006%"}, d2={"Landroidx/compose/ui/graphics/colorspace/Xyz;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "<init>", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "getMinValue", "", "component", "getMaxValue", "toXyz", "", "v", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics", "toZ", "toZ$ui_graphics", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "fromXyz", "clamp", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Xyz extends ColorSpace {
    public static final int $stable;

    static {
    }

    public Xyz(String arg8, int arg9) {
        super(arg8, ColorModel.Companion.getXyz-xdoWZVw(), arg9, null);
    }

    private final float clamp(float arg2) {
        float v1 = -2f;
        if(arg2 < v1) {
            arg2 = v1;
        }

        v1 = 2f;
        if(arg2 > v1) {
            return v1;
        }

        return arg2;
    }

    public float[] fromXyz(float[] arg5) {
        float v0 = arg5[0];
        float v1 = -2f;
        if(v0 < v1) {
            v0 = v1;
        }

        float v2 = 2f;
        if(v0 > v2) {
            v0 = v2;
        }

        arg5[0] = v0;
        v0 = arg5[1];
        if(v0 < v1) {
            v0 = v1;
        }

        if(v0 > v2) {
            v0 = v2;
        }

        arg5[1] = v0;
        int v4 = 2;
        v0 = arg5[v4];
        if(v0 < v1) {
        }
        else {
            v1 = v0;
        }

        if(v1 > v2) {
        }
        else {
            v2 = v1;
        }

        arg5[v4] = v2;
        return arg5;
    }

    public float getMaxValue(int arg1) {
        return 2f;
    }

    public float getMinValue(int arg1) {
        return -2f;
    }

    public boolean isWideGamut() {
        return 1;
    }

    public long toXy$ui_graphics(float arg3, float arg4, float arg5) {
        float v2 = -2f;
        if(arg3 < v2) {
            arg3 = v2;
        }

        arg5 = 2f;
        if(arg3 > arg5) {
            arg3 = arg5;
        }

        if(arg4 < v2) {
            arg4 = v2;
        }

        if(arg4 > arg5) {
        }
        else {
            arg5 = arg4;
        }

        return (((long)Float.floatToRawIntBits(arg3))) << 0x20 | (((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL;
    }

    public float[] toXyz(float[] arg5) {
        float v0 = arg5[0];
        float v1 = -2f;
        if(v0 < v1) {
            v0 = v1;
        }

        float v2 = 2f;
        if(v0 > v2) {
            v0 = v2;
        }

        arg5[0] = v0;
        v0 = arg5[1];
        if(v0 < v1) {
            v0 = v1;
        }

        if(v0 > v2) {
            v0 = v2;
        }

        arg5[1] = v0;
        int v4 = 2;
        v0 = arg5[v4];
        if(v0 < v1) {
        }
        else {
            v1 = v0;
        }

        if(v1 > v2) {
        }
        else {
            v2 = v1;
        }

        arg5[v4] = v2;
        return arg5;
    }

    public float toZ$ui_graphics(float arg1, float arg2, float arg3) {
        float v0 = -2f;
        if(arg3 < v0) {
            arg3 = v0;
        }

        v0 = 2f;
        if(arg3 > v0) {
            return v0;
        }

        return arg3;
    }

    public long xyzaToColor-JlNiLsg$ui_graphics(float arg3, float arg4, float arg5, float arg6, ColorSpace arg7) {
        float v2 = -2f;
        if(arg3 < v2) {
            arg3 = v2;
        }

        float v0 = 2f;
        if(arg3 > v0) {
            arg3 = v0;
        }

        if(arg4 < v2) {
            arg4 = v2;
        }

        if(arg4 > v0) {
            arg4 = v0;
        }

        if(arg5 < v2) {
            arg5 = v2;
        }

        if(arg5 > v0) {
        }
        else {
            v0 = arg5;
        }

        return ColorKt.Color(arg3, arg4, v0, arg6, arg7);
    }
}

