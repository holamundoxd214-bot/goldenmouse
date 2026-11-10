package com.TryJeanPc.goldenmouse.gamespace;

import android.view.View$OnClickListener;
import android.view.View;
import com.TryJeanPc.goldenmouse.GameInfo;

public final class GoldenCompactGrid$Cards$$ExternalSyntheticLambda0 implements View$OnClickListener {
    public GoldenCompactGrid$Cards$$ExternalSyntheticLambda0(GoldenCompactGrid arg1, GameInfo arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onClick(View arg2) {
        Cards.onBindViewHolder$lambda$2(this.f$0, this.f$1, arg2);
    }
}

