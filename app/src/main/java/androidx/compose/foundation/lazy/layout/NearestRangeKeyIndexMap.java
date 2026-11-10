package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\u0010\u0004\u001A\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016J\u0012\u0010\u0012\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001A\u00020\u000FH\u0016R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/lazy/layout/NearestRangeKeyIndexMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "nearestRange", "Lkotlin/ranges/IntRange;", "intervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "<init>", "(Lkotlin/ranges/IntRange;Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;)V", "map", "Landroidx/collection/ObjectIntMap;", "", "keys", "", "[Ljava/lang/Object;", "keysStartIndex", "", "getIndex", "key", "getKey", "index", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NearestRangeKeyIndexMap implements LazyLayoutKeyIndexMap {
    public static final int $stable = 8;
    private final Object[] keys;
    private final int keysStartIndex;
    private final ObjectIntMap map;

    static {
    }

    public NearestRangeKeyIndexMap(IntRange arg5, LazyLayoutIntervalContent arg6) {
        super();
        IntervalList v6 = arg6.getIntervals();
        int v0 = arg5.getFirst();
        int v3 = v0 >= 0 ? 1 : 0;
        if(v3 == 0) {
            InlineClassHelperKt.throwIllegalStateException("negative nearestRange.first");
        }

        int v5 = Math.min(arg5.getLast(), v6.getSize() - 1);
        if(v5 < v0) {
            this.map = ObjectIntMapKt.emptyObjectIntMap();
            this.keys = new Object[0];
            this.keysStartIndex = 0;
            return;
        }

        int v2 = v5 - v0 + 1;
        this.keys = new Object[v2];
        this.keysStartIndex = v0;
        MutableObjectIntMap v1 = new MutableObjectIntMap(v2);
        v6.forEach(v0, v5, new NearestRangeKeyIndexMap$$ExternalSyntheticLambda0(v0, v5, v1, this));
        this.map = ((ObjectIntMap)v1);
    }

    public int getIndex(Object arg1) {
        ObjectIntMap v0 = this.map;
        int v1 = v0.findKeyIndex(arg1);
        if(v1 >= 0) {
            return v0.values[v1];
        }

        return -1;
    }

    public Object getKey(int arg2) {
        Object[] v0 = this.keys;
        arg2 -= this.keysStartIndex;
        if(arg2 >= 0 && arg2 < v0.length) {
            return v0[arg2];
        }

        return null;
    }

    static final Unit lambda$1$0(int arg4, int arg5, MutableObjectIntMap arg6, NearestRangeKeyIndexMap arg7, Interval arg8) {
        Object v1;
        Function1 v0 = arg8.getValue().getKey();
        arg4 = Math.max(arg4, arg8.getStartIndex());
        arg5 = Math.min(arg5, arg8.getStartIndex() + arg8.getSize() - 1);
        if(arg4 <= arg5) {
            while(true) {
                if(v0 != null) {
                    v1 = v0.invoke(Integer.valueOf(arg4 - arg8.getStartIndex()));
                    if(v1 == null) {
                        goto label_16;
                    }
                }
                else {
                label_16:
                    v1 = Lazy_androidKt.getDefaultLazyLayoutKey(arg4);
                }

                arg6.set(v1, arg4);
                arg7.keys[arg4 - arg7.keysStartIndex] = v1;
                if(arg4 == arg5) {
                    break;
                }

                ++arg4;
            }
        }

        return Unit.INSTANCE;
    }
}

