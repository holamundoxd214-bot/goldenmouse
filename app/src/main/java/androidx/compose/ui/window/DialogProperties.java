package androidx.compose.ui.window;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003\u0012\b\b\u0002\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fB\'\b\u0016\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\rB;\b\u0017\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\u000B\u0010\u000EB\'\b\u0017\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u000B\u0010\u000FJ\u0013\u0010\u0019\u001A\u00020\u00032\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001B\u001A\u00020\u001CH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001D"}, d2={"Landroidx/compose/ui/window/DialogProperties;", "", "dismissOnBackPress", "", "dismissOnClickOutside", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "usePlatformDefaultWidth", "decorFitsSystemWindows", "windowTitle", "", "<init>", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZLjava/lang/String;)V", "(ZZZ)V", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;)V", "getDismissOnBackPress", "()Z", "getDismissOnClickOutside", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getUsePlatformDefaultWidth", "getDecorFitsSystemWindows", "getWindowTitle", "()Ljava/lang/String;", "equals", "other", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DialogProperties {
    public static final int $stable;
    private final boolean decorFitsSystemWindows;
    private final boolean dismissOnBackPress;
    private final boolean dismissOnClickOutside;
    private final SecureFlagPolicy securePolicy;
    private final boolean usePlatformDefaultWidth;
    private final String windowTitle;

    static {
    }

    public DialogProperties(boolean arg2, boolean arg3, boolean arg4, int arg5, DefaultConstructorMarker arg6) {
        this(true, true, true);
    }

    public DialogProperties() {
        this(false, false, null, false, false, null, 0x3F, null);
    }

    public DialogProperties(boolean arg2, boolean arg3, SecureFlagPolicy arg4, boolean arg5, boolean arg6, String arg7, int arg8, DefaultConstructorMarker arg9) {
        if((arg8 & 4) != 0) {
            arg4 = SecureFlagPolicy.Inherit;
        }

        if((arg8 & 0x20) != 0) {
            arg7 = "";
        }

        this(true, true, arg4, true, true, arg7);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public DialogProperties(boolean arg10, boolean arg11, SecureFlagPolicy arg12) {
        this(arg10, arg11, arg12, true, true, null, 0x20, null);
    }

    public DialogProperties(boolean arg2, boolean arg3, SecureFlagPolicy arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 4) != 0) {
            arg4 = SecureFlagPolicy.Inherit;
        }

        this(true, true, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public DialogProperties(boolean arg8, boolean arg9, SecureFlagPolicy arg10, boolean arg11, boolean arg12) {
        this(arg8, arg9, SecureFlagPolicy.Inherit, arg11, true, "");
    }

    public DialogProperties(boolean arg1, boolean arg2, SecureFlagPolicy arg3, boolean arg4, boolean arg5, String arg6) {
        super();
        this.dismissOnBackPress = arg1;
        this.dismissOnClickOutside = arg2;
        this.securePolicy = arg3;
        this.usePlatformDefaultWidth = arg4;
        this.decorFitsSystemWindows = arg5;
        this.windowTitle = arg6;
    }

    public DialogProperties(boolean arg2, boolean arg3, SecureFlagPolicy arg4, boolean arg5, boolean arg6, int arg7, DefaultConstructorMarker arg8) {
        if((arg7 & 4) != 0) {
            arg4 = SecureFlagPolicy.Inherit;
        }

        this(true, true, arg4, true, true);
    }

    public DialogProperties(boolean arg10, boolean arg11, boolean arg12) {
        this(arg10, arg11, SecureFlagPolicy.Inherit, arg12, true, null, 0x20, null);
    }

    public boolean equals(Object arg5) {
        if(this == (((DialogProperties)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof DialogProperties)) {
            return 0;
        }

        if(this.dismissOnBackPress != ((DialogProperties)arg5).dismissOnBackPress) {
            return 0;
        }

        if(this.dismissOnClickOutside != ((DialogProperties)arg5).dismissOnClickOutside) {
            return 0;
        }

        if(this.securePolicy != ((DialogProperties)arg5).securePolicy) {
            return 0;
        }

        if(this.usePlatformDefaultWidth != ((DialogProperties)arg5).usePlatformDefaultWidth) {
            return 0;
        }

        if(this.decorFitsSystemWindows != ((DialogProperties)arg5).decorFitsSystemWindows) {
            return 0;
        }

        return 1;
    }

    public final boolean getDecorFitsSystemWindows() {
        return this.decorFitsSystemWindows;
    }

    public final boolean getDismissOnBackPress() {
        return this.dismissOnBackPress;
    }

    public final boolean getDismissOnClickOutside() {
        return this.dismissOnClickOutside;
    }

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.dismissOnBackPress) * 0x1F + Boolean.hashCode(this.dismissOnClickOutside)) * 0x1F + this.securePolicy.hashCode()) * 0x1F + Boolean.hashCode(this.usePlatformDefaultWidth)) * 0x1F + Boolean.hashCode(this.decorFitsSystemWindows);
    }
}

