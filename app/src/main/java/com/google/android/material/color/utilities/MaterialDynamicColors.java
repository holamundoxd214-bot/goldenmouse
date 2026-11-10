package com.google.android.material.color.utilities;

public final class MaterialDynamicColors {
    public MaterialDynamicColors() {
        super();
    }

    public DynamicColor background() {
        return new DynamicColor("background", new MaterialDynamicColors$$ExternalSyntheticLambda100(), new MaterialDynamicColors$$ExternalSyntheticLambda101(), true, null, null, null, null);
    }

    public DynamicColor controlActivated() {
        return DynamicColor.fromPalette("control_activated", new MaterialDynamicColors$$ExternalSyntheticLambda70(), new MaterialDynamicColors$$ExternalSyntheticLambda71());
    }

    public DynamicColor controlHighlight() {
        return new DynamicColor("control_highlight", new MaterialDynamicColors$$ExternalSyntheticLambda93(), new MaterialDynamicColors$$ExternalSyntheticLambda94(), false, null, null, null, null, new MaterialDynamicColors$$ExternalSyntheticLambda95());
    }

    public DynamicColor controlNormal() {
        return DynamicColor.fromPalette("control_normal", new MaterialDynamicColors$$ExternalSyntheticLambda55(), new MaterialDynamicColors$$ExternalSyntheticLambda66());
    }

    public DynamicColor error() {
        return new DynamicColor("error", new MaterialDynamicColors$$ExternalSyntheticLambda32(), new MaterialDynamicColors$$ExternalSyntheticLambda34(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(3, 4.5, 7, 11), new MaterialDynamicColors$$ExternalSyntheticLambda35(this));
    }

    public DynamicColor errorContainer() {
        return new DynamicColor("error_container", new MaterialDynamicColors$$ExternalSyntheticLambda50(), new MaterialDynamicColors$$ExternalSyntheticLambda51(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1, 1, 3, 7), new MaterialDynamicColors$$ExternalSyntheticLambda52(this));
    }

    static double findDesiredChromaByTone(double arg8, double arg10, double arg12, boolean arg14) {
        Hct v0 = Hct.from(arg8, arg10, arg12);
        if(v0.getChroma() < arg10) {
            double v1;
            for(v1 = v0.getChroma(); v0.getChroma() < arg10; v1 = Math.max(v1, v3_1.getChroma())) {
                double v3 = arg14 ? -1 : 1;
                arg12 += v3;
                Hct v3_1 = Hct.from(arg8, arg10, arg12);
                if(v1 > v3_1.getChroma()) {
                }
                else {
                    if(Math.abs(v3_1.getChroma() - arg10) < 0.4) {
                        return arg12;
                    }

                    goto label_21;
                }

                return arg12;
            label_21:
                if(Math.abs(v3_1.getChroma() - arg10) < Math.abs(v0.getChroma() - arg10)) {
                    v0 = v3_1;
                }
            }
        }

        return arg12;
    }

    public DynamicColor highestSurface(DynamicScheme arg1) {
        if(arg1.isDark) {
            return this.surfaceBright();
        }

        return this.surfaceDim();
    }

    public DynamicColor inverseOnSurface() {
        return new DynamicColor("inverse_on_surface", new MaterialDynamicColors$$ExternalSyntheticLambda18(), new MaterialDynamicColors$$ExternalSyntheticLambda19(), false, new MaterialDynamicColors$$ExternalSyntheticLambda20(this), null, new ContrastCurve(4.5, 7, 11, 21), null);
    }

    public DynamicColor inversePrimary() {
        return new DynamicColor("inverse_primary", new MaterialDynamicColors$$ExternalSyntheticLambda115(), new MaterialDynamicColors$$ExternalSyntheticLambda116(), false, new MaterialDynamicColors$$ExternalSyntheticLambda117(this), null, new ContrastCurve(3, 4.5, 7, 11), null);
    }

    public DynamicColor inverseSurface() {
        return new DynamicColor("inverse_surface", new MaterialDynamicColors$$ExternalSyntheticLambda42(), new MaterialDynamicColors$$ExternalSyntheticLambda43(), false, null, null, null, null);
    }

    private static boolean isFidelity(DynamicScheme arg2) {
        if(arg2.variant != Variant.FIDELITY) {
            if(arg2.variant == Variant.CONTENT) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static boolean isMonochrome(DynamicScheme arg1) {
        if(arg1.variant == Variant.MONOCHROME) {
            return 1;
        }

        return 0;
    }

    static TonalPalette lambda$background$10(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$background$11(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 6 : 98;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$controlActivated$145(DynamicScheme arg0) {
        return arg0.primaryPalette;
    }

    static Double lambda$controlActivated$146(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 30 : 90;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$controlHighlight$149(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$controlHighlight$150(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 100 : 0;
        return Double.valueOf(v0);
    }

    static Double lambda$controlHighlight$151(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 0.2 : 0.12;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$controlNormal$147(DynamicScheme arg0) {
        return arg0.neutralVariantPalette;
    }

    static Double lambda$controlNormal$148(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 80 : 30;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$error$91(DynamicScheme arg0) {
        return arg0.errorPalette;
    }

    static Double lambda$error$92(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 80 : 40;
        return Double.valueOf(v0);
    }

    ToneDeltaPair lambda$error$93$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.errorContainer(), this.error(), 15, TonePolarity.NEARER, false);
    }

    static TonalPalette lambda$errorContainer$97(DynamicScheme arg0) {
        return arg0.errorPalette;
    }

    static Double lambda$errorContainer$98(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 30 : 90;
        return Double.valueOf(v0);
    }

    ToneDeltaPair lambda$errorContainer$99$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.errorContainer(), this.error(), 15, TonePolarity.NEARER, false);
    }

    static TonalPalette lambda$inverseOnSurface$39(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$inverseOnSurface$40(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 20 : 95;
        return Double.valueOf(v0);
    }

    DynamicColor lambda$inverseOnSurface$41$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.inverseSurface();
    }

    static TonalPalette lambda$inversePrimary$64(DynamicScheme arg0) {
        return arg0.primaryPalette;
    }

    static Double lambda$inversePrimary$65(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 40 : 80;
        return Double.valueOf(v0);
    }

    DynamicColor lambda$inversePrimary$66$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.inverseSurface();
    }

    static TonalPalette lambda$inverseSurface$37(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$inverseSurface$38(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 90 : 20;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$neutralPaletteKeyColor$6(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$neutralPaletteKeyColor$7(DynamicScheme arg2) {
        return Double.valueOf(arg2.neutralPalette.getKeyColor().getTone());
    }

    static TonalPalette lambda$neutralVariantPaletteKeyColor$8(DynamicScheme arg0) {
        return arg0.neutralVariantPalette;
    }

    static Double lambda$neutralVariantPaletteKeyColor$9(DynamicScheme arg2) {
        return Double.valueOf(arg2.neutralVariantPalette.getKeyColor().getTone());
    }

    static TonalPalette lambda$onBackground$12(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$onBackground$13(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 90 : 10;
        return Double.valueOf(v0);
    }

    DynamicColor lambda$onBackground$14$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.background();
    }

    static TonalPalette lambda$onError$94(DynamicScheme arg0) {
        return arg0.errorPalette;
    }

    static Double lambda$onError$95(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 20 : 100;
        return Double.valueOf(v0);
    }

    DynamicColor lambda$onError$96$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.error();
    }

    static TonalPalette lambda$onErrorContainer$100(DynamicScheme arg0) {
        return arg0.errorPalette;
    }

    static Double lambda$onErrorContainer$101(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 90 : 10;
        return Double.valueOf(v0);
    }

    DynamicColor lambda$onErrorContainer$102$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.errorContainer();
    }

    static TonalPalette lambda$onPrimary$55(DynamicScheme arg0) {
        return arg0.primaryPalette;
    }

    static Double lambda$onPrimary$56(DynamicScheme arg2) {
        double v0;
        if(MaterialDynamicColors.isMonochrome(arg2)) {
            v0 = arg2.isDark ? 10 : 90;
            return Double.valueOf(v0);
        }

        v0 = arg2.isDark ? 20 : 100;
        return Double.valueOf(v0);
    }

    DynamicColor lambda$onPrimary$57$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.primary();
    }

    static TonalPalette lambda$onPrimaryContainer$61(DynamicScheme arg0) {
        return arg0.primaryPalette;
    }

    Double lambda$onPrimaryContainer$62$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg3) {
        double v2;
        if(MaterialDynamicColors.isFidelity(arg3)) {
            return Double.valueOf(DynamicColor.foregroundTone(this.primaryContainer().tone.apply(arg3).doubleValue(), 4.5));
        }

        if(MaterialDynamicColors.isMonochrome(arg3)) {
            v2 = arg3.isDark ? 0 : 100;
            return Double.valueOf(v2);
        }

        v2 = arg3.isDark ? 90 : 10;
        return Double.valueOf(v2);
    }

    DynamicColor lambda$onPrimaryContainer$63$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.primaryContainer();
    }

    static TonalPalette lambda$onPrimaryFixed$109(DynamicScheme arg0) {
        return arg0.primaryPalette;
    }

    static Double lambda$onPrimaryFixed$110(DynamicScheme arg2) {
        double v0 = MaterialDynamicColors.isMonochrome(arg2) ? 100 : 10;
        return Double.valueOf(v0);
    }

    DynamicColor lambda$onPrimaryFixed$111$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.primaryFixedDim();
    }

    DynamicColor lambda$onPrimaryFixed$112$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.primaryFixed();
    }

    static TonalPalette lambda$onPrimaryFixedVariant$113(DynamicScheme arg0) {
        return arg0.primaryPalette;
    }

    static Double lambda$onPrimaryFixedVariant$114(DynamicScheme arg2) {
        double v0 = MaterialDynamicColors.isMonochrome(arg2) ? 90 : 30;
        return Double.valueOf(v0);
    }

    DynamicColor lambda$onPrimaryFixedVariant$115$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.primaryFixedDim();
    }

    DynamicColor lambda$onPrimaryFixedVariant$116$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.primaryFixed();
    }

    static TonalPalette lambda$onSecondary$70(DynamicScheme arg0) {
        return arg0.secondaryPalette;
    }

    static Double lambda$onSecondary$71(DynamicScheme arg3) {
        double v1 = 100;
        if(MaterialDynamicColors.isMonochrome(arg3)) {
            if(arg3.isDark) {
                v1 = 10;
            }

            return Double.valueOf(v1);
        }

        if(arg3.isDark) {
            v1 = 20;
        }

        return Double.valueOf(v1);
    }

    DynamicColor lambda$onSecondary$72$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.secondary();
    }

    static TonalPalette lambda$onSecondaryContainer$76(DynamicScheme arg0) {
        return arg0.secondaryPalette;
    }

    Double lambda$onSecondaryContainer$77$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg3) {
        if(!MaterialDynamicColors.isFidelity(arg3)) {
            double v2 = arg3.isDark ? 90 : 10;
            return Double.valueOf(v2);
        }

        return Double.valueOf(DynamicColor.foregroundTone(this.secondaryContainer().tone.apply(arg3).doubleValue(), 4.5));
    }

    DynamicColor lambda$onSecondaryContainer$78$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.secondaryContainer();
    }

    static TonalPalette lambda$onSecondaryFixed$123(DynamicScheme arg0) {
        return arg0.secondaryPalette;
    }

    static Double lambda$onSecondaryFixed$124(DynamicScheme arg2) {
        return Double.valueOf(10);
    }

    DynamicColor lambda$onSecondaryFixed$125$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.secondaryFixedDim();
    }

    DynamicColor lambda$onSecondaryFixed$126$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.secondaryFixed();
    }

    static TonalPalette lambda$onSecondaryFixedVariant$127(DynamicScheme arg0) {
        return arg0.secondaryPalette;
    }

    static Double lambda$onSecondaryFixedVariant$128(DynamicScheme arg2) {
        double v0 = MaterialDynamicColors.isMonochrome(arg2) ? 25 : 30;
        return Double.valueOf(v0);
    }

    DynamicColor lambda$onSecondaryFixedVariant$129$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.secondaryFixedDim();
    }

    DynamicColor lambda$onSecondaryFixedVariant$130$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.secondaryFixed();
    }

    static TonalPalette lambda$onSurface$31(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$onSurface$32(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 90 : 10;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$onSurfaceVariant$35(DynamicScheme arg0) {
        return arg0.neutralVariantPalette;
    }

    static Double lambda$onSurfaceVariant$36(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 80 : 30;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$onTertiary$82(DynamicScheme arg0) {
        return arg0.tertiaryPalette;
    }

    static Double lambda$onTertiary$83(DynamicScheme arg2) {
        double v0;
        if(MaterialDynamicColors.isMonochrome(arg2)) {
            v0 = arg2.isDark ? 10 : 90;
            return Double.valueOf(v0);
        }

        v0 = arg2.isDark ? 20 : 100;
        return Double.valueOf(v0);
    }

    DynamicColor lambda$onTertiary$84$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.tertiary();
    }

    static TonalPalette lambda$onTertiaryContainer$88(DynamicScheme arg0) {
        return arg0.tertiaryPalette;
    }

    Double lambda$onTertiaryContainer$89$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg3) {
        double v2;
        if(MaterialDynamicColors.isMonochrome(arg3)) {
            v2 = arg3.isDark ? 0 : 100;
            return Double.valueOf(v2);
        }

        if(!MaterialDynamicColors.isFidelity(arg3)) {
            v2 = arg3.isDark ? 90 : 10;
            return Double.valueOf(v2);
        }

        return Double.valueOf(DynamicColor.foregroundTone(this.tertiaryContainer().tone.apply(arg3).doubleValue(), 4.5));
    }

    DynamicColor lambda$onTertiaryContainer$90$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.tertiaryContainer();
    }

    static TonalPalette lambda$onTertiaryFixed$137(DynamicScheme arg0) {
        return arg0.tertiaryPalette;
    }

    static Double lambda$onTertiaryFixed$138(DynamicScheme arg2) {
        double v0 = MaterialDynamicColors.isMonochrome(arg2) ? 100 : 10;
        return Double.valueOf(v0);
    }

    DynamicColor lambda$onTertiaryFixed$139$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.tertiaryFixedDim();
    }

    DynamicColor lambda$onTertiaryFixed$140$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.tertiaryFixed();
    }

    static TonalPalette lambda$onTertiaryFixedVariant$141(DynamicScheme arg0) {
        return arg0.tertiaryPalette;
    }

    static Double lambda$onTertiaryFixedVariant$142(DynamicScheme arg2) {
        double v0 = MaterialDynamicColors.isMonochrome(arg2) ? 90 : 30;
        return Double.valueOf(v0);
    }

    DynamicColor lambda$onTertiaryFixedVariant$143$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.tertiaryFixedDim();
    }

    DynamicColor lambda$onTertiaryFixedVariant$144$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg1) {
        return this.tertiaryFixed();
    }

    static TonalPalette lambda$outline$42(DynamicScheme arg0) {
        return arg0.neutralVariantPalette;
    }

    static Double lambda$outline$43(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 60 : 50;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$outlineVariant$44(DynamicScheme arg0) {
        return arg0.neutralVariantPalette;
    }

    static Double lambda$outlineVariant$45(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 30 : 80;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$primary$52(DynamicScheme arg0) {
        return arg0.primaryPalette;
    }

    static Double lambda$primary$53(DynamicScheme arg2) {
        double v0;
        if(MaterialDynamicColors.isMonochrome(arg2)) {
            v0 = arg2.isDark ? 100 : 0;
            return Double.valueOf(v0);
        }

        v0 = arg2.isDark ? 80 : 40;
        return Double.valueOf(v0);
    }

    ToneDeltaPair lambda$primary$54$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.primaryContainer(), this.primary(), 15, TonePolarity.NEARER, false);
    }

    static TonalPalette lambda$primaryContainer$58(DynamicScheme arg0) {
        return arg0.primaryPalette;
    }

    static Double lambda$primaryContainer$59(DynamicScheme arg2) {
        double v0;
        if(MaterialDynamicColors.isFidelity(arg2)) {
            return Double.valueOf(MaterialDynamicColors.performAlbers(arg2.sourceColorHct, arg2));
        }

        if(MaterialDynamicColors.isMonochrome(arg2)) {
            v0 = arg2.isDark ? 85 : 25;
            return Double.valueOf(v0);
        }

        v0 = arg2.isDark ? 30 : 90;
        return Double.valueOf(v0);
    }

    ToneDeltaPair lambda$primaryContainer$60$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.primaryContainer(), this.primary(), 15, TonePolarity.NEARER, false);
    }

    static TonalPalette lambda$primaryFixed$103(DynamicScheme arg0) {
        return arg0.primaryPalette;
    }

    static Double lambda$primaryFixed$104(DynamicScheme arg2) {
        double v0 = MaterialDynamicColors.isMonochrome(arg2) ? 40 : 90;
        return Double.valueOf(v0);
    }

    ToneDeltaPair lambda$primaryFixed$105$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.primaryFixed(), this.primaryFixedDim(), 10, TonePolarity.LIGHTER, true);
    }

    static TonalPalette lambda$primaryFixedDim$106(DynamicScheme arg0) {
        return arg0.primaryPalette;
    }

    static Double lambda$primaryFixedDim$107(DynamicScheme arg2) {
        double v0 = MaterialDynamicColors.isMonochrome(arg2) ? 30 : 80;
        return Double.valueOf(v0);
    }

    ToneDeltaPair lambda$primaryFixedDim$108$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.primaryFixed(), this.primaryFixedDim(), 10, TonePolarity.LIGHTER, true);
    }

    static TonalPalette lambda$primaryPaletteKeyColor$0(DynamicScheme arg0) {
        return arg0.primaryPalette;
    }

    static Double lambda$primaryPaletteKeyColor$1(DynamicScheme arg2) {
        return Double.valueOf(arg2.primaryPalette.getKeyColor().getTone());
    }

    static TonalPalette lambda$scrim$48(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$scrim$49(DynamicScheme arg2) {
        return Double.valueOf(0);
    }

    static TonalPalette lambda$secondary$67(DynamicScheme arg0) {
        return arg0.secondaryPalette;
    }

    static Double lambda$secondary$68(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 80 : 40;
        return Double.valueOf(v0);
    }

    ToneDeltaPair lambda$secondary$69$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.secondaryContainer(), this.secondary(), 15, TonePolarity.NEARER, false);
    }

    static TonalPalette lambda$secondaryContainer$73(DynamicScheme arg0) {
        return arg0.secondaryPalette;
    }

    static Double lambda$secondaryContainer$74(DynamicScheme arg12) {
        double v1 = 30;
        double v9 = arg12.isDark ? v1 : 90;
        if(MaterialDynamicColors.isMonochrome(arg12)) {
            if(arg12.isDark) {
            }
            else {
                v1 = 85;
            }

            return Double.valueOf(v1);
        }

        if(!MaterialDynamicColors.isFidelity(arg12)) {
            return Double.valueOf(v9);
        }

        return Double.valueOf(MaterialDynamicColors.performAlbers(arg12.secondaryPalette.getHct(MaterialDynamicColors.findDesiredChromaByTone(arg12.secondaryPalette.getHue(), arg12.secondaryPalette.getChroma(), v9, arg12.isDark ^ 1)), arg12));
    }

    ToneDeltaPair lambda$secondaryContainer$75$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.secondaryContainer(), this.secondary(), 15, TonePolarity.NEARER, false);
    }

    static TonalPalette lambda$secondaryFixed$117(DynamicScheme arg0) {
        return arg0.secondaryPalette;
    }

    static Double lambda$secondaryFixed$118(DynamicScheme arg2) {
        double v0 = MaterialDynamicColors.isMonochrome(arg2) ? 80 : 90;
        return Double.valueOf(v0);
    }

    ToneDeltaPair lambda$secondaryFixed$119$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.secondaryFixed(), this.secondaryFixedDim(), 10, TonePolarity.LIGHTER, true);
    }

    static TonalPalette lambda$secondaryFixedDim$120(DynamicScheme arg0) {
        return arg0.secondaryPalette;
    }

    static Double lambda$secondaryFixedDim$121(DynamicScheme arg2) {
        double v0 = MaterialDynamicColors.isMonochrome(arg2) ? 70 : 80;
        return Double.valueOf(v0);
    }

    ToneDeltaPair lambda$secondaryFixedDim$122$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.secondaryFixed(), this.secondaryFixedDim(), 10, TonePolarity.LIGHTER, true);
    }

    static TonalPalette lambda$secondaryPaletteKeyColor$2(DynamicScheme arg0) {
        return arg0.secondaryPalette;
    }

    static Double lambda$secondaryPaletteKeyColor$3(DynamicScheme arg2) {
        return Double.valueOf(arg2.secondaryPalette.getKeyColor().getTone());
    }

    static TonalPalette lambda$shadow$46(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$shadow$47(DynamicScheme arg2) {
        return Double.valueOf(0);
    }

    static TonalPalette lambda$surface$15(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$surface$16(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 6 : 98;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$surfaceBright$19(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$surfaceBright$20(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 24 : 98;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$surfaceContainer$25(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$surfaceContainer$26(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 12 : 94;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$surfaceContainerHigh$27(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$surfaceContainerHigh$28(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 17 : 92;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$surfaceContainerHighest$29(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$surfaceContainerHighest$30(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 22 : 90;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$surfaceContainerLow$23(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$surfaceContainerLow$24(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 10 : 96;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$surfaceContainerLowest$21(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$surfaceContainerLowest$22(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 4 : 100;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$surfaceDim$17(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$surfaceDim$18(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 6 : 87;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$surfaceTint$50(DynamicScheme arg0) {
        return arg0.primaryPalette;
    }

    static Double lambda$surfaceTint$51(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 80 : 40;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$surfaceVariant$33(DynamicScheme arg0) {
        return arg0.neutralVariantPalette;
    }

    static Double lambda$surfaceVariant$34(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 30 : 90;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$tertiary$79(DynamicScheme arg0) {
        return arg0.tertiaryPalette;
    }

    static Double lambda$tertiary$80(DynamicScheme arg2) {
        double v0;
        if(MaterialDynamicColors.isMonochrome(arg2)) {
            v0 = arg2.isDark ? 90 : 25;
            return Double.valueOf(v0);
        }

        v0 = arg2.isDark ? 80 : 40;
        return Double.valueOf(v0);
    }

    ToneDeltaPair lambda$tertiary$81$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.tertiaryContainer(), this.tertiary(), 15, TonePolarity.NEARER, false);
    }

    static TonalPalette lambda$tertiaryContainer$85(DynamicScheme arg0) {
        return arg0.tertiaryPalette;
    }

    static Double lambda$tertiaryContainer$86(DynamicScheme arg3) {
        double v0;
        if(MaterialDynamicColors.isMonochrome(arg3)) {
            v0 = arg3.isDark ? 60 : 49;
            return Double.valueOf(v0);
        }

        if(!MaterialDynamicColors.isFidelity(arg3)) {
            v0 = arg3.isDark ? 30 : 90;
            return Double.valueOf(v0);
        }

        return Double.valueOf(DislikeAnalyzer.fixIfDisliked(arg3.tertiaryPalette.getHct(MaterialDynamicColors.performAlbers(arg3.tertiaryPalette.getHct(arg3.sourceColorHct.getTone()), arg3))).getTone());
    }

    ToneDeltaPair lambda$tertiaryContainer$87$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.tertiaryContainer(), this.tertiary(), 15, TonePolarity.NEARER, false);
    }

    static TonalPalette lambda$tertiaryFixed$131(DynamicScheme arg0) {
        return arg0.tertiaryPalette;
    }

    static Double lambda$tertiaryFixed$132(DynamicScheme arg2) {
        double v0 = MaterialDynamicColors.isMonochrome(arg2) ? 40 : 90;
        return Double.valueOf(v0);
    }

    ToneDeltaPair lambda$tertiaryFixed$133$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.tertiaryFixed(), this.tertiaryFixedDim(), 10, TonePolarity.LIGHTER, true);
    }

    static TonalPalette lambda$tertiaryFixedDim$134(DynamicScheme arg0) {
        return arg0.tertiaryPalette;
    }

    static Double lambda$tertiaryFixedDim$135(DynamicScheme arg2) {
        double v0 = MaterialDynamicColors.isMonochrome(arg2) ? 30 : 80;
        return Double.valueOf(v0);
    }

    ToneDeltaPair lambda$tertiaryFixedDim$136$com-google-android-material-color-utilities-MaterialDynamicColors(DynamicScheme arg8) {
        return new ToneDeltaPair(this.tertiaryFixed(), this.tertiaryFixedDim(), 10, TonePolarity.LIGHTER, true);
    }

    static TonalPalette lambda$tertiaryPaletteKeyColor$4(DynamicScheme arg0) {
        return arg0.tertiaryPalette;
    }

    static Double lambda$tertiaryPaletteKeyColor$5(DynamicScheme arg2) {
        return Double.valueOf(arg2.tertiaryPalette.getKeyColor().getTone());
    }

    static TonalPalette lambda$textHintInverse$160(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$textHintInverse$161(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 10 : 90;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$textPrimaryInverse$152(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$textPrimaryInverse$153(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 10 : 90;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$textPrimaryInverseDisableOnly$156(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$textPrimaryInverseDisableOnly$157(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 10 : 90;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$textSecondaryAndTertiaryInverse$154(DynamicScheme arg0) {
        return arg0.neutralVariantPalette;
    }

    static Double lambda$textSecondaryAndTertiaryInverse$155(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 30 : 80;
        return Double.valueOf(v0);
    }

    static TonalPalette lambda$textSecondaryAndTertiaryInverseDisabled$158(DynamicScheme arg0) {
        return arg0.neutralPalette;
    }

    static Double lambda$textSecondaryAndTertiaryInverseDisabled$159(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 10 : 90;
        return Double.valueOf(v0);
    }

    public DynamicColor neutralPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda11(), new MaterialDynamicColors$$ExternalSyntheticLambda22());
    }

    public DynamicColor neutralVariantPaletteKeyColor() {
        return DynamicColor.fromPalette("neutral_variant_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda144(), new MaterialDynamicColors$$ExternalSyntheticLambda145());
    }

    public DynamicColor onBackground() {
        return new DynamicColor("on_background", new MaterialDynamicColors$$ExternalSyntheticLambda104(), new MaterialDynamicColors$$ExternalSyntheticLambda105(), false, new MaterialDynamicColors$$ExternalSyntheticLambda106(this), null, new ContrastCurve(3, 3, 4.5, 7), null);
    }

    public DynamicColor onError() {
        return new DynamicColor("on_error", new MaterialDynamicColors$$ExternalSyntheticLambda130(), new MaterialDynamicColors$$ExternalSyntheticLambda131(), false, new MaterialDynamicColors$$ExternalSyntheticLambda132(this), null, new ContrastCurve(4.5, 7, 11, 21), null);
    }

    public DynamicColor onErrorContainer() {
        return new DynamicColor("on_error_container", new MaterialDynamicColors$$ExternalSyntheticLambda45(), new MaterialDynamicColors$$ExternalSyntheticLambda46(), false, new MaterialDynamicColors$$ExternalSyntheticLambda47(this), null, new ContrastCurve(4.5, 7, 11, 21), null);
    }

    public DynamicColor onPrimary() {
        return new DynamicColor("on_primary", new MaterialDynamicColors$$ExternalSyntheticLambda112(), new MaterialDynamicColors$$ExternalSyntheticLambda113(), false, new MaterialDynamicColors$$ExternalSyntheticLambda114(this), null, new ContrastCurve(4.5, 7, 11, 21), null);
    }

    public DynamicColor onPrimaryContainer() {
        return new DynamicColor("on_primary_container", new MaterialDynamicColors$$ExternalSyntheticLambda135(), new MaterialDynamicColors$$ExternalSyntheticLambda136(this), false, new MaterialDynamicColors$$ExternalSyntheticLambda137(this), null, new ContrastCurve(4.5, 7, 11, 21), null);
    }

    public DynamicColor onPrimaryFixed() {
        return new DynamicColor("on_primary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda28(), new MaterialDynamicColors$$ExternalSyntheticLambda29(), false, new MaterialDynamicColors$$ExternalSyntheticLambda30(this), new MaterialDynamicColors$$ExternalSyntheticLambda31(this), new ContrastCurve(4.5, 7, 11, 21), null);
    }

    public DynamicColor onPrimaryFixedVariant() {
        return new DynamicColor("on_primary_fixed_variant", new MaterialDynamicColors$$ExternalSyntheticLambda122(), new MaterialDynamicColors$$ExternalSyntheticLambda123(), false, new MaterialDynamicColors$$ExternalSyntheticLambda124(this), new MaterialDynamicColors$$ExternalSyntheticLambda125(this), new ContrastCurve(3, 4.5, 7, 11), null);
    }

    public DynamicColor onSecondary() {
        return new DynamicColor("on_secondary", new MaterialDynamicColors$$ExternalSyntheticLambda1(), new MaterialDynamicColors$$ExternalSyntheticLambda2(), false, new MaterialDynamicColors$$ExternalSyntheticLambda3(this), null, new ContrastCurve(4.5, 7, 11, 21), null);
    }

    public DynamicColor onSecondaryContainer() {
        return new DynamicColor("on_secondary_container", new MaterialDynamicColors$$ExternalSyntheticLambda25(), new MaterialDynamicColors$$ExternalSyntheticLambda26(this), false, new MaterialDynamicColors$$ExternalSyntheticLambda27(this), null, new ContrastCurve(4.5, 7, 11, 21), null);
    }

    public DynamicColor onSecondaryFixed() {
        return new DynamicColor("on_secondary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda14(), new MaterialDynamicColors$$ExternalSyntheticLambda15(), false, new MaterialDynamicColors$$ExternalSyntheticLambda16(this), new MaterialDynamicColors$$ExternalSyntheticLambda17(this), new ContrastCurve(4.5, 7, 11, 21), null);
    }

    public DynamicColor onSecondaryFixedVariant() {
        return new DynamicColor("on_secondary_fixed_variant", new MaterialDynamicColors$$ExternalSyntheticLambda62(), new MaterialDynamicColors$$ExternalSyntheticLambda63(), false, new MaterialDynamicColors$$ExternalSyntheticLambda64(this), new MaterialDynamicColors$$ExternalSyntheticLambda65(this), new ContrastCurve(3, 4.5, 7, 11), null);
    }

    public DynamicColor onSurface() {
        return new DynamicColor("on_surface", new MaterialDynamicColors$$ExternalSyntheticLambda140(), new MaterialDynamicColors$$ExternalSyntheticLambda151(), false, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(4.5, 7, 11, 21), null);
    }

    public DynamicColor onSurfaceVariant() {
        return new DynamicColor("on_surface_variant", new MaterialDynamicColors$$ExternalSyntheticLambda40(), new MaterialDynamicColors$$ExternalSyntheticLambda41(), false, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(3, 4.5, 7, 11), null);
    }

    public DynamicColor onTertiary() {
        return new DynamicColor("on_tertiary", new MaterialDynamicColors$$ExternalSyntheticLambda107(), new MaterialDynamicColors$$ExternalSyntheticLambda118(), false, new MaterialDynamicColors$$ExternalSyntheticLambda129(this), null, new ContrastCurve(4.5, 7, 11, 21), null);
    }

    public DynamicColor onTertiaryContainer() {
        return new DynamicColor("on_tertiary_container", new MaterialDynamicColors$$ExternalSyntheticLambda21(), new MaterialDynamicColors$$ExternalSyntheticLambda23(this), false, new MaterialDynamicColors$$ExternalSyntheticLambda24(this), null, new ContrastCurve(4.5, 7, 11, 21), null);
    }

    public DynamicColor onTertiaryFixed() {
        return new DynamicColor("on_tertiary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda87(), new MaterialDynamicColors$$ExternalSyntheticLambda88(), false, new MaterialDynamicColors$$ExternalSyntheticLambda89(this), new MaterialDynamicColors$$ExternalSyntheticLambda90(this), new ContrastCurve(4.5, 7, 11, 21), null);
    }

    public DynamicColor onTertiaryFixedVariant() {
        return new DynamicColor("on_tertiary_fixed_variant", new MaterialDynamicColors$$ExternalSyntheticLambda75(), new MaterialDynamicColors$$ExternalSyntheticLambda76(), false, new MaterialDynamicColors$$ExternalSyntheticLambda77(this), new MaterialDynamicColors$$ExternalSyntheticLambda78(this), new ContrastCurve(3, 4.5, 7, 11), null);
    }

    public DynamicColor outline() {
        return new DynamicColor("outline", new MaterialDynamicColors$$ExternalSyntheticLambda9(), new MaterialDynamicColors$$ExternalSyntheticLambda10(), false, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1.5, 3, 4.5, 7), null);
    }

    public DynamicColor outlineVariant() {
        return new DynamicColor("outline_variant", new MaterialDynamicColors$$ExternalSyntheticLambda108(), new MaterialDynamicColors$$ExternalSyntheticLambda109(), false, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1, 1, 3, 7), null);
    }

    static double performAlbers(Hct arg2, DynamicScheme arg3) {
        Hct v3 = arg2.inViewingConditions(MaterialDynamicColors.viewingConditionsForAlbers(arg3));
        if((DynamicColor.tonePrefersLightForeground(arg2.getTone())) && !DynamicColor.toneAllowsLightForeground(v3.getTone())) {
            return DynamicColor.enableLightForeground(arg2.getTone());
        }

        return DynamicColor.enableLightForeground(v3.getTone());
    }

    public DynamicColor primary() {
        return new DynamicColor("primary", new MaterialDynamicColors$$ExternalSyntheticLambda57(), new MaterialDynamicColors$$ExternalSyntheticLambda58(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(3, 4.5, 7, 11), new MaterialDynamicColors$$ExternalSyntheticLambda59(this));
    }

    public DynamicColor primaryContainer() {
        return new DynamicColor("primary_container", new MaterialDynamicColors$$ExternalSyntheticLambda97(), new MaterialDynamicColors$$ExternalSyntheticLambda98(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1, 1, 3, 7), new MaterialDynamicColors$$ExternalSyntheticLambda99(this));
    }

    public DynamicColor primaryFixed() {
        return new DynamicColor("primary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda153(), new MaterialDynamicColors$$ExternalSyntheticLambda154(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1, 1, 3, 7), new MaterialDynamicColors$$ExternalSyntheticLambda155(this));
    }

    public DynamicColor primaryFixedDim() {
        return new DynamicColor("primary_fixed_dim", new MaterialDynamicColors$$ExternalSyntheticLambda156(), new MaterialDynamicColors$$ExternalSyntheticLambda157(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1, 1, 3, 7), new MaterialDynamicColors$$ExternalSyntheticLambda158(this));
    }

    public DynamicColor primaryPaletteKeyColor() {
        return DynamicColor.fromPalette("primary_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda72(), new MaterialDynamicColors$$ExternalSyntheticLambda73());
    }

    public DynamicColor scrim() {
        return new DynamicColor("scrim", new MaterialDynamicColors$$ExternalSyntheticLambda60(), new MaterialDynamicColors$$ExternalSyntheticLambda61(), false, null, null, null, null);
    }

    public DynamicColor secondary() {
        return new DynamicColor("secondary", new MaterialDynamicColors$$ExternalSyntheticLambda4(), new MaterialDynamicColors$$ExternalSyntheticLambda5(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(3, 4.5, 7, 11), new MaterialDynamicColors$$ExternalSyntheticLambda6(this));
    }

    public DynamicColor secondaryContainer() {
        return new DynamicColor("secondary_container", new MaterialDynamicColors$$ExternalSyntheticLambda83(), new MaterialDynamicColors$$ExternalSyntheticLambda84(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1, 1, 3, 7), new MaterialDynamicColors$$ExternalSyntheticLambda86(this));
    }

    public DynamicColor secondaryFixed() {
        return new DynamicColor("secondary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda119(), new MaterialDynamicColors$$ExternalSyntheticLambda120(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1, 1, 3, 7), new MaterialDynamicColors$$ExternalSyntheticLambda121(this));
    }

    public DynamicColor secondaryFixedDim() {
        return new DynamicColor("secondary_fixed_dim", new MaterialDynamicColors$$ExternalSyntheticLambda138(), new MaterialDynamicColors$$ExternalSyntheticLambda139(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1, 1, 3, 7), new MaterialDynamicColors$$ExternalSyntheticLambda141(this));
    }

    public DynamicColor secondaryPaletteKeyColor() {
        return DynamicColor.fromPalette("secondary_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda79(), new MaterialDynamicColors$$ExternalSyntheticLambda80());
    }

    public DynamicColor shadow() {
        return new DynamicColor("shadow", new MaterialDynamicColors$$ExternalSyntheticLambda148(), new MaterialDynamicColors$$ExternalSyntheticLambda149(), false, null, null, null, null);
    }

    public DynamicColor surface() {
        return new DynamicColor("surface", new MaterialDynamicColors$$ExternalSyntheticLambda0(), new MaterialDynamicColors$$ExternalSyntheticLambda74(), true, null, null, null, null);
    }

    public DynamicColor surfaceBright() {
        return new DynamicColor("surface_bright", new MaterialDynamicColors$$ExternalSyntheticLambda110(), new MaterialDynamicColors$$ExternalSyntheticLambda111(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainer() {
        return new DynamicColor("surface_container", new MaterialDynamicColors$$ExternalSyntheticLambda38(), new MaterialDynamicColors$$ExternalSyntheticLambda39(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainerHigh() {
        return new DynamicColor("surface_container_high", new MaterialDynamicColors$$ExternalSyntheticLambda102(), new MaterialDynamicColors$$ExternalSyntheticLambda103(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainerHighest() {
        return new DynamicColor("surface_container_highest", new MaterialDynamicColors$$ExternalSyntheticLambda150(), new MaterialDynamicColors$$ExternalSyntheticLambda152(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainerLow() {
        return new DynamicColor("surface_container_low", new MaterialDynamicColors$$ExternalSyntheticLambda81(), new MaterialDynamicColors$$ExternalSyntheticLambda82(), true, null, null, null, null);
    }

    public DynamicColor surfaceContainerLowest() {
        return new DynamicColor("surface_container_lowest", new MaterialDynamicColors$$ExternalSyntheticLambda7(), new MaterialDynamicColors$$ExternalSyntheticLambda8(), true, null, null, null, null);
    }

    public DynamicColor surfaceDim() {
        return new DynamicColor("surface_dim", new MaterialDynamicColors$$ExternalSyntheticLambda33(), new MaterialDynamicColors$$ExternalSyntheticLambda44(), true, null, null, null, null);
    }

    public DynamicColor surfaceTint() {
        return new DynamicColor("surface_tint", new MaterialDynamicColors$$ExternalSyntheticLambda12(), new MaterialDynamicColors$$ExternalSyntheticLambda13(), true, null, null, null, null);
    }

    public DynamicColor surfaceVariant() {
        return new DynamicColor("surface_variant", new MaterialDynamicColors$$ExternalSyntheticLambda142(), new MaterialDynamicColors$$ExternalSyntheticLambda143(), true, null, null, null, null);
    }

    public DynamicColor tertiary() {
        return new DynamicColor("tertiary", new MaterialDynamicColors$$ExternalSyntheticLambda67(), new MaterialDynamicColors$$ExternalSyntheticLambda68(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(3, 4.5, 7, 11), new MaterialDynamicColors$$ExternalSyntheticLambda69(this));
    }

    public DynamicColor tertiaryContainer() {
        return new DynamicColor("tertiary_container", new MaterialDynamicColors$$ExternalSyntheticLambda159(), new MaterialDynamicColors$$ExternalSyntheticLambda160(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1, 1, 3, 7), new MaterialDynamicColors$$ExternalSyntheticLambda161(this));
    }

    public DynamicColor tertiaryFixed() {
        return new DynamicColor("tertiary_fixed", new MaterialDynamicColors$$ExternalSyntheticLambda53(), new MaterialDynamicColors$$ExternalSyntheticLambda54(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1, 1, 3, 7), new MaterialDynamicColors$$ExternalSyntheticLambda56(this));
    }

    public DynamicColor tertiaryFixedDim() {
        return new DynamicColor("tertiary_fixed_dim", new MaterialDynamicColors$$ExternalSyntheticLambda126(), new MaterialDynamicColors$$ExternalSyntheticLambda127(), true, new MaterialDynamicColors$$ExternalSyntheticLambda162(this), null, new ContrastCurve(1, 1, 3, 7), new MaterialDynamicColors$$ExternalSyntheticLambda128(this));
    }

    public DynamicColor tertiaryPaletteKeyColor() {
        return DynamicColor.fromPalette("tertiary_palette_key_color", new MaterialDynamicColors$$ExternalSyntheticLambda91(), new MaterialDynamicColors$$ExternalSyntheticLambda92());
    }

    public DynamicColor textHintInverse() {
        return DynamicColor.fromPalette("text_hint_inverse", new MaterialDynamicColors$$ExternalSyntheticLambda146(), new MaterialDynamicColors$$ExternalSyntheticLambda147());
    }

    public DynamicColor textPrimaryInverse() {
        return DynamicColor.fromPalette("text_primary_inverse", new MaterialDynamicColors$$ExternalSyntheticLambda36(), new MaterialDynamicColors$$ExternalSyntheticLambda37());
    }

    public DynamicColor textPrimaryInverseDisableOnly() {
        return DynamicColor.fromPalette("text_primary_inverse_disable_only", new MaterialDynamicColors$$ExternalSyntheticLambda133(), new MaterialDynamicColors$$ExternalSyntheticLambda134());
    }

    public DynamicColor textSecondaryAndTertiaryInverse() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse", new MaterialDynamicColors$$ExternalSyntheticLambda48(), new MaterialDynamicColors$$ExternalSyntheticLambda49());
    }

    public DynamicColor textSecondaryAndTertiaryInverseDisabled() {
        return DynamicColor.fromPalette("text_secondary_and_tertiary_inverse_disabled", new MaterialDynamicColors$$ExternalSyntheticLambda85(), new MaterialDynamicColors$$ExternalSyntheticLambda96());
    }

    private static ViewingConditions viewingConditionsForAlbers(DynamicScheme arg2) {
        double v0 = arg2.isDark ? 30 : 80;
        return ViewingConditions.defaultWithBackgroundLstar(v0);
    }
}

