package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001A\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/material3/DefaultNavigationBarOverride;", "Landroidx/compose/material3/NavigationBarOverride;", "<init>", "()V", "NavigationBar", "", "Landroidx/compose/material3/NavigationBarOverrideScope;", "(Landroidx/compose/material3/NavigationBarOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DefaultNavigationBarOverride implements NavigationBarOverride {
    public static final int $stable;
    public static final DefaultNavigationBarOverride INSTANCE;

    static {
        DefaultNavigationBarOverride.INSTANCE = new DefaultNavigationBarOverride();
    }

    private DefaultNavigationBarOverride() {
        super();
    }

    public void NavigationBar(NavigationBarOverrideScope arg17, Composer arg18, int arg19) {
        int v3;
        NavigationBarOverrideScope v0 = arg17;
        int v1 = arg19;
        int v2 = 882141204;
        Composer v13 = arg18.startRestartGroup(v2);
        ComposerKt.sourceInformation(v13, "C(NavigationBar)145@6463L486,140@6289L660:NavigationBar.kt#uh7d8r");
        int v4 = 2;
        if((v1 & 6) == 0) {
            v3 = v13.changed(v0) ? 4 : v4;
            v3 |= v1;
        }
        else {
            v3 = v1;
        }

        boolean v4_1 = (v3 & 3) != v4 ? true : false;
        if(v13.shouldExecute(v4_1, v3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v3, -1, "androidx.compose.material3.DefaultNavigationBarOverride.NavigationBar (NavigationBar.kt:139)");
            }

            SurfaceKt.Surface-T9BRK9s(v0.getModifier(), null, v0.getContainerColor-0d7_KjU(), v0.getContentColor-0d7_KjU(), v0.getTonalElevation-D9Ej5fM(), 0f, null, ComposableLambdaKt.rememberComposableLambda(0x76B04459, true, new DefaultNavigationBarOverride$NavigationBar$1(v0), v13, 54), v13, 0xC00000, 98);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_55;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v13.skipToGroupEnd();
        }

    label_55:
        ScopeUpdateScope v2_1 = v13.endRestartGroup();
        if(v2_1 != null) {
            v2_1.updateScope(new DefaultNavigationBarOverride$$ExternalSyntheticLambda0(this, v0, v1));
        }
    }

    static final Unit NavigationBar$lambda$0(DefaultNavigationBarOverride arg0, NavigationBarOverrideScope arg1, int arg2, Composer arg3, int arg4) {
        arg0.NavigationBar(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }
}

