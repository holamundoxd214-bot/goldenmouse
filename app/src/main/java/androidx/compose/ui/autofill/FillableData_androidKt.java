package androidx.compose.ui.autofill;

import android.view.autofill.AutofillValue;
import kotlin.Metadata;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0014\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004\u001A\u0014\u0010\u0005\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007\u001A\u0014\u0010\b\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\t\u001A\u00020\n\u001A\u0014\u0010\u000B\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\f\u001A\u00020\r\u001A\u0014\u0010\u000E\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0010\u001A\f\u0010\u0011\u001A\u0004\u0018\u00010\u0010*\u00020\u0001¨\u0006\u0012"}, d2={"createFromText", "Landroidx/compose/ui/autofill/FillableData;", "Landroidx/compose/ui/autofill/FillableData$Companion;", "textValue", "", "createFromBoolean", "booleanValue", "", "createFromListIndex", "listIndexValue", "", "createFromDateMillis", "dateMillisValue", "", "createFromAutofillValue", "autofillValue", "Landroid/view/autofill/AutofillValue;", "toAutofillValue", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FillableData_androidKt {
    public static final FillableData createFromAutofillValue(Companion arg0, AutofillValue arg1) {
        return new AndroidFillableData(arg1);
    }

    public static final FillableData createFromBoolean(Companion arg0, boolean arg1) {
        return new AndroidFillableData(AutofillValue.forToggle(arg1));
    }

    public static final FillableData createFromDateMillis(Companion arg0, long arg1) {
        return new AndroidFillableData(AutofillValue.forDate(arg1));
    }

    public static final FillableData createFromListIndex(Companion arg0, int arg1) {
        return new AndroidFillableData(AutofillValue.forList(arg1));
    }

    public static final FillableData createFromText(Companion arg0, CharSequence arg1) {
        return new AndroidFillableData(AutofillValue.forText(arg1));
    }

    public static final AutofillValue toAutofillValue(FillableData arg2) {
        AutofillValue v1 = null;
        if((arg2 instanceof AndroidFillableData)) {
        }
        else {
            arg2 = ((FillableData)v1);
        }

        if(arg2 != null) {
            return ((AndroidFillableData)arg2).getAutofillValue$ui();
        }

        return v1;
    }
}

