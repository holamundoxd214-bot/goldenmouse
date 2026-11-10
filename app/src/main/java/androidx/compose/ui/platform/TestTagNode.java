package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\n\u001A\u00020\u000B*\u00020\fH\u0016R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\r"}, d2={"Landroidx/compose/ui/platform/TestTagNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "tag", "", "<init>", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "setTag", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class TestTagNode extends Node implements SemanticsModifierNode {
    private String tag;

    public TestTagNode(String arg1) {
        super();
        this.tag = arg1;
    }

    public void applySemantics(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setTestTag(arg1, this.tag);
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(String arg1) {
        this.tag = arg1;
    }
}

