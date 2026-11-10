package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function4;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\u001A~\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042`\u0010\u0005\u001A\\\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u00020\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u000F\u001A\n\u0010\u0010\u001A\u00020\f*\u00020\u0011\u001A\u0013\u0010\u0012\u001A\u00020\f*\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001A\n\u0010\u0015\u001A\u00020\f*\u00020\u0011\u001A\u000F\u0010\u0016\u001A\u00020\u0007*\u00020\u0011¢\u0006\u0002\u0010\u0017\u001A\u0014\u0010\u0018\u001A\u00020\f*\u00020\u00112\b\b\u0002\u0010\u0019\u001A\u00020\u0004\u001A\u0019\u0010\u001A\u001A\u00020\u0007*\u00020\u00112\b\b\u0002\u0010\u0019\u001A\u00020\u0004¢\u0006\u0002\u0010\u001B¨\u0006\u001C"}, d2={"detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "", "onGesture", "Lkotlin/Function4;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "centroid", "pan", "", "zoom", "rotation", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRotation", "Landroidx/compose/ui/input/pointer/PointerEvent;", "angle", "angle-k-4lQ0M", "(J)F", "calculateZoom", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateCentroidSize", "useCurrent", "calculateCentroid", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TransformGestureDetectorKt {
    private static final float angle-k-4lQ0M(long arg7) {
        int v0 = ((int)(arg7 >> 0x20));
        long v3 = 0xFFFFFFFFL;
        if(Float.compare(Float.intBitsToFloat(v0), 0f) == 0 && Float.intBitsToFloat(((int)(arg7 & v3))) == 0f) {
            return 0;
        }

        return -(((float)Math.atan2(((double)Float.intBitsToFloat(v0)), ((double)Float.intBitsToFloat(((int)(arg7 & v3))))))) * 180f / 3.141593f;
    }

    public static final long calculateCentroid(PointerEvent arg7, boolean arg8) {
        long v0 = Offset.Companion.getZero-F1C5BW0();
        List v7 = arg7.getChanges();
        int v2 = v7.size();
        int v3 = 0;
        int v4 = 0;
        while(v3 < v2) {
            Object v5 = v7.get(v3);
            if((((PointerInputChange)v5).getPressed()) && (((PointerInputChange)v5).getPreviousPressed())) {
                long v5_1 = arg8 ? ((PointerInputChange)v5).getPosition-F1C5BW0() : ((PointerInputChange)v5).getPreviousPosition-F1C5BW0();
                v0 = Offset.plus-MK-Hz9U(v0, v5_1);
                ++v4;
            }

            ++v3;
        }

        if(v4 == 0) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }

        return Offset.div-tuRUvjQ(v0, ((float)v4));
    }

    public static long calculateCentroid$default(PointerEvent arg0, boolean arg1, int arg2, Object arg3) {
        return TransformGestureDetectorKt.calculateCentroid(arg0, true);
    }

    public static final float calculateCentroidSize(PointerEvent arg8, boolean arg9) {
        long v0 = TransformGestureDetectorKt.calculateCentroid(arg8, arg9);
        float v3 = 0f;
        if(Offset.equals-impl0(v0, Offset.Companion.getUnspecified-F1C5BW0())) {
            return 0;
        }

        List v8 = arg8.getChanges();
        int v2 = v8.size();
        int v4 = 0;
        int v5 = 0;
        while(v4 < v2) {
            Object v6 = v8.get(v4);
            if((((PointerInputChange)v6).getPressed()) && (((PointerInputChange)v6).getPreviousPressed())) {
                long v6_1 = arg9 ? ((PointerInputChange)v6).getPosition-F1C5BW0() : ((PointerInputChange)v6).getPreviousPosition-F1C5BW0();
                v3 += Offset.getDistance-impl(Offset.minus-MK-Hz9U(v6_1, v0));
                ++v5;
            }

            ++v4;
        }

        return v3 / (((float)v5));
    }

    public static float calculateCentroidSize$default(PointerEvent arg0, boolean arg1, int arg2, Object arg3) {
        return TransformGestureDetectorKt.calculateCentroidSize(arg0, true);
    }

    public static final long calculatePan(PointerEvent arg4) {
        long v0 = TransformGestureDetectorKt.calculateCentroid(arg4, true);
        if(Offset.equals-impl0(v0, Offset.Companion.getUnspecified-F1C5BW0())) {
            return Offset.Companion.getZero-F1C5BW0();
        }

        return Offset.minus-MK-Hz9U(v0, TransformGestureDetectorKt.calculateCentroid(arg4, false));
    }

    public static final float calculateRotation(PointerEvent arg15) {
        List v0 = arg15.getChanges();
        int v1 = v0.size();
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        while(true) {
            int v5 = 1;
            if(v3 >= v1) {
                break;
            }

            Object v6 = v0.get(v3);
            if(!((PointerInputChange)v6).getPreviousPressed() || !((PointerInputChange)v6).getPressed()) {
                v5 = 0;
            }
            else {
            }

            v4 += v5;
            ++v3;
        }

        if(v4 < 2) {
            return 0;
        }

        long v3_1 = TransformGestureDetectorKt.calculateCentroid(arg15, true);
        long v5_1 = TransformGestureDetectorKt.calculateCentroid(arg15, false);
        List v15 = arg15.getChanges();
        int v0_1 = v15.size();
        float v7 = 0f;
        float v8 = 0f;
        while(v2 < v0_1) {
            Object v9 = v15.get(v2);
            if((((PointerInputChange)v9).getPressed()) && (((PointerInputChange)v9).getPreviousPressed())) {
                long v10 = ((PointerInputChange)v9).getPosition-F1C5BW0();
                long v12 = Offset.minus-MK-Hz9U(((PointerInputChange)v9).getPreviousPosition-F1C5BW0(), v5_1);
                long v9_1 = Offset.minus-MK-Hz9U(v10, v3_1);
                float v14 = TransformGestureDetectorKt.angle-k-4lQ0M(v9_1) - TransformGestureDetectorKt.angle-k-4lQ0M(v12);
                float v9_2 = Offset.getDistance-impl(Offset.plus-MK-Hz9U(v9_1, v12)) / 2f;
                float v11 = 360f;
                if(Float.compare(v14, 180f) > 0) {
                    v14 -= v11;
                }
                else if(v14 < -180f) {
                    v14 += v11;
                }

                v8 += v14 * v9_2;
                v7 += v9_2;
            }

            ++v2;
        }

        if(v7 == 0f) {
            return 0;
        }

        return v8 / v7;
    }

    public static final float calculateZoom(PointerEvent arg3) {
        float v0 = TransformGestureDetectorKt.calculateCentroidSize(arg3, true);
        float v3 = TransformGestureDetectorKt.calculateCentroidSize(arg3, false);
        if(v0 == 0f) {
        }
        else {
            if(v3 == 0f) {
                return 1f;
            }

            goto label_10;
        }

        return 1f;
    label_10:
        return v0 / v3;
    }

    public static final Object detectTransformGestures(PointerInputScope arg2, boolean arg3, Function4 arg4, Continuation arg5) {
        Object v2 = ForEachGestureKt.awaitEachGesture(arg2, new TransformGestureDetectorKt$detectTransformGestures$2(arg3, arg4, null), arg5);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }

    public static Object detectTransformGestures$default(PointerInputScope arg0, boolean arg1, Function4 arg2, Continuation arg3, int arg4, Object arg5) {
        return TransformGestureDetectorKt.detectTransformGestures(arg0, false, arg2, arg3);
    }
}

