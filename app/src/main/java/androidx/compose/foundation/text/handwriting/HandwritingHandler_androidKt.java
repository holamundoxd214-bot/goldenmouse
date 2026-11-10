package androidx.compose.foundation.text.handwriting;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2={"handwritingHandler", "Landroidx/compose/ui/Modifier;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class HandwritingHandler_androidKt {
    public static final Modifier handwritingHandler(Modifier arg1) {
        if(StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
            arg1 = arg1.then(new HandwritingHandlerElement());
        }

        return arg1;
    }
}

