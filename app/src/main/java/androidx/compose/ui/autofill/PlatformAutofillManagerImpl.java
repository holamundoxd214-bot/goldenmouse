package androidx.compose.ui.autofill;

import android.graphics.Rect;
import android.os.Build$VERSION;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import kotlin.Metadata;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0018\u0010\u0010\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J \u0010\u0011\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J \u0010\u0014\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u0016H\u0016J\b\u0010\u0017\u001A\u00020\tH\u0016J\b\u0010\u0018\u001A\u00020\tH\u0016J \u0010\u0019\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u001A"}, d2={"Landroidx/compose/ui/autofill/PlatformAutofillManagerImpl;", "Landroidx/compose/ui/autofill/PlatformAutofillManager;", "platformAndroidManager", "Landroid/view/autofill/AutofillManager;", "<init>", "(Landroid/view/autofill/AutofillManager;)V", "getPlatformAndroidManager", "()Landroid/view/autofill/AutofillManager;", "notifyViewEntered", "", "view", "Landroid/view/View;", "semanticsId", "", "bounds", "Landroid/graphics/Rect;", "notifyViewExited", "notifyValueChanged", "autofillValue", "Landroid/view/autofill/AutofillValue;", "notifyViewVisibilityChanged", "isVisible", "", "commit", "cancel", "requestAutofill", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlatformAutofillManagerImpl implements PlatformAutofillManager {
    public static final int $stable = 8;
    private final AutofillManager platformAndroidManager;

    static {
    }

    public PlatformAutofillManagerImpl(AutofillManager arg1) {
        super();
        this.platformAndroidManager = arg1;
    }

    public void cancel() {
        this.platformAndroidManager.cancel();
    }

    public void commit() {
        this.platformAndroidManager.commit();
    }

    public final AutofillManager getPlatformAndroidManager() {
        return this.platformAndroidManager;
    }

    public void notifyValueChanged(View arg1, int arg2, AutofillValue arg3) {
        this.platformAndroidManager.notifyValueChanged(arg1, arg2, arg3);
    }

    public void notifyViewEntered(View arg1, int arg2, Rect arg3) {
        this.platformAndroidManager.notifyViewEntered(arg1, arg2, arg3);
    }

    public void notifyViewExited(View arg1, int arg2) {
        this.platformAndroidManager.notifyViewExited(arg1, arg2);
    }

    public void notifyViewVisibilityChanged(View arg3, int arg4, boolean arg5) {
        if(Build$VERSION.SDK_INT >= 27) {
            AutofillApi27Helper.INSTANCE.notifyViewVisibilityChanged(arg3, this.platformAndroidManager, arg4, arg5);
        }
    }

    public void requestAutofill(View arg1, int arg2, Rect arg3) {
        this.platformAndroidManager.requestAutofill(arg1, arg2, arg3);
    }
}

