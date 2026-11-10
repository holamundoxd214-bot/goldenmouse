package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001A\u00020\u0011H\u0016J\u0006\u0010\u0014\u001A\u00020\u0011J\b\u0010\u0015\u001A\u00020\u0011H$J\"\u0010\u0016\u001A\u00020\u0011*\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0019H\u0004J*\u0010\u001B\u001A\u00020\u0011*\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u001C\u001A\u00020\u00192\u0006\u0010\u001D\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u0019H\u0004R\u0013\u0010\u0003\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000BR&\u0010\r\u001A\u00028\u00002\u0006\u0010\f\u001A\u00028\u0000@TX\u0096\u000E¢\u0006\u0010\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\u0005¨\u0006\u001E"}, d2={"Landroidx/compose/runtime/AbstractApplier;", "T", "Landroidx/compose/runtime/Applier;", "root", "<init>", "(Ljava/lang/Object;)V", "getRoot", "()Ljava/lang/Object;", "Ljava/lang/Object;", "stack", "Landroidx/compose/runtime/Stack;", "Ljava/util/ArrayList;", "value", "current", "getCurrent", "setCurrent", "down", "", "node", "up", "clear", "onClear", "remove", "", "index", "", "count", "move", "from", "to", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class AbstractApplier implements Applier {
    public static final int $stable = 8;
    private Object current;
    private final Object root;
    private final ArrayList stack;

    static {
    }

    public AbstractApplier(Object arg3) {
        super();
        this.root = arg3;
        this.stack = Stack.constructor-impl$default(null, 1, null);
        this.current = arg3;
    }

    public final void clear() {
        Stack.clear-impl(this.stack);
        this.setCurrent(this.root);
        this.onClear();
    }

    public void down(Object arg3) {
        Stack.push-impl(this.stack, this.getCurrent());
        this.setCurrent(arg3);
    }

    public Object getCurrent() {
        return this.current;
    }

    public final Object getRoot() {
        return this.root;
    }

    protected final void move(List arg2, int arg3, int arg4, int arg5) {
        int v1 = arg3 > arg4 ? arg4 : arg4 - arg5;
        if(arg5 == 1) {
            if(arg3 != arg4 + 1) {
                if(arg3 == arg4 - 1) {
                }
                else {
                    arg2.add(v1, arg2.remove(arg3));
                    return;
                }
            }

            arg2.set(arg3, arg2.set(arg4, arg2.get(arg3)));
            return;
        }

        List v3 = arg2.subList(arg3, arg5 + arg3);
        List v4 = CollectionsKt.toMutableList(v3);
        v3.clear();
        arg2.addAll(v1, ((Collection)v4));
    }

    protected abstract void onClear();

    protected final void remove(List arg1, int arg2, int arg3) {
        if(arg3 == 1) {
            arg1.remove(arg2);
            return;
        }

        arg1.subList(arg2, arg3 + arg2).clear();
    }

    protected void setCurrent(Object arg1) {
        this.current = arg1;
    }

    public void up() {
        this.setCurrent(Stack.pop-impl(this.stack));
    }
}

