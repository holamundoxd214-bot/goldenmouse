package com.TryJeanPc.goldenmouse;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

public final class GoldenGamePickerView$$ExternalSyntheticLambda2 implements OnApplyWindowInsetsListener {
    public GoldenGamePickerView$$ExternalSyntheticLambda2(View arg1, GoldenGamePickerView arg2, View arg3, Rect arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View arg7, WindowInsetsCompat arg8) {
        return GoldenGamePickerView.onFinishInflate$lambda$5(this.f$0, this.f$1, this.f$2, this.f$3, arg7, arg8);
    }
}

