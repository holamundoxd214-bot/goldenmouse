package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public class AllCapsTransformationMethod implements TransformationMethod {
    private Locale mLocale;

    public AllCapsTransformationMethod(Context arg1) {
        super();
        this.mLocale = arg1.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence arg1, View arg2) {
        if(arg1 != null) {
            return arg1.toString().toUpperCase(this.mLocale);
        }

        return null;
    }

    public void onFocusChanged(View arg1, CharSequence arg2, boolean arg3, int arg4, Rect arg5) {
    }
}

