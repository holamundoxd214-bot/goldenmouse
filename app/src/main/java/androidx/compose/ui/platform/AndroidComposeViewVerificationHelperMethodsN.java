package androidx.compose.ui.platform;

import android.content.Context;
import android.view.View;
import androidx.compose.ui.input.pointer.AndroidPointerIcon;
import androidx.compose.ui.input.pointer.AndroidPointerIconType;
import androidx.compose.ui.input.pointer.PointerIcon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0007J\u001A\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0007¨\u0006\u000E"}, d2={"Landroidx/compose/ui/platform/AndroidComposeViewVerificationHelperMethodsN;", "", "<init>", "()V", "toAndroidPointerIcon", "Landroid/view/PointerIcon;", "context", "Landroid/content/Context;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "setPointerIcon", "", "view", "Landroid/view/View;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class AndroidComposeViewVerificationHelperMethodsN {
    public static final AndroidComposeViewVerificationHelperMethodsN INSTANCE;

    static {
        AndroidComposeViewVerificationHelperMethodsN.INSTANCE = new AndroidComposeViewVerificationHelperMethodsN();
    }

    private AndroidComposeViewVerificationHelperMethodsN() {
        super();
    }

    public final void setPointerIcon(View arg2, PointerIcon arg3) {
        android.view.PointerIcon v1 = this.toAndroidPointerIcon(arg2.getContext(), arg3);
        if(!Intrinsics.areEqual(arg2.getPointerIcon(), v1)) {
            arg2.setPointerIcon(v1);
        }
    }

    public final android.view.PointerIcon toAndroidPointerIcon(Context arg1, PointerIcon arg2) {
        if((arg2 instanceof AndroidPointerIcon)) {
            return ((AndroidPointerIcon)arg2).getPointerIcon();
        }

        if((arg2 instanceof AndroidPointerIconType)) {
            return android.view.PointerIcon.getSystemIcon(arg1, ((AndroidPointerIconType)arg2).getType());
        }

        return android.view.PointerIcon.getSystemIcon(arg1, 1000);
    }
}

