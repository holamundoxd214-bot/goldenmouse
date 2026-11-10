package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A)\u0010\u0000\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004*\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001H\u0002\u001A#\u0010\u0007\u001A\u00020\b*\u00020\b2\u0017\u0010\t\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¨\u0006\u000B"}, d2={"toUsingEnterExitScope", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/focus/FocusDirection;", "Landroidx/compose/ui/focus/FocusRequester;", "focusProperties", "Landroidx/compose/ui/Modifier;", "scope", "Landroidx/compose/ui/focus/FocusProperties;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusPropertiesKt {
    public static final Function1 access$toUsingEnterExitScope(Function1 arg0) {
        return FocusPropertiesKt.toUsingEnterExitScope(arg0);
    }

    public static final Modifier focusProperties(Modifier arg2, Function1 arg3) {
        return arg2.then(new FocusPropertiesElement(new FocusPropertiesKt$sam$androidx_compose_ui_focus_FocusPropertiesScope$0(arg3)));
    }

    private static final Function1 toUsingEnterExitScope(Function1 arg1) {
        return new FocusPropertiesKt$toUsingEnterExitScope$1(arg1);
    }
}

