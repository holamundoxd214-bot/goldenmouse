package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001A%\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0007¨\u0006\u0007"}, d2={"modifierLocalConsumer", "Landroidx/compose/ui/Modifier;", "consumer", "Lkotlin/Function1;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "", "Lkotlin/ExtensionFunctionType;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ModifierLocalConsumerKt {
    public static final Modifier modifierLocalConsumer(Modifier arg2, Function1 arg3) {
        Function1 v1_1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            ModifierLocalConsumerKt$modifierLocalConsumer$$inlined$debugInspectorInfo$1 v1 = new ModifierLocalConsumerKt$modifierLocalConsumer$$inlined$debugInspectorInfo$1(arg3);
        }
        else {
            v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return arg2.then(new ModifierLocalConsumerImpl(arg3, v1_1));
    }
}

