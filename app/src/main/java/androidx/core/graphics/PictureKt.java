package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001A9\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0017\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2={"record", "Landroid/graphics/Picture;", "width", "", "height", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class PictureKt {
    public static final Picture record(Picture arg1, int arg2, int arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "block");
        Canvas v2 = arg1.beginRecording(arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(v2, "beginRecording(...)");
        try {
            arg4.invoke(v2);
        }
        catch(Throwable v2_1) {
            arg1.endRecording();
            throw v2_1;
        }

        arg1.endRecording();
        return arg1;
    }
}

