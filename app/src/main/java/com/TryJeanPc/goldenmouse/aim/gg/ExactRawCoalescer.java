package com.TryJeanPc.goldenmouse.aim.gg;

import java.util.LinkedList;
import java.util.function.Consumer;

public final class ExactRawCoalescer {
    public enum Mode {
        public static final enum Mode NO_LIMIT;
        public static final enum Mode RATE_125HZ;
        public static final enum Mode RATE_250HZ;
        public static final enum Mode RATE_500HZ;
        public final long intervalNanos;

        private static Mode[] $values() {
            return new Mode[]{Mode.RATE_125HZ, Mode.RATE_250HZ, Mode.RATE_500HZ, Mode.NO_LIMIT};
        }

        static {
            Mode.RATE_125HZ = new Mode("RATE_125HZ", 0, 8000000);
            Mode.RATE_250HZ = new Mode("RATE_250HZ", 1, 4000000);
            Mode.RATE_500HZ = new Mode("RATE_500HZ", 2, 2000000);
            Mode.NO_LIMIT = new Mode("NO_LIMIT", 3, -1);
            Mode.$VALUES = Mode.$values();
        }

        private Mode(String arg1, int arg2, long arg3) {
            super(arg1, arg2);
            this.intervalNanos = arg3;
        }

        public static Mode valueOf(String arg1) {
            return Enum.valueOf(Mode.class, arg1);
        }

        public static Mode[] values() {
            return Mode.$VALUES.clone();
        }
    }

    public final class Motion {
        public int x;
        public int y;

        public Motion(int arg1, int arg2) {
            super();
            this.x = arg1;
            this.y = arg2;
        }

        public Motion copy() {
            return new Motion(this.x, this.y);
        }

        public String toString() {
            return this.x + "," + this.y;
        }
    }

    public long intervalNanos;
    public long lastDispatchNanos;
    public int pendingX;
    public int pendingY;

    public ExactRawCoalescer() {
        super();
        this.lastDispatchNanos = -1;
        this.intervalNanos = -1;
        this.configure(Mode.RATE_125HZ);
    }

    public ExactRawCoalescer(int arg3) {
        super();
        this.lastDispatchNanos = -1;
        this.intervalNanos = -1;
        this.configure(Mode.values()[arg3]);
    }

    public void accept(int arg3, int arg4, long arg5, Consumer arg7) {
        LinkedList v0 = new LinkedList();
        v0.add(new Motion(arg3, arg4));
        this.accept(v0, arg5, arg7);
    }

    public void accept(LinkedList arg7, long arg8, Consumer arg10) {
        __monitor_enter(this);
        try {
            if(this.intervalNanos == -1) {
                arg10.accept(arg7);
                __monitor_exit(this);
                return;
            }

            Object v1 = arg7.get(0);
            this.pendingX += ((Motion)v1).x;
            this.pendingY += ((Motion)v1).y;
            if(arg8 - this.lastDispatchNanos >= this.intervalNanos) {
                ((Motion)v1).x = this.pendingX;
                ((Motion)v1).y = this.pendingY;
                arg10.accept(arg7);
                this.pendingX = 0;
                this.pendingY = 0;
                this.lastDispatchNanos = arg8;
            }

            __monitor_exit(this);
            return;
        label_32:
            __monitor_exit(this);
        }
        catch(Throwable v7) {
            goto label_32;
        }

        throw v7;
    }

    public void configure(Mode arg3) {
        __monitor_enter(this);
        try {
            this.setInterval(arg3.intervalNanos);
        }
        catch(Throwable v3) {
            try {
            label_6:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_6;
            }

            throw v3;
        }

        __monitor_exit(this);
    }

    public void discardPending() {
        __monitor_enter(this);
        try {
            this.pendingX = 0;
            this.pendingY = 0;
        }
        catch(Throwable v0) {
            try {
            label_7:
                __monitor_exit(this);
            }
            catch(Throwable v0) {
                goto label_7;
            }

            throw v0;
        }

        __monitor_exit(this);
    }

    public void setInterval(long arg1) {
        __monitor_enter(this);
        try {
            this.intervalNanos = arg1;
            this.pendingX = 0;
            this.pendingY = 0;
        }
        catch(Throwable v1) {
            try {
            label_8:
                __monitor_exit(this);
            }
            catch(Throwable v1) {
                goto label_8;
            }

            throw v1;
        }

        __monitor_exit(this);
    }
}

