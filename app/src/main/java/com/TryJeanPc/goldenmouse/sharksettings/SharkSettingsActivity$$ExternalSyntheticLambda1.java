package com.TryJeanPc.goldenmouse.sharksettings;

import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.CompoundButton;
import com.TryJeanPc.goldenmouse.ui.DecorativeAnimationPreferences;
import com.TryJeanPc.goldenmouse.ui.DecorativeEffect;

public final class SharkSettingsActivity$$ExternalSyntheticLambda1 implements CompoundButton$OnCheckedChangeListener {
    public SharkSettingsActivity$$ExternalSyntheticLambda1(DecorativeAnimationPreferences arg1, DecorativeEffect arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onCheckedChanged(CompoundButton arg2, boolean arg3) {
        SharkSettingsActivity.onCreate$lambda$4$lambda$3(this.f$0, this.f$1, arg2, arg3);
    }
}

