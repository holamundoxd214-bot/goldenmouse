package androidx.compose.ui.graphics;

import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B©\u0001\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\u0006\u0010\u000B\u001A\u00020\u0005\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\u0006\u0010\r\u001A\u00020\u0005\u0012\u0006\u0010\u000E\u001A\u00020\u0005\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\u0006\u0010\u0011\u001A\u00020\u0012\u0012\u0006\u0010\u0013\u001A\u00020\u0014\u0012\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001A\u00020\u0018\u0012\u0006\u0010\u0019\u001A\u00020\u0018\u0012\b\b\u0002\u0010\u001A\u001A\u00020\u001B\u0012\b\b\u0002\u0010\u001C\u001A\u00020\u001D\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F¢\u0006\u0004\b \u0010!J\u0006\u0010`\u001A\u00020^J#\u0010a\u001A\u00020b*\u00020c2\u0006\u0010d\u001A\u00020e2\u0006\u0010f\u001A\u00020gH\u0016¢\u0006\u0004\bh\u0010iJ\b\u0010j\u001A\u00020kH\u0016J\f\u0010l\u001A\u00020^*\u00020mH\u0016R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001A\u0010\u0006\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010#\"\u0004\b\'\u0010%R\u001A\u0010\u0007\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001A\u0010\b\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001A\u0010\t\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b,\u0010#\"\u0004\b-\u0010%R\u001A\u0010\n\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b.\u0010#\"\u0004\b/\u0010%R\u001A\u0010\u000B\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001A\u0010\f\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b2\u0010#\"\u0004\b3\u0010%R\u001A\u0010\r\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b4\u0010#\"\u0004\b5\u0010%R\u001A\u0010\u000E\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b6\u0010#\"\u0004\b7\u0010%R\u001C\u0010\u000F\u001A\u00020\u0010X\u0086\u000E¢\u0006\u0010\n\u0002\u0010<\u001A\u0004\b8\u00109\"\u0004\b:\u0010;R\u001A\u0010\u0011\u001A\u00020\u0012X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001A\u0010\u0013\u001A\u00020\u0014X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001C\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001C\u0010\u0017\u001A\u00020\u0018X\u0086\u000E¢\u0006\u0010\n\u0002\u0010<\u001A\u0004\bI\u00109\"\u0004\bJ\u0010;R\u001C\u0010\u0019\u001A\u00020\u0018X\u0086\u000E¢\u0006\u0010\n\u0002\u0010<\u001A\u0004\bK\u00109\"\u0004\bL\u0010;R\u001C\u0010\u001A\u001A\u00020\u001BX\u0086\u000E¢\u0006\u0010\n\u0002\u0010Q\u001A\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001C\u0010\u001C\u001A\u00020\u001DX\u0086\u000E¢\u0006\u0010\n\u0002\u0010Q\u001A\u0004\bR\u0010N\"\u0004\bS\u0010PR\u001C\u0010\u001E\u001A\u0004\u0018\u00010\u001FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0014\u0010X\u001A\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bY\u0010BR\u0014\u0010Z\u001A\u00020\u0014X\u0096D¢\u0006\b\n\u0000\u001A\u0004\bZ\u0010BR\u001F\u0010[\u001A\u0013\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020^0\\¢\u0006\u0002\b_X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006n"}, d2={"Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJIILandroidx/compose/ui/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getScaleX", "()F", "setScaleX", "(F)V", "getScaleY", "setScaleY", "getAlpha", "setAlpha", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "getShadowElevation", "setShadowElevation", "getRotationX", "setRotationX", "getRotationY", "setRotationY", "getRotationZ", "setRotationZ", "getCameraDistance", "setCameraDistance", "getTransformOrigin-SzJe1aQ", "()J", "setTransformOrigin-__ExYCQ", "(J)V", "J", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "getClip", "()Z", "setClip", "(Z)V", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "getAmbientShadowColor-0d7_KjU", "setAmbientShadowColor-8_81llA", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "getCompositingStrategy--NrFUSI", "()I", "setCompositingStrategy-aDBOjCE", "(I)V", "I", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "isImportantForBounds", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "invalidateLayerBlock", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "toString", "", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class SimpleGraphicsLayerModifier extends Node implements LayoutModifierNode, SemanticsModifierNode {
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private float cameraDistance;
    private boolean clip;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private final boolean isImportantForBounds;
    private Function1 layerBlock;
    private RenderEffect renderEffect;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private Shape shape;
    private long spotShadowColor;
    private long transformOrigin;
    private float translationX;
    private float translationY;

    public SimpleGraphicsLayerModifier(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10, long arg11, Shape arg13, boolean arg14, RenderEffect arg15, long arg16, long arg18, int arg20, int arg21, ColorFilter arg22, DefaultConstructorMarker arg23) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg13, arg14, arg15, arg16, arg18, arg20, arg21, arg22);
    }

    private SimpleGraphicsLayerModifier(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10, long arg11, Shape arg13, boolean arg14, RenderEffect arg15, long arg16, long arg18, int arg20, int arg21, ColorFilter arg22) {
        super();
        this.scaleX = arg1;
        this.scaleY = arg2;
        this.alpha = arg3;
        this.translationX = arg4;
        this.translationY = arg5;
        this.shadowElevation = arg6;
        this.rotationX = arg7;
        this.rotationY = arg8;
        this.rotationZ = arg9;
        this.cameraDistance = arg10;
        this.transformOrigin = arg11;
        this.shape = arg13;
        this.clip = arg14;
        this.renderEffect = arg15;
        this.ambientShadowColor = arg16;
        this.spotShadowColor = arg18;
        this.compositingStrategy = arg20;
        this.blendMode = arg21;
        this.colorFilter = arg22;
        this.layerBlock = new SimpleGraphicsLayerModifier$layerBlock$1(this);
    }

    public SimpleGraphicsLayerModifier(float arg26, float arg27, float arg28, float arg29, float arg30, float arg31, float arg32, float arg33, float arg34, float arg35, long arg36, Shape arg38, boolean arg39, RenderEffect arg40, long arg41, long arg43, int arg45, int arg46, ColorFilter arg47, int arg48, DefaultConstructorMarker arg49) {
        int v21 = (arg48 & 0x10000) != 0 ? CompositingStrategy.Companion.getAuto--NrFUSI() : arg45;
        int v22 = (arg48 & 0x20000) != 0 ? BlendMode.Companion.getSrcOver-0nO6VwU() : arg46;
        ColorFilter v23 = (arg48 & 0x40000) != 0 ? null : arg47;
        this(arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg38, arg39, arg40, arg41, arg43, v21, v22, v23, null);
    }

    public static final Function1 access$getLayerBlock$p(SimpleGraphicsLayerModifier arg0) {
        return arg0.layerBlock;
    }

    public void applySemantics(SemanticsPropertyReceiver arg2) {
        if(!ComposeUiFlags.isGraphicsLayerShapeSemanticsEnabled) {
        }
        else {
            if(!this.clip) {
                return;
            }

            goto label_6;
        }

        return;
    label_6:
        SemanticsPropertiesKt.setShape(arg2, this.shape);
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final long getAmbientShadowColor-0d7_KjU() {
        return this.ambientShadowColor;
    }

    public final int getBlendMode-0nO6VwU() {
        return this.blendMode;
    }

    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    public final boolean getClip() {
        return this.clip;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final int getCompositingStrategy--NrFUSI() {
        return this.compositingStrategy;
    }

    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public final float getRotationX() {
        return this.rotationX;
    }

    public final float getRotationY() {
        return this.rotationY;
    }

    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final float getShadowElevation() {
        return this.shadowElevation;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    public final long getSpotShadowColor-0d7_KjU() {
        return this.spotShadowColor;
    }

    public final long getTransformOrigin-SzJe1aQ() {
        return this.transformOrigin;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final void invalidateLayerBlock() {
        LayoutModifierNodeKt.updateLayerBlock(this, this.layerBlock);
    }

    public boolean isImportantForBounds() {
        return this.isImportantForBounds;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        Placeable v9 = arg9.measure-BRTryo0(arg10);
        return MeasureScope.layout$default(arg8, v9.getWidth(), v9.getHeight(), null, new SimpleGraphicsLayerModifier$measure$1(v9, this), 4, null);
    }

    public final void setAlpha(float arg1) {
        this.alpha = arg1;
    }

    public final void setAmbientShadowColor-8_81llA(long arg1) {
        this.ambientShadowColor = arg1;
    }

    public final void setBlendMode-s9anfk8(int arg1) {
        this.blendMode = arg1;
    }

    public final void setCameraDistance(float arg1) {
        this.cameraDistance = arg1;
    }

    public final void setClip(boolean arg1) {
        this.clip = arg1;
    }

    public final void setColorFilter(ColorFilter arg1) {
        this.colorFilter = arg1;
    }

    public final void setCompositingStrategy-aDBOjCE(int arg1) {
        this.compositingStrategy = arg1;
    }

    public final void setRenderEffect(RenderEffect arg1) {
        this.renderEffect = arg1;
    }

    public final void setRotationX(float arg1) {
        this.rotationX = arg1;
    }

    public final void setRotationY(float arg1) {
        this.rotationY = arg1;
    }

    public final void setRotationZ(float arg1) {
        this.rotationZ = arg1;
    }

    public final void setScaleX(float arg1) {
        this.scaleX = arg1;
    }

    public final void setScaleY(float arg1) {
        this.scaleY = arg1;
    }

    public final void setShadowElevation(float arg1) {
        this.shadowElevation = arg1;
    }

    public final void setShape(Shape arg1) {
        this.shape = arg1;
    }

    public final void setSpotShadowColor-8_81llA(long arg1) {
        this.spotShadowColor = arg1;
    }

    public final void setTransformOrigin-__ExYCQ(long arg1) {
        this.transformOrigin = arg1;
    }

    public final void setTranslationX(float arg1) {
        this.translationX = arg1;
    }

    public final void setTranslationY(float arg1) {
        this.translationY = arg1;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("SimpleGraphicsLayerModifier(scaleX=");
        v0.append(this.scaleX).append(", scaleY=").append(this.scaleY).append(", alpha = ").append(this.alpha).append(", translationX=").append(this.translationX).append(", translationY=").append(this.translationY).append(", shadowElevation=").append(this.shadowElevation).append(", rotationX=").append(this.rotationX).append(", rotationY=").append(this.rotationY).append(", rotationZ=").append(this.rotationZ).append(", cameraDistance=").append(this.cameraDistance).append(", transformOrigin=").append(TransformOrigin.toString-impl(this.transformOrigin)).append(", shape=");
        v0.append(this.shape).append(", clip=").append(this.clip).append(", renderEffect=").append(this.renderEffect).append(", ambientShadowColor=").append(Color.toString-impl(this.ambientShadowColor)).append(", spotShadowColor=").append(Color.toString-impl(this.spotShadowColor)).append(", compositingStrategy=").append(CompositingStrategy.toString-impl(this.compositingStrategy)).append(", blendMode=").append(BlendMode.toString-impl(this.blendMode)).append(", colorFilter=").append(this.colorFilter).append(')');
        return v0.toString();
    }
}

