package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.tokens.NavigationBarHorizontalItemTokens;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.material3.tokens.NavigationBarVerticalItemTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001AT\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\u0011\u0010\u000B\u001A\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u000E\u0010\u000F\u001A\u0081\u0001\u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u00122\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00010\f2\u0011\u0010\u0014\u001A\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0015\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\u00122\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0007¢\u0006\u0004\b\u001D\u0010\u001E\u001A\u0018\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020%2\u0006\u0010\'\u001A\u00020%H\u0002\"\u001A\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020!0 X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#\"\u0016\u0010(\u001A\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001A\u0004\b*\u0010+\"\u0016\u0010-\u001A\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001A\u0004\b.\u0010+\"\u0016\u0010/\u001A\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001A\u0004\b0\u0010+\"\u0016\u00101\u001A\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001A\u0004\b2\u0010+\"\u0016\u00103\u001A\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001A\u0004\b4\u0010+\"\u0016\u00105\u001A\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001A\u0004\b6\u0010+\"\u0016\u00107\u001A\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001A\u0004\b8\u0010+¨\u00069"}, d2={"ShortNavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/material3/ShortNavigationBarArrangement;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "ShortNavigationBar-kQ6Tpik", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ShortNavigationBarItem", "selected", "", "onClick", "icon", "label", "enabled", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "colors", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "ShortNavigationBarItem-6ZDA4I0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "LocalShortNavigationBarOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ShortNavigationBarOverride;", "getLocalShortNavigationBarOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "calculateCenteredContentHorizontalPadding", "", "itemsCount", "barWidth", "TopIconItemVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTopIconItemVerticalPadding", "()F", "F", "TopIconIndicatorVerticalPadding", "getTopIconIndicatorVerticalPadding", "TopIconIndicatorHorizontalPadding", "getTopIconIndicatorHorizontalPadding", "StartIconIndicatorVerticalPadding", "getStartIconIndicatorVerticalPadding", "TopIconIndicatorToLabelPadding", "getTopIconIndicatorToLabelPadding", "StartIconIndicatorHorizontalPadding", "getStartIconIndicatorHorizontalPadding", "StartIconToLabelPadding", "getStartIconToLabelPadding", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ShortNavigationBarKt {
    private static final ProvidableCompositionLocal LocalShortNavigationBarOverride;
    private static final float StartIconIndicatorHorizontalPadding;
    private static final float StartIconIndicatorVerticalPadding;
    private static final float StartIconToLabelPadding;
    private static final float TopIconIndicatorHorizontalPadding;
    private static final float TopIconIndicatorToLabelPadding;
    private static final float TopIconIndicatorVerticalPadding;
    private static final float TopIconItemVerticalPadding;

    static {
        ShortNavigationBarKt.LocalShortNavigationBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new ShortNavigationBarKt$$ExternalSyntheticLambda2(), 1, null);
        ShortNavigationBarKt.TopIconItemVerticalPadding = NavigationBarVerticalItemTokens.INSTANCE.getContainerBetweenSpace-D9Ej5fM();
        ShortNavigationBarKt.TopIconIndicatorVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(NavigationBarVerticalItemTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.getIconSize-D9Ej5fM()) / 2f);
        ShortNavigationBarKt.TopIconIndicatorHorizontalPadding = Dp.constructor-impl(Dp.constructor-impl(NavigationBarVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.getIconSize-D9Ej5fM()) / 2f);
        ShortNavigationBarKt.StartIconIndicatorVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(NavigationBarHorizontalItemTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM() - NavigationBarHorizontalItemTokens.INSTANCE.getIconSize-D9Ej5fM()) / 2f);
        ShortNavigationBarKt.TopIconIndicatorToLabelPadding = Dp.constructor-impl(4f);
        ShortNavigationBarKt.StartIconIndicatorHorizontalPadding = NavigationBarHorizontalItemTokens.INSTANCE.getActiveIndicatorLeadingSpace-D9Ej5fM();
        ShortNavigationBarKt.StartIconToLabelPadding = NavigationBarTokens.INSTANCE.getItemActiveIndicatorIconLabelSpace-D9Ej5fM();
    }

    static final ShortNavigationBarOverride LocalShortNavigationBarOverride$lambda$4() {
        return DefaultShortNavigationBarOverride.INSTANCE;
    }

    public static final void ShortNavigationBar-kQ6Tpik(Modifier arg23, long arg24, long arg26, WindowInsets arg28, int arg29, Function2 arg30, Composer arg31, int arg32, int arg33) {
        WindowInsets v6;
        long v4_1;
        long v2_3;
        Modifier v14_1;
        WindowInsets v19;
        long v17;
        int v20;
        Companion v14_2;
        Companion v2_1;
        Function2 v12_1;
        int v12;
        int v11;
        WindowInsets v10_1;
        int v10;
        long v7_1;
        int v7;
        long v5;
        Modifier v3;
        int v4;
        int v9 = arg32;
        int v0 = 0x20E82F74;
        Composer v1 = arg31.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(ShortNavigationBar)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,windowInsets,arrangement:c#material3.ShortNavigationBarArrangement,content)102@4884L7,*111@5217L20:ShortNavigationBar.kt#uh7d8r");
        int v2 = arg33 & 1;
        if(v2 != 0) {
            v4 = v9 | 6;
            v3 = arg23;
        }
        else if((v9 & 6) == 0) {
            v3 = arg23;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v9;
        }
        else {
            v3 = arg23;
            v4 = v9;
        }

        if((v9 & 0x30) == 0) {
            if((arg33 & 2) == 0) {
                v5 = arg24;
                if(v1.changed(v5)) {
                    v7 = 0x20;
                }
                else {
                    goto label_34;
                }
            }
            else {
                v5 = arg24;
            label_34:
                v7 = 16;
            }

            v4 |= v7;
        }
        else {
            v5 = arg24;
        }

        if((v9 & 0x180) == 0) {
            if((arg33 & 4) == 0) {
                v7_1 = arg26;
                if(v1.changed(v7_1)) {
                    v10 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v7_1 = arg26;
            label_48:
                v10 = 0x80;
            }

            v4 |= v10;
        }
        else {
            v7_1 = arg26;
        }

        if((v9 & 0xC00) == 0) {
            if((arg33 & 8) == 0) {
                v10_1 = arg28;
                if(v1.changed(v10_1)) {
                    v11 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v10_1 = arg28;
            label_62:
                v11 = 0x400;
            }

            v4 |= v11;
        }
        else {
            v10_1 = arg28;
        }

        if((v9 & 0x6000) == 0) {
            if((arg33 & 16) == 0) {
                v11 = arg29;
                if(v1.changed(v11)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_76;
                }
            }
            else {
                v11 = arg29;
            label_76:
                v12 = 0x2000;
            }

            v4 |= v12;
        }
        else {
            v11 = arg29;
        }

        int v13 = 0x30000;
        if((arg33 & 0x20) != 0) {
            v4 |= v13;
            goto label_95;
        }
        else if((v9 & v13) == 0) {
            v12_1 = arg30;
            v13 = v1.changedInstance(v12_1) ? 0x20000 : 0x10000;
            v4 |= v13;
        }
        else {
        label_95:
            v12_1 = arg30;
        }

        boolean v13_1 = (74899 & v4) != 74898 ? true : false;
        if(v1.shouldExecute(v13_1, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "96@4556L14,97@4625L12,98@4699L12");
            int v14 = 0xFFFF1FFF;
            if((v9 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v2_1 = Modifier.Companion;
                }
                else {
                    Modifier v2_2 = v3;
                }

                v13 = 6;
                if((arg33 & 2) != 0) {
                    v5 = ShortNavigationBarDefaults.INSTANCE.getContainerColor(v1, v13);
                    v4 &= 0xFFFFFF8F;
                }

                if((arg33 & 4) != 0) {
                    v7_1 = ShortNavigationBarDefaults.INSTANCE.getContentColor(v1, v13);
                    v4 &= -897;
                }

                if((arg33 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                    v10_1 = ShortNavigationBarDefaults.INSTANCE.getWindowInsets(v1, v13);
                }

                if((arg33 & 16) != 0) {
                    v4 &= v14;
                    v14_2 = v2_1;
                    v20 = ShortNavigationBarDefaults.INSTANCE.getArrangement-LnnQw40();
                    v17 = v7_1;
                    v19 = v10_1;
                    goto label_166;
                }

                v14_2 = v2_1;
            label_163:
                v17 = v7_1;
                v19 = v10_1;
                v20 = v11;
            }
            else {
                v1.skipToGroupEnd();
                if((arg33 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((arg33 & 4) != 0) {
                    v4 &= -897;
                }

                if((arg33 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                if((arg33 & 16) != 0) {
                    v4 &= v14;
                }

                v14_1 = v3;
                goto label_163;
            }

        label_166:
            long v15 = v5;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.material3.ShortNavigationBar (ShortNavigationBar.kt:101)");
            }

            ProvidableCompositionLocal v0_1 = ShortNavigationBarKt.LocalShortNavigationBarOverride;
            ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = v1.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v1);
            ((ShortNavigationBarOverride)v0_2).ShortNavigationBar(new ShortNavigationBarOverrideScope(((Modifier)v14_2), v15, v17, v19, v20, v12_1, null), v1, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_3 = v15;
            v4_1 = v17;
            v6 = v19;
            v7 = v20;
        }
        else {
            v1.skipToGroupEnd();
            v14_1 = v3;
            v2_3 = v5;
            v4_1 = v7_1;
            v6 = v10_1;
            v7 = v11;
        }

        ScopeUpdateScope v11_1 = v1.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new ShortNavigationBarKt$$ExternalSyntheticLambda0(((Modifier)v14_2), v2_3, v4_1, v6, v7, arg30, v9, arg33));
        }
    }

    public static final void ShortNavigationBarItem-6ZDA4I0(boolean arg32, Function0 arg33, Function2 arg34, Function2 arg35, Modifier arg36, boolean arg37, int arg38, NavigationItemColors arg39, MutableInteractionSource arg40, Composer arg41, int arg42, int arg43) {
        boolean v6_2;
        NavigationItemColors v8_1;
        MutableInteractionSource v9_1;
        Composer v29;
        Object v28;
        MutableInteractionSource v5_3;
        MutableInteractionSource v0_2;
        NavigationItemColors v23;
        boolean v25;
        Modifier v24;
        Companion v5_1;
        int v16;
        NavigationItemColors v15_1;
        int v8;
        boolean v7_1;
        int v6;
        Modifier v5;
        Function2 v4;
        Function2 v14;
        int v3;
        Function0 v13;
        boolean v12;
        int v2;
        int v10 = arg42;
        int v11 = arg43;
        Composer v1 = arg41.startRestartGroup(0xBA8F8FD0);
        ComposerKt.sourceInformation(v1, "C(ShortNavigationBarItem)N(selected,onClick,icon,label,modifier,enabled,iconPosition:c#material3.NavigationItemIconPosition,colors,interactionSource)241@10566L5,242@10643L5,237@10414L842:ShortNavigationBar.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v2 = v10 | 6;
            v12 = arg32;
        }
        else {
            v12 = arg32;
            if((v10 & 6) == 0) {
                v2 = v1.changed(v12) ? 4 : 2;
                v2 |= v10;
            }
            else {
                v2 = v10;
            }
        }

        if((v11 & 2) != 0) {
            v2 |= 0x30;
            v13 = arg33;
        }
        else {
            v13 = arg33;
            if((v10 & 0x30) == 0) {
                v3 = v1.changedInstance(v13) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        if((v11 & 4) != 0) {
            v2 |= 0x180;
            v14 = arg34;
        }
        else {
            v14 = arg34;
            if((v10 & 0x180) == 0) {
                v3 = v1.changedInstance(v14) ? 0x100 : 0x80;
                v2 |= v3;
            }
        }

        if((v11 & 8) != 0) {
            v2 |= 0xC00;
            v4 = arg35;
        }
        else {
            v4 = arg35;
            if((v10 & 0xC00) == 0) {
                v3 = v1.changedInstance(v4) ? 0x800 : 0x400;
                v2 |= v3;
            }
        }

        v3 = v11 & 16;
        if(v3 != 0) {
            v2 |= 0x6000;
            goto label_79;
        }
        else if((v10 & 0x6000) == 0) {
            v5 = arg36;
            v6 = v1.changed(v5) ? 0x4000 : 0x2000;
            v2 |= v6;
        }
        else {
        label_79:
            v5 = arg36;
        }

        v6 = v11 & 0x20;
        int v7 = 0x30000;
        if(v6 != 0) {
            v2 |= v7;
            goto label_95;
        }
        else if((v7 & v10) == 0) {
            v7_1 = arg37;
            v8 = v1.changed(v7_1) ? 0x20000 : 0x10000;
            v2 |= v8;
        }
        else {
        label_95:
            v7_1 = arg37;
        }

        v8 = v11 & 0x40;
        int v9 = 0x180000;
        if(v8 != 0) {
            v2 |= v9;
            goto label_111;
        }
        else if((v9 & v10) == 0) {
            v9 = arg38;
            int v15 = v1.changed(v9) ? 0x100000 : 0x80000;
            v2 |= v15;
        }
        else {
        label_111:
            v9 = arg38;
        }

        if((0xC00000 & v10) == 0) {
            if((v11 & 0x80) == 0) {
                v15_1 = arg39;
                if(v1.changed(v15_1)) {
                    v16 = 0x800000;
                }
                else {
                    goto label_123;
                }
            }
            else {
                v15_1 = arg39;
            label_123:
                v16 = 0x400000;
            }

            v2 |= v16;
        }
        else {
            v15_1 = arg39;
        }

        int v0 = v11 & 0x100;
        int v17 = 0x6000000;
        if(v0 != 0) {
            v2 |= v17;
            goto label_143;
        }
        else if((v10 & v17) == 0) {
            v17 = v0;
            int v18 = v1.changed(arg40) ? 0x4000000 : 0x2000000;
            v2 |= v18;
        }
        else {
        label_143:
            v17 = v0;
        }

        int v41 = v2;
        boolean v0_1 = (v2 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_1, v41 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "217@9765L8");
            int v19 = 0xFE3FFFFF;
            v2 = 6;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    v5_1 = Modifier.Companion;
                }

                if(v6 != 0) {
                    v7_1 = true;
                }

                if(v8 != 0) {
                    v9 = NavigationItemIconPosition.Companion.getTop--xw1Ddg();
                }

                if((v11 & 0x80) != 0) {
                    v3 = v41 & v19;
                    v15_1 = ShortNavigationBarItemDefaults.INSTANCE.colors(v1, v2);
                }
                else {
                    v3 = v41;
                }

                v0_2 = v17 != 0 ? null : arg40;
            label_179:
                v24 = ((Modifier)v5_1);
                v25 = v7_1;
                v23 = v15_1;
            }
            else {
                v1.skipToGroupEnd();
                if((v11 & 0x80) != 0) {
                    v3 = v41 & v19;
                    v24 = v5;
                    v25 = v7_1;
                    v23 = v15_1;
                    v0_2 = arg40;
                }
                else {
                    v0_2 = arg40;
                    v3 = v41;
                    goto label_179;
                }
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xBA8F8FD0, v3, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:219)");
            }

            if(v0_2 == null) {
                v1.startReplaceGroup(0x487885CB);
                ComposerKt.sourceInformation(v1, "221@9917L39");
                ComposerKt.sourceInformationMarkerStart(v1, 0x54EB1D17, "CC(remember):ShortNavigationBar.kt#9igjgp");
                Object v5_2 = v1.rememberedValue();
                if(v5_2 == Composer.Companion.getEmpty()) {
                    v5_3 = InteractionSourceKt.MutableInteractionSource();
                    v1.updateRememberedValue(v5_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v1);
                v1.endReplaceGroup();
                v28 = v5_3;
            }
            else {
                v1.startReplaceGroup(1424693900);
                v1.endReplaceGroup();
                MutableInteractionSource v28_1 = v0_2;
            }

            boolean v5_4 = NavigationItemIconPosition.equals-impl0(v9, NavigationItemIconPosition.Companion.getTop--xw1Ddg());
            float v6_1 = v5_4 ? ShortNavigationBarKt.TopIconIndicatorHorizontalPadding : ShortNavigationBarKt.StartIconIndicatorHorizontalPadding;
            float v18_1 = v6_1;
            float v5_5 = v5_4 ? ShortNavigationBarKt.TopIconIndicatorVerticalPadding : ShortNavigationBarKt.StartIconIndicatorVerticalPadding;
            float v19_1 = v5_5;
            int v5_6 = v3 >> 6;
            v29 = v1;
            int v27 = v9;
            NavigationItemKt.NavigationItem-8Df7sds(v12, v13, v14, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), v1, v2), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), v1, v2), NavigationBarVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM(), v18_1, v19_1, ShortNavigationBarKt.TopIconIndicatorToLabelPadding, ShortNavigationBarKt.StartIconToLabelPadding, ShortNavigationBarKt.TopIconItemVerticalPadding, v23, v24, v25, v4, v27, ((MutableInteractionSource)v28), v29, v3 & 14 | 0x36030000 | v3 & 0x70 | v3 & 0x380, v2 | v3 >> 18 & 0x70 | v5_6 & 0x380 | v5_6 & 0x1C00 | v3 << 3 & 0xE000 | v3 >> 3 & 0x70000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_1 = v0_2;
            v8_1 = v23;
            v5 = v24;
            v6_2 = v25;
            v7 = v27;
        }
        else {
            v29 = v1;
            v29.skipToGroupEnd();
            v6_2 = v7_1;
            v7 = v9;
            v8_1 = v15_1;
            v9_1 = arg40;
        }

        ScopeUpdateScope v12_1 = v29.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new ShortNavigationBarKt$$ExternalSyntheticLambda1(arg32, arg33, arg34, arg35, v5, v6_2, v7, v8_1, v9_1, v10, v11));
        }
    }

    static final Unit ShortNavigationBarItem_6ZDA4I0$lambda$3(boolean arg13, Function0 arg14, Function2 arg15, Function2 arg16, Modifier arg17, boolean arg18, int arg19, NavigationItemColors arg20, MutableInteractionSource arg21, int arg22, int arg23, Composer arg24, int arg25) {
        ShortNavigationBarKt.ShortNavigationBarItem-6ZDA4I0(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit ShortNavigationBar_kQ6Tpik$lambda$1(Modifier arg12, long arg13, long arg15, WindowInsets arg17, int arg18, Function2 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        ShortNavigationBarKt.ShortNavigationBar-kQ6Tpik(arg12, arg13, arg15, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    public static final int access$calculateCenteredContentHorizontalPadding(int arg0, int arg1) {
        return ShortNavigationBarKt.calculateCenteredContentHorizontalPadding(arg0, arg1);
    }

    private static final int calculateCenteredContentHorizontalPadding(int arg1, int arg2) {
        if(arg1 > 6) {
            return 0;
        }

        return MathKt.roundToInt((((float)(100 - (arg1 + 3) * 10))) / 2f / 100f * (((float)arg2)));
    }

    public static final ProvidableCompositionLocal getLocalShortNavigationBarOverride() {
        return ShortNavigationBarKt.LocalShortNavigationBarOverride;
    }

    public static final float getStartIconIndicatorHorizontalPadding() {
        return ShortNavigationBarKt.StartIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconIndicatorVerticalPadding() {
        return ShortNavigationBarKt.StartIconIndicatorVerticalPadding;
    }

    public static final float getStartIconToLabelPadding() {
        return ShortNavigationBarKt.StartIconToLabelPadding;
    }

    public static final float getTopIconIndicatorHorizontalPadding() {
        return ShortNavigationBarKt.TopIconIndicatorHorizontalPadding;
    }

    public static final float getTopIconIndicatorToLabelPadding() {
        return ShortNavigationBarKt.TopIconIndicatorToLabelPadding;
    }

    public static final float getTopIconIndicatorVerticalPadding() {
        return ShortNavigationBarKt.TopIconIndicatorVerticalPadding;
    }

    public static final float getTopIconItemVerticalPadding() {
        return ShortNavigationBarKt.TopIconItemVerticalPadding;
    }
}

