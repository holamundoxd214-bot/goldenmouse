package androidx.lifecycle;

import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build$VERSION;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00192\u00020\u0001:\u0003\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\t\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\n\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u000B\u001A\u00020\u00072\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0016J\b\u0010\u000E\u001A\u00020\u0007H\u0016J\b\u0010\u000F\u001A\u00020\u0007H\u0016J\b\u0010\u0010\u001A\u00020\u0007H\u0016J\b\u0010\u0011\u001A\u00020\u0007H\u0016J\b\u0010\u0012\u001A\u00020\u0007H\u0016J\u0010\u0010\u0013\u001A\u00020\u00072\u0006\u0010\u0014\u001A\u00020\u0015H\u0002J\u0010\u0010\u0016\u001A\u00020\u00072\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/lifecycle/ReportFragment;", "Landroid/app/Fragment;", "<init>", "()V", "processListener", "Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "dispatchCreate", "", "listener", "dispatchStart", "dispatchResume", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onResume", "onPause", "onStop", "onDestroy", "dispatch", "event", "Landroidx/lifecycle/Lifecycle$Event;", "setProcessListener", "ActivityInitializationListener", "LifecycleCallbacks", "Companion", "lifecycle-runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public class ReportFragment extends Fragment {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\b\u0010\u0004\u001A\u00020\u0003H&J\b\u0010\u0005\u001A\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2={"Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "", "onCreate", "", "onStart", "onResume", "lifecycle-runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    @Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007J\u001D\u0010\n\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\fH\u0001¢\u0006\u0002\b\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001E\u0010\u000E\u001A\u00020\u000F*\u00020\t8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2={"Landroidx/lifecycle/ReportFragment$Companion;", "", "<init>", "()V", "REPORT_FRAGMENT_TAG", "", "injectIfNeededIn", "", "activity", "Landroid/app/Activity;", "dispatch", "event", "Landroidx/lifecycle/Lifecycle$Event;", "dispatch$lifecycle_runtime", "reportFragment", "Landroidx/lifecycle/ReportFragment;", "get$annotations", "(Landroid/app/Activity;)V", "get", "(Landroid/app/Activity;)Landroidx/lifecycle/ReportFragment;", "lifecycle-runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final void dispatch$lifecycle_runtime(Activity arg1, Event arg2) {
            Intrinsics.checkNotNullParameter(arg1, "activity");
            Intrinsics.checkNotNullParameter(arg2, "event");
            if((arg1 instanceof LifecycleRegistryOwner)) {
                ((LifecycleRegistryOwner)arg1).getLifecycle().handleLifecycleEvent(arg2);
                return;
            }

            if((arg1 instanceof LifecycleOwner)) {
                Lifecycle v0 = ((LifecycleOwner)arg1).getLifecycle();
                if((v0 instanceof LifecycleRegistry)) {
                    ((LifecycleRegistry)v0).handleLifecycleEvent(arg2);
                }
            }
        }

        public final ReportFragment get(Activity arg1) {
            Intrinsics.checkNotNullParameter(arg1, "<this>");
            Fragment v0 = arg1.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return ((ReportFragment)v0);
        }

        @JvmStatic public static void get$annotations(Activity arg0) {
        }

        @JvmStatic public final void injectIfNeededIn(Activity arg3) {
            Intrinsics.checkNotNullParameter(arg3, "activity");
            if(Build$VERSION.SDK_INT >= 29) {
                LifecycleCallbacks.Companion.registerIn(arg3);
            }

            FragmentManager v2 = arg3.getFragmentManager();
            String v3 = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
            if(v2.findFragmentByTag(v3) == null) {
                v2.beginTransaction().add(new ReportFragment(), v3).commit();
                v2.executePendingTransactions();
            }
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0016J\u001A\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\u000B\u001A\u0004\u0018\u00010\tH\u0016J\u0010\u0010\f\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\r\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0018\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0016J\u0010\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016¨\u0006\u0018"}, d2={"Landroidx/lifecycle/ReportFragment$LifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "onActivityPostCreated", "savedInstanceState", "onActivityStarted", "onActivityPostStarted", "onActivityResumed", "onActivityPostResumed", "onActivityPrePaused", "onActivityPaused", "onActivityPreStopped", "onActivityStopped", "onActivitySaveInstanceState", "onActivityPreDestroyed", "onActivityDestroyed", "Companion", "lifecycle-runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LifecycleCallbacks implements Application$ActivityLifecycleCallbacks {
        @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\b"}, d2={"Landroidx/lifecycle/ReportFragment$LifecycleCallbacks$Companion;", "", "<init>", "()V", "registerIn", "", "activity", "Landroid/app/Activity;", "lifecycle-runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class androidx.lifecycle.ReportFragment$LifecycleCallbacks$Companion {
            public androidx.lifecycle.ReportFragment$LifecycleCallbacks$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.lifecycle.ReportFragment$LifecycleCallbacks$Companion() {
                super();
            }

            @JvmStatic public final void registerIn(Activity arg1) {
                Intrinsics.checkNotNullParameter(arg1, "activity");
                arg1.registerActivityLifecycleCallbacks(new LifecycleCallbacks());
            }
        }

        public static final androidx.lifecycle.ReportFragment$LifecycleCallbacks$Companion Companion;

        static {
            LifecycleCallbacks.Companion = new androidx.lifecycle.ReportFragment$LifecycleCallbacks$Companion(null);
        }

        public LifecycleCallbacks() {
            super();
        }

        public void onActivityCreated(Activity arg1, Bundle arg2) {
            Intrinsics.checkNotNullParameter(arg1, "activity");
        }

        public void onActivityDestroyed(Activity arg1) {
            Intrinsics.checkNotNullParameter(arg1, "activity");
        }

        public void onActivityPaused(Activity arg1) {
            Intrinsics.checkNotNullParameter(arg1, "activity");
        }

        public void onActivityPostCreated(Activity arg1, Bundle arg2) {
            Intrinsics.checkNotNullParameter(arg1, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime(arg1, Event.ON_CREATE);
        }

        public void onActivityPostResumed(Activity arg2) {
            Intrinsics.checkNotNullParameter(arg2, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime(arg2, Event.ON_RESUME);
        }

        public void onActivityPostStarted(Activity arg2) {
            Intrinsics.checkNotNullParameter(arg2, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime(arg2, Event.ON_START);
        }

        public void onActivityPreDestroyed(Activity arg2) {
            Intrinsics.checkNotNullParameter(arg2, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime(arg2, Event.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity arg2) {
            Intrinsics.checkNotNullParameter(arg2, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime(arg2, Event.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity arg2) {
            Intrinsics.checkNotNullParameter(arg2, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime(arg2, Event.ON_STOP);
        }

        public void onActivityResumed(Activity arg1) {
            Intrinsics.checkNotNullParameter(arg1, "activity");
        }

        public void onActivitySaveInstanceState(Activity arg1, Bundle arg2) {
            Intrinsics.checkNotNullParameter(arg1, "activity");
            Intrinsics.checkNotNullParameter(arg2, "bundle");
        }

        public void onActivityStarted(Activity arg1) {
            Intrinsics.checkNotNullParameter(arg1, "activity");
        }

        public void onActivityStopped(Activity arg1) {
            Intrinsics.checkNotNullParameter(arg1, "activity");
        }

        @JvmStatic public static final void registerIn(Activity arg1) {
            LifecycleCallbacks.Companion.registerIn(arg1);
        }
    }

    public static final Companion Companion = null;
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private ActivityInitializationListener processListener;

    static {
        ReportFragment.Companion = new Companion(null);
    }

    public ReportFragment() {
        super();
    }

    private final void dispatch(Event arg3) {
        if(Build$VERSION.SDK_INT < 29) {
            Companion v0 = ReportFragment.Companion;
            Activity v2 = this.getActivity();
            Intrinsics.checkNotNullExpressionValue(v2, "getActivity(...)");
            v0.dispatch$lifecycle_runtime(v2, arg3);
        }
    }

    @JvmStatic public static final void dispatch$lifecycle_runtime(Activity arg1, Event arg2) {
        ReportFragment.Companion.dispatch$lifecycle_runtime(arg1, arg2);
    }

    private final void dispatchCreate(ActivityInitializationListener arg1) {
        if(arg1 != null) {
            arg1.onCreate();
        }
    }

    private final void dispatchResume(ActivityInitializationListener arg1) {
        if(arg1 != null) {
            arg1.onResume();
        }
    }

    private final void dispatchStart(ActivityInitializationListener arg1) {
        if(arg1 != null) {
            arg1.onStart();
        }
    }

    public static final ReportFragment get(Activity arg1) {
        return ReportFragment.Companion.get(arg1);
    }

    @JvmStatic public static final void injectIfNeededIn(Activity arg1) {
        ReportFragment.Companion.injectIfNeededIn(arg1);
    }

    public void onActivityCreated(Bundle arg1) {
        super.onActivityCreated(arg1);
        this.dispatchCreate(this.processListener);
        this.dispatch(Event.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        this.dispatch(Event.ON_DESTROY);
        this.processListener = null;
    }

    public void onPause() {
        super.onPause();
        this.dispatch(Event.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        this.dispatchResume(this.processListener);
        this.dispatch(Event.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        this.dispatchStart(this.processListener);
        this.dispatch(Event.ON_START);
    }

    public void onStop() {
        super.onStop();
        this.dispatch(Event.ON_STOP);
    }

    public final void setProcessListener(ActivityInitializationListener arg1) {
        this.processListener = arg1;
    }
}

