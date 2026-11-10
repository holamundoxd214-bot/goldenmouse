package androidx.compose.ui.graphics;

import android.graphics.BlendModeColorFilter;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u000E\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0005¨\u0006\u000F"}, d2={"Landroidx/compose/ui/graphics/BlendModeColorFilterHelper;", "", "<init>", "()V", "BlendModeColorFilter", "Landroid/graphics/BlendModeColorFilter;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "BlendModeColorFilter-xETnrds", "(JI)Landroid/graphics/BlendModeColorFilter;", "createBlendModeColorFilter", "Landroidx/compose/ui/graphics/BlendModeColorFilter;", "androidBlendModeColorFilter", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) final class BlendModeColorFilterHelper {
    public static final BlendModeColorFilterHelper INSTANCE;

    static {
        BlendModeColorFilterHelper.INSTANCE = new BlendModeColorFilterHelper();
    }

    private BlendModeColorFilterHelper() {
        super();
    }

    public final BlendModeColorFilter BlendModeColorFilter-xETnrds(long arg1, int arg3) {
        return new BlendModeColorFilter(ColorKt.toArgb-8_81llA(arg1), AndroidBlendMode_androidKt.toAndroidBlendMode-s9anfk8(arg3));
    }

    public final androidx.compose.ui.graphics.BlendModeColorFilter createBlendModeColorFilter(BlendModeColorFilter arg7) {
        return new androidx.compose.ui.graphics.BlendModeColorFilter(ColorKt.Color(arg7.getColor()), AndroidBlendMode_androidKt.toComposeBlendMode(arg7.getMode()), arg7, null);
    }
}

