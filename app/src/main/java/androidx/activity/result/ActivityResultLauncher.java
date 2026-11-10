package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u001F\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00028\u00002\b\u0010\t\u001A\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u000BJ\b\u0010\f\u001A\u00020\u0006H\'R\u001C\u0010\r\u001A\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u000EX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2={"Landroidx/activity/result/ActivityResultLauncher;", "I", "", "<init>", "()V", "launch", "", "input", "(Ljava/lang/Object;)V", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "unregister", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "getContract", "()Landroidx/activity/result/contract/ActivityResultContract;", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class ActivityResultLauncher {
    public ActivityResultLauncher() {
        super();
    }

    public abstract ActivityResultContract getContract();

    public abstract void launch(Object arg1, ActivityOptionsCompat arg2);

    public void launch(Object arg2) {
        this.launch(arg2, null);
    }

    public abstract void unregister();
}

