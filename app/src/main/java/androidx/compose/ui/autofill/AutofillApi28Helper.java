package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007¨\u0006\n"}, d2={"Landroidx/compose/ui/autofill/AutofillApi28Helper;", "", "<init>", "()V", "setMaxTextLength", "", "structure", "Landroid/view/ViewStructure;", "length", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AutofillApi28Helper {
    public static final int $stable;
    public static final AutofillApi28Helper INSTANCE;

    static {
        AutofillApi28Helper.INSTANCE = new AutofillApi28Helper();
    }

    private AutofillApi28Helper() {
        super();
    }

    public final void setMaxTextLength(ViewStructure arg1, int arg2) {
        arg1.setMaxTextLength(arg2);
    }
}

