package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0095\u0001\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001A¡\u0001\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00122\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001Aµ\u0001\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00122\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u001AH\u0007¢\u0006\u0004\b\u001C\u0010\u001D\u001A¿\u0001\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00122\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u001A2\b\b\u0002\u0010\u001E\u001A\u00020\u001FH\u0007¢\u0006\u0004\b \u0010!\u001AÕ\u0001\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00122\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u001A2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010\"\u001A\u00020#2\n\b\u0002\u0010$\u001A\u0004\u0018\u00010%H\u0007¢\u0006\u0004\b&\u0010\'\u001A%\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0017\u0010(\u001A\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)¢\u0006\u0002\b,H\u0007\u001A\f\u0010-\u001A\u00020\u0001*\u00020\u0001H\u0007\"\u0010\u0010.\u001A\u0004\u0018\u00010/X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00060"}, d2={"graphicsLayer", "Landroidx/compose/ui/Modifier;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "graphicsLayer-sKFY_QE", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "graphicsLayer-2Xn7asI", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;)Landroidx/compose/ui/Modifier;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "graphicsLayer-pANQ8Wg", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJ)Landroidx/compose/ui/Modifier;", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "graphicsLayer-Ap8cVGQ", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJI)Landroidx/compose/ui/Modifier;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "graphicsLayer-_6ThJ44", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJIILandroidx/compose/ui/graphics/ColorFilter;)Landroidx/compose/ui/Modifier;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "toolingGraphicsLayer", "reusableGraphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class GraphicsLayerModifierKt {
    private static ReusableGraphicsLayerScope reusableGraphicsLayerScope;

    static {
    }

    public static final ReusableGraphicsLayerScope access$getReusableGraphicsLayerScope$p() {
        return GraphicsLayerModifierKt.reusableGraphicsLayerScope;
    }

    public static final void access$setReusableGraphicsLayerScope$p(ReusableGraphicsLayerScope arg0) {
        GraphicsLayerModifierKt.reusableGraphicsLayerScope = arg0;
    }

    public static final Modifier graphicsLayer(Modifier arg1, Function1 arg2) {
        return arg1.then(new BlockGraphicsLayerElement(arg2));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replace with graphicsLayer that consumes shadow color parameters", replaceWith="<_subannotation>") public static final Modifier graphicsLayer-2Xn7asI(Modifier arg24, float arg25, float arg26, float arg27, float arg28, float arg29, float arg30, float arg31, float arg32, float arg33, float arg34, long arg35, Shape arg37, boolean arg38, RenderEffect arg39) {
        return GraphicsLayerModifierKt.graphicsLayer-_6ThJ44(arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg37, arg38, arg39, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor(), CompositingStrategy.Companion.getAuto--NrFUSI(), BlendMode.Companion.getSrcOver-0nO6VwU(), null);
    }

    public static Modifier graphicsLayer-2Xn7asI$default(Modifier arg15, float arg16, float arg17, float arg18, float arg19, float arg20, float arg21, float arg22, float arg23, float arg24, float arg25, long arg26, Shape arg28, boolean arg29, RenderEffect arg30, int arg31, Object arg32) {
        int v0 = arg31;
        float v2 = 1f;
        float v1 = (v0 & 1) != 0 ? v2 : arg16;
        float v3 = (v0 & 2) != 0 ? v2 : arg17;
        if((v0 & 4) != 0) {
        }
        else {
            v2 = arg18;
        }

        float v5 = 0f;
        float v4 = (v0 & 8) != 0 ? 0f : arg19;
        float v6 = (v0 & 16) != 0 ? 0f : arg20;
        float v7 = (v0 & 0x20) != 0 ? 0f : arg21;
        float v8 = (v0 & 0x40) != 0 ? 0f : arg22;
        float v9 = (v0 & 0x80) != 0 ? 0f : arg23;
        if((v0 & 0x100) != 0) {
        }
        else {
            v5 = arg24;
        }

        float v10 = (v0 & 0x200) != 0 ? 8f : arg25;
        long v11 = (v0 & 0x400) != 0 ? TransformOrigin.Companion.getCenter-SzJe1aQ() : arg26;
        Shape v13 = (v0 & 0x800) != 0 ? RectangleShapeKt.getRectangleShape() : arg28;
        boolean v14 = (v0 & 0x1000) != 0 ? false : arg29;
        RenderEffect v31 = (v0 & 0x2000) != 0 ? null : arg30;
        return GraphicsLayerModifierKt.graphicsLayer-2Xn7asI(arg15, v1, v3, v2, v4, v6, v7, v8, v9, v5, v10, v11, v13, v14, v31);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replace with graphicsLayer that consumes a blend mode and a color filter", replaceWith="<_subannotation>") public static final Modifier graphicsLayer-Ap8cVGQ(Modifier arg24, float arg25, float arg26, float arg27, float arg28, float arg29, float arg30, float arg31, float arg32, float arg33, float arg34, long arg35, Shape arg37, boolean arg38, RenderEffect arg39, long arg40, long arg42, int arg44) {
        return GraphicsLayerModifierKt.graphicsLayer-_6ThJ44(arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg37, arg38, arg39, arg40, arg42, arg44, BlendMode.Companion.getSrcOver-0nO6VwU(), null);
    }

    public static Modifier graphicsLayer-Ap8cVGQ$default(Modifier arg20, float arg21, float arg22, float arg23, float arg24, float arg25, float arg26, float arg27, float arg28, float arg29, float arg30, long arg31, Shape arg33, boolean arg34, RenderEffect arg35, long arg36, long arg38, int arg40, int arg41, Object arg42) {
        int v0 = arg41;
        float v2 = 1f;
        float v1 = (v0 & 1) != 0 ? v2 : arg21;
        float v3 = (v0 & 2) != 0 ? v2 : arg22;
        if((v0 & 4) != 0) {
        }
        else {
            v2 = arg23;
        }

        float v5 = 0f;
        float v4 = (v0 & 8) != 0 ? 0f : arg24;
        float v6 = (v0 & 16) != 0 ? 0f : arg25;
        float v7 = (v0 & 0x20) != 0 ? 0f : arg26;
        float v8 = (v0 & 0x40) != 0 ? 0f : arg27;
        float v9 = (v0 & 0x80) != 0 ? 0f : arg28;
        if((v0 & 0x100) != 0) {
        }
        else {
            v5 = arg29;
        }

        float v10 = (v0 & 0x200) != 0 ? 8f : arg30;
        long v11 = (v0 & 0x400) != 0 ? TransformOrigin.Companion.getCenter-SzJe1aQ() : arg31;
        Shape v13 = (v0 & 0x800) != 0 ? RectangleShapeKt.getRectangleShape() : arg33;
        boolean v14 = (v0 & 0x1000) != 0 ? false : arg34;
        RenderEffect v15 = (v0 & 0x2000) != 0 ? null : arg35;
        arg21 = v1;
        long v16 = (v0 & 0x4000) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : arg36;
        long v18 = (0x8000 & v0) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : arg38;
        arg41 = (v0 & 0x10000) != 0 ? CompositingStrategy.Companion.getAuto--NrFUSI() : arg40;
        return GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ(arg20, arg21, v3, v2, v4, v6, v7, v8, v9, v5, v10, v11, v13, v14, v15, v16, v18, arg41);
    }

    public static final Modifier graphicsLayer-_6ThJ44(Modifier arg24, float arg25, float arg26, float arg27, float arg28, float arg29, float arg30, float arg31, float arg32, float arg33, float arg34, long arg35, Shape arg37, boolean arg38, RenderEffect arg39, long arg40, long arg42, int arg44, int arg45, ColorFilter arg46) {
        return arg24.then(new GraphicsLayerElement(arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg37, arg38, arg39, arg40, arg42, arg44, arg45, arg46, null));
    }

    public static Modifier graphicsLayer-_6ThJ44$default(Modifier arg23, float arg24, float arg25, float arg26, float arg27, float arg28, float arg29, float arg30, float arg31, float arg32, float arg33, long arg34, Shape arg36, boolean arg37, RenderEffect arg38, long arg39, long arg41, int arg43, int arg44, ColorFilter arg45, int arg46, Object arg47) {
        int v0 = arg46;
        float v2 = 1f;
        float v1 = (v0 & 1) != 0 ? v2 : arg24;
        float v3 = (v0 & 2) != 0 ? v2 : arg25;
        if((v0 & 4) != 0) {
        }
        else {
            v2 = arg26;
        }

        float v5 = 0f;
        float v4 = (v0 & 8) != 0 ? 0f : arg27;
        float v6 = (v0 & 16) != 0 ? 0f : arg28;
        float v7 = (v0 & 0x20) != 0 ? 0f : arg29;
        float v8 = (v0 & 0x40) != 0 ? 0f : arg30;
        float v9 = (v0 & 0x80) != 0 ? 0f : arg31;
        if((v0 & 0x100) != 0) {
        }
        else {
            v5 = arg32;
        }

        float v10 = (v0 & 0x200) != 0 ? 8f : arg33;
        long v11 = (v0 & 0x400) != 0 ? TransformOrigin.Companion.getCenter-SzJe1aQ() : arg34;
        Shape v13 = (v0 & 0x800) != 0 ? RectangleShapeKt.getRectangleShape() : arg36;
        boolean v14 = (v0 & 0x1000) != 0 ? false : arg37;
        RenderEffect v16 = null;
        RenderEffect v15 = (v0 & 0x2000) != 0 ? v16 : arg38;
        arg24 = v1;
        long v17 = (v0 & 0x4000) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : arg39;
        long v19 = (0x8000 & v0) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : arg41;
        int v1_1 = (0x10000 & v0) != 0 ? CompositingStrategy.Companion.getAuto--NrFUSI() : arg43;
        int v21 = (v0 & 0x20000) != 0 ? BlendMode.Companion.getSrcOver-0nO6VwU() : arg44;
        ColorFilter v46 = (v0 & 0x40000) != 0 ? ((ColorFilter)v16) : arg45;
        return GraphicsLayerModifierKt.graphicsLayer-_6ThJ44(arg23, arg24, v3, v2, v4, v6, v7, v8, v9, v5, v10, v11, v13, v14, v15, v17, v19, v1_1, v21, v46);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replace with graphicsLayer that consumes a compositing strategy", replaceWith="<_subannotation>") public static final Modifier graphicsLayer-pANQ8Wg(Modifier arg24, float arg25, float arg26, float arg27, float arg28, float arg29, float arg30, float arg31, float arg32, float arg33, float arg34, long arg35, Shape arg37, boolean arg38, RenderEffect arg39, long arg40, long arg42) {
        return GraphicsLayerModifierKt.graphicsLayer-_6ThJ44(arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg37, arg38, arg39, arg40, arg42, CompositingStrategy.Companion.getAuto--NrFUSI(), BlendMode.Companion.getSrcOver-0nO6VwU(), null);
    }

    public static Modifier graphicsLayer-pANQ8Wg$default(Modifier arg18, float arg19, float arg20, float arg21, float arg22, float arg23, float arg24, float arg25, float arg26, float arg27, float arg28, long arg29, Shape arg31, boolean arg32, RenderEffect arg33, long arg34, long arg36, int arg38, Object arg39) {
        int v0 = arg38;
        float v2 = 1f;
        float v1 = (v0 & 1) != 0 ? v2 : arg19;
        float v3 = (v0 & 2) != 0 ? v2 : arg20;
        if((v0 & 4) != 0) {
        }
        else {
            v2 = arg21;
        }

        float v5 = 0f;
        float v4 = (v0 & 8) != 0 ? 0f : arg22;
        float v6 = (v0 & 16) != 0 ? 0f : arg23;
        float v7 = (v0 & 0x20) != 0 ? 0f : arg24;
        float v8 = (v0 & 0x40) != 0 ? 0f : arg25;
        float v9 = (v0 & 0x80) != 0 ? 0f : arg26;
        if((v0 & 0x100) != 0) {
        }
        else {
            v5 = arg27;
        }

        float v10 = (v0 & 0x200) != 0 ? 8f : arg28;
        long v11 = (v0 & 0x400) != 0 ? TransformOrigin.Companion.getCenter-SzJe1aQ() : arg29;
        Shape v13 = (v0 & 0x800) != 0 ? RectangleShapeKt.getRectangleShape() : arg31;
        boolean v14 = (v0 & 0x1000) != 0 ? false : arg32;
        RenderEffect v15 = (v0 & 0x2000) != 0 ? null : arg33;
        arg19 = v1;
        long v16 = (v0 & 0x4000) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : arg34;
        long v37 = (v0 & 0x8000) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : arg36;
        return GraphicsLayerModifierKt.graphicsLayer-pANQ8Wg(arg18, arg19, v3, v2, v4, v6, v7, v8, v9, v5, v10, v11, v13, v14, v15, v16, v37);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replace with graphicsLayer that consumes an optional RenderEffect parameter and shadow color parameters", replaceWith="<_subannotation>") public static final Modifier graphicsLayer-sKFY_QE(Modifier arg26, float arg27, float arg28, float arg29, float arg30, float arg31, float arg32, float arg33, float arg34, float arg35, float arg36, long arg37, Shape arg39, boolean arg40) {
        return GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg39, arg40, null, 0, 0, 0, BlendMode.Companion.getSrcOver-0nO6VwU(), null, 0x1C000, null);
    }

    public static Modifier graphicsLayer-sKFY_QE$default(Modifier arg13, float arg14, float arg15, float arg16, float arg17, float arg18, float arg19, float arg20, float arg21, float arg22, float arg23, long arg24, Shape arg26, boolean arg27, int arg28, Object arg29) {
        int v0 = arg28;
        float v2 = 1f;
        if((v0 & 1) != 0) {
            arg14 = v2;
        }

        float v1 = (v0 & 2) != 0 ? v2 : arg15;
        if((v0 & 4) != 0) {
        }
        else {
            v2 = arg16;
        }

        float v4 = 0f;
        float v3 = (v0 & 8) != 0 ? 0f : arg17;
        float v5 = (v0 & 16) != 0 ? 0f : arg18;
        float v6 = (v0 & 0x20) != 0 ? 0f : arg19;
        float v7 = (v0 & 0x40) != 0 ? 0f : arg20;
        float v8 = (v0 & 0x80) != 0 ? 0f : arg21;
        if((v0 & 0x100) != 0) {
        }
        else {
            v4 = arg22;
        }

        float v9 = (v0 & 0x200) != 0 ? 8f : arg23;
        long v10 = (v0 & 0x400) != 0 ? TransformOrigin.Companion.getCenter-SzJe1aQ() : arg24;
        Shape v12 = (v0 & 0x800) != 0 ? RectangleShapeKt.getRectangleShape() : arg26;
        boolean v28 = (v0 & 0x1000) != 0 ? false : arg27;
        return GraphicsLayerModifierKt.graphicsLayer-sKFY_QE(arg13, arg14, v1, v2, v3, v5, v6, v7, v8, v4, v9, v10, v12, v28);
    }

    public static final Modifier toolingGraphicsLayer(Modifier arg27) {
        Modifier v0 = arg27;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = v0.then(GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(Modifier.Companion, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0, null, false, null, 0, 0, 0, 0, null, 0x7FFFF, null));
        }

        return v0;
    }
}

