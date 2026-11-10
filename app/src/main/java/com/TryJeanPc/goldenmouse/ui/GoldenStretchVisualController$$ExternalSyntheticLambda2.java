package com.TryJeanPc.goldenmouse.ui;

import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface;
import com.TryJeanPc.goldenmouse.stretch.physical.GoldenStretchPhysicalController;

public final class GoldenStretchVisualController$$ExternalSyntheticLambda2 implements DialogInterface$OnCancelListener {
    public GoldenStretchVisualController$$ExternalSyntheticLambda2(GoldenStretchPhysicalController arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onCancel(DialogInterface arg1) {
        GoldenStretchVisualController.bindControls$lambda$15$lambda$14$lambda$13(this.f$0, arg1);
    }
}

