package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001\u001A\u0012\u0010\u0003\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001\u001A\u0012\u0010\u0004\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001\u001A\u0019\u0010\u0005\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\t\u001A\u0011\u0010\n\u001A\u00020\u000B*\u00020\u0001H\u0007¢\u0006\u0002\u0010\f\u001A\u0012\u0010\n\u001A\u00020\u000B*\u00020\u00012\u0006\u0010\r\u001A\u00020\u000E\u001A\f\u0010\u000F\u001A\u00020\u0001*\u00020\u000BH\u0000\u001A\u0006\u0010\u0010\u001A\u00020\u0001\u001A.\u0010\u0010\u001A\u00020\u00012\b\b\u0002\u0010\u0011\u001A\u00020\u00122\b\b\u0002\u0010\u0013\u001A\u00020\u00122\b\b\u0002\u0010\u0014\u001A\u00020\u00122\b\b\u0002\u0010\u0015\u001A\u00020\u0012\u001A5\u0010\u0010\u001A\u00020\u00012\b\b\u0002\u0010\u0011\u001A\u00020\u00162\b\b\u0002\u0010\u0013\u001A\u00020\u00162\b\b\u0002\u0010\u0014\u001A\u00020\u00162\b\b\u0002\u0010\u0015\u001A\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018\"\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"union", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "exclude", "add", "only", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "only-bOOhFvg", "(Landroidx/compose/foundation/layout/WindowInsets;I)Landroidx/compose/foundation/layout/WindowInsets;", "asPaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/PaddingValues;", "density", "Landroidx/compose/ui/unit/Density;", "asInsets", "WindowInsets", "left", "", "top", "right", "bottom", "Landroidx/compose/ui/unit/Dp;", "WindowInsets-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/WindowInsets;", "EmptyWindowInsets", "Landroidx/compose/foundation/layout/FixedIntInsets;", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WindowInsetsKt {
    private static final FixedIntInsets EmptyWindowInsets;

    static {
        WindowInsetsKt.EmptyWindowInsets = new FixedIntInsets(0, 0, 0, 0);
    }

    public static final WindowInsets WindowInsets() {
        return WindowInsetsKt.EmptyWindowInsets;
    }

    public static final WindowInsets WindowInsets(int arg1, int arg2, int arg3, int arg4) {
        return new FixedIntInsets(arg1, arg2, arg3, arg4);
    }

    public static WindowInsets WindowInsets$default(int arg1, int arg2, int arg3, int arg4, int arg5, Object arg6) {
        return WindowInsetsKt.WindowInsets(0, 0, 0, 0);
    }

    public static final WindowInsets WindowInsets-a9UjIt4(float arg6, float arg7, float arg8, float arg9) {
        return new FixedDpInsets(arg6, arg7, arg8, arg9, null);
    }

    public static WindowInsets WindowInsets-a9UjIt4$default(float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = Dp.constructor-impl(0f);
        }

        if((arg5 & 2) != 0) {
            arg2 = Dp.constructor-impl(0f);
        }

        if((arg5 & 4) != 0) {
            arg3 = Dp.constructor-impl(0f);
        }

        if((arg5 & 8) != 0) {
            arg4 = Dp.constructor-impl(0f);
        }

        return WindowInsetsKt.WindowInsets-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public static final WindowInsets add(WindowInsets arg1, WindowInsets arg2) {
        return new AddedInsets(arg1, arg2);
    }

    public static final WindowInsets asInsets(PaddingValues arg1) {
        return new PaddingValuesInsets(arg1);
    }

    public static final PaddingValues asPaddingValues(WindowInsets arg3, Composer arg4, int arg5) {
        int v1 = -1485016250;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(asPaddingValues)221@9118L7:WindowInsets.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.foundation.layout.asPaddingValues (WindowInsets.kt:221)");
        }

        ProvidableCompositionLocal v0 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0_1 = arg4.consume(((CompositionLocal)v0));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        InsetsPaddingValues v5 = new InsetsPaddingValues(arg3, ((Density)v0_1));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return ((PaddingValues)v5);
    }

    public static final PaddingValues asPaddingValues(WindowInsets arg1, Density arg2) {
        return new InsetsPaddingValues(arg1, arg2);
    }

    public static final WindowInsets exclude(WindowInsets arg1, WindowInsets arg2) {
        return new ExcludeInsets(arg1, arg2);
    }

    public static final WindowInsets only-bOOhFvg(WindowInsets arg2, int arg3) {
        return new LimitInsets(arg2, arg3, null);
    }

    public static final WindowInsets union(WindowInsets arg1, WindowInsets arg2) {
        return new UnionInsets(arg1, arg2);
    }
}

