package com.google.android.material.search;

import android.view.View;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

public final class SearchView$$ExternalSyntheticLambda0 implements OnApplyWindowInsetsListener {
    public SearchView$$ExternalSyntheticLambda0(ViewGroup$MarginLayoutParams arg1, int arg2, int arg3) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View arg3, WindowInsetsCompat arg4) {
        return SearchView.lambda$setUpDividerInsetListener$6(this.f$0, this.f$1, this.f$2, arg3, arg4);
    }
}

