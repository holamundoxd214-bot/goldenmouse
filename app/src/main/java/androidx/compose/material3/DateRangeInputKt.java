package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u008F\u0001\u0010\u0000\u001A\u00020\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00032:\u0010\u0005\u001A6\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0002\u0010\u0017\"\u0010\u0010\u0018\u001A\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001A¨\u0006\u001B"}, d2={"DateRangeInputContent", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;I)V", "TextFieldSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DateRangeInputKt {
    private static final float TextFieldSpacing;

    static {
        DateRangeInputKt.TextFieldSpacing = Dp.constructor-impl(8f);
    }

    public static final void DateRangeInputContent(Long arg30, Long arg31, Function2 arg32, CalendarModel arg33, IntRange arg34, DatePickerFormatter arg35, SelectableDates arg36, DatePickerColors arg37, FocusRequester arg38, Composer arg39, int arg40) {
        Function2 v15_2;
        Composer v12_2;
        String v2_1;
        int v3_3;
        Object v4_3;
        DateInputValidator v4_4;
        int v17;
        int v16;
        SelectableDates v10_2;
        int v10;
        IntRange v7_1;
        int v7;
        int v5;
        Long v1 = arg30;
        Long v15 = arg31;
        Function2 v0 = arg32;
        CalendarModel v3 = arg33;
        DatePickerFormatter v6 = arg35;
        int v2 = arg40;
        Composer v13 = arg39.startRestartGroup(0x51D1F196);
        ComposerKt.sourceInformation(v13, "C(DateRangeInputContent)N(selectedStartDateMillis,selectedEndDateMillis,onDatesSelectionChange,calendarModel,yearRange,dateFormatter,selectableDates,colors,focusRequester)47@1831L89,48@1948L45,49@2028L44,50@2106L45,51@2180L50,53@2268L531,70@3012L2615:DateRangeInput.kt#uh7d8r");
        if((v2 & 6) == 0) {
            v5 = v13.changed(v1) ? 4 : 2;
            v5 |= v2;
        }
        else {
            v5 = v2;
        }

        if((v2 & 0x30) == 0) {
            v7 = v13.changed(v15) ? 0x20 : 16;
            v5 |= v7;
        }

        if((v2 & 0x180) == 0) {
            v7 = v13.changedInstance(v0) ? 0x100 : 0x80;
            v5 |= v7;
        }

        if((v2 & 0xC00) == 0) {
            v7 = v13.changedInstance(v3) ? 0x800 : 0x400;
            v5 |= v7;
        }

        if((v2 & 0x6000) == 0) {
            v7_1 = arg34;
            v10 = v13.changedInstance(v7_1) ? 0x4000 : 0x2000;
            v5 |= v10;
        }
        else {
            v7_1 = arg34;
        }

        int v12 = 0x40000;
        if((0x30000 & v2) == 0) {
            boolean v10_1 = (v2 & v12) == 0 ? v13.changed(v6) : v13.changedInstance(v6);
            v10 = v10_1 ? 0x20000 : 0x10000;
            v5 |= v10;
        }

        if((0x180000 & v2) == 0) {
            v10_2 = arg36;
            v16 = v13.changed(v10_2) ? 0x100000 : 0x80000;
            v5 |= v16;
        }
        else {
            v10_2 = arg36;
        }

        DatePickerColors v14 = arg37;
        if((v2 & 0xC00000) == 0) {
            v16 = v13.changed(v14) ? 0x800000 : 0x400000;
            v5 |= v16;
        }

        FocusRequester v11 = arg38;
        if((v2 & 0x6000000) == 0) {
            v17 = v13.changed(v11) ? 0x4000000 : 0x2000000;
            v5 |= v17;
        }

        boolean v8 = (v5 & 0x2492493) != 0x2492492 ? true : false;
        if(v13.shouldExecute(v8, v5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x51D1F196, v5, -1, "androidx.compose.material3.DateRangeInputContent (DateRangeInput.kt:44)");
            }

            Locale v4 = v3.getLocale();
            String v9 = "CC(remember):DateRangeInput.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v13, 622601007, v9);
            boolean v4_1 = v13.changed(v4);
            Object v8_1 = v13.rememberedValue();
            if((v4_1) || v8_1 == Composer.Companion.getEmpty()) {
                DateInputFormat v8_2 = v3.getDateInputFormat(v3.getLocale());
                v13.updateRememberedValue(v8_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            String v4_2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_input_invalid_for_pattern), v13, 0);
            int v21 = v12;
            String v12_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_input_invalid_year_range), v13, 0);
            String v22 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_input_invalid_not_allowed), v13, 0);
            String v3_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_range_input_invalid_range_input), v13, 0);
            ComposerKt.sourceInformationMarkerStart(v13, 0x251C5B89, v9);
            boolean v24 = v13.changed(v8_1);
            String v23 = v3_1;
            if((v5 & 0x70000) != 0x20000) {
                if((v5 & v21) != 0 && (v13.changed(v6))) {
                    goto label_167;
                }

                v2 = 0;
            }
            else {
            label_167:
                v2 = 1;
            }

            Object v3_2 = v13.rememberedValue();
            if(((((int)v24)) | v2) != 0 || v3_2 == Composer.Companion.getEmpty()) {
                v2_1 = v9;
                v3_3 = v5;
                v4_4 = new DateInputValidator(v7_1, v10_2, v8_1, v6, v4_2, v12_1, v22, v23);
                v8_1 = v8_1;
                v13.updateRememberedValue(v4_4);
            }
            else {
                v4_3 = v3_2;
                v3_3 = v5;
                v2_1 = v9;
            }

            Object v7_2 = v4_4;
            ComposerKt.sourceInformationMarkerEnd(v13);
            ((DateInputValidator)v7_2).setCurrentStartDateMillis(v1);
            ((DateInputValidator)v7_2).setCurrentEndDateMillis(v15);
            Modifier v4_5 = PaddingKt.padding(Modifier.Companion, DateInputKt.getInputTextFieldPadding());
            HorizontalOrVertical v5_1 = Arrangement.INSTANCE.spacedBy-0680j_4(DateRangeInputKt.TextFieldSpacing);
            ComposerKt.sourceInformationMarkerStart(v13, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy v5_2 = RowKt.rowMeasurePolicy(((Horizontal)v5_1), Alignment.Companion.getTop(), v13, 6);
            ComposerKt.sourceInformationMarkerStart(v13, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v9_1 = ComposablesKt.getCurrentCompositeKeyHash(v13, 0);
            CompositionLocalMap v6_1 = v13.getCurrentCompositionLocalMap();
            v4_5 = ComposedModifierKt.materializeModifier(v13, v4_5);
            Function0 v10_3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v13, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v13.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v13.startReusableNode();
            if(v13.getInserting()) {
                v13.createNode(v10_3);
            }
            else {
                v13.useNode();
            }

            Composer v10_4 = Updater.constructor-impl(v13);
            Updater.set-impl(v10_4, v5_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v10_4, v6_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v5_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v10_4.getInserting()) || !Intrinsics.areEqual(v10_4.rememberedValue(), Integer.valueOf(v9_1))) {
                v10_4.updateRememberedValue(Integer.valueOf(v9_1));
                v10_4.apply(Integer.valueOf(v9_1), v5_3);
            }

            Updater.set-impl(v10_4, v4_5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v13, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance v21_1 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(v13, 0x2095701, "C75@3274L56,88@3872L203,79@3468L219,86@3715L62,76@3339L1026,99@4393L54,111@4959L199,103@4585L191,109@4804L62,100@4456L1165:DateRangeInput.kt#uh7d8r");
            v4_2 = ((DateInputFormat)v8_1).getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(v4_2, "toUpperCase(...)");
            String v5_4 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_range_picker_start_headline), v13, 0);
            Modifier v9_2 = RowScope.weight$default(((RowScope)v21_1), Modifier.Companion, 0.5f, false, 2, null);
            v10 = InputIdentifier.Companion.getStartDateInput-J2x2o4M();
            Modifier v11_1 = v9_2;
            Locale v9_3 = arg33.getLocale();
            ComposerKt.sourceInformationMarkerStart(v13, 1122021, v2_1);
            v12 = v3_3 & 0x380;
            v16 = v12 == 0x100 ? 1 : 0;
            int v1_1 = v3_3 & 0x70;
            int v6_2 = v1_1 == 0x20 ? 1 : 0;
            v6_2 |= v16;
            v16 = v1_1;
            Object v1_2 = v13.rememberedValue();
            if(v6_2 != 0 || v1_2 == Composer.Companion.getEmpty()) {
                DateRangeInputKt$$ExternalSyntheticLambda0 v1_3 = new DateRangeInputKt$$ExternalSyntheticLambda0(v0, v15);
                v13.updateRememberedValue(v1_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            int v20 = 0x1B6000;
            int v15_1 = v3_3 & 0x1C00;
            v6_2 = v3_3 << 3 & 0x70 | v20 | v15_1;
            int v22_1 = v3_3 >> 21;
            int v27 = v22_1 & 14;
            String v19 = v2_1;
            String v29 = v4_2;
            int v28 = v15_1;
            v17 = v16;
            v15_1 = 0;
            v16 = v3_3;
            int v18 = v12;
            v12_2 = v13;
            DateInputKt.DateInputTextField-xJ3Ic0Y(v11_1, arg30, v1_2, arg33, ComposableLambdaKt.rememberComposableLambda(1740538748, true, new DateRangeInputKt$DateRangeInputContent$2$2(v5_4, v4_2), v13, 54), ComposableLambdaKt.rememberComposableLambda(0x4949163D, true, new DateRangeInputKt$DateRangeInputContent$2$3(v4_2), v13, 54), v10, ((DateInputValidator)v7_2), ((DateInputFormat)v8_1), v9_3, v14, arg38, v12_2, v6_2, v22_1 & 0x7E);
            Long v0_1 = arg30;
            String v1_4 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_range_picker_end_headline), v12_2, 0);
            Modifier v2_2 = RowScope.weight$default(((RowScope)v21_1), Modifier.Companion, 0.5f, false, 2, null);
            v6_2 = InputIdentifier.Companion.getEndDateInput-J2x2o4M();
            v9_3 = arg33.getLocale();
            ComposerKt.sourceInformationMarkerStart(v12_2, 1156801, v19);
            int v4_6 = v18 == 0x100 ? 1 : 0;
            if((v16 & 14) == 4) {
                v15_1 = 1;
            }

            v3_3 = v4_6 | v15_1;
            v4_3 = v12_2.rememberedValue();
            if(v3_3 != 0 || v4_3 == Composer.Companion.getEmpty()) {
                v15_2 = arg32;
                DateRangeInputKt$$ExternalSyntheticLambda1 v4_7 = new DateRangeInputKt$$ExternalSyntheticLambda1(v15_2, v0_1);
                v12_2.updateRememberedValue(v4_7);
            }
            else {
                v15_2 = arg32;
            }

            ComposerKt.sourceInformationMarkerEnd(v12_2);
            DateInputKt.DateInputTextField-xJ3Ic0Y(v2_2, arg31, v4_3, arg33, ComposableLambdaKt.rememberComposableLambda(-882370893, true, new DateRangeInputKt$DateRangeInputContent$2$5(v1_4, v29), v12_2, 54), ComposableLambdaKt.rememberComposableLambda(0x7498FD34, true, new DateRangeInputKt$DateRangeInputContent$2$6(v29), v12_2, 54), v6_2, ((DateInputValidator)v7_2), ((DateInputFormat)v8_1), v9_3, arg37, null, v12_2, v17 | v20 | v28, v27 | 0x30);
            ComposerKt.sourceInformationMarkerEnd(v12_2);
            ComposerKt.sourceInformationMarkerEnd(v12_2);
            v12_2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v12_2);
            ComposerKt.sourceInformationMarkerEnd(v12_2);
            ComposerKt.sourceInformationMarkerEnd(v12_2);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_426;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v15_2 = v0;
            v12_2 = v13;
            v12_2.skipToGroupEnd();
        }

    label_426:
        ScopeUpdateScope v11_2 = v12_2.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new DateRangeInputKt$$ExternalSyntheticLambda2(arg30, arg31, v15_2, arg33, arg34, arg35, arg36, arg37, arg38, arg40));
        }
    }

    static final Unit DateRangeInputContent$lambda$7$lambda$4$lambda$3(Function2 arg0, Long arg1, Long arg2) {
        arg0.invoke(arg2, arg1);
        return Unit.INSTANCE;
    }

    static final Unit DateRangeInputContent$lambda$7$lambda$6$lambda$5(Function2 arg0, Long arg1, Long arg2) {
        arg0.invoke(arg1, arg2);
        return Unit.INSTANCE;
    }

    static final Unit DateRangeInputContent$lambda$8(Long arg12, Long arg13, Function2 arg14, CalendarModel arg15, IntRange arg16, DatePickerFormatter arg17, SelectableDates arg18, DatePickerColors arg19, FocusRequester arg20, int arg21, Composer arg22, int arg23) {
        DateRangeInputKt.DateRangeInputContent(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg22, RecomposeScopeImplKt.updateChangedFlags(arg21 | 1));
        return Unit.INSTANCE;
    }
}

