package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
        super();
    }

    public static int getAttr(Context arg2, int arg3, int arg4) {
        TypedValue v0 = new TypedValue();
        arg2.getTheme().resolveAttribute(arg3, v0, true);
        if(v0.resourceId != 0) {
            return arg3;
        }

        return arg4;
    }

    public static boolean getBoolean(TypedArray arg0, int arg1, int arg2, boolean arg3) {
        return arg0.getBoolean(arg1, arg0.getBoolean(arg2, arg3));
    }

    public static Drawable getDrawable(TypedArray arg0, int arg1, int arg2) {
        Drawable v1 = arg0.getDrawable(arg1);
        if(v1 == null) {
            return arg0.getDrawable(arg2);
        }

        return v1;
    }

    public static int getInt(TypedArray arg0, int arg1, int arg2, int arg3) {
        return arg0.getInt(arg1, arg0.getInt(arg2, arg3));
    }

    public static boolean getNamedBoolean(TypedArray arg0, XmlPullParser arg1, String arg2, int arg3, boolean arg4) {
        if(!TypedArrayUtils.hasAttribute(arg1, arg2)) {
            return arg4;
        }

        return arg0.getBoolean(arg3, arg4);
    }

    public static int getNamedColor(TypedArray arg0, XmlPullParser arg1, String arg2, int arg3, int arg4) {
        if(!TypedArrayUtils.hasAttribute(arg1, arg2)) {
            return arg4;
        }

        return arg0.getColor(arg3, arg4);
    }

    public static ColorStateList getNamedColorStateList(TypedArray arg1, XmlPullParser arg2, Resources$Theme arg3, String arg4, int arg5) {
        if(TypedArrayUtils.hasAttribute(arg2, arg4)) {
            TypedValue v2 = new TypedValue();
            arg1.getValue(arg5, v2);
            if(v2.type != 2) {
                if(v2.type >= 28 && v2.type <= 0x1F) {
                    return TypedArrayUtils.getNamedColorStateListFromInt(v2);
                }

                return ColorStateListInflaterCompat.inflate(arg1.getResources(), arg1.getResourceId(arg5, 0), arg3);
            }

            throw new UnsupportedOperationException("Failed to resolve attribute at index " + arg5 + ": " + v2);
        }

        return null;
    }

    private static ColorStateList getNamedColorStateListFromInt(TypedValue arg0) {
        return ColorStateList.valueOf(arg0.data);
    }

    public static ComplexColorCompat getNamedComplexColor(TypedArray arg1, XmlPullParser arg2, Resources$Theme arg3, String arg4, int arg5, int arg6) {
        if(TypedArrayUtils.hasAttribute(arg2, arg4)) {
            TypedValue v2 = new TypedValue();
            arg1.getValue(arg5, v2);
            if(v2.type >= 28 && v2.type <= 0x1F) {
                return ComplexColorCompat.from(v2.data);
            }

            ComplexColorCompat v1 = ComplexColorCompat.inflate(arg1.getResources(), arg1.getResourceId(arg5, 0), arg3);
            if(v1 == null) {
                goto label_20;
            }

            return v1;
        }

    label_20:
        return ComplexColorCompat.from(arg6);
    }

    public static float getNamedFloat(TypedArray arg0, XmlPullParser arg1, String arg2, int arg3, float arg4) {
        if(!TypedArrayUtils.hasAttribute(arg1, arg2)) {
            return arg4;
        }

        return arg0.getFloat(arg3, arg4);
    }

    public static int getNamedInt(TypedArray arg0, XmlPullParser arg1, String arg2, int arg3, int arg4) {
        if(!TypedArrayUtils.hasAttribute(arg1, arg2)) {
            return arg4;
        }

        return arg0.getInt(arg3, arg4);
    }

    public static int getNamedResourceId(TypedArray arg0, XmlPullParser arg1, String arg2, int arg3, int arg4) {
        if(!TypedArrayUtils.hasAttribute(arg1, arg2)) {
            return arg4;
        }

        return arg0.getResourceId(arg3, arg4);
    }

    public static String getNamedString(TypedArray arg0, XmlPullParser arg1, String arg2, int arg3) {
        if(!TypedArrayUtils.hasAttribute(arg1, arg2)) {
            return null;
        }

        return arg0.getString(arg3);
    }

    public static int getResourceId(TypedArray arg0, int arg1, int arg2, int arg3) {
        return arg0.getResourceId(arg1, arg0.getResourceId(arg2, arg3));
    }

    public static String getString(TypedArray arg0, int arg1, int arg2) {
        String v1 = arg0.getString(arg1);
        if(v1 == null) {
            return arg0.getString(arg2);
        }

        return v1;
    }

    public static CharSequence getText(TypedArray arg0, int arg1, int arg2) {
        CharSequence v1 = arg0.getText(arg1);
        if(v1 == null) {
            return arg0.getText(arg2);
        }

        return v1;
    }

    public static CharSequence[] getTextArray(TypedArray arg0, int arg1, int arg2) {
        CharSequence[] v1 = arg0.getTextArray(arg1);
        if(v1 == null) {
            return arg0.getTextArray(arg2);
        }

        return v1;
    }

    public static boolean hasAttribute(XmlPullParser arg1, String arg2) {
        if(arg1.getAttributeValue("http://schemas.android.com/apk/res/android", arg2) != null) {
            return 1;
        }

        return 0;
    }

    public static TypedArray obtainAttributes(Resources arg0, Resources$Theme arg1, AttributeSet arg2, int[] arg3) {
        if(arg1 == null) {
            return arg0.obtainAttributes(arg2, arg3);
        }

        return arg1.obtainStyledAttributes(arg2, arg3, 0, 0);
    }

    public static TypedValue peekNamedValue(TypedArray arg0, XmlPullParser arg1, String arg2, int arg3) {
        if(!TypedArrayUtils.hasAttribute(arg1, arg2)) {
            return null;
        }

        return arg0.peekValue(arg3);
    }
}

