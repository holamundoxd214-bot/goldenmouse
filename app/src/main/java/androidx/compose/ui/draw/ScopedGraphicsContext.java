package androidx.compose.ui.draw;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectListKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.shadow.ShadowContext;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001A\u00020\u0006H\u0016J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0006H\u0016J\u0006\u0010\u0015\u001A\u00020\u000FR\u0016\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R(\u0010\b\u001A\u0004\u0018\u00010\u00012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0001@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u0014\u0010\u0011\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2={"Landroidx/compose/ui/draw/ScopedGraphicsContext;", "Landroidx/compose/ui/graphics/GraphicsContext;", "<init>", "()V", "allocatedGraphicsLayers", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "value", "graphicsContext", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "setGraphicsContext", "(Landroidx/compose/ui/graphics/GraphicsContext;)V", "createGraphicsLayer", "releaseGraphicsLayer", "", "layer", "shadowContext", "Landroidx/compose/ui/graphics/shadow/ShadowContext;", "getShadowContext", "()Landroidx/compose/ui/graphics/shadow/ShadowContext;", "releaseGraphicsLayers", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class ScopedGraphicsContext implements GraphicsContext {
    private MutableObjectList allocatedGraphicsLayers;
    private GraphicsContext graphicsContext;

    public ScopedGraphicsContext() {
        super();
    }

    public GraphicsLayer createGraphicsLayer() {
        GraphicsContext v0 = this.graphicsContext;
        int v1 = v0 != null ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalStateException("GraphicsContext not provided");
        }

        GraphicsLayer v0_1 = v0.createGraphicsLayer();
        MutableObjectList v1_1 = this.allocatedGraphicsLayers;
        if(v1_1 == null) {
            this.allocatedGraphicsLayers = ObjectListKt.mutableObjectListOf(v0_1);
            return v0_1;
        }

        v1_1.add(v0_1);
        return v0_1;
    }

    public final GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public ShadowContext getShadowContext() {
        GraphicsContext v1 = this.graphicsContext;
        int v0 = v1 != null ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("GraphicsContext not provided");
        }

        return v1.getShadowContext();
    }

    public void releaseGraphicsLayer(GraphicsLayer arg1) {
        GraphicsContext v0 = this.graphicsContext;
        if(v0 != null) {
            v0.releaseGraphicsLayer(arg1);
        }
    }

    public final void releaseGraphicsLayers() {
        MutableObjectList v0 = this.allocatedGraphicsLayers;
        if(v0 != null) {
            Object[] v2 = v0.content;
            int v1 = v0._size;
            int v3;
            for(v3 = 0; v3 < v1; ++v3) {
                this.releaseGraphicsLayer(v2[v3]);
            }

            v0.clear();
        }
    }

    public final void setGraphicsContext(GraphicsContext arg1) {
        this.releaseGraphicsLayers();
        this.graphicsContext = arg1;
    }
}

