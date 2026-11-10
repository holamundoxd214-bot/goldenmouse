package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.StringHelpers_jvmKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0001\u001A\u001C\u0010\u0005\u001A\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\nH\u0000¨\u0006\u000B"}, d2={"mask", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation$Companion;", "character", "", "toVisualText", "", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "codepointTransformation", "offsetMappingCalculator", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CodepointTransformationKt {
    public static final CodepointTransformation mask(Companion arg0, char arg1) {
        return new MaskCodepointTransformation(arg1);
    }

    public static final CharSequence toVisualText(TextFieldCharSequence arg8, CodepointTransformation arg9, OffsetMappingCalculator arg10) {
        StringBuilder v0 = new StringBuilder();
        int v1 = 0;
        int v2 = 0;
        int v3;
        for(v3 = 0; v1 < arg8.length(); ++v3) {
            int v4 = CodepointHelpers_jvmKt.codePointAt(arg8, v1);
            int v5 = arg9.transform(v3, v4);
            int v6 = CodepointHelpers_jvmKt.charCount(v4);
            if(v5 != v4) {
                arg10.recordEditOperation(v0.length(), v0.length() + v6, CodepointHelpers_jvmKt.charCount(v5));
                v2 = 1;
            }

            StringHelpers_jvmKt.appendCodePointX(v0, v5);
            v1 += v6;
        }

        String v9 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v9, "toString(...)");
        if(v2 != 0) {
            return ((CharSequence)v9);
        }

        return arg8;
    }
}

