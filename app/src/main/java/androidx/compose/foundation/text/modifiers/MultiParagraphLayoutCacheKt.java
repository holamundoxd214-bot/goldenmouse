package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0082\u0002¢\u0006\u0004\b\u0003\u0010\u0004\"\u0010\u0010\u0005\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2={"times", "Landroidx/compose/ui/unit/TextUnit;", "other", "times-NB67dxo", "(JJ)J", "DefaultFontSize", "J", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MultiParagraphLayoutCacheKt {
    private static final long DefaultFontSize;

    static {
        MultiParagraphLayoutCacheKt.DefaultFontSize = TextUnitKt.getSp(14);
    }

    public static final long access$times-NB67dxo(long arg0, long arg2) {
        return MultiParagraphLayoutCacheKt.times-NB67dxo(arg0, arg2);
    }

    private static final long times-NB67dxo(long arg4, long arg6) {
        float v6;
        if(TextUnit.isEm-impl(arg6)) {
            if(!TextUnit.isEm-impl(arg4)) {
                if(TextUnit.getRawType-impl(arg4) == 0) {
                    arg4 = MultiParagraphLayoutCacheKt.DefaultFontSize;
                    v6 = TextUnit.getValue-impl(arg6);
                    TextUnitKt.checkArithmetic--R2X_6o(arg4);
                    return TextUnitKt.pack(TextUnit.getRawType-impl(arg4), TextUnit.getValue-impl(arg4) * v6);
                }

                v6 = TextUnit.getValue-impl(arg6);
                TextUnitKt.checkArithmetic--R2X_6o(arg4);
                return TextUnitKt.pack(TextUnit.getRawType-impl(arg4), TextUnit.getValue-impl(arg4) * v6);
            }

            throw new IllegalStateException("Cannot convert Em to Px when style.fontSize is Em (" + TextUnit.toString-impl(arg6) + "). Please declare the style.fontSize with Sp units instead.");
        }

        throw new IllegalArgumentException("The multiplier must be in em, but was " + TextUnit.toString-impl(arg6) + '.');
    }
}

