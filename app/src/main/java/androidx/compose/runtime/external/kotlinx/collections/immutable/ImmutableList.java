package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\bJ\u001E\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "E", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "subList", "fromIndex", "", "toIndex", "SubList", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface ImmutableList extends ImmutableCollection, List, KMappedMarker {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000B\u001A\u00028\u00012\u0006\u0010\f\u001A\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\rJ\u001E\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0016R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList$SubList;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "Lkotlin/collections/AbstractList;", "source", "fromIndex", "", "toIndex", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;II)V", "_size", "get", "index", "(I)Ljava/lang/Object;", "size", "getSize", "()I", "subList", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class SubList extends AbstractList implements ImmutableList {
        private int _size;
        private final int fromIndex;
        private final ImmutableList source;
        private final int toIndex;

        public SubList(ImmutableList arg1, int arg2, int arg3) {
            super();
            this.source = arg1;
            this.fromIndex = arg2;
            this.toIndex = arg3;
            ListImplementation.checkRangeIndexes$runtime(arg2, arg3, arg1.size());
            this._size = arg3 - arg2;
        }

        public Object get(int arg2) {
            ListImplementation.checkElementIndex$runtime(arg2, this._size);
            return this.source.get(this.fromIndex + arg2);
        }

        public int getSize() {
            return this._size;
        }

        public ImmutableList subList(int arg3, int arg4) {
            ListImplementation.checkRangeIndexes$runtime(arg3, arg4, this._size);
            return new SubList(this.source, arg3 + this.fromIndex, this.fromIndex + arg4);
        }

        public List subList(int arg1, int arg2) {
            return this.subList(arg1, arg2);
        }
    }

    default ImmutableList subList(int arg2, int arg3) {
        return new SubList(this, arg2, arg3);
    }

    default List subList(int arg1, int arg2) {
        return this.subList(arg1, arg2);
    }
}

