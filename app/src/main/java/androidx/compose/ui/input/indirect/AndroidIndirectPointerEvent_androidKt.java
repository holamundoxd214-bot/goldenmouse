package androidx.compose.ui.input.indirect;

import android.view.InputDevice$MotionRange;
import android.view.InputDevice;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerId;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u001A-\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00012\b\b\u0002\u0010\u0007\u001A\u00020\b2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\n\u0010\u000B\u001A\u0015\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0000¢\u0006\u0002\u0010\u0010\u001A\u0015\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0006\u001A\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0012\"\u0015\u0010\u0000\u001A\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u000E\u0010\u0013\u001A\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"nativeEvent", "Landroid/view/MotionEvent;", "Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "getNativeEvent", "(Landroidx/compose/ui/input/indirect/IndirectPointerEvent;)Landroid/view/MotionEvent;", "IndirectPointerEvent", "motionEvent", "primaryDirectionalMotionAxis", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "previousMotionEvent", "IndirectPointerEvent-eAXfkT4", "(Landroid/view/MotionEvent;ILandroid/view/MotionEvent;)Landroidx/compose/ui/input/indirect/IndirectPointerEvent;", "convertActionToIndirectPointerEventType", "Landroidx/compose/ui/input/indirect/IndirectPointerEventType;", "actionMasked", "", "(I)I", "indirectPrimaryDirectionalScrollAxis", "(Landroid/view/MotionEvent;)I", "RATIO_CUTOFF", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidIndirectPointerEvent_androidKt {
    private static final float RATIO_CUTOFF = 5f;

    public static final IndirectPointerEvent IndirectPointerEvent-eAXfkT4(MotionEvent arg30, int arg31, MotionEvent arg32) {
        boolean v21;
        long v0_1;
        long v13_1;
        boolean v7_1;
        int v6;
        MotionEvent v4 = arg30;
        MotionEvent v0 = arg32;
        int v1 = v4.getActionMasked();
        if(v1 == 1) {
            v6 = 0;
        }
        else if(v1 != 6) {
            v6 = -1;
        }
        else {
            v6 = v4.getActionIndex();
        }

        Integer v7 = v0 != null ? Integer.valueOf(v0.getActionMasked()) : null;
        if(v7 == null || v7.intValue() != 0) {
            if(v7 == null) {
            }
            else {
                if(v7.intValue() != 5) {
                    goto label_26;
                }

                goto label_34;
            }

        label_26:
            if(v7 == null) {
            }
            else if(v7.intValue() == 2) {
                goto label_34;
            }

            v7_1 = false;
        }
        else {
        label_34:
            v7_1 = true;
        }

        long v11 = v4.getEventTime();
        int v8 = v4.getPointerCount();
        ArrayList v9 = new ArrayList(v8);
        int v10 = 0;
        while(v10 < v8) {
            int v13 = v4.getPointerId(v10);
            long v14 = PointerId.constructor-impl(((long)v13));
            float v16 = v4.getX(v10);
            float v17 = v4.getY(v10);
            long v3 = ((long)Float.floatToRawIntBits(v16));
            int v23 = v6;
            long v5 = ((long)Float.floatToRawIntBits(v17));
            int v2 = 0x20;
            long v16_1 = 0xFFFFFFFFL;
            v3 = Offset.constructor-impl(v3 << v2 | v5 & v16_1);
            v6 = v23;
            long v18 = v14;
            boolean v15 = v10 != v6 ? true : false;
            int v5_1 = v0 != null ? v0.findPointerIndex(v13) : -1;
            if(v5_1 >= 0) {
                Intrinsics.checkNotNull(v0);
                v13_1 = v0.getEventTime();
                v23 = v1;
                v0_1 = Offset.constructor-impl((((long)Float.floatToRawIntBits(v0.getX(v5_1)))) << v2 | (((long)Float.floatToRawIntBits(v0.getY(v5_1)))) & v16_1);
                v21 = v7_1;
            }
            else {
                v23 = v1;
                v0_1 = v3;
                v13_1 = v11;
                v21 = false;
            }

            v9.add(new IndirectPointerInputChange(v18, v11, v3, v15, arg30.getPressure(v10), v13_1, v0_1, v21, null));
            ++v10;
            v9 = v9;
            v8 = v8;
            v4 = arg30;
            v1 = v23;
            v0 = arg32;
        }

        return new AndroidIndirectPointerEvent(v9, AndroidIndirectPointerEvent_androidKt.convertActionToIndirectPointerEventType(v1), arg31, arg30, null);
    }

    public static IndirectPointerEvent IndirectPointerEvent-eAXfkT4$default(MotionEvent arg0, int arg1, MotionEvent arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg1 = IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getNone-nZO2Niw();
        }

        if((arg3 & 4) != 0) {
            arg2 = null;
        }

        return AndroidIndirectPointerEvent_androidKt.IndirectPointerEvent-eAXfkT4(arg0, arg1, arg2);
    }

    public static final int convertActionToIndirectPointerEventType(int arg1) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                if(arg1 == 2) {
                    return IndirectPointerEventType.Companion.getMove-4ZHQPSE();
                }
                else if(arg1 == 5) {
                    goto label_18;
                }
                else if(arg1 != 6) {
                    return IndirectPointerEventType.Companion.getUnknown-4ZHQPSE();
                }
            }

            return IndirectPointerEventType.Companion.getRelease-4ZHQPSE();
        }

    label_18:
        return IndirectPointerEventType.Companion.getPress-4ZHQPSE();
    }

    public static final MotionEvent getNativeEvent(IndirectPointerEvent arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.ui.input.indirect.AndroidIndirectPointerEvent");
        return ((AndroidIndirectPointerEvent)arg1).getNativeEvent$ui();
    }

    public static final int indirectPrimaryDirectionalScrollAxis(MotionEvent arg4) {
        if(arg4.isFromSource(0x200000)) {
            InputDevice v4 = arg4.getDevice();
            if(v4 != null) {
                InputDevice$MotionRange v0 = v4.getMotionRange(0);
                InputDevice$MotionRange v4_1 = v4.getMotionRange(1);
                if(v0 != null && v4_1 == null) {
                    return IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getX-nZO2Niw();
                }

                if(v4_1 != null && v0 == null) {
                    return IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getY-nZO2Niw();
                }

                if(v0 == null) {
                    goto label_42;
                }

                if(v4_1 == null) {
                    goto label_42;
                }

                float v0_1 = v0.getRange();
                float v4_2 = v4_1.getRange();
                float v2 = 5f;
                if(Float.compare(v0_1, v4_2) > 0) {
                    if(v4_2 == 0f) {
                    }
                    else {
                        if(v0_1 / v4_2 >= v2) {
                            goto label_31;
                        }

                        goto label_34;
                    }

                label_31:
                    return IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getX-nZO2Niw();
                }

            label_34:
                if(v4_2 <= v0_1) {
                    goto label_42;
                }

                if(v0_1 == 0f) {
                }
                else {
                    if(v4_2 / v0_1 >= v2) {
                        goto label_39;
                    }

                    goto label_42;
                }

            label_39:
                return IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getY-nZO2Niw();
            }

        label_42:
            return IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getNone-nZO2Niw();
        }

        throw new IllegalArgumentException("MotionEvent must be a touch navigation source".toString());
    }
}

