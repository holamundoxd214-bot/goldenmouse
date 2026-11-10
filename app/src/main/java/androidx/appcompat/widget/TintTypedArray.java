package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.content.res.ResourcesCompat;

public class TintTypedArray {
    class Api21Impl {
        private Api21Impl() {
            super();
        }

        static int getChangingConfigurations(TypedArray arg0) {
            return arg0.getChangingConfigurations();
        }

        static int getType(TypedArray arg0, int arg1) {
            return arg0.getType(arg1);
        }
    }

    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    private TintTypedArray(Context arg1, TypedArray arg2) {
        super();
        this.mContext = arg1;
        this.mWrapped = arg2;
    }

    public boolean getBoolean(int arg1, boolean arg2) {
        return this.mWrapped.getBoolean(arg1, arg2);
    }

    public int getChangingConfigurations() {
        return Api21Impl.getChangingConfigurations(this.mWrapped);
    }

    public int getColor(int arg1, int arg2) {
        return this.mWrapped.getColor(arg1, arg2);
    }

    public ColorStateList getColorStateList(int arg3) {
        if(this.mWrapped.hasValue(arg3)) {
            int v0 = this.mWrapped.getResourceId(arg3, 0);
            if(v0 != 0) {
                ColorStateList v0_1 = AppCompatResources.getColorStateList(this.mContext, v0);
                if(v0_1 != null) {
                    return v0_1;
                }
            }
        }

        return this.mWrapped.getColorStateList(arg3);
    }

    public float getDimension(int arg1, float arg2) {
        return this.mWrapped.getDimension(arg1, arg2);
    }

    public int getDimensionPixelOffset(int arg1, int arg2) {
        return this.mWrapped.getDimensionPixelOffset(arg1, arg2);
    }

    public int getDimensionPixelSize(int arg1, int arg2) {
        return this.mWrapped.getDimensionPixelSize(arg1, arg2);
    }

    public Drawable getDrawable(int arg3) {
        if(this.mWrapped.hasValue(arg3)) {
            int v0 = this.mWrapped.getResourceId(arg3, 0);
            if(v0 != 0) {
                return AppCompatResources.getDrawable(this.mContext, v0);
            }
        }

        return this.mWrapped.getDrawable(arg3);
    }

    public Drawable getDrawableIfKnown(int arg3) {
        if(this.mWrapped.hasValue(arg3)) {
            arg3 = this.mWrapped.getResourceId(arg3, 0);
            if(arg3 != 0) {
                return AppCompatDrawableManager.get().getDrawable(this.mContext, arg3, true);
            }
        }

        return null;
    }

    public float getFloat(int arg1, float arg2) {
        return this.mWrapped.getFloat(arg1, arg2);
    }

    public Typeface getFont(int arg3, int arg4, FontCallback arg5) {
        arg3 = this.mWrapped.getResourceId(arg3, 0);
        if(arg3 == 0) {
            return null;
        }

        TypedValue v0 = this.mTypedValue;
        if(v0 == null) {
            v0 = new TypedValue();
            this.mTypedValue = v0;
        }

        return ResourcesCompat.getFont(this.mContext, arg3, v0, arg4, arg5);
    }

    public float getFraction(int arg1, int arg2, int arg3, float arg4) {
        return this.mWrapped.getFraction(arg1, arg2, arg3, arg4);
    }

    public int getIndex(int arg1) {
        return this.mWrapped.getIndex(arg1);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int arg1, int arg2) {
        return this.mWrapped.getInt(arg1, arg2);
    }

    public int getInteger(int arg1, int arg2) {
        return this.mWrapped.getInteger(arg1, arg2);
    }

    public int getLayoutDimension(int arg1, int arg2) {
        return this.mWrapped.getLayoutDimension(arg1, arg2);
    }

    public int getLayoutDimension(int arg1, String arg2) {
        return this.mWrapped.getLayoutDimension(arg1, arg2);
    }

    public String getNonResourceString(int arg1) {
        return this.mWrapped.getNonResourceString(arg1);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int arg1, int arg2) {
        return this.mWrapped.getResourceId(arg1, arg2);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public String getString(int arg1) {
        return this.mWrapped.getString(arg1);
    }

    public CharSequence getText(int arg1) {
        return this.mWrapped.getText(arg1);
    }

    public CharSequence[] getTextArray(int arg1) {
        return this.mWrapped.getTextArray(arg1);
    }

    public int getType(int arg1) {
        return Api21Impl.getType(this.mWrapped, arg1);
    }

    public boolean getValue(int arg1, TypedValue arg2) {
        return this.mWrapped.getValue(arg1, arg2);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int arg1) {
        return this.mWrapped.hasValue(arg1);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public static TintTypedArray obtainStyledAttributes(Context arg1, AttributeSet arg2, int[] arg3) {
        return new TintTypedArray(arg1, arg1.obtainStyledAttributes(arg2, arg3));
    }

    public static TintTypedArray obtainStyledAttributes(Context arg1, AttributeSet arg2, int[] arg3, int arg4, int arg5) {
        return new TintTypedArray(arg1, arg1.obtainStyledAttributes(arg2, arg3, arg4, arg5));
    }

    public static TintTypedArray obtainStyledAttributes(Context arg1, int arg2, int[] arg3) {
        return new TintTypedArray(arg1, arg1.obtainStyledAttributes(arg2, arg3));
    }

    public TypedValue peekValue(int arg1) {
        return this.mWrapped.peekValue(arg1);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }
}

