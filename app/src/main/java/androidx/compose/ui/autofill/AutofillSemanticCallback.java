package androidx.compose.ui.autofill;

import android.util.Log;
import android.view.View;
import android.view.autofill.AutofillManager$AutofillCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016J\u000E\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\rJ\u000E\u0010\u000E\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r¨\u0006\u000F"}, d2={"Landroidx/compose/ui/autofill/AutofillSemanticCallback;", "Landroid/view/autofill/AutofillManager$AutofillCallback;", "<init>", "()V", "onAutofillEvent", "", "view", "Landroid/view/View;", "virtualId", "", "event", "register", "androidAutofillManager", "Landroidx/compose/ui/autofill/AndroidAutofillManager;", "unregister", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AutofillSemanticCallback extends AutofillManager$AutofillCallback {
    public static final int $stable;
    public static final AutofillSemanticCallback INSTANCE;

    static {
        AutofillSemanticCallback.INSTANCE = new AutofillSemanticCallback();
        AutofillSemanticCallback.$stable = 8;
    }

    private AutofillSemanticCallback() {
        super();
    }

    public void onAutofillEvent(View arg1, int arg2, int arg3) {
        String v0;
        super.onAutofillEvent(arg1, arg2, arg3);
        if(arg3 == 1) {
            v0 = "Autofill popup was shown.";
        }
        else if(arg3 == 2) {
            v0 = "Autofill popup was hidden.";
        }
        else if(arg3 != 3) {
            v0 = "Unknown status event.";
        }
        else {
            v0 = "Autofill popup isn\'t shown because autofill is not available.\n\nDid you set up autofill?\n1. Go to Settings > System > Languages&input > Advanced > Autofill Service\n2. Pick a service\n\nDid you add an account?\n1. Go to Settings > System > Languages&input > Advanced\n2. Click on the settings icon next to the Autofill Service\n3. Add your account";
        }

        Log.d("Autofill Status", v0);
    }

    public final void register(AndroidAutofillManager arg2) {
        PlatformAutofillManager v2 = arg2.getPlatformAutofillManager();
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.ui.autofill.PlatformAutofillManagerImpl");
        ((PlatformAutofillManagerImpl)v2).getPlatformAndroidManager().registerCallback(((AutofillManager$AutofillCallback)this));
    }

    public final void unregister(AndroidAutofillManager arg2) {
        PlatformAutofillManager v2 = arg2.getPlatformAutofillManager();
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type androidx.compose.ui.autofill.PlatformAutofillManagerImpl");
        ((PlatformAutofillManagerImpl)v2).getPlatformAndroidManager().unregisterCallback(((AutofillManager$AutofillCallback)this));
    }
}

