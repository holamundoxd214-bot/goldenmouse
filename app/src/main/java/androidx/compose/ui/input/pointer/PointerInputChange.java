package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\u0006\u0010\r\u001A\u00020\u0007\u0012\u0006\u0010\u000E\u001A\u00020\t\u0012\u0006\u0010\u000F\u001A\u00020\t\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014B]\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\u0006\u0010\r\u001A\u00020\u0007\u0012\u0006\u0010\u000E\u001A\u00020\t\u0012\u0006\u0010\u000F\u001A\u00020\t\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001A\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0015BS\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\u0006\u0010\r\u001A\u00020\u0007\u0012\u0006\u0010\u000E\u001A\u00020\t\u0012\u0006\u0010\u0016\u001A\u00020\u0017\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0018Bw\b\u0010\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\u0006\u0010\r\u001A\u00020\u0007\u0012\u0006\u0010\u000E\u001A\u00020\t\u0012\u0006\u0010\u000F\u001A\u00020\t\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A\u0012\u0006\u0010\u0012\u001A\u00020\u0007\u0012\u0006\u0010\u001C\u001A\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u001DJ\u0006\u0010A\u001A\u00020BJi\u0010I\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010J\u001A\u00020\u00052\b\b\u0002\u0010K\u001A\u00020\u00072\b\b\u0002\u0010L\u001A\u00020\t2\b\b\u0002\u0010M\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\u00072\b\b\u0002\u0010\u000E\u001A\u00020\t2\b\b\u0002\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0010\u001A\u00020\u0011H\u0007¢\u0006\u0004\bN\u0010OJg\u0010I\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010J\u001A\u00020\u00052\b\b\u0002\u0010K\u001A\u00020\u00072\b\b\u0002\u0010L\u001A\u00020\t2\b\b\u0002\u0010M\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\u00072\b\b\u0002\u0010\u000E\u001A\u00020\t2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u0007¢\u0006\u0004\bP\u0010QJq\u0010I\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010J\u001A\u00020\u00052\b\b\u0002\u0010K\u001A\u00020\u00072\b\b\u0002\u0010L\u001A\u00020\t2\b\b\u0002\u0010M\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\u00072\b\b\u0002\u0010\u000E\u001A\u00020\t2\u0006\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u0007H\u0007¢\u0006\u0004\bR\u0010SJq\u0010I\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010J\u001A\u00020\u00052\b\b\u0002\u0010K\u001A\u00020\u00072\b\b\u0002\u0010L\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010M\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\u00072\b\b\u0002\u0010\u000E\u001A\u00020\t2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u0007¢\u0006\u0004\bT\u0010UJw\u0010I\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010J\u001A\u00020\u00052\b\b\u0002\u0010K\u001A\u00020\u00072\b\b\u0002\u0010L\u001A\u00020\t2\b\b\u0002\u0010M\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\u00072\b\b\u0002\u0010\u000E\u001A\u00020\t2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A2\b\b\u0002\u0010\u0012\u001A\u00020\u0007H\u0007¢\u0006\u0004\bV\u0010WJ\u0081\u0001\u0010I\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010J\u001A\u00020\u00052\b\b\u0002\u0010K\u001A\u00020\u00072\b\b\u0002\u0010L\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010M\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\u00072\b\b\u0002\u0010\u000E\u001A\u00020\t2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\u000E\b\u0002\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A2\b\b\u0002\u0010\u0012\u001A\u00020\u0007¢\u0006\u0004\bX\u0010YJ\b\u0010Z\u001A\u00020[H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010 \u001A\u0004\b\u001E\u0010\u001FR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u001FR\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010 \u001A\u0004\b\"\u0010\u001FR\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b#\u0010$R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010\u001FR\u0013\u0010\r\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010 \u001A\u0004\b(\u0010\u001FR\u0011\u0010\u000E\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b)\u0010$R\u0013\u0010\u0010\u001A\u00020\u0011¢\u0006\n\n\u0002\u0010,\u001A\u0004\b*\u0010+R\u0013\u0010\u0012\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010 \u001A\u0004\b-\u0010\u001FR\u0017\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A8F¢\u0006\u0006\u001A\u0004\b.\u0010/R\u0016\u00100\u001A\n\u0012\u0004\u0012\u00020\u001B\u0018\u00010\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u001C\u001A\u00020\u0007X\u0080\u000E¢\u0006\u0010\n\u0002\u0010 \u001A\u0004\b1\u0010\u001F\"\u0004\b2\u00103R\u0011\u00104\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b4\u0010$R\u001A\u00105\u001A\u00020\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b6\u0010$\"\u0004\b7\u00108R\u001A\u00109\u001A\u00020\tX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b:\u0010$\"\u0004\b;\u00108R\u001C\u0010<\u001A\u0004\u0018\u00010\u0000X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010C\u001A\u0004\u0018\u00010\u0017X\u0082\u000E¢\u0006\b\n\u0000\u0012\u0004\bD\u0010ER\u001A\u0010\u0016\u001A\u00020\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u0010E\u001A\u0004\bG\u0010H¨\u0006\\"}, d2={"Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "pressed", "", "pressure", "", "previousUptimeMillis", "previousPosition", "previousPressed", "isInitiallyConsumed", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "scrollDelta", "<init>", "(JJJZFJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJZJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "consumed", "Landroidx/compose/ui/input/pointer/ConsumedData;", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "originalEventPosition", "(JJJZFJJZZILjava/util/List;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId-J3iCeTQ", "()J", "J", "getUptimeMillis", "getPosition-F1C5BW0", "getPressed", "()Z", "getPressure", "()F", "getPreviousUptimeMillis", "getPreviousPosition-F1C5BW0", "getPreviousPressed", "getType-T8wyACA", "()I", "I", "getScrollDelta-F1C5BW0", "getHistorical", "()Ljava/util/List;", "_historical", "getOriginalEventPosition-F1C5BW0$ui", "setOriginalEventPosition-k-4lQ0M$ui", "(J)V", "isConsumed", "downChange", "getDownChange$ui", "setDownChange$ui", "(Z)V", "positionChange", "getPositionChange$ui", "setPositionChange$ui", "consumedDelegate", "getConsumedDelegate$ui", "()Landroidx/compose/ui/input/pointer/PointerInputChange;", "setConsumedDelegate$ui", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "consume", "", "_consumed", "get_consumed$annotations", "()V", "getConsumed$annotations", "getConsumed", "()Landroidx/compose/ui/input/pointer/ConsumedData;", "copy", "currentTime", "currentPosition", "currentPressed", "previousTime", "copy-Ezr-O64", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;I)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-JKmWfYY", "(JJJZJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-0GkPj7c", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;IJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-Tn9QgHE", "(JJJZFJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-OHpmEuE", "(JJJZJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-wbzehF4", "(JJJZFJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PointerInputChange {
    public static final int $stable;
    private ConsumedData _consumed;
    private List _historical;
    private PointerInputChange consumedDelegate;
    private boolean downChange;
    private final long id;
    private long originalEventPosition;
    private final long position;
    private boolean positionChange;
    private final boolean pressed;
    private final float pressure;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long scrollDelta;
    private final int type;
    private final long uptimeMillis;

    static {
    }

    private PointerInputChange(long arg1, long arg3, long arg5, boolean arg7, float arg8, long arg9, long arg11, boolean arg13, boolean arg14, int arg15, long arg16) {
        super();
        this.id = arg1;
        this.uptimeMillis = arg3;
        this.position = arg5;
        this.pressed = arg7;
        this.pressure = arg8;
        this.previousUptimeMillis = arg9;
        this.previousPosition = arg11;
        this.previousPressed = arg13;
        this.type = arg15;
        this.scrollDelta = arg16;
        this.originalEventPosition = Offset.Companion.getZero-F1C5BW0();
        this.downChange = arg14;
        this.positionChange = arg14;
    }

    public PointerInputChange(long arg22, long arg24, long arg26, boolean arg28, float arg29, long arg30, long arg32, boolean arg34, boolean arg35, int arg36, long arg37, int arg39, DefaultConstructorMarker arg40) {
        int v0 = arg39;
        int v17 = (v0 & 0x200) != 0 ? PointerType.Companion.getTouch-T8wyACA() : arg36;
        long v18 = (v0 & 0x400) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg37;
        this(arg22, arg24, arg26, arg28, arg29, arg30, arg32, arg34, arg35, v17, v18, null);
    }

    public PointerInputChange(long arg1, long arg3, long arg5, boolean arg7, float arg8, long arg9, long arg11, boolean arg13, boolean arg14, int arg15, long arg16, DefaultConstructorMarker arg18) {
        this(arg1, arg3, arg5, arg7, arg8, arg9, arg11, arg13, arg14, arg15, arg16);
    }

    private PointerInputChange(long arg20, long arg22, long arg24, boolean arg26, float arg27, long arg28, long arg30, boolean arg32, boolean arg33, int arg34, List arg35, long arg36, long arg38) {
        this(arg20, arg22, arg24, arg26, arg27, arg28, arg30, arg32, arg33, arg34, arg36, null);
        this._historical = arg35;
        this.originalEventPosition = arg38;
    }

    public PointerInputChange(long arg1, long arg3, long arg5, boolean arg7, float arg8, long arg9, long arg11, boolean arg13, boolean arg14, int arg15, List arg16, long arg17, long arg19, DefaultConstructorMarker arg21) {
        this(arg1, arg3, arg5, arg7, arg8, arg9, arg11, arg13, arg14, arg15, arg16, arg17, arg19);
    }

    private PointerInputChange(long arg21, long arg23, long arg25, boolean arg27, long arg28, long arg30, boolean arg32, ConsumedData arg33, int arg34) {
        boolean v0 = (arg33.getDownChange()) || (arg33.getPositionChange()) ? true : false;
        this(arg21, arg23, arg25, arg27, 1f, arg28, arg30, arg32, v0, arg34, Offset.Companion.getZero-F1C5BW0(), null);
    }

    public PointerInputChange(long arg18, long arg20, long arg22, boolean arg24, long arg25, long arg27, boolean arg29, ConsumedData arg30, int arg31, int arg32, DefaultConstructorMarker arg33) {
        int v15 = (arg32 & 0x100) != 0 ? PointerType.Companion.getTouch-T8wyACA() : arg31;
        this(arg18, arg20, arg22, arg24, arg25, arg27, arg29, arg30, v15, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use another constructor with `scrollDelta` and without `ConsumedData` instead", replaceWith="<_subannotation>") public PointerInputChange(long arg1, long arg3, long arg5, boolean arg7, long arg8, long arg10, boolean arg12, ConsumedData arg13, int arg14, DefaultConstructorMarker arg15) {
        this(arg1, arg3, arg5, arg7, arg8, arg10, arg12, arg13, arg14);
    }

    private PointerInputChange(long arg20, long arg22, long arg24, boolean arg26, long arg27, long arg29, boolean arg31, boolean arg32, int arg33, long arg34) {
        this(arg20, arg22, arg24, arg26, 1f, arg27, arg29, arg31, arg32, arg33, arg34, null);
    }

    public PointerInputChange(long arg21, long arg23, long arg25, boolean arg27, long arg28, long arg30, boolean arg32, boolean arg33, int arg34, long arg35, int arg37, DefaultConstructorMarker arg38) {
        int v0 = arg37;
        int v16 = (v0 & 0x100) != 0 ? PointerType.Companion.getTouch-T8wyACA() : arg34;
        long v17 = (v0 & 0x200) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg35;
        this(arg21, arg23, arg25, arg27, arg28, arg30, arg32, arg33, v16, v17, null);
    }

    public PointerInputChange(long arg1, long arg3, long arg5, boolean arg7, long arg8, long arg10, boolean arg12, boolean arg13, int arg14, long arg15, DefaultConstructorMarker arg17) {
        this(arg1, arg3, arg5, arg7, arg8, arg10, arg12, arg13, arg14, arg15);
    }

    public final void consume() {
        PointerInputChange v0 = this.consumedDelegate;
        if(v0 == null) {
            this.downChange = true;
            this.positionChange = true;
            return;
        }

        if(v0 != null) {
            v0.consume();
        }
    }

    @Deprecated(message="Partial consumption has been deprecated. Use copy() instead without `consumed` parameter to create a shallow copy or a constructor to create a new PointerInputChange", replaceWith="<_subannotation>") public final PointerInputChange copy-0GkPj7c(long arg24, long arg26, long arg28, boolean arg30, long arg31, long arg33, boolean arg35, ConsumedData arg36, int arg37, long arg38) {
        PointerInputChange v0 = this;
        float v9 = v0.pressure;
        boolean v2 = (arg36.getDownChange()) || (arg36.getPositionChange()) ? true : false;
        PointerInputChange v1 = new PointerInputChange(arg24, arg26, arg28, arg30, v9, arg31, arg33, arg35, v2, arg37, v0.getHistorical(), arg38, v0.originalEventPosition, null);
        v1.positionChange = v0.positionChange;
        v1.downChange = v0.downChange;
        return v1;
    }

    public static PointerInputChange copy-0GkPj7c$default(PointerInputChange arg18, long arg19, long arg21, long arg23, boolean arg25, long arg26, long arg28, boolean arg30, ConsumedData arg31, int arg32, long arg33, int arg35, Object arg36) {
        long v16;
        PointerInputChange v1 = arg18;
        int v0 = arg35;
        long v2 = (v0 & 1) != 0 ? v1.id : arg19;
        long v4 = (v0 & 2) != 0 ? v1.uptimeMillis : arg21;
        long v6 = (v0 & 4) != 0 ? v1.position : arg23;
        boolean v8 = (v0 & 8) != 0 ? v1.pressed : arg25;
        long v9 = (v0 & 16) != 0 ? v1.previousUptimeMillis : arg26;
        long v11 = (v0 & 0x20) != 0 ? v1.previousPosition : arg28;
        boolean v13 = (v0 & 0x40) != 0 ? v1.previousPressed : arg30;
        int v15 = (v0 & 0x100) != 0 ? v1.type : arg32;
        if((v0 & 0x200) != 0) {
            v16 = v1.scrollDelta;
            v2 = v2;
        }
        else {
            v16 = arg33;
        }

        return v1.copy-0GkPj7c(v2, v4, v6, v8, v9, v11, v13, arg31, v15, v16);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use another copy() method with scrollDelta parameter instead", replaceWith="<_subannotation>") public final PointerInputChange copy-Ezr-O64(long arg24, long arg26, long arg28, boolean arg30, long arg31, long arg33, boolean arg35, ConsumedData arg36, int arg37) {
        PointerInputChange v0 = this;
        float v9 = v0.pressure;
        boolean v2 = (arg36.getDownChange()) || (arg36.getPositionChange()) ? true : false;
        PointerInputChange v1 = new PointerInputChange(arg24, arg26, arg28, arg30, v9, arg31, arg33, arg35, v2, arg37, v0.getHistorical(), v0.scrollDelta, v0.originalEventPosition, null);
        v1.positionChange = v0.positionChange;
        v1.downChange = v0.downChange;
        return v1;
    }

    public static PointerInputChange copy-Ezr-O64$default(PointerInputChange arg14, long arg15, long arg17, long arg19, boolean arg21, long arg22, long arg24, boolean arg26, ConsumedData arg27, int arg28, int arg29, Object arg30) {
        int v0 = arg29;
        long v1 = (v0 & 1) != 0 ? arg14.id : arg15;
        long v3 = (v0 & 2) != 0 ? arg14.uptimeMillis : arg17;
        long v5 = (v0 & 4) != 0 ? arg14.position : arg19;
        boolean v7 = (v0 & 8) != 0 ? arg14.pressed : arg21;
        long v8 = (v0 & 16) != 0 ? arg14.previousUptimeMillis : arg22;
        long v10 = (v0 & 0x20) != 0 ? arg14.previousPosition : arg24;
        boolean v12 = (v0 & 0x40) != 0 ? arg14.previousPressed : arg26;
        ConsumedData v13 = (v0 & 0x80) != 0 ? arg14.getConsumed() : arg27;
        arg29 = (v0 & 0x100) != 0 ? arg14.type : arg28;
        return arg14.copy-Ezr-O64(v1, v3, v5, v7, v8, v10, v12, v13, arg29);
    }

    public final PointerInputChange copy-JKmWfYY(long arg20, long arg22, long arg24, boolean arg26, long arg27, long arg29, boolean arg31, int arg32, long arg33) {
        PointerInputChange v1 = this;
        PointerInputChange v0 = v1.copy-wbzehF4(arg20, arg22, arg24, arg26, v1.pressure, arg27, arg29, arg31, arg32, v1.getHistorical(), arg33);
        PointerInputChange v2 = v1.consumedDelegate;
        if(v2 == null) {
        }
        else {
            v1 = v2;
        }

        v0.consumedDelegate = v1;
        return v0;
    }

    public static PointerInputChange copy-JKmWfYY$default(PointerInputChange arg17, long arg18, long arg20, long arg22, boolean arg24, long arg25, long arg27, boolean arg29, int arg30, long arg31, int arg33, Object arg34) {
        long v19;
        long v32;
        PointerInputChange v0 = arg17;
        int v1 = arg33;
        long v2 = (v1 & 1) != 0 ? v0.id : arg18;
        long v4 = (v1 & 2) != 0 ? v0.uptimeMillis : arg20;
        long v6 = (v1 & 4) != 0 ? v0.position : arg22;
        boolean v8 = (v1 & 8) != 0 ? v0.pressed : arg24;
        long v9 = (v1 & 16) != 0 ? v0.previousUptimeMillis : arg25;
        long v11 = (v1 & 0x20) != 0 ? v0.previousPosition : arg27;
        boolean v13 = (v1 & 0x40) != 0 ? v0.previousPressed : arg29;
        int v14 = (v1 & 0x80) != 0 ? v0.type : arg30;
        if((v1 & 0x100) != 0) {
            v32 = v0.scrollDelta;
            v19 = v2;
        }
        else {
            v32 = arg31;
            v19 = v2;
        }

        return v0.copy-JKmWfYY(v19, v4, v6, v8, v9, v11, v13, v14, v32);
    }

    public final PointerInputChange copy-OHpmEuE(long arg20, long arg22, long arg24, boolean arg26, long arg27, long arg29, boolean arg31, int arg32, List arg33, long arg34) {
        PointerInputChange v1 = this;
        PointerInputChange v0 = v1.copy-wbzehF4(arg20, arg22, arg24, arg26, v1.pressure, arg27, arg29, arg31, arg32, arg33, arg34);
        PointerInputChange v2 = v1.consumedDelegate;
        if(v2 == null) {
        }
        else {
            v1 = v2;
        }

        v0.consumedDelegate = v1;
        return v0;
    }

    public static PointerInputChange copy-OHpmEuE$default(PointerInputChange arg18, long arg19, long arg21, long arg23, boolean arg25, long arg26, long arg28, boolean arg30, int arg31, List arg32, long arg33, int arg35, Object arg36) {
        long v16;
        PointerInputChange v1 = arg18;
        int v0 = arg35;
        long v2 = (v0 & 1) != 0 ? v1.id : arg19;
        long v4 = (v0 & 2) != 0 ? v1.uptimeMillis : arg21;
        long v6 = (v0 & 4) != 0 ? v1.position : arg23;
        boolean v8 = (v0 & 8) != 0 ? v1.pressed : arg25;
        long v9 = (v0 & 16) != 0 ? v1.previousUptimeMillis : arg26;
        long v11 = (v0 & 0x20) != 0 ? v1.previousPosition : arg28;
        boolean v13 = (v0 & 0x40) != 0 ? v1.previousPressed : arg30;
        int v14 = (v0 & 0x80) != 0 ? v1.type : arg31;
        if((v0 & 0x200) != 0) {
            v16 = v1.scrollDelta;
            v2 = v2;
        }
        else {
            v16 = arg33;
        }

        return v1.copy-OHpmEuE(v2, v4, v6, v8, v9, v11, v13, v14, arg32, v16);
    }

    public final PointerInputChange copy-Tn9QgHE(long arg24, long arg26, long arg28, boolean arg30, float arg31, long arg32, long arg34, boolean arg36, int arg37, long arg38) {
        PointerInputChange v0 = this;
        PointerInputChange v1 = new PointerInputChange(arg24, arg26, arg28, arg30, arg31, arg32, arg34, arg36, false, arg37, v0.getHistorical(), arg38, v0.originalEventPosition, null);
        PointerInputChange v2 = v0.consumedDelegate;
        if(v2 == null) {
        }
        else {
            v0 = v2;
        }

        v1.consumedDelegate = v0;
        return v1;
    }

    public static PointerInputChange copy-Tn9QgHE$default(PointerInputChange arg18, long arg19, long arg21, long arg23, boolean arg25, float arg26, long arg27, long arg29, boolean arg31, int arg32, long arg33, int arg35, Object arg36) {
        long v20;
        long v34;
        PointerInputChange v0 = arg18;
        int v1 = arg35;
        long v2 = (v1 & 1) != 0 ? v0.id : arg19;
        long v4 = (v1 & 2) != 0 ? v0.uptimeMillis : arg21;
        long v6 = (v1 & 4) != 0 ? v0.position : arg23;
        boolean v8 = (v1 & 8) != 0 ? v0.pressed : arg25;
        float v9 = (v1 & 16) != 0 ? v0.pressure : arg26;
        long v10 = (v1 & 0x20) != 0 ? v0.previousUptimeMillis : arg27;
        long v12 = (v1 & 0x40) != 0 ? v0.previousPosition : arg29;
        boolean v14 = (v1 & 0x80) != 0 ? v0.previousPressed : arg31;
        int v15 = (v1 & 0x100) != 0 ? v0.type : arg32;
        if((v1 & 0x200) != 0) {
            v34 = v0.scrollDelta;
            v20 = v2;
        }
        else {
            v34 = arg33;
            v20 = v2;
        }

        return v0.copy-Tn9QgHE(v20, v4, v6, v8, v9, v10, v12, v14, v15, v34);
    }

    public final PointerInputChange copy-wbzehF4(long arg24, long arg26, long arg28, boolean arg30, float arg31, long arg32, long arg34, boolean arg36, int arg37, List arg38, long arg39) {
        PointerInputChange v0 = this;
        PointerInputChange v1 = new PointerInputChange(arg24, arg26, arg28, arg30, arg31, arg32, arg34, arg36, false, arg37, arg38, arg39, v0.originalEventPosition, null);
        PointerInputChange v2 = v0.consumedDelegate;
        if(v2 == null) {
        }
        else {
            v0 = v2;
        }

        v1.consumedDelegate = v0;
        return v1;
    }

    public static PointerInputChange copy-wbzehF4$default(PointerInputChange arg18, long arg19, long arg21, long arg23, boolean arg25, float arg26, long arg27, long arg29, boolean arg31, int arg32, List arg33, long arg34, int arg36, Object arg37) {
        long v35;
        List v34;
        PointerInputChange v0 = arg18;
        int v1 = arg36;
        long v2 = (v1 & 1) != 0 ? v0.id : arg19;
        long v4 = (v1 & 2) != 0 ? v0.uptimeMillis : arg21;
        long v6 = (v1 & 4) != 0 ? v0.position : arg23;
        boolean v8 = (v1 & 8) != 0 ? v0.pressed : arg25;
        float v9 = (v1 & 16) != 0 ? v0.pressure : arg26;
        long v10 = (v1 & 0x20) != 0 ? v0.previousUptimeMillis : arg27;
        long v12 = (v1 & 0x40) != 0 ? v0.previousPosition : arg29;
        boolean v14 = (v1 & 0x80) != 0 ? v0.previousPressed : arg31;
        int v15 = (v1 & 0x100) != 0 ? v0.type : arg32;
        long v16 = v2;
        List v2_1 = (v1 & 0x200) != 0 ? v0.getHistorical() : arg33;
        if((v1 & 0x400) != 0) {
            v34 = v2_1;
            v35 = v0.scrollDelta;
        }
        else {
            v35 = arg34;
            v34 = v2_1;
        }

        return v0.copy-wbzehF4(v16, v4, v6, v8, v9, v10, v12, v14, v15, v34, v35);
    }

    public final ConsumedData getConsumed() {
        ConsumedData v0 = this._consumed;
        if(v0 == null) {
            v0 = new ConsumedData(this);
            this._consumed = v0;
        }

        Intrinsics.checkNotNull(v0);
        return v0;
    }

    @Deprecated(message="use isConsumed and consume() pair of methods instead") public static void getConsumed$annotations() {
    }

    public final PointerInputChange getConsumedDelegate$ui() {
        return this.consumedDelegate;
    }

    public final boolean getDownChange$ui() {
        return this.downChange;
    }

    public final List getHistorical() {
        List v0 = this._historical;
        if(v0 == null) {
            v0 = CollectionsKt.emptyList();
        }

        return v0;
    }

    public final long getId-J3iCeTQ() {
        return this.id;
    }

    public final long getOriginalEventPosition-F1C5BW0$ui() {
        return this.originalEventPosition;
    }

    public final long getPosition-F1C5BW0() {
        return this.position;
    }

    public final boolean getPositionChange$ui() {
        return this.positionChange;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    public final float getPressure() {
        return this.pressure;
    }

    public final long getPreviousPosition-F1C5BW0() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    public final long getPreviousUptimeMillis() {
        return this.previousUptimeMillis;
    }

    public final long getScrollDelta-F1C5BW0() {
        return this.scrollDelta;
    }

    public final int getType-T8wyACA() {
        return this.type;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    private static void get_consumed$annotations() {
    }

    public final boolean isConsumed() {
        PointerInputChange v0 = this.consumedDelegate;
        if(v0 != null) {
            return v0.isConsumed();
        }

        if(!this.downChange) {
            if(this.positionChange) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final void setConsumedDelegate$ui(PointerInputChange arg1) {
        this.consumedDelegate = arg1;
    }

    public final void setDownChange$ui(boolean arg1) {
        this.downChange = arg1;
    }

    public final void setOriginalEventPosition-k-4lQ0M$ui(long arg1) {
        this.originalEventPosition = arg1;
    }

    public final void setPositionChange$ui(boolean arg1) {
        this.positionChange = arg1;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("PointerInputChange(id=");
        v0.append(PointerId.toString-impl(this.id)).append(", uptimeMillis=").append(this.uptimeMillis).append(", position=").append(Offset.toString-impl(this.position)).append(", pressed=").append(this.pressed).append(", pressure=").append(this.pressure).append(", previousUptimeMillis=").append(this.previousUptimeMillis).append(", previousPosition=").append(Offset.toString-impl(this.previousPosition)).append(", previousPressed=").append(this.previousPressed).append(", isConsumed=").append(this.isConsumed()).append(", type=").append(PointerType.toString-impl(this.type)).append(", historical=").append(this.getHistorical()).append(",scrollDelta=");
        v0.append(Offset.toString-impl(this.scrollDelta)).append(')');
        return v0.toString();
    }
}

