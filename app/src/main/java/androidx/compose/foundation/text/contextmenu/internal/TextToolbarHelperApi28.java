package androidx.compose.foundation.text.contextmenu.internal;

import android.app.RemoteAction;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.textclassifier.TextClassification;
import kotlin.Metadata;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\tJ.\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012J&\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/text/contextmenu/internal/TextToolbarHelperApi28;", "", "<init>", "()V", "addMenuItem", "", "menu", "Landroid/view/Menu;", "orderId", "", "context", "Landroid/content/Context;", "textClassification", "Landroid/view/textclassifier/TextClassification;", "index", "isPrimary", "", "remoteAction", "Landroid/app/RemoteAction;", "addLegacyMenuItem", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextToolbarHelperApi28 {
    public static final TextToolbarHelperApi28 INSTANCE;

    static {
        TextToolbarHelperApi28.INSTANCE = new TextToolbarHelperApi28();
    }

    private TextToolbarHelperApi28() {
        super();
    }

    public final void addLegacyMenuItem(Menu arg2, int arg3, Context arg4, TextClassification arg5) {
        MenuItem v1 = arg2.add(0x1020041, 0x1020041, arg3, arg5.getLabel());
        v1.setShowAsAction(2);
        v1.setIcon(arg5.getIcon());
        v1.setOnMenuItemClickListener(new TextToolbarHelperApi28$$ExternalSyntheticLambda0(arg4, arg5));
    }

    static final boolean addLegacyMenuItem$lambda$0(Context arg0, TextClassification arg1, MenuItem arg2) {
        TextClassificationHelperApi28.INSTANCE.sendLegacyIntent(arg0, arg1);
        return 1;
    }

    public final void addMenuItem(Menu arg2, int arg3, Context arg4, TextClassification arg5, int arg6) {
        if(arg6 < 0) {
            this.addLegacyMenuItem(arg2, arg3, arg4, arg5);
            return;
        }

        boolean v0 = arg6 == 0 ? true : false;
        this.addMenuItem(arg2, arg3, arg4, v0, arg5.getActions().get(arg6));
    }

    public final void addMenuItem(Menu arg4, int arg5, Context arg6, boolean arg7, RemoteAction arg8) {
        int v3 = 0;
        int v0 = 0x1020041;
        int v1 = arg7 ? v0 : 0;
        MenuItem v4 = arg4.add(v0, v1, arg5, arg8.getTitle());
        if(arg7) {
            v3 = 2;
        }

        v4.setShowAsAction(v3);
        if((arg7) || (arg8.shouldShowIcon())) {
            v4.setIcon(arg8.getIcon().loadDrawable(arg6));
        }

        v4.setOnMenuItemClickListener(new TextToolbarHelperApi28$$ExternalSyntheticLambda1(arg8));
    }

    static final boolean addMenuItem$lambda$0(RemoteAction arg0, MenuItem arg1) {
        TextClassificationHelperApi28.INSTANCE.sendPendingIntent(arg0.getActionIntent());
        return 1;
    }
}

