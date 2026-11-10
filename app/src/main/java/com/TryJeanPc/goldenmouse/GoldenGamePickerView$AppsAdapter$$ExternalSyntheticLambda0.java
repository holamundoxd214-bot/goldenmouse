package com.TryJeanPc.goldenmouse;

import android.view.View$OnClickListener;
import android.view.View;

public final class GoldenGamePickerView$AppsAdapter$$ExternalSyntheticLambda0 implements View$OnClickListener {
    public GoldenGamePickerView$AppsAdapter$$ExternalSyntheticLambda0(AppRow arg1, GoldenGamePickerView arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onClick(View arg2) {
        AppsAdapter.onBindViewHolder$lambda$1(this.f$0, this.f$1, arg2);
    }
}

