package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.View;
import androidx.core.util.Pair;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ActivityOptionsCompat {
    class ActivityOptionsCompatImpl extends ActivityOptionsCompat {
        private final ActivityOptions mActivityOptions;

        ActivityOptionsCompatImpl(ActivityOptions arg1) {
            super();
            this.mActivityOptions = arg1;
        }

        public Rect getLaunchBounds() {
            return this.mActivityOptions.getLaunchBounds();
        }

        public int getLaunchDisplayId() {
            return this.mActivityOptions.getLaunchDisplayId();
        }

        public void requestUsageTimeReport(PendingIntent arg1) {
            this.mActivityOptions.requestUsageTimeReport(arg1);
        }

        public ActivityOptionsCompat setLaunchBounds(Rect arg2) {
            return new ActivityOptionsCompatImpl(this.mActivityOptions.setLaunchBounds(arg2));
        }

        public ActivityOptionsCompat setLaunchDisplayId(int arg2) {
            this.mActivityOptions.setLaunchDisplayId(arg2);
            return this;
        }

        public ActivityOptionsCompat setPendingIntentBackgroundActivityStartMode(int arg3) {
            if(Build$VERSION.SDK_INT >= 34) {
                this.mActivityOptions.setPendingIntentBackgroundActivityStartMode(arg3);
                return this;
            }

            if(Build$VERSION.SDK_INT >= 33) {
                boolean v3 = arg3 != 2 ? true : false;
                this.mActivityOptions.setPendingIntentBackgroundActivityLaunchAllowed(v3);
            }

            return this;
        }

        public ActivityOptionsCompat setShareIdentityEnabled(boolean arg3) {
            if(Build$VERSION.SDK_INT < 34) {
                return this;
            }

            return new ActivityOptionsCompatImpl(this.mActivityOptions.setShareIdentityEnabled(arg3));
        }

        public Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }

        public void update(ActivityOptionsCompat arg2) {
            if((arg2 instanceof ActivityOptionsCompatImpl)) {
                this.mActivityOptions.update(((ActivityOptionsCompatImpl)arg2).mActivityOptions);
            }
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface BackgroundActivityStartMode {
    }

    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    protected ActivityOptionsCompat() {
        super();
    }

    public Rect getLaunchBounds() {
        return null;
    }

    public int getLaunchDisplayId() {
        return -1;
    }

    public static ActivityOptionsCompat makeBasic() {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeBasic());
    }

    public static ActivityOptionsCompat makeClipRevealAnimation(View arg1, int arg2, int arg3, int arg4, int arg5) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeClipRevealAnimation(arg1, arg2, arg3, arg4, arg5));
    }

    public static ActivityOptionsCompat makeCustomAnimation(Context arg1, int arg2, int arg3) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeCustomAnimation(arg1, arg2, arg3));
    }

    public static ActivityOptionsCompat makeScaleUpAnimation(View arg1, int arg2, int arg3, int arg4, int arg5) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeScaleUpAnimation(arg1, arg2, arg3, arg4, arg5));
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity arg1, View arg2, String arg3) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(arg1, arg2, arg3));
    }

    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity arg4, Pair[] arg5) {
        android.util.Pair[] v0;
        if(arg5 != null) {
            v0 = new android.util.Pair[arg5.length];
            int v1;
            for(v1 = 0; v1 < arg5.length; ++v1) {
                v0[v1] = android.util.Pair.create(arg5[v1].first, arg5[v1].second);
            }
        }
        else {
            v0 = null;
        }

        return new ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(arg4, v0));
    }

    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeTaskLaunchBehind());
    }

    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View arg1, Bitmap arg2, int arg3, int arg4) {
        return new ActivityOptionsCompatImpl(ActivityOptions.makeThumbnailScaleUpAnimation(arg1, arg2, arg3, arg4));
    }

    public void requestUsageTimeReport(PendingIntent arg1) {
    }

    public ActivityOptionsCompat setLaunchBounds(Rect arg1) {
        return this;
    }

    public ActivityOptionsCompat setLaunchDisplayId(int arg1) {
        return this;
    }

    public ActivityOptionsCompat setPendingIntentBackgroundActivityStartMode(int arg1) {
        return this;
    }

    public ActivityOptionsCompat setShareIdentityEnabled(boolean arg1) {
        return this;
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(ActivityOptionsCompat arg1) {
    }
}

