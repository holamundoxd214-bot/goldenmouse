package androidx.compose.ui.platform;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\t"}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewTranslationCallbackS;", "", "<init>", "()V", "setViewTranslationCallback", "", "view", "Landroid/view/View;", "clearViewTranslationCallback", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidComposeViewTranslationCallbackS {
    public static final int $stable;
    public static final AndroidComposeViewTranslationCallbackS INSTANCE;

    static {
        AndroidComposeViewTranslationCallbackS.INSTANCE = new AndroidComposeViewTranslationCallbackS();
    }

    private AndroidComposeViewTranslationCallbackS() {
        super();
    }

    public final void clearViewTranslationCallback(View arg1) {
        arg1.clearViewTranslationCallback();
    }

    public final void setViewTranslationCallback(View arg1) {
        arg1.setViewTranslationCallback(AndroidComposeViewTranslationCallback.INSTANCE);
    }
}

