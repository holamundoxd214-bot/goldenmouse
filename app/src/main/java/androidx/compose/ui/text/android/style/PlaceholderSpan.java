package androidx.compose.ui.text.android.style;

import android.graphics.Canvas;
import android.graphics.Paint$FontMetricsInt;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnitKt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 -2\u00020\u0001:\u0001-BA\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0005¢\u0006\u0004\b\u000B\u0010\fB9\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\r\u001A\u00020\u000E\u0012\u0006\u0010\n\u001A\u00020\u0005¢\u0006\u0004\b\u000B\u0010\u000FJ4\u0010\u001D\u001A\u00020\u00052\u0006\u0010\u001E\u001A\u00020\u001F2\b\u0010 \u001A\u0004\u0018\u00010!2\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\u00052\b\u0010$\u001A\u0004\u0018\u00010\u0013H\u0017JR\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020(2\b\u0010 \u001A\u0004\u0018\u00010!2\u0006\u0010\"\u001A\u00020\u00052\u0006\u0010#\u001A\u00020\u00052\u0006\u0010)\u001A\u00020\u00032\u0006\u0010*\u001A\u00020\u00052\u0006\u0010+\u001A\u00020\u00052\u0006\u0010,\u001A\u00020\u00052\u0006\u0010\u001E\u001A\u00020\u001FH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u001E\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u0013@BX\u0086.¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u00058F@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0011R \u0010\u0019\u001A\u00020\u00052\u0006\u0010\u0012\u001A\u00020\u00058F@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0011R\u000E\u0010\u001B\u001A\u00020\u001CX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006."}, d2={"Landroidx/compose/ui/text/android/style/PlaceholderSpan;", "Landroid/text/style/ReplacementSpan;", "width", "", "widthUnit", "", "height", "heightUnit", "widthAsSpInPx", "heightAsSpInPx", "verticalAlign", "<init>", "(FIFIFFI)V", "density", "Landroidx/compose/ui/unit/Density;", "(FIFILandroidx/compose/ui/unit/Density;I)V", "getVerticalAlign", "()I", "value", "Landroid/graphics/Paint$FontMetricsInt;", "fontMetrics", "getFontMetrics", "()Landroid/graphics/Paint$FontMetricsInt;", "widthPx", "getWidthPx", "heightPx", "getHeightPx", "isLaidOut", "", "getSize", "paint", "Landroid/graphics/Paint;", "text", "", "start", "end", "fm", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", "top", "y", "bottom", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlaceholderSpan extends ReplacementSpan {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u000F\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/android/style/PlaceholderSpan$Companion;", "", "<init>", "()V", "ALIGN_ABOVE_BASELINE", "", "ALIGN_TOP", "ALIGN_BOTTOM", "ALIGN_CENTER", "ALIGN_TEXT_TOP", "ALIGN_TEXT_BOTTOM", "ALIGN_TEXT_CENTER", "UNIT_SP", "UNIT_EM", "UNIT_UNSPECIFIED", "VerticalAlign", "Unit", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        @Retention(value=RetentionPolicy.SOURCE) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/compose/ui/text/android/style/PlaceholderSpan$Companion$Unit;", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @public interface Unit {
        }

        @Retention(value=RetentionPolicy.SOURCE) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/compose/ui/text/android/style/PlaceholderSpan$Companion$VerticalAlign;", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @public interface VerticalAlign {
        }

        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final int ALIGN_ABOVE_BASELINE = 0;
    public static final int ALIGN_BOTTOM = 2;
    public static final int ALIGN_CENTER = 3;
    public static final int ALIGN_TEXT_BOTTOM = 5;
    public static final int ALIGN_TEXT_CENTER = 6;
    public static final int ALIGN_TEXT_TOP = 4;
    public static final int ALIGN_TOP = 1;
    public static final Companion Companion = null;
    public static final int UNIT_EM = 1;
    public static final int UNIT_SP = 0;
    public static final int UNIT_UNSPECIFIED = 2;
    private Paint$FontMetricsInt fontMetrics;
    private final float height;
    private final float heightAsSpInPx;
    private int heightPx;
    private final int heightUnit;
    private boolean isLaidOut;
    private final int verticalAlign;
    private final float width;
    private final float widthAsSpInPx;
    private int widthPx;
    private final int widthUnit;

    static {
        PlaceholderSpan.Companion = new Companion(null);
        PlaceholderSpan.$stable = 8;
    }

    private PlaceholderSpan(float arg1, int arg2, float arg3, int arg4, float arg5, float arg6, int arg7) {
        super();
        this.width = arg1;
        this.widthUnit = arg2;
        this.height = arg3;
        this.heightUnit = arg4;
        this.widthAsSpInPx = arg5;
        this.heightAsSpInPx = arg6;
        this.verticalAlign = arg7;
    }

    public PlaceholderSpan(float arg12, int arg13, float arg14, int arg15, Density arg16, int arg17) {
        Density v0 = arg16;
        float v1 = 0f;
        float v8 = arg13 == 0 ? v0.toPx--R2X_6o(TextUnitKt.getSp(arg12)) : 0f;
        if(arg15 == 0) {
            v1 = v0.toPx--R2X_6o(TextUnitKt.getSp(arg14));
        }

        this(arg12, arg13, arg14, arg15, v8, v1, arg17);
    }

    public void draw(Canvas arg1, CharSequence arg2, int arg3, int arg4, float arg5, int arg6, int arg7, int arg8, Paint arg9) {
    }

    public final Paint$FontMetricsInt getFontMetrics() {
        Paint$FontMetricsInt v0 = this.fontMetrics;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
        return null;
    }

    public final int getHeightPx() {
        if(!this.isLaidOut) {
            InlineClassHelperKt.throwIllegalStateException("PlaceholderSpan is not laid out yet.");
        }

        return this.heightPx;
    }

    public int getSize(Paint arg1, CharSequence arg2, int arg3, int arg4, Paint$FontMetricsInt arg5) {
        float v1_1;
        this.isLaidOut = true;
        float v3 = arg1.getTextSize();
        this.fontMetrics = arg1.getFontMetricsInt();
        int v1 = this.getFontMetrics().descent > this.getFontMetrics().ascent ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Invalid fontMetrics: line height can not be negative.");
        }

        v1 = this.widthUnit;
        String v4 = "Unsupported unit.";
        if(v1 == 0) {
            v1_1 = this.widthAsSpInPx;
        }
        else if(v1 == 1) {
            v1_1 = this.width * v3;
        }
        else {
            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck(v4);
            throw new KotlinNothingValueException();
        }

        this.widthPx = PlaceholderSpan_androidKt.ceilToInt(v1_1);
        v1 = this.heightUnit;
        if(v1 == 0) {
            v1_1 = this.heightAsSpInPx;
        }
        else if(v1 == 1) {
            v1_1 = this.height * v3;
        }
        else {
            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck(v4);
            throw new KotlinNothingValueException();
        }

        this.heightPx = PlaceholderSpan_androidKt.ceilToInt(v1_1);
        if(arg5 != null) {
            arg5.ascent = this.getFontMetrics().ascent;
            arg5.descent = this.getFontMetrics().descent;
            arg5.leading = this.getFontMetrics().leading;
            switch(this.verticalAlign) {
                case 0: {
                    if(arg5.ascent > -this.getHeightPx()) {
                        arg5.ascent = -this.getHeightPx();
                    }
                    else {
                    }

                    break;
                }
                case 1: 
                case 4: {
                    if(arg5.ascent + this.getHeightPx() > arg5.descent) {
                        arg5.descent = arg5.ascent + this.getHeightPx();
                    }
                    else {
                    }

                    break;
                }
                case 2: 
                case 5: {
                    if(arg5.ascent > arg5.descent - this.getHeightPx()) {
                        arg5.ascent = arg5.descent - this.getHeightPx();
                    }
                    else {
                    }

                    break;
                }
                case 3: 
                case 6: {
                    if(arg5.descent - arg5.ascent < this.getHeightPx()) {
                        arg5.ascent -= (this.getHeightPx() - (arg5.descent - arg5.ascent)) / 2;
                        arg5.descent = arg5.ascent + this.getHeightPx();
                    }
                    else {
                    }

                    break;
                }
                default: {
                    InlineClassHelperKt.throwIllegalArgumentException("Unknown verticalAlign.");
                    break;
                }
            }

            arg5.top = Math.min(this.getFontMetrics().top, arg5.ascent);
            arg5.bottom = Math.max(this.getFontMetrics().bottom, arg5.descent);
        }

        return this.getWidthPx();
    }

    public final int getVerticalAlign() {
        return this.verticalAlign;
    }

    public final int getWidthPx() {
        if(!this.isLaidOut) {
            InlineClassHelperKt.throwIllegalStateException("PlaceholderSpan is not laid out yet.");
        }

        return this.widthPx;
    }
}

