package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder$Source;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001AU\u0010\u0000\u001A\u00020\u0001*\u00020\u00022C\b\u0004\u0010\u0003\u001A=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000B0\u0004¢\u0006\u0002\b\fH\u0087\bø\u0001\u0000\u001AU\u0010\r\u001A\u00020\u000E*\u00020\u00022C\b\u0004\u0010\u0003\u001A=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000B0\u0004¢\u0006\u0002\b\fH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000F"}, d2={"decodeBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/ImageDecoder$Source;", "action", "Lkotlin/Function3;", "Landroid/graphics/ImageDecoder;", "Landroid/graphics/ImageDecoder$ImageInfo;", "Lkotlin/ParameterName;", "name", "info", "source", "", "Lkotlin/ExtensionFunctionType;", "decodeDrawable", "Landroid/graphics/drawable/Drawable;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ImageDecoderKt {
    public static final Bitmap decodeBitmap(ImageDecoder$Source arg1, Function3 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        Bitmap v1 = ImageDecoder.decodeBitmap(arg1, new ImageDecoderKt$decodeBitmap$1(arg2));
        Intrinsics.checkNotNullExpressionValue(v1, "decodeBitmap(...)");
        return v1;
    }

    public static final Drawable decodeDrawable(ImageDecoder$Source arg1, Function3 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        Drawable v1 = ImageDecoder.decodeDrawable(arg1, new ImageDecoderKt$decodeDrawable$1(arg2));
        Intrinsics.checkNotNullExpressionValue(v1, "decodeDrawable(...)");
        return v1;
    }
}

