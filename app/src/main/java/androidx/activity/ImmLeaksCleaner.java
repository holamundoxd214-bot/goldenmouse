package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000F2\u00020\u0001:\u0004\f\r\u000E\u000FB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2={"Landroidx/activity/ImmLeaksCleaner;", "Landroidx/lifecycle/LifecycleEventObserver;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "Cleaner", "FailedInitialization", "ValidCleaner", "Companion"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ImmLeaksCleaner implements LifecycleEventObserver {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\f\u001A\u00020\r*\u00020\u0005H&R\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u0001*\u00020\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001A\u0004\u0018\u00010\t*\u00020\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B\u0082\u0001\u0002\u000E\u000F¨\u0006\u0010"}, d2={"Landroidx/activity/ImmLeaksCleaner$Cleaner;", "", "<init>", "()V", "lock", "Landroid/view/inputmethod/InputMethodManager;", "getLock", "(Landroid/view/inputmethod/InputMethodManager;)Ljava/lang/Object;", "servedView", "Landroid/view/View;", "getServedView", "(Landroid/view/inputmethod/InputMethodManager;)Landroid/view/View;", "clearNextServedView", "", "Landroidx/activity/ImmLeaksCleaner$FailedInitialization;", "Landroidx/activity/ImmLeaksCleaner$ValidCleaner;", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class Cleaner {
        private Cleaner() {
            super();
        }

        public Cleaner(DefaultConstructorMarker arg1) {
            this();
        }

        public abstract boolean clearNextServedView(InputMethodManager arg1);

        public abstract Object getLock(InputMethodManager arg1);

        public abstract View getServedView(InputMethodManager arg1);
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\u0004\u001A\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2={"Landroidx/activity/ImmLeaksCleaner$Companion;", "", "<init>", "()V", "cleaner", "Landroidx/activity/ImmLeaksCleaner$Cleaner;", "getCleaner", "()Landroidx/activity/ImmLeaksCleaner$Cleaner;", "cleaner$delegate", "Lkotlin/Lazy;", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Cleaner getCleaner() {
            return ImmLeaksCleaner.cleaner$delegate.getValue();
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\r\u001A\u00020\u000E*\u00020\u0006H\u0016R\u001A\u0010\u0004\u001A\u0004\u0018\u00010\u0005*\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u0004\u0018\u00010\n*\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u000F"}, d2={"Landroidx/activity/ImmLeaksCleaner$FailedInitialization;", "Landroidx/activity/ImmLeaksCleaner$Cleaner;", "<init>", "()V", "lock", "", "Landroid/view/inputmethod/InputMethodManager;", "getLock", "(Landroid/view/inputmethod/InputMethodManager;)Ljava/lang/Object;", "servedView", "Landroid/view/View;", "getServedView", "(Landroid/view/inputmethod/InputMethodManager;)Landroid/view/View;", "clearNextServedView", "", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class FailedInitialization extends Cleaner {
        public static final FailedInitialization INSTANCE;

        static {
            FailedInitialization.INSTANCE = new FailedInitialization();
        }

        private FailedInitialization() {
            super(null);
        }

        public boolean clearNextServedView(InputMethodManager arg1) {
            Intrinsics.checkNotNullParameter(arg1, "<this>");
            return 0;
        }

        public Object getLock(InputMethodManager arg1) {
            Intrinsics.checkNotNullParameter(arg1, "<this>");
            return null;
        }

        public View getServedView(InputMethodManager arg1) {
            Intrinsics.checkNotNullParameter(arg1, "<this>");
            return null;
        }
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u0011\u001A\u00020\u0012*\u00020\nH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u0004\u0018\u00010\t*\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\r\u001A\u0004\u0018\u00010\u000E*\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0013"}, d2={"Landroidx/activity/ImmLeaksCleaner$ValidCleaner;", "Landroidx/activity/ImmLeaksCleaner$Cleaner;", "hField", "Ljava/lang/reflect/Field;", "servedViewField", "nextServedViewField", "<init>", "(Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;)V", "lock", "", "Landroid/view/inputmethod/InputMethodManager;", "getLock", "(Landroid/view/inputmethod/InputMethodManager;)Ljava/lang/Object;", "servedView", "Landroid/view/View;", "getServedView", "(Landroid/view/inputmethod/InputMethodManager;)Landroid/view/View;", "clearNextServedView", "", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ValidCleaner extends Cleaner {
        private final Field hField;
        private final Field nextServedViewField;
        private final Field servedViewField;

        public ValidCleaner(Field arg2, Field arg3, Field arg4) {
            Intrinsics.checkNotNullParameter(arg2, "hField");
            Intrinsics.checkNotNullParameter(arg3, "servedViewField");
            Intrinsics.checkNotNullParameter(arg4, "nextServedViewField");
            super(null);
            this.hField = arg2;
            this.servedViewField = arg3;
            this.nextServedViewField = arg4;
        }

        public boolean clearNextServedView(InputMethodManager arg2) {
            Intrinsics.checkNotNullParameter(arg2, "<this>");
            try {
                this.nextServedViewField.set(arg2, null);
                return 1;
            }
            catch(IllegalAccessException ) {
                return 0;
            }
        }

        public Object getLock(InputMethodManager arg2) {
            Intrinsics.checkNotNullParameter(arg2, "<this>");
            try {
                return this.hField.get(arg2);
            }
            catch(IllegalAccessException ) {
                return null;
            }
        }

        public View getServedView(InputMethodManager arg2) {
            Intrinsics.checkNotNullParameter(arg2, "<this>");
            try {
                return this.servedViewField.get(arg2);
            }
            catch(ClassCastException ) {
                return null;
            }
        }
    }

    public static final Companion Companion;
    private final Activity activity;
    private static final Lazy cleaner$delegate;

    static {
        ImmLeaksCleaner.Companion = new Companion(null);
        ImmLeaksCleaner.cleaner$delegate = LazyKt.lazy(new ImmLeaksCleaner$$ExternalSyntheticLambda0());
    }

    public ImmLeaksCleaner(Activity arg2) {
        Intrinsics.checkNotNullParameter(arg2, "activity");
        super();
        this.activity = arg2;
    }

    public static final Lazy access$getCleaner$delegate$cp() {
        return ImmLeaksCleaner.cleaner$delegate;
    }

    static final Cleaner cleaner_delegate$lambda$0() {
        try {
            Class v0 = InputMethodManager.class;
            Field v1 = v0.getDeclaredField("mServedView");
            v1.setAccessible(true);
            Field v3 = v0.getDeclaredField("mNextServedView");
            v3.setAccessible(true);
            Field v0_1 = v0.getDeclaredField("mH");
            v0_1.setAccessible(true);
            Intrinsics.checkNotNull(v0_1);
            Intrinsics.checkNotNull(v1);
            Intrinsics.checkNotNull(v3);
            return new ValidCleaner(v0_1, v1, v3);
        }
        catch(NoSuchFieldException ) {
            return FailedInitialization.INSTANCE;
        }
    }

    public void onStateChanged(LifecycleOwner arg2, Event arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "event");
        if(arg3 != Event.ON_DESTROY) {
        }
        else {
            Object v1 = this.activity.getSystemService("input_method");
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            Cleaner v2 = ImmLeaksCleaner.Companion.getCleaner();
            Object v3 = v2.getLock(((InputMethodManager)v1));
            if(v3 == null) {
            }
            else {
                __monitor_enter(v3);
                try {
                    View v0 = v2.getServedView(((InputMethodManager)v1));
                    if(v0 == null) {
                    }
                    else {
                        goto label_22;
                    }
                }
                catch(Throwable v1_1) {
                    goto label_32;
                }

                __monitor_exit(v3);
                return;
                try {
                label_22:
                    if(v0.isAttachedToWindow()) {
                    }
                    else {
                        goto label_26;
                    }
                }
                catch(Throwable v1_1) {
                    goto label_32;
                }

                __monitor_exit(v3);
                return;
                try {
                label_26:
                    boolean v2_1 = v2.clearNextServedView(((InputMethodManager)v1));
                }
                catch(Throwable v1_1) {
                label_32:
                    __monitor_exit(v3);
                    throw v1_1;
                }

                __monitor_exit(v3);
                if(v2_1) {
                    ((InputMethodManager)v1).isActive();
                }
            }
        }
    }
}

