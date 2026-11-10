package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u000BJ\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000F\u001A\u00020\u000BJT\u0010\u0011\u001A\u0002H\u0012\"\u0004\b\u0001\u0010\u00122\u0006\u0010\u0013\u001A\u00020\u000B26\u0010\u0014\u001A2\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H\u00120\u0015H\u0086\b¢\u0006\u0002\u0010\u001AR\u0018\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0011\u0010\n\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Interval", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "", "<init>", "()V", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "itemCount", "", "getItemCount", "()I", "getKey", "index", "getContentType", "withInterval", "T", "globalIndex", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "localIntervalIndex", "content", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class LazyLayoutIntervalContent {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R1\u0010\u0002\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR1\u0010\n\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "", "key", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "getKey", "()Lkotlin/jvm/functions/Function1;", "type", "getType", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Interval {
        default Function1 getKey() {
            return null;
        }

        default Function1 getType() {
            return LazyLayoutIntervalContent$Interval$type$1.INSTANCE;
        }
    }

    public static final int $stable;

    static {
    }

    public LazyLayoutIntervalContent() {
        super();
    }

    public final Object getContentType(int arg2) {
        androidx.compose.foundation.lazy.layout.IntervalList$Interval v1 = this.getIntervals().get(arg2);
        return v1.getValue().getType().invoke(Integer.valueOf(arg2 - v1.getStartIndex()));
    }

    public abstract IntervalList getIntervals();

    public final int getItemCount() {
        return this.getIntervals().getSize();
    }

    public final Object getKey(int arg2) {
        androidx.compose.foundation.lazy.layout.IntervalList$Interval v1 = this.getIntervals().get(arg2);
        int v0 = arg2 - v1.getStartIndex();
        Function1 v1_1 = v1.getValue().getKey();
        if(v1_1 != null) {
            Object v1_2 = v1_1.invoke(Integer.valueOf(v0));
            if(v1_2 == null) {
            }
            else {
                return v1_2;
            }
        }

        return Lazy_androidKt.getDefaultLazyLayoutKey(arg2);
    }

    public final Object withInterval(int arg2, Function2 arg3) {
        androidx.compose.foundation.lazy.layout.IntervalList$Interval v1 = this.getIntervals().get(arg2);
        return arg3.invoke(Integer.valueOf(arg2 - v1.getStartIndex()), v1.getValue());
    }
}

