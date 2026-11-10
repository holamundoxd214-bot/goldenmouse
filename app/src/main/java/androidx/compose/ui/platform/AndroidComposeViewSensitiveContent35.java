package androidx.compose.ui.platform;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007¨\u0006\n"}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewSensitiveContent35;", "", "<init>", "()V", "setContentSensitivity", "", "view", "Landroid/view/View;", "isSensitiveContent", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class AndroidComposeViewSensitiveContent35 {
    public static final AndroidComposeViewSensitiveContent35 INSTANCE;

    static {
        AndroidComposeViewSensitiveContent35.INSTANCE = new AndroidComposeViewSensitiveContent35();
    }

    private AndroidComposeViewSensitiveContent35() {
        super();
    }

    public final void setContentSensitivity(View arg1, boolean arg2) {
        if(arg2) {
            arg1.setContentSensitivity(1);
            return;
        }

        arg1.setContentSensitivity(0);
    }
}

