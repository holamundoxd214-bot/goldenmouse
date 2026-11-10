package androidx.compose.ui.input.pointer;

import android.os.Build$VERSION;
import android.util.SparseBooleanArray;
import android.util.SparseLongArray;
import android.view.MotionEvent;
import androidx.collection.LongSparseArray;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent;
import androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent_androidKt;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001BH\u0000¢\u0006\u0002\b\u001CJ#\u0010\u001D\u001A\u0004\u0018\u00010\u001E2\u0006\u0010\u0018\u001A\u00020\u00192\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010 H\u0000¢\u0006\u0002\b!J\u000E\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020\u0014J\u0010\u0010%\u001A\u00020#2\u0006\u0010\u0018\u001A\u00020\u0019H\u0002J\u0010\u0010&\u001A\u00020#2\u0006\u0010\u0018\u001A\u00020\u0019H\u0002J\u0014\u0010\'\u001A\u00020(*\u00020\u00192\u0006\u0010$\u001A\u00020\u0014H\u0002J\u0017\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020\u0014H\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001A\u00020#2\u0006\u0010\u0018\u001A\u00020\u0019H\u0002J(\u0010/\u001A\u00020\u000F2\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u00100\u001A\u00020\u00142\u0006\u00101\u001A\u00020(H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u0006\u001A\u00020\u00078\u0000X\u0081\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\b\u0010\u0003\u001A\u0004\b\t\u0010\nR\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000¨\u00063"}, d2={"Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "", "<init>", "()V", "nextId", "", "motionEventToComposePointerIdMap", "Landroid/util/SparseLongArray;", "getMotionEventToComposePointerIdMap$ui$annotations", "getMotionEventToComposePointerIdMap$ui", "()Landroid/util/SparseLongArray;", "activeHoverIds", "Landroid/util/SparseBooleanArray;", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "previousIndirectPointerEventData", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData;", "previousToolType", "", "previousSource", "convertToPointerInputEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "motionEvent", "Landroid/view/MotionEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "convertToPointerInputEvent$ui", "convertToIndirectPointerEvent", "Landroidx/compose/ui/input/indirect/AndroidIndirectPointerEvent;", "primaryDirectionalMotionAxisOverride", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "convertToIndirectPointerEvent-k92h6UU$ui", "endStream", "", "pointerId", "addFreshIds", "removeStaleIds", "hasPointerId", "", "getComposePointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "motionEventPointerId", "getComposePointerId-_I2yYro", "(I)J", "clearOnDeviceChange", "createPointerInputEventData", "index", "pressed", "IndirectPointerEventData", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MotionEventAdapter {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0083@\u0018\u0000 \u001E2\u00020\u0001:\u0001\u001EB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u0004\u0010\u000BJ\u001A\u0010\u0012\u001A\u00020\n2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001A\u001A\u00020\u001BHÖ\u0001¢\u0006\u0004\b\u001C\u0010\u001DR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\t\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u00038F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0005R\u0011\u0010\u0007\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0005\u0088\u0001\u0002¨\u0006\u001F"}, d2={"Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData;", "", "packedValue", "", "constructor-impl", "(J)J", "uptime", "position", "Landroidx/compose/ui/geometry/Offset;", "down", "", "(JJZ)J", "getPackedValue", "()J", "getDown-impl", "(J)Z", "getUptime-impl", "getPosition-F1C5BW0", "equals", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline final class IndirectPointerEventData {
        @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0002J\u0010\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0005H\u0002J\u0010\u0010\u000B\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0005H\u0002¨\u0006\f"}, d2={"Landroidx/compose/ui/input/pointer/MotionEventAdapter$IndirectPointerEventData$Companion;", "", "<init>", "()V", "packShorts", "", "val1", "", "val2", "unpackShort1", "value", "unpackShort2", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            public static final int access$packShorts(Companion arg0, short arg1, short arg2) {
                return arg0.packShorts(arg1, arg2);
            }

            public static final short access$unpackShort1(Companion arg0, int arg1) {
                return arg0.unpackShort1(arg1);
            }

            public static final short access$unpackShort2(Companion arg0, int arg1) {
                return arg0.unpackShort2(arg1);
            }

            private final int packShorts(short arg1, short arg2) {
                return arg1 << 16 | 0xFFFF & arg2;
            }

            private final short unpackShort1(int arg1) {
                return ((short)(arg1 >>> 16));
            }

            private final short unpackShort2(int arg1) {
                return ((short)(0xFFFF & arg1));
            }
        }

        public static final Companion Companion;
        private final long packedValue;

        static {
            IndirectPointerEventData.Companion = new Companion(null);
        }

        private IndirectPointerEventData(long arg1) {
            super();
            this.packedValue = arg1;
        }

        public static final IndirectPointerEventData box-impl(long arg1) {
            return new IndirectPointerEventData(arg1);
        }

        public static long constructor-impl(long arg4, long arg6, boolean arg8) {
            long v0 = arg8 ? 1 : 0;
            return IndirectPointerEventData.constructor-impl((arg4 & 0x7FFFFFFF) << 1 | v0 | (((long)Companion.access$packShorts(IndirectPointerEventData.Companion, ((short)(((int)Float.intBitsToFloat(((int)(arg6 >> 0x20)))))), ((short)(((int)Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))))))))) << 0x20);
        }

        public static long constructor-impl(long arg0) {
            return arg0;
        }

        public boolean equals(Object arg3) {
            return IndirectPointerEventData.equals-impl(this.packedValue, arg3);
        }

        public static boolean equals-impl(long arg4, Object arg6) {
            if(!(arg6 instanceof IndirectPointerEventData)) {
                return 0;
            }

            if(arg4 != ((IndirectPointerEventData)arg6).unbox-impl()) {
                return 0;
            }

            return 1;
        }

        public static final boolean equals-impl0(long arg0, long arg2) {
            if(arg0 == arg2) {
                return 1;
            }

            return 0;
        }

        public static final boolean getDown-impl(long arg2) {
            if((arg2 & 1) != 0) {
                return 1;
            }

            return 0;
        }

        public final long getPackedValue() {
            return this.packedValue;
        }

        public static final long getPosition-F1C5BW0(long arg4) {
            int v4 = ((int)(arg4 >>> 0x20));
            return Offset.constructor-impl((((long)Float.floatToRawIntBits(((float)Companion.access$unpackShort2(IndirectPointerEventData.Companion, v4))))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(((float)Companion.access$unpackShort1(IndirectPointerEventData.Companion, v4))))) << 0x20);
        }

        public static final long getUptime-impl(long arg2) {
            return arg2 >> 1 & 0x7FFFFFFF;
        }

        public int hashCode() {
            return IndirectPointerEventData.hashCode-impl(this.packedValue);
        }

        public static int hashCode-impl(long arg0) {
            return Long.hashCode(arg0);
        }

        public String toString() {
            return IndirectPointerEventData.toString-impl(this.packedValue);
        }

        public static String toString-impl(long arg2) {
            return "IndirectPointerEventData(packedValue=" + arg2 + ')';
        }

        public final long unbox-impl() {
            return this.packedValue;
        }
    }

    public static final int $stable = 8;
    private final SparseBooleanArray activeHoverIds;
    private final SparseLongArray motionEventToComposePointerIdMap;
    private long nextId;
    private final List pointers;
    private final LongSparseArray previousIndirectPointerEventData;
    private int previousSource;
    private int previousToolType;

    static {
    }

    public MotionEventAdapter() {
        super();
        this.motionEventToComposePointerIdMap = new SparseLongArray();
        this.activeHoverIds = new SparseBooleanArray();
        this.pointers = new ArrayList();
        this.previousIndirectPointerEventData = new LongSparseArray(0, 1, null);
        this.previousToolType = -1;
        this.previousSource = -1;
    }

    private final void addFreshIds(MotionEvent arg8) {
        int v0 = arg8.getActionMasked();
        long v1 = 1;
        if(v0 == 0 || v0 == 5) {
            v0 = arg8.getActionIndex();
            int v3_1 = arg8.getPointerId(v0);
            if(this.motionEventToComposePointerIdMap.indexOfKey(v3_1) < 0) {
                SparseLongArray v4 = this.motionEventToComposePointerIdMap;
                long v5 = this.nextId;
                this.nextId = v1 + v5;
                v4.put(v3_1, v5);
                if(arg8.getToolType(v0) == 3) {
                    this.activeHoverIds.put(v3_1, true);
                }
            }
        }
        else if(v0 != 9) {
        }
        else {
            int v8 = arg8.getPointerId(0);
            if(this.motionEventToComposePointerIdMap.indexOfKey(v8) < 0) {
                SparseLongArray v0_1 = this.motionEventToComposePointerIdMap;
                long v3 = this.nextId;
                this.nextId = v1 + v3;
                v0_1.put(v8, v3);
                return;
            }
        }
    }

    private final void clearOnDeviceChange(MotionEvent arg3) {
        int v3;
        int v0;
        if(arg3.getPointerCount() != 1) {
        }
        else {
            v0 = arg3.getToolType(0);
            v3 = arg3.getSource();
            if(v0 == this.previousToolType) {
                if(v3 != this.previousSource) {
                }
                else {
                    return;
                }
            }

            goto label_13;
        }

        return;
    label_13:
        this.previousToolType = v0;
        this.previousSource = v3;
        this.activeHoverIds.clear();
        this.motionEventToComposePointerIdMap.clear();
    }

    public final AndroidIndirectPointerEvent convertToIndirectPointerEvent-k92h6UU$ui(MotionEvent arg28, IndirectPointerEventPrimaryDirectionalMotionAxis arg29) {
        int v26;
        int v5;
        MotionEventAdapter v0 = this;
        MotionEvent v4 = arg28;
        int v1 = v4.getActionMasked();
        this.clearOnDeviceChange(arg28);
        if(v1 == 3) {
            v0.motionEventToComposePointerIdMap.clear();
            v0.activeHoverIds.clear();
            return null;
        }

        this.addFreshIds(arg28);
        if(v1 == 1) {
            v5 = 0;
        }
        else if(v1 != 6) {
            v5 = -1;
        }
        else {
            v5 = v4.getActionIndex();
        }

        int v6 = v1 == 0 || v1 == 2 || v1 == 5 ? 1 : 0;
        int v7 = v4.getPointerCount();
        ArrayList v8 = new ArrayList(v7);
        int v9 = 0;
        while(v9 < v7) {
            long v12 = v0.getComposePointerId-_I2yYro(v4.getPointerId(v9));
            long v10 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v4.getY(v9)))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(v4.getX(v9)))) << 0x20);
            boolean v18 = v9 != v5 ? true : false;
            Object v14 = v0.previousIndirectPointerEventData.get(v12);
            if(v9 == v5) {
                v0.previousIndirectPointerEventData.remove(v12);
                goto label_68;
            }
            else if(v6 != 0) {
                v26 = v1;
                v0.previousIndirectPointerEventData.put(v12, IndirectPointerEventData.box-impl(IndirectPointerEventData.constructor-impl(v4.getEventTime(), v10, true)));
            }
            else {
            label_68:
                v26 = v1;
            }

            long v16 = v10;
            Object v0_1 = v14;
            long v14_1 = v4.getEventTime();
            float v19 = v4.getPressure(v9);
            long v20 = v0_1 != null ? IndirectPointerEventData.getUptime-impl(((IndirectPointerEventData)v0_1).unbox-impl()) : v4.getEventTime();
            long v22 = v0_1 != null ? IndirectPointerEventData.getPosition-F1C5BW0(((IndirectPointerEventData)v0_1).unbox-impl()) : v16;
            boolean v24 = v0_1 != null ? IndirectPointerEventData.getDown-impl(((IndirectPointerEventData)v0_1).unbox-impl()) : false;
            v8.add(new IndirectPointerInputChange(v12, v14_1, v16, v18, v19, v20, v22, v24, null));
            ++v9;
            v0 = this;
            v1 = v26;
        }

        v26 = v1;
        ArrayList v1_1 = v8;
        this.removeStaleIds(arg28);
        int v0_2 = arg29 != null ? arg29.unbox-impl() : AndroidIndirectPointerEvent_androidKt.indirectPrimaryDirectionalScrollAxis(v4);
        return new AndroidIndirectPointerEvent(((List)v1_1), AndroidIndirectPointerEvent_androidKt.convertActionToIndirectPointerEventType(v26), v0_2, v4, null);
    }

    public static AndroidIndirectPointerEvent convertToIndirectPointerEvent-k92h6UU$ui$default(MotionEventAdapter arg0, MotionEvent arg1, IndirectPointerEventPrimaryDirectionalMotionAxis arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        return arg0.convertToIndirectPointerEvent-k92h6UU$ui(arg1, arg2);
    }

    public final PointerInputEvent convertToPointerInputEvent$ui(MotionEvent arg10, PositionCalculator arg11) {
        boolean v8;
        int v0 = arg10.getActionMasked();
        if(v0 != 3 && v0 != 4) {
            this.clearOnDeviceChange(arg10);
            this.addFreshIds(arg10);
            int v1 = v0 == 9 || v0 == 7 || v0 == 10 ? 1 : 0;
            int v4 = v0 == 8 ? 1 : 0;
            if(v1 != 0) {
                this.activeHoverIds.put(arg10.getPointerId(arg10.getActionIndex()), true);
            }

            if(v0 == 1) {
                v0 = 0;
            }
            else if(v0 != 6) {
                v0 = -1;
            }
            else {
                v0 = arg10.getActionIndex();
            }

            this.pointers.clear();
            int v5 = arg10.getPointerCount();
            int v6;
            for(v6 = 0; v6 < v5; ++v6) {
                List v7 = this.pointers;
                if(v1 != 0 || v6 == v0) {
                label_50:
                    v8 = false;
                }
                else {
                    if(v4 != 0 && arg10.getButtonState() == 0) {
                        goto label_50;
                    }

                    v8 = true;
                }

                v7.add(this.createPointerInputEventData(arg11, arg10, v6, v8));
            }

            this.removeStaleIds(arg10);
            return new PointerInputEvent(arg10.getEventTime(), this.pointers, arg10);
        }

        this.motionEventToComposePointerIdMap.clear();
        this.activeHoverIds.clear();
        return null;
    }

    private final PointerInputEventData createPointerInputEventData(PositionCalculator arg36, MotionEvent arg37, int arg38, boolean arg39) {
        int v13;
        long v25;
        int v24;
        MotionEventAdapter v0 = this;
        PositionCalculator v1 = arg36;
        MotionEvent v2 = arg37;
        int v3 = arg38;
        long v6 = v0.getComposePointerId-_I2yYro(arg37.getPointerId(arg38));
        float v15 = arg37.getPressure(arg38);
        int v10 = 0x20;
        long v11 = 0xFFFFFFFFL;
        long v16 = Offset.constructor-impl((((long)Float.floatToRawIntBits(arg37.getY(arg38)))) & v11 | (((long)Float.floatToRawIntBits(arg37.getX(arg38)))) << v10);
        long v21 = Offset.copy-dBAh8RU$default(v16, 0f, 0f, 3, null);
        long v4 = v16;
        if(v3 == 0) {
            v4 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v2.getRawY()))) & v11 | (((long)Float.floatToRawIntBits(v2.getRawX()))) << v10);
            v16 = v1.screenToLocal-MK-Hz9U(v4);
        }
        else if(Build$VERSION.SDK_INT >= 29) {
            v4 = MotionEventHelper.INSTANCE.toRawOffset-dBAh8RU(v2, v3);
            v16 = v1.screenToLocal-MK-Hz9U(v4);
        }
        else {
            v16 = v4;
            v4 = v1.localToScreen-MK-Hz9U(v4);
        }

        int v1_1 = arg37.getToolType(arg38);
        if(v1_1 == 0) {
            v1_1 = PointerType.Companion.getUnknown-T8wyACA();
        }
        else if(v1_1 == 1) {
            v1_1 = PointerType.Companion.getTouch-T8wyACA();
        }
        else if(v1_1 == 2) {
            v1_1 = PointerType.Companion.getStylus-T8wyACA();
        }
        else if(v1_1 == 3) {
            v1_1 = PointerType.Companion.getMouse-T8wyACA();
        }
        else if(v1_1 != 4) {
            v1_1 = PointerType.Companion.getUnknown-T8wyACA();
        }
        else {
            v1_1 = PointerType.Companion.getEraser-T8wyACA();
        }

        ArrayList v8 = new ArrayList(v2.getHistorySize());
        int v9 = v2.getHistorySize();
        int v14 = 0;
        while(v14 < v9) {
            float v18 = v2.getHistoricalX(v3, v14);
            float v19 = v2.getHistoricalY(v3, v14);
            int v23 = 0x7FFFFFFF;
            v24 = v10;
            v25 = v11;
            int v11_1 = 0x7F800000;
            if((Float.floatToRawIntBits(v18) & v23) >= v11_1 || (Float.floatToRawIntBits(v19) & v23) >= v11_1) {
                v13 = v14;
            }
            else {
                long v30 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v18))) << v24 | (((long)Float.floatToRawIntBits(v19))) & v25);
                v13 = v14;
                v8.add(new HistoricalChange(v2.getHistoricalEventTime(v13), v30, v30, null));
            }

            v14 = v13 + 1;
            v10 = v24;
            v11 = v25;
        }

        v24 = v10;
        v25 = v11;
        long v9_1 = v2.getActionMasked() == 8 ? Offset.constructor-impl((((long)Float.floatToRawIntBits(-v2.getAxisValue(9) + 0f))) & v25 | (((long)Float.floatToRawIntBits(v2.getAxisValue(10)))) << v24) : Offset.Companion.getZero-F1C5BW0();
        return new PointerInputEventData(v6, v2.getEventTime(), v4, v16, arg39, v15, v1_1, v0.activeHoverIds.get(arg37.getPointerId(arg38), false), v8, v9_1, v21, null);
    }

    public final void endStream(int arg2) {
        this.activeHoverIds.delete(arg2);
        this.motionEventToComposePointerIdMap.delete(arg2);
    }

    private final long getComposePointerId-_I2yYro(int arg5) {
        long v4;
        int v0 = this.motionEventToComposePointerIdMap.indexOfKey(arg5);
        if(v0 >= 0) {
            v4 = this.motionEventToComposePointerIdMap.valueAt(v0);
        }
        else {
            long v0_1 = this.nextId;
            this.nextId = 1 + v0_1;
            this.motionEventToComposePointerIdMap.put(arg5, v0_1);
            v4 = v0_1;
        }

        return PointerId.constructor-impl(v4);
    }

    public final SparseLongArray getMotionEventToComposePointerIdMap$ui() {
        return this.motionEventToComposePointerIdMap;
    }

    public static void getMotionEventToComposePointerIdMap$ui$annotations() {
    }

    private final boolean hasPointerId(MotionEvent arg4, int arg5) {
        int v3 = arg4.getPointerCount();
        int v1;
        for(v1 = 0; v1 < v3; ++v1) {
            if(arg4.getPointerId(v1) == arg5) {
                return 1;
            }
        }

        return 0;
    }

    private final void removeStaleIds(MotionEvent arg5) {
        int v0 = arg5.getActionMasked();
        if(v0 == 1 || v0 == 6) {
            v0 = arg5.getPointerId(arg5.getActionIndex());
            if(!this.activeHoverIds.get(v0, false)) {
                this.motionEventToComposePointerIdMap.delete(v0);
                this.activeHoverIds.delete(v0);
            }
        }
        else {
        }

        if(this.motionEventToComposePointerIdMap.size() > arg5.getPointerCount()) {
            for(v0 = this.motionEventToComposePointerIdMap.size() - 1; -1 < v0; --v0) {
                int v1 = this.motionEventToComposePointerIdMap.keyAt(v0);
                if(!this.hasPointerId(arg5, v1)) {
                    this.motionEventToComposePointerIdMap.removeAt(v0);
                    this.activeHoverIds.delete(v1);
                }
            }
        }
    }
}

