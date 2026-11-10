package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0017\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004\"\u0010\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0016\u0010\b\u001A\u00020\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\n¨\u0006\u000B"}, d2={"LocalTextSelectionColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getLocalTextSelectionColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "DefaultSelectionColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultTextSelectionColors", "getDefaultTextSelectionColors$annotations", "()V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextSelectionColorsKt {
    private static final long DefaultSelectionColor;
    private static final TextSelectionColors DefaultTextSelectionColors;
    private static final ProvidableCompositionLocal LocalTextSelectionColors;

    static {
        TextSelectionColorsKt.LocalTextSelectionColors = CompositionLocalKt.compositionLocalOf$default(null, new TextSelectionColorsKt$$ExternalSyntheticLambda0(), 1, null);
        long v2 = ColorKt.Color(0xFF4286F4L);
        TextSelectionColorsKt.DefaultSelectionColor = v2;
        TextSelectionColorsKt.DefaultTextSelectionColors = new TextSelectionColors(v2, Color.copy-wmQWz5c$default(v2, 0.4f, 0f, 0f, 0f, 14, null), null);
    }

    static final TextSelectionColors LocalTextSelectionColors$lambda$0() {
        return TextSelectionColorsKt.DefaultTextSelectionColors;
    }

    private static void getDefaultTextSelectionColors$annotations() {
    }

    public static final ProvidableCompositionLocal getLocalTextSelectionColors() {
        return TextSelectionColorsKt.LocalTextSelectionColors;
    }
}

