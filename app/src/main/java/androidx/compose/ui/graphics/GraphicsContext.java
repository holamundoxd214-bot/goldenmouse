package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.shadow.ShadowContext;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0003H&R\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/graphics/GraphicsContext;", "", "createGraphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "releaseGraphicsLayer", "", "layer", "shadowContext", "Landroidx/compose/ui/graphics/shadow/ShadowContext;", "getShadowContext", "()Landroidx/compose/ui/graphics/shadow/ShadowContext;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public interface GraphicsContext {
    GraphicsLayer createGraphicsLayer();

    default ShadowContext getShadowContext() {
        return new GraphicsContext$shadowContext$1();
    }

    void releaseGraphicsLayer(GraphicsLayer arg1);
}

