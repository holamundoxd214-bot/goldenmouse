package androidx.compose.material3.tokens;

import androidx.compose.material3.internal.DefaultPlatformTextStyle_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.LineHeightStyle$Alignment;
import androidx.compose.ui.text.style.LineHeightStyle$Trim;
import androidx.compose.ui.text.style.LineHeightStyle;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"DefaultLineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefaultLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "DefaultTextStyle", "Landroidx/compose/ui/text/TextStyle;", "getDefaultTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TypographyTokensKt {
    private static final LineHeightStyle DefaultLineHeightStyle;
    private static final TextStyle DefaultTextStyle;

    static {
        LineHeightStyle v0 = new LineHeightStyle(Alignment.Companion.getCenter-PIaL0Z0(), Trim.Companion.getNone-EVpEnUU(), null);
        TypographyTokensKt.DefaultLineHeightStyle = v0;
        TypographyTokensKt.DefaultTextStyle = TextStyle.copy-p1EtxEg$default(TextStyle.Companion.getDefault(), 0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, DefaultPlatformTextStyle_androidKt.defaultPlatformTextStyle(), v0, 0, 0, null, 0xE7FFFF, null);
    }

    public static final LineHeightStyle getDefaultLineHeightStyle() {
        return TypographyTokensKt.DefaultLineHeightStyle;
    }

    public static final TextStyle getDefaultTextStyle() {
        return TypographyTokensKt.DefaultTextStyle;
    }
}

