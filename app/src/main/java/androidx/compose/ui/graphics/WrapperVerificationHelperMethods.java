package androidx.compose.ui.graphics;

import android.graphics.Paint;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001A\u00020\u00052\n\u0010\u0006\u001A\u00060\u0007j\u0002`\b2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Landroidx/compose/ui/graphics/WrapperVerificationHelperMethods;", "", "<init>", "()V", "setBlendMode", "", "paint", "Landroid/graphics/Paint;", "Landroidx/compose/ui/graphics/NativePaint;", "mode", "Landroidx/compose/ui/graphics/BlendMode;", "setBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WrapperVerificationHelperMethods {
    public static final int $stable;
    public static final WrapperVerificationHelperMethods INSTANCE;

    static {
        WrapperVerificationHelperMethods.INSTANCE = new WrapperVerificationHelperMethods();
    }

    private WrapperVerificationHelperMethods() {
        super();
    }

    public final void setBlendMode-GB0RdKg(Paint arg1, int arg2) {
        arg1.setBlendMode(AndroidBlendMode_androidKt.toAndroidBlendMode-s9anfk8(arg2));
    }
}

