package androidx.compose.foundation.gestures;

import android.view.ViewConfiguration;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2={"platformScrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidScrollable_androidKt {
    public static final ScrollConfig platformScrollConfig(CompositionLocalConsumerModifierNode arg1) {
        return new AndroidConfig(ViewConfiguration.get(DelegatableNode_androidKt.requireView(((DelegatableNode)arg1)).getContext()));
    }
}

