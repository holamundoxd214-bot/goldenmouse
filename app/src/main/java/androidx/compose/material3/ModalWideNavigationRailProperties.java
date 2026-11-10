package androidx.compose.material3;

import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0013\b\u0016\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\bJ\u0013\u0010\r\u001A\u00020\u00052\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000F\u001A\u00020\u0010H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0011"}, d2={"Landroidx/compose/material3/ModalWideNavigationRailProperties;", "", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "shouldDismissOnBackPress", "", "<init>", "(Landroidx/compose/ui/window/SecureFlagPolicy;Z)V", "(Z)V", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getShouldDismissOnBackPress", "()Z", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ModalWideNavigationRailProperties {
    public static final int $stable;
    private final SecureFlagPolicy securePolicy;
    private final boolean shouldDismissOnBackPress;

    static {
    }

    public ModalWideNavigationRailProperties() {
        this(null, false, 3, null);
    }

    public ModalWideNavigationRailProperties(SecureFlagPolicy arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = SecureFlagPolicy.Inherit;
        }

        this(arg1, true);
    }

    public ModalWideNavigationRailProperties(SecureFlagPolicy arg1, boolean arg2) {
        super();
        this.securePolicy = arg1;
        this.shouldDismissOnBackPress = arg2;
    }

    public ModalWideNavigationRailProperties(boolean arg2) {
        this(SecureFlagPolicy.Inherit, arg2);
    }

    public ModalWideNavigationRailProperties(boolean arg1, int arg2, DefaultConstructorMarker arg3) {
        this(true);
    }

    public boolean equals(Object arg4) {
        if(this == (((ModalWideNavigationRailProperties)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof ModalWideNavigationRailProperties)) {
            return 0;
        }

        if(this.securePolicy != ((ModalWideNavigationRailProperties)arg4).securePolicy) {
            return 0;
        }

        return 1;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    public int hashCode() {
        return this.securePolicy.hashCode() * 0x1F + Boolean.hashCode(this.shouldDismissOnBackPress);
    }
}

