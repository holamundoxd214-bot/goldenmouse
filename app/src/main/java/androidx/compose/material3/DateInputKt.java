package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001An\u0010\u0000\u001A\u00020\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u00032#\u0010\u0004\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0002\u0010\u0015\u001A\u009F\u0001\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u00032\u0014\u0010\u0004\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\t\u001A\u00020\n2\u0013\u0010\u001A\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001B¢\u0006\u0002\b\u001C2\u0013\u0010\u001D\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001B¢\u0006\u0002\b\u001C2\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#2\n\u0010$\u001A\u00060%j\u0002`&2\u0006\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\'\u0010(\"\u0014\u0010)\u001A\u00020*X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b+\u0010,\"\u0010\u0010-\u001A\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u00060²\u0006\n\u00101\u001A\u000202X\u008A\u008E\u0002"}, d2={"DateInputContent", "", "selectedDateMillis", "", "onDateSelectionChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dateInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;I)V", "DateInputTextField", "modifier", "Landroidx/compose/ui/Modifier;", "initialDateMillis", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "dateInputValidator", "Landroidx/compose/material3/DateInputValidator;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateInputTextField-xJ3Ic0Y", "(Landroidx/compose/ui/Modifier;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/material3/DateInputValidator;Landroidx/compose/material3/internal/DateInputFormat;Ljava/util/Locale;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "InputTextFieldPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getInputTextFieldPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "InputTextNonErroneousBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "material3", "text", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DateInputKt {
    private static final PaddingValues InputTextFieldPadding;
    private static final float InputTextNonErroneousBottomPadding;

    static {
        DateInputKt.InputTextFieldPadding = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl(24f), Dp.constructor-impl(10f), Dp.constructor-impl(24f), 0f, 8, null);
        DateInputKt.InputTextNonErroneousBottomPadding = Dp.constructor-impl(16f);
    }

    public static final void DateInputContent(Long arg19, Function1 arg20, CalendarModel arg21, IntRange arg22, DatePickerFormatter arg23, SelectableDates arg24, DatePickerColors arg25, FocusRequester arg26, Composer arg27, int arg28) {
        Composer v12_3;
        int v3_2;
        DateInputValidator v12_2;
        int v0;
        int v10;
        SelectableDates v6_2;
        int v6;
        IntRange v5_1;
        int v5;
        int v4;
        Long v1 = arg19;
        CalendarModel v3 = arg21;
        DatePickerFormatter v8 = arg23;
        int v15 = arg28;
        Composer v2 = arg27.startRestartGroup(0xE63AFEFD);
        ComposerKt.sourceInformation(v2, "C(DateInputContent)N(selectedDateMillis,onDateSelectionChange,calendarModel,yearRange,dateFormatter,selectableDates,colors,focusRequester)70@2926L89,71@3043L45,72@3123L44,73@3201L45,75@3284L552,88@3925L42,92@4122L165,98@4311L62,89@3972L951:DateInput.kt#uh7d8r");
        if((v15 & 6) == 0) {
            v4 = v2.changed(v1) ? 4 : 2;
            v4 |= v15;
        }
        else {
            v4 = v15;
        }

        Function1 v13 = arg20;
        if((v15 & 0x30) == 0) {
            v5 = v2.changedInstance(v13) ? 0x20 : 16;
            v4 |= v5;
        }

        if((v15 & 0x180) == 0) {
            v5 = v2.changedInstance(v3) ? 0x100 : 0x80;
            v4 |= v5;
        }

        if((v15 & 0xC00) == 0) {
            v5_1 = arg22;
            v6 = v2.changedInstance(v5_1) ? 0x800 : 0x400;
            v4 |= v6;
        }
        else {
            v5_1 = arg22;
        }

        int v9 = 0x8000;
        if((v15 & 0x6000) == 0) {
            boolean v6_1 = (v15 & v9) == 0 ? v2.changed(v8) : v2.changedInstance(v8);
            v6 = v6_1 ? 0x4000 : 0x2000;
            v4 |= v6;
        }

        if((0x30000 & v15) == 0) {
            v6_2 = arg24;
            v10 = v2.changed(v6_2) ? 0x20000 : 0x10000;
            v4 |= v10;
        }
        else {
            v6_2 = arg24;
        }

        DatePickerColors v14 = arg25;
        if((0x180000 & v15) == 0) {
            v10 = v2.changed(v14) ? 0x100000 : 0x80000;
            v4 |= v10;
        }

        if((0xC00000 & v15) == 0) {
            int v11 = v2.changed(arg26) ? 0x800000 : 0x400000;
            v4 |= v11;
        }

        boolean v11_1 = (0x492493 & v4) != 4793490 ? true : false;
        if(v2.shouldExecute(v11_1, v4 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xE63AFEFD, v4, -1, "androidx.compose.material3.DateInputContent (DateInput.kt:67)");
            }

            Locale v7 = v3.getLocale();
            String v12 = "CC(remember):DateInput.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v2, 0x43776A16, v12);
            boolean v7_1 = v2.changed(v7);
            Object v11_2 = v2.rememberedValue();
            if((v7_1) || v11_2 == Composer.Companion.getEmpty()) {
                DateInputFormat v11_3 = v3.getDateInputFormat(v3.getLocale());
                v2.updateRememberedValue(v11_3);
            }

            Object v7_2 = v11_2;
            ComposerKt.sourceInformationMarkerEnd(v2);
            String v11_4 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_input_invalid_for_pattern), v2, 0);
            int v17 = v9;
            String v9_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_input_invalid_year_range), v2, 0);
            String v3_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_input_invalid_not_allowed), v2, 0);
            ComposerKt.sourceInformationMarkerStart(v2, 0x437798A5, v12);
            boolean v18 = v2.changed(v7_2);
            if((0xE000 & v4) != 0x4000) {
                if((v4 & v17) != 0 && (v2.changed(v8))) {
                    goto label_154;
                }

                v0 = 0;
            }
            else {
            label_154:
                v0 = 1;
            }

            Object v12_1 = v2.rememberedValue();
            if(((((int)v18)) | v0) != 0 || v12_1 == Composer.Companion.getEmpty()) {
                v0 = v4;
                String v10_1 = v9_1;
                v9_1 = v11_4;
                v11_4 = v3_1;
                v3_2 = 1;
                DateInputValidator v4_1 = new DateInputValidator(v5_1, v6_2, ((DateInputFormat)v7_2), v8, v9_1, v10_1, v11_4, "");
                v2.updateRememberedValue(v4_1);
                v12_2 = v4_1;
            }
            else {
                v0 = v4;
                v3_2 = 1;
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            String v4_2 = ((DateInputFormat)v7_2).getPatternWithDelimiters().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(v4_2, "toUpperCase(...)");
            String v5_2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_date_input_label), v2, 0);
            Modifier v6_3 = PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0f, v3_2, null), DateInputKt.InputTextFieldPadding);
            int v8_1 = InputIdentifier.Companion.getSingleDateInput-J2x2o4M();
            v12_2.setCurrentStartDateMillis(v1);
            Locale v9_2 = arg21.getLocale();
            ComposableLambda v5_3 = ComposableLambdaKt.rememberComposableLambda(0xD32AE13B, ((boolean)v3_2), new DateInputKt$DateInputContent$2(v5_2, v4_2), v2, 54);
            ComposableLambda v3_3 = ComposableLambdaKt.rememberComposableLambda(0xB9B342DA, ((boolean)v3_2), new DateInputKt$DateInputContent$3(v4_2), v2, 54);
            v4 = v0 << 3;
            DatePickerColors v10_2 = v14;
            int v14_1 = v0 >> 18 & 0x7E;
            Modifier v0_1 = v6_3;
            v6 = v8_1;
            Object v8_2 = v7_2;
            v7_2 = v12_2;
            v12_3 = v2;
            DateInputKt.DateInputTextField-xJ3Ic0Y(v0_1, v1, v13, arg21, v5_3, v3_3, v6, ((DateInputValidator)v7_2), ((DateInputFormat)v8_2), v9_2, v10_2, arg26, v12_3, v4 & 0x1C00 | (v4 & 0x70 | 0x1B6006 | v4 & 0x380), v14_1);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_235;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v12_3 = v2;
            v12_3.skipToGroupEnd();
        }

    label_235:
        ScopeUpdateScope v10_3 = v12_3.endRestartGroup();
        if(v10_3 != null) {
            v10_3.updateScope(new DateInputKt$$ExternalSyntheticLambda0(arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, v15));
        }
    }

    static final Unit DateInputContent$lambda$3(Long arg11, Function1 arg12, CalendarModel arg13, IntRange arg14, DatePickerFormatter arg15, SelectableDates arg16, DatePickerColors arg17, FocusRequester arg18, int arg19, Composer arg20, int arg21) {
        DateInputKt.DateInputContent(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg20, RecomposeScopeImplKt.updateChangedFlags(arg19 | 1));
        return Unit.INSTANCE;
    }

    public static final void DateInputTextField-xJ3Ic0Y(Modifier arg43, Long arg44, Function1 arg45, CalendarModel arg46, Function2 arg47, Function2 arg48, int arg49, DateInputValidator arg50, DateInputFormat arg51, Locale arg52, DatePickerColors arg53, FocusRequester arg54, Composer arg55, int arg56, int arg57) {
        DateInputKt$DateInputTextField$5$1 v0_5;
        Composer v8_2;
        Modifier v7_3;
        DateInputKt$$ExternalSyntheticLambda4 v2_6;
        float v2_3;
        int v10_2;
        MutableState v5_1;
        DateInputKt$$ExternalSyntheticLambda2 v2_2;
        DateInputKt$$ExternalSyntheticLambda1 v1_2;
        int v18;
        int v21;
        int v17;
        int v16;
        int v2;
        Long v1 = arg44;
        CalendarModel v4 = arg46;
        DateInputFormat v3 = arg51;
        Locale v6 = arg52;
        FocusRequester v12 = arg54;
        int v13 = arg56;
        Composer v11 = arg55.startRestartGroup(1456309913);
        ComposerKt.sourceInformation(v11, "C(DateInputTextField)N(modifier,initialDateMillis,onDateSelectionChange,calendarModel,label,placeholder,inputIdentifier:c#material3.InputIdentifier,dateInputValidator,dateInputFormat,locale,colors,focusRequester)130@5481L36,130@5429L88,132@5569L715,132@5546L738,164@6980L1604,205@8702L60,215@9086L59,162@6915L2641,228@9583L297,228@9562L318,237@9920L727,237@9886L761:DateInput.kt#uh7d8r");
        Modifier v14 = arg43;
        if((v13 & 6) == 0) {
            v2 = v11.changed(v14) ? 4 : 2;
            v2 |= v13;
        }
        else {
            v2 = v13;
        }

        if((v13 & 0x30) == 0) {
            int v8 = v11.changed(v1) ? 0x20 : 16;
            v2 |= v8;
        }

        if((v13 & 0x180) == 0) {
            v16 = v11.changedInstance(arg45) ? 0x100 : 0x80;
            v2 |= v16;
        }

        if((v13 & 0xC00) == 0) {
            int v5 = v11.changedInstance(v4) ? 0x800 : 0x400;
            v2 |= v5;
        }

        if((v13 & 0x6000) == 0) {
            v16 = v11.changedInstance(arg47) ? 0x4000 : 0x2000;
            v2 |= v16;
        }

        Function2 v15 = arg48;
        if((v13 & 0x30000) == 0) {
            v17 = v11.changedInstance(v15) ? 0x20000 : 0x10000;
            v2 |= v17;
        }

        int v7 = arg49;
        if((v13 & 0x180000) == 0) {
            int v19 = v11.changed(v7) ? 0x100000 : 0x80000;
            v2 |= v19;
        }

        DateInputValidator v9 = arg50;
        if((v13 & 0xC00000) == 0) {
            v21 = v11.changed(v9) ? 0x800000 : 0x400000;
            v2 |= v21;
        }

        if((v13 & 0x6000000) == 0) {
            v21 = v11.changed(v3) ? 0x4000000 : 0x2000000;
            v2 |= v21;
        }

        if((v13 & 0x30000000) == 0) {
            v21 = v11.changedInstance(v6) ? 0x20000000 : 0x10000000;
            v2 |= v21;
        }

        DatePickerColors v15_1 = arg53;
        if((arg57 & 6) == 0) {
            v17 = v11.changed(v15_1) ? 4 : 2;
            v17 |= arg57;
        }
        else {
            v17 = arg57;
        }

        if((arg57 & 0x30) == 0) {
            v18 = v11.changed(v12) ? 0x20 : 16;
            v17 |= v18;
        }

        int v15_2 = v17;
        boolean v0 = (v2 & 306783379) != 306783378 || (v15_2 & 19) != 18 ? true : false;
        if(v11.shouldExecute(v0, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1456309913, v2, v15_2, "androidx.compose.material3.DateInputTextField (DateInput.kt:128)");
            }

            Object[] v10 = new Object[0];
            Saver v0_1 = TextFieldValue.Companion.getSaver();
            v17 = v15_2;
            String v15_3 = "CC(remember):DateInput.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v11, 0xD98689BD, v15_3);
            Object v1_1 = v11.rememberedValue();
            int v22 = v2;
            if(v1_1 == Composer.Companion.getEmpty()) {
                v1_2 = new DateInputKt$$ExternalSyntheticLambda1();
                v11.updateRememberedValue(v1_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            MutableState v10_1 = RememberSaveableKt.rememberSaveable(v10, v0_1, ((Function0)v1_2), v11, 0x180);
            Object[] v0_2 = new Object[]{DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$6(v10_1)};
            ComposerKt.sourceInformationMarkerStart(v11, -645490844, v15_3);
            v2 = v22 & 0x1C00000;
            boolean v18_1 = v11.changed(v10_1);
            int v1_3 = v2 == 0x800000 ? 1 : 0;
            int v23 = (((int)v18_1)) | v1_3 | v11.changedInstance(v4);
            v1_3 = v22 & 0xE000000;
            v18 = v2;
            v2 = v1_3 == 0x4000000 ? 1 : 0;
            int v9_1 = v22 & 0x380000;
            v23 = v23 | v2 | v11.changedInstance(v6);
            v2 = v9_1 == 0x100000 ? 1 : 0;
            v23 |= v2;
            Object v2_1 = v11.rememberedValue();
            if(v23 != 0 || v2_1 == Composer.Companion.getEmpty()) {
                MutableState v8_1 = v10_1;
                v13 = v18;
                v10_2 = v22;
                v2_2 = new DateInputKt$$ExternalSyntheticLambda2(arg50, v4, arg51, v6, v7, v8_1);
                v5_1 = v8_1;
                v11.updateRememberedValue(v2_2);
            }
            else {
                v5_1 = v10_1;
                v13 = v18;
                v10_2 = v22;
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            Object v0_3 = RememberSaveableKt.rememberSaveable(v0_2, ((Function0)v2_2), v11, 0);
            if(StringsKt.isBlank(((MutableState)v0_3).getValue())) {
                v2_3 = DateInputKt.InputTextNonErroneousBottomPadding;
            }
            else {
                PaddingValues v2_4 = TextFieldDefaults.supportingTextPadding-a9UjIt4$material3$default(TextFieldDefaults.INSTANCE, 0f, 0f, 0f, 0f, 15, null);
                v2_3 = Dp.constructor-impl(DateInputKt.InputTextNonErroneousBottomPadding - Dp.constructor-impl(v2_4.calculateBottomPadding-D9Ej5fM() + v2_4.calculateTopPadding-D9Ej5fM()));
            }

            float v18_2 = v2_3;
            TextFieldValue v22_1 = DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$6(v5_1);
            ComposerKt.sourceInformationMarkerStart(v11, -645444803, v15_3);
            v2 = 0x4000000;
            int v3_1 = v1_3 == v2 ? 1 : 0;
            v3_1 = v3_1 | v11.changed(v5_1) | v11.changed(v0_3);
            v7 = (v10_2 & 0x380) == 0x100 ? 1 : 0;
            v3_1 = v3_1 | v7 | v11.changedInstance(v4) | v11.changedInstance(v6);
            v7 = v13 == 0x800000 ? 1 : 0;
            v3_1 |= v7;
            v7 = v9_1 == 0x100000 ? 1 : 0;
            v3_1 |= v7;
            Object v7_1 = v11.rememberedValue();
            if(v3_1 != 0 || v7_1 == Composer.Companion.getEmpty()) {
                v3 = arg51;
                v13 = v10_2;
                DateInputKt$$ExternalSyntheticLambda3 v2_5 = new DateInputKt$$ExternalSyntheticLambda3(v3, v0_3, arg45, v4, v6, arg50, arg49, v5_1);
                v4 = v4;
                v6 = v6;
                v5_1 = v5_1;
                v11.updateRememberedValue(v2_5);
                DateInputKt$$ExternalSyntheticLambda3 v7_2 = v2_5;
            }
            else {
                v3 = arg51;
                v13 = v10_2;
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            v9_1 = v17;
            String v10_3 = v15_3;
            Modifier v15_4 = PaddingKt.padding-qDBjuR0$default(v14, 0f, 0f, 0f, v18_2, 7, null);
            ComposerKt.sourceInformationMarkerStart(v11, 0xD9881C75, v10_3);
            boolean v14_1 = v11.changed(v0_3);
            v2_1 = v11.rememberedValue();
            if((v14_1) || v2_1 == Composer.Companion.getEmpty()) {
                v2_6 = new DateInputKt$$ExternalSyntheticLambda4(((MutableState)v0_3));
                v11.updateRememberedValue(v2_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            Object v14_2 = null;
            Object v16_1 = v7_1;
            Modifier v2_7 = SemanticsModifierKt.semantics$default(v15_4, false, ((Function1)v2_6), 1, v14_2);
            if(v12 != null) {
                v7_3 = FocusRequesterModifierKt.focusRequester(Modifier.Companion, v12);
            }
            else {
                Companion v7_4 = Modifier.Companion;
            }

            v2_7 = v2_7.then(v7_3);
            Continuation v7_5 = ((Continuation)v14_2);
            OutlinedTextFieldKt.OutlinedTextField(v22_1, v16_1, v2_7, false, false, null, arg47, arg48, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(0xEAAB2812, true, new DateInputKt$DateInputTextField$3(((MutableState)v0_3)), v11, 54), StringsKt.isBlank(v0_3.getValue()) ^ 1, new DateVisualTransformation(v3), new KeyboardOptions(0, Boolean.valueOf(false), KeyboardType.Companion.getNumber-PjHm6EE(), ImeAction.Companion.getDone-eUduSuo(), null, null, null, 0x71, null), null, true, 0, 0, null, null, arg53.getDateTextFieldColors(), v11, v13 << 6 & 0x1F80000, 0xC30180, 0, 0x3D0F38);
            v8_2 = v11;
            Unit v2_8 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(v8_2, 0xD9888B82, v10_3);
            v9_1 = (v9_1 & 0x70) == 0x20 ? 1 : 0;
            Object v11_1 = v8_2.rememberedValue();
            if(v9_1 != 0 || v11_1 == Composer.Companion.getEmpty()) {
                DateInputKt$DateInputTextField$4$1 v11_2 = new DateInputKt$DateInputTextField$4$1(v12, v7_5);
                v8_2.updateRememberedValue(v11_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8_2);
            EffectsKt.LaunchedEffect(v2_8, ((Function2)v11_1), v8_2, 6);
            ComposerKt.sourceInformationMarkerStart(v8_2, -645351600, v10_3);
            v2 = (v13 & 0x70) == 0x20 ? 1 : 0;
            v2 |= v8_2.changedInstance(v4);
            v1_3 = v1_3 == 0x4000000 ? 1 : 0;
            int v0_4 = v2 | v1_3 | v8_2.changedInstance(v6) | v8_2.changed(v5_1);
            v1_1 = v8_2.rememberedValue();
            if(v0_4 != 0 || v1_1 == Composer.Companion.getEmpty()) {
                v1 = arg44;
                v0_5 = new DateInputKt$DateInputTextField$5$1(v1, v4, v3, arg52, v5_1, null);
                v8_2.updateRememberedValue(v0_5);
            }
            else {
                v0_3 = v1_1;
                v1 = arg44;
            }

            ComposerKt.sourceInformationMarkerEnd(v8_2);
            EffectsKt.LaunchedEffect(v1, ((Function2)v0_5), v8_2, v13 >> 3 & 14);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_467;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1 = arg44;
            v8_2 = v11;
            v8_2.skipToGroupEnd();
        }

    label_467:
        ScopeUpdateScope v15_5 = v8_2.endRestartGroup();
        if(v15_5 != null) {
            v15_5.updateScope(new DateInputKt$$ExternalSyntheticLambda5(arg43, v1, arg45, arg46, arg47, arg48, arg49, arg50, arg51, arg52, arg53, v12, arg56, arg57));
        }
    }

    static final Unit DateInputTextField_xJ3Ic0Y$lambda$12$lambda$11(DateInputFormat arg3, MutableState arg4, Function1 arg5, CalendarModel arg6, Locale arg7, DateInputValidator arg8, int arg9, MutableState arg10, TextFieldValue arg11) {
        Long v0_2;
        if(arg11.getText().length() <= arg3.getPatternWithoutDelimiters().length()) {
            String v0 = arg11.getText();
            int v1 = 0;
            while(true) {
                if(v1 >= ((CharSequence)v0).length()) {
                    break;
                }
                else if(!Character.isDigit(((CharSequence)v0).charAt(v1))) {
                }
                else {
                    ++v1;
                    continue;
                }

                goto label_43;
            }

            DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$7(arg10, arg11);
            String v10 = StringsKt.trim(arg11.getText()).toString();
            Object v0_1 = null;
            if(v10.length() == 0) {
            }
            else {
                if(v10.length() < arg3.getPatternWithoutDelimiters().length()) {
                    goto label_28;
                }

                goto label_32;
            }

        label_28:
            arg4.setValue("");
            arg5.invoke(v0_1);
            goto label_43;
        label_32:
            CalendarDate v3 = arg6.parse(v10, arg3.getPatternWithoutDelimiters(), arg7);
            arg4.setValue(arg8.validate-XivgLIo(v3, arg9, arg7));
            if(arg4.getValue().length() == 0 && v3 != null) {
                v0_2 = Long.valueOf(v3.getUtcTimeMillis());
            }

            arg5.invoke(v0_2);
        }

    label_43:
        return Unit.INSTANCE;
    }

    static final Unit DateInputTextField_xJ3Ic0Y$lambda$14$lambda$13(MutableState arg1, SemanticsPropertyReceiver arg2) {
        if(!StringsKt.isBlank(arg1.getValue())) {
            SemanticsPropertiesKt.error(arg2, arg1.getValue());
        }

        return Unit.INSTANCE;
    }

    static final Unit DateInputTextField_xJ3Ic0Y$lambda$17(Modifier arg16, Long arg17, Function1 arg18, CalendarModel arg19, Function2 arg20, Function2 arg21, int arg22, DateInputValidator arg23, DateInputFormat arg24, Locale arg25, DatePickerColors arg26, FocusRequester arg27, int arg28, int arg29, Composer arg30, int arg31) {
        DateInputKt.DateInputTextField-xJ3Ic0Y(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg30, RecomposeScopeImplKt.updateChangedFlags(arg28 | 1), RecomposeScopeImplKt.updateChangedFlags(arg29));
        return Unit.INSTANCE;
    }

    static final MutableState DateInputTextField_xJ3Ic0Y$lambda$5$lambda$4() {
        return SnapshotStateKt.mutableStateOf$default(new TextFieldValue(null, 0, null, 7, null), null, 2, null);
    }

    private static final TextFieldValue DateInputTextField_xJ3Ic0Y$lambda$6(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void DateInputTextField_xJ3Ic0Y$lambda$7(MutableState arg0, TextFieldValue arg1) {
        arg0.setValue(arg1);
    }

    static final MutableState DateInputTextField_xJ3Ic0Y$lambda$9$lambda$8(DateInputValidator arg1, CalendarModel arg2, DateInputFormat arg3, Locale arg4, int arg5, MutableState arg6) {
        String v1 = DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$6(arg6).getText().length() > 0 ? arg1.validate-XivgLIo(arg2.parse(DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$6(arg6).getText(), arg3.getPatternWithoutDelimiters(), arg4), arg5, arg4) : "";
        return SnapshotStateKt.mutableStateOf$default(v1, null, 2, null);
    }

    public static final void access$DateInputTextField_xJ3Ic0Y$lambda$7(MutableState arg0, TextFieldValue arg1) {
        DateInputKt.DateInputTextField_xJ3Ic0Y$lambda$7(arg0, arg1);
    }

    public static final PaddingValues getInputTextFieldPadding() {
        return DateInputKt.InputTextFieldPadding;
    }
}

