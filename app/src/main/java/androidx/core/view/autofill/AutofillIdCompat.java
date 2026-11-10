package androidx.core.view.autofill;

import android.view.autofill.AutofillId;

public class AutofillIdCompat {
    private final Object mWrappedObj;

    private AutofillIdCompat(AutofillId arg1) {
        super();
        this.mWrappedObj = arg1;
    }

    public AutofillId toAutofillId() {
        return this.mWrappedObj;
    }

    public static AutofillIdCompat toAutofillIdCompat(AutofillId arg1) {
        return new AutofillIdCompat(arg1);
    }
}

