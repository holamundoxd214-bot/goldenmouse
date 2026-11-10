package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

@LazyGridScopeMarker @Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J`\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00012\u001B\b\u0002\u0010\u0005\u001A\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\b\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00012\u001C\u0010\u000B\u001A\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\b\r¢\u0006\u0002\b\tH&¢\u0006\u0002\u0010\u000EJÈ\u0001\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u00112%\b\u0002\u0010\u0004\u001A\u001F\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000620\b\u0002\u0010\u0005\u001A*\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015¢\u0006\u0002\b\t2%\b\u0002\u0010\n\u001A\u001F\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000621\u0010\u0016\u001A-\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\u0002\b\r¢\u0006\u0002\b\tH&¢\u0006\u0002\u0010\u0017JI\u0010\u0018\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00012\"\u0010\u000B\u001A\u001E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\u0002\b\r¢\u0006\u0002\b\tH&¢\u0006\u0002\u0010\u0019\u0082\u0001\u0001\u001Aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001BÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "", "item", "", "key", "span", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "Lkotlin/ExtensionFunctionType;", "contentType", "content", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/ParameterName;", "name", "index", "Lkotlin/Function2;", "itemContent", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)V", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface LazyGridScope {
    void item(Object arg1, Function1 arg2, Object arg3, Function3 arg4);

    static void item$default(LazyGridScope arg1, Object arg2, Function1 arg3, Object arg4, Function3 arg5, int arg6, Object arg7) {
        if(arg7 == null) {
            Object v0 = null;
            if((arg6 & 1) != 0) {
                arg2 = v0;
            }

            if((arg6 & 2) != 0) {
                arg3 = ((Function1)v0);
            }

            if((arg6 & 4) != 0) {
                arg4 = v0;
            }

            arg1.item(arg2, arg3, arg4, arg5);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
    }

    void items(int arg1, Function1 arg2, Function2 arg3, Function1 arg4, Function4 arg5);

    static void items$default(LazyGridScope arg1, int arg2, Function1 arg3, Function2 arg4, Function1 arg5, Function4 arg6, int arg7, Object arg8) {
        LazyGridScope$items$1 v5;
        if(arg8 == null) {
            Function1 v0 = null;
            if((arg7 & 2) != 0) {
                arg3 = v0;
            }

            if((arg7 & 4) != 0) {
                arg4 = ((Function2)v0);
            }

            if((arg7 & 8) != 0) {
                v5 = LazyGridScope$items$1.INSTANCE;
            }

            arg1.items(arg2, arg3, arg4, ((Function1)v5), arg6);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
    }

    void stickyHeader(Object arg1, Object arg2, Function4 arg3);

    static void stickyHeader$default(LazyGridScope arg1, Object arg2, Object arg3, Function4 arg4, int arg5, Object arg6) {
        if(arg6 == null) {
            Object v0 = null;
            if((arg5 & 1) != 0) {
                arg2 = v0;
            }

            if((arg5 & 2) != 0) {
                arg3 = v0;
            }

            arg1.stickyHeader(arg2, arg3, arg4);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
    }
}

