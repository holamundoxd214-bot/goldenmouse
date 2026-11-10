package com.TryJeanPc.goldenmouse.telemetry;

import android.view.Choreographer$FrameCallback;
import android.view.Choreographer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B5\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000B\u0010\fJ\u0006\u0010\u0012\u001A\u00020\nJ\u0006\u0010\u0013\u001A\u00020\nJ\u0010\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\u0006H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/telemetry/FpsCalculator;", "Landroid/view/Choreographer$FrameCallback;", "frames", "Lcom/TryJeanPc/goldenmouse/telemetry/FpsCalculator$Frames;", "uptimeMillis", "Lkotlin/Function0;", "", "onFpsCalculated", "Lkotlin/Function1;", "", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/telemetry/FpsCalculator$Frames;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "running", "", "generation", "frameCount", "lastCalculationTimeMs", "start", "stop", "doFrame", "frameTimeNanos", "Frames", "AndroidFrames", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class FpsCalculator implements Choreographer$FrameCallback {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016¨\u0006\t"}, d2={"Lcom/TryJeanPc/goldenmouse/telemetry/FpsCalculator$AndroidFrames;", "Lcom/TryJeanPc/goldenmouse/telemetry/FpsCalculator$Frames;", "<init>", "()V", "post", "", "callback", "Landroid/view/Choreographer$FrameCallback;", "remove", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class AndroidFrames implements Frames {
        public static final AndroidFrames INSTANCE;

        static {
            AndroidFrames.INSTANCE = new AndroidFrames();
        }

        private AndroidFrames() {
            super();
        }

        public void post(Choreographer$FrameCallback arg1) {
            Intrinsics.checkNotNullParameter(arg1, "callback");
            Choreographer.getInstance().postFrameCallback(arg1);
        }

        public void remove(Choreographer$FrameCallback arg1) {
            Intrinsics.checkNotNullParameter(arg1, "callback");
            Choreographer.getInstance().removeFrameCallback(arg1);
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/telemetry/FpsCalculator$Frames;", "", "post", "", "callback", "Landroid/view/Choreographer$FrameCallback;", "remove", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface Frames {
        void post(Choreographer$FrameCallback arg1);

        void remove(Choreographer$FrameCallback arg1);
    }

    public static final int $stable = 8;
    private int frameCount;
    private final Frames frames;
    private long generation;
    private long lastCalculationTimeMs;
    private final Function1 onFpsCalculated;
    private boolean running;
    private final Function0 uptimeMillis;

    static {
    }

    public FpsCalculator(Frames arg2, Function0 arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "frames");
        Intrinsics.checkNotNullParameter(arg3, "uptimeMillis");
        Intrinsics.checkNotNullParameter(arg4, "onFpsCalculated");
        super();
        this.frames = arg2;
        this.uptimeMillis = arg3;
        this.onFpsCalculated = arg4;
    }

    public FpsCalculator(Frames arg1, Function0 arg2, Function1 arg3, int arg4, DefaultConstructorMarker arg5) {
        com.TryJeanPc.goldenmouse.telemetry.FpsCalculator$1 v2;
        AndroidFrames v1;
        if((arg4 & 1) != 0) {
            v1 = AndroidFrames.INSTANCE;
        }

        if((arg4 & 2) != 0) {
            v2 = com.TryJeanPc.goldenmouse.telemetry.FpsCalculator$1.INSTANCE;
        }

        this(((Frames)v1), ((Function0)v2), arg3);
    }

    public void doFrame(long arg10) {
        if(!this.running) {
        }
        else {
            arg10 = this.generation;
            ++this.frameCount;
            long v0 = this.uptimeMillis.invoke().longValue();
            long v2 = v0 - this.lastCalculationTimeMs;
            long v4 = 1000;
            if(v2 >= v4) {
                this.onFpsCalculated.invoke(Integer.valueOf(((int)((((long)this.frameCount)) * v4 / v2))));
                if(!this.running) {
                    return;
                }
                else if(this.generation != arg10) {
                    return;
                }
                else {
                    this.frameCount = 0;
                    this.lastCalculationTimeMs = v0;
                }
            }

            if(!this.running) {
                return;
            }

            if(this.generation != arg10) {
                return;
            }

            this.frames.post(((Choreographer$FrameCallback)this));
        }
    }

    public final void start() {
        if(this.running) {
            return;
        }

        this.running = true;
        ++this.generation;
        this.frameCount = 0;
        this.lastCalculationTimeMs = this.uptimeMillis.invoke().longValue();
        this.frames.post(((Choreographer$FrameCallback)this));
    }

    public final void stop() {
        if(!this.running) {
            return;
        }

        this.running = false;
        ++this.generation;
        this.frames.remove(this);
        this.frameCount = 0;
        this.lastCalculationTimeMs = 0;
    }
}

