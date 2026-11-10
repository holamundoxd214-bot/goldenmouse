package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012<\u0010\u0005\u001A8\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u0006¢\u0006\u0004\b\r\u0010\u000EJ\t\u0010\u0016\u001A\u00020\u0017H\u0096\u0002J\t\u0010\u0018\u001A\u00020\u0002H\u0096\u0002J\u0017\u0010\u0019\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\nH\u0000¢\u0006\u0002\b\u001AR\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000RD\u0010\u0005\u001A8\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00020\f8F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u001B"}, d2={"Landroidx/compose/foundation/layout/ContextualFlowItemIterator;", "", "Landroidx/compose/ui/layout/Measurable;", "itemCount", "", "getMeasurables", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "", "<init>", "(ILkotlin/jvm/functions/Function2;)V", "_list", "", "itemIndex", "listIndex", "list", "getList", "()Ljava/util/List;", "hasNext", "", "next", "getNext", "getNext$foundation_layout", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ContextualFlowItemIterator implements Iterator, KMappedMarker {
    public static final int $stable = 8;
    private final List _list;
    private final Function2 getMeasurables;
    private final int itemCount;
    private int itemIndex;
    private int listIndex;

    static {
    }

    public ContextualFlowItemIterator(int arg1, Function2 arg2) {
        super();
        this.itemCount = arg1;
        this.getMeasurables = arg2;
        this._list = new ArrayList();
    }

    public final List getList() {
        return this._list;
    }

    public final Measurable getNext$foundation_layout(FlowLineInfo arg3) {
        Object v3;
        if(this.listIndex < this.getList().size()) {
            v3 = this.getList().get(this.listIndex);
            ++this.listIndex;
            return ((Measurable)v3);
        }

        int v0 = this.itemIndex;
        if(v0 < this.itemCount) {
            v3 = this.getMeasurables.invoke(Integer.valueOf(v0), arg3);
            ++this.itemIndex;
            if(((List)v3).isEmpty()) {
                return this.next();
            }

            Object v0_1 = CollectionsKt.first(((List)v3));
            this._list.addAll(((Collection)v3));
            ++this.listIndex;
            return ((Measurable)v0_1);
        }

        throw new IndexOutOfBoundsException("No item returned at index call. Index: " + this.itemIndex);
    }

    public static Measurable getNext$foundation_layout$default(ContextualFlowItemIterator arg7, FlowLineInfo arg8, int arg9, Object arg10) {
        if((arg9 & 1) != 0) {
            arg8 = new FlowLineInfo(0, 0, 0f, 0f, 15, null);
        }

        return arg7.getNext$foundation_layout(arg8);
    }

    public boolean hasNext() {
        if(this.listIndex >= this.getList().size()) {
            if(this.itemIndex < this.itemCount) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public Measurable next() {
        return ContextualFlowItemIterator.getNext$foundation_layout$default(this, null, 1, null);
    }

    public Object next() {
        return this.next();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

