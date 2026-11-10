package com.TryJeanPc.goldenmouse.engine;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001\u001FB7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\u0007\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000BJP\u0010\u0012\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00062\u0018\u0010\u001A\u001A\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u001BJ\u000E\u0010\u001C\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u000EJ\u0006\u0010\u001D\u001A\u00020\tJ\b\u0010\u001E\u001A\u00020\tH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"Lcom/TryJeanPc/goldenmouse/engine/JoystickMotionSmoother;", "", "scheduler", "Lcom/TryJeanPc/goldenmouse/engine/ActionScheduler;", "nanoTime", "Lkotlin/Function0;", "", "runLocked", "Lkotlin/Function1;", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/engine/ActionScheduler;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "motions", "", "", "Lcom/TryJeanPc/goldenmouse/engine/JoystickMotionSmoother$Motion;", "tickScheduled", "", "move", "id", "fromX", "", "fromY", "toX", "toY", "durationMs", "emit", "Lkotlin/Function2;", "stop", "clear", "scheduleTick", "Motion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class JoystickMotionSmoother {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0018\u0010\n\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\u0004\b\r\u0010\u000EJ\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001D\u001A\u00020\bHÆ\u0003J\t\u0010\u001E\u001A\u00020\bHÆ\u0003J\u001B\u0010\u001F\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000BHÆ\u0003Ja\u0010 \u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\u001A\b\u0002\u0010\n\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000BHÆ\u0001J\u0013\u0010!\u001A\u00020\f2\b\u0010\"\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001A\u00020$HÖ\u0001J\t\u0010%\u001A\u00020&HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0015R#\u0010\n\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018¨\u0006\'"}, d2={"Lcom/TryJeanPc/goldenmouse/engine/JoystickMotionSmoother$Motion;", "", "startX", "", "startY", "targetX", "targetY", "startNanos", "", "durationNanos", "emit", "Lkotlin/Function2;", "", "<init>", "(FFFFJJLkotlin/jvm/functions/Function2;)V", "getStartX", "()F", "getStartY", "getTargetX", "getTargetY", "getStartNanos", "()J", "getDurationNanos", "getEmit", "()Lkotlin/jvm/functions/Function2;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Motion {
        private final long durationNanos;
        private final Function2 emit;
        private final long startNanos;
        private final float startX;
        private final float startY;
        private final float targetX;
        private final float targetY;

        public Motion(float arg2, float arg3, float arg4, float arg5, long arg6, long arg8, Function2 arg10) {
            Intrinsics.checkNotNullParameter(arg10, "emit");
            super();
            this.startX = arg2;
            this.startY = arg3;
            this.targetX = arg4;
            this.targetY = arg5;
            this.startNanos = arg6;
            this.durationNanos = arg8;
            this.emit = arg10;
        }

        public final float component1() {
            return this.startX;
        }

        public final float component2() {
            return this.startY;
        }

        public final float component3() {
            return this.targetX;
        }

        public final float component4() {
            return this.targetY;
        }

        public final long component5() {
            return this.startNanos;
        }

        public final long component6() {
            return this.durationNanos;
        }

        public final Function2 component7() {
            return this.emit;
        }

        public final Motion copy(float arg11, float arg12, float arg13, float arg14, long arg15, long arg17, Function2 arg19) {
            Intrinsics.checkNotNullParameter(arg19, "emit");
            return new Motion(arg11, arg12, arg13, arg14, arg15, arg17, arg19);
        }

        public static Motion copy$default(Motion arg0, float arg1, float arg2, float arg3, float arg4, long arg5, long arg7, Function2 arg9, int arg10, Object arg11) {
            if((arg10 & 1) != 0) {
                arg1 = arg0.startX;
            }

            if((arg10 & 2) != 0) {
                arg2 = arg0.startY;
            }

            if((arg10 & 4) != 0) {
                arg3 = arg0.targetX;
            }

            if((arg10 & 8) != 0) {
                arg4 = arg0.targetY;
            }

            if((arg10 & 16) != 0) {
                arg5 = arg0.startNanos;
            }

            if((arg10 & 0x20) != 0) {
                arg7 = arg0.durationNanos;
            }

            if((arg10 & 0x40) != 0) {
                arg9 = arg0.emit;
            }

            return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg7, arg9);
        }

        public boolean equals(Object arg8) {
            if(this == (((Motion)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Motion)) {
                return 0;
            }

            if(Float.compare(this.startX, ((Motion)arg8).startX) != 0) {
                return 0;
            }

            if(Float.compare(this.startY, ((Motion)arg8).startY) != 0) {
                return 0;
            }

            if(Float.compare(this.targetX, ((Motion)arg8).targetX) != 0) {
                return 0;
            }

            if(Float.compare(this.targetY, ((Motion)arg8).targetY) != 0) {
                return 0;
            }

            if(this.startNanos != ((Motion)arg8).startNanos) {
                return 0;
            }

            if(this.durationNanos != ((Motion)arg8).durationNanos) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.emit, ((Motion)arg8).emit)) {
                return 0;
            }

            return 1;
        }

        public final long getDurationNanos() {
            return this.durationNanos;
        }

        public final Function2 getEmit() {
            return this.emit;
        }

        public final long getStartNanos() {
            return this.startNanos;
        }

        public final float getStartX() {
            return this.startX;
        }

        public final float getStartY() {
            return this.startY;
        }

        public final float getTargetX() {
            return this.targetX;
        }

        public final float getTargetY() {
            return this.targetY;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.startX) * 0x1F + Float.hashCode(this.startY)) * 0x1F + Float.hashCode(this.targetX)) * 0x1F + Float.hashCode(this.targetY)) * 0x1F + Long.hashCode(this.startNanos)) * 0x1F + Long.hashCode(this.durationNanos)) * 0x1F + this.emit.hashCode();
        }

        public String toString() {
            return "Motion(startX=" + this.startX + ", startY=" + this.startY + ", targetX=" + this.targetX + ", targetY=" + this.targetY + ", startNanos=" + this.startNanos + ", durationNanos=" + this.durationNanos + ", emit=" + this.emit + ")";
        }
    }

    public static final int $stable = 8;
    private final Map motions;
    private final Function0 nanoTime;
    private final Function1 runLocked;
    private final ActionScheduler scheduler;
    private boolean tickScheduled;

    static {
    }

    public JoystickMotionSmoother(ActionScheduler arg2, Function0 arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "scheduler");
        Intrinsics.checkNotNullParameter(arg3, "nanoTime");
        Intrinsics.checkNotNullParameter(arg4, "runLocked");
        super();
        this.scheduler = arg2;
        this.nanoTime = arg3;
        this.runLocked = arg4;
        this.motions = new LinkedHashMap();
    }

    public final void clear() {
        this.motions.clear();
    }

    public final void move(String arg12, float arg13, float arg14, float arg15, float arg16, long arg17, Function2 arg19) {
        Function2 v9 = arg19;
        Intrinsics.checkNotNullParameter(arg12, "id");
        Intrinsics.checkNotNullParameter(v9, "emit");
        this.motions.remove(arg12);
        if(arg17 == 0) {
            v9.invoke(Float.valueOf(arg15), Float.valueOf(arg16));
            return;
        }

        if(arg13 == arg15 && arg14 == arg16) {
            return;
        }

        this.motions.put(arg12, new Motion(arg13, arg14, arg15, arg16, this.nanoTime.invoke().longValue(), arg17 * 1000000, v9));
        this.scheduleTick();
    }

    private final void scheduleTick() {
        long v11;
        JoystickMotionSmoother v0 = this;
        if(!v0.tickScheduled) {
            if(v0.motions.isEmpty()) {
            }
            else {
                v0.tickScheduled = true;
                long v1 = v0.nanoTime.invoke().longValue();
                Iterator v3 = v0.motions.values().iterator();
                if(v3.hasNext()) {
                    Object v4 = v3.next();
                    long v7 = 0xF423F;
                    long v9 = 1000000;
                    long v5 = (((Motion)v4).getDurationNanos() - (v1 - ((Motion)v4).getStartNanos()) + v7) / v9;
                    while(true) {
                        v11 = v5;
                        do {
                            if(v3.hasNext()) {
                                v4 = v3.next();
                                v5 = (((Motion)v4).getDurationNanos() - (v1 - ((Motion)v4).getStartNanos()) + v7) / v9;
                                if(v11 <= v5) {
                                    continue;
                                }

                                break;
                            }
                            else {
                                break;
                            }
                        }
                        while(true);
                    }

                    v0.scheduler.schedule(RangesKt.coerceIn(v11, 1, 8), new JoystickMotionSmoother$$ExternalSyntheticLambda0(v0));
                    return;
                }
                else {
                    throw new NoSuchElementException();
                }
            }
        }
    }

    static final Unit scheduleTick$lambda$3(JoystickMotionSmoother arg2) {
        arg2.runLocked.invoke(new JoystickMotionSmoother$$ExternalSyntheticLambda1(arg2));
        return Unit.INSTANCE;
    }

    static final Unit scheduleTick$lambda$3$lambda$2(JoystickMotionSmoother arg15) {
        arg15.tickScheduled = false;
        long v0 = arg15.nanoTime.invoke().longValue();
        Iterator v2 = MapsKt.toMap(arg15.motions).entrySet().iterator();
        while(v2.hasNext()) {
            Object v3 = v2.next();
            Object v4 = ((Map$Entry)v3).getKey();
            v3 = ((Map$Entry)v3).getValue();
            if(arg15.motions.get(v4) != v3) {
                continue;
            }

            float v5 = ((float)RangesKt.coerceIn((((double)(v0 - ((Motion)v3).getStartNanos()))) / (((double)((Motion)v3).getDurationNanos())), 0, 1));
            boolean v6 = ((Motion)v3).getEmit().invoke(Float.valueOf(((Motion)v3).getStartX() + (((Motion)v3).getTargetX() - ((Motion)v3).getStartX()) * v5), Float.valueOf(((Motion)v3).getStartY() + (((Motion)v3).getTargetY() - ((Motion)v3).getStartY()) * v5)).booleanValue();
            if(arg15.motions.get(v4) != v3) {
                continue;
            }

            if((v6) && v5 != 1f) {
                continue;
            }

            arg15.motions.remove(v4);
        }

        arg15.scheduleTick();
        return Unit.INSTANCE;
    }

    public final void stop(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "id");
        this.motions.remove(arg2);
    }
}

