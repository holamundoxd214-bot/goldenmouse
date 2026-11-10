package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010u\u001A\u00020vJ\r\u0010w\u001A\u00020vH\u0000¢\u0006\u0002\bxR\u001A\u0010\u0004\u001A\u00020\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000B@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R$\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000B@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000E\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000B@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u000E\"\u0004\b\u0016\u0010\u0010R$\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000B@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u000E\"\u0004\b\u0019\u0010\u0010R$\u0010\u001A\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000B@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u000E\"\u0004\b\u001C\u0010\u0010R$\u0010\u001D\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000B@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u000E\"\u0004\b\u001F\u0010\u0010R&\u0010!\u001A\u00020 2\u0006\u0010\n\u001A\u00020 @VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010&\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R&\u0010\'\u001A\u00020 2\u0006\u0010\n\u001A\u00020 @VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010&\u001A\u0004\b(\u0010#\"\u0004\b)\u0010%R$\u0010*\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000B@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b+\u0010\u000E\"\u0004\b,\u0010\u0010R$\u0010-\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000B@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b.\u0010\u000E\"\u0004\b/\u0010\u0010R$\u00100\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000B@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b1\u0010\u000E\"\u0004\b2\u0010\u0010R$\u00103\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000B@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b4\u0010\u000E\"\u0004\b5\u0010\u0010R&\u00107\u001A\u0002062\u0006\u0010\n\u001A\u000206@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010&\u001A\u0004\b8\u0010#\"\u0004\b9\u0010%R$\u0010;\u001A\u00020:2\u0006\u0010\n\u001A\u00020:@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010A\u001A\u00020@2\u0006\u0010\n\u001A\u00020@@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bB\u0010C\"\u0004\bD\u0010ER&\u0010G\u001A\u00020F2\u0006\u0010\n\u001A\u00020F@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010J\u001A\u0004\bH\u0010\u0007\"\u0004\bI\u0010\tR\u001C\u0010K\u001A\u00020LX\u0096\u000E¢\u0006\u0010\n\u0002\u0010&\u001A\u0004\bM\u0010#\"\u0004\bN\u0010%R\u001A\u0010O\u001A\u00020PX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001A\u0010U\u001A\u00020VX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0014\u0010[\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\\\u0010\u000ER\u0014\u0010]\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b^\u0010\u000ER(\u0010`\u001A\u0004\u0018\u00010_2\b\u0010\n\u001A\u0004\u0018\u00010_@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\ba\u0010b\"\u0004\bc\u0010dR(\u0010f\u001A\u0004\u0018\u00010e2\b\u0010\n\u001A\u0004\u0018\u00010e@VX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bg\u0010h\"\u0004\bi\u0010jR&\u0010l\u001A\u00020k2\u0006\u0010\n\u001A\u00020k@VX\u0096\u000E¢\u0006\u0010\n\u0002\u0010J\u001A\u0004\bm\u0010\u0007\"\u0004\bn\u0010\tR\u001E\u0010o\u001A\u0004\u0018\u00010p@\u0001X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bq\u0010r\"\u0004\bs\u0010t¨\u0006y"}, d2={"Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "<init>", "()V", "mutatedFields", "", "getMutatedFields$ui", "()I", "setMutatedFields$ui", "(I)V", "value", "", "scaleX", "getScaleX", "()F", "setScaleX", "(F)V", "scaleY", "getScaleY", "setScaleY", "alpha", "getAlpha", "setAlpha", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "Landroidx/compose/ui/graphics/TransformOrigin;", "transformOrigin", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "Landroidx/compose/ui/graphics/Shape;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "", "clip", "getClip", "()Z", "setClip", "(Z)V", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "I", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "setSize-uvyYCjk", "graphicsDensity", "Landroidx/compose/ui/unit/Density;", "getGraphicsDensity$ui", "()Landroidx/compose/ui/unit/Density;", "setGraphicsDensity$ui", "(Landroidx/compose/ui/unit/Density;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection$ui", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection$ui", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "density", "getDensity", "fontScale", "getFontScale", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "setBlendMode-s9anfk8", "outline", "Landroidx/compose/ui/graphics/Outline;", "getOutline$ui", "()Landroidx/compose/ui/graphics/Outline;", "setOutline$ui", "(Landroidx/compose/ui/graphics/Outline;)V", "reset", "", "updateOutline", "updateOutline$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ReusableGraphicsLayerScope implements GraphicsLayerScope {
    public static final int $stable;
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private float cameraDistance;
    private boolean clip;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private Density graphicsDensity;
    private LayoutDirection layoutDirection;
    private int mutatedFields;
    private Outline outline;
    private RenderEffect renderEffect;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private Shape shape;
    private long size;
    private long spotShadowColor;
    private long transformOrigin;
    private float translationX;
    private float translationY;

    static {
    }

    public ReusableGraphicsLayerScope() {
        super();
        this.scaleX = 1f;
        this.scaleY = 1f;
        this.alpha = 1f;
        this.ambientShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
        this.spotShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
        this.cameraDistance = 8f;
        this.transformOrigin = TransformOrigin.Companion.getCenter-SzJe1aQ();
        this.shape = RectangleShapeKt.getRectangleShape();
        this.compositingStrategy = CompositingStrategy.Companion.getAuto--NrFUSI();
        this.size = Size.Companion.getUnspecified-NH-jbRc();
        this.graphicsDensity = DensityKt.Density$default(1f, 0f, 2, null);
        this.layoutDirection = LayoutDirection.Ltr;
        this.blendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
    }

    public float getAlpha() {
        return this.alpha;
    }

    public long getAmbientShadowColor-0d7_KjU() {
        return this.ambientShadowColor;
    }

    public int getBlendMode-0nO6VwU() {
        return this.blendMode;
    }

    public float getCameraDistance() {
        return this.cameraDistance;
    }

    public boolean getClip() {
        return this.clip;
    }

    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public int getCompositingStrategy--NrFUSI() {
        return this.compositingStrategy;
    }

    public float getDensity() {
        return this.graphicsDensity.getDensity();
    }

    public float getFontScale() {
        return this.graphicsDensity.getFontScale();
    }

    public final Density getGraphicsDensity$ui() {
        return this.graphicsDensity;
    }

    public final LayoutDirection getLayoutDirection$ui() {
        return this.layoutDirection;
    }

    public final int getMutatedFields$ui() {
        return this.mutatedFields;
    }

    public final Outline getOutline$ui() {
        return this.outline;
    }

    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public float getRotationX() {
        return this.rotationX;
    }

    public float getRotationY() {
        return this.rotationY;
    }

    public float getRotationZ() {
        return this.rotationZ;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public float getShadowElevation() {
        return this.shadowElevation;
    }

    public Shape getShape() {
        return this.shape;
    }

    public long getSize-NH-jbRc() {
        return this.size;
    }

    public long getSpotShadowColor-0d7_KjU() {
        return this.spotShadowColor;
    }

    public long getTransformOrigin-SzJe1aQ() {
        return this.transformOrigin;
    }

    public float getTranslationX() {
        return this.translationX;
    }

    public float getTranslationY() {
        return this.translationY;
    }

    public final void reset() {
        this.setScaleX(1f);
        this.setScaleY(1f);
        this.setAlpha(1f);
        this.setTranslationX(0f);
        this.setTranslationY(0f);
        this.setShadowElevation(0f);
        this.setAmbientShadowColor-8_81llA(GraphicsLayerScopeKt.getDefaultShadowColor());
        this.setSpotShadowColor-8_81llA(GraphicsLayerScopeKt.getDefaultShadowColor());
        this.setRotationX(0f);
        this.setRotationY(0f);
        this.setRotationZ(0f);
        this.setCameraDistance(8f);
        this.setTransformOrigin-__ExYCQ(TransformOrigin.Companion.getCenter-SzJe1aQ());
        this.setShape(RectangleShapeKt.getRectangleShape());
        this.setClip(false);
        this.setRenderEffect(null);
        this.setColorFilter(null);
        this.setBlendMode-s9anfk8(BlendMode.Companion.getSrcOver-0nO6VwU());
        this.setCompositingStrategy-aDBOjCE(CompositingStrategy.Companion.getAuto--NrFUSI());
        this.setSize-uvyYCjk(Size.Companion.getUnspecified-NH-jbRc());
        this.outline = null;
        this.mutatedFields = 0;
    }

    public void setAlpha(float arg2) {
        if(this.alpha == arg2) {
            return;
        }

        this.mutatedFields |= 4;
        this.alpha = arg2;
    }

    public void setAmbientShadowColor-8_81llA(long arg3) {
        if(!Color.equals-impl0(this.ambientShadowColor, arg3)) {
            this.mutatedFields |= 0x40;
            this.ambientShadowColor = arg3;
        }
    }

    public void setBlendMode-s9anfk8(int arg3) {
        if(!BlendMode.equals-impl0(this.blendMode, arg3)) {
            this.mutatedFields |= 0x80000;
            this.blendMode = arg3;
        }
    }

    public void setCameraDistance(float arg2) {
        if(this.cameraDistance == arg2) {
            return;
        }

        this.mutatedFields |= 0x800;
        this.cameraDistance = arg2;
    }

    public void setClip(boolean arg2) {
        if(this.clip != arg2) {
            this.mutatedFields |= 0x4000;
            this.clip = arg2;
        }
    }

    public void setColorFilter(ColorFilter arg3) {
        if(!Intrinsics.areEqual(this.colorFilter, arg3)) {
            this.mutatedFields |= 0x40000;
            this.colorFilter = arg3;
        }
    }

    public void setCompositingStrategy-aDBOjCE(int arg3) {
        if(!CompositingStrategy.equals-impl0(this.compositingStrategy, arg3)) {
            this.mutatedFields |= 0x8000;
            this.compositingStrategy = arg3;
        }
    }

    public final void setGraphicsDensity$ui(Density arg1) {
        this.graphicsDensity = arg1;
    }

    public final void setLayoutDirection$ui(LayoutDirection arg1) {
        this.layoutDirection = arg1;
    }

    public final void setMutatedFields$ui(int arg1) {
        this.mutatedFields = arg1;
    }

    public final void setOutline$ui(Outline arg1) {
        this.outline = arg1;
    }

    public void setRenderEffect(RenderEffect arg3) {
        if(!Intrinsics.areEqual(this.renderEffect, arg3)) {
            this.mutatedFields |= 0x20000;
            this.renderEffect = arg3;
        }
    }

    public void setRotationX(float arg2) {
        if(this.rotationX == arg2) {
            return;
        }

        this.mutatedFields |= 0x100;
        this.rotationX = arg2;
    }

    public void setRotationY(float arg2) {
        if(this.rotationY == arg2) {
            return;
        }

        this.mutatedFields |= 0x200;
        this.rotationY = arg2;
    }

    public void setRotationZ(float arg2) {
        if(this.rotationZ == arg2) {
            return;
        }

        this.mutatedFields |= 0x400;
        this.rotationZ = arg2;
    }

    public void setScaleX(float arg2) {
        if(this.scaleX == arg2) {
            return;
        }

        this.mutatedFields |= 1;
        this.scaleX = arg2;
    }

    public void setScaleY(float arg2) {
        if(this.scaleY == arg2) {
            return;
        }

        this.mutatedFields |= 2;
        this.scaleY = arg2;
    }

    public void setShadowElevation(float arg2) {
        if(this.shadowElevation == arg2) {
            return;
        }

        this.mutatedFields |= 0x20;
        this.shadowElevation = arg2;
    }

    public void setShape(Shape arg2) {
        if(!Intrinsics.areEqual(this.shape, arg2)) {
            this.mutatedFields |= 0x2000;
            this.shape = arg2;
        }
    }

    public void setSize-uvyYCjk(long arg1) {
        this.size = arg1;
    }

    public void setSpotShadowColor-8_81llA(long arg3) {
        if(!Color.equals-impl0(this.spotShadowColor, arg3)) {
            this.mutatedFields |= 0x80;
            this.spotShadowColor = arg3;
        }
    }

    public void setTransformOrigin-__ExYCQ(long arg3) {
        if(!TransformOrigin.equals-impl0(this.transformOrigin, arg3)) {
            this.mutatedFields |= 0x1000;
            this.transformOrigin = arg3;
        }
    }

    public void setTranslationX(float arg2) {
        if(this.translationX == arg2) {
            return;
        }

        this.mutatedFields |= 8;
        this.translationX = arg2;
    }

    public void setTranslationY(float arg2) {
        if(this.translationY == arg2) {
            return;
        }

        this.mutatedFields |= 16;
        this.translationY = arg2;
    }

    public final void updateOutline$ui() {
        this.outline = this.getShape().createOutline-Pq9zytI(this.getSize-NH-jbRc(), this.layoutDirection, this.graphicsDensity);
    }
}

