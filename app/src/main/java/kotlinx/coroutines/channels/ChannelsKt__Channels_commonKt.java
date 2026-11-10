package kotlinx.coroutines.channels;

import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u001A$\u0010\u0002\u001A\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0087@¢\u0006\u0002\u0010\u0006\u001A$\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\b\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0007\u001AP\u0010\t\u001A\u0002H\n\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u001D\u0010\u000B\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0004\u0012\u0002H\n0\f¢\u0006\u0002\b\rH\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000E\u001A2\u0010\u000F\u001A\u00020\u0010\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00100\fH\u0086H¢\u0006\u0002\u0010\u0012\u001A$\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00030\u0014\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001A\u001A\u0010\u0015\u001A\u00020\u0010*\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H\u0001\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"DEFAULT_CLOSE_MESSAGE", "", "receiveOrNull", "E", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "consume", "R", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "", "action", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "cancelConsumed", "cause", "", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/channels/ChannelsKt") final class ChannelsKt__Channels_commonKt {
    public static final void cancelConsumed(ReceiveChannel arg2, Throwable arg3) {
        Throwable v0 = null;
        if(arg3 != null) {
            if((arg3 instanceof CancellationException)) {
                v0 = arg3;
            }

            if(v0 != null) {
                goto label_9;
            }

            CancellationException v0_1 = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", arg3);
        }

    label_9:
        arg2.cancel(((CancellationException)v0));
    }

    public static final Object consume(ReceiveChannel arg1, Function1 arg2) {
        Object v2_1;
        try {
            v2_1 = arg2.invoke(arg1);
        }
        catch(Throwable v2) {
            try {
                throw v2;
            }
            catch(Throwable v0) {
                ChannelsKt.cancelConsumed(arg1, v2);
                throw v0;
            }
        }

        ChannelsKt.cancelConsumed(arg1, null);
        return v2_1;
    }

    public static final Object consumeEach(ReceiveChannel arg6, Function1 arg7, Continuation arg8) {
        Object v2_1;
        Object v7;
        Object v6;
        Function1 v8_1;
        ChannelIterator v6_2;
        int v2;
        Continuation v0;
        if((arg8 instanceof ChannelsKt__Channels_commonKt$consumeEach$1)) {
            v0 = arg8;
            v2 = 0x80000000;
            if((((ChannelsKt__Channels_commonKt$consumeEach$1)v0).label & v2) != 0) {
                ((ChannelsKt__Channels_commonKt$consumeEach$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ChannelsKt__Channels_commonKt$consumeEach$1 v0_1 = new ChannelsKt__Channels_commonKt$consumeEach$1(arg8);
        }

        Object v8 = ((ChannelsKt__Channels_commonKt$consumeEach$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ChannelsKt__Channels_commonKt$consumeEach$1)v0).label;
        Throwable v3 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            try {
                Function1 v5 = arg7;
                ReceiveChannel v7_2 = arg6;
                v6_2 = arg6.iterator();
                v8_1 = v5;
                goto label_37;
            }
            catch(Throwable v7_1) {
                Throwable v5_1 = v7_1;
                ChannelIterator v7_3 = v6_2;
                v6_1 = v5_1;
                try {
                label_61:
                    throw v6_1;
                }
                catch(Throwable v8_2) {
                    ChannelsKt.cancelConsumed(((ReceiveChannel)v7), v6_1);
                    throw v8_2;
                }
            }

            try {
            label_47:
                if(((Boolean)v8).booleanValue()) {
                    ((Function1)v2_1).invoke(((ChannelIterator)v6).next());
                    v8 = v2_1;
                }
                else {
                    goto label_54;
                }

                goto label_37;
            }
            catch(Throwable v6_1) {
                goto label_26;
            }

        label_54:
            ChannelsKt.cancelConsumed(((ReceiveChannel)v7), v3);
            return Unit.INSTANCE;
        }
        else if(v2 == 1) {
            v6 = ((ChannelsKt__Channels_commonKt$consumeEach$1)v0).L$2;
            v7 = ((ChannelsKt__Channels_commonKt$consumeEach$1)v0).L$1;
            v2_1 = ((ChannelsKt__Channels_commonKt$consumeEach$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v8);
                goto label_47;
            }
            catch(Throwable v6_1) {
                goto label_26;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_37:
            ((ChannelsKt__Channels_commonKt$consumeEach$1)v0).L$0 = v8_1;
            ((ChannelsKt__Channels_commonKt$consumeEach$1)v0).L$1 = v7;
            ((ChannelsKt__Channels_commonKt$consumeEach$1)v0).L$2 = v6;
            ((ChannelsKt__Channels_commonKt$consumeEach$1)v0).label = 1;
            v2_1 = ((ChannelIterator)v6).hasNext(v0);
            if(v2_1 == v1) {
                return v1;
            }

            Object v5_2 = v2_1;
            Function1 v2_2 = v8_1;
            v8 = v5_2;
            goto label_47;
        }
        catch(Throwable v6_1) {
        label_26:
            goto label_61;
        }
    }

    private static final Object consumeEach$$forInline(ReceiveChannel arg2, Function1 arg3, Continuation arg4) {
        Continuation v0;
        try {
            ChannelIterator v4 = arg2.iterator();
            while(true) {
                v0 = null;
                if(!v4.hasNext(v0).booleanValue()) {
                    break;
                }

                arg3.invoke(v4.next());
            }
        }
        catch(Throwable v3) {
            goto label_14;
        }

        ChannelsKt.cancelConsumed(arg2, ((Throwable)v0));
        return Unit.INSTANCE;
        try {
        label_14:
            throw v3;
        }
        catch(Throwable v4_1) {
            ChannelsKt.cancelConsumed(arg2, v3);
            throw v4_1;
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in the favour of \'onReceiveCatching\'") public static final SelectClause1 onReceiveOrNull(ReceiveChannel arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.onReceiveOrNull?>");
        return arg1.getOnReceiveOrNull();
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in the favour of \'receiveCatching\'", replaceWith="<_subannotation>") public static final Object receiveOrNull(ReceiveChannel arg1, Continuation arg2) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt.receiveOrNull?>");
        return arg1.receiveOrNull(arg2);
    }

    public static final Object toList(ReceiveChannel arg8, Continuation arg9) {
        Object v6;
        Object v2_1;
        ChannelIterator v8_2;
        List v5_1;
        int v2;
        Continuation v0;
        if((arg9 instanceof ChannelsKt__Channels_commonKt$toList$1)) {
            v0 = arg9;
            v2 = 0x80000000;
            if((((ChannelsKt__Channels_commonKt$toList$1)v0).label & v2) != 0) {
                ((ChannelsKt__Channels_commonKt$toList$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ChannelsKt__Channels_commonKt$toList$1 v0_1 = new ChannelsKt__Channels_commonKt$toList$1(arg9);
        }

        Object v9 = ((ChannelsKt__Channels_commonKt$toList$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ChannelsKt__Channels_commonKt$toList$1)v0).label;
        Throwable v3 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            List v9_1 = CollectionsKt.createListBuilder();
            try {
                v5_1 = v9_1;
                List v6_1 = v5_1;
                ReceiveChannel v9_3 = arg8;
                v8_2 = arg8.iterator();
                goto label_40;
            }
            catch(Throwable v9_2) {
                Throwable v7 = v9_2;
                ChannelIterator v9_4 = v8_2;
                v8_1 = v7;
                try {
                label_67:
                    throw v8_1;
                }
                catch(Throwable v0_2) {
                    ChannelsKt.cancelConsumed(((ReceiveChannel)v9_4), v8_1);
                    throw v0_2;
                }
            }

            try {
            label_51:
                if(((Boolean)v9).booleanValue()) {
                    v5_1.add(v8_2.next());
                    v9 = v2_1;
                }
                else {
                    goto label_58;
                }

                goto label_40;
            }
            catch(Throwable v8_1) {
                goto label_27;
            }

        label_58:
            ChannelsKt.cancelConsumed(((ReceiveChannel)v2_1), v3);
            return CollectionsKt.build(((List)v6));
        }
        else if(v2 == 1) {
            Object v8 = ((ChannelsKt__Channels_commonKt$toList$1)v0).L$3;
            v2_1 = ((ChannelsKt__Channels_commonKt$toList$1)v0).L$2;
            Object v5 = ((ChannelsKt__Channels_commonKt$toList$1)v0).L$1;
            v6 = ((ChannelsKt__Channels_commonKt$toList$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v9);
                goto label_51;
            }
            catch(Throwable v8_1) {
                goto label_27;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_40:
            ((ChannelsKt__Channels_commonKt$toList$1)v0).L$0 = v6;
            ((ChannelsKt__Channels_commonKt$toList$1)v0).L$1 = v5_1;
            ((ChannelsKt__Channels_commonKt$toList$1)v0).L$2 = v9;
            ((ChannelsKt__Channels_commonKt$toList$1)v0).L$3 = v8_2;
            ((ChannelsKt__Channels_commonKt$toList$1)v0).label = 1;
            v2_1 = v8_2.hasNext(v0);
            if(v2_1 != v1) {
                goto label_48;
            }
        }
        catch(Throwable v8_1) {
            goto label_62;
        }

        return v1;
    label_48:
        Object v7_1 = v2_1;
        ReceiveChannel v2_2 = ((ReceiveChannel)v9);
        v9 = v7_1;
        goto label_51;
    label_62:
        goto label_67;
    label_27:
        v9 = v2_1;
        goto label_67;
    }
}

