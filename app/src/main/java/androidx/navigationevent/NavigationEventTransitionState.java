package androidx.navigationevent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00072\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\b\t¨\u0006\n"}, d2={"Landroidx/navigationevent/NavigationEventTransitionState;", "", "<init>", "()V", "Idle", "InProgress", "Direction", "Companion", "Landroidx/navigationevent/NavigationEventTransitionState$Idle;", "Landroidx/navigationevent/NavigationEventTransitionState$InProgress;", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class NavigationEventTransitionState {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/navigationevent/NavigationEventTransitionState$Companion;", "", "<init>", "()V", "TRANSITIONING_UNKNOWN", "", "TRANSITIONING_FORWARD", "TRANSITIONING_BACK", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @Target(value={ElementType.METHOD, ElementType.PARAMETER}) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/navigationevent/NavigationEventTransitionState$Direction;", "", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @kotlin.annotation.Target(allowedTargets={AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER}) @public interface Direction {
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016¨\u0006\u0006"}, d2={"Landroidx/navigationevent/NavigationEventTransitionState$Idle;", "Landroidx/navigationevent/NavigationEventTransitionState;", "<init>", "()V", "toString", "", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Idle extends NavigationEventTransitionState {
        public static final Idle INSTANCE;

        static {
            Idle.INSTANCE = new Idle();
        }

        private Idle() {
            super(null);
        }

        public String toString() {
            return "Idle()";
        }
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0005H\u0016J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0013"}, d2={"Landroidx/navigationevent/NavigationEventTransitionState$InProgress;", "Landroidx/navigationevent/NavigationEventTransitionState;", "latestEvent", "Landroidx/navigationevent/NavigationEvent;", "direction", "", "<init>", "(Landroidx/navigationevent/NavigationEvent;I)V", "getLatestEvent", "()Landroidx/navigationevent/NavigationEvent;", "getDirection", "()I", "equals", "", "other", "", "hashCode", "toString", "", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InProgress extends NavigationEventTransitionState {
        private final int direction;
        private final NavigationEvent latestEvent;

        public InProgress(NavigationEvent arg2, int arg3) {
            Intrinsics.checkNotNullParameter(arg2, "latestEvent");
            super(null);
            this.latestEvent = arg2;
            this.direction = arg3;
        }

        public boolean equals(Object arg5) {
            if(this == (((InProgress)arg5))) {
                return 1;
            }

            if(arg5 != null) {
                if(this.getClass() != arg5.getClass()) {
                }
                else if(this.direction != ((InProgress)arg5).direction) {
                    return 0;
                }
                else if(!Intrinsics.areEqual(this.latestEvent, ((InProgress)arg5).latestEvent)) {
                    return 0;
                }
                else {
                    return 1;
                }
            }

            return 0;
        }

        public final int getDirection() {
            return this.direction;
        }

        public final NavigationEvent getLatestEvent() {
            return this.latestEvent;
        }

        public int hashCode() {
            return this.direction * 0x1F + this.latestEvent.hashCode();
        }

        public String toString() {
            return "InProgress(latestEvent=" + this.latestEvent + ", direction=" + this.direction + ')';
        }
    }

    public static final Companion Companion = null;
    public static final int TRANSITIONING_BACK = -1;
    public static final int TRANSITIONING_FORWARD = 1;
    public static final int TRANSITIONING_UNKNOWN;

    static {
        NavigationEventTransitionState.Companion = new Companion(null);
    }

    private NavigationEventTransitionState() {
        super();
    }

    public NavigationEventTransitionState(DefaultConstructorMarker arg1) {
        this();
    }
}

