package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.text.StringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.intl.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\n\u001A\u00020\u000B*\u00020\fH\u0016J\b\u0010\r\u001A\u00020\u000EH\u0016J\t\u0010\u000F\u001A\u00020\u0003HÂ\u0003J\u0013\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/text/input/AllCapsTransformation;", "Landroidx/compose/foundation/text/input/InputTransformation;", "locale", "Landroidx/compose/ui/text/intl/Locale;", "<init>", "(Landroidx/compose/ui/text/intl/Locale;)V", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "transformInput", "", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AllCapsTransformation implements InputTransformation {
    private final KeyboardOptions keyboardOptions;
    private final Locale locale;

    public AllCapsTransformation(Locale arg11) {
        super();
        this.locale = arg11;
        this.keyboardOptions = new KeyboardOptions(KeyboardCapitalization.Companion.getCharacters-IUNYP9k(), null, 0, 0, null, null, null, 0x7E, null);
    }

    private final Locale component1() {
        return this.locale;
    }

    public final AllCapsTransformation copy(Locale arg1) {
        return new AllCapsTransformation(arg1);
    }

    public static AllCapsTransformation copy$default(AllCapsTransformation arg0, Locale arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.locale;
        }

        return arg0.copy(arg1);
    }

    public boolean equals(Object arg4) {
        if(this == (((AllCapsTransformation)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof AllCapsTransformation)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.locale, ((AllCapsTransformation)arg4).locale)) {
            return 0;
        }

        return 1;
    }

    public KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    public int hashCode() {
        return this.locale.hashCode();
    }

    public String toString() {
        return "InputTransformation.allCaps(locale=" + this.locale + ')';
    }

    public void transformInput(TextFieldBuffer arg8) {
        ChangeList v0 = arg8.getChanges();
        int v1;
        for(v1 = 0; v1 < v0.getChangeCount(); ++v1) {
            long v2 = v0.getRange--jx7JFs(v1);
            v0.getOriginalRange--jx7JFs(v1);
            if(!TextRange.getCollapsed-impl(v2)) {
                arg8.replace(TextRange.getMin-impl(v2), TextRange.getMax-impl(v2), StringKt.toUpperCase(TextRangeKt.substring-FDrldGo(arg8.asCharSequence(), v2), this.locale));
            }
        }
    }
}

