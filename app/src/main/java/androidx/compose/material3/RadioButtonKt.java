package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AO\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\"\u0010\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010\"\u0010\u0010\u0011\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010\"\u0010\u0010\u0012\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0013"}, d2={"RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "RadioButtonPadding", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonDotSize", "RadioStrokeWidth", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RadioButtonKt {
    private static final float RadioButtonDotSize;
    private static final float RadioButtonPadding;
    private static final float RadioStrokeWidth;

    static {
        RadioButtonKt.RadioButtonPadding = Dp.constructor-impl(2f);
        RadioButtonKt.RadioButtonDotSize = Dp.constructor-impl(12f);
        RadioButtonKt.RadioStrokeWidth = Dp.constructor-impl(2f);
    }

    public static final void RadioButton(boolean arg24, Function0 arg25, Modifier arg26, boolean arg27, RadioButtonColors arg28, MutableInteractionSource arg29, Composer arg30, int arg31, int arg32) {
        Modifier v3_4;
        MutableInteractionSource v6_2;
        Companion v1_2;
        Modifier v0_3;
        boolean v4_3;
        Modifier v11_3;
        RadioButtonColors v10_1;
        RadioButtonColors v5_1;
        boolean v3_1;
        Modifier v4_1;
        MutableInteractionSource v2_1;
        Companion v4_2;
        MutableInteractionSource v11_1;
        int v10;
        RadioButtonColors v9_1;
        boolean v8;
        int v6;
        Modifier v5;
        int v4;
        int v3;
        boolean v1 = arg24;
        Function0 v2 = arg25;
        int v7 = arg31;
        int v0 = 408580840;
        Composer v12 = arg30.startRestartGroup(v0);
        ComposerKt.sourceInformation(v12, "C(RadioButton)N(selected,onClick,modifier,enabled,colors,interactionSource)85@4070L7,82@3836L252,87@4117L29,114@5028L416,101@4610L834:RadioButton.kt#uh7d8r");
        if((arg32 & 1) != 0) {
            v3 = v7 | 6;
        }
        else if((v7 & 6) == 0) {
            v3 = v12.changed(v1) ? 4 : 2;
            v3 |= v7;
        }
        else {
            v3 = v7;
        }

        if((arg32 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v7 & 0x30) == 0) {
            v4 = v12.changedInstance(v2) ? 0x20 : 16;
            v3 |= v4;
        }

        v4 = arg32 & 4;
        if(v4 != 0) {
            v3 |= 0x180;
            goto label_48;
        }
        else if((v7 & 0x180) == 0) {
            v5 = arg26;
            v6 = v12.changed(v5) ? 0x100 : 0x80;
            v3 |= v6;
        }
        else {
        label_48:
            v5 = arg26;
        }

        v6 = arg32 & 8;
        if(v6 != 0) {
            v3 |= 0xC00;
            goto label_63;
        }
        else if((v7 & 0xC00) == 0) {
            v8 = arg27;
            int v9 = v12.changed(v8) ? 0x800 : 0x400;
            v3 |= v9;
        }
        else {
        label_63:
            v8 = arg27;
        }

        if((v7 & 0x6000) == 0) {
            if((arg32 & 16) == 0) {
                v9_1 = arg28;
                if(v12.changed(v9_1)) {
                    v10 = 0x4000;
                }
                else {
                    goto label_74;
                }
            }
            else {
                v9_1 = arg28;
            label_74:
                v10 = 0x2000;
            }

            v3 |= v10;
        }
        else {
            v9_1 = arg28;
        }

        v10 = arg32 & 0x20;
        int v11 = 0x30000;
        if(v10 != 0) {
            v3 |= v11;
            goto label_93;
        }
        else if((v11 & v7) == 0) {
            v11_1 = arg29;
            int v13 = v12.changed(v11_1) ? 0x20000 : 0x10000;
            v3 |= v13;
        }
        else {
        label_93:
            v11_1 = arg29;
        }

        boolean v13_1 = (74899 & v3) != 74898 ? true : false;
        if(v12.shouldExecute(v13_1, v3 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "78@3737L8");
            MutableInteractionSource v14 = null;
            int v17 = 0xFFFF1FFF;
            int v15 = 6;
            if((v7 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v4_2 = Modifier.Companion;
                }
                else {
                    v4_1 = v5;
                }

                if(v6 != 0) {
                    v8 = true;
                }

                if((arg32 & 16) != 0) {
                    v3 &= v17;
                    v9_1 = RadioButtonDefaults.INSTANCE.colors(v12, v15);
                }

                v6 = v3;
                v3_1 = v8;
                v5_1 = v9_1;
                if(v10 != 0) {
                    v2_1 = v14;
                    goto label_143;
                }

            label_124:
                v2_1 = v11_1;
            }
            else {
                v12.skipToGroupEnd();
                if((arg32 & 16) != 0) {
                    v3 &= v17;
                }

                v6 = v3;
                v4_1 = v5;
                v3_1 = v8;
                v5_1 = v9_1;
                goto label_124;
            }

        label_143:
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v6, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:80)");
            }

            float v0_1 = 2f;
            float v8_1 = v1 ? Dp.constructor-impl(RadioButtonKt.RadioButtonDotSize / v0_1) : Dp.constructor-impl(0f);
            FiniteAnimationSpec v9_2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, v12, v15);
            Object v15_1 = v14;
            State v8_2 = AnimateAsStateKt.animateDpAsState-AjpBEmI(v8_1, ((AnimationSpec)v9_2), null, null, v12, 0, 12);
            State v9_3 = v5_1.radioColor$material3(v3_1, v1, v12, v6 >> 6 & 0x380 | (v6 >> 9 & 14 | v6 << 3 & 0x70));
            if(arg25 != null) {
                Companion v6_1 = Modifier.Companion;
                v10 = Role.Companion.getRadioButton-o7Vup1c();
                IndicationNodeFactory v0_2 = RippleKt.ripple-H2RKhps$default(false, Dp.constructor-impl(RadioButtonTokens.INSTANCE.getStateLayerSize-D9Ej5fM() / v0_1), 0, 4, null);
                Role v11_2 = Role.box-impl(v10);
                v10_1 = v5_1;
                Role v5_2 = v11_2;
                v11_3 = ((Modifier)v4_2);
                v4_3 = v3_1;
                v0_3 = SelectableKt.selectable-O2vRcR0(v6_1, v1, v2_1, v0_2, v4_3, v5_2, arg25);
            }
            else {
                v11_3 = ((Modifier)v4_2);
                v10_1 = v5_1;
                v4_3 = v3_1;
                Companion v0_4 = Modifier.Companion;
            }

            if(arg25 != null) {
                Modifier v1_1 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
            }
            else {
                v1_2 = Modifier.Companion;
            }

            v0_3 = SizeKt.requiredSize-3ABfNKs(PaddingKt.padding-3ABfNKs(SizeKt.wrapContentSize$default(v11_3.then(((Modifier)v1_2)).then(v0_3), Alignment.Companion.getCenter(), false, 2, v15_1), RadioButtonKt.RadioButtonPadding), RadioButtonTokens.INSTANCE.getIconSize-D9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(v12, 1804211304, "CC(remember):RadioButton.kt#9igjgp");
            int v1_3 = v12.changed(v9_3) | v12.changed(v8_2);
            Object v3_2 = v12.rememberedValue();
            if(v1_3 != 0 || v3_2 == Composer.Companion.getEmpty()) {
                RadioButtonKt$$ExternalSyntheticLambda0 v3_3 = new RadioButtonKt$$ExternalSyntheticLambda0(v9_3, v8_2);
                v12.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            CanvasKt.Canvas(v0_3, ((Function1)v3_2), v12, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_2 = v2_1;
            v5_1 = v10_1;
            v3_4 = v11_3;
        }
        else {
            v12.skipToGroupEnd();
            v3_4 = v5;
            v4_3 = v8;
            v5_1 = v9_1;
            v6_2 = v11_1;
        }

        ScopeUpdateScope v9_4 = v12.endRestartGroup();
        if(v9_4 != null) {
            v9_4.updateScope(new RadioButtonKt$$ExternalSyntheticLambda1(arg24, arg25, v3_4, v4_3, v5_1, v6_2, v7, arg32));
        }
    }

    static final Unit RadioButton$lambda$1$lambda$0(State arg13, State arg14, DrawScope arg15) {
        float v3 = arg15.toPx-0680j_4(RadioButtonKt.RadioStrokeWidth);
        float v12 = v3 / 2f;
        DrawScope.drawCircle-VaOC9Bg$default(arg15, arg13.getValue().unbox-impl(), arg15.toPx-0680j_4(Dp.constructor-impl(RadioButtonTokens.INSTANCE.getIconSize-D9Ej5fM() / 2f)) - v12, 0, 0f, new Stroke(v3, 0f, 0, 0, null, 30, null), null, 0, 108, null);
        if(Dp.compareTo-0680j_4(arg14.getValue().unbox-impl(), Dp.constructor-impl(0f)) > 0) {
            DrawScope.drawCircle-VaOC9Bg$default(arg15, arg13.getValue().unbox-impl(), arg15.toPx-0680j_4(arg14.getValue().unbox-impl()) - v12, 0, 0f, Fill.INSTANCE, null, 0, 108, null);
        }

        return Unit.INSTANCE;
    }

    static final Unit RadioButton$lambda$2(boolean arg10, Function0 arg11, Modifier arg12, boolean arg13, RadioButtonColors arg14, MutableInteractionSource arg15, int arg16, int arg17, Composer arg18, int arg19) {
        RadioButtonKt.RadioButton(arg10, arg11, arg12, arg13, arg14, arg15, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }
}

