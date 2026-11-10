package androidx.compose.foundation.text.contextmenu.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Build$VERSION;
import android.view.textclassifier.TextClassification;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u0016\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f¨\u0006\r"}, d2={"Landroidx/compose/foundation/text/contextmenu/internal/TextClassificationHelperApi28;", "", "<init>", "()V", "sendPendingIntent", "", "pendingIntent", "Landroid/app/PendingIntent;", "sendLegacyIntent", "context", "Landroid/content/Context;", "textClassification", "Landroid/view/textclassifier/TextClassification;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextClassificationHelperApi28 {
    public static final int $stable;
    public static final TextClassificationHelperApi28 INSTANCE;

    static {
        TextClassificationHelperApi28.INSTANCE = new TextClassificationHelperApi28();
    }

    private TextClassificationHelperApi28() {
        super();
    }

    public final void sendLegacyIntent(Context arg3, TextClassification arg4) {
        String v0 = arg4.getText();
        int v0_1 = v0 != null ? v0.hashCode() : 0;
        this.sendPendingIntent(PendingIntent.getActivity(arg3, v0_1, arg4.getIntent(), 0xC000000));
    }

    public final void sendPendingIntent(PendingIntent arg2) {
        if(Build$VERSION.SDK_INT >= 34) {
            TextClassificationHelper34.INSTANCE.sendIntentAllowBackgroundActivityStart(arg2);
            return;
        }

        arg2.send();
    }
}

