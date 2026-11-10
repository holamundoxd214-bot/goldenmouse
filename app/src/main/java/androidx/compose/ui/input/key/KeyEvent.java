package androidx.compose.ui.input.key;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u000EHÖ\u0001J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\t\u001A\u0004\b\u0007\u0010\b\u0088\u0001\u0002¨\u0006\u0011"}, d2={"Landroidx/compose/ui/input/key/KeyEvent;", "", "nativeKeyEvent", "Landroid/view/KeyEvent;", "Landroidx/compose/ui/input/key/NativeKeyEvent;", "constructor-impl", "(Landroid/view/KeyEvent;)Landroid/view/KeyEvent;", "getNativeKeyEvent", "()Landroid/view/KeyEvent;", "Landroid/view/KeyEvent;", "equals", "", "other", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class KeyEvent {
    private final android.view.KeyEvent nativeKeyEvent;

    private KeyEvent(android.view.KeyEvent arg1) {
        super();
        this.nativeKeyEvent = arg1;
    }

    public static final KeyEvent box-impl(android.view.KeyEvent arg1) {
        return new KeyEvent(arg1);
    }

    public static android.view.KeyEvent constructor-impl(android.view.KeyEvent arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return KeyEvent.equals-impl(this.nativeKeyEvent, arg1);
    }

    public static boolean equals-impl(android.view.KeyEvent arg2, Object arg3) {
        if(!(arg3 instanceof KeyEvent)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((KeyEvent)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(android.view.KeyEvent arg0, android.view.KeyEvent arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public final android.view.KeyEvent getNativeKeyEvent() {
        return this.nativeKeyEvent;
    }

    public int hashCode() {
        return KeyEvent.hashCode-impl(this.nativeKeyEvent);
    }

    public static int hashCode-impl(android.view.KeyEvent arg0) {
        return arg0.hashCode();
    }

    public String toString() {
        return KeyEvent.toString-impl(this.nativeKeyEvent);
    }

    public static String toString-impl(android.view.KeyEvent arg2) {
        return "KeyEvent(nativeKeyEvent=" + arg2 + ')';
    }

    public final android.view.KeyEvent unbox-impl() {
        return this.nativeKeyEvent;
    }
}

