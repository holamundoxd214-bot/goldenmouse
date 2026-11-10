package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001A\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001A\u00020\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000B0\rH\u0086\b¢\u0006\u0004\b\u000E\u0010\u000FJ\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001R\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002¨\u0006\u0017"}, d2={"Lkotlinx/coroutines/internal/InlineList;", "E", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "plus", "element", "plus-FjFbRPM", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEachReversed", "", "action", "Lkotlin/Function1;", "forEachReversed-impl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "equals", "", "other", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class InlineList {
    private final Object holder;

    private InlineList(Object arg1) {
        super();
        this.holder = arg1;
    }

    public static final InlineList box-impl(Object arg1) {
        return new InlineList(arg1);
    }

    public static Object constructor-impl(Object arg0) {
        return arg0;
    }

    public static Object constructor-impl$default(Object arg0, int arg1, DefaultConstructorMarker arg2) {
        if((arg1 & 1) != 0) {
            arg0 = null;
        }

        return InlineList.constructor-impl(arg0);
    }

    public boolean equals(Object arg1) {
        return InlineList.equals-impl(this.holder, arg1);
    }

    public static boolean equals-impl(Object arg2, Object arg3) {
        if(!(arg3 instanceof InlineList)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((InlineList)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(Object arg0, Object arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final void forEachReversed-impl(Object arg2, Function1 arg3) {
        if(arg2 == null) {
        }
        else if(!(arg2 instanceof ArrayList)) {
            arg3.invoke(arg2);
            return;
        }
        else {
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
            int v0;
            for(v0 = ((ArrayList)arg2).size() - 1; -1 < v0; --v0) {
                arg3.invoke(((ArrayList)arg2).get(v0));
            }
        }
    }

    public int hashCode() {
        return InlineList.hashCode-impl(this.holder);
    }

    public static int hashCode-impl(Object arg0) {
        if(arg0 == null) {
            return 0;
        }

        return arg0.hashCode();
    }

    public static final Object plus-FjFbRPM(Object arg2, Object arg3) {
        if(DebugKt.getASSERTIONS_ENABLED()) {
            if(!(arg3 instanceof List)) {
            }
            else {
                throw new AssertionError();
            }
        }

        if(arg2 == null) {
            return InlineList.constructor-impl(arg3);
        }

        if((arg2 instanceof ArrayList)) {
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
            arg2.add(arg3);
            return InlineList.constructor-impl(arg2);
        }

        ArrayList v0 = new ArrayList(4);
        v0.add(arg2);
        v0.add(arg3);
        return InlineList.constructor-impl(v0);
    }

    public String toString() {
        return InlineList.toString-impl(this.holder);
    }

    public static String toString-impl(Object arg2) {
        return "InlineList(holder=" + arg2 + ')';
    }

    public final Object unbox-impl() {
        return this.holder;
    }
}

