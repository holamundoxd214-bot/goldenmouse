package androidx.activity;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public final class OnBackPressedCallback$$ExternalSyntheticThrowIAE2 {
    public static void m(Object arg1) {
        if((arg1 instanceof AutoCloseable)) {
            ((AutoCloseable)arg1).close();
            return;
        }

        if((arg1 instanceof ExecutorService)) {
            OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(((ExecutorService)arg1));
            return;
        }

        if((arg1 instanceof TypedArray)) {
            ((TypedArray)arg1).recycle();
            return;
        }

        if((arg1 instanceof MediaMetadataRetriever)) {
            ((MediaMetadataRetriever)arg1).release();
            return;
        }

        if((arg1 instanceof MediaDrm)) {
            ((MediaDrm)arg1).release();
            return;
        }

        OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m$1(arg1);
    }

    public static boolean m(String arg5) {
        int v0 = arg5.length();
        int v2;
        for(v2 = 0; v2 < v0; v2 += Character.charCount(v3)) {
            int v3 = arg5.codePointAt(v2);
            if(!Character.isWhitespace(v3)) {
                return 0;
            }
        }

        return 1;
    }

    public static List m(Object arg0) {
        return OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(new Object[]{arg0});
    }

    public static List m(Object[] arg4) {
        ArrayList v0 = new ArrayList(arg4.length);
        int v1 = arg4.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(Objects.requireNonNull(arg4[v2]));
        }

        return Collections.unmodifiableList(((List)v0));
    }

    public static void m(ExecutorService arg5) {
        if(arg5 != ForkJoinPool.commonPool()) {
            boolean v0 = arg5.isTerminated();
            if(!v0) {
                arg5.shutdown();
                int v1 = 0;
                while(!v0) {
                    try {
                        v0 = arg5.awaitTermination(1, TimeUnit.DAYS);
                    }
                    catch(InterruptedException ) {
                        if(v1 != 0) {
                            continue;
                        }

                        arg5.shutdownNow();
                        v1 = 1;
                    }
                }

                if(v1 == 0) {
                    return;
                }

                Thread.currentThread().interrupt();
            }
        }
    }

    public static void m$1(Object arg0) {
        throw new IllegalArgumentException();
    }
}

