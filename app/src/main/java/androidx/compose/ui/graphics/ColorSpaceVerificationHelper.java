package androidx.compose.ui.graphics;

import android.graphics.ColorSpace$Named;
import android.graphics.ColorSpace$Rgb$TransferParameters;
import android.graphics.ColorSpace$Rgb;
import android.graphics.ColorSpace;
import android.os.Build$VERSION;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import androidx.compose.ui.graphics.colorspace.WhitePoint;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001A\u00020\u0005*\u00020\u0006H\u0007J\f\u0010\u0007\u001A\u00020\u0006*\u00020\u0005H\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/graphics/ColorSpaceVerificationHelper;", "", "<init>", "()V", "androidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "composeColorSpace", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) final class ColorSpaceVerificationHelper {
    public static final ColorSpaceVerificationHelper INSTANCE;

    static {
        ColorSpaceVerificationHelper.INSTANCE = new ColorSpaceVerificationHelper();
    }

    private ColorSpaceVerificationHelper() {
        super();
    }

    @JvmStatic public static final ColorSpace androidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace arg22) {
        androidx.compose.ui.graphics.colorspace.ColorSpace v0 = arg22;
        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getSrgb())) {
            return ColorSpace.get(ColorSpace$Named.SRGB);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getAces())) {
            return ColorSpace.get(ColorSpace$Named.ACES);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getAcescg())) {
            return ColorSpace.get(ColorSpace$Named.ACESCG);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getAdobeRgb())) {
            return ColorSpace.get(ColorSpace$Named.ADOBE_RGB);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getBt2020())) {
            return ColorSpace.get(ColorSpace$Named.BT2020);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getBt709())) {
            return ColorSpace.get(ColorSpace$Named.BT709);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getCieLab())) {
            return ColorSpace.get(ColorSpace$Named.CIE_LAB);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getCieXyz())) {
            return ColorSpace.get(ColorSpace$Named.CIE_XYZ);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getDciP3())) {
            return ColorSpace.get(ColorSpace$Named.DCI_P3);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getDisplayP3())) {
            return ColorSpace.get(ColorSpace$Named.DISPLAY_P3);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getExtendedSrgb())) {
            return ColorSpace.get(ColorSpace$Named.EXTENDED_SRGB);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getLinearExtendedSrgb())) {
            return ColorSpace.get(ColorSpace$Named.LINEAR_EXTENDED_SRGB);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getLinearSrgb())) {
            return ColorSpace.get(ColorSpace$Named.LINEAR_SRGB);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getNtsc1953())) {
            return ColorSpace.get(ColorSpace$Named.NTSC_1953);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getProPhotoRgb())) {
            return ColorSpace.get(ColorSpace$Named.PRO_PHOTO_RGB);
        }

        if(Intrinsics.areEqual(v0, ColorSpaces.INSTANCE.getSmpteC())) {
            return ColorSpace.get(ColorSpace$Named.SMPTE_C);
        }

        if(Build$VERSION.SDK_INT >= 34) {
            ColorSpace v1 = ColorSpaceVerificationHelperV34.obtainAndroidColorSpace(v0);
            if(v1 != null) {
                return v1;
            }
        }

        if((v0 instanceof Rgb)) {
            androidx.compose.ui.graphics.colorspace.ColorSpace v1_1 = v0;
            float[] v6 = ((Rgb)v1_1).getWhitePoint().toXyz$ui_graphics();
            TransferParameters v2 = ((Rgb)v1_1).getTransferParameters();
            ColorSpace$Rgb$TransferParameters v7 = v2 != null ? new ColorSpace$Rgb$TransferParameters(v2.getA(), v2.getB(), v2.getC(), v2.getD(), v2.getE(), v2.getF(), v2.getGamma()) : null;
            ColorSpace$Rgb v2_1 = v7 != null ? new ColorSpace$Rgb(v0.getName(), ((Rgb)v1_1).getPrimaries$ui_graphics(), v6, v7) : new ColorSpace$Rgb(v0.getName(), ((Rgb)v1_1).getPrimaries$ui_graphics(), v6, new ColorSpaceVerificationHelper$$ExternalSyntheticLambda0(((Rgb)v1_1).getOetf()), new ColorSpaceVerificationHelper$$ExternalSyntheticLambda1(((Rgb)v1_1).getEotf()), ((Rgb)v1_1).getMinValue(0), ((Rgb)v1_1).getMaxValue(0));
            return ((ColorSpace)v2_1);
        }

        return ColorSpace.get(ColorSpace$Named.SRGB);
    }

    static final double androidColorSpace$lambda$0(Function1 arg0, double arg1) {
        return arg0.invoke(Double.valueOf(arg1)).doubleValue();
    }

    static final double androidColorSpace$lambda$1(Function1 arg0, double arg1) {
        return arg0.invoke(Double.valueOf(arg1)).doubleValue();
    }

    @JvmStatic public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace(ColorSpace arg26) {
        Rgb v7;
        ColorSpace v0 = arg26;
        int v1 = v0.getId();
        if(v1 == ColorSpace$Named.SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getSrgb();
        }

        if(v1 == ColorSpace$Named.ACES.ordinal()) {
            return ColorSpaces.INSTANCE.getAces();
        }

        if(v1 == ColorSpace$Named.ACESCG.ordinal()) {
            return ColorSpaces.INSTANCE.getAcescg();
        }

        if(v1 == ColorSpace$Named.ADOBE_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getAdobeRgb();
        }

        if(v1 == ColorSpace$Named.BT2020.ordinal()) {
            return ColorSpaces.INSTANCE.getBt2020();
        }

        if(v1 == ColorSpace$Named.BT709.ordinal()) {
            return ColorSpaces.INSTANCE.getBt709();
        }

        if(v1 == ColorSpace$Named.CIE_LAB.ordinal()) {
            return ColorSpaces.INSTANCE.getCieLab();
        }

        if(v1 == ColorSpace$Named.CIE_XYZ.ordinal()) {
            return ColorSpaces.INSTANCE.getCieXyz();
        }

        if(v1 == ColorSpace$Named.DCI_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDciP3();
        }

        if(v1 == ColorSpace$Named.DISPLAY_P3.ordinal()) {
            return ColorSpaces.INSTANCE.getDisplayP3();
        }

        if(v1 == ColorSpace$Named.EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getExtendedSrgb();
        }

        if(v1 == ColorSpace$Named.LINEAR_EXTENDED_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearExtendedSrgb();
        }

        if(v1 == ColorSpace$Named.LINEAR_SRGB.ordinal()) {
            return ColorSpaces.INSTANCE.getLinearSrgb();
        }

        if(v1 == ColorSpace$Named.NTSC_1953.ordinal()) {
            return ColorSpaces.INSTANCE.getNtsc1953();
        }

        if(v1 == ColorSpace$Named.PRO_PHOTO_RGB.ordinal()) {
            return ColorSpaces.INSTANCE.getProPhotoRgb();
        }

        if(v1 == ColorSpace$Named.SMPTE_C.ordinal()) {
            return ColorSpaces.INSTANCE.getSmpteC();
        }

        if(Build$VERSION.SDK_INT >= 34) {
            androidx.compose.ui.graphics.colorspace.ColorSpace v1_1 = ColorSpaceVerificationHelperV34.obtainComposeColorSpaceFromId(v0.getId());
            if(!Intrinsics.areEqual(v1_1, ColorSpaces.INSTANCE.getUnspecified$ui_graphics())) {
                return v1_1;
            }
        }

        if((v0 instanceof ColorSpace$Rgb)) {
            ColorSpace v1_2 = v0;
            ColorSpace$Rgb$TransferParameters v2 = ((ColorSpace$Rgb)v1_2).getTransferParameters();
            WhitePoint v3 = ((ColorSpace$Rgb)v1_2).getWhitePoint().length == 3 ? new WhitePoint(((ColorSpace$Rgb)v1_2).getWhitePoint()[0], ((ColorSpace$Rgb)v1_2).getWhitePoint()[1], ((ColorSpace$Rgb)v1_2).getWhitePoint()[2]) : new WhitePoint(((ColorSpace$Rgb)v1_2).getWhitePoint()[0], ((ColorSpace$Rgb)v1_2).getWhitePoint()[1]);
            WhitePoint v10 = v3;
            TransferParameters v11 = v2 != null ? new TransferParameters(v2.g, v2.a, v2.b, v2.c, v2.d, v2.e, v2.f) : null;
            v7 = new Rgb(((ColorSpace$Rgb)v1_2).getName(), ((ColorSpace$Rgb)v1_2).getPrimaries(), v10, ((ColorSpace$Rgb)v1_2).getTransform(), new ColorSpaceVerificationHelper$$ExternalSyntheticLambda2(v0), new ColorSpaceVerificationHelper$$ExternalSyntheticLambda3(v0), ((ColorSpace$Rgb)v1_2).getMinValue(0), ((ColorSpace$Rgb)v1_2).getMaxValue(0), v11, ((ColorSpace$Rgb)v1_2).getId());
        }
        else {
            v7 = ColorSpaces.INSTANCE.getSrgb();
        }

        return ((androidx.compose.ui.graphics.colorspace.ColorSpace)v7);
    }

    static final double composeColorSpace$lambda$0(ColorSpace arg0, double arg1) {
        return ((ColorSpace$Rgb)arg0).getOetf().applyAsDouble(arg1);
    }

    static final double composeColorSpace$lambda$1(ColorSpace arg0, double arg1) {
        return ((ColorSpace$Rgb)arg0).getEotf().applyAsDouble(arg1);
    }
}

