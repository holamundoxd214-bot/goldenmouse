package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B_\u0012#\u0010\u0002\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u00121\u0010\t\u001A-\u0012\u0004\u0012\u00020\u000B\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r¢\u0006\u0002\b\u000E¢\u0006\u0004\b\u000F\u0010\u0010R1\u0010\u0002\u001A\u001F\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R>\u0010\t\u001A-\u0012\u0004\u0012\u00020\u000B\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\r¢\u0006\u0002\b\u000E¢\u0006\n\n\u0002\u0010\u0015\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/pager/PagerIntervalContent;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent$Interval;", "key", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "page", "", "item", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "getKey", "()Lkotlin/jvm/functions/Function1;", "getItem", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PagerIntervalContent implements Interval {
    public static final int $stable;
    private final Function4 item;
    private final Function1 key;

    static {
    }

    public PagerIntervalContent(Function1 arg1, Function4 arg2) {
        super();
        this.key = arg1;
        this.item = arg2;
    }

    public final Function4 getItem() {
        return this.item;
    }

    public Function1 getKey() {
        return this.key;
    }
}

