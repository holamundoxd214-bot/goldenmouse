package com.TryJeanPc.goldenmouse.service;

import android.app.AlertDialog;
import android.view.View$OnClickListener;
import android.view.View;
import com.TryJeanPc.goldenmouse.profile.GameProfileStorage$IdRepairPlan;

public final class ProfileIdentityRepairDialog$$ExternalSyntheticLambda4 implements View$OnClickListener {
    public ProfileIdentityRepairDialog$$ExternalSyntheticLambda4(ProfileIdentityRepairDialog arg1, AlertDialog arg2, IdRepairPlan arg3, String arg4) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
        this.f$2 = arg3;
        this.f$3 = arg4;
    }

    public final void onClick(View arg4) {
        ProfileIdentityRepairDialog.showResult$lambda$6(this.f$0, this.f$1, this.f$2, this.f$3, arg4);
    }
}

