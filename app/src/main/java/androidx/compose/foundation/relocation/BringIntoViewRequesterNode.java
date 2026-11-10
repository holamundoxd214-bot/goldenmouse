package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier$Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001A\u00020\u000BH\u0016J\u000E\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0002\u001A\u00020\u0003J\b\u0010\r\u001A\u00020\u000BH\u0002J\b\u0010\u000E\u001A\u00020\u000BH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/relocation/BringIntoViewRequesterNode;", "Landroidx/compose/ui/Modifier$Node;", "requester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "<init>", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "onAttach", "", "updateRequester", "disposeRequester", "onDetach", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BringIntoViewRequesterNode extends Node {
    public static final int $stable = 8;
    private BringIntoViewRequester requester;
    private final boolean shouldAutoInvalidate;

    static {
    }

    public BringIntoViewRequesterNode(BringIntoViewRequester arg1) {
        super();
        this.requester = arg1;
    }

    private final void disposeRequester() {
        BringIntoViewRequester v0 = this.requester;
        if((v0 instanceof BringIntoViewRequesterImpl)) {
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.foundation.relocation.BringIntoViewRequesterImpl");
            ((BringIntoViewRequesterImpl)v0).getNodes().remove(this);
        }
    }

    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public void onAttach() {
        this.updateRequester(this.requester);
    }

    public void onDetach() {
        this.disposeRequester();
    }

    public final void updateRequester(BringIntoViewRequester arg2) {
        this.disposeRequester();
        if((arg2 instanceof BringIntoViewRequesterImpl)) {
            arg2.getNodes().add(this);
        }

        this.requester = arg2;
    }
}

