package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001D\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000B\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010A\u001A\u0004\u0018\u0001042\b\b\u0001\u0010B\u001A\u00020\u00052\u0006\u0010C\u001A\u00020\rJ\u0016\u0010D\u001A\u0002042\u0006\u0010E\u001A\u00020FH\u0080\b¢\u0006\u0002\bGJ\u001D\u0010M\u001A\u00020N2\u0006\u0010O\u001A\u00020\r2\u0006\u0010P\u001A\u00020NH\u0000¢\u0006\u0002\bQJ\u001D\u0010R\u001A\u00020N2\u0006\u0010O\u001A\u00020\r2\u0006\u0010P\u001A\u00020NH\u0000¢\u0006\u0002\bSJ\u001D\u0010T\u001A\u00020N2\u0006\u0010O\u001A\u00020\r2\u0006\u0010P\u001A\u00020NH\u0000¢\u0006\u0002\bUJ\u001D\u0010V\u001A\u00020N2\u0006\u0010W\u001A\u00020\r2\u0006\u0010P\u001A\u00020NH\u0000¢\u0006\u0002\bXR\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0014\u0010\f\u001A\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0010\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001A\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000FR\u0014\u0010\u0013\u001A\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u000FR\u0011\u0010\u0015\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0018R\u0011\u0010\u001B\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0018R\u0011\u0010\u001D\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0018R\u0011\u0010\u001F\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u0018R\u0011\u0010!\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0018R\u0011\u0010#\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u0018R\u0011\u0010%\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\u0018R\u0011\u0010\'\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b(\u0010\u0018R\u0011\u0010)\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b*\u0010\u0018R\u0011\u0010+\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b,\u0010\u0018R\u0011\u0010-\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b.\u0010\u0018R\u0011\u0010/\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b0\u0010\u0018R\u0011\u00101\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b2\u0010\u0018R\u0011\u00103\u001A\u000204¢\u0006\b\n\u0000\u001A\u0004\b5\u00106R\u0011\u00107\u001A\u000204¢\u0006\b\n\u0000\u001A\u0004\b8\u00106R\u0014\u00109\u001A\u00020\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b:\u0010\u0018R\u0011\u0010;\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b<\u0010\u0018R\u0011\u0010=\u001A\u00020\u0016¢\u0006\b\n\u0000\u001A\u0004\b>\u0010\u0018R\u0011\u0010?\u001A\u000204¢\u0006\b\n\u0000\u001A\u0004\b@\u00106R\u001C\u0010H\u001A\b\u0012\u0004\u0012\u0002040IX\u0080\u0004¢\u0006\n\n\u0002\u0010L\u001A\u0004\bJ\u0010K¨\u0006Y"}, d2={"Landroidx/compose/ui/graphics/colorspace/ColorSpaces;", "", "<init>", "()V", "SrgbPrimaries", "", "getSrgbPrimaries$ui_graphics", "()[F", "Ntsc1953Primaries", "getNtsc1953Primaries$ui_graphics", "Bt2020Primaries", "getBt2020Primaries$ui_graphics", "SrgbTransferParameters", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getSrgbTransferParameters$ui_graphics", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "NoneTransferParameters", "Bt2020HlgTransferParameters", "getBt2020HlgTransferParameters$ui_graphics", "Bt2020PqTransferParameters", "getBt2020PqTransferParameters$ui_graphics", "Srgb", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "getSrgb", "()Landroidx/compose/ui/graphics/colorspace/Rgb;", "LinearSrgb", "getLinearSrgb", "ExtendedSrgb", "getExtendedSrgb", "LinearExtendedSrgb", "getLinearExtendedSrgb", "Bt709", "getBt709", "Bt2020", "getBt2020", "DciP3", "getDciP3", "DisplayP3", "getDisplayP3", "Ntsc1953", "getNtsc1953", "SmpteC", "getSmpteC", "AdobeRgb", "getAdobeRgb", "ProPhotoRgb", "getProPhotoRgb", "Aces", "getAces", "Acescg", "getAcescg", "CieXyz", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getCieXyz", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "CieLab", "getCieLab", "Unspecified", "getUnspecified$ui_graphics", "Bt2020Hlg", "getBt2020Hlg", "Bt2020Pq", "getBt2020Pq", "Oklab", "getOklab", "match", "toXYZD50", "function", "getColorSpace", "id", "", "getColorSpace$ui_graphics", "ColorSpacesArray", "", "getColorSpacesArray$ui_graphics", "()[Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "[Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "transferHlgOetf", "", "params", "x", "transferHlgOetf$ui_graphics", "transferHlgEotf", "transferHlgEotf$ui_graphics", "transferSt2048Oetf", "transferSt2048Oetf$ui_graphics", "transferSt2048Eotf", "pq", "transferSt2048Eotf$ui_graphics", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ColorSpaces {
    public static final int $stable;
    private static final Rgb Aces;
    private static final Rgb Acescg;
    private static final Rgb AdobeRgb;
    private static final Rgb Bt2020;
    private static final Rgb Bt2020Hlg;
    private static final TransferParameters Bt2020HlgTransferParameters;
    private static final Rgb Bt2020Pq;
    private static final TransferParameters Bt2020PqTransferParameters;
    private static final float[] Bt2020Primaries;
    private static final Rgb Bt709;
    private static final ColorSpace CieLab;
    private static final ColorSpace CieXyz;
    private static final ColorSpace[] ColorSpacesArray;
    private static final Rgb DciP3;
    private static final Rgb DisplayP3;
    private static final Rgb ExtendedSrgb;
    public static final ColorSpaces INSTANCE;
    private static final Rgb LinearExtendedSrgb;
    private static final Rgb LinearSrgb;
    private static final TransferParameters NoneTransferParameters;
    private static final Rgb Ntsc1953;
    private static final float[] Ntsc1953Primaries;
    private static final ColorSpace Oklab;
    private static final Rgb ProPhotoRgb;
    private static final Rgb SmpteC;
    private static final Rgb Srgb;
    private static final float[] SrgbPrimaries;
    private static final TransferParameters SrgbTransferParameters;
    private static final Rgb Unspecified;

    static {
        ColorSpaces.INSTANCE = new ColorSpaces();
        float[] v3 = new float[]{0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f};
        ColorSpaces.SrgbPrimaries = v3;
        float[] v12 = new float[]{0.67f, 0.33f, 0.21f, 0.71f, 0.14f, 0.08f};
        ColorSpaces.Ntsc1953Primaries = v12;
        float[] v15 = new float[]{0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f};
        ColorSpaces.Bt2020Primaries = v15;
        TransferParameters v16 = new TransferParameters(2.4, 0.947867, 0.052133, 0.077399, 0.04045, 0, 0, 0x60, null);
        ColorSpaces.SrgbTransferParameters = v16;
        TransferParameters v17 = new TransferParameters(2.2, 0.947867, 0.052133, 0.077399, 0.04045, 0, 0, 0x60, null);
        ColorSpaces.NoneTransferParameters = v17;
        TransferParameters v18 = new TransferParameters(-3, 2, 2, 5.591816, 0.284669, 0.559911, -0.68549);
        ColorSpaces.Bt2020HlgTransferParameters = v18;
        TransferParameters v24 = new TransferParameters(-2, -1.555223, 1.860454, 0.012683, 18.851563, -18.6875, 6.277395);
        ColorSpaces.Bt2020PqTransferParameters = v24;
        Rgb v25 = new Rgb("sRGB IEC61966-2.1", v3, Illuminant.INSTANCE.getD65(), v16, 0);
        ColorSpaces.Srgb = v25;
        Rgb v26 = new Rgb("sRGB IEC61966-2.1 (Linear)", v3, Illuminant.INSTANCE.getD65(), 1, 0f, 1f, 1);
        ColorSpaces.LinearSrgb = v26;
        Rgb v10 = new Rgb("scRGB-nl IEC 61966-2-2:2003", v3, Illuminant.INSTANCE.getD65(), null, new ColorSpaces$$ExternalSyntheticLambda0(), new ColorSpaces$$ExternalSyntheticLambda1(), -0.799f, 2.399f, v16, 2);
        ColorSpaces.ExtendedSrgb = v10;
        Rgb v11 = new Rgb("scRGB IEC 61966-2-2:2003", v3, Illuminant.INSTANCE.getD65(), 1, -0.5f, 7.499f, 3);
        ColorSpaces.LinearExtendedSrgb = v11;
        Rgb v27 = new Rgb("Rec. ITU-R BT.709-5", new float[]{0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f}, Illuminant.INSTANCE.getD65(), new TransferParameters(2.222222, 0.909918, 0.090082, 0.222222, 0.081, 0, 0, 0x60, null), 4);
        ColorSpaces.Bt709 = v27;
        Rgb v28 = new Rgb("Rec. ITU-R BT.2020-1", new float[]{0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f}, Illuminant.INSTANCE.getD65(), new TransferParameters(2.222222, 0.90967, 0.09033, 0.222222, 0.08145, 0, 0, 0x60, null), 5);
        ColorSpaces.Bt2020 = v28;
        Rgb v29 = new Rgb("SMPTE RP 431-2-2007 DCI (P3)", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, new WhitePoint(0.314f, 0.351f), 2.6, 0f, 1f, 6);
        ColorSpaces.DciP3 = v29;
        Rgb v30 = new Rgb("Display P3", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, Illuminant.INSTANCE.getD65(), v16, 7);
        ColorSpaces.DisplayP3 = v30;
        Rgb v7 = new Rgb("NTSC (1953)", v12, Illuminant.INSTANCE.getC(), new TransferParameters(2.222222, 0.909918, 0.090082, 0.222222, 0.081, 0, 0, 0x60, null), 8);
        ColorSpaces.Ntsc1953 = v7;
        Rgb v31 = new Rgb("SMPTE-C RGB", new float[]{0.63f, 0.34f, 0.31f, 0.595f, 0.155f, 0.07f}, Illuminant.INSTANCE.getD65(), new TransferParameters(2.222222, 0.909918, 0.090082, 0.222222, 0.081, 0, 0, 0x60, null), 9);
        ColorSpaces.SmpteC = v31;
        Rgb v32 = new Rgb("Adobe RGB (1998)", new float[]{0.64f, 0.33f, 0.21f, 0.71f, 0.15f, 0.06f}, Illuminant.INSTANCE.getD65(), 2.2, 0f, 1f, 10);
        ColorSpaces.AdobeRgb = v32;
        Rgb v33 = new Rgb("ROMM RGB ISO 22028-2:2013", new float[]{0.7347f, 0.2653f, 0.1596f, 0.8404f, 0.0366f, 0.0001f}, Illuminant.INSTANCE.getD50(), new TransferParameters(1.8, 1, 0, 0.0625, 0.031248, 0, 0, 0x60, null), 11);
        ColorSpaces.ProPhotoRgb = v33;
        Rgb v34 = new Rgb("SMPTE ST 2065-1:2012 ACES", new float[]{0.7347f, 0.2653f, 0f, 1f, 0.0001f, -0.077f}, Illuminant.INSTANCE.getD60(), 1, -65504f, 65504f, 12);
        ColorSpaces.Aces = v34;
        Rgb v35 = new Rgb("Academy S-2014-004 ACEScg", new float[]{0.713f, 0.293f, 0.165f, 0.83f, 0.128f, 0.044f}, Illuminant.INSTANCE.getD60(), 1, -65504f, 65504f, 13);
        ColorSpaces.Acescg = v35;
        Xyz v8 = new Xyz("Generic XYZ", 14);
        ColorSpaces.CieXyz = ((ColorSpace)v8);
        Lab v9 = new Lab("Generic L*a*b*", 15);
        ColorSpaces.CieLab = ((ColorSpace)v9);
        Rgb v1 = new Rgb("None", v3, Illuminant.INSTANCE.getD65(), v17, 16);
        ColorSpaces.Unspecified = v1;
        Rgb v2 = new Rgb("Hybrid Log Gamma encoding", v15, Illuminant.INSTANCE.getD65(), null, new ColorSpaces$$ExternalSyntheticLambda2(), new ColorSpaces$$ExternalSyntheticLambda3(), 0f, 1f, v18, 17);
        ColorSpaces.Bt2020Hlg = v2;
        Rgb v13 = new Rgb("Perceptual Quantizer encoding", v15, Illuminant.INSTANCE.getD65(), null, new ColorSpaces$$ExternalSyntheticLambda4(), new ColorSpaces$$ExternalSyntheticLambda5(), 0f, 1f, v24, 18);
        ColorSpaces.Bt2020Pq = v13;
        Oklab v3_1 = new Oklab("Oklab", 19);
        ColorSpaces.Oklab = ((ColorSpace)v3_1);
        ColorSpaces.ColorSpacesArray = new ColorSpace[]{v25, v26, v10, v11, v27, v28, v29, v30, v7, v31, v32, v33, v34, v35, v8, v9, v1, v2, v13, v3_1};
        ColorSpaces.$stable = 8;
    }

    private ColorSpaces() {
        super();
    }

    static final double Bt2020Hlg$lambda$0(double arg2) {
        return ColorSpaces.INSTANCE.transferHlgOetf$ui_graphics(ColorSpaces.Bt2020HlgTransferParameters, arg2);
    }

    static final double Bt2020Hlg$lambda$1(double arg2) {
        return ColorSpaces.INSTANCE.transferHlgEotf$ui_graphics(ColorSpaces.Bt2020HlgTransferParameters, arg2);
    }

    static final double Bt2020Pq$lambda$0(double arg2) {
        return ColorSpaces.INSTANCE.transferSt2048Oetf$ui_graphics(ColorSpaces.Bt2020PqTransferParameters, arg2);
    }

    static final double Bt2020Pq$lambda$1(double arg2) {
        return ColorSpaces.INSTANCE.transferSt2048Eotf$ui_graphics(ColorSpaces.Bt2020PqTransferParameters, arg2);
    }

    static final double ExtendedSrgb$lambda$0(double arg12) {
        return ColorSpaceKt.absRcpResponse(arg12, 0.947867, 0.052133, 0.077399, 0.04045, 2.4);
    }

    static final double ExtendedSrgb$lambda$1(double arg12) {
        return ColorSpaceKt.absResponse(arg12, 0.947867, 0.052133, 0.077399, 0.04045, 2.4);
    }

    public final Rgb getAces() {
        return ColorSpaces.Aces;
    }

    public final Rgb getAcescg() {
        return ColorSpaces.Acescg;
    }

    public final Rgb getAdobeRgb() {
        return ColorSpaces.AdobeRgb;
    }

    public final Rgb getBt2020() {
        return ColorSpaces.Bt2020;
    }

    public final Rgb getBt2020Hlg() {
        return ColorSpaces.Bt2020Hlg;
    }

    public final TransferParameters getBt2020HlgTransferParameters$ui_graphics() {
        return ColorSpaces.Bt2020HlgTransferParameters;
    }

    public final Rgb getBt2020Pq() {
        return ColorSpaces.Bt2020Pq;
    }

    public final TransferParameters getBt2020PqTransferParameters$ui_graphics() {
        return ColorSpaces.Bt2020PqTransferParameters;
    }

    public final float[] getBt2020Primaries$ui_graphics() {
        return ColorSpaces.Bt2020Primaries;
    }

    public final Rgb getBt709() {
        return ColorSpaces.Bt709;
    }

    public final ColorSpace getCieLab() {
        return ColorSpaces.CieLab;
    }

    public final ColorSpace getCieXyz() {
        return ColorSpaces.CieXyz;
    }

    public final ColorSpace getColorSpace$ui_graphics(int arg1) {
        return this.getColorSpacesArray$ui_graphics()[arg1];
    }

    public final ColorSpace[] getColorSpacesArray$ui_graphics() {
        return ColorSpaces.ColorSpacesArray;
    }

    public final Rgb getDciP3() {
        return ColorSpaces.DciP3;
    }

    public final Rgb getDisplayP3() {
        return ColorSpaces.DisplayP3;
    }

    public final Rgb getExtendedSrgb() {
        return ColorSpaces.ExtendedSrgb;
    }

    public final Rgb getLinearExtendedSrgb() {
        return ColorSpaces.LinearExtendedSrgb;
    }

    public final Rgb getLinearSrgb() {
        return ColorSpaces.LinearSrgb;
    }

    public final Rgb getNtsc1953() {
        return ColorSpaces.Ntsc1953;
    }

    public final float[] getNtsc1953Primaries$ui_graphics() {
        return ColorSpaces.Ntsc1953Primaries;
    }

    public final ColorSpace getOklab() {
        return ColorSpaces.Oklab;
    }

    public final Rgb getProPhotoRgb() {
        return ColorSpaces.ProPhotoRgb;
    }

    public final Rgb getSmpteC() {
        return ColorSpaces.SmpteC;
    }

    public final Rgb getSrgb() {
        return ColorSpaces.Srgb;
    }

    public final float[] getSrgbPrimaries$ui_graphics() {
        return ColorSpaces.SrgbPrimaries;
    }

    public final TransferParameters getSrgbTransferParameters$ui_graphics() {
        return ColorSpaces.SrgbTransferParameters;
    }

    public final Rgb getUnspecified$ui_graphics() {
        return ColorSpaces.Unspecified;
    }

    public final ColorSpace match(float[] arg9, TransferParameters arg10) {
        Adaptation v2;
        ColorSpace[] v8 = ColorSpaces.ColorSpacesArray;
        int v0 = v8.length;
        int v1;
        for(v1 = 0; true; ++v1) {
            v2 = null;
            if(v1 >= v0) {
                break;
            }

            ColorSpace v3 = v8[v1];
            if(ColorModel.equals-impl0(v3.getModel-xdoWZVw(), ColorModel.Companion.getRgb-xdoWZVw())) {
                ColorSpace v2_1 = ColorSpaceKt.adapt$default(v3, Illuminant.INSTANCE.getD50(), v2, 2, v2);
                Intrinsics.checkNotNull(v2_1, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
                if((ColorSpaceKt.compare(arg9, ((Rgb)v2_1).getTransform$ui_graphics())) && (ColorSpaceKt.compare(arg10, ((Rgb)v2_1).getTransferParameters()))) {
                    return v3;
                }
            }
        }

        return ((ColorSpace)v2);
    }

    public final double transferHlgEotf$ui_graphics(TransferParameters arg20, double arg21) {
        double v1 = 1;
        double v3 = Double.compare(arg21, 0) < 0 ? -1 : v1;
        double v5 = arg21 * v3;
        double v7 = arg20.getA();
        double v9 = arg20.getB();
        double v11 = arg20.getC();
        double v13 = arg20.getD();
        double v15 = arg20.getE();
        double v17 = arg20.getF() + v1;
        v7 *= v5;
        double v0 = v7 <= v1 ? Math.pow(v7, v9) : Math.exp((v5 - v15) * v11) + v13;
        return v17 * v3 * v0;
    }

    public final double transferHlgOetf$ui_graphics(TransferParameters arg20, double arg21) {
        double v1 = 1;
        double v3 = Double.compare(arg21, 0) < 0 ? -1 : v1;
        double v7 = v1 / arg20.getA();
        double v9 = v1 / arg20.getB();
        double v11 = v1 / arg20.getC();
        double v13 = arg20.getD();
        double v15 = arg20.getE();
        double v5 = arg21 * v3 / (arg20.getF() + v1);
        if(v5 <= v1) {
            v7 *= Math.pow(v5, v9);
        }
        else {
            v7 = v11 * Math.log(v5 - v13) + v15;
        }

        return v3 * v7;
    }

    public final double transferSt2048Eotf$ui_graphics(TransferParameters arg11, double arg12) {
        double v0 = 0;
        double v2 = arg12 < v0 ? -1 : 1;
        arg12 *= v2;
        return v2 * Math.pow(RangesKt.coerceAtLeast(arg11.getA() + arg11.getB() * Math.pow(arg12, arg11.getC()), v0) / (arg11.getD() + arg11.getE() * Math.pow(arg12, arg11.getC())), arg11.getF());
    }

    public final double transferSt2048Oetf$ui_graphics(TransferParameters arg22, double arg23) {
        double v3 = 1;
        double v5 = Double.compare(arg23, 0) < 0 ? -1 : v3;
        double v7 = arg23 * v5;
        double v9 = -arg22.getA();
        double v11 = arg22.getD();
        double v13 = v3 / arg22.getF();
        return v5 * Math.pow(Math.max(v9 + v11 * Math.pow(v7, v13), 0) / (arg22.getB() + -arg22.getE() * Math.pow(v7, v13)), v3 / arg22.getC());
    }
}

