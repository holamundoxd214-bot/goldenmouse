package androidx.window.core;

import android.content.ComponentName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\b\u0010\u0012\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000B¨\u0006\u0013"}, d2={"Landroidx/window/core/ActivityComponentInfo;", "", "packageName", "", "className", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "componentName", "Landroid/content/ComponentName;", "(Landroid/content/ComponentName;)V", "getPackageName", "()Ljava/lang/String;", "getClassName", "equals", "", "other", "hashCode", "", "toString", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ActivityComponentInfo {
    private final String className;
    private final String packageName;

    public ActivityComponentInfo(ComponentName arg3) {
        Intrinsics.checkNotNullParameter(arg3, "componentName");
        String v0 = arg3.getPackageName();
        Intrinsics.checkNotNullExpressionValue(v0, "getPackageName(...)");
        String v3 = arg3.getClassName();
        Intrinsics.checkNotNullExpressionValue(v3, "getClassName(...)");
        this(v0, v3);
    }

    public ActivityComponentInfo(String arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "packageName");
        Intrinsics.checkNotNullParameter(arg3, "className");
        super();
        this.packageName = arg2;
        this.className = arg3;
    }

    public boolean equals(Object arg5) {
        if(this == (((ActivityComponentInfo)arg5))) {
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

        Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type androidx.window.core.ActivityComponentInfo");
        if(!Intrinsics.areEqual(this.packageName, ((ActivityComponentInfo)arg5).packageName)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.className, ((ActivityComponentInfo)arg5).className)) {
            return 0;
        }

        return 1;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return this.packageName.hashCode() * 0x1F + this.className.hashCode();
    }

    public String toString() {
        return "ClassInfo { packageName: " + this.packageName + ", className: " + this.className + " }";
    }
}

