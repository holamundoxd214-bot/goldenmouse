package androidx.compose.ui.graphics;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\r\u0010\u0007\u001A\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001A\b\u0010\n\u001A\u00020\u000BH\u0007\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2={"DefaultCameraDistance", "", "DefaultShadowColor", "Landroidx/compose/ui/graphics/Color;", "getDefaultShadowColor", "()J", "J", "rememberGraphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "GraphicsLayerScope", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class GraphicsLayerScopeKt {
    public static final float DefaultCameraDistance = 8f;
    private static final long DefaultShadowColor;

    static {
        GraphicsLayerScopeKt.DefaultShadowColor = Color.Companion.getBlack-0d7_KjU();
    }

    public static final GraphicsLayerScope GraphicsLayerScope() {
        return new ReusableGraphicsLayerScope();
    }

    public static final long getDefaultShadowColor() {
        return GraphicsLayerScopeKt.DefaultShadowColor;
    }

    public static final GraphicsLayer rememberGraphicsLayer(Composer arg3, int arg4) {
        GraphicsContextObserver v0_1;
        int v1 = 158092365;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberGraphicsLayer)250@10875L7,251@10894L53:GraphicsLayerScope.kt#aiphks");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.ui.graphics.rememberGraphicsLayer (GraphicsLayerScope.kt:249)");
        }

        ProvidableCompositionLocal v4 = CompositionLocalsKt.getLocalGraphicsContext();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v4_1 = arg3.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        ComposerKt.sourceInformationMarkerStart(arg3, 1602911010, "CC(remember):GraphicsLayerScope.kt#9igjgp");
        Object v0 = arg3.rememberedValue();
        if(v0 == Composer.Companion.getEmpty()) {
            v0_1 = new GraphicsContextObserver(((GraphicsContext)v4_1));
            arg3.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        GraphicsLayer v4_2 = v0_1.getGraphicsLayer();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4_2;
    }
}

