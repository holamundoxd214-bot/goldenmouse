package androidx.compose.foundation.text;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A4\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u000E\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0000\u001A\u000F\u0010\u000B\u001A\u0004\u0018\u00010\fH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000E"}, d2={"textFieldScroll", "Landroidx/compose/ui/Modifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "rememberTextFieldOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldScroll_androidKt {
    public static final OverscrollEffect rememberTextFieldOverscrollEffect(Composer arg3, int arg4) {
        int v1 = -73012098;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberTextFieldOverscrollEffect):TextFieldScroll.android.kt#423gt5");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.foundation.text.rememberTextFieldOverscrollEffect (TextFieldScroll.android.kt:37)");
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return null;
    }

    public static final Modifier textFieldScroll(Modifier arg0, TextFieldScrollerPosition arg1, TextFieldValue arg2, VisualTransformation arg3, Function0 arg4) {
        return TextFieldScrollKt.defaultTextFieldScroll(arg0, arg1, arg2, arg3, arg4);
    }
}

