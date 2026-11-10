package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ActivityComponentInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB#\b\u0016\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\fJ\u0016\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0015J\u0016\u0010\u0017\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u0019J\b\u0010\u001A\u001A\u00020\u0006H\u0016J\u0013\u0010\u001B\u001A\u00020\u00132\b\u0010\u001C\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001D\u001A\u00020\u001EH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\t\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u000B\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0010¨\u0006\u001F"}, d2={"Landroidx/window/embedding/SplitPairFilter;", "", "_primaryActivityName", "Landroidx/window/core/ActivityComponentInfo;", "_secondaryActivityName", "secondaryActivityIntentAction", "", "<init>", "(Landroidx/window/core/ActivityComponentInfo;Landroidx/window/core/ActivityComponentInfo;Ljava/lang/String;)V", "primaryActivityName", "Landroid/content/ComponentName;", "secondaryActivityName", "(Landroid/content/ComponentName;Landroid/content/ComponentName;Ljava/lang/String;)V", "getSecondaryActivityIntentAction", "()Ljava/lang/String;", "getPrimaryActivityName", "()Landroid/content/ComponentName;", "getSecondaryActivityName", "matchesActivityPair", "", "primaryActivity", "Landroid/app/Activity;", "secondaryActivity", "matchesActivityIntentPair", "secondaryActivityIntent", "Landroid/content/Intent;", "toString", "equals", "other", "hashCode", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitPairFilter {
    private final ActivityComponentInfo _primaryActivityName;
    private final ActivityComponentInfo _secondaryActivityName;
    private final String secondaryActivityIntentAction;

    public SplitPairFilter(ComponentName arg2, ComponentName arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg2, "primaryActivityName");
        Intrinsics.checkNotNullParameter(arg3, "secondaryActivityName");
        this(new ActivityComponentInfo(arg2), new ActivityComponentInfo(arg3), arg4);
    }

    public SplitPairFilter(ActivityComponentInfo arg2, ActivityComponentInfo arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg2, "_primaryActivityName");
        Intrinsics.checkNotNullParameter(arg3, "_secondaryActivityName");
        super();
        this._primaryActivityName = arg2;
        this._secondaryActivityName = arg3;
        this.secondaryActivityIntentAction = arg4;
        MatcherUtils.INSTANCE.validateComponentName$window_release(arg2.getPackageName(), arg2.getClassName());
        MatcherUtils.INSTANCE.validateComponentName$window_release(arg3.getPackageName(), arg3.getClassName());
    }

    public boolean equals(Object arg5) {
        if(this == (((SplitPairFilter)arg5))) {
            return 1;
        }

        Class v1 = this.getClass();
        if(arg5 != null) {
            Class v2 = arg5.getClass();
        }
        else {
            Object v2_1 = null;
        }

        if(!Intrinsics.areEqual(v1, v2)) {
            return 0;
        }

        Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type androidx.window.embedding.SplitPairFilter");
        if(!Intrinsics.areEqual(this._primaryActivityName, ((SplitPairFilter)arg5)._primaryActivityName)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this._secondaryActivityName, ((SplitPairFilter)arg5)._secondaryActivityName)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.secondaryActivityIntentAction, ((SplitPairFilter)arg5).secondaryActivityIntentAction)) {
            return 0;
        }

        return 1;
    }

    public final ComponentName getPrimaryActivityName() {
        return new ComponentName(this._primaryActivityName.getPackageName(), this._primaryActivityName.getClassName());
    }

    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    public final ComponentName getSecondaryActivityName() {
        return new ComponentName(this._secondaryActivityName.getPackageName(), this._secondaryActivityName.getClassName());
    }

    public int hashCode() {
        int v0 = (this._primaryActivityName.hashCode() * 0x1F + this._secondaryActivityName.hashCode()) * 0x1F;
        String v2 = this.secondaryActivityIntentAction;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        return v0 + v2_1;
    }

    public final boolean matchesActivityIntentPair(Activity arg3, Intent arg4) {
        Intrinsics.checkNotNullParameter(arg3, "primaryActivity");
        Intrinsics.checkNotNullParameter(arg4, "secondaryActivityIntent");
        if(!MatcherUtils.INSTANCE.isActivityMatching$window_release(arg3, this._primaryActivityName)) {
            return 0;
        }

        if(!MatcherUtils.INSTANCE.isIntentMatching$window_release(arg4, this._secondaryActivityName)) {
            return 0;
        }

        String v2 = this.secondaryActivityIntentAction;
        if(v2 != null) {
            if(Intrinsics.areEqual(v2, arg4.getAction())) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean matchesActivityPair(Activity arg3, Activity arg4) {
        Intrinsics.checkNotNullParameter(arg3, "primaryActivity");
        Intrinsics.checkNotNullParameter(arg4, "secondaryActivity");
        if(!MatcherUtils.INSTANCE.isActivityMatching$window_release(arg3, this._primaryActivityName)) {
            return 0;
        }

        if(!MatcherUtils.INSTANCE.isActivityMatching$window_release(arg4, this._secondaryActivityName)) {
            return 0;
        }

        String v2 = this.secondaryActivityIntentAction;
        if(v2 != null) {
            Intent v3 = arg4.getIntent();
            if(v3 != null) {
                String v3_1 = v3.getAction();
            }
            else {
                Object v3_2 = null;
            }

            if(Intrinsics.areEqual(v2, v3_2)) {
                return 1;
            }

            return 0;
        }

        return 1;
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.getPrimaryActivityName() + ", secondaryActivityName=" + this.getSecondaryActivityName() + ", secondaryActivityAction=" + this.secondaryActivityIntentAction + '}';
    }
}

