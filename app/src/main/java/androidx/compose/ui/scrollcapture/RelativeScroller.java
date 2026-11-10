package androidx.compose.ui.scrollcapture;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000B\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\"\u0010\u0004\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000F\u001A\u00020\u0010J\u001E\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0014J\u001E\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0013\u001A\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0014J\u000E\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u0003J\u0016\u0010\u0018\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u0004\u001A\u00020\u00102\u0006\u0010\u001A\u001A\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0019R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0004\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001E\u0010\f\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\u0006@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u001B"}, d2={"Landroidx/compose/ui/scrollcapture/RelativeScroller;", "", "viewportSize", "", "scrollBy", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "<init>", "(ILkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "value", "scrollAmount", "getScrollAmount", "()F", "reset", "", "scrollRangeIntoView", "min", "max", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollRangeToCenter", "mapOffsetToViewport", "offset", "scrollTo", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delta", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class RelativeScroller {
    private float scrollAmount;
    private final Function2 scrollBy;
    private final int viewportSize;

    public RelativeScroller(int arg1, Function2 arg2) {
        super();
        this.viewportSize = arg1;
        this.scrollBy = arg2;
    }

    public static final Object access$scrollBy(RelativeScroller arg0, float arg1, Continuation arg2) {
        return arg0.scrollBy(arg1, arg2);
    }

    public final float getScrollAmount() {
        return this.scrollAmount;
    }

    public final int mapOffsetToViewport(int arg2) {
        return RangesKt.coerceIn(arg2 - MathKt.roundToInt(this.scrollAmount), 0, this.viewportSize);
    }

    public final void reset() {
        this.scrollAmount = 0f;
    }

    private final Object scrollBy(float arg5, Continuation arg6) {
        RelativeScroller$scrollBy$1 v0_1;
        int v2;
        if((arg6 instanceof RelativeScroller$scrollBy$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((RelativeScroller$scrollBy$1)v0).label & v2) != 0) {
                ((RelativeScroller$scrollBy$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new RelativeScroller$scrollBy$1(this, arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            Function2 v6_1 = this.scrollBy;
            Float v5 = Boxing.boxFloat(arg5);
            v0_1.label = 1;
            v6 = v6_1.invoke(v5, v0_1);
            if(v6 == v1) {
                return v1;
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v6);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        this.scrollAmount += ((Number)v6).floatValue();
        return Unit.INSTANCE;
    }

    public final Object scrollRangeIntoView(int arg6, int arg7, Continuation arg8) {
        if(arg6 <= arg7) {
            int v0 = arg7 - arg6;
            int v1 = this.viewportSize;
            if(v0 <= v1) {
                float v0_1 = ((float)arg6);
                float v2 = this.scrollAmount;
                if(v0_1 >= v2 && (((float)arg7)) <= (((float)v1)) + v2) {
                    return Unit.INSTANCE;
                }

                if(v0_1 < v2) {
                }
                else {
                    arg6 = arg7 - v1;
                }

                Object v5 = this.scrollTo(((float)arg6), arg8);
                if(v5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return v5;
                }

                return Unit.INSTANCE;
            }

            throw new IllegalArgumentException("Expected range (" + v0 + ") to be ≤ viewportSize=" + this.viewportSize.toString());
        }

        throw new IllegalArgumentException("Expected min=" + arg6 + " ≤ max=" + arg7.toString());
    }

    public final Object scrollRangeToCenter(int arg5, int arg6, Continuation arg7) {
        if(arg5 <= arg6) {
            int v0 = arg6 - arg5;
            int v1 = this.viewportSize;
            if(v0 <= v1) {
                float v3 = this.scrollAmount;
                if((((float)arg5)) >= v3 && (((float)arg6)) <= v3 + (((float)v1))) {
                    return Unit.INSTANCE;
                }

                Object v4 = this.scrollTo(((float)(arg5 + v0 / 2 - v1 / 2)), arg7);
                if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return v4;
                }

                return Unit.INSTANCE;
            }

            throw new IllegalArgumentException("Expected range (" + v0 + ") to be ≤ viewportSize=" + this.viewportSize.toString());
        }

        throw new IllegalArgumentException("Expected min=" + arg5 + " ≤ max=" + arg6.toString());
    }

    public final Object scrollTo(float arg2, Continuation arg3) {
        Object v1 = this.scrollBy(arg2 - this.scrollAmount, arg3);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }
}

