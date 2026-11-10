package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\u0005\u0012\b\b\u0002\u0010\t\u001A\u00020\u0005¢\u0006\u0004\b\n\u0010\u000BB1\b\u0016\u0012\b\b\u0002\u0010\f\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0005\u0012\b\b\u0002\u0010\r\u001A\u00020\u0005¢\u0006\u0004\b\n\u0010\u000EBE\b\u0016\u0012\b\b\u0002\u0010\f\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0010\u0012\b\b\u0002\u0010\b\u001A\u00020\u0005\u0012\b\b\u0002\u0010\r\u001A\u00020\u0005¢\u0006\u0004\b\n\u0010\u0011BO\b\u0016\u0012\b\b\u0002\u0010\f\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0010\u0012\b\b\u0002\u0010\b\u001A\u00020\u0005\u0012\b\b\u0002\u0010\r\u001A\u00020\u0005\u0012\b\b\u0002\u0010\t\u001A\u00020\u0005¢\u0006\u0004\b\n\u0010\u0012J\u0013\u0010\u001F\u001A\u00020\u00052\b\u0010 \u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010!\u001A\u00020\u0003H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0016R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0016R\u0011\u0010\f\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0016R\u0011\u0010\u000F\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\r\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u0016¨\u0006\""}, d2={"Landroidx/compose/ui/window/PopupProperties;", "", "flags", "", "inheritSecurePolicy", "", "dismissOnBackPress", "dismissOnClickOutside", "excludeFromSystemGesture", "usePlatformDefaultWidth", "<init>", "(IZZZZZ)V", "focusable", "clippingEnabled", "(ZZZZ)V", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "(ZZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZZ)V", "getFlags$ui", "()I", "getInheritSecurePolicy$ui", "()Z", "getDismissOnBackPress", "getDismissOnClickOutside", "getExcludeFromSystemGesture", "getUsePlatformDefaultWidth", "getFocusable", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getClippingEnabled", "equals", "other", "hashCode", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PopupProperties {
    public static final int $stable;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final boolean excludeFromSystemGesture;
    private final int flags;
    private final boolean inheritSecurePolicy;
    private final boolean usePlatformDefaultWidth;

    static {
    }

    public PopupProperties(boolean arg2, boolean arg3, boolean arg4, boolean arg5, int arg6, DefaultConstructorMarker arg7) {
        this(false, true, true, true);
    }

    public PopupProperties(boolean arg2, boolean arg3, boolean arg4, SecureFlagPolicy arg5, boolean arg6, boolean arg7, int arg8, DefaultConstructorMarker arg9) {
        PopupProperties v3;
        boolean v5;
        boolean v8;
        SecureFlagPolicy v7;
        boolean v9;
        if((arg8 & 8) != 0) {
            arg5 = SecureFlagPolicy.Inherit;
        }

        if((arg8 & 0x20) != 0) {
            v9 = true;
            v7 = arg5;
            v8 = true;
            v5 = true;
            arg6 = true;
            v3 = this;
            arg4 = false;
        }
        else {
            v9 = arg7;
            v8 = true;
            arg6 = true;
            v7 = arg5;
            arg4 = false;
            v5 = true;
            v3 = this;
        }

        this(arg4, v5, arg6, v7, v8, v9);
    }

    public PopupProperties(int arg2, boolean arg3, boolean arg4, boolean arg5, boolean arg6, boolean arg7, int arg8, DefaultConstructorMarker arg9) {
        this(arg2, true, true, true, true, false);
    }

    public PopupProperties(int arg1, boolean arg2, boolean arg3, boolean arg4, boolean arg5, boolean arg6) {
        super();
        this.flags = arg1;
        this.inheritSecurePolicy = arg2;
        this.dismissOnBackPress = arg3;
        this.dismissOnClickOutside = arg4;
        this.excludeFromSystemGesture = arg5;
        this.usePlatformDefaultWidth = arg6;
    }

    public PopupProperties(boolean arg9, boolean arg10, boolean arg11, SecureFlagPolicy arg12, boolean arg13, boolean arg14) {
        this(arg9, arg10, arg11, arg12, arg13, arg14, false);
    }

    public PopupProperties(boolean arg1, boolean arg2, boolean arg3, SecureFlagPolicy arg4, boolean arg5, boolean arg6, boolean arg7) {
        int v1 = AndroidPopup_androidKt.createFlags(arg1, arg4, arg6);
        boolean v4 = arg4 == SecureFlagPolicy.Inherit ? true : false;
        this(v1, v4, arg2, arg3, arg5, arg7);
    }

    public PopupProperties(boolean arg3, boolean arg4, boolean arg5, SecureFlagPolicy arg6, boolean arg7, boolean arg8, boolean arg9, int arg10, DefaultConstructorMarker arg11) {
        if((arg10 & 8) != 0) {
            arg6 = SecureFlagPolicy.Inherit;
        }

        this(false, true, true, arg6, true, true, false);
    }

    public PopupProperties(boolean arg8, boolean arg9, boolean arg10, boolean arg11) {
        this(arg8, arg9, arg10, SecureFlagPolicy.Inherit, true, arg11);
    }

    public boolean equals(Object arg5) {
        if(this == (((PopupProperties)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof PopupProperties)) {
            return 0;
        }

        if(this.flags != ((PopupProperties)arg5).flags) {
            return 0;
        }

        if(this.inheritSecurePolicy != ((PopupProperties)arg5).inheritSecurePolicy) {
            return 0;
        }

        if(this.dismissOnBackPress != ((PopupProperties)arg5).dismissOnBackPress) {
            return 0;
        }

        if(this.dismissOnClickOutside != ((PopupProperties)arg5).dismissOnClickOutside) {
            return 0;
        }

        if(this.excludeFromSystemGesture != ((PopupProperties)arg5).excludeFromSystemGesture) {
            return 0;
        }

        if(this.usePlatformDefaultWidth != ((PopupProperties)arg5).usePlatformDefaultWidth) {
            return 0;
        }

        return 1;
    }

    public final boolean getClippingEnabled() {
        if((this.flags & 0x200) == 0) {
            return 1;
        }

        return 0;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    public final boolean getExcludeFromSystemGesture() {
        return this.excludeFromSystemGesture;
    }

    public final int getFlags$ui() {
        return this.flags;
    }

    public final boolean getFocusable() {
        if((this.flags & 8) == 0) {
            return 1;
        }

        return 0;
    }

    public final boolean getInheritSecurePolicy$ui() {
        return this.inheritSecurePolicy;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        if(this.inheritSecurePolicy) {
            return SecureFlagPolicy.Inherit;
        }

        if((this.flags & 0x2000) == 0) {
            return SecureFlagPolicy.SecureOff;
        }

        return SecureFlagPolicy.SecureOn;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public int hashCode() {
        return ((((this.flags * 0x1F + Boolean.hashCode(this.inheritSecurePolicy)) * 0x1F + Boolean.hashCode(this.dismissOnBackPress)) * 0x1F + Boolean.hashCode(this.dismissOnClickOutside)) * 0x1F + Boolean.hashCode(this.excludeFromSystemGesture)) * 0x1F + Boolean.hashCode(this.usePlatformDefaultWidth);
    }
}

