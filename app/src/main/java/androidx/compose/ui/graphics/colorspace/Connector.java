package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u000B\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000  2\u00020\u0001:\u0002\u001F B;\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u000B\u0010\fB!\b\u0010\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\r\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\u000EJ \u0010\t\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u0016H\u0007J\u0012\u0010\t\u001A\u00020\n2\b\b\u0001\u0010\u0019\u001A\u00020\nH\u0017J\u0017\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001BH\u0010¢\u0006\u0004\b\u001D\u0010\u001ER\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u000E\u0010\u0005\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2={"Landroidx/compose/ui/graphics/colorspace/Connector;", "", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", "transformSource", "transformDestination", "renderIntent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "transform", "", "<init>", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I[FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "intent", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSource", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getDestination", "getRenderIntent-uksYyKA", "()I", "I", "r", "", "g", "b", "v", "transformToColor", "Landroidx/compose/ui/graphics/Color;", "color", "transformToColor-l2rxGTc$ui_graphics", "(J)J", "RgbConnector", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public class Connector {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\nH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u0015\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0006\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\u000F¨\u0006\u0010"}, d2={"Landroidx/compose/ui/graphics/colorspace/Connector$Companion;", "", "<init>", "()V", "computeTransform", "", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)[F", "identity", "Landroidx/compose/ui/graphics/colorspace/Connector;", "identity$ui_graphics", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final float[] access$computeTransform-YBCOT_4(Companion arg0, ColorSpace arg1, ColorSpace arg2, int arg3) {
            return arg0.computeTransform-YBCOT_4(arg1, arg2, arg3);
        }

        private final float[] computeTransform-YBCOT_4(ColorSpace arg5, ColorSpace arg6, int arg7) {
            boolean v4 = RenderIntent.equals-impl0(arg7, RenderIntent.Companion.getAbsolute-uksYyKA());
            float[] v7 = null;
            if(!v4) {
                return v7;
            }

            v4 = ColorModel.equals-impl0(arg5.getModel-xdoWZVw(), ColorModel.Companion.getRgb-xdoWZVw());
            boolean v0 = ColorModel.equals-impl0(arg6.getModel-xdoWZVw(), ColorModel.Companion.getRgb-xdoWZVw());
            if((v4) && (v0)) {
                return v7;
            }

            if(!v4) {
                if(v0) {
                }
                else {
                    return v7;
                }
            }

            if(v4) {
            }
            else {
                arg5 = arg6;
            }

            Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            float[] v4_1 = v4 ? ((Rgb)arg5).getWhitePoint().toXyz$ui_graphics() : Illuminant.INSTANCE.getD50Xyz$ui_graphics();
            float[] v5 = v0 ? ((Rgb)arg5).getWhitePoint().toXyz$ui_graphics() : Illuminant.INSTANCE.getD50Xyz$ui_graphics();
            return new float[]{v4_1[0] / v5[0], v4_1[1] / v5[1], v4_1[2] / v5[2]};
        }

        public final Connector identity$ui_graphics(ColorSpace arg2) {
            return new Connector$Companion$identity$1(arg2, RenderIntent.Companion.getRelative-uksYyKA());
        }
    }

    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016J\u0017\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000EH\u0010¢\u0006\u0004\b\u0010\u0010\u0011J\'\u0010\u0012\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/ui/graphics/colorspace/Connector$RgbConnector;", "Landroidx/compose/ui/graphics/colorspace/Connector;", "mSource", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "mDestination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "<init>", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "mTransform", "", "transform", "v", "transformToColor", "Landroidx/compose/ui/graphics/Color;", "color", "transformToColor-l2rxGTc$ui_graphics", "(J)J", "computeTransform", "source", "destination", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;I)[F", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RgbConnector extends Connector {
        public static final int $stable = 8;
        private final Rgb mDestination;
        private final Rgb mSource;
        private final float[] mTransform;

        static {
        }

        public RgbConnector(Rgb arg1, Rgb arg2, int arg3, DefaultConstructorMarker arg4) {
            this(arg1, arg2, arg3);
        }

        private RgbConnector(Rgb arg9, Rgb arg10, int arg11) {
            super(arg9, arg10, arg9, arg10, arg11, null, null);
            this.mSource = arg9;
            this.mDestination = arg10;
            this.mTransform = this.computeTransform-YBCOT_4(arg9, arg10, arg11);
        }

        private final float[] computeTransform-YBCOT_4(Rgb arg6, Rgb arg7, int arg8) {
            if(ColorSpaceKt.compare(arg6.getWhitePoint(), arg7.getWhitePoint())) {
                return ColorSpaceKt.mul3x3(arg7.getInverseTransform$ui_graphics(), arg6.getTransform$ui_graphics());
            }

            float[] v5 = arg6.getTransform$ui_graphics();
            float[] v0 = arg7.getInverseTransform$ui_graphics();
            float[] v1 = arg6.getWhitePoint().toXyz$ui_graphics();
            float[] v2 = arg7.getWhitePoint().toXyz$ui_graphics();
            if(!ColorSpaceKt.compare(arg6.getWhitePoint(), Illuminant.INSTANCE.getD50())) {
                v5 = ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(Adaptation.Companion.getBradford().getTransform$ui_graphics(), v1, Illuminant.INSTANCE.newD50Xyz$ui_graphics()), arg6.getTransform$ui_graphics());
            }

            if(!ColorSpaceKt.compare(arg7.getWhitePoint(), Illuminant.INSTANCE.getD50())) {
                v0 = ColorSpaceKt.inverse3x3(ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(Adaptation.Companion.getBradford().getTransform$ui_graphics(), v2, Illuminant.INSTANCE.newD50Xyz$ui_graphics()), arg7.getTransform$ui_graphics()));
            }

            if(RenderIntent.equals-impl0(arg8, RenderIntent.Companion.getAbsolute-uksYyKA())) {
                v5 = ColorSpaceKt.mul3x3Diag(new float[]{v1[0] / v2[0], v1[1] / v2[1], v1[2] / v2[2]}, v5);
            }

            return ColorSpaceKt.mul3x3(v0, v5);
        }

        public float[] transform(float[] arg7) {
            arg7[0] = ((float)this.mSource.getEotfFunc$ui_graphics().invoke(((double)arg7[0])));
            arg7[1] = ((float)this.mSource.getEotfFunc$ui_graphics().invoke(((double)arg7[1])));
            arg7[2] = ((float)this.mSource.getEotfFunc$ui_graphics().invoke(((double)arg7[2])));
            ColorSpaceKt.mul3x3Float3(this.mTransform, arg7);
            arg7[0] = ((float)this.mDestination.getOetfFunc$ui_graphics().invoke(((double)arg7[0])));
            arg7[1] = ((float)this.mDestination.getOetfFunc$ui_graphics().invoke(((double)arg7[1])));
            arg7[2] = ((float)this.mDestination.getOetfFunc$ui_graphics().invoke(((double)arg7[2])));
            return arg7;
        }

        public long transformToColor-l2rxGTc$ui_graphics(long arg7) {
            float v0 = Color.getRed-impl(arg7);
            float v1 = Color.getGreen-impl(arg7);
            float v2 = Color.getBlue-impl(arg7);
            float v7 = Color.getAlpha-impl(arg7);
            float v8 = ((float)this.mSource.getEotfFunc$ui_graphics().invoke(((double)v0)));
            v0 = ((float)this.mSource.getEotfFunc$ui_graphics().invoke(((double)v1)));
            v1 = ((float)this.mSource.getEotfFunc$ui_graphics().invoke(((double)v2)));
            return ColorKt.Color(((float)this.mDestination.getOetfFunc$ui_graphics().invoke(((double)(this.mTransform[0] * v8 + this.mTransform[3] * v0 + this.mTransform[6] * v1)))), ((float)this.mDestination.getOetfFunc$ui_graphics().invoke(((double)(this.mTransform[1] * v8 + this.mTransform[4] * v0 + this.mTransform[7] * v1)))), ((float)this.mDestination.getOetfFunc$ui_graphics().invoke(((double)(this.mTransform[2] * v8 + this.mTransform[5] * v0 + this.mTransform[8] * v1)))), v7, this.mDestination);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final ColorSpace destination;
    private final int renderIntent;
    private final ColorSpace source;
    private final float[] transform;
    private final ColorSpace transformDestination;
    private final ColorSpace transformSource;

    static {
        Connector.Companion = new Companion(null);
        Connector.$stable = 8;
    }

    public Connector(ColorSpace arg1, ColorSpace arg2, int arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    private Connector(ColorSpace arg12, ColorSpace arg13, int arg14) {
        int v1 = 2;
        Adaptation v2 = null;
        ColorSpace v6 = ColorModel.equals-impl0(arg12.getModel-xdoWZVw(), ColorModel.Companion.getRgb-xdoWZVw()) ? ColorSpaceKt.adapt$default(arg12, Illuminant.INSTANCE.getD50(), v2, v1, v2) : arg12;
        ColorSpace v7 = ColorModel.equals-impl0(arg13.getModel-xdoWZVw(), ColorModel.Companion.getRgb-xdoWZVw()) ? ColorSpaceKt.adapt$default(arg13, Illuminant.INSTANCE.getD50(), v2, v1, v2) : arg13;
        this(arg12, arg13, v6, v7, arg14, Companion.access$computeTransform-YBCOT_4(Connector.Companion, arg12, arg13, arg14), null);
    }

    public Connector(ColorSpace arg1, ColorSpace arg2, ColorSpace arg3, ColorSpace arg4, int arg5, float[] arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private Connector(ColorSpace arg1, ColorSpace arg2, ColorSpace arg3, ColorSpace arg4, int arg5, float[] arg6) {
        super();
        this.source = arg1;
        this.destination = arg2;
        this.transformSource = arg3;
        this.transformDestination = arg4;
        this.renderIntent = arg5;
        this.transform = arg6;
    }

    public final ColorSpace getDestination() {
        return this.destination;
    }

    public final int getRenderIntent-uksYyKA() {
        return this.renderIntent;
    }

    public final ColorSpace getSource() {
        return this.source;
    }

    public final float[] transform(float arg3, float arg4, float arg5) {
        return this.transform(new float[]{arg3, arg4, arg5});
    }

    public float[] transform(float[] arg5) {
        arg5 = this.transformSource.toXyz(arg5);
        float[] v0 = this.transform;
        if(v0 != null) {
            arg5[0] *= v0[0];
            arg5[1] *= v0[1];
            arg5[2] *= v0[2];
        }

        return this.transformDestination.fromXyz(arg5);
    }

    public long transformToColor-l2rxGTc$ui_graphics(long arg10) {
        float v0 = Color.getRed-impl(arg10);
        float v1 = Color.getGreen-impl(arg10);
        float v2 = Color.getBlue-impl(arg10);
        float v7 = Color.getAlpha-impl(arg10);
        arg10 = this.transformSource.toXy$ui_graphics(v0, v1, v2);
        float v3 = Float.intBitsToFloat(((int)(arg10 >> 0x20)));
        float v10 = Float.intBitsToFloat(((int)(arg10 & 0xFFFFFFFFL)));
        float v11 = this.transformSource.toZ$ui_graphics(v0, v1, v2);
        float[] v0_1 = this.transform;
        if(v0_1 != null) {
            v3 *= v0_1[0];
            v10 *= v0_1[1];
            v11 *= v0_1[2];
        }

        return this.transformDestination.xyzaToColor-JlNiLsg$ui_graphics(v3, v10, v11, v7, this.destination);
    }
}

