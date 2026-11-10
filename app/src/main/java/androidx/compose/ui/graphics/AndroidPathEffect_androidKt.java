package androidx.compose.ui.graphics;

import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.PathDashPathEffect$Style;
import android.graphics.PathDashPathEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0003\u001A\u00020\u0002*\u00020\u0001\u001A\u0010\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0006H\u0000\u001A\u0018\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0006H\u0000\u001A\u0018\u0010\u000B\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\u0002H\u0000\u001A/\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001A\u0013\u0010\u0016\u001A\u00020\u0017*\u00020\u0013H\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2={"asAndroidPathEffect", "Landroid/graphics/PathEffect;", "Landroidx/compose/ui/graphics/PathEffect;", "toComposePathEffect", "actualCornerPathEffect", "radius", "", "actualDashPathEffect", "intervals", "", "phase", "actualChainPathEffect", "outer", "inner", "actualStampedPathEffect", "shape", "Landroidx/compose/ui/graphics/Path;", "advance", "style", "Landroidx/compose/ui/graphics/StampedPathEffectStyle;", "actualStampedPathEffect-7aD1DOk", "(Landroidx/compose/ui/graphics/Path;FFI)Landroidx/compose/ui/graphics/PathEffect;", "toAndroidPathDashPathEffectStyle", "Landroid/graphics/PathDashPathEffect$Style;", "toAndroidPathDashPathEffectStyle-oQv6xUo", "(I)Landroid/graphics/PathDashPathEffect$Style;", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidPathEffect_androidKt {
    public static final PathEffect actualChainPathEffect(PathEffect arg3, PathEffect arg4) {
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidPathEffect");
        android.graphics.PathEffect v3 = ((AndroidPathEffect)arg3).getNativePathEffect();
        Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidPathEffect");
        return new AndroidPathEffect(new ComposePathEffect(v3, ((AndroidPathEffect)arg4).getNativePathEffect()));
    }

    public static final PathEffect actualCornerPathEffect(float arg2) {
        return new AndroidPathEffect(new CornerPathEffect(arg2));
    }

    public static final PathEffect actualDashPathEffect(float[] arg2, float arg3) {
        return new AndroidPathEffect(new DashPathEffect(arg2, arg3));
    }

    public static final PathEffect actualStampedPathEffect-7aD1DOk(Path arg3, float arg4, float arg5, int arg6) {
        if((arg3 instanceof AndroidPath)) {
            return new AndroidPathEffect(new PathDashPathEffect(((AndroidPath)arg3).getInternalPath(), arg4, arg5, AndroidPathEffect_androidKt.toAndroidPathDashPathEffectStyle-oQv6xUo(arg6)));
        }

        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public static final android.graphics.PathEffect asAndroidPathEffect(PathEffect arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidPathEffect");
        return ((AndroidPathEffect)arg1).getNativePathEffect();
    }

    public static final PathDashPathEffect$Style toAndroidPathDashPathEffectStyle-oQv6xUo(int arg1) {
        if(StampedPathEffectStyle.equals-impl0(arg1, StampedPathEffectStyle.Companion.getMorph-Ypspkwk())) {
            return PathDashPathEffect$Style.MORPH;
        }

        if(StampedPathEffectStyle.equals-impl0(arg1, StampedPathEffectStyle.Companion.getRotate-Ypspkwk())) {
            return PathDashPathEffect$Style.ROTATE;
        }

        if(StampedPathEffectStyle.equals-impl0(arg1, StampedPathEffectStyle.Companion.getTranslate-Ypspkwk())) {
            return PathDashPathEffect$Style.TRANSLATE;
        }

        return PathDashPathEffect$Style.TRANSLATE;
    }

    public static final PathEffect toComposePathEffect(android.graphics.PathEffect arg1) {
        return new AndroidPathEffect(arg1);
    }
}

