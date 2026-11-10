package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001D\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\r\u001A\u00020\u0002H\u0096\u0082\u0004J\u0006\u0010\u000E\u001A\u00020\u0002J\u0016\u0010\u000F\u001A\u00020\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u0001H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000B\u001A\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0004\u0012\u00020\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Landroidx/activity/compose/ReportDrawnComposition;", "Lkotlin/Function0;", "", "fullyDrawnReporter", "Landroidx/activity/FullyDrawnReporter;", "predicate", "", "<init>", "(Landroidx/activity/FullyDrawnReporter;Lkotlin/jvm/functions/Function0;)V", "snapshotStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "checkReporter", "Lkotlin/Function1;", "invoke", "removeReporter", "observeReporter", "activity-compose"}, k=1, mv={2, 1, 0}, xi=0x30) final class ReportDrawnComposition implements Function0 {
    private final Function1 checkReporter;
    private final FullyDrawnReporter fullyDrawnReporter;
    private final Function0 predicate;
    private final SnapshotStateObserver snapshotStateObserver;

    public ReportDrawnComposition(FullyDrawnReporter arg3, Function0 arg4) {
        super();
        this.fullyDrawnReporter = arg3;
        this.predicate = arg4;
        SnapshotStateObserver v0 = new SnapshotStateObserver(new ReportDrawnComposition$$ExternalSyntheticLambda0());
        v0.start();
        this.snapshotStateObserver = v0;
        this.checkReporter = new ReportDrawnComposition$checkReporter$1(this);
        arg3.addOnReportDrawnListener(this);
        if(!arg3.isFullyDrawnReported()) {
            arg3.addReporter();
            this.observeReporter(arg4);
        }
    }

    public static final void access$observeReporter(ReportDrawnComposition arg0, Function0 arg1) {
        arg0.observeReporter(arg1);
    }

    public Object invoke() {
        this.invoke();
        return Unit.INSTANCE;
    }

    public void invoke() {
        this.snapshotStateObserver.clear();
        this.snapshotStateObserver.stop();
    }

    private final void observeReporter(Function0 arg5) {
        BooleanRef v0 = new BooleanRef();
        this.snapshotStateObserver.observeReads(arg5, this.checkReporter, new ReportDrawnComposition$$ExternalSyntheticLambda1(v0, arg5));
        if(v0.element) {
            this.removeReporter();
        }
    }

    static final Unit observeReporter$lambda$0(BooleanRef arg0, Function0 arg1) {
        arg0.element = arg1.invoke().booleanValue();
        return Unit.INSTANCE;
    }

    public final void removeReporter() {
        this.snapshotStateObserver.clear(this.predicate);
        if(!this.fullyDrawnReporter.isFullyDrawnReported()) {
            this.fullyDrawnReporter.removeReporter();
        }

        this.invoke();
    }

    static final Unit snapshotStateObserver$lambda$0(Function0 arg0) {
        arg0.invoke();
        return Unit.INSTANCE;
    }
}

