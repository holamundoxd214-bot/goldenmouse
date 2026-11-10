package com.TryJeanPc.goldenmouse;

import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.CompoundButton;
import kotlin.jvm.functions.Function1;

public final class PanelVisual$$ExternalSyntheticLambda12 implements CompoundButton$OnCheckedChangeListener {
    public PanelVisual$$ExternalSyntheticLambda12(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onCheckedChanged(CompoundButton arg1, boolean arg2) {
        PanelVisual.agregarSwitch$lambda$38$lambda$37(this.f$0, arg1, arg2);
    }
}

