package androidx.compose.ui.platform;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewVerificationHelperMethodsO;", "", "<init>", "()V", "focusable", "", "view", "Landroid/view/View;", "", "defaultFocusHighlightEnabled", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class AndroidComposeViewVerificationHelperMethodsO {
    public static final AndroidComposeViewVerificationHelperMethodsO INSTANCE;

    static {
        AndroidComposeViewVerificationHelperMethodsO.INSTANCE = new AndroidComposeViewVerificationHelperMethodsO();
    }

    private AndroidComposeViewVerificationHelperMethodsO() {
        super();
    }

    public final void focusable(View arg1, int arg2, boolean arg3) {
        arg1.setFocusable(arg2);
        arg1.setDefaultFocusHighlightEnabled(arg3);
    }
}

