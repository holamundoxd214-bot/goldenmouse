package androidx.compose.material3.tokens;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007R\u0011\u0010\u000E\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000BR\u0011\u0010\u0010\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000B¨\u0006\u0014"}, d2={"Landroidx/compose/material3/tokens/ProgressIndicatorTokens;", "", "<init>", "()V", "ActiveIndicatorColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActiveIndicatorColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getActiveShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "StopColor", "getStopColor", "StopShape", "getStopShape", "TrackColor", "getTrackColor", "TrackShape", "getTrackShape", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ProgressIndicatorTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens ActiveIndicatorColor;
    private static final ShapeKeyTokens ActiveShape;
    public static final ProgressIndicatorTokens INSTANCE;
    private static final ColorSchemeKeyTokens StopColor;
    private static final ShapeKeyTokens StopShape;
    private static final ColorSchemeKeyTokens TrackColor;
    private static final ShapeKeyTokens TrackShape;

    static {
        ProgressIndicatorTokens.INSTANCE = new ProgressIndicatorTokens();
        ProgressIndicatorTokens.ActiveIndicatorColor = ColorSchemeKeyTokens.Primary;
        ProgressIndicatorTokens.ActiveShape = ShapeKeyTokens.CornerFull;
        ProgressIndicatorTokens.StopColor = ColorSchemeKeyTokens.Primary;
        ProgressIndicatorTokens.StopShape = ShapeKeyTokens.CornerFull;
        ProgressIndicatorTokens.TrackColor = ColorSchemeKeyTokens.SecondaryContainer;
        ProgressIndicatorTokens.TrackShape = ShapeKeyTokens.CornerFull;
    }

    private ProgressIndicatorTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getActiveIndicatorColor() {
        return ProgressIndicatorTokens.ActiveIndicatorColor;
    }

    public final ShapeKeyTokens getActiveShape() {
        return ProgressIndicatorTokens.ActiveShape;
    }

    public final ColorSchemeKeyTokens getStopColor() {
        return ProgressIndicatorTokens.StopColor;
    }

    public final ShapeKeyTokens getStopShape() {
        return ProgressIndicatorTokens.StopShape;
    }

    public final ColorSchemeKeyTokens getTrackColor() {
        return ProgressIndicatorTokens.TrackColor;
    }

    public final ShapeKeyTokens getTrackShape() {
        return ProgressIndicatorTokens.TrackShape;
    }
}

