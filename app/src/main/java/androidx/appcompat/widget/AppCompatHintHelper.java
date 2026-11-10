package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

class AppCompatHintHelper {
    private AppCompatHintHelper() {
        super();
    }

    static InputConnection onCreateInputConnection(InputConnection arg1, EditorInfo arg2, View arg3) {
        if(arg1 != null && arg2.hintText == null) {
            ViewParent v3 = arg3.getParent();
            while((v3 instanceof View)) {
                if((v3 instanceof WithHint)) {
                    arg2.hintText = ((WithHint)v3).getHint();
                    return arg1;
                }
                else {
                    v3 = v3.getParent();
                    continue;
                }

                return arg1;
            }
        }

        return arg1;
    }
}

