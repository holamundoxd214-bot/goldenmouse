package androidx.compose.runtime;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Bo\b\u0000\u0012\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u001A\u0010\u000B\u001A\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000E\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r0\f\u0012\u0006\u0010\u000F\u001A\u00020\u0010\u0012\u000E\u0010\u0011\u001A\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010%\u001A\u00020&H\u0000¢\u0006\u0002\b\'R\u001C\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001A\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0007\u001A\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0014\u0010\t\u001A\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR.\u0010\u000B\u001A\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000E\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r0\fX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R\u0014\u0010\u000F\u001A\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u001C\u0010\u0011\u001A\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\fX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u001F¨\u0006("}, d2={"Landroidx/compose/runtime/MovableContentStateReference;", "", "content", "Landroidx/compose/runtime/MovableContent;", "parameter", "composition", "Landroidx/compose/runtime/ControlledComposition;", "slotStorage", "Landroidx/compose/runtime/SlotStorage;", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidations", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/RecomposeScopeImpl;", "locals", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "nestedReferences", "<init>", "(Landroidx/compose/runtime/MovableContent;Ljava/lang/Object;Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/SlotStorage;Landroidx/compose/runtime/Anchor;Ljava/util/List;Landroidx/compose/runtime/PersistentCompositionLocalMap;Ljava/util/List;)V", "getContent$runtime", "()Landroidx/compose/runtime/MovableContent;", "getParameter$runtime", "()Ljava/lang/Object;", "getComposition$runtime", "()Landroidx/compose/runtime/ControlledComposition;", "getSlotStorage$runtime", "()Landroidx/compose/runtime/SlotStorage;", "getAnchor$runtime", "()Landroidx/compose/runtime/Anchor;", "getInvalidations$runtime", "()Ljava/util/List;", "setInvalidations$runtime", "(Ljava/util/List;)V", "getLocals$runtime", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "getNestedReferences$runtime", "transferPendingInvalidations", "", "transferPendingInvalidations$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class MovableContentStateReference {
    public static final int $stable = 8;
    private final Anchor anchor;
    private final ControlledComposition composition;
    private final MovableContent content;
    private List invalidations;
    private final PersistentCompositionLocalMap locals;
    private final List nestedReferences;
    private final Object parameter;
    private final SlotStorage slotStorage;

    static {
    }

    public MovableContentStateReference(MovableContent arg1, Object arg2, ControlledComposition arg3, SlotStorage arg4, Anchor arg5, List arg6, PersistentCompositionLocalMap arg7, List arg8) {
        super();
        this.content = arg1;
        this.parameter = arg2;
        this.composition = arg3;
        this.slotStorage = arg4;
        this.anchor = arg5;
        this.invalidations = arg6;
        this.locals = arg7;
        this.nestedReferences = arg8;
    }

    public final Anchor getAnchor$runtime() {
        return this.anchor;
    }

    public final ControlledComposition getComposition$runtime() {
        return this.composition;
    }

    public final MovableContent getContent$runtime() {
        return this.content;
    }

    public final List getInvalidations$runtime() {
        return this.invalidations;
    }

    public final PersistentCompositionLocalMap getLocals$runtime() {
        return this.locals;
    }

    public final List getNestedReferences$runtime() {
        return this.nestedReferences;
    }

    public final Object getParameter$runtime() {
        return this.parameter;
    }

    public final SlotStorage getSlotStorage$runtime() {
        return this.slotStorage;
    }

    public final void setInvalidations$runtime(List arg1) {
        this.invalidations = arg1;
    }

    public final void transferPendingInvalidations$runtime() {
        if(this.anchor.getValid()) {
            List v0 = this.invalidations;
            ControlledComposition v1 = this.composition;
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            this.invalidations = CollectionsKt.plus(((Collection)v0), ((CompositionImpl)v1).extractInvalidationsOf$runtime(this.anchor));
        }
    }
}

