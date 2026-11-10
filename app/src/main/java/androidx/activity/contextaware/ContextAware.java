package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001A\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2={"Landroidx/activity/contextaware/ContextAware;", "", "peekAvailableContext", "Landroid/content/Context;", "addOnContextAvailableListener", "", "listener", "Landroidx/activity/contextaware/OnContextAvailableListener;", "removeOnContextAvailableListener", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public interface ContextAware {
    void addOnContextAvailableListener(OnContextAvailableListener arg1);

    Context peekAvailableContext();

    void removeOnContextAvailableListener(OnContextAvailableListener arg1);
}

