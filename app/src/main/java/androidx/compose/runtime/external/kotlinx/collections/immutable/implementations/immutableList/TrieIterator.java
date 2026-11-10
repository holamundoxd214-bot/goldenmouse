package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B/\u0012\u000E\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\u0007¢\u0006\u0004\b\n\u0010\u000BJ7\u0010\u0010\u001A\u00020\u00112\u000E\u0010\u0003\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u0007H\u0000¢\u0006\u0004\b\u0012\u0010\u000BJ\u0018\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u0007H\u0002J\u0010\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u0007H\u0002J\r\u0010\u0017\u001A\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0018J\u000E\u0010\u0019\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0018J\r\u0010\u001A\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018R\u000E\u0010\t\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\rR\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/TrieIterator;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "root", "", "", "index", "", "size", "height", "<init>", "([Ljava/lang/Object;III)V", "path", "[Ljava/lang/Object;", "isInRightEdge", "", "reset", "", "reset$runtime", "fillPath", "startLevel", "fillPathIfNeeded", "indexPredicate", "elementAtCurrentIndex", "()Ljava/lang/Object;", "next", "previous", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class TrieIterator extends AbstractListIterator {
    public static final int $stable = 8;
    private int height;
    private boolean isInRightEdge;
    private Object[] path;

    static {
    }

    public TrieIterator(Object[] arg3, int arg4, int arg5, int arg6) {
        super(arg4, arg5);
        this.height = arg6;
        Object[] v6 = new Object[arg6];
        this.path = v6;
        boolean v5 = arg4 == arg5 ? true : false;
        this.isInRightEdge = v5;
        v6[0] = arg3;
        this.fillPath(arg4 - (((int)v5)), 1);
    }

    private final Object elementAtCurrentIndex() {
        int v0 = this.getIndex() & 0x1F;
        Object v2 = this.path[this.height - 1];
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
        return v2[v0];
    }

    private final void fillPath(int arg5, int arg6) {
        int v0 = (this.height - arg6) * 5;
        while(arg6 < this.height) {
            Object[] v1 = this.path;
            Object v2 = v1[arg6 - 1];
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            v1[arg6] = v2[UtilsKt.indexSegment(arg5, v0)];
            v0 += -5;
            ++arg6;
        }
    }

    private final void fillPathIfNeeded(int arg3) {
        int v0;
        for(v0 = 0; UtilsKt.indexSegment(this.getIndex(), v0) == arg3; v0 += 5) {
        }

        if(v0 > 0) {
            this.fillPath(this.getIndex(), this.height - 1 - v0 / 5 + 1);
        }
    }

    public Object next() {
        if(this.hasNext()) {
            Object v0 = this.elementAtCurrentIndex();
            this.setIndex(this.getIndex() + 1);
            if(this.getIndex() == this.getSize()) {
                this.isInRightEdge = true;
                return v0;
            }

            this.fillPathIfNeeded(0);
            return v0;
        }

        throw new NoSuchElementException();
    }

    public Object previous() {
        if(this.hasPrevious()) {
            this.setIndex(this.getIndex() - 1);
            if(this.isInRightEdge) {
                this.isInRightEdge = false;
                return this.elementAtCurrentIndex();
            }

            this.fillPathIfNeeded(0x1F);
            return this.elementAtCurrentIndex();
        }

        throw new NoSuchElementException();
    }

    public final void reset$runtime(Object[] arg3, int arg4, int arg5, int arg6) {
        this.setIndex(arg4);
        this.setSize(arg5);
        this.height = arg6;
        Object[] v0 = this.path;
        if(v0.length < arg6) {
            v0 = new Object[arg6];
            this.path = v0;
        }

        boolean v6 = false;
        v0[0] = arg3;
        if(arg4 == arg5) {
            v6 = true;
        }

        this.isInRightEdge = v6;
        this.fillPath(arg4 - (((int)v6)), 1);
    }
}

