package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\"\u0011\u0010\u0000\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0003\"\u0011\u0010\u0006\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\u0003\"\u0011\u0010\b\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0003\"\u000E\u0010\n\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"FastOutSlowInEasing", "Landroidx/compose/animation/core/Easing;", "getFastOutSlowInEasing", "()Landroidx/compose/animation/core/Easing;", "LinearOutSlowInEasing", "getLinearOutSlowInEasing", "FastOutLinearInEasing", "getFastOutLinearInEasing", "LinearEasing", "getLinearEasing", "OneUlpAt1", "", "animation-core"}, k=2, mv={2, 0, 0}, xi=0x30) public final class EasingKt {
    private static final Easing FastOutLinearInEasing = null;
    private static final Easing FastOutSlowInEasing = null;
    private static final Easing LinearEasing = null;
    private static final Easing LinearOutSlowInEasing = null;
    private static final float OneUlpAt1 = 1.192093E-07f;

    static {
        EasingKt.FastOutSlowInEasing = new CubicBezierEasing(0.4f, 0f, 0.2f, 1f);
        EasingKt.LinearOutSlowInEasing = new CubicBezierEasing(0f, 0f, 0.2f, 1f);
        EasingKt.FastOutLinearInEasing = new CubicBezierEasing(0.4f, 0f, 1f, 1f);
        EasingKt.LinearEasing = new EasingKt$$ExternalSyntheticLambda0();
    }

    static final float LinearEasing$lambda$0(float arg0) {
        return arg0;
    }

    public static final Easing getFastOutLinearInEasing() {
        return EasingKt.FastOutLinearInEasing;
    }

    public static final Easing getFastOutSlowInEasing() {
        return EasingKt.FastOutSlowInEasing;
    }

    public static final Easing getLinearEasing() {
        return EasingKt.LinearEasing;
    }

    public static final Easing getLinearOutSlowInEasing() {
        return EasingKt.LinearOutSlowInEasing;
    }
}

