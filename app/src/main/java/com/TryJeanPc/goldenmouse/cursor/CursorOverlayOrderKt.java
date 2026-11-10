package com.TryJeanPc.goldenmouse.cursor;

import android.content.Context;
import android.content.ContextWrapper;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u000E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003¨\u0006\u0004"}, d2={"bringCursorAboveWindow", "", "context", "Landroid/content/Context;", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class CursorOverlayOrderKt {
    public static final void bringCursorAboveWindow(Context arg3) {
        Intrinsics.checkNotNullParameter(arg3, "context");
        Set v0 = Collections.newSetFromMap(new IdentityHashMap());
        while(arg3 != null) {
            if(!v0.add(arg3)) {
                return;
            }

            if((arg3 instanceof CursorOverlayHost)) {
                ((CursorOverlayHost)arg3).bringCursorToFront();
                return;
            }
            else {
                Context v2 = null;
                if((arg3 instanceof ContextWrapper)) {
                }
                else {
                    arg3 = v2;
                }

                if(arg3 != null) {
                    arg3 = ((ContextWrapper)arg3).getBaseContext();
                    continue;
                }

                arg3 = v2;
                continue;
            }

            return;
        }
    }
}

