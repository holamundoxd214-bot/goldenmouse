package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fJ\u0006\u0010\r\u001A\u00020\u000ER\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "", "<init>", "()V", "previousPointerInputData", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "produce", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "pointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "clear", "", "PointerInputData", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class PointerInputChangeEventProducer {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001A\u0004\b\f\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2={"Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer$PointerInputData;", "", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "down", "", "<init>", "(JJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getUptime", "()J", "getPositionOnScreen-F1C5BW0", "J", "getDown", "()Z", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class PointerInputData {
        private final boolean down;
        private final long positionOnScreen;
        private final long uptime;

        public PointerInputData(long arg1, long arg3, boolean arg5, DefaultConstructorMarker arg6) {
            this(arg1, arg3, arg5);
        }

        private PointerInputData(long arg1, long arg3, boolean arg5) {
            super();
            this.uptime = arg1;
            this.positionOnScreen = arg3;
            this.down = arg5;
        }

        public final boolean getDown() {
            return this.down;
        }

        public final long getPositionOnScreen-F1C5BW0() {
            return this.positionOnScreen;
        }

        public final long getUptime() {
            return this.uptime;
        }
    }

    private final LongSparseArray previousPointerInputData;

    public PointerInputChangeEventProducer() {
        super();
        this.previousPointerInputData = new LongSparseArray(0, 1, null);
    }

    public final void clear() {
        this.previousPointerInputData.clear();
    }

    public final InternalPointerEvent produce(PointerInputEvent arg36, PositionCalculator arg37) {
        long v24;
        long v22;
        boolean v26;
        PointerInputChangeEventProducer v0 = this;
        LongSparseArray v1 = new LongSparseArray(arg36.getPointers().size());
        List v2 = arg36.getPointers();
        int v3 = v2.size();
        int v5;
        for(v5 = 0; v5 < v3; ++v5) {
            Object v6 = v2.get(v5);
            Object v7 = v0.previousPointerInputData.get(((PointerInputEventData)v6).getId-J3iCeTQ());
            if(v7 == null) {
                v26 = false;
                v22 = ((PointerInputEventData)v6).getUptime();
                v24 = ((PointerInputEventData)v6).getPosition-F1C5BW0();
            }
            else {
                v22 = ((PointerInputData)v7).getUptime();
                v26 = ((PointerInputData)v7).getDown();
                v24 = arg37.screenToLocal-MK-Hz9U(((PointerInputData)v7).getPositionOnScreen-F1C5BW0());
            }

            v1.put(((PointerInputEventData)v6).getId-J3iCeTQ(), new PointerInputChange(((PointerInputEventData)v6).getId-J3iCeTQ(), ((PointerInputEventData)v6).getUptime(), ((PointerInputEventData)v6).getPosition-F1C5BW0(), ((PointerInputEventData)v6).getDown(), ((PointerInputEventData)v6).getPressure(), v22, v24, v26, false, ((PointerInputEventData)v6).getType-T8wyACA(), ((PointerInputEventData)v6).getHistorical(), ((PointerInputEventData)v6).getScrollDelta-F1C5BW0(), ((PointerInputEventData)v6).getOriginalEventPosition-F1C5BW0(), null));
            boolean v8 = ((PointerInputEventData)v6).getDown();
            LongSparseArray v9 = v0.previousPointerInputData;
            if(v8) {
                v9.put(((PointerInputEventData)v6).getId-J3iCeTQ(), new PointerInputData(((PointerInputEventData)v6).getUptime(), ((PointerInputEventData)v6).getPositionOnScreen-F1C5BW0(), ((PointerInputEventData)v6).getDown(), null));
            }
            else {
                v9.remove(((PointerInputEventData)v6).getId-J3iCeTQ());
            }
        }

        return new InternalPointerEvent(v1, arg36);
    }
}

