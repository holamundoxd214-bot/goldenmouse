package androidx.compose.material3;

import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u001D\b\u0016\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007B\'\b\u0016\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0002\u0010\nB7\b\u0016\u0012\u0006\u0010\u000B\u001A\u00020\u0005\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0002\u0010\rB\u0011\b\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u000EB\u001D\b\u0017\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u000FB-\b\u0017\u0012\u0006\u0010\u000B\u001A\u00020\u0005\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0010J\u0013\u0010\u0019\u001A\u00020\u00052\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001B\u001A\u00020\u001CH\u0016R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001A\u00020\u00058G¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0014R\u0018\u0010\u000B\u001A\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0015\u0010\u0016R\u0018\u0010\f\u001A\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0018\u0010\u0016¨\u0006\u001D"}, d2={"Landroidx/compose/material3/ModalBottomSheetProperties;", "", "<init>", "()V", "shouldDismissOnBackPress", "", "shouldDismissOnClickOutside", "(ZZ)V", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "(Landroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "isAppearanceLightStatusBars", "isAppearanceLightNavigationBars", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "(Z)V", "(Landroidx/compose/ui/window/SecureFlagPolicy;Z)V", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;Z)V", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getShouldDismissOnBackPress", "()Z", "isAppearanceLightStatusBars$material3", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isAppearanceLightNavigationBars$material3", "equals", "other", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ModalBottomSheetProperties {
    public static final int $stable;
    private final Boolean isAppearanceLightNavigationBars;
    private final Boolean isAppearanceLightStatusBars;
    private final SecureFlagPolicy securePolicy;
    private final boolean shouldDismissOnBackPress;
    private final boolean shouldDismissOnClickOutside;

    static {
    }

    public ModalBottomSheetProperties() {
        super();
        this.securePolicy = SecureFlagPolicy.Inherit;
        this.shouldDismissOnBackPress = true;
        this.shouldDismissOnClickOutside = true;
        this.isAppearanceLightStatusBars = null;
        this.isAppearanceLightNavigationBars = null;
    }

    public ModalBottomSheetProperties(SecureFlagPolicy arg2, boolean arg3, boolean arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 1) != 0) {
            arg2 = SecureFlagPolicy.Inherit;
        }

        this(arg2, true, true);
    }

    public ModalBottomSheetProperties(boolean arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
        this(true, true);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use empty constructor or constructor including shouldDismissOnScrimClick param.") public ModalBottomSheetProperties(SecureFlagPolicy arg2, boolean arg3) {
        this(arg2, arg3, true);
    }

    public ModalBottomSheetProperties(SecureFlagPolicy arg1, boolean arg2, boolean arg3) {
        super();
        this.securePolicy = arg1;
        this.shouldDismissOnBackPress = arg2;
        this.shouldDismissOnClickOutside = arg3;
        this.isAppearanceLightNavigationBars = null;
        this.isAppearanceLightStatusBars = null;
    }

    public ModalBottomSheetProperties(SecureFlagPolicy arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = SecureFlagPolicy.Inherit;
        }

        this(arg1, true);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced with additional shouldDismissOnScrimClick param constructor.") public ModalBottomSheetProperties(boolean arg2) {
        this(arg2, true);
    }

    public ModalBottomSheetProperties(boolean arg2, boolean arg3) {
        super();
        this.securePolicy = SecureFlagPolicy.Inherit;
        this.shouldDismissOnBackPress = arg2;
        this.shouldDismissOnClickOutside = arg3;
        this.isAppearanceLightNavigationBars = null;
        this.isAppearanceLightStatusBars = null;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use empty constructor or constructor including shouldDismissOnScrimClick param.") public ModalBottomSheetProperties(boolean arg1, boolean arg2, SecureFlagPolicy arg3, boolean arg4) {
        super();
        this.shouldDismissOnBackPress = arg4;
        this.shouldDismissOnClickOutside = true;
        this.securePolicy = arg3;
        this.isAppearanceLightStatusBars = Boolean.valueOf(arg1);
        this.isAppearanceLightNavigationBars = Boolean.valueOf(arg2);
    }

    public ModalBottomSheetProperties(boolean arg1, boolean arg2, SecureFlagPolicy arg3, boolean arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 4) != 0) {
            arg3 = SecureFlagPolicy.Inherit;
        }

        this(arg1, arg2, arg3, true);
    }

    public ModalBottomSheetProperties(boolean arg1, boolean arg2, SecureFlagPolicy arg3, boolean arg4, boolean arg5) {
        super();
        this.shouldDismissOnBackPress = arg4;
        this.shouldDismissOnClickOutside = arg5;
        this.securePolicy = arg3;
        this.isAppearanceLightStatusBars = Boolean.valueOf(arg1);
        this.isAppearanceLightNavigationBars = Boolean.valueOf(arg2);
    }

    public ModalBottomSheetProperties(boolean arg7, boolean arg8, SecureFlagPolicy arg9, boolean arg10, boolean arg11, int arg12, DefaultConstructorMarker arg13) {
        if((arg12 & 4) != 0) {
            arg9 = SecureFlagPolicy.Inherit;
        }

        SecureFlagPolicy v3 = arg9;
        boolean v4 = (arg12 & 8) != 0 ? true : arg10;
        boolean v5 = (arg12 & 16) != 0 ? true : arg11;
        this(arg7, arg8, v3, v4, v5);
    }

    public boolean equals(Object arg5) {
        if(this == (((ModalBottomSheetProperties)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ModalBottomSheetProperties)) {
            return 0;
        }

        if(this.securePolicy != ((ModalBottomSheetProperties)arg5).securePolicy) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.isAppearanceLightStatusBars, ((ModalBottomSheetProperties)arg5).isAppearanceLightStatusBars)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.isAppearanceLightNavigationBars, ((ModalBottomSheetProperties)arg5).isAppearanceLightNavigationBars)) {
            return 0;
        }

        if(this.shouldDismissOnClickOutside != ((ModalBottomSheetProperties)arg5).shouldDismissOnClickOutside) {
            return 0;
        }

        if(this.shouldDismissOnBackPress != ((ModalBottomSheetProperties)arg5).shouldDismissOnBackPress) {
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
        int v0 = (this.securePolicy.hashCode() * 0x1F + Boolean.hashCode(this.shouldDismissOnBackPress)) * 0x1F;
        Boolean v1 = this.isAppearanceLightStatusBars;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.isAppearanceLightNavigationBars;
        if(v1 != null) {
            v2 = v1.hashCode();
        }

        return (v0 + v2) * 0x1F + Boolean.hashCode(this.shouldDismissOnClickOutside);
    }

    public final Boolean isAppearanceLightNavigationBars$material3() {
        return this.isAppearanceLightNavigationBars;
    }

    public final Boolean isAppearanceLightStatusBars$material3() {
        return this.isAppearanceLightStatusBars;
    }

    public final boolean shouldDismissOnClickOutside() {
        return this.shouldDismissOnClickOutside;
    }
}

