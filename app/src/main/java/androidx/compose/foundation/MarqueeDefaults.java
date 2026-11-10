package androidx.compose.foundation;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086D¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u00020\u0005X\u0086D¢\u0006\u000E\n\u0000\u0012\u0004\b\n\u0010\u0003\u001A\u0004\b\u000B\u0010\bR\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0010\u001A\u00020\u0011¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/MarqueeDefaults;", "", "<init>", "()V", "Iterations", "", "getIterations$annotations", "getIterations", "()I", "RepeatDelayMillis", "getRepeatDelayMillis$annotations", "getRepeatDelayMillis", "Spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "getSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "Velocity", "Landroidx/compose/ui/unit/Dp;", "getVelocity-D9Ej5fM", "()F", "F", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MarqueeDefaults {
    public static final int $stable;
    public static final MarqueeDefaults INSTANCE;
    private static final int Iterations;
    private static final int RepeatDelayMillis;
    private static final MarqueeSpacing Spacing;
    private static final float Velocity;

    static {
        MarqueeDefaults.INSTANCE = new MarqueeDefaults();
        MarqueeDefaults.Iterations = 3;
        MarqueeDefaults.RepeatDelayMillis = 1200;
        MarqueeDefaults.Spacing = MarqueeSpacing.Companion.fractionOfContainer(0.333333f);
        MarqueeDefaults.Velocity = Dp.constructor-impl(30f);
    }

    private MarqueeDefaults() {
        super();
    }

    public final int getIterations() {
        return MarqueeDefaults.Iterations;
    }

    public static void getIterations$annotations() {
    }

    public final int getRepeatDelayMillis() {
        return MarqueeDefaults.RepeatDelayMillis;
    }

    public static void getRepeatDelayMillis$annotations() {
    }

    public final MarqueeSpacing getSpacing() {
        return MarqueeDefaults.Spacing;
    }

    public final float getVelocity-D9Ej5fM() {
        return MarqueeDefaults.Velocity;
    }
}

