package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 w2\u00020\u0001:\u0001wJ\'\u0010S\u001A\u00020T2\u0006\u0010U\u001A\u00020V2\u0006\u0010W\u001A\u00020V2\u0006\u0010X\u001A\u00020YH&¢\u0006\u0004\bZ\u0010[J!\u0010\\\u001A\u00020T2\b\u0010]\u001A\u0004\u0018\u00010^2\u0006\u0010_\u001A\u00020YH&¢\u0006\u0004\b`\u0010aJ\u0010\u0010d\u001A\u00020T2\u0006\u0010e\u001A\u00020fH&J9\u0010g\u001A\u00020T2\u0006\u0010h\u001A\u00020i2\u0006\u0010j\u001A\u00020k2\u0006\u0010l\u001A\u00020m2\u0017\u0010n\u001A\u0013\u0012\u0004\u0012\u00020p\u0012\u0004\u0012\u00020T0o¢\u0006\u0002\bqH&J\b\u0010t\u001A\u00020TH&J\b\u0010u\u001A\u00020vH&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005R\u0018\u0010\b\u001A\u00020\tX¦\u000E¢\u0006\f\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0018\u0010\u000E\u001A\u00020\u000FX¦\u000E¢\u0006\f\u001A\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001A\u00020\u0014X¦\u000E¢\u0006\f\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001A\u00020\u001AX¦\u000E¢\u0006\f\u001A\u0004\b\u001B\u0010\u000B\"\u0004\b\u001C\u0010\rR\u001A\u0010\u001D\u001A\u0004\u0018\u00010\u001EX¦\u000E¢\u0006\f\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\u0018\u0010#\u001A\u00020\u0014X¦\u000E¢\u0006\f\u001A\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R\u0018\u0010&\u001A\u00020\u0014X¦\u000E¢\u0006\f\u001A\u0004\b\'\u0010\u0016\"\u0004\b(\u0010\u0018R\u0018\u0010)\u001A\u00020\u0014X¦\u000E¢\u0006\f\u001A\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R\u0018\u0010,\u001A\u00020\u0014X¦\u000E¢\u0006\f\u001A\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u0018\u0010/\u001A\u00020\u0014X¦\u000E¢\u0006\f\u001A\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R\u0018\u00102\u001A\u000203X¦\u000E¢\u0006\f\u001A\u0004\b4\u0010\u0005\"\u0004\b5\u0010\u0012R\u0018\u00106\u001A\u000203X¦\u000E¢\u0006\f\u001A\u0004\b7\u0010\u0005\"\u0004\b8\u0010\u0012R\u0018\u00109\u001A\u00020\u0014X¦\u000E¢\u0006\f\u001A\u0004\b:\u0010\u0016\"\u0004\b;\u0010\u0018R\u0018\u0010<\u001A\u00020\u0014X¦\u000E¢\u0006\f\u001A\u0004\b=\u0010\u0016\"\u0004\b>\u0010\u0018R\u0018\u0010?\u001A\u00020\u0014X¦\u000E¢\u0006\f\u001A\u0004\b@\u0010\u0016\"\u0004\bA\u0010\u0018R\u0018\u0010B\u001A\u00020\u0014X¦\u000E¢\u0006\f\u001A\u0004\bC\u0010\u0016\"\u0004\bD\u0010\u0018R\u0018\u0010E\u001A\u00020FX¦\u000E¢\u0006\f\u001A\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001A\u0010K\u001A\u0004\u0018\u00010LX¦\u000E¢\u0006\f\u001A\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0018\u0010Q\u001A\u00020FX¦\u000E¢\u0006\f\u001A\u0004\bQ\u0010H\"\u0004\bR\u0010JR\u0014\u0010b\u001A\u00020F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bc\u0010HR\u0014\u0010r\u001A\u00020F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bs\u0010Hø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006xÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "", "layerId", "", "getLayerId", "()J", "ownerId", "getOwnerId", "compositingStrategy", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "getCompositingStrategy-ke2Ky5w", "()I", "setCompositingStrategy-Wpw9cng", "(I)V", "pivotOffset", "Landroidx/compose/ui/geometry/Offset;", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "(J)V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "", "getClip", "()Z", "setClip", "(Z)V", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "isInvalidated", "setInvalidated", "setPosition", "", "x", "", "y", "size", "Landroidx/compose/ui/unit/IntSize;", "setPosition-H0pRuoY", "(IIJ)V", "setOutline", "outline", "Landroid/graphics/Outline;", "outlineSize", "setOutline-O0kMr_c", "(Landroid/graphics/Outline;J)V", "supportsSoftwareRendering", "getSupportsSoftwareRendering", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "record", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "hasDisplayList", "getHasDisplayList", "discardDisplayList", "calculateMatrix", "Landroid/graphics/Matrix;", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public interface GraphicsLayerImpl {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2={"Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl$Companion;", "", "<init>", "()V", "DefaultDrawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "getDefaultDrawBlock", "()Lkotlin/jvm/functions/Function1;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final Function1 DefaultDrawBlock;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.DefaultDrawBlock = GraphicsLayerImpl$Companion$DefaultDrawBlock$1.INSTANCE;
        }

        private Companion() {
            super();
        }

        public final Function1 getDefaultDrawBlock() {
            return Companion.DefaultDrawBlock;
        }
    }

    public static final Companion Companion;

    static {
        GraphicsLayerImpl.Companion = Companion.$$INSTANCE;
    }

    Matrix calculateMatrix();

    void discardDisplayList();

    void draw(Canvas arg1);

    float getAlpha();

    long getAmbientShadowColor-0d7_KjU();

    int getBlendMode-0nO6VwU();

    float getCameraDistance();

    boolean getClip();

    ColorFilter getColorFilter();

    int getCompositingStrategy-ke2Ky5w();

    default boolean getHasDisplayList() {
        return 1;
    }

    long getLayerId();

    long getOwnerId();

    long getPivotOffset-F1C5BW0();

    RenderEffect getRenderEffect();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    long getSpotShadowColor-0d7_KjU();

    default boolean getSupportsSoftwareRendering() {
        return 0;
    }

    float getTranslationX();

    float getTranslationY();

    boolean isInvalidated();

    void record(Density arg1, LayoutDirection arg2, GraphicsLayer arg3, Function1 arg4);

    void setAlpha(float arg1);

    void setAmbientShadowColor-8_81llA(long arg1);

    void setBlendMode-s9anfk8(int arg1);

    void setCameraDistance(float arg1);

    void setClip(boolean arg1);

    void setColorFilter(ColorFilter arg1);

    void setCompositingStrategy-Wpw9cng(int arg1);

    void setInvalidated(boolean arg1);

    void setOutline-O0kMr_c(Outline arg1, long arg2);

    void setPivotOffset-k-4lQ0M(long arg1);

    void setPosition-H0pRuoY(int arg1, int arg2, long arg3);

    void setRenderEffect(RenderEffect arg1);

    void setRotationX(float arg1);

    void setRotationY(float arg1);

    void setRotationZ(float arg1);

    void setScaleX(float arg1);

    void setScaleY(float arg1);

    void setShadowElevation(float arg1);

    void setSpotShadowColor-8_81llA(long arg1);

    void setTranslationX(float arg1);

    void setTranslationY(float arg1);
}

