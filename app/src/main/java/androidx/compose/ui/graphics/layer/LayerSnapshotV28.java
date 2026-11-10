package androidx.compose.ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\n"}, d2={"Landroidx/compose/ui/graphics/layer/LayerSnapshotV28;", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "<init>", "()V", "toBitmap", "Landroid/graphics/Bitmap;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "GraphicsLayerPicture", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayerSnapshotV28 implements LayerSnapshotImpl {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0016J\b\u0010\r\u001A\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u000BH\u0016J\b\u0010\u0010\u001A\u00020\u000BH\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\u0010\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\tH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2={"Landroidx/compose/ui/graphics/layer/LayerSnapshotV28$GraphicsLayerPicture;", "Landroid/graphics/Picture;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "<init>", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "getGraphicsLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "beginRecording", "Landroid/graphics/Canvas;", "width", "", "height", "endRecording", "", "getWidth", "getHeight", "requiresHardwareAcceleration", "", "draw", "canvas", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) final class GraphicsLayerPicture extends Picture {
        private final GraphicsLayer graphicsLayer;

        public GraphicsLayerPicture(GraphicsLayer arg1) {
            super();
            this.graphicsLayer = arg1;
        }

        public Canvas beginRecording(int arg1, int arg2) {
            return new Canvas();
        }

        public void draw(Canvas arg2) {
            this.graphicsLayer.draw$ui_graphics(AndroidCanvas_androidKt.Canvas(arg2), null);
        }

        public void endRecording() {
        }

        public final GraphicsLayer getGraphicsLayer() {
            return this.graphicsLayer;
        }

        public int getHeight() {
            return ((int)(this.graphicsLayer.getSize-YbymL2g() & 0xFFFFFFFFL));
        }

        public int getWidth() {
            return ((int)(this.graphicsLayer.getSize-YbymL2g() >> 0x20));
        }

        public boolean requiresHardwareAcceleration() {
            return 1;
        }
    }

    public static final int $stable;
    public static final LayerSnapshotV28 INSTANCE;

    static {
        LayerSnapshotV28.INSTANCE = new LayerSnapshotV28();
    }

    private LayerSnapshotV28() {
        super();
    }

    public Object toBitmap(GraphicsLayer arg1, Continuation arg2) {
        return Bitmap.createBitmap(new GraphicsLayerPicture(arg1));
    }
}

