package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001A\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/material3/DefaultWideNavigationRailOverride;", "Landroidx/compose/material3/WideNavigationRailOverride;", "<init>", "()V", "WideNavigationRail", "", "Landroidx/compose/material3/WideNavigationRailOverrideScope;", "(Landroidx/compose/material3/WideNavigationRailOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DefaultWideNavigationRailOverride implements WideNavigationRailOverride {
    public static final int $stable;
    public static final DefaultWideNavigationRailOverride INSTANCE;

    static {
        DefaultWideNavigationRailOverride.INSTANCE = new DefaultWideNavigationRailOverride();
    }

    private DefaultWideNavigationRailOverride() {
        super();
    }

    public void WideNavigationRail(WideNavigationRailOverrideScope arg13, Composer arg14, int arg15) {
        int v14_1;
        int v0 = 0x92F3A84E;
        Composer v10 = arg14.startRestartGroup(v0);
        ComposerKt.sourceInformation(v10, "C(WideNavigationRail)193@9224L346:WideNavigationRail.kt#uh7d8r");
        int v1 = 2;
        if((arg15 & 6) == 0) {
            boolean v14 = (arg15 & 8) == 0 ? v10.changed(arg13) : v10.changedInstance(arg13);
            v14_1 = v14 ? 4 : v1;
            v14_1 |= arg15;
        }
        else {
            v14_1 = arg15;
        }

        boolean v1_1 = (v14_1 & 3) != v1 ? true : false;
        if(v10.shouldExecute(v1_1, v14_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v14_1, -1, "androidx.compose.material3.DefaultWideNavigationRailOverride.WideNavigationRail (WideNavigationRail.kt:192)");
            }

            WideNavigationRailKt.access$WideNavigationRailLayout(arg13.getModifier(), false, WideNavigationRailStateKt.isExpanded(arg13.getState().getTargetValue()), arg13.getColors(), arg13.getShape(), arg13.getHeader(), arg13.getWindowInsets(), arg13.getArrangement(), arg13.getContent(), v10, 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_50;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v10.skipToGroupEnd();
        }

    label_50:
        ScopeUpdateScope v14_2 = v10.endRestartGroup();
        if(v14_2 != null) {
            v14_2.updateScope(new DefaultWideNavigationRailOverride$$ExternalSyntheticLambda0(this, arg13, arg15));
        }
    }

    static final Unit WideNavigationRail$lambda$0(DefaultWideNavigationRailOverride arg0, WideNavigationRailOverrideScope arg1, int arg2, Composer arg3, int arg4) {
        arg0.WideNavigationRail(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }
}

