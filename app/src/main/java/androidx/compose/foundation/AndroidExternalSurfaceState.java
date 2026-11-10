package androidx.compose.foundation;

import android.graphics.Rect;
import android.view.SurfaceHolder$Callback;
import android.view.SurfaceHolder;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0016J(\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\bH\u0016J\u0010\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0016R\u001A\u0010\u0007\u001A\u00020\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001A\u0010\r\u001A\u00020\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\n\"\u0004\b\u000F\u0010\f¨\u0006\u0019"}, d2={"Landroidx/compose/foundation/AndroidExternalSurfaceState;", "Landroidx/compose/foundation/BaseAndroidExternalSurfaceState;", "Landroid/view/SurfaceHolder$Callback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "lastWidth", "", "getLastWidth", "()I", "setLastWidth", "(I)V", "lastHeight", "getLastHeight", "setLastHeight", "surfaceCreated", "", "holder", "Landroid/view/SurfaceHolder;", "surfaceChanged", "format", "width", "height", "surfaceDestroyed", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AndroidExternalSurfaceState extends BaseAndroidExternalSurfaceState implements SurfaceHolder$Callback {
    private int lastHeight;
    private int lastWidth;

    public AndroidExternalSurfaceState(CoroutineScope arg1) {
        super(arg1);
        this.lastWidth = -1;
        this.lastHeight = -1;
    }

    public final int getLastHeight() {
        return this.lastHeight;
    }

    public final int getLastWidth() {
        return this.lastWidth;
    }

    public final void setLastHeight(int arg1) {
        this.lastHeight = arg1;
    }

    public final void setLastWidth(int arg1) {
        this.lastWidth = arg1;
    }

    public void surfaceChanged(SurfaceHolder arg1, int arg2, int arg3, int arg4) {
        if(this.lastWidth == arg3) {
            if(this.lastHeight != arg4) {
            }
            else {
                return;
            }
        }

        this.lastWidth = arg3;
        this.lastHeight = arg4;
        this.dispatchSurfaceChanged(arg1.getSurface(), arg3, arg4);
    }

    public void surfaceCreated(SurfaceHolder arg3) {
        Rect v0 = arg3.getSurfaceFrame();
        this.lastWidth = v0.width();
        this.lastHeight = v0.height();
        this.dispatchSurfaceCreated(arg3.getSurface(), this.lastWidth, this.lastHeight);
    }

    public void surfaceDestroyed(SurfaceHolder arg1) {
        this.dispatchSurfaceDestroyed(arg1.getSurface());
    }
}

