package androidx.compose.material3;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J?\u0010\n\u001A\u00020\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\r2\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u000B0\r¢\u0006\u0002\b\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0096\u0001¢\u0006\u0002\u0010\u0014J:\u0010\u0015\u001A\u00020\u000B2\u0011\u0010\u0016\u001A\r\u0012\u0004\u0012\u00020\u000B0\r¢\u0006\u0002\b\u000F2\u0017\u0010\u0017\u001A\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000B0\u0018¢\u0006\u0002\b\u000FH\u0096\u0001¢\u0006\u0002\u0010\u001AJM\u0010\u001B\u001A\u00020\u000B2\u0006\u0010\u001C\u001A\u00020\u00132\u0012\u0010\u001D\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000B0\u00182\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u000B0\r¢\u0006\u0002\b\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0096\u0001¢\u0006\u0002\u0010\u001ER\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0018\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020!0 X\u0096\u0005¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u0012\u0010$\u001A\u00020%X\u0096\u0005¢\u0006\u0006\u001A\u0004\b&\u0010\'¨\u0006("}, d2={"Landroidx/compose/material3/AppBarColumnScopeImpl;", "Landroidx/compose/material3/AppBarColumnScope;", "Landroidx/compose/material3/AppBarScope;", "Landroidx/compose/material3/AppBarItemProvider;", "impl", "Landroidx/compose/material3/AppBarScopeImpl;", "<init>", "(Landroidx/compose/material3/AppBarScopeImpl;)V", "getImpl", "()Landroidx/compose/material3/AppBarScopeImpl;", "clickableItem", "", "onClick", "Lkotlin/Function0;", "icon", "Landroidx/compose/runtime/Composable;", "label", "", "enabled", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Z)V", "customItem", "appbarContent", "menuContent", "Lkotlin/Function1;", "Landroidx/compose/material3/AppBarMenuState;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "toggleableItem", "checked", "onCheckedChange", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Z)V", "items", "", "Landroidx/compose/material3/AppBarItem;", "getItems", "()Ljava/util/List;", "itemsCount", "", "getItemsCount", "()I", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class AppBarColumnScopeImpl implements AppBarColumnScope, AppBarItemProvider, AppBarScope {
    private final AppBarScopeImpl impl;

    public AppBarColumnScopeImpl(AppBarScopeImpl arg1) {
        super();
        this.impl = arg1;
    }

    public void clickableItem(Function0 arg1, Function2 arg2, String arg3, boolean arg4) {
        this.impl.clickableItem(arg1, arg2, arg3, arg4);
    }

    public void customItem(Function2 arg1, Function3 arg2) {
        this.impl.customItem(arg1, arg2);
    }

    public final AppBarScopeImpl getImpl() {
        return this.impl;
    }

    public List getItems() {
        return this.impl.getItems();
    }

    public int getItemsCount() {
        return this.impl.getItemsCount();
    }

    public void toggleableItem(boolean arg1, Function1 arg2, Function2 arg3, String arg4, boolean arg5) {
        this.impl.toggleableItem(arg1, arg2, arg3, arg4, arg5);
    }
}

