package androidx.compose.animation.core;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/compose/animation/core/Spring;", "", "<init>", "()V", "StiffnessHigh", "", "StiffnessMedium", "StiffnessMediumLow", "StiffnessLow", "StiffnessVeryLow", "DampingRatioHighBouncy", "DampingRatioMediumBouncy", "DampingRatioLowBouncy", "DampingRatioNoBouncy", "DefaultDisplacementThreshold", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Spring {
    public static final int $stable = 0;
    public static final float DampingRatioHighBouncy = 0.2f;
    public static final float DampingRatioLowBouncy = 0.75f;
    public static final float DampingRatioMediumBouncy = 0.5f;
    public static final float DampingRatioNoBouncy = 1f;
    public static final float DefaultDisplacementThreshold = 0.01f;
    public static final Spring INSTANCE = null;
    public static final float StiffnessHigh = 10000f;
    public static final float StiffnessLow = 200f;
    public static final float StiffnessMedium = 1500f;
    public static final float StiffnessMediumLow = 400f;
    public static final float StiffnessVeryLow = 50f;

    static {
        Spring.INSTANCE = new Spring();
    }

    private Spring() {
        super();
    }
}

