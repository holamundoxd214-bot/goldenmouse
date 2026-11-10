package androidx.compose.material3;

import androidx.compose.animation.core.SnapSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u001Al\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0014\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0015\b\u0002\u0010\b\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0007¢\u0006\u0002\u0010\u0010\u001AR\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0013\u0010\b\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\n2\u0006\u0010\u000E\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0003¢\u0006\u0002\u0010\u0015\"\u0016\u0010\u0016\u001A\u00020\u0017X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u0018\u0010\u0019\"\u0016\u0010\u001B\u001A\u00020\u0017X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u001C\u0010\u0019\"\u0010\u0010\u001D\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001A\"\u0010\u0010\u001E\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001A\"\u0010\u0010\u001F\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001A\"\u0014\u0010 \u001A\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Landroidx/compose/material3/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/SwitchColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "ThumbDiameter", "Landroidx/compose/ui/unit/Dp;", "getThumbDiameter", "()F", "F", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "SwitchWidth", "SwitchHeight", "ThumbPadding", "SnapSpec", "Landroidx/compose/animation/core/SnapSpec;", "", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SwitchKt {
    private static final SnapSpec SnapSpec;
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDiameter;
    private static final float ThumbPadding;
    private static final float UncheckedThumbDiameter;

    static {
        float v0 = SwitchTokens.INSTANCE.getSelectedHandleWidth-D9Ej5fM();
        SwitchKt.ThumbDiameter = v0;
        SwitchKt.UncheckedThumbDiameter = SwitchTokens.INSTANCE.getUnselectedHandleWidth-D9Ej5fM();
        SwitchKt.SwitchWidth = SwitchTokens.INSTANCE.getTrackWidth-D9Ej5fM();
        float v1 = SwitchTokens.INSTANCE.getTrackHeight-D9Ej5fM();
        SwitchKt.SwitchHeight = v1;
        SwitchKt.ThumbPadding = Dp.constructor-impl(Dp.constructor-impl(v1 - v0) / 2f);
        SwitchKt.SnapSpec = new SnapSpec(0, 1, null);
    }

    public static final void Switch(boolean arg21, Function1 arg22, Modifier arg23, Function2 arg24, boolean arg25, SwitchColors arg26, MutableInteractionSource arg27, Composer arg28, int arg29, int arg30) {
        MutableInteractionSource v7_1;
        Function2 v4_2;
        SwitchColors v6_1;
        boolean v5_1;
        Modifier v3_1;
        Composer v16_1;
        boolean v4_1;
        Object v2_1;
        Modifier v10_1;
        Function2 v13_2;
        MutableInteractionSource v18;
        SwitchColors v12_1;
        boolean v11_1;
        Modifier v0_2;
        Companion v0_1;
        MutableInteractionSource v15_1;
        int v14;
        SwitchColors v13_1;
        boolean v12;
        int v11;
        Function2 v10;
        int v5;
        Modifier v4;
        int v3;
        boolean v1;
        int v2;
        Function1 v6 = arg22;
        int v8 = arg29;
        Composer v7 = arg28.startRestartGroup(0xF04DC361);
        ComposerKt.sourceInformation(v7, "C(Switch)N(checked,onCheckedChange,modifier,thumbContent,enabled,colors,interactionSource)128@5642L5,118@5267L424:Switch.kt#uh7d8r");
        if((arg30 & 1) != 0) {
            v2 = v8 | 6;
            v1 = arg21;
        }
        else if((v8 & 6) == 0) {
            v1 = arg21;
            v2 = v7.changed(v1) ? 4 : 2;
            v2 |= v8;
        }
        else {
            v1 = arg21;
            v2 = v8;
        }

        if((arg30 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v8 & 0x30) == 0) {
            v3 = v7.changedInstance(v6) ? 0x20 : 16;
            v2 |= v3;
        }

        v3 = arg30 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_51;
        }
        else if((v8 & 0x180) == 0) {
            v4 = arg23;
            v5 = v7.changed(v4) ? 0x100 : 0x80;
            v2 |= v5;
        }
        else {
        label_51:
            v4 = arg23;
        }

        v5 = arg30 & 8;
        if(v5 != 0) {
            v2 |= 0xC00;
            goto label_66;
        }
        else if((v8 & 0xC00) == 0) {
            v10 = arg24;
            v11 = v7.changedInstance(v10) ? 0x800 : 0x400;
            v2 |= v11;
        }
        else {
        label_66:
            v10 = arg24;
        }

        v11 = arg30 & 16;
        if(v11 != 0) {
            v2 |= 0x6000;
            goto label_81;
        }
        else if((v8 & 0x6000) == 0) {
            v12 = arg25;
            int v13 = v7.changed(v12) ? 0x4000 : 0x2000;
            v2 |= v13;
        }
        else {
        label_81:
            v12 = arg25;
        }

        if((0x30000 & v8) == 0) {
            if((arg30 & 0x20) == 0) {
                v13_1 = arg26;
                if(v7.changed(v13_1)) {
                    v14 = 0x20000;
                }
                else {
                    goto label_93;
                }
            }
            else {
                v13_1 = arg26;
            label_93:
                v14 = 0x10000;
            }

            v2 |= v14;
        }
        else {
            v13_1 = arg26;
        }

        v14 = arg30 & 0x40;
        int v15 = 0x180000;
        if(v14 != 0) {
            v2 |= v15;
            goto label_112;
        }
        else if((v15 & v8) == 0) {
            v15_1 = arg27;
            int v16 = v7.changed(v15_1) ? 0x100000 : 0x80000;
            v2 |= v16;
        }
        else {
        label_112:
            v15_1 = arg27;
        }

        int v17 = v3;
        boolean v0 = (v2 & 0x92493) != 0x92492 ? true : false;
        if(v7.shouldExecute(v0, v2 & 1)) {
            v7.startDefaults();
            ComposerKt.sourceInformation(v7, "96@4536L8");
            int v19 = 0xFFF8FFFF;
            int v9 = 6;
            if((v8 & 1) == 0 || (v7.getDefaultsInvalid())) {
                if(v17 != 0) {
                    v0_1 = Modifier.Companion;
                }
                else {
                    v0_2 = v4;
                }

                if(v5 != 0) {
                    v10 = null;
                }

                if(v11 != 0) {
                    v12 = true;
                }

                if((arg30 & 0x20) != 0) {
                    v2 &= v19;
                    v13_1 = SwitchDefaults.INSTANCE.colors(v7, v9);
                }

                if(v14 != 0) {
                    v14 = v2;
                    v11_1 = v12;
                    v12_1 = v13_1;
                    v18 = null;
                }
                else {
                    v14 = v2;
                    v11_1 = v12;
                    v12_1 = v13_1;
                    v18 = v15_1;
                }

                v13_2 = v10;
                Companion v10_2 = v0_1;
            }
            else {
                v7.skipToGroupEnd();
                if((arg30 & 0x20) != 0) {
                    v2 &= v19;
                }

                v14 = v2;
                v11_1 = v12;
                v12_1 = v13_1;
                v18 = v15_1;
                v13_2 = v10;
                v10_1 = v4;
            }

            v7.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xF04DC361, v14, -1, "androidx.compose.material3.Switch (Switch.kt:98)");
            }

            if(v18 == null) {
                v7.startReplaceGroup(1768604058);
                ComposerKt.sourceInformation(v7, "100@4688L39");
                ComposerKt.sourceInformationMarkerStart(v7, 334146408, "CC(remember):Switch.kt#9igjgp");
                Object v0_3 = v7.rememberedValue();
                if(v0_3 == Composer.Companion.getEmpty()) {
                    MutableInteractionSource v0_4 = InteractionSourceKt.MutableInteractionSource();
                    v7.updateRememberedValue(v0_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v7);
                v7.endReplaceGroup();
                v2_1 = v0_3;
            }
            else {
                v7.startReplaceGroup(0x13EAA8DD);
                v7.endReplaceGroup();
                MutableInteractionSource v2_2 = v18;
            }

            if(v6 != null) {
                v4_1 = v11_1;
                v11_1 = false;
                v0_2 = ToggleableKt.toggleable-O2vRcR0(InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.Companion), v1, ((MutableInteractionSource)v2_1), null, v4_1, Role.box-impl(Role.Companion.getSwitch-o7Vup1c()), v6);
            }
            else {
                v4_1 = v11_1;
                v11_1 = false;
                v0_1 = Modifier.Companion;
            }

            v0_2 = SizeKt.requiredSize-VpY3zN4(SizeKt.wrapContentSize$default(v10_1.then(((Modifier)v0_1)), Alignment.Companion.getCenter(), v11_1, 2, null), SwitchKt.SwitchWidth, SwitchKt.SwitchHeight);
            Shape v15_2 = ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), v7, v9);
            int v1_1 = v14 << 3;
            v5 = v14 >> 6;
            Modifier v9_1 = v0_2;
            v16_1 = v7;
            v0_2 = v10_1;
            SwitchKt.SwitchImpl(v9_1, arg21, v4_1, v12_1, v13_2, v2_1, v15_2, v16_1, v1_1 & 0x70 | v5 & 0x380 | v5 & 0x1C00 | v1_1 & 0xE000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = v0_2;
            v5_1 = v4_1;
            v6_1 = v12_1;
            v4_2 = v13_2;
            v7_1 = v18;
        }
        else {
            v16_1 = v7;
            v16_1.skipToGroupEnd();
            v3_1 = v4;
            v4_2 = v10;
            v5_1 = v12;
            v6_1 = v13_1;
            v7_1 = v15_1;
        }

        ScopeUpdateScope v10_3 = v16_1.endRestartGroup();
        if(v10_3 != null) {
            v10_3.updateScope(new SwitchKt$$ExternalSyntheticLambda0(arg21, arg22, v3_1, v4_2, v5_1, v6_1, v7_1, v8, arg30));
        }
    }

    static final Unit Switch$lambda$1(boolean arg11, Function1 arg12, Modifier arg13, Function2 arg14, boolean arg15, SwitchColors arg16, MutableInteractionSource arg17, int arg18, int arg19, Composer arg20, int arg21) {
        SwitchKt.Switch(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    private static final void SwitchImpl(Modifier arg25, boolean arg26, boolean arg27, SwitchColors arg28, Function2 arg29, InteractionSource arg30, Shape arg31, Composer arg32, int arg33) {
        Shape v11_6;
        int v11;
        int v10;
        Modifier v1 = arg25;
        boolean v2 = arg26;
        boolean v3 = arg27;
        SwitchColors v4 = arg28;
        Function2 v5 = arg29;
        InteractionSource v6 = arg30;
        Shape v7 = arg31;
        int v8 = arg33;
        int v0 = 0xD8029DA3;
        Composer v9 = arg32.startRestartGroup(v0);
        ComposerKt.sourceInformation(v9, "C(SwitchImpl)N(modifier,checked,enabled,colors,thumbContent,interactionSource,thumbShape)146@6188L5,148@6199L1341:Switch.kt#uh7d8r");
        if((v8 & 6) == 0) {
            v10 = v9.changed(v1) ? 4 : 2;
            v10 |= v8;
        }
        else {
            v10 = v8;
        }

        if((v8 & 0x30) == 0) {
            v11 = v9.changed(v2) ? 0x20 : 16;
            v10 |= v11;
        }

        if((v8 & 0x180) == 0) {
            v11 = v9.changed(v3) ? 0x100 : 0x80;
            v10 |= v11;
        }

        if((v8 & 0xC00) == 0) {
            v11 = v9.changed(v4) ? 0x800 : 0x400;
            v10 |= v11;
        }

        if((v8 & 0x6000) == 0) {
            v11 = v9.changedInstance(v5) ? 0x4000 : 0x2000;
            v10 |= v11;
        }

        if((0x30000 & v8) == 0) {
            v11 = v9.changed(v6) ? 0x20000 : 0x10000;
            v10 |= v11;
        }

        if((0x180000 & v8) == 0) {
            v11 = v9.changed(v7) ? 0x100000 : 0x80000;
            v10 |= v11;
        }

        boolean v11_1 = (0x92493 & v10) != 0x92492 ? true : false;
        if(v9.shouldExecute(v11_1, v10 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v10, -1, "androidx.compose.material3.SwitchImpl (Switch.kt:143)");
            }

            long v11_2 = v4.trackColor-WaAFU9c$material3(v3, v2);
            long v14 = v4.thumbColor-WaAFU9c$material3(v3, v2);
            Shape v0_1 = ShapesKt.getValue(SwitchTokens.INSTANCE.getTrackShape(), v9, 6);
            Modifier v0_2 = BackgroundKt.background-bw27NRU(BorderKt.border-xT4_qwU(v1, SwitchTokens.INSTANCE.getTrackOutlineWidth-D9Ej5fM(), v4.borderColor-WaAFU9c$material3(v3, v2), v0_1), v11_2, v0_1);
            String v8_1 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v9, 0x2BB5B5D7, v8_1);
            MeasurePolicy v11_3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            String v7_1 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v9, -1323940314, v7_1);
            int v17 = ComposablesKt.getCurrentCompositeKeyHash(v9, 0);
            CompositionLocalMap v12 = v9.getCurrentCompositionLocalMap();
            v0_2 = ComposedModifierKt.materializeModifier(v9, v0_2);
            Function0 v13 = ComposeUiNode.Companion.getConstructor();
            int v18 = v10;
            String v10_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v9, 0xD6BD0031, v10_1);
            if(!(v9.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v9.startReusableNode();
            if(v9.getInserting()) {
                v9.createNode(v13);
            }
            else {
                v9.useNode();
            }

            Composer v1_1 = Updater.constructor-impl(v9);
            Updater.set-impl(v1_1, v11_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v1_1, v12, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v11_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v1_1.getInserting()) || !Intrinsics.areEqual(v1_1.rememberedValue(), Integer.valueOf(v17))) {
                v1_1.updateRememberedValue(Integer.valueOf(v17));
                v1_1.apply(Integer.valueOf(v17), v11_4);
            }

            Updater.set-impl(v1_1, v0_2, ComposeUiNode.Companion.getSetModifier());
            String v1_2 = "C72@3468L9:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v9, 0x800B7D29, v1_2);
            BoxScopeInstance v11_5 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(v9, 0xB8C04F72, "C161@6809L7,153@6374L1160:Switch.kt#uh7d8r");
            v0_2 = ((BoxScope)v11_5).align(Modifier.Companion, Alignment.Companion.getCenterStart()).then(new ThumbElement(v6, v2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, v9, 6)));
            v11_6 = arg31;
            v0_2 = BackgroundKt.background-bw27NRU(IndicationKt.indication(v0_2, v6, RippleKt.ripple-H2RKhps$default(false, Dp.constructor-impl(SwitchTokens.INSTANCE.getStateLayerSize-D9Ej5fM() / 2f), 0, 4, null)), v14, v11_6);
            Alignment v12_1 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(v9, 0x2BB5B5D7, v8_1);
            MeasurePolicy v12_2 = BoxKt.maybeCachedBoxMeasurePolicy(v12_1, false);
            ComposerKt.sourceInformationMarkerStart(v9, -1323940314, v7_1);
            int v7_2 = ComposablesKt.getCurrentCompositeKeyHash(v9, 0);
            CompositionLocalMap v8_2 = v9.getCurrentCompositionLocalMap();
            v0_2 = ComposedModifierKt.materializeModifier(v9, v0_2);
            v13 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v9, 0xD6BD0031, v10_1);
            if(!(v9.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v9.startReusableNode();
            if(v9.getInserting()) {
                v9.createNode(v13);
            }
            else {
                v9.useNode();
            }

            Composer v10_2 = Updater.constructor-impl(v9);
            Updater.set-impl(v10_2, v12_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v10_2, v8_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v8_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v10_2.getInserting()) || !Intrinsics.areEqual(v10_2.rememberedValue(), Integer.valueOf(v7_2))) {
                v10_2.updateRememberedValue(Integer.valueOf(v7_2));
                v10_2.apply(Integer.valueOf(v7_2), v8_3);
            }

            Updater.set-impl(v10_2, v0_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v9, 0x800B7D29, v1_2);
            ComposerKt.sourceInformationMarkerStart(v9, 0x49A8FE66, "C:Switch.kt#uh7d8r");
            if(v5 != null) {
                v9.startReplaceGroup(0x49A95FFF);
                ComposerKt.sourceInformation(v9, "174@7365L145");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(v4.iconColor-WaAFU9c$material3(v3, v2))), v5, v9, ProvidedValue.$stable | v18 >> 9 & 0x70);
                v9.endReplaceGroup();
            }
            else {
                v9.startReplaceGroup(0x49ACF3F3);
                v9.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            v9.endNode();
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            v9.endNode();
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            ComposerKt.sourceInformationMarkerEnd(v9);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_270;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v11_6 = v7;
            v9.skipToGroupEnd();
        }

    label_270:
        ScopeUpdateScope v9_1 = v9.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new SwitchKt$$ExternalSyntheticLambda1(arg25, v2, v3, v4, v5, v6, v11_6, arg33));
        }
    }

    static final Unit SwitchImpl$lambda$4(Modifier arg10, boolean arg11, boolean arg12, SwitchColors arg13, Function2 arg14, InteractionSource arg15, Shape arg16, int arg17, Composer arg18, int arg19) {
        SwitchKt.SwitchImpl(arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg18, RecomposeScopeImplKt.updateChangedFlags(arg17 | 1));
        return Unit.INSTANCE;
    }

    public static final SnapSpec access$getSnapSpec$p() {
        return SwitchKt.SnapSpec;
    }

    public static final float access$getSwitchHeight$p() {
        return SwitchKt.SwitchHeight;
    }

    public static final float access$getSwitchWidth$p() {
        return SwitchKt.SwitchWidth;
    }

    public static final float access$getThumbPadding$p() {
        return SwitchKt.ThumbPadding;
    }

    public static final float getThumbDiameter() {
        return SwitchKt.ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return SwitchKt.UncheckedThumbDiameter;
    }
}

