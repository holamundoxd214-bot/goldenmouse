package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086\n\u001A\u0015\u0010\u0005\u001A\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0001H\u0086\u0002\u001A\u0015\u0010\b\u001A\u00020\t*\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0001H\u0086\n\u001A\r\u0010\r\u001A\u00020\u0006*\u00020\u0002H\u0086\b\u001A\r\u0010\u000E\u001A\u00020\u0006*\u00020\u0002H\u0086\b\u001A3\u0010\u000F\u001A\u00020\t*\u00020\u00022!\u0010\u0010\u001A\u001D\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\t0\u0011H\u0086\bø\u0001\u0000\u001AH\u0010\u0014\u001A\u00020\t*\u00020\u000226\u0010\u0010\u001A2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\t0\u0015H\u0086\bø\u0001\u0000\u001A\u0013\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00010\u0017*\u00020\u0002H\u0086\u0002\u001A\u0015\u0010\u0018\u001A\u00020\t*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086\b\"\u0016\u0010\n\u001A\u00020\u0004*\u00020\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f\"\u001B\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00010\u001A*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001D"}, d2={"get", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "index", "", "contains", "", "item", "minusAssign", "", "size", "getSize", "(Landroid/view/Menu;)I", "isEmpty", "isNotEmpty", "forEach", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "iterator", "", "removeItemAt", "children", "Lkotlin/sequences/Sequence;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class MenuKt {
    public static final boolean contains(Menu arg4, MenuItem arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "item");
        int v0 = arg4.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(Intrinsics.areEqual(arg4.getItem(v2), arg5)) {
                return 1;
            }
        }

        return 0;
    }

    public static final void forEach(Menu arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "action");
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            MenuItem v2 = arg4.getItem(v1);
            Intrinsics.checkNotNullExpressionValue(v2, "getItem(...)");
            arg5.invoke(v2);
        }
    }

    public static final void forEachIndexed(Menu arg5, Function2 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "action");
        int v0 = arg5.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Integer v2 = Integer.valueOf(v1);
            MenuItem v3 = arg5.getItem(v1);
            Intrinsics.checkNotNullExpressionValue(v3, "getItem(...)");
            arg6.invoke(v2, v3);
        }
    }

    public static final MenuItem get(Menu arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        MenuItem v1 = arg1.getItem(arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "getItem(...)");
        return v1;
    }

    public static final Sequence getChildren(Menu arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new MenuKt$children$1(arg1);
    }

    public static final int getSize(Menu arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.size();
    }

    public static final boolean isEmpty(Menu arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.size() == 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isNotEmpty(Menu arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.size() != 0) {
            return 1;
        }

        return 0;
    }

    public static final Iterator iterator(Menu arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new MenuKt$iterator$1(arg1);
    }

    public static final void minusAssign(Menu arg1, MenuItem arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "item");
        arg1.removeItem(arg2.getItemId());
    }

    public static final void removeItemAt(Menu arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        MenuItem v2 = arg1.getItem(arg2);
        if(v2 != null) {
            arg1.removeItem(v2.getItemId());
            return;
        }

        throw new IndexOutOfBoundsException();
    }
}

