package androidx.compose.ui.autofill;

import android.view.autofill.AutofillValue;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u0011H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001A\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0016\u0010\f\u001A\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0016\u0010\u0010\u001A\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001A\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2={"Landroidx/compose/ui/autofill/AndroidFillableData;", "Landroidx/compose/ui/autofill/FillableData;", "autofillValue", "Landroid/view/autofill/AutofillValue;", "<init>", "(Landroid/view/autofill/AutofillValue;)V", "getAutofillValue$ui", "()Landroid/view/autofill/AutofillValue;", "textValue", "", "getTextValue", "()Ljava/lang/CharSequence;", "booleanValue", "", "getBooleanValue", "()Ljava/lang/Boolean;", "listIndexValue", "", "getListIndexValue", "()Ljava/lang/Integer;", "getListIndexOrDefault", "defaultValue", "dateMillisValue", "", "getDateMillisValue", "()Ljava/lang/Long;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidFillableData implements FillableData {
    public static final int $stable = 8;
    private final AutofillValue autofillValue;

    static {
    }

    public AndroidFillableData(AutofillValue arg1) {
        super();
        this.autofillValue = arg1;
    }

    public final AutofillValue getAutofillValue$ui() {
        return this.autofillValue;
    }

    public Boolean getBooleanValue() {
        if(this.autofillValue.isToggle()) {
            return Boolean.valueOf(this.autofillValue.getToggleValue());
        }

        return null;
    }

    public Long getDateMillisValue() {
        if(this.autofillValue.isDate()) {
            return Long.valueOf(this.autofillValue.getDateValue());
        }

        return null;
    }

    public int getListIndexOrDefault(int arg2) {
        if(this.autofillValue.isList()) {
            return this.autofillValue.getListValue();
        }

        return arg2;
    }

    public Integer getListIndexValue() {
        if(this.autofillValue.isList()) {
            return Integer.valueOf(this.autofillValue.getListValue());
        }

        return null;
    }

    public CharSequence getTextValue() {
        if(this.autofillValue.isText()) {
            return this.autofillValue.getTextValue();
        }

        return null;
    }
}

