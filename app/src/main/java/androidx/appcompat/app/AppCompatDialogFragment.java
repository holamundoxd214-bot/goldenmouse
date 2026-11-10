package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

public class AppCompatDialogFragment extends DialogFragment {
    public AppCompatDialogFragment() {
        super();
    }

    public AppCompatDialogFragment(int arg1) {
        super(arg1);
    }

    public Dialog onCreateDialog(Bundle arg2) {
        return new AppCompatDialog(this.getContext(), this.getTheme());
    }

    public void setupDialog(Dialog arg3, int arg4) {
        if((arg3 instanceof AppCompatDialog)) {
            Dialog v2 = arg3;
            if(arg4 != 1 && arg4 != 2) {
                if(arg4 != 3) {
                    return;
                }
                else {
                    arg3.getWindow().addFlags(24);
                }
            }

            ((AppCompatDialog)v2).supportRequestWindowFeature(1);
            return;
        }

        super.setupDialog(arg3, arg4);
    }
}

