package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B8\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0011\u0010\u0005\u001A\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\r\u0010\u000E\u001A\u00020\u0004H\u0017¢\u0006\u0002\u0010\u000FJ\u0015\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0012H\u0017¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001B\u0010\u0005\u001A\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/material3/ClickableAppBarItem;", "Landroidx/compose/material3/AppBarItem;", "onClick", "Lkotlin/Function0;", "", "icon", "Landroidx/compose/runtime/Composable;", "enabled", "", "label", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;ZLjava/lang/String;)V", "Lkotlin/jvm/functions/Function2;", "AppbarContent", "(Landroidx/compose/runtime/Composer;I)V", "MenuContent", "state", "Landroidx/compose/material3/AppBarMenuState;", "(Landroidx/compose/material3/AppBarMenuState;Landroidx/compose/runtime/Composer;I)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ClickableAppBarItem implements AppBarItem {
    public static final int $stable;
    private final boolean enabled;
    private final Function2 icon;
    private final String label;
    private final Function0 onClick;

    static {
    }

    public ClickableAppBarItem(Function0 arg1, Function2 arg2, boolean arg3, String arg4) {
        super();
        this.onClick = arg1;
        this.icon = arg2;
        this.enabled = arg3;
        this.label = arg4;
    }

    public void AppbarContent(Composer arg14, int arg15) {
        int v14;
        int v0 = -1170649368;
        Composer v4 = arg14.startRestartGroup(v0);
        ComposerKt.sourceInformation(v4, "C(AppbarContent)162@5298L60,163@5382L32,164@5436L22,165@5470L88,160@5223L335:AppBarDsl.kt#uh7d8r");
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
                ComposerKt.traceEventStart(v0, v14, -1, "androidx.compose.material3.ClickableAppBarItem.AppbarContent (AppBarDsl.kt:158)");
            }

            TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.rememberTooltipPositionProvider-Hu5FAss(TooltipAnchorPosition.Companion.getAbove-lOKsHw4(), 0f, v4, 390, 2), ComposableLambdaKt.rememberComposableLambda(0xCF524853, true, new ClickableAppBarItem$AppbarContent$1(this), v4, 54), TooltipKt.rememberTooltipState(false, false, null, v4, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-592360853, true, new ClickableAppBarItem$AppbarContent$2(this), v4, 54), v4, 0x6000030, 0xF8);
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
            v14_1.updateScope(new ClickableAppBarItem$$ExternalSyntheticLambda2(this, arg15));
        }
    }

    static final Unit AppbarContent$lambda$0(ClickableAppBarItem arg0, int arg1, Composer arg2, int arg3) {
        arg0.AppbarContent(arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    public void MenuContent(AppBarMenuState arg17, Composer arg18, int arg19) {
        int v4;
        ClickableAppBarItem v0 = this;
        AppBarMenuState v1 = arg17;
        int v2 = arg19;
        int v3 = 0xD0D1293D;
        Composer v13 = arg18.startRestartGroup(v3);
        ComposerKt.sourceInformation(v13, "C(MenuContent)N(state)174@5713L15,175@5752L73,172@5645L191:AppBarDsl.kt#uh7d8r");
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
                ComposerKt.traceEventStart(v3, v4, -1, "androidx.compose.material3.ClickableAppBarItem.MenuContent (AppBarDsl.kt:171)");
            }

            v3 = 0;
            boolean v9 = v0.enabled;
            ComposableLambda v6_2 = ComposableLambdaKt.rememberComposableLambda(900574477, true, new ClickableAppBarItem$MenuContent$1(v0), v13, 54);
            ComposerKt.sourceInformationMarkerStart(v13, 0xE12BE506, "CC(remember):AppBarDsl.kt#9igjgp");
            v7 = (v4 & 0x70) == v7 ? 1 : 0;
            if((v4 & 14) == v5) {
                v3 = 1;
            }

            Object v4_1 = v13.rememberedValue();
            if((v3 | v7) != 0 || v4_1 == Composer.Companion.getEmpty()) {
                ClickableAppBarItem$$ExternalSyntheticLambda0 v4_2 = new ClickableAppBarItem$$ExternalSyntheticLambda0(v0, v1);
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
            v3_1.updateScope(new ClickableAppBarItem$$ExternalSyntheticLambda1(v0, v1, v2));
        }
    }

    static final Unit MenuContent$lambda$2$lambda$1(ClickableAppBarItem arg0, AppBarMenuState arg1) {
        arg0.onClick.invoke();
        arg1.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit MenuContent$lambda$3(ClickableAppBarItem arg0, AppBarMenuState arg1, int arg2, Composer arg3, int arg4) {
        arg0.MenuContent(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    public static final boolean access$getEnabled$p(ClickableAppBarItem arg0) {
        return arg0.enabled;
    }

    public static final Function2 access$getIcon$p(ClickableAppBarItem arg0) {
        return arg0.icon;
    }

    public static final String access$getLabel$p(ClickableAppBarItem arg0) {
        return arg0.label;
    }

    public static final Function0 access$getOnClick$p(ClickableAppBarItem arg0) {
        return arg0.onClick;
    }
}

