package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0012\u001A\u00020\u0007J\u001B\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u000F2\u0006\u0010\u0015\u001A\u00028\u0000¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00020\u000F¢\u0006\u0002\u0010\u0018J\u001D\u0010\u0019\u001A\u00020\u00072\u0012\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u001BH\u0086\bJ\u000F\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00000\u001DH\u0086\bJ\u0016\u0010\u001E\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00020\u000FH\u0086\n¢\u0006\u0002\u0010\u0018R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0012\u0010\u000E\u001A\u00020\u000F8Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001F"}, d2={"Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "T", "", "vector", "Landroidx/compose/runtime/collection/MutableVector;", "onVectorMutated", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/runtime/collection/MutableVector;Lkotlin/jvm/functions/Function0;)V", "getVector", "()Landroidx/compose/runtime/collection/MutableVector;", "getOnVectorMutated", "()Lkotlin/jvm/functions/Function0;", "size", "", "getSize", "()I", "clear", "add", "index", "element", "(ILjava/lang/Object;)V", "removeAt", "(I)Ljava/lang/Object;", "forEach", "block", "Lkotlin/Function1;", "asList", "", "get", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MutableVectorWithMutationTracking {
    public static final int $stable;
    private final Function0 onVectorMutated;
    private final MutableVector vector;

    static {
        MutableVectorWithMutationTracking.$stable = MutableVector.$stable;
    }

    public MutableVectorWithMutationTracking(MutableVector arg1, Function0 arg2) {
        super();
        this.vector = arg1;
        this.onVectorMutated = arg2;
    }

    public final void add(int arg2, Object arg3) {
        this.vector.add(arg2, arg3);
        this.onVectorMutated.invoke();
    }

    public final List asList() {
        return this.getVector().asMutableList();
    }

    public final void clear() {
        this.vector.clear();
        this.onVectorMutated.invoke();
    }

    public final void forEach(Function1 arg4) {
        MutableVector v3 = this.getVector();
        Object[] v0 = v3.content;
        int v3_1 = v3.getSize();
        int v1;
        for(v1 = 0; v1 < v3_1; ++v1) {
            arg4.invoke(v0[v1]);
        }
    }

    public final Object get(int arg1) {
        return this.getVector().content[arg1];
    }

    public final Function0 getOnVectorMutated() {
        return this.onVectorMutated;
    }

    public final int getSize() {
        return this.getVector().getSize();
    }

    public final MutableVector getVector() {
        return this.vector;
    }

    public final Object removeAt(int arg2) {
        Object v2 = this.vector.removeAt(arg2);
        this.onVectorMutated.invoke();
        return v2;
    }
}

