package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDialogFragment;

public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    class com.google.android.material.bottomsheet.BottomSheetDialogFragment$1 {
    }

    class BottomSheetDismissCallback extends BottomSheetCallback {
        BottomSheetDismissCallback(BottomSheetDialogFragment arg1, com.google.android.material.bottomsheet.BottomSheetDialogFragment$1 arg2) {
            this(arg1);
        }

        private BottomSheetDismissCallback(BottomSheetDialogFragment arg1) {
            BottomSheetDialogFragment.this = arg1;
            super();
        }

        public void onSlide(View arg1, float arg2) {
        }

        public void onStateChanged(View arg1, int arg2) {
            if(arg2 == 5) {
                BottomSheetDialogFragment.this.dismissAfterAnimation();
            }
        }
    }

    private boolean waitingForDismissAllowingStateLoss;

    public BottomSheetDialogFragment() {
        super();
    }

    public BottomSheetDialogFragment(int arg1) {
        super(arg1);
    }

    static void access$100(BottomSheetDialogFragment arg0) {
        arg0.dismissAfterAnimation();
    }

    public void dismiss() {
        if(!this.tryDismissWithAnimation(false)) {
            super.dismiss();
        }
    }

    private void dismissAfterAnimation() {
        if(this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
            return;
        }

        super.dismiss();
    }

    public void dismissAllowingStateLoss() {
        if(!this.tryDismissWithAnimation(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    private void dismissWithAnimation(BottomSheetBehavior arg3, boolean arg4) {
        this.waitingForDismissAllowingStateLoss = arg4;
        int v0 = 5;
        if(arg3.getState() == v0) {
            this.dismissAfterAnimation();
            return;
        }

        if((this.getDialog() instanceof BottomSheetDialog)) {
            this.getDialog().removeDefaultCallback();
        }

        arg3.addBottomSheetCallback(new BottomSheetDismissCallback(this, null));
        arg3.setState(v0);
    }

    public Dialog onCreateDialog(Bundle arg2) {
        return new BottomSheetDialog(this.getContext(), this.getTheme());
    }

    private boolean tryDismissWithAnimation(boolean arg4) {
        Dialog v0 = this.getDialog();
        if((v0 instanceof BottomSheetDialog)) {
            BottomSheetBehavior v1 = ((BottomSheetDialog)v0).getBehavior();
            if((v1.isHideable()) && (((BottomSheetDialog)v0).getDismissWithAnimation())) {
                this.dismissWithAnimation(v1, arg4);
                return 1;
            }
        }

        return 0;
    }
}

