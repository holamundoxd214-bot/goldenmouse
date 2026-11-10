package androidx.compose.ui.input.indirect;

import android.view.MotionEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0001\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fR\u001A\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0016\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0007\u001A\u00020\bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u0012\u0010\u0010R\u0014\u0010\t\u001A\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2={"Landroidx/compose/ui/input/indirect/AndroidIndirectPointerEvent;", "Landroidx/compose/ui/input/indirect/PlatformIndirectPointerEvent;", "changes", "", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "type", "Landroidx/compose/ui/input/indirect/IndirectPointerEventType;", "primaryDirectionalMotionAxis", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "nativeEvent", "Landroid/view/MotionEvent;", "<init>", "(Ljava/util/List;IILandroid/view/MotionEvent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getChanges", "()Ljava/util/List;", "getType-4ZHQPSE", "()I", "I", "getPrimaryDirectionalMotionAxis-nZO2Niw", "getNativeEvent$ui", "()Landroid/view/MotionEvent;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidIndirectPointerEvent implements PlatformIndirectPointerEvent {
    public static final int $stable = 8;
    private final List changes;
    private final MotionEvent nativeEvent;
    private final int primaryDirectionalMotionAxis;
    private final int type;

    static {
    }

    private AndroidIndirectPointerEvent(List arg1, int arg2, int arg3, MotionEvent arg4) {
        super();
        this.changes = arg1;
        this.type = arg2;
        this.primaryDirectionalMotionAxis = arg3;
        this.nativeEvent = arg4;
        if(!this.getChanges().isEmpty()) {
            return;
        }

        throw new IllegalArgumentException("changes cannot be empty".toString());
    }

    public AndroidIndirectPointerEvent(List arg1, int arg2, int arg3, MotionEvent arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public List getChanges() {
        return this.changes;
    }

    public final MotionEvent getNativeEvent$ui() {
        return this.nativeEvent;
    }

    public int getPrimaryDirectionalMotionAxis-nZO2Niw() {
        return this.primaryDirectionalMotionAxis;
    }

    public int getType-4ZHQPSE() {
        return this.type;
    }
}

