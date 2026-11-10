package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/text/selection/HandleImageCache;", "", "<init>", "()V", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "getImageBitmap", "()Landroidx/compose/ui/graphics/ImageBitmap;", "setImageBitmap", "(Landroidx/compose/ui/graphics/ImageBitmap;)V", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "getCanvasDrawScope", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "setCanvasDrawScope", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class HandleImageCache {
    public static final HandleImageCache INSTANCE;
    private static Canvas canvas;
    private static CanvasDrawScope canvasDrawScope;
    private static ImageBitmap imageBitmap;

    static {
        HandleImageCache.INSTANCE = new HandleImageCache();
    }

    private HandleImageCache() {
        super();
    }

    public final Canvas getCanvas() {
        return HandleImageCache.canvas;
    }

    public final CanvasDrawScope getCanvasDrawScope() {
        return HandleImageCache.canvasDrawScope;
    }

    public final ImageBitmap getImageBitmap() {
        return HandleImageCache.imageBitmap;
    }

    public final void setCanvas(Canvas arg1) {
        HandleImageCache.canvas = arg1;
    }

    public final void setCanvasDrawScope(CanvasDrawScope arg1) {
        HandleImageCache.canvasDrawScope = arg1;
    }

    public final void setImageBitmap(ImageBitmap arg1) {
        HandleImageCache.imageBitmap = arg1;
    }
}

