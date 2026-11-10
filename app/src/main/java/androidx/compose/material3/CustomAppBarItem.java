package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B3\u0012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005\u0012\u0017\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\b\u0005¢\u0006\u0004\b\t\u0010\nJ\r\u0010\r\u001A\u00020\u0004H\u0017¢\u0006\u0002\u0010\u000EJ\u0015\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\bH\u0017¢\u0006\u0002\u0010\u0011R\u001B\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000BR!\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\b\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0012"}, d2={"Landroidx/compose/material3/CustomAppBarItem;", "Landroidx/compose/material3/AppBarItem;", "appbarContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "menuContent", "Lkotlin/Function1;", "Landroidx/compose/material3/AppBarMenuState;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function3;", "AppbarContent", "(Landroidx/compose/runtime/Composer;I)V", "MenuContent", "state", "(Landroidx/compose/material3/AppBarMenuState;Landroidx/compose/runtime/Composer;I)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CustomAppBarItem implements AppBarItem {
    public static final int $stable;
    private final Function2 appbarContent;
    private final Function3 menuContent;

    static {
    }

    public CustomAppBarItem(Function2 arg1, Function3 arg2) {
        super();
        this.appbarContent = arg1;
        this.menuContent = arg2;
    }

    public void AppbarContent(Composer arg6, int arg7) {
        int v1;
        int v0 = 0x42DCF12D;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(AppbarContent)229@7260L15:AppBarDsl.kt#uh7d8r");
        int v2 = 2;
        if((arg7 & 6) == 0) {
            v1 = arg6.changed(this) ? 4 : v2;
            v1 |= arg7;
        }
        else {
            v1 = arg7;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg6.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.CustomAppBarItem.AppbarContent (AppBarDsl.kt:228)");
            }

            this.appbarContent.invoke(arg6, Integer.valueOf(0));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_37;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_37:
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new CustomAppBarItem$$ExternalSyntheticLambda0(this, arg7));
        }
    }

    static final Unit AppbarContent$lambda$0(CustomAppBarItem arg0, int arg1, Composer arg2, int arg3) {
        arg0.AppbarContent(arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    public void MenuContent(AppBarMenuState arg5, Composer arg6, int arg7) {
        int v1;
        int v0 = 0x91823EF8;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(MenuContent)N(state)234@7362L18:AppBarDsl.kt#uh7d8r");
        if((arg7 & 6) == 0) {
            v1 = arg6.changed(arg5) ? 4 : 2;
            v1 |= arg7;
        }
        else {
            v1 = arg7;
        }

        if((arg7 & 0x30) == 0) {
            int v2 = arg6.changed(this) ? 0x20 : 16;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 19) != 18 ? true : false;
        if(arg6.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.CustomAppBarItem.MenuContent (AppBarDsl.kt:233)");
            }

            this.menuContent.invoke(arg5, arg6, Integer.valueOf(v1 & 14));
            if(!ComposerKt.isTraceInProgress()) {
                goto label_45;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_45:
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new CustomAppBarItem$$ExternalSyntheticLambda1(this, arg5, arg7));
        }
    }

    static final Unit MenuContent$lambda$1(CustomAppBarItem arg0, AppBarMenuState arg1, int arg2, Composer arg3, int arg4) {
        arg0.MenuContent(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }
}

