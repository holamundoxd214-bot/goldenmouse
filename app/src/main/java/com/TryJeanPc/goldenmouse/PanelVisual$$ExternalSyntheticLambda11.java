package com.TryJeanPc.goldenmouse;

import android.view.View$OnClickListener;
import android.view.View;
import android.widget.TextView;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class PanelVisual$$ExternalSyntheticLambda11 implements View$OnClickListener {
    public PanelVisual$$ExternalSyntheticLambda11(List arg1, ObjectRef arg2, TextView arg3, boolean arg4, PanelVisual arg5, Function1 arg6) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
        this.f$4 = arg5;
        this.f$5 = arg6;
    }

    public final void onClick(View arg8) {
        PanelVisual.agregarSelector$lambda$47(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, arg8);
    }
}

