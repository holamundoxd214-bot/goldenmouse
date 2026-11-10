package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.graphics.Typeface;
import android.os.Build$VERSION;
import android.os.CancellationSignal;
import androidx.activity.OnBackPressedCallback$$ExternalSyntheticThrowIAE2;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Consumer;
import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

class FontRequestWorker {
    final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        TypefaceResult(Typeface arg1) {
            super();
            this.mTypeface = arg1;
            this.mResult = 0;
        }

        TypefaceResult(int arg2) {
            super();
            this.mTypeface = null;
            this.mResult = arg2;
        }

        boolean isSuccess() {
            if(this.mResult == 0) {
                return 1;
            }

            return 0;
        }
    }

    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE;
    static final Object LOCK;
    static final SimpleArrayMap PENDING_REPLIES;
    static final LruCache sTypefaceCache;

    static {
        FontRequestWorker.sTypefaceCache = new LruCache(16);
        FontRequestWorker.DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
        FontRequestWorker.LOCK = new Object();
        FontRequestWorker.PENDING_REPLIES = new SimpleArrayMap();
    }

    private FontRequestWorker() {
        super();
    }

    private static String createCacheId(List arg4, int arg5) {
        StringBuilder v0 = new StringBuilder();
        int v1;
        for(v1 = 0; v1 < arg4.size(); ++v1) {
            v0.append(arg4.get(v1).getId()).append("-").append(arg5);
            if(v1 < arg4.size() - 1) {
                v0.append(";");
            }
        }

        return v0.toString();
    }

    private static int getFontFamilyResultStatus(FontFamilyResult arg5) {
        int v1 = -3;
        int v2 = 1;
        if(arg5.getStatusCode() != 0) {
            if(arg5.getStatusCode() != 1) {
                return v1;
            }

            return -2;
        }

        FontInfo[] v5 = arg5.getFonts();
        if(v5 != null) {
            if(v5.length == 0) {
            }
            else {
                int v0 = v5.length;
                v2 = 0;
                int v3 = 0;
                while(v3 < v0) {
                    int v4 = v5[v3].getResultCode();
                    if(v4 == 0) {
                        ++v3;
                        continue;
                    }
                    else if(v4 < 0) {
                        return v1;
                    }
                    else {
                        return v4;
                    }

                    return v2;
                }
            }
        }

        return v2;
    }

    static TypefaceResult getFontSync(String arg4, Context arg5, List arg6, int arg7) {
        FontFamilyResult v6;
        TypefaceResult v4_1;
        LruCache v0;
        Trace.beginSection("getFontSync");
        try {
            v0 = FontRequestWorker.sTypefaceCache;
            Object v1 = v0.get(arg4);
            if(v1 == null) {
                goto label_9;
            }

            v4_1 = new TypefaceResult(((Typeface)v1));
        }
        catch(Throwable v4) {
            goto label_44;
        }

        Trace.endSection();
        return v4_1;
    label_9:
        CancellationSignal v1_1 = null;
        try {
            v6 = FontProvider.getFontFamilyResult(arg5, arg6, v1_1);
            goto label_11;
        }
        catch(Throwable v4) {
        }
        catch(PackageManager$NameNotFoundException ) {
            try {
                v4_1 = new TypefaceResult(-1);
            }
            catch(Throwable v4) {
                goto label_44;
            }

            Trace.endSection();
            return v4_1;
            try {
            label_11:
                int v2 = FontRequestWorker.getFontFamilyResultStatus(v6);
                if(v2 == 0) {
                    goto label_17;
                }

                v4_1 = new TypefaceResult(v2);
            }
            catch(Throwable v4) {
                goto label_44;
            }

            Trace.endSection();
            return v4_1;
            try {
            label_17:
                Typeface v5 = !v6.hasFallback() || Build$VERSION.SDK_INT < 29 ? TypefaceCompat.createFromFontInfo(arg5, v1_1, v6.getFonts(), arg7) : TypefaceCompat.createFromFontInfoWithFallback(arg5, v1_1, v6.getFontsWithFallbacks(), arg7);
                if(v5 == null) {
                    goto label_33;
                }

                v0.put(arg4, v5);
                v4_1 = new TypefaceResult(v5);
            }
            catch(Throwable v4) {
                goto label_44;
            }

            Trace.endSection();
            return v4_1;
            try {
            label_33:
                v4_1 = new TypefaceResult(-3);
            }
            catch(Throwable v4) {
            label_44:
                Trace.endSection();
                throw v4;
            }
        }

        Trace.endSection();
        return v4_1;
    }

    static Typeface requestFontAsync(Context arg5, List arg6, int arg7, Executor arg8, CallbackWrapper arg9) {
        ExecutorService v8;
        Typeface v4;
        String v0 = FontRequestWorker.createCacheId(arg6, arg7);
        Object v1 = FontRequestWorker.sTypefaceCache.get(v0);
        if(v1 != null) {
            arg9.onTypefaceResult(new TypefaceResult(((Typeface)v1)));
            return ((Typeface)v1);
        }

        androidx.core.provider.FontRequestWorker$2 v1_1 = new Consumer(arg9) {
            public void accept(TypefaceResult arg2) {
                if(arg2 == null) {
                    arg2 = new TypefaceResult(-3);
                }

                this.val$callback.onTypefaceResult(arg2);
            }

            public void accept(Object arg1) {
                this.accept(((TypefaceResult)arg1));
            }
        };
        Object v9 = FontRequestWorker.LOCK;
        __monitor_enter(v9);
        try {
            SimpleArrayMap v2 = FontRequestWorker.PENDING_REPLIES;
            Object v3 = v2.get(v0);
            v4 = null;
            if(v3 != null) {
                ((ArrayList)v3).add(v1_1);
                __monitor_exit(v9);
                return v4;
            }

            ArrayList v3_1 = new ArrayList();
            v3_1.add(v1_1);
            v2.put(v0, v3_1);
            __monitor_exit(v9);
        }
        catch(Throwable v5) {
            try {
            label_33:
                __monitor_exit(v9);
            }
            catch(Throwable v5) {
                goto label_33;
            }

            throw v5;
        }

        androidx.core.provider.FontRequestWorker$3 v9_1 = new Callable(v0, arg5, arg6, arg7) {
            public TypefaceResult call() {
                try {
                    return FontRequestWorker.getFontSync(this.val$id, this.val$context, this.val$requests, this.val$style);
                }
                catch(Throwable ) {
                    return new TypefaceResult(-3);
                }
            }

            public Object call() throws Exception {
                return this.call();
            }
        };
        if(arg8 == null) {
            v8 = FontRequestWorker.DEFAULT_EXECUTOR_SERVICE;
        }

        RequestExecutor.execute(((Executor)v8), ((Callable)v9_1), new Consumer(v0) {
            public void accept(TypefaceResult arg4) {
                int v3_1;
                Object v1;
                Object v0 = FontRequestWorker.LOCK;
                __monitor_enter(v0);
                try {
                    v1 = FontRequestWorker.PENDING_REPLIES.get(this.val$id);
                    if(v1 == null) {
                        __monitor_exit(v0);
                        return;
                    }

                    FontRequestWorker.PENDING_REPLIES.remove(this.val$id);
                    __monitor_exit(v0);
                    v3_1 = 0;
                }
                catch(Throwable v3) {
                    try {
                    label_21:
                        __monitor_exit(v0);
                    }
                    catch(Throwable v3) {
                        goto label_21;
                    }

                    throw v3;
                }

                while(v3_1 < ((ArrayList)v1).size()) {
                    ((ArrayList)v1).get(v3_1).accept(arg4);
                    ++v3_1;
                }
            }

            public void accept(Object arg1) {
                this.accept(((TypefaceResult)arg1));
            }
        });
        return v4;
    }

    static Typeface requestFontSync(Context arg2, FontRequest arg3, CallbackWrapper arg4, int arg5, int arg6) {
        String v0 = FontRequestWorker.createCacheId(OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(arg3), arg5);
        Object v1 = FontRequestWorker.sTypefaceCache.get(v0);
        if(v1 != null) {
            arg4.onTypefaceResult(new TypefaceResult(((Typeface)v1)));
            return ((Typeface)v1);
        }

        if(arg6 == -1) {
            TypefaceResult v2 = FontRequestWorker.getFontSync(v0, arg2, OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(arg3), arg5);
            arg4.onTypefaceResult(v2);
            return v2.mTypeface;
        }

        androidx.core.provider.FontRequestWorker$1 v1_1 = new Callable(v0, arg2, arg3, arg5) {
            public TypefaceResult call() {
                return FontRequestWorker.getFontSync(this.val$id, this.val$context, OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(this.val$request), this.val$style);
            }

            public Object call() throws Exception {
                return this.call();
            }
        };
        try {
            Object v2_1 = RequestExecutor.submit(FontRequestWorker.DEFAULT_EXECUTOR_SERVICE, ((Callable)v1_1), arg6);
            arg4.onTypefaceResult(((TypefaceResult)v2_1));
            return ((TypefaceResult)v2_1).mTypeface;
        }
        catch(InterruptedException ) {
            arg4.onTypefaceResult(new TypefaceResult(-3));
            return null;
        }
    }

    static void resetTypefaceCache() {
        FontRequestWorker.sTypefaceCache.evictAll();
    }
}

