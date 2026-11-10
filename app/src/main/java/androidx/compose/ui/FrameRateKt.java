package androidx.compose.ui;

import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u001A\u0019\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u0014\u0010\u0002\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0002¨\u0006\b"}, d2={"preferredFrameRate", "Landroidx/compose/ui/Modifier;", "frameRate", "", "frameRateCategory", "Landroidx/compose/ui/FrameRateCategory;", "preferredFrameRate-kI47g10", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FrameRateKt {
    private static final Modifier frameRate(Modifier arg1, float arg2) {
        return arg1.then(new FrameRateElement(arg2));
    }

    public static final Modifier preferredFrameRate(Modifier arg26, float arg27) {
        if(ComposeUiFlags.isAdaptiveRefreshRateEnabled) {
            return FrameRateKt.frameRate(GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(arg26, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0, null, false, null, 0, 0, 0, 0, null, 0x7FFFF, null), arg27);
        }

        return arg26;
    }

    public static final Modifier preferredFrameRate-kI47g10(Modifier arg26, float arg27) {
        if(ComposeUiFlags.isAdaptiveRefreshRateEnabled) {
            return FrameRateKt.frameRate(GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(arg26, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0, null, false, null, 0, 0, 0, 0, null, 0x7FFFF, null), arg27);
        }

        return arg26;
    }
}

