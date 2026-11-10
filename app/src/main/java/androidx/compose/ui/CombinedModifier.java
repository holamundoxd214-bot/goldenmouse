package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010\t\u001A\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000B\u001A\u0002H\n2\u0018\u0010\f\u001A\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000FJ5\u0010\u0010\u001A\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000B\u001A\u0002H\n2\u0018\u0010\f\u001A\u0014\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\n0\rH\u0016¢\u0006\u0002\u0010\u000FJ\u001C\u0010\u0011\u001A\u00020\u00122\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00120\u0014H\u0016J\u001C\u0010\u0015\u001A\u00020\u00122\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00120\u0014H\u0016J\u0013\u0010\u0016\u001A\u00020\u00122\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\b\u0010\u001B\u001A\u00020\u001CH\u0016R\u0014\u0010\u0002\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0007¨\u0006\u001D"}, d2={"Landroidx/compose/ui/CombinedModifier;", "Landroidx/compose/ui/Modifier;", "outer", "inner", "<init>", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;)V", "getOuter$ui", "()Landroidx/compose/ui/Modifier;", "getInner$ui", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "Landroidx/compose/ui/Modifier$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "any", "", "predicate", "Lkotlin/Function1;", "all", "equals", "other", "", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CombinedModifier implements Modifier {
    public static final int $stable;
    private final Modifier inner;
    private final Modifier outer;

    static {
    }

    public CombinedModifier(Modifier arg1, Modifier arg2) {
        super();
        this.outer = arg1;
        this.inner = arg2;
    }

    public boolean all(Function1 arg2) {
        if((this.outer.all(arg2)) && (this.inner.all(arg2))) {
            return 1;
        }

        return 0;
    }

    public boolean any(Function1 arg2) {
        if(!this.outer.any(arg2)) {
            if(this.inner.any(arg2)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof CombinedModifier)) && (Intrinsics.areEqual(this.outer, ((CombinedModifier)arg3).outer)) && (Intrinsics.areEqual(this.inner, ((CombinedModifier)arg3).inner))) {
            return 1;
        }

        return 0;
    }

    public Object foldIn(Object arg2, Function2 arg3) {
        return this.inner.foldIn(this.outer.foldIn(arg2, arg3), arg3);
    }

    public Object foldOut(Object arg2, Function2 arg3) {
        return this.outer.foldOut(this.inner.foldOut(arg2, arg3), arg3);
    }

    public final Modifier getInner$ui() {
        return this.inner;
    }

    public final Modifier getOuter$ui() {
        return this.outer;
    }

    public int hashCode() {
        return this.outer.hashCode() + this.inner.hashCode() * 0x1F;
    }

    public String toString() {
        return "[" + this.foldIn("", CombinedModifier$toString$1.INSTANCE) + ']';
    }
}

