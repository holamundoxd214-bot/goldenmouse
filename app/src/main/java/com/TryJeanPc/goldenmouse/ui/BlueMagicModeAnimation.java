package com.TryJeanPc.goldenmouse.ui;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0005J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0002J\u0015\u0010\r\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u000BH\u0000¢\u0006\u0002\b\u000FR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/BlueMagicModeAnimation;", "", "<init>", "()V", "DURATION_MS", "", "COLOR_DURATION_MS", "frameAt", "Lcom/TryJeanPc/goldenmouse/ui/BlueMagicModeAnimation$Frame;", "elapsedMs", "smoothStep", "", "fraction", "easeOut", "t", "easeOut$app", "Frame", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class BlueMagicModeAnimation {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J;\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001A\u00020\u00072\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\f¨\u0006\u001E"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/BlueMagicModeAnimation$Frame;", "", "opening", "", "labelAlpha", "labelOffset", "showNewLabel", "", "scanProgress", "<init>", "(FFFZF)V", "getOpening", "()F", "getLabelAlpha", "getLabelOffset", "getShowNewLabel", "()Z", "getScanProgress", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Frame {
        public static final int $stable;
        private final float labelAlpha;
        private final float labelOffset;
        private final float opening;
        private final float scanProgress;
        private final boolean showNewLabel;

        static {
        }

        public Frame(float arg1, float arg2, float arg3, boolean arg4, float arg5) {
            super();
            this.opening = arg1;
            this.labelAlpha = arg2;
            this.labelOffset = arg3;
            this.showNewLabel = arg4;
            this.scanProgress = arg5;
        }

        public final float component1() {
            return this.opening;
        }

        public final float component2() {
            return this.labelAlpha;
        }

        public final float component3() {
            return this.labelOffset;
        }

        public final boolean component4() {
            return this.showNewLabel;
        }

        public final float component5() {
            return this.scanProgress;
        }

        public final Frame copy(float arg1, float arg2, float arg3, boolean arg4, float arg5) {
            return new Frame(arg1, arg2, arg3, arg4, arg5);
        }

        public static Frame copy$default(Frame arg0, float arg1, float arg2, float arg3, boolean arg4, float arg5, int arg6, Object arg7) {
            if((arg6 & 1) != 0) {
                arg1 = arg0.opening;
            }

            if((arg6 & 2) != 0) {
                arg2 = arg0.labelAlpha;
            }

            if((arg6 & 4) != 0) {
                arg3 = arg0.labelOffset;
            }

            if((arg6 & 8) != 0) {
                arg4 = arg0.showNewLabel;
            }

            if((arg6 & 16) != 0) {
                arg5 = arg0.scanProgress;
            }

            return arg0.copy(arg1, arg2, arg3, arg4, arg5);
        }

        public boolean equals(Object arg5) {
            if(this == (((Frame)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Frame)) {
                return 0;
            }

            if(Float.compare(this.opening, ((Frame)arg5).opening) != 0) {
                return 0;
            }

            if(Float.compare(this.labelAlpha, ((Frame)arg5).labelAlpha) != 0) {
                return 0;
            }

            if(Float.compare(this.labelOffset, ((Frame)arg5).labelOffset) != 0) {
                return 0;
            }

            if(this.showNewLabel != ((Frame)arg5).showNewLabel) {
                return 0;
            }

            if(Float.compare(this.scanProgress, ((Frame)arg5).scanProgress) != 0) {
                return 0;
            }

            return 1;
        }

        public final float getLabelAlpha() {
            return this.labelAlpha;
        }

        public final float getLabelOffset() {
            return this.labelOffset;
        }

        public final float getOpening() {
            return this.opening;
        }

        public final float getScanProgress() {
            return this.scanProgress;
        }

        public final boolean getShowNewLabel() {
            return this.showNewLabel;
        }

        public int hashCode() {
            return (((Float.hashCode(this.opening) * 0x1F + Float.hashCode(this.labelAlpha)) * 0x1F + Float.hashCode(this.labelOffset)) * 0x1F + Boolean.hashCode(this.showNewLabel)) * 0x1F + Float.hashCode(this.scanProgress);
        }

        public String toString() {
            return "Frame(opening=" + this.opening + ", labelAlpha=" + this.labelAlpha + ", labelOffset=" + this.labelOffset + ", showNewLabel=" + this.showNewLabel + ", scanProgress=" + this.scanProgress + ")";
        }
    }

    public static final int $stable = 0;
    public static final long COLOR_DURATION_MS = 1500;
    public static final long DURATION_MS = 900;
    public static final BlueMagicModeAnimation INSTANCE;

    static {
        BlueMagicModeAnimation.INSTANCE = new BlueMagicModeAnimation();
    }

    private BlueMagicModeAnimation() {
        super();
    }

    public final float easeOut$app(float arg2) {
        arg2 = 1f - arg2;
        return 1f - arg2 * arg2 * arg2;
    }

    public final Frame frameAt(long arg9) {
        float v3;
        float v0;
        arg9 = RangesKt.coerceIn(arg9, 0, 900);
        float v1 = 1f;
        if(Long.compare(arg9, 300) < 0) {
            v0 = this.smoothStep((((float)arg9)) / 300f);
            goto label_12;
        }
        else {
            long v2 = 420;
            if(arg9 < v2) {
                v3 = v1;
            }
            else {
                v0 = v1 - this.smoothStep((((float)(arg9 - v2))) / 480f);
            label_12:
                v3 = v0;
            }
        }

        long v4 = 220;
        boolean v0_1 = arg9 >= v4 ? true : false;
        boolean v6 = v0_1;
        float v8 = v6 ? this.smoothStep((((float)(arg9 - v4))) / 260f) : v1 - this.smoothStep((((float)arg9)) / 220f);
        float v4_1 = v8;
        v8 = v6 ? 0.28f : -0.28f;
        return new Frame(v3, v4_1, v8 * (v1 - v4_1), v6, (((float)arg9)) / 900f);
    }

    private final float smoothStep(float arg2) {
        float v1 = RangesKt.coerceIn(arg2, 0f, 1f);
        return v1 * v1 * (3f - v1 * 2f);
    }
}

