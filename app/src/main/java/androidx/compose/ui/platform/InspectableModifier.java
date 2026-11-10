package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier$Element;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Deprecated(level=DeprecationLevel.WARNING, message="This API will create more invalidations of your modifier than necessary, so it\'s use is discouraged. Implementing the inspectableProperties method on ModifierNodeElement is the recommended zero-cost alternative to exposing properties on a Modifier to tooling.") @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000EB \u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tR\u0015\u0010\n\u001A\u00060\u000BR\u00020\u0000¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u000F"}, d2={"Landroidx/compose/ui/platform/InspectableModifier;", "Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "end", "Landroidx/compose/ui/platform/InspectableModifier$End;", "getEnd", "()Landroidx/compose/ui/platform/InspectableModifier$End;", "End", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InspectableModifier extends InspectorValueInfo implements Element {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/ui/platform/InspectableModifier$End;", "Landroidx/compose/ui/Modifier$Element;", "<init>", "(Landroidx/compose/ui/platform/InspectableModifier;)V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class End implements Element {
        public End(InspectableModifier arg1) {
            InspectableModifier.this = arg1;
            super();
        }
    }

    public static final int $stable;
    private final End end;

    static {
    }

    public InspectableModifier(Function1 arg1) {
        super(arg1);
        this.end = new End(this);
    }

    public final End getEnd() {
        return this.end;
    }
}

