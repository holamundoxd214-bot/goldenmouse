package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View$OnClickListener;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppCompatViewInflater {
    class DeclaredOnClickListener implements View$OnClickListener {
        private final View mHostView;
        private final String mMethodName;
        private Context mResolvedContext;
        private Method mResolvedMethod;

        public DeclaredOnClickListener(View arg1, String arg2) {
            super();
            this.mHostView = arg1;
            this.mMethodName = arg2;
        }

        public void onClick(View arg2) {
            if(this.mResolvedMethod == null) {
                this.resolveMethod(this.mHostView.getContext());
            }

            try {
                this.mResolvedMethod.invoke(this.mResolvedContext, arg2);
                return;
            }
            catch(InvocationTargetException v1) {
                throw new IllegalStateException("Could not execute method for android:onClick", ((Throwable)v1));
            }
            catch(IllegalAccessException v1_1) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", ((Throwable)v1_1));
            }
        }

        private void resolveMethod(Context arg6) {
            while(arg6 != null) {
                try {
                    if(!arg6.isRestricted()) {
                        Method v0 = arg6.getClass().getMethod(this.mMethodName, View.class);
                        if(v0 != null) {
                            this.mResolvedMethod = v0;
                            this.mResolvedContext = arg6;
                            return;
                        }
                    }

                    goto label_15;
                }
                catch(NoSuchMethodException ) {
                label_15:
                    if((arg6 instanceof ContextWrapper)) {
                        arg6 = ((ContextWrapper)arg6).getBaseContext();
                        continue;
                    }

                    arg6 = null;
                    continue;
                }
            }

            int v6 = this.mHostView.getId();
            String v6_1 = v6 == -1 ? "" : " with id \'" + this.mHostView.getContext().getResources().getResourceEntryName(v6) + "\'";
            throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + v6_1);
        }
    }

    private static final String LOG_TAG = "AppCompatViewInflater";
    private final Object[] mConstructorArgs;
    private static final int[] sAccessibilityHeading;
    private static final int[] sAccessibilityPaneTitle;
    private static final String[] sClassPrefixList;
    private static final SimpleArrayMap sConstructorMap;
    private static final Class[] sConstructorSignature;
    private static final int[] sOnClickAttrs;
    private static final int[] sScreenReaderFocusable;

    static {
        AppCompatViewInflater.sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
        AppCompatViewInflater.sOnClickAttrs = new int[]{0x101026F};
        AppCompatViewInflater.sAccessibilityHeading = new int[]{0x1010580};
        AppCompatViewInflater.sAccessibilityPaneTitle = new int[]{0x101057C};
        AppCompatViewInflater.sScreenReaderFocusable = new int[]{0x1010574};
        AppCompatViewInflater.sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
        AppCompatViewInflater.sConstructorMap = new SimpleArrayMap();
    }

    public AppCompatViewInflater() {
        super();
        this.mConstructorArgs = new Object[2];
    }

    private void backportAccessibilityAttributes(Context arg3, View arg4, AttributeSet arg5) {
        if(Build$VERSION.SDK_INT > 28) {
            return;
        }

        TypedArray v2 = arg3.obtainStyledAttributes(arg5, AppCompatViewInflater.sAccessibilityHeading);
        if(v2.hasValue(0)) {
            ViewCompat.setAccessibilityHeading(arg4, v2.getBoolean(0, false));
        }

        v2.recycle();
        v2 = arg3.obtainStyledAttributes(arg5, AppCompatViewInflater.sAccessibilityPaneTitle);
        if(v2.hasValue(0)) {
            ViewCompat.setAccessibilityPaneTitle(arg4, v2.getString(0));
        }

        v2.recycle();
        v2 = arg3.obtainStyledAttributes(arg5, AppCompatViewInflater.sScreenReaderFocusable);
        if(v2.hasValue(0)) {
            ViewCompat.setScreenReaderFocusable(arg4, v2.getBoolean(0, false));
        }

        v2.recycle();
    }

    private void checkOnClickListener(View arg2, AttributeSet arg3) {
        Context v1 = arg2.getContext();
        if((v1 instanceof ContextWrapper)) {
            if(!ViewCompat.hasOnClickListeners(arg2)) {
            }
            else {
                TypedArray v1_1 = v1.obtainStyledAttributes(arg3, AppCompatViewInflater.sOnClickAttrs);
                String v3 = v1_1.getString(0);
                if(v3 != null) {
                    arg2.setOnClickListener(new DeclaredOnClickListener(arg2, v3));
                }

                v1_1.recycle();
            }
        }
    }

    protected AppCompatAutoCompleteTextView createAutoCompleteTextView(Context arg1, AttributeSet arg2) {
        return new AppCompatAutoCompleteTextView(arg1, arg2);
    }

    protected AppCompatButton createButton(Context arg1, AttributeSet arg2) {
        return new AppCompatButton(arg1, arg2);
    }

    protected AppCompatCheckBox createCheckBox(Context arg1, AttributeSet arg2) {
        return new AppCompatCheckBox(arg1, arg2);
    }

    protected AppCompatCheckedTextView createCheckedTextView(Context arg1, AttributeSet arg2) {
        return new AppCompatCheckedTextView(arg1, arg2);
    }

    protected AppCompatEditText createEditText(Context arg1, AttributeSet arg2) {
        return new AppCompatEditText(arg1, arg2);
    }

    protected AppCompatImageButton createImageButton(Context arg1, AttributeSet arg2) {
        return new AppCompatImageButton(arg1, arg2);
    }

    protected AppCompatImageView createImageView(Context arg1, AttributeSet arg2) {
        return new AppCompatImageView(arg1, arg2);
    }

    protected AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context arg1, AttributeSet arg2) {
        return new AppCompatMultiAutoCompleteTextView(arg1, arg2);
    }

    protected AppCompatRadioButton createRadioButton(Context arg1, AttributeSet arg2) {
        return new AppCompatRadioButton(arg1, arg2);
    }

    protected AppCompatRatingBar createRatingBar(Context arg1, AttributeSet arg2) {
        return new AppCompatRatingBar(arg1, arg2);
    }

    protected AppCompatSeekBar createSeekBar(Context arg1, AttributeSet arg2) {
        return new AppCompatSeekBar(arg1, arg2);
    }

    protected AppCompatSpinner createSpinner(Context arg1, AttributeSet arg2) {
        return new AppCompatSpinner(arg1, arg2);
    }

    protected AppCompatTextView createTextView(Context arg1, AttributeSet arg2) {
        return new AppCompatTextView(arg1, arg2);
    }

    protected AppCompatToggleButton createToggleButton(Context arg1, AttributeSet arg2) {
        return new AppCompatToggleButton(arg1, arg2);
    }

    public final View createView(View arg1, String arg2, Context arg3, AttributeSet arg4, boolean arg5, boolean arg6, boolean arg7, boolean arg8) {
        View v5;
        AppCompatRadioButton v5_11;
        Context v1 = !arg5 || arg1 == null ? arg3 : arg1.getContext();
        if((arg6) || (arg7)) {
            v1 = AppCompatViewInflater.themifyContext(v1, arg4, arg6, arg7);
        }

        if(arg8) {
            v1 = TintContextWrapper.wrap(v1);
        }

        arg2.hashCode();
        int v6 = -1;
        switch(arg2.hashCode()) {
            case -937446323: {
                if(!arg2.equals("ImageButton")) {
                    goto label_98;
                }

                v6 = 4;
                break;
            }
            case -658531749: {
                if(!arg2.equals("SeekBar")) {
                    goto label_98;
                }

                v6 = 5;
                break;
            }
            case -339785223: {
                if(!arg2.equals("Spinner")) {
                    goto label_98;
                }

                v6 = 6;
                break;
            }
            case 776382189: {
                if(!arg2.equals("RadioButton")) {
                    goto label_98;
                }

                v6 = 7;
                break;
            }
            case 799298502: {
                if(!arg2.equals("ToggleButton")) {
                    goto label_98;
                }

                v6 = 8;
                break;
            }
            case 1125864064: {
                if(!arg2.equals("ImageView")) {
                    goto label_98;
                }

                v6 = 9;
                break;
            }
            case 1413872058: {
                if(!arg2.equals("AutoCompleteTextView")) {
                    goto label_98;
                }

                v6 = 10;
                break;
            }
            case 1601505219: {
                if(!arg2.equals("CheckBox")) {
                    goto label_98;
                }

                v6 = 11;
                break;
            }
            case 1666676343: {
                if(!arg2.equals("EditText")) {
                    goto label_98;
                }

                v6 = 12;
                break;
            }
            case 2001146706: {
                if(!arg2.equals("Button")) {
                    goto label_98;
                }

                v6 = 13;
                break;
            }
            case -1946472170: {
                if(!arg2.equals("RatingBar")) {
                    goto label_98;
                }

                v6 = 0;
                break;
            }
            case -1455429095: {
                if(!arg2.equals("CheckedTextView")) {
                    goto label_98;
                }

                v6 = 1;
                break;
            }
            case -1346021293: {
                if(!arg2.equals("MultiAutoCompleteTextView")) {
                    goto label_98;
                }

                v6 = 2;
                break;
            }
            case -938935918: {
                if(!arg2.equals("TextView")) {
                    goto label_98;
                }

                v6 = 3;
                break;
            }
            default: {
                break;
            }
        }

    label_98:
        switch(v6) {
            case 0: {
                AppCompatRatingBar v5_7 = this.createRatingBar(v1, arg4);
                this.verifyNotNull(((View)v5_7), arg2);
                break;
            }
            case 1: {
                AppCompatCheckedTextView v5_5 = this.createCheckedTextView(v1, arg4);
                this.verifyNotNull(((View)v5_5), arg2);
                break;
            }
            case 2: {
                AppCompatMultiAutoCompleteTextView v5_3 = this.createMultiAutoCompleteTextView(v1, arg4);
                this.verifyNotNull(((View)v5_3), arg2);
                break;
            }
            case 3: {
                AppCompatTextView v5_1 = this.createTextView(v1, arg4);
                this.verifyNotNull(((View)v5_1), arg2);
                break;
            }
            case 4: {
                AppCompatImageButton v5_14 = this.createImageButton(v1, arg4);
                this.verifyNotNull(((View)v5_14), arg2);
                break;
            }
            case 5: {
                AppCompatSeekBar v5_13 = this.createSeekBar(v1, arg4);
                this.verifyNotNull(((View)v5_13), arg2);
                break;
            }
            case 6: {
                AppCompatSpinner v5_12 = this.createSpinner(v1, arg4);
                this.verifyNotNull(((View)v5_12), arg2);
                break;
            }
            case 7: {
                v5_11 = this.createRadioButton(v1, arg4);
                this.verifyNotNull(((View)v5_11), arg2);
                break;
            }
            case 8: {
                AppCompatToggleButton v5_10 = this.createToggleButton(v1, arg4);
                this.verifyNotNull(((View)v5_10), arg2);
                break;
            }
            case 9: {
                AppCompatImageView v5_9 = this.createImageView(v1, arg4);
                this.verifyNotNull(((View)v5_9), arg2);
                break;
            }
            case 10: {
                AppCompatAutoCompleteTextView v5_8 = this.createAutoCompleteTextView(v1, arg4);
                this.verifyNotNull(((View)v5_8), arg2);
                break;
            }
            case 11: {
                AppCompatCheckBox v5_6 = this.createCheckBox(v1, arg4);
                this.verifyNotNull(((View)v5_6), arg2);
                break;
            }
            case 12: {
                AppCompatEditText v5_4 = this.createEditText(v1, arg4);
                this.verifyNotNull(((View)v5_4), arg2);
                break;
            }
            case 13: {
                AppCompatButton v5_2 = this.createButton(v1, arg4);
                this.verifyNotNull(((View)v5_2), arg2);
                break;
            }
            default: {
                v5 = this.createView(v1, arg2, arg4);
                break;
            }
        }

        if((((View)v5_11)) == null && arg3 != v1) {
            v5 = this.createViewFromTag(v1, arg2, arg4);
        }

        if((((View)v5_11)) != null) {
            this.checkOnClickListener(((View)v5_11), arg4);
            this.backportAccessibilityAttributes(v1, ((View)v5_11), arg4);
        }

        return ((View)v5_11);
    }

    protected View createView(Context arg1, String arg2, AttributeSet arg3) {
        return null;
    }

    private View createViewByPrefix(Context arg3, String arg4, String arg5) throws ClassNotFoundException, InflateException {
        SimpleArrayMap v0 = AppCompatViewInflater.sConstructorMap;
        Object v1 = v0.get(arg4);
        if(v1 == null) {
            if(arg5 != null) {
                try {
                    arg5 = arg5 + arg4;
                    goto label_11;
                label_10:
                    arg5 = arg4;
                label_11:
                    Constructor v1_1 = Class.forName(arg5, false, arg3.getClassLoader()).asSubclass(View.class).getConstructor(AppCompatViewInflater.sConstructorSignature);
                    v0.put(arg4, v1_1);
                label_19:
                    v1_1.setAccessible(true);
                    return v1_1.newInstance(this.mConstructorArgs);
                }
                catch(Exception ) {
                    return null;
                }
            }
            else {
                goto label_10;
            }

            goto label_11;
        }

        goto label_19;
    }

    private View createViewFromTag(Context arg6, String arg7, AttributeSet arg8) {
        View v6_1;
        View v3_2;
        int v8;
        String v1 = null;
        if(arg7.equals("view")) {
            arg7 = arg8.getAttributeValue(v1, "class");
        }

        try {
            Object[] v3 = this.mConstructorArgs;
            v3[0] = arg6;
            v3[1] = arg8;
            if(-1 != arg7.indexOf(46)) {
                goto label_32;
            }

            v8 = 0;
            while(true) {
            label_16:
                String[] v3_1 = AppCompatViewInflater.sClassPrefixList;
                if(v8 >= v3_1.length) {
                    goto label_28;
                }

                v3_2 = this.createViewByPrefix(arg6, arg7, v3_1[v8]);
                if(v3_2 == null) {
                    goto label_26;
                }

                break;
            }
        }
        catch(Throwable v6) {
            goto label_38;
        }
        catch(Exception ) {
            goto label_42;
        }

        Object[] v5 = this.mConstructorArgs;
        v5[0] = v1;
        v5[1] = v1;
        return v3_2;
    label_26:
        ++v8;
        goto label_16;
    label_28:
        v5 = this.mConstructorArgs;
        v5[0] = v1;
        v5[1] = v1;
        return ((View)v1);
        try {
        label_32:
            v6_1 = this.createViewByPrefix(arg6, arg7, v1);
        }
        catch(Throwable v6) {
        label_38:
            v5 = this.mConstructorArgs;
            v5[0] = v1;
            v5[1] = v1;
            throw v6;
        }
        catch(Exception ) {
        label_42:
            v5 = this.mConstructorArgs;
            v5[0] = v1;
            v5[1] = v1;
            return ((View)v1);
        }

        v5 = this.mConstructorArgs;
        v5[0] = v1;
        v5[1] = v1;
        return v6_1;
    }

    private static Context themifyContext(Context arg2, AttributeSet arg3, boolean arg4, boolean arg5) {
        TypedArray v3 = arg2.obtainStyledAttributes(arg3, styleable.View, 0, 0);
        int v4 = arg4 ? v3.getResourceId(styleable.View_android_theme, 0) : 0;
        if((arg5) && v4 == 0) {
            v4 = v3.getResourceId(styleable.View_theme, 0);
            if(v4 != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }

        v3.recycle();
        if(v4 != 0 && (!(arg2 instanceof ContextThemeWrapper) || arg2.getThemeResId() != v4)) {
            return new ContextThemeWrapper(arg2, v4);
        }

        return arg2;
    }

    private void verifyNotNull(View arg2, String arg3) {
        if(arg2 != null) {
            return;
        }

        throw new IllegalStateException(this.getClass().getName() + " asked to inflate view for <" + arg3 + ">, but returned null");
    }
}

