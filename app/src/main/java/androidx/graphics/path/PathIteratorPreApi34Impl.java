package androidx.graphics.path;

import android.graphics.Path;
import dalvik.annotation.optimization.FastNative;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016J!\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\f2\u0006\u0010\u0006\u001A\u00020\u0007H\u0082 J\u0011\u0010\u0010\u001A\u00020\u00112\u0006\u0010\t\u001A\u00020\nH\u0082 J\b\u0010\u0012\u001A\u00020\u0011H\u0004J\b\u0010\u0013\u001A\u00020\u000EH\u0016J\u0011\u0010\u0014\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\nH\u0083 J!\u0010\u0015\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\fH\u0083 J\u0011\u0010\u0019\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\nH\u0083 J\u0011\u0010\u001A\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\nH\u0083 J\u0011\u0010\u001B\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\nH\u0083 J\u0018\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\fH\u0016J\b\u0010\u001E\u001A\u00020\u001DH\u0016R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2={"Landroidx/graphics/path/PathIteratorPreApi34Impl;", "Landroidx/graphics/path/PathIteratorImpl;", "path", "Landroid/graphics/Path;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "tolerance", "", "(Landroid/graphics/Path;Landroidx/graphics/path/PathIterator$ConicEvaluation;F)V", "internalPathIterator", "", "calculateSize", "", "includeConvertedConics", "", "createInternalPathIterator", "destroyInternalPathIterator", "", "finalize", "hasNext", "internalPathIteratorHasNext", "internalPathIteratorNext", "points", "", "offset", "internalPathIteratorPeek", "internalPathIteratorRawSize", "internalPathIteratorSize", "next", "Landroidx/graphics/path/PathSegment$Type;", "peek", "graphics-path_release"}, k=1, mv={1, 8, 0}, xi=0x30) public final class PathIteratorPreApi34Impl extends PathIteratorImpl {
    private final long internalPathIterator;

    public PathIteratorPreApi34Impl(Path arg2, ConicEvaluation arg3, float arg4) {
        Intrinsics.checkNotNullParameter(arg2, "path");
        Intrinsics.checkNotNullParameter(arg3, "conicEvaluation");
        super(arg2, arg3, arg4);
        this.internalPathIterator = this.createInternalPathIterator(arg2, arg3.ordinal(), arg4);
    }

    public PathIteratorPreApi34Impl(Path arg1, ConicEvaluation arg2, float arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = ConicEvaluation.AsQuadratics;
        }

        if((arg4 & 4) != 0) {
            arg3 = 0.25f;
        }

        this(arg1, arg2, arg3);
    }

    public int calculateSize(boolean arg3) {
        if(arg3) {
            if(this.getConicEvaluation() == ConicEvaluation.AsConic) {
            }
            else {
                return this.internalPathIteratorSize(this.internalPathIterator);
            }
        }

        return this.internalPathIteratorRawSize(this.internalPathIterator);
    }

    private final native long createInternalPathIterator(Path arg1, int arg2, float arg3) {
    }

    private final native void destroyInternalPathIterator(long arg1) {
    }

    protected final void finalize() {
        this.destroyInternalPathIterator(this.internalPathIterator);
    }

    public boolean hasNext() {
        return this.internalPathIteratorHasNext(this.internalPathIterator);
    }

    @FastNative private final native boolean internalPathIteratorHasNext(long arg1) {
    }

    @FastNative private final native int internalPathIteratorNext(long arg1, float[] arg2, int arg3) {
    }

    @FastNative private final native int internalPathIteratorPeek(long arg1) {
    }

    @FastNative private final native int internalPathIteratorRawSize(long arg1) {
    }

    @FastNative private final native int internalPathIteratorSize(long arg1) {
    }

    public Type next(float[] arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg4, "points");
        return PathIteratorImplKt.PathSegmentTypes[this.internalPathIteratorNext(this.internalPathIterator, arg4, arg5)];
    }

    public Type peek() {
        return PathIteratorImplKt.PathSegmentTypes[this.internalPathIteratorPeek(this.internalPathIterator)];
    }
}

