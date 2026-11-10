package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition$Segment;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001%J\u0017\u0010\u0003\u001A\u00020\u0004*\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H¦\u0004JL\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u000E\b\u0002\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f2#\b\u0002\u0010\u000E\u001A\u001D\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000FH&¢\u0006\u0004\b\u0014\u0010\u0015JL\u0010\u0016\u001A\u00020\u00172\u0006\u0010\t\u001A\u00020\n2\u000E\b\u0002\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f2#\b\u0002\u0010\u0018\u001A\u001D\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000FH&¢\u0006\u0004\b\u0019\u0010\u001AR\u001E\u0010\u001B\u001A\u00020\u0017*\u00020\u001C8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 R\u0012\u0010!\u001A\u00020\"X¦\u0004¢\u0006\u0006\u001A\u0004\b#\u0010$\u0082\u0001\u0001&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\'À\u0006\u0001"}, d2={"Landroidx/compose/animation/AnimatedContentTransitionScope;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "using", "Landroidx/compose/animation/ContentTransform;", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "slideIntoContainer", "Landroidx/compose/animation/EnterTransition;", "towards", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "initialOffset", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "offsetForFullSlide", "slideIntoContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "slideOutOfContainer", "Landroidx/compose/animation/ExitTransition;", "targetOffset", "slideOutOfContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "KeepUntilTransitionsFinished", "Landroidx/compose/animation/ExitTransition$Companion;", "getKeepUntilTransitionsFinished$annotations", "(Landroidx/compose/animation/ExitTransition$Companion;)V", "getKeepUntilTransitionsFinished", "(Landroidx/compose/animation/ExitTransition$Companion;)Landroidx/compose/animation/ExitTransition;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "getContentAlignment", "()Landroidx/compose/ui/Alignment;", "SlideDirection", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface AnimatedContentTransitionScope extends Segment {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class SlideDirection {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2={"Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection$Companion;", "", "<init>", "()V", "Left", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "getLeft-DKzdypw", "()I", "I", "Right", "getRight-DKzdypw", "Up", "getUp-DKzdypw", "Down", "getDown-DKzdypw", "Start", "getStart-DKzdypw", "End", "getEnd-DKzdypw", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            public final int getDown-DKzdypw() {
                return SlideDirection.Down;
            }

            public final int getEnd-DKzdypw() {
                return SlideDirection.End;
            }

            public final int getLeft-DKzdypw() {
                return SlideDirection.Left;
            }

            public final int getRight-DKzdypw() {
                return SlideDirection.Right;
            }

            public final int getStart-DKzdypw() {
                return SlideDirection.Start;
            }

            public final int getUp-DKzdypw() {
                return SlideDirection.Up;
            }
        }

        public static final Companion Companion;
        private static final int Down;
        private static final int End;
        private static final int Left;
        private static final int Right;
        private static final int Start;
        private static final int Up;
        private final int value;

        static {
            SlideDirection.Companion = new Companion(null);
            SlideDirection.Left = SlideDirection.constructor-impl(0);
            SlideDirection.Right = SlideDirection.constructor-impl(1);
            SlideDirection.Up = SlideDirection.constructor-impl(2);
            SlideDirection.Down = SlideDirection.constructor-impl(3);
            SlideDirection.Start = SlideDirection.constructor-impl(4);
            SlideDirection.End = SlideDirection.constructor-impl(5);
        }

        private SlideDirection(int arg1) {
            super();
            this.value = arg1;
        }

        public static final int access$getDown$cp() {
            return SlideDirection.Down;
        }

        public static final int access$getEnd$cp() {
            return SlideDirection.End;
        }

        public static final int access$getLeft$cp() {
            return SlideDirection.Left;
        }

        public static final int access$getRight$cp() {
            return SlideDirection.Right;
        }

        public static final int access$getStart$cp() {
            return SlideDirection.Start;
        }

        public static final int access$getUp$cp() {
            return SlideDirection.Up;
        }

        public static final SlideDirection box-impl(int arg1) {
            return new SlideDirection(arg1);
        }

        public static int constructor-impl(int arg0) {
            return arg0;
        }

        public boolean equals(Object arg1) {
            return SlideDirection.equals-impl(this.value, arg1);
        }

        public static boolean equals-impl(int arg2, Object arg3) {
            if(!(arg3 instanceof SlideDirection)) {
                return 0;
            }

            if(arg2 != ((SlideDirection)arg3).unbox-impl()) {
                return 0;
            }

            return 1;
        }

        public static final boolean equals-impl0(int arg0, int arg1) {
            if(arg0 == arg1) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return SlideDirection.hashCode-impl(this.value);
        }

        public static int hashCode-impl(int arg0) {
            return Integer.hashCode(arg0);
        }

        public String toString() {
            return SlideDirection.toString-impl(this.value);
        }

        public static String toString-impl(int arg1) {
            if(SlideDirection.equals-impl0(arg1, SlideDirection.Left)) {
                return "Left";
            }

            if(SlideDirection.equals-impl0(arg1, SlideDirection.Right)) {
                return "Right";
            }

            if(SlideDirection.equals-impl0(arg1, SlideDirection.Up)) {
                return "Up";
            }

            if(SlideDirection.equals-impl0(arg1, SlideDirection.Down)) {
                return "Down";
            }

            if(SlideDirection.equals-impl0(arg1, SlideDirection.Start)) {
                return "Start";
            }

            if(SlideDirection.equals-impl0(arg1, SlideDirection.End)) {
                return "End";
            }

            return "Invalid";
        }

        public final int unbox-impl() {
            return this.value;
        }
    }

    Alignment getContentAlignment();

    default ExitTransition getKeepUntilTransitionsFinished(androidx.compose.animation.ExitTransition$Companion arg1) {
        return arg1.getKeepUntilTransitionsFinished$animation();
    }

    static void getKeepUntilTransitionsFinished$annotations(androidx.compose.animation.ExitTransition$Companion arg0) {
    }

    EnterTransition slideIntoContainer-mOhB8PU(int arg1, FiniteAnimationSpec arg2, Function1 arg3);

    static EnterTransition slideIntoContainer-mOhB8PU$default(AnimatedContentTransitionScope arg2, int arg3, FiniteAnimationSpec arg4, Function1 arg5, int arg6, Object arg7) {
        AnimatedContentTransitionScope$slideIntoContainer$1 v5;
        SpringSpec v4;
        if(arg7 == null) {
            if((arg6 & 2) != 0) {
                v4 = AnimationSpecKt.spring$default(0f, 0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, null);
            }

            if((arg6 & 4) != 0) {
                v5 = AnimatedContentTransitionScope$slideIntoContainer$1.INSTANCE;
            }

            return arg2.slideIntoContainer-mOhB8PU(arg3, ((FiniteAnimationSpec)v4), ((Function1)v5));
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideIntoContainer-mOhB8PU");
    }

    ExitTransition slideOutOfContainer-mOhB8PU(int arg1, FiniteAnimationSpec arg2, Function1 arg3);

    static ExitTransition slideOutOfContainer-mOhB8PU$default(AnimatedContentTransitionScope arg2, int arg3, FiniteAnimationSpec arg4, Function1 arg5, int arg6, Object arg7) {
        AnimatedContentTransitionScope$slideOutOfContainer$1 v5;
        SpringSpec v4;
        if(arg7 == null) {
            if((arg6 & 2) != 0) {
                v4 = AnimationSpecKt.spring$default(0f, 0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, null);
            }

            if((arg6 & 4) != 0) {
                v5 = AnimatedContentTransitionScope$slideOutOfContainer$1.INSTANCE;
            }

            return arg2.slideOutOfContainer-mOhB8PU(arg3, ((FiniteAnimationSpec)v4), ((Function1)v5));
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideOutOfContainer-mOhB8PU");
    }

    ContentTransform using(ContentTransform arg1, SizeTransform arg2);
}

