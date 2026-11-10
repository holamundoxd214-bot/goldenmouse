package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0011\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\t\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\r\u0010\u0010\u001A\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001B\u0010\u0007\u001A\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000FR\u000E\u0010\n\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/compose/material3/ToggleableAppBarItem;", "Landroidx/compose/material3/AppBarItem;", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "label", "", "<init>", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;ZLjava/lang/String;)V", "Lkotlin/jvm/functions/Function2;", "AppbarContent", "(Landroidx/compose/runtime/Composer;I)V", "MenuContent", "state", "Landroidx/compose/material3/AppBarMenuState;", "(Landroidx/compose/material3/AppBarMenuState;Landroidx/compose/runtime/Composer;I)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ToggleableAppBarItem implements AppBarItem {
    public static final int $stable;
    private final boolean checked;
    private final boolean enabled;
    private final Function2 icon;
    private final String label;
    private final Function1 onCheckedChange;

    static {
    }

    public ToggleableAppBarItem(boolean arg1, Function1 arg2, Function2 arg3, boolean arg4, String arg5) {
        super();
        this.checked = arg1;
        this.onCheckedChange = arg2;
        this.icon = arg3;
        this.enabled = arg4;
        this.label = arg5;
    }

    public void AppbarContent(Composer arg14, int arg15) {
        int v14;
        int v0 = 0xFCD67ED0;
        Composer v4 = arg14.startRestartGroup(v0);
        ComposerKt.sourceInformation(v4, "C(AppbarContent)197@6344L60,198@6428L32,199@6482L22,200@6516L208,195@6269L455:AppBarDsl.kt#uh7d8r");
        int v1 = 2;
        if((arg15 & 6) == 0) {
            v14 = v4.changed(this) ? 4 : v1;
            v14 |= arg15;
        }
        else {
            v14 = arg15;
        }

        boolean v1_1 = (v14 & 3) != v1 ? true : false;
        if(v4.shouldExecute(v1_1, v14 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v14, -1, "androidx.compose.material3.ToggleableAppBarItem.AppbarContent (AppBarDsl.kt:193)");
            }

            TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.rememberTooltipPositionProvider-Hu5FAss(TooltipAnchorPosition.Companion.getAbove-lOKsHw4(), 0f, v4, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1965247803, true, new ToggleableAppBarItem$AppbarContent$1(this), v4, 54), TooltipKt.rememberTooltipState(false, false, null, v4, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(694023085, true, new ToggleableAppBarItem$AppbarContent$2(this), v4, 54), v4, 0x6000030, 0xF8);
            v4 = v4;
            if(!ComposerKt.isTraceInProgress()) {
                goto label_69;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v4.skipToGroupEnd();
        }

    label_69:
        ScopeUpdateScope v14_1 = v4.endRestartGroup();
        if(v14_1 != null) {
            v14_1.updateScope(new ToggleableAppBarItem$$ExternalSyntheticLambda2(this, arg15));
        }
    }

    static final Unit AppbarContent$lambda$0(ToggleableAppBarItem arg0, int arg1, Composer arg2, int arg3) {
        arg0.AppbarContent(arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    public void MenuContent(AppBarMenuState arg17, Composer arg18, int arg19) {
        int v4;
        ToggleableAppBarItem v0 = this;
        AppBarMenuState v1 = arg17;
        int v2 = arg19;
        int v3 = 0xB939EF1B;
        Composer v13 = arg18.startRestartGroup(v3);
        ComposerKt.sourceInformation(v13, "C(MenuContent)N(state)214@6879L15,215@6918L89,212@6811L207:AppBarDsl.kt#uh7d8r");
        int v5 = 4;
        if((v2 & 6) == 0) {
            v4 = v13.changed(v1) ? v5 : 2;
            v4 |= v2;
        }
        else {
            v4 = v2;
        }

        int v7 = 0x20;
        if((v2 & 0x30) == 0) {
            int v6 = v13.changed(v0) ? v7 : 16;
            v4 |= v6;
        }

        boolean v6_1 = (v4 & 19) != 18 ? true : false;
        if(v13.shouldExecute(v6_1, v4 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v4, -1, "androidx.compose.material3.ToggleableAppBarItem.MenuContent (AppBarDsl.kt:211)");
            }

            v3 = 0;
            boolean v9 = v0.enabled;
            ComposableLambda v6_2 = ComposableLambdaKt.rememberComposableLambda(0xEFEDE54B, true, new ToggleableAppBarItem$MenuContent$1(v0), v13, 54);
            ComposerKt.sourceInformationMarkerStart(v13, 1383770996, "CC(remember):AppBarDsl.kt#9igjgp");
            v7 = (v4 & 0x70) == v7 ? 1 : 0;
            if((v4 & 14) == v5) {
                v3 = 1;
            }

            Object v4_1 = v13.rememberedValue();
            if((v3 | v7) != 0 || v4_1 == Composer.Companion.getEmpty()) {
                ToggleableAppBarItem$$ExternalSyntheticLambda0 v4_2 = new ToggleableAppBarItem$$ExternalSyntheticLambda0(v0, v1);
                v13.updateRememberedValue(v4_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v13);
            AndroidMenu_androidKt.DropdownMenuItem(v6_2, v4_1, null, null, null, v9, null, null, null, v13, 6, 476);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_88;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v13.skipToGroupEnd();
        }

    label_88:
        ScopeUpdateScope v3_1 = v13.endRestartGroup();
        if(v3_1 != null) {
            v3_1.updateScope(new ToggleableAppBarItem$$ExternalSyntheticLambda1(v0, v1, v2));
        }
    }

    static final Unit MenuContent$lambda$2$lambda$1(ToggleableAppBarItem arg1, AppBarMenuState arg2) {
        arg1.onCheckedChange.invoke(Boolean.valueOf(arg1.checked ^ 1));
        arg2.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit MenuContent$lambda$3(ToggleableAppBarItem arg0, AppBarMenuState arg1, int arg2, Composer arg3, int arg4) {
        arg0.MenuContent(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final boolean access$getChecked$p(ToggleableAppBarItem arg0) {
        return arg0.checked;
    }

    public static final boolean access$getEnabled$p(ToggleableAppBarItem arg0) {
        return arg0.enabled;
    }

    public static final Function2 access$getIcon$p(ToggleableAppBarItem arg0) {
        return arg0.icon;
    }

    public static final String access$getLabel$p(ToggleableAppBarItem arg0) {
        return arg0.label;
    }

    public static final Function1 access$getOnCheckedChange$p(ToggleableAppBarItem arg0) {
        return arg0.onCheckedChange;
    }
}

