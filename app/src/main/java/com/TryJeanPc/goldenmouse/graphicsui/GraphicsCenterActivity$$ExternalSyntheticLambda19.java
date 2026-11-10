package com.TryJeanPc.goldenmouse.graphicsui;

import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.CompoundButton;
import kotlin.jvm.functions.Function1;

public final class GraphicsCenterActivity$$ExternalSyntheticLambda19 implements CompoundButton$OnCheckedChangeListener {
    public GraphicsCenterActivity$$ExternalSyntheticLambda19(Function1 arg1) {
        super();
        this.f$0 = arg1;
    }

    public final void onCheckedChanged(CompoundButton arg1, boolean arg2) {
        GraphicsCenterActivity.toggle$lambda$60$lambda$59(this.f$0, arg1, arg2);
    }
}

