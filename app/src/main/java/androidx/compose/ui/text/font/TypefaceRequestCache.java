package androidx.compose.ui.text.font;

import androidx.collection.LruCache;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u000E\u001A\u00020\n2\u001E\u0010\u000F\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u000B0\u0010J(\u0010\u0012\u001A\u00020\u00112\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\n0\u00142\u0012\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\u0010J\u0017\u0010\u0015\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u000E\u001A\u00020\nH\u0000¢\u0006\u0002\b\u0016R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001A\u00020\u00188@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2={"Landroidx/compose/ui/text/font/TypefaceRequestCache;", "", "<init>", "()V", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "getLock$ui_text", "()Landroidx/compose/ui/text/platform/SynchronizedObject;", "resultCache", "Landroidx/collection/LruCache;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "Landroidx/compose/ui/text/font/TypefaceResult;", "runCached", "Landroidx/compose/runtime/State;", "typefaceRequest", "resolveTypeface", "Lkotlin/Function1;", "", "preWarmCache", "typefaceRequests", "", "get", "get$ui_text", "size", "", "getSize$ui_text", "()I", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TypefaceRequestCache {
    public static final int $stable = 8;
    private final SynchronizedObject lock;
    private final LruCache resultCache;

    static {
    }

    public TypefaceRequestCache() {
        super();
        this.lock = new SynchronizedObject();
        this.resultCache = new LruCache(16);
    }

    public final TypefaceResult get$ui_text(TypefaceRequest arg2) {
        SynchronizedObject v0 = this.lock;
        __monitor_enter(v0);
        try {
            __monitor_exit(v0);
            return this.resultCache.get(arg2);
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }
    }

    public final SynchronizedObject getLock$ui_text() {
        return this.lock;
    }

    public final int getSize$ui_text() {
        int v1_1;
        SynchronizedObject v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1_1 = this.resultCache.size();
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
        return v1_1;
    }

    public final void preWarmCache(List arg7, Function1 arg8) {
        Object v3_1;
        int v0 = arg7.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg7.get(v1);
            SynchronizedObject v3 = this.lock;
            __monitor_enter(v3);
            try {
                __monitor_exit(v3);
                if(this.resultCache.get(v2) != null) {
                    goto label_28;
                }
            }
            catch(Throwable v6) {
                __monitor_exit(v3);
                throw v6;
            }

            try {
                v3_1 = arg8.invoke(v2);
                if((v3_1 instanceof Async)) {
                    goto label_28;
                }
            }
            catch(Exception v6_1) {
                throw new IllegalStateException("Could not load font", ((Throwable)v6_1));
            }

            SynchronizedObject v4 = this.lock;
            __monitor_enter(v4);
            try {
                this.resultCache.put(v2, v3_1);
                __monitor_exit(v4);
            }
            catch(Throwable v6) {
                __monitor_exit(v4);
                throw v6;
            }

        label_28:
        }
    }

    public final State runCached(TypefaceRequest arg4, Function1 arg5) {
        Object v5;
        SynchronizedObject v0 = this.lock;
        __monitor_enter(v0);
        try {
            Object v1 = this.resultCache.get(arg4);
            if(v1 != null) {
                if(((TypefaceResult)v1).getCacheable()) {
                    __monitor_exit(v0);
                    return ((State)v1);
                }
                else {
                    this.resultCache.remove(arg4);
                }
            }

            __monitor_exit(v0);
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        try {
            v5 = arg5.invoke(new TypefaceRequestCache$$ExternalSyntheticLambda0(this, arg4));
            v0 = this.lock;
        }
        catch(Exception v3_1) {
            throw new IllegalStateException("Could not load font", ((Throwable)v3_1));
        }

        __monitor_enter(v0);
        try {
            if(this.resultCache.get(arg4) == null && (((TypefaceResult)v5).getCacheable())) {
                this.resultCache.put(arg4, v5);
            }
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
        return ((State)v5);
    }

    static final Unit runCached$lambda$1(TypefaceRequestCache arg2, TypefaceRequest arg3, TypefaceResult arg4) {
        SynchronizedObject v0 = arg2.lock;
        __monitor_enter(v0);
        try {
            if(arg4.getCacheable()) {
                arg2.resultCache.put(arg3, arg4);
            }
            else {
                arg2.resultCache.remove(arg3);
            }
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
        return Unit.INSTANCE;
    }
}

