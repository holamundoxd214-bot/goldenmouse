package com.TryJeanPc.goldenmouse.gamespace;

import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface;
import com.TryJeanPc.goldenmouse.StartEvaluation;

public final class GoldenGameSpaceActivity$$ExternalSyntheticLambda6 implements DialogInterface$OnClickListener {
    public GoldenGameSpaceActivity$$ExternalSyntheticLambda6(StartEvaluation arg1, GoldenGameSpaceActivity arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void onClick(DialogInterface arg2, int arg3) {
        GoldenGameSpaceActivity.showStartRequirements$lambda$7(this.f$0, this.f$1, arg2, arg3);
    }
}

