package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

@LazyStaggeredGridScopeMarker @Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001JO\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u001C\u0010\b\u001A\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\b\u000B¢\u0006\u0002\b\fH&¢\u0006\u0002\u0010\rJ½\u0001\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00102%\b\u0002\u0010\u0004\u001A\u001F\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2%\b\u0002\u0010\u0005\u001A\u001F\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2%\b\u0002\u0010\u0006\u001A\u001F\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t21\u0010\u0014\u001A-\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\u0002\b\u000B¢\u0006\u0002\b\fH&¢\u0006\u0002\u0010\u0016\u0082\u0001\u0001\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "", "item", "", "key", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridIntervalContent;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LazyStaggeredGridScope {
    void item(Object arg1, Object arg2, StaggeredGridItemSpan arg3, Function3 arg4);

    static void item$default(LazyStaggeredGridScope arg1, Object arg2, Object arg3, StaggeredGridItemSpan arg4, Function3 arg5, int arg6, Object arg7) {
        if(arg7 == null) {
            Object v0 = null;
            if((arg6 & 1) != 0) {
                arg2 = v0;
            }

            if((arg6 & 2) != 0) {
                arg3 = v0;
            }

            if((arg6 & 4) != 0) {
                arg4 = ((StaggeredGridItemSpan)v0);
            }

            arg1.item(arg2, arg3, arg4, arg5);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
    }

    void items(int arg1, Function1 arg2, Function1 arg3, Function1 arg4, Function4 arg5);

    static void items$default(LazyStaggeredGridScope arg1, int arg2, Function1 arg3, Function1 arg4, Function1 arg5, Function4 arg6, int arg7, Object arg8) {
        LazyStaggeredGridScope$items$1 v4;
        if(arg8 == null) {
            Function1 v0 = null;
            if((arg7 & 2) != 0) {
                arg3 = v0;
            }

            if((arg7 & 4) != 0) {
                v4 = LazyStaggeredGridScope$items$1.INSTANCE;
            }

            if((arg7 & 8) != 0) {
                arg5 = v0;
            }

            arg1.items(arg2, arg3, ((Function1)v4), arg5, arg6);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
    }
}

