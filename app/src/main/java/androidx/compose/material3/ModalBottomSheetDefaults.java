package androidx.compose.material3;

import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u000BH\u0007R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/material3/ModalBottomSheetDefaults;", "", "<init>", "()V", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "getProperties", "()Landroidx/compose/material3/ModalBottomSheetProperties;", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isFocusable", "", "shouldDismissOnBackPress", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ModalBottomSheetDefaults {
    public static final int $stable;
    public static final ModalBottomSheetDefaults INSTANCE;
    private static final ModalBottomSheetProperties properties;

    static {
        ModalBottomSheetDefaults.INSTANCE = new ModalBottomSheetDefaults();
        ModalBottomSheetDefaults.properties = new ModalBottomSheetProperties();
    }

    private ModalBottomSheetDefaults() {
        super();
    }

    public final ModalBottomSheetProperties getProperties() {
        return ModalBottomSheetDefaults.properties;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="\'isFocusable\' param is no longer used. Use value without this parameter.", replaceWith="<_subannotation>") public final ModalBottomSheetProperties properties(SecureFlagPolicy arg7, boolean arg8, boolean arg9) {
        return new ModalBottomSheetProperties(arg7, arg9, false, 4, null);
    }

    public static ModalBottomSheetProperties properties$default(ModalBottomSheetDefaults arg1, SecureFlagPolicy arg2, boolean arg3, boolean arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg2 = SecureFlagPolicy.Inherit;
        }

        return arg1.properties(arg2, true, true);
    }
}

