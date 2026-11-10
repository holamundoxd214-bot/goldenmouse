package androidx.compose.foundation.content.internal;

import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.ReceiveContentNode;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001A\u0004\u0018\u00010\tH\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001A\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Landroidx/compose/foundation/content/internal/DynamicReceiveContentConfiguration;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "receiveContentNode", "Landroidx/compose/foundation/content/ReceiveContentNode;", "<init>", "(Landroidx/compose/foundation/content/ReceiveContentNode;)V", "getReceiveContentNode", "()Landroidx/compose/foundation/content/ReceiveContentNode;", "getParentReceiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "receiveContentListener", "getReceiveContentListener", "()Landroidx/compose/foundation/content/ReceiveContentListener;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DynamicReceiveContentConfiguration extends ReceiveContentConfiguration {
    public static final int $stable = 8;
    private final ReceiveContentListener receiveContentListener;
    private final ReceiveContentNode receiveContentNode;

    static {
    }

    public DynamicReceiveContentConfiguration(ReceiveContentNode arg1) {
        super();
        this.receiveContentNode = arg1;
        this.receiveContentListener = new DynamicReceiveContentConfiguration$receiveContentListener$1(this);
    }

    public static final ReceiveContentListener access$getParentReceiveContentListener(DynamicReceiveContentConfiguration arg0) {
        return arg0.getParentReceiveContentListener();
    }

    private final ReceiveContentListener getParentReceiveContentListener() {
        ReceiveContentConfiguration v0 = ReceiveContentConfigurationKt.getReceiveContentConfiguration(this.receiveContentNode);
        if(v0 != null) {
            return v0.getReceiveContentListener();
        }

        return null;
    }

    public ReceiveContentListener getReceiveContentListener() {
        return this.receiveContentListener;
    }

    public final ReceiveContentNode getReceiveContentNode() {
        return this.receiveContentNode;
    }
}

