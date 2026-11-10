package androidx.compose.ui.text.android;

import android.text.Layout$Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001F\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\bÁ\u0002\u0018\u00002\u00020\u0001:\b89:;<=>?B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020%X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020%X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020(X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010,\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010-\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u00020(X\u0080T¢\u0006\u0002\n\u0000R\u0014\u00100\u001A\u000201X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b2\u00103R\u0014\u00104\u001A\u000205X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b6\u00107¨\u0006@"}, d2={"Landroidx/compose/ui/text/android/LayoutCompat;", "", "<init>", "()V", "ALIGN_NORMAL", "", "ALIGN_OPPOSITE", "ALIGN_CENTER", "ALIGN_LEFT", "ALIGN_RIGHT", "JUSTIFICATION_MODE_NONE", "JUSTIFICATION_MODE_INTER_WORD", "HYPHENATION_FREQUENCY_NONE", "HYPHENATION_FREQUENCY_NORMAL", "HYPHENATION_FREQUENCY_NORMAL_FAST", "HYPHENATION_FREQUENCY_FULL", "HYPHENATION_FREQUENCY_FULL_FAST", "BREAK_STRATEGY_SIMPLE", "BREAK_STRATEGY_HIGH_QUALITY", "BREAK_STRATEGY_BALANCED", "LINE_BREAK_STYLE_NONE", "LINE_BREAK_STYLE_LOOSE", "LINE_BREAK_STYLE_NORMAL", "LINE_BREAK_STYLE_STRICT", "LINE_BREAK_WORD_STYLE_NONE", "LINE_BREAK_WORD_STYLE_PHRASE", "TEXT_DIRECTION_LTR", "TEXT_DIRECTION_RTL", "TEXT_DIRECTION_FIRST_STRONG_LTR", "TEXT_DIRECTION_FIRST_STRONG_RTL", "TEXT_DIRECTION_ANY_RTL_LTR", "TEXT_DIRECTION_LOCALE", "TEXT_GRANULARITY_CHARACTER", "TEXT_GRANULARITY_WORD", "DEFAULT_ALIGNMENT", "DEFAULT_TEXT_DIRECTION", "DEFAULT_LINESPACING_MULTIPLIER", "", "DEFAULT_LINESPACING_EXTRA", "DEFAULT_INCLUDE_PADDING", "", "DEFAULT_MAX_LINES", "DEFAULT_BREAK_STRATEGY", "DEFAULT_LINE_BREAK_STYLE", "DEFAULT_LINE_BREAK_WORD_STYLE", "DEFAULT_HYPHENATION_FREQUENCY", "DEFAULT_JUSTIFICATION_MODE", "DEFAULT_FALLBACK_LINE_SPACING", "DEFAULT_LAYOUT_ALIGNMENT", "Landroid/text/Layout$Alignment;", "getDEFAULT_LAYOUT_ALIGNMENT$ui_text", "()Landroid/text/Layout$Alignment;", "DEFAULT_TEXT_DIRECTION_HEURISTIC", "Landroid/text/TextDirectionHeuristic;", "getDEFAULT_TEXT_DIRECTION_HEURISTIC$ui_text", "()Landroid/text/TextDirectionHeuristic;", "TextLayoutAlignment", "JustificationMode", "HyphenationFrequency", "BreakStrategy", "LineBreakStyle", "LineBreakWordStyle", "TextDirection", "TextGranularity", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutCompat {
    @Retention(value=RetentionPolicy.SOURCE) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/compose/ui/text/android/LayoutCompat$BreakStrategy;", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @public interface BreakStrategy {
    }

    @Retention(value=RetentionPolicy.SOURCE) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/compose/ui/text/android/LayoutCompat$HyphenationFrequency;", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @public interface HyphenationFrequency {
    }

    @Retention(value=RetentionPolicy.SOURCE) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/compose/ui/text/android/LayoutCompat$JustificationMode;", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @public interface JustificationMode {
    }

    @Retention(value=RetentionPolicy.SOURCE) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/compose/ui/text/android/LayoutCompat$LineBreakStyle;", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @public interface LineBreakStyle {
    }

    @Retention(value=RetentionPolicy.SOURCE) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/compose/ui/text/android/LayoutCompat$LineBreakWordStyle;", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @public interface LineBreakWordStyle {
    }

    @Retention(value=RetentionPolicy.SOURCE) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/compose/ui/text/android/LayoutCompat$TextDirection;", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @public interface TextDirection {
    }

    @Retention(value=RetentionPolicy.SOURCE) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/compose/ui/text/android/LayoutCompat$TextGranularity;", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @public interface TextGranularity {
    }

    @Retention(value=RetentionPolicy.SOURCE) @Metadata(d1={"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2={"Landroidx/compose/ui/text/android/LayoutCompat$TextLayoutAlignment;", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) @kotlin.annotation.Retention(value=AnnotationRetention.SOURCE) @public interface TextLayoutAlignment {
    }

    public static final int $stable = 0;
    public static final int ALIGN_CENTER = 2;
    public static final int ALIGN_LEFT = 3;
    public static final int ALIGN_NORMAL = 0;
    public static final int ALIGN_OPPOSITE = 1;
    public static final int ALIGN_RIGHT = 4;
    public static final int BREAK_STRATEGY_BALANCED = 2;
    public static final int BREAK_STRATEGY_HIGH_QUALITY = 1;
    public static final int BREAK_STRATEGY_SIMPLE = 0;
    public static final int DEFAULT_ALIGNMENT = 0;
    public static final int DEFAULT_BREAK_STRATEGY = 0;
    public static final boolean DEFAULT_FALLBACK_LINE_SPACING = true;
    public static final int DEFAULT_HYPHENATION_FREQUENCY = 0;
    public static final boolean DEFAULT_INCLUDE_PADDING = false;
    public static final int DEFAULT_JUSTIFICATION_MODE = 0;
    private static final Layout$Alignment DEFAULT_LAYOUT_ALIGNMENT = null;
    public static final float DEFAULT_LINESPACING_EXTRA = 0f;
    public static final float DEFAULT_LINESPACING_MULTIPLIER = 1f;
    public static final int DEFAULT_LINE_BREAK_STYLE = 0;
    public static final int DEFAULT_LINE_BREAK_WORD_STYLE = 0;
    public static final int DEFAULT_MAX_LINES = 0x7FFFFFFF;
    public static final int DEFAULT_TEXT_DIRECTION = 2;
    private static final TextDirectionHeuristic DEFAULT_TEXT_DIRECTION_HEURISTIC = null;
    public static final int HYPHENATION_FREQUENCY_FULL = 2;
    public static final int HYPHENATION_FREQUENCY_FULL_FAST = 4;
    public static final int HYPHENATION_FREQUENCY_NONE = 0;
    public static final int HYPHENATION_FREQUENCY_NORMAL = 1;
    public static final int HYPHENATION_FREQUENCY_NORMAL_FAST = 3;
    public static final LayoutCompat INSTANCE = null;
    public static final int JUSTIFICATION_MODE_INTER_WORD = 1;
    public static final int JUSTIFICATION_MODE_NONE = 0;
    public static final int LINE_BREAK_STYLE_LOOSE = 1;
    public static final int LINE_BREAK_STYLE_NONE = 0;
    public static final int LINE_BREAK_STYLE_NORMAL = 2;
    public static final int LINE_BREAK_STYLE_STRICT = 3;
    public static final int LINE_BREAK_WORD_STYLE_NONE = 0;
    public static final int LINE_BREAK_WORD_STYLE_PHRASE = 1;
    public static final int TEXT_DIRECTION_ANY_RTL_LTR = 4;
    public static final int TEXT_DIRECTION_FIRST_STRONG_LTR = 2;
    public static final int TEXT_DIRECTION_FIRST_STRONG_RTL = 3;
    public static final int TEXT_DIRECTION_LOCALE = 5;
    public static final int TEXT_DIRECTION_LTR = 0;
    public static final int TEXT_DIRECTION_RTL = 1;
    public static final int TEXT_GRANULARITY_CHARACTER = 0;
    public static final int TEXT_GRANULARITY_WORD = 1;

    static {
        LayoutCompat.INSTANCE = new LayoutCompat();
        LayoutCompat.DEFAULT_LAYOUT_ALIGNMENT = Layout$Alignment.ALIGN_NORMAL;
        LayoutCompat.DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        LayoutCompat.$stable = 8;
    }

    private LayoutCompat() {
        super();
    }

    public final Layout$Alignment getDEFAULT_LAYOUT_ALIGNMENT$ui_text() {
        return LayoutCompat.DEFAULT_LAYOUT_ALIGNMENT;
    }

    public final TextDirectionHeuristic getDEFAULT_TEXT_DIRECTION_HEURISTIC$ui_text() {
        return LayoutCompat.DEFAULT_TEXT_DIRECTION_HEURISTIC;
    }
}

