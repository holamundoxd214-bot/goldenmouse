package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.os.BundleCompat;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.random.Random;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 92\u00020\u0001:\u0003789B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u0012\u001A\u00020\u0013\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u00152\u0006\u0010\u0016\u001A\u00020\u00062\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00150\u00182\u0006\u0010\u0019\u001A\u0002H\u00142\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BH\'¢\u0006\u0002\u0010\u001CJJ\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u00140\u001E\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u00152\u0006\u0010\u001F\u001A\u00020\u00072\u0006\u0010 \u001A\u00020!2\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00150\u00182\f\u0010\"\u001A\b\u0012\u0004\u0012\u0002H\u00150#JB\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u00140\u001E\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u00152\u0006\u0010\u001F\u001A\u00020\u00072\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00150\u00182\f\u0010\"\u001A\b\u0012\u0004\u0012\u0002H\u00150#J\u0015\u0010$\u001A\u00020\u00132\u0006\u0010\u001F\u001A\u00020\u0007H\u0001¢\u0006\u0002\b%J\u000E\u0010&\u001A\u00020\u00132\u0006\u0010\'\u001A\u00020\u0011J\u0010\u0010(\u001A\u00020\u00132\b\u0010)\u001A\u0004\u0018\u00010\u0011J\"\u0010*\u001A\u00020+2\u0006\u0010\u0016\u001A\u00020\u00062\u0006\u0010,\u001A\u00020\u00062\b\u0010-\u001A\u0004\u0018\u00010.H\u0007J#\u0010*\u001A\u00020+\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0016\u001A\u00020\u00062\u0006\u0010/\u001A\u0002H\u0015H\u0007¢\u0006\u0002\u00100J8\u00101\u001A\u00020\u0013\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u001F\u001A\u00020\u00072\u0006\u0010,\u001A\u00020\u00062\b\u0010-\u001A\u0004\u0018\u00010.2\u000E\u00102\u001A\n\u0012\u0004\u0012\u0002H\u0015\u0018\u00010\u000EH\u0002J\u0010\u00103\u001A\u00020\u00132\u0006\u0010\u001F\u001A\u00020\u0007H\u0002J\b\u00104\u001A\u00020\u0006H\u0002J\u0018\u00105\u001A\u00020\u00132\u0006\u00106\u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\u0007H\u0002R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00070\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010\r\u001A\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000E0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u000F\u001A\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2={"Landroidx/activity/result/ActivityResultRegistry;", "", "<init>", "()V", "rcToKey", "", "", "", "keyToRc", "keyToLifecycleContainers", "Landroidx/activity/result/ActivityResultRegistry$LifecycleContainer;", "launchedKeys", "", "keyToCallback", "Landroidx/activity/result/ActivityResultRegistry$CallbackAndContract;", "parsedPendingResults", "pendingResults", "Landroid/os/Bundle;", "onLaunch", "", "I", "O", "requestCode", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "input", "options", "Landroidx/core/app/ActivityOptionsCompat;", "(ILandroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/core/app/ActivityOptionsCompat;)V", "register", "Landroidx/activity/result/ActivityResultLauncher;", "key", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "callback", "Landroidx/activity/result/ActivityResultCallback;", "unregister", "unregister$activity", "onSaveInstanceState", "outState", "onRestoreInstanceState", "savedInstanceState", "dispatchResult", "", "resultCode", "data", "Landroid/content/Intent;", "result", "(ILjava/lang/Object;)Z", "doDispatch", "callbackAndContract", "registerKey", "generateRandomNumber", "bindRcKey", "rc", "CallbackAndContract", "LifecycleContainer", "Companion", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class ActivityResultRegistry {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\'\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\u0010\u0005\u001A\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001B\u0010\u0005\u001A\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Landroidx/activity/result/ActivityResultRegistry$CallbackAndContract;", "O", "", "callback", "Landroidx/activity/result/ActivityResultCallback;", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "<init>", "(Landroidx/activity/result/ActivityResultCallback;Landroidx/activity/result/contract/ActivityResultContract;)V", "getCallback", "()Landroidx/activity/result/ActivityResultCallback;", "getContract", "()Landroidx/activity/result/contract/ActivityResultContract;", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) final class CallbackAndContract {
        private final ActivityResultCallback callback;
        private final ActivityResultContract contract;

        public CallbackAndContract(ActivityResultCallback arg2, ActivityResultContract arg3) {
            Intrinsics.checkNotNullParameter(arg2, "callback");
            Intrinsics.checkNotNullParameter(arg3, "contract");
            super();
            this.callback = arg2;
            this.contract = arg3;
        }

        public final ActivityResultCallback getCallback() {
            return this.callback;
        }

        public final ActivityResultContract getContract() {
            return this.contract;
        }
    }

    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/activity/result/ActivityResultRegistry$Companion;", "", "<init>", "()V", "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", "", "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", "KEY_COMPONENT_ACTIVITY_PENDING_RESULTS", "LOG_TAG", "INITIAL_REQUEST_CODE_VALUE", "", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\nJ\u0006\u0010\u000E\u001A\u00020\fR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/activity/result/ActivityResultRegistry$LifecycleContainer;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "<init>", "(Landroidx/lifecycle/Lifecycle;)V", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "observers", "", "Landroidx/lifecycle/LifecycleEventObserver;", "addObserver", "", "observer", "clearObservers", "activity"}, k=1, mv={2, 1, 0}, xi=0x30) final class LifecycleContainer {
        private final Lifecycle lifecycle;
        private final List observers;

        public LifecycleContainer(Lifecycle arg2) {
            Intrinsics.checkNotNullParameter(arg2, "lifecycle");
            super();
            this.lifecycle = arg2;
            this.observers = new ArrayList();
        }

        public final void addObserver(LifecycleEventObserver arg3) {
            Intrinsics.checkNotNullParameter(arg3, "observer");
            this.lifecycle.addObserver(arg3);
            this.observers.add(arg3);
        }

        public final void clearObservers() {
            Iterator v0 = this.observers.iterator();
            while(v0.hasNext()) {
                this.lifecycle.removeObserver(v0.next());
            }

            this.observers.clear();
        }

        public final Lifecycle getLifecycle() {
            return this.lifecycle;
        }
    }

    private static final Companion Companion = null;
    private static final int INITIAL_REQUEST_CODE_VALUE = 0x10000;
    private static final String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final String LOG_TAG = "ActivityResultRegistry";
    private final transient Map keyToCallback;
    private final Map keyToLifecycleContainers;
    private final Map keyToRc;
    private final List launchedKeys;
    private final Map parsedPendingResults;
    private final Bundle pendingResults;
    private final Map rcToKey;

    static {
        ActivityResultRegistry.Companion = new Companion(null);
    }

    public ActivityResultRegistry() {
        super();
        this.rcToKey = new LinkedHashMap();
        this.keyToRc = new LinkedHashMap();
        this.keyToLifecycleContainers = new LinkedHashMap();
        this.launchedKeys = new ArrayList();
        this.keyToCallback = new LinkedHashMap();
        this.parsedPendingResults = new LinkedHashMap();
        this.pendingResults = new Bundle();
    }

    public static final Map access$getKeyToRc$p(ActivityResultRegistry arg0) {
        return arg0.keyToRc;
    }

    public static final List access$getLaunchedKeys$p(ActivityResultRegistry arg0) {
        return arg0.launchedKeys;
    }

    private final void bindRcKey(int arg3, String arg4) {
        this.rcToKey.put(Integer.valueOf(arg3), arg4);
        this.keyToRc.put(arg4, Integer.valueOf(arg3));
    }

    public final boolean dispatchResult(int arg2, int arg3, Intent arg4) {
        Object v2 = this.rcToKey.get(Integer.valueOf(arg2));
        if(v2 == null) {
            return 0;
        }

        this.doDispatch(((String)v2), arg3, arg4, this.keyToCallback.get(v2));
        return 1;
    }

    public final boolean dispatchResult(int arg3, Object arg4) {
        Object v3 = this.rcToKey.get(Integer.valueOf(arg3));
        if(v3 == null) {
            return 0;
        }

        Object v0 = this.keyToCallback.get(v3);
        ActivityResultCallback v1 = v0 != null ? ((CallbackAndContract)v0).getCallback() : null;
        if(v1 == null) {
            this.pendingResults.remove(((String)v3));
            this.parsedPendingResults.put(v3, arg4);
        }
        else {
            ActivityResultCallback v0_1 = ((CallbackAndContract)v0).getCallback();
            Intrinsics.checkNotNull(v0_1, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
            if(this.launchedKeys.remove(v3)) {
                v0_1.onActivityResult(arg4);
            }
        }

        return 1;
    }

    private final void doDispatch(String arg2, int arg3, Intent arg4, CallbackAndContract arg5) {
        ActivityResultCallback v0 = arg5 != null ? arg5.getCallback() : null;
        if(v0 != null && (this.launchedKeys.contains(arg2))) {
            arg5.getCallback().onActivityResult(arg5.getContract().parseResult(arg3, arg4));
            this.launchedKeys.remove(arg2);
            return;
        }

        this.parsedPendingResults.remove(arg2);
        this.pendingResults.putParcelable(arg2, new ActivityResult(arg3, arg4));
    }

    private final int generateRandomNumber() {
        Object v1;
        Iterator v0 = SequencesKt.generateSequence(new ActivityResultRegistry$$ExternalSyntheticLambda1()).iterator();
        do {
            if(!v0.hasNext()) {
                goto label_14;
            }

            v1 = v0.next();
        }
        while(this.rcToKey.containsKey(Integer.valueOf(((Number)v1).intValue())));

        return ((Number)v1).intValue();
    label_14:
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    static final Integer generateRandomNumber$lambda$0() {
        return Integer.valueOf(Random.Default.nextInt(0x7FFF0000) + 0x10000);
    }

    public abstract void onLaunch(int arg1, ActivityResultContract arg2, Object arg3, ActivityOptionsCompat arg4);

    public final void onRestoreInstanceState(Bundle arg7) {
        if(arg7 == null) {
        }
        else {
            ArrayList v0 = arg7.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList v1 = arg7.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if(v1 != null) {
                if(v0 == null) {
                }
                else {
                    ArrayList v2 = arg7.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    if(v2 != null) {
                        this.launchedKeys.addAll(((Collection)v2));
                    }

                    arg7 = arg7.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                    if(arg7 != null) {
                        this.pendingResults.putAll(arg7);
                    }

                    int v7 = v1.size();
                    int v2_1;
                    for(v2_1 = 0; v2_1 < v7; ++v2_1) {
                        Object v3 = v1.get(v2_1);
                        if(this.keyToRc.containsKey(v3)) {
                            Object v4 = this.keyToRc.remove(v3);
                            if(!this.pendingResults.containsKey(((String)v3))) {
                                TypeIntrinsics.asMutableMap(this.rcToKey).remove(v4);
                            }
                        }

                        v3 = v0.get(v2_1);
                        Intrinsics.checkNotNullExpressionValue(v3, "get(...)");
                        int v3_1 = ((Number)v3).intValue();
                        Object v5 = v1.get(v2_1);
                        Intrinsics.checkNotNullExpressionValue(v5, "get(...)");
                        this.bindRcKey(v3_1, ((String)v5));
                    }
                }
            }
        }
    }

    public final void onSaveInstanceState(Bundle arg3) {
        Intrinsics.checkNotNullParameter(arg3, "outState");
        arg3.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.keyToRc.values()));
        arg3.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.keyToRc.keySet()));
        arg3.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.launchedKeys));
        arg3.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(this.pendingResults));
    }

    public final ActivityResultLauncher register(String arg3, ActivityResultContract arg4, ActivityResultCallback arg5) {
        Object v0;
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.checkNotNullParameter(arg4, "contract");
        Intrinsics.checkNotNullParameter(arg5, "callback");
        this.registerKey(arg3);
        this.keyToCallback.put(arg3, new CallbackAndContract(arg5, arg4));
        if(this.parsedPendingResults.containsKey(arg3)) {
            v0 = this.parsedPendingResults.get(arg3);
            this.parsedPendingResults.remove(arg3);
            arg5.onActivityResult(v0);
        }

        v0 = BundleCompat.getParcelable(this.pendingResults, arg3, ActivityResult.class);
        if(v0 != null) {
            this.pendingResults.remove(arg3);
            arg5.onActivityResult(arg4.parseResult(((ActivityResult)v0).getResultCode(), ((ActivityResult)v0).getData()));
        }

        return new ActivityResultRegistry$register$3(this, arg3, arg4);
    }

    public final ActivityResultLauncher register(String arg4, LifecycleOwner arg5, ActivityResultContract arg6, ActivityResultCallback arg7) {
        Intrinsics.checkNotNullParameter(arg4, "key");
        Intrinsics.checkNotNullParameter(arg5, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(arg6, "contract");
        Intrinsics.checkNotNullParameter(arg7, "callback");
        Lifecycle v0 = arg5.getLifecycle();
        if(!v0.getCurrentState().isAtLeast(State.STARTED)) {
            this.registerKey(arg4);
            Object v5 = this.keyToLifecycleContainers.get(arg4);
            if(v5 == null) {
                LifecycleContainer v5_1 = new LifecycleContainer(v0);
            }

            ((LifecycleContainer)v5).addObserver(new ActivityResultRegistry$$ExternalSyntheticLambda0(this, arg4, arg7, arg6));
            this.keyToLifecycleContainers.put(arg4, v5);
            return new ActivityResultRegistry$register$2(this, arg4, arg6);
        }

        throw new IllegalStateException("LifecycleOwner " + arg5 + " is attempting to register while current state is " + v0.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.".toString());
    }

    static final void register$lambda$1(ActivityResultRegistry arg1, String arg2, ActivityResultCallback arg3, ActivityResultContract arg4, LifecycleOwner arg5, Event arg6) {
        Object v5;
        Intrinsics.checkNotNullParameter(arg5, "<unused var>");
        Intrinsics.checkNotNullParameter(arg6, "event");
        if(Event.ON_START == arg6) {
            arg1.keyToCallback.put(arg2, new CallbackAndContract(arg3, arg4));
            if(arg1.parsedPendingResults.containsKey(arg2)) {
                v5 = arg1.parsedPendingResults.get(arg2);
                arg1.parsedPendingResults.remove(arg2);
                arg3.onActivityResult(v5);
            }

            v5 = BundleCompat.getParcelable(arg1.pendingResults, arg2, ActivityResult.class);
            if(v5 == null) {
                return;
            }

            arg1.pendingResults.remove(arg2);
            arg3.onActivityResult(arg4.parseResult(((ActivityResult)v5).getResultCode(), ((ActivityResult)v5).getData()));
            return;
        }
        else {
            if(Event.ON_STOP == arg6) {
                arg1.keyToCallback.remove(arg2);
                return;
            }

            if(Event.ON_DESTROY != arg6) {
                return;
            }

            arg1.unregister$activity(arg2);
        }
    }

    private final void registerKey(String arg2) {
        if(this.keyToRc.get(arg2) != null) {
            return;
        }

        this.bindRcKey(this.generateRandomNumber(), arg2);
    }

    public final void unregister$activity(String arg6) {
        Object v0;
        Intrinsics.checkNotNullParameter(arg6, "key");
        if(!this.launchedKeys.contains(arg6)) {
            v0 = this.keyToRc.remove(arg6);
            if(v0 != null) {
                this.rcToKey.remove(v0);
            }
        }

        this.keyToCallback.remove(arg6);
        String v1 = ": ";
        String v2 = "Dropping pending result for request ";
        String v3 = "ActivityResultRegistry";
        if(this.parsedPendingResults.containsKey(arg6)) {
            Log.w(v3, v2 + arg6 + v1 + this.parsedPendingResults.get(arg6));
            this.parsedPendingResults.remove(arg6);
        }

        if(this.pendingResults.containsKey(arg6)) {
            Log.w(v3, v2 + arg6 + v1 + BundleCompat.getParcelable(this.pendingResults, arg6, ActivityResult.class));
            this.pendingResults.remove(arg6);
        }

        v0 = this.keyToLifecycleContainers.get(arg6);
        if(v0 != null) {
            ((LifecycleContainer)v0).clearObservers();
            this.keyToLifecycleContainers.remove(arg6);
        }
    }
}

