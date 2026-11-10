package androidx.compose.foundation.text;

import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/foundation/text/TextAutoSizeDefaults;", "", "<init>", "()V", "MinFontSize", "Landroidx/compose/ui/unit/TextUnit;", "getMinFontSize-XSAIIZE", "()J", "J", "MaxFontSize", "getMaxFontSize-XSAIIZE", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextAutoSizeDefaults {
    public static final int $stable;
    public static final TextAutoSizeDefaults INSTANCE;
    private static final long MaxFontSize;
    private static final long MinFontSize;

    static {
        TextAutoSizeDefaults.INSTANCE = new TextAutoSizeDefaults();
        TextAutoSizeDefaults.MinFontSize = TextUnitKt.getSp(12);
        TextAutoSizeDefaults.MaxFontSize = TextUnitKt.getSp(0x70);
    }

    private TextAutoSizeDefaults() {
        super();
    }

    public final long getMaxFontSize-XSAIIZE() {
        return TextAutoSizeDefaults.MaxFontSize;
    }

    public final long getMinFontSize-XSAIIZE() {
        return TextAutoSizeDefaults.MinFontSize;
    }
}

