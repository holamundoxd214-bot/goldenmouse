package com.TryJeanPc.goldenmouse.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000¨\u0006\u0004"}, d2={"validGraphicsPackage", "", "value", "", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class GraphicsProfileKt {
    public static final boolean validGraphicsPackage(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        if(arg2.length() <= 0xFF && (new Regex("[A-Za-z0-9_]+(\\.[A-Za-z0-9_]+)+").matches(((CharSequence)arg2)))) {
            return 1;
        }

        return 0;
    }
}

