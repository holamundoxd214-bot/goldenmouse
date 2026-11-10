package androidx.compose.material3;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J>\u0010\u000E\u001A\u00020\u000F2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u00112\u0011\u0010\u0012\u001A\r\u0012\u0004\u0012\u00020\u000F0\u0011¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016¢\u0006\u0002\u0010\u0018JL\u0010\u0019\u001A\u00020\u000F2\u0006\u0010\u001A\u001A\u00020\u00172\u0012\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000F0\u001C2\u0011\u0010\u0012\u001A\r\u0012\u0004\u0012\u00020\u000F0\u0011¢\u0006\u0002\b\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016¢\u0006\u0002\u0010\u001DJ9\u0010\u001E\u001A\u00020\u000F2\u0011\u0010\u001F\u001A\r\u0012\u0004\u0012\u00020\u000F0\u0011¢\u0006\u0002\b\u00132\u0017\u0010 \u001A\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u000F0\u001C¢\u0006\u0002\b\u0013H\u0016¢\u0006\u0002\u0010\"R\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006#"}, d2={"Landroidx/compose/material3/AppBarScopeImpl;", "Landroidx/compose/material3/AppBarScope;", "Landroidx/compose/material3/AppBarItemProvider;", "<init>", "()V", "items", "", "Landroidx/compose/material3/AppBarItem;", "getItems", "()Ljava/util/List;", "itemsCount", "", "getItemsCount", "()I", "clickableItem", "", "onClick", "Lkotlin/Function0;", "icon", "Landroidx/compose/runtime/Composable;", "label", "", "enabled", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Z)V", "toggleableItem", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Ljava/lang/String;Z)V", "customItem", "appbarContent", "menuContent", "Landroidx/compose/material3/AppBarMenuState;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AppBarScopeImpl implements AppBarItemProvider, AppBarScope {
    public static final int $stable = 8;
    private final List items;

    static {
    }

    public AppBarScopeImpl() {
        super();
        this.items = new ArrayList();
    }

    public void clickableItem(Function0 arg2, Function2 arg3, String arg4, boolean arg5) {
        this.getItems().add(new ClickableAppBarItem(arg2, arg3, arg5, arg4));
    }

    public void customItem(Function2 arg2, Function3 arg3) {
        this.getItems().add(new CustomAppBarItem(arg2, arg3));
    }

    public List getItems() {
        return this.items;
    }

    public int getItemsCount() {
        return this.getItems().size();
    }

    public void toggleableItem(boolean arg7, Function1 arg8, Function2 arg9, String arg10, boolean arg11) {
        this.getItems().add(new ToggleableAppBarItem(arg7, arg8, arg9, arg11, arg10));
    }
}

