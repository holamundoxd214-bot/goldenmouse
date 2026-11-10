package androidx.compose.foundation;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView$SurfaceTextureListener;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0019H\u0016J \u0010\u001B\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0019H\u0016J\u0010\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0016\u001A\u00020\u0017H\u0016J\u0010\u0010\u001E\u001A\u00020\u00152\u0006\u0010\u001F\u001A\u00020\u0017H\u0016R\u001C\u0010\u0007\u001A\u00020\bX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\r\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "Landroidx/compose/foundation/BaseAndroidExternalSurfaceState;", "Landroid/view/TextureView$SurfaceTextureListener;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "getSurfaceSize-YbymL2g", "()J", "setSurfaceSize-ozmzZPI", "(J)V", "J", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "surfaceTextureSurface", "Landroid/view/Surface;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureSizeChanged", "onSurfaceTextureDestroyed", "", "onSurfaceTextureUpdated", "surface", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class AndroidEmbeddedExternalSurfaceState extends BaseAndroidExternalSurfaceState implements TextureView$SurfaceTextureListener {
    private final Matrix matrix;
    private long surfaceSize;
    private Surface surfaceTextureSurface;

    public AndroidEmbeddedExternalSurfaceState(CoroutineScope arg3) {
        super(arg3);
        this.surfaceSize = IntSize.Companion.getZero-YbymL2g();
        this.matrix = new Matrix();
    }

    public final Matrix getMatrix() {
        return this.matrix;
    }

    public final long getSurfaceSize-YbymL2g() {
        return this.surfaceSize;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture arg5, int arg6, int arg7) {
        if(!IntSize.equals-impl0(this.surfaceSize, IntSize.Companion.getZero-YbymL2g())) {
            int v0 = ((int)(this.surfaceSize >> 0x20));
            arg7 = ((int)(this.surfaceSize & 0xFFFFFFFFL));
            arg5.setDefaultBufferSize(v0, arg7);
            arg6 = v0;
        }

        Surface v0_1 = new Surface(arg5);
        this.surfaceTextureSurface = v0_1;
        this.dispatchSurfaceCreated(v0_1, arg6, arg7);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture arg1) {
        Surface v1 = this.surfaceTextureSurface;
        Intrinsics.checkNotNull(v1);
        this.dispatchSurfaceDestroyed(v1);
        this.surfaceTextureSurface = null;
        return 1;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture arg5, int arg6, int arg7) {
        if(!IntSize.equals-impl0(this.surfaceSize, IntSize.Companion.getZero-YbymL2g())) {
            int v0 = ((int)(this.surfaceSize >> 0x20));
            arg7 = ((int)(this.surfaceSize & 0xFFFFFFFFL));
            arg5.setDefaultBufferSize(v0, arg7);
            arg6 = v0;
        }

        Surface v5 = this.surfaceTextureSurface;
        Intrinsics.checkNotNull(v5);
        this.dispatchSurfaceChanged(v5, arg6, arg7);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture arg1) {
    }

    public final void setSurfaceSize-ozmzZPI(long arg1) {
        this.surfaceSize = arg1;
    }
}

