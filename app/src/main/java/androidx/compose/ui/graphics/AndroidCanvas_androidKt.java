package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A\u000E\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0001\"\u0019\u0010\b\u001A\u00060\u0001j\u0002`\t*\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B\"\u000E\u0010\f\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\r"}, d2={"NativeCanvas", "Landroid/graphics/Canvas;", "ActualCanvas", "Landroidx/compose/ui/graphics/Canvas;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "Canvas", "c", "nativeCanvas", "Landroidx/compose/ui/graphics/NativeCanvas;", "getNativeCanvas", "(Landroidx/compose/ui/graphics/Canvas;)Landroid/graphics/Canvas;", "EmptyCanvas", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidCanvas_androidKt {
    private static final Canvas EmptyCanvas;

    static {
        AndroidCanvas_androidKt.EmptyCanvas = new Canvas();
    }

    public static final androidx.compose.ui.graphics.Canvas ActualCanvas(ImageBitmap arg2) {
        AndroidCanvas v0 = new AndroidCanvas();
        v0.setInternalCanvas(new Canvas(AndroidImageBitmap_androidKt.asAndroidBitmap(arg2)));
        return ((androidx.compose.ui.graphics.Canvas)v0);
    }

    public static final androidx.compose.ui.graphics.Canvas Canvas(Canvas arg1) {
        AndroidCanvas v0 = new AndroidCanvas();
        v0.setInternalCanvas(arg1);
        return ((androidx.compose.ui.graphics.Canvas)v0);
    }

    public static final Canvas access$getEmptyCanvas$p() {
        return AndroidCanvas_androidKt.EmptyCanvas;
    }

    public static final Canvas getNativeCanvas(androidx.compose.ui.graphics.Canvas arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidCanvas");
        return ((AndroidCanvas)arg1).getInternalCanvas();
    }
}

