package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\f\u0010\rJG\u0010\u000E\u001A\u00020\u00052\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0098\u0001\u0010\u000E\u001A\u00020\u00052\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00172\u0011\u0010\u0019\u001A\r\u0012\u0004\u0012\u00020\u00050\u001A¢\u0006\u0002\b\u001B2\u0011\u0010\u001C\u001A\r\u0012\u0004\u0012\u00020\u00050\u001A¢\u0006\u0002\b\u001B2\u0011\u0010\u001D\u001A\r\u0012\u0004\u0012\u00020\u00050\u001A¢\u0006\u0002\b\u001B2\n\u0010\u001E\u001A\u00060\u001Fj\u0002` H\u0003¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2={"Landroidx/compose/material3/DateRangePickerDefaults;", "", "<init>", "()V", "DateRangePickerTitle", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "modifier", "Landroidx/compose/ui/Modifier;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "DateRangePickerTitle-FNtVw6o", "(ILandroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DateRangePickerHeadline", "selectedStartDateMillis", "", "selectedEndDateMillis", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "DateRangePickerHeadline-qS89cEg", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "startDateText", "", "endDateText", "startDatePlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "endDatePlaceholder", "datesDelimiter", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateRangePickerHeadline-nZrIstQ", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;JLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Ljava/util/Locale;Landroidx/compose/runtime/Composer;II)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DateRangePickerDefaults {
    public static final int $stable;
    public static final DateRangePickerDefaults INSTANCE;

    static {
        DateRangePickerDefaults.INSTANCE = new DateRangePickerDefaults();
    }

    private DateRangePickerDefaults() {
        super();
    }

    private final void DateRangePickerHeadline-nZrIstQ(Long arg47, Long arg48, int arg49, DatePickerFormatter arg50, Modifier arg51, long arg52, String arg54, String arg55, Function2 arg56, Function2 arg57, Function2 arg58, Locale arg59, Composer arg60, int arg61, int arg62) {
        Composer v0_4;
        String v44;
        int v20;
        int v5;
        int v17;
        int v4;
        Long v1 = arg47;
        Long v6 = arg48;
        int v7 = arg49;
        DatePickerFormatter v0 = arg50;
        Modifier v8 = arg51;
        String v9 = arg54;
        String v10 = arg55;
        Function2 v11 = arg56;
        Function2 v12 = arg57;
        Function2 v13 = arg58;
        Locale v2 = arg59;
        int v15 = arg61;
        Composer v14 = arg60.startRestartGroup(1381313200);
        ComposerKt.sourceInformation(v14, "C(DateRangePickerHeadline)N(selectedStartDateMillis,selectedEndDateMillis,displayMode:c#material3.DisplayMode,dateFormatter,modifier,contentColor:c#ui.graphics.Color,startDateText,endDateText,startDatePlaceholder,endDatePlaceholder,datesDelimiter,locale)504@23527L168,502@23453L792:DateRangePicker.kt#uh7d8r");
        int v16 = 2;
        if((v15 & 6) == 0) {
            v4 = v14.changed(v1) ? 4 : v16;
            v4 |= v15;
        }
        else {
            v4 = v15;
        }

        int v18 = 0x20;
        int v19 = 16;
        if((v15 & 0x30) == 0) {
            v17 = v14.changed(v6) ? v18 : v19;
            v4 |= v17;
        }

        if((v15 & 0x180) == 0) {
            v5 = v14.changed(v7) ? 0x100 : 0x80;
            v4 |= v5;
        }

        if((v15 & 0xC00) == 0) {
            boolean v5_1 = (v15 & 0x1000) == 0 ? v14.changed(v0) : v14.changedInstance(v0);
            v5 = v5_1 ? 0x800 : 0x400;
            v4 |= v5;
        }

        if((v15 & 0x6000) == 0) {
            v5 = v14.changed(v8) ? 0x4000 : 0x2000;
            v4 |= v5;
        }

        v17 = v4;
        if((0x30000 & v15) == 0) {
            v20 = v14.changed(arg52) ? 0x20000 : 0x10000;
            v17 |= v20;
        }

        if((v15 & 0x180000) == 0) {
            v20 = v14.changed(v9) ? 0x100000 : 0x80000;
            v17 |= v20;
        }

        if((v15 & 0xC00000) == 0) {
            v20 = v14.changed(v10) ? 0x800000 : 0x400000;
            v17 |= v20;
        }

        if((v15 & 0x6000000) == 0) {
            v20 = v14.changedInstance(v11) ? 0x4000000 : 0x2000000;
            v17 |= v20;
        }

        if((v15 & 0x30000000) == 0) {
            v20 = v14.changedInstance(v12) ? 0x20000000 : 0x10000000;
            v17 |= v20;
        }

        v4 = v17;
        if((arg62 & 6) == 0) {
            v5 = v14.changedInstance(v13) ? 4 : v16;
            v5 |= arg62;
        }
        else {
            v5 = arg62;
        }

        if((arg62 & 0x30) == 0) {
            if(v14.changedInstance(v2)) {
            }
            else {
                v18 = v19;
            }

            v5 |= v18;
        }

        boolean v0_1 = (v4 & 306783379) != 306783378 || (v5 & 19) != 18 ? true : false;
        if(v14.shouldExecute(v0_1, v4 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1381313200, v4, v5, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:468)");
            }

            int v42 = v5;
            int v43 = v4;
            v0 = arg50;
            String v16_1 = DatePickerFormatter.formatDate$default(v0, v1, v2, false, 4, null);
            v6 = arg47;
            v1 = arg48;
            v2 = arg59;
            String v3 = DatePickerFormatter.formatDate$default(v0, v1, v2, false, 4, null);
            String v5_2 = v0.formatDate(v6, v2, true);
            String v4_1 = "";
            if(v5_2 == null) {
                v14.startReplaceGroup(0x25020EF7);
                ComposerKt.sourceInformation(v14, v4_1);
                if(DisplayMode.equals-impl0(v7, DisplayMode.Companion.getPicker-jFl-4v0())) {
                    v14.startReplaceGroup(0x11B5C583);
                    ComposerKt.sourceInformation(v14, "482@22593L51");
                    v44 = v3;
                    v5_2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_picker_no_selection_description), v14, 0);
                    v14.endReplaceGroup();
                }
                else {
                    v44 = v3;
                    if(DisplayMode.equals-impl0(v7, DisplayMode.Companion.getInput-jFl-4v0())) {
                        v14.startReplaceGroup(0x11B5D11E);
                        ComposerKt.sourceInformation(v14, "483@22686L46");
                        v3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_input_no_input_description), v14, 0);
                        v14.endReplaceGroup();
                        v5_2 = v3;
                    }
                    else {
                        v14.startReplaceGroup(0x25056FEE);
                        v14.endReplaceGroup();
                        v5_2 = v4_1;
                    }
                }

                v14.endReplaceGroup();
            }
            else {
                v44 = v3;
                v14.startReplaceGroup(0x11B5A72B);
                v14.endReplaceGroup();
            }

            v3 = v0.formatDate(v1, v2, true);
            if(v3 == null) {
                v14.startReplaceGroup(0x25098D17);
                ComposerKt.sourceInformation(v14, v4_1);
                if(DisplayMode.equals-impl0(v7, DisplayMode.Companion.getPicker-jFl-4v0())) {
                    v14.startReplaceGroup(0x11B60363);
                    ComposerKt.sourceInformation(v14, "494@23088L51");
                    v3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_picker_no_selection_description), v14, 0);
                    v14.endReplaceGroup();
                    goto label_235;
                }
                else if(DisplayMode.equals-impl0(v7, DisplayMode.Companion.getInput-jFl-4v0())) {
                    v14.startReplaceGroup(0x11B60EFE);
                    ComposerKt.sourceInformation(v14, "495@23181L46");
                    v3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_input_no_input_description), v14, 0);
                    v14.endReplaceGroup();
                label_235:
                    v4_1 = v3;
                }
                else {
                    v14.startReplaceGroup(0x250CEE0E);
                    v14.endReplaceGroup();
                }

                v14.endReplaceGroup();
                v3 = v4_1;
            }
            else {
                v14.startReplaceGroup(0x11B5E549);
                v14.endReplaceGroup();
            }

            v4_1 = v9 + ": " + v5_2;
            String v0_2 = v10 + ": " + v3;
            ComposerKt.sourceInformationMarkerStart(v14, 0x11B63AB8, "CC(remember):DateRangePicker.kt#9igjgp");
            int v3_1 = v14.changed(v4_1) | v14.changed(v0_2);
            Object v5_3 = v14.rememberedValue();
            if(v3_1 != 0 || v5_3 == Composer.Companion.getEmpty()) {
                DateRangePickerDefaults$$ExternalSyntheticLambda0 v5_4 = new DateRangePickerDefaults$$ExternalSyntheticLambda0(v4_1, v0_2);
                v14.updateRememberedValue(v5_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            Modifier v0_3 = SemanticsModifierKt.clearAndSetSemantics(v8, ((Function1)v5_3));
            Vertical v3_2 = Alignment.Companion.getCenterVertically();
            HorizontalOrVertical v4_2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4f));
            ComposerKt.sourceInformationMarkerStart(v14, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy v1_1 = RowKt.rowMeasurePolicy(((Horizontal)v4_2), v3_2, v14, 54);
            ComposerKt.sourceInformationMarkerStart(v14, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v3_1 = ComposablesKt.getCurrentCompositeKeyHash(v14, 0);
            CompositionLocalMap v4_3 = v14.getCurrentCompositionLocalMap();
            v0_3 = ComposedModifierKt.materializeModifier(v14, v0_3);
            Function0 v5_5 = ComposeUiNode.Companion.getConstructor();
            int v60 = v3_1;
            ComposerKt.sourceInformationMarkerStart(v14, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v14.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v14.startReusableNode();
            if(v14.getInserting()) {
                v14.createNode(v5_5);
            }
            else {
                v14.useNode();
            }

            Composer v2_1 = Updater.constructor-impl(v14);
            Updater.set-impl(v2_1, v1_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v2_1, v4_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v1_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v2_1.getInserting()) || !Intrinsics.areEqual(v2_1.rememberedValue(), Integer.valueOf(v60))) {
                v2_1.updateRememberedValue(Integer.valueOf(v60));
                v2_1.apply(Integer.valueOf(v60), v1_2);
            }

            Updater.set-impl(v2_1, v0_3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v14, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v14, 0xF56CF4E9, "C516@24035L16:DateRangePicker.kt#uh7d8r");
            if(v16_1 != null) {
                v14.startReplaceGroup(0xF56D4BF9);
                ComposerKt.sourceInformation(v14, "512@23895L53");
                TextKt.Text-Nvy7gAk(v16_1, null, arg52, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, v14, v43 >> 9 & 0x380, 0, 0x3FFFA);
                v0_4 = v14;
                v0_4.endReplaceGroup();
            }
            else {
                v0_4 = v14;
                v0_4.startReplaceGroup(0xF56EA8D8);
                ComposerKt.sourceInformation(v0_4, "514@23986L22");
                v11.invoke(v0_4, Integer.valueOf(v43 >> 24 & 14));
                v0_4.endReplaceGroup();
            }

            v13.invoke(v0_4, Integer.valueOf(v42 & 14));
            if(v44 != null) {
                v0_4.startReplaceGroup(0xF570949B);
                ComposerKt.sourceInformation(v0_4, "518@24112L51");
                TextKt.Text-Nvy7gAk(v44, null, arg52, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, v0_4, v43 >> 9 & 0x380, 0, 0x3FFFA);
                v0_4.endReplaceGroup();
            }
            else {
                v0_4.startReplaceGroup(-177083974);
                ComposerKt.sourceInformation(v0_4, "520@24201L20");
                v12.invoke(v0_4, Integer.valueOf(v43 >> 27 & 14));
                v0_4.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v0_4);
            ComposerKt.sourceInformationMarkerEnd(v0_4);
            v0_4.endNode();
            ComposerKt.sourceInformationMarkerEnd(v0_4);
            ComposerKt.sourceInformationMarkerEnd(v0_4);
            ComposerKt.sourceInformationMarkerEnd(v0_4);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_452;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v6 = v1;
            v0_4 = v14;
            v0_4.skipToGroupEnd();
        }

    label_452:
        ScopeUpdateScope v0_5 = v0_4.endRestartGroup();
        if(v0_5 != null) {
            v0_5.updateScope(new DateRangePickerDefaults$$ExternalSyntheticLambda1(this, v6, arg48, v7, arg50, v8, arg52, v9, v10, v11, v12, v13, arg59, v15, arg62));
        }
    }

    public final void DateRangePickerHeadline-qS89cEg(Long arg18, Long arg19, int arg20, DatePickerFormatter arg21, Modifier arg22, long arg23, Composer arg25, int arg26, int arg27) {
        Modifier v6_2;
        long v7_4;
        Modifier v7_2;
        DateRangePickerDefaults v11_1;
        int v11;
        long v9_1;
        Modifier v8;
        int v7;
        int v6;
        Long v4;
        Long v2;
        int v3;
        DatePickerFormatter v5 = arg21;
        int v0 = arg26;
        int v1 = 0x62A8C6F7;
        Composer v14 = arg25.startRestartGroup(v1);
        ComposerKt.sourceInformation(v14, "C(DateRangePickerHeadline)N(selectedStartDateMillis,selectedEndDateMillis,displayMode:c#material3.DisplayMode,dateFormatter,modifier,contentColor:c#ui.graphics.Color)410@19016L47,411@19090L45,421@19564L52,422@19651L50,423@19732L42,424@19797L15,412@19144L679:DateRangePicker.kt#uh7d8r");
        if((arg27 & 1) != 0) {
            v3 = v0 | 6;
            v2 = arg18;
        }
        else if((v0 & 6) == 0) {
            v2 = arg18;
            v3 = v14.changed(v2) ? 4 : 2;
            v3 |= v0;
        }
        else {
            v2 = arg18;
            v3 = v0;
        }

        if((arg27 & 2) != 0) {
            v3 |= 0x30;
            goto label_39;
        }
        else if((v0 & 0x30) == 0) {
            v4 = arg19;
            v6 = v14.changed(v4) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_39:
            v4 = arg19;
        }

        if((arg27 & 4) != 0) {
            v3 |= 0x180;
            goto label_54;
        }
        else if((v0 & 0x180) == 0) {
            v6 = arg20;
            v7 = v14.changed(v6) ? 0x100 : 0x80;
            v3 |= v7;
        }
        else {
        label_54:
            v6 = arg20;
        }

        if((arg27 & 8) != 0) {
            v3 |= 0xC00;
        }
        else if((v0 & 0xC00) == 0) {
            boolean v7_1 = (v0 & 0x1000) == 0 ? v14.changed(v5) : v14.changedInstance(v5);
            v7 = v7_1 ? 0x800 : 0x400;
            v3 |= v7;
        }

        v7 = arg27 & 16;
        if(v7 != 0) {
            v3 |= 0x6000;
            goto label_85;
        }
        else if((v0 & 0x6000) == 0) {
            v8 = arg22;
            int v9 = v14.changed(v8) ? 0x4000 : 0x2000;
            v3 |= v9;
        }
        else {
        label_85:
            v8 = arg22;
        }

        if((0x30000 & v0) == 0) {
            if((arg27 & 0x20) == 0) {
                v9_1 = arg23;
                if(v14.changed(v9_1)) {
                    v11 = 0x20000;
                }
                else {
                    goto label_97;
                }
            }
            else {
                v9_1 = arg23;
            label_97:
                v11 = 0x10000;
            }

            v3 |= v11;
        }
        else {
            v9_1 = arg23;
        }

        int v12 = 0x180000;
        if((arg27 & 0x40) != 0) {
            v3 |= v12;
            goto label_116;
        }
        else if((v0 & v12) == 0) {
            v11_1 = this;
            v12 = v14.changed(v11_1) ? 0x100000 : 0x80000;
            v3 |= v12;
        }
        else {
        label_116:
            v11_1 = this;
        }

        boolean v12_1 = (0x92493 & v3) != 0x92492 ? true : false;
        if(v14.shouldExecute(v12_1, v3 & 1)) {
            v14.startDefaults();
            ComposerKt.sourceInformation(v14, "408@18949L8");
            int v16 = 0xFFF8FFFF;
            int v13 = 6;
            if((v0 & 1) == 0 || (v14.getDefaultsInvalid())) {
                if(v7 != 0) {
                    Companion v7_3 = Modifier.Companion;
                }
                else {
                    v7_2 = v8;
                }

                if((arg27 & 0x20) == 0) {
                    goto label_155;
                }

                v3 &= v16;
                v9_1 = DatePickerDefaults.INSTANCE.colors(v14, v13).getHeadlineContentColor-0d7_KjU();
            }
            else {
                v14.skipToGroupEnd();
                if((arg27 & 0x20) != 0) {
                    v3 &= v16;
                }

                v7_2 = v8;
            }

        label_155:
            v14.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1, v3, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:409)");
            }

            String v1_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_range_picker_start_headline), v14, 0);
            String v12_2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_range_picker_end_headline), v14, 0);
            ComposableLambda v8_1 = ComposableLambdaKt.rememberComposableLambda(850203865, true, new DateRangePickerDefaults$DateRangePickerHeadline$1(v1_1, v9_1), v14, 54);
            String v22 = v1_1;
            int v15 = 0x70000 & v3 | (v3 & 14 | 0x36000000 | v3 & 0x70 | v3 & 0x380 | v3 & 0x1C00 | 0xE000 & v3);
            v16 = v3 >> 12 & 0x380 | 6;
            Long v1_2 = v2;
            v2 = v4;
            DatePickerFormatter v4_1 = v5;
            v3 = v6;
            Modifier v5_1 = v7_2;
            long v6_1 = v9_1;
            v11_1.DateRangePickerHeadline-nZrIstQ(v1_2, v2, v3, v4_1, v5_1, v6_1, v22, v12_2, v8_1, ComposableLambdaKt.rememberComposableLambda(0x10D2835A, true, new DateRangePickerDefaults$DateRangePickerHeadline$2(v12_2, v9_1), v14, 54), ComposableLambdaKt.rememberComposableLambda(-320655704, true, new DateRangePickerDefaults$DateRangePickerHeadline$3(v9_1), v14, 54), CalendarLocale_androidKt.defaultLocale(v14, 0), v14, v15, v16);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_4 = v6_1;
            v6_2 = v5_1;
        }
        else {
            v14.skipToGroupEnd();
            v6_2 = v8;
            v7_4 = v9_1;
        }

        ScopeUpdateScope v11_2 = v14.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new DateRangePickerDefaults$$ExternalSyntheticLambda3(this, arg18, arg19, arg20, arg21, v6_2, v7_4, arg26, arg27));
        }
    }

    static final Unit DateRangePickerHeadline_nZrIstQ$lambda$3$lambda$2(String arg1, String arg2, SemanticsPropertyReceiver arg3) {
        SemanticsPropertiesKt.setLiveRegion-hR3wRGc(arg3, LiveRegionMode.Companion.getPolite-0phEisY());
        SemanticsPropertiesKt.setContentDescription(arg3, arg1 + ", " + arg2);
        return Unit.INSTANCE;
    }

    static final Unit DateRangePickerHeadline_nZrIstQ$lambda$5(DateRangePickerDefaults arg18, Long arg19, Long arg20, int arg21, DatePickerFormatter arg22, Modifier arg23, long arg24, String arg26, String arg27, Function2 arg28, Function2 arg29, Function2 arg30, Locale arg31, int arg32, int arg33, Composer arg34, int arg35) {
        arg18.DateRangePickerHeadline-nZrIstQ(arg19, arg20, arg21, arg22, arg23, arg24, arg26, arg27, arg28, arg29, arg30, arg31, arg34, RecomposeScopeImplKt.updateChangedFlags(arg32 | 1), RecomposeScopeImplKt.updateChangedFlags(arg33));
        return Unit.INSTANCE;
    }

    static final Unit DateRangePickerHeadline_qS89cEg$lambda$1(DateRangePickerDefaults arg12, Long arg13, Long arg14, int arg15, DatePickerFormatter arg16, Modifier arg17, long arg18, int arg20, int arg21, Composer arg22, int arg23) {
        arg12.DateRangePickerHeadline-qS89cEg(arg13, arg14, arg15, arg16, arg17, arg18, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    public final void DateRangePickerTitle-FNtVw6o(int arg34, Modifier arg35, long arg36, Composer arg38, int arg39, int arg40) {
        long v4_3;
        Modifier v3_1;
        Composer v0_1;
        Modifier v8;
        long v9_2;
        Companion v4_1;
        int v9;
        long v7_1;
        Modifier v5;
        int v3;
        int v2 = arg34;
        int v6 = arg39;
        int v0 = 0x29682CF3;
        Composer v1 = arg38.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(DateRangePickerTitle)N(displayMode:c#material3.DisplayMode,modifier,contentColor:c#ui.graphics.Color):DateRangePicker.kt#uh7d8r");
        if((arg40 & 1) != 0) {
            v3 = v6 | 6;
        }
        else if((v6 & 6) == 0) {
            v3 = v1.changed(v2) ? 4 : 2;
            v3 |= v6;
        }
        else {
            v3 = v6;
        }

        int v4 = arg40 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_35;
        }
        else if((v6 & 0x30) == 0) {
            v5 = arg35;
            int v7 = v1.changed(v5) ? 0x20 : 16;
            v3 |= v7;
        }
        else {
        label_35:
            v5 = arg35;
        }

        if((v6 & 0x180) == 0) {
            if((arg40 & 4) == 0) {
                v7_1 = arg36;
                if(v1.changed(v7_1)) {
                    v9 = 0x100;
                }
                else {
                    goto label_46;
                }
            }
            else {
                v7_1 = arg36;
            label_46:
                v9 = 0x80;
            }

            v3 |= v9;
        }
        else {
            v7_1 = arg36;
        }

        boolean v9_1 = (v3 & 0x93) != 0x92 ? true : false;
        if(v1.shouldExecute(v9_1, v3 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "370@17337L8");
            if((v6 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v4_1 = Modifier.Companion;
                }
                else {
                    Modifier v4_2 = v5;
                }

                if((arg40 & 4) != 0) {
                    v7_1 = DatePickerDefaults.INSTANCE.colors(v1, 6).getTitleContentColor-0d7_KjU();
                    v3 &= -897;
                }

                v9_2 = v7_1;
                Companion v8_1 = v4_1;
            }
            else {
                v1.skipToGroupEnd();
                if((arg40 & 4) != 0) {
                    v3 &= -897;
                }

                v9_2 = v7_1;
                v8 = v5;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:371)");
            }

            if(DisplayMode.equals-impl0(v2, DisplayMode.Companion.getPicker-jFl-4v0())) {
                v1.startReplaceGroup(0x7010DFC3);
                ComposerKt.sourceInformation(v1, "375@17478L48,374@17452L176");
                TextKt.Text-Nvy7gAk(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_range_picker_title), v1, 0), v8, v9_2, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, v1, v3 & 0x3F0, 0, 0x3FFF8);
                v0_1 = v1;
                v0_1.endReplaceGroup();
            }
            else {
                v0_1 = v1;
                if(DisplayMode.equals-impl0(v2, DisplayMode.Companion.getInput-jFl-4v0())) {
                    v0_1.startReplaceGroup(0x7010FC02);
                    ComposerKt.sourceInformation(v0_1, "381@17704L47,380@17678L175");
                    TextKt.Text-Nvy7gAk(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_range_input_title), v0_1, 0), v8, v9_2, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, null, v0_1, v3 & 0x3F0, 0, 0x3FFF8);
                    v0_1.endReplaceGroup();
                }
                else {
                    v0_1.startReplaceGroup(-1844364305);
                    v0_1.endReplaceGroup();
                }
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = v8;
            v4_3 = v9_2;
        }
        else {
            v0_1 = v1;
            v0_1.skipToGroupEnd();
            v3_1 = v5;
            v4_3 = v7_1;
        }

        ScopeUpdateScope v8_2 = v0_1.endRestartGroup();
        if(v8_2 != null) {
            v8_2.updateScope(new DateRangePickerDefaults$$ExternalSyntheticLambda2(this, v2, v3_1, v4_3, v6, arg40));
        }
    }

    static final Unit DateRangePickerTitle_FNtVw6o$lambda$0(DateRangePickerDefaults arg8, int arg9, Modifier arg10, long arg11, int arg13, int arg14, Composer arg15, int arg16) {
        arg8.DateRangePickerTitle-FNtVw6o(arg9, arg10, arg11, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }
}

