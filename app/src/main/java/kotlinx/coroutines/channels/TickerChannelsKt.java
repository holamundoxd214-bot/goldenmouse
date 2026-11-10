package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A4\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007\u001A,\u0010\n\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00020\fH\u0082@¢\u0006\u0002\u0010\r\u001A,\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00020\fH\u0082@¢\u0006\u0002\u0010\r¨\u0006\u000F"}, d2={"ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "delayMillis", "", "initialDelayMillis", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "fixedPeriodTicker", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedDelayTicker", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class TickerChannelsKt {
    public static final Object access$fixedDelayTicker(long arg0, long arg2, SendChannel arg4, Continuation arg5) {
        return TickerChannelsKt.fixedDelayTicker(arg0, arg2, arg4, arg5);
    }

    public static final Object access$fixedPeriodTicker(long arg0, long arg2, SendChannel arg4, Continuation arg5) {
        return TickerChannelsKt.fixedPeriodTicker(arg0, arg2, arg4, arg5);
    }

    private static final Object fixedDelayTicker(long arg6, long arg8, SendChannel arg10, Continuation arg11) {
        Object v8;
        Object v10;
        SendChannel v8_2;
        int v2;
        Continuation v0;
        if((arg11 instanceof TickerChannelsKt$fixedDelayTicker$1)) {
            v0 = arg11;
            v2 = 0x80000000;
            if((((TickerChannelsKt$fixedDelayTicker$1)v0).label & v2) != 0) {
                ((TickerChannelsKt$fixedDelayTicker$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            TickerChannelsKt$fixedDelayTicker$1 v0_1 = new TickerChannelsKt$fixedDelayTicker$1(arg11);
        }

        Object v11 = ((TickerChannelsKt$fixedDelayTicker$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((TickerChannelsKt$fixedDelayTicker$1)v0).label;
        int v3 = 3;
        int v4 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v11);
            ((TickerChannelsKt$fixedDelayTicker$1)v0).L$0 = arg10;
            ((TickerChannelsKt$fixedDelayTicker$1)v0).J$0 = arg6;
            ((TickerChannelsKt$fixedDelayTicker$1)v0).label = 1;
            if(DelayKt.delay(arg8, v0) == v1) {
                return v1;
            label_56:
                ((TickerChannelsKt$fixedDelayTicker$1)v0).L$0 = v8;
                ((TickerChannelsKt$fixedDelayTicker$1)v0).J$0 = arg6;
                ((TickerChannelsKt$fixedDelayTicker$1)v0).label = v3;
                if(DelayKt.delay(arg6, v0) != v1) {
                    goto label_26;
                }

                return v1;
            }
            else {
            label_48:
                Unit v8_1 = Unit.INSTANCE;
                ((TickerChannelsKt$fixedDelayTicker$1)v0).L$0 = v10;
                ((TickerChannelsKt$fixedDelayTicker$1)v0).J$0 = arg6;
                ((TickerChannelsKt$fixedDelayTicker$1)v0).label = v4;
                if(((SendChannel)v10).send(v8_1, v0) == v1) {
                    return v1;
                }
                else {
                    v8_2 = ((SendChannel)v10);
                    goto label_56;
                }
            }
        }
        else if(v2 == 1) {
            arg6 = ((TickerChannelsKt$fixedDelayTicker$1)v0).J$0;
            v10 = ((TickerChannelsKt$fixedDelayTicker$1)v0).L$0;
            ResultKt.throwOnFailure(v11);
            goto label_48;
        }
        else if(v2 == v4) {
            arg6 = ((TickerChannelsKt$fixedDelayTicker$1)v0).J$0;
            v8 = ((TickerChannelsKt$fixedDelayTicker$1)v0).L$0;
            ResultKt.throwOnFailure(v11);
            goto label_56;
        }
        else if(v2 == v3) {
            arg6 = ((TickerChannelsKt$fixedDelayTicker$1)v0).J$0;
            v8 = ((TickerChannelsKt$fixedDelayTicker$1)v0).L$0;
            ResultKt.throwOnFailure(v11);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_26:
        v10 = v8_2;
        goto label_48;
    }

    private static final Object fixedPeriodTicker(long arg18, long arg20, SendChannel arg22, Continuation arg23) {
        int v0_2;
        int v11;
        Object v3_1;
        long v9;
        long v7;
        long v10;
        long v16;
        TickerChannelsKt$fixedPeriodTicker$1 v1_1;
        int v3;
        Continuation v0 = arg23;
        if((v0 instanceof TickerChannelsKt$fixedPeriodTicker$1)) {
            Continuation v1 = v0;
            v3 = 0x80000000;
            if((((TickerChannelsKt$fixedPeriodTicker$1)v1).label & v3) != 0) {
                ((TickerChannelsKt$fixedPeriodTicker$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v1_1 = new TickerChannelsKt$fixedPeriodTicker$1(v0);
        }

        Object v0_1 = v1_1.result;
        Object v2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v3 = v1_1.label;
        int v4 = 4;
        int v5 = 3;
        int v6 = 2;
        if(v3 == 0) {
            ResultKt.throwOnFailure(v0_1);
            AbstractTimeSource v0_3 = AbstractTimeSourceKt.timeSource;
            long v8 = v0_3 != null ? v0_3.nanoTime() : System.nanoTime();
            v8 += EventLoop_commonKt.delayToNanos(arg20);
            SendChannel v0_4 = arg22;
            v1_1.L$0 = v0_4;
            v10 = arg18;
            v1_1.J$0 = v10;
            v1_1.J$1 = v8;
            v1_1.label = 1;
            if(DelayKt.delay(arg20, ((Continuation)v1_1)) == v2) {
            }
            else {
                v7 = v8;
            label_80:
                v9 = EventLoop_commonKt.delayToNanos(v10);
                goto label_81;
            }

            return v2;
        label_94:
            v0_3 = AbstractTimeSourceKt.timeSource;
            long v11_1 = v0_3 != null ? v0_3.nanoTime() : System.nanoTime();
            long v4_1 = 0;
            long v13 = RangesKt.coerceAtLeast(v9 - v11_1, v4_1);
            if(v13 == v4_1 && v7 != v4_1) {
                v4_1 = v7 - (v11_1 - v9) % v7;
                v9 = v11_1 + v4_1;
                v4_1 = EventLoop_commonKt.delayNanosToMillis(v4_1);
                v1_1.L$0 = v3_1;
                v1_1.J$0 = v9;
                v1_1.J$1 = v7;
                v0_2 = 3;
                v1_1.label = v0_2;
                if(DelayKt.delay(v4_1, ((Continuation)v1_1)) == v2) {
                    return v2;
                }
                else {
                    goto label_45;
                }
            }

            v0_2 = 3;
            v4_1 = EventLoop_commonKt.delayNanosToMillis(v13);
            v1_1.L$0 = v3_1;
            v1_1.J$0 = v9;
            v1_1.J$1 = v7;
            v11 = 4;
            v1_1.label = v11;
            if(DelayKt.delay(v4_1, ((Continuation)v1_1)) != v2) {
                goto label_32;
            }

            return v2;
        label_81:
            v7 += v9;
            Unit v3_2 = Unit.INSTANCE;
            v1_1.L$0 = v0_1;
            v1_1.J$0 = v7;
            v1_1.J$1 = v9;
            v1_1.label = v6;
            if(((SendChannel)v0_1).send(v3_2, ((Continuation)v1_1)) == v2) {
                return v2;
            }

            v16 = v9;
            v9 = v7;
            v7 = v16;
            v3_1 = v0_1;
            goto label_94;
        label_45:
            v16 = v9;
            v9 = v7;
            v7 = v16;
            v0_1 = v3_1;
            goto label_81;
        }
        else if(v3 == 1) {
            v7 = v1_1.J$1;
            v9 = v1_1.J$0;
            v3_1 = v1_1.L$0;
            ResultKt.throwOnFailure(v0_1);
            v0_1 = v3_1;
            v10 = v9;
            goto label_80;
        }
        else if(v3 == v6) {
            v7 = v1_1.J$1;
            v9 = v1_1.J$0;
            v3_1 = v1_1.L$0;
            ResultKt.throwOnFailure(v0_1);
            goto label_94;
        }
        else if(v3 == v5) {
            v7 = v1_1.J$1;
            v9 = v1_1.J$0;
            v3_1 = v1_1.L$0;
            ResultKt.throwOnFailure(v0_1);
            v0_2 = v5;
            goto label_45;
        }
        else if(v3 == v4) {
            v7 = v1_1.J$1;
            v9 = v1_1.J$0;
            v3_1 = v1_1.L$0;
            ResultKt.throwOnFailure(v0_1);
            v11 = v4;
            v0_2 = v5;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_32:
        v16 = v9;
        v9 = v7;
        v7 = v16;
        v0_1 = v3_1;
        goto label_81;
    }

    public static final ReceiveChannel ticker(long arg8, long arg10, CoroutineContext arg12, TickerMode arg13) {
        long v0 = 0;
        String v3 = " ms";
        if(Long.compare(arg8, v0) >= 0) {
            if(arg10 >= v0) {
                return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(arg12), 0, new TickerChannelsKt$ticker$3(arg13, arg8, arg10, null));
            }

            throw new IllegalArgumentException("Expected non-negative initial delay, but has " + arg10 + v3.toString());
        }

        throw new IllegalArgumentException("Expected non-negative delay, but has " + arg8 + v3.toString());
    }

    public static ReceiveChannel ticker$default(long arg0, long arg2, CoroutineContext arg4, TickerMode arg5, int arg6, Object arg7) {
        EmptyCoroutineContext v4;
        if((arg6 & 2) != 0) {
            arg2 = arg0;
        }

        if((arg6 & 4) != 0) {
            v4 = EmptyCoroutineContext.INSTANCE;
        }

        if((arg6 & 8) != 0) {
            arg5 = TickerMode.FIXED_PERIOD;
        }

        return TickerChannelsKt.ticker(arg0, arg2, ((CoroutineContext)v4), arg5);
    }
}

