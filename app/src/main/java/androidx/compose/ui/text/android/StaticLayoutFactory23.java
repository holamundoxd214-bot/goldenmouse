package androidx.compose.ui.text.android;

import android.os.Build$VERSION;
import android.text.StaticLayout$Builder;
import android.text.StaticLayout;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\tH\u0016¨\u0006\f"}, d2={"Landroidx/compose/ui/text/android/StaticLayoutFactory23;", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "<init>", "()V", "create", "Landroid/text/StaticLayout;", "params", "Landroidx/compose/ui/text/android/StaticLayoutParams;", "isFallbackLineSpacingEnabled", "", "layout", "useFallbackLineSpacing", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class StaticLayoutFactory23 implements StaticLayoutFactoryImpl {
    public StaticLayoutFactory23() {
        super();
    }

    public StaticLayout create(StaticLayoutParams arg5) {
        StaticLayout$Builder v4 = StaticLayout$Builder.obtain(arg5.getText(), arg5.getStart(), arg5.getEnd(), arg5.getPaint(), arg5.getWidth());
        v4.setTextDirection(arg5.getTextDir());
        v4.setAlignment(arg5.getAlignment());
        v4.setMaxLines(arg5.getMaxLines());
        v4.setEllipsize(arg5.getEllipsize());
        v4.setEllipsizedWidth(arg5.getEllipsizedWidth());
        v4.setLineSpacing(arg5.getLineSpacingExtra(), arg5.getLineSpacingMultiplier());
        v4.setIncludePad(arg5.getIncludePadding());
        v4.setBreakStrategy(arg5.getBreakStrategy());
        v4.setHyphenationFrequency(arg5.getHyphenationFrequency());
        v4.setIndents(arg5.getLeftIndents(), arg5.getRightIndents());
        StaticLayoutFactory26.setJustificationMode(v4, arg5.getJustificationMode());
        if(Build$VERSION.SDK_INT >= 28) {
            StaticLayoutFactory28.setUseLineSpacingFromFallbacks(v4, arg5.getUseFallbackLineSpacing());
        }

        if(Build$VERSION.SDK_INT >= 33) {
            StaticLayoutFactory33.setLineBreakConfig(v4, arg5.getLineBreakStyle(), arg5.getLineBreakWordStyle());
        }

        if(Build$VERSION.SDK_INT >= 35) {
            StaticLayoutFactory35.disableUseBoundsForWidth(v4);
        }

        return v4.build();
    }

    public boolean isFallbackLineSpacingEnabled(StaticLayout arg2, boolean arg3) {
        if(Build$VERSION.SDK_INT >= 33) {
            return StaticLayoutFactory33.isFallbackLineSpacingEnabled(arg2);
        }

        if(Build$VERSION.SDK_INT >= 28) {
            return arg3;
        }

        return 0;
    }
}

