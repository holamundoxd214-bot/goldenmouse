package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0017\u0010\r\u001A\u0013\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\n0\u000E¢\u0006\u0002\b\u0010H\u0086\bR\u001C\u0010\u0004\u001A\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2={"Landroidx/compose/ui/graphics/CanvasHolder;", "", "<init>", "()V", "androidCanvas", "Landroidx/compose/ui/graphics/AndroidCanvas;", "getAndroidCanvas$annotations", "getAndroidCanvas", "()Landroidx/compose/ui/graphics/AndroidCanvas;", "drawInto", "", "targetCanvas", "Landroid/graphics/Canvas;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ExtensionFunctionType;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CanvasHolder {
    public static final int $stable = 8;
    private final AndroidCanvas androidCanvas;

    static {
    }

    public CanvasHolder() {
        super();
        this.androidCanvas = new AndroidCanvas();
    }

    public final void drawInto(Canvas arg3, Function1 arg4) {
        Canvas v0 = this.getAndroidCanvas().getInternalCanvas();
        this.getAndroidCanvas().setInternalCanvas(arg3);
        arg4.invoke(this.getAndroidCanvas());
        this.getAndroidCanvas().setInternalCanvas(v0);
    }

    public final AndroidCanvas getAndroidCanvas() {
        return this.androidCanvas;
    }

    public static void getAndroidCanvas$annotations() {
    }
}

