package androidx.compose.ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.media.Image;
import android.media.ImageReader;
import android.os.Looper;
import android.view.Surface;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.os.HandlerCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/ui/graphics/layer/LayerSnapshotV22;", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "<init>", "()V", "toBitmap", "Landroid/graphics/Bitmap;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayerSnapshotV22 implements LayerSnapshotImpl {
    public static final int $stable;
    public static final LayerSnapshotV22 INSTANCE;

    static {
        LayerSnapshotV22.INSTANCE = new LayerSnapshotV22();
    }

    private LayerSnapshotV22() {
        super();
    }

    public Object toBitmap(GraphicsLayer arg9, Continuation arg10) {
        Bitmap v8_4;
        ImageReader v9_2;
        Canvas v3;
        Surface v8_3;
        CancellableContinuationImpl v6;
        Continuation v0;
        if((arg10 instanceof LayerSnapshotV22$toBitmap$1)) {
            v0 = arg10;
            int v2 = 0x80000000;
            if((((LayerSnapshotV22$toBitmap$1)v0).label & v2) != 0) {
                ((LayerSnapshotV22$toBitmap$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            LayerSnapshotV22$toBitmap$1 v0_1 = new LayerSnapshotV22$toBitmap$1(this, arg10);
        }

        Object v8 = ((LayerSnapshotV22$toBitmap$1)v0).result;
        Object v10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v1 = ((LayerSnapshotV22$toBitmap$1)v0).label;
        GraphicsLayer v2_1 = null;
        if(v1 == 0) {
            ResultKt.throwOnFailure(v8);
            long v4 = arg9.getSize-YbymL2g();
            Looper v8_2 = Looper.myLooper();
            if(v8_2 == null) {
                v8_2 = Looper.getMainLooper();
            }

            ImageReader v1_1 = ImageReader.newInstance(((int)(v4 >> 0x20)), ((int)(v4 & 0xFFFFFFFFL)), 1, 1);
            try {
                ((LayerSnapshotV22$toBitmap$1)v0).L$0 = arg9;
                ((LayerSnapshotV22$toBitmap$1)v0).L$1 = v8_2;
                ((LayerSnapshotV22$toBitmap$1)v0).L$2 = v1_1;
                ((LayerSnapshotV22$toBitmap$1)v0).L$3 = v1_1;
                ((LayerSnapshotV22$toBitmap$1)v0).L$4 = v0;
                ((LayerSnapshotV22$toBitmap$1)v0).label = 1;
                v6 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(v0), 1);
                v6.initCancellability();
                v1_1.setOnImageAvailableListener(new LayerSnapshotV22$toBitmap$2$image$1$1(v6), HandlerCompat.createAsync(v8_2));
                v8_3 = v1_1.getSurface();
                v3 = SurfaceUtils.INSTANCE.lockCanvas(v8_3);
            }
            catch(Throwable v8_1) {
                goto label_87;
            }

            try {
                v3.drawColor(ColorKt.toArgb-8_81llA(Color.Companion.getBlack-0d7_KjU()), PorterDuff$Mode.CLEAR);
                arg9.draw$ui_graphics(AndroidCanvas_androidKt.Canvas(v3), v2_1);
                goto label_72;
            }
            catch(Throwable v9_1) {
                try {
                    v8_3.unlockCanvasAndPost(v3);
                    throw v9_1;
                label_72:
                    v8_3.unlockCanvasAndPost(v3);
                    v8 = v6.getResult();
                    if(v8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(v0);
                    }
                }
                catch(Throwable v8_1) {
                label_87:
                    v9_2 = v1_1;
                    goto label_88;
                }
            }

            if(v8 == v10) {
                return v10;
            }

            v9_2 = v1_1;
        }
        else if(v1 == 1) {
            Object v9 = ((LayerSnapshotV22$toBitmap$1)v0).L$2;
            try {
                ResultKt.throwOnFailure(v8);
            }
            catch(Throwable v8_1) {
                goto label_28;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
            v8_4 = LayerSnapshot_androidKt.access$toBitmap(((Image)v8));
            goto label_81;
        }
        catch(Throwable v8_1) {
        label_28:
        }

        try {
        label_88:
            throw v8_1;
        }
        catch(Throwable v10_1) {
            AutoCloseableKt.closeFinally(((AutoCloseable)v9_2), v8_1);
            throw v10_1;
        }

    label_81:
        AutoCloseableKt.closeFinally(((AutoCloseable)v9_2), ((Throwable)v2_1));
        return v8_4;
    }
}

