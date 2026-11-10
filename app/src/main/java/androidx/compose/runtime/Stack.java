package androidx.compose.runtime;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0018\b\u0002\u0010\u0003\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00028\u0000¢\u0006\u0004\b\u000F\u0010\u0010J\r\u0010\u0011\u001A\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001A\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0013J\u0015\u0010\u0014\u001A\u00028\u00002\u0006\u0010\u0016\u001A\u00020\t¢\u0006\u0004\b\u0015\u0010\u0017J\r\u0010\u0018\u001A\u00020\r¢\u0006\u0004\b\u0019\u0010\u001AJ\r\u0010\u001B\u001A\u00020\r¢\u0006\u0004\b\u001C\u0010\u001AJ\r\u0010\u001D\u001A\u00020\u001E¢\u0006\u0004\b\u001F\u0010 J\u0013\u0010!\u001A\b\u0012\u0004\u0012\u00028\u00000\"¢\u0006\u0004\b#\u0010$J\u0014\u0010%\u001A\u00020\r2\b\u0010&\u001A\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\'\u001A\u00020\tHÖ\u0081\u0004J\n\u0010(\u001A\u00020)HÖ\u0081\u0004R\u001E\u0010\u0003\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B\u0088\u0001\u0003\u0092\u0001\u0012\u0012\u0004\u0012\u0002H\u00010\u0004j\b\u0012\u0004\u0012\u0002H\u0001`\u0005¨\u0006*"}, d2={"Landroidx/compose/runtime/Stack;", "T", "", "backing", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "constructor-impl", "(Ljava/util/ArrayList;)Ljava/util/ArrayList;", "size", "", "getSize-impl", "(Ljava/util/ArrayList;)I", "push", "", "value", "push-impl", "(Ljava/util/ArrayList;Ljava/lang/Object;)Z", "pop", "pop-impl", "(Ljava/util/ArrayList;)Ljava/lang/Object;", "peek", "peek-impl", "index", "(Ljava/util/ArrayList;I)Ljava/lang/Object;", "isEmpty", "isEmpty-impl", "(Ljava/util/ArrayList;)Z", "isNotEmpty", "isNotEmpty-impl", "clear", "", "clear-impl", "(Ljava/util/ArrayList;)V", "toArray", "", "toArray-impl", "(Ljava/util/ArrayList;)[Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class Stack {
    private final ArrayList backing;

    private Stack(ArrayList arg1) {
        super();
        this.backing = arg1;
    }

    public static final Stack box-impl(ArrayList arg1) {
        return new Stack(arg1);
    }

    public static final void clear-impl(ArrayList arg0) {
        arg0.clear();
    }

    public static ArrayList constructor-impl(ArrayList arg0) {
        return arg0;
    }

    public static ArrayList constructor-impl$default(ArrayList arg0, int arg1, DefaultConstructorMarker arg2) {
        if((arg1 & 1) != 0) {
            arg0 = new ArrayList();
        }

        return Stack.constructor-impl(arg0);
    }

    public boolean equals(Object arg1) {
        return Stack.equals-impl(this.backing, arg1);
    }

    public static boolean equals-impl(ArrayList arg2, Object arg3) {
        if(!(arg3 instanceof Stack)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((Stack)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(ArrayList arg0, ArrayList arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final int getSize-impl(ArrayList arg0) {
        return arg0.size();
    }

    public int hashCode() {
        return Stack.hashCode-impl(this.backing);
    }

    public static int hashCode-impl(ArrayList arg0) {
        return arg0.hashCode();
    }

    public static final boolean isEmpty-impl(ArrayList arg0) {
        return arg0.isEmpty();
    }

    public static final boolean isNotEmpty-impl(ArrayList arg0) {
        return Stack.isEmpty-impl(arg0) ^ 1;
    }

    public static final Object peek-impl(ArrayList arg0, int arg1) {
        return arg0.get(arg1);
    }

    public static final Object peek-impl(ArrayList arg1) {
        return arg1.get(Stack.getSize-impl(arg1) - 1);
    }

    public static final Object pop-impl(ArrayList arg1) {
        return arg1.remove(Stack.getSize-impl(arg1) - 1);
    }

    public static final boolean push-impl(ArrayList arg0, Object arg1) {
        return arg0.add(arg1);
    }

    public static final Object[] toArray-impl(ArrayList arg4) {
        int v0 = arg4.size();
        Object[] v1 = new Object[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = arg4.get(v2);
        }

        return v1;
    }

    public String toString() {
        return Stack.toString-impl(this.backing);
    }

    public static String toString-impl(ArrayList arg2) {
        return "Stack(backing=" + arg2 + ')';
    }

    public final ArrayList unbox-impl() {
        return this.backing;
    }
}

