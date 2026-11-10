package com.TryJeanPc.goldenmouse;

import android.view.View$OnClickListener;
import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.CompoundButton;

public final class GoldenGamePickerView$AppsAdapter$$ExternalSyntheticLambda1 implements CompoundButton$OnCheckedChangeListener {
    public GoldenGamePickerView$AppsAdapter$$ExternalSyntheticLambda1(boolean arg1, AppRow arg2, View$OnClickListener arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final void onCheckedChanged(CompoundButton arg3, boolean arg4) {
        AppsAdapter.onBindViewHolder$lambda$2(this.f$0, this.f$1, this.f$2, arg3, arg4);
    }
}

