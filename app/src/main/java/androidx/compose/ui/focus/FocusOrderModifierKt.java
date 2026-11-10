package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A%\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0007\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\bH\u0007\u001A-\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001A\u00020\b2\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0007¨\u0006\t"}, d2={"focusOrder", "Landroidx/compose/ui/Modifier;", "focusOrderReceiver", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusOrder;", "", "Lkotlin/ExtensionFunctionType;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusOrderModifierKt {
    @Deprecated(message="Use focusRequester() instead", replaceWith="<_subannotation>") public static final Modifier focusOrder(Modifier arg0, FocusRequester arg1) {
        return FocusRequesterModifierKt.focusRequester(arg0, arg1);
    }

    @Deprecated(message="Use focusProperties() and focusRequester() instead", replaceWith="<_subannotation>") public static final Modifier focusOrder(Modifier arg1, FocusRequester arg2, Function1 arg3) {
        return FocusPropertiesKt.focusProperties(FocusRequesterModifierKt.focusRequester(arg1, arg2), new FocusOrderModifierKt$focusOrder$2(new FocusOrderToProperties(arg3)));
    }

    @Deprecated(message="Use focusProperties() instead", replaceWith="<_subannotation>") public static final Modifier focusOrder(Modifier arg1, Function1 arg2) {
        return FocusPropertiesKt.focusProperties(arg1, new FocusOrderModifierKt$focusOrder$1(new FocusOrderToProperties(arg2)));
    }
}

