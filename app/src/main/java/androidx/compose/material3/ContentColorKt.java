package androidx.compose.material3;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"LocalContentColor", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/graphics/Color;", "getLocalContentColor", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ContentColorKt {
    private static final ProvidableCompositionLocal LocalContentColor;

    static {
        ContentColorKt.LocalContentColor = CompositionLocalKt.compositionLocalOf$default(null, ContentColorKt$LocalContentColor$1.INSTANCE, 1, null);
    }

    public static final ProvidableCompositionLocal getLocalContentColor() {
        return ContentColorKt.LocalContentColor;
    }
}

