package androidx.compose.material3.internal;

import android.os.Build$VERSION;
import android.view.accessibility.AccessibilityManager$AccessibilityServicesStateChangeListener;
import android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0002\u0014\u0017\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001(B\u001F\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020\u0003H\u0016J\u000E\u0010%\u001A\u00020#2\u0006\u0010&\u001A\u00020\u001AJ\u000E\u0010\'\u001A\u00020#2\u0006\u0010&\u001A\u00020\u001AR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR+\u0010\r\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u00038B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u000E\u0010\n\"\u0004\b\u000F\u0010\u0010R\u0012\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0018\u0010\u0019\u001A\u00020\u0003*\u00020\u001A8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0018\u0010\u001D\u001A\u00020\u0003*\u00020\u001A8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001CR\u0014\u0010\u001F\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b \u0010!¨\u0006)"}, d2={"Landroidx/compose/material3/internal/Listener;", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "Landroidx/compose/runtime/State;", "", "listenToTouchExplorationState", "listenToSwitchAccessState", "listenToVoiceAccessState", "<init>", "(ZZZ)V", "getListenToSwitchAccessState", "()Z", "getListenToVoiceAccessState", "<set-?>", "accessibilityEnabled", "getAccessibilityEnabled", "setAccessibilityEnabled", "(Z)V", "accessibilityEnabled$delegate", "Landroidx/compose/runtime/MutableState;", "touchExplorationListener", "androidx/compose/material3/internal/Listener$touchExplorationListener$1", "Landroidx/compose/material3/internal/Listener$touchExplorationListener$1;", "otherA11yServicesListener", "androidx/compose/material3/internal/Listener$otherA11yServicesListener$1", "Landroidx/compose/material3/internal/Listener$otherA11yServicesListener$1;", "switchAccessEnabled", "Landroid/view/accessibility/AccessibilityManager;", "getSwitchAccessEnabled", "(Landroid/view/accessibility/AccessibilityManager;)Z", "voiceAccessEnabled", "getVoiceAccessEnabled", "value", "getValue", "()Ljava/lang/Boolean;", "onAccessibilityStateChanged", "", "enabled", "register", "am", "unregister", "Api33Impl", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class Listener implements AccessibilityManager$AccessibilityStateChangeListener, State {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007J\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007¨\u0006\u000B"}, d2={"Landroidx/compose/material3/internal/Listener$Api33Impl;", "", "<init>", "()V", "addAccessibilityServicesStateChangeListener", "", "am", "Landroid/view/accessibility/AccessibilityManager;", "listener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityServicesStateChangeListener;", "removeAccessibilityServicesStateChangeListener", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class Api33Impl {
        public static final Api33Impl INSTANCE;

        static {
            Api33Impl.INSTANCE = new Api33Impl();
        }

        private Api33Impl() {
            super();
        }

        @JvmStatic public static final void addAccessibilityServicesStateChangeListener(AccessibilityManager arg0, AccessibilityManager$AccessibilityServicesStateChangeListener arg1) {
            arg0.addAccessibilityServicesStateChangeListener(arg1);
        }

        @JvmStatic public static final void removeAccessibilityServicesStateChangeListener(AccessibilityManager arg0, AccessibilityManager$AccessibilityServicesStateChangeListener arg1) {
            arg0.removeAccessibilityServicesStateChangeListener(arg1);
        }
    }

    private final MutableState accessibilityEnabled$delegate;
    private final boolean listenToSwitchAccessState;
    private final boolean listenToVoiceAccessState;
    private final Listener$otherA11yServicesListener$1 otherA11yServicesListener;
    private final Listener$touchExplorationListener$1 touchExplorationListener;

    public Listener(boolean arg4, boolean arg5, boolean arg6) {
        Listener$otherA11yServicesListener$1 v2_1;
        super();
        this.listenToSwitchAccessState = arg5;
        this.listenToVoiceAccessState = arg6;
        SnapshotMutationPolicy v2 = null;
        this.accessibilityEnabled$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), v2, 2, v2);
        Listener$touchExplorationListener$1 v4 = arg4 ? new Listener$touchExplorationListener$1() : ((Listener$touchExplorationListener$1)v2);
        this.touchExplorationListener = v4;
        if(((arg5) || (arg6)) && Build$VERSION.SDK_INT >= 33) {
            v2_1 = new Listener$otherA11yServicesListener$1(this);
        }

        this.otherA11yServicesListener = v2_1;
    }

    public static final boolean access$getSwitchAccessEnabled(Listener arg0, AccessibilityManager arg1) {
        return arg0.getSwitchAccessEnabled(arg1);
    }

    public static final boolean access$getVoiceAccessEnabled(Listener arg0, AccessibilityManager arg1) {
        return arg0.getVoiceAccessEnabled(arg1);
    }

    private final boolean getAccessibilityEnabled() {
        return this.accessibilityEnabled$delegate.getValue().booleanValue();
    }

    public final boolean getListenToSwitchAccessState() {
        return this.listenToSwitchAccessState;
    }

    public final boolean getListenToVoiceAccessState() {
        return this.listenToVoiceAccessState;
    }

    private final boolean getSwitchAccessEnabled(AccessibilityManager arg6) {
        List v5 = arg6.getEnabledAccessibilityServiceList(16);
        int v6 = v5.size();
        int v1;
        for(v1 = 0; v1 < v6; ++v1) {
            String v2 = v5.get(v1).getSettingsActivityName();
            if(v2 != null && (StringsKt.contains(((CharSequence)v2), "SwitchAccess", true))) {
                return 1;
            }
        }

        return 0;
    }

    public Boolean getValue() {
        boolean v1;
        if(this.getAccessibilityEnabled()) {
            Listener$touchExplorationListener$1 v0 = this.touchExplorationListener;
            v1 = true;
            if(v0 != null && (v0.getEnabled())) {
                goto label_23;
            }

            if(this.listenToSwitchAccessState) {
                Listener$otherA11yServicesListener$1 v0_1 = this.otherA11yServicesListener;
                if(v0_1 != null && (v0_1.getSwitchAccessEnabled())) {
                    goto label_23;
                }
            }

            if(!this.listenToVoiceAccessState) {
                goto label_22;
            }

            Listener$otherA11yServicesListener$1 v2 = this.otherA11yServicesListener;
            if(v2 == null) {
                goto label_22;
            }

            if(!v2.getVoiceAccessEnabled()) {
                goto label_22;
            }
        }
        else {
        label_22:
            v1 = false;
        }

    label_23:
        return Boolean.valueOf(v1);
    }

    public Object getValue() {
        return this.getValue();
    }

    private final boolean getVoiceAccessEnabled(AccessibilityManager arg6) {
        List v5 = arg6.getEnabledAccessibilityServiceList(16);
        int v6 = v5.size();
        int v1;
        for(v1 = 0; v1 < v6; ++v1) {
            String v2 = v5.get(v1).getSettingsActivityName();
            if(v2 != null && (StringsKt.contains(((CharSequence)v2), "VoiceAccess", true))) {
                return 1;
            }
        }

        return 0;
    }

    public void onAccessibilityStateChanged(boolean arg1) {
        this.setAccessibilityEnabled(arg1);
    }

    public final void register(AccessibilityManager arg3) {
        this.setAccessibilityEnabled(arg3.isEnabled());
        arg3.addAccessibilityStateChangeListener(this);
        Listener$touchExplorationListener$1 v0 = this.touchExplorationListener;
        if(v0 != null) {
            v0.setEnabled(arg3.isTouchExplorationEnabled());
            arg3.addTouchExplorationStateChangeListener(((AccessibilityManager$TouchExplorationStateChangeListener)v0));
        }

        if(Build$VERSION.SDK_INT >= 33) {
            Listener$otherA11yServicesListener$1 v0_1 = this.otherA11yServicesListener;
            if(v0_1 != null) {
                v0_1.setSwitchAccessEnabled(this.getSwitchAccessEnabled(arg3));
                v0_1.setVoiceAccessEnabled(this.getVoiceAccessEnabled(arg3));
                Api33Impl.addAccessibilityServicesStateChangeListener(arg3, ((AccessibilityManager$AccessibilityServicesStateChangeListener)v0_1));
            }
        }
    }

    private final void setAccessibilityEnabled(boolean arg1) {
        this.accessibilityEnabled$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void unregister(AccessibilityManager arg3) {
        arg3.removeAccessibilityStateChangeListener(this);
        Listener$touchExplorationListener$1 v0 = this.touchExplorationListener;
        if(v0 != null) {
            arg3.removeTouchExplorationStateChangeListener(((AccessibilityManager$TouchExplorationStateChangeListener)v0));
        }

        if(Build$VERSION.SDK_INT >= 33) {
            Listener$otherA11yServicesListener$1 v2 = this.otherA11yServicesListener;
            if(v2 != null) {
                Api33Impl.removeAccessibilityServicesStateChangeListener(arg3, ((AccessibilityManager$AccessibilityServicesStateChangeListener)v2));
            }
        }
    }
}

