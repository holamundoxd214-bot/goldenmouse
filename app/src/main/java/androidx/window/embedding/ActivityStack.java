package androidx.window.embedding;

import android.app.Activity;
import androidx.window.WindowSdkExtensions;
import androidx.window.extensions.embedding.ActivityStack$Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B)\b\u0000\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u001F\b\u0017\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\u000BJ\r\u0010\u000F\u001A\u00020\bH\u0001¢\u0006\u0002\b\u0010J\u0011\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u0004H\u0086\u0002J\u0013\u0010\u0013\u001A\u00020\u00062\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0016H\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016R\u001A\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u000ER\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Landroidx/window/embedding/ActivityStack;", "", "activitiesInProcess", "", "Landroid/app/Activity;", "isEmpty", "", "token", "Landroidx/window/extensions/embedding/ActivityStack$Token;", "<init>", "(Ljava/util/List;ZLandroidx/window/extensions/embedding/ActivityStack$Token;)V", "(Ljava/util/List;Z)V", "getActivitiesInProcess$window_release", "()Ljava/util/List;", "()Z", "getToken", "getToken$window_release", "contains", "activity", "equals", "other", "hashCode", "", "toString", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ActivityStack {
    private final List activitiesInProcess;
    private final boolean isEmpty;
    private final ActivityStack$Token token;

    public ActivityStack(List arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "activitiesInProcess");
        this(arg2, arg3, null);
    }

    public ActivityStack(List arg2, boolean arg3, ActivityStack$Token arg4) {
        Intrinsics.checkNotNullParameter(arg2, "activitiesInProcess");
        super();
        this.activitiesInProcess = arg2;
        this.isEmpty = arg3;
        this.token = arg4;
    }

    public final boolean contains(Activity arg2) {
        Intrinsics.checkNotNullParameter(arg2, "activity");
        return this.activitiesInProcess.contains(arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((ActivityStack)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof ActivityStack)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.activitiesInProcess, ((ActivityStack)arg5).activitiesInProcess)) {
            return 0;
        }

        if(this.isEmpty != ((ActivityStack)arg5).isEmpty) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.token, ((ActivityStack)arg5).token)) {
            return 0;
        }

        return 1;
    }

    public final List getActivitiesInProcess$window_release() {
        return this.activitiesInProcess;
    }

    public final ActivityStack$Token getToken$window_release() {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        ActivityStack$Token v2 = this.token;
        Intrinsics.checkNotNull(v2);
        return v2;
    }

    public int hashCode() {
        int v0 = (this.activitiesInProcess.hashCode() * 0x1F + Boolean.hashCode(this.isEmpty)) * 0x1F;
        ActivityStack$Token v2 = this.token;
        int v2_1 = v2 != null ? v2.hashCode() : 0;
        return v0 + v2_1;
    }

    public final boolean isEmpty() {
        return this.isEmpty;
    }

    public String toString() {
        return "ActivityStack{activitiesInProcess=" + this.activitiesInProcess + ", isEmpty=" + this.isEmpty + ", token=" + this.token + '}';
    }
}

