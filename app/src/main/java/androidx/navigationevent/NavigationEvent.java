package androidx.navigationevent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001B2\u00020\u0001:\u0002\u001A\u001BB;\b\u0007\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0003\u0010\u0007\u001A\u00020\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001A\u00020\u0003H\u0016J\b\u0010\u0018\u001A\u00020\u0019H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001A\u00020\u00058G¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0006\u001A\u00020\u00058G¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0013\u0010\u0007\u001A\u00020\u00058G¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000FR\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001C"}, d2={"Landroidx/navigationevent/NavigationEvent;", "", "swipeEdge", "", "progress", "", "touchX", "touchY", "frameTimeMillis", "", "<init>", "(IFFFJ)V", "getSwipeEdge", "()I", "getProgress", "()F", "getTouchX", "getTouchY", "getFrameTimeMillis", "()J", "equals", "", "other", "hashCode", "toString", "", "SwipeEdge", "Companion", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationEvent {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/navigationevent/NavigationEvent$Companion;", "", "<init>", "()V", "EDGE_LEFT", "", "EDGE_RIGHT", "EDGE_NONE", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @Target(value={ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE}) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/navigationevent/NavigationEvent$SwipeEdge;", "", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.TYPE}) @public interface SwipeEdge {
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
        NavigationEvent.Companion = new Companion(null);
    }

    public NavigationEvent(int arg1, float arg2, float arg3, float arg4, long arg5) {
        super();
        this.swipeEdge = arg1;
        this.progress = arg2;
        this.touchX = arg3;
        this.touchY = arg4;
        this.frameTimeMillis = arg5;
    }

    public NavigationEvent() {
        this(0, 0f, 0f, 0f, 0, 0x1F, null);
    }

    public NavigationEvent(int arg2, float arg3, float arg4, float arg5, long arg6, int arg8, DefaultConstructorMarker arg9) {
        if((arg8 & 1) != 0) {
            arg2 = 2;
        }

        if((arg8 & 16) != 0) {
            arg6 = 0;
        }

        this(arg2, 0f, 0f, 0f, arg6);
    }

    public NavigationEvent(int arg10) {
        this(arg10, 0f, 0f, 0f, 0, 30, null);
    }

    public NavigationEvent(int arg10, float arg11) {
        this(arg10, arg11, 0f, 0f, 0, 28, null);
    }

    public NavigationEvent(int arg10, float arg11, float arg12) {
        this(arg10, arg11, arg12, 0f, 0, 24, null);
    }

    public NavigationEvent(int arg10, float arg11, float arg12, float arg13) {
        this(arg10, arg11, arg12, arg13, 0, 16, null);
    }

    public boolean equals(Object arg5) {
        if(this == (((NavigationEvent)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(this.getClass() != arg5.getClass()) {
            }
            else if(this.touchX == ((NavigationEvent)arg5).touchX && this.touchY == ((NavigationEvent)arg5).touchY && this.progress == ((NavigationEvent)arg5).progress) {
                if(this.swipeEdge != ((NavigationEvent)arg5).swipeEdge) {
                    return 0;
                }
                else if(this.frameTimeMillis != ((NavigationEvent)arg5).frameTimeMillis) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
        }

        return 0;
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

    public int hashCode() {
        return (((Float.hashCode(this.touchX) * 0x1F + Float.hashCode(this.touchY)) * 0x1F + Float.hashCode(this.progress)) * 0x1F + Integer.hashCode(this.swipeEdge)) * 0x1F + Long.hashCode(this.frameTimeMillis);
    }

    public String toString() {
        return "NavigationEvent(touchX=" + this.touchX + ", touchY=" + this.touchY + ", progress=" + this.progress + ", swipeEdge=" + this.swipeEdge + ", frameTimeMillis=" + this.frameTimeMillis + ')';
    }
}

