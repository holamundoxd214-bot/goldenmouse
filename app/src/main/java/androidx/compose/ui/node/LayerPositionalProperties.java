package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0000J\u000E\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0014J\u000E\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0012\u001A\u00020\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000F¨\u0006\u0017"}, d2={"Landroidx/compose/ui/node/LayerPositionalProperties;", "", "<init>", "()V", "scaleX", "", "scaleY", "translationX", "translationY", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "copyFrom", "", "other", "scope", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "hasSameValuesAs", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class LayerPositionalProperties {
    private float cameraDistance;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private long transformOrigin;
    private float translationX;
    private float translationY;

    public LayerPositionalProperties() {
        super();
        this.scaleX = 1f;
        this.scaleY = 1f;
        this.cameraDistance = 8f;
        this.transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
    }

    public final void copyFrom(LayerPositionalProperties arg3) {
        this.scaleX = arg3.scaleX;
        this.scaleY = arg3.scaleY;
        this.translationX = arg3.translationX;
        this.translationY = arg3.translationY;
        this.rotationX = arg3.rotationX;
        this.rotationY = arg3.rotationY;
        this.rotationZ = arg3.rotationZ;
        this.cameraDistance = arg3.cameraDistance;
        this.transformOrigin = arg3.transformOrigin;
    }

    public final void copyFrom(GraphicsLayerScope arg3) {
        this.scaleX = arg3.getScaleX();
        this.scaleY = arg3.getScaleY();
        this.translationX = arg3.getTranslationX();
        this.translationY = arg3.getTranslationY();
        this.rotationX = arg3.getRotationX();
        this.rotationY = arg3.getRotationY();
        this.rotationZ = arg3.getRotationZ();
        this.cameraDistance = arg3.getCameraDistance();
        this.transformOrigin = arg3.getTransformOrigin-SzJe1aQ();
    }

    public final boolean hasSameValuesAs(LayerPositionalProperties arg3) {
        if(this.scaleX == arg3.scaleX && this.scaleY == arg3.scaleY && this.translationX == arg3.translationX && this.translationY == arg3.translationY && this.rotationX == arg3.rotationX && this.rotationY == arg3.rotationY && this.rotationZ == arg3.rotationZ && this.cameraDistance == arg3.cameraDistance && (TransformOrigin.equals-impl0(this.transformOrigin, arg3.transformOrigin))) {
            return 1;
        }

        return 0;
    }
}

