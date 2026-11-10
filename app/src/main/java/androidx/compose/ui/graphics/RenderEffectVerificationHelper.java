package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import kotlin.Metadata;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u000F\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2={"Landroidx/compose/ui/graphics/RenderEffectVerificationHelper;", "", "<init>", "()V", "createBlurEffect", "Landroid/graphics/RenderEffect;", "inputRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "createBlurEffect-8A-3gB4", "(Landroidx/compose/ui/graphics/RenderEffect;FFI)Landroid/graphics/RenderEffect;", "createOffsetEffect", "offset", "Landroidx/compose/ui/geometry/Offset;", "createOffsetEffect-Uv8p0NA", "(Landroidx/compose/ui/graphics/RenderEffect;J)Landroid/graphics/RenderEffect;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) final class RenderEffectVerificationHelper {
    public static final RenderEffectVerificationHelper INSTANCE;

    static {
        RenderEffectVerificationHelper.INSTANCE = new RenderEffectVerificationHelper();
    }

    private RenderEffectVerificationHelper() {
        super();
    }

    public final RenderEffect createBlurEffect-8A-3gB4(androidx.compose.ui.graphics.RenderEffect arg2, float arg3, float arg4, int arg5) {
        if(arg3 == 0f && arg4 == 0f) {
            return RenderEffect.createOffsetEffect(0f, 0f);
        }

        if(arg2 == null) {
            return RenderEffect.createBlurEffect(arg3, arg4, AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(arg5));
        }

        return RenderEffect.createBlurEffect(arg3, arg4, arg2.asAndroidRenderEffect(), AndroidTileMode_androidKt.toAndroidTileMode-0vamqd0(arg5));
    }

    public final RenderEffect createOffsetEffect-Uv8p0NA(androidx.compose.ui.graphics.RenderEffect arg5, long arg6) {
        long v0 = 0xFFFFFFFFL;
        int v4 = 0x20;
        if(arg5 == null) {
            return RenderEffect.createOffsetEffect(Float.intBitsToFloat(((int)(arg6 >> v4))), Float.intBitsToFloat(((int)(arg6 & v0))));
        }

        return RenderEffect.createOffsetEffect(Float.intBitsToFloat(((int)(arg6 >> v4))), Float.intBitsToFloat(((int)(arg6 & v0))), arg5.asAndroidRenderEffect());
    }
}

