package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FJ$\u0010\u0002\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00040\u0003H¦\u0080\u0004J\u0016\u0010\u0006\u001A\u00020\u00072\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0003H\u0096\u0080\u0004J)\u0010\b\u001A\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\t0\u000BH\u0096\u0082\u0004¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001A\u00020\u000E2\n\u0010\n\u001A\u0006\u0012\u0002\b\u00030\u000BH\u0096\u0080\u0004¨\u0006\u0010"}, d2={"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "releaseInterceptedContinuation", "", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "Key", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public interface ContinuationInterceptor extends Element {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class DefaultImpls {
        public static Object fold(ContinuationInterceptor arg1, Object arg2, Function2 arg3) {
            Intrinsics.checkNotNullParameter(arg3, "operation");
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.fold(((Element)arg1), arg2, arg3);
        }

        public static Element get(ContinuationInterceptor arg2, Key arg3) {
            Intrinsics.checkNotNullParameter(arg3, "key");
            Element v1 = null;
            if((arg3 instanceof AbstractCoroutineContextKey)) {
                if(((AbstractCoroutineContextKey)arg3).isSubKey$kotlin_stdlib(arg2.getKey())) {
                    Element v2 = ((AbstractCoroutineContextKey)arg3).tryCast$kotlin_stdlib(((Element)arg2));
                    if((v2 instanceof Element)) {
                        return v2;
                    }
                }

                return v1;
            }

            if(ContinuationInterceptor.Key == arg3) {
                Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return arg2;
            }

            return v1;
        }

        public static CoroutineContext minusKey(ContinuationInterceptor arg1, Key arg2) {
            Intrinsics.checkNotNullParameter(arg2, "key");
            if((arg2 instanceof AbstractCoroutineContextKey)) {
                if((((AbstractCoroutineContextKey)arg2).isSubKey$kotlin_stdlib(arg1.getKey())) && ((AbstractCoroutineContextKey)arg2).tryCast$kotlin_stdlib(arg1) != null) {
                    return EmptyCoroutineContext.INSTANCE;
                }

                return arg1;
            }

            if(ContinuationInterceptor.Key == arg2) {
                return EmptyCoroutineContext.INSTANCE;
            }

            return arg1;
        }

        public static CoroutineContext plus(ContinuationInterceptor arg1, CoroutineContext arg2) {
            Intrinsics.checkNotNullParameter(arg2, "context");
            return kotlin.coroutines.CoroutineContext$Element$DefaultImpls.plus(((Element)arg1), arg2);
        }

        public static void releaseInterceptedContinuation(ContinuationInterceptor arg0, Continuation arg1) {
            Intrinsics.checkNotNullParameter(arg1, "continuation");
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "<init>", "()V", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class kotlin.coroutines.ContinuationInterceptor$Key implements Key {
        static {
            kotlin.coroutines.ContinuationInterceptor$Key.$$INSTANCE = new kotlin.coroutines.ContinuationInterceptor$Key();
        }

        private kotlin.coroutines.ContinuationInterceptor$Key() {
            super();
        }
    }

    public static final kotlin.coroutines.ContinuationInterceptor$Key Key;

    static {
        ContinuationInterceptor.Key = kotlin.coroutines.ContinuationInterceptor$Key.$$INSTANCE;
    }

    Element get(Key arg1);

    Continuation interceptContinuation(Continuation arg1);

    CoroutineContext minusKey(Key arg1);

    void releaseInterceptedContinuation(Continuation arg1);
}

