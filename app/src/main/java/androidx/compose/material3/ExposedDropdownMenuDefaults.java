package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.Icons$Filled;
import androidx.compose.material3.tokens.FilledAutocompleteTokens;
import androidx.compose.material3.tokens.OutlinedAutocompleteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0002\u0010\nJ\u0095\u0003\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0010\u001A\u00020\u000E2\b\b\u0002\u0010\u0011\u001A\u00020\u000E2\b\b\u0002\u0010\u0012\u001A\u00020\u000E2\b\b\u0002\u0010\u0013\u001A\u00020\u000E2\b\b\u0002\u0010\u0014\u001A\u00020\u000E2\b\b\u0002\u0010\u0015\u001A\u00020\u000E2\b\b\u0002\u0010\u0016\u001A\u00020\u000E2\b\b\u0002\u0010\u0017\u001A\u00020\u000E2\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u000E2\b\b\u0002\u0010\u001B\u001A\u00020\u000E2\b\b\u0002\u0010\u001C\u001A\u00020\u000E2\b\b\u0002\u0010\u001D\u001A\u00020\u000E2\b\b\u0002\u0010\u001E\u001A\u00020\u000E2\b\b\u0002\u0010\u001F\u001A\u00020\u000E2\b\b\u0002\u0010 \u001A\u00020\u000E2\b\b\u0002\u0010!\u001A\u00020\u000E2\b\b\u0002\u0010\"\u001A\u00020\u000E2\b\b\u0002\u0010#\u001A\u00020\u000E2\b\b\u0002\u0010$\u001A\u00020\u000E2\b\b\u0002\u0010%\u001A\u00020\u000E2\b\b\u0002\u0010&\u001A\u00020\u000E2\b\b\u0002\u0010\'\u001A\u00020\u000E2\b\b\u0002\u0010(\u001A\u00020\u000E2\b\b\u0002\u0010)\u001A\u00020\u000E2\b\b\u0002\u0010*\u001A\u00020\u000E2\b\b\u0002\u0010+\u001A\u00020\u000E2\b\b\u0002\u0010,\u001A\u00020\u000E2\b\b\u0002\u0010-\u001A\u00020\u000E2\b\b\u0002\u0010.\u001A\u00020\u000E2\b\b\u0002\u0010/\u001A\u00020\u000E2\b\b\u0002\u00100\u001A\u00020\u000E2\b\b\u0002\u00101\u001A\u00020\u000E2\b\b\u0002\u00102\u001A\u00020\u000E2\b\b\u0002\u00103\u001A\u00020\u000E2\b\b\u0002\u00104\u001A\u00020\u000E2\b\b\u0002\u00105\u001A\u00020\u000EH\u0007¢\u0006\u0004\b6\u00107J\u0095\u0003\u00108\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0010\u001A\u00020\u000E2\b\b\u0002\u0010\u0011\u001A\u00020\u000E2\b\b\u0002\u0010\u0012\u001A\u00020\u000E2\b\b\u0002\u0010\u0013\u001A\u00020\u000E2\b\b\u0002\u0010\u0014\u001A\u00020\u000E2\b\b\u0002\u0010\u0015\u001A\u00020\u000E2\b\b\u0002\u0010\u0016\u001A\u00020\u000E2\b\b\u0002\u0010\u0017\u001A\u00020\u000E2\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u00109\u001A\u00020\u000E2\b\b\u0002\u0010:\u001A\u00020\u000E2\b\b\u0002\u0010;\u001A\u00020\u000E2\b\b\u0002\u0010<\u001A\u00020\u000E2\b\b\u0002\u0010\u001E\u001A\u00020\u000E2\b\b\u0002\u0010\u001F\u001A\u00020\u000E2\b\b\u0002\u0010 \u001A\u00020\u000E2\b\b\u0002\u0010!\u001A\u00020\u000E2\b\b\u0002\u0010\"\u001A\u00020\u000E2\b\b\u0002\u0010#\u001A\u00020\u000E2\b\b\u0002\u0010$\u001A\u00020\u000E2\b\b\u0002\u0010%\u001A\u00020\u000E2\b\b\u0002\u0010&\u001A\u00020\u000E2\b\b\u0002\u0010\'\u001A\u00020\u000E2\b\b\u0002\u0010(\u001A\u00020\u000E2\b\b\u0002\u0010)\u001A\u00020\u000E2\b\b\u0002\u0010*\u001A\u00020\u000E2\b\b\u0002\u0010+\u001A\u00020\u000E2\b\b\u0002\u0010,\u001A\u00020\u000E2\b\b\u0002\u0010-\u001A\u00020\u000E2\b\b\u0002\u0010.\u001A\u00020\u000E2\b\b\u0002\u0010/\u001A\u00020\u000E2\b\b\u0002\u00100\u001A\u00020\u000E2\b\b\u0002\u00101\u001A\u00020\u000E2\b\b\u0002\u00102\u001A\u00020\u000E2\b\b\u0002\u00103\u001A\u00020\u000E2\b\b\u0002\u00104\u001A\u00020\u000E2\b\b\u0002\u00105\u001A\u00020\u000EH\u0007¢\u0006\u0004\b=\u00107J\u0015\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0002\u0010BJ\u0081\u0003\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0010\u001A\u00020\u000E2\b\b\u0002\u0010\u0011\u001A\u00020\u000E2\b\b\u0002\u0010C\u001A\u00020\u000E2\b\b\u0002\u0010\u0015\u001A\u00020\u000E2\b\b\u0002\u0010\u0016\u001A\u00020\u000E2\b\b\u0002\u0010\u0017\u001A\u00020\u000E2\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u000E2\b\b\u0002\u0010\u001B\u001A\u00020\u000E2\b\b\u0002\u0010\u001C\u001A\u00020\u000E2\b\b\u0002\u0010\u001D\u001A\u00020\u000E2\b\b\u0002\u0010\u001E\u001A\u00020\u000E2\b\b\u0002\u0010\u001F\u001A\u00020\u000E2\b\b\u0002\u0010 \u001A\u00020\u000E2\b\b\u0002\u0010!\u001A\u00020\u000E2\b\b\u0002\u0010\"\u001A\u00020\u000E2\b\b\u0002\u0010#\u001A\u00020\u000E2\b\b\u0002\u0010$\u001A\u00020\u000E2\b\b\u0002\u0010%\u001A\u00020\u000E2\b\b\u0002\u0010&\u001A\u00020\u000E2\b\b\u0002\u0010\'\u001A\u00020\u000E2\b\b\u0002\u0010(\u001A\u00020\u000E2\b\b\u0002\u0010)\u001A\u00020\u000E2\b\b\u0002\u0010*\u001A\u00020\u000E2\b\b\u0002\u0010+\u001A\u00020\u000E2\b\b\u0002\u0010,\u001A\u00020\u000E2\b\b\u0002\u0010-\u001A\u00020\u000E2\b\b\u0002\u0010.\u001A\u00020\u000E2\b\b\u0002\u0010/\u001A\u00020\u000E2\b\b\u0002\u00100\u001A\u00020\u000E2\b\b\u0002\u00101\u001A\u00020\u000E2\b\b\u0002\u00102\u001A\u00020\u000E2\b\b\u0002\u00103\u001A\u00020\u000E2\b\b\u0002\u00104\u001A\u00020\u000E2\b\b\u0002\u00105\u001A\u00020\u000EH\u0007¢\u0006\u0004\bD\u0010EJ\u0081\u0003\u00108\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\b\b\u0002\u0010\u0010\u001A\u00020\u000E2\b\b\u0002\u0010\u0011\u001A\u00020\u000E2\b\b\u0002\u0010C\u001A\u00020\u000E2\b\b\u0002\u0010\u0015\u001A\u00020\u000E2\b\b\u0002\u0010\u0016\u001A\u00020\u000E2\b\b\u0002\u0010\u0017\u001A\u00020\u000E2\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u00109\u001A\u00020\u000E2\b\b\u0002\u0010:\u001A\u00020\u000E2\b\b\u0002\u0010;\u001A\u00020\u000E2\b\b\u0002\u0010<\u001A\u00020\u000E2\b\b\u0002\u0010\u001E\u001A\u00020\u000E2\b\b\u0002\u0010\u001F\u001A\u00020\u000E2\b\b\u0002\u0010 \u001A\u00020\u000E2\b\b\u0002\u0010!\u001A\u00020\u000E2\b\b\u0002\u0010\"\u001A\u00020\u000E2\b\b\u0002\u0010#\u001A\u00020\u000E2\b\b\u0002\u0010$\u001A\u00020\u000E2\b\b\u0002\u0010%\u001A\u00020\u000E2\b\b\u0002\u0010&\u001A\u00020\u000E2\b\b\u0002\u0010\'\u001A\u00020\u000E2\b\b\u0002\u0010(\u001A\u00020\u000E2\b\b\u0002\u0010)\u001A\u00020\u000E2\b\b\u0002\u0010*\u001A\u00020\u000E2\b\b\u0002\u0010+\u001A\u00020\u000E2\b\b\u0002\u0010,\u001A\u00020\u000E2\b\b\u0002\u0010-\u001A\u00020\u000E2\b\b\u0002\u0010.\u001A\u00020\u000E2\b\b\u0002\u0010/\u001A\u00020\u000E2\b\b\u0002\u00100\u001A\u00020\u000E2\b\b\u0002\u00101\u001A\u00020\u000E2\b\b\u0002\u00102\u001A\u00020\u000E2\b\b\u0002\u00103\u001A\u00020\u000E2\b\b\u0002\u00104\u001A\u00020\u000E2\b\b\u0002\u00105\u001A\u00020\u000EH\u0007¢\u0006\u0004\bF\u0010EJÿ\u0001\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010G\u001A\u00020\u000E2\b\b\u0002\u0010\u0010\u001A\u00020\u000E2\b\b\u0002\u0010C\u001A\u00020\u000E2\b\b\u0002\u0010\u0016\u001A\u00020\u000E2\b\b\u0002\u0010\u0017\u001A\u00020\u000E2\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u000E2\b\b\u0002\u0010\u001B\u001A\u00020\u000E2\b\b\u0002\u0010\u001C\u001A\u00020\u000E2\b\b\u0002\u0010\u001D\u001A\u00020\u000E2\b\b\u0002\u0010\u001E\u001A\u00020\u000E2\b\b\u0002\u0010\u001F\u001A\u00020\u000E2\b\b\u0002\u0010 \u001A\u00020\u000E2\b\b\u0002\u0010!\u001A\u00020\u000E2\b\b\u0002\u0010\"\u001A\u00020\u000E2\b\b\u0002\u0010#\u001A\u00020\u000E2\b\b\u0002\u0010$\u001A\u00020\u000E2\b\b\u0002\u0010%\u001A\u00020\u000E2\b\b\u0002\u0010&\u001A\u00020\u000E2\b\b\u0002\u0010\'\u001A\u00020\u000E2\b\b\u0002\u0010(\u001A\u00020\u000E2\b\b\u0002\u0010)\u001A\u00020\u000E2\b\b\u0002\u0010H\u001A\u00020\u000E2\b\b\u0002\u0010,\u001A\u00020\u000EH\u0007¢\u0006\u0004\bI\u0010JJÿ\u0001\u00108\u001A\u00020\f2\b\b\u0002\u0010G\u001A\u00020\u000E2\b\b\u0002\u0010\u0010\u001A\u00020\u000E2\b\b\u0002\u0010C\u001A\u00020\u000E2\b\b\u0002\u0010\u0016\u001A\u00020\u000E2\b\b\u0002\u0010\u0017\u001A\u00020\u000E2\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u00109\u001A\u00020\u000E2\b\b\u0002\u0010:\u001A\u00020\u000E2\b\b\u0002\u0010;\u001A\u00020\u000E2\b\b\u0002\u0010<\u001A\u00020\u000E2\b\b\u0002\u0010\u001E\u001A\u00020\u000E2\b\b\u0002\u0010\u001F\u001A\u00020\u000E2\b\b\u0002\u0010 \u001A\u00020\u000E2\b\b\u0002\u0010!\u001A\u00020\u000E2\b\b\u0002\u0010\"\u001A\u00020\u000E2\b\b\u0002\u0010#\u001A\u00020\u000E2\b\b\u0002\u0010$\u001A\u00020\u000E2\b\b\u0002\u0010%\u001A\u00020\u000E2\b\b\u0002\u0010&\u001A\u00020\u000E2\b\b\u0002\u0010\'\u001A\u00020\u000E2\b\b\u0002\u0010(\u001A\u00020\u000E2\b\b\u0002\u0010)\u001A\u00020\u000E2\b\b\u0002\u0010H\u001A\u00020\u000E2\b\b\u0002\u0010,\u001A\u00020\u000EH\u0007¢\u0006\u0004\bK\u0010JR\u0011\u0010>\u001A\u00020?¢\u0006\b\n\u0000\u001A\u0004\b@\u0010A¨\u0006L"}, d2={"Landroidx/compose/material3/ExposedDropdownMenuDefaults;", "", "<init>", "()V", "TrailingIcon", "", "expanded", "", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "textFieldColors", "Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "textFieldColors-FD9MK7s", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldColors", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "outlinedTextFieldColors-FD9MK7s", "ItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "(ZLandroidx/compose/runtime/Composer;I)V", "containerColor", "textFieldColors-tN0la-I", "(JJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldColors-tN0la-I", "textColor", "placeholderColor", "textFieldColors-St-qZLY", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "outlinedTextFieldColors-St-qZLY", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ExposedDropdownMenuDefaults {
    public static final int $stable;
    public static final ExposedDropdownMenuDefaults INSTANCE;
    private static final PaddingValues ItemContentPadding;

    static {
        ExposedDropdownMenuDefaults.INSTANCE = new ExposedDropdownMenuDefaults();
        ExposedDropdownMenuDefaults.ItemContentPadding = PaddingKt.PaddingValues-YgX7TsA(ExposedDropdownMenuKt.access$getExposedDropdownMenuItemHorizontalPadding$p(), Dp.constructor-impl(0f));
    }

    private ExposedDropdownMenuDefaults() {
        super();
    }

    public final void TrailingIcon(boolean arg10, Modifier arg11, Composer arg12, int arg13, int arg14) {
        Companion v11;
        int v12;
        int v0 = 0x98B73379;
        Composer v6 = arg12.startRestartGroup(v0);
        ComposerKt.sourceInformation(v6, "C(TrailingIcon)N(expanded,modifier)512@22846L83:ExposedDropdownMenu.kt#uh7d8r");
        if((arg14 & 1) != 0) {
            v12 = arg13 | 6;
        }
        else if((arg13 & 6) == 0) {
            v12 = v6.changed(arg10) ? 4 : 2;
            v12 |= arg13;
        }
        else {
            v12 = arg13;
        }

        int v1 = arg14 & 2;
        if(v1 != 0) {
            v12 |= 0x30;
        }
        else if((arg13 & 0x30) == 0) {
            int v2 = v6.changed(arg11) ? 0x20 : 16;
            v12 |= v2;
        }

        boolean v2_1 = (v12 & 19) != 18 ? true : false;
        if(v6.shouldExecute(v2_1, v12 & 1)) {
            if(v1 != 0) {
                v11 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v12, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:511)");
            }

            ImageVector v1_1 = Filled.INSTANCE.getArrowDropDown$material3();
            float v12_1 = arg10 ? 180f : 0f;
            IconKt.Icon-ww6aTOc(v1_1, null, RotateKt.rotate(((Modifier)v11), v12_1), 0, v6, 0x30, 8);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_63;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v6.skipToGroupEnd();
        }

    label_63:
        Modifier v3 = ((Modifier)v11);
        ScopeUpdateScope v11_1 = v6.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new ExposedDropdownMenuDefaults$$ExternalSyntheticLambda0(this, arg10, v3, arg13, arg14));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public final void TrailingIcon(boolean arg8, Composer arg9, int arg10) {
        boolean v2;
        ExposedDropdownMenuDefaults v1_2;
        int v9;
        int v0 = -1803742020;
        Composer v4 = arg9.startRestartGroup(v0);
        ComposerKt.sourceInformation(v4, "C(TrailingIcon)N(expanded)849@45151L32:ExposedDropdownMenu.kt#uh7d8r");
        if((arg10 & 6) == 0) {
            v9 = v4.changed(arg8) ? 4 : 2;
            v9 |= arg10;
        }
        else {
            v9 = arg10;
        }

        if((arg10 & 0x30) == 0) {
            int v1 = v4.changed(this) ? 0x20 : 16;
            v9 |= v1;
        }

        boolean v1_1 = (v9 & 19) != 18 ? true : false;
        if(v4.shouldExecute(v1_1, v9 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v9, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:849)");
            }

            v1_2 = this;
            v2 = arg8;
            v1_2.TrailingIcon(v2, Modifier.Companion, v4, v9 & 14 | 0x30 | v9 << 3 & 0x380, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_54;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1_2 = this;
            v2 = arg8;
            v4.skipToGroupEnd();
        }

    label_54:
        ScopeUpdateScope v7 = v4.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new ExposedDropdownMenuDefaults$$ExternalSyntheticLambda1(v1_2, v2, arg10));
        }
    }

    static final Unit TrailingIcon$lambda$0(ExposedDropdownMenuDefaults arg6, boolean arg7, Modifier arg8, int arg9, int arg10, Composer arg11, int arg12) {
        arg6.TrailingIcon(arg7, arg8, arg11, RecomposeScopeImplKt.updateChangedFlags(arg9 | 1), arg10);
        return Unit.INSTANCE;
    }

    static final Unit TrailingIcon$lambda$1(ExposedDropdownMenuDefaults arg0, boolean arg1, int arg2, Composer arg3, int arg4) {
        arg0.TrailingIcon(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public final PaddingValues getItemContentPadding() {
        return ExposedDropdownMenuDefaults.ItemContentPadding;
    }

    public final TextFieldColors outlinedTextFieldColors-FD9MK7s(long arg96, long arg98, long arg100, long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, TextSelectionColors arg116, long arg117, long arg119, long arg121, long arg123, long arg125, long arg127, long arg129, long arg131, long arg133, long arg135, long arg137, long arg139, long arg141, long arg143, long arg145, long arg147, long arg149, long arg151, long arg153, long arg155, long arg157, long arg159, long arg161, long arg163, long arg165, long arg167, long arg169, long arg171, Composer arg173, int arg174, int arg175, int arg176, int arg177, int arg178, int arg179) {
        long v77;
        long v65;
        long v57;
        long v49;
        long v41;
        int v5_3;
        long v33;
        long v29;
        Object v5_1;
        Composer v0 = arg173;
        int v1 = arg174;
        int v2 = arg175;
        int v3 = arg178;
        int v4 = arg179;
        ComposerKt.sourceInformationMarkerStart(v0, 0xEC9E6F54, "C(outlinedTextFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedBorderColor:c#ui.graphics.Color,unfocusedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,errorBorderColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)726@37797L5,727@37887L5,729@37996L5,732@38188L5,737@38504L5,738@38602L5,739@38681L7,740@38780L5,741@38874L5,743@38987L5,746@39185L5,748@39303L5,750@39418L5,752@39540L5,756@39763L5,758@39883L5,760@40000L5,762@40124L5,766@40350L5,767@40444L5,768@40535L5,770@40645L5,773@40838L5,774@40938L5,776@41052L5,778@41173L5,781@41377L5,782@41472L5,783@41569L5,785@41685L5,788@41884L5,789@41979L5,790@42076L5,792@42192L5,795@42391L5,797@42457L2206:ExposedDropdownMenu.kt#uh7d8r");
        int v7 = 6;
        long v8 = (v3 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), v0, v7) : arg96;
        long v10 = (v3 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), v0, v7) : arg98;
        long v12 = (v3 & 4) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), v0, v7), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0f, 0f, 0f, 14, null) : arg100;
        long v14 = (v3 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), v0, v7) : arg102;
        long v16 = (v3 & 16) != 0 ? Color.Companion.getTransparent-0d7_KjU() : arg104;
        long v18 = (v3 & 0x20) != 0 ? Color.Companion.getTransparent-0d7_KjU() : arg106;
        long v20 = (v3 & 0x40) != 0 ? Color.Companion.getTransparent-0d7_KjU() : arg108;
        long v22 = (v3 & 0x80) != 0 ? Color.Companion.getTransparent-0d7_KjU() : arg110;
        long v24 = (v3 & 0x100) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), v0, v7) : arg112;
        long v26 = (v3 & 0x200) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), v0, v7) : arg114;
        if((v3 & 0x400) != 0) {
            ProvidableCompositionLocal v5 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v5_1 = v0.consume(((CompositionLocal)v5));
            ComposerKt.sourceInformationMarkerEnd(v0);
        }
        else {
            TextSelectionColors v5_2 = arg116;
        }

        if((v3 & 0x800) != 0) {
            v7 = 6;
            v29 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), v0, v7);
        }
        else {
            v7 = 6;
            v29 = arg117;
        }

        long v31 = (v3 & 0x1000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), v0, v7) : arg119;
        long v6 = (v3 & 0x2000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), v0, v7), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), 0f, 0f, 0f, 14, null) : arg121;
        Object v96 = v5_1;
        if((v3 & 0x4000) != 0) {
            v3 = 6;
            v33 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), v0, v3);
        }
        else {
            v3 = 6;
            v33 = arg123;
        }

        long v35 = (arg178 & 0x8000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), v0, v3) : arg125;
        long v37 = (arg178 & 0x10000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), v0, v3) : arg127;
        long v39 = (arg178 & 0x20000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), v0, v3), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null) : arg129;
        if((arg178 & 0x40000) != 0) {
            v5_3 = 6;
            v41 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), v0, v5_3);
        }
        else {
            v5_3 = 6;
            v41 = arg131;
        }

        long v43 = (arg178 & 0x80000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), v0, v5_3) : arg133;
        long v45 = (arg178 & 0x100000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), v0, v5_3) : arg135;
        long v47 = (arg178 & 0x200000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), v0, v5_3), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null) : arg137;
        if((arg178 & 0x400000) != 0) {
            v5_3 = 6;
            v49 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), v0, v5_3);
        }
        else {
            v5_3 = 6;
            v49 = arg139;
        }

        long v51 = (arg178 & 0x800000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), v0, v5_3) : arg141;
        long v53 = (arg178 & 0x1000000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), v0, v5_3) : arg143;
        long v55 = (arg178 & 0x2000000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), v0, v5_3), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null) : arg145;
        if((arg178 & 0x4000000) != 0) {
            v5_3 = 6;
            v57 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), v0, v5_3);
        }
        else {
            v5_3 = 6;
            v57 = arg147;
        }

        long v59 = (arg178 & 0x8000000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3) : arg149;
        long v61 = (arg178 & 0x10000000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3) : arg151;
        long v63 = (arg178 & 0x20000000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v5_3), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null) : arg153;
        if((arg178 & 0x40000000) != 0) {
            v5_3 = 6;
            v65 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3);
        }
        else {
            v5_3 = 6;
            v65 = arg155;
        }

        long v71 = (v4 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3) : arg157;
        long v73 = (v4 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3) : arg159;
        long v75 = (v4 & 4) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v5_3), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null) : arg161;
        if((v4 & 8) != 0) {
            v5_3 = 6;
            v77 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3);
        }
        else {
            v5_3 = 6;
            v77 = arg163;
        }

        long v79 = (v4 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3) : arg165;
        long v81 = (v4 & 0x20) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3) : arg167;
        long v83 = (v4 & 0x40) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v5_3), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null) : arg169;
        long v85 = (v4 & 0x80) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, 6) : arg171;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(0xEC9E6F54, v1, v2, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:797)");
        }

        int v89 = v2 & 0x7FFFFFFE;
        v3 = arg177 << 12;
        v2 = arg177 >> 18;
        TextFieldColors v0_1 = OutlinedTextFieldDefaults.INSTANCE.colors-0hiis_0(v8, v10, v12, v14, v16, v18, v20, v22, v24, v26, v96, v29, v31, v6, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v57, v59, v61, v63, v65, 0, 0, 0, 0, v71, v73, v75, v77, v79, v81, v83, v85, v0, arg174 & 0x7FFFFFFE, v89, arg176 & 0x7FFFFFFE, arg177 & 14 | 0x70000 & v3 | 0x380000 & v3 | 0x1C00000 & v3 | 0xE000000 & v3 | v3 & 0x70000000, v2 & 14 | 0xC00 | v2 & 0x70 | v2 & 0x380, 0, 15);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg173);
        return v0_1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public final TextFieldColors outlinedTextFieldColors-St-qZLY(long arg87, long arg89, long arg91, long arg93, long arg95, TextSelectionColors arg97, long arg98, long arg100, long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, Composer arg134, int arg135, int arg136, int arg137, int arg138) {
        TextSelectionColors v22_1;
        Composer v0 = arg134;
        int v1 = arg135;
        int v2 = arg136;
        int v3 = arg138;
        int v5 = 0xFB0B45CD;
        ComposerKt.sourceInformationMarkerStart(v0, v5, "C(outlinedTextFieldColors)N(textColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedBorderColor:c#ui.graphics.Color,unfocusedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,errorBorderColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,placeholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)1179@65144L5,1181@65253L5,1185@65488L5,1186@65586L5,1187@65665L7,1188@65764L5,1189@65858L5,1191@65971L5,1194@66169L5,1196@66287L5,1198@66402L5,1200@66524L5,1204@66747L5,1206@66867L5,1208@66984L5,1210@67108L5,1214@67334L5,1215@67428L5,1216@67519L5,1218@67629L5,1221@67822L5,1222@67915L5,1224@68031L5,1260@69972L5,1261@70066L5,1263@70183L5,1266@70387L5,1267@70479L5,1268@70573L5,1270@70690L5,1273@70894L5,1228@68172L2738:ExposedDropdownMenu.kt#uh7d8r");
        int v6 = 6;
        long v7 = (v3 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), v0, v6) : arg87;
        long v9 = (v3 & 2) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), v0, v6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0f, 0f, 0f, 14, null) : arg89;
        long v11 = (v3 & 4) != 0 ? Color.Companion.getTransparent-0d7_KjU() : arg91;
        long v18 = (v3 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), v0, v6) : arg93;
        long v20 = (v3 & 16) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), v0, v6) : arg95;
        if((v3 & 0x20) != 0) {
            ProvidableCompositionLocal v4 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v4_1 = v0.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(v0);
            Object v22 = v4_1;
        }
        else {
            v22_1 = arg97;
        }

        long v23 = (v3 & 0x40) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), v0, v6) : arg98;
        long v25 = (v3 & 0x80) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), v0, v6) : arg100;
        long v27 = (v3 & 0x100) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), v0, v6), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), 0f, 0f, 0f, 14, null) : arg102;
        long v29 = (v3 & 0x200) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), v0, v6) : arg104;
        long v31 = (v3 & 0x400) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), v0, v6) : arg106;
        long v33 = (v3 & 0x800) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), v0, v6) : arg108;
        long v35 = (v3 & 0x1000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), v0, v6), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null) : arg110;
        long v37 = (v3 & 0x2000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), v0, v6) : arg112;
        long v39 = (v3 & 0x4000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), v0, v6) : arg114;
        long v41 = (0x8000 & v3) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), v0, v6) : arg116;
        long v43 = (0x10000 & v3) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), v0, v6), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null) : arg118;
        long v45 = (0x20000 & v3) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), v0, v6) : arg120;
        long v47 = (0x40000 & v3) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), v0, v6) : arg122;
        long v49 = (0x80000 & v3) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), v0, v6) : arg124;
        long v51 = (0x100000 & v3) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), v0, v6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null) : arg126;
        long v53 = (0x200000 & v3) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), v0, v6) : arg128;
        long v55 = (0x400000 & v3) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6) : arg130;
        long v59 = (v3 & 0x800000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), v0, v6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0f, 0f, 0f, 14, null) : arg132;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v5, v1, v2, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:1228)");
        }

        int v4_2 = v1 << 3;
        v3 = v1 & 14 | v4_2 & 0x70 | v4_2 & 0x380;
        v4_2 = v1 << 9;
        v3 = v3 | v4_2 & 0x1C00 | v1 << 6 & 0xE000 | v4_2 & 0x70000;
        v4_2 = v1 << 15;
        int v80 = v3 | v1 << 12 & 0x380000 | v4_2 & 0x1C00000 | v4_2 & 0xE000000 | v4_2 & 0x70000000;
        v4_2 = v2 << 15;
        int v81 = v1 >> 15 & 0xFFFE | v4_2 & 0x70000 | v4_2 & 0x380000 | v4_2 & 0x1C00000 | v4_2 & 0xE000000 | v4_2 & 0x70000000;
        v1 = v2 >> 15 & 0xFFFE;
        v2 = arg137 << 15;
        v3 = arg137 << 18;
        TextFieldColors v0_1 = this.outlinedTextFieldColors-FD9MK7s(v7, v7, v9, v7, v11, v11, v11, v11, v18, v20, v22_1, v23, v25, v27, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v55, v59, v55, ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6), Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6), Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6), v0, v80, v81, v1 | v2 & 0x70000 | v2 & 0x380000 | v2 & 0x1C00000 | v3 & 0xE000000 | v3 & 0x70000000, arg137 >> 6 & 14 | v2 & 0x70000000, 0, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg134);
        return v0_1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public final TextFieldColors outlinedTextFieldColors-tN0la-I(long arg87, long arg89, long arg91, long arg93, long arg95, long arg97, long arg99, long arg101, TextSelectionColors arg103, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, long arg134, long arg136, long arg138, long arg140, long arg142, long arg144, long arg146, long arg148, long arg150, long arg152, long arg154, long arg156, long arg158, Composer arg160, int arg161, int arg162, int arg163, int arg164, int arg165, int arg166) {
        long v69;
        long v61;
        long v53;
        long v45;
        long v37;
        long v29;
        int v5_1;
        long v88;
        long v25;
        TextSelectionColors v4_2;
        Composer v0 = arg160;
        int v1 = arg161;
        int v2 = arg162;
        int v3 = arg165;
        ComposerKt.sourceInformationMarkerStart(v0, 0xC9F01E02, "C(outlinedTextFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedBorderColor:c#ui.graphics.Color,unfocusedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,errorBorderColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)966@52291L5,967@52381L5,969@52490L5,972@52682L5,975@52872L5,976@52970L5,977@53049L7,978@53148L5,979@53242L5,981@53355L5,984@53553L5,986@53671L5,988@53786L5,990@53908L5,994@54131L5,996@54251L5,998@54368L5,1000@54492L5,1004@54718L5,1005@54812L5,1006@54903L5,1008@55013L5,1011@55206L5,1012@55306L5,1014@55420L5,1016@55541L5,1019@55745L5,1020@55840L5,1021@55937L5,1023@56053L5,1026@56252L5,1027@56347L5,1028@56444L5,1030@56560L5,1033@56759L5,1035@56799L2199:ExposedDropdownMenu.kt#uh7d8r");
        int v6 = 6;
        long v7 = (v3 & 1) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), v0, v6) : arg87;
        long v9 = (v3 & 2) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), v0, v6) : arg89;
        long v11 = (v3 & 4) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), v0, v6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0f, 0f, 0f, 14, null) : arg91;
        long v13 = (v3 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), v0, v6) : arg93;
        long v15 = (v3 & 16) != 0 ? Color.Companion.getTransparent-0d7_KjU() : arg95;
        long v17 = (v3 & 0x20) != 0 ? Color.Companion.getTransparent-0d7_KjU() : arg97;
        long v19 = (v3 & 0x40) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), v0, v6) : arg99;
        long v21 = (v3 & 0x80) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), v0, v6) : arg101;
        if((v3 & 0x100) != 0) {
            ProvidableCompositionLocal v4 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v4_1 = v0.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(v0);
        }
        else {
            v4_2 = arg103;
        }

        if((v3 & 0x200) != 0) {
            v6 = 6;
            v25 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), v0, v6);
        }
        else {
            v6 = 6;
            v25 = arg104;
        }

        long v27 = (v3 & 0x400) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), v0, v6) : arg106;
        long v5 = (v3 & 0x800) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), v0, v6), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineOpacity(), 0f, 0f, 0f, 14, null) : arg108;
        Object v87 = v4_2;
        if((v3 & 0x1000) != 0) {
            v88 = v5;
            v5_1 = 6;
            v29 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), v0, v5_1);
        }
        else {
            v88 = v5;
            v5_1 = 6;
            v29 = arg110;
        }

        long v31 = (v3 & 0x2000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), v0, v5_1) : arg112;
        long v33 = (v3 & 0x4000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), v0, v5_1) : arg114;
        long v35 = (0x8000 & v3) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), v0, v5_1), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null) : arg116;
        if((0x10000 & v3) != 0) {
            v5_1 = 6;
            v37 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), v0, v5_1);
        }
        else {
            v5_1 = 6;
            v37 = arg118;
        }

        long v39 = (0x20000 & v3) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), v0, v5_1) : arg120;
        long v41 = (0x40000 & v3) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), v0, v5_1) : arg122;
        long v43 = (0x80000 & v3) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), v0, v5_1), OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null) : arg124;
        if((0x100000 & v3) != 0) {
            v5_1 = 6;
            v45 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), v0, v5_1);
        }
        else {
            v5_1 = 6;
            v45 = arg126;
        }

        long v47 = (0x200000 & v3) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), v0, v5_1) : arg128;
        long v49 = (0x400000 & v3) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), v0, v5_1) : arg130;
        long v51 = (0x800000 & v3) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), v0, v5_1), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null) : arg132;
        if((0x1000000 & v3) != 0) {
            v5_1 = 6;
            v53 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), v0, v5_1);
        }
        else {
            v5_1 = 6;
            v53 = arg134;
        }

        long v55 = (0x2000000 & v3) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1) : arg136;
        long v57 = (0x4000000 & v3) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1) : arg138;
        long v59 = (0x8000000 & v3) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v5_1), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null) : arg140;
        if((0x10000000 & v3) != 0) {
            v5_1 = 6;
            v61 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1);
        }
        else {
            v5_1 = 6;
            v61 = arg142;
        }

        long v63 = (0x20000000 & v3) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1) : arg144;
        long v65 = (v3 & 0x40000000) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1) : arg146;
        long v67 = (arg166 & 1) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v5_1), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null) : arg148;
        if((arg166 & 2) != 0) {
            v5_1 = 6;
            v69 = ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1);
        }
        else {
            v5_1 = 6;
            v69 = arg150;
        }

        long v71 = (arg166 & 4) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1) : arg152;
        long v73 = (arg166 & 8) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1) : arg154;
        long v75 = (arg166 & 16) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v5_1), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null) : arg156;
        long v77 = (arg166 & 0x20) != 0 ? ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, 6) : arg158;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(0xC9F01E02, v1, v2, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:1035)");
        }

        int v4_3 = v1 << 6;
        v3 = 0xFFFE & v1 | v1 << 3 & 0x70000 | v4_3 & 0x380000 | v4_3 & 0x1C00000 | v4_3 & 0xE000000 | v4_3 & 0x70000000;
        v4_3 = v2 << 6;
        int v81 = v1 >> 24 & 0x7E | v4_3 & 0x380 | v4_3 & 0x1C00 | v4_3 & 0xE000 | v4_3 & 0x70000 | v4_3 & 0x380000 | v4_3 & 0x1C00000 | v4_3 & 0xE000000 | v4_3 & 0x70000000;
        v1 = v2 >> 24 & 0x7E;
        v2 = arg163 << 6;
        int v82 = v1 | v2 & 0x380 | v2 & 0x1C00 | v2 & 0xE000 | v2 & 0x70000 | v2 & 0x380000 | v2 & 0x1C00000 | v2 & 0xE000000 | v2 & 0x70000000;
        v2 = arg164 << 6;
        TextFieldColors v0_1 = this.outlinedTextFieldColors-FD9MK7s(v7, v9, v11, v13, v15, v15, v15, v17, v19, v21, v87, v25, v27, v88, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v57, v59, v61, v63, v65, v67, v69, v71, v73, v75, v77, v0, v3, v81, v82, arg163 >> 24 & 0x7E | v2 & 0x380 | v2 & 0x1C00 | v2 & 0xE000 | v2 & 0x70000 | v2 & 0x380000 | v2 & 0x1C00000 | v2 & 0xE000000 | v2 & 0x70000000, 0, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg160);
        return v0_1;
    }

    public final TextFieldColors textFieldColors-FD9MK7s(long arg96, long arg98, long arg100, long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, TextSelectionColors arg116, long arg117, long arg119, long arg121, long arg123, long arg125, long arg127, long arg129, long arg131, long arg133, long arg135, long arg137, long arg139, long arg141, long arg143, long arg145, long arg147, long arg149, long arg151, long arg153, long arg155, long arg157, long arg159, long arg161, long arg163, long arg165, long arg167, long arg169, long arg171, Composer arg173, int arg174, int arg175, int arg176, int arg177, int arg178, int arg179) {
        long v77;
        long v65;
        long v49;
        long v41;
        int v5_3;
        long v33;
        long v29;
        Object v5_1;
        Composer v0 = arg173;
        int v1 = arg174;
        int v2 = arg175;
        int v3 = arg178;
        int v4 = arg179;
        ComposerKt.sourceInformationMarkerStart(v0, -375683630, "C(textFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedIndicatorColor:c#ui.graphics.Color,unfocusedIndicatorColor:c#ui.graphics.Color,disabledIndicatorColor:c#ui.graphics.Color,errorIndicatorColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)565@26918L5,566@27006L5,568@27113L5,571@27301L5,572@27396L5,573@27493L5,574@27589L5,575@27682L5,576@27763L5,577@27859L5,578@27938L7,580@28058L5,582@28173L5,584@28295L5,588@28520L5,590@28636L5,591@28737L5,593@28857L5,597@29076L5,599@29194L5,601@29309L5,603@29431L5,607@29653L5,608@29745L5,609@29834L5,610@29930L5,611@30020L5,612@30118L5,613@30218L5,615@30337L5,618@30537L5,619@30630L5,620@30725L5,622@30839L5,625@31034L5,626@31127L5,627@31222L5,629@31336L5,632@31531L5,634@31589L2230:ExposedDropdownMenu.kt#uh7d8r");
        int v7 = 6;
        long v8 = (v3 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), v0, v7) : arg96;
        long v10 = (v3 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), v0, v7) : arg98;
        long v12 = (v3 & 4) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), v0, v7), FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0f, 0f, 0f, 14, null) : arg100;
        long v14 = (v3 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), v0, v7) : arg102;
        long v16 = (v3 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), v0, v7) : arg104;
        long v18 = (v3 & 0x20) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), v0, v7) : arg106;
        long v20 = (v3 & 0x40) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), v0, v7) : arg108;
        long v22 = (v3 & 0x80) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), v0, v7) : arg110;
        long v24 = (v3 & 0x100) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), v0, v7) : arg112;
        long v26 = (v3 & 0x200) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), v0, v7) : arg114;
        if((v3 & 0x400) != 0) {
            ProvidableCompositionLocal v5 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v5_1 = v0.consume(((CompositionLocal)v5));
            ComposerKt.sourceInformationMarkerEnd(v0);
        }
        else {
            TextSelectionColors v5_2 = arg116;
        }

        if((v3 & 0x800) != 0) {
            v7 = 6;
            v29 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), v0, v7);
        }
        else {
            v7 = 6;
            v29 = arg117;
        }

        long v31 = (v3 & 0x1000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), v0, v7) : arg119;
        long v6 = (v3 & 0x2000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), v0, v7), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), 0f, 0f, 0f, 14, null) : arg121;
        Object v96 = v5_1;
        if((v3 & 0x4000) != 0) {
            v3 = 6;
            v33 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), v0, v3);
        }
        else {
            v3 = 6;
            v33 = arg123;
        }

        long v35 = (arg178 & 0x8000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), v0, v3) : arg125;
        long v37 = (arg178 & 0x10000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), v0, v3) : arg127;
        long v39 = (arg178 & 0x20000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), v0, v3), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null) : arg129;
        if((arg178 & 0x40000) != 0) {
            v5_3 = 6;
            v41 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), v0, v5_3);
        }
        else {
            v5_3 = 6;
            v41 = arg131;
        }

        long v43 = (arg178 & 0x80000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), v0, v5_3) : arg133;
        long v45 = (arg178 & 0x100000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), v0, v5_3) : arg135;
        long v47 = (arg178 & 0x200000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), v0, v5_3), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null) : arg137;
        if((arg178 & 0x400000) != 0) {
            v5_3 = 6;
            v49 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), v0, v5_3);
        }
        else {
            v5_3 = 6;
            v49 = arg139;
        }

        long v51 = (arg178 & 0x800000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), v0, v5_3) : arg141;
        long v53 = (arg178 & 0x1000000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), v0, v5_3) : arg143;
        long v55 = (arg178 & 0x2000000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), v0, v5_3) : arg145;
        long v57 = (arg178 & 0x4000000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), v0, v5_3) : arg147;
        long v59 = (arg178 & 0x8000000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3) : arg149;
        long v61 = (arg178 & 0x10000000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3) : arg151;
        long v63 = (arg178 & 0x20000000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v5_3), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null) : arg153;
        if((arg178 & 0x40000000) != 0) {
            v5_3 = 6;
            v65 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3);
        }
        else {
            v5_3 = 6;
            v65 = arg155;
        }

        long v71 = (v4 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3) : arg157;
        long v73 = (v4 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3) : arg159;
        long v75 = (v4 & 4) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v5_3), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null) : arg161;
        if((v4 & 8) != 0) {
            v5_3 = 6;
            v77 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3);
        }
        else {
            v5_3 = 6;
            v77 = arg163;
        }

        long v79 = (v4 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3) : arg165;
        long v81 = (v4 & 0x20) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_3) : arg167;
        long v83 = (v4 & 0x40) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v5_3), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null) : arg169;
        long v85 = (v4 & 0x80) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, 6) : arg171;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-375683630, v1, v2, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:634)");
        }

        int v89 = v2 & 0x7FFFFFFE;
        v3 = arg177 << 12;
        v2 = arg177 >> 18;
        TextFieldColors v0_1 = TextFieldDefaults.INSTANCE.colors-0hiis_0(v8, v10, v12, v14, v16, v18, v20, v22, v24, v26, v96, v29, v31, v6, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v57, v59, v61, v63, v65, 0, 0, 0, 0, v71, v73, v75, v77, v79, v81, v83, v85, v0, arg174 & 0x7FFFFFFE, v89, arg176 & 0x7FFFFFFE, arg177 & 14 | 0x70000 & v3 | 0x380000 & v3 | 0x1C00000 & v3 | 0xE000000 & v3 | v3 & 0x70000000, v2 & 14 | 0xC00 | v2 & 0x70 | v2 & 0x380, 0, 15);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg173);
        return v0_1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public final TextFieldColors textFieldColors-St-qZLY(long arg87, long arg89, long arg91, long arg93, long arg95, TextSelectionColors arg97, long arg98, long arg100, long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, Composer arg134, int arg135, int arg136, int arg137, int arg138) {
        Object v22;
        Composer v0 = arg134;
        int v1 = arg135;
        int v2 = arg136;
        int v3 = arg138;
        int v5 = 0x87FF6DCB;
        ComposerKt.sourceInformationMarkerStart(v0, v5, "C(textFieldColors)N(textColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedIndicatorColor:c#ui.graphics.Color,unfocusedIndicatorColor:c#ui.graphics.Color,disabledIndicatorColor:c#ui.graphics.Color,errorIndicatorColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,placeholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)1080@59201L5,1082@59308L5,1085@59495L5,1086@59576L5,1087@59672L5,1088@59751L7,1090@59871L5,1092@59986L5,1094@60108L5,1098@60333L5,1100@60449L5,1101@60550L5,1103@60670L5,1107@60889L5,1109@61007L5,1111@61122L5,1113@61244L5,1117@61466L5,1118@61558L5,1119@61647L5,1120@61743L5,1121@61833L5,1122@61924L5,1124@62038L5,1160@63993L5,1161@64087L5,1163@64204L5,1166@64408L5,1167@64500L5,1168@64594L5,1170@64711L5,1173@64915L5,1128@62177L2754:ExposedDropdownMenu.kt#uh7d8r");
        int v6 = 6;
        long v7 = (v3 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), v0, v6) : arg87;
        long v9 = (v3 & 2) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), v0, v6), FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0f, 0f, 0f, 14, null) : arg89;
        long v11 = (v3 & 4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), v0, v6) : arg91;
        long v18 = (v3 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), v0, v6) : arg93;
        long v20 = (v3 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), v0, v6) : arg95;
        if((v3 & 0x20) != 0) {
            ProvidableCompositionLocal v4 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v4_1 = v0.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(v0);
            v22 = v4_1;
        }
        else {
            TextSelectionColors v22_1 = arg97;
        }

        long v23 = (v3 & 0x40) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), v0, v6) : arg98;
        long v25 = (v3 & 0x80) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), v0, v6) : arg100;
        long v27 = (v3 & 0x100) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), v0, v6), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), 0f, 0f, 0f, 14, null) : arg102;
        long v29 = (v3 & 0x200) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), v0, v6) : arg104;
        long v31 = (v3 & 0x400) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), v0, v6) : arg106;
        long v33 = (v3 & 0x800) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), v0, v6) : arg108;
        long v35 = (v3 & 0x1000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), v0, v6), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null) : arg110;
        long v37 = (v3 & 0x2000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), v0, v6) : arg112;
        long v39 = (v3 & 0x4000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), v0, v6) : arg114;
        long v41 = (0x8000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), v0, v6) : arg116;
        long v43 = (0x10000 & v3) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), v0, v6), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null) : arg118;
        long v45 = (0x20000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), v0, v6) : arg120;
        long v47 = (0x40000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), v0, v6) : arg122;
        long v49 = (0x80000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), v0, v6) : arg124;
        long v51 = (0x100000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), v0, v6) : arg126;
        long v53 = (0x200000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), v0, v6) : arg128;
        long v55 = (0x400000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6) : arg130;
        long v59 = (v3 & 0x800000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), v0, v6), FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0f, 0f, 0f, 14, null) : arg132;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v5, v1, v2, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:1128)");
        }

        int v4_2 = v1 << 3;
        v3 = v1 & 14 | v4_2 & 0x70 | v4_2 & 0x380;
        v4_2 = v1 << 9;
        v3 = v3 | v4_2 & 0x1C00 | v1 << 6 & 0xE000 | v4_2 & 0x70000;
        v4_2 = v1 << 15;
        int v80 = v3 | v1 << 12 & 0x380000 | v4_2 & 0x1C00000 | v4_2 & 0xE000000 | v4_2 & 0x70000000;
        v4_2 = v2 << 15;
        int v81 = v1 >> 15 & 0xFFFE | v4_2 & 0x70000 | v4_2 & 0x380000 | v4_2 & 0x1C00000 | v4_2 & 0xE000000 | v4_2 & 0x70000000;
        v1 = v2 >> 15 & 0xFFFE;
        v2 = arg137 << 15;
        v3 = arg137 << 18;
        TextFieldColors v0_1 = this.textFieldColors-FD9MK7s(v7, v7, v9, v7, v11, v11, v11, v11, v18, v20, ((TextSelectionColors)v22), v23, v25, v27, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v55, v59, v55, ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6), Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6), Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v6), OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.getValue(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v6), v0, v80, v81, v1 | v2 & 0x70000 | v2 & 0x380000 | v2 & 0x1C00000 | v3 & 0xE000000 | v3 & 0x70000000, arg137 >> 6 & 14 | v2 & 0x70000000, 0, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg134);
        return v0_1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public final TextFieldColors textFieldColors-tN0la-I(long arg87, long arg89, long arg91, long arg93, long arg95, long arg97, long arg99, long arg101, TextSelectionColors arg103, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, long arg134, long arg136, long arg138, long arg140, long arg142, long arg144, long arg146, long arg148, long arg150, long arg152, long arg154, long arg156, long arg158, Composer arg160, int arg161, int arg162, int arg163, int arg164, int arg165, int arg166) {
        long v69;
        long v61;
        long v45;
        long v37;
        long v29;
        int v5_1;
        long v88;
        long v25;
        TextSelectionColors v4_2;
        Composer v0 = arg160;
        int v1 = arg161;
        int v2 = arg162;
        int v3 = arg165;
        ComposerKt.sourceInformationMarkerStart(v0, 0x50EC8180, "C(textFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,containerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedIndicatorColor:c#ui.graphics.Color,unfocusedIndicatorColor:c#ui.graphics.Color,disabledIndicatorColor:c#ui.graphics.Color,errorIndicatorColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)854@45398L5,855@45486L5,857@45593L5,860@45781L5,861@45869L5,862@45962L5,863@46043L5,864@46139L5,865@46218L7,867@46338L5,869@46453L5,871@46575L5,875@46800L5,877@46916L5,878@47017L5,880@47137L5,884@47356L5,886@47474L5,888@47589L5,890@47711L5,894@47933L5,895@48025L5,896@48114L5,897@48210L5,898@48300L5,899@48398L5,900@48498L5,902@48617L5,905@48817L5,906@48910L5,907@49005L5,909@49119L5,912@49314L5,913@49407L5,914@49502L5,916@49616L5,919@49811L5,921@49851L2215:ExposedDropdownMenu.kt#uh7d8r");
        int v6 = 6;
        long v7 = (v3 & 1) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusInputTextColor(), v0, v6) : arg87;
        long v9 = (v3 & 2) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), v0, v6) : arg89;
        long v11 = (v3 & 4) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), v0, v6), FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextOpacity(), 0f, 0f, 0f, 14, null) : arg91;
        long v13 = (v3 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorInputTextColor(), v0, v6) : arg93;
        long v15 = (v3 & 16) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), v0, v6) : arg95;
        long v17 = (v3 & 0x20) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), v0, v6) : arg97;
        long v19 = (v3 & 0x40) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), v0, v6) : arg99;
        long v21 = (v3 & 0x80) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), v0, v6) : arg101;
        if((v3 & 0x100) != 0) {
            ProvidableCompositionLocal v4 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v4_1 = v0.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(v0);
        }
        else {
            v4_2 = arg103;
        }

        if((v3 & 0x200) != 0) {
            v6 = 6;
            v25 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), v0, v6);
        }
        else {
            v6 = 6;
            v25 = arg104;
        }

        long v27 = (v3 & 0x400) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), v0, v6) : arg106;
        long v5 = (v3 & 0x800) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), v0, v6), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorOpacity(), 0f, 0f, 0f, 14, null) : arg108;
        Object v87 = v4_2;
        if((v3 & 0x1000) != 0) {
            v88 = v5;
            v5_1 = 6;
            v29 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), v0, v5_1);
        }
        else {
            v88 = v5;
            v5_1 = 6;
            v29 = arg110;
        }

        long v31 = (v3 & 0x2000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), v0, v5_1) : arg112;
        long v33 = (v3 & 0x4000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), v0, v5_1) : arg114;
        long v35 = (0x8000 & v3) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), v0, v5_1), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null) : arg116;
        if((0x10000 & v3) != 0) {
            v5_1 = 6;
            v37 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), v0, v5_1);
        }
        else {
            v5_1 = 6;
            v37 = arg118;
        }

        long v39 = (0x20000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), v0, v5_1) : arg120;
        long v41 = (0x40000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), v0, v5_1) : arg122;
        long v43 = (0x80000 & v3) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), v0, v5_1), FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null) : arg124;
        if((0x100000 & v3) != 0) {
            v5_1 = 6;
            v45 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), v0, v5_1);
        }
        else {
            v5_1 = 6;
            v45 = arg126;
        }

        long v47 = (0x200000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), v0, v5_1) : arg128;
        long v49 = (0x400000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), v0, v5_1) : arg130;
        long v51 = (0x800000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), v0, v5_1) : arg132;
        long v53 = (0x1000000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), v0, v5_1) : arg134;
        long v55 = (0x2000000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1) : arg136;
        long v57 = (0x4000000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1) : arg138;
        long v59 = (0x8000000 & v3) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v5_1), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null) : arg140;
        if((0x10000000 & v3) != 0) {
            v5_1 = 6;
            v61 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1);
        }
        else {
            v5_1 = 6;
            v61 = arg142;
        }

        long v63 = (0x20000000 & v3) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1) : arg144;
        long v65 = (v3 & 0x40000000) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1) : arg146;
        long v67 = (arg166 & 1) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v5_1), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null) : arg148;
        if((arg166 & 2) != 0) {
            v5_1 = 6;
            v69 = ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1);
        }
        else {
            v5_1 = 6;
            v69 = arg150;
        }

        long v71 = (arg166 & 4) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1) : arg152;
        long v73 = (arg166 & 8) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, v5_1) : arg154;
        long v75 = (arg166 & 16) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextColor(), v0, v5_1), FilledAutocompleteTokens.INSTANCE.getFieldDisabledSupportingTextOpacity(), 0f, 0f, 0f, 14, null) : arg156;
        long v77 = (arg166 & 0x20) != 0 ? ColorSchemeKt.getValue(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), v0, 6) : arg158;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(0x50EC8180, v1, v2, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:921)");
        }

        int v4_3 = v1 << 6;
        v3 = 0xFFFE & v1 | v1 << 3 & 0x70000 | v4_3 & 0x380000 | v4_3 & 0x1C00000 | v4_3 & 0xE000000 | v4_3 & 0x70000000;
        v4_3 = v2 << 6;
        int v81 = v1 >> 24 & 0x7E | v4_3 & 0x380 | v4_3 & 0x1C00 | v4_3 & 0xE000 | v4_3 & 0x70000 | v4_3 & 0x380000 | v4_3 & 0x1C00000 | v4_3 & 0xE000000 | v4_3 & 0x70000000;
        v1 = v2 >> 24 & 0x7E;
        v2 = arg163 << 6;
        int v82 = v1 | v2 & 0x380 | v2 & 0x1C00 | v2 & 0xE000 | v2 & 0x70000 | v2 & 0x380000 | v2 & 0x1C00000 | v2 & 0xE000000 | v2 & 0x70000000;
        v2 = arg164 << 6;
        TextFieldColors v0_1 = this.textFieldColors-FD9MK7s(v7, v9, v11, v13, v15, v15, v15, v17, v19, v21, v87, v25, v27, v88, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v57, v59, v61, v63, v65, v67, v69, v71, v73, v75, v77, v0, v3, v81, v82, arg163 >> 24 & 0x7E | v2 & 0x380 | v2 & 0x1C00 | v2 & 0xE000 | v2 & 0x70000 | v2 & 0x380000 | v2 & 0x1C00000 | v2 & 0xE000000 | v2 & 0x70000000, 0, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg160);
        return v0_1;
    }
}

