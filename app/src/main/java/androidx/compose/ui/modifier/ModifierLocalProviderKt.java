package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A,\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006¨\u0006\u0007"}, d2={"modifierLocalProvider", "Landroidx/compose/ui/Modifier;", "T", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "Lkotlin/Function0;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ModifierLocalProviderKt {
    public static final Modifier modifierLocalProvider(Modifier arg2, ProvidableModifierLocal arg3, Function0 arg4) {
        ModifierLocalProviderKt$modifierLocalProvider$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new ModifierLocalProviderKt$modifierLocalProvider$$inlined$debugInspectorInfo$1(arg3, arg4);
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg2.then(new ModifierLocalProviderKt$modifierLocalProvider$1(arg3, arg4, ((Function1)v0)));
    }
}

