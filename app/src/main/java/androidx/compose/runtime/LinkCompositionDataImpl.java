package androidx.compose.runtime;

import androidx.compose.runtime.composer.linkbuffer.SlotTable;
import androidx.compose.runtime.composer.linkbuffer.SlotTableKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.runtime.tooling.CompositionInstance;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0015\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0016\u001A\u00020\u0017H\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016J\u0013\u0010\u001A\u001A\u00020\u00132\b\u0010\u001B\u001A\u0004\u0018\u00010\u0017H\u0096\u0002J\n\u0010\"\u001A\u0004\u0018\u00010\u000FH\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001A\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0014R\u0016\u0010\u001C\u001A\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b \u0010!R\u001A\u0010\t\u001A\u0004\u0018\u00010#*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010$R\u001A\u0010%\u001A\u0004\u0018\u00010&*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010(R\u001A\u0010\u001C\u001A\u0004\u0018\u00010\u0004*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010)¨\u0006*"}, d2={"Landroidx/compose/runtime/LinkCompositionDataImpl;", "Landroidx/compose/runtime/tooling/CompositionData;", "Landroidx/compose/runtime/tooling/CompositionInstance;", "composition", "Landroidx/compose/runtime/Composition;", "<init>", "(Landroidx/compose/runtime/Composition;)V", "getComposition", "()Landroidx/compose/runtime/Composition;", "slotTable", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "getSlotTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "compositionGroups", "", "Landroidx/compose/runtime/tooling/CompositionGroup;", "getCompositionGroups", "()Ljava/lang/Iterable;", "isEmpty", "", "()Z", "find", "identityToFind", "", "hashCode", "", "equals", "other", "parent", "getParent", "()Landroidx/compose/runtime/tooling/CompositionInstance;", "data", "getData", "()Landroidx/compose/runtime/tooling/CompositionData;", "findContextGroup", "Landroidx/compose/runtime/SlotStorage;", "(Landroidx/compose/runtime/Composition;)Landroidx/compose/runtime/SlotStorage;", "context", "Landroidx/compose/runtime/CompositionContext;", "getContext", "(Landroidx/compose/runtime/Composition;)Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/Composition;)Landroidx/compose/runtime/Composition;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LinkCompositionDataImpl implements CompositionData, CompositionInstance {
    public static final int $stable = 8;
    private final Composition composition;

    static {
    }

    public LinkCompositionDataImpl(Composition arg1) {
        super();
        this.composition = arg1;
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof LinkCompositionDataImpl)) && (Intrinsics.areEqual(this.composition, ((LinkCompositionDataImpl)arg2).composition))) {
            return 1;
        }

        return 0;
    }

    public CompositionGroup find(Object arg1) {
        return this.getSlotTable().find(arg1);
    }

    public CompositionGroup findContextGroup() {
        Composition v0 = this.getParent(this.composition);
        CompositionGroup v1 = null;
        if(v0 != null) {
            SlotStorage v0_1 = this.getSlotTable(v0);
            if(v0_1 != null) {
                SlotTable v0_2 = SlotTableKt.asLinkBufferSlotTable(v0_1);
                if(v0_2 == null) {
                }
                else {
                    CompositionContext v3 = this.getContext(this.composition);
                    if(v3 == null) {
                        return v1;
                    }
                    else {
                        Integer v3_1 = LinkComposerKt.findSubcompositionContextGroup(v0_2, v3);
                        if(v3_1 != null) {
                            return SlotTableKt.compositionGroupOf(v0_2, ((Number)v3_1).intValue());
                        }
                    }
                }
            }
        }

        return v1;
    }

    public final Composition getComposition() {
        return this.composition;
    }

    public Iterable getCompositionGroups() {
        return this.getSlotTable().getCompositionGroups();
    }

    private final CompositionContext getContext(Composition arg2) {
        CompositionContext v0 = null;
        if((arg2 instanceof CompositionImpl)) {
        }
        else {
            arg2 = ((Composition)v0);
        }

        if(arg2 != null) {
            return ((CompositionImpl)arg2).getParent();
        }

        return v0;
    }

    public CompositionData getData() {
        return this;
    }

    private final Composition getParent(Composition arg1) {
        CompositionContext v0 = this.getContext(arg1);
        if(v0 != null) {
            return v0.getComposition$runtime();
        }

        return null;
    }

    public CompositionInstance getParent() {
        LinkCompositionDataImpl v0;
        Composition v1 = this.getParent(this.composition);
        if(v1 != null) {
            v0 = new LinkCompositionDataImpl(v1);
        }
        else {
            CompositionInstance v0_1 = null;
        }

        return ((CompositionInstance)v0);
    }

    private final SlotStorage getSlotTable(Composition arg2) {
        SlotStorage v0 = null;
        if((arg2 instanceof CompositionImpl)) {
        }
        else {
            arg2 = ((Composition)v0);
        }

        if(arg2 != null) {
            return ((CompositionImpl)arg2).getSlotStorage$runtime();
        }

        return v0;
    }

    private final SlotTable getSlotTable() {
        Composition v1 = this.composition;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
        return SlotTableKt.asLinkBufferSlotTable(((CompositionImpl)v1).getSlotStorage$runtime());
    }

    public int hashCode() {
        return this.composition.hashCode() * 0x1F;
    }

    public boolean isEmpty() {
        return this.getSlotTable().isEmpty();
    }
}

