package com.TryJeanPc.goldenmouse.aim.gg;

import java.util.Random;
import java.util.function.LongSupplier;

public final class FpsCameraKernel {
    public final class Bounds {
        private final int bottom;
        private final int left;
        private final int right;
        private final int top;

        public Bounds(int arg1, int arg2, int arg3, int arg4) {
            super();
            this.left = arg1;
            this.top = arg2;
            this.right = arg3;
            this.bottom = arg4;
            if(arg3 >= arg1 && arg4 >= arg2) {
                return;
            }

            throw new IllegalArgumentException("Inverted bounds");
        }

        public int bottom() {
            return this.bottom;
        }

        int clipX(int arg2) {
            return Math.min(Math.max(arg2, this.left), this.right);
        }

        int clipY(int arg2) {
            return Math.min(Math.max(arg2, this.top), this.bottom);
        }

        public boolean contains(int arg2, int arg3) {
            if(arg2 >= this.left && arg2 <= this.right && arg3 >= this.top && arg3 <= this.bottom) {
                return 1;
            }

            return 0;
        }

        public int left() {
            return this.left;
        }

        public int right() {
            return this.right;
        }

        public int top() {
            return this.top;
        }
    }

    public interface Delays {
        void sleepMillis(int arg1);
    }

    public enum HorizontalCorrection {
        public static final enum HorizontalCorrection NONE;
        public static final enum HorizontalCorrection POSITION_CURVE;
        public static final enum HorizontalCorrection POSITION_RATIONAL;

        private static HorizontalCorrection[] $values() {
            return new HorizontalCorrection[]{HorizontalCorrection.NONE, HorizontalCorrection.POSITION_RATIONAL, HorizontalCorrection.POSITION_CURVE};
        }

        static {
            HorizontalCorrection.NONE = new HorizontalCorrection("NONE", 0);
            HorizontalCorrection.POSITION_RATIONAL = new HorizontalCorrection("POSITION_RATIONAL", 1);
            HorizontalCorrection.POSITION_CURVE = new HorizontalCorrection("POSITION_CURVE", 2);
            HorizontalCorrection.$VALUES = HorizontalCorrection.$values();
        }

        private HorizontalCorrection(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static HorizontalCorrection valueOf(String arg1) {
            return Enum.valueOf(HorizontalCorrection.class, arg1);
        }

        public static HorizontalCorrection[] values() {
            return HorizontalCorrection.$VALUES.clone();
        }
    }

    public interface TouchSink {
        int down(int arg1, int arg2);

        void move(int arg1, int arg2, int arg3);

        void up(int arg1, int arg2, int arg3);
    }

    private Bounds bounds;
    private boolean clampToBounds;
    private LongSupplier completionClock;
    private boolean contact;
    private HorizontalCorrection correction;
    private final Delays delays;
    private float densityDpi;
    private boolean enabled;
    private double fractionX;
    private double fractionY;
    private int globalTouchDownDelay;
    private int idleReleaseMillis;
    private boolean invertY;
    private int jitterRange;
    private long lastMotionMillis;
    private long nextPauseCheckMillis;
    private long nextTimerMillis;
    private boolean observedPauseEnabled;
    private int originX;
    private int originY;
    private long pausedUntilMillis;
    private int pointer;
    private final Random random;
    private int releaseFlags;
    private float scaleX;
    private float scaleY;
    private int screenWidth;
    private int sensitivityX;
    private int sensitivityY;
    private final TouchSink sink;
    private int timerPeriodMillis;
    private boolean timerScheduled;
    private int touchDownDelay;
    private int touchUpDelay;
    private int x;
    private int y;

    public FpsCameraKernel(Bounds arg3, int arg4, int arg5, int arg6, float arg7, long arg8, TouchSink arg10, Delays arg11) {
        super();
        this.sensitivityX = 500;
        this.sensitivityY = 500;
        this.scaleX = 1f;
        this.scaleY = 1f;
        this.pointer = -1;
        this.lastMotionMillis = 0xE8D4A50FFFL;
        this.jitterRange = 10;
        this.idleReleaseMillis = 700;
        this.correction = HorizontalCorrection.NONE;
        if(arg6 > 0 && arg7 > 0f) {
            this.bounds = arg3;
            this.originX = arg4;
            this.originY = arg5;
            this.screenWidth = arg6;
            this.densityDpi = arg7;
            this.random = new Random(arg8);
            this.sink = arg10;
            this.delays = arg11;
            return;
        }

        throw new IllegalArgumentException("Display dimensions");
    }

    public void acceptRaw(int arg7, int arg8, long arg9) {
        double v2;
        __monitor_enter(this);
        float v7 = ((float)arg7);
        try {
            double v0 = ((double)(v7 * this.scaleX));
            double v7_2 = ((double)((((float)arg8)) * this.scaleY));
            if(this.correction == HorizontalCorrection.POSITION_CURVE) {
                v2 = FpsCameraKernel.curveGain(((float)this.originX), ((float)this.x), ((float)((((double)this.x)) + v0)), this.densityDpi) * 3;
                goto label_23;
            }
            else if(this.correction == HorizontalCorrection.POSITION_RATIONAL) {
                float v2_1 = (((float)Math.abs(this.originX - this.x))) / (((float)this.screenWidth));
                v2 = ((double)((0.98f / (5.6f * v2_1 * v2_1 + 1f) + 0.02f) * 2f));
            label_23:
                v0 *= v2;
            }

            v2 = this.fractionX + v0;
            this.fractionX = v2;
            this.fractionY += v7_2;
            v0 = 1;
            if(Math.abs(v2) < v0 && Math.abs(this.fractionY) < v0) {
                this.lastMotionMillis = this.observedTime(arg9);
                goto label_63;
            }

            goto label_65;
        }
        catch(Throwable v7_1) {
            goto label_83;
        }

    label_63:
        __monitor_exit(this);
        return;
        try {
        label_65:
            this.moveIntegers(((int)this.fractionX), ((int)this.fractionY), arg9);
            this.fractionX -= ((double)(((int)this.fractionX)));
            this.fractionY -= ((double)(((int)this.fractionY)));
        }
        catch(Throwable v7_1) {
            try {
            label_83:
                __monitor_exit(this);
            }
            catch(Throwable v7_1) {
                goto label_83;
            }

            throw v7_1;
        }

        __monitor_exit(this);
    }

    private boolean allowsIntegerMovement(long arg5) {
        if(this.observedPauseEnabled) {
            if(this.observedTime(arg5) > this.nextPauseCheckMillis) {
                this.nextPauseCheckMillis = this.observedTime(arg5) + (((long)((this.random.nextInt(300) + 200) * 1000)));
                this.pausedUntilMillis = this.observedTime(arg5) + (((long)((this.random.nextInt(6) + 6) * 1000)));
            }

            if(this.observedTime(arg5) >= this.pausedUntilMillis) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    private void beginContact() {
        int v0 = Math.max(this.globalTouchDownDelay, this.touchDownDelay);
        if(v0 > 0) {
            this.delays.sleepMillis(v0);
        }

        this.x = this.bounds.clipX(this.originX + this.jitter());
        v0 = this.bounds.clipY(this.originY + this.jitter());
        this.y = v0;
        this.pointer = this.sink.down(this.x, v0);
        this.contact = true;
    }

    public static double curveGain(float arg2, float arg3, float arg4, float arg5) {
        if(arg3 == arg4) {
            return 1;
        }

        arg3 = arg4 - arg3;
        return ((double)Math.abs(arg3 * 0.1f / ((Math.abs(326f / arg5 * (arg4 - arg2 - arg3 / 2f) / 300f) * 3f + 1f) * (Math.min(Math.max(arg3 / 300f, -1f), 1f) * 28f * 3f) * 0.2f * 1f / 0.6f)));
    }

    private void endContact() {
        this.sink.up(this.pointer, this.x, this.y);
        this.contact = false;
    }

    public boolean hasContact() {
        boolean v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.contact;
        }
        catch(Throwable v0) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_5;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    private int jitter() {
        int v0 = this.jitterRange;
        if(v0 == 0) {
            return 0;
        }

        int v1 = -v0;
        v0 -= v1;
        if(v0 <= 1) {
            return v1;
        }

        return v1 + 1 + (((int)(this.random.nextDouble() * (((double)(v0 - 1))))));
    }

    public void moveIntegers(int arg3, int arg4, long arg5) {
        __monitor_enter(this);
        try {
            if(this.allowsIntegerMovement(arg5)) {
                goto label_5;
            }
        }
        catch(Throwable v3) {
            goto label_58;
        }

        __monitor_exit(this);
        return;
        try {
        label_5:
            if(this.enabled) {
                goto label_9;
            }
        }
        catch(Throwable v3) {
            goto label_58;
        }

        __monitor_exit(this);
        return;
        try {
        label_9:
            if(this.contact) {
                goto label_16;
            }

            this.beginContact();
            this.lastMotionMillis = this.observedTime(arg5);
        }
        catch(Throwable v3) {
            goto label_58;
        }

        __monitor_exit(this);
        return;
        try {
        label_16:
            if(this.invertY) {
                arg4 = -arg4;
            }

            int v0 = this.x + arg3;
            this.x = v0;
            arg3 = this.y + arg4;
            this.y = arg3;
            if(this.clampToBounds) {
                this.x = this.bounds.clipX(v0);
                this.y = this.bounds.clipY(this.y);
            }
            else if((this.releaseFlags & 2) != 0 && !this.bounds.contains(v0, arg3)) {
                arg3 = this.touchUpDelay;
                if(arg3 > 0) {
                    this.delays.sleepMillis(arg3);
                }

                this.endContact();
                goto label_46;
            }

            goto label_48;
        }
        catch(Throwable v3) {
            goto label_58;
        }

    label_46:
        __monitor_exit(this);
        return;
        try {
        label_48:
            this.sink.move(this.pointer, this.x, this.y);
            this.lastMotionMillis = this.observedTime(arg5);
        }
        catch(Throwable v3) {
            try {
            label_58:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_58;
            }

            throw v3;
        }

        __monitor_exit(this);
    }

    public long nextPauseCheckMillis() {
        long v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.nextPauseCheckMillis;
        }
        catch(Throwable v0) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_5;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public long nextTimerMillis() {
        long v0_1;
        __monitor_enter(this);
        try {
            if(this.timerScheduled) {
                v0_1 = this.nextTimerMillis;
            }
            else {
                goto label_5;
            }

            goto label_6;
        }
        catch(Throwable v0) {
            try {
            label_9:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_9;
            }

            throw v0;
        }

    label_5:
        v0_1 = 0x7FFFFFFFFFFFFFFFL;
    label_6:
        __monitor_exit(this);
        return v0_1;
    }

    public void observeAvailabilityCheck(boolean arg2, String arg3, long arg4) {
        __monitor_enter(this);
        if(arg2) {
            __monitor_exit(this);
            return;
        }

        try {
            String v2_1 = arg3.toLowerCase();
            if(v2_1.charAt(v2_1.length() - 1) > 110) {
                this.observedPauseEnabled = true;
                this.nextPauseCheckMillis = this.observedTime(arg4) + (((long)((this.random.nextInt(300) + 500) * 1000)));
            }
        }
        catch(Throwable v2) {
            try {
            label_24:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_24;
            }

            throw v2;
        }

        __monitor_exit(this);
    }

    private long observedTime(long arg1) {
        LongSupplier v0 = this.completionClock;
        if(v0 == null) {
            return arg1;
        }

        return v0.getAsLong();
    }

    public long pausedUntilMillis() {
        long v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.pausedUntilMillis;
        }
        catch(Throwable v0) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_5;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public double remainderX() {
        double v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.fractionX;
        }
        catch(Throwable v0) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_5;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public double remainderY() {
        double v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.fractionY;
        }
        catch(Throwable v0) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_5;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public int sensitivityX() {
        int v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.sensitivityX;
        }
        catch(Throwable v0) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_5;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public int sensitivityY() {
        int v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.sensitivityY;
        }
        catch(Throwable v0) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_5;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public void setCompletionClock(LongSupplier arg1) {
        __monitor_enter(this);
        try {
            this.completionClock = arg1;
        }
        catch(Throwable v1) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v1) {
                goto label_5;
            }

            throw v1;
        }

        __monitor_exit(this);
    }

    public void setCorrection(HorizontalCorrection arg1) {
        __monitor_enter(this);
        try {
            this.correction = arg1;
        }
        catch(Throwable v1) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v1) {
                goto label_5;
            }

            throw v1;
        }

        __monitor_exit(this);
    }

    public void setGesturePolicy(boolean arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        __monitor_enter(this);
        try {
            this.clampToBounds = arg1;
            this.releaseFlags = arg2;
            this.idleReleaseMillis = arg3;
            this.touchDownDelay = arg4;
            this.touchUpDelay = arg5;
            this.globalTouchDownDelay = arg6;
        }
        catch(Throwable v1) {
            try {
            label_10:
                __monitor_exit(this);
            }
            catch(Throwable v1) {
                goto label_10;
            }

            throw v1;
        }

        __monitor_exit(this);
    }

    public void setInvertY(boolean arg1) {
        __monitor_enter(this);
        try {
            this.invertY = arg1;
        }
        catch(Throwable v1) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v1) {
                goto label_5;
            }

            throw v1;
        }

        __monitor_exit(this);
    }

    public void setJitterRange(int arg2) {
        __monitor_enter(this);
        if(arg2 >= 0) {
            try {
                this.jitterRange = arg2;
            }
            catch(Throwable v2) {
                goto label_6;
            }

            __monitor_exit(this);
            return;
        }

        try {
            throw new IllegalArgumentException("Negative jitter");
        }
        catch(Throwable v2) {
        label_6:
            try {
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_6;
            }

            throw v2;
        }
    }

    public void setSensitivity(int arg2, int arg3) {
        __monitor_enter(this);
        try {
            this.sensitivityX = arg2;
            this.sensitivityY = arg3;
            this.scaleX = (((float)arg2)) / 500f;
            this.scaleY = (((float)arg3)) / 500f;
        }
        catch(Throwable v2) {
            try {
            label_13:
                __monitor_exit(this);
            }
            catch(Throwable v2) {
                goto label_13;
            }

            throw v2;
        }

        __monitor_exit(this);
    }

    public void start(long arg4) {
        __monitor_enter(this);
        try {
            this.enabled = true;
            if(!this.clampToBounds && (this.releaseFlags & 1) != 0 && !this.timerScheduled) {
                int v1 = Math.max(this.idleReleaseMillis, 10);
                this.idleReleaseMillis = v1;
                this.timerScheduled = true;
                this.timerPeriodMillis = v1 / 2;
                this.nextTimerMillis = arg4;
            }
        }
        catch(Throwable v4) {
            try {
            label_21:
                __monitor_exit(this);
            }
            catch(Throwable v4) {
                goto label_21;
            }

            throw v4;
        }

        __monitor_exit(this);
    }

    public void stop() {
        __monitor_enter(this);
        try {
            this.enabled = false;
            this.timerScheduled = false;
            if(this.contact) {
                this.endContact();
            }
        }
        catch(Throwable v0) {
            try {
            label_10:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_10;
            }

            throw v0;
        }

        __monitor_exit(this);
    }

    public void tick(long arg8) {
        long v0;
        __monitor_enter(this);
        try {
            if(this.timerScheduled) {
                goto label_5;
            }
        }
        catch(Throwable v8) {
            goto label_30;
        }

        __monitor_exit(this);
        return;
        try {
        label_5:
            v0 = this.nextTimerMillis;
            if(arg8 >= v0) {
                goto label_9;
            }
        }
        catch(Throwable v8) {
            goto label_30;
        }

        __monitor_exit(this);
        return;
    label_9:
        long v2 = arg8 - v0;
        try {
            this.nextTimerMillis = v0 + (v2 / (((long)this.timerPeriodMillis)) + 1) * (((long)this.timerPeriodMillis));
            if((this.contact) && arg8 - this.lastMotionMillis >= (((long)this.idleReleaseMillis))) {
                this.endContact();
            }
        }
        catch(Throwable v8) {
            try {
            label_30:
                __monitor_exit(this);
            }
            catch(Throwable v8) {
                goto label_30;
            }

            throw v8;
        }

        __monitor_exit(this);
    }

    public int x() {
        int v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.x;
        }
        catch(Throwable v0) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_5;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }

    public int y() {
        int v0_1;
        __monitor_enter(this);
        try {
            v0_1 = this.y;
        }
        catch(Throwable v0) {
            try {
            label_5:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_5;
            }

            throw v0;
        }

        __monitor_exit(this);
        return v0_1;
    }
}

