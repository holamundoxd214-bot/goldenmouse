package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\f\n\u0000\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0080\u0080\u0004¨\u0006\u0003"}, d2={"titlecaseImpl", "", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class _OneToManyTitlecaseMappingsKt {
    public static final String titlecaseImpl(char arg4) {
        String v0 = String.valueOf(arg4);
        String v1 = "null cannot be cast to non-null type java.lang.String";
        Intrinsics.checkNotNull(v0, v1);
        v0 = v0.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(v0, "toUpperCase(...)");
        if(v0.length() > 1) {
            if(arg4 == 329) {
                return v0;
            }

            arg4 = v0.charAt(0);
            Intrinsics.checkNotNull(v0, v1);
            v0 = v0.substring(1);
            Intrinsics.checkNotNullExpressionValue(v0, "substring(...)");
            Intrinsics.checkNotNull(v0, v1);
            v0 = v0.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(v0, "toLowerCase(...)");
            return arg4 + v0;
        }

        return String.valueOf(Character.toTitleCase(arg4));
    }
}

