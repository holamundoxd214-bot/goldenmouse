package androidx.core.graphics.drawable;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001A*\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001A\u00020\u00042\b\b\u0003\u0010\u0005\u001A\u00020\u00042\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u001A,\u0010\b\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001A\u00020\u00042\b\b\u0003\u0010\u0005\u001A\u00020\u00042\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u001A2\u0010\t\u001A\u00020\n*\u00020\u00022\b\b\u0003\u0010\u000B\u001A\u00020\u00042\b\b\u0003\u0010\f\u001A\u00020\u00042\b\b\u0003\u0010\r\u001A\u00020\u00042\b\b\u0003\u0010\u000E\u001A\u00020\u0004¨\u0006\u000F"}, d2={"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "toBitmapOrNull", "updateBounds", "", "left", "top", "right", "bottom", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable arg5, int arg6, int arg7, Bitmap$Config arg8) {
        Bitmap v5;
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        if((arg5 instanceof BitmapDrawable)) {
            Drawable v0 = arg5;
            if(((BitmapDrawable)v0).getBitmap() != null) {
                if(arg8 != null && ((BitmapDrawable)v0).getBitmap().getConfig() != arg8) {
                    goto label_31;
                }

                if(arg6 == ((BitmapDrawable)v0).getBitmap().getWidth() && arg7 == ((BitmapDrawable)v0).getBitmap().getHeight()) {
                    v5 = ((BitmapDrawable)v0).getBitmap();
                    Intrinsics.checkNotNullExpressionValue(v5, "getBitmap(...)");
                    return v5;
                }

                v5 = Bitmap.createScaledBitmap(((BitmapDrawable)v0).getBitmap(), arg6, arg7, true);
                Intrinsics.checkNotNullExpressionValue(v5, "createScaledBitmap(...)");
                return v5;
            }
            else {
                throw new IllegalArgumentException("bitmap is null");
            }
        }

    label_31:
        Rect v0_1 = arg5.getBounds();
        Intrinsics.checkNotNullExpressionValue(v0_1, "getBounds(...)");
        int v1 = v0_1.left;
        int v2 = v0_1.top;
        int v3 = v0_1.right;
        int v0_2 = v0_1.bottom;
        if(arg8 == null) {
            arg8 = Bitmap$Config.ARGB_8888;
        }

        Bitmap v8 = Bitmap.createBitmap(arg6, arg7, arg8);
        Intrinsics.checkNotNullExpressionValue(v8, "createBitmap(...)");
        arg5.setBounds(0, 0, arg6, arg7);
        arg5.draw(new Canvas(v8));
        arg5.setBounds(v1, v2, v3, v0_2);
        return v8;
    }

    public static Bitmap toBitmap$default(Drawable arg0, int arg1, int arg2, Bitmap$Config arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.getIntrinsicWidth();
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.getIntrinsicHeight();
        }

        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        return DrawableKt.toBitmap(arg0, arg1, arg2, arg3);
    }

    public static final Bitmap toBitmapOrNull(Drawable arg1, int arg2, int arg3, Bitmap$Config arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(((arg1 instanceof BitmapDrawable)) && arg1.getBitmap() == null) {
            return null;
        }

        return DrawableKt.toBitmap(arg1, arg2, arg3, arg4);
    }

    public static Bitmap toBitmapOrNull$default(Drawable arg0, int arg1, int arg2, Bitmap$Config arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.getIntrinsicWidth();
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.getIntrinsicHeight();
        }

        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        return DrawableKt.toBitmapOrNull(arg0, arg1, arg2, arg3);
    }

    public static final void updateBounds(Drawable arg1, int arg2, int arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.setBounds(arg2, arg3, arg4, arg5);
    }

    public static void updateBounds$default(Drawable arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.getBounds().left;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.getBounds().top;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.getBounds().right;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.getBounds().bottom;
        }

        DrawableKt.updateBounds(arg0, arg1, arg2, arg3, arg4);
    }
}

