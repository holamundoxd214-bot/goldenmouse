package androidx.compose.ui.autofill;

import android.view.View;
import android.view.autofill.AutofillManager;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0007¨\u0006\u000E"}, d2={"Landroidx/compose/ui/autofill/AutofillApi27Helper;", "", "<init>", "()V", "notifyViewVisibilityChanged", "", "view", "Landroid/view/View;", "autofillManager", "Landroid/view/autofill/AutofillManager;", "semanticsId", "", "isVisible", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AutofillApi27Helper {
    public static final int $stable;
    public static final AutofillApi27Helper INSTANCE;

    static {
        AutofillApi27Helper.INSTANCE = new AutofillApi27Helper();
    }

    private AutofillApi27Helper() {
        super();
    }

    public final void notifyViewVisibilityChanged(View arg1, AutofillManager arg2, int arg3, boolean arg4) {
        arg2.notifyViewVisibilityChanged(arg1, arg3, arg4);
    }
}

