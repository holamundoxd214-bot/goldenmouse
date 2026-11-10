package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.OnLayoutRectChangedModifierKt;
import androidx.compose.ui.node.DelegatableNode$RegistrationHandle;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.spatial.RelativeLayoutBounds;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000E\u0010\t\u001A\u00020\bH\u0086@¢\u0006\u0002\u0010\nJ\f\u0010\u000B\u001A\u00060\u0002R\u00020\u0000H\u0016J\u0014\u0010\f\u001A\u00020\b2\n\u0010\r\u001A\u00060\u0002R\u00020\u0000H\u0016J\f\u0010\u000E\u001A\u00020\b*\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096\u0002R\u0014\u0010\u0005\u001A\b\u0018\u00010\u0002R\u00020\u0000X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier$Node;", "<init>", "()V", "attachedNode", "lock", "Lkotlinx/coroutines/CompletableDeferred;", "", "waitForFirstLayout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "hashCode", "", "equals", "", "other", "", "Node", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AwaitFirstLayoutModifier extends ModifierNodeElement {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016J\u0006\u0010\b\u001A\u00020\u0005J\b\u0010\t\u001A\u00020\u0005H\u0016R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier$Node;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "(Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;)V", "onAttach", "", "handle", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "requestOnAfterLayoutCallback", "onDetach", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Node extends androidx.compose.ui.Modifier$Node {
        private RegistrationHandle handle;

        public Node(AwaitFirstLayoutModifier arg1) {
            AwaitFirstLayoutModifier.this = arg1;
            super();
        }

        public void onAttach() {
            AwaitFirstLayoutModifier.this.attachedNode = this;
            if(AwaitFirstLayoutModifier.this.lock != null) {
                this.requestOnAfterLayoutCallback();
            }
        }

        public void onDetach() {
            Node v1 = null;
            if(AwaitFirstLayoutModifier.this.attachedNode == this) {
                AwaitFirstLayoutModifier.this.attachedNode = v1;
            }

            RegistrationHandle v0 = this.handle;
            if(v0 != null) {
                v0.unregister();
            }

            this.handle = ((RegistrationHandle)v1);
        }

        public final void requestOnAfterLayoutCallback() {
            this.handle = OnLayoutRectChangedModifierKt.registerOnLayoutRectChanged(this, 0, 0, new AwaitFirstLayoutModifier$Node$$ExternalSyntheticLambda0(this, AwaitFirstLayoutModifier.this));
        }

        static final Unit requestOnAfterLayoutCallback$lambda$0(Node arg1, AwaitFirstLayoutModifier arg2, RelativeLayoutBounds arg3) {
            RegistrationHandle v3 = arg1.handle;
            if(v3 != null) {
                v3.unregister();
            }

            v3 = null;
            arg1.handle = v3;
            CompletableDeferred v1 = arg2.lock;
            if(v1 != null) {
                v1.complete(Unit.INSTANCE);
            }

            arg2.lock = ((CompletableDeferred)v3);
            return Unit.INSTANCE;
        }
    }

    public static final int $stable;
    private Node attachedNode;
    private CompletableDeferred lock;

    static {
    }

    public AwaitFirstLayoutModifier() {
        super();
    }

    public static final Node access$getAttachedNode$p(AwaitFirstLayoutModifier arg0) {
        return arg0.attachedNode;
    }

    public static final CompletableDeferred access$getLock$p(AwaitFirstLayoutModifier arg0) {
        return arg0.lock;
    }

    public static final void access$setAttachedNode$p(AwaitFirstLayoutModifier arg0, Node arg1) {
        arg0.attachedNode = arg1;
    }

    public static final void access$setLock$p(AwaitFirstLayoutModifier arg0, CompletableDeferred arg1) {
        arg0.lock = arg1;
    }

    public Node create() {
        return new Node(this);
    }

    public androidx.compose.ui.Modifier$Node create() {
        return this.create();
    }

    public boolean equals(Object arg1) {
        if((((AwaitFirstLayoutModifier)arg1)) == this) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return 0xEA;
    }

    public void inspectableProperties(InspectorInfo arg1) {
        arg1.setName("AwaitFirstLayoutModifier");
    }

    public void update(Node arg1) {
    }

    public void update(androidx.compose.ui.Modifier$Node arg1) {
        this.update(((Node)arg1));
    }

    public final Object waitForFirstLayout(Continuation arg3) {
        CompletableDeferred v0 = this.lock;
        if(v0 == null) {
            v0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            this.lock = v0;
            Node v2 = this.attachedNode;
            if(v2 != null && (v2.isAttached())) {
                v2.requestOnAfterLayoutCallback();
            }
        }

        Object v2_1 = v0.await(arg3);
        if(v2_1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2_1;
        }

        return Unit.INSTANCE;
    }
}

