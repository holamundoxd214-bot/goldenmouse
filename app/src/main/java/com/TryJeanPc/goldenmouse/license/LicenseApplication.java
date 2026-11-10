package com.TryJeanPc.goldenmouse.license;

import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public final class LicenseApplication extends Application {
    public LicenseApplication() {
        super();
    }

    public void onCreate() {
        super.onCreate();
        LicenseManager.initialize(((Context)this));
        this.registerActivityLifecycleCallbacks(new Application$ActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity arg1, Bundle arg2) {
            }

            public void onActivityDestroyed(Activity arg1) {
            }

            public void onActivityPaused(Activity arg1) {
            }

            public void onActivityResumed(Activity arg2) {
                if(!(arg2 instanceof LicenseActivity) && !LicenseManager.isAuthorized()) {
                    arg2.startActivity(new Intent(((Context)arg2), LicenseActivity.class).addFlags(0x20020000));
                }
            }

            public void onActivitySaveInstanceState(Activity arg1, Bundle arg2) {
            }

            public void onActivityStarted(Activity arg1) {
            }

            public void onActivityStopped(Activity arg1) {
            }
        });
    }
}

