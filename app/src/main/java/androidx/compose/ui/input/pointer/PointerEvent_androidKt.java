package androidx.compose.ui.input.pointer;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b*\u001A\r\u0010\u0003\u001A\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001A\u0019\u0010\u0013\u001A\u00020\u0007*\u00020\b2\u0006\u0010\u0014\u001A\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001A\u0011\u0010\u0019\u001A\u00020\u0001*\u00020\b¢\u0006\u0004\b\u001A\u0010\u001B\u001A\u0011\u0010\u001C\u001A\u00020\u0001*\u00020\b¢\u0006\u0004\b\u001D\u0010\u001B\"\u0015\u0010\u0006\u001A\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001A\u0004\b\t\u0010\n\"\u0015\u0010\u000B\u001A\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001A\u0004\b\f\u0010\n\"\u0015\u0010\r\u001A\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\n\"\u0015\u0010\u000F\u001A\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\n\"\u0015\u0010\u0011\u001A\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\n\"\u0015\u0010\u0017\u001A\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\n\"\u0015\u0010\u001E\u001A\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u001F\u0010\n\"\u0015\u0010 \u001A\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b!\u0010\n\"\u0015\u0010\"\u001A\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b#\u0010\n\"\u0015\u0010$\u001A\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b%\u0010\n\"\u0015\u0010&\u001A\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\'\u0010\n\"\u0015\u0010(\u001A\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b)\u0010\n\"\u0015\u0010*\u001A\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b+\u0010\n\"\u0015\u0010,\u001A\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b-\u0010\n\"\u0015\u0010.\u001A\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b/\u0010\n\"\u0015\u00100\u001A\u00020\u0007*\u00020\u00048F¢\u0006\u0006\u001A\u0004\b1\u0010\n*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001*\f\b\u0000\u0010\u0002\"\u00020\u00012\u00020\u0001¨\u00062"}, d2={"NativePointerButtons", "", "NativePointerKeyboardModifiers", "EmptyPointerKeyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "()I", "isPrimaryPressed", "", "Landroidx/compose/ui/input/pointer/PointerButtons;", "isPrimaryPressed-aHzCx-E", "(I)Z", "isSecondaryPressed", "isSecondaryPressed-aHzCx-E", "isTertiaryPressed", "isTertiaryPressed-aHzCx-E", "isBackPressed", "isBackPressed-aHzCx-E", "isForwardPressed", "isForwardPressed-aHzCx-E", "isPressed", "buttonIndex", "isPressed-bNIWhpI", "(II)Z", "areAnyPressed", "getAreAnyPressed-aHzCx-E", "indexOfFirstPressed", "indexOfFirstPressed-aHzCx-E", "(I)I", "indexOfLastPressed", "indexOfLastPressed-aHzCx-E", "isCtrlPressed", "isCtrlPressed-5xRPYO0", "isMetaPressed", "isMetaPressed-5xRPYO0", "isAltPressed", "isAltPressed-5xRPYO0", "isAltGraphPressed", "isAltGraphPressed-5xRPYO0", "isSymPressed", "isSymPressed-5xRPYO0", "isShiftPressed", "isShiftPressed-5xRPYO0", "isFunctionPressed", "isFunctionPressed-5xRPYO0", "isCapsLockOn", "isCapsLockOn-5xRPYO0", "isScrollLockOn", "isScrollLockOn-5xRPYO0", "isNumLockOn", "isNumLockOn-5xRPYO0", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PointerEvent_androidKt {
    public static final int EmptyPointerKeyboardModifiers() {
        return PointerKeyboardModifiers.constructor-impl(0);
    }

    public static final boolean getAreAnyPressed-aHzCx-E(int arg0) {
        if(arg0 != 0) {
            return 1;
        }

        return 0;
    }

    public static final int indexOfFirstPressed-aHzCx-E(int arg2) {
        if(arg2 == 0) {
            return -1;
        }

        arg2 = arg2 & -97 | (arg2 & 0x60) >>> 5;
        int v0 = 0;
        while((arg2 & 1) == 0) {
            ++v0;
            arg2 >>>= 1;
        }

        return v0;
    }

    public static final int indexOfLastPressed-aHzCx-E(int arg1) {
        arg1 = arg1 & -97 | (arg1 & 0x60) >>> 5;
        int v0 = -1;
        while(arg1 != 0) {
            ++v0;
            arg1 >>>= 1;
        }

        return v0;
    }

    public static final boolean isAltGraphPressed-5xRPYO0(int arg0) {
        return 0;
    }

    public static final boolean isAltPressed-5xRPYO0(int arg0) {
        if((arg0 & 2) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isBackPressed-aHzCx-E(int arg0) {
        if((arg0 & 8) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isCapsLockOn-5xRPYO0(int arg1) {
        if((arg1 & 0x100000) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isCtrlPressed-5xRPYO0(int arg0) {
        if((arg0 & 0x1000) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isForwardPressed-aHzCx-E(int arg0) {
        if((arg0 & 16) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isFunctionPressed-5xRPYO0(int arg0) {
        if((arg0 & 8) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isMetaPressed-5xRPYO0(int arg1) {
        if((arg1 & 0x10000) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isNumLockOn-5xRPYO0(int arg1) {
        if((arg1 & 0x200000) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isPressed-bNIWhpI(int arg4, int arg5) {
        if(arg5 != 0) {
            if(arg5 != 1) {
                int v2 = 2;
                if(arg5 != v2 && arg5 != 3 && arg5 != 4) {
                    if((arg4 & 1 << arg5 + v2) != 0) {
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }

                if((arg4 & 1 << arg5) != 0) {
                    return 1;
                }

                return 0;
            }

            return PointerEvent_androidKt.isSecondaryPressed-aHzCx-E(arg4);
        }

        return PointerEvent_androidKt.isPrimaryPressed-aHzCx-E(arg4);
    }

    public static final boolean isPrimaryPressed-aHzCx-E(int arg0) {
        if((arg0 & 33) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isScrollLockOn-5xRPYO0(int arg1) {
        if((arg1 & 0x400000) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isSecondaryPressed-aHzCx-E(int arg0) {
        if((arg0 & 66) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isShiftPressed-5xRPYO0(int arg1) {
        if((arg1 & 1) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isSymPressed-5xRPYO0(int arg0) {
        if((arg0 & 4) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isTertiaryPressed-aHzCx-E(int arg0) {
        if((arg0 & 4) != 0) {
            return 1;
        }

        return 0;
    }
}

