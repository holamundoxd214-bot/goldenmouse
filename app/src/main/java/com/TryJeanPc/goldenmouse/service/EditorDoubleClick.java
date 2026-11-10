package com.TryJeanPc.goldenmouse.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0018B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u000E\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000BJ\u0016\u0010\u0011\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u0005J\u000E\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0003J\u0006\u0010\u0017\u001A\u00020\u000FR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/service/EditorDoubleClick;", "", "timeout", "", "touchSlop", "", "doubleTapSlop", "longPressTimeout", "<init>", "(JFFJ)V", "first", "Lcom/TryJeanPc/goldenmouse/service/EditorDoubleClick$Press;", "firstUp", "current", "down", "", "press", "move", "x", "y", "up", "", "time", "reset", "Press", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class EditorDoubleClick {
    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000EJ\t\u0010\u001B\u001A\u00020\u0001HÆ\u0003J\u000B\u0010\u001C\u001A\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001D\u001A\u00020\u0006HÆ\u0003J\t\u0010\u001E\u001A\u00020\bHÆ\u0003J\t\u0010\u001F\u001A\u00020\bHÆ\u0003J\t\u0010 \u001A\u00020\u000BHÆ\u0003J\t\u0010!\u001A\u00020\u000BHÆ\u0003JQ\u0010\"\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u000BHÆ\u0001J\u0013\u0010#\u001A\u00020$2\b\u0010%\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001A\u00020\u000BHÖ\u0001J\t\u0010\'\u001A\u00020\u0004HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0003\u001A\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0019¨\u0006("}, d2={"Lcom/TryJeanPc/goldenmouse/service/EditorDoubleClick$Press;", "", "owner", "profile", "", "time", "", "x", "", "y", "source", "", "device", "<init>", "(Ljava/lang/Object;Ljava/lang/String;JFFII)V", "getOwner", "()Ljava/lang/Object;", "getProfile", "()Ljava/lang/String;", "getTime", "()J", "getX", "()F", "getY", "getSource", "()I", "getDevice", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Press {
        public static final int $stable = 8;
        private final int device;
        private final Object owner;
        private final String profile;
        private final int source;
        private final long time;
        private final float x;
        private final float y;

        static {
        }

        public Press(Object arg2, String arg3, long arg4, float arg6, float arg7, int arg8, int arg9) {
            Intrinsics.checkNotNullParameter(arg2, "owner");
            super();
            this.owner = arg2;
            this.profile = arg3;
            this.time = arg4;
            this.x = arg6;
            this.y = arg7;
            this.source = arg8;
            this.device = arg9;
        }

        public final Object component1() {
            return this.owner;
        }

        public final String component2() {
            return this.profile;
        }

        public final long component3() {
            return this.time;
        }

        public final float component4() {
            return this.x;
        }

        public final float component5() {
            return this.y;
        }

        public final int component6() {
            return this.source;
        }

        public final int component7() {
            return this.device;
        }

        public final Press copy(Object arg10, String arg11, long arg12, float arg14, float arg15, int arg16, int arg17) {
            Intrinsics.checkNotNullParameter(arg10, "owner");
            return new Press(arg10, arg11, arg12, arg14, arg15, arg16, arg17);
        }

        public static Press copy$default(Press arg0, Object arg1, String arg2, long arg3, float arg5, float arg6, int arg7, int arg8, int arg9, Object arg10) {
            if((arg9 & 1) != 0) {
                arg1 = arg0.owner;
            }

            if((arg9 & 2) != 0) {
                arg2 = arg0.profile;
            }

            if((arg9 & 4) != 0) {
                arg3 = arg0.time;
            }

            if((arg9 & 8) != 0) {
                arg5 = arg0.x;
            }

            if((arg9 & 16) != 0) {
                arg6 = arg0.y;
            }

            if((arg9 & 0x20) != 0) {
                arg7 = arg0.source;
            }

            if((arg9 & 0x40) != 0) {
                arg8 = arg0.device;
            }

            return arg0.copy(arg1, arg2, arg3, arg5, arg6, arg7, arg8);
        }

        public boolean equals(Object arg8) {
            if(this == (((Press)arg8))) {
                return 1;
            }

            if(!(arg8 instanceof Press)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.owner, ((Press)arg8).owner)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.profile, ((Press)arg8).profile)) {
                return 0;
            }

            if(this.time != ((Press)arg8).time) {
                return 0;
            }

            if(Float.compare(this.x, ((Press)arg8).x) != 0) {
                return 0;
            }

            if(Float.compare(this.y, ((Press)arg8).y) != 0) {
                return 0;
            }

            if(this.source != ((Press)arg8).source) {
                return 0;
            }

            if(this.device != ((Press)arg8).device) {
                return 0;
            }

            return 1;
        }

        public final int getDevice() {
            return this.device;
        }

        public final Object getOwner() {
            return this.owner;
        }

        public final String getProfile() {
            return this.profile;
        }

        public final int getSource() {
            return this.source;
        }

        public final long getTime() {
            return this.time;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public int hashCode() {
            int v0 = this.owner.hashCode() * 0x1F;
            String v1 = this.profile;
            int v1_1 = v1 == null ? 0 : v1.hashCode();
            return (((((v0 + v1_1) * 0x1F + Long.hashCode(this.time)) * 0x1F + Float.hashCode(this.x)) * 0x1F + Float.hashCode(this.y)) * 0x1F + Integer.hashCode(this.source)) * 0x1F + Integer.hashCode(this.device);
        }

        public String toString() {
            return "Press(owner=" + this.owner + ", profile=" + this.profile + ", time=" + this.time + ", x=" + this.x + ", y=" + this.y + ", source=" + this.source + ", device=" + this.device + ")";
        }
    }

    public static final int $stable = 8;
    private Press current;
    private final float doubleTapSlop;
    private Press first;
    private long firstUp;
    private final long longPressTimeout;
    private final long timeout;
    private final float touchSlop;

    static {
    }

    public EditorDoubleClick(long arg1, float arg3, float arg4, long arg5) {
        super();
        this.timeout = arg1;
        this.touchSlop = arg3;
        this.doubleTapSlop = arg4;
        this.longPressTimeout = arg5;
    }

    public final void down(Press arg2) {
        Intrinsics.checkNotNullParameter(arg2, "press");
        if(this.current != null) {
            this.reset();
        }

        this.current = arg2;
    }

    public final void move(float arg3, float arg4) {
        Press v0 = this.current;
        if(v0 == null) {
        }
        else {
            if(Math.abs(arg3 - v0.getX()) <= this.touchSlop) {
                if(Math.abs(arg4 - v0.getY()) > this.touchSlop) {
                }
                else {
                    return;
                }
            }

            goto label_15;
        }

        return;
    label_15:
        this.reset();
    }

    public final void reset() {
        this.first = null;
        this.current = null;
        this.firstUp = 0;
    }

    public final boolean up(long arg14) {
        Press v0 = this.current;
        boolean v1 = false;
        if(v0 == null) {
            return 0;
        }

        Press v2 = null;
        this.current = v2;
        long v3 = this.longPressTimeout;
        long v5 = arg14 - v0.getTime();
        long v7 = 0;
        if(v7 <= v5 && v5 < v3) {
            Press v3_1 = this.first;
            if(v3_1 != null && v3_1.getOwner() == v0.getOwner() && (Intrinsics.areEqual(v3_1.getProfile(), v0.getProfile())) && v3_1.getSource() == v0.getSource() && v3_1.getDevice() == v0.getDevice()) {
                long v4 = this.timeout;
                long v9 = v0.getTime() - this.firstUp;
                if(v7 <= v9 && v9 <= v4 && (((float)Math.hypot(((double)(v0.getX() - v3_1.getX())), ((double)(v0.getY() - v3_1.getY()))))) <= this.doubleTapSlop) {
                    v1 = true;
                }
            }

            if(v1) {
                v0 = v2;
            }

            this.first = v0;
            if(v1) {
                arg14 = v7;
            }

            this.firstUp = arg14;
            return v1;
        }

        this.reset();
        return 0;
    }
}

