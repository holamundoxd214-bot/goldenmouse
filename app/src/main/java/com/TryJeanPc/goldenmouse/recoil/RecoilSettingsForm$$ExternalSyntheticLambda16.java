package com.TryJeanPc.goldenmouse.recoil;

import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.CompoundButton;
import kotlin.jvm.functions.Function1;

public final class RecoilSettingsForm$$ExternalSyntheticLambda16 implements CompoundButton$OnCheckedChangeListener {
    public RecoilSettingsForm$$ExternalSyntheticLambda16(RecoilSettingsForm arg1, Function1 arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onCheckedChanged(CompoundButton arg2, boolean arg3) {
        RecoilSettingsForm.toggle$lambda$27(this.f$0, this.f$1, arg2, arg3);
    }
}

