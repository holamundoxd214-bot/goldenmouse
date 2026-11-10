package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0000\"\u0018\u0010\u0003\u001A\u00020\u0001*\u00020\u00048AX\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006\"\u001A\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2={"fromToken", "Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/material3/Typography;", "value", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getValue", "(Landroidx/compose/material3/tokens/TypographyKeyTokens;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "LocalTypography", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTypography", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TypographyKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[TypographyKeyTokens.values().length];
            try {
                v0[TypographyKeyTokens.DisplayLarge.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[TypographyKeyTokens.DisplayMedium.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[TypographyKeyTokens.DisplaySmall.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[TypographyKeyTokens.HeadlineLarge.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[TypographyKeyTokens.HeadlineMedium.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[TypographyKeyTokens.HeadlineSmall.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[TypographyKeyTokens.TitleLarge.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_31:
                                            v0[TypographyKeyTokens.TitleMedium.ordinal()] = 8;
                                            goto label_35;
                                        }
                                        catch(NoSuchFieldError ) {
                                            try {
                                            label_35:
                                                v0[TypographyKeyTokens.TitleSmall.ordinal()] = 9;
                                                goto label_39;
                                            }
                                            catch(NoSuchFieldError ) {
                                                try {
                                                label_39:
                                                    v0[TypographyKeyTokens.BodyLarge.ordinal()] = 10;
                                                    goto label_43;
                                                }
                                                catch(NoSuchFieldError ) {
                                                    try {
                                                    label_43:
                                                        v0[TypographyKeyTokens.BodyMedium.ordinal()] = 11;
                                                        goto label_47;
                                                    }
                                                    catch(NoSuchFieldError ) {
                                                        try {
                                                        label_47:
                                                            v0[TypographyKeyTokens.BodySmall.ordinal()] = 12;
                                                            goto label_51;
                                                        }
                                                        catch(NoSuchFieldError ) {
                                                            try {
                                                            label_51:
                                                                v0[TypographyKeyTokens.LabelLarge.ordinal()] = 13;
                                                                goto label_55;
                                                            }
                                                            catch(NoSuchFieldError ) {
                                                                try {
                                                                label_55:
                                                                    v0[TypographyKeyTokens.LabelMedium.ordinal()] = 14;
                                                                    goto label_59;
                                                                }
                                                                catch(NoSuchFieldError ) {
                                                                    try {
                                                                    label_59:
                                                                        v0[TypographyKeyTokens.LabelSmall.ordinal()] = 15;
                                                                        goto label_63;
                                                                    }
                                                                    catch(NoSuchFieldError ) {
                                                                        try {
                                                                        label_63:
                                                                            v0[TypographyKeyTokens.DisplayLargeEmphasized.ordinal()] = 16;
                                                                            goto label_67;
                                                                        }
                                                                        catch(NoSuchFieldError ) {
                                                                            try {
                                                                            label_67:
                                                                                v0[TypographyKeyTokens.DisplayMediumEmphasized.ordinal()] = 17;
                                                                                goto label_71;
                                                                            }
                                                                            catch(NoSuchFieldError ) {
                                                                                try {
                                                                                label_71:
                                                                                    v0[TypographyKeyTokens.DisplaySmallEmphasized.ordinal()] = 18;
                                                                                    goto label_75;
                                                                                }
                                                                                catch(NoSuchFieldError ) {
                                                                                    try {
                                                                                    label_75:
                                                                                        v0[TypographyKeyTokens.HeadlineLargeEmphasized.ordinal()] = 19;
                                                                                        goto label_79;
                                                                                    }
                                                                                    catch(NoSuchFieldError ) {
                                                                                        try {
                                                                                        label_79:
                                                                                            v0[TypographyKeyTokens.HeadlineMediumEmphasized.ordinal()] = 20;
                                                                                            goto label_83;
                                                                                        }
                                                                                        catch(NoSuchFieldError ) {
                                                                                            try {
                                                                                            label_83:
                                                                                                v0[TypographyKeyTokens.HeadlineSmallEmphasized.ordinal()] = 21;
                                                                                                goto label_87;
                                                                                            }
                                                                                            catch(NoSuchFieldError ) {
                                                                                                try {
                                                                                                label_87:
                                                                                                    v0[TypographyKeyTokens.TitleLargeEmphasized.ordinal()] = 22;
                                                                                                    goto label_91;
                                                                                                }
                                                                                                catch(NoSuchFieldError ) {
                                                                                                    try {
                                                                                                    label_91:
                                                                                                        v0[TypographyKeyTokens.TitleMediumEmphasized.ordinal()] = 23;
                                                                                                        goto label_95;
                                                                                                    }
                                                                                                    catch(NoSuchFieldError ) {
                                                                                                        try {
                                                                                                        label_95:
                                                                                                            v0[TypographyKeyTokens.TitleSmallEmphasized.ordinal()] = 24;
                                                                                                            goto label_99;
                                                                                                        }
                                                                                                        catch(NoSuchFieldError ) {
                                                                                                            try {
                                                                                                            label_99:
                                                                                                                v0[TypographyKeyTokens.BodyLargeEmphasized.ordinal()] = 25;
                                                                                                                goto label_103;
                                                                                                            }
                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                try {
                                                                                                                label_103:
                                                                                                                    v0[TypographyKeyTokens.BodyMediumEmphasized.ordinal()] = 26;
                                                                                                                    goto label_107;
                                                                                                                }
                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                    try {
                                                                                                                    label_107:
                                                                                                                        v0[TypographyKeyTokens.BodySmallEmphasized.ordinal()] = 27;
                                                                                                                        goto label_111;
                                                                                                                    }
                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                        try {
                                                                                                                        label_111:
                                                                                                                            v0[TypographyKeyTokens.LabelLargeEmphasized.ordinal()] = 28;
                                                                                                                            goto label_115;
                                                                                                                        }
                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                            try {
                                                                                                                            label_115:
                                                                                                                                v0[TypographyKeyTokens.LabelMediumEmphasized.ordinal()] = 29;
                                                                                                                                goto label_119;
                                                                                                                            }
                                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                                try {
                                                                                                                                label_119:
                                                                                                                                    v0[TypographyKeyTokens.LabelSmallEmphasized.ordinal()] = 30;
                                                                                                                                    goto label_123;
                                                                                                                                }
                                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                                label_123:
                                                                                                                                    WhenMappings.$EnumSwitchMapping$0 = v0;
                                                                                                                                    return;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static final ProvidableCompositionLocal LocalTypography;

    static {
        TypographyKt.LocalTypography = CompositionLocalKt.staticCompositionLocalOf(new TypographyKt$$ExternalSyntheticLambda0());
    }

    static final Typography LocalTypography$lambda$0() {
        return new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0x7FFF, null);
    }

    public static final TextStyle fromToken(Typography arg1, TypographyKeyTokens arg2) {
        switch(WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()]) {
            case 1: {
                goto label_65;
            }
            case 2: {
                goto label_63;
            }
            case 3: {
                goto label_61;
            }
            case 4: {
                goto label_59;
            }
            case 5: {
                goto label_57;
            }
            case 6: {
                goto label_55;
            }
            case 7: {
                goto label_53;
            }
            case 8: {
                goto label_51;
            }
            case 9: {
                goto label_49;
            }
            case 10: {
                goto label_47;
            }
            case 11: {
                goto label_45;
            }
            case 12: {
                goto label_43;
            }
            case 13: {
                goto label_41;
            }
            case 14: {
                goto label_39;
            }
            case 15: {
                goto label_37;
            }
            case 16: {
                goto label_35;
            }
            case 17: {
                goto label_33;
            }
            case 18: {
                goto label_31;
            }
            case 19: {
                goto label_29;
            }
            case 20: {
                goto label_27;
            }
            case 21: {
                goto label_25;
            }
            case 22: {
                goto label_23;
            }
            case 23: {
                goto label_21;
            }
            case 24: {
                goto label_19;
            }
            case 25: {
                goto label_17;
            }
            case 26: {
                goto label_15;
            }
            case 27: {
                goto label_13;
            }
            case 28: {
                goto label_11;
            }
            case 29: {
                goto label_9;
            }
            case 30: {
                goto label_7;
            }
        }

        throw new NoWhenBranchMatchedException();
    label_33:
        return arg1.getDisplayMediumEmphasized$material3();
    label_35:
        return arg1.getDisplayLargeEmphasized$material3();
    label_37:
        return arg1.getLabelSmall();
    label_39:
        return arg1.getLabelMedium();
    label_41:
        return arg1.getLabelLarge();
    label_43:
        return arg1.getBodySmall();
    label_45:
        return arg1.getBodyMedium();
    label_47:
        return arg1.getBodyLarge();
    label_49:
        return arg1.getTitleSmall();
    label_51:
        return arg1.getTitleMedium();
    label_53:
        return arg1.getTitleLarge();
    label_55:
        return arg1.getHeadlineSmall();
    label_57:
        return arg1.getHeadlineMedium();
    label_59:
        return arg1.getHeadlineLarge();
    label_61:
        return arg1.getDisplaySmall();
    label_63:
        return arg1.getDisplayMedium();
    label_65:
        return arg1.getDisplayLarge();
    label_7:
        return arg1.getLabelSmallEmphasized$material3();
    label_9:
        return arg1.getLabelMediumEmphasized$material3();
    label_11:
        return arg1.getLabelLargeEmphasized$material3();
    label_13:
        return arg1.getBodySmallEmphasized$material3();
    label_15:
        return arg1.getBodyMediumEmphasized$material3();
    label_17:
        return arg1.getBodyLargeEmphasized$material3();
    label_19:
        return arg1.getTitleSmallEmphasized$material3();
    label_21:
        return arg1.getTitleMediumEmphasized$material3();
    label_23:
        return arg1.getTitleLargeEmphasized$material3();
    label_25:
        return arg1.getHeadlineSmallEmphasized$material3();
    label_27:
        return arg1.getHeadlineMediumEmphasized$material3();
    label_29:
        return arg1.getHeadlineLargeEmphasized$material3();
    label_31:
        return arg1.getDisplaySmallEmphasized$material3();
    }

    public static final ProvidableCompositionLocal getLocalTypography() {
        return TypographyKt.LocalTypography;
    }

    public static final TextStyle getValue(TypographyKeyTokens arg3, Composer arg4, int arg5) {
        int v1 = -1049072145;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(<get-value>)524@28934L10:Typography.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.<get-value> (Typography.kt:524)");
        }

        TextStyle v3 = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(arg4, 6), arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }
}

