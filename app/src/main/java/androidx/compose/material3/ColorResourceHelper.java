package androidx.compose.material3;

import android.content.Context;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0001\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/material3/ColorResourceHelper;", "", "<init>", "()V", "getColor", "Landroidx/compose/ui/graphics/Color;", "context", "Landroid/content/Context;", "id", "", "getColor-WaAFU9c", "(Landroid/content/Context;I)J", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ColorResourceHelper {
    public static final ColorResourceHelper INSTANCE;

    static {
        ColorResourceHelper.INSTANCE = new ColorResourceHelper();
    }

    private ColorResourceHelper() {
        super();
    }

    public final long getColor-WaAFU9c(Context arg1, int arg2) {
        return ColorKt.Color(arg1.getResources().getColor(arg2, arg1.getTheme()));
    }
}

