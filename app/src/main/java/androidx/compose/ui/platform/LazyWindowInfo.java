package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0018\u001A\u00020\u00192\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\bJ\u0016\u0010\u001B\u001A\u00020\u00192\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005R\u0016\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R+\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\n8V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER$\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u00128V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001C\u001A\u00020\u001D8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020!8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010\u001F¨\u0006#"}, d2={"Landroidx/compose/ui/platform/LazyWindowInfo;", "Landroidx/compose/ui/platform/WindowInfo;", "<init>", "()V", "onInitializeContainerSize", "Lkotlin/Function0;", "Landroidx/compose/ui/platform/DerivedSize;", "_containerSize", "Landroidx/compose/runtime/MutableState;", "<set-?>", "", "isWindowFocused", "()Z", "setWindowFocused", "(Z)V", "isWindowFocused$delegate", "Landroidx/compose/runtime/MutableState;", "value", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "keyboardModifiers", "getKeyboardModifiers-k7X9c1A", "()I", "setKeyboardModifiers-5xRPYO0", "(I)V", "updateContainerSizeIfObserved", "", "calculateContainerSize", "setOnInitializeContainerSize", "containerSize", "Landroidx/compose/ui/unit/IntSize;", "getContainerSize-YbymL2g", "()J", "containerDpSize", "Landroidx/compose/ui/unit/DpSize;", "getContainerDpSize-MYxV2XQ", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyWindowInfo implements WindowInfo {
    public static final int $stable;
    private MutableState _containerSize;
    private final MutableState isWindowFocused$delegate;
    private Function0 onInitializeContainerSize;

    static {
    }

    public LazyWindowInfo() {
        super();
        this.isWindowFocused$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
    }

    public static final MutableState access$get_containerSize$p(LazyWindowInfo arg0) {
        return arg0._containerSize;
    }

    public long getContainerDpSize-MYxV2XQ() {
        DerivedSize v0_3;
        MutableState v0 = this._containerSize;
        if(v0 == null) {
            Function0 v0_1 = this.onInitializeContainerSize;
            if(v0_1 != null) {
                Object v0_2 = v0_1.invoke();
                if(v0_2 == null) {
                    goto label_6;
                }
            }
            else {
            label_6:
                v0_3 = DerivedSize.Companion.getZero();
            }

            v0 = SnapshotStateKt.mutableStateOf$default(v0_3, null, 2, null);
            this._containerSize = v0;
            this.onInitializeContainerSize = null;
        }

        Intrinsics.checkNotNull(v0);
        return v0.getValue().getDpSize-MYxV2XQ();
    }

    public long getContainerSize-YbymL2g() {
        DerivedSize v0_3;
        MutableState v0 = this._containerSize;
        if(v0 == null) {
            Function0 v0_1 = this.onInitializeContainerSize;
            if(v0_1 != null) {
                Object v0_2 = v0_1.invoke();
                if(v0_2 == null) {
                    goto label_6;
                }
            }
            else {
            label_6:
                v0_3 = DerivedSize.Companion.getZero();
            }

            v0 = SnapshotStateKt.mutableStateOf$default(v0_3, null, 2, null);
            this._containerSize = v0;
            this.onInitializeContainerSize = null;
        }

        Intrinsics.checkNotNull(v0);
        return v0.getValue().getPxSize-YbymL2g();
    }

    public int getKeyboardModifiers-k7X9c1A() {
        return WindowInfoImpl.Companion.getGlobalKeyboardModifiers$ui().getValue().unbox-impl();
    }

    public boolean isWindowFocused() {
        return this.isWindowFocused$delegate.getValue().booleanValue();
    }

    public void setKeyboardModifiers-5xRPYO0(int arg1) {
        WindowInfoImpl.Companion.getGlobalKeyboardModifiers$ui().setValue(PointerKeyboardModifiers.box-impl(arg1));
    }

    public final void setOnInitializeContainerSize(Function0 arg2) {
        if(this._containerSize == null) {
            this.onInitializeContainerSize = arg2;
        }
    }

    public void setWindowFocused(boolean arg1) {
        this.isWindowFocused$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void updateContainerSizeIfObserved(Function0 arg1) {
        MutableState v0 = this._containerSize;
        if(v0 != null) {
            v0.setValue(arg1.invoke());
        }
    }
}

