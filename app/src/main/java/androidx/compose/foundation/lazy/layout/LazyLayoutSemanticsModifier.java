package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u0018\u001A\u00020\u0002H\u0016J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0002H\u0016J\f\u0010\u001C\u001A\u00020\u001A*\u00020\u001DH\u0016J\u0013\u0010\u001E\u001A\u00020\u000B2\b\u0010\u001F\u001A\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001A\u00020\"H\u0016R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0016¨\u0006#"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticsModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticsModifierNode;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "", "reverseScrolling", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZ)V", "getItemProviderLambda", "()Lkotlin/jvm/functions/Function0;", "getState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getUserScrollEnabled", "()Z", "getReverseScrolling", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LazyLayoutSemanticsModifier extends ModifierNodeElement {
    private final Function0 itemProviderLambda;
    private final Orientation orientation;
    private final boolean reverseScrolling;
    private final LazyLayoutSemanticState state;
    private final boolean userScrollEnabled;

    public LazyLayoutSemanticsModifier(Function0 arg1, LazyLayoutSemanticState arg2, Orientation arg3, boolean arg4, boolean arg5) {
        super();
        this.itemProviderLambda = arg1;
        this.state = arg2;
        this.orientation = arg3;
        this.userScrollEnabled = arg4;
        this.reverseScrolling = arg5;
    }

    public LazyLayoutSemanticsModifierNode create() {
        return new LazyLayoutSemanticsModifierNode(this.itemProviderLambda, this.state, this.orientation, this.userScrollEnabled, this.reverseScrolling);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((LazyLayoutSemanticsModifier)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof LazyLayoutSemanticsModifier)) {
            return 0;
        }

        if(this.itemProviderLambda != ((LazyLayoutSemanticsModifier)arg5).itemProviderLambda) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((LazyLayoutSemanticsModifier)arg5).state)) {
            return 0;
        }

        if(this.orientation != ((LazyLayoutSemanticsModifier)arg5).orientation) {
            return 0;
        }

        if(this.userScrollEnabled != ((LazyLayoutSemanticsModifier)arg5).userScrollEnabled) {
            return 0;
        }

        if(this.reverseScrolling != ((LazyLayoutSemanticsModifier)arg5).reverseScrolling) {
            return 0;
        }

        return 1;
    }

    public final Function0 getItemProviderLambda() {
        return this.itemProviderLambda;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    public final LazyLayoutSemanticState getState() {
        return this.state;
    }

    public final boolean getUserScrollEnabled() {
        return this.userScrollEnabled;
    }

    public int hashCode() {
        return (((this.itemProviderLambda.hashCode() * 0x1F + this.state.hashCode()) * 0x1F + this.orientation.hashCode()) * 0x1F + Boolean.hashCode(this.userScrollEnabled)) * 0x1F + Boolean.hashCode(this.reverseScrolling);
    }

    public void inspectableProperties(InspectorInfo arg1) {
    }

    public void update(LazyLayoutSemanticsModifierNode arg7) {
        arg7.update(this.itemProviderLambda, this.state, this.orientation, this.userScrollEnabled, this.reverseScrolling);
    }

    public void update(Node arg1) {
        this.update(((LazyLayoutSemanticsModifierNode)arg1));
    }
}

