package androidx.compose.material3.tokens;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0019\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0014\u0010\f\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007R\u0014\u0010\u000E\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0007R\u0014\u0010\u0010\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0007R\u0014\u0010\u001A\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0007R\u0014\u0010\u001C\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0007¨\u0006\u001E"}, d2={"Landroidx/compose/material3/tokens/ExpressiveMotionTokens;", "", "<init>", "()V", "SpringDefaultSpatialDamping", "", "getSpringDefaultSpatialDamping", "()F", "SpringDefaultSpatialStiffness", "getSpringDefaultSpatialStiffness", "SpringDefaultEffectsDamping", "getSpringDefaultEffectsDamping", "SpringDefaultEffectsStiffness", "getSpringDefaultEffectsStiffness", "SpringFastSpatialDamping", "getSpringFastSpatialDamping", "SpringFastSpatialStiffness", "getSpringFastSpatialStiffness", "SpringFastEffectsDamping", "getSpringFastEffectsDamping", "SpringFastEffectsStiffness", "getSpringFastEffectsStiffness", "SpringSlowSpatialDamping", "getSpringSlowSpatialDamping", "SpringSlowSpatialStiffness", "getSpringSlowSpatialStiffness", "SpringSlowEffectsDamping", "getSpringSlowEffectsDamping", "SpringSlowEffectsStiffness", "getSpringSlowEffectsStiffness", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ExpressiveMotionTokens {
    public static final int $stable;
    public static final ExpressiveMotionTokens INSTANCE;
    private static final float SpringDefaultEffectsDamping;
    private static final float SpringDefaultEffectsStiffness;
    private static final float SpringDefaultSpatialDamping;
    private static final float SpringDefaultSpatialStiffness;
    private static final float SpringFastEffectsDamping;
    private static final float SpringFastEffectsStiffness;
    private static final float SpringFastSpatialDamping;
    private static final float SpringFastSpatialStiffness;
    private static final float SpringSlowEffectsDamping;
    private static final float SpringSlowEffectsStiffness;
    private static final float SpringSlowSpatialDamping;
    private static final float SpringSlowSpatialStiffness;

    static {
        ExpressiveMotionTokens.INSTANCE = new ExpressiveMotionTokens();
        ExpressiveMotionTokens.SpringDefaultSpatialDamping = 0.8f;
        ExpressiveMotionTokens.SpringDefaultSpatialStiffness = 380f;
        ExpressiveMotionTokens.SpringDefaultEffectsDamping = 1f;
        ExpressiveMotionTokens.SpringDefaultEffectsStiffness = 1600f;
        ExpressiveMotionTokens.SpringFastSpatialDamping = 0.6f;
        ExpressiveMotionTokens.SpringFastSpatialStiffness = 800f;
        ExpressiveMotionTokens.SpringFastEffectsDamping = 1f;
        ExpressiveMotionTokens.SpringFastEffectsStiffness = 3800f;
        ExpressiveMotionTokens.SpringSlowSpatialDamping = 0.8f;
        ExpressiveMotionTokens.SpringSlowSpatialStiffness = 200f;
        ExpressiveMotionTokens.SpringSlowEffectsDamping = 1f;
        ExpressiveMotionTokens.SpringSlowEffectsStiffness = 800f;
    }

    private ExpressiveMotionTokens() {
        super();
    }

    public final float getSpringDefaultEffectsDamping() {
        return ExpressiveMotionTokens.SpringDefaultEffectsDamping;
    }

    public final float getSpringDefaultEffectsStiffness() {
        return ExpressiveMotionTokens.SpringDefaultEffectsStiffness;
    }

    public final float getSpringDefaultSpatialDamping() {
        return ExpressiveMotionTokens.SpringDefaultSpatialDamping;
    }

    public final float getSpringDefaultSpatialStiffness() {
        return ExpressiveMotionTokens.SpringDefaultSpatialStiffness;
    }

    public final float getSpringFastEffectsDamping() {
        return ExpressiveMotionTokens.SpringFastEffectsDamping;
    }

    public final float getSpringFastEffectsStiffness() {
        return ExpressiveMotionTokens.SpringFastEffectsStiffness;
    }

    public final float getSpringFastSpatialDamping() {
        return ExpressiveMotionTokens.SpringFastSpatialDamping;
    }

    public final float getSpringFastSpatialStiffness() {
        return ExpressiveMotionTokens.SpringFastSpatialStiffness;
    }

    public final float getSpringSlowEffectsDamping() {
        return ExpressiveMotionTokens.SpringSlowEffectsDamping;
    }

    public final float getSpringSlowEffectsStiffness() {
        return ExpressiveMotionTokens.SpringSlowEffectsStiffness;
    }

    public final float getSpringSlowSpatialDamping() {
        return ExpressiveMotionTokens.SpringSlowSpatialDamping;
    }

    public final float getSpringSlowSpatialStiffness() {
        return ExpressiveMotionTokens.SpringSlowSpatialStiffness;
    }
}

