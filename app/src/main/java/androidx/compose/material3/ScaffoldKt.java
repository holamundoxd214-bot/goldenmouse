package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A®\u0001\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0013\b\u0002\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\b\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\t\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\u0017\u0010\u0011\u001A\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001A\u0084\u0001\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0017\u001A\u00020\u000B2\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0017\u0010\u0011\u001A\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u00062\u0011\u0010\u0018\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0019\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u000F\u001A\u00020\u00102\u0011\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0004\b\u001A\u0010\u001B\"\u0010\u0010\u001C\u001A\u00020\u001DX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001E¨\u0006\u001F"}, d2={"Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material3/FabPosition;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ScaffoldKt {
    private static final float FabSpacing;

    static {
        ScaffoldKt.FabSpacing = Dp.constructor-impl(16f);
    }

    public static final void Scaffold-TvnljyQ(Modifier arg28, Function2 arg29, Function2 arg30, Function2 arg31, Function2 arg32, int arg33, long arg34, long arg36, WindowInsets arg38, Function3 arg39, Composer arg40, int arg41, int arg42) {
        long v9_1;
        long v7_2;
        WindowInsets v11_1;
        int v6_1;
        Function2 v4_1;
        Function2 v3_3;
        Function2 v2_4;
        Modifier v1_1;
        Composer v25;
        ScaffoldKt$$ExternalSyntheticLambda0 v3_2;
        MutableWindowInsets v15_2;
        int v29;
        WindowInsets v10_1;
        long v19_1;
        int v12_1;
        Function2 v7_1;
        Function2 v5_1;
        Modifier v0_2;
        long v21_1;
        Companion v0_3;
        int v20;
        long v2_1;
        int v40;
        int v17;
        int v0;
        int v15;
        Function2 v12;
        int v11;
        Function2 v10;
        int v9;
        Function2 v8;
        int v7;
        Function2 v6;
        int v4;
        int v13 = arg41;
        int v14 = arg42;
        Composer v1 = arg40.startRestartGroup(0xB7CA3D88);
        ComposerKt.sourceInformation(v1, "C(Scaffold)N(modifier,topBar,bottomBar,snackbarHost,floatingActionButton,floatingActionButtonPosition:c#material3.FabPosition,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,contentWindowInsets,content)94@4873L74,97@5031L224,103@5332L315,95@4952L695:Scaffold.kt#uh7d8r");
        int v2 = v14 & 1;
        if(v2 != 0) {
            v4 = v13 | 6;
        }
        else if((v13 & 6) == 0) {
            v4 = v1.changed(arg28) ? 4 : 2;
            v4 |= v13;
        }
        else {
            v4 = v13;
        }

        int v5 = v14 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_39;
        }
        else if((v13 & 0x30) == 0) {
            v6 = arg29;
            v7 = v1.changedInstance(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_39:
            v6 = arg29;
        }

        v7 = v14 & 4;
        if(v7 != 0) {
            v4 |= 0x180;
            goto label_54;
        }
        else if((v13 & 0x180) == 0) {
            v8 = arg30;
            v9 = v1.changedInstance(v8) ? 0x100 : 0x80;
            v4 |= v9;
        }
        else {
        label_54:
            v8 = arg30;
        }

        v9 = v14 & 8;
        if(v9 != 0) {
            v4 |= 0xC00;
            goto label_69;
        }
        else if((v13 & 0xC00) == 0) {
            v10 = arg31;
            v11 = v1.changedInstance(v10) ? 0x800 : 0x400;
            v4 |= v11;
        }
        else {
        label_69:
            v10 = arg31;
        }

        v11 = v14 & 16;
        if(v11 != 0) {
            v4 |= 0x6000;
            goto label_84;
        }
        else if((v13 & 0x6000) == 0) {
            v12 = arg32;
            v15 = v1.changedInstance(v12) ? 0x4000 : 0x2000;
            v4 |= v15;
        }
        else {
        label_84:
            v12 = arg32;
        }

        v15 = v14 & 0x20;
        int v16 = 0x30000;
        if(v15 != 0) {
            v4 |= v16;
        }
        else {
            v0 = arg33;
            if((v13 & v16) == 0) {
                v17 = v1.changed(v0) ? 0x20000 : 0x10000;
                v4 |= v17;
            }
        }

        if((v13 & 0x180000) == 0) {
            v40 = v2;
            v2_1 = arg34;
            v17 = (v14 & 0x40) != 0 || !v1.changed(v2_1) ? 0x80000 : 0x100000;
            v4 |= v17;
        }
        else {
            v40 = v2;
        }

        v17 = 0xC00000;
        if((v13 & v17) == 0) {
            v2_1 = arg36;
            v0 = (v14 & 0x80) != 0 || !v1.changed(v2_1) ? 0x400000 : 0x800000;
            v4 |= v0;
        }

        int v19 = 0x6000000;
        if((v13 & 0x6000000) == 0) {
            v20 = (v14 & 0x100) != 0 || !v1.changed(arg38) ? 0x2000000 : 0x4000000;
            v4 |= v20;
        }

        v20 = 0x30000000;
        if((v14 & 0x200) != 0) {
            v4 |= v20;
        }
        else if((v13 & v20) == 0) {
            v20 = v1.changedInstance(arg39) ? 0x20000000 : 0x10000000;
            v4 |= v20;
        }

        boolean v0_1 = (v4 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_1, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "89@4637L11,90@4687L31,91@4777L19");
            v2 = 0xFE3FFFFF;
            int v21 = 0xFFC7FFFF;
            if((v13 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v40 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    v0_2 = arg28;
                }

                v5_1 = v5 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$-39202156$material3() : v6;
                v6 = v7 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3() : v8;
                v7_1 = v9 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3() : v10;
                v8 = v11 != 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$-1514016380$material3() : v12;
                v9 = v15 != 0 ? FabPosition.Companion.getEnd-ERTFSPs() : arg33;
                v11 = 6;
                if((v14 & 0x40) != 0) {
                    v4 &= v21;
                    v15 = v2;
                    v2_1 = MaterialTheme.INSTANCE.getColorScheme(v1, v11).getBackground-0d7_KjU();
                }
                else {
                    v15 = v2;
                    v2_1 = arg34;
                }

                if((v14 & 0x80) != 0) {
                    v21_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v2_1, v1, v4 >> 18 & 14);
                    v4 &= v15;
                }
                else {
                    v21_1 = arg36;
                }

                if((v14 & 0x100) != 0) {
                    v10_1 = ScaffoldDefaults.INSTANCE.getContentWindowInsets(v1, v11);
                    v4 &= 0xF1FFFFFF;
                }
                else {
                    v10_1 = arg38;
                }

                v12_1 = v19;
                v19_1 = v21_1;
            }
            else {
                v1.skipToGroupEnd();
                if((v14 & 0x40) != 0) {
                    v4 &= v21;
                }

                if((v14 & 0x80) != 0) {
                    v4 &= v2;
                }

                if((v14 & 0x100) != 0) {
                    v4 &= 0xF1FFFFFF;
                }

                v0_2 = arg28;
                v9 = arg33;
                v2_1 = arg34;
                v5_1 = v6;
                v6 = v8;
                v7_1 = v10;
                v8 = v12;
                v12_1 = v19;
                v19_1 = arg36;
                v10_1 = arg38;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                v29 = v12_1;
                ComposerKt.traceEventStart(0xB7CA3D88, v4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
            }
            else {
                v29 = v12_1;
            }

            ComposerKt.sourceInformationMarkerStart(v1, -298760782, "CC(remember):Scaffold.kt#9igjgp");
            v11 = 0xE000000 & v4 ^ v29;
            v12_1 = 0x4000000;
            v12_1 = v11 > v12_1 && (v1.changed(v10_1)) || (v4 & v29) == v12_1 ? 1 : 0;
            Object v15_1 = v1.rememberedValue();
            if(v12_1 != 0 || v15_1 == Composer.Companion.getEmpty()) {
                v15_2 = new MutableWindowInsets(v10_1);
                v1.updateRememberedValue(v15_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            arg36 = v2_1;
            ComposerKt.sourceInformationMarkerStart(v1, 0xEE315A08, "CC(remember):Scaffold.kt#9igjgp");
            boolean v2_2 = v1.changed(v15_2);
            v12_1 = 0x4000000;
            int v3 = v11 > v12_1 && (v1.changed(v10_1)) || (v4 & v29) == v12_1 ? 1 : 0;
            v2 = (((int)v2_2)) | v3;
            Object v3_1 = v1.rememberedValue();
            if(v2 != 0 || v3_1 == Composer.Companion.getEmpty()) {
                v3_2 = new ScaffoldKt$$ExternalSyntheticLambda0(v15_2, v10_1);
                v1.updateRememberedValue(v3_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            Modifier v2_3 = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(((Modifier)v0_3), ((Function1)v3_2));
            v3 = v4 >> 12;
            v4 = v3 & 0x380 | v17;
            long v17_1 = arg36;
            v25 = v1;
            SurfaceKt.Surface-T9BRK9s(v2_3, null, v17_1, v19_1, 0f, 0f, null, ComposableLambdaKt.rememberComposableLambda(0x329906E3, true, new ScaffoldKt$Scaffold$2(v9, v5_1, arg39, v7_1, v8, v15_2, v6), v1, 54), v25, v4 | v3 & 0x1C00, 0x72);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = ((Modifier)v0_3);
            v2_4 = v5_1;
            v3_3 = v6;
            v4_1 = v7_1;
            v5_1 = v8;
            v6_1 = v9;
            v11_1 = v10_1;
            v7_2 = v17_1;
            v9_1 = v19_1;
        }
        else {
            v25 = v1;
            v25.skipToGroupEnd();
            v1_1 = arg28;
            v11_1 = arg38;
            v2_4 = v6;
            v3_3 = v8;
            v4_1 = v10;
            v5_1 = v12;
            v6_1 = arg33;
            v7_2 = arg34;
            v9_1 = arg36;
        }

        ScopeUpdateScope v15_3 = v25.endRestartGroup();
        if(v15_3 != null) {
            v15_3.updateScope(new ScaffoldKt$$ExternalSyntheticLambda1(v1_1, v2_4, v3_3, v4_1, v5_1, v6_1, v7_2, v9_1, v11_1, arg39, v13, v14));
        }
    }

    private static final void ScaffoldLayout-FMILGgc(int arg19, Function2 arg20, Function3 arg21, Function2 arg22, Function2 arg23, WindowInsets arg24, Function2 arg25, Composer arg26, int arg27) {
        ScaffoldKt$$ExternalSyntheticLambda2 v6_2;
        int v3_1;
        ComposableLambda v0_3;
        Object v16_1;
        int v16;
        int v10;
        int v6;
        Function2 v2 = arg20;
        Function3 v3 = arg21;
        Function2 v4 = arg22;
        Function2 v5 = arg23;
        Function2 v7 = arg25;
        int v8 = arg27;
        int v0 = 0xEF4B26F3;
        Composer v1 = arg26.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(ScaffoldLayout)N(fabPosition:c#material3.FabPosition,topBar,content,snackbar,fab,contentWindowInsets,bottomBar)142@6839L626,158@7515L41,159@7607L45,160@7698L35,162@7788L73,163@7913L47,164@7982L5885,164@7965L5902:Scaffold.kt#uh7d8r");
        int v15 = arg19;
        if((v8 & 6) == 0) {
            v6 = v1.changed(v15) ? 4 : 2;
            v6 |= v8;
        }
        else {
            v6 = v8;
        }

        int v11 = 0x20;
        if((v8 & 0x30) == 0) {
            v10 = v1.changedInstance(v2) ? v11 : 16;
            v6 |= v10;
        }

        if((v8 & 0x180) == 0) {
            v10 = v1.changedInstance(v3) ? 0x100 : 0x80;
            v6 |= v10;
        }

        if((v8 & 0xC00) == 0) {
            v10 = v1.changedInstance(v4) ? 0x800 : 0x400;
            v6 |= v10;
        }

        if((v8 & 0x6000) == 0) {
            v10 = v1.changedInstance(v5) ? 0x4000 : 0x2000;
            v6 |= v10;
        }

        if((0x30000 & v8) == 0) {
            v16 = v1.changed(arg24) ? 0x20000 : 0x10000;
            v6 |= v16;
        }

        if((v8 & 0x180000) == 0) {
            v16 = v1.changedInstance(v7) ? 0x100000 : 0x80000;
            v6 |= v16;
        }

        boolean v9 = (v6 & 0x92493) != 0x92492 ? true : false;
        if(v1.shouldExecute(v9, v6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v6, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:137)");
            }

            String v9_1 = "CC(remember):Scaffold.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v1, 1226671013, v9_1);
            Object v0_1 = v1.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                ScaffoldKt$ScaffoldLayout$contentPadding$1$1 v0_2 = new ScaffoldKt$ScaffoldLayout$contentPadding$1$1();
                v1.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerStart(v1, 1226692060, v9_1);
            v11 = (v6 & 0x70) == v11 ? 1 : 0;
            Object v12 = v1.rememberedValue();
            if(v11 != 0 || v12 == Composer.Companion.getEmpty()) {
                ComposableLambda v12_1 = ComposableLambdaKt.composableLambdaInstance(605195056, true, new ScaffoldKt$ScaffoldLayout$topBarContent$1$1(v2));
                v1.updateRememberedValue(v12_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerStart(v1, 1226695008, v9_1);
            v11 = (v6 & 0x1C00) == 0x800 ? 1 : 0;
            Object v14 = v1.rememberedValue();
            if(v11 != 0 || v14 == Composer.Companion.getEmpty()) {
                ComposableLambda v14_1 = ComposableLambdaKt.composableLambdaInstance(0x18F7E4F7, true, new ScaffoldKt$ScaffoldLayout$snackbarContent$1$1(v4));
                v1.updateRememberedValue(v14_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerStart(v1, 1226697910, v9_1);
            v11 = (0xE000 & v6) == 0x4000 ? 1 : 0;
            Object v13 = v1.rememberedValue();
            if(v11 != 0 || v13 == Composer.Companion.getEmpty()) {
                ComposableLambda v13_1 = ComposableLambdaKt.composableLambdaInstance(338600263, true, new ScaffoldKt$ScaffoldLayout$fabContent$1$1(v5));
                v1.updateRememberedValue(v13_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerStart(v1, 1226700828, v9_1);
            int v2_1 = (v6 & 0x380) == 0x100 ? 1 : 0;
            Object v11_1 = v1.rememberedValue();
            if(v2_1 != 0 || v11_1 == Composer.Companion.getEmpty()) {
                v16_1 = v0_1;
                ComposableLambda v11_2 = ComposableLambdaKt.composableLambdaInstance(0x961E76F3, true, new ScaffoldKt$ScaffoldLayout$bodyContent$1$1(v3, ((ScaffoldKt$ScaffoldLayout$contentPadding$1$1)v0_1)));
                v1.updateRememberedValue(v11_2);
            }
            else {
                v16_1 = v0_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerStart(v1, 1226704802, v9_1);
            v2_1 = (0x380000 & v6) == 0x100000 ? 1 : 0;
            v0_1 = v1.rememberedValue();
            if(v2_1 != 0 || v0_1 == Composer.Companion.getEmpty()) {
                v3_1 = 1;
                v0_3 = ComposableLambdaKt.composableLambdaInstance(0x98C8ED68, true, new ScaffoldKt$ScaffoldLayout$bottomBarContent$1$1(v7));
                v1.updateRememberedValue(v0_3);
            }
            else {
                v3_1 = 1;
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerStart(v1, 0x491E2710, v9_1);
            v2_1 = (0x70000 & v6) == 0x20000 ? v3_1 : 0;
            v2_1 = v2_1 | v1.changed(v12) | v1.changed(v14) | v1.changed(v13);
            v6 = (v6 & 14) == 4 ? v3_1 : 0;
            v2_1 = v2_1 | v6 | v1.changed(v0_3) | v1.changed(v11_1);
            Object v6_1 = v1.rememberedValue();
            if(v2_1 != 0 || v6_1 == Composer.Companion.getEmpty()) {
                Object v2_2 = v14;
                v14 = v13;
                v13 = v2_2;
                v2_1 = v3_1;
                Object v17 = v16_1;
                v16_1 = v0_3;
                v0 = 0;
                ScaffoldKt$$ExternalSyntheticLambda2 v10_1 = new ScaffoldKt$$ExternalSyntheticLambda2(arg24, ((Function2)v12), ((Function2)v13), ((Function2)v14), v15, ((Function2)v16_1), ((ScaffoldKt$ScaffoldLayout$contentPadding$1$1)v17), v11_1);
                v1.updateRememberedValue(v10_1);
                v6_2 = v10_1;
            }
            else {
                v2_1 = v3_1;
                v0 = 0;
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            SubcomposeLayoutKt.SubcomposeLayout(null, ((Function2)v6_2), v1, v0, v2_1);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_269;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
        }

    label_269:
        ScopeUpdateScope v9_2 = v1.endRestartGroup();
        if(v9_2 != null) {
            v9_2.updateScope(new ScaffoldKt$$ExternalSyntheticLambda3(arg19, arg20, arg21, v4, v5, arg24, v7, v8));
        }
    }

    static final MeasureResult ScaffoldLayout_FMILGgc$lambda$15$lambda$14(WindowInsets arg17, Function2 arg18, Function2 arg19, Function2 arg20, int arg21, Function2 arg22, ScaffoldKt$ScaffoldLayout$contentPadding$1$1 arg23, Function2 arg24, SubcomposeMeasureScope arg25, Constraints arg26) {
        Integer v0_1;
        int v14;
        FabPlacement v10_1;
        WindowInsets v5 = arg17;
        int v0 = arg21;
        SubcomposeMeasureScope v6 = arg25;
        int v4 = Constraints.getMaxWidth-impl(arg26.unbox-impl());
        int v7 = Constraints.getMaxHeight-impl(arg26.unbox-impl());
        long v1 = Constraints.copy-Zbe2FdA$default(arg26.unbox-impl(), 0, 0, 0, 0, 10, null);
        SubcomposeMeasureScope v3 = v6;
        int v8 = v5.getLeft(((Density)v3), v6.getLayoutDirection());
        int v9 = v5.getRight(((Density)v3), v6.getLayoutDirection());
        int v10 = v5.getBottom(((Density)v3));
        Placeable v11 = CollectionsKt.first(v6.subcompose(ScaffoldLayoutContent.TopBar, arg18)).measure-BRTryo0(v1);
        int v13 = -v8 - v9;
        v10 = -v10;
        Placeable v12 = CollectionsKt.first(v6.subcompose(ScaffoldLayoutContent.Snackbar, arg19)).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(v1, v13, v10));
        int v15 = v7;
        int v26 = v8;
        Placeable v7_1 = CollectionsKt.first(v6.subcompose(ScaffoldLayoutContent.Fab, arg20)).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(v1, v13, v10));
        if(v7_1.getWidth() != 0 || v7_1.getHeight() != 0) {
            v8 = v7_1.getWidth();
            v13 = v7_1.getHeight();
            if(!FabPosition.equals-impl0(v0, FabPosition.Companion.getStart-ERTFSPs())) {
                if(!FabPosition.equals-impl0(v0, FabPosition.Companion.getEnd-ERTFSPs())) {
                    if(FabPosition.equals-impl0(v0, FabPosition.Companion.getEndOverlay-ERTFSPs())) {
                    }
                    else {
                        v9 = (v4 - v8 + v26 - v9) / 2;
                        goto label_91;
                    }
                }

                if(v6.getLayoutDirection() == LayoutDirection.Ltr) {
                    v10 = v6.roundToPx-0680j_4(ScaffoldKt.FabSpacing);
                label_64:
                    v9 = v4 - v10 - v8 - v9;
                    goto label_91;
                }

                v9 = v6.roundToPx-0680j_4(ScaffoldKt.FabSpacing);
            label_60:
                v9 += v26;
            }
            else if(v6.getLayoutDirection() == LayoutDirection.Ltr) {
                v9 = v6.roundToPx-0680j_4(ScaffoldKt.FabSpacing);
                goto label_60;
            }
            else {
                v10 = v6.roundToPx-0680j_4(ScaffoldKt.FabSpacing);
                goto label_64;
            }

        label_91:
            v10_1 = new FabPlacement(v9, v8, v13);
        }
        else {
            v10_1 = null;
        }

        Placeable v9_1 = CollectionsKt.first(v6.subcompose(ScaffoldLayoutContent.BottomBar, arg22)).measure-BRTryo0(v1);
        v13 = 0;
        v8 = v9_1.getWidth() != 0 || v9_1.getHeight() != 0 ? 0 : 1;
        if(v10_1 != null) {
            if(v8 != 0 || (FabPosition.equals-impl0(v0, FabPosition.Companion.getEndOverlay-ERTFSPs()))) {
                v0 = v10_1.getHeight() + v6.roundToPx-0680j_4(ScaffoldKt.FabSpacing);
                v14 = v5.getBottom(((Density)v3));
            }
            else {
                v0 = v9_1.getHeight() + v10_1.getHeight();
                v14 = v6.roundToPx-0680j_4(ScaffoldKt.FabSpacing);
            }

            v0_1 = Integer.valueOf(v0 + v14);
        }
        else {
            v0_1 = null;
        }

        v14 = v12.getHeight();
        if(v14 != 0) {
            if(v0_1 != null) {
                v13 = v0_1.intValue();
            }
            else {
                Integer v13_1 = Integer.valueOf(v9_1.getHeight());
                v13_1.intValue();
                if(v8 == 0) {
                }
                else {
                    v13_1 = null;
                }

                if(v13_1 != null) {
                    v13 = v13_1.intValue();
                    goto label_144;
                }

                v13 = v5.getBottom(((Density)v3));
            }

        label_144:
            v13 += v14;
        }

        PaddingValues v3_1 = WindowInsetsKt.asPaddingValues(v5, ((Density)v3));
        float v14_1 = v11.getWidth() != 0 || v11.getHeight() != 0 ? v6.toDp-u2uoSUM(v11.getHeight()) : v3_1.calculateTopPadding-D9Ej5fM();
        float v8_1 = v8 != 0 ? v3_1.calculateBottomPadding-D9Ej5fM() : v6.toDp-u2uoSUM(v9_1.getHeight());
        arg23.setPaddingHolder(PaddingKt.PaddingValues-a9UjIt4(PaddingKt.calculateStartPadding(v3_1, v6.getLayoutDirection()), v14_1, PaddingKt.calculateEndPadding(v3_1, v6.getLayoutDirection()), v8_1));
        return MeasureScope.layout$default(v6, v4, v15, null, new ScaffoldKt$$ExternalSyntheticLambda4(CollectionsKt.first(v6.subcompose(ScaffoldLayoutContent.MainContent, arg24)).measure-BRTryo0(v1), v11, v12, v4, v5, v6, v15, v13, v9_1, v10_1, v7_1, v0_1), 4, null);
    }

    static final Unit ScaffoldLayout_FMILGgc$lambda$15$lambda$14$lambda$13(Placeable arg15, Placeable arg16, Placeable arg17, int arg18, WindowInsets arg19, SubcomposeMeasureScope arg20, int arg21, int arg22, Placeable arg23, FabPlacement arg24, Placeable arg25, Integer arg26, PlacementScope arg27) {
        PlacementScope.place$default(arg27, arg15, 0, 0, 0f, 4, null);
        PlacementScope.place$default(arg27, arg16, 0, 0, 0f, 4, null);
        PlacementScope.place$default(arg27, arg17, (arg18 - arg17.getWidth() + arg19.getLeft(arg20, arg20.getLayoutDirection()) - arg19.getRight(arg20, arg20.getLayoutDirection())) / 2, arg21 - arg22, 0f, 4, null);
        PlacementScope.place$default(arg27, arg23, 0, arg21 - arg23.getHeight(), 0f, 4, null);
        if(arg24 != null) {
            int v15 = arg24.getLeft();
            Intrinsics.checkNotNull(arg26);
            PlacementScope.place$default(arg27, arg25, v15, arg21 - arg26.intValue(), 0f, 4, null);
        }

        return Unit.INSTANCE;
    }

    static final Unit ScaffoldLayout_FMILGgc$lambda$16(int arg10, Function2 arg11, Function3 arg12, Function2 arg13, Function2 arg14, WindowInsets arg15, Function2 arg16, int arg17, Composer arg18, int arg19) {
        ScaffoldKt.ScaffoldLayout-FMILGgc(arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg18, RecomposeScopeImplKt.updateChangedFlags(arg17 | 1));
        return Unit.INSTANCE;
    }

    static final Unit Scaffold_TvnljyQ$lambda$2$lambda$1(MutableWindowInsets arg0, WindowInsets arg1, WindowInsets arg2) {
        arg0.setInsets(WindowInsetsKt.exclude(arg1, arg2));
        return Unit.INSTANCE;
    }

    static final Unit Scaffold_TvnljyQ$lambda$3(Modifier arg16, Function2 arg17, Function2 arg18, Function2 arg19, Function2 arg20, int arg21, long arg22, long arg24, WindowInsets arg26, Function3 arg27, int arg28, int arg29, Composer arg30, int arg31) {
        ScaffoldKt.Scaffold-TvnljyQ(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg24, arg26, arg27, arg30, RecomposeScopeImplKt.updateChangedFlags(arg28 | 1), arg29);
        return Unit.INSTANCE;
    }

    public static final void access$ScaffoldLayout-FMILGgc(int arg0, Function2 arg1, Function3 arg2, Function2 arg3, Function2 arg4, WindowInsets arg5, Function2 arg6, Composer arg7, int arg8) {
        ScaffoldKt.ScaffoldLayout-FMILGgc(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
}

