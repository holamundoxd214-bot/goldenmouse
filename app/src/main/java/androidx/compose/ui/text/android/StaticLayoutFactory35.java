package androidx.compose.ui.text.android;

import android.text.StaticLayout$Builder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/text/android/StaticLayoutFactory35;", "", "<init>", "()V", "disableUseBoundsForWidth", "", "builder", "Landroid/text/StaticLayout$Builder;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class StaticLayoutFactory35 {
    public static final StaticLayoutFactory35 INSTANCE;

    static {
        StaticLayoutFactory35.INSTANCE = new StaticLayoutFactory35();
    }

    private StaticLayoutFactory35() {
        super();
    }

    @JvmStatic public static final void disableUseBoundsForWidth(StaticLayout$Builder arg1) {
        arg1.setUseBoundsForWidth(false);
    }
}

