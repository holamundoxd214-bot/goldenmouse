package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.inputmethodservice.InputMethodService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2={"Landroidx/window/layout/util/ContextCompatHelper;", "", "<init>", "()V", "unwrapContext", "Landroid/content/Context;", "context", "unwrapContext$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ContextCompatHelper {
    public static final ContextCompatHelper INSTANCE;

    static {
        ContextCompatHelper.INSTANCE = new ContextCompatHelper();
    }

    private ContextCompatHelper() {
        super();
    }

    public final Context unwrapContext$window_release(Context arg3) {
        Context v0;
        Intrinsics.checkNotNullParameter(arg3, "context");
        Context v2 = arg3;
        while((v2 instanceof ContextWrapper)) {
            if((v2 instanceof Activity)) {
            }
            else if((v2 instanceof InputMethodService)) {
            }
            else {
                v0 = v2;
                if(((ContextWrapper)v0).getBaseContext() == null) {
                    return v2;
                }

                goto label_15;
            }

            return v2;
        label_15:
            v2 = ((ContextWrapper)v0).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(v2, "getBaseContext(...)");
        }

        return arg3;
    }
}

