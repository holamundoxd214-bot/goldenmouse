package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.indirect.IndirectPointerEventPrimaryDirectionalMotionAxis;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import kotlin.Metadata;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u001A\'\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0003¢\u0006\u0004\b\u0007\u0010\b\u001A\'\u0010\t\u001A\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0003¢\u0006\u0004\b\n\u0010\b\u001A\f\u0010\u000B\u001A\u00020\f*\u00020\u0002H\u0003\u001A\f\u0010\r\u001A\u00020\f*\u00020\u0002H\u0003\u001A\f\u0010\u000E\u001A\u00020\f*\u00020\u0002H\u0003\u001A1\u0010\u000F\u001A\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001A\u00020\fH\u0003¢\u0006\u0004\b\u0011\u0010\u0012\u001A\'\u0010\u0013\u001A\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\b\u001A\'\u0010\u0013\u001A\u00020\u0001*\u00020\u00012\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001A\'\u0010\u0017\u001A\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\b\u001A?\u0010\u0019\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u0001H\u0002¢\u0006\u0004\b \u0010!\"\u000E\u0010\"\u001A\u00020#X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010$\u001A\u00020#X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"positionChange", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "primaryDirectionalMotionAxis", "Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;", "positionChange-_bfSUIo", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;)J", "positionChangeIgnoreConsumed", "positionChangeIgnoreConsumed-_bfSUIo", "changedToUpIgnoreConsumed", "", "changedToDown", "changedToDownIgnoreConsumed", "positionChangeInternal", "ignoreConsumed", "positionChangeInternal-wfG_k4k", "(Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;Z)J", "primaryAxisPosition", "primaryAxisPosition-_bfSUIo", "primaryAxisPosition-grjNGvw", "(JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;)J", "primaryAxisPreviousPosition", "primaryAxisPreviousPosition-_bfSUIo", "addIndirectPointerInputChange", "", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "event", "smoother", "Landroidx/compose/foundation/gestures/IndirectPointerInputEventSmoother;", "nodeOffset", "addIndirectPointerInputChange-Qf4Zb88", "(Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/ui/input/indirect/IndirectPointerInputChange;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/input/indirect/IndirectPointerEventPrimaryDirectionalMotionAxis;Landroidx/compose/foundation/gestures/IndirectPointerInputEventSmoother;J)V", "SmoothingFactor", "", "PixelSensibility", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class IndirectPointerInputDragCycleDetectorKt {
    private static final int PixelSensibility = 2;
    private static final int SmoothingFactor = 3;

    public static final void access$addIndirectPointerInputChange-Qf4Zb88(VelocityTracker arg0, IndirectPointerInputChange arg1, Orientation arg2, IndirectPointerEventPrimaryDirectionalMotionAxis arg3, IndirectPointerInputEventSmoother arg4, long arg5) {
        IndirectPointerInputDragCycleDetectorKt.addIndirectPointerInputChange-Qf4Zb88(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final boolean access$changedToDownIgnoreConsumed(IndirectPointerInputChange arg0) {
        return IndirectPointerInputDragCycleDetectorKt.changedToDownIgnoreConsumed(arg0);
    }

    public static final boolean access$changedToUpIgnoreConsumed(IndirectPointerInputChange arg0) {
        return IndirectPointerInputDragCycleDetectorKt.changedToUpIgnoreConsumed(arg0);
    }

    public static final long access$positionChange-_bfSUIo(IndirectPointerInputChange arg0, Orientation arg1, IndirectPointerEventPrimaryDirectionalMotionAxis arg2) {
        return IndirectPointerInputDragCycleDetectorKt.positionChange-_bfSUIo(arg0, arg1, arg2);
    }

    public static final long access$positionChangeIgnoreConsumed-_bfSUIo(IndirectPointerInputChange arg0, Orientation arg1, IndirectPointerEventPrimaryDirectionalMotionAxis arg2) {
        return IndirectPointerInputDragCycleDetectorKt.positionChangeIgnoreConsumed-_bfSUIo(arg0, arg1, arg2);
    }

    public static final long access$primaryAxisPosition-_bfSUIo(IndirectPointerInputChange arg0, Orientation arg1, IndirectPointerEventPrimaryDirectionalMotionAxis arg2) {
        return IndirectPointerInputDragCycleDetectorKt.primaryAxisPosition-_bfSUIo(arg0, arg1, arg2);
    }

    public static final long access$primaryAxisPreviousPosition-_bfSUIo(IndirectPointerInputChange arg0, Orientation arg1, IndirectPointerEventPrimaryDirectionalMotionAxis arg2) {
        return IndirectPointerInputDragCycleDetectorKt.primaryAxisPreviousPosition-_bfSUIo(arg0, arg1, arg2);
    }

    private static final void addIndirectPointerInputChange-Qf4Zb88(VelocityTracker arg2, IndirectPointerInputChange arg3, Orientation arg4, IndirectPointerEventPrimaryDirectionalMotionAxis arg5, IndirectPointerInputEventSmoother arg6, long arg7) {
        arg2.addPosition-Uv8p0NA(arg3.getUptimeMillis(), Offset.plus-MK-Hz9U(IndirectPointerInputDragCycleDetectorKt.primaryAxisPosition-grjNGvw(arg6.smoothEventPosition-tuRUvjQ(arg3), arg4, arg5), arg7));
    }

    private static final boolean changedToDown(IndirectPointerInputChange arg1) {
        if(!arg1.isConsumed() && !arg1.getPreviousPressed() && (arg1.getPressed())) {
            return 1;
        }

        return 0;
    }

    private static final boolean changedToDownIgnoreConsumed(IndirectPointerInputChange arg1) {
        if(!arg1.getPreviousPressed() && (arg1.getPressed())) {
            return 1;
        }

        return 0;
    }

    private static final boolean changedToUpIgnoreConsumed(IndirectPointerInputChange arg1) {
        if((arg1.getPreviousPressed()) && !arg1.getPressed()) {
            return 1;
        }

        return 0;
    }

    private static final long positionChange-_bfSUIo(IndirectPointerInputChange arg1, Orientation arg2, IndirectPointerEventPrimaryDirectionalMotionAxis arg3) {
        return IndirectPointerInputDragCycleDetectorKt.positionChangeInternal-wfG_k4k(arg1, arg2, arg3, false);
    }

    private static final long positionChangeIgnoreConsumed-_bfSUIo(IndirectPointerInputChange arg1, Orientation arg2, IndirectPointerEventPrimaryDirectionalMotionAxis arg3) {
        return IndirectPointerInputDragCycleDetectorKt.positionChangeInternal-wfG_k4k(arg1, arg2, arg3, true);
    }

    private static final long positionChangeInternal-wfG_k4k(IndirectPointerInputChange arg2, Orientation arg3, IndirectPointerEventPrimaryDirectionalMotionAxis arg4, boolean arg5) {
        long v3 = Offset.minus-MK-Hz9U(IndirectPointerInputDragCycleDetectorKt.primaryAxisPosition-_bfSUIo(arg2, arg3, arg4), IndirectPointerInputDragCycleDetectorKt.primaryAxisPreviousPosition-_bfSUIo(arg2, arg3, arg4));
        if(!arg5 && (arg2.isConsumed())) {
            return Offset.Companion.getZero-F1C5BW0();
        }

        return v3;
    }

    static long positionChangeInternal-wfG_k4k$default(IndirectPointerInputChange arg0, Orientation arg1, IndirectPointerEventPrimaryDirectionalMotionAxis arg2, boolean arg3, int arg4, Object arg5) {
        return IndirectPointerInputDragCycleDetectorKt.positionChangeInternal-wfG_k4k(arg0, arg1, arg2, false);
    }

    private static final long primaryAxisPosition-_bfSUIo(IndirectPointerInputChange arg5, Orientation arg6, IndirectPointerEventPrimaryDirectionalMotionAxis arg7) {
        float v5;
        if(arg6 == null) {
            return arg5.getPosition-F1C5BW0();
        }

        int v0 = IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getX-nZO2Niw();
        boolean v1 = false;
        boolean v0_1 = arg7 == null ? false : IndirectPointerEventPrimaryDirectionalMotionAxis.equals-impl0(arg7.unbox-impl(), v0);
        long v2 = 0xFFFFFFFFL;
        int v4 = 0x20;
        if(v0_1) {
            v5 = Float.intBitsToFloat(((int)(arg5.getPosition-F1C5BW0() >> v4)));
        }
        else {
            v0 = IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getY-nZO2Niw();
            if(arg7 == null) {
            }
            else {
                v1 = IndirectPointerEventPrimaryDirectionalMotionAxis.equals-impl0(arg7.unbox-impl(), v0);
            }

            if(!v1) {
                goto label_51;
            }

            v5 = Float.intBitsToFloat(((int)(arg5.getPosition-F1C5BW0() & v2)));
        }

        if(arg6 == Orientation.Horizontal) {
            return Offset.constructor-impl((((long)Float.floatToRawIntBits(v5))) << v4 | (((long)Float.floatToRawIntBits(0f))) & v2);
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << v4 | (((long)Float.floatToRawIntBits(v5))) & v2);
    label_51:
        return arg5.getPosition-F1C5BW0();
    }

    private static final long primaryAxisPosition-grjNGvw(long arg5, Orientation arg7, IndirectPointerEventPrimaryDirectionalMotionAxis arg8) {
        float v5;
        if(arg7 == null) {
        }
        else {
            int v0 = IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getX-nZO2Niw();
            boolean v1 = false;
            boolean v0_1 = arg8 == null ? false : IndirectPointerEventPrimaryDirectionalMotionAxis.equals-impl0(arg8.unbox-impl(), v0);
            long v2 = 0xFFFFFFFFL;
            int v4 = 0x20;
            if(v0_1) {
                v5 = Float.intBitsToFloat(((int)(arg5 >> v4)));
            }
            else {
                v0 = IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getY-nZO2Niw();
                if(arg8 == null) {
                }
                else {
                    v1 = IndirectPointerEventPrimaryDirectionalMotionAxis.equals-impl0(arg8.unbox-impl(), v0);
                }

                if(!v1) {
                    return arg5;
                }

                v5 = Float.intBitsToFloat(((int)(arg5 & v2)));
            }

            if(arg7 == Orientation.Horizontal) {
                return Offset.constructor-impl((((long)Float.floatToRawIntBits(v5))) << v4 | (((long)Float.floatToRawIntBits(0f))) & v2);
            }

            arg5 = Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << v4 | (((long)Float.floatToRawIntBits(v5))) & v2);
        }

        return arg5;
    }

    private static final long primaryAxisPreviousPosition-_bfSUIo(IndirectPointerInputChange arg5, Orientation arg6, IndirectPointerEventPrimaryDirectionalMotionAxis arg7) {
        float v5;
        if(arg6 == null) {
            return arg5.getPreviousPosition-F1C5BW0();
        }

        int v0 = IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getX-nZO2Niw();
        boolean v1 = false;
        boolean v0_1 = arg7 == null ? false : IndirectPointerEventPrimaryDirectionalMotionAxis.equals-impl0(arg7.unbox-impl(), v0);
        long v2 = 0xFFFFFFFFL;
        int v4 = 0x20;
        if(v0_1) {
            v5 = Float.intBitsToFloat(((int)(arg5.getPreviousPosition-F1C5BW0() >> v4)));
        }
        else {
            v0 = IndirectPointerEventPrimaryDirectionalMotionAxis.Companion.getY-nZO2Niw();
            if(arg7 == null) {
            }
            else {
                v1 = IndirectPointerEventPrimaryDirectionalMotionAxis.equals-impl0(arg7.unbox-impl(), v0);
            }

            if(!v1) {
                goto label_51;
            }

            v5 = Float.intBitsToFloat(((int)(arg5.getPreviousPosition-F1C5BW0() & v2)));
        }

        if(arg6 == Orientation.Horizontal) {
            return Offset.constructor-impl((((long)Float.floatToRawIntBits(v5))) << v4 | (((long)Float.floatToRawIntBits(0f))) & v2);
        }

        return Offset.constructor-impl((((long)Float.floatToRawIntBits(0f))) << v4 | (((long)Float.floatToRawIntBits(v5))) & v2);
    label_51:
        return arg5.getPreviousPosition-F1C5BW0();
    }
}

