package androidx.compose.foundation.content;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007¨\u0006\u0004"}, d2={"contentReceiver", "Landroidx/compose/ui/Modifier;", "receiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ReceiveContentKt {
    public static final Modifier contentReceiver(Modifier arg1, ReceiveContentListener arg2) {
        return arg1.then(new ReceiveContentElement(arg2));
    }
}

