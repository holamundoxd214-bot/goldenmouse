package androidx.compose.ui.viewinterop;

import androidx.compose.ui.Modifier$Node;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0002\u0018\u00002\u00020\u0001B5\u0012,\u0010\u0002\u001A(\u0012\u001A\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000F\u001A\u00020\u0005H\u0016J\b\u0010\u0010\u001A\u00020\u0005H\u0016J4\u0010\u0011\u001A\u00020\u00052,\u0010\u0002\u001A(\u0012\u001A\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0007R@\u0010\u0002\u001A(\u0012\u001A\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003j\u0004\u0018\u0001`\u0006\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\tR#\u0010\r\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000B¨\u0006\u0012"}, d2={"Landroidx/compose/ui/viewinterop/BringIntoViewNode;", "Landroidx/compose/ui/Modifier$Node;", "onRequesterReady", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Rect;", "", "Landroidx/compose/ui/viewinterop/BringIntoViewRequester;", "Landroidx/compose/ui/viewinterop/OnRequesterReady;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnRequesterReady", "()Lkotlin/jvm/functions/Function1;", "setOnRequesterReady", "requester", "getRequester", "onAttach", "onDetach", "update", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class BringIntoViewNode extends Node {
    private Function1 onRequesterReady;
    private final Function1 requester;

    public BringIntoViewNode(Function1 arg1) {
        super();
        this.onRequesterReady = arg1;
        this.requester = new BringIntoViewNode$requester$1(this);
    }

    public final Function1 getOnRequesterReady() {
        return this.onRequesterReady;
    }

    public final Function1 getRequester() {
        return this.requester;
    }

    public void onAttach() {
        this.onRequesterReady.invoke(this.requester);
    }

    public void onDetach() {
        this.onRequesterReady.invoke(null);
    }

    public final void setOnRequesterReady(Function1 arg1) {
        this.onRequesterReady = arg1;
    }

    public final void update(Function1 arg2) {
        this.onRequesterReady = arg2;
        if(this.isAttached()) {
            arg2.invoke(this.requester);
        }
    }
}

