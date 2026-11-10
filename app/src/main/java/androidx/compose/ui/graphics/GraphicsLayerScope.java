package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.PlacementScopeMarker;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;

@PlacementScopeMarker @Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000B\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u0018\u0010\u000E\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u000F\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u0018\u0010\u0011\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\u0018\u0010\u0014\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007R$\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0017\u001A\u00020\u00188V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR$\u0010\u001D\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u00188V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u001E\u0010\u001A\"\u0004\b\u001F\u0010\u001CR\u0018\u0010 \u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007R\u0018\u0010#\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007R\u0018\u0010&\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\'\u0010\u0005\"\u0004\b(\u0010\u0007R\u0018\u0010)\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R\u0018\u0010,\u001A\u00020-X¦\u000E¢\u0006\f\u001A\u0004\b.\u0010\u001A\"\u0004\b/\u0010\u001CR\u0018\u00100\u001A\u000201X¦\u000E¢\u0006\f\u001A\u0004\b2\u00103\"\u0004\b4\u00105R\u001E\u00106\u001A\u000207X¦\u000E¢\u0006\u0012\u0012\u0004\b8\u00109\u001A\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010@\u001A\u0004\u0018\u00010?2\b\u0010>\u001A\u0004\u0018\u00010?8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001A\u00020E2\u0006\u0010>\u001A\u00020E8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bG\u0010H\"\u0004\bI\u0010JR(\u0010L\u001A\u0004\u0018\u00010K2\b\u0010>\u001A\u0004\u0018\u00010K8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u0010Q\u001A\u00020R2\u0006\u0010Q\u001A\u00020R8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\bS\u0010H\"\u0004\bT\u0010JR\u0014\u0010U\u001A\u00020V8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\bW\u0010\u001Aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006XÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Landroidx/compose/ui/unit/Density;", "scaleX", "", "getScaleX", "()F", "setScaleX", "(F)V", "scaleY", "getScaleY", "setScaleY", "alpha", "getAlpha", "setAlpha", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "shadowElevation", "getShadowElevation", "setShadowElevation", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "cameraDistance", "getCameraDistance", "setCameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "getTransformOrigin-SzJe1aQ", "setTransformOrigin-__ExYCQ", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "clip", "", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "_", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface GraphicsLayerScope extends Density {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static long getAmbientShadowColor-0d7_KjU(GraphicsLayerScope arg2) {
            return arg2.getAmbientShadowColor-0d7_KjU();
        }

        @Deprecated public static int getBlendMode-0nO6VwU(GraphicsLayerScope arg0) {
            return arg0.getBlendMode-0nO6VwU();
        }

        public static void getClip$annotations() {
        }

        @Deprecated public static ColorFilter getColorFilter(GraphicsLayerScope arg0) {
            return arg0.getColorFilter();
        }

        @Deprecated public static int getCompositingStrategy--NrFUSI(GraphicsLayerScope arg0) {
            return arg0.getCompositingStrategy--NrFUSI();
        }

        @Deprecated public static RenderEffect getRenderEffect(GraphicsLayerScope arg0) {
            return arg0.getRenderEffect();
        }

        @Deprecated public static long getSize-NH-jbRc(GraphicsLayerScope arg2) {
            return arg2.getSize-NH-jbRc();
        }

        @Deprecated public static long getSpotShadowColor-0d7_KjU(GraphicsLayerScope arg2) {
            return arg2.getSpotShadowColor-0d7_KjU();
        }

        @Deprecated public static int roundToPx--R2X_6o(GraphicsLayerScope arg0, long arg1) {
            return arg0.roundToPx--R2X_6o(arg1);
        }

        @Deprecated public static int roundToPx-0680j_4(GraphicsLayerScope arg0, float arg1) {
            return arg0.roundToPx-0680j_4(arg1);
        }

        @Deprecated public static void setAmbientShadowColor-8_81llA(GraphicsLayerScope arg0, long arg1) {
            arg0.setAmbientShadowColor-8_81llA(arg1);
        }

        @Deprecated public static void setBlendMode-s9anfk8(GraphicsLayerScope arg0, int arg1) {
            arg0.setBlendMode-s9anfk8(arg1);
        }

        @Deprecated public static void setColorFilter(GraphicsLayerScope arg0, ColorFilter arg1) {
            arg0.setColorFilter(arg1);
        }

        @Deprecated public static void setCompositingStrategy-aDBOjCE(GraphicsLayerScope arg0, int arg1) {
            arg0.setCompositingStrategy-aDBOjCE(arg1);
        }

        @Deprecated public static void setRenderEffect(GraphicsLayerScope arg0, RenderEffect arg1) {
            arg0.setRenderEffect(arg1);
        }

        @Deprecated public static void setSpotShadowColor-8_81llA(GraphicsLayerScope arg0, long arg1) {
            arg0.setSpotShadowColor-8_81llA(arg1);
        }

        @Deprecated public static float toDp-GaN1DYA(GraphicsLayerScope arg0, long arg1) {
            return arg0.toDp-GaN1DYA(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(GraphicsLayerScope arg0, float arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static float toDp-u2uoSUM(GraphicsLayerScope arg0, int arg1) {
            return arg0.toDp-u2uoSUM(arg1);
        }

        @Deprecated public static long toDpSize-k-rfVVM(GraphicsLayerScope arg0, long arg1) {
            return arg0.toDpSize-k-rfVVM(arg1);
        }

        @Deprecated public static float toPx--R2X_6o(GraphicsLayerScope arg0, long arg1) {
            return arg0.toPx--R2X_6o(arg1);
        }

        @Deprecated public static float toPx-0680j_4(GraphicsLayerScope arg0, float arg1) {
            return arg0.toPx-0680j_4(arg1);
        }

        @Deprecated public static Rect toRect(GraphicsLayerScope arg0, DpRect arg1) {
            return arg0.toRect(arg1);
        }

        @Deprecated public static long toSize-XkaWNTQ(GraphicsLayerScope arg0, long arg1) {
            return arg0.toSize-XkaWNTQ(arg1);
        }

        @Deprecated public static long toSp-0xMU5do(GraphicsLayerScope arg0, float arg1) {
            return arg0.toSp-0xMU5do(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(GraphicsLayerScope arg0, float arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }

        @Deprecated public static long toSp-kPz2Gy4(GraphicsLayerScope arg0, int arg1) {
            return arg0.toSp-kPz2Gy4(arg1);
        }
    }

    static long access$getAmbientShadowColor-0d7_KjU$jd(GraphicsLayerScope arg2) {
        return super.getAmbientShadowColor-0d7_KjU();
    }

    static int access$getBlendMode-0nO6VwU$jd(GraphicsLayerScope arg0) {
        return super.getBlendMode-0nO6VwU();
    }

    static ColorFilter access$getColorFilter$jd(GraphicsLayerScope arg0) {
        return super.getColorFilter();
    }

    static int access$getCompositingStrategy--NrFUSI$jd(GraphicsLayerScope arg0) {
        return super.getCompositingStrategy--NrFUSI();
    }

    static RenderEffect access$getRenderEffect$jd(GraphicsLayerScope arg0) {
        return super.getRenderEffect();
    }

    static long access$getSize-NH-jbRc$jd(GraphicsLayerScope arg2) {
        return super.getSize-NH-jbRc();
    }

    static long access$getSpotShadowColor-0d7_KjU$jd(GraphicsLayerScope arg2) {
        return super.getSpotShadowColor-0d7_KjU();
    }

    static int access$roundToPx--R2X_6o$jd(GraphicsLayerScope arg0, long arg1) {
        return super.roundToPx--R2X_6o(arg1);
    }

    static int access$roundToPx-0680j_4$jd(GraphicsLayerScope arg0, float arg1) {
        return super.roundToPx-0680j_4(arg1);
    }

    static void access$setAmbientShadowColor-8_81llA$jd(GraphicsLayerScope arg0, long arg1) {
        super.setAmbientShadowColor-8_81llA(arg1);
    }

    static void access$setBlendMode-s9anfk8$jd(GraphicsLayerScope arg0, int arg1) {
        super.setBlendMode-s9anfk8(arg1);
    }

    static void access$setColorFilter$jd(GraphicsLayerScope arg0, ColorFilter arg1) {
        super.setColorFilter(arg1);
    }

    static void access$setCompositingStrategy-aDBOjCE$jd(GraphicsLayerScope arg0, int arg1) {
        super.setCompositingStrategy-aDBOjCE(arg1);
    }

    static void access$setRenderEffect$jd(GraphicsLayerScope arg0, RenderEffect arg1) {
        super.setRenderEffect(arg1);
    }

    static void access$setSpotShadowColor-8_81llA$jd(GraphicsLayerScope arg0, long arg1) {
        super.setSpotShadowColor-8_81llA(arg1);
    }

    static float access$toDp-GaN1DYA$jd(GraphicsLayerScope arg0, long arg1) {
        return super.toDp-GaN1DYA(arg1);
    }

    static float access$toDp-u2uoSUM$jd(GraphicsLayerScope arg0, float arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static float access$toDp-u2uoSUM$jd(GraphicsLayerScope arg0, int arg1) {
        return super.toDp-u2uoSUM(arg1);
    }

    static long access$toDpSize-k-rfVVM$jd(GraphicsLayerScope arg0, long arg1) {
        return super.toDpSize-k-rfVVM(arg1);
    }

    static float access$toPx--R2X_6o$jd(GraphicsLayerScope arg0, long arg1) {
        return super.toPx--R2X_6o(arg1);
    }

    static float access$toPx-0680j_4$jd(GraphicsLayerScope arg0, float arg1) {
        return super.toPx-0680j_4(arg1);
    }

    static Rect access$toRect$jd(GraphicsLayerScope arg0, DpRect arg1) {
        return super.toRect(arg1);
    }

    static long access$toSize-XkaWNTQ$jd(GraphicsLayerScope arg0, long arg1) {
        return super.toSize-XkaWNTQ(arg1);
    }

    static long access$toSp-0xMU5do$jd(GraphicsLayerScope arg0, float arg1) {
        return super.toSp-0xMU5do(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(GraphicsLayerScope arg0, float arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    static long access$toSp-kPz2Gy4$jd(GraphicsLayerScope arg0, int arg1) {
        return super.toSp-kPz2Gy4(arg1);
    }

    float getAlpha();

    default long getAmbientShadowColor-0d7_KjU() {
        return GraphicsLayerScopeKt.getDefaultShadowColor();
    }

    default int getBlendMode-0nO6VwU() {
        return BlendMode.Companion.getSrcOver-0nO6VwU();
    }

    float getCameraDistance();

    boolean getClip();

    default ColorFilter getColorFilter() {
        return null;
    }

    default int getCompositingStrategy--NrFUSI() {
        return CompositingStrategy.Companion.getAuto--NrFUSI();
    }

    default RenderEffect getRenderEffect() {
        return null;
    }

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    Shape getShape();

    default long getSize-NH-jbRc() {
        return Size.Companion.getUnspecified-NH-jbRc();
    }

    default long getSpotShadowColor-0d7_KjU() {
        return GraphicsLayerScopeKt.getDefaultShadowColor();
    }

    long getTransformOrigin-SzJe1aQ();

    float getTranslationX();

    float getTranslationY();

    void setAlpha(float arg1);

    default void setAmbientShadowColor-8_81llA(long arg1) {
    }

    default void setBlendMode-s9anfk8(int arg1) {
    }

    void setCameraDistance(float arg1);

    void setClip(boolean arg1);

    default void setColorFilter(ColorFilter arg1) {
    }

    default void setCompositingStrategy-aDBOjCE(int arg1) {
    }

    default void setRenderEffect(RenderEffect arg1) {
    }

    void setRotationX(float arg1);

    void setRotationY(float arg1);

    void setRotationZ(float arg1);

    void setScaleX(float arg1);

    void setScaleY(float arg1);

    void setShadowElevation(float arg1);

    void setShape(Shape arg1);

    default void setSpotShadowColor-8_81llA(long arg1) {
    }

    void setTransformOrigin-__ExYCQ(long arg1);

    void setTranslationX(float arg1);

    void setTranslationY(float arg1);
}

