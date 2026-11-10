package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ActivityComponentInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\tJ\u001D\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\b\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\rJ\u001D\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\b\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\u0011J\u0018\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0014H\u0002J\u001D\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u0014H\u0000¢\u0006\u0002\b\u001AR\u000E\u0010\u001B\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0014X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001D"}, d2={"Landroidx/window/embedding/MatcherUtils;", "", "<init>", "()V", "areComponentsMatching", "", "activityComponent", "Landroidx/window/core/ActivityComponentInfo;", "ruleComponent", "areComponentsMatching$window_release", "isActivityMatching", "activity", "Landroid/app/Activity;", "isActivityMatching$window_release", "isIntentMatching", "intent", "Landroid/content/Intent;", "isIntentMatching$window_release", "wildcardMatch", "name", "", "pattern", "validateComponentName", "", "packageName", "className", "validateComponentName$window_release", "sDebugMatchers", "sMatchersTag", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class MatcherUtils {
    public static final MatcherUtils INSTANCE = null;
    public static final boolean sDebugMatchers = false;
    public static final String sMatchersTag = "SplitRuleResolution";

    static {
        MatcherUtils.INSTANCE = new MatcherUtils();
    }

    private MatcherUtils() {
        super();
    }

    public final boolean areComponentsMatching$window_release(ActivityComponentInfo arg7, ActivityComponentInfo arg8) {
        Intrinsics.checkNotNullParameter(arg8, "ruleComponent");
        String v0 = "*";
        if(arg7 == null) {
            if((Intrinsics.areEqual(arg8.getPackageName(), v0)) && (Intrinsics.areEqual(arg8.getClassName(), v0))) {
                return 1;
            }

            return 0;
        }

        if(!StringsKt.contains$default(arg7.toString(), ((CharSequence)v0), false, 2, null)) {
            int v0_1 = (Intrinsics.areEqual(arg7.getPackageName(), arg8.getPackageName())) || (this.wildcardMatch(arg7.getPackageName(), arg8.getPackageName())) ? 1 : 0;
            int v6 = (Intrinsics.areEqual(arg7.getClassName(), arg8.getClassName())) || (this.wildcardMatch(arg7.getClassName(), arg8.getClassName())) ? 1 : 0;
            if(v0_1 != 0 && v6 != 0) {
                return 1;
            }

            return 0;
        }

        throw new IllegalArgumentException("Wildcard can only be part of the rule.".toString());
    }

    public final boolean isActivityMatching$window_release(Activity arg4, ActivityComponentInfo arg5) {
        Intrinsics.checkNotNullParameter(arg4, "activity");
        Intrinsics.checkNotNullParameter(arg5, "ruleComponent");
        ComponentName v1 = arg4.getComponentName();
        Intrinsics.checkNotNullExpressionValue(v1, "getComponentName(...)");
        if(this.areComponentsMatching$window_release(new ActivityComponentInfo(v1), arg5)) {
            return 1;
        }

        Intent v3 = arg4.getIntent();
        if(v3 != null) {
            return MatcherUtils.INSTANCE.isIntentMatching$window_release(v3, arg5);
        }

        return 0;
    }

    public final boolean isIntentMatching$window_release(Intent arg4, ActivityComponentInfo arg5) {
        Intrinsics.checkNotNullParameter(arg4, "intent");
        Intrinsics.checkNotNullParameter(arg5, "ruleComponent");
        ComponentName v0 = arg4.getComponent();
        ActivityComponentInfo v1 = v0 != null ? new ActivityComponentInfo(v0) : null;
        if(this.areComponentsMatching$window_release(v1, arg5)) {
            return 1;
        }

        if(arg4.getComponent() != null) {
            return 0;
        }

        String v4 = arg4.getPackage();
        if(v4 == null) {
            return 0;
        }

        if(((Intrinsics.areEqual(v4, arg5.getPackageName())) || (this.wildcardMatch(v4, arg5.getPackageName()))) && (Intrinsics.areEqual(arg5.getClassName(), "*"))) {
            return 1;
        }

        return 0;
    }

    public final void validateComponentName$window_release(String arg11, String arg12) {
        Intrinsics.checkNotNullParameter(arg11, "packageName");
        Intrinsics.checkNotNullParameter(arg12, "className");
        String v0 = arg11;
        if(((CharSequence)v0).length() > 0) {
            String v10 = arg12;
            if(((CharSequence)v10).length() > 0) {
                String v6 = "*";
                int v8 = 2;
                Object v9 = null;
                if(StringsKt.contains$default(((CharSequence)v0), v6, false, v8, v9)) {
                    if(StringsKt.indexOf$default(((CharSequence)v0), "*", 0, false, 6, null) == arg11.length() - 1) {
                    }
                    else {
                        throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
                    }
                }

                if(StringsKt.contains$default(((CharSequence)v10), ((CharSequence)v6), false, v8, v9)) {
                    if(StringsKt.indexOf$default(v10, "*", 0, false, 6, null) == arg12.length() - 1) {
                    }
                    else {
                        throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
                    }
                }

                return;
            }

            throw new IllegalArgumentException("Activity class name must not be empty".toString());
        }

        throw new IllegalArgumentException("Package name must not be empty".toString());
    }

    private final boolean wildcardMatch(String arg12, String arg13) {
        String v0 = arg13;
        String v11 = "*";
        int v7 = 2;
        Object v8 = null;
        if(!StringsKt.contains$default(((CharSequence)v0), v11, false, v7, v8)) {
            return 0;
        }

        if(Intrinsics.areEqual(arg13, v11)) {
            return 1;
        }

        if(StringsKt.indexOf$default(((CharSequence)v0), "*", 0, false, 6, null) == StringsKt.lastIndexOf$default(((CharSequence)v0), "*", 0, false, 6, null) && (StringsKt.endsWith$default(arg13, v11, false, v7, v8))) {
            v11 = arg13.substring(0, arg13.length() - 1);
            Intrinsics.checkNotNullExpressionValue(v11, "substring(...)");
            return StringsKt.startsWith$default(arg12, v11, false, v7, v8);
        }

        throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end".toString());
    }
}

