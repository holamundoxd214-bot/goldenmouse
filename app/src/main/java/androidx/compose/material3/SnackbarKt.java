package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SnackbarTokens;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001A\u0096\u0001\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0015\b\u0002\u0010\u0004\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u0007\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\b\b\u0002\u0010\u000F\u001A\u00020\r2\b\b\u0002\u0010\u0010\u001A\u00020\r2\u0011\u0010\u0011\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001Ag\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\b\b\u0002\u0010\u0016\u001A\u00020\r2\b\b\u0002\u0010\u000F\u001A\u00020\r2\b\b\u0002\u0010\u0010\u001A\u00020\rH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001Ab\u0010\u0019\u001A\u00020\u00012\u0011\u0010\u001A\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u0007\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\rH\u0003¢\u0006\u0004\b\u001D\u0010\u001E\u001Ad\u0010\u001F\u001A\u00020\u00012\u0011\u0010\u001A\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u0004\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u0007\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020\r2\u0006\u0010!\u001A\u00020\rH\u0003¢\u0006\u0004\b\"\u0010\u001E\"\u0010\u0010#\u001A\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010&\u001A\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010\'\u001A\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010(\u001A\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010)\u001A\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010*\u001A\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010+\u001A\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%\"\u0010\u0010,\u001A\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006-"}, d2={"Snackbar", "", "modifier", "Landroidx/compose/ui/Modifier;", "action", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "dismissAction", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "actionContentColor", "dismissActionContentColor", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "NewLineButtonSnackbar", "text", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "LongButtonVerticalOffset", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SnackbarKt {
    private static final float ContainerMaxWidth;
    private static final float HeightToFirstLine;
    private static final float HorizontalSpacing;
    private static final float HorizontalSpacingButtonSide;
    private static final float LongButtonVerticalOffset;
    private static final float SeparateButtonExtraY;
    private static final float SnackbarVerticalPadding;
    private static final float TextEndExtraSpacing;

    static {
        SnackbarKt.ContainerMaxWidth = Dp.constructor-impl(600f);
        SnackbarKt.HeightToFirstLine = Dp.constructor-impl(30f);
        SnackbarKt.HorizontalSpacing = Dp.constructor-impl(16f);
        SnackbarKt.HorizontalSpacingButtonSide = Dp.constructor-impl(8f);
        SnackbarKt.SeparateButtonExtraY = Dp.constructor-impl(2f);
        SnackbarKt.SnackbarVerticalPadding = Dp.constructor-impl(6f);
        SnackbarKt.TextEndExtraSpacing = Dp.constructor-impl(8f);
        SnackbarKt.LongButtonVerticalOffset = Dp.constructor-impl(12f);
    }

    private static final void NewLineButtonSnackbar-kKq0p4A(Function2 arg34, Function2 arg35, Function2 arg36, TextStyle arg37, long arg38, long arg40, Composer arg42, int arg43) {
        int v8;
        int v6;
        Function2 v1 = arg34;
        Function2 v2 = arg35;
        Function2 v3 = arg36;
        TextStyle v4 = arg37;
        int v9 = arg43;
        int v0 = 0xF039831E;
        Composer v5 = arg42.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(NewLineButtonSnackbar)N(text,action,dismissAction,actionTextStyle,actionContentColor:c#ui.graphics.Color,dismissActionContentColor:c#ui.graphics.Color)259@11546L1177:Snackbar.kt#uh7d8r");
        if((v9 & 6) == 0) {
            v6 = v5.changedInstance(v1) ? 4 : 2;
            v6 |= v9;
        }
        else {
            v6 = v9;
        }

        if((v9 & 0x30) == 0) {
            v8 = v5.changedInstance(v2) ? 0x20 : 16;
            v6 |= v8;
        }

        if((v9 & 0x180) == 0) {
            v8 = v5.changedInstance(v3) ? 0x100 : 0x80;
            v6 |= v8;
        }

        if((v9 & 0xC00) == 0) {
            v8 = v5.changed(v4) ? 0x800 : 0x400;
            v6 |= v8;
        }

        long v10 = arg38;
        if((v9 & 0x6000) == 0) {
            v8 = v5.changed(v10) ? 0x4000 : 0x2000;
            v6 |= v8;
        }

        long v12 = arg40;
        if((0x30000 & v9) == 0) {
            v8 = v5.changed(v12) ? 0x20000 : 0x10000;
            v6 |= v8;
        }

        boolean v8_1 = (74899 & v6) != 74898 ? true : false;
        if(v5.shouldExecute(v8_1, v6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v6, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:258)");
            }

            Modifier v0_1 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, 0f, SnackbarKt.ContainerMaxWidth, 1, null), 0f, 1, null), SnackbarKt.HorizontalSpacing, 0f, 0f, SnackbarKt.SeparateButtonExtraY, 6, null);
            ComposerKt.sourceInformationMarkerStart(v5, 0xE32F0E82, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy v7 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), v5, 0);
            String v15 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v5, -1323940314, v15);
            int v19 = ComposablesKt.getCurrentCompositeKeyHash(v5, 0);
            CompositionLocalMap v14 = v5.getCurrentCompositionLocalMap();
            v0_1 = ComposedModifierKt.materializeModifier(v5, v0_1);
            Function0 v8_2 = ComposeUiNode.Companion.getConstructor();
            int v20 = v6;
            String v9_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v5, 0xD6BD0031, v9_1);
            if(!(v5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v5.startReusableNode();
            if(v5.getInserting()) {
                v5.createNode(v8_2);
            }
            else {
                v5.useNode();
            }

            Composer v6_1 = Updater.constructor-impl(v5);
            Updater.set-impl(v6_1, v7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v6_1, v14, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v7_1 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v6_1.getInserting()) || !Intrinsics.areEqual(v6_1.rememberedValue(), Integer.valueOf(v19))) {
                v6_1.updateRememberedValue(Integer.valueOf(v19));
                v6_1.apply(Integer.valueOf(v19), v7_1);
            }

            Updater.set-impl(v6_1, v0_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v5, 0xE9125B67, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance v0_2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(v5, 0x9697CFA9, "C267@11835L191,274@12036L681:Snackbar.kt#uh7d8r");
            Modifier v23 = AlignmentLineKt.paddingFromBaseline-VpY3zN4(Modifier.Companion, SnackbarKt.HeightToFirstLine, SnackbarKt.LongButtonVerticalOffset);
            float v26 = SnackbarKt.HorizontalSpacingButtonSide;
            Modifier v6_2 = PaddingKt.padding-qDBjuR0$default(v23, 0f, 0f, v26, 0f, 11, null);
            String v8_3 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v5, 0x2BB5B5D7, v8_3);
            MeasurePolicy v14_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v5, -1323940314, v15);
            int v10_1 = ComposablesKt.getCurrentCompositeKeyHash(v5, 0);
            CompositionLocalMap v7_2 = v5.getCurrentCompositionLocalMap();
            v6_2 = ComposedModifierKt.materializeModifier(v5, v6_2);
            Function0 v11 = ComposeUiNode.Companion.getConstructor();
            int v23_1 = v10_1;
            ComposerKt.sourceInformationMarkerStart(v5, 0xD6BD0031, v9_1);
            if(!(v5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v5.startReusableNode();
            if(v5.getInserting()) {
                v5.createNode(v11);
            }
            else {
                v5.useNode();
            }

            Composer v10_2 = Updater.constructor-impl(v5);
            Updater.set-impl(v10_2, v14_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v10_2, v7_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v7_1 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v10_2.getInserting()) || !Intrinsics.areEqual(v10_2.rememberedValue(), Integer.valueOf(v23_1))) {
                v10_2.updateRememberedValue(Integer.valueOf(v23_1));
                v10_2.apply(Integer.valueOf(v23_1), v7_1);
            }

            Updater.set-impl(v10_2, v6_2, ComposeUiNode.Companion.getSetModifier());
            String v7_3 = "C72@3468L9:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v5, 0x800B7D29, v7_3);
            ComposerKt.sourceInformationMarkerStart(v5, -1846600805, "C271@12010L6:Snackbar.kt#uh7d8r");
            v1.invoke(v5, Integer.valueOf(v20 & 14));
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            v5.endNode();
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            Modifier v27 = ((ColumnScope)v0_2).align(Modifier.Companion, Alignment.Companion.getEnd());
            if(v3 == null) {
            }
            else {
                v26 = Dp.constructor-impl(0f);
            }

            v0_1 = PaddingKt.padding-qDBjuR0$default(v27, 0f, 0f, v26, 0f, 11, null);
            ComposerKt.sourceInformationMarkerStart(v5, 0x2BB5B5D7, v8_3);
            MeasurePolicy v8_4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v5, -1323940314, v15);
            v10_1 = ComposablesKt.getCurrentCompositeKeyHash(v5, 0);
            CompositionLocalMap v11_1 = v5.getCurrentCompositionLocalMap();
            v0_1 = ComposedModifierKt.materializeModifier(v5, v0_1);
            Function0 v14_2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v5, 0xD6BD0031, v9_1);
            if(!(v5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v5.startReusableNode();
            if(v5.getInserting()) {
                v5.createNode(v14_2);
            }
            else {
                v5.useNode();
            }

            v6_1 = Updater.constructor-impl(v5);
            Updater.set-impl(v6_1, v8_4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v6_1, v11_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v8_5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v6_1.getInserting()) || !Intrinsics.areEqual(v6_1.rememberedValue(), Integer.valueOf(v10_1))) {
                v6_1.updateRememberedValue(Integer.valueOf(v10_1));
                v6_1.apply(Integer.valueOf(v10_1), v8_5);
            }

            Updater.set-impl(v6_1, v0_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v5, 0x800B7D29, v7_3);
            ComposerKt.sourceInformationMarkerStart(v5, 0x41D0B0C1, "C278@12204L503:Snackbar.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(v5, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Companion v0_3 = Modifier.Companion;
            MeasurePolicy v6_3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), v5, 0);
            ComposerKt.sourceInformationMarkerStart(v5, -1323940314, v15);
            int v7_4 = ComposablesKt.getCurrentCompositeKeyHash(v5, 0);
            CompositionLocalMap v8_6 = v5.getCurrentCompositionLocalMap();
            v0_1 = ComposedModifierKt.materializeModifier(v5, ((Modifier)v0_3));
            Function0 v10_3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v5, 0xD6BD0031, v9_1);
            if(!(v5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v5.startReusableNode();
            if(v5.getInserting()) {
                v5.createNode(v10_3);
            }
            else {
                v5.useNode();
            }

            Composer v9_2 = Updater.constructor-impl(v5);
            Updater.set-impl(v9_2, v6_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v9_2, v8_6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v6_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v9_2.getInserting()) || !Intrinsics.areEqual(v9_2.rememberedValue(), Integer.valueOf(v7_4))) {
                v9_2.updateRememberedValue(Integer.valueOf(v7_4));
                v9_2.apply(Integer.valueOf(v7_4), v6_4);
            }

            Updater.set-impl(v9_2, v0_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v5, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v5, 916026697, "C279@12226L209:Snackbar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(arg38)), TextKt.getLocalTextStyle().provides(v4)}, v2, v5, ProvidedValue.$stable | v20 & 0x70);
            if(v3 != null) {
                v5.startReplaceGroup(0x369D2B05);
                ComposerKt.sourceInformation(v5, "285@12501L174");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(v12)), v3, v5, ProvidedValue.$stable | v20 >> 3 & 0x70);
                v5.endReplaceGroup();
            }
            else {
                v5.startReplaceGroup(0x36A04E5B);
                v5.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            v5.endNode();
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            v5.endNode();
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            v5.endNode();
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_410;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v5.skipToGroupEnd();
        }

    label_410:
        ScopeUpdateScope v10_4 = v5.endRestartGroup();
        if(v10_4 != null) {
            v10_4.updateScope(new SnackbarKt$$ExternalSyntheticLambda2(v1, v2, v3, v4, arg38, v12, arg43));
        }
    }

    static final Unit NewLineButtonSnackbar_kKq0p4A$lambda$6(Function2 arg11, Function2 arg12, Function2 arg13, TextStyle arg14, long arg15, long arg17, int arg19, Composer arg20, int arg21) {
        SnackbarKt.NewLineButtonSnackbar-kKq0p4A(arg11, arg12, arg13, arg14, arg15, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg19 | 1));
        return Unit.INSTANCE;
    }

    private static final void OneRowSnackbar-kKq0p4A(Function2 arg23, Function2 arg24, Function2 arg25, TextStyle arg26, long arg27, long arg29, Composer arg31, int arg32) {
        int v8;
        int v6;
        Function2 v1 = arg23;
        Function2 v2 = arg24;
        Function2 v3 = arg25;
        TextStyle v4 = arg26;
        int v9 = arg32;
        int v0 = 0xC87D1A34;
        Composer v5 = arg31.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(OneRowSnackbar)N(text,action,dismissAction,actionTextStyle,actionTextColor:c#ui.graphics.Color,dismissActionColor:c#ui.graphics.Color)333@14092L3580,307@13082L4590:Snackbar.kt#uh7d8r");
        if((v9 & 6) == 0) {
            v6 = v5.changedInstance(v1) ? 4 : 2;
            v6 |= v9;
        }
        else {
            v6 = v9;
        }

        if((v9 & 0x30) == 0) {
            v8 = v5.changedInstance(v2) ? 0x20 : 16;
            v6 |= v8;
        }

        if((v9 & 0x180) == 0) {
            v8 = v5.changedInstance(v3) ? 0x100 : 0x80;
            v6 |= v8;
        }

        if((v9 & 0xC00) == 0) {
            v8 = v5.changed(v4) ? 0x800 : 0x400;
            v6 |= v8;
        }

        long v10 = arg27;
        if((v9 & 0x6000) == 0) {
            v8 = v5.changed(v10) ? 0x4000 : 0x2000;
            v6 |= v8;
        }

        long v12 = arg29;
        if((0x30000 & v9) == 0) {
            v8 = v5.changed(v12) ? 0x20000 : 0x10000;
            v6 |= v8;
        }

        boolean v8_1 = (74899 & v6) != 74898 ? true : false;
        if(v5.shouldExecute(v8_1, v6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v6, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:303)");
            }

            Companion v16 = Modifier.Companion;
            float v17 = SnackbarKt.HorizontalSpacing;
            float v8_2 = v3 == null ? SnackbarKt.HorizontalSpacingButtonSide : Dp.constructor-impl(0f);
            Modifier v8_3 = PaddingKt.padding-qDBjuR0$default(((Modifier)v16), v17, 0f, v8_2, 0f, 10, null);
            ComposerKt.sourceInformationMarkerStart(v5, -1650453040, "CC(remember):Snackbar.kt#9igjgp");
            Object v0_1 = v5.rememberedValue();
            String v15 = "text";
            String v7 = "action";
            int v19 = v6;
            String v6_1 = "dismissAction";
            if(v0_1 == Composer.Companion.getEmpty()) {
                SnackbarKt$OneRowSnackbar$2$1 v0_2 = new SnackbarKt$OneRowSnackbar$2$1(v7, v6_1, v15);
                v5.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            String v9_1 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v5, -1323940314, v9_1);
            int v21 = ComposablesKt.getCurrentCompositeKeyHash(v5, 0);
            CompositionLocalMap v14 = v5.getCurrentCompositionLocalMap();
            v8_3 = ComposedModifierKt.materializeModifier(v5, v8_3);
            Function0 v10_1 = ComposeUiNode.Companion.getConstructor();
            int v11 = 0xD6BD0031;
            String v12_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v5, v11, v12_1);
            if(!(v5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v5.startReusableNode();
            if(v5.getInserting()) {
                v5.createNode(v10_1);
            }
            else {
                v5.useNode();
            }

            Composer v10_2 = Updater.constructor-impl(v5);
            Updater.set-impl(v10_2, v0_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v10_2, v14, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v0_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v10_2.getInserting()) || !Intrinsics.areEqual(v10_2.rememberedValue(), Integer.valueOf(v21))) {
                v10_2.updateRememberedValue(Integer.valueOf(v21));
                v10_2.apply(Integer.valueOf(v21), v0_3);
            }

            Updater.set-impl(v10_2, v8_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v5, -1014272487, "C309@13112L86:Snackbar.kt#uh7d8r");
            Modifier v0_4 = PaddingKt.padding-VpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, v15), 0f, SnackbarKt.SnackbarVerticalPadding, 1, null);
            String v10_3 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v5, 0x2BB5B5D7, v10_3);
            MeasurePolicy v13 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(v5, -1323940314, v9_1);
            int v15_1 = ComposablesKt.getCurrentCompositeKeyHash(v5, 0);
            v14 = v5.getCurrentCompositionLocalMap();
            v0_4 = ComposedModifierKt.materializeModifier(v5, v0_4);
            Function0 v8_4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v5, v11, v12_1);
            if(!(v5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v5.startReusableNode();
            if(v5.getInserting()) {
                v5.createNode(v8_4);
            }
            else {
                v5.useNode();
            }

            Composer v8_5 = Updater.constructor-impl(v5);
            Updater.set-impl(v8_5, v13, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v8_5, v14, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v11_1 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v8_5.getInserting()) || !Intrinsics.areEqual(v8_5.rememberedValue(), Integer.valueOf(v15_1))) {
                v8_5.updateRememberedValue(Integer.valueOf(v15_1));
                v8_5.apply(Integer.valueOf(v15_1), v11_1);
            }

            Updater.set-impl(v8_5, v0_4, ComposeUiNode.Companion.getSetModifier());
            String v8_6 = "C72@3468L9:Box.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart(v5, 0x800B7D29, v8_6);
            ComposerKt.sourceInformationMarkerStart(v5, 0x5473EEAC, "C309@13190L6:Snackbar.kt#uh7d8r");
            v1.invoke(v5, Integer.valueOf(v19 & 14));
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            v5.endNode();
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            if(v2 != null) {
                v5.startReplaceGroup(0xC38D060F);
                ComposerKt.sourceInformation(v5, "311@13249L296");
                Modifier v7_1 = LayoutIdKt.layoutId(Modifier.Companion, v7);
                ComposerKt.sourceInformationMarkerStart(v5, 0x2BB5B5D7, v10_3);
                MeasurePolicy v11_2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v5, -1323940314, v9_1);
                int v13_1 = ComposablesKt.getCurrentCompositeKeyHash(v5, 0);
                v14 = v5.getCurrentCompositionLocalMap();
                v7_1 = ComposedModifierKt.materializeModifier(v5, v7_1);
                Function0 v15_2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v5, 0xD6BD0031, v12_1);
                if(!(v5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v5.startReusableNode();
                if(v5.getInserting()) {
                    v5.createNode(v15_2);
                }
                else {
                    v5.useNode();
                }

                Composer v0_5 = Updater.constructor-impl(v5);
                Updater.set-impl(v0_5, v11_2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v0_5, v14, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                v11_1 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v0_5.getInserting()) || !Intrinsics.areEqual(v0_5.rememberedValue(), Integer.valueOf(v13_1))) {
                    v0_5.updateRememberedValue(Integer.valueOf(v13_1));
                    v0_5.apply(Integer.valueOf(v13_1), v11_1);
                }

                Updater.set-impl(v0_5, v7_1, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v5, 0x800B7D29, v8_6);
                ComposerKt.sourceInformationMarkerStart(v5, 0x767AC19, "C312@13305L222:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(arg27)), TextKt.getLocalTextStyle().provides(v4)}, v2, v5, ProvidedValue.$stable | v19 & 0x70);
                ComposerKt.sourceInformationMarkerEnd(v5);
                ComposerKt.sourceInformationMarkerEnd(v5);
                v5.endNode();
                ComposerKt.sourceInformationMarkerEnd(v5);
                ComposerKt.sourceInformationMarkerEnd(v5);
                ComposerKt.sourceInformationMarkerEnd(v5);
                v5.endReplaceGroup();
            }
            else {
                v5.startReplaceGroup(-1013852841);
                v5.endReplaceGroup();
            }

            if(v3 != null) {
                v5.startReplaceGroup(-1013804481);
                ComposerKt.sourceInformation(v5, "320@13617L248");
                v0_4 = LayoutIdKt.layoutId(Modifier.Companion, v6_1);
                ComposerKt.sourceInformationMarkerStart(v5, 0x2BB5B5D7, v10_3);
                MeasurePolicy v6_2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v5, -1323940314, v9_1);
                int v7_2 = ComposablesKt.getCurrentCompositeKeyHash(v5, 0);
                CompositionLocalMap v9_2 = v5.getCurrentCompositionLocalMap();
                v0_4 = ComposedModifierKt.materializeModifier(v5, v0_4);
                v10_1 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v5, 0xD6BD0031, v12_1);
                if(!(v5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v5.startReusableNode();
                if(v5.getInserting()) {
                    v5.createNode(v10_1);
                }
                else {
                    v5.useNode();
                }

                v10_2 = Updater.constructor-impl(v5);
                Updater.set-impl(v10_2, v6_2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v10_2, v9_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 v6_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v10_2.getInserting()) || !Intrinsics.areEqual(v10_2.rememberedValue(), Integer.valueOf(v7_2))) {
                    v10_2.updateRememberedValue(Integer.valueOf(v7_2));
                    v10_2.apply(Integer.valueOf(v7_2), v6_3);
                }

                Updater.set-impl(v10_2, v0_4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v5, 0x800B7D29, v8_6);
                ComposerKt.sourceInformationMarkerStart(v5, -339190631, "C321@13680L167:Snackbar.kt#uh7d8r");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(arg29)), v3, v5, ProvidedValue.$stable | v19 >> 3 & 0x70);
                ComposerKt.sourceInformationMarkerEnd(v5);
                ComposerKt.sourceInformationMarkerEnd(v5);
                v5.endNode();
                ComposerKt.sourceInformationMarkerEnd(v5);
                ComposerKt.sourceInformationMarkerEnd(v5);
                ComposerKt.sourceInformationMarkerEnd(v5);
                v5.endReplaceGroup();
            }
            else {
                v5.startReplaceGroup(-1013535401);
                v5.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            v5.endNode();
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_398;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v5.skipToGroupEnd();
        }

    label_398:
        ScopeUpdateScope v10_4 = v5.endRestartGroup();
        if(v10_4 != null) {
            v10_4.updateScope(new SnackbarKt$$ExternalSyntheticLambda0(v1, v2, v3, v4, arg27, arg29, arg32));
        }
    }

    static final Unit OneRowSnackbar_kKq0p4A$lambda$12(Function2 arg11, Function2 arg12, Function2 arg13, TextStyle arg14, long arg15, long arg17, int arg19, Composer arg20, int arg21) {
        SnackbarKt.OneRowSnackbar-kKq0p4A(arg11, arg12, arg13, arg14, arg15, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg19 | 1));
        return Unit.INSTANCE;
    }

    public static final void Snackbar-eQBnUkQ(Modifier arg24, Function2 arg25, Function2 arg26, boolean arg27, Shape arg28, long arg29, long arg31, long arg33, long arg35, Function2 arg37, Composer arg38, int arg39, int arg40) {
        Function2 v3_2;
        long v12_2;
        boolean v4_1;
        long v10_1;
        long v8_1;
        long v6_2;
        Function2 v2_1;
        Shape v5_1;
        Composer v0_1;
        long v11_1;
        long v9_1;
        Shape v6_1;
        boolean v17_1;
        Function2 v22;
        long v18_1;
        Modifier v1_2;
        Companion v1_3;
        int v1;
        long v3_1;
        int v38;
        int v16;
        long v13_1;
        int v13;
        Shape v12_1;
        boolean v11;
        int v10;
        Function2 v9;
        int v8;
        Function2 v7;
        int v5;
        int v15 = arg39;
        int v0 = arg40;
        Composer v2 = arg38.startRestartGroup(0xB75AE4EC);
        ComposerKt.sourceInformation(v2, "C(Snackbar)N(modifier,action,dismissAction,actionOnNewLine,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,actionContentColor:c#ui.graphics.Color,dismissActionContentColor:c#ui.graphics.Color,content)117@5477L1123,111@5280L1320:Snackbar.kt#uh7d8r");
        int v3 = v0 & 1;
        if(v3 != 0) {
            v5 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            v5 = v2.changed(arg24) ? 4 : 2;
            v5 |= v15;
        }
        else {
            v5 = v15;
        }

        int v6 = v0 & 2;
        if(v6 != 0) {
            v5 |= 0x30;
            goto label_39;
        }
        else if((v15 & 0x30) == 0) {
            v7 = arg25;
            v8 = v2.changedInstance(v7) ? 0x20 : 16;
            v5 |= v8;
        }
        else {
        label_39:
            v7 = arg25;
        }

        v8 = v0 & 4;
        if(v8 != 0) {
            v5 |= 0x180;
            goto label_54;
        }
        else if((v15 & 0x180) == 0) {
            v9 = arg26;
            v10 = v2.changedInstance(v9) ? 0x100 : 0x80;
            v5 |= v10;
        }
        else {
        label_54:
            v9 = arg26;
        }

        v10 = v0 & 8;
        if(v10 != 0) {
            v5 |= 0xC00;
            goto label_69;
        }
        else if((v15 & 0xC00) == 0) {
            v11 = arg27;
            int v12 = v2.changed(v11) ? 0x800 : 0x400;
            v5 |= v12;
        }
        else {
        label_69:
            v11 = arg27;
        }

        if((v15 & 0x6000) == 0) {
            if((v0 & 16) == 0) {
                v12_1 = arg28;
                if(v2.changed(v12_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_80;
                }
            }
            else {
                v12_1 = arg28;
            label_80:
                v13 = 0x2000;
            }

            v5 |= v13;
        }
        else {
            v12_1 = arg28;
        }

        if((0x30000 & v15) == 0) {
            if((v0 & 0x20) == 0) {
                v13_1 = arg29;
                if(v2.changed(v13_1)) {
                    v16 = 0x20000;
                }
                else {
                    goto label_95;
                }
            }
            else {
                v13_1 = arg29;
            label_95:
                v16 = 0x10000;
            }

            v5 |= v16;
        }
        else {
            v13_1 = arg29;
        }

        if((v15 & 0x180000) == 0) {
            v38 = v3;
            v3_1 = arg31;
            v16 = (v0 & 0x40) != 0 || !v2.changed(v3_1) ? 0x80000 : 0x100000;
            v5 |= v16;
        }
        else {
            v38 = v3;
        }

        if((v15 & 0xC00000) == 0) {
            v3_1 = arg33;
            v1 = (v0 & 0x80) != 0 || !v2.changed(v3_1) ? 0x400000 : 0x800000;
            v5 |= v1;
        }

        if((0x6000000 & v15) == 0) {
            v3_1 = arg35;
            v1 = (v0 & 0x100) != 0 || !v2.changed(v3_1) ? 0x2000000 : 0x4000000;
            v5 |= v1;
        }

        int v17 = 0x30000000;
        if((v0 & 0x200) != 0) {
            v5 |= v17;
        }
        else if((v15 & v17) == 0) {
            v17 = v2.changedInstance(arg37) ? 0x20000000 : 0x10000000;
            v5 |= v17;
        }

        boolean v1_1 = (v5 & 306783379) != 306783378 ? true : false;
        if(v2.shouldExecute(v1_1, v5 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "104@4967L5,105@5019L5,106@5069L12,107@5132L18,108@5208L25");
            v3 = 0xF1FFFFFF;
            int v18 = 0xFE3FFFFF;
            int v19 = 0xFFC7FFFF;
            int v20 = 0xFFF8FFFF;
            int v21 = 0xFFFF1FFF;
            if((v15 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v38 != 0) {
                    v1_3 = Modifier.Companion;
                }
                else {
                    v1_2 = arg24;
                }

                v22 = null;
                if(v6 != 0) {
                    v7 = v22;
                }

                if(v8 != 0) {
                }
                else {
                    v22 = v9;
                }

                v17_1 = v10 != 0 ? false : v11;
                v8 = 6;
                if((v0 & 16) != 0) {
                    v6_1 = SnackbarDefaults.INSTANCE.getShape(v2, v8);
                    v5 &= v21;
                }
                else {
                    v6_1 = v12_1;
                }

                if((v0 & 0x20) != 0) {
                    v9_1 = SnackbarDefaults.INSTANCE.getColor(v2, v8);
                    v5 &= v20;
                }
                else {
                    v9_1 = v13_1;
                }

                if((v0 & 0x40) != 0) {
                    v11_1 = SnackbarDefaults.INSTANCE.getContentColor(v2, v8);
                    v5 &= v19;
                }
                else {
                    v11_1 = arg31;
                }

                if((v0 & 0x80) != 0) {
                    v13_1 = SnackbarDefaults.INSTANCE.getActionContentColor(v2, v8);
                    v5 &= v18;
                }
                else {
                    v13_1 = arg33;
                }

                v38 = v3;
                if((v0 & 0x100) != 0) {
                    v18_1 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(v2, v8);
                    v5 &= v38;
                    goto label_258;
                }

                v18_1 = arg35;
            }
            else {
                v2.skipToGroupEnd();
                if((v0 & 16) != 0) {
                    v5 &= v21;
                }

                if((v0 & 0x20) != 0) {
                    v5 &= v20;
                }

                if((v0 & 0x40) != 0) {
                    v5 &= v19;
                }

                if((v0 & 0x80) != 0) {
                    v5 &= v18;
                }

                if((v0 & 0x100) != 0) {
                    v5 &= v3;
                }

                v1_2 = arg24;
                v18_1 = arg35;
                v22 = v9;
                v17_1 = v11;
                v6_1 = v12_1;
                v9_1 = v13_1;
                v11_1 = arg31;
                v13_1 = arg33;
            }

        label_258:
            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xB75AE4EC, v5, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:110)");
            }

            int v4 = v5 >> 9;
            SurfaceKt.Surface-T9BRK9s(((Modifier)v1_3), v6_1, v9_1, v11_1, 0f, SnackbarTokens.INSTANCE.getContainerElevation-D9Ej5fM(), null, ComposableLambdaKt.rememberComposableLambda(0xAFEB6FF1, true, new SnackbarKt$Snackbar$1(v17_1, v7, arg37, v22, v13_1, v18_1), v2, 54), v2, v5 & 14 | 0xC30000 | v4 & 0x70 | v4 & 0x380 | v4 & 0x1C00, 80);
            v1_2 = ((Modifier)v1_3);
            v0_1 = v2;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_1 = v6_1;
            v2_1 = v7;
            v6_2 = v9_1;
            v8_1 = v11_1;
            v10_1 = v13_1;
            v4_1 = v17_1;
            v12_2 = v18_1;
            v3_2 = v22;
        }
        else {
            v0_1 = v2;
            v0_1.skipToGroupEnd();
            v1_2 = arg24;
            v2_1 = v7;
            v3_2 = v9;
            v4_1 = v11;
            v5_1 = v12_1;
            v6_2 = v13_1;
            v8_1 = arg31;
            v10_1 = arg33;
            v12_2 = arg35;
        }

        ScopeUpdateScope v0_2 = v0_1.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new SnackbarKt$$ExternalSyntheticLambda3(v1_2, v2_1, v3_2, v4_1, v5_1, v6_2, v8_1, v10_1, v12_2, arg37, v15, arg40));
        }
    }

    public static final void Snackbar-sDKtq54(SnackbarData arg34, Modifier arg35, boolean arg36, Shape arg37, long arg38, long arg40, long arg42, long arg44, long arg46, Composer arg48, int arg49, int arg50) {
        long v13;
        long v11;
        long v7_1;
        long v5_1;
        Shape v4_4;
        boolean v3_1;
        long v9_2;
        Composer v30;
        Function2 v17_2;
        long v23;
        long v21_1;
        Shape v20_1;
        boolean v19_1;
        Modifier v2_2;
        long v27;
        long v25;
        long v19_2;
        long v8_1;
        Shape v6_1;
        int v2;
        long v4_1;
        int v16;
        int v48;
        int v14;
        long v12_1;
        int v12;
        long v10_1;
        int v10;
        Shape v9_1;
        boolean v8;
        int v7;
        Modifier v6;
        int v4;
        SnackbarData v1 = arg34;
        int v15 = arg49;
        int v0 = arg50;
        Composer v3 = arg48.startRestartGroup(0x105E641F);
        ComposerKt.sourceInformation(v3, "C(Snackbar)N(snackbarData,modifier,actionOnNewLine,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,actionColor:c#ui.graphics.Color,actionContentColor:c#ui.graphics.Color,dismissActionContentColor:c#ui.graphics.Color)246@11225L38,236@10813L457:Snackbar.kt#uh7d8r");
        if((v0 & 1) != 0) {
            v4 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            v4 = v3.changed(v1) ? 4 : 2;
            v4 |= v15;
        }
        else {
            v4 = v15;
        }

        int v5 = v0 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_36;
        }
        else if((v15 & 0x30) == 0) {
            v6 = arg35;
            v7 = v3.changed(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_36:
            v6 = arg35;
        }

        v7 = v0 & 4;
        if(v7 != 0) {
            v4 |= 0x180;
            goto label_51;
        }
        else if((v15 & 0x180) == 0) {
            v8 = arg36;
            int v9 = v3.changed(v8) ? 0x100 : 0x80;
            v4 |= v9;
        }
        else {
        label_51:
            v8 = arg36;
        }

        if((v15 & 0xC00) == 0) {
            if((v0 & 8) == 0) {
                v9_1 = arg37;
                if(v3.changed(v9_1)) {
                    v10 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v9_1 = arg37;
            label_62:
                v10 = 0x400;
            }

            v4 |= v10;
        }
        else {
            v9_1 = arg37;
        }

        if((v15 & 0x6000) == 0) {
            if((v0 & 16) == 0) {
                v10_1 = arg38;
                if(v3.changed(v10_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_76;
                }
            }
            else {
                v10_1 = arg38;
            label_76:
                v12 = 0x2000;
            }

            v4 |= v12;
        }
        else {
            v10_1 = arg38;
        }

        if((0x30000 & v15) == 0) {
            if((v0 & 0x20) == 0) {
                v12_1 = arg40;
                if(v3.changed(v12_1)) {
                    v14 = 0x20000;
                }
                else {
                    goto label_91;
                }
            }
            else {
                v12_1 = arg40;
            label_91:
                v14 = 0x10000;
            }

            v4 |= v14;
        }
        else {
            v12_1 = arg40;
        }

        if((0x180000 & v15) == 0) {
            if((v0 & 0x40) == 0) {
                v14 = v4;
                v48 = v5;
                if(v3.changed(arg42)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_110;
                }
            }
            else {
                v14 = v4;
                v48 = v5;
            label_110:
                v16 = 0x80000;
            }

            v14 |= v16;
        }
        else {
            v14 = v4;
            v48 = v5;
        }

        if((v15 & 0xC00000) == 0) {
            v4_1 = arg44;
            v2 = (v0 & 0x80) != 0 || !v3.changed(v4_1) ? 0x400000 : 0x800000;
            v14 |= v2;
        }

        if((0x6000000 & v15) == 0) {
            v4_1 = arg46;
            v2 = (v0 & 0x100) != 0 || !v3.changed(v4_1) ? 0x2000000 : 0x4000000;
            v14 |= v2;
        }

        boolean v2_1 = (0x2492493 & v14) != 0x2492492 ? true : false;
        if(v3.shouldExecute(v2_1, v14 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "200@9454L5,201@9506L5,202@9556L12,203@9612L11,204@9674L18,205@9750L25");
            v4 = 0xF1FFFFFF;
            int v18 = 0xFE3FFFFF;
            int v19 = 0xFFC7FFFF;
            int v20 = 0xFFF8FFFF;
            int v21 = 0xFFFF1FFF;
            if((v15 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v48 != 0) {
                    Companion v2_3 = Modifier.Companion;
                }
                else {
                    v2_2 = v6;
                }

                boolean v17 = v7 != 0 ? false : v8;
                v7 = 6;
                if((v0 & 8) != 0) {
                    v6_1 = SnackbarDefaults.INSTANCE.getShape(v3, v7);
                    v14 &= 0xFFFFE3FF;
                }
                else {
                    v6_1 = v9_1;
                }

                if((v0 & 16) != 0) {
                    v8_1 = SnackbarDefaults.INSTANCE.getColor(v3, v7);
                    v14 &= v21;
                }
                else {
                    v8_1 = v10_1;
                }

                if((v0 & 0x20) != 0) {
                    v10_1 = SnackbarDefaults.INSTANCE.getContentColor(v3, v7);
                    v14 &= v20;
                }
                else {
                    v10_1 = v12_1;
                }

                if((v0 & 0x40) != 0) {
                    v12_1 = SnackbarDefaults.INSTANCE.getActionColor(v3, v7);
                    v14 &= v19;
                }
                else {
                    v12_1 = arg42;
                }

                v48 = v4;
                if((v0 & 0x80) != 0) {
                    v19_2 = SnackbarDefaults.INSTANCE.getActionContentColor(v3, v7);
                    v14 &= v18;
                }
                else {
                    v19_2 = arg44;
                }

                if((v0 & 0x100) != 0) {
                    v14 &= v48;
                    v23 = v10_1;
                    v25 = v19_2;
                    v27 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(v3, v7);
                    v20_1 = v6_1;
                    v21_1 = v8_1;
                }
                else {
                    v27 = arg46;
                    v21_1 = v8_1;
                    v23 = v10_1;
                    v25 = v19_2;
                    v20_1 = v6_1;
                }

                v19_1 = v17;
            }
            else {
                v3.skipToGroupEnd();
                if((v0 & 8) != 0) {
                    v14 &= 0xFFFFE3FF;
                }

                if((v0 & 16) != 0) {
                    v14 &= v21;
                }

                if((v0 & 0x20) != 0) {
                    v14 &= v20;
                }

                if((v0 & 0x40) != 0) {
                    v14 &= v19;
                }

                if((v0 & 0x80) != 0) {
                    v14 &= v18;
                }

                if((v0 & 0x100) != 0) {
                    v14 &= v4;
                }

                v25 = arg44;
                v27 = arg46;
                v2_2 = v6;
                v19_1 = v8;
                v20_1 = v9_1;
                v21_1 = v10_1;
                v23 = v12_1;
                v12_1 = arg42;
            }

            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x105E641F, v14, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:206)");
            }

            String v4_2 = v1.getVisuals().getActionLabel();
            ComposableLambda v6_2 = null;
            v7 = 54;
            if(v4_2 != null) {
                v3.startReplaceGroup(0xD86EF8D3);
                ComposerKt.sourceInformation(v3, "210@9949L268");
                ComposableLambda v4_3 = ComposableLambdaKt.rememberComposableLambda(0xADD89A81, true, new SnackbarKt$Snackbar$actionComposable$1(v12_1, v1, v4_2), v3, v7);
                v3.endReplaceGroup();
                ComposableLambda v17_1 = v4_3;
            }
            else {
                v3.startReplaceGroup(-663517017);
                v3.endReplaceGroup();
                v17_2 = ((Function2)v6_2);
            }

            if(v1.getVisuals().getWithDismissAction()) {
                v3.startReplaceGroup(0xD875DBD4);
                ComposerKt.sourceInformation(v3, "222@10401L363");
                v6_2 = ComposableLambdaKt.rememberComposableLambda(0x93F5674F, true, new SnackbarKt$Snackbar$dismissActionComposable$1(v1), v3, v7);
                v3.endReplaceGroup();
            }
            else {
                v3.startReplaceGroup(0xD87BD047);
                v3.endReplaceGroup();
            }

            v4 = v14 << 3;
            v30 = v3;
            SnackbarKt.Snackbar-eQBnUkQ(PaddingKt.padding-3ABfNKs(v2_2, Dp.constructor-impl(12f)), v17_2, v6_2, v19_1, v20_1, v21_1, v23, v25, v27, ComposableLambdaKt.rememberComposableLambda(0xB4846F7A, true, new SnackbarKt$Snackbar$3(v1), v3, v7), v30, v4 & 0x380000 | (v4 & 0x1C00 | 0x30000000 | 0xE000 & v4 | 0x70000 & v4) | 0x1C00000 & v14 | 0xE000000 & v14, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_2 = v12_1;
            v3_1 = v19_1;
            v4_4 = v20_1;
            v5_1 = v21_1;
            v7_1 = v23;
            v11 = v25;
            v13 = v27;
        }
        else {
            v30 = v3;
            v30.skipToGroupEnd();
            v2_2 = v6;
            v3_1 = v8;
            v4_4 = v9_1;
            v5_1 = v10_1;
            v7_1 = v12_1;
            v9_2 = arg42;
            v11 = arg44;
            v13 = arg46;
        }

        ScopeUpdateScope v0_1 = v30.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new SnackbarKt$$ExternalSyntheticLambda1(v1, v2_2, v3_1, v4_4, v5_1, v7_1, v9_2, v11, v13, v15, arg50));
        }
    }

    static final Unit Snackbar_eQBnUkQ$lambda$0(Modifier arg18, Function2 arg19, Function2 arg20, boolean arg21, Shape arg22, long arg23, long arg25, long arg27, long arg29, Function2 arg31, int arg32, int arg33, Composer arg34, int arg35) {
        SnackbarKt.Snackbar-eQBnUkQ(arg18, arg19, arg20, arg21, arg22, arg23, arg25, arg27, arg29, arg31, arg34, RecomposeScopeImplKt.updateChangedFlags(arg32 | 1), arg33);
        return Unit.INSTANCE;
    }

    static final Unit Snackbar_sDKtq54$lambda$1(SnackbarData arg18, Modifier arg19, boolean arg20, Shape arg21, long arg22, long arg24, long arg26, long arg28, long arg30, int arg32, int arg33, Composer arg34, int arg35) {
        SnackbarKt.Snackbar-sDKtq54(arg18, arg19, arg20, arg21, arg22, arg24, arg26, arg28, arg30, arg34, RecomposeScopeImplKt.updateChangedFlags(arg32 | 1), arg33);
        return Unit.INSTANCE;
    }

    public static final void access$NewLineButtonSnackbar-kKq0p4A(Function2 arg0, Function2 arg1, Function2 arg2, TextStyle arg3, long arg4, long arg6, Composer arg8, int arg9) {
        SnackbarKt.NewLineButtonSnackbar-kKq0p4A(arg0, arg1, arg2, arg3, arg4, arg6, arg8, arg9);
    }

    public static final void access$OneRowSnackbar-kKq0p4A(Function2 arg0, Function2 arg1, Function2 arg2, TextStyle arg3, long arg4, long arg6, Composer arg8, int arg9) {
        SnackbarKt.OneRowSnackbar-kKq0p4A(arg0, arg1, arg2, arg3, arg4, arg6, arg8, arg9);
    }

    public static final float access$getContainerMaxWidth$p() {
        return SnackbarKt.ContainerMaxWidth;
    }

    public static final float access$getHeightToFirstLine$p() {
        return SnackbarKt.HeightToFirstLine;
    }

    public static final float access$getTextEndExtraSpacing$p() {
        return SnackbarKt.TextEndExtraSpacing;
    }
}

