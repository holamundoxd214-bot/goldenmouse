package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u0010J\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001A\u00020\u0004H¦\u0002J6\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u00042\b\b\u0002\u0010\r\u001A\u00020\u00042\u0018\u0010\u000E\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00020\u000B0\u000FH&R\u0012\u0010\u0003\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/layout/IntervalList;", "T", "", "size", "", "getSize", "()I", "get", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "index", "forEach", "", "fromIndex", "toIndex", "block", "Lkotlin/Function1;", "Interval", "Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface IntervalList {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\b\u0007\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B!\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00028\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0013\u0010\u0006\u001A\u00028\u0001¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\r¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "T", "", "startIndex", "", "size", "value", "<init>", "(IILjava/lang/Object;)V", "getStartIndex", "()I", "getSize", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Interval {
        public static final int $stable;
        private final int size;
        private final int startIndex;
        private final Object value;

        static {
        }

        public Interval(int arg1, int arg2, Object arg3) {
            super();
            this.startIndex = arg1;
            this.size = arg2;
            this.value = arg3;
            int v0 = 1;
            arg1 = arg1 >= 0 ? 1 : 0;
            if(arg1 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("startIndex should be >= 0");
            }

            if(arg2 > 0) {
            }
            else {
                v0 = 0;
            }

            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalArgumentException("size should be > 0");
            }
        }

        public final int getSize() {
            return this.size;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final Object getValue() {
            return this.value;
        }
    }

    void forEach(int arg1, int arg2, Function1 arg3);

    static void forEach$default(IntervalList arg0, int arg1, int arg2, Function1 arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 2) != 0) {
                arg2 = arg0.getSize() - 1;
            }

            arg0.forEach(0, arg2, arg3);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: forEach");
    }

    Interval get(int arg1);

    int getSize();
}

