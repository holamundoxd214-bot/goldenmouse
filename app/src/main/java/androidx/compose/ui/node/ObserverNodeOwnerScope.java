package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0001\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\n¨\u0006\f"}, d2={"Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "Landroidx/compose/ui/node/OwnerScope;", "observerNode", "Landroidx/compose/ui/node/ObserverModifierNode;", "<init>", "(Landroidx/compose/ui/node/ObserverModifierNode;)V", "getObserverNode$ui", "()Landroidx/compose/ui/node/ObserverModifierNode;", "isValidOwnerScope", "", "()Z", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ObserverNodeOwnerScope implements OwnerScope {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2={"Landroidx/compose/ui/node/ObserverNodeOwnerScope$Companion;", "", "<init>", "()V", "OnObserveReadsChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "", "getOnObserveReadsChanged$ui", "()Lkotlin/jvm/functions/Function1;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Function1 getOnObserveReadsChanged$ui() {
            return ObserverNodeOwnerScope.OnObserveReadsChanged;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Function1 OnObserveReadsChanged;
    private final ObserverModifierNode observerNode;

    static {
        ObserverNodeOwnerScope.Companion = new Companion(null);
        ObserverNodeOwnerScope.$stable = 8;
        ObserverNodeOwnerScope.OnObserveReadsChanged = ObserverNodeOwnerScope$Companion$OnObserveReadsChanged$1.INSTANCE;
    }

    public ObserverNodeOwnerScope(ObserverModifierNode arg1) {
        super();
        this.observerNode = arg1;
    }

    public static final Function1 access$getOnObserveReadsChanged$cp() {
        return ObserverNodeOwnerScope.OnObserveReadsChanged;
    }

    public final ObserverModifierNode getObserverNode$ui() {
        return this.observerNode;
    }

    public boolean isValidOwnerScope() {
        return this.observerNode.getNode().isAttached();
    }
}

