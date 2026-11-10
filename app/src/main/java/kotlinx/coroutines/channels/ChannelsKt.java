package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata(d1={"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt", "kotlinx/coroutines/channels/ChannelsKt__DeprecatedKt"}, k=4, mv={2, 1, 0}, xi=0x30) public final class ChannelsKt {
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object any(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__DeprecatedKt.any(arg0, arg1);
    }

    public static final void cancelConsumed(ReceiveChannel arg0, Throwable arg1) {
        ChannelsKt__Channels_commonKt.cancelConsumed(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported") public static final Object consume(BroadcastChannel arg0, Function1 arg1) {
        return ChannelsKt__DeprecatedKt.consume(arg0, arg1);
    }

    public static final Object consume(ReceiveChannel arg0, Function1 arg1) {
        return ChannelsKt__Channels_commonKt.consume(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported") public static final Object consumeEach(BroadcastChannel arg0, Function1 arg1, Continuation arg2) {
        return ChannelsKt__DeprecatedKt.consumeEach(arg0, arg1, arg2);
    }

    public static final Object consumeEach(ReceiveChannel arg0, Function1 arg1, Continuation arg2) {
        return ChannelsKt__Channels_commonKt.consumeEach(arg0, arg1, arg2);
    }

    public static final Function1 consumes(ReceiveChannel arg0) {
        return ChannelsKt__DeprecatedKt.consumes(arg0);
    }

    public static final Function1 consumesAll(ReceiveChannel[] arg0) {
        return ChannelsKt__DeprecatedKt.consumesAll(arg0);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object count(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__DeprecatedKt.count(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel distinct(ReceiveChannel arg0) {
        return ChannelsKt__DeprecatedKt.distinct(arg0);
    }

    public static final ReceiveChannel distinctBy(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2) {
        return ChannelsKt__DeprecatedKt.distinctBy(arg0, arg1, arg2);
    }

    public static ReceiveChannel distinctBy$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        return ChannelsKt__DeprecatedKt.distinctBy$default(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel drop(ReceiveChannel arg0, int arg1, CoroutineContext arg2) {
        return ChannelsKt__DeprecatedKt.drop(arg0, arg1, arg2);
    }

    public static ReceiveChannel drop$default(ReceiveChannel arg0, int arg1, CoroutineContext arg2, int arg3, Object arg4) {
        return ChannelsKt__DeprecatedKt.drop$default(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel dropWhile(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2) {
        return ChannelsKt__DeprecatedKt.dropWhile(arg0, arg1, arg2);
    }

    public static ReceiveChannel dropWhile$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        return ChannelsKt__DeprecatedKt.dropWhile$default(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object elementAt(ReceiveChannel arg0, int arg1, Continuation arg2) {
        return ChannelsKt__DeprecatedKt.elementAt(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object elementAtOrNull(ReceiveChannel arg0, int arg1, Continuation arg2) {
        return ChannelsKt__DeprecatedKt.elementAtOrNull(arg0, arg1, arg2);
    }

    public static final ReceiveChannel filter(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2) {
        return ChannelsKt__DeprecatedKt.filter(arg0, arg1, arg2);
    }

    public static ReceiveChannel filter$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        return ChannelsKt__DeprecatedKt.filter$default(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel filterIndexed(ReceiveChannel arg0, CoroutineContext arg1, Function3 arg2) {
        return ChannelsKt__DeprecatedKt.filterIndexed(arg0, arg1, arg2);
    }

    public static ReceiveChannel filterIndexed$default(ReceiveChannel arg0, CoroutineContext arg1, Function3 arg2, int arg3, Object arg4) {
        return ChannelsKt__DeprecatedKt.filterIndexed$default(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel filterNot(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2) {
        return ChannelsKt__DeprecatedKt.filterNot(arg0, arg1, arg2);
    }

    public static ReceiveChannel filterNot$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        return ChannelsKt__DeprecatedKt.filterNot$default(arg0, arg1, arg2, arg3, arg4);
    }

    public static final ReceiveChannel filterNotNull(ReceiveChannel arg0) {
        return ChannelsKt__DeprecatedKt.filterNotNull(arg0);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object filterNotNullTo(ReceiveChannel arg0, Collection arg1, Continuation arg2) {
        return ChannelsKt__DeprecatedKt.filterNotNullTo(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object filterNotNullTo(ReceiveChannel arg0, SendChannel arg1, Continuation arg2) {
        return ChannelsKt__DeprecatedKt.filterNotNullTo(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object first(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__DeprecatedKt.first(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object firstOrNull(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__DeprecatedKt.firstOrNull(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel flatMap(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2) {
        return ChannelsKt__DeprecatedKt.flatMap(arg0, arg1, arg2);
    }

    public static ReceiveChannel flatMap$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        return ChannelsKt__DeprecatedKt.flatMap$default(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object indexOf(ReceiveChannel arg0, Object arg1, Continuation arg2) {
        return ChannelsKt__DeprecatedKt.indexOf(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object last(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__DeprecatedKt.last(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object lastIndexOf(ReceiveChannel arg0, Object arg1, Continuation arg2) {
        return ChannelsKt__DeprecatedKt.lastIndexOf(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object lastOrNull(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__DeprecatedKt.lastOrNull(arg0, arg1);
    }

    public static final ReceiveChannel map(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2) {
        return ChannelsKt__DeprecatedKt.map(arg0, arg1, arg2);
    }

    public static ReceiveChannel map$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        return ChannelsKt__DeprecatedKt.map$default(arg0, arg1, arg2, arg3, arg4);
    }

    public static final ReceiveChannel mapIndexed(ReceiveChannel arg0, CoroutineContext arg1, Function3 arg2) {
        return ChannelsKt__DeprecatedKt.mapIndexed(arg0, arg1, arg2);
    }

    public static ReceiveChannel mapIndexed$default(ReceiveChannel arg0, CoroutineContext arg1, Function3 arg2, int arg3, Object arg4) {
        return ChannelsKt__DeprecatedKt.mapIndexed$default(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel mapIndexedNotNull(ReceiveChannel arg0, CoroutineContext arg1, Function3 arg2) {
        return ChannelsKt__DeprecatedKt.mapIndexedNotNull(arg0, arg1, arg2);
    }

    public static ReceiveChannel mapIndexedNotNull$default(ReceiveChannel arg0, CoroutineContext arg1, Function3 arg2, int arg3, Object arg4) {
        return ChannelsKt__DeprecatedKt.mapIndexedNotNull$default(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel mapNotNull(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2) {
        return ChannelsKt__DeprecatedKt.mapNotNull(arg0, arg1, arg2);
    }

    public static ReceiveChannel mapNotNull$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        return ChannelsKt__DeprecatedKt.mapNotNull$default(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object maxWith(ReceiveChannel arg0, Comparator arg1, Continuation arg2) {
        return ChannelsKt__DeprecatedKt.maxWith(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object minWith(ReceiveChannel arg0, Comparator arg1, Continuation arg2) {
        return ChannelsKt__DeprecatedKt.minWith(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object none(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__DeprecatedKt.none(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in the favour of \'onReceiveCatching\'") public static final SelectClause1 onReceiveOrNull(ReceiveChannel arg0) {
        return ChannelsKt__Channels_commonKt.onReceiveOrNull(arg0);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in the favour of \'receiveCatching\'", replaceWith="<_subannotation>") public static final Object receiveOrNull(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__Channels_commonKt.receiveOrNull(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Left for binary compatibility") public static final ReceiveChannel requireNoNulls(ReceiveChannel arg0) {
        return ChannelsKt__DeprecatedKt.requireNoNulls(arg0);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Deprecated in the favour of \'trySendBlocking\'. Consider handling the result of \'trySendBlocking\' explicitly and rethrow exception if necessary", replaceWith="<_subannotation>") public static final void sendBlocking(SendChannel arg0, Object arg1) {
        ChannelsKt__ChannelsKt.sendBlocking(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object single(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__DeprecatedKt.single(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object singleOrNull(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__DeprecatedKt.singleOrNull(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel take(ReceiveChannel arg0, int arg1, CoroutineContext arg2) {
        return ChannelsKt__DeprecatedKt.take(arg0, arg1, arg2);
    }

    public static ReceiveChannel take$default(ReceiveChannel arg0, int arg1, CoroutineContext arg2, int arg3, Object arg4) {
        return ChannelsKt__DeprecatedKt.take$default(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel takeWhile(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2) {
        return ChannelsKt__DeprecatedKt.takeWhile(arg0, arg1, arg2);
    }

    public static ReceiveChannel takeWhile$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        return ChannelsKt__DeprecatedKt.takeWhile$default(arg0, arg1, arg2, arg3, arg4);
    }

    public static final Object toChannel(ReceiveChannel arg0, SendChannel arg1, Continuation arg2) {
        return ChannelsKt__DeprecatedKt.toChannel(arg0, arg1, arg2);
    }

    public static final Object toCollection(ReceiveChannel arg0, Collection arg1, Continuation arg2) {
        return ChannelsKt__DeprecatedKt.toCollection(arg0, arg1, arg2);
    }

    public static final Object toList(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__Channels_commonKt.toList(arg0, arg1);
    }

    public static final Object toMap(ReceiveChannel arg0, Map arg1, Continuation arg2) {
        return ChannelsKt__DeprecatedKt.toMap(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object toMap(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__DeprecatedKt.toMap(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object toMutableList(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__DeprecatedKt.toMutableList(arg0, arg1);
    }

    public static final Object toMutableSet(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__DeprecatedKt.toMutableSet(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object toSet(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt__DeprecatedKt.toSet(arg0, arg1);
    }

    public static final Object trySendBlocking(SendChannel arg0, Object arg1) {
        return ChannelsKt__ChannelsKt.trySendBlocking(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel withIndex(ReceiveChannel arg0, CoroutineContext arg1) {
        return ChannelsKt__DeprecatedKt.withIndex(arg0, arg1);
    }

    public static ReceiveChannel withIndex$default(ReceiveChannel arg0, CoroutineContext arg1, int arg2, Object arg3) {
        return ChannelsKt__DeprecatedKt.withIndex$default(arg0, arg1, arg2, arg3);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel zip(ReceiveChannel arg0, ReceiveChannel arg1) {
        return ChannelsKt__DeprecatedKt.zip(arg0, arg1);
    }

    public static final ReceiveChannel zip(ReceiveChannel arg0, ReceiveChannel arg1, CoroutineContext arg2, Function2 arg3) {
        return ChannelsKt__DeprecatedKt.zip(arg0, arg1, arg2, arg3);
    }

    public static ReceiveChannel zip$default(ReceiveChannel arg0, ReceiveChannel arg1, CoroutineContext arg2, Function2 arg3, int arg4, Object arg5) {
        return ChannelsKt__DeprecatedKt.zip$default(arg0, arg1, arg2, arg3, arg4, arg5);
    }
}

