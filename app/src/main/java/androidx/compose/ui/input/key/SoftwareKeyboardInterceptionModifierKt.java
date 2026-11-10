package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0012\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u001A\u001E\u0010\u0005\u001A\u00020\u0001*\u00020\u00012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¨\u0006\u0006"}, d2={"onInterceptKeyBeforeSoftKeyboard", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreInterceptKeyBeforeSoftKeyboard", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SoftwareKeyboardInterceptionModifierKt {
    public static final Modifier onInterceptKeyBeforeSoftKeyboard(Modifier arg2, Function1 arg3) {
        return arg2.then(new SoftKeyboardInterceptionElement(arg3, null));
    }

    public static final Modifier onPreInterceptKeyBeforeSoftKeyboard(Modifier arg2, Function1 arg3) {
        return arg2.then(new SoftKeyboardInterceptionElement(null, arg3));
    }
}

