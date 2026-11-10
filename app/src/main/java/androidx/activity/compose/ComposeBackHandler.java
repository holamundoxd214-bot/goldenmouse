package androidx.activity.compose;

import androidx.activity.compose.internal.BackHandlerCompat;
import androidx.navigationevent.NavigationEventInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001A\u00020\bH\u0016R \u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\f¨\u0006\u000E"}, d2={"Landroidx/activity/compose/ComposeBackHandler;", "Landroidx/activity/compose/internal/BackHandlerCompat;", "info", "Landroidx/activity/compose/BackHandlerInfo;", "<init>", "(Landroidx/activity/compose/BackHandlerInfo;)V", "currentOnBackCompleted", "Lkotlin/Function0;", "", "getCurrentOnBackCompleted", "()Lkotlin/jvm/functions/Function0;", "setCurrentOnBackCompleted", "(Lkotlin/jvm/functions/Function0;)V", "onBackCompleted", "activity-compose"}, k=1, mv={2, 1, 0}, xi=0x30) final class ComposeBackHandler extends BackHandlerCompat {
    private Function0 currentOnBackCompleted;

    public ComposeBackHandler(BackHandlerInfo arg1) {
        super(((NavigationEventInfo)arg1));
        this.currentOnBackCompleted = new ComposeBackHandler$$ExternalSyntheticLambda0();
    }

    static final Unit currentOnBackCompleted$lambda$0() {
        return Unit.INSTANCE;
    }

    public final Function0 getCurrentOnBackCompleted() {
        return this.currentOnBackCompleted;
    }

    public void onBackCompleted() {
        this.currentOnBackCompleted.invoke();
    }

    public final void setCurrentOnBackCompleted(Function0 arg1) {
        this.currentOnBackCompleted = arg1;
    }
}

