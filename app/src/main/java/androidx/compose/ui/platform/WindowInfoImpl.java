package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0001\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\n8V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER$\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u00128V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u00068V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR$\u0010\u001D\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\b8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u001E\u0010\u001A\"\u0004\b\u001F\u0010\u001C¨\u0006!"}, d2={"Landroidx/compose/ui/platform/WindowInfoImpl;", "Landroidx/compose/ui/platform/WindowInfo;", "<init>", "()V", "_containerSize", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/IntSize;", "_containerDpSize", "Landroidx/compose/ui/unit/DpSize;", "<set-?>", "", "isWindowFocused", "()Z", "setWindowFocused", "(Z)V", "isWindowFocused$delegate", "Landroidx/compose/runtime/MutableState;", "value", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "keyboardModifiers", "getKeyboardModifiers-k7X9c1A", "()I", "setKeyboardModifiers-5xRPYO0", "(I)V", "containerSize", "getContainerSize-YbymL2g", "()J", "setContainerSize-ozmzZPI", "(J)V", "containerDpSize", "getContainerDpSize-MYxV2XQ", "setContainerDpSize-EaSLcWc", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowInfoImpl implements WindowInfo {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/ui/platform/WindowInfoImpl$Companion;", "", "<init>", "()V", "GlobalKeyboardModifiers", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getGlobalKeyboardModifiers$ui", "()Landroidx/compose/runtime/MutableState;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final MutableState getGlobalKeyboardModifiers$ui() {
            return WindowInfoImpl.GlobalKeyboardModifiers;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final MutableState GlobalKeyboardModifiers;
    private final MutableState _containerDpSize;
    private final MutableState _containerSize;
    private final MutableState isWindowFocused$delegate;

    static {
        WindowInfoImpl.Companion = new Companion(null);
        WindowInfoImpl.GlobalKeyboardModifiers = SnapshotStateKt.mutableStateOf$default(PointerKeyboardModifiers.box-impl(PointerEvent_androidKt.EmptyPointerKeyboardModifiers()), null, 2, null);
    }

    public WindowInfoImpl() {
        super();
        this._containerSize = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), null, 2, null);
        this._containerDpSize = SnapshotStateKt.mutableStateOf$default(DpSize.box-impl(DpSize.Companion.getZero-MYxV2XQ()), null, 2, null);
        this.isWindowFocused$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
    }

    public static final MutableState access$getGlobalKeyboardModifiers$cp() {
        return WindowInfoImpl.GlobalKeyboardModifiers;
    }

    public long getContainerDpSize-MYxV2XQ() {
        return this._containerDpSize.getValue().unbox-impl();
    }

    public long getContainerSize-YbymL2g() {
        return this._containerSize.getValue().unbox-impl();
    }

    public int getKeyboardModifiers-k7X9c1A() {
        return WindowInfoImpl.GlobalKeyboardModifiers.getValue().unbox-impl();
    }

    public boolean isWindowFocused() {
        return this.isWindowFocused$delegate.getValue().booleanValue();
    }

    public void setContainerDpSize-EaSLcWc(long arg1) {
        this._containerDpSize.setValue(DpSize.box-impl(arg1));
    }

    public void setContainerSize-ozmzZPI(long arg1) {
        this._containerSize.setValue(IntSize.box-impl(arg1));
    }

    public void setKeyboardModifiers-5xRPYO0(int arg1) {
        WindowInfoImpl.GlobalKeyboardModifiers.setValue(PointerKeyboardModifiers.box-impl(arg1));
    }

    public void setWindowFocused(boolean arg1) {
        this.isWindowFocused$delegate.setValue(Boolean.valueOf(arg1));
    }
}

