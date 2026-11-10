package kotlinx.coroutines.flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(d1={"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__LogicKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, k=4, mv={2, 1, 0}, xi=0x30) public final class FlowKt {
    public static final String DEFAULT_CONCURRENCY_PROPERTY_NAME = "kotlinx.coroutines.flow.defaultConcurrency";

    public static final Object all(Flow arg0, Function2 arg1, Continuation arg2) {
        return FlowKt__LogicKt.all(arg0, arg1, arg2);
    }

    public static final Object any(Flow arg0, Function2 arg1, Continuation arg2) {
        return FlowKt__LogicKt.any(arg0, arg1, arg2);
    }

    public static final Flow asFlow(Iterable arg0) {
        return FlowKt__BuildersKt.asFlow(arg0);
    }

    public static final Flow asFlow(Iterator arg0) {
        return FlowKt__BuildersKt.asFlow(arg0);
    }

    public static final Flow asFlow(Function0 arg0) {
        return FlowKt__BuildersKt.asFlow(arg0);
    }

    public static final Flow asFlow(Function1 arg0) {
        return FlowKt__BuildersKt.asFlow(arg0);
    }

    public static final Flow asFlow(IntRange arg0) {
        return FlowKt__BuildersKt.asFlow(arg0);
    }

    public static final Flow asFlow(LongRange arg0) {
        return FlowKt__BuildersKt.asFlow(arg0);
    }

    public static final Flow asFlow(Sequence arg0) {
        return FlowKt__BuildersKt.asFlow(arg0);
    }

    public static final Flow asFlow(int[] arg0) {
        return FlowKt__BuildersKt.asFlow(arg0);
    }

    public static final Flow asFlow(long[] arg0) {
        return FlowKt__BuildersKt.asFlow(arg0);
    }

    public static final Flow asFlow(Object[] arg0) {
        return FlowKt__BuildersKt.asFlow(arg0);
    }

    public static final SharedFlow asSharedFlow(MutableSharedFlow arg0) {
        return FlowKt__ShareKt.asSharedFlow(arg0);
    }

    public static final StateFlow asStateFlow(MutableStateFlow arg0) {
        return FlowKt__ShareKt.asStateFlow(arg0);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Since 1.4.0, binary compatibility with earlier versions") public static final Flow buffer(Flow arg0, int arg1) {
        return FlowKt__ContextKt.buffer(arg0, arg1);
    }

    public static final Flow buffer(Flow arg0, int arg1, BufferOverflow arg2) {
        return FlowKt__ContextKt.buffer(arg0, arg1, arg2);
    }

    public static Flow buffer$default(Flow arg0, int arg1, int arg2, Object arg3) {
        return FlowKt__ContextKt.buffer$default(arg0, arg1, arg2, arg3);
    }

    public static Flow buffer$default(Flow arg0, int arg1, BufferOverflow arg2, int arg3, Object arg4) {
        return FlowKt__ContextKt.buffer$default(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'cache()\' is \'shareIn\' with unlimited replay and \'started = SharingStarted.Lazily\' argument\'", replaceWith="<_subannotation>") public static final Flow cache(Flow arg0) {
        return FlowKt__MigrationKt.cache(arg0);
    }

    public static final Flow callbackFlow(Function2 arg0) {
        return FlowKt__BuildersKt.callbackFlow(arg0);
    }

    public static final Flow cancellable(Flow arg0) {
        return FlowKt__ContextKt.cancellable(arg0);
    }

    public static final Flow catch(Flow arg0, Function3 arg1) {
        return FlowKt__ErrorsKt.catch(arg0, arg1);
    }

    public static final Object catchImpl(Flow arg0, FlowCollector arg1, Continuation arg2) {
        return FlowKt__ErrorsKt.catchImpl(arg0, arg1, arg2);
    }

    public static final Flow channelFlow(Function2 arg0) {
        return FlowKt__BuildersKt.channelFlow(arg0);
    }

    public static final Flow chunked(Flow arg0, int arg1) {
        return FlowKt__TransformKt.chunked(arg0, arg1);
    }

    public static final Object collect(Flow arg0, Continuation arg1) {
        return FlowKt__CollectKt.collect(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Backwards compatibility with JS and K/N") public static final Object collect(Flow arg0, Function2 arg1, Continuation arg2) {
        return FlowKt__CollectKt.collect(arg0, arg1, arg2);
    }

    public static final Object collectIndexed(Flow arg0, Function3 arg1, Continuation arg2) {
        return FlowKt__CollectKt.collectIndexed(arg0, arg1, arg2);
    }

    public static final Object collectLatest(Flow arg0, Function2 arg1, Continuation arg2) {
        return FlowKt__CollectKt.collectLatest(arg0, arg1, arg2);
    }

    public static final Object collectWhile(Flow arg0, Function2 arg1, Continuation arg2) {
        return FlowKt__LimitKt.collectWhile(arg0, arg1, arg2);
    }

    public static final Flow combine(Iterable arg0, Function2 arg1) {
        return FlowKt__ZipKt.combine(arg0, arg1);
    }

    public static final Flow combine(Flow arg0, Flow arg1, Function3 arg2) {
        return FlowKt__ZipKt.combine(arg0, arg1, arg2);
    }

    public static final Flow combine(Flow arg0, Flow arg1, Flow arg2, Function4 arg3) {
        return FlowKt__ZipKt.combine(arg0, arg1, arg2, arg3);
    }

    public static final Flow combine(Flow arg0, Flow arg1, Flow arg2, Flow arg3, Function5 arg4) {
        return FlowKt__ZipKt.combine(arg0, arg1, arg2, arg3, arg4);
    }

    public static final Flow combine(Flow arg0, Flow arg1, Flow arg2, Flow arg3, Flow arg4, Function6 arg5) {
        return FlowKt__ZipKt.combine(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final Flow combine(Flow[] arg0, Function2 arg1) {
        return FlowKt__ZipKt.combine(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'combineLatest\' is \'combine\'", replaceWith="<_subannotation>") public static final Flow combineLatest(Flow arg0, Flow arg1, Function3 arg2) {
        return FlowKt__MigrationKt.combineLatest(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'combineLatest\' is \'combine\'", replaceWith="<_subannotation>") public static final Flow combineLatest(Flow arg0, Flow arg1, Flow arg2, Function4 arg3) {
        return FlowKt__MigrationKt.combineLatest(arg0, arg1, arg2, arg3);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'combineLatest\' is \'combine\'", replaceWith="<_subannotation>") public static final Flow combineLatest(Flow arg0, Flow arg1, Flow arg2, Flow arg3, Function5 arg4) {
        return FlowKt__MigrationKt.combineLatest(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'combineLatest\' is \'combine\'", replaceWith="<_subannotation>") public static final Flow combineLatest(Flow arg0, Flow arg1, Flow arg2, Flow arg3, Flow arg4, Function6 arg5) {
        return FlowKt__MigrationKt.combineLatest(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final Flow combineTransform(Iterable arg0, Function3 arg1) {
        return FlowKt__ZipKt.combineTransform(arg0, arg1);
    }

    public static final Flow combineTransform(Flow arg0, Flow arg1, Function4 arg2) {
        return FlowKt__ZipKt.combineTransform(arg0, arg1, arg2);
    }

    public static final Flow combineTransform(Flow arg0, Flow arg1, Flow arg2, Function5 arg3) {
        return FlowKt__ZipKt.combineTransform(arg0, arg1, arg2, arg3);
    }

    public static final Flow combineTransform(Flow arg0, Flow arg1, Flow arg2, Flow arg3, Function6 arg4) {
        return FlowKt__ZipKt.combineTransform(arg0, arg1, arg2, arg3, arg4);
    }

    public static final Flow combineTransform(Flow arg0, Flow arg1, Flow arg2, Flow arg3, Flow arg4, Function7 arg5) {
        return FlowKt__ZipKt.combineTransform(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final Flow combineTransform(Flow[] arg0, Function3 arg1) {
        return FlowKt__ZipKt.combineTransform(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'compose\' is \'let\'", replaceWith="<_subannotation>") public static final Flow compose(Flow arg0, Function1 arg1) {
        return FlowKt__MigrationKt.compose(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'concatMap\' is \'flatMapConcat\'", replaceWith="<_subannotation>") public static final Flow concatMap(Flow arg0, Function1 arg1) {
        return FlowKt__MigrationKt.concatMap(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'concatWith\' is \'onCompletion\'. Use \'onCompletion { emit(value) }\'", replaceWith="<_subannotation>") public static final Flow concatWith(Flow arg0, Object arg1) {
        return FlowKt__MigrationKt.concatWith(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'concatWith\' is \'onCompletion\'. Use \'onCompletion { if (it == null) emitAll(other) }\'", replaceWith="<_subannotation>") public static final Flow concatWith(Flow arg0, Flow arg1) {
        return FlowKt__MigrationKt.concatWith(arg0, arg1);
    }

    public static final Flow conflate(Flow arg0) {
        return FlowKt__ContextKt.conflate(arg0);
    }

    public static final Flow consumeAsFlow(ReceiveChannel arg0) {
        return FlowKt__ChannelsKt.consumeAsFlow(arg0);
    }

    public static final Object count(Flow arg0, Continuation arg1) {
        return FlowKt__CountKt.count(arg0, arg1);
    }

    public static final Object count(Flow arg0, Function2 arg1, Continuation arg2) {
        return FlowKt__CountKt.count(arg0, arg1, arg2);
    }

    public static final Flow debounce(Flow arg0, long arg1) {
        return FlowKt__DelayKt.debounce(arg0, arg1);
    }

    public static final Flow debounce(Flow arg0, Function1 arg1) {
        return FlowKt__DelayKt.debounce(arg0, arg1);
    }

    public static final Flow debounce-HG0u8IE(Flow arg0, long arg1) {
        return FlowKt__DelayKt.debounce-HG0u8IE(arg0, arg1);
    }

    public static final Flow debounceDuration(Flow arg0, Function1 arg1) {
        return FlowKt__DelayKt.debounceDuration(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use \'onEach { delay(timeMillis) }\'", replaceWith="<_subannotation>") public static final Flow delayEach(Flow arg0, long arg1) {
        return FlowKt__MigrationKt.delayEach(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use \'onStart { delay(timeMillis) }\'", replaceWith="<_subannotation>") public static final Flow delayFlow(Flow arg0, long arg1) {
        return FlowKt__MigrationKt.delayFlow(arg0, arg1);
    }

    public static final Flow distinctUntilChanged(Flow arg0, Function2 arg1) {
        return FlowKt__DistinctKt.distinctUntilChanged(arg0, arg1);
    }

    public static final Flow distinctUntilChanged(Flow arg0) {
        return FlowKt__DistinctKt.distinctUntilChanged(arg0);
    }

    public static final Flow distinctUntilChangedBy(Flow arg0, Function1 arg1) {
        return FlowKt__DistinctKt.distinctUntilChangedBy(arg0, arg1);
    }

    public static final Flow drop(Flow arg0, int arg1) {
        return FlowKt__LimitKt.drop(arg0, arg1);
    }

    public static final Flow dropWhile(Flow arg0, Function2 arg1) {
        return FlowKt__LimitKt.dropWhile(arg0, arg1);
    }

    public static final Object emitAll(FlowCollector arg0, ReceiveChannel arg1, Continuation arg2) {
        return FlowKt__ChannelsKt.emitAll(arg0, arg1, arg2);
    }

    public static final Object emitAll(FlowCollector arg0, Flow arg1, Continuation arg2) {
        return FlowKt__CollectKt.emitAll(arg0, arg1, arg2);
    }

    public static final Flow emptyFlow() {
        return FlowKt__BuildersKt.emptyFlow();
    }

    public static final void ensureActive(FlowCollector arg0) {
        FlowKt__EmittersKt.ensureActive(arg0);
    }

    public static final Flow filter(Flow arg0, Function2 arg1) {
        return FlowKt__TransformKt.filter(arg0, arg1);
    }

    public static final Flow filterIsInstance(Flow arg0) {
        return FlowKt__TransformKt.filterIsInstance(arg0);
    }

    public static final Flow filterIsInstance(Flow arg0, KClass arg1) {
        return FlowKt__TransformKt.filterIsInstance(arg0, arg1);
    }

    public static final Flow filterNot(Flow arg0, Function2 arg1) {
        return FlowKt__TransformKt.filterNot(arg0, arg1);
    }

    public static final Flow filterNotNull(Flow arg0) {
        return FlowKt__TransformKt.filterNotNull(arg0);
    }

    public static final Object first(Flow arg0, Function2 arg1, Continuation arg2) {
        return FlowKt__ReduceKt.first(arg0, arg1, arg2);
    }

    public static final Object first(Flow arg0, Continuation arg1) {
        return FlowKt__ReduceKt.first(arg0, arg1);
    }

    public static final Object firstOrNull(Flow arg0, Continuation arg1) {
        return FlowKt__ReduceKt.firstOrNull(arg0, arg1);
    }

    public static final Object firstOrNull(Flow arg0, Function2 arg1, Continuation arg2) {
        return FlowKt__ReduceKt.firstOrNull(arg0, arg1, arg2);
    }

    public static final ReceiveChannel fixedPeriodTicker(CoroutineScope arg0, long arg1) {
        return FlowKt__DelayKt.fixedPeriodTicker(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue is \'flatMapConcat\'", replaceWith="<_subannotation>") public static final Flow flatMap(Flow arg0, Function2 arg1) {
        return FlowKt__MigrationKt.flatMap(arg0, arg1);
    }

    public static final Flow flatMapConcat(Flow arg0, Function2 arg1) {
        return FlowKt__MergeKt.flatMapConcat(arg0, arg1);
    }

    public static final Flow flatMapLatest(Flow arg0, Function2 arg1) {
        return FlowKt__MergeKt.flatMapLatest(arg0, arg1);
    }

    public static final Flow flatMapMerge(Flow arg0, int arg1, Function2 arg2) {
        return FlowKt__MergeKt.flatMapMerge(arg0, arg1, arg2);
    }

    public static Flow flatMapMerge$default(Flow arg0, int arg1, Function2 arg2, int arg3, Object arg4) {
        return FlowKt__MergeKt.flatMapMerge$default(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'flatten\' is \'flattenConcat\'", replaceWith="<_subannotation>") public static final Flow flatten(Flow arg0) {
        return FlowKt__MigrationKt.flatten(arg0);
    }

    public static final Flow flattenConcat(Flow arg0) {
        return FlowKt__MergeKt.flattenConcat(arg0);
    }

    public static final Flow flattenMerge(Flow arg0, int arg1) {
        return FlowKt__MergeKt.flattenMerge(arg0, arg1);
    }

    public static Flow flattenMerge$default(Flow arg0, int arg1, int arg2, Object arg3) {
        return FlowKt__MergeKt.flattenMerge$default(arg0, arg1, arg2, arg3);
    }

    public static final Flow flow(Function2 arg0) {
        return FlowKt__BuildersKt.flow(arg0);
    }

    public static final Flow flowCombine(Flow arg0, Flow arg1, Function3 arg2) {
        return FlowKt__ZipKt.flowCombine(arg0, arg1, arg2);
    }

    public static final Flow flowCombineTransform(Flow arg0, Flow arg1, Function4 arg2) {
        return FlowKt__ZipKt.flowCombineTransform(arg0, arg1, arg2);
    }

    public static final Flow flowOf(Object arg0) {
        return FlowKt__BuildersKt.flowOf(arg0);
    }

    public static final Flow flowOf(Object[] arg0) {
        return FlowKt__BuildersKt.flowOf(arg0);
    }

    public static final Flow flowOn(Flow arg0, CoroutineContext arg1) {
        return FlowKt__ContextKt.flowOn(arg0, arg1);
    }

    public static final Object fold(Flow arg0, Object arg1, Function3 arg2, Continuation arg3) {
        return FlowKt__ReduceKt.fold(arg0, arg1, arg2, arg3);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'forEach\' is \'collect\'", replaceWith="<_subannotation>") public static final void forEach(Flow arg0, Function2 arg1) {
        FlowKt__MigrationKt.forEach(arg0, arg1);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return FlowKt__MergeKt.getDEFAULT_CONCURRENCY();
    }

    public static void getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
        FlowKt__MergeKt.getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations();
    }

    public static final Object last(Flow arg0, Continuation arg1) {
        return FlowKt__ReduceKt.last(arg0, arg1);
    }

    public static final Object lastOrNull(Flow arg0, Continuation arg1) {
        return FlowKt__ReduceKt.lastOrNull(arg0, arg1);
    }

    public static final Job launchIn(Flow arg0, CoroutineScope arg1) {
        return FlowKt__CollectKt.launchIn(arg0, arg1);
    }

    public static final Flow map(Flow arg0, Function2 arg1) {
        return FlowKt__TransformKt.map(arg0, arg1);
    }

    public static final Flow mapLatest(Flow arg0, Function2 arg1) {
        return FlowKt__MergeKt.mapLatest(arg0, arg1);
    }

    public static final Flow mapNotNull(Flow arg0, Function2 arg1) {
        return FlowKt__TransformKt.mapNotNull(arg0, arg1);
    }

    public static final Flow merge(Iterable arg0) {
        return FlowKt__MergeKt.merge(arg0);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'merge\' is \'flattenConcat\'", replaceWith="<_subannotation>") public static final Flow merge(Flow arg0) {
        return FlowKt__MigrationKt.merge(arg0);
    }

    public static final Flow merge(Flow[] arg0) {
        return FlowKt__MergeKt.merge(arg0);
    }

    public static final Void noImpl() {
        return FlowKt__MigrationKt.noImpl();
    }

    public static final Object none(Flow arg0, Function2 arg1, Continuation arg2) {
        return FlowKt__LogicKt.none(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Collect flow in the desired context instead") public static final Flow observeOn(Flow arg0, CoroutineContext arg1) {
        return FlowKt__MigrationKt.observeOn(arg0, arg1);
    }

    public static final Flow onCompletion(Flow arg0, Function3 arg1) {
        return FlowKt__EmittersKt.onCompletion(arg0, arg1);
    }

    public static final Flow onEach(Flow arg0, Function2 arg1) {
        return FlowKt__TransformKt.onEach(arg0, arg1);
    }

    public static final Flow onEmpty(Flow arg0, Function2 arg1) {
        return FlowKt__EmittersKt.onEmpty(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'onErrorXxx\' is \'catch\'. Use \'catch { emitAll(fallback) }\'", replaceWith="<_subannotation>") public static final Flow onErrorResume(Flow arg0, Flow arg1) {
        return FlowKt__MigrationKt.onErrorResume(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'onErrorXxx\' is \'catch\'. Use \'catch { emitAll(fallback) }\'", replaceWith="<_subannotation>") public static final Flow onErrorResumeNext(Flow arg0, Flow arg1) {
        return FlowKt__MigrationKt.onErrorResumeNext(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'onErrorXxx\' is \'catch\'. Use \'catch { emit(fallback) }\'", replaceWith="<_subannotation>") public static final Flow onErrorReturn(Flow arg0, Object arg1) {
        return FlowKt__MigrationKt.onErrorReturn(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'onErrorXxx\' is \'catch\'. Use \'catch { e -> if (predicate(e)) emit(fallback) else throw e }\'", replaceWith="<_subannotation>") public static final Flow onErrorReturn(Flow arg0, Object arg1, Function1 arg2) {
        return FlowKt__MigrationKt.onErrorReturn(arg0, arg1, arg2);
    }

    public static Flow onErrorReturn$default(Flow arg0, Object arg1, Function1 arg2, int arg3, Object arg4) {
        return FlowKt__MigrationKt.onErrorReturn$default(arg0, arg1, arg2, arg3, arg4);
    }

    public static final Flow onStart(Flow arg0, Function2 arg1) {
        return FlowKt__EmittersKt.onStart(arg0, arg1);
    }

    public static final SharedFlow onSubscription(SharedFlow arg0, Function2 arg1) {
        return FlowKt__ShareKt.onSubscription(arg0, arg1);
    }

    public static final ReceiveChannel produceIn(Flow arg0, CoroutineScope arg1) {
        return FlowKt__ChannelsKt.produceIn(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'publish()\' is \'shareIn\'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to \'started = SharingStarted.Lazily\' argument, \npublish().refCount() translates to \'started = SharingStarted.WhileSubscribed()\' argument.", replaceWith="<_subannotation>") public static final Flow publish(Flow arg0) {
        return FlowKt__MigrationKt.publish(arg0);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'publish(bufferSize)\' is \'buffer\' followed by \'shareIn\'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to \'started = SharingStarted.Lazily\' argument, \npublish().refCount() translates to \'started = SharingStarted.WhileSubscribed()\' argument.", replaceWith="<_subannotation>") public static final Flow publish(Flow arg0, int arg1) {
        return FlowKt__MigrationKt.publish(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Collect flow in the desired context instead") public static final Flow publishOn(Flow arg0, CoroutineContext arg1) {
        return FlowKt__MigrationKt.publishOn(arg0, arg1);
    }

    public static final Flow receiveAsFlow(ReceiveChannel arg0) {
        return FlowKt__ChannelsKt.receiveAsFlow(arg0);
    }

    public static final Object reduce(Flow arg0, Function3 arg1, Continuation arg2) {
        return FlowKt__ReduceKt.reduce(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'replay()\' is \'shareIn\' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to \'started = SharingStarted.Lazily\' argument, \nreplay().refCount() translates to \'started = SharingStarted.WhileSubscribed()\' argument.", replaceWith="<_subannotation>") public static final Flow replay(Flow arg0) {
        return FlowKt__MigrationKt.replay(arg0);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'replay(bufferSize)\' is \'shareIn\' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to \'started = SharingStarted.Lazily\' argument, \nreplay().refCount() translates to \'started = SharingStarted.WhileSubscribed()\' argument.", replaceWith="<_subannotation>") public static final Flow replay(Flow arg0, int arg1) {
        return FlowKt__MigrationKt.replay(arg0, arg1);
    }

    public static final Flow retry(Flow arg0, long arg1, Function2 arg3) {
        return FlowKt__ErrorsKt.retry(arg0, arg1, arg3);
    }

    public static Flow retry$default(Flow arg0, long arg1, Function2 arg3, int arg4, Object arg5) {
        return FlowKt__ErrorsKt.retry$default(arg0, arg1, arg3, arg4, arg5);
    }

    public static final Flow retryWhen(Flow arg0, Function4 arg1) {
        return FlowKt__ErrorsKt.retryWhen(arg0, arg1);
    }

    public static final Flow runningFold(Flow arg0, Object arg1, Function3 arg2) {
        return FlowKt__TransformKt.runningFold(arg0, arg1, arg2);
    }

    public static final Flow runningReduce(Flow arg0, Function3 arg1) {
        return FlowKt__TransformKt.runningReduce(arg0, arg1);
    }

    public static final Flow sample(Flow arg0, long arg1) {
        return FlowKt__DelayKt.sample(arg0, arg1);
    }

    public static final Flow sample-HG0u8IE(Flow arg0, long arg1) {
        return FlowKt__DelayKt.sample-HG0u8IE(arg0, arg1);
    }

    public static final Flow scan(Flow arg0, Object arg1, Function3 arg2) {
        return FlowKt__TransformKt.scan(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow has less verbose \'scan\' shortcut", replaceWith="<_subannotation>") public static final Flow scanFold(Flow arg0, Object arg1, Function3 arg2) {
        return FlowKt__MigrationKt.scanFold(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="\'scanReduce\' was renamed to \'runningReduce\' to be consistent with Kotlin standard library", replaceWith="<_subannotation>") public static final Flow scanReduce(Flow arg0, Function3 arg1) {
        return FlowKt__MigrationKt.scanReduce(arg0, arg1);
    }

    public static final SharedFlow shareIn(Flow arg0, CoroutineScope arg1, SharingStarted arg2, int arg3) {
        return FlowKt__ShareKt.shareIn(arg0, arg1, arg2, arg3);
    }

    public static SharedFlow shareIn$default(Flow arg0, CoroutineScope arg1, SharingStarted arg2, int arg3, int arg4, Object arg5) {
        return FlowKt__ShareKt.shareIn$default(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    public static final Object single(Flow arg0, Continuation arg1) {
        return FlowKt__ReduceKt.single(arg0, arg1);
    }

    public static final Object singleOrNull(Flow arg0, Continuation arg1) {
        return FlowKt__ReduceKt.singleOrNull(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'skip\' is \'drop\'", replaceWith="<_subannotation>") public static final Flow skip(Flow arg0, int arg1) {
        return FlowKt__MigrationKt.skip(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'startWith\' is \'onStart\'. Use \'onStart { emit(value) }\'", replaceWith="<_subannotation>") public static final Flow startWith(Flow arg0, Object arg1) {
        return FlowKt__MigrationKt.startWith(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogue of \'startWith\' is \'onStart\'. Use \'onStart { emitAll(other) }\'", replaceWith="<_subannotation>") public static final Flow startWith(Flow arg0, Flow arg1) {
        return FlowKt__MigrationKt.startWith(arg0, arg1);
    }

    public static final StateFlow stateIn(Flow arg0, CoroutineScope arg1, SharingStarted arg2, Object arg3) {
        return FlowKt__ShareKt.stateIn(arg0, arg1, arg2, arg3);
    }

    public static final Object stateIn(Flow arg0, CoroutineScope arg1, Continuation arg2) {
        return FlowKt__ShareKt.stateIn(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use \'launchIn\' with \'onEach\', \'onCompletion\' and \'catch\' instead") public static final void subscribe(Flow arg0) {
        FlowKt__MigrationKt.subscribe(arg0);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use \'launchIn\' with \'onEach\', \'onCompletion\' and \'catch\' instead") public static final void subscribe(Flow arg0, Function2 arg1) {
        FlowKt__MigrationKt.subscribe(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use \'launchIn\' with \'onEach\', \'onCompletion\' and \'catch\' instead") public static final void subscribe(Flow arg0, Function2 arg1, Function2 arg2) {
        FlowKt__MigrationKt.subscribe(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use \'flowOn\' instead") public static final Flow subscribeOn(Flow arg0, CoroutineContext arg1) {
        return FlowKt__MigrationKt.subscribeOn(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Flow analogues of \'switchMap\' are \'transformLatest\', \'flatMapLatest\' and \'mapLatest\'", replaceWith="<_subannotation>") public static final Flow switchMap(Flow arg0, Function2 arg1) {
        return FlowKt__MigrationKt.switchMap(arg0, arg1);
    }

    public static final Flow take(Flow arg0, int arg1) {
        return FlowKt__LimitKt.take(arg0, arg1);
    }

    public static final Flow takeWhile(Flow arg0, Function2 arg1) {
        return FlowKt__LimitKt.takeWhile(arg0, arg1);
    }

    public static final Flow timeout-HG0u8IE(Flow arg0, long arg1) {
        return FlowKt__DelayKt.timeout-HG0u8IE(arg0, arg1);
    }

    public static final Object toCollection(Flow arg0, Collection arg1, Continuation arg2) {
        return FlowKt__CollectionKt.toCollection(arg0, arg1, arg2);
    }

    public static final Object toList(Flow arg0, List arg1, Continuation arg2) {
        return FlowKt__CollectionKt.toList(arg0, arg1, arg2);
    }

    public static Object toList$default(Flow arg0, List arg1, Continuation arg2, int arg3, Object arg4) {
        return FlowKt__CollectionKt.toList$default(arg0, arg1, arg2, arg3, arg4);
    }

    public static final Object toSet(Flow arg0, Set arg1, Continuation arg2) {
        return FlowKt__CollectionKt.toSet(arg0, arg1, arg2);
    }

    public static Object toSet$default(Flow arg0, Set arg1, Continuation arg2, int arg3, Object arg4) {
        return FlowKt__CollectionKt.toSet$default(arg0, arg1, arg2, arg3, arg4);
    }

    public static final Flow transform(Flow arg0, Function3 arg1) {
        return FlowKt__EmittersKt.transform(arg0, arg1);
    }

    public static final Flow transformLatest(Flow arg0, Function3 arg1) {
        return FlowKt__MergeKt.transformLatest(arg0, arg1);
    }

    public static final Flow transformWhile(Flow arg0, Function3 arg1) {
        return FlowKt__LimitKt.transformWhile(arg0, arg1);
    }

    public static final Flow unsafeTransform(Flow arg0, Function3 arg1) {
        return FlowKt__EmittersKt.unsafeTransform(arg0, arg1);
    }

    public static final Flow withIndex(Flow arg0) {
        return FlowKt__TransformKt.withIndex(arg0);
    }

    public static final Flow zip(Flow arg0, Flow arg1, Function3 arg2) {
        return FlowKt__ZipKt.zip(arg0, arg1, arg2);
    }
}

