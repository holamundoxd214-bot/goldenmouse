package androidx.window.embedding;

import android.app.Activity;
import android.os.IBinder;
import androidx.window.WindowSdkExtensions;
import androidx.window.extensions.embedding.SplitInfo$Token;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\u0018\u00002\u00020\u0001B5\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\b\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u000B\u0010\fB)\b\u0011\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\rB)\b\u0011\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\u000EB!\b\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u000B\u0010\u000FJ\r\u0010\u0017\u001A\u00020\bH\u0001¢\u0006\u0002\b\u0018J\r\u0010\u0019\u001A\u00020\nH\u0001¢\u0006\u0002\b\u001AJ\u0011\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001EH\u0086\u0002J\u0013\u0010\u001F\u001A\u00020\u001C2\b\u0010 \u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010!\u001A\u00020\"H\u0016J\b\u0010#\u001A\u00020$H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0007\u001A\u0004\u0018\u00010\b8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0016R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"Landroidx/window/embedding/SplitInfo;", "", "primaryActivityStack", "Landroidx/window/embedding/ActivityStack;", "secondaryActivityStack", "splitAttributes", "Landroidx/window/embedding/SplitAttributes;", "binder", "Landroid/os/IBinder;", "token", "Landroidx/window/extensions/embedding/SplitInfo$Token;", "<init>", "(Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/SplitAttributes;Landroid/os/IBinder;Landroidx/window/extensions/embedding/SplitInfo$Token;)V", "(Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/SplitAttributes;Landroidx/window/extensions/embedding/SplitInfo$Token;)V", "(Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/SplitAttributes;Landroid/os/IBinder;)V", "(Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/SplitAttributes;)V", "getPrimaryActivityStack", "()Landroidx/window/embedding/ActivityStack;", "getSecondaryActivityStack", "getSplitAttributes", "()Landroidx/window/embedding/SplitAttributes;", "getBinder$annotations", "()V", "getBinder", "getBinder$window_release", "getToken", "getToken$window_release", "contains", "", "activity", "Landroid/app/Activity;", "equals", "other", "hashCode", "", "toString", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitInfo {
    private final IBinder binder;
    private final ActivityStack primaryActivityStack;
    private final ActivityStack secondaryActivityStack;
    private final SplitAttributes splitAttributes;
    private final SplitInfo$Token token;

    public SplitInfo(ActivityStack arg8, ActivityStack arg9, SplitAttributes arg10, SplitInfo$Token arg11) {
        Intrinsics.checkNotNullParameter(arg8, "primaryActivityStack");
        Intrinsics.checkNotNullParameter(arg9, "secondaryActivityStack");
        Intrinsics.checkNotNullParameter(arg10, "splitAttributes");
        Intrinsics.checkNotNullParameter(arg11, "token");
        this(arg8, arg9, arg10, null, arg11);
    }

    public SplitInfo(ActivityStack arg8, ActivityStack arg9, SplitAttributes arg10) {
        Intrinsics.checkNotNullParameter(arg8, "primaryActivityStack");
        Intrinsics.checkNotNullParameter(arg9, "secondaryActivityStack");
        Intrinsics.checkNotNullParameter(arg10, "splitAttributes");
        this(arg8, arg9, arg10, null, null);
    }

    public SplitInfo(ActivityStack arg8, ActivityStack arg9, SplitAttributes arg10, IBinder arg11) {
        Intrinsics.checkNotNullParameter(arg8, "primaryActivityStack");
        Intrinsics.checkNotNullParameter(arg9, "secondaryActivityStack");
        Intrinsics.checkNotNullParameter(arg10, "splitAttributes");
        Intrinsics.checkNotNullParameter(arg11, "binder");
        this(arg8, arg9, arg10, arg11, null);
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(new IntRange(3, 4));
    }

    private SplitInfo(ActivityStack arg1, ActivityStack arg2, SplitAttributes arg3, IBinder arg4, SplitInfo$Token arg5) {
        super();
        this.primaryActivityStack = arg1;
        this.secondaryActivityStack = arg2;
        this.splitAttributes = arg3;
        this.binder = arg4;
        this.token = arg5;
    }

    public final boolean contains(Activity arg2) {
        Intrinsics.checkNotNullParameter(arg2, "activity");
        if(!this.primaryActivityStack.contains(arg2)) {
            if(this.secondaryActivityStack.contains(arg2)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean equals(Object arg5) {
        if(this == (((SplitInfo)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SplitInfo)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.primaryActivityStack, ((SplitInfo)arg5).primaryActivityStack)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.secondaryActivityStack, ((SplitInfo)arg5).secondaryActivityStack)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.splitAttributes, ((SplitInfo)arg5).splitAttributes)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.token, ((SplitInfo)arg5).token)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.binder, ((SplitInfo)arg5).binder)) {
            return 0;
        }

        return 1;
    }

    @Deprecated(message="Use [token] instead", replaceWith="<_subannotation>") private static void getBinder$annotations() {
    }

    public final IBinder getBinder$window_release() {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(new IntRange(3, 4));
        IBinder v4 = this.binder;
        if(v4 != null) {
            return v4;
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final ActivityStack getPrimaryActivityStack() {
        return this.primaryActivityStack;
    }

    public final ActivityStack getSecondaryActivityStack() {
        return this.secondaryActivityStack;
    }

    public final SplitAttributes getSplitAttributes() {
        return this.splitAttributes;
    }

    public final SplitInfo$Token getToken$window_release() {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        SplitInfo$Token v2 = this.token;
        if(v2 != null) {
            return v2;
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public int hashCode() {
        int v0 = ((this.primaryActivityStack.hashCode() * 0x1F + this.secondaryActivityStack.hashCode()) * 0x1F + this.splitAttributes.hashCode()) * 0x1F;
        SplitInfo$Token v1 = this.token;
        int v2 = 0;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        v0 = (v0 + v1_1) * 0x1F;
        IBinder v3 = this.binder;
        if(v3 != null) {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("SplitInfo:{");
        v0.append("primaryActivityStack=" + this.primaryActivityStack + ", ");
        v0.append("secondaryActivityStack=" + this.secondaryActivityStack + ", ");
        v0.append("splitAttributes=" + this.splitAttributes + ", ");
        if(this.token != null) {
            v0.append("token=" + this.token);
        }

        if(this.binder != null) {
            v0.append("binder=" + this.binder);
        }

        v0.append("}");
        String v4 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v4, "toString(...)");
        return v4;
    }
}

