package androidx.compose.ui.platform.coreshims;

import android.os.Bundle;
import android.view.ViewStructure;

public class ViewStructureCompat {
    class Api23Impl {
        private Api23Impl() {
            super();
        }

        static Bundle getExtras(ViewStructure arg0) {
            return arg0.getExtras();
        }

        static void setClassName(ViewStructure arg0, String arg1) {
            arg0.setClassName(arg1);
        }

        static void setContentDescription(ViewStructure arg0, CharSequence arg1) {
            arg0.setContentDescription(arg1);
        }

        static void setDimens(ViewStructure arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
            arg0.setDimens(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        static void setId(ViewStructure arg0, int arg1, String arg2, String arg3, String arg4) {
            arg0.setId(arg1, arg2, arg3, arg4);
        }

        static void setText(ViewStructure arg0, CharSequence arg1) {
            arg0.setText(arg1);
        }

        static void setTextStyle(ViewStructure arg0, float arg1, int arg2, int arg3, int arg4) {
            arg0.setTextStyle(arg1, arg2, arg3, arg4);
        }
    }

    private final Object mWrappedObj;

    private ViewStructureCompat(ViewStructure arg1) {
        super();
        this.mWrappedObj = arg1;
    }

    public Bundle getExtras() {
        return Api23Impl.getExtras(this.mWrappedObj);
    }

    public void setClassName(String arg1) {
        Api23Impl.setClassName(this.mWrappedObj, arg1);
    }

    public void setContentDescription(CharSequence arg1) {
        Api23Impl.setContentDescription(this.mWrappedObj, arg1);
    }

    public void setDimens(int arg8, int arg9, int arg10, int arg11, int arg12, int arg13) {
        Api23Impl.setDimens(this.mWrappedObj, arg8, arg9, arg10, arg11, arg12, arg13);
    }

    public void setId(int arg1, String arg2, String arg3, String arg4) {
        Api23Impl.setId(this.mWrappedObj, arg1, arg2, arg3, arg4);
    }

    public void setText(CharSequence arg1) {
        Api23Impl.setText(this.mWrappedObj, arg1);
    }

    public void setTextStyle(float arg1, int arg2, int arg3, int arg4) {
        Api23Impl.setTextStyle(this.mWrappedObj, arg1, arg2, arg3, arg4);
    }

    public ViewStructure toViewStructure() {
        return this.mWrappedObj;
    }

    public static ViewStructureCompat toViewStructureCompat(ViewStructure arg1) {
        return new ViewStructureCompat(arg1);
    }
}

