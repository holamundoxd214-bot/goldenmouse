package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.TextAutoSizeLayoutScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J#\u0010\u0002\u001A\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0001H¦\u0002J\b\u0010\u000E\u001A\u00020\u000FH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2={"Landroidx/compose/foundation/text/TextAutoSize;", "", "getFontSize", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "getFontSize-Ci0_558", "(Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;JLandroidx/compose/ui/text/AnnotatedString;)J", "equals", "", "other", "hashCode", "", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TextAutoSize {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u0007¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/foundation/text/TextAutoSize$Companion;", "", "<init>", "()V", "StepBased", "Landroidx/compose/foundation/text/TextAutoSize;", "minFontSize", "Landroidx/compose/ui/unit/TextUnit;", "maxFontSize", "stepSize", "StepBased-vU-0ePk", "(JJJ)Landroidx/compose/foundation/text/TextAutoSize;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        public final TextAutoSize StepBased-vU-0ePk(long arg9, long arg11, long arg13) {
            return new AutoSizeStepBased(arg9, arg11, arg13, null);
        }

        public static TextAutoSize StepBased-vU-0ePk$default(Companion arg7, long arg8, long arg10, long arg12, int arg14, Object arg15) {
            if((arg14 & 1) != 0) {
                arg8 = TextAutoSizeDefaults.INSTANCE.getMinFontSize-XSAIIZE();
            }

            long v1 = arg8;
            if((arg14 & 2) != 0) {
                arg10 = TextAutoSizeDefaults.INSTANCE.getMaxFontSize-XSAIIZE();
            }

            long v3 = arg10;
            if((arg14 & 4) != 0) {
                arg12 = TextUnitKt.getSp(0.25);
            }

            return arg7.StepBased-vU-0ePk(v1, v3, arg12);
        }
    }

    public static final Companion Companion;

    static {
        TextAutoSize.Companion = Companion.$$INSTANCE;
    }

    boolean equals(Object arg1);

    long getFontSize-Ci0_558(TextAutoSizeLayoutScope arg1, long arg2, AnnotatedString arg3);

    int hashCode();
}

