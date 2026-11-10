package com.google.android.material.search;

import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils$RelativePadding;

public final class SearchView$$ExternalSyntheticLambda3 implements OnApplyWindowInsetsListener {
    public SearchView$$ExternalSyntheticLambda3(SearchView arg1) {
        super();
        this.f$0 = arg1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View arg1, WindowInsetsCompat arg2, RelativePadding arg3) {
        return this.f$0.lambda$setUpToolbarInsetListener$4$com-google-android-material-search-SearchView(arg1, arg2, arg3);
    }
}

