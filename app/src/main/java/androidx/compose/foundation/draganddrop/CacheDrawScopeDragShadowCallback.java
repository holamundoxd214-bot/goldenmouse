package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/compose/foundation/draganddrop/CacheDrawScopeDragShadowCallback;", "", "<init>", "()V", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "drawDragShadow", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "cachePicture", "Landroidx/compose/ui/draw/DrawResult;", "scope", "Landroidx/compose/ui/draw/CacheDrawScope;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CacheDrawScopeDragShadowCallback {
    public static final int $stable = 8;
    private GraphicsLayer graphicsLayer;

    public static Unit $r8$lambda$Uc502JhJAN_At3kmQ4ortvfz2kc(ContentDrawScope arg0) {
        return CacheDrawScopeDragShadowCallback.cachePicture$lambda$0$0$0(arg0);
    }

    public static Unit $r8$lambda$WcrtWHLv1feneYDi8FHqUX-WkTs(CacheDrawScopeDragShadowCallback arg0, ContentDrawScope arg1) {
        return CacheDrawScopeDragShadowCallback.cachePicture$lambda$0$1(arg0, arg1);
    }

    static {
    }

    public CacheDrawScopeDragShadowCallback() {
        super();
    }

    public final DrawResult cachePicture(CacheDrawScope arg10) {
        GraphicsLayer v1 = arg10.obtainGraphicsLayer();
        CacheDrawScope.record-TdoYBX4$default(arg10, v1, null, null, 0, new CacheDrawScopeDragShadowCallback$$ExternalSyntheticLambda0(), 7, null);
        this.graphicsLayer = v1;
        return arg10.onDrawWithContent(new CacheDrawScopeDragShadowCallback$$ExternalSyntheticLambda1(this));
    }

    private static final Unit cachePicture$lambda$0$0$0(ContentDrawScope arg0) {
        arg0.drawContent();
        return Unit.INSTANCE;
    }

    private static final Unit cachePicture$lambda$0$1(CacheDrawScopeDragShadowCallback arg0, ContentDrawScope arg1) {
        GraphicsLayer v0 = arg0.graphicsLayer;
        Intrinsics.checkNotNull(v0);
        GraphicsLayerKt.drawLayer(((DrawScope)arg1), v0);
        return Unit.INSTANCE;
    }

    public final void drawDragShadow(DrawScope arg1) {
        GraphicsLayer v0 = this.graphicsLayer;
        if(v0 != null) {
            GraphicsLayerKt.drawLayer(arg1, v0);
            return;
        }

        throw new IllegalArgumentException("No cached drag shadow. Check if the drag source node was rendered first");
    }
}

