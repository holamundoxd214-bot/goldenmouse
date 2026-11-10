package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH&¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2={"Landroidx/compose/ui/graphics/Brush;", "", "<init>", "()V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "J", "applyTo", "", "size", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "Companion", "Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/SolidColor;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class Brush {
    @Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\u0004\u001A\u00020\u00052*\u0010\u0006\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\u0004\u001A\u00020\u00052\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0010\u0010\u0014J;\u0010\u0015\u001A\u00020\u00052\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010\u0016\u001A\u00020\t2\b\b\u0002\u0010\u0017\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0018\u0010\u0019JY\u0010\u0015\u001A\u00020\u00052*\u0010\u0006\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u0016\u001A\u00020\t2\b\b\u0002\u0010\u0017\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0018\u0010\u001AJ;\u0010\u001B\u001A\u00020\u00052\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010\u001C\u001A\u00020\t2\b\b\u0002\u0010\u001D\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u001E\u0010\u0019JY\u0010\u001B\u001A\u00020\u00052*\u0010\u0006\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u001C\u001A\u00020\t2\b\b\u0002\u0010\u001D\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u001E\u0010\u001AJY\u0010\u001F\u001A\u00020\u00052*\u0010\u0006\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010 \u001A\u00020\f2\b\b\u0002\u0010!\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\"\u0010#J;\u0010\u001F\u001A\u00020\u00052\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010 \u001A\u00020\f2\b\b\u0002\u0010!\u001A\u00020\t2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\"\u0010$JE\u0010%\u001A\u00020\u00052*\u0010\u0006\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\"\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010 \u001A\u00020\fH\u0007¢\u0006\u0004\b&\u0010\'J\'\u0010%\u001A\u00020\u00052\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\n0\u00132\b\b\u0002\u0010 \u001A\u00020\fH\u0007¢\u0006\u0004\b&\u0010(J\'\u0010)\u001A\u00020\u00052\u0006\u0010*\u001A\u00020\u00052\u0006\u0010+\u001A\u00020\u00052\u0006\u0010,\u001A\u00020-H\u0007¢\u0006\u0004\b.\u0010/¨\u00060"}, d2={"Landroidx/compose/ui/graphics/Brush$Companion;", "", "<init>", "()V", "linearGradient", "Landroidx/compose/ui/graphics/Brush;", "colorStops", "", "Lkotlin/Pair;", "", "Landroidx/compose/ui/graphics/Color;", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "linearGradient-mHitzGk", "([Lkotlin/Pair;JJI)Landroidx/compose/ui/graphics/Brush;", "colors", "", "(Ljava/util/List;JJI)Landroidx/compose/ui/graphics/Brush;", "horizontalGradient", "startX", "endX", "horizontalGradient-8A-3gB4", "(Ljava/util/List;FFI)Landroidx/compose/ui/graphics/Brush;", "([Lkotlin/Pair;FFI)Landroidx/compose/ui/graphics/Brush;", "verticalGradient", "startY", "endY", "verticalGradient-8A-3gB4", "radialGradient", "center", "radius", "radialGradient-P_Vx-Ks", "([Lkotlin/Pair;JFI)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;JFI)Landroidx/compose/ui/graphics/Brush;", "sweepGradient", "sweepGradient-Uv8p0NA", "([Lkotlin/Pair;J)Landroidx/compose/ui/graphics/Brush;", "(Ljava/util/List;J)Landroidx/compose/ui/graphics/Brush;", "composite", "dstBrush", "srcBrush", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "composite-7EN7VTw", "(Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Brush;I)Landroidx/compose/ui/graphics/Brush;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Brush composite-7EN7VTw(Brush arg2, Brush arg3, int arg4) {
            return new CompositeShaderBrush(BrushKt.toShaderBrush(arg2), BrushKt.toShaderBrush(arg3), arg4, null);
        }

        public final Brush horizontalGradient-8A-3gB4(List arg16, float arg17, float arg18, int arg19) {
            return this.linearGradient-mHitzGk(arg16, Offset.constructor-impl((((long)Float.floatToRawIntBits(arg17))) << 0x20 | (((long)Float.floatToRawIntBits(0f))) & 0xFFFFFFFFL), Offset.constructor-impl((((long)Float.floatToRawIntBits(arg18))) << 0x20 | (((long)Float.floatToRawIntBits(0f))) & 0xFFFFFFFFL), arg19);
        }

        public final Brush horizontalGradient-8A-3gB4(Pair[] arg10, float arg11, float arg12, int arg13) {
            return this.linearGradient-mHitzGk(Arrays.copyOf(((Object[])arg10), arg10.length), Offset.constructor-impl((((long)Float.floatToRawIntBits(arg11))) << 0x20 | (((long)Float.floatToRawIntBits(0f))) & 0xFFFFFFFFL), Offset.constructor-impl((((long)Float.floatToRawIntBits(arg12))) << 0x20 | (((long)Float.floatToRawIntBits(0f))) & 0xFFFFFFFFL), arg13);
        }

        public static Brush horizontalGradient-8A-3gB4$default(Companion arg0, List arg1, float arg2, float arg3, int arg4, int arg5, Object arg6) {
            if((arg5 & 4) != 0) {
                arg3 = Infinityf;
            }

            if((arg5 & 8) != 0) {
                arg4 = TileMode.Companion.getClamp-3opZhB0();
            }

            return arg0.horizontalGradient-8A-3gB4(arg1, 0f, arg3, arg4);
        }

        public static Brush horizontalGradient-8A-3gB4$default(Companion arg0, Pair[] arg1, float arg2, float arg3, int arg4, int arg5, Object arg6) {
            if((arg5 & 4) != 0) {
                arg3 = Infinityf;
            }

            if((arg5 & 8) != 0) {
                arg4 = TileMode.Companion.getClamp-3opZhB0();
            }

            return arg0.horizontalGradient-8A-3gB4(arg1, 0f, arg3, arg4);
        }

        public final Brush linearGradient-mHitzGk(List arg10, long arg11, long arg13, int arg15) {
            return new LinearGradient(arg10, null, arg11, arg13, arg15, null);
        }

        public final Brush linearGradient-mHitzGk(Pair[] arg13, long arg14, long arg16, int arg18) {
            int v12 = arg13.length;
            ArrayList v0 = new ArrayList(v12);
            int v1 = 0;
            int v2;
            for(v2 = 0; v2 < v12; ++v2) {
                v0.add(Color.box-impl(arg13[v2].getSecond().unbox-impl()));
            }

            ArrayList v4 = v0;
            v12 = arg13.length;
            v0 = new ArrayList(v12);
            while(v1 < v12) {
                v0.add(Float.valueOf(arg13[v1].getFirst().floatValue()));
                ++v1;
            }

            return new LinearGradient(((List)v4), v0, arg14, arg16, arg18, null);
        }

        public static Brush linearGradient-mHitzGk$default(Companion arg7, List arg8, long arg9, long arg11, int arg13, int arg14, Object arg15) {
            if((arg14 & 2) != 0) {
                arg9 = Offset.Companion.getZero-F1C5BW0();
            }

            long v2 = arg9;
            if((arg14 & 4) != 0) {
                arg11 = Offset.Companion.getInfinite-F1C5BW0();
            }

            long v4 = arg11;
            if((arg14 & 8) != 0) {
                arg13 = TileMode.Companion.getClamp-3opZhB0();
            }

            return arg7.linearGradient-mHitzGk(arg8, v2, v4, arg13);
        }

        public static Brush linearGradient-mHitzGk$default(Companion arg7, Pair[] arg8, long arg9, long arg11, int arg13, int arg14, Object arg15) {
            if((arg14 & 2) != 0) {
                arg9 = Offset.Companion.getZero-F1C5BW0();
            }

            long v2 = arg9;
            if((arg14 & 4) != 0) {
                arg11 = Offset.Companion.getInfinite-F1C5BW0();
            }

            long v4 = arg11;
            if((arg14 & 8) != 0) {
                arg13 = TileMode.Companion.getClamp-3opZhB0();
            }

            return arg7.linearGradient-mHitzGk(arg8, v2, v4, arg13);
        }

        public final Brush radialGradient-P_Vx-Ks(List arg9, long arg10, float arg12, int arg13) {
            return new RadialGradient(arg9, null, arg10, arg12, arg13, null);
        }

        public final Brush radialGradient-P_Vx-Ks(Pair[] arg12, long arg13, float arg15, int arg16) {
            int v11 = arg12.length;
            ArrayList v0 = new ArrayList(v11);
            int v1 = 0;
            int v2;
            for(v2 = 0; v2 < v11; ++v2) {
                v0.add(Color.box-impl(arg12[v2].getSecond().unbox-impl()));
            }

            ArrayList v4 = v0;
            v11 = arg12.length;
            v0 = new ArrayList(v11);
            while(v1 < v11) {
                v0.add(Float.valueOf(arg12[v1].getFirst().floatValue()));
                ++v1;
            }

            return new RadialGradient(((List)v4), v0, arg13, arg15, arg16, null);
        }

        public static Brush radialGradient-P_Vx-Ks$default(Companion arg6, List arg7, long arg8, float arg10, int arg11, int arg12, Object arg13) {
            if((arg12 & 2) != 0) {
                arg8 = Offset.Companion.getUnspecified-F1C5BW0();
            }

            long v2 = arg8;
            if((arg12 & 4) != 0) {
                arg10 = Infinityf;
            }

            float v4 = arg10;
            if((arg12 & 8) != 0) {
                arg11 = TileMode.Companion.getClamp-3opZhB0();
            }

            return arg6.radialGradient-P_Vx-Ks(arg7, v2, v4, arg11);
        }

        public static Brush radialGradient-P_Vx-Ks$default(Companion arg6, Pair[] arg7, long arg8, float arg10, int arg11, int arg12, Object arg13) {
            if((arg12 & 2) != 0) {
                arg8 = Offset.Companion.getUnspecified-F1C5BW0();
            }

            long v2 = arg8;
            if((arg12 & 4) != 0) {
                arg10 = Infinityf;
            }

            float v4 = arg10;
            if((arg12 & 8) != 0) {
                arg11 = TileMode.Companion.getClamp-3opZhB0();
            }

            return arg6.radialGradient-P_Vx-Ks(arg7, v2, v4, arg11);
        }

        public final Brush sweepGradient-Uv8p0NA(List arg7, long arg8) {
            return new SweepGradient(arg8, arg7, null, null);
        }

        public final Brush sweepGradient-Uv8p0NA(Pair[] arg10, long arg11) {
            int v9 = arg10.length;
            ArrayList v0 = new ArrayList(v9);
            int v1 = 0;
            int v2;
            for(v2 = 0; v2 < v9; ++v2) {
                v0.add(Color.box-impl(arg10[v2].getSecond().unbox-impl()));
            }

            ArrayList v6 = v0;
            v9 = arg10.length;
            v0 = new ArrayList(v9);
            while(v1 < v9) {
                v0.add(Float.valueOf(arg10[v1].getFirst().floatValue()));
                ++v1;
            }

            return new SweepGradient(arg11, ((List)v6), v0, null);
        }

        public static Brush sweepGradient-Uv8p0NA$default(Companion arg0, List arg1, long arg2, int arg4, Object arg5) {
            if((arg4 & 2) != 0) {
                arg2 = Offset.Companion.getUnspecified-F1C5BW0();
            }

            return arg0.sweepGradient-Uv8p0NA(arg1, arg2);
        }

        public static Brush sweepGradient-Uv8p0NA$default(Companion arg0, Pair[] arg1, long arg2, int arg4, Object arg5) {
            if((arg4 & 2) != 0) {
                arg2 = Offset.Companion.getUnspecified-F1C5BW0();
            }

            return arg0.sweepGradient-Uv8p0NA(arg1, arg2);
        }

        public final Brush verticalGradient-8A-3gB4(List arg16, float arg17, float arg18, int arg19) {
            return this.linearGradient-mHitzGk(arg16, Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << 0x20 | (((long)Float.floatToRawIntBits(arg17))) & 0xFFFFFFFFL), Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << 0x20 | (((long)Float.floatToRawIntBits(arg18))) & 0xFFFFFFFFL), arg19);
        }

        public final Brush verticalGradient-8A-3gB4(Pair[] arg11, float arg12, float arg13, int arg14) {
            return this.linearGradient-mHitzGk(Arrays.copyOf(((Object[])arg11), arg11.length), Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << 0x20 | (((long)Float.floatToRawIntBits(arg12))) & 0xFFFFFFFFL), Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << 0x20 | (((long)Float.floatToRawIntBits(arg13))) & 0xFFFFFFFFL), arg14);
        }

        public static Brush verticalGradient-8A-3gB4$default(Companion arg0, Pair[] arg1, float arg2, float arg3, int arg4, int arg5, Object arg6) {
            if((arg5 & 4) != 0) {
                arg3 = Infinityf;
            }

            if((arg5 & 8) != 0) {
                arg4 = TileMode.Companion.getClamp-3opZhB0();
            }

            return arg0.verticalGradient-8A-3gB4(arg1, 0f, arg3, arg4);
        }

        public static Brush verticalGradient-8A-3gB4$default(Companion arg0, List arg1, float arg2, float arg3, int arg4, int arg5, Object arg6) {
            if((arg5 & 4) != 0) {
                arg3 = Infinityf;
            }

            if((arg5 & 8) != 0) {
                arg4 = TileMode.Companion.getClamp-3opZhB0();
            }

            return arg0.verticalGradient-8A-3gB4(arg1, 0f, arg3, arg4);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final long intrinsicSize;

    static {
        Brush.Companion = new Companion(null);
    }

    private Brush() {
        super();
        this.intrinsicSize = Size.Companion.getUnspecified-NH-jbRc();
    }

    public Brush(DefaultConstructorMarker arg1) {
        this();
    }

    public abstract void applyTo-Pq9zytI(long arg1, Paint arg2, float arg3);

    public long getIntrinsicSize-NH-jbRc() {
        return this.intrinsicSize;
    }
}

