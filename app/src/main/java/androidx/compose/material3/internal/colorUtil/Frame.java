package androidx.compose.material3.internal.colorUtil;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0013\b\u0001\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CBY\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u0012\u0006\u0010\f\u001A\u00020\u0003\u0012\u0006\u0010\r\u001A\u00020\u0003¢\u0006\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0002\u001A\u00020\u00038G¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001A\u00020\u00038G¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001A\u00020\u00038G¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001A\u00020\n8G¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000B\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0011R\u0013\u0010\f\u001A\u00020\u00038G¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0011R\u0011\u0010\r\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0011¨\u0006\u001D"}, d2={"Landroidx/compose/material3/internal/colorUtil/Frame;", "", "n", "", "aw", "nbb", "ncb", "c", "nc", "rgbD", "", "fl", "flRoot", "z", "<init>", "(FFFFFF[FFFF)V", "getN", "()F", "getAw", "getNbb", "getNcb", "getC", "getNc", "getRgbD", "()[F", "getFl", "getFlRoot", "getZ", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Frame {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0010R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2={"Landroidx/compose/material3/internal/colorUtil/Frame$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/material3/internal/colorUtil/Frame;", "getDefault", "()Landroidx/compose/material3/internal/colorUtil/Frame;", "make", "whitepoint", "", "adaptingLuminance", "", "backgroundLstar", "surround", "discountingIlluminant", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Frame getDefault() {
            return Frame.Default;
        }

        public final Frame make(float[] arg24, float arg25, float arg26, float arg27, boolean arg28) {
            // Method was not decompiled
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Frame Default;
    private final float aw;
    private final float c;
    private final float fl;
    private final float flRoot;
    private final float n;
    private final float nbb;
    private final float nc;
    private final float ncb;
    private final float[] rgbD;
    private final float z;

    static {
        Companion v0 = new Companion(null);
        Frame.Companion = v0;
        Frame.$stable = 8;
        Frame.Default = v0.make(CamUtils.INSTANCE.getWHITE_POINT_D65(), ((float)(CamUtils.INSTANCE.yFromLstar(50) * 63.661977 / 100)), 50f, 2f, false);
    }

    private Frame(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float[] arg7, float arg8, float arg9, float arg10) {
        super();
        this.n = arg1;
        this.aw = arg2;
        this.nbb = arg3;
        this.ncb = arg4;
        this.c = arg5;
        this.nc = arg6;
        this.rgbD = arg7;
        this.fl = arg8;
        this.flRoot = arg9;
        this.z = arg10;
    }

    public Frame(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float[] arg7, float arg8, float arg9, float arg10, DefaultConstructorMarker arg11) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public static final Frame access$getDefault$cp() {
        return Frame.Default;
    }

    public final float getAw() {
        return this.aw;
    }

    public final float getC() {
        return this.c;
    }

    public final float getFl() {
        return this.fl;
    }

    public final float getFlRoot() {
        return this.flRoot;
    }

    public final float getN() {
        return this.n;
    }

    public final float getNbb() {
        return this.nbb;
    }

    public final float getNc() {
        return this.nc;
    }

    public final float getNcb() {
        return this.ncb;
    }

    public final float[] getRgbD() {
        return this.rgbD;
    }

    public final float getZ() {
        return this.z;
    }
}

