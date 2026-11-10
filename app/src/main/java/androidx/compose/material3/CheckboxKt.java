package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1={"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AU\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0014\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\u001Ae\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0014\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0011\u001AO\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u00142\u000E\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0017\u001A_\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u00142\u000E\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0018\u001A=\u0010\u0019\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\u00142\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000FH\u0003¢\u0006\u0002\u0010\u001B\u001A3\u0010\u001C\u001A\u00020\u0001*\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u000FH\u0002¢\u0006\u0004\b$\u0010%\u001A;\u0010&\u001A\u00020\u0001*\u00020\u001D2\u0006\u0010\'\u001A\u00020\u001F2\u0006\u0010(\u001A\u00020\"2\u0006\u0010)\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u000F2\u0006\u0010*\u001A\u00020+H\u0002¢\u0006\u0004\b,\u0010-\"\u000E\u0010.\u001A\u00020/X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00100\u001A\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00103\u001A\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00104\u001A\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102¨\u00065"}, d2={"Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "checkmarkStroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "outlineStroke", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "TriStateCheckbox", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/runtime/Composer;I)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "stroke", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/material3/CheckDrawingCache;)V", "SnapAnimationDelay", "", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CheckboxKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ToggleableState.values().length];
            try {
                v0[ToggleableState.On.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[ToggleableState.Off.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[ToggleableState.Indeterminate.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    private static final float CheckboxDefaultPadding = 0f;
    private static final float CheckboxSize = 0f;
    private static final float RadiusSize = 0f;
    private static final int SnapAnimationDelay = 100;

    static {
        CheckboxKt.CheckboxDefaultPadding = Dp.constructor-impl(2f);
        CheckboxKt.CheckboxSize = Dp.constructor-impl(20f);
        CheckboxKt.RadiusSize = Dp.constructor-impl(2f);
    }

    public static final void Checkbox(boolean arg27, Function1 arg28, Modifier arg29, boolean arg30, CheckboxColors arg31, MutableInteractionSource arg32, Composer arg33, int arg34, int arg35) {
        MutableInteractionSource v6_2;
        CheckboxColors v5_1;
        boolean v4_1;
        Modifier v3_1;
        Composer v16_1;
        CheckboxKt$$ExternalSyntheticLambda6 v9_3;
        Object v9_2;
        MutableInteractionSource v15_1;
        CheckboxColors v14_2;
        boolean v13_1;
        Companion v9_1;
        int v15;
        MutableInteractionSource v14_1;
        int v13;
        CheckboxColors v12_1;
        boolean v11;
        int v10;
        Modifier v9;
        int v6;
        int v4;
        boolean v1 = arg27;
        Function1 v2 = arg28;
        int v7 = arg34;
        int v0 = -1406741137;
        Composer v3 = arg33.startRestartGroup(v0);
        ComposerKt.sourceInformation(v3, "C(Checkbox)N(checked,onCheckedChange,modifier,enabled,colors,interactionSource)98@4432L7,99@4492L493:Checkbox.kt#uh7d8r");
        if((arg35 & 1) != 0) {
            v4 = v7 | 6;
        }
        else if((v7 & 6) == 0) {
            v4 = v3.changed(v1) ? 4 : 2;
            v4 |= v7;
        }
        else {
            v4 = v7;
        }

        int v8 = 0x20;
        if((arg35 & 2) != 0) {
            v4 |= 0x30;
        }
        else if((v7 & 0x30) == 0) {
            v6 = v3.changedInstance(v2) ? v8 : 16;
            v4 |= v6;
        }

        v6 = arg35 & 4;
        if(v6 != 0) {
            v4 |= 0x180;
            goto label_49;
        }
        else if((v7 & 0x180) == 0) {
            v9 = arg29;
            v10 = v3.changed(v9) ? 0x100 : 0x80;
            v4 |= v10;
        }
        else {
        label_49:
            v9 = arg29;
        }

        v10 = arg35 & 8;
        if(v10 != 0) {
            v4 |= 0xC00;
            goto label_64;
        }
        else if((v7 & 0xC00) == 0) {
            v11 = arg30;
            int v12 = v3.changed(v11) ? 0x800 : 0x400;
            v4 |= v12;
        }
        else {
        label_64:
            v11 = arg30;
        }

        if((v7 & 0x6000) == 0) {
            if((arg35 & 16) == 0) {
                v12_1 = arg31;
                if(v3.changed(v12_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_75;
                }
            }
            else {
                v12_1 = arg31;
            label_75:
                v13 = 0x2000;
            }

            v4 |= v13;
        }
        else {
            v12_1 = arg31;
        }

        v13 = arg35 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v4 |= v14;
            goto label_94;
        }
        else if((v14 & v7) == 0) {
            v14_1 = arg32;
            v15 = v3.changed(v14_1) ? 0x20000 : 0x10000;
            v4 |= v15;
        }
        else {
        label_94:
            v14_1 = arg32;
        }

        int v16 = 0;
        boolean v5 = (74899 & v4) != 74898 ? true : false;
        if(v3.shouldExecute(v5, v4 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "95@4319L8");
            int v18 = 0xFFFF1FFF;
            v15 = 6;
            if((v7 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v6 != 0) {
                    v9_1 = Modifier.Companion;
                }

                if(v10 != 0) {
                    v11 = true;
                }

                if((arg35 & 16) != 0) {
                    v4 &= v18;
                    v12_1 = CheckboxDefaults.INSTANCE.colors(v3, v15);
                }

                if(v13 != 0) {
                    v13_1 = v11;
                    v14_2 = v12_1;
                    v15_1 = null;
                    goto label_125;
                }

            label_121:
                v13_1 = v11;
                v15_1 = v14_1;
                v14_2 = v12_1;
            }
            else {
                v3.skipToGroupEnd();
                if((arg35 & 16) != 0) {
                    v4 &= v18;
                }
                else {
                }

                goto label_121;
            }

        label_125:
            Modifier v12_2 = ((Modifier)v9_1);
            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:97)");
            }

            ProvidableCompositionLocal v0_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = v3.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v3);
            float v0_3 = ((float)Math.floor(((double)((Density)v0_2).toPx-0680j_4(CheckboxDefaults.INSTANCE.getStrokeWidth-D9Ej5fM()))));
            ToggleableState v6_1 = ToggleableStateKt.ToggleableState(v1);
            if(v2 != null) {
                v3.startReplaceGroup(0x7B26FDF6);
                ComposerKt.sourceInformation(v3, "103@4629L29");
                ComposerKt.sourceInformationMarkerStart(v3, 1036481964, "CC(remember):Checkbox.kt#9igjgp");
                v8 = (v4 & 0x70) == v8 ? 1 : 0;
                if((v4 & 14) == 4) {
                    v16 = 1;
                }

                v9_2 = v3.rememberedValue();
                if((v8 | v16) != 0 || v9_2 == Composer.Companion.getEmpty()) {
                    v9_3 = new CheckboxKt$$ExternalSyntheticLambda6(v2, v1);
                    v3.updateRememberedValue(v9_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v3);
                v3.endReplaceGroup();
                v9_2 = v9_3;
            }
            else {
                v3.startReplaceGroup(0x7B27FE8F);
                v3.endReplaceGroup();
                Function0 v9_4 = null;
            }

            v16_1 = v3;
            CheckboxKt.TriStateCheckbox(v6_1, ((Function0)v9_2), new Stroke(v0_3, 0f, StrokeCap.Companion.getSquare-KaPHkGw(), 0, null, 26, null), new Stroke(v0_3, 0f, 0, 0, null, 30, null), v12_2, v13_1, v14_2, v15_1, v16_1, v4 << 6 & 0x1FFE000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = v12_2;
            v4_1 = v13_1;
            v5_1 = v14_2;
            v6_2 = v15_1;
        }
        else {
            v16_1 = v3;
            v16_1.skipToGroupEnd();
            v3_1 = v9;
            v4_1 = v11;
            v5_1 = v12_1;
            v6_2 = v14_1;
        }

        ScopeUpdateScope v9_5 = v16_1.endRestartGroup();
        if(v9_5 != null) {
            v9_5.updateScope(new CheckboxKt$$ExternalSyntheticLambda7(v1, v2, v3_1, v4_1, v5_1, v6_2, v7, arg35));
        }
    }

    public static final void Checkbox(boolean arg22, Function1 arg23, Stroke arg24, Stroke arg25, Modifier arg26, boolean arg27, CheckboxColors arg28, MutableInteractionSource arg29, Composer arg30, int arg31, int arg32) {
        MutableInteractionSource v8_2;
        CheckboxColors v7_1;
        boolean v6_1;
        Modifier v5_1;
        Composer v19_1;
        CheckboxKt$$ExternalSyntheticLambda3 v4_2;
        CheckboxColors v17_1;
        int v0_1;
        boolean v16_1;
        MutableInteractionSource v18;
        int v17;
        MutableInteractionSource v7;
        int v16;
        CheckboxColors v15_1;
        boolean v12_1;
        int v11;
        Modifier v8;
        Stroke v14;
        Stroke v13;
        int v6;
        int v4;
        boolean v1 = arg22;
        Function1 v2 = arg23;
        int v9 = arg31;
        int v10 = arg32;
        Composer v3 = arg30.startRestartGroup(0x1FE26C6F);
        ComposerKt.sourceInformation(v3, "C(Checkbox)N(checked,onCheckedChange,checkmarkStroke,outlineStroke,modifier,enabled,colors,interactionSource)162@7424L439:Checkbox.kt#uh7d8r");
        if((v10 & 1) != 0) {
            v4 = v9 | 6;
        }
        else if((v9 & 6) == 0) {
            v4 = v3.changed(v1) ? 4 : 2;
            v4 |= v9;
        }
        else {
            v4 = v9;
        }

        if((v10 & 2) != 0) {
            v4 |= 0x30;
        }
        else if((v9 & 0x30) == 0) {
            v6 = v3.changedInstance(v2) ? 0x20 : 16;
            v4 |= v6;
        }

        if((v10 & 4) != 0) {
            v4 |= 0x180;
            v13 = arg24;
        }
        else {
            v13 = arg24;
            if((v9 & 0x180) == 0) {
                v6 = v3.changedInstance(v13) ? 0x100 : 0x80;
                v4 |= v6;
            }
        }

        if((v10 & 8) != 0) {
            v4 |= 0xC00;
            v14 = arg25;
        }
        else {
            v14 = arg25;
            if((v9 & 0xC00) == 0) {
                v6 = v3.changedInstance(v14) ? 0x800 : 0x400;
                v4 |= v6;
            }
        }

        v6 = v10 & 16;
        if(v6 != 0) {
            v4 |= 0x6000;
            goto label_77;
        }
        else if((v9 & 0x6000) == 0) {
            v8 = arg26;
            v11 = v3.changed(v8) ? 0x4000 : 0x2000;
            v4 |= v11;
        }
        else {
        label_77:
            v8 = arg26;
        }

        v11 = v10 & 0x20;
        int v12 = 0x30000;
        if(v11 != 0) {
            v4 |= v12;
            goto label_93;
        }
        else if((v12 & v9) == 0) {
            v12_1 = arg27;
            int v15 = v3.changed(v12_1) ? 0x20000 : 0x10000;
            v4 |= v15;
        }
        else {
        label_93:
            v12_1 = arg27;
        }

        if((0x180000 & v9) == 0) {
            if((v10 & 0x40) == 0) {
                v15_1 = arg28;
                if(v3.changed(v15_1)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_105;
                }
            }
            else {
                v15_1 = arg28;
            label_105:
                v16 = 0x80000;
            }

            v4 |= v16;
        }
        else {
            v15_1 = arg28;
        }

        int v5 = v10 & 0x80;
        v16 = 0xC00000;
        if(v5 != 0) {
            v4 |= v16;
            v7 = arg29;
        }
        else {
            v7 = arg29;
            if((v9 & v16) == 0) {
                v17 = v3.changed(v7) ? 0x800000 : 0x400000;
                v4 |= v17;
            }
        }

        v17 = v4;
        int v19 = 0;
        boolean v0 = (v4 & 0x492493) != 4793490 ? true : false;
        if(v3.shouldExecute(v0, v17 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "159@7349L8");
            Object v4_1 = null;
            int v21 = 0xFFC7FFFF;
            if((v9 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v6 != 0) {
                    Companion v8_1 = Modifier.Companion;
                }

                if(v11 != 0) {
                    v12_1 = true;
                }

                if((v10 & 0x40) != 0) {
                    v6 = v17 & v21;
                    v15_1 = CheckboxDefaults.INSTANCE.colors(v3, 6);
                }
                else {
                    v6 = v17;
                }

                if(v5 != 0) {
                    v18 = ((MutableInteractionSource)v4_1);
                }
                else {
                label_152:
                    v18 = v7;
                }

                v16_1 = v12_1;
                v17_1 = v15_1;
                v0_1 = 0x20;
                v5 = 0x1FE26C6F;
            }
            else {
                v3.skipToGroupEnd();
                if((v10 & 0x40) != 0) {
                    v6 = v17 & v21;
                    goto label_152;
                }
                else {
                    v18 = v7;
                    v16_1 = v12_1;
                    v6 = v17;
                    v0_1 = 0x20;
                    v5 = 0x1FE26C6F;
                    v17_1 = v15_1;
                }
            }

            Modifier v15_2 = v8;
            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v5, v6, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
            }

            ToggleableState v11_1 = ToggleableStateKt.ToggleableState(v1);
            if(v2 != null) {
                v3.startReplaceGroup(0x6E2F6436);
                ComposerKt.sourceInformation(v3, "166@7561L29");
                ComposerKt.sourceInformationMarkerStart(v3, 0xB0F9476C, "CC(remember):Checkbox.kt#9igjgp");
                v0_1 = (v6 & 0x70) == v0_1 ? 1 : 0;
                if((v6 & 14) == 4) {
                    v19 = 1;
                }

                v4_1 = v3.rememberedValue();
                if((v0_1 | v19) != 0 || v4_1 == Composer.Companion.getEmpty()) {
                    v4_2 = new CheckboxKt$$ExternalSyntheticLambda3(v2, v1);
                    v3.updateRememberedValue(v4_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v3);
                v3.endReplaceGroup();
            }
            else {
                v3.startReplaceGroup(0x6E3064CF);
                v3.endReplaceGroup();
            }

            v19_1 = v3;
            CheckboxKt.TriStateCheckbox(v11_1, v4_2, v13, v14, v15_2, v16_1, v17_1, v18, v19_1, v6 & 0x1FFFF80, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_1 = v15_2;
            v6_1 = v16_1;
            v7_1 = v17_1;
            v8_2 = v18;
        }
        else {
            v19_1 = v3;
            v19_1.skipToGroupEnd();
            v5_1 = v8;
            v6_1 = v12_1;
            v8_2 = v7;
            v7_1 = v15_1;
        }

        ScopeUpdateScope v11_2 = v19_1.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new CheckboxKt$$ExternalSyntheticLambda4(v1, v2, arg24, arg25, v5_1, v6_1, v7_1, v8_2, v9, v10));
        }
    }

    static final Unit Checkbox$lambda$2$lambda$1(Function1 arg0, boolean arg1) {
        arg0.invoke(Boolean.valueOf((((int)arg1)) ^ 1));
        return Unit.INSTANCE;
    }

    static final Unit Checkbox$lambda$3(boolean arg10, Function1 arg11, Modifier arg12, boolean arg13, CheckboxColors arg14, MutableInteractionSource arg15, int arg16, int arg17, Composer arg18, int arg19) {
        CheckboxKt.Checkbox(arg10, arg11, arg12, arg13, arg14, arg15, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }

    static final Unit Checkbox$lambda$5$lambda$4(Function1 arg0, boolean arg1) {
        arg0.invoke(Boolean.valueOf((((int)arg1)) ^ 1));
        return Unit.INSTANCE;
    }

    static final Unit Checkbox$lambda$6(boolean arg12, Function1 arg13, Stroke arg14, Stroke arg15, Modifier arg16, boolean arg17, CheckboxColors arg18, MutableInteractionSource arg19, int arg20, int arg21, Composer arg22, int arg23) {
        CheckboxKt.Checkbox(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    private static final void CheckboxImpl(boolean arg25, ToggleableState arg26, Modifier arg27, CheckboxColors arg28, Stroke arg29, Stroke arg30, Composer arg31, int arg32) {
        CheckboxKt$$ExternalSyntheticLambda0 v14_3;
        CheckDrawingCache v6_4;
        Composer v0_5;
        float v12_3;
        float v0_3;
        Object v21;
        Float v20_1;
        float v7_1;
        int v23;
        int v22;
        int v10;
        int v7;
        boolean v1 = arg25;
        ToggleableState v2 = arg26;
        Modifier v3 = arg27;
        CheckboxColors v4 = arg28;
        Stroke v12 = arg29;
        Stroke v8 = arg30;
        int v0 = arg32;
        int v5 = 0xCADF6160;
        Composer v6 = arg31.startRestartGroup(v5);
        ComposerKt.sourceInformation(v6, "C(CheckboxImpl)N(enabled,value,modifier,colors,checkmarkStroke,outlineStroke)402@18923L23,403@19015L14,405@19077L608,423@19752L594,439@20368L32,440@20429L21,441@20477L24,442@20531L27,443@20641L476,443@20563L554:Checkbox.kt#uh7d8r");
        int v9 = 2;
        if((v0 & 6) == 0) {
            v7 = v6.changed(v1) ? 4 : v9;
            v7 |= v0;
        }
        else {
            v7 = v0;
        }

        if((v0 & 0x30) == 0) {
            v10 = v6.changed(v2.ordinal()) ? 0x20 : 16;
            v7 |= v10;
        }

        if((v0 & 0x180) == 0) {
            v10 = v6.changed(v3) ? 0x100 : 0x80;
            v7 |= v10;
        }

        if((v0 & 0xC00) == 0) {
            v10 = v6.changed(v4) ? 0x800 : 0x400;
            v7 |= v10;
        }

        if((v0 & 0x6000) == 0) {
            v10 = v6.changedInstance(v12) ? 0x4000 : 0x2000;
            v7 |= v10;
        }

        if((0x30000 & v0) == 0) {
            v10 = v6.changedInstance(v8) ? 0x20000 : 0x10000;
            v7 |= v10;
        }

        boolean v10_1 = (74899 & v7) != 74898 ? true : false;
        if(v6.shouldExecute(v10_1, v7 & 1)) {
            int v11 = -1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v5, v7, v11, "androidx.compose.material3.CheckboxImpl (Checkbox.kt:401)");
            }

            v5 = v7 >> 3;
            v10 = v5 & 14;
            Transition v16 = TransitionKt.updateTransition(v2, null, v6, v10, v9);
            FiniteAnimationSpec v9_1 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v6, 6);
            CheckboxKt$CheckboxImpl$checkDrawFraction$1 v15 = new CheckboxKt$CheckboxImpl$checkDrawFraction$1(v9_1);
            String v11_1 = "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli";
            ComposerKt.sourceInformationMarkerStart(v6, 0xB03404EB, v11_1);
            TwoWayConverter v18 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            String v0_1 = "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli";
            ComposerKt.sourceInformationMarkerStart(v6, 0xF77F2E11, v0_1);
            Object v20 = v16.getCurrentState();
            v6.startReplaceGroup(-768316570);
            String v13 = "CN(it):Checkbox.kt#uh7d8r";
            ComposerKt.sourceInformation(v6, v13);
            String v14 = "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:415)";
            if(ComposerKt.isTraceInProgress()) {
                v22 = v7;
                v23 = v10;
                ComposerKt.traceEventStart(-768316570, 0, -1, v14);
            }
            else {
                v22 = v7;
                v23 = v10;
            }

            v7 = WhenMappings.$EnumSwitchMapping$0[((ToggleableState)v20).ordinal()];
            v10 = 3;
            float v24 = 1f;
            if(v7 == 1 || v7 == v10) {
                v7_1 = v24;
            }
            else if(v7 == 2) {
                v7_1 = 0f;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6.endReplaceGroup();
            Float v7_2 = Float.valueOf(v7_1);
            Object v12_1 = v16.getTargetState();
            v10 = -768316570;
            v6.startReplaceGroup(v10);
            ComposerKt.sourceInformation(v6, v13);
            if(ComposerKt.isTraceInProgress()) {
                v20_1 = v7_2;
                v21 = v12_1;
                ComposerKt.traceEventStart(v10, 0, -1, v14);
            }
            else {
                v20_1 = v7_2;
                v21 = v12_1;
            }

            v7 = WhenMappings.$EnumSwitchMapping$0[((ToggleableState)v21).ordinal()];
            if(v7 == 1 || v7 == 3) {
                v7_1 = v24;
            }
            else if(v7 == 2) {
                v7_1 = 0f;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6.endReplaceGroup();
            String v12_2 = v13;
            State v14_1 = TransitionKt.createTransitionAnimation(v16, v20_1, Float.valueOf(v7_1), ((Function3)v15).invoke(v16.getSegment(), v6, Integer.valueOf(0)), v18, "FloatAnimation", v6, 0);
            Transition v15_1 = v16;
            Composer v13_1 = v6;
            ComposerKt.sourceInformationMarkerEnd(v13_1);
            ComposerKt.sourceInformationMarkerEnd(v13_1);
            CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 v10_2 = new CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1(v9_1);
            ComposerKt.sourceInformationMarkerStart(v13_1, 0xB03404EB, v11_1);
            TwoWayConverter v17 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(v13_1, 0xF77F2E11, v0_1);
            Object v0_2 = v15_1.getCurrentState();
            int v6_1 = 1840054703;
            v13_1.startReplaceGroup(v6_1);
            ComposerKt.sourceInformation(v13_1, v12_2);
            String v9_2 = "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:433)";
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v6_1, 0, -1, v9_2);
            }

            v0 = WhenMappings.$EnumSwitchMapping$0[((ToggleableState)v0_2).ordinal()];
            if(v0 == 1 || v0 == 2) {
                v0_3 = 0f;
            }
            else if(v0 == 3) {
                v0_3 = v24;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v13_1.endReplaceGroup();
            Float v0_4 = Float.valueOf(v0_3);
            Object v11_2 = v15_1.getTargetState();
            v13_1.startReplaceGroup(v6_1);
            ComposerKt.sourceInformation(v13_1, v12_2);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v6_1, 0, -1, v9_2);
            }

            v6_1 = WhenMappings.$EnumSwitchMapping$0[((ToggleableState)v11_2).ordinal()];
            if(v6_1 == 1 || v6_1 == 2) {
                v12_3 = 0f;
            }
            else if(v6_1 == 3) {
                v12_3 = v24;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v13_1.endReplaceGroup();
            Float v6_2 = Float.valueOf(v12_3);
            Object v16_1 = ((Function3)v10_2).invoke(v15_1.getSegment(), v13_1, Integer.valueOf(0));
            State v10_3 = v14_1;
            State v11_3 = TransitionKt.createTransitionAnimation(v15_1, v0_4, v6_2, ((FiniteAnimationSpec)v16_1), v17, "FloatAnimation", v13_1, 0);
            v0_5 = v13_1;
            ComposerKt.sourceInformationMarkerEnd(v0_5);
            ComposerKt.sourceInformationMarkerEnd(v0_5);
            String v7_3 = "CC(remember):Checkbox.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v0_5, 0x908D59C0, v7_3);
            Object v6_3 = v0_5.rememberedValue();
            if(v6_3 == Composer.Companion.getEmpty()) {
                CheckDrawingCache v12_4 = new CheckDrawingCache(null, null, null, 7, null);
                v0_5.updateRememberedValue(v12_4);
                v6_4 = v12_4;
            }

            Object v13_2 = v6_4;
            ComposerKt.sourceInformationMarkerEnd(v0_5);
            State v9_3 = v4.checkmarkColor$material3(v2, v0_5, v23 | v22 >> 6 & 0x70);
            v5 = v5 & 0x380 | v22 & 0x7E;
            State v6_5 = v4.boxColor$material3(v1, v2, v0_5, v5);
            State v5_1 = v4.borderColor$material3(v1, v2, v0_5, v5);
            Modifier v1_1 = SizeKt.requiredSize-3ABfNKs(SizeKt.wrapContentSize$default(v3, Alignment.Companion.getCenter(), false, 2, null), CheckboxKt.CheckboxSize);
            ComposerKt.sourceInformationMarkerStart(v0_5, 0x908D7D9C, v7_3);
            v12 = arg29;
            v7 = v0_5.changed(v6_5) | v0_5.changed(v5_1) | v0_5.changedInstance(v8) | v0_5.changed(v9_3) | v0_5.changed(v10_3) | v0_5.changed(v11_3) | v0_5.changedInstance(v12);
            Object v14_2 = v0_5.rememberedValue();
            if(v7 != 0 || v14_2 == Composer.Companion.getEmpty()) {
                CheckboxKt$$ExternalSyntheticLambda0 v5_2 = new CheckboxKt$$ExternalSyntheticLambda0(v6_5, v5_1, v8, v9_3, v10_3, v11_3, v12, ((CheckDrawingCache)v13_2));
                v0_5.updateRememberedValue(v5_2);
                v14_3 = v5_2;
            }

            ComposerKt.sourceInformationMarkerEnd(v0_5);
            CanvasKt.Canvas(v1_1, ((Function1)v14_3), v0_5, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_341;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v0_5 = v6;
            v0_5.skipToGroupEnd();
        }

    label_341:
        ScopeUpdateScope v8_1 = v0_5.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new CheckboxKt$$ExternalSyntheticLambda1(arg25, v2, v3, v4, arg29, arg30, arg32));
        }
    }

    static final Unit CheckboxImpl$lambda$14$lambda$13(State arg7, State arg8, Stroke arg9, State arg10, State arg11, State arg12, Stroke arg13, CheckDrawingCache arg14, DrawScope arg15) {
        CheckboxKt.drawBox-1wkBAMs(arg15, arg7.getValue().unbox-impl(), arg8.getValue().unbox-impl(), arg15.toPx-0680j_4(CheckboxKt.RadiusSize), arg9);
        CheckboxKt.drawCheck-3IgeMak(arg15, arg10.getValue().unbox-impl(), arg11.getValue().floatValue(), arg12.getValue().floatValue(), arg13, arg14);
        return Unit.INSTANCE;
    }

    static final Unit CheckboxImpl$lambda$15(boolean arg8, ToggleableState arg9, Modifier arg10, CheckboxColors arg11, Stroke arg12, Stroke arg13, int arg14, Composer arg15, int arg16) {
        CheckboxKt.CheckboxImpl(arg8, arg9, arg10, arg11, arg12, arg13, arg15, RecomposeScopeImplKt.updateChangedFlags(arg14 | 1));
        return Unit.INSTANCE;
    }

    public static final void TriStateCheckbox(ToggleableState arg22, Function0 arg23, Stroke arg24, Stroke arg25, Modifier arg26, boolean arg27, CheckboxColors arg28, MutableInteractionSource arg29, Composer arg30, int arg31, int arg32) {
        CheckboxColors v7_1;
        MutableInteractionSource v8_1;
        Modifier v5_2;
        Composer v0_3;
        boolean v6_1;
        Companion v2_3;
        MutableInteractionSource v16;
        Modifier v12_2;
        MutableInteractionSource v2_1;
        CheckboxColors v13_1;
        Companion v12_3;
        boolean v1_1;
        Modifier v0_2;
        Companion v0_1;
        int v15;
        MutableInteractionSource v14_1;
        int v13;
        CheckboxColors v12_1;
        boolean v5_1;
        int v4;
        Modifier v3;
        Stroke v11;
        Stroke v8;
        int v2;
        int v1;
        Function0 v6 = arg23;
        int v9 = arg31;
        int v10 = arg32;
        Composer v7 = arg30.startRestartGroup(-406243761);
        ComposerKt.sourceInformation(v7, "C(TriStateCheckbox)N(state,onClick,checkmarkStroke,outlineStroke,modifier,enabled,colors,interactionSource)289@13489L543:Checkbox.kt#uh7d8r");
        if((v10 & 1) != 0) {
            v1 = v9 | 6;
        }
        else if((v9 & 6) == 0) {
            v1 = v7.changed(arg22.ordinal()) ? 4 : 2;
            v1 |= v9;
        }
        else {
            v1 = v9;
        }

        if((v10 & 2) != 0) {
            v1 |= 0x30;
        }
        else if((v9 & 0x30) == 0) {
            v2 = v7.changedInstance(v6) ? 0x20 : 16;
            v1 |= v2;
        }

        if((v10 & 4) != 0) {
            v1 |= 0x180;
            v8 = arg24;
        }
        else {
            v8 = arg24;
            if((v9 & 0x180) == 0) {
                v2 = v7.changedInstance(v8) ? 0x100 : 0x80;
                v1 |= v2;
            }
        }

        if((v10 & 8) != 0) {
            v1 |= 0xC00;
            v11 = arg25;
        }
        else {
            v11 = arg25;
            if((v9 & 0xC00) == 0) {
                v2 = v7.changedInstance(v11) ? 0x800 : 0x400;
                v1 |= v2;
            }
        }

        v2 = v10 & 16;
        if(v2 != 0) {
            v1 |= 0x6000;
            goto label_78;
        }
        else if((v9 & 0x6000) == 0) {
            v3 = arg26;
            v4 = v7.changed(v3) ? 0x4000 : 0x2000;
            v1 |= v4;
        }
        else {
        label_78:
            v3 = arg26;
        }

        v4 = v10 & 0x20;
        int v5 = 0x30000;
        if(v4 != 0) {
            v1 |= v5;
            goto label_94;
        }
        else if((v5 & v9) == 0) {
            v5_1 = arg27;
            int v12 = v7.changed(v5_1) ? 0x20000 : 0x10000;
            v1 |= v12;
        }
        else {
        label_94:
            v5_1 = arg27;
        }

        if((0x180000 & v9) == 0) {
            if((v10 & 0x40) == 0) {
                v12_1 = arg28;
                if(v7.changed(v12_1)) {
                    v13 = 0x100000;
                }
                else {
                    goto label_106;
                }
            }
            else {
                v12_1 = arg28;
            label_106:
                v13 = 0x80000;
            }

            v1 |= v13;
        }
        else {
            v12_1 = arg28;
        }

        v13 = v10 & 0x80;
        int v14 = 0xC00000;
        if(v13 != 0) {
            v1 |= v14;
            goto label_125;
        }
        else if((v14 & v9) == 0) {
            v14_1 = arg29;
            v15 = v7.changed(v14_1) ? 0x800000 : 0x400000;
            v1 |= v15;
        }
        else {
        label_125:
            v14_1 = arg29;
        }

        boolean v0 = (0x492493 & v1) != 4793490 ? true : false;
        if(v7.shouldExecute(v0, v1 & 1)) {
            v7.startDefaults();
            ComposerKt.sourceInformation(v7, "273@12959L8");
            int v30 = 0xFFC7FFFF;
            v15 = 6;
            if((v9 & 1) == 0 || (v7.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v0_1 = Modifier.Companion;
                }
                else {
                    v0_2 = v3;
                }

                if(v4 != 0) {
                    v5_1 = true;
                }

                if((v10 & 0x40) != 0) {
                    v1 &= v30;
                    v12_1 = CheckboxDefaults.INSTANCE.colors(v7, v15);
                }

                if(v13 != 0) {
                    v2_1 = null;
                    v14 = v1;
                    v1_1 = v5_1;
                    v13_1 = v12_1;
                    v12_3 = v0_1;
                    goto label_181;
                }

                v13_1 = v12_1;
                v2_1 = v14_1;
                v12_3 = v0_1;
                v14 = v1;
            label_155:
                v1_1 = v5_1;
            }
            else {
                v7.skipToGroupEnd();
                if((v10 & 0x40) != 0) {
                    v1 &= v30;
                }

                v13_1 = v12_1;
                v2_1 = v14_1;
                v14 = v1;
                v12_2 = v3;
                goto label_155;
            }

        label_181:
            v7.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-406243761, v14, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:275)");
            }

            if(v6 != null) {
                v0_2 = ToggleableKt.triStateToggleable-O2vRcR0(Modifier.Companion, arg22, v2_1, RippleKt.ripple-H2RKhps$default(false, Dp.constructor-impl(CheckboxTokens.INSTANCE.getStateLayerSize-D9Ej5fM() / 2f), 0, 4, null), v1_1, Role.box-impl(Role.Companion.getCheckbox-o7Vup1c()), v6);
                v16 = v2_1;
                v1_1 = v1_1;
            }
            else {
                v16 = v2_1;
                v0_1 = Modifier.Companion;
            }

            if(arg23 != null) {
                Modifier v2_2 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion);
            }
            else {
                v2_3 = Modifier.Companion;
            }

            v3 = PaddingKt.padding-3ABfNKs(v12_2.then(((Modifier)v2_3)).then(((Modifier)v0_1)), CheckboxKt.CheckboxDefaultPadding);
            v2 = v14 << 6;
            CheckboxColors v4_1 = v13_1;
            CheckboxKt.CheckboxImpl(v1_1, arg22, v3, v4_1, v8, v11, v7, v14 >> 15 & 14 | v14 << 3 & 0x70 | v14 >> 9 & 0x1C00 | 0xE000 & v2 | v2 & 0x70000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_1 = v1_1;
            v0_3 = v7;
            v5_2 = v12_2;
            v8_1 = v16;
            v7_1 = v4_1;
        }
        else {
            v7.skipToGroupEnd();
            v6_1 = v5_1;
            v0_3 = v7;
            v7_1 = v12_1;
            v8_1 = v14_1;
            v5_2 = v3;
        }

        ScopeUpdateScope v11_1 = v0_3.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new CheckboxKt$$ExternalSyntheticLambda2(arg22, arg23, arg24, arg25, v5_2, v6_1, v7_1, v8_1, v9, v10));
        }
    }

    public static final void TriStateCheckbox(ToggleableState arg24, Function0 arg25, Modifier arg26, boolean arg27, CheckboxColors arg28, MutableInteractionSource arg29, Composer arg30, int arg31, int arg32) {
        MutableInteractionSource v6_1;
        CheckboxColors v5_1;
        boolean v4_1;
        Composer v16;
        CheckboxColors v14_1;
        boolean v13_1;
        MutableInteractionSource v15_1;
        Companion v12_3;
        Modifier v3_2;
        MutableInteractionSource v11_1;
        int v10;
        CheckboxColors v8_1;
        boolean v6;
        int v5;
        Modifier v4;
        int v3;
        Function0 v9;
        int v2;
        int v7 = arg31;
        int v0 = -1608358065;
        Composer v1 = arg30.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(TriStateCheckbox)N(state,onClick,modifier,enabled,colors,interactionSource)215@9923L7,216@9983L337:Checkbox.kt#uh7d8r");
        if((arg32 & 1) != 0) {
            v2 = v7 | 6;
        }
        else if((v7 & 6) == 0) {
            v2 = v1.changed(arg24.ordinal()) ? 4 : 2;
            v2 |= v7;
        }
        else {
            v2 = v7;
        }

        if((arg32 & 2) != 0) {
            v2 |= 0x30;
            v9 = arg25;
        }
        else {
            v9 = arg25;
            if((v7 & 0x30) == 0) {
                v3 = v1.changedInstance(v9) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = arg32 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_50;
        }
        else if((v7 & 0x180) == 0) {
            v4 = arg26;
            v5 = v1.changed(v4) ? 0x100 : 0x80;
            v2 |= v5;
        }
        else {
        label_50:
            v4 = arg26;
        }

        v5 = arg32 & 8;
        if(v5 != 0) {
            v2 |= 0xC00;
            goto label_65;
        }
        else if((v7 & 0xC00) == 0) {
            v6 = arg27;
            int v8 = v1.changed(v6) ? 0x800 : 0x400;
            v2 |= v8;
        }
        else {
        label_65:
            v6 = arg27;
        }

        if((v7 & 0x6000) == 0) {
            if((arg32 & 16) == 0) {
                v8_1 = arg28;
                if(v1.changed(v8_1)) {
                    v10 = 0x4000;
                }
                else {
                    goto label_76;
                }
            }
            else {
                v8_1 = arg28;
            label_76:
                v10 = 0x2000;
            }

            v2 |= v10;
        }
        else {
            v8_1 = arg28;
        }

        v10 = arg32 & 0x20;
        int v11 = 0x30000;
        if(v10 != 0) {
            v2 |= v11;
            goto label_95;
        }
        else if((v11 & v7) == 0) {
            v11_1 = arg29;
            int v12 = v1.changed(v11_1) ? 0x20000 : 0x10000;
            v2 |= v12;
        }
        else {
        label_95:
            v11_1 = arg29;
        }

        boolean v14 = true;
        boolean v12_1 = (74899 & v2) != 74898 ? true : false;
        if(v1.shouldExecute(v12_1, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "212@9810L8");
            int v13 = 0xFFFF1FFF;
            int v15 = 6;
            if((v7 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v3_1 = Modifier.Companion;
                }
                else {
                    v3_2 = v4;
                }

                if(v5 != 0) {
                }
                else {
                    v14 = v6;
                }

                if((arg32 & 16) != 0) {
                    v2 &= v13;
                    v8_1 = CheckboxDefaults.INSTANCE.colors(v1, v15);
                }

                if(v10 != 0) {
                    v12_3 = ((Companion)v3_2);
                    v13_1 = v14;
                    v3 = v15;
                    v15_1 = null;
                    v14_1 = v8_1;
                    goto label_153;
                }

                v12_3 = ((Companion)v3_2);
                v13_1 = v14;
                v3 = v15;
                v14_1 = v8_1;
            label_125:
                v15_1 = v11_1;
            }
            else {
                v1.skipToGroupEnd();
                if((arg32 & 16) != 0) {
                    v2 &= v13;
                }

                Modifier v12_2 = v4;
                v13_1 = v6;
                v14_1 = v8_1;
                v3 = v15;
                goto label_125;
            }

        label_153:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
            }

            ProvidableCompositionLocal v0_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = v1.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(v1);
            float v0_3 = ((float)Math.floor(((double)((Density)v0_2).toPx-0680j_4(CheckboxDefaults.INSTANCE.getStrokeWidth-D9Ej5fM()))));
            Stroke v10_1 = new Stroke(v0_3, 0f, StrokeCap.Companion.getSquare-KaPHkGw(), 0, null, 26, null);
            Stroke v11_2 = new Stroke(v0_3, 0f, 0, 0, null, 30, null);
            v0 = v2 & 0x7E;
            v2 <<= v3;
            v16 = v1;
            CheckboxKt.TriStateCheckbox(arg24, v9, v10_1, v11_2, ((Modifier)v12_3), v13_1, v14_1, v15_1, v16, v0 | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | v2 & 0x1C00000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_2 = ((Modifier)v12_3);
            v4_1 = v13_1;
            v5_1 = v14_1;
            v6_1 = v15_1;
        }
        else {
            v16 = v1;
            v16.skipToGroupEnd();
            v3_2 = v4;
            v4_1 = v6;
            v5_1 = v8_1;
            v6_1 = v11_1;
        }

        ScopeUpdateScope v9_1 = v16.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new CheckboxKt$$ExternalSyntheticLambda5(arg24, arg25, v3_2, v4_1, v5_1, v6_1, v7, arg32));
        }
    }

    static final Unit TriStateCheckbox$lambda$8(ToggleableState arg10, Function0 arg11, Modifier arg12, boolean arg13, CheckboxColors arg14, MutableInteractionSource arg15, int arg16, int arg17, Composer arg18, int arg19) {
        CheckboxKt.TriStateCheckbox(arg10, arg11, arg12, arg13, arg14, arg15, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }

    static final Unit TriStateCheckbox$lambda$9(ToggleableState arg12, Function0 arg13, Stroke arg14, Stroke arg15, Modifier arg16, boolean arg17, CheckboxColors arg18, MutableInteractionSource arg19, int arg20, int arg21, Composer arg22, int arg23) {
        CheckboxKt.TriStateCheckbox(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    private static final void drawBox-1wkBAMs(DrawScope arg37, long arg38, long arg40, float arg42, Stroke arg43) {
        float v1 = 2f;
        float v0 = arg43.getWidth() / v1;
        int v4 = 0x20;
        float v2 = Float.intBitsToFloat(((int)(arg37.getSize-NH-jbRc() >> v4)));
        long v5 = 0xFFFFFFFFL;
        if(Color.equals-impl0(arg38, arg40)) {
            DrawScope.drawRoundRect-u-Aw5IA$default(arg37, arg38, 0, Size.constructor-impl((((long)Float.floatToRawIntBits(v2))) << v4 | (((long)Float.floatToRawIntBits(v2))) & v5), CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(arg42))) << v4 | (((long)Float.floatToRawIntBits(arg42))) & v5), Fill.INSTANCE, 0f, null, 0, 0xE2, null);
            return;
        }

        long v25 = Offset.constructor-impl((((long)Float.floatToRawIntBits(arg43.getWidth()))) << v4 | (((long)Float.floatToRawIntBits(arg43.getWidth()))) & v5);
        long v27 = Size.constructor-impl((((long)Float.floatToRawIntBits(v2 - arg43.getWidth() * v1))) << v4 | (((long)Float.floatToRawIntBits(v2 - arg43.getWidth() * v1))) & v5);
        v1 = Math.max(0f, arg42 - arg43.getWidth());
        DrawScope.drawRoundRect-u-Aw5IA$default(arg37, arg38, v25, v27, CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(v1))) << v4 | (((long)Float.floatToRawIntBits(v1))) & v5), Fill.INSTANCE, 0f, null, 0, 0xE0, null);
        v25 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v0))) << v4 | (((long)Float.floatToRawIntBits(v0))) & v5);
        v0 = arg42 - v0;
        DrawScope.drawRoundRect-u-Aw5IA$default(arg37, arg40, v25, Size.constructor-impl((((long)Float.floatToRawIntBits(v2 - arg43.getWidth()))) & v5 | (((long)Float.floatToRawIntBits(v2 - arg43.getWidth()))) << v4), CornerRadius.constructor-impl((((long)Float.floatToRawIntBits(v0))) << v4 | (((long)Float.floatToRawIntBits(v0))) & v5), arg43, 0f, null, 0, 0xE0, null);
    }

    private static final void drawCheck-3IgeMak(DrawScope arg15, long arg16, float arg18, float arg19, Stroke arg20, CheckDrawingCache arg21) {
        float v1 = Float.intBitsToFloat(((int)(arg15.getSize-NH-jbRc() >> 0x20)));
        float v2 = MathHelpersKt.lerp(0.4f, 0.5f, arg19);
        float v4 = MathHelpersKt.lerp(0.7f, 0.5f, arg19);
        float v5 = MathHelpersKt.lerp(0.5f, 0.5f, arg19);
        float v0 = MathHelpersKt.lerp(0.3f, 0.5f, arg19);
        arg21.getCheckPath().rewind();
        arg21.getCheckPath().moveTo(0.2f * v1, v5 * v1);
        arg21.getCheckPath().lineTo(v2 * v1, v4 * v1);
        arg21.getCheckPath().lineTo(0.8f * v1, v1 * v0);
        arg21.getPathMeasure().setPath(arg21.getCheckPath(), false);
        arg21.getPathToDraw().rewind();
        arg21.getPathMeasure().getSegment(0f, arg21.getPathMeasure().getLength() * arg18, arg21.getPathToDraw(), true);
        DrawScope.drawPath-LG529CI$default(arg15, arg21.getPathToDraw(), arg16, 0f, arg20, null, 0, 52, null);
    }
}

