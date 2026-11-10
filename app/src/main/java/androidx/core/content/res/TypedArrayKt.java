package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004H\u0002\u001A\u0014\u0010\u0005\u001A\u00020\u0006*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004\u001A\u0016\u0010\u0007\u001A\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004H\u0007\u001A\u0014\u0010\b\u001A\u00020\t*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004\u001A\u0014\u0010\n\u001A\u00020\u000B*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004\u001A\u0016\u0010\f\u001A\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004H\u0007\u001A\u0016\u0010\r\u001A\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004H\u0007\u001A\u0014\u0010\u000E\u001A\u00020\u000F*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004\u001A\u0014\u0010\u0010\u001A\u00020\u000B*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004\u001A\u0016\u0010\u0011\u001A\u00020\u0012*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004H\u0007\u001A\u0014\u0010\u0013\u001A\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004\u001A\u0014\u0010\u0014\u001A\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004\u001A\u0016\u0010\u0015\u001A\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004H\u0007\u001A\u0014\u0010\u0016\u001A\u00020\u0017*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004\u001A\u0014\u0010\u0018\u001A\u00020\u0019*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004\u001A\u001F\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00190\u001B*\u00020\u00022\b\b\u0001\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u001C\u001A/\u0010\u001D\u001A\u0002H\u001E\"\u0004\b\u0000\u0010\u001E*\u00020\u00022\u0012\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u001E0 H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2={"checkAttribute", "", "Landroid/content/res/TypedArray;", "index", "", "getBooleanOrThrow", "", "getColorOrThrow", "getColorStateListOrThrow", "Landroid/content/res/ColorStateList;", "getDimensionOrThrow", "", "getDimensionPixelOffsetOrThrow", "getDimensionPixelSizeOrThrow", "getDrawableOrThrow", "Landroid/graphics/drawable/Drawable;", "getFloatOrThrow", "getFontOrThrow", "Landroid/graphics/Typeface;", "getIntOrThrow", "getIntegerOrThrow", "getResourceIdOrThrow", "getStringOrThrow", "", "getTextOrThrow", "", "getTextArrayOrThrow", "", "(Landroid/content/res/TypedArray;I)[Ljava/lang/CharSequence;", "use", "R", "block", "Lkotlin/Function1;", "(Landroid/content/res/TypedArray;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray arg0, int arg1) {
        if(arg0.hasValue(arg1)) {
            return;
        }

        throw new IllegalArgumentException("Attribute not defined in set.");
    }

    public static final boolean getBooleanOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        return arg1.getBoolean(arg2, false);
    }

    public static final int getColorOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        return arg1.getColor(arg2, 0);
    }

    public static final ColorStateList getColorStateListOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        ColorStateList v1 = arg1.getColorStateList(arg2);
        if(v1 != null) {
            return v1;
        }

        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        return arg1.getDimension(arg2, 0f);
    }

    public static final int getDimensionPixelOffsetOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        return arg1.getDimensionPixelOffset(arg2, 0);
    }

    public static final int getDimensionPixelSizeOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        return arg1.getDimensionPixelSize(arg2, 0);
    }

    public static final Drawable getDrawableOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        Drawable v1 = arg1.getDrawable(arg2);
        Intrinsics.checkNotNull(v1);
        return v1;
    }

    public static final float getFloatOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        return arg1.getFloat(arg2, 0f);
    }

    public static final Typeface getFontOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        return TypedArrayApi26ImplKt.getFont(arg1, arg2);
    }

    public static final int getIntOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        return arg1.getInt(arg2, 0);
    }

    public static final int getIntegerOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        return arg1.getInteger(arg2, 0);
    }

    public static final int getResourceIdOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        return arg1.getResourceId(arg2, 0);
    }

    public static final String getStringOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        String v1 = arg1.getString(arg2);
        if(v1 != null) {
            return v1;
        }

        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    public static final CharSequence[] getTextArrayOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        CharSequence[] v1 = arg1.getTextArray(arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "getTextArray(...)");
        return v1;
    }

    public static final CharSequence getTextOrThrow(TypedArray arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        TypedArrayKt.checkAttribute(arg1, arg2);
        CharSequence v1 = arg1.getText(arg2);
        if(v1 != null) {
            return v1;
        }

        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final Object use(TypedArray arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "block");
        Object v2 = arg2.invoke(arg1);
        arg1.recycle();
        return v2;
    }
}

