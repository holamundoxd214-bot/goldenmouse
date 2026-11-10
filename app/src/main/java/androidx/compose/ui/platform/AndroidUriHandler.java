package androidx.compose.ui.platform;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/ui/platform/AndroidUriHandler;", "Landroidx/compose/ui/platform/UriHandler;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "openUri", "", "uri", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidUriHandler implements UriHandler {
    public static final int $stable = 8;
    private final Context context;

    static {
    }

    public AndroidUriHandler(Context arg1) {
        super();
        this.context = arg1;
    }

    public void openUri(String arg4) {
        try {
            this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(arg4)));
            return;
        }
        catch(ActivityNotFoundException v3) {
            throw new IllegalArgumentException("Can\'t open " + arg4 + '.', ((Throwable)v3));
        }
    }
}

