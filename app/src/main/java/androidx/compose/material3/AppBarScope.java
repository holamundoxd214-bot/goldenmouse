package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J@\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00052\u0011\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u00072\u0006\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BH&¢\u0006\u0002\u0010\fJN\u0010\r\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000B2\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00030\u00102\u0011\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u00072\u0006\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BH&¢\u0006\u0002\u0010\u0011J9\u0010\u0012\u001A\u00020\u00032\u0011\u0010\u0013\u001A\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u00072\u0017\u0010\u0014\u001A\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0002\b\u0007H&¢\u0006\u0002\u0010\u0016\u0082\u0001\u0005\u0017\u0018\u0019\u001A\u001Bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001CÀ\u0006\u0001"}, d2={"Landroidx/compose/material3/AppBarScope;", "", "clickableItem", "", "onClick", "Lkotlin/Function0;", "icon", "Landroidx/compose/runtime/Composable;", "label", "", "enabled", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Z)V", "toggleableItem", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Z)V", "customItem", "appbarContent", "menuContent", "Landroidx/compose/material3/AppBarMenuState;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "Landroidx/compose/material3/AppBarColumnScope;", "Landroidx/compose/material3/AppBarColumnScopeImpl;", "Landroidx/compose/material3/AppBarRowScope;", "Landroidx/compose/material3/AppBarRowScopeImpl;", "Landroidx/compose/material3/AppBarScopeImpl;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public interface AppBarScope {
    void clickableItem(Function0 arg1, Function2 arg2, String arg3, boolean arg4);

    static void clickableItem$default(AppBarScope arg0, Function0 arg1, Function2 arg2, String arg3, boolean arg4, int arg5, Object arg6) {
        if(arg6 == null) {
            arg0.clickableItem(arg1, arg2, arg3, true);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clickableItem");
    }

    void customItem(Function2 arg1, Function3 arg2);

    void toggleableItem(boolean arg1, Function1 arg2, Function2 arg3, String arg4, boolean arg5);

    static void toggleableItem$default(AppBarScope arg6, boolean arg7, Function1 arg8, Function2 arg9, String arg10, boolean arg11, int arg12, Object arg13) {
        if(arg13 == null) {
            arg6.toggleableItem(arg7, arg8, arg9, arg10, true);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toggleableItem");
    }
}

