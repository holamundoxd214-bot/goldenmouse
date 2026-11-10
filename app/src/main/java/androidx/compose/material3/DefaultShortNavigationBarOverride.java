package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001A\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2={"Landroidx/compose/material3/DefaultShortNavigationBarOverride;", "Landroidx/compose/material3/ShortNavigationBarOverride;", "<init>", "()V", "ShortNavigationBar", "", "Landroidx/compose/material3/ShortNavigationBarOverrideScope;", "(Landroidx/compose/material3/ShortNavigationBarOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DefaultShortNavigationBarOverride implements ShortNavigationBarOverride {
    public static final int $stable;
    public static final DefaultShortNavigationBarOverride INSTANCE;

    static {
        DefaultShortNavigationBarOverride.INSTANCE = new DefaultShortNavigationBarOverride();
    }

    private DefaultShortNavigationBarOverride() {
        super();
    }

    public void ShortNavigationBar(ShortNavigationBarOverrideScope arg17, Composer arg18, int arg19) {
        int v3;
        ShortNavigationBarOverrideScope v0 = arg17;
        int v1 = arg19;
        int v2 = 0xF44A722;
        Composer v13 = arg18.startRestartGroup(v2);
        ComposerKt.sourceInformation(v13, "C(ShortNavigationBar)123@5671L865,123@5589L947:ShortNavigationBar.kt#uh7d8r");
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
                ComposerKt.traceEventStart(v2, v3, -1, "androidx.compose.material3.DefaultShortNavigationBarOverride.ShortNavigationBar (ShortNavigationBar.kt:122)");
            }

            SurfaceKt.Surface-T9BRK9s(v0.getModifier(), null, v0.getContainerColor-0d7_KjU(), v0.getContentColor-0d7_KjU(), 0f, 0f, null, ComposableLambdaKt.rememberComposableLambda(0xE14AEE7, true, new DefaultShortNavigationBarOverride$ShortNavigationBar$1(v0), v13, 54), v13, 0xC00000, 0x72);
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
            v2_1.updateScope(new DefaultShortNavigationBarOverride$$ExternalSyntheticLambda0(this, v0, v1));
        }
    }

    static final Unit ShortNavigationBar$lambda$0(DefaultShortNavigationBarOverride arg0, ShortNavigationBarOverrideScope arg1, int arg2, Composer arg3, int arg4) {
        arg0.ShortNavigationBar(arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }
}

