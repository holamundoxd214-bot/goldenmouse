package androidx.compose.material3.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2={"Landroidx/compose/material3/internal/BackEventProgress;", "", "NotRunning", "InProgress", "Completed", "Landroidx/compose/material3/internal/BackEventProgress$Completed;", "Landroidx/compose/material3/internal/BackEventProgress$InProgress;", "Landroidx/compose/material3/internal/BackEventProgress$NotRunning;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public interface BackEventProgress {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/material3/internal/BackEventProgress$Completed;", "Landroidx/compose/material3/internal/BackEventProgress;", "<init>", "()V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Completed implements BackEventProgress {
        public static final int $stable;
        public static final Completed INSTANCE;

        static {
            Completed.INSTANCE = new Completed();
        }

        private Completed() {
            super();
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0007HÆ\u0003J1\u0010\u0014\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001A\u00020\u00162\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001D"}, d2={"Landroidx/compose/material3/internal/BackEventProgress$InProgress;", "Landroidx/compose/material3/internal/BackEventProgress;", "touchX", "", "touchY", "progress", "swipeEdge", "Landroidx/compose/material3/internal/SwipeEdge;", "<init>", "(FFFLandroidx/compose/material3/internal/SwipeEdge;)V", "getTouchX", "()F", "getTouchY", "getProgress", "getSwipeEdge", "()Landroidx/compose/material3/internal/SwipeEdge;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InProgress implements BackEventProgress {
        public static final int $stable;
        private final float progress;
        private final SwipeEdge swipeEdge;
        private final float touchX;
        private final float touchY;

        static {
        }

        public InProgress(float arg1, float arg2, float arg3, SwipeEdge arg4) {
            super();
            this.touchX = arg1;
            this.touchY = arg2;
            this.progress = arg3;
            this.swipeEdge = arg4;
        }

        public final float component1() {
            return this.touchX;
        }

        public final float component2() {
            return this.touchY;
        }

        public final float component3() {
            return this.progress;
        }

        public final SwipeEdge component4() {
            return this.swipeEdge;
        }

        public final InProgress copy(float arg1, float arg2, float arg3, SwipeEdge arg4) {
            return new InProgress(arg1, arg2, arg3, arg4);
        }

        public static InProgress copy$default(InProgress arg0, float arg1, float arg2, float arg3, SwipeEdge arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.touchX;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.touchY;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.progress;
            }

            if((arg5 & 8) != 0) {
                arg4 = arg0.swipeEdge;
            }

            return arg0.copy(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg5) {
            if(this == (((InProgress)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof InProgress)) {
                return 0;
            }

            if(Float.compare(this.touchX, ((InProgress)arg5).touchX) != 0) {
                return 0;
            }

            if(Float.compare(this.touchY, ((InProgress)arg5).touchY) != 0) {
                return 0;
            }

            if(Float.compare(this.progress, ((InProgress)arg5).progress) != 0) {
                return 0;
            }

            if(this.swipeEdge != ((InProgress)arg5).swipeEdge) {
                return 0;
            }

            return 1;
        }

        public final float getProgress() {
            return this.progress;
        }

        public final SwipeEdge getSwipeEdge() {
            return this.swipeEdge;
        }

        public final float getTouchX() {
            return this.touchX;
        }

        public final float getTouchY() {
            return this.touchY;
        }

        public int hashCode() {
            return ((Float.hashCode(this.touchX) * 0x1F + Float.hashCode(this.touchY)) * 0x1F + Float.hashCode(this.progress)) * 0x1F + this.swipeEdge.hashCode();
        }

        public String toString() {
            return "InProgress(touchX=" + this.touchX + ", touchY=" + this.touchY + ", progress=" + this.progress + ", swipeEdge=" + this.swipeEdge + ')';
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/compose/material3/internal/BackEventProgress$NotRunning;", "Landroidx/compose/material3/internal/BackEventProgress;", "<init>", "()V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NotRunning implements BackEventProgress {
        public static final int $stable;
        public static final NotRunning INSTANCE;

        static {
            NotRunning.INSTANCE = new NotRunning();
        }

        private NotRunning() {
            super();
        }
    }

}

