package com.TryJeanPc.goldenmouse.sharksettings;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;

public final class SharkThemesActivity$$ExternalSyntheticLambda1 implements ActivityResultCallback {
    public SharkThemesActivity$$ExternalSyntheticLambda1(SharkThemesActivity arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onActivityResult(Object arg1) {
        SharkThemesActivity.choosePhoto$lambda$1(this.f$0, ((Uri)arg1));
    }
}

