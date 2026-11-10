package androidx.activity;

import android.os.Build$VERSION;
import android.window.BackEvent;
import androidx.navigationevent.NavigationEvent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\u0003\u0018\u0000 \u001F2\u00020\u0001:\u0002\u001E\u001FB5\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BB\u0011\b\u0017\u0012\u0006\u0010\f\u001A\u00020\r¢\u0006\u0004\b\n\u0010\u000EB\u0011\b\u0016\u0012\u0006\u0010\u000F\u001A\u00020\u0010¢\u0006\u0004\b\n\u0010\u0011J\b\u0010\u001A\u001A\u00020\rH\u0007J\u0006\u0010\u001B\u001A\u00020\u0010J\b\u0010\u001C\u001A\u00020\u001DH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2={"Landroidx/activity/BackEventCompat;", "", "touchX", "", "touchY", "progress", "swipeEdge", "", "frameTimeMillis", "", "<init>", "(FFFIJ)V", "backEvent", "Landroid/window/BackEvent;", "(Landroid/window/BackEvent;)V", "navigationEvent", "Landroidx/navigationevent/NavigationEvent;", "(Landroidx/navigationevent/NavigationEvent;)V", "getTouchX", "()F", "getTouchY", "getProgress", "getSwipeEdge", "()I", "getFrameTimeMillis", "()J", "toBackEvent", "toNavigationEvent", "toString", "", "SwipeEdge", "Companion", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class BackEventCompat {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/activity/BackEventCompat$Companion;", "", "<init>", "()V", "EDGE_LEFT", "", "EDGE_RIGHT", "EDGE_NONE", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @Target(value={ElementType.TYPE_USE}) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/activity/BackEventCompat$SwipeEdge;", "", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.TYPE}) @public interface SwipeEdge {
    }

    public static final Companion Companion = null;
    public static final int EDGE_LEFT = 0;
    public static final int EDGE_NONE = 2;
    public static final int EDGE_RIGHT = 1;
    private final long frameTimeMillis;
    private final float progress;
    private final int swipeEdge;
    private final float touchX;
    private final float touchY;

    static {
        BackEventCompat.Companion = new Companion(null);
    }

    public BackEventCompat(NavigationEvent arg9) {
        Intrinsics.checkNotNullParameter(arg9, "navigationEvent");
        this(arg9.getTouchX(), arg9.getTouchY(), arg9.getProgress(), arg9.getSwipeEdge(), arg9.getFrameTimeMillis());
    }

    public BackEventCompat(float arg10, float arg11, float arg12, int arg13) {
        this(arg10, arg11, arg12, arg13, 0, 16, null);
    }

    public BackEventCompat(float arg8, float arg9, float arg10, int arg11, long arg12, int arg14, DefaultConstructorMarker arg15) {
        if((arg14 & 16) != 0) {
            arg12 = 0;
        }

        this(arg8, arg9, arg10, arg11, arg12);
    }

    public BackEventCompat(float arg1, float arg2, float arg3, int arg4, long arg5) {
        super();
        this.touchX = arg1;
        this.touchY = arg2;
        this.progress = arg3;
        this.swipeEdge = arg4;
        this.frameTimeMillis = arg5;
    }

    public BackEventCompat(BackEvent arg9) {
        Intrinsics.checkNotNullParameter(arg9, "backEvent");
        float v2 = arg9.getTouchX();
        float v3 = arg9.getTouchY();
        float v4 = arg9.getProgress();
        int v5 = arg9.getSwipeEdge();
        long v0 = Build$VERSION.SDK_INT >= 36 ? arg9.getFrameTimeMillis() : 0;
        this(v2, v3, v4, v5, v0);
    }

    public final long getFrameTimeMillis() {
        return this.frameTimeMillis;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final int getSwipeEdge() {
        return this.swipeEdge;
    }

    public final float getTouchX() {
        return this.touchX;
    }

    public final float getTouchY() {
        return this.touchY;
    }

    public final BackEvent toBackEvent() {
        if(Build$VERSION.SDK_INT >= 36) {
            return new BackEvent(this.touchX, this.touchY, this.progress, this.swipeEdge, this.frameTimeMillis);
        }

        return new BackEvent(this.touchX, this.touchY, this.progress, this.swipeEdge);
    }

    public final NavigationEvent toNavigationEvent() {
        return new NavigationEvent(this.swipeEdge, this.progress, this.touchX, this.touchY, this.frameTimeMillis);
    }

    public String toString() {
        return "BackEventCompat(touchX=" + this.touchX + ", touchY=" + this.touchY + ", progress=" + this.progress + ", swipeEdge=" + this.swipeEdge + ", frameTimeMillis=" + this.frameTimeMillis + ')';
    }
}

