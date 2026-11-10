package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u000E\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t2\u000E\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\t¢\u0006\u0002\u0010\f¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchPhysicalDisplayIdentity;", "", "<init>", "()V", "resolve", "", "api", "", "address", "Lkotlin/Function0;", "uniqueId", "", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Long;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchPhysicalDisplayIdentity {
    public static final int $stable;
    public static final StretchPhysicalDisplayIdentity INSTANCE;

    static {
        StretchPhysicalDisplayIdentity.INSTANCE = new StretchPhysicalDisplayIdentity();
    }

    private StretchPhysicalDisplayIdentity() {
        super();
    }

    public final Long resolve(int arg4, Function0 arg5, Function0 arg6) {
        String v3 = "local:";
        Intrinsics.checkNotNullParameter(arg5, "address");
        Intrinsics.checkNotNullParameter(arg6, "uniqueId");
        try {
            Object v5 = arg5.invoke();
            if(v5 == null) {
                goto label_10;
            }

            Long v3_1 = Long.valueOf(((Number)v5).longValue());
            return v3_1;
        }
        catch(Exception ) {
        label_10:
            Long v0 = null;
            if(arg4 < 29) {
                return v0;
            }

            try {
                Object v4 = arg6.invoke();
                if(v4 == null) {
                    return v0;
                }

                int v5_1 = 2;
                if(StringsKt.startsWith$default(((String)v4), v3, false, v5_1, v0)) {
                    if(((String)v4).length() > 26) {
                    }
                    else {
                        v3 = StringsKt.removePrefix(((String)v4), ((CharSequence)v3));
                        long v4_1 = StringsKt.startsWith$default(v3, "-", false, v5_1, v0) ? Long.parseLong(v3) : Long.parseUnsignedLong(v3);
                        if(!Intrinsics.areEqual(v3, String.valueOf(v4_1)) && !Intrinsics.areEqual(v3, Long.toUnsignedString(v4_1))) {
                            return v0;
                        }

                        v0 = Long.valueOf(v4_1);
                    }
                }

                return v0;
            }
            catch(Exception ) {
                return v0;
            }
        }
    }
}

