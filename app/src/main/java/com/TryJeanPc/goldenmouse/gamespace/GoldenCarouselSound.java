package com.TryJeanPc.goldenmouse.gamespace;

import android.content.Context;
import android.media.AudioAttributes$Builder;
import android.media.SoundPool$Builder;
import android.media.SoundPool$OnLoadCompleteListener;
import android.media.SoundPool;
import android.util.Log;
import com.TryJeanPc.goldenmouse.R$raw;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\fJ\u0006\u0010\u0011\u001A\u00020\u000FJ\u0006\u0010\u0012\u001A\u00020\u000FR\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/gamespace/GoldenCarouselSound;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "pool", "Landroid/media/SoundPool;", "sample", "", "stream", "loaded", "", "active", "setActive", "", "value", "play", "release", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenCarouselSound {
    public static final int $stable = 8;
    private boolean active;
    private boolean loaded;
    private SoundPool pool;
    private int sample;
    private int stream;

    static {
    }

    public GoldenCarouselSound(Context arg5) {
        Intrinsics.checkNotNullParameter(arg5, "context");
        super();
        try {
            SoundPool v0 = new SoundPool$Builder().setMaxStreams(1).setAudioAttributes(new AudioAttributes$Builder().setUsage(14).setContentType(4).build()).build();
            this.pool = v0;
            v0.setOnLoadCompleteListener(new GoldenCarouselSound$$ExternalSyntheticLambda0(this));
            this.sample = v0.load(arg5.getApplicationContext(), raw.golden_carousel_click, 1);
            return;
        }
        catch(RuntimeException v5) {
            Log.w("GoldenCarouselSound", "Sound unavailable", ((Throwable)v5));
            this.release();
            return;
        }
    }

    static final void _init_$lambda$0(GoldenCarouselSound arg0, SoundPool arg1, int arg2, int arg3) {
        boolean v1 = arg2 != arg0.sample || arg3 != 0 ? false : true;
        arg0.loaded = v1;
        if(arg3 != 0) {
            Log.w("GoldenCarouselSound", "Sound load failed: " + arg3);
        }
    }

    public final void play() {
        if((this.active) && (this.loaded)) {
            try {
                SoundPool v1 = this.pool;
                if(v1 == null) {
                    return;
                }

                int v0_1 = this.stream;
                if(v0_1 != 0) {
                    v1.stop(v0_1);
                }

                this.stream = v1.play(this.sample, 0.32f, 0.32f, 1, 0, 1f);
                return;
            }
            catch(RuntimeException v0) {
                Log.w("GoldenCarouselSound", "Cannot play sound", v0);
            }
        }
    }

    public final void release() {
        this.active = false;
        this.loaded = false;
        SoundPool v0 = this.pool;
        SoundPool v1 = null;
        this.pool = v1;
        if(v0 != null) {
            try {
                v0.setOnLoadCompleteListener(((SoundPool$OnLoadCompleteListener)v1));
            label_8:
                if(v0 == null) {
                    return;
                }

                v0.release();
                return;
            }
            catch(RuntimeException v2) {
                Log.w("GoldenCarouselSound", "Cannot release sound", ((Throwable)v2));
                return;
            }
        }

        goto label_8;
    }

    public final void setActive(boolean arg3) {
        this.active = arg3;
        if(!arg3) {
            try {
                SoundPool v3_1 = this.pool;
                if(v3_1 == null) {
                    goto label_11;
                }

                v3_1.stop(this.stream);
            }
            catch(RuntimeException v3) {
                Log.w("GoldenCarouselSound", "Cannot stop sound", ((Throwable)v3));
            }

        label_11:
            this.stream = 0;
        }
    }
}

