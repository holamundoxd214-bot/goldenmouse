package androidx.compose.ui.text.font;

import androidx.collection.LruCache;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0015\u001A\u00020\u0016J\u001D\u0010\u0017\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013¢\u0006\u0002\b\u0018JH\u0010\u0019\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u00162\u001E\u0010\u001A\u001A\u001A\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001C\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001BH\u0086@¢\u0006\u0002\u0010\u001DJ+\u0010\u001E\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u000E\u0010\u001A\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001FH\u0086\bR\u0010\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001A\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2={"Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "", "<init>", "()V", "PermanentFailure", "Landroidx/compose/ui/text/font/AsyncTypefaceCache$AsyncTypefaceResult;", "Ljava/lang/Object;", "resultCache", "Landroidx/collection/LruCache;", "Landroidx/compose/ui/text/font/AsyncTypefaceCache$Key;", "permanentCache", "Landroidx/collection/MutableScatterMap;", "cacheLock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "put", "", "font", "Landroidx/compose/ui/text/font/Font;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "result", "forever", "", "get", "get-1ASDuI8", "runCached", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/PlatformFontLoader;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runCachedBlocking", "Lkotlin/Function0;", "AsyncTypefaceResult", "Key", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AsyncTypefaceCache {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u000B\u001A\u00020\b2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u000EHÖ\u0001J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\t\u0010\n\u0088\u0001\u0002¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/font/AsyncTypefaceCache$AsyncTypefaceResult;", "", "result", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getResult", "()Ljava/lang/Object;", "isPermanentFailure", "", "isPermanentFailure-impl", "(Ljava/lang/Object;)Z", "equals", "other", "hashCode", "", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class AsyncTypefaceResult {
        private final Object result;

        private AsyncTypefaceResult(Object arg1) {
            super();
            this.result = arg1;
        }

        public static final AsyncTypefaceResult box-impl(Object arg1) {
            return new AsyncTypefaceResult(arg1);
        }

        public static Object constructor-impl(Object arg0) {
            return arg0;
        }

        public boolean equals(Object arg1) {
            return AsyncTypefaceResult.equals-impl(this.result, arg1);
        }

        public static boolean equals-impl(Object arg2, Object arg3) {
            if(!(arg3 instanceof AsyncTypefaceResult)) {
                return 0;
            }

            if(!Intrinsics.areEqual(arg2, ((AsyncTypefaceResult)arg3).unbox-impl())) {
                return 0;
            }

            return 1;
        }

        public static final boolean equals-impl0(Object arg0, Object arg1) {
            return Intrinsics.areEqual(arg0, arg1);
        }

        public final Object getResult() {
            return this.result;
        }

        public int hashCode() {
            return AsyncTypefaceResult.hashCode-impl(this.result);
        }

        public static int hashCode-impl(Object arg0) {
            if(arg0 == null) {
                return 0;
            }

            return arg0.hashCode();
        }

        public static final boolean isPermanentFailure-impl(Object arg0) {
            if(arg0 == null) {
                return 1;
            }

            return 0;
        }

        public String toString() {
            return AsyncTypefaceResult.toString-impl(this.result);
        }

        public static String toString-impl(Object arg2) {
            return "AsyncTypefaceResult(result=" + arg2 + ')';
        }

        public final Object unbox-impl() {
            return this.result;
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\f\u001A\u0004\u0018\u00010\u0001HÆ\u0003J\u001F\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0015"}, d2={"Landroidx/compose/ui/text/font/AsyncTypefaceCache$Key;", "", "font", "Landroidx/compose/ui/text/font/Font;", "loaderKey", "<init>", "(Landroidx/compose/ui/text/font/Font;Ljava/lang/Object;)V", "getFont", "()Landroidx/compose/ui/text/font/Font;", "getLoaderKey", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Key {
        public static final int $stable = 8;
        private final Font font;
        private final Object loaderKey;

        static {
        }

        public Key(Font arg1, Object arg2) {
            super();
            this.font = arg1;
            this.loaderKey = arg2;
        }

        public final Font component1() {
            return this.font;
        }

        public final Object component2() {
            return this.loaderKey;
        }

        public final Key copy(Font arg1, Object arg2) {
            return new Key(arg1, arg2);
        }

        public static Key copy$default(Key arg0, Font arg1, Object arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.font;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.loaderKey;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Key)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Key)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.font, ((Key)arg5).font)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.loaderKey, ((Key)arg5).loaderKey)) {
                return 0;
            }

            return 1;
        }

        public final Font getFont() {
            return this.font;
        }

        public final Object getLoaderKey() {
            return this.loaderKey;
        }

        public int hashCode() {
            int v0 = this.font.hashCode() * 0x1F;
            Object v1 = this.loaderKey;
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            return v0 + v1_1;
        }

        public String toString() {
            return "Key(font=" + this.font + ", loaderKey=" + this.loaderKey + ')';
        }
    }

    public static final int $stable = 8;
    private final Object PermanentFailure;
    private final SynchronizedObject cacheLock;
    private final MutableScatterMap permanentCache;
    private final LruCache resultCache;

    static {
    }

    public AsyncTypefaceCache() {
        super();
        this.PermanentFailure = AsyncTypefaceResult.constructor-impl(null);
        this.resultCache = new LruCache(16);
        this.permanentCache = ScatterMapKt.mutableScatterMapOf();
        this.cacheLock = new SynchronizedObject();
    }

    public static final SynchronizedObject access$getCacheLock$p(AsyncTypefaceCache arg0) {
        return arg0.cacheLock;
    }

    public static final MutableScatterMap access$getPermanentCache$p(AsyncTypefaceCache arg0) {
        return arg0.permanentCache;
    }

    public static final LruCache access$getResultCache$p(AsyncTypefaceCache arg0) {
        return arg0.resultCache;
    }

    public final AsyncTypefaceResult get-1ASDuI8(Font arg2, PlatformFontLoader arg3) {
        Key v0 = new Key(arg2, arg3.getCacheKey());
        SynchronizedObject v2 = this.cacheLock;
        __monitor_enter(v2);
        try {
            Object v3 = this.resultCache.get(v0);
            if(v3 == null) {
                v3 = this.permanentCache.get(v0);
            }

            __monitor_exit(v2);
            return ((AsyncTypefaceResult)v3);
        }
        catch(Throwable v1) {
            __monitor_exit(v2);
            throw v1;
        }
    }

    public final void put(Font arg2, PlatformFontLoader arg3, Object arg4, boolean arg5) {
        Key v0 = new Key(arg2, arg3.getCacheKey());
        SynchronizedObject v2 = this.cacheLock;
        __monitor_enter(v2);
        if(arg4 == null) {
            try {
                this.permanentCache.set(v0, AsyncTypefaceResult.box-impl(this.PermanentFailure));
                goto label_25;
            label_14:
                if(arg5) {
                    this.permanentCache.set(v0, AsyncTypefaceResult.box-impl(AsyncTypefaceResult.constructor-impl(arg4)));
                }
                else {
                    this.resultCache.put(v0, AsyncTypefaceResult.box-impl(AsyncTypefaceResult.constructor-impl(arg4)));
                    goto label_25;
                label_13:
                    goto label_27;
                }
            }
            catch(Throwable v1) {
                goto label_13;
            }
        }
        else {
            goto label_14;
        label_27:
            __monitor_exit(v2);
            throw v1;
        }

    label_25:
        __monitor_exit(v2);
    }

    public static void put$default(AsyncTypefaceCache arg0, Font arg1, PlatformFontLoader arg2, Object arg3, boolean arg4, int arg5, Object arg6) {
        arg0.put(arg1, arg2, arg3, false);
    }

    public final Object runCached(Font arg6, PlatformFontLoader arg7, boolean arg8, Function1 arg9, Continuation arg10) {
        Object v6;
        Key v6_2;
        Object v5_1;
        int v2;
        Continuation v0;
        if((arg10 instanceof AsyncTypefaceCache$runCached$1)) {
            v0 = arg10;
            v2 = 0x80000000;
            if((((AsyncTypefaceCache$runCached$1)v0).label & v2) != 0) {
                ((AsyncTypefaceCache$runCached$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            AsyncTypefaceCache$runCached$1 v0_1 = new AsyncTypefaceCache$runCached$1(this, arg10);
        }

        Object v10 = ((AsyncTypefaceCache$runCached$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((AsyncTypefaceCache$runCached$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v10);
            Key v10_1 = new Key(arg6, arg7.getCacheKey());
            SynchronizedObject v6_1 = this.cacheLock;
            __monitor_enter(v6_1);
            try {
                Object v7 = this.resultCache.get(v10_1);
                if(v7 == null) {
                    v7 = this.permanentCache.get(v10_1);
                }

                if(v7 == null) {
                    goto label_42;
                }

                v5_1 = ((AsyncTypefaceResult)v7).unbox-impl();
            }
            catch(Throwable v5) {
                goto label_79;
            }

            __monitor_exit(v6_1);
            return v5_1;
        label_42:
            goto label_43;
        label_79:
            __monitor_exit(v6_1);
            throw v5;
        label_43:
            __monitor_exit(v6_1);
            ((AsyncTypefaceCache$runCached$1)v0).L$0 = v10_1;
            ((AsyncTypefaceCache$runCached$1)v0).Z$0 = arg8;
            ((AsyncTypefaceCache$runCached$1)v0).label = 1;
            v6 = arg9.invoke(v0);
            if(v6 == v1) {
                return v1;
            }

            Key v4 = v10_1;
            v10 = v6;
            v6_2 = v4;
        }
        else if(v2 == 1) {
            arg8 = ((AsyncTypefaceCache$runCached$1)v0).Z$0;
            v6 = ((AsyncTypefaceCache$runCached$1)v0).L$0;
            ResultKt.throwOnFailure(v10);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        SynchronizedObject v7_1 = this.cacheLock;
        __monitor_enter(v7_1);
        if(v10 == null) {
            try {
                this.permanentCache.set(v6_2, AsyncTypefaceResult.box-impl(this.PermanentFailure));
                goto label_73;
            label_63:
                if(arg8) {
                    this.permanentCache.set(v6_2, AsyncTypefaceResult.box-impl(AsyncTypefaceResult.constructor-impl(v10)));
                }
                else {
                    this.resultCache.put(v6_2, AsyncTypefaceResult.box-impl(AsyncTypefaceResult.constructor-impl(v10)));
                }

            label_73:
                goto label_74;
            label_62:
                goto label_76;
            }
            catch(Throwable v5) {
                goto label_62;
            }
        }
        else {
            goto label_63;
        }

        goto label_73;
    label_76:
        __monitor_exit(v7_1);
        throw v5;
    label_74:
        __monitor_exit(v7_1);
        return v10;
    }

    public final Object runCachedBlocking(Font arg10, PlatformFontLoader arg11, Function0 arg12) {
        Object v9;
        SynchronizedObject v1 = this.cacheLock;
        __monitor_enter(v1);
        try {
            Key v0_1 = new Key(arg10, arg11.getCacheKey());
            Object v2 = this.resultCache.get(v0_1);
            if(v2 == null) {
                v2 = this.permanentCache.get(v0_1);
            }

            if(v2 == null) {
                goto label_15;
            }

            v9 = ((AsyncTypefaceResult)v2).unbox-impl();
        }
        catch(Throwable v0) {
            goto label_28;
        }

        __monitor_exit(v1);
        return v9;
    label_15:
        goto label_16;
    label_28:
        __monitor_exit(v1);
        throw v0;
    label_16:
        __monitor_exit(v1);
        Object v5 = arg12.invoke();
        AsyncTypefaceCache.put$default(this, arg10, arg11, v5, false, 8, null);
        return v5;
    }
}

