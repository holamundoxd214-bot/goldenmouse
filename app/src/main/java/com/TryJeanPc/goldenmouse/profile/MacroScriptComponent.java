package com.TryJeanPc.goldenmouse.profile;

import com.TryJeanPc.goldenmouse.macro.editor.MacroDraft;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000B\u0010\u0010\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0011\u001A\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0012\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001A\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001A\u00020\rHÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\rX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u001A"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/MacroScriptComponent;", "Lcom/TryJeanPc/goldenmouse/profile/ControlComponent;", "macro", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "rejectedPayload", "Lcom/TryJeanPc/goldenmouse/profile/RejectedMacroPayload;", "<init>", "(Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;Lcom/TryJeanPc/goldenmouse/profile/RejectedMacroPayload;)V", "getMacro", "()Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "getRejectedPayload", "()Lcom/TryJeanPc/goldenmouse/profile/RejectedMacroPayload;", "type", "", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroScriptComponent implements ControlComponent {
    public static final int $stable = 8;
    private final MacroDraft macro;
    private final RejectedMacroPayload rejectedPayload;
    private final String type;

    static {
    }

    public MacroScriptComponent(MacroDraft arg2, RejectedMacroPayload arg3, int arg4, DefaultConstructorMarker arg5) {
        MacroDraft v0 = null;
        if((arg4 & 1) != 0) {
            arg2 = v0;
        }

        if((arg4 & 2) != 0) {
            arg3 = ((RejectedMacroPayload)v0);
        }

        this(arg2, arg3);
    }

    public MacroScriptComponent() {
        this(null, null, 3, null);
    }

    public MacroScriptComponent(MacroDraft arg1, RejectedMacroPayload arg2) {
        super();
        this.macro = arg1;
        this.rejectedPayload = arg2;
        this.type = "MACRO_SCRIPT";
    }

    public final MacroDraft component1() {
        return this.macro;
    }

    public final RejectedMacroPayload component2() {
        return this.rejectedPayload;
    }

    public final MacroScriptComponent copy(MacroDraft arg1, RejectedMacroPayload arg2) {
        return new MacroScriptComponent(arg1, arg2);
    }

    public static MacroScriptComponent copy$default(MacroScriptComponent arg0, MacroDraft arg1, RejectedMacroPayload arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.macro;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.rejectedPayload;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((MacroScriptComponent)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof MacroScriptComponent)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.macro, ((MacroScriptComponent)arg5).macro)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.rejectedPayload, ((MacroScriptComponent)arg5).rejectedPayload)) {
            return 0;
        }

        return 1;
    }

    public final MacroDraft getMacro() {
        return this.macro;
    }

    public final RejectedMacroPayload getRejectedPayload() {
        return this.rejectedPayload;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        MacroDraft v0 = this.macro;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        RejectedMacroPayload v2 = this.rejectedPayload;
        if(v2 == null) {
        }
        else {
            v1 = v2.hashCode();
        }

        return v0_1 + v1;
    }

    public String toString() {
        return "MacroScriptComponent(macro=" + this.macro + ", rejectedPayload=" + this.rejectedPayload + ")";
    }
}

