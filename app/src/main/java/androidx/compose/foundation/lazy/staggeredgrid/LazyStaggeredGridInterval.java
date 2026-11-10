package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u009A\u0001\u0012#\u0010\u0002\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012#\u0010\t\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003\u0012#\u0010\n\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u0003\u0012\"\u0010\f\u001A\u001E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011¢\u0006\u0004\b\u0012\u0010\u0013R1\u0010\u0002\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R1\u0010\t\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0015R.\u0010\n\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0015R/\u0010\f\u001A\u001E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridInterval;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "key", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "", "type", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "item", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "getKey", "()Lkotlin/jvm/functions/Function1;", "getType", "getSpan", "getItem", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridInterval implements Interval {
    public static final int $stable;
    private final Function4 item;
    private final Function1 key;
    private final Function1 span;
    private final Function1 type;

    static {
    }

    public LazyStaggeredGridInterval(Function1 arg1, Function1 arg2, Function1 arg3, Function4 arg4) {
        super();
        this.key = arg1;
        this.type = arg2;
        this.span = arg3;
        this.item = arg4;
    }

    public final Function4 getItem() {
        return this.item;
    }

    public Function1 getKey() {
        return this.key;
    }

    public final Function1 getSpan() {
        return this.span;
    }

    public Function1 getType() {
        return this.type;
    }
}

