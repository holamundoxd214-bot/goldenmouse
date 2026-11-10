package kotlinx.coroutines.channels;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000E\u0010\u0003\u001A\u00020\u0004H¦B¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001A\u00028\u0000H\u0097@¢\u0006\u0004\b\u0007\u0010\u0005J\u000E\u0010\u0007\u001A\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\b¨\u0006\t"}, d2={"Lkotlinx/coroutines/channels/ChannelIterator;", "E", "", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "next0", "next", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public interface ChannelIterator {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.3.0, binary compatibility with versions <= 1.2.x") public static Object next(ChannelIterator arg4, Continuation arg5) {
            Object v4;
            int v2;
            Continuation v0;
            if((arg5 instanceof ChannelIterator$next0$1)) {
                v0 = arg5;
                v2 = 0x80000000;
                if((((ChannelIterator$next0$1)v0).label & v2) != 0) {
                    ((ChannelIterator$next0$1)v0).label -= v2;
                }
                else {
                    goto label_11;
                }
            }
            else {
            label_11:
                ChannelIterator$next0$1 v0_1 = new ChannelIterator$next0$1(arg5);
            }

            Object v5 = ((ChannelIterator$next0$1)v0).result;
            Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            v2 = ((ChannelIterator$next0$1)v0).label;
            if(v2 == 0) {
                ResultKt.throwOnFailure(v5);
                ((ChannelIterator$next0$1)v0).L$0 = arg4;
                ((ChannelIterator$next0$1)v0).label = 1;
                v5 = arg4.hasNext(v0);
                if(v5 == v1) {
                    return v1;
                }
            }
            else if(v2 == 1) {
                v4 = ((ChannelIterator$next0$1)v0).L$0;
                ResultKt.throwOnFailure(v5);
            }
            else {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }

            if(((Boolean)v5).booleanValue()) {
                return ((ChannelIterator)v4).next();
            }

            throw new ClosedReceiveChannelException("Channel was closed");
        }
    }

    Object hasNext(Continuation arg1);

    Object next();

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.3.0, binary compatibility with versions <= 1.2.x") Object next(Continuation arg1);
}

