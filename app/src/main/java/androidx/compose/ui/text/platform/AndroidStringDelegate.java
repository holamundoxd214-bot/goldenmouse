package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.PlatformStringDelegate;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\n\u0010\u0007\u001A\u00060\bj\u0002`\tH\u0016J\u001C\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\n\u0010\u0007\u001A\u00060\bj\u0002`\tH\u0016J\u001C\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\n\u0010\u0007\u001A\u00060\bj\u0002`\tH\u0016J\u001C\u0010\f\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\n\u0010\u0007\u001A\u00060\bj\u0002`\tH\u0016¨\u0006\r"}, d2={"Landroidx/compose/ui/text/platform/AndroidStringDelegate;", "Landroidx/compose/ui/text/PlatformStringDelegate;", "<init>", "()V", "toUpperCase", "", "string", "locale", "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "toLowerCase", "capitalize", "decapitalize", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidStringDelegate implements PlatformStringDelegate {
    public static final int $stable;

    static {
    }

    public AndroidStringDelegate() {
        super();
    }

    public String capitalize(String arg3, Locale arg4) {
        if(arg3.length() > 0) {
            StringBuilder v2 = new StringBuilder();
            char v0 = arg3.charAt(0);
            String v4 = Character.isLowerCase(v0) ? CharsKt.titlecase(v0, arg4) : String.valueOf(v0);
            v2 = v2.append(v4);
            arg3 = arg3.substring(1);
            Intrinsics.checkNotNullExpressionValue(arg3, "substring(...)");
            return v2.append(arg3).toString();
        }

        return arg3;
    }

    public String decapitalize(String arg2, Locale arg3) {
        if(arg2.length() > 0) {
            StringBuilder v1 = new StringBuilder().append(CharsKt.lowercase(arg2.charAt(0), arg3));
            arg2 = arg2.substring(1);
            Intrinsics.checkNotNullExpressionValue(arg2, "substring(...)");
            return v1.append(arg2).toString();
        }

        return arg2;
    }

    public String toLowerCase(String arg1, Locale arg2) {
        String v0 = arg1.toLowerCase(arg2);
        Intrinsics.checkNotNullExpressionValue(v0, "toLowerCase(...)");
        return v0;
    }

    public String toUpperCase(String arg1, Locale arg2) {
        String v0 = arg1.toUpperCase(arg2);
        Intrinsics.checkNotNullExpressionValue(v0, "toUpperCase(...)");
        return v0;
    }
}

