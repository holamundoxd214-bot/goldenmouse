package androidx.core.view;

import android.view.ViewStructure;

public class ViewStructureCompat {
    private final ViewStructure mWrappedObj;

    private ViewStructureCompat(ViewStructure arg1) {
        super();
        this.mWrappedObj = arg1;
    }

    public void setClassName(String arg1) {
        this.mWrappedObj.setClassName(arg1);
    }

    public void setContentDescription(CharSequence arg1) {
        this.mWrappedObj.setContentDescription(arg1);
    }

    public void setDimens(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        this.mWrappedObj.setDimens(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public void setText(CharSequence arg1) {
        this.mWrappedObj.setText(arg1);
    }

    public ViewStructure toViewStructure() {
        return this.mWrappedObj;
    }

    public static ViewStructureCompat toViewStructureCompat(ViewStructure arg1) {
        return new ViewStructureCompat(arg1);
    }
}

