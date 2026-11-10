package androidx.compose.ui.autofill;

import android.view.View;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0016J\u0010\u0010\u001A\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u0011X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001B"}, d2={"Landroidx/compose/ui/autofill/AndroidAutofill;", "Landroidx/compose/ui/autofill/Autofill;", "view", "Landroid/view/View;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "<init>", "(Landroid/view/View;Landroidx/compose/ui/autofill/AutofillTree;)V", "getView", "()Landroid/view/View;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "autofillManager", "Landroid/view/autofill/AutofillManager;", "getAutofillManager", "()Landroid/view/autofill/AutofillManager;", "rootAutofillId", "Landroid/view/autofill/AutofillId;", "getRootAutofillId", "()Landroid/view/autofill/AutofillId;", "setRootAutofillId", "(Landroid/view/autofill/AutofillId;)V", "requestAutofillForNode", "", "autofillNode", "Landroidx/compose/ui/autofill/AutofillNode;", "cancelAutofillForNode", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidAutofill implements Autofill {
    public static final int $stable = 8;
    private final AutofillManager autofillManager;
    private final AutofillTree autofillTree;
    private AutofillId rootAutofillId;
    private final View view;

    static {
    }

    public AndroidAutofill(View arg2, AutofillTree arg3) {
        super();
        this.view = arg2;
        this.autofillTree = arg3;
        Object v3 = arg2.getContext().getSystemService(AutofillManager.class);
        if(v3 != null) {
            this.autofillManager = ((AutofillManager)v3);
            arg2.setImportantForAutofill(1);
            AutofillIdCompat v2 = ViewCompatShims.getAutofillId(arg2);
            AutofillId v2_1 = v2 != null ? v2.toAutofillId() : null;
            if(v2_1 != null) {
                this.rootAutofillId = v2_1;
                return;
            }

            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
            throw new KotlinNothingValueException();
        }

        throw new IllegalStateException("Autofill service could not be located.".toString());
    }

    public void cancelAutofillForNode(AutofillNode arg2) {
        this.autofillManager.notifyViewExited(this.view, arg2.getId());
    }

    public final AutofillManager getAutofillManager() {
        return this.autofillManager;
    }

    public final AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final AutofillId getRootAutofillId() {
        return this.rootAutofillId;
    }

    public final View getView() {
        return this.view;
    }

    public void requestAutofillForNode(AutofillNode arg7) {
        Rect v0 = arg7.getBoundingBox();
        if(v0 != null) {
            this.autofillManager.notifyViewEntered(this.view, arg7.getId(), new android.graphics.Rect(Math.round(v0.getLeft()), Math.round(v0.getTop()), Math.round(v0.getRight()), Math.round(v0.getBottom())));
            return;
        }

        throw new IllegalStateException("requestAutofill called before onChildPositioned()".toString());
    }

    public final void setRootAutofillId(AutofillId arg1) {
        this.rootAutofillId = arg1;
    }
}

