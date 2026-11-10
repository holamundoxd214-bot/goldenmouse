package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u001A\u0014\u0010\u0004\u001A\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0000\u001A\u001E\u0010\t\u001A\u00020\n*\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\fH\u0001\u001A \u0010\u000E\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0002\u001A \u0010\u0011\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0002\"\u0014\u0010\u0000\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003¨\u0006\u0014"}, d2={"ValidatingEmptyOffsetMappingIdentity", "Landroidx/compose/ui/text/input/OffsetMapping;", "getValidatingEmptyOffsetMappingIdentity", "()Landroidx/compose/ui/text/input/OffsetMapping;", "filterWithValidation", "Landroidx/compose/ui/text/input/TransformedText;", "Landroidx/compose/ui/text/input/VisualTransformation;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "throwIfNotValidTransform", "", "originalLength", "", "limit", "validateTransformedToOriginal", "originalOffset", "offset", "validateOriginalToTransformed", "transformedOffset", "transformedLength", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ValidatingOffsetMappingKt {
    private static final OffsetMapping ValidatingEmptyOffsetMappingIdentity;

    static {
        ValidatingOffsetMappingKt.ValidatingEmptyOffsetMappingIdentity = new ValidatingOffsetMapping(OffsetMapping.Companion.getIdentity(), 0, 0);
    }

    public static final void access$validateOriginalToTransformed(int arg0, int arg1, int arg2) {
        ValidatingOffsetMappingKt.validateOriginalToTransformed(arg0, arg1, arg2);
    }

    public static final void access$validateTransformedToOriginal(int arg0, int arg1, int arg2) {
        ValidatingOffsetMappingKt.validateTransformedToOriginal(arg0, arg1, arg2);
    }

    public static final TransformedText filterWithValidation(VisualTransformation arg4, AnnotatedString arg5) {
        TransformedText v4 = arg4.filter(arg5);
        ValidatingOffsetMappingKt.throwIfNotValidTransform$default(v4, arg5.length(), 0, 2, null);
        return new TransformedText(v4.getText(), new ValidatingOffsetMapping(v4.getOffsetMapping(), arg5.length(), v4.getText().length()));
    }

    public static final OffsetMapping getValidatingEmptyOffsetMappingIdentity() {
        return ValidatingOffsetMappingKt.ValidatingEmptyOffsetMappingIdentity;
    }

    public static final void throwIfNotValidTransform(TransformedText arg5, int arg6, int arg7) {
        int v0 = arg5.getText().length();
        int v1 = Math.min(arg6, arg7);
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            ValidatingOffsetMappingKt.validateOriginalToTransformed(arg5.getOffsetMapping().originalToTransformed(v3), v0, v3);
        }

        ValidatingOffsetMappingKt.validateOriginalToTransformed(arg5.getOffsetMapping().originalToTransformed(arg6), v0, arg6);
        arg7 = Math.min(v0, arg7);
        while(v2 < arg7) {
            ValidatingOffsetMappingKt.validateTransformedToOriginal(arg5.getOffsetMapping().transformedToOriginal(v2), arg6, v2);
            ++v2;
        }

        ValidatingOffsetMappingKt.validateTransformedToOriginal(arg5.getOffsetMapping().transformedToOriginal(v0), arg6, v0);
    }

    public static void throwIfNotValidTransform$default(TransformedText arg0, int arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = 100;
        }

        ValidatingOffsetMappingKt.throwIfNotValidTransform(arg0, arg1, arg2);
    }

    private static final void validateOriginalToTransformed(int arg2, int arg3, int arg4) {
        int v0 = 0;
        if(arg2 >= 0 && arg2 <= arg3) {
            v0 = 1;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("OffsetMapping.originalToTransformed returned invalid mapping: " + arg4 + " -> " + arg2 + " is not in range of transformed text [0, " + arg3 + ']');
        }
    }

    private static final void validateTransformedToOriginal(int arg2, int arg3, int arg4) {
        int v0 = 0;
        if(arg2 >= 0 && arg2 <= arg3) {
            v0 = 1;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("OffsetMapping.transformedToOriginal returned invalid mapping: " + arg4 + " -> " + arg2 + " is not in range of original text [0, " + arg3 + ']');
        }
    }
}

