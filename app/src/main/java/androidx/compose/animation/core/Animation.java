package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\b\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004J\u0015\u0010\u0013\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00020\u0006H&¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001A\u00028\u00012\u0006\u0010\u0014\u001A\u00020\u0006H&¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u0006H\u0016R\u0012\u0010\u0005\u001A\u00020\u0006X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u001E\u0010\t\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0012\u0010\r\u001A\u00028\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0012\u0010\u0010\u001A\u00020\u0011X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0003"}, d2={"Landroidx/compose/animation/core/Animation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "durationNanos", "", "getDurationNanos", "()J", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "targetValue", "getTargetValue", "()Ljava/lang/Object;", "isInfinite", "", "()Z", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "isFinishedFromNanos", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Animation {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static boolean isFinishedFromNanos(Animation arg0, long arg1) {
            return arg0.isFinishedFromNanos(arg1);
        }
    }

    static boolean access$isFinishedFromNanos$jd(Animation arg0, long arg1) {
        return super.isFinishedFromNanos(arg1);
    }

    long getDurationNanos();

    Object getTargetValue();

    TwoWayConverter getTypeConverter();

    Object getValueFromNanos(long arg1);

    AnimationVector getVelocityVectorFromNanos(long arg1);

    default boolean isFinishedFromNanos(long arg3) {
        if(arg3 >= this.getDurationNanos()) {
            return 1;
        }

        return 0;
    }

    boolean isInfinite();
}

