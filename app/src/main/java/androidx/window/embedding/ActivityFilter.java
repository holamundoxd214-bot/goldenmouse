package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ActivityComponentInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001B\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001B\b\u0016\u0012\u0006\u0010\b\u001A\u00020\t\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\nJ\u000E\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012J\u000E\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u0015J\u0013\u0010\u0018\u001A\u00020\u00102\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0016J\b\u0010\u001C\u001A\u00020\u0005H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u001D"}, d2={"Landroidx/window/embedding/ActivityFilter;", "", "activityComponentInfo", "Landroidx/window/core/ActivityComponentInfo;", "intentAction", "", "<init>", "(Landroidx/window/core/ActivityComponentInfo;Ljava/lang/String;)V", "componentName", "Landroid/content/ComponentName;", "(Landroid/content/ComponentName;Ljava/lang/String;)V", "getActivityComponentInfo$window_release", "()Landroidx/window/core/ActivityComponentInfo;", "getIntentAction", "()Ljava/lang/String;", "matchesIntent", "", "intent", "Landroid/content/Intent;", "matchesActivity", "activity", "Landroid/app/Activity;", "getComponentName", "()Landroid/content/ComponentName;", "equals", "other", "hashCode", "", "toString", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ActivityFilter {
    private final ActivityComponentInfo activityComponentInfo;
    private final String intentAction;

    public ActivityFilter(ComponentName arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "componentName");
        this(new ActivityComponentInfo(arg2), arg3);
    }

    public ActivityFilter(ActivityComponentInfo arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "activityComponentInfo");
        super();
        this.activityComponentInfo = arg2;
        this.intentAction = arg3;
        MatcherUtils.INSTANCE.validateComponentName$window_release(arg2.getPackageName(), arg2.getClassName());
    }

    public boolean equals(Object arg5) {
        if(this == (((ActivityFilter)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ActivityFilter)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.activityComponentInfo, ((ActivityFilter)arg5).activityComponentInfo)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.intentAction, ((ActivityFilter)arg5).intentAction)) {
            return 0;
        }

        return 1;
    }

    public final ActivityComponentInfo getActivityComponentInfo$window_release() {
        return this.activityComponentInfo;
    }

    public final ComponentName getComponentName() {
        return new ComponentName(this.activityComponentInfo.getPackageName(), this.activityComponentInfo.getClassName());
    }

    public final String getIntentAction() {
        return this.intentAction;
    }

    public int hashCode() {
        int v0 = this.activityComponentInfo.hashCode() * 0x1F;
        String v1 = this.intentAction;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return v0 + v1_1;
    }

    public final boolean matchesActivity(Activity arg3) {
        Intrinsics.checkNotNullParameter(arg3, "activity");
        if(MatcherUtils.INSTANCE.isActivityMatching$window_release(arg3, this.activityComponentInfo)) {
            String v2 = this.intentAction;
            if(v2 != null) {
                Intent v3 = arg3.getIntent();
                if(v3 != null) {
                    String v3_1 = v3.getAction();
                }
                else {
                    Object v3_2 = null;
                }

                if(!Intrinsics.areEqual(v2, v3_1)) {
                    return 0;
                }
            }

            return 1;
        }

        return 0;
    }

    public final boolean matchesIntent(Intent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "intent");
        if(!MatcherUtils.INSTANCE.isIntentMatching$window_release(arg3, this.activityComponentInfo)) {
            return 0;
        }

        String v2 = this.intentAction;
        if(v2 != null) {
            if(Intrinsics.areEqual(v2, arg3.getAction())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public String toString() {
        return "ActivityFilter(componentName=" + this.activityComponentInfo + ", intentAction=" + this.intentAction + ')';
    }
}

