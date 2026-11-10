package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0001\u0018\u00002\u00020\u0001B\u0094\u0001\u0012#\u0010\u0002\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u001D\u0010\t\u001A\u0019\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r\u0012#\u0010\u000E\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003\u0012\"\u0010\u000F\u001A\u001E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\n¢\u0006\u0002\b\u0012¢\u0006\u0002\b\r¢\u0006\u0004\b\u0013\u0010\u0014R1\u0010\u0002\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R(\u0010\t\u001A\u0019\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R1\u0010\u000E\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0016R/\u0010\u000F\u001A\u001E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\n¢\u0006\u0002\b\u0012¢\u0006\u0002\b\r¢\u0006\n\n\u0002\u0010\u001C\u001A\u0004\b\u001A\u0010\u001B¨\u0006\u001D"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridInterval;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "key", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "", "span", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Lkotlin/ExtensionFunctionType;", "type", "item", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "", "Landroidx/compose/runtime/Composable;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "getKey", "()Lkotlin/jvm/functions/Function1;", "getSpan", "()Lkotlin/jvm/functions/Function2;", "getType", "getItem", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyGridInterval implements Interval {
    public static final int $stable;
    private final Function4 item;
    private final Function1 key;
    private final Function2 span;
    private final Function1 type;

    static {
    }

    public LazyGridInterval(Function1 arg1, Function2 arg2, Function1 arg3, Function4 arg4) {
        super();
        this.key = arg1;
        this.span = arg2;
        this.type = arg3;
        this.item = arg4;
    }

    public final Function4 getItem() {
        return this.item;
    }

    public Function1 getKey() {
        return this.key;
    }

    public final Function2 getSpan() {
        return this.span;
    }

    public Function1 getType() {
        return this.type;
    }
}

