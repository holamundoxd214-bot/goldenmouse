package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntSize;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0004\u001A@\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u00062\u0010\b\u0002\u0010\b\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0000\u001A(\u0010\u000B\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u0006H\u0000\u001A(\u0010\f\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00062\b\b\u0002\u0010\u000E\u001A\u00020\u0006H\u0000\u001A\u0014\u0010\u000F\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0003H\u0000\u001AA\u0010\u0016\u001A\u00020\u0015*\u001E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0011j\u0002`\u00172\u0006\u0010\u0018\u001A\u00020\u00122\b\b\u0002\u0010\u0019\u001A\u00020\u0014H\u0000¢\u0006\u0004\b\u001A\u0010\u001B\u001AI\u0010\u001C\u001A\u00020\u0015*\u001E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0011j\u0002`\u00172\u0006\u0010\u0018\u001A\u00020\u00122\u0006\u0010\u001D\u001A\u00020\u00132\b\b\u0002\u0010\u0019\u001A\u00020\u0014H\u0000¢\u0006\u0004\b\u001E\u0010\u001F\u001AU\u0010 \u001A\u00020\u0015*\u001E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0011j\u0002`\u00172\u0006\u0010\u0018\u001A\u00020\u00122\u0012\u0010!\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00130\"\"\u00020\u00132\b\b\u0002\u0010\u0019\u001A\u00020\u0014H\u0000¢\u0006\u0004\b#\u0010$\u001AO\u0010 \u001A\u00020\u0015*\u001E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0011j\u0002`\u00172\u0006\u0010\u0018\u001A\u00020\u00122\f\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00130\t2\b\b\u0002\u0010\u0019\u001A\u00020\u0014H\u0000¢\u0006\u0004\b#\u0010%*<\b\u0000\u0010\u0010\"\u001A\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00112\u001A\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0011¨\u0006&"}, d2={"down", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "id", "", "durationMillis", "x", "", "y", "historicalData", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "moveTo", "moveBy", "dx", "dy", "up", "PointerInputHandler", "Lkotlin/Function3;", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "Landroidx/compose/ui/unit/IntSize;", "", "invokeOverAllPasses", "Landroidx/compose/ui/input/pointer/PointerInputHandler;", "pointerEvent", "size", "invokeOverAllPasses-H0pRuoY", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "invokeOverPass", "pointerEventPass", "invokeOverPass-hUlJWOE", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "invokeOverPasses", "pointerEventPasses", "", "invokeOverPasses-hUlJWOE", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;[Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;Ljava/util/List;J)V", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PointerInputTestUtilKt {
    public static final PointerInputChange down(long arg20, long arg22, float arg24, float arg25, List arg26) {
        PointerInputChange v0 = new PointerInputChange(PointerId.constructor-impl(arg20), arg22, Offset.constructor-impl((((long)Float.floatToRawIntBits(arg24))) << 0x20 | (((long)Float.floatToRawIntBits(arg25))) & 0xFFFFFFFFL), true, 1f, arg22, Offset.constructor-impl((((long)Float.floatToRawIntBits(arg24))) << 0x20 | (((long)Float.floatToRawIntBits(arg25))) & 0xFFFFFFFFL), false, false, 0, 0, 0x600, null);
        List v1 = arg26;
        if(v1 != null) {
            if(((Collection)v1).isEmpty()) {
            }
            else {
                v0 = PointerInputChange.copy-OHpmEuE$default(v0, 0, 0, 0, false, 0, 0, false, 0, arg26, 0, 0x2FF, null);
            }
        }

        return v0;
    }

    public static PointerInputChange down$default(long arg7, long arg9, float arg11, float arg12, List arg13, int arg14, Object arg15) {
        if((arg14 & 2) != 0) {
            arg9 = 0;
        }

        long v2 = arg9;
        float v4 = (arg14 & 4) != 0 ? 0f : arg11;
        float v5 = (arg14 & 8) != 0 ? 0f : arg12;
        if((arg14 & 16) != 0) {
            arg13 = null;
        }

        return PointerInputTestUtilKt.down(arg7, v2, v4, v5, arg13);
    }

    public static final void invokeOverAllPasses-H0pRuoY(Function3 arg3, PointerEvent arg4, long arg5) {
        PointerInputTestUtilKt.invokeOverPasses-hUlJWOE(arg3, arg4, CollectionsKt.listOf(new PointerEventPass[]{PointerEventPass.Initial, PointerEventPass.Main, PointerEventPass.Final}), arg5);
    }

    public static void invokeOverAllPasses-H0pRuoY$default(Function3 arg0, PointerEvent arg1, long arg2, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = IntSize.constructor-impl(0x7FFFFFFF7FFFFFFFL);
        }

        PointerInputTestUtilKt.invokeOverAllPasses-H0pRuoY(arg0, arg1, arg2);
    }

    public static final void invokeOverPass-hUlJWOE(Function3 arg0, PointerEvent arg1, PointerEventPass arg2, long arg3) {
        PointerInputTestUtilKt.invokeOverPasses-hUlJWOE(arg0, arg1, CollectionsKt.listOf(arg2), arg3);
    }

    public static void invokeOverPass-hUlJWOE$default(Function3 arg0, PointerEvent arg1, PointerEventPass arg2, long arg3, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = IntSize.constructor-impl(0x7FFFFFFF7FFFFFFFL);
        }

        PointerInputTestUtilKt.invokeOverPass-hUlJWOE(arg0, arg1, arg2, arg3);
    }

    public static final void invokeOverPasses-hUlJWOE(Function3 arg4, PointerEvent arg5, List arg6, long arg7) {
        if(!arg5.getChanges().isEmpty()) {
            List v0 = arg6;
            if(!((Collection)v0).isEmpty()) {
                int v0_1 = ((Collection)v0).size();
                int v1;
                for(v1 = 0; v1 < v0_1; ++v1) {
                    arg4.invoke(arg5, arg6.get(v1), IntSize.box-impl(arg7));
                }

                return;
            }

            throw new IllegalArgumentException("invokeOverPasses called with no passes".toString());
        }

        throw new IllegalArgumentException("invokeOverPasses called with no changes".toString());
    }

    public static final void invokeOverPasses-hUlJWOE(Function3 arg0, PointerEvent arg1, PointerEventPass[] arg2, long arg3) {
        PointerInputTestUtilKt.invokeOverPasses-hUlJWOE(arg0, arg1, ArraysKt.toList(((Object[])arg2)), arg3);
    }

    public static void invokeOverPasses-hUlJWOE$default(Function3 arg0, PointerEvent arg1, List arg2, long arg3, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = IntSize.constructor-impl(0x7FFFFFFF7FFFFFFFL);
        }

        PointerInputTestUtilKt.invokeOverPasses-hUlJWOE(arg0, arg1, arg2, arg3);
    }

    public static void invokeOverPasses-hUlJWOE$default(Function3 arg0, PointerEvent arg1, PointerEventPass[] arg2, long arg3, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = IntSize.constructor-impl(0x7FFFFFFF7FFFFFFFL);
        }

        PointerInputTestUtilKt.invokeOverPasses-hUlJWOE(arg0, arg1, arg2, arg3);
    }

    public static final PointerInputChange moveBy(PointerInputChange arg20, long arg21, float arg23, float arg24) {
        return new PointerInputChange(arg20.getId-J3iCeTQ(), arg20.getUptimeMillis() + arg21, Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg20.getPosition-F1C5BW0() & 0xFFFFFFFFL))) + arg24))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg20.getPosition-F1C5BW0() >> 0x20))) + arg23))) << 0x20), true, 1f, arg20.getUptimeMillis(), arg20.getPosition-F1C5BW0(), arg20.getPressed(), false, 0, 0, 0x600, null);
    }

    public static PointerInputChange moveBy$default(PointerInputChange arg1, long arg2, float arg4, float arg5, int arg6, Object arg7) {
        return PointerInputTestUtilKt.moveBy(arg1, arg2, 0f, 0f);
    }

    public static final PointerInputChange moveTo(PointerInputChange arg20, long arg21, float arg23, float arg24) {
        return new PointerInputChange(arg20.getId-J3iCeTQ(), arg21, Offset.constructor-impl((((long)Float.floatToRawIntBits(arg23))) << 0x20 | (((long)Float.floatToRawIntBits(arg24))) & 0xFFFFFFFFL), true, 1f, arg20.getUptimeMillis(), arg20.getPosition-F1C5BW0(), arg20.getPressed(), false, 0, 0, 0x600, null);
    }

    public static PointerInputChange moveTo$default(PointerInputChange arg1, long arg2, float arg4, float arg5, int arg6, Object arg7) {
        return PointerInputTestUtilKt.moveTo(arg1, arg2, 0f, 0f);
    }

    public static final PointerInputChange up(PointerInputChange arg20, long arg21) {
        return new PointerInputChange(arg20.getId-J3iCeTQ(), arg21, arg20.getPosition-F1C5BW0(), false, 1f, arg20.getUptimeMillis(), arg20.getPosition-F1C5BW0(), arg20.getPressed(), false, 0, 0, 0x600, null);
    }
}

