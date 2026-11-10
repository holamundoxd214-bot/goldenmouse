package androidx.core.app;

import android.app.Activity;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window$Callback;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001*B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\tH\u0017J\u0012\u0010\u0011\u001A\u00020\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001A\u00020\u000F2\u0006\u0010\u0015\u001A\u00020\u0013H\u0015J\'\u0010\u0016\u001A\u0004\u0018\u0001H\u0017\"\b\b\u0000\u0010\u0017*\u00020\t2\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u00170\bH\u0017¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020!H\u0017J\u0010\u0010\"\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020!H\u0016J\u0010\u0010#\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020!H\u0016J\u001D\u0010$\u001A\u00020\u001F2\u000E\u0010%\u001A\n\u0012\u0004\u0012\u00020\'\u0018\u00010&H\u0004¢\u0006\u0002\u0010(J\u001D\u0010)\u001A\u00020\u001F2\u000E\u0010%\u001A\n\u0012\u0004\u0012\u00020\'\u0018\u00010&H\u0002¢\u0006\u0002\u0010(R(\u0010\u0006\u001A\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0005R\u0014\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0005R\u0014\u0010\u001A\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D¨\u0006+"}, d2={"Landroidx/core/app/ComponentActivity;", "Landroid/app/Activity;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/core/view/KeyEventDispatcher$Component;", "<init>", "()V", "extraDataMap", "Landroidx/collection/SimpleArrayMap;", "Ljava/lang/Class;", "Landroidx/core/app/ComponentActivity$ExtraData;", "getExtraDataMap$annotations", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry$annotations", "putExtraData", "", "extraData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "getExtraData", "T", "extraDataClass", "(Ljava/lang/Class;)Landroidx/core/app/ComponentActivity$ExtraData;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "superDispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "dispatchKeyShortcutEvent", "dispatchKeyEvent", "shouldDumpInternalState", "args", "", "", "([Ljava/lang/String;)Z", "shouldSkipDump", "ExtraData", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public class ComponentActivity extends Activity implements Component, LifecycleOwner {
    @Deprecated(message="Store the object you want to save directly by using\n      {@link View#setTag(int, Object)} with the window\'s decor view.") @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/core/app/ComponentActivity$ExtraData;", "", "<init>", "()V", "core"}, k=1, mv={2, 1, 0}, xi=0x30) public class ExtraData {
        public ExtraData() {
            super();
        }
    }

    private final SimpleArrayMap extraDataMap;
    private final LifecycleRegistry lifecycleRegistry;

    public ComponentActivity() {
        super();
        this.extraDataMap = new SimpleArrayMap(0, 1, null);
        this.lifecycleRegistry = new LifecycleRegistry(this);
    }

    public boolean dispatchKeyEvent(KeyEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        View v0 = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(v0, "getDecorView(...)");
        if(KeyEventDispatcher.dispatchBeforeHierarchy(v0, arg3)) {
            return 1;
        }

        return KeyEventDispatcher.dispatchKeyEvent(this, v0, ((Window$Callback)this), arg3);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent arg3) {
        Intrinsics.checkNotNullParameter(arg3, "event");
        View v0 = this.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(v0, "getDecorView(...)");
        if(KeyEventDispatcher.dispatchBeforeHierarchy(v0, arg3)) {
            return 1;
        }

        return super.dispatchKeyShortcutEvent(arg3);
    }

    @Deprecated(message="Use {@link View#getTag(int)} with the window\'s decor view.") public ExtraData getExtraData(Class arg2) {
        Intrinsics.checkNotNullParameter(arg2, "extraDataClass");
        return this.extraDataMap.get(arg2);
    }

    private static void getExtraDataMap$annotations() {
    }

    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    private static void getLifecycleRegistry$annotations() {
    }

    protected void onCreate(Bundle arg1) {
        super.onCreate(arg1);
        ReportFragment.Companion.injectIfNeededIn(((Activity)this));
    }

    protected void onSaveInstanceState(Bundle arg3) {
        Intrinsics.checkNotNullParameter(arg3, "outState");
        this.lifecycleRegistry.setCurrentState(State.CREATED);
        super.onSaveInstanceState(arg3);
    }

    @Deprecated(message="Use {@link View#setTag(int, Object)} with the window\'s decor view.") public void putExtraData(ExtraData arg2) {
        Intrinsics.checkNotNullParameter(arg2, "extraData");
        this.extraDataMap.put(arg2.getClass(), arg2);
    }

    protected final boolean shouldDumpInternalState(String[] arg1) {
        return this.shouldSkipDump(arg1) ^ 1;
    }

    private final boolean shouldSkipDump(String[] arg3) {
        if(arg3 != null) {
            if(arg3.length == 0) {
            }
            else {
                String v3 = arg3[0];
                switch(v3.hashCode()) {
                    case -645125871: {
                        goto label_37;
                    }
                    case 100470631: {
                        goto label_28;
                    }
                    case 472614934: {
                        goto label_24;
                    }
                    case 1159329357: {
                        goto label_15;
                    }
                    case 1455016274: {
                        goto label_10;
                    }
                }

                return 0;
            label_37:
                if(!v3.equals("--translation")) {
                }
                else if(Build$VERSION.SDK_INT >= 0x1F) {
                    return 1;
                label_24:
                    if(!v3.equals("--list-dumpables")) {
                        return 0;
                    label_10:
                        if(!v3.equals("--autofill")) {
                        }
                        else {
                            return 1;
                        label_28:
                            if(!v3.equals("--dump-dumpable")) {
                            }
                            else {
                                goto label_32;
                            }
                        }
                    }
                    else {
                    label_32:
                        if(Build$VERSION.SDK_INT >= 33) {
                            return 1;
                        }
                        else {
                            return 0;
                        label_15:
                            if(!v3.equals("--contentcapture")) {
                            }
                            else if(Build$VERSION.SDK_INT >= 29) {
                                return 1;
                            }
                            else {
                                return 0;
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    public boolean superDispatchKeyEvent(KeyEvent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "event");
        return super.dispatchKeyEvent(arg2);
    }
}

