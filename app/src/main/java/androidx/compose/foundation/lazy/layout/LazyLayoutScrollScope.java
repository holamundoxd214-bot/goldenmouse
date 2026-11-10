package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001A\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u0003H&J\u001A\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u00032\b\b\u0002\u0010\u0012\u001A\u00020\u0003H&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", "Landroidx/compose/foundation/gestures/ScrollScope;", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "lastVisibleItemIndex", "getLastVisibleItemIndex", "itemCount", "getItemCount", "snapToItem", "", "index", "offset", "calculateDistanceTo", "targetIndex", "targetOffset", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LazyLayoutScrollScope extends ScrollScope {
    int calculateDistanceTo(int arg1, int arg2);

    static int calculateDistanceTo$default(LazyLayoutScrollScope arg0, int arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            return arg0.calculateDistanceTo(arg1, 0);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateDistanceTo");
    }

    int getFirstVisibleItemIndex();

    int getFirstVisibleItemScrollOffset();

    int getItemCount();

    int getLastVisibleItemIndex();

    void snapToItem(int arg1, int arg2);

    static void snapToItem$default(LazyLayoutScrollScope arg0, int arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            arg0.snapToItem(arg1, 0);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: snapToItem");
    }
}

