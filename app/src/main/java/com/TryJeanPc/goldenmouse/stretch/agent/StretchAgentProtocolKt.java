package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000¨\u0006\u0004"}, d2={"validAgentText", "", "value", "", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class StretchAgentProtocolKt {
    public static final boolean validAgentText(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "value");
        String v0 = arg3;
        if(!StringsKt.isBlank(((CharSequence)v0)) && arg3.length() <= 0x80) {
            int v3 = 0;
            while(true) {
                if(v3 >= ((CharSequence)v0).length()) {
                    return 1;
                }
                else if(Character.isISOControl(((CharSequence)v0).charAt(v3))) {
                }
                else {
                    ++v3;
                    continue;
                }

                return 0;
            }

            return 1;
        }

        return 0;
    }
}

