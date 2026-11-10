package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001D\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B£\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0004\u0012\u0006\u0010\b\u001A\u00020\u0004\u0012\u0006\u0010\t\u001A\u00020\u0004\u0012\u0006\u0010\n\u001A\u00020\u0004\u0012\u0006\u0010\u000B\u001A\u00020\u0004\u0012\u0006\u0010\f\u001A\u00020\u0004\u0012\u0006\u0010\r\u001A\u00020\u0004\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u0012\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001A\u00020\u0017\u0012\u0006\u0010\u0018\u001A\u00020\u0017\u0012\u0006\u0010\u0019\u001A\u00020\u001A\u0012\u0006\u0010\u001B\u001A\u00020\u001C\u0012\b\u0010\u001D\u001A\u0004\u0018\u00010\u001E¢\u0006\u0004\b\u001F\u0010 J\b\u0010=\u001A\u00020\u0002H\u0016J\u0010\u0010>\u001A\u00020?2\u0006\u0010@\u001A\u00020\u0002H\u0016J\f\u0010A\u001A\u00020?*\u00020BH\u0016J\t\u0010C\u001A\u00020\u0004HÆ\u0003J\t\u0010D\u001A\u00020\u0004HÆ\u0003J\t\u0010E\u001A\u00020\u0004HÆ\u0003J\t\u0010F\u001A\u00020\u0004HÆ\u0003J\t\u0010G\u001A\u00020\u0004HÆ\u0003J\t\u0010H\u001A\u00020\u0004HÆ\u0003J\t\u0010I\u001A\u00020\u0004HÆ\u0003J\t\u0010J\u001A\u00020\u0004HÆ\u0003J\t\u0010K\u001A\u00020\u0004HÆ\u0003J\t\u0010L\u001A\u00020\u0004HÆ\u0003J\u0010\u0010M\u001A\u00020\u000FHÆ\u0003¢\u0006\u0004\bN\u0010-J\t\u0010O\u001A\u00020\u0011HÆ\u0003J\t\u0010P\u001A\u00020\u0013HÆ\u0003J\u000B\u0010Q\u001A\u0004\u0018\u00010\u0015HÆ\u0003J\u0010\u0010R\u001A\u00020\u0017HÆ\u0003¢\u0006\u0004\bS\u0010-J\u0010\u0010T\u001A\u00020\u0017HÆ\u0003¢\u0006\u0004\bU\u0010-J\u0010\u0010V\u001A\u00020\u001AHÆ\u0003¢\u0006\u0004\bW\u00108J\u0010\u0010X\u001A\u00020\u001CHÆ\u0003¢\u0006\u0004\bY\u00108J\u000B\u0010Z\u001A\u0004\u0018\u00010\u001EHÆ\u0003JÒ\u0001\u0010[\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00042\b\b\u0002\u0010\b\u001A\u00020\u00042\b\b\u0002\u0010\t\u001A\u00020\u00042\b\b\u0002\u0010\n\u001A\u00020\u00042\b\b\u0002\u0010\u000B\u001A\u00020\u00042\b\b\u0002\u0010\f\u001A\u00020\u00042\b\b\u0002\u0010\r\u001A\u00020\u00042\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0018\u001A\u00020\u00172\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001EHÆ\u0001¢\u0006\u0004\b\\\u0010]J\u0013\u0010^\u001A\u00020\u00132\b\u0010_\u001A\u0004\u0018\u00010`HÖ\u0003J\t\u0010a\u001A\u00020bHÖ\u0001J\t\u0010c\u001A\u00020dHÖ\u0001R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\"R\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\"R\u0011\u0010\u0006\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\"R\u0011\u0010\u0007\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b%\u0010\"R\u0011\u0010\b\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\"R\u0011\u0010\t\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010\"R\u0011\u0010\n\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b(\u0010\"R\u0011\u0010\u000B\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b)\u0010\"R\u0011\u0010\f\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b*\u0010\"R\u0011\u0010\r\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b+\u0010\"R\u0013\u0010\u000E\u001A\u00020\u000F¢\u0006\n\n\u0002\u0010.\u001A\u0004\b,\u0010-R\u0011\u0010\u0010\u001A\u00020\u0011¢\u0006\b\n\u0000\u001A\u0004\b/\u00100R\u0011\u0010\u0012\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b1\u00102R\u0013\u0010\u0014\u001A\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001A\u0004\b3\u00104R\u0013\u0010\u0016\u001A\u00020\u0017¢\u0006\n\n\u0002\u0010.\u001A\u0004\b5\u0010-R\u0013\u0010\u0018\u001A\u00020\u0017¢\u0006\n\n\u0002\u0010.\u001A\u0004\b6\u0010-R\u0013\u0010\u0019\u001A\u00020\u001A¢\u0006\n\n\u0002\u00109\u001A\u0004\b7\u00108R\u0013\u0010\u001B\u001A\u00020\u001C¢\u0006\n\n\u0002\u00109\u001A\u0004\b:\u00108R\u0013\u0010\u001D\u001A\u0004\u0018\u00010\u001E¢\u0006\b\n\u0000\u001A\u0004\b;\u0010<¨\u0006e"}, d2={"Landroidx/compose/ui/graphics/GraphicsLayerElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/graphics/SimpleGraphicsLayerModifier;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJIILandroidx/compose/ui/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getScaleX", "()F", "getScaleY", "getAlpha", "getTranslationX", "getTranslationY", "getShadowElevation", "getRotationX", "getRotationY", "getRotationZ", "getCameraDistance", "getTransformOrigin-SzJe1aQ", "()J", "J", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getClip", "()Z", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "getAmbientShadowColor-0d7_KjU", "getSpotShadowColor-0d7_KjU", "getCompositingStrategy--NrFUSI", "()I", "I", "getBlendMode-0nO6VwU", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component11-SzJe1aQ", "component12", "component13", "component14", "component15", "component15-0d7_KjU", "component16", "component16-0d7_KjU", "component17", "component17--NrFUSI", "component18", "component18-0nO6VwU", "component19", "copy", "copy-cp5nf6A", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJIILandroidx/compose/ui/graphics/ColorFilter;)Landroidx/compose/ui/graphics/GraphicsLayerElement;", "equals", "other", "", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class GraphicsLayerElement extends ModifierNodeElement {
    private final float alpha;
    private final long ambientShadowColor;
    private final int blendMode;
    private final float cameraDistance;
    private final boolean clip;
    private final ColorFilter colorFilter;
    private final int compositingStrategy;
    private final RenderEffect renderEffect;
    private final float rotationX;
    private final float rotationY;
    private final float rotationZ;
    private final float scaleX;
    private final float scaleY;
    private final float shadowElevation;
    private final Shape shape;
    private final long spotShadowColor;
    private final long transformOrigin;
    private final float translationX;
    private final float translationY;

    private GraphicsLayerElement(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10, long arg11, Shape arg13, boolean arg14, RenderEffect arg15, long arg16, long arg18, int arg20, int arg21, ColorFilter arg22) {
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
    }

    public GraphicsLayerElement(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10, long arg11, Shape arg13, boolean arg14, RenderEffect arg15, long arg16, long arg18, int arg20, int arg21, ColorFilter arg22, DefaultConstructorMarker arg23) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg13, arg14, arg15, arg16, arg18, arg20, arg21, arg22);
    }

    public final float component1() {
        return this.scaleX;
    }

    public final float component10() {
        return this.cameraDistance;
    }

    public final long component11-SzJe1aQ() {
        return this.transformOrigin;
    }

    public final Shape component12() {
        return this.shape;
    }

    public final boolean component13() {
        return this.clip;
    }

    public final RenderEffect component14() {
        return this.renderEffect;
    }

    public final long component15-0d7_KjU() {
        return this.ambientShadowColor;
    }

    public final long component16-0d7_KjU() {
        return this.spotShadowColor;
    }

    public final int component17--NrFUSI() {
        return this.compositingStrategy;
    }

    public final int component18-0nO6VwU() {
        return this.blendMode;
    }

    public final ColorFilter component19() {
        return this.colorFilter;
    }

    public final float component2() {
        return this.scaleY;
    }

    public final float component3() {
        return this.alpha;
    }

    public final float component4() {
        return this.translationX;
    }

    public final float component5() {
        return this.translationY;
    }

    public final float component6() {
        return this.shadowElevation;
    }

    public final float component7() {
        return this.rotationX;
    }

    public final float component8() {
        return this.rotationY;
    }

    public final float component9() {
        return this.rotationZ;
    }

    public final GraphicsLayerElement copy-cp5nf6A(float arg25, float arg26, float arg27, float arg28, float arg29, float arg30, float arg31, float arg32, float arg33, float arg34, long arg35, Shape arg37, boolean arg38, RenderEffect arg39, long arg40, long arg42, int arg44, int arg45, ColorFilter arg46) {
        return new GraphicsLayerElement(arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg37, arg38, arg39, arg40, arg42, arg44, arg45, arg46, null);
    }

    public static GraphicsLayerElement copy-cp5nf6A$default(GraphicsLayerElement arg17, float arg18, float arg19, float arg20, float arg21, float arg22, float arg23, float arg24, float arg25, float arg26, float arg27, long arg28, Shape arg30, boolean arg31, RenderEffect arg32, long arg33, long arg35, int arg37, int arg38, ColorFilter arg39, int arg40, Object arg41) {
        ColorFilter v40;
        GraphicsLayerElement v0 = arg17;
        int v1 = arg40;
        float v2 = (v1 & 1) != 0 ? v0.scaleX : arg18;
        float v3 = (v1 & 2) != 0 ? v0.scaleY : arg19;
        float v4 = (v1 & 4) != 0 ? v0.alpha : arg20;
        float v5 = (v1 & 8) != 0 ? v0.translationX : arg21;
        float v6 = (v1 & 16) != 0 ? v0.translationY : arg22;
        float v7 = (v1 & 0x20) != 0 ? v0.shadowElevation : arg23;
        float v8 = (v1 & 0x40) != 0 ? v0.rotationX : arg24;
        float v9 = (v1 & 0x80) != 0 ? v0.rotationY : arg25;
        float v10 = (v1 & 0x100) != 0 ? v0.rotationZ : arg26;
        float v11 = (v1 & 0x200) != 0 ? v0.cameraDistance : arg27;
        long v12 = (v1 & 0x400) != 0 ? v0.transformOrigin : arg28;
        Shape v14 = (v1 & 0x800) != 0 ? v0.shape : arg30;
        boolean v15 = (v1 & 0x1000) != 0 ? v0.clip : arg31;
        arg18 = v2;
        RenderEffect v2_1 = (v1 & 0x2000) != 0 ? v0.renderEffect : arg32;
        RenderEffect v19 = v2_1;
        long v1_1 = (v1 & 0x4000) != 0 ? v0.ambientShadowColor : arg33;
        long v20 = v1_1;
        v1_1 = (arg40 & 0x8000) != 0 ? v0.spotShadowColor : arg35;
        long v22 = v1_1;
        v1 = (arg40 & 0x10000) != 0 ? v0.compositingStrategy : arg37;
        int v2_2 = (arg40 & 0x20000) != 0 ? v0.blendMode : arg38;
        if((arg40 & 0x40000) != 0) {
            arg38 = v1;
            v40 = v0.colorFilter;
        }
        else {
            v40 = arg39;
            arg38 = v1;
        }

        return v0.copy-cp5nf6A(arg18, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v14, v15, v19, v20, v22, arg38, v2_2, v40);
    }

    public Node create() {
        return this.create();
    }

    public SimpleGraphicsLayerModifier create() {
        return new SimpleGraphicsLayerModifier(this.scaleX, this.scaleY, this.alpha, this.translationX, this.translationY, this.shadowElevation, this.rotationX, this.rotationY, this.rotationZ, this.cameraDistance, this.transformOrigin, this.shape, this.clip, this.renderEffect, this.ambientShadowColor, this.spotShadowColor, this.compositingStrategy, this.blendMode, this.colorFilter, null);
    }

    public boolean equals(Object arg8) {
        if(this == (((GraphicsLayerElement)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof GraphicsLayerElement)) {
            return 0;
        }

        if(Float.compare(this.scaleX, ((GraphicsLayerElement)arg8).scaleX) != 0) {
            return 0;
        }

        if(Float.compare(this.scaleY, ((GraphicsLayerElement)arg8).scaleY) != 0) {
            return 0;
        }

        if(Float.compare(this.alpha, ((GraphicsLayerElement)arg8).alpha) != 0) {
            return 0;
        }

        if(Float.compare(this.translationX, ((GraphicsLayerElement)arg8).translationX) != 0) {
            return 0;
        }

        if(Float.compare(this.translationY, ((GraphicsLayerElement)arg8).translationY) != 0) {
            return 0;
        }

        if(Float.compare(this.shadowElevation, ((GraphicsLayerElement)arg8).shadowElevation) != 0) {
            return 0;
        }

        if(Float.compare(this.rotationX, ((GraphicsLayerElement)arg8).rotationX) != 0) {
            return 0;
        }

        if(Float.compare(this.rotationY, ((GraphicsLayerElement)arg8).rotationY) != 0) {
            return 0;
        }

        if(Float.compare(this.rotationZ, ((GraphicsLayerElement)arg8).rotationZ) != 0) {
            return 0;
        }

        if(Float.compare(this.cameraDistance, ((GraphicsLayerElement)arg8).cameraDistance) != 0) {
            return 0;
        }

        if(!TransformOrigin.equals-impl0(this.transformOrigin, ((GraphicsLayerElement)arg8).transformOrigin)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.shape, ((GraphicsLayerElement)arg8).shape)) {
            return 0;
        }

        if(this.clip != ((GraphicsLayerElement)arg8).clip) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.renderEffect, ((GraphicsLayerElement)arg8).renderEffect)) {
            return 0;
        }

        if(!Color.equals-impl0(this.ambientShadowColor, ((GraphicsLayerElement)arg8).ambientShadowColor)) {
            return 0;
        }

        if(!Color.equals-impl0(this.spotShadowColor, ((GraphicsLayerElement)arg8).spotShadowColor)) {
            return 0;
        }

        if(!CompositingStrategy.equals-impl0(this.compositingStrategy, ((GraphicsLayerElement)arg8).compositingStrategy)) {
            return 0;
        }

        if(!BlendMode.equals-impl0(this.blendMode, ((GraphicsLayerElement)arg8).blendMode)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.colorFilter, ((GraphicsLayerElement)arg8).colorFilter)) {
            return 0;
        }

        return 1;
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

    public int hashCode() {
        int v0 = ((((((((((((Float.hashCode(this.scaleX) * 0x1F + Float.hashCode(this.scaleY)) * 0x1F + Float.hashCode(this.alpha)) * 0x1F + Float.hashCode(this.translationX)) * 0x1F + Float.hashCode(this.translationY)) * 0x1F + Float.hashCode(this.shadowElevation)) * 0x1F + Float.hashCode(this.rotationX)) * 0x1F + Float.hashCode(this.rotationY)) * 0x1F + Float.hashCode(this.rotationZ)) * 0x1F + Float.hashCode(this.cameraDistance)) * 0x1F + TransformOrigin.hashCode-impl(this.transformOrigin)) * 0x1F + this.shape.hashCode()) * 0x1F + Boolean.hashCode(this.clip)) * 0x1F;
        RenderEffect v1 = this.renderEffect;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (((((v0 + v1_1) * 0x1F + Color.hashCode-impl(this.ambientShadowColor)) * 0x1F + Color.hashCode-impl(this.spotShadowColor)) * 0x1F + CompositingStrategy.hashCode-impl(this.compositingStrategy)) * 0x1F + BlendMode.hashCode-impl(this.blendMode)) * 0x1F;
        ColorFilter v5 = this.colorFilter;
        if(v5 == null) {
        }
        else {
            v2 = v5.hashCode();
        }

        return v0 + v2;
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("graphicsLayer");
        arg4.getProperties().set("scaleX", Float.valueOf(this.scaleX));
        arg4.getProperties().set("scaleY", Float.valueOf(this.scaleY));
        arg4.getProperties().set("alpha", Float.valueOf(this.alpha));
        arg4.getProperties().set("translationX", Float.valueOf(this.translationX));
        arg4.getProperties().set("translationY", Float.valueOf(this.translationY));
        arg4.getProperties().set("shadowElevation", Float.valueOf(this.shadowElevation));
        arg4.getProperties().set("rotationX", Float.valueOf(this.rotationX));
        arg4.getProperties().set("rotationY", Float.valueOf(this.rotationY));
        arg4.getProperties().set("rotationZ", Float.valueOf(this.rotationZ));
        arg4.getProperties().set("cameraDistance", Float.valueOf(this.cameraDistance));
        arg4.getProperties().set("transformOrigin", TransformOrigin.box-impl(this.transformOrigin));
        arg4.getProperties().set("shape", this.shape);
        arg4.getProperties().set("clip", Boolean.valueOf(this.clip));
        arg4.getProperties().set("renderEffect", this.renderEffect);
        arg4.getProperties().set("ambientShadowColor", Color.box-impl(this.ambientShadowColor));
        arg4.getProperties().set("spotShadowColor", Color.box-impl(this.spotShadowColor));
        arg4.getProperties().set("compositingStrategy", CompositingStrategy.box-impl(this.compositingStrategy));
        arg4.getProperties().set("blendMode", BlendMode.box-impl(this.blendMode));
        arg4.getProperties().set("colorFilter", this.colorFilter);
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("GraphicsLayerElement(scaleX=");
        v0.append(this.scaleX).append(", scaleY=").append(this.scaleY).append(", alpha=").append(this.alpha).append(", translationX=").append(this.translationX).append(", translationY=").append(this.translationY).append(", shadowElevation=").append(this.shadowElevation).append(", rotationX=").append(this.rotationX).append(", rotationY=").append(this.rotationY).append(", rotationZ=").append(this.rotationZ).append(", cameraDistance=").append(this.cameraDistance).append(", transformOrigin=").append(TransformOrigin.toString-impl(this.transformOrigin)).append(", shape=");
        v0.append(this.shape).append(", clip=").append(this.clip).append(", renderEffect=").append(this.renderEffect).append(", ambientShadowColor=").append(Color.toString-impl(this.ambientShadowColor)).append(", spotShadowColor=").append(Color.toString-impl(this.spotShadowColor)).append(", compositingStrategy=").append(CompositingStrategy.toString-impl(this.compositingStrategy)).append(", blendMode=").append(BlendMode.toString-impl(this.blendMode)).append(", colorFilter=").append(this.colorFilter).append(')');
        return v0.toString();
    }

    public void update(Node arg1) {
        this.update(((SimpleGraphicsLayerModifier)arg1));
    }

    public void update(SimpleGraphicsLayerModifier arg3) {
        arg3.setScaleX(this.scaleX);
        arg3.setScaleY(this.scaleY);
        arg3.setAlpha(this.alpha);
        arg3.setTranslationX(this.translationX);
        arg3.setTranslationY(this.translationY);
        arg3.setShadowElevation(this.shadowElevation);
        arg3.setRotationX(this.rotationX);
        arg3.setRotationY(this.rotationY);
        arg3.setRotationZ(this.rotationZ);
        arg3.setCameraDistance(this.cameraDistance);
        arg3.setTransformOrigin-__ExYCQ(this.transformOrigin);
        arg3.setShape(this.shape);
        arg3.setClip(this.clip);
        arg3.setRenderEffect(this.renderEffect);
        arg3.setAmbientShadowColor-8_81llA(this.ambientShadowColor);
        arg3.setSpotShadowColor-8_81llA(this.spotShadowColor);
        arg3.setCompositingStrategy-aDBOjCE(this.compositingStrategy);
        arg3.setBlendMode-s9anfk8(this.blendMode);
        arg3.setColorFilter(this.colorFilter);
        arg3.invalidateLayerBlock();
    }
}

