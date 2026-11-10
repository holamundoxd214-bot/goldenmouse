package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u001C\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0007\"\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"BroadcastChannel", "Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "capacity", "", "NO_ELEMENT", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class BroadcastChannelKt {
    private static final Symbol NO_ELEMENT;

    static {
        BroadcastChannelKt.NO_ELEMENT = new Symbol("NO_ELEMENT");
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="BroadcastChannel is deprecated in the favour of SharedFlow and StateFlow, and is no longer supported") public static final BroadcastChannel BroadcastChannel(int arg1) {
        if(arg1 != -2) {
            if(arg1 != -1) {
                if(arg1 != 0) {
                    if(arg1 != 0x7FFFFFFF) {
                        return new BroadcastChannelImpl(arg1);
                    }

                    throw new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
                }

                throw new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
            }

            return new ConflatedBroadcastChannel();
        }

        return new BroadcastChannelImpl(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core());
    }

    public static final Symbol access$getNO_ELEMENT$p() {
        return BroadcastChannelKt.NO_ELEMENT;
    }
}

