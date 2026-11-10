package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u000F\u001A\u00020\n\u0012\u000E\b\u0002\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001A\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010)\u001A\u00020\u0003HÆ\u0003¢\u0006\u0004\b*\u0010\u0018J\t\u0010+\u001A\u00020\u0005HÆ\u0003J\u0010\u0010,\u001A\u00020\u0007HÆ\u0003¢\u0006\u0004\b-\u0010\u0018J\u0010\u0010.\u001A\u00020\u0007HÆ\u0003¢\u0006\u0004\b/\u0010\u0018J\t\u00100\u001A\u00020\nHÆ\u0003J\t\u00101\u001A\u00020\fHÆ\u0003J\u0010\u00102\u001A\u00020\u000EHÆ\u0003¢\u0006\u0004\b3\u0010\"J\t\u00104\u001A\u00020\nHÆ\u0003J\u000F\u00105\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\u0010\u00106\u001A\u00020\u0007HÆ\u0003¢\u0006\u0004\b7\u0010\u0018J\u0010\u00108\u001A\u00020\u0007HÆ\u0003¢\u0006\u0004\b9\u0010\u0018J\u0084\u0001\u0010:\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\n2\u000E\b\u0002\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001A\u00020\u00072\b\b\u0002\u0010\u0014\u001A\u00020\u0007HÆ\u0001¢\u0006\u0004\b;\u0010<J\u0013\u0010=\u001A\u00020\n2\b\u0010>\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001A\u00020@HÖ\u0001J\t\u0010A\u001A\u00020BHÖ\u0001R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0018R\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u001B\u0010\u0018R\u0013\u0010\b\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\u001C\u0010\u0018R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 R\u0013\u0010\r\u001A\u00020\u000E¢\u0006\n\n\u0002\u0010#\u001A\u0004\b!\u0010\"R\u0011\u0010\u000F\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u001ER\u0017\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0013\u0010\u0013\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b\'\u0010\u0018R\u0013\u0010\u0014\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001A\u0004\b(\u0010\u0018¨\u0006C"}, d2={"Landroidx/compose/ui/input/pointer/PointerInputEventData;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "position", "down", "", "pressure", "", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "activeHover", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "scrollDelta", "originalEventPosition", "<init>", "(JJJJZFIZLjava/util/List;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId-J3iCeTQ", "()J", "J", "getUptime", "getPositionOnScreen-F1C5BW0", "getPosition-F1C5BW0", "getDown", "()Z", "getPressure", "()F", "getType-T8wyACA", "()I", "I", "getActiveHover", "getHistorical", "()Ljava/util/List;", "getScrollDelta-F1C5BW0", "getOriginalEventPosition-F1C5BW0", "component1", "component1-J3iCeTQ", "component2", "component3", "component3-F1C5BW0", "component4", "component4-F1C5BW0", "component5", "component6", "component7", "component7-T8wyACA", "component8", "component9", "component10", "component10-F1C5BW0", "component11", "component11-F1C5BW0", "copy", "copy-rc8HELY", "(JJJJZFIZLjava/util/List;JJ)Landroidx/compose/ui/input/pointer/PointerInputEventData;", "equals", "other", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PointerInputEventData {
    public static final int $stable = 8;
    private final boolean activeHover;
    private final boolean down;
    private final List historical;
    private final long id;
    private final long originalEventPosition;
    private final long position;
    private final long positionOnScreen;
    private final float pressure;
    private final long scrollDelta;
    private final int type;
    private final long uptime;

    static {
    }

    public PointerInputEventData(long arg1, long arg3, long arg5, long arg7, boolean arg9, float arg10, int arg11, boolean arg12, List arg13, long arg14, long arg16, DefaultConstructorMarker arg18) {
        this(arg1, arg3, arg5, arg7, arg9, arg10, arg11, arg12, arg13, arg14, arg16);
    }

    public PointerInputEventData(long arg22, long arg24, long arg26, long arg28, boolean arg30, float arg31, int arg32, boolean arg33, List arg34, long arg35, long arg37, int arg39, DefaultConstructorMarker arg40) {
        List v15_1;
        int v0 = arg39;
        boolean v14 = (v0 & 0x80) != 0 ? false : arg33;
        if((v0 & 0x100) != 0) {
            ArrayList v15 = new ArrayList();
        }
        else {
            v15_1 = arg34;
        }

        long v16 = (v0 & 0x200) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg35;
        long v18 = (v0 & 0x400) != 0 ? Offset.Companion.getZero-F1C5BW0() : arg37;
        this(arg22, arg24, arg26, arg28, arg30, arg31, arg32, v14, v15_1, v16, v18, null);
    }

    private PointerInputEventData(long arg1, long arg3, long arg5, long arg7, boolean arg9, float arg10, int arg11, boolean arg12, List arg13, long arg14, long arg16) {
        super();
        this.id = arg1;
        this.uptime = arg3;
        this.positionOnScreen = arg5;
        this.position = arg7;
        this.down = arg9;
        this.pressure = arg10;
        this.type = arg11;
        this.activeHover = arg12;
        this.historical = arg13;
        this.scrollDelta = arg14;
        this.originalEventPosition = arg16;
    }

    public final long component1-J3iCeTQ() {
        return this.id;
    }

    public final long component10-F1C5BW0() {
        return this.scrollDelta;
    }

    public final long component11-F1C5BW0() {
        return this.originalEventPosition;
    }

    public final long component2() {
        return this.uptime;
    }

    public final long component3-F1C5BW0() {
        return this.positionOnScreen;
    }

    public final long component4-F1C5BW0() {
        return this.position;
    }

    public final boolean component5() {
        return this.down;
    }

    public final float component6() {
        return this.pressure;
    }

    public final int component7-T8wyACA() {
        return this.type;
    }

    public final boolean component8() {
        return this.activeHover;
    }

    public final List component9() {
        return this.historical;
    }

    public final PointerInputEventData copy-rc8HELY(long arg20, long arg22, long arg24, long arg26, boolean arg28, float arg29, int arg30, boolean arg31, List arg32, long arg33, long arg35) {
        return new PointerInputEventData(arg20, arg22, arg24, arg26, arg28, arg29, arg30, arg31, arg32, arg33, arg35, null);
    }

    public static PointerInputEventData copy-rc8HELY$default(PointerInputEventData arg17, long arg18, long arg20, long arg22, long arg24, boolean arg26, float arg27, int arg28, boolean arg29, List arg30, long arg31, long arg33, int arg35, Object arg36) {
        long v34;
        long v32;
        long v15;
        PointerInputEventData v0 = arg17;
        int v1 = arg35;
        long v2 = (v1 & 1) != 0 ? v0.id : arg18;
        long v4 = (v1 & 2) != 0 ? v0.uptime : arg20;
        long v6 = (v1 & 4) != 0 ? v0.positionOnScreen : arg22;
        long v8 = (v1 & 8) != 0 ? v0.position : arg24;
        boolean v10 = (v1 & 16) != 0 ? v0.down : arg26;
        float v11 = (v1 & 0x20) != 0 ? v0.pressure : arg27;
        int v12 = (v1 & 0x40) != 0 ? v0.type : arg28;
        boolean v13 = (v1 & 0x80) != 0 ? v0.activeHover : arg29;
        List v14 = (v1 & 0x100) != 0 ? v0.historical : arg30;
        if((v1 & 0x200) != 0) {
            v15 = v2;
            v2 = v0.scrollDelta;
        }
        else {
            v15 = v2;
            v2 = arg31;
        }

        if((v1 & 0x400) != 0) {
            v32 = v2;
            v34 = v0.originalEventPosition;
        }
        else {
            v34 = arg33;
            v32 = v2;
        }

        return v0.copy-rc8HELY(v15, v4, v6, v8, v10, v11, v12, v13, v14, v32, v34);
    }

    public boolean equals(Object arg8) {
        if(this == (((PointerInputEventData)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof PointerInputEventData)) {
            return 0;
        }

        if(!PointerId.equals-impl0(this.id, ((PointerInputEventData)arg8).id)) {
            return 0;
        }

        if(this.uptime != ((PointerInputEventData)arg8).uptime) {
            return 0;
        }

        if(!Offset.equals-impl0(this.positionOnScreen, ((PointerInputEventData)arg8).positionOnScreen)) {
            return 0;
        }

        if(!Offset.equals-impl0(this.position, ((PointerInputEventData)arg8).position)) {
            return 0;
        }

        if(this.down != ((PointerInputEventData)arg8).down) {
            return 0;
        }

        if(Float.compare(this.pressure, ((PointerInputEventData)arg8).pressure) != 0) {
            return 0;
        }

        if(!PointerType.equals-impl0(this.type, ((PointerInputEventData)arg8).type)) {
            return 0;
        }

        if(this.activeHover != ((PointerInputEventData)arg8).activeHover) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.historical, ((PointerInputEventData)arg8).historical)) {
            return 0;
        }

        if(!Offset.equals-impl0(this.scrollDelta, ((PointerInputEventData)arg8).scrollDelta)) {
            return 0;
        }

        if(!Offset.equals-impl0(this.originalEventPosition, ((PointerInputEventData)arg8).originalEventPosition)) {
            return 0;
        }

        return 1;
    }

    public final boolean getActiveHover() {
        return this.activeHover;
    }

    public final boolean getDown() {
        return this.down;
    }

    public final List getHistorical() {
        return this.historical;
    }

    public final long getId-J3iCeTQ() {
        return this.id;
    }

    public final long getOriginalEventPosition-F1C5BW0() {
        return this.originalEventPosition;
    }

    public final long getPosition-F1C5BW0() {
        return this.position;
    }

    public final long getPositionOnScreen-F1C5BW0() {
        return this.positionOnScreen;
    }

    public final float getPressure() {
        return this.pressure;
    }

    public final long getScrollDelta-F1C5BW0() {
        return this.scrollDelta;
    }

    public final int getType-T8wyACA() {
        return this.type;
    }

    public final long getUptime() {
        return this.uptime;
    }

    public int hashCode() {
        return (((((((((PointerId.hashCode-impl(this.id) * 0x1F + Long.hashCode(this.uptime)) * 0x1F + Offset.hashCode-impl(this.positionOnScreen)) * 0x1F + Offset.hashCode-impl(this.position)) * 0x1F + Boolean.hashCode(this.down)) * 0x1F + Float.hashCode(this.pressure)) * 0x1F + PointerType.hashCode-impl(this.type)) * 0x1F + Boolean.hashCode(this.activeHover)) * 0x1F + this.historical.hashCode()) * 0x1F + Offset.hashCode-impl(this.scrollDelta)) * 0x1F + Offset.hashCode-impl(this.originalEventPosition);
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("PointerInputEventData(id=");
        v0.append(PointerId.toString-impl(this.id)).append(", uptime=").append(this.uptime).append(", positionOnScreen=").append(Offset.toString-impl(this.positionOnScreen)).append(", position=").append(Offset.toString-impl(this.position)).append(", down=").append(this.down).append(", pressure=").append(this.pressure).append(", type=").append(PointerType.toString-impl(this.type)).append(", activeHover=").append(this.activeHover).append(", historical=").append(this.historical).append(", scrollDelta=").append(Offset.toString-impl(this.scrollDelta)).append(", originalEventPosition=").append(Offset.toString-impl(this.originalEventPosition)).append(')');
        return v0.toString();
    }
}

