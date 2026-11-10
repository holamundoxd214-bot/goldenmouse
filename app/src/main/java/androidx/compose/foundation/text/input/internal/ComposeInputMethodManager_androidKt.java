package androidx.compose.foundation.text.input.internal;

import android.os.Build$VERSION;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000\u001A(\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005H\u0001\"\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"ComposeInputMethodManager", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "view", "Landroid/view/View;", "ComposeInputMethodManagerFactory", "Lkotlin/Function1;", "overrideComposeInputMethodManagerFactoryForTests", "factory", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ComposeInputMethodManager_androidKt {
    private static Function1 ComposeInputMethodManagerFactory;

    static {
        ComposeInputMethodManager_androidKt.ComposeInputMethodManagerFactory = new ComposeInputMethodManager_androidKt$$ExternalSyntheticLambda0();
    }

    public static final ComposeInputMethodManager ComposeInputMethodManager(View arg1) {
        return ComposeInputMethodManager_androidKt.ComposeInputMethodManagerFactory.invoke(arg1);
    }

    static final ComposeInputMethodManager ComposeInputMethodManagerFactory$lambda$0(View arg2) {
        if(Build$VERSION.SDK_INT >= 34) {
            return new ComposeInputMethodManagerImplApi34(arg2);
        }

        return new ComposeInputMethodManagerImplApi24(arg2);
    }

    public static final Function1 overrideComposeInputMethodManagerFactoryForTests(Function1 arg1) {
        Function1 v0 = ComposeInputMethodManager_androidKt.ComposeInputMethodManagerFactory;
        ComposeInputMethodManager_androidKt.ComposeInputMethodManagerFactory = arg1;
        return v0;
    }
}

