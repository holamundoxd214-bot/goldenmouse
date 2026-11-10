package androidx.compose.ui.node;

import androidx.compose.ui.Modifier$Node;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001F\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000*\u0001\u0001\u001A\f\u0010\b\u001A\u00020\t*\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001A\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001A\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"DetachedModifierLocalReadScope", "androidx/compose/ui/node/BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1", "Landroidx/compose/ui/node/BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1;", "onDrawCacheReadsChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/node/BackwardsCompatNode;", "", "updateModifierLocalConsumer", "isChainUpdate", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BackwardsCompatNodeKt {
    private static final BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1 DetachedModifierLocalReadScope;
    private static final Function1 onDrawCacheReadsChanged;
    private static final Function1 updateModifierLocalConsumer;

    static {
        BackwardsCompatNodeKt.DetachedModifierLocalReadScope = new BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1();
        BackwardsCompatNodeKt.onDrawCacheReadsChanged = BackwardsCompatNodeKt$onDrawCacheReadsChanged$1.INSTANCE;
        BackwardsCompatNodeKt.updateModifierLocalConsumer = BackwardsCompatNodeKt$updateModifierLocalConsumer$1.INSTANCE;
    }

    public static final BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1 access$getDetachedModifierLocalReadScope$p() {
        return BackwardsCompatNodeKt.DetachedModifierLocalReadScope;
    }

    public static final Function1 access$getOnDrawCacheReadsChanged$p() {
        return BackwardsCompatNodeKt.onDrawCacheReadsChanged;
    }

    public static final Function1 access$getUpdateModifierLocalConsumer$p() {
        return BackwardsCompatNodeKt.updateModifierLocalConsumer;
    }

    public static final boolean access$isChainUpdate(BackwardsCompatNode arg0) {
        return BackwardsCompatNodeKt.isChainUpdate(arg0);
    }

    private static final boolean isChainUpdate(BackwardsCompatNode arg1) {
        Node v1 = DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg1)).getNodes$ui().getTail$ui();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.node.TailModifierNode");
        return ((TailModifierNode)v1).getAttachHasBeenRun();
    }
}

