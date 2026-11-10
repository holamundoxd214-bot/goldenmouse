package com.TryJeanPc.goldenmouse.controls;

import com.TryJeanPc.goldenmouse.profile.ControlComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0003H&J\u0018\u0010\u0007\u001A\u00020\u00052\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH&J\u0018\u0010\n\u001A\u00020\u00052\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\u000BÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/ProfileComponentControl;", "Lcom/TryJeanPc/goldenmouse/controls/ConfigurableInputControl;", "currentComponent", "Lcom/TryJeanPc/goldenmouse/profile/ControlComponent;", "applyComponent", "", "component", "setOnConfigure", "listener", "Lkotlin/Function0;", "setOnComponentChanged", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface ProfileComponentControl extends ConfigurableInputControl {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static void setOnComponentChanged(ProfileComponentControl arg0, Function0 arg1) {
            arg0.setOnComponentChanged(arg1);
        }
    }

    static void access$setOnComponentChanged$jd(ProfileComponentControl arg0, Function0 arg1) {
        super.setOnComponentChanged(arg1);
    }

    void applyComponent(ControlComponent arg1);

    ControlComponent currentComponent();

    default void setOnComponentChanged(Function0 arg1) {
    }

    void setOnConfigure(Function0 arg1);
}

