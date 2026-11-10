package androidx.compose.foundation.text.input;

import androidx.compose.ui.text.intl.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0007\u001AD\u0010\u0003\u001A\u00020\u0001*\u00020\u000126\u0010\u0004\u001A2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00060\u0005H\u0007\u001A\u0014\u0010\u000B\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001A\u00020\rH\u0007\u001A\u0014\u0010\u000E\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u000FH\u0007¨\u0006\u0010"}, d2={"then", "Landroidx/compose/foundation/text/input/InputTransformation;", "next", "byValue", "transformation", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "current", "proposed", "allCaps", "locale", "Landroidx/compose/ui/text/intl/Locale;", "maxLength", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InputTransformationKt {
    public static final InputTransformation allCaps(InputTransformation arg1, Locale arg2) {
        return InputTransformationKt.then(arg1, new AllCapsTransformation(arg2));
    }

    public static final InputTransformation byValue(InputTransformation arg1, Function2 arg2) {
        return InputTransformationKt.then(arg1, new InputTransformationByValue(arg2));
    }

    public static final InputTransformation maxLength(InputTransformation arg1, int arg2) {
        return InputTransformationKt.then(arg1, new MaxLengthFilter(arg2));
    }

    public static final InputTransformation then(InputTransformation arg1, InputTransformation arg2) {
        return new FilterChain(arg1, arg2);
    }
}

