package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bg\u00121\u0010\u0003\u001A-\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0002\b\u000B¢\u0006\u0002\b\f\u0012#\u0010\r\u001A\u001F\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000E\u0012\u0006\u0010\u0011\u001A\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013R>\u0010\u0003\u001A-\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0002\b\u000B¢\u0006\u0002\b\f¢\u0006\n\n\u0002\u0010\u0016\u001A\u0004\b\u0014\u0010\u0015R.\u0010\r\u001A\u001F\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000F\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0011\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u001A\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00020\u001CX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2={"Landroidx/compose/foundation/pager/PagerLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/pager/PagerIntervalContent;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "", "Lkotlin/ParameterName;", "name", "page", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "key", "Lkotlin/Function1;", "index", "", "pageCount", "<init>", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;I)V", "getPageContent", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "getKey", "()Lkotlin/jvm/functions/Function1;", "getPageCount", "()I", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class PagerLayoutIntervalContent extends LazyLayoutIntervalContent {
    private final IntervalList intervals;
    private final Function1 key;
    private final Function4 pageContent;
    private final int pageCount;

    public PagerLayoutIntervalContent(Function4 arg3, Function1 arg4, int arg5) {
        super();
        this.pageContent = arg3;
        this.key = arg4;
        this.pageCount = arg5;
        MutableIntervalList v0 = new MutableIntervalList();
        v0.addInterval(arg5, new PagerIntervalContent(arg4, arg3));
        this.intervals = ((IntervalList)v0);
    }

    public IntervalList getIntervals() {
        return this.intervals;
    }

    public final Function1 getKey() {
        return this.key;
    }

    public final Function4 getPageContent() {
        return this.pageContent;
    }

    public final int getPageCount() {
        return this.pageCount;
    }
}

