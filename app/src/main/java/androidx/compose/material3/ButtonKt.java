package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\u008F\u0001\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u001C\u0010\u0014\u001A\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001A\u008F\u0001\u0010\u001A\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u001C\u0010\u0014\u001A\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001A\u008F\u0001\u0010\u001B\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u001C\u0010\u0014\u001A\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001A\u008F\u0001\u0010\u001C\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u001C\u0010\u0014\u001A\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001A\u008F\u0001\u0010\u001D\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u001C\u0010\u0014\u001A\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001E"}, d2={"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ButtonColors;", "elevation", "Landroidx/compose/material3/ButtonElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ButtonColors;Landroidx/compose/material3/ButtonElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedButton", "FilledTonalButton", "OutlinedButton", "TextButton", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ButtonKt {
    public static final void Button(Function0 arg30, Modifier arg31, boolean arg32, Shape arg33, ButtonColors arg34, ButtonElevation arg35, BorderStroke arg36, PaddingValues arg37, MutableInteractionSource arg38, Function3 arg39, Composer arg40, int arg41, int arg42) {
        MutableInteractionSource v9_2;
        ButtonElevation v6_5;
        Modifier v2_2;
        PaddingValues v8_2;
        BorderStroke v7_1;
        Shape v4_1;
        ButtonColors v5_5;
        Composer v26;
        ButtonKt$$ExternalSyntheticLambda1 v5_4;
        State v11_1;
        Object v24_1;
        int v5_1;
        boolean v15_2;
        MutableInteractionSource v3;
        Modifier v1_1;
        BorderStroke v23;
        Shape v16_1;
        boolean v3_1;
        BorderStroke v0_4;
        Companion v31;
        ButtonColors v21_1;
        Shape v24;
        Modifier v0_3;
        int v18;
        PaddingValues v2_1;
        int v40;
        BorderStroke v15_1;
        int v14;
        ButtonElevation v9_1;
        int v9;
        ButtonColors v8_1;
        int v8;
        Shape v6_1;
        boolean v5;
        int v4;
        Function0 v13;
        int v1;
        Function3 v10 = arg39;
        int v11 = arg41;
        int v12 = arg42;
        Composer v7 = arg40.startRestartGroup(0xB1EABF50);
        ComposerKt.sourceInformation(v7, "C(Button)N(onClick,modifier,enabled,shape,colors,elevation,border,contentPadding,interactionSource,content)129@6472L22,137@6736L590,127@6398L928:Button.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
            v13 = arg30;
        }
        else {
            v13 = arg30;
            if((v11 & 6) == 0) {
                v1 = v7.changedInstance(v13) ? 4 : 2;
                v1 |= v11;
            }
            else {
                v1 = v11;
            }
        }

        int v2 = v12 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
        }
        else if((v11 & 0x30) == 0) {
            v4 = v7.changed(arg31) ? 0x20 : 16;
            v1 |= v4;
        }

        v4 = v12 & 4;
        if(v4 != 0) {
            v1 |= 0x180;
            goto label_53;
        }
        else if((v11 & 0x180) == 0) {
            v5 = arg32;
            int v6 = v7.changed(v5) ? 0x100 : 0x80;
            v1 |= v6;
        }
        else {
        label_53:
            v5 = arg32;
        }

        if((v11 & 0xC00) == 0) {
            if((v12 & 8) == 0) {
                v6_1 = arg33;
                if(v7.changed(v6_1)) {
                    v8 = 0x800;
                }
                else {
                    goto label_64;
                }
            }
            else {
                v6_1 = arg33;
            label_64:
                v8 = 0x400;
            }

            v1 |= v8;
        }
        else {
            v6_1 = arg33;
        }

        if((v11 & 0x6000) == 0) {
            if((v12 & 16) == 0) {
                v8_1 = arg34;
                if(v7.changed(v8_1)) {
                    v9 = 0x4000;
                }
                else {
                    goto label_78;
                }
            }
            else {
                v8_1 = arg34;
            label_78:
                v9 = 0x2000;
            }

            v1 |= v9;
        }
        else {
            v8_1 = arg34;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v9_1 = arg35;
                if(v7.changed(v9_1)) {
                    v14 = 0x20000;
                }
                else {
                    goto label_93;
                }
            }
            else {
                v9_1 = arg35;
            label_93:
                v14 = 0x10000;
            }

            v1 |= v14;
        }
        else {
            v9_1 = arg35;
        }

        v14 = v12 & 0x40;
        int v15 = 0x180000;
        if(v14 != 0) {
            v1 |= v15;
            goto label_112;
        }
        else if((v15 & v11) == 0) {
            v15_1 = arg36;
            int v16 = v7.changed(v15_1) ? 0x100000 : 0x80000;
            v1 |= v16;
        }
        else {
        label_112:
            v15_1 = arg36;
        }

        int v0 = v12 & 0x80;
        int v17 = 0xC00000;
        if(v0 != 0) {
            v1 |= v17;
            v40 = v2;
        }
        else {
            v40 = v2;
            v2_1 = arg37;
            if((v11 & v17) == 0) {
                v17 = v7.changed(v2_1) ? 0x800000 : 0x400000;
                v1 |= v17;
            }
        }

        v2 = v12 & 0x100;
        v17 = 0x6000000;
        if(v2 != 0) {
            v1 |= v17;
            goto label_146;
        }
        else if((v11 & v17) == 0) {
            v17 = v2;
            v18 = v7.changed(arg38) ? 0x4000000 : 0x2000000;
            v1 |= v18;
        }
        else {
        label_146:
            v17 = v2;
        }

        v18 = v0;
        int v19 = 0x30000000;
        if((v12 & 0x200) != 0) {
            v1 |= v19;
        }
        else if((v11 & v19) == 0) {
            v0 = v7.changedInstance(v10) ? 0x20000000 : 0x10000000;
            v1 |= v0;
        }

        boolean v0_1 = (306783379 & v1) != 306783378 ? true : false;
        if(v7.shouldExecute(v0_1, v1 & 1)) {
            v7.startDefaults();
            ComposerKt.sourceInformation(v7, "114@5728L5,115@5777L14,116@5842L17");
            int v20 = 0xFFF8FFFF;
            int v21 = 0xFFFF1FFF;
            v2 = 6;
            if((v11 & 1) == 0 || (v7.getDefaultsInvalid())) {
                if(v40 != 0) {
                    Companion v0_2 = Modifier.Companion;
                }
                else {
                    v0_3 = arg31;
                }

                boolean v23_1 = v4 != 0 ? true : v5;
                if((v12 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                    v24 = ButtonDefaults.INSTANCE.getShape(v7, v2);
                }
                else {
                    v24 = v6_1;
                }

                if((v12 & 16) != 0) {
                    v1 &= v21;
                    v21_1 = ButtonDefaults.INSTANCE.buttonColors(v7, v2);
                }
                else {
                    v21_1 = v8_1;
                }

                int v25 = v1;
                if((v12 & 0x20) != 0) {
                    v31 = ((Companion)v0_3);
                    v12 = 1;
                    v0_4 = null;
                    v9_1 = ButtonDefaults.INSTANCE.buttonElevation-R_JCAzs(0f, 0f, 0f, 0f, 0f, v7, 0x30000, 0x1F);
                    v1 = v25 & v20;
                }
                else {
                    v31 = ((Companion)v0_3);
                    v12 = 1;
                    v0_4 = null;
                    v1 = v25;
                }

                if(v14 != 0) {
                    v15_1 = v0_4;
                }

                v2_1 = v18 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : arg37;
                v3_1 = v23_1;
                v23 = v15_1;
                v15_2 = v3_1;
                v3 = v17 != 0 ? ((MutableInteractionSource)v0_4) : arg38;
                v4 = v1;
                v8_1 = v21_1;
                v16_1 = v24;
                v5_1 = 0xB1EABF50;
                Companion v1_2 = v31;
            }
            else {
                v7.skipToGroupEnd();
                if((v12 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v1 &= v21;
                }

                if((v12 & 0x20) != 0) {
                    v1 &= v20;
                }

                v4 = v1;
                v12 = 1;
                v16_1 = v6_1;
                v23 = v15_1;
                v1_1 = arg31;
                v2_1 = arg37;
                v3 = arg38;
                v15_2 = v5;
                v5_1 = 0xB1EABF50;
            }

            v7.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v5_1, v4, -1, "androidx.compose.material3.Button (Button.kt:121)");
            }

            String v5_2 = "CC(remember):Button.kt#9igjgp";
            if(v3 == null) {
                v7.startReplaceGroup(0x64D5E04B);
                ComposerKt.sourceInformation(v7, "123@6150L39");
                ComposerKt.sourceInformationMarkerStart(v7, 0xE2387297, v5_2);
                Object v6_2 = v7.rememberedValue();
                if(v6_2 == Composer.Companion.getEmpty()) {
                    MutableInteractionSource v6_3 = InteractionSourceKt.MutableInteractionSource();
                    v7.updateRememberedValue(v6_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v7);
                v7.endReplaceGroup();
                v24_1 = v6_2;
            }
            else {
                v7.startReplaceGroup(0xE238700C);
                v7.endReplaceGroup();
                MutableInteractionSource v24_2 = v3;
            }

            long v17_1 = v8_1.containerColor-vNxB06k$material3(v15_2);
            Modifier v6_4 = v1_1;
            long v0_5 = v8_1.contentColor-vNxB06k$material3(v15_2);
            if(v9_1 == null) {
                v7.startReplaceGroup(1691921830);
                v7.endReplaceGroup();
                v11_1 = null;
            }
            else {
                v7.startReplaceGroup(-499611205);
                ComposerKt.sourceInformation(v7, "126@6335L43");
                v11_1 = v9_1.shadowElevation$material3(v15_2, v24_1, v7, v4 >> 6 & 14 | v4 >> 9 & 0x380);
                v7.endReplaceGroup();
            }

            float v11_2 = v11_1 != null ? v11_1.getValue().unbox-impl() : Dp.constructor-impl(0f);
            ComposerKt.sourceInformationMarkerStart(v7, -499606842, v5_2);
            Object v5_3 = v7.rememberedValue();
            if(v5_3 == Composer.Companion.getEmpty()) {
                v5_4 = new ButtonKt$$ExternalSyntheticLambda1();
                v7.updateRememberedValue(v5_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v7);
            MutableInteractionSource v31_1 = v3;
            SurfaceKt.Surface-o_FOJdg(v13, SemanticsModifierKt.semantics$default(v6_4, false, ((Function1)v5_4), v12, null), v15_2, v16_1, v17_1, v0_5, 0f, v11_2, v23, ((MutableInteractionSource)v24_1), ComposableLambdaKt.rememberComposableLambda(0xE012C85B, ((boolean)v12), new ButtonKt$Button$2(v0_5, v2_1, v10), v7, 54), v7, v4 & 8078 | 0xE000000 & v4 << 6, 6, 0x40);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v26 = v7;
            v5_5 = v8_1;
            v3_1 = v15_2;
            v4_1 = v16_1;
            v7_1 = v23;
            v8_2 = v2_1;
            v2_2 = v6_4;
            v6_5 = v9_1;
            v9_2 = v31_1;
        }
        else {
            v7.skipToGroupEnd();
            v2_2 = arg31;
            v3_1 = v5;
            v4_1 = v6_1;
            v26 = v7;
            v5_5 = v8_1;
            v6_5 = v9_1;
            v7_1 = v15_1;
            v8_2 = arg37;
            v9_2 = arg38;
        }

        ScopeUpdateScope v13_1 = v26.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new ButtonKt$$ExternalSyntheticLambda2(arg30, v2_2, v3_1, v4_1, v5_5, v6_5, v7_1, v8_2, v9_2, v10, arg41, arg42));
        }
    }

    static final Unit Button$lambda$2$lambda$1(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(arg1, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Button$lambda$3(Function0 arg14, Modifier arg15, boolean arg16, Shape arg17, ButtonColors arg18, ButtonElevation arg19, BorderStroke arg20, PaddingValues arg21, MutableInteractionSource arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        ButtonKt.Button(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void ElevatedButton(Function0 arg26, Modifier arg27, boolean arg28, Shape arg29, ButtonColors arg30, ButtonElevation arg31, BorderStroke arg32, PaddingValues arg33, MutableInteractionSource arg34, Function3 arg35, Composer arg36, int arg37, int arg38) {
        MutableInteractionSource v9_2;
        PaddingValues v8_2;
        BorderStroke v7_1;
        ButtonElevation v6_2;
        ButtonColors v5_1;
        Shape v4_1;
        boolean v3_2;
        Modifier v2_2;
        Composer v23;
        int v0_2;
        BorderStroke v19_1;
        ButtonElevation v18_2;
        ButtonColors v17_1;
        Shape v16_1;
        boolean v15_1;
        MutableInteractionSource v21;
        PaddingValues v20;
        Companion v14_3;
        ButtonColors v21_1;
        Shape v20_1;
        Companion v0_3;
        int v18;
        int v17;
        int v15;
        BorderStroke v14_1;
        int v10;
        ButtonElevation v9_1;
        int v9;
        ButtonColors v8_1;
        int v8;
        Shape v6_1;
        boolean v5;
        int v4;
        Modifier v3;
        Function0 v13;
        int v1;
        int v11 = arg37;
        int v12 = arg38;
        Composer v7 = arg36.startRestartGroup(0x8C210046);
        ComposerKt.sourceInformation(v7, "C(ElevatedButton)N(onClick,modifier,enabled,shape,colors,elevation,border,contentPadding,interactionSource,content)215@10659L315:Button.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
            v13 = arg26;
        }
        else {
            v13 = arg26;
            if((v11 & 6) == 0) {
                v1 = v7.changedInstance(v13) ? 4 : 2;
                v1 |= v11;
            }
            else {
                v1 = v11;
            }
        }

        int v2 = v12 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
            goto label_37;
        }
        else if((v11 & 0x30) == 0) {
            v3 = arg27;
            v4 = v7.changed(v3) ? 0x20 : 16;
            v1 |= v4;
        }
        else {
        label_37:
            v3 = arg27;
        }

        v4 = v12 & 4;
        if(v4 != 0) {
            v1 |= 0x180;
            goto label_52;
        }
        else if((v11 & 0x180) == 0) {
            v5 = arg28;
            int v6 = v7.changed(v5) ? 0x100 : 0x80;
            v1 |= v6;
        }
        else {
        label_52:
            v5 = arg28;
        }

        if((v11 & 0xC00) == 0) {
            if((v12 & 8) == 0) {
                v6_1 = arg29;
                if(v7.changed(v6_1)) {
                    v8 = 0x800;
                }
                else {
                    goto label_63;
                }
            }
            else {
                v6_1 = arg29;
            label_63:
                v8 = 0x400;
            }

            v1 |= v8;
        }
        else {
            v6_1 = arg29;
        }

        if((v11 & 0x6000) == 0) {
            if((v12 & 16) == 0) {
                v8_1 = arg30;
                if(v7.changed(v8_1)) {
                    v9 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v8_1 = arg30;
            label_77:
                v9 = 0x2000;
            }

            v1 |= v9;
        }
        else {
            v8_1 = arg30;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v9_1 = arg31;
                if(v7.changed(v9_1)) {
                    v10 = 0x20000;
                }
                else {
                    goto label_92;
                }
            }
            else {
                v9_1 = arg31;
            label_92:
                v10 = 0x10000;
            }

            v1 |= v10;
        }
        else {
            v9_1 = arg31;
        }

        v10 = v12 & 0x40;
        int v14 = 0x180000;
        if(v10 != 0) {
            v1 |= v14;
            goto label_111;
        }
        else if((v14 & v11) == 0) {
            v14_1 = arg32;
            v15 = v7.changed(v14_1) ? 0x100000 : 0x80000;
            v1 |= v15;
        }
        else {
        label_111:
            v14_1 = arg32;
        }

        v15 = v12 & 0x80;
        int v16 = 0xC00000;
        if(v15 != 0) {
            v1 |= v16;
        }
        else {
            PaddingValues v0 = arg33;
            if((v11 & v16) == 0) {
                v17 = v7.changed(v0) ? 0x800000 : 0x400000;
                v1 |= v17;
            }
        }

        int v36 = v2;
        v2 = v12 & 0x100;
        v17 = 0x6000000;
        if(v2 != 0) {
            v1 |= v17;
            goto label_144;
        }
        else if((v11 & v17) == 0) {
            v17 = v2;
            v18 = v7.changed(arg34) ? 0x4000000 : 0x2000000;
            v1 |= v18;
        }
        else {
        label_144:
            v17 = v2;
        }

        v18 = 0x30000000;
        if((v12 & 0x200) != 0) {
            v1 |= v18;
        }
        else if((v11 & v18) == 0) {
            v18 = v7.changedInstance(arg35) ? 0x20000000 : 0x10000000;
            v1 |= v18;
        }

        boolean v18_1 = true;
        boolean v0_1 = (v1 & 306783379) != 306783378 ? true : false;
        if(v7.shouldExecute(v0_1, v1 & 1)) {
            v7.startDefaults();
            ComposerKt.sourceInformation(v7, "207@10290L13,208@10347L22,209@10420L25");
            int v19 = 0xFFF8FFFF;
            v2 = 0xFFFF1FFF;
            if((v11 & 1) == 0 || (v7.getDefaultsInvalid())) {
                if(v36 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = v3;
                }

                if(v4 != 0) {
                }
                else {
                    v18_1 = v5;
                }

                v4 = 6;
                if((v12 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                    v20_1 = ButtonDefaults.INSTANCE.getElevatedShape(v7, v4);
                }
                else {
                    v20_1 = v6_1;
                }

                if((v12 & 16) != 0) {
                    v1 &= v2;
                    v21_1 = ButtonDefaults.INSTANCE.elevatedButtonColors(v7, v4);
                }
                else {
                    v21_1 = v8_1;
                }

                int v22 = v1;
                if((v12 & 0x20) != 0) {
                    v9_1 = ButtonDefaults.INSTANCE.elevatedButtonElevation-R_JCAzs(0f, 0f, 0f, 0f, 0f, v7, 0x30000, 0x1F);
                    v1 = v22 & v19;
                }
                else {
                    v1 = v22;
                }

                BorderStroke v2_1 = null;
                if(v10 != 0) {
                    v14_1 = v2_1;
                }

                PaddingValues v3_1 = v15 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : arg33;
                v19_1 = v14_1;
                v15_1 = v18_1;
                v16_1 = v20_1;
                if(v17 != 0) {
                    v17_1 = v21_1;
                    v14_3 = v0_3;
                    v21 = ((MutableInteractionSource)v2_1);
                }
                else {
                    v17_1 = v21_1;
                    v21 = arg34;
                    v14_3 = v0_3;
                }

                v20 = v3_1;
                v18_2 = v9_1;
                v0_2 = 0x8C210046;
            }
            else {
                v7.skipToGroupEnd();
                if((v12 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v1 &= v2;
                }

                if((v12 & 0x20) != 0) {
                    v1 &= v19;
                }

                v20 = arg33;
                v21 = arg34;
                v15_1 = v5;
                v16_1 = v6_1;
                v17_1 = v8_1;
                v18_2 = v9_1;
                v19_1 = v14_1;
                v0_2 = 0x8C210046;
                Modifier v14_2 = v3;
            }

            v7.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_2, v1, -1, "androidx.compose.material3.ElevatedButton (Button.kt:215)");
            }

            ButtonKt.Button(v13, ((Modifier)v14_3), v15_1, v16_1, v17_1, v18_2, v19_1, v20, v21, arg35, v7, v1 & 0x7FFFFFFE, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v23 = v7;
            v2_2 = ((Modifier)v14_3);
            v3_2 = v15_1;
            v4_1 = v16_1;
            v5_1 = v17_1;
            v6_2 = v18_2;
            v7_1 = v19_1;
            v8_2 = v20;
            v9_2 = v21;
        }
        else {
            v7.skipToGroupEnd();
            v2_2 = v3;
            v3_2 = v5;
            v4_1 = v6_1;
            v23 = v7;
            v5_1 = v8_1;
            v6_2 = v9_1;
            v7_1 = v14_1;
            v8_2 = arg33;
            v9_2 = arg34;
        }

        ScopeUpdateScope v13_1 = v23.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new ButtonKt$$ExternalSyntheticLambda3(arg26, v2_2, v3_2, v4_1, v5_1, v6_2, v7_1, v8_2, v9_2, arg35, v11, v12));
        }
    }

    static final Unit ElevatedButton$lambda$4(Function0 arg14, Modifier arg15, boolean arg16, Shape arg17, ButtonColors arg18, ButtonElevation arg19, BorderStroke arg20, PaddingValues arg21, MutableInteractionSource arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        ButtonKt.ElevatedButton(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void FilledTonalButton(Function0 arg26, Modifier arg27, boolean arg28, Shape arg29, ButtonColors arg30, ButtonElevation arg31, BorderStroke arg32, PaddingValues arg33, MutableInteractionSource arg34, Function3 arg35, Composer arg36, int arg37, int arg38) {
        MutableInteractionSource v9_2;
        PaddingValues v8_2;
        BorderStroke v7_1;
        ButtonElevation v6_2;
        ButtonColors v5_1;
        Shape v4_1;
        boolean v3_2;
        Modifier v2_2;
        Composer v23;
        Modifier v14_2;
        int v0_2;
        BorderStroke v19_1;
        ButtonElevation v18_2;
        ButtonColors v17_1;
        Shape v16_1;
        boolean v15_1;
        MutableInteractionSource v21;
        PaddingValues v20;
        Companion v14_3;
        ButtonColors v21_1;
        Shape v20_1;
        Modifier v0_4;
        int v18;
        int v17;
        int v15;
        BorderStroke v14_1;
        int v10;
        ButtonElevation v9_1;
        int v9;
        ButtonColors v8_1;
        int v8;
        Shape v6_1;
        boolean v5;
        int v4;
        Modifier v3;
        Function0 v13;
        int v1;
        int v11 = arg37;
        int v12 = arg38;
        Composer v7 = arg36.startRestartGroup(0xF9E65CD0);
        ComposerKt.sourceInformation(v7, "C(FilledTonalButton)N(onClick,modifier,enabled,shape,colors,elevation,border,contentPadding,interactionSource,content)288@14374L315:Button.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
            v13 = arg26;
        }
        else {
            v13 = arg26;
            if((v11 & 6) == 0) {
                v1 = v7.changedInstance(v13) ? 4 : 2;
                v1 |= v11;
            }
            else {
                v1 = v11;
            }
        }

        int v2 = v12 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
            goto label_37;
        }
        else if((v11 & 0x30) == 0) {
            v3 = arg27;
            v4 = v7.changed(v3) ? 0x20 : 16;
            v1 |= v4;
        }
        else {
        label_37:
            v3 = arg27;
        }

        v4 = v12 & 4;
        if(v4 != 0) {
            v1 |= 0x180;
            goto label_52;
        }
        else if((v11 & 0x180) == 0) {
            v5 = arg28;
            int v6 = v7.changed(v5) ? 0x100 : 0x80;
            v1 |= v6;
        }
        else {
        label_52:
            v5 = arg28;
        }

        if((v11 & 0xC00) == 0) {
            if((v12 & 8) == 0) {
                v6_1 = arg29;
                if(v7.changed(v6_1)) {
                    v8 = 0x800;
                }
                else {
                    goto label_63;
                }
            }
            else {
                v6_1 = arg29;
            label_63:
                v8 = 0x400;
            }

            v1 |= v8;
        }
        else {
            v6_1 = arg29;
        }

        if((v11 & 0x6000) == 0) {
            if((v12 & 16) == 0) {
                v8_1 = arg30;
                if(v7.changed(v8_1)) {
                    v9 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v8_1 = arg30;
            label_77:
                v9 = 0x2000;
            }

            v1 |= v9;
        }
        else {
            v8_1 = arg30;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v9_1 = arg31;
                if(v7.changed(v9_1)) {
                    v10 = 0x20000;
                }
                else {
                    goto label_92;
                }
            }
            else {
                v9_1 = arg31;
            label_92:
                v10 = 0x10000;
            }

            v1 |= v10;
        }
        else {
            v9_1 = arg31;
        }

        v10 = v12 & 0x40;
        int v14 = 0x180000;
        if(v10 != 0) {
            v1 |= v14;
            goto label_111;
        }
        else if((v14 & v11) == 0) {
            v14_1 = arg32;
            v15 = v7.changed(v14_1) ? 0x100000 : 0x80000;
            v1 |= v15;
        }
        else {
        label_111:
            v14_1 = arg32;
        }

        v15 = v12 & 0x80;
        int v16 = 0xC00000;
        if(v15 != 0) {
            v1 |= v16;
        }
        else {
            PaddingValues v0 = arg33;
            if((v11 & v16) == 0) {
                v17 = v7.changed(v0) ? 0x800000 : 0x400000;
                v1 |= v17;
            }
        }

        int v36 = v2;
        v2 = v12 & 0x100;
        v17 = 0x6000000;
        if(v2 != 0) {
            v1 |= v17;
            goto label_144;
        }
        else if((v11 & v17) == 0) {
            v17 = v2;
            v18 = v7.changed(arg34) ? 0x4000000 : 0x2000000;
            v1 |= v18;
        }
        else {
        label_144:
            v17 = v2;
        }

        v18 = 0x30000000;
        if((v12 & 0x200) != 0) {
            v1 |= v18;
        }
        else if((v11 & v18) == 0) {
            v18 = v7.changedInstance(arg35) ? 0x20000000 : 0x10000000;
            v1 |= v18;
        }

        boolean v18_1 = true;
        boolean v0_1 = (v1 & 306783379) != 306783378 ? true : false;
        if(v7.shouldExecute(v0_1, v1 & 1)) {
            v7.startDefaults();
            ComposerKt.sourceInformation(v7, "280@13996L16,281@14056L25,282@14132L28");
            int v19 = 0xFFF8FFFF;
            v2 = 0xFFFF1FFF;
            if((v11 & 1) == 0 || (v7.getDefaultsInvalid())) {
                if(v36 != 0) {
                    Companion v0_3 = Modifier.Companion;
                }
                else {
                    v0_4 = v3;
                }

                if(v4 != 0) {
                }
                else {
                    v18_1 = v5;
                }

                v4 = 6;
                if((v12 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                    v20_1 = ButtonDefaults.INSTANCE.getFilledTonalShape(v7, v4);
                }
                else {
                    v20_1 = v6_1;
                }

                if((v12 & 16) != 0) {
                    v1 &= v2;
                    v21_1 = ButtonDefaults.INSTANCE.filledTonalButtonColors(v7, v4);
                }
                else {
                    v21_1 = v8_1;
                }

                int v22 = v1;
                if((v12 & 0x20) != 0) {
                    v9_1 = ButtonDefaults.INSTANCE.filledTonalButtonElevation-R_JCAzs(0f, 0f, 0f, 0f, 0f, v7, 0x30000, 0x1F);
                    v1 = v22 & v19;
                }
                else {
                    v1 = v22;
                }

                BorderStroke v2_1 = null;
                if(v10 != 0) {
                    v14_1 = v2_1;
                }

                PaddingValues v3_1 = v15 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : arg33;
                v19_1 = v14_1;
                v15_1 = v18_1;
                v16_1 = v20_1;
                if(v17 != 0) {
                    v17_1 = v21_1;
                    v14_3 = ((Companion)v0_4);
                    v21 = ((MutableInteractionSource)v2_1);
                }
                else {
                    v17_1 = v21_1;
                    v21 = arg34;
                    v14_3 = ((Companion)v0_4);
                }

                v20 = v3_1;
                v18_2 = v9_1;
                v0_2 = 0xF9E65CD0;
            }
            else {
                v7.skipToGroupEnd();
                if((v12 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v1 &= v2;
                }

                if((v12 & 0x20) != 0) {
                    v1 &= v19;
                }

                v20 = arg33;
                v21 = arg34;
                v15_1 = v5;
                v16_1 = v6_1;
                v17_1 = v8_1;
                v18_2 = v9_1;
                v19_1 = v14_1;
                v0_2 = 0xF9E65CD0;
                v14_2 = v3;
            }

            v7.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_2, v1, -1, "androidx.compose.material3.FilledTonalButton (Button.kt:288)");
            }

            ButtonKt.Button(v13, v14_2, v15_1, v16_1, v17_1, v18_2, v19_1, v20, v21, arg35, v7, v1 & 0x7FFFFFFE, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v23 = v7;
            v2_2 = v14_2;
            v3_2 = v15_1;
            v4_1 = v16_1;
            v5_1 = v17_1;
            v6_2 = v18_2;
            v7_1 = v19_1;
            v8_2 = v20;
            v9_2 = v21;
        }
        else {
            v7.skipToGroupEnd();
            v2_2 = v3;
            v3_2 = v5;
            v4_1 = v6_1;
            v23 = v7;
            v5_1 = v8_1;
            v6_2 = v9_1;
            v7_1 = v14_1;
            v8_2 = arg33;
            v9_2 = arg34;
        }

        ScopeUpdateScope v13_1 = v23.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new ButtonKt$$ExternalSyntheticLambda5(arg26, v2_2, v3_2, v4_1, v5_1, v6_2, v7_1, v8_2, v9_2, arg35, v11, v12));
        }
    }

    static final Unit FilledTonalButton$lambda$5(Function0 arg14, Modifier arg15, boolean arg16, Shape arg17, ButtonColors arg18, ButtonElevation arg19, BorderStroke arg20, PaddingValues arg21, MutableInteractionSource arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        ButtonKt.FilledTonalButton(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void OutlinedButton(Function0 arg26, Modifier arg27, boolean arg28, Shape arg29, ButtonColors arg30, ButtonElevation arg31, BorderStroke arg32, PaddingValues arg33, MutableInteractionSource arg34, Function3 arg35, Composer arg36, int arg37, int arg38) {
        MutableInteractionSource v9_1;
        BorderStroke v7_3;
        ButtonElevation v6_1;
        ButtonColors v5_2;
        Shape v4_1;
        boolean v3_2;
        Modifier v2_1;
        Composer v23;
        Modifier v14_2;
        BorderStroke v19_1;
        ButtonElevation v18_1;
        ButtonColors v17_1;
        Shape v16_1;
        boolean v15_1;
        MutableInteractionSource v21;
        PaddingValues v20;
        Companion v14_3;
        PaddingValues v8_2;
        BorderStroke v4;
        ButtonColors v3_1;
        Shape v5_1;
        Companion v0_3;
        int v18;
        int v17;
        int v15;
        BorderStroke v14_1;
        ButtonElevation v10_1;
        int v9;
        ButtonColors v8_1;
        int v8;
        Shape v7_1;
        boolean v6;
        int v5;
        Function0 v13;
        int v2;
        int v11 = arg37;
        int v12 = arg38;
        Composer v1 = arg36.startRestartGroup(0x17D7208E);
        ComposerKt.sourceInformation(v1, "C(OutlinedButton)N(onClick,modifier,enabled,shape,colors,elevation,border,contentPadding,interactionSource,content)360@17981L315:Button.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v2 = v11 | 6;
            v13 = arg26;
        }
        else {
            v13 = arg26;
            if((v11 & 6) == 0) {
                v2 = v1.changedInstance(v13) ? 4 : 2;
                v2 |= v11;
            }
            else {
                v2 = v11;
            }
        }

        int v3 = v12 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
        }
        else if((v11 & 0x30) == 0) {
            v5 = v1.changed(arg27) ? 0x20 : 16;
            v2 |= v5;
        }

        v5 = v12 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_52;
        }
        else if((v11 & 0x180) == 0) {
            v6 = arg28;
            int v7 = v1.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_52:
            v6 = arg28;
        }

        if((v11 & 0xC00) == 0) {
            if((v12 & 8) == 0) {
                v7_1 = arg29;
                if(v1.changed(v7_1)) {
                    v8 = 0x800;
                }
                else {
                    goto label_63;
                }
            }
            else {
                v7_1 = arg29;
            label_63:
                v8 = 0x400;
            }

            v2 |= v8;
        }
        else {
            v7_1 = arg29;
        }

        if((v11 & 0x6000) == 0) {
            if((v12 & 16) == 0) {
                v8_1 = arg30;
                if(v1.changed(v8_1)) {
                    v9 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v8_1 = arg30;
            label_77:
                v9 = 0x2000;
            }

            v2 |= v9;
        }
        else {
            v8_1 = arg30;
        }

        v9 = v12 & 0x20;
        int v10 = 0x30000;
        if(v9 != 0) {
            v2 |= v10;
            goto label_96;
        }
        else if((v10 & v11) == 0) {
            v10_1 = arg31;
            int v14 = v1.changed(v10_1) ? 0x20000 : 0x10000;
            v2 |= v14;
        }
        else {
        label_96:
            v10_1 = arg31;
        }

        if((0x180000 & v11) == 0) {
            if((v12 & 0x40) == 0) {
                v14_1 = arg32;
                if(v1.changed(v14_1)) {
                    v15 = 0x100000;
                }
                else {
                    goto label_108;
                }
            }
            else {
                v14_1 = arg32;
            label_108:
                v15 = 0x80000;
            }

            v2 |= v15;
        }
        else {
            v14_1 = arg32;
        }

        v15 = v12 & 0x80;
        int v16 = 0xC00000;
        if(v15 != 0) {
            v2 |= v16;
        }
        else {
            PaddingValues v0 = arg33;
            if((v11 & v16) == 0) {
                v17 = v1.changed(v0) ? 0x800000 : 0x400000;
                v2 |= v17;
            }
        }

        int v0_1 = v12 & 0x100;
        v17 = 0x6000000;
        if(v0_1 != 0) {
            v2 |= v17;
            goto label_143;
        }
        else if((v11 & v17) == 0) {
            v17 = v0_1;
            v18 = v1.changed(arg34) ? 0x4000000 : 0x2000000;
            v2 |= v18;
        }
        else {
        label_143:
            v17 = v0_1;
        }

        v18 = 0x30000000;
        if((v12 & 0x200) != 0) {
            v2 |= v18;
        }
        else if((v11 & v18) == 0) {
            v18 = v1.changedInstance(arg35) ? 0x20000000 : 0x10000000;
            v2 |= v18;
        }

        int v36 = v3;
        boolean v0_2 = (v2 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_2, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "352@17608L13,353@17665L22,355@17772L29");
            v3 = 0xFFC7FFFF;
            int v19 = 0xFFFF1FFF;
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v36 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = arg27;
                }

                if(v5 != 0) {
                    v6 = true;
                }

                v36 = v3;
                v3 = 6;
                if((v12 & 8) != 0) {
                    v5_1 = ButtonDefaults.INSTANCE.getOutlinedShape(v1, v3);
                    v2 &= 0xFFFFE3FF;
                }
                else {
                    v5_1 = v7_1;
                }

                if((v12 & 16) != 0) {
                    v3_1 = ButtonDefaults.INSTANCE.outlinedButtonColors(v1, v3);
                    v2 &= v19;
                }
                else {
                    v3_1 = v8_1;
                }

                ButtonElevation v7_2 = null;
                if(v9 != 0) {
                    v10_1 = v7_2;
                }

                if((v12 & 0x40) != 0) {
                    v4 = ButtonDefaults.INSTANCE.outlinedButtonBorder(v6, v1, v2 >> 6 & 14 | 0x30, 0);
                    v2 &= v36;
                }
                else {
                    v4 = v14_1;
                }

                v8_2 = v15 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : arg33;
                if(v17 != 0) {
                    v14_3 = v0_3;
                    v17_1 = v3_1;
                    v19_1 = v4;
                    v16_1 = v5_1;
                    v15_1 = v6;
                    v21 = ((MutableInteractionSource)v7_2);
                }
                else {
                    v21 = arg34;
                    v14_3 = v0_3;
                    v17_1 = v3_1;
                    v19_1 = v4;
                    v16_1 = v5_1;
                    v15_1 = v6;
                }

                v20 = v8_2;
                v18_1 = v10_1;
                v0_1 = 0x17D7208E;
            }
            else {
                v1.skipToGroupEnd();
                if((v12 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v2 &= v19;
                }

                if((v12 & 0x40) != 0) {
                    v2 &= v3;
                }

                v20 = arg33;
                v21 = arg34;
                v15_1 = v6;
                v16_1 = v7_1;
                v17_1 = v8_1;
                v18_1 = v10_1;
                v19_1 = v14_1;
                v0_1 = 0x17D7208E;
                v14_2 = arg27;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v2, -1, "androidx.compose.material3.OutlinedButton (Button.kt:360)");
            }

            v23 = v1;
            ButtonKt.Button(v13, v14_2, v15_1, v16_1, v17_1, v18_1, v19_1, v20, v21, arg35, v23, v2 & 0x7FFFFFFE, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v14_2;
            v3_2 = v15_1;
            v4_1 = v16_1;
            v5_2 = v17_1;
            v6_1 = v18_1;
            v7_3 = v19_1;
            v8_2 = v20;
            v9_1 = v21;
        }
        else {
            v23 = v1;
            v23.skipToGroupEnd();
            v2_1 = arg27;
            v9_1 = arg34;
            v3_2 = v6;
            v4_1 = v7_1;
            v5_2 = v8_1;
            v6_1 = v10_1;
            v7_3 = v14_1;
            v8_2 = arg33;
        }

        ScopeUpdateScope v13_1 = v23.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new ButtonKt$$ExternalSyntheticLambda0(arg26, v2_1, v3_2, v4_1, v5_2, v6_1, v7_3, v8_2, v9_1, arg35, v11, v12));
        }
    }

    static final Unit OutlinedButton$lambda$6(Function0 arg14, Modifier arg15, boolean arg16, Shape arg17, ButtonColors arg18, ButtonElevation arg19, BorderStroke arg20, PaddingValues arg21, MutableInteractionSource arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        ButtonKt.OutlinedButton(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void TextButton(Function0 arg26, Modifier arg27, boolean arg28, Shape arg29, ButtonColors arg30, ButtonElevation arg31, BorderStroke arg32, PaddingValues arg33, MutableInteractionSource arg34, Function3 arg35, Composer arg36, int arg37, int arg38) {
        MutableInteractionSource v9_1;
        PaddingValues v8_2;
        BorderStroke v7_2;
        ButtonElevation v6_1;
        ButtonColors v5_1;
        Shape v4_2;
        boolean v3_2;
        Modifier v2_1;
        Composer v23;
        boolean v15_2;
        BorderStroke v19_2;
        ButtonElevation v18_1;
        ButtonColors v17_1;
        Shape v16_1;
        Modifier v14_1;
        MutableInteractionSource v21;
        PaddingValues v20;
        int v19;
        int v18;
        BorderStroke v15_1;
        int v14;
        ButtonElevation v10_1;
        int v9;
        ButtonColors v8_1;
        int v8;
        Shape v7_1;
        boolean v6;
        int v5;
        Modifier v4;
        Function0 v13;
        int v2;
        int v11 = arg37;
        int v12 = arg38;
        Composer v1 = arg36.startRestartGroup(-1061374109);
        ComposerKt.sourceInformation(v1, "C(TextButton)N(onClick,modifier,enabled,shape,colors,elevation,border,contentPadding,interactionSource,content)429@21385L315:Button.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v2 = v11 | 6;
            v13 = arg26;
        }
        else {
            v13 = arg26;
            if((v11 & 6) == 0) {
                v2 = v1.changedInstance(v13) ? 4 : 2;
                v2 |= v11;
            }
            else {
                v2 = v11;
            }
        }

        int v3 = v12 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_37;
        }
        else if((v11 & 0x30) == 0) {
            v4 = arg27;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_37:
            v4 = arg27;
        }

        v5 = v12 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_52;
        }
        else if((v11 & 0x180) == 0) {
            v6 = arg28;
            int v7 = v1.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_52:
            v6 = arg28;
        }

        if((v11 & 0xC00) == 0) {
            if((v12 & 8) == 0) {
                v7_1 = arg29;
                if(v1.changed(v7_1)) {
                    v8 = 0x800;
                }
                else {
                    goto label_63;
                }
            }
            else {
                v7_1 = arg29;
            label_63:
                v8 = 0x400;
            }

            v2 |= v8;
        }
        else {
            v7_1 = arg29;
        }

        if((v11 & 0x6000) == 0) {
            if((v12 & 16) == 0) {
                v8_1 = arg30;
                if(v1.changed(v8_1)) {
                    v9 = 0x4000;
                }
                else {
                    goto label_77;
                }
            }
            else {
                v8_1 = arg30;
            label_77:
                v9 = 0x2000;
            }

            v2 |= v9;
        }
        else {
            v8_1 = arg30;
        }

        v9 = v12 & 0x20;
        int v10 = 0x30000;
        if(v9 != 0) {
            v2 |= v10;
            goto label_96;
        }
        else if((v10 & v11) == 0) {
            v10_1 = arg31;
            v14 = v1.changed(v10_1) ? 0x20000 : 0x10000;
            v2 |= v14;
        }
        else {
        label_96:
            v10_1 = arg31;
        }

        v14 = v12 & 0x40;
        int v15 = 0x180000;
        if(v14 != 0) {
            v2 |= v15;
            goto label_112;
        }
        else if((v15 & v11) == 0) {
            v15_1 = arg32;
            int v16 = v1.changed(v15_1) ? 0x100000 : 0x80000;
            v2 |= v16;
        }
        else {
        label_112:
            v15_1 = arg32;
        }

        int v0 = v12 & 0x80;
        int v17 = 0xC00000;
        if(v0 != 0) {
            v2 |= v17;
            goto label_129;
        }
        else if((v11 & v17) == 0) {
            v17 = v0;
            v18 = v1.changed(arg33) ? 0x800000 : 0x400000;
            v2 |= v18;
        }
        else {
        label_129:
            v17 = v0;
        }

        v0 = v12 & 0x100;
        v18 = 0x6000000;
        if(v0 != 0) {
            v2 |= v18;
            goto label_147;
        }
        else if((v11 & v18) == 0) {
            v18 = v0;
            v19 = v1.changed(arg34) ? 0x4000000 : 0x2000000;
            v2 |= v19;
        }
        else {
        label_147:
            v18 = v0;
        }

        v19 = 0x30000000;
        if((v12 & 0x200) != 0) {
            v2 |= v19;
        }
        else if((v11 & v19) == 0) {
            v19 = v1.changedInstance(arg35) ? 0x20000000 : 0x10000000;
            v2 |= v19;
        }

        int v36 = v3;
        boolean v19_1 = true;
        boolean v0_1 = (v2 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_1, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "421@21050L9,422@21103L18");
            v3 = 0xFFFF1FFF;
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v36 != 0) {
                    Companion v4_1 = Modifier.Companion;
                }

                if(v5 != 0) {
                }
                else {
                    v19_1 = v6;
                }

                v5 = 6;
                if((v12 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                    v7_1 = ButtonDefaults.INSTANCE.getTextShape(v1, v5);
                }

                if((v12 & 16) != 0) {
                    v2 &= v3;
                    v8_1 = ButtonDefaults.INSTANCE.textButtonColors(v1, v5);
                }

                ButtonElevation v0_2 = null;
                if(v9 != 0) {
                    v10_1 = v0_2;
                }

                if(v14 != 0) {
                    v15_1 = ((BorderStroke)v0_2);
                }

                PaddingValues v3_1 = v17 != 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : arg33;
                if(v18 != 0) {
                    boolean v14_2 = v19_1;
                    v19_2 = v15_1;
                    v15_2 = v14_2;
                    v21 = ((MutableInteractionSource)v0_2);
                }
                else {
                    v0_1 = v19_1;
                    v19_2 = v15_1;
                    v15_2 = v0_1;
                    v21 = arg34;
                }

                v20 = v3_1;
                v14_1 = v4;
                v16_1 = v7_1;
                v17_1 = v8_1;
                v18_1 = v10_1;
                v0 = -1061374109;
            }
            else {
                v1.skipToGroupEnd();
                if((v12 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v2 &= v3;
                }

                v20 = arg33;
                v21 = arg34;
                v14_1 = v4;
                v16_1 = v7_1;
                v17_1 = v8_1;
                v18_1 = v10_1;
                v19_2 = v15_1;
                v0 = -1061374109;
                v15_2 = v6;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.TextButton (Button.kt:429)");
            }

            v23 = v1;
            ButtonKt.Button(v13, v14_1, v15_2, v16_1, v17_1, v18_1, v19_2, v20, v21, arg35, v23, v2 & 0x7FFFFFFE, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v14_1;
            v3_2 = v15_2;
            v4_2 = v16_1;
            v5_1 = v17_1;
            v6_1 = v18_1;
            v7_2 = v19_2;
            v8_2 = v20;
            v9_1 = v21;
        }
        else {
            v23 = v1;
            v23.skipToGroupEnd();
            v9_1 = arg34;
            v2_1 = v4;
            v3_2 = v6;
            v4_2 = v7_1;
            v5_1 = v8_1;
            v6_1 = v10_1;
            v7_2 = v15_1;
            v8_2 = arg33;
        }

        ScopeUpdateScope v13_1 = v23.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new ButtonKt$$ExternalSyntheticLambda4(arg26, v2_1, v3_2, v4_2, v5_1, v6_1, v7_2, v8_2, v9_1, arg35, v11, v12));
        }
    }

    static final Unit TextButton$lambda$7(Function0 arg14, Modifier arg15, boolean arg16, Shape arg17, ButtonColors arg18, ButtonElevation arg19, BorderStroke arg20, PaddingValues arg21, MutableInteractionSource arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        ButtonKt.TextButton(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }
}

