package androidx.lifecycle;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001A\u0002H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u0003H\u0016¢\u0006\u0002\u0010\bR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Landroidx/lifecycle/AndroidViewModel;", "Landroidx/lifecycle/ViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "getApplication", "T", "()Landroid/app/Application;", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public class AndroidViewModel extends ViewModel {
    private final Application application;

    public AndroidViewModel(Application arg2) {
        Intrinsics.checkNotNullParameter(arg2, "application");
        super();
        this.application = arg2;
    }

    public Application getApplication() {
        Application v1 = this.application;
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return v1;
    }
}

