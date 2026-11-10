package androidx.compose.ui.text.android;

import android.graphics.text.LineBreakConfig$Builder;
import android.text.StaticLayout$Builder;
import android.text.StaticLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J \u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\rH\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/text/android/StaticLayoutFactory33;", "", "<init>", "()V", "isFallbackLineSpacingEnabled", "", "layout", "Landroid/text/StaticLayout;", "setLineBreakConfig", "", "builder", "Landroid/text/StaticLayout$Builder;", "lineBreakStyle", "", "lineBreakWordStyle", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class StaticLayoutFactory33 {
    public static final StaticLayoutFactory33 INSTANCE;

    static {
        StaticLayoutFactory33.INSTANCE = new StaticLayoutFactory33();
    }

    private StaticLayoutFactory33() {
        super();
    }

    @JvmStatic public static final boolean isFallbackLineSpacingEnabled(StaticLayout arg0) {
        return arg0.isFallbackLineSpacingEnabled();
    }

    @JvmStatic public static final void setLineBreakConfig(StaticLayout$Builder arg1, int arg2, int arg3) {
        arg1.setLineBreakConfig(new LineBreakConfig$Builder().setLineBreakStyle(arg2).setLineBreakWordStyle(arg3).build());
    }
}

