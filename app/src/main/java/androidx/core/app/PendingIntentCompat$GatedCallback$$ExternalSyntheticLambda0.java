package androidx.core.app;

import android.app.PendingIntent$OnFinished;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public final class PendingIntentCompat$GatedCallback$$ExternalSyntheticLambda0 implements PendingIntent$OnFinished {
    public PendingIntentCompat$GatedCallback$$ExternalSyntheticLambda0(GatedCallback arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onSendFinished(PendingIntent arg1, Intent arg2, int arg3, String arg4, Bundle arg5) {
        GatedCallback.$r8$lambda$-_JLK_p2qvpYOAwGjpaXu2HJ864(this.f$0, arg1, arg2, arg3, arg4, arg5);
    }
}

