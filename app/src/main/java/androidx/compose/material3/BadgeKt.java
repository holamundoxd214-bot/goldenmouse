package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.BadgeTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.HorizontalRuler;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AS\u0010\u0000\u001A\u00020\u00012\u001C\u0010\u0002\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\u001C\u0010\t\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\n\u001AO\u0010\u000B\u001A\u00020\u00012\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2 \b\u0002\u0010\t\u001A\u001A\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001A\f\u0010%\u001A\u00020\b*\u00020\bH\u0000\"\u0016\u0010\u0012\u001A\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0017\u001A\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0018\u0010\u0015\"\u0016\u0010\u0019\u001A\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u001A\u0010\u0015\"\u0016\u0010\u001B\u001A\u00020\u0013X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u001C\u0010\u0015\"\u0014\u0010\u001D\u001A\u00020\u001EX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0014\u0010!\u001A\u00020\"X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b#\u0010$¨\u0006&"}, d2={"BadgedBox", "", "badge", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Badge", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "Landroidx/compose/foundation/layout/RowScope;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgeWithContentHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getBadgeWithContentHorizontalPadding", "()F", "F", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeWithContentVerticalOffset", "getBadgeWithContentVerticalOffset", "BadgeOffset", "getBadgeOffset", "BadgeTopRuler", "Landroidx/compose/ui/layout/HorizontalRuler;", "getBadgeTopRuler", "()Landroidx/compose/ui/layout/HorizontalRuler;", "BadgeEndRuler", "Landroidx/compose/ui/layout/VerticalRuler;", "getBadgeEndRuler", "()Landroidx/compose/ui/layout/VerticalRuler;", "badgeBounds", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BadgeKt {
    private static final VerticalRuler BadgeEndRuler;
    private static final float BadgeOffset;
    private static final HorizontalRuler BadgeTopRuler;
    private static final float BadgeWithContentHorizontalOffset;
    private static final float BadgeWithContentHorizontalPadding;
    private static final float BadgeWithContentVerticalOffset;

    static {
        BadgeKt.BadgeWithContentHorizontalPadding = Dp.constructor-impl(4f);
        BadgeKt.BadgeWithContentHorizontalOffset = Dp.constructor-impl(12f);
        BadgeKt.BadgeWithContentVerticalOffset = Dp.constructor-impl(14f);
        BadgeKt.BadgeOffset = Dp.constructor-impl(6f);
        BadgeKt.BadgeTopRuler = new HorizontalRuler();
        BadgeKt.BadgeEndRuler = new VerticalRuler();
    }

    public static final void Badge-eopBjH0(Modifier arg16, long arg17, long arg19, Function3 arg21, Composer arg22, int arg23, int arg24) {
        Modifier v1_1;
        Composer v0_5;
        Companion v3_2;
        Shape v4_1;
        Modifier v2_1;
        Companion v2_2;
        Function3 v12;
        long v10;
        int v6;
        long v8;
        Modifier v4;
        int v5;
        int v7 = arg23;
        int v0 = 0x552176FC;
        Composer v1 = arg22.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(Badge)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,content)165@6561L876:Badge.kt#uh7d8r");
        int v2 = arg24 & 1;
        int v3 = 2;
        if(v2 != 0) {
            v5 = v7 | 6;
            v4 = arg16;
        }
        else if((v7 & 6) == 0) {
            v4 = arg16;
            v5 = v1.changed(v4) ? 4 : v3;
            v5 |= v7;
        }
        else {
            v4 = arg16;
            v5 = v7;
        }

        if((v7 & 0x30) == 0) {
            v8 = arg17;
            v6 = (arg24 & 2) != 0 || !v1.changed(v8) ? 16 : 0x20;
            v5 |= v6;
        }
        else {
            v8 = arg17;
        }

        if((v7 & 0x180) == 0) {
            v10 = arg19;
            v6 = (arg24 & 4) != 0 || !v1.changed(v10) ? 0x80 : 0x100;
            v5 |= v6;
        }
        else {
            v10 = arg19;
        }

        v6 = arg24 & 8;
        if(v6 != 0) {
            v5 |= 0xC00;
            goto label_65;
        }
        else if((v7 & 0xC00) == 0) {
            v12 = arg21;
            int v13 = v1.changedInstance(v12) ? 0x800 : 0x400;
            v5 |= v13;
        }
        else {
        label_65:
            v12 = arg21;
        }

        boolean v13_1 = (v5 & 0x493) != 1170 ? true : false;
        if(v1.shouldExecute(v13_1, v5 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "152@6161L14,153@6203L31");
            Object v14 = null;
            int v15 = 6;
            if((v7 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v2_2 = Modifier.Companion;
                }
                else {
                    v2_1 = v4;
                }

                if((arg24 & 2) != 0) {
                    v8 = BadgeDefaults.INSTANCE.getContainerColor(v1, v15);
                    v5 &= 0xFFFFFF8F;
                }

                if((arg24 & 4) != 0) {
                    v10 = ColorSchemeKt.contentColorFor-ek8zF_U(v8, v1, v5 >> 3 & 14);
                    v5 &= -897;
                }

                if(v6 == 0) {
                    goto label_112;
                }

                v12 = ((Function3)v14);
            }
            else {
                v1.skipToGroupEnd();
                if((arg24 & 2) != 0) {
                    v5 &= 0xFFFFFF8F;
                }

                if((arg24 & 4) != 0) {
                    v5 &= -897;
                }

                v2_1 = v4;
            }

        label_112:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v5, -1, "androidx.compose.material3.Badge (Badge.kt:155)");
            }

            BadgeTokens v0_1 = BadgeTokens.INSTANCE;
            float v0_2 = v12 != null ? v0_1.getLargeSize-D9Ej5fM() : v0_1.getSize-D9Ej5fM();
            if(v12 != null) {
                v1.startReplaceGroup(-1051012910);
                ComposerKt.sourceInformation(v1, "159@6458L5");
                v4_1 = ShapesKt.getValue(BadgeTokens.INSTANCE.getLargeShape(), v1, v15);
                v1.endReplaceGroup();
            }
            else {
                v1.startReplaceGroup(0xC15BB0F7);
                ComposerKt.sourceInformation(v1, "161@6511L5");
                v4_1 = ShapesKt.getValue(BadgeTokens.INSTANCE.getShape(), v1, v15);
                v1.endReplaceGroup();
            }

            Modifier v0_3 = BackgroundKt.background-bw27NRU(SizeKt.defaultMinSize-VpY3zN4(((Modifier)v2_2), v0_2, v0_2), v8, v4_1);
            if(v12 != null) {
                Modifier v3_1 = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, BadgeKt.BadgeWithContentHorizontalPadding, 0f, v3, v14);
            }
            else {
                v3_2 = Modifier.Companion;
            }

            v0_3 = v0_3.then(((Modifier)v3_2));
            Vertical v3_3 = Alignment.Companion.getCenterVertically();
            HorizontalOrVertical v4_2 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(v1, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy v3_4 = RowKt.rowMeasurePolicy(((Horizontal)v4_2), v3_3, v1, 54);
            ComposerKt.sourceInformationMarkerStart(v1, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v4_3 = ComposablesKt.getCurrentCompositeKeyHash(v1, 0);
            CompositionLocalMap v13_2 = v1.getCurrentCompositionLocalMap();
            v0_3 = ComposedModifierKt.materializeModifier(v1, v0_3);
            Function0 v14_1 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v1, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v1.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v1.startReusableNode();
            if(v1.getInserting()) {
                v1.createNode(v14_1);
            }
            else {
                v1.useNode();
            }

            Composer v6_1 = Updater.constructor-impl(v1);
            Updater.set-impl(v6_1, v3_4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v6_1, v13_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v3_5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v6_1.getInserting()) || !Intrinsics.areEqual(v6_1.rememberedValue(), Integer.valueOf(v4_3))) {
                v6_1.updateRememberedValue(Integer.valueOf(v4_3));
                v6_1.apply(Integer.valueOf(v4_3), v3_5);
            }

            Updater.set-impl(v6_1, v0_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v1, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance v0_4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(v1, 0x50373362, "C:Badge.kt#uh7d8r");
            if(v12 != null) {
                v1.startReplaceGroup(0x50378236);
                ComposerKt.sourceInformation(v1, "180@7239L5,184@7393L13,181@7257L164");
                ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(v10, TypographyKt.getValue(BadgeTokens.INSTANCE.getLargeLabelTextFont(), v1, 6), ComposableLambdaKt.rememberComposableLambda(0x2049E075, true, new BadgeKt$Badge$1$1(v12, ((RowScope)v0_4)), v1, 54), v1, v5 >> 6 & 14 | 0x180);
                v0_5 = v1;
                v0_5.endReplaceGroup();
            }
            else {
                v0_5 = v1;
                v0_5.startReplaceGroup(0x503C7E8A);
                v0_5.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v0_5);
            ComposerKt.sourceInformationMarkerEnd(v0_5);
            v0_5.endNode();
            ComposerKt.sourceInformationMarkerEnd(v0_5);
            ComposerKt.sourceInformationMarkerEnd(v0_5);
            ComposerKt.sourceInformationMarkerEnd(v0_5);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = ((Modifier)v2_2);
        }
        else {
            v0_5 = v1;
            v0_5.skipToGroupEnd();
            v1_1 = v4;
        }

        long v2_3 = v8;
        long v4_4 = v10;
        Function3 v6_2 = v12;
        ScopeUpdateScope v9 = v0_5.endRestartGroup();
        if(v9 != null) {
            v9.updateScope(new BadgeKt$$ExternalSyntheticLambda2(v1_1, v2_3, v4_4, v6_2, v7, arg24));
        }
    }

    static final Unit Badge_eopBjH0$lambda$4(Modifier arg10, long arg11, long arg13, Function3 arg15, int arg16, int arg17, Composer arg18, int arg19) {
        BadgeKt.Badge-eopBjH0(arg10, arg11, arg13, arg15, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }

    public static final void BadgedBox(Function3 arg17, Modifier arg18, Function3 arg19, Composer arg20, int arg21, int arg22) {
        BadgeKt$BadgedBox$1$1 v0_2;
        Modifier v6_2;
        int v8;
        Modifier v7;
        int v5;
        Function3 v1 = arg17;
        Function3 v3 = arg19;
        int v4 = arg21;
        int v0 = 0x9B0A4467;
        Composer v2 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v2, "C(BadgedBox)N(badge,modifier,content)78@3019L2193,68@2698L2514:Badge.kt#uh7d8r");
        if((arg22 & 1) != 0) {
            v5 = v4 | 6;
        }
        else if((v4 & 6) == 0) {
            v5 = v2.changedInstance(v1) ? 4 : 2;
            v5 |= v4;
        }
        else {
            v5 = v4;
        }

        int v6 = arg22 & 2;
        if(v6 != 0) {
            v5 |= 0x30;
            goto label_36;
        }
        else if((v4 & 0x30) == 0) {
            v7 = arg18;
            v8 = v2.changed(v7) ? 0x20 : 16;
            v5 |= v8;
        }
        else {
        label_36:
            v7 = arg18;
        }

        if((arg22 & 4) != 0) {
            v5 |= 0x180;
        }
        else if((v4 & 0x180) == 0) {
            v8 = v2.changedInstance(v3) ? 0x100 : 0x80;
            v5 |= v8;
        }

        boolean v8_1 = (v5 & 0x93) != 0x92 ? true : false;
        if(v2.shouldExecute(v8_1, v5 & 1)) {
            if(v6 != 0) {
                Companion v6_1 = Modifier.Companion;
            }
            else {
                v6_2 = v7;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v5, -1, "androidx.compose.material3.BadgedBox (Badge.kt:67)");
            }

            ComposerKt.sourceInformationMarkerStart(v2, 0x18B0B58, "CC(remember):Badge.kt#9igjgp");
            Object v0_1 = v2.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = BadgeKt$BadgedBox$1$1.INSTANCE;
                v2.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            int v7_1 = -1323940314;
            String v8_2 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v2, v7_1, v8_2);
            int v9 = ComposablesKt.getCurrentCompositeKeyHash(v2, 0);
            CompositionLocalMap v11 = v2.getCurrentCompositionLocalMap();
            Modifier v12 = ComposedModifierKt.materializeModifier(v2, v6_2);
            Function0 v13 = ComposeUiNode.Companion.getConstructor();
            String v15 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v2, 0xD6BD0031, v15);
            if(!(v2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v2.startReusableNode();
            if(v2.getInserting()) {
                v2.createNode(v13);
            }
            else {
                v2.useNode();
            }

            Composer v13_1 = Updater.constructor-impl(v2);
            Updater.set-impl(v13_1, v0_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v13_1, v11, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v0_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v13_1.getInserting()) || !Intrinsics.areEqual(v13_1.rememberedValue(), Integer.valueOf(v9))) {
                v13_1.updateRememberedValue(Integer.valueOf(v9));
                v13_1.apply(Integer.valueOf(v9), v0_3);
            }

            Updater.set-impl(v13_1, v12, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v2, 0xA613909, "C71@2767L162,76@2942L59:Badge.kt#uh7d8r");
            Modifier v0_4 = LayoutIdKt.layoutId(Modifier.Companion, "anchor");
            Alignment v9_1 = Alignment.Companion.getCenter();
            int v11_1 = v5 << 3 & 0x1C00 | 54;
            String v13_2 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v2, 0x2BB5B5D7, v13_2);
            MeasurePolicy v9_2 = BoxKt.maybeCachedBoxMeasurePolicy(v9_1, false);
            ComposerKt.sourceInformationMarkerStart(v2, v7_1, v8_2);
            int v14 = ComposablesKt.getCurrentCompositeKeyHash(v2, 0);
            CompositionLocalMap v7_2 = v2.getCurrentCompositionLocalMap();
            v0_4 = ComposedModifierKt.materializeModifier(v2, v0_4);
            Function0 v10 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v2, 0xD6BD0031, v15);
            if(!(v2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v2.startReusableNode();
            if(v2.getInserting()) {
                v2.createNode(v10);
            }
            else {
                v2.useNode();
            }

            Composer v10_1 = Updater.constructor-impl(v2);
            Updater.set-impl(v10_1, v9_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v10_1, v7_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v7_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v10_1.getInserting()) || !Intrinsics.areEqual(v10_1.rememberedValue(), Integer.valueOf(v14))) {
                v10_1.updateRememberedValue(Integer.valueOf(v14));
                v10_1.apply(Integer.valueOf(v14), v7_3);
            }

            Updater.set-impl(v10_1, v0_4, ComposeUiNode.Companion.getSetModifier());
            v0 = 0x800B7D29;
            String v7_4 = "C72@3468L9:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v2, v0, v7_4);
            v3.invoke(BoxScopeInstance.INSTANCE, v2, Integer.valueOf(v11_1 >> 6 & 0x70 | 6));
            ComposerKt.sourceInformationMarkerEnd(v2);
            v2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            Modifier v9_3 = LayoutIdKt.layoutId(Modifier.Companion, "badge");
            v5 = v5 << 9 & 0x1C00 | 6;
            ComposerKt.sourceInformationMarkerStart(v2, 0x2BB5B5D7, v13_2);
            MeasurePolicy v10_2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v2, -1323940314, v8_2);
            v8 = ComposablesKt.getCurrentCompositeKeyHash(v2, 0);
            v11 = v2.getCurrentCompositionLocalMap();
            v9_3 = ComposedModifierKt.materializeModifier(v2, v9_3);
            Function0 v12_1 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v2, 0xD6BD0031, v15);
            if(!(v2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v2.startReusableNode();
            if(v2.getInserting()) {
                v2.createNode(v12_1);
            }
            else {
                v2.useNode();
            }

            Composer v12_2 = Updater.constructor-impl(v2);
            Updater.set-impl(v12_2, v10_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v12_2, v11, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v10_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v12_2.getInserting()) || !Intrinsics.areEqual(v12_2.rememberedValue(), Integer.valueOf(v8))) {
                v12_2.updateRememberedValue(Integer.valueOf(v8));
                v12_2.apply(Integer.valueOf(v8), v10_3);
            }

            Updater.set-impl(v12_2, v9_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v2, v0, v7_4);
            v1.invoke(BoxScopeInstance.INSTANCE, v2, Integer.valueOf(v5 >> 6 & 0x70 | 6));
            ComposerKt.sourceInformationMarkerEnd(v2);
            v2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            v2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v2);
            ComposerKt.sourceInformationMarkerEnd(v2);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_265;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v2.skipToGroupEnd();
            v6_2 = v7;
        }

    label_265:
        ScopeUpdateScope v7_5 = v2.endRestartGroup();
        if(v7_5 != null) {
            v7_5.updateScope(new BadgeKt$$ExternalSyntheticLambda0(v1, ((Companion)v6_2), v3, v4, arg22));
        }
    }

    static final Unit BadgedBox$lambda$2(Function3 arg6, Modifier arg7, Function3 arg8, int arg9, int arg10, Composer arg11, int arg12) {
        BadgeKt.BadgedBox(arg6, arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    public static final Modifier badgeBounds(Modifier arg1) {
        return LayoutModifierKt.layout(arg1, new BadgeKt$$ExternalSyntheticLambda1());
    }

    static final MeasureResult badgeBounds$lambda$7(MeasureScope arg8, Measurable arg9, Constraints arg10) {
        Placeable v9 = arg9.measure-BRTryo0(arg10.unbox-impl());
        return MeasureScope.layout$default(arg8, v9.getWidth(), v9.getHeight(), null, new BadgeKt$$ExternalSyntheticLambda3(), new BadgeKt$$ExternalSyntheticLambda4(v9), 4, null);
    }

    static final Unit badgeBounds$lambda$7$lambda$5(RulerScope arg4) {
        arg4.provides(BadgeKt.BadgeEndRuler, ((float)(((int)(arg4.getCoordinates().getSize-YbymL2g() >> 0x20)))));
        arg4.provides(BadgeKt.BadgeTopRuler, 0f);
        return Unit.INSTANCE;
    }

    static final Unit badgeBounds$lambda$7$lambda$6(Placeable arg7, PlacementScope arg8) {
        PlacementScope.place$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public static final VerticalRuler getBadgeEndRuler() {
        return BadgeKt.BadgeEndRuler;
    }

    public static final float getBadgeOffset() {
        return BadgeKt.BadgeOffset;
    }

    public static final HorizontalRuler getBadgeTopRuler() {
        return BadgeKt.BadgeTopRuler;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeKt.BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeKt.BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentVerticalOffset() {
        return BadgeKt.BadgeWithContentVerticalOffset;
    }
}

