package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0007¨\u0006\f"}, d2={"Landroidx/compose/ui/text/android/style/TextDecorationSpan;", "Landroid/text/style/CharacterStyle;", "isUnderlineText", "", "isStrikethroughText", "<init>", "(ZZ)V", "()Z", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextDecorationSpan extends CharacterStyle {
    public static final int $stable = 8;
    private final boolean isStrikethroughText;
    private final boolean isUnderlineText;

    static {
    }

    public TextDecorationSpan(boolean arg1, boolean arg2) {
        super();
        this.isUnderlineText = arg1;
        this.isStrikethroughText = arg2;
    }

    public final boolean isStrikethroughText() {
        return this.isStrikethroughText;
    }

    public final boolean isUnderlineText() {
        return this.isUnderlineText;
    }

    public void updateDrawState(TextPaint arg2) {
        arg2.setUnderlineText(this.isUnderlineText);
        arg2.setStrikeThruText(this.isStrikethroughText);
    }
}

