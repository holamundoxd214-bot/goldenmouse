package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AR\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022#\u0010\u0003\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\t\u0010\n\u001AV\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022!\u0010\f\u001A\u001D\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000E0\u0004H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u000F\u0010\n\u001AX\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022#\u0010\f\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000E0\u0004H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0010\u0010\n\u001AX\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022#\u0010\f\u001A\u001F\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000E0\u0004H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0012\u0010\n\u001A>\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00150\u0014\"\u0004\b\u0000\u0010\u00152\b\b\u0002\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0018\u001A\u00020\u00192\u0016\b\u0002\u0010\u001A\u001A\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u000E\u0018\u00010\u0004\u001A\u001E\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00150\u0014\"\u0004\b\u0000\u0010\u00152\b\b\u0002\u0010\u0016\u001A\u00020\u0017H\u0007¨\u0006\u001B"}, d2={"getOrElse", "T", "Lkotlinx/coroutines/channels/ChannelResult;", "onFailure", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "exception", "getOrElse-WpGqRn0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onSuccess", "action", "value", "", "onSuccess-WpGqRn0", "onFailure-WpGqRn0", "onClosed", "onClosed-WpGqRn0", "Channel", "Lkotlinx/coroutines/channels/Channel;", "E", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ChannelKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.4.0, binary compatibility with earlier versions") public static final Channel Channel(int arg2) {
        return ChannelKt.Channel$default(arg2, null, null, 6, null);
    }

    public static final Channel Channel(int arg2, BufferOverflow arg3, Function1 arg4) {
        ConflatedBufferedChannel v2_1;
        BufferedChannel v2;
        BufferedChannel v3;
        if(arg2 != -2) {
            if(arg2 != -1) {
                if(arg2 != 0) {
                    int v0 = 0x7FFFFFFF;
                    if(arg2 != v0) {
                        if(arg3 == BufferOverflow.SUSPEND) {
                            v3 = new BufferedChannel(arg2, arg4);
                        }
                        else {
                            ConflatedBufferedChannel v3_1 = new ConflatedBufferedChannel(arg2, arg3, arg4);
                        }

                        return ((Channel)v3);
                    }

                    return new BufferedChannel(v0, arg4);
                }

                if(arg3 == BufferOverflow.SUSPEND) {
                    v2 = new BufferedChannel(0, arg4);
                }
                else {
                    v2_1 = new ConflatedBufferedChannel(1, arg3, arg4);
                }

                return ((Channel)v2);
            }

            if(arg3 == BufferOverflow.SUSPEND) {
                return new ConflatedBufferedChannel(1, BufferOverflow.DROP_OLDEST, arg4);
            }

            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }

        if(arg3 == BufferOverflow.SUSPEND) {
            v2 = new BufferedChannel(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core(), arg4);
        }
        else {
            v2_1 = new ConflatedBufferedChannel(1, arg3, arg4);
        }

        return ((Channel)v2);
    }

    public static Channel Channel$default(int arg0, BufferOverflow arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg1 = BufferOverflow.SUSPEND;
        }

        if((arg3 & 4) != 0) {
            arg2 = null;
        }

        return ChannelKt.Channel(0, arg1, arg2);
    }

    public static Channel Channel$default(int arg0, int arg1, Object arg2) {
        return ChannelKt.Channel(0);
    }

    public static final Object getOrElse-WpGqRn0(Object arg1, Function1 arg2) {
        if((arg1 instanceof Failed)) {
            arg1 = arg2.invoke(ChannelResult.exceptionOrNull-impl(arg1));
        }

        return arg1;
    }

    public static final Object onClosed-WpGqRn0(Object arg1, Function1 arg2) {
        if((arg1 instanceof Closed)) {
            arg2.invoke(ChannelResult.exceptionOrNull-impl(arg1));
        }

        return arg1;
    }

    public static final Object onFailure-WpGqRn0(Object arg1, Function1 arg2) {
        if((arg1 instanceof Failed)) {
            arg2.invoke(ChannelResult.exceptionOrNull-impl(arg1));
        }

        return arg1;
    }

    public static final Object onSuccess-WpGqRn0(Object arg1, Function1 arg2) {
        if(!(arg1 instanceof Failed)) {
            arg2.invoke(arg1);
        }

        return arg1;
    }
}

