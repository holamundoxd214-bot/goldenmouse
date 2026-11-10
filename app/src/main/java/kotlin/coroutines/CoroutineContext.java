package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J)\u0010\u0002\u001A\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00030\u0006H¦\u0082\u0004¢\u0006\u0002\u0010\u0007J7\u0010\b\u001A\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001A\u0002H\t2\u0018\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\t0\fH¦\u0080\u0004¢\u0006\u0002\u0010\rJ\u0012\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u0000H\u0096\u0082\u0004J\u0016\u0010\u0010\u001A\u00020\u00002\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0006H¦\u0080\u0004¨\u0006\u0013"}, d2={"Lkotlin/coroutines/CoroutineContext;", "", "get", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "plus", "context", "minusKey", "Key", "Element", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface CoroutineContext {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class DefaultImpls {
        public static CoroutineContext plus(CoroutineContext arg1, CoroutineContext arg2) {
            Intrinsics.checkNotNullParameter(arg2, "context");
            if(arg2 == EmptyCoroutineContext.INSTANCE) {
                return arg1;
            }

            return arg2.fold(arg1, new CoroutineContext$DefaultImpls$$ExternalSyntheticLambda0());
        }

        static CoroutineContext plus$lambda$0(CoroutineContext arg3, Element arg4) {
            CombinedContext v0_1;
            Intrinsics.checkNotNullParameter(arg3, "acc");
            Intrinsics.checkNotNullParameter(arg4, "element");
            arg3 = arg3.minusKey(arg4.getKey());
            if(arg3 == EmptyCoroutineContext.INSTANCE) {
                return arg4;
            }

            Element v0 = arg3.get(ContinuationInterceptor.Key);
            if(v0 == null) {
                v0_1 = new CombinedContext(arg3, arg4);
            }
            else {
                arg3 = arg3.minusKey(ContinuationInterceptor.Key);
                v0_1 = arg3 == EmptyCoroutineContext.INSTANCE ? new CombinedContext(((CoroutineContext)arg4), v0) : new CombinedContext(new CombinedContext(arg3, arg4), v0);
            }

            return ((CoroutineContext)v0_1);
        }
    }

    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0006\u001A\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u00002\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0003H\u0096\u0082\u0004¢\u0006\u0002\u0010\bJ7\u0010\t\u001A\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000B\u001A\u0002H\n2\u0018\u0010\f\u001A\u0014\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\n0\rH\u0096\u0080\u0004¢\u0006\u0002\u0010\u000EJ\u0016\u0010\u000F\u001A\u00020\u00012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003H\u0096\u0080\u0004R\u0017\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003X¦\u0084\b¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2={"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "minusKey", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface Element extends CoroutineContext {
        @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class kotlin.coroutines.CoroutineContext$Element$DefaultImpls {
            public static Object fold(Element arg1, Object arg2, Function2 arg3) {
                Intrinsics.checkNotNullParameter(arg3, "operation");
                return arg3.invoke(arg2, arg1);
            }

            public static Element get(Element arg1, Key arg2) {
                Intrinsics.checkNotNullParameter(arg2, "key");
                if(Intrinsics.areEqual(arg1.getKey(), arg2)) {
                    Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                    return arg1;
                }

                return null;
            }

            public static CoroutineContext minusKey(Element arg1, Key arg2) {
                Intrinsics.checkNotNullParameter(arg2, "key");
                if(Intrinsics.areEqual(arg1.getKey(), arg2)) {
                    return EmptyCoroutineContext.INSTANCE;
                }

                return arg1;
            }

            public static CoroutineContext plus(Element arg1, CoroutineContext arg2) {
                Intrinsics.checkNotNullParameter(arg2, "context");
                return DefaultImpls.plus(((CoroutineContext)arg1), arg2);
            }
        }

        Object fold(Object arg1, Function2 arg2);

        Element get(Key arg1);

        Key getKey();

        CoroutineContext minusKey(Key arg1);
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2={"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface Key {
    }

    Object fold(Object arg1, Function2 arg2);

    Element get(Key arg1);

    CoroutineContext minusKey(Key arg1);

    CoroutineContext plus(CoroutineContext arg1);
}

