package androidx.lifecycle;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"application", "Landroid/app/Application;", "Landroidx/lifecycle/AndroidViewModel;", "getApplication", "(Landroidx/lifecycle/AndroidViewModel;)Landroid/app/Application;", "lifecycle-viewmodel"}, k=2, mv={2, 1, 0}, xi=0x30) public final class AndroidViewModel_androidKt {
    public static final Application getApplication(AndroidViewModel arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getApplication();
    }
}

