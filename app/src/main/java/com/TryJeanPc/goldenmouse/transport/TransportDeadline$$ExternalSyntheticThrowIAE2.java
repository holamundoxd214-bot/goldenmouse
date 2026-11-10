package com.TryJeanPc.goldenmouse.transport;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public final class TransportDeadline$$ExternalSyntheticThrowIAE2 {
    public static void m(Object arg1) {
        if((arg1 instanceof AutoCloseable)) {
            ((AutoCloseable)arg1).close();
            return;
        }

        if((arg1 instanceof ExecutorService)) {
            TransportDeadline$$ExternalSyntheticThrowIAE2.m(((ExecutorService)arg1));
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

        TransportDeadline$$ExternalSyntheticThrowIAE2.m$1(arg1);
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

