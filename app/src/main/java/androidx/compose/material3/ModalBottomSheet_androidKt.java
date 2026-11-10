package androidx.compose.material3;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.WindowManager$LayoutParams;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A¶\u0001\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\b\b\u0002\u0010\u000F\u001A\u00020\t2\b\b\u0002\u0010\u0010\u001A\u00020\r2\u0015\b\u0002\u0010\u0011\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u00162\u001C\u0010\u0017\u001A\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u001AH\u0007¢\u0006\u0004\b\u001B\u0010\u001C\u001AT\u0010\u001D\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u00162\u0012\u0010\u001E\u001A\u000E\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001F2\u0011\u0010\u0017\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012H\u0001¢\u0006\u0004\b\"\u0010#\u001A\f\u0010$\u001A\u00020%*\u00020&H\u0000\u001A\u0013\u0010\'\u001A\u00020%*\u00020\rH\u0000¢\u0006\u0004\b(\u0010)¨\u0006*²\u0006\u0015\u0010+\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0012X\u008A\u0084\u0002"}, d2={"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetDialog", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "ModalBottomSheetDialog-sW7UJKQ", "(Lkotlin/jvm/functions/Function0;JLandroidx/compose/material3/ModalBottomSheetProperties;Landroidx/compose/animation/core/Animatable;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isFlagSecureEnabled", "", "Landroid/view/View;", "isDark", "isDark-8_81llA", "(J)Z", "material3", "currentContent"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ModalBottomSheet_androidKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use constructor with contentWindowInsets parameter.", replaceWith="<_subannotation>") public static final void ModalBottomSheet-dYc4hso(Function0 arg29, Modifier arg30, SheetState arg31, float arg32, Shape arg33, long arg34, long arg36, float arg38, long arg39, Function2 arg41, WindowInsets arg42, ModalBottomSheetProperties arg43, Function3 arg44, Composer arg45, int arg46, int arg47, int arg48) {
        ModalBottomSheetProperties v15_1;
        long v11_1;
        SheetState v3_2;
        WindowInsets v14_2;
        Function2 v13_2;
        long v8_1;
        float v4_1;
        Modifier v2_1;
        Composer v21;
        WindowInsets v3_1;
        long v15;
        float v14_1;
        float v7_1;
        long v12_1;
        SheetState v6_1;
        Modifier v5_1;
        Shape v9_1;
        ModalBottomSheetProperties v19;
        Function2 v17_1;
        long v16_1;
        float v10_1;
        long v6_2;
        Shape v5_2;
        int v24;
        long v14;
        int v20;
        long v10;
        int v18;
        Shape v7;
        int v17;
        int v16;
        SheetState v13_1;
        Modifier v12;
        int v8;
        int v0 = arg46;
        int v1 = arg47;
        int v2 = arg48;
        Composer v4 = arg45.startRestartGroup(0x4FFE1F38);
        ComposerKt.sourceInformation(v4, "C(ModalBottomSheet)N(onDismissRequest,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,scrimColor:c#ui.graphics.Color,dragHandle,windowInsets,properties,content)343@15830L485:ModalBottomSheet.android.kt#uh7d8r");
        if((v2 & 1) != 0) {
            v8 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v8 = v4.changedInstance(arg29) ? 4 : 2;
            v8 |= v0;
        }
        else {
            v8 = v0;
        }

        int v9 = v2 & 2;
        if(v9 != 0) {
            v8 |= 0x30;
            goto label_40;
        }
        else if((v0 & 0x30) == 0) {
            v12 = arg30;
            int v13 = v4.changed(v12) ? 0x20 : 16;
            v8 |= v13;
        }
        else {
        label_40:
            v12 = arg30;
        }

        if((v0 & 0x180) == 0) {
            if((v2 & 4) == 0) {
                v13_1 = arg31;
                if(v4.changed(v13_1)) {
                    v16 = 0x100;
                }
                else {
                    goto label_51;
                }
            }
            else {
                v13_1 = arg31;
            label_51:
                v16 = 0x80;
            }

            v8 |= v16;
        }
        else {
            v13_1 = arg31;
        }

        v16 = v2 & 8;
        if(v16 != 0) {
            v8 |= 0xC00;
        }
        else if((v0 & 0xC00) == 0) {
            v17 = v4.changed(arg32) ? 0x800 : 0x400;
            v8 |= v17;
        }

        if((v0 & 0x6000) == 0) {
            if((v2 & 16) == 0) {
                v7 = arg33;
                if(v4.changed(v7)) {
                    v18 = 0x4000;
                }
                else {
                    goto label_80;
                }
            }
            else {
                v7 = arg33;
            label_80:
                v18 = 0x2000;
            }

            v8 |= v18;
        }
        else {
            v7 = arg33;
        }

        if((v0 & 0x30000) == 0) {
            v10 = arg34;
            v20 = (v2 & 0x20) != 0 || !v4.changed(v10) ? 0x10000 : 0x20000;
            v8 |= v20;
        }
        else {
            v10 = arg34;
        }

        if((v0 & 0x180000) == 0) {
            v14 = arg36;
            int v22 = (v2 & 0x40) != 0 || !v4.changed(v14) ? 0x80000 : 0x100000;
            v8 |= v22;
        }
        else {
            v14 = arg36;
        }

        int v3 = v2 & 0x80;
        int v23 = 0xC00000;
        if(v3 != 0) {
            v8 |= v23;
        }
        else {
            v23 &= v0;
            float v0_1 = arg38;
            if(v23 == 0) {
                v23 = v4.changed(v0_1) ? 0x800000 : 0x400000;
                v8 |= v23;
            }
        }

        if((arg46 & 0x6000000) == 0) {
            long v5 = arg39;
            v0 = (v2 & 0x100) != 0 || !v4.changed(v5) ? 0x2000000 : 0x4000000;
            v8 |= v0;
        }

        v0 = v2 & 0x200;
        v23 = 0x30000000;
        if(v0 != 0) {
            v8 |= v23;
            goto label_157;
        }
        else if((arg46 & v23) == 0) {
            v23 = v0;
            v24 = v4.changedInstance(arg41) ? 0x20000000 : 0x10000000;
            v8 |= v24;
        }
        else {
        label_157:
            v23 = v0;
        }

        if((v1 & 6) == 0) {
            v17 = (v2 & 0x400) != 0 || !v4.changed(arg42) ? 2 : 4;
            v17 |= v1;
        }
        else {
            v17 = v1;
        }

        v0 = v2 & 0x800;
        if(v0 != 0) {
            v17 |= 0x30;
            v24 = v0;
        }
        else if((v1 & 0x30) == 0) {
            v24 = v0;
            v18 = v4.changed(arg43) ? 0x20 : 16;
            v17 |= v18;
        }
        else {
            v24 = v0;
        }

        v0 = v17;
        v17 = v3;
        if((v2 & 0x1000) != 0) {
            v0 |= 0x180;
        }
        else if((v1 & 0x180) == 0) {
            v20 = v4.changedInstance(arg44) ? 0x100 : 0x80;
            v0 |= v20;
        }

        boolean v1_1 = (v8 & 306783379) != 306783378 || (v0 & 0x93) != 0x92 ? true : false;
        if(v4.shouldExecute(v1_1, v8 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "331@15186L31,333@15317L13,334@15380L14,335@15422L31,337@15530L10,339@15677L12");
            int v6 = 0xFFFF1FFF;
            int v45 = 0xFFF8FFFF;
            v3 = 3;
            if((arg46 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v9 != 0) {
                    Companion v12_2 = Modifier.Companion;
                }

                if((v2 & 4) != 0) {
                    v8 &= -897;
                    v13_1 = ModalBottomSheetKt.rememberModalBottomSheetState(false, null, v4, 0, v3);
                }

                float v1_2 = v16 != 0 ? BottomSheetDefaults.INSTANCE.getSheetMaxWidth-D9Ej5fM() : arg32;
                v9 = 6;
                if((v2 & 16) != 0) {
                    v5_2 = BottomSheetDefaults.INSTANCE.getExpandedShape(v4, v9);
                    v8 &= v6;
                }
                else {
                    v5_2 = v7;
                }

                if((v2 & 0x20) != 0) {
                    v6_2 = BottomSheetDefaults.INSTANCE.getContainerColor(v4, v9);
                    v8 &= v45;
                }
                else {
                    v6_2 = v10;
                }

                if((v2 & 0x40) != 0) {
                    v10 = ColorSchemeKt.contentColorFor-ek8zF_U(v6_2, v4, v8 >> 15 & 14);
                    v8 &= 0xFFC7FFFF;
                    v14 = v10;
                }

                v10_1 = v17 != 0 ? Dp.constructor-impl(0f) : arg38;
                if((v2 & 0x100) != 0) {
                    v16_1 = BottomSheetDefaults.INSTANCE.getScrimColor(v4, v9);
                    v8 &= 0xF1FFFFFF;
                }
                else {
                    v16_1 = arg39;
                }

                Function2 v11 = v23 != 0 ? ComposableSingletons$ModalBottomSheet_androidKt.INSTANCE.getLambda$-1294623166$material3() : arg41;
                if((v2 & 0x400) != 0) {
                    v3_1 = BottomSheetDefaults.INSTANCE.getWindowInsets(v4, v9);
                    v0 &= -15;
                }
                else {
                    v3_1 = arg42;
                }

                v19 = v24 != 0 ? ModalBottomSheetDefaults.INSTANCE.getProperties() : arg43;
                v9_1 = v5_2;
                v5_1 = v12;
                long v27 = v6_2;
                v7_1 = v1_2;
                v6_1 = v13_1;
                v12_1 = v14;
                v15 = v16_1;
                v14_1 = v10_1;
                v17_1 = v11;
                v10 = v27;
            }
            else {
                v4.skipToGroupEnd();
                if((v2 & 4) != 0) {
                    v8 &= -897;
                }

                if((v2 & 16) != 0) {
                    v8 &= v6;
                }

                if((v2 & 0x20) != 0) {
                    v8 &= v45;
                }

                if((v2 & 0x40) != 0) {
                    v8 &= 0xFFC7FFFF;
                }

                if((v2 & 0x100) != 0) {
                    v8 &= 0xF1FFFFFF;
                }

                if((v2 & 0x400) != 0) {
                    v0 &= -15;
                }

                v17_1 = arg41;
                v19 = arg43;
                v9_1 = v7;
                v5_1 = v12;
                v6_1 = v13_1;
                v12_1 = v14;
                v7_1 = arg32;
                v14_1 = arg38;
                v15 = arg39;
                v3_1 = arg42;
            }

            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x4FFE1F38, v8, v0, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.android.kt:343)");
            }

            v2 = v8 << 3;
            v0 <<= 3;
            v21 = v4;
            ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(arg29, v5_1, v6_1, v7_1, false, v9_1, v10, v12_1, v14_1, v15, v17_1, new ModalBottomSheet_androidKt$ModalBottomSheet$1(v3_1), v19, arg44, v21, v8 & 0x1FFE | v2 & 0x70000 | v2 & 0x380000 | v2 & 0x1C00000 | v2 & 0xE000000 | v2 & 0x70000000, v8 >> 27 & 14 | v0 & 0x380 | v0 & 0x1C00, 16);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v5_1;
            v4_1 = v7_1;
            v5_2 = v9_1;
            v8_1 = v12_1;
            v13_2 = v17_1;
            float v27_1 = v14_1;
            v14_2 = v3_1;
            v3_2 = v6_1;
            v6_2 = v10;
            v10_1 = v27_1;
            v11_1 = v15;
            v15_1 = v19;
        }
        else {
            v21 = v4;
            v21.skipToGroupEnd();
            v4_1 = arg32;
            v5_2 = v7;
            v6_2 = v10;
            v2_1 = v12;
            v3_2 = v13_1;
            v8_1 = v14;
            v10_1 = arg38;
            v11_1 = arg39;
            v13_2 = arg41;
            v14_2 = arg42;
            v15_1 = arg43;
        }

        ScopeUpdateScope v0_2 = v21.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new ModalBottomSheet_androidKt$$ExternalSyntheticLambda4(arg29, v2_1, v3_2, v4_1, v5_2, v6_2, v8_1, v10_1, v11_1, v13_2, v14_2, v15_1, arg44, arg46, arg47, arg48));
        }
    }

    public static final void ModalBottomSheetDialog-sW7UJKQ(Function0 arg24, long arg25, ModalBottomSheetProperties arg27, Animatable arg28, Function2 arg29, Composer arg30, int arg31) {
        ModalBottomSheet_androidKt$$ExternalSyntheticLambda2 v2_3;
        ModalBottomSheet_androidKt$$ExternalSyntheticLambda1 v2_2;
        int v18;
        boolean v8_1;
        int v8;
        ModalBottomSheetProperties v3_1;
        int v3;
        int v2;
        Animatable v9 = arg28;
        Function2 v12 = arg29;
        int v13 = arg31;
        int v0 = 0x2DB43478;
        Composer v14 = arg30.startRestartGroup(v0);
        ComposerKt.sourceInformation(v14, "C(ModalBottomSheetDialog)N(onDismissRequest,contentColor:c#ui.graphics.Color,properties,predictiveBackProgress,content)370@16794L7,371@16833L7,372@16888L7,373@16918L28,374@16973L29,375@17039L21,375@17022L38,376@17077L24,378@17127L586,397@17744L129,397@17719L154,406@17890L224,406@17879L235:ModalBottomSheet.android.kt#uh7d8r");
        if((v13 & 6) == 0) {
            v2 = v14.changedInstance(arg24) ? 4 : 2;
            v2 |= v13;
        }
        else {
            v2 = v13;
        }

        long v6 = arg25;
        if((v13 & 0x30) == 0) {
            v3 = v14.changed(v6) ? 0x20 : 16;
            v2 |= v3;
        }

        if((v13 & 0x180) == 0) {
            v3_1 = arg27;
            v8 = v14.changed(v3_1) ? 0x100 : 0x80;
            v2 |= v8;
        }
        else {
            v3_1 = arg27;
        }

        if((v13 & 0xC00) == 0) {
            v8_1 = (v13 & 0x1000) == 0 ? v14.changed(v9) : v14.changedInstance(v9);
            v8 = v8_1 ? 0x800 : 0x400;
            v2 |= v8;
        }

        if((v13 & 0x6000) == 0) {
            v8 = v14.changedInstance(v12) ? 0x4000 : 0x2000;
            v2 |= v8;
        }

        v8_1 = (v2 & 9363) != 9362 ? true : false;
        if(v14.shouldExecute(v8_1, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.ModalBottomSheetDialog (ModalBottomSheet.android.kt:369)");
            }

            ProvidableCompositionLocal v0_1 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(v14, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = v14.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v14);
            ProvidableCompositionLocal v4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v14, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v4_1 = v14.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(v14);
            ProvidableCompositionLocal v5 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v14, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v5_1 = v14.consume(((CompositionLocal)v5));
            ComposerKt.sourceInformationMarkerEnd(v14);
            Object v8_2 = v5_1;
            CompositionContext v5_2 = ComposablesKt.rememberCompositionContext(v14, 0);
            State v10 = SnapshotStateKt.rememberUpdatedState(v12, v14, v2 >> 12 & 14);
            Object[] v11 = new Object[0];
            String v12_1 = "CC(remember):ModalBottomSheet.android.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v14, -1854325107, v12_1);
            Object v15 = v14.rememberedValue();
            if(v15 == Composer.Companion.getEmpty()) {
                ModalBottomSheet_androidKt$$ExternalSyntheticLambda0 v15_1 = new ModalBottomSheet_androidKt$$ExternalSyntheticLambda0();
                v14.updateRememberedValue(v15_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            Object v1 = RememberSaveableKt.rememberSaveable(v11, ((Function0)v15), v14, 0x30);
            ComposerKt.sourceInformationMarkerStart(v14, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v14, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            Object v11_1 = v14.rememberedValue();
            if(v11_1 == Composer.Companion.getEmpty()) {
                CoroutineScope v11_2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v14);
                v14.updateRememberedValue(v11_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 0x91794BC2, v12_1);
            int v15_2 = v14.changed(v0_2) | v14.changed(v4_1);
            Object v17 = v0_2;
            v0_2 = v14.rememberedValue();
            if(v15_2 != 0 || v0_2 == Composer.Companion.getEmpty()) {
                v18 = v2;
                v13 = 0x100;
                ModalBottomSheetDialogWrapper v0_3 = new ModalBottomSheetDialogWrapper(arg24, v3_1, v6, v17, v8_2, v4_1, v1, v9, v11_1, null);
                v8_2 = v8_2;
                v3 = 1;
                v0_3.setContent(v5_2, ComposableLambdaKt.composableLambdaInstance(0xC1555065, true, new ModalBottomSheet_androidKt$ModalBottomSheetDialog$dialog$1$1$1(v10)));
                v14.updateRememberedValue(v0_3);
            }
            else {
                v18 = v2;
                v3 = 1;
                v13 = 0x100;
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, -1854302439, v12_1);
            boolean v1_1 = v14.changedInstance(v0_2);
            Object v2_1 = v14.rememberedValue();
            if((v1_1) || v2_1 == Composer.Companion.getEmpty()) {
                v2_2 = new ModalBottomSheet_androidKt$$ExternalSyntheticLambda1(((ModalBottomSheetDialogWrapper)v0_2));
                v14.updateRememberedValue(v2_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            EffectsKt.DisposableEffect(v0_2, ((Function1)v2_2), v14, 0);
            ComposerKt.sourceInformationMarkerStart(v14, 0x9179A9B8, v12_1);
            v1_1 = v14.changedInstance(v0_2);
            v2 = v18;
            int v11_3 = (v2 & 14) == 4 ? v3 : 0;
            int v1_2 = (((int)v1_1)) | v11_3;
            v11_3 = (v2 & 0x380) == v13 ? v3 : 0;
            v1_2 |= v11_3;
            v11_3 = (v2 & 0x70) == 0x20 ? v3 : 0;
            v1_2 = v1_2 | v11_3 | v14.changed(v8_2.ordinal());
            v2_1 = v14.rememberedValue();
            if(v1_2 != 0 || v2_1 == Composer.Companion.getEmpty()) {
                v2_3 = new ModalBottomSheet_androidKt$$ExternalSyntheticLambda2(v0_2, arg24, arg27, arg25, ((LayoutDirection)v8_2));
                v14.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            EffectsKt.SideEffect(((Function0)v2_3), v14, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_231;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v14.skipToGroupEnd();
        }

    label_231:
        ScopeUpdateScope v8_3 = v14.endRestartGroup();
        if(v8_3 != null) {
            v8_3.updateScope(new ModalBottomSheet_androidKt$$ExternalSyntheticLambda3(arg24, arg25, arg27, arg28, arg29, arg31));
        }
    }

    private static final Function2 ModalBottomSheetDialog_sW7UJKQ$lambda$1(State arg0) {
        return arg0.getValue();
    }

    static final Unit ModalBottomSheetDialog_sW7UJKQ$lambda$10$lambda$9(ModalBottomSheetDialogWrapper arg0, Function0 arg1, ModalBottomSheetProperties arg2, long arg3, LayoutDirection arg5) {
        arg0.updateParameters-9LQNqLg(arg1, arg2, arg3, arg5);
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheetDialog_sW7UJKQ$lambda$11(Function0 arg8, long arg9, ModalBottomSheetProperties arg11, Animatable arg12, Function2 arg13, int arg14, Composer arg15, int arg16) {
        ModalBottomSheet_androidKt.ModalBottomSheetDialog-sW7UJKQ(arg8, arg9, arg11, arg12, arg13, arg15, RecomposeScopeImplKt.updateChangedFlags(arg14 | 1));
        return Unit.INSTANCE;
    }

    static final UUID ModalBottomSheetDialog_sW7UJKQ$lambda$3$lambda$2() {
        return UUID.randomUUID();
    }

    static final DisposableEffectResult ModalBottomSheetDialog_sW7UJKQ$lambda$8$lambda$7(ModalBottomSheetDialogWrapper arg0, DisposableEffectScope arg1) {
        arg0.show();
        return new ModalBottomSheet_androidKt$ModalBottomSheetDialog_sW7UJKQ$lambda$8$lambda$7$$inlined$onDispose$1(arg0);
    }

    static final Unit ModalBottomSheet_dYc4hso$lambda$0(Function0 arg21, Modifier arg22, SheetState arg23, float arg24, Shape arg25, long arg26, long arg28, float arg30, long arg31, Function2 arg33, WindowInsets arg34, ModalBottomSheetProperties arg35, Function3 arg36, int arg37, int arg38, int arg39, Composer arg40, int arg41) {
        ModalBottomSheet_androidKt.ModalBottomSheet-dYc4hso(arg21, arg22, arg23, arg24, arg25, arg26, arg28, arg30, arg31, arg33, arg34, arg35, arg36, arg40, RecomposeScopeImplKt.updateChangedFlags(arg37 | 1), RecomposeScopeImplKt.updateChangedFlags(arg38), arg39);
        return Unit.INSTANCE;
    }

    public static final Function2 access$ModalBottomSheetDialog_sW7UJKQ$lambda$1(State arg0) {
        return ModalBottomSheet_androidKt.ModalBottomSheetDialog_sW7UJKQ$lambda$1(arg0);
    }

    public static final boolean isDark-8_81llA(long arg2) {
        if(!Color.equals-impl0(arg2, Color.Companion.getTransparent-0d7_KjU()) && (((double)ColorKt.luminance-8_81llA(arg2))) <= 0.5) {
            return 1;
        }

        return 0;
    }

    public static final boolean isFlagSecureEnabled(View arg1) {
        ViewGroup$LayoutParams v1 = arg1.getRootView().getLayoutParams();
        if((v1 instanceof WindowManager$LayoutParams)) {
        }
        else {
            v1 = null;
        }

        if(v1 != null && (((WindowManager$LayoutParams)v1).flags & 0x2000) != 0) {
            return 1;
        }

        return 0;
    }
}

