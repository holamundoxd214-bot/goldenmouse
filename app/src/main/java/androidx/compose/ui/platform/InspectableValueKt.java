package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A5\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u0019\b\u0004\u0010\r\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086\b\u001AA\u0010\u000E\u001A\u00020\u000F*\u00020\u000F2\u0019\b\b\u0010\u0010\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u0017\u0010\u0011\u001A\u0013\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u000F0\u0001¢\u0006\u0002\b\u0004H\u0087\b\u001A-\u0010\u0012\u001A\u00020\u000F*\u00020\u000F2\u0017\u0010\u0010\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\u0006\u0010\u0013\u001A\u00020\u000FH\u0001\"\"\u0010\u0000\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u001A\u0010\u0007\u001A\u00020\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000B¨\u0006\u0014"}, d2={"NoInspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "getNoInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "isDebugInspectorInfoEnabled", "", "()Z", "setDebugInspectorInfoEnabled", "(Z)V", "debugInspectorInfo", "definitions", "inspectable", "Landroidx/compose/ui/Modifier;", "inspectorInfo", "factory", "inspectableWrapper", "wrapped", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InspectableValueKt {
    private static final Function1 NoInspectorInfo;
    private static boolean isDebugInspectorInfoEnabled;

    static {
        InspectableValueKt.NoInspectorInfo = InspectableValueKt$NoInspectorInfo$1.INSTANCE;
    }

    public static final Function1 debugInspectorInfo(Function1 arg1) {
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            return new InspectableValueKt$debugInspectorInfo$1(arg1);
        }

        return InspectableValueKt.getNoInspectorInfo();
    }

    public static final Function1 getNoInspectorInfo() {
        return InspectableValueKt.NoInspectorInfo;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="This API will create more invalidations of your modifier than necessary, so it\'s use is discouraged. Implementing the inspectableProperties method on ModifierNodeElement is the recommended zero-cost alternative to exposing properties on a Modifier to tooling.") public static final Modifier inspectable(Modifier arg1, Function1 arg2, Function1 arg3) {
        return InspectableValueKt.inspectableWrapper(arg1, arg2, arg3.invoke(Modifier.Companion));
    }

    public static final Modifier inspectableWrapper(Modifier arg1, Function1 arg2, Modifier arg3) {
        InspectableModifier v0 = new InspectableModifier(arg2);
        return arg1.then(v0).then(arg3).then(v0.getEnd());
    }

    public static final boolean isDebugInspectorInfoEnabled() {
        return InspectableValueKt.isDebugInspectorInfoEnabled;
    }

    public static final void setDebugInspectorInfoEnabled(boolean arg0) {
        InspectableValueKt.isDebugInspectorInfoEnabled = arg0;
    }
}

