package com.TryJeanPc.goldenmouse.service;

import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import com.TryJeanPc.goldenmouse.ui.WindowFocusPolicy;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0012\u0010\u0000\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0002\u001A\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007\u001A\u000E\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\t"}, d2={"owner", "Lcom/TryJeanPc/goldenmouse/service/SessionOverlayWindows;", "context", "Landroid/content/Context;", "showSessionDialog", "", "dialog", "Landroid/app/Dialog;", "hideSessionDialog", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class SessionOverlayWindowsKt {
    public static final void hideSessionDialog(Dialog arg2) {
        Intrinsics.checkNotNullParameter(arg2, "dialog");
        Context v0 = arg2.getContext();
        Intrinsics.checkNotNullExpressionValue(v0, "getContext(...)");
        SessionOverlayWindows v0_1 = SessionOverlayWindowsKt.owner(v0);
        if(v0_1 == null) {
            arg2.hide();
            return;
        }

        v0_1.hide(arg2);
    }

    private static final SessionOverlayWindows owner(Context arg3) {
        Context v1;
        Set v0 = Collections.newSetFromMap(new IdentityHashMap());
        while(true) {
            v1 = null;
            if(arg3 != null && (v0.add(arg3))) {
                if((arg3 instanceof SessionOverlayHost)) {
                    return ((SessionOverlayHost)arg3).getSessionOverlayWindows();
                }
                else {
                    if((arg3 instanceof ContextWrapper)) {
                    }
                    else {
                        arg3 = v1;
                    }

                    if(arg3 != null) {
                        arg3 = ((ContextWrapper)arg3).getBaseContext();
                        continue;
                    }

                    arg3 = v1;
                    continue;
                }
            }

            break;
        }

        return ((SessionOverlayWindows)v1);
    }

    public static final void showSessionDialog(Dialog arg2) {
        Intrinsics.checkNotNullParameter(arg2, "dialog");
        Context v0 = arg2.getContext();
        Intrinsics.checkNotNullExpressionValue(v0, "getContext(...)");
        SessionOverlayWindows v0_1 = SessionOverlayWindowsKt.owner(v0);
        if(v0_1 == null) {
            WindowFocusPolicy.INSTANCE.prepare(arg2);
            arg2.show();
            return;
        }

        v0_1.show(arg2);
    }
}

