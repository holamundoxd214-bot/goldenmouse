package com.TryJeanPc.goldenmouse.controls;

import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import com.TryJeanPc.goldenmouse.mapper.InputBindingSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0081\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/MarkerLabel;", "", "normal", "", "compact", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getNormal", "()Ljava/lang/String;", "getCompact", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MarkerLabel {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/MarkerLabel$Companion;", "", "<init>", "()V", "fromBinding", "Lcom/TryJeanPc/goldenmouse/controls/MarkerLabel;", "binding", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "fallback", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
            static {
                int[] v0 = new int[InputBindingSource.values().length];
                try {
                    v0[InputBindingSource.MOUSE.ordinal()] = 1;
                    goto label_7;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_7:
                        v0[InputBindingSource.KEYBOARD.ordinal()] = 2;
                        goto label_11;
                    }
                    catch(NoSuchFieldError ) {
                    label_11:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }

        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final MarkerLabel fromBinding(InputBinding arg9, String arg10) {
            String v9_2;
            Intrinsics.checkNotNullParameter(arg10, "fallback");
            String v8 = null;
            String v0 = arg9 != null ? arg9.getNormalizedCode() : v8;
            InputBindingSource v9 = arg9 != null ? arg9.getSource() : ((InputBindingSource)v8);
            int v9_1 = v9 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[v9.ordinal()];
            String v2 = "RIGHT";
            String v3 = "LEFT";
            int v4 = 2;
            if(v9_1 != 1) {
                if(v9_1 != v4) {
                    return new MarkerLabel(arg10, v8, v4, ((DefaultConstructorMarker)v8));
                }

                if(v0 != null) {
                    String v1 = "ALT";
                    String v5 = "CTRL";
                    String v6 = "ESC";
                    String v7 = "SHF";
                    switch(v0.hashCode()) {
                        case -1793460494: {
                            goto label_189;
                        }
                        case -1721778389: {
                            goto label_181;
                        }
                        case -1455726339: {
                            goto label_173;
                        }
                        case -1067127502: {
                            goto label_165;
                        }
                        case -1066899305: {
                            goto label_157;
                        }
                        case -884439066: {
                            goto label_149;
                        }
                        case -653450739: {
                            goto label_141;
                        }
                        case -154864545: {
                            goto label_132;
                        }
                        case 2715: {
                            goto label_128;
                        }
                        case 67563: {
                            goto label_124;
                        }
                        case 68949: {
                            goto label_118;
                        }
                        case 82805: {
                            goto label_111;
                        }
                        case 2104482: {
                            goto label_107;
                        }
                        case 2332679: {
                            goto label_104;
                        }
                        case 66129592: {
                            goto label_96;
                        }
                        case 77974012: {
                            goto label_89;
                        }
                        case 78869602: {
                            goto label_82;
                        }
                        case 79100134: {
                            goto label_74;
                        }
                        case 251709627: {
                            goto label_66;
                        }
                        case 773428258: {
                            goto label_62;
                        }
                        case 921250600: {
                            goto label_54;
                        }
                        case 1217930855: {
                            goto label_50;
                        }
                        case 1291520876: {
                            goto label_46;
                        }
                        case 1553555803: {
                            goto label_42;
                        }
                        case 2054124673: {
                            goto label_38;
                        }
                        case 2122784710: {
                            goto label_34;
                        }
                    }

                    goto label_197;
                label_34:
                    if(!v0.equals("ALT_RIGHT")) {
                        goto label_197;
                    label_165:
                        if(!v0.equals("DPAD_DOWN")) {
                            goto label_197;
                        label_38:
                            if(!v0.equals("ESCAPE")) {
                                goto label_197;
                            label_104:
                                if(!v0.equals(v3)) {
                                    goto label_197;
                                label_42:
                                    if(!v0.equals("CTRL_LEFT")) {
                                        goto label_197;
                                    label_107:
                                        if(!v0.equals("DOWN")) {
                                        }
                                        else {
                                            goto label_169;
                                        }
                                    }
                                    else {
                                        goto label_193;
                                    }
                                }
                                else {
                                    goto label_161;
                                }
                            }
                            else {
                                goto label_121;
                            }
                        }
                        else {
                        label_169:
                            return new MarkerLabel("↓", v8, v4, ((DefaultConstructorMarker)v8));
                        label_173:
                            if(!v0.equals("ALT_LEFT")) {
                                goto label_197;
                            label_46:
                                if(!v0.equals("DPAD_RIGHT")) {
                                    goto label_197;
                                label_111:
                                    v9_2 = "TAB";
                                    if(!v0.equals(v9_2)) {
                                    }
                                    else {
                                        return new MarkerLabel(v9_2, v8, v4, ((DefaultConstructorMarker)v8));
                                    label_50:
                                        if(!v0.equals("RIGHTCTRL")) {
                                            goto label_197;
                                        label_181:
                                            if(!v0.equals("DPAD_UP")) {
                                                goto label_197;
                                            label_54:
                                                if(!v0.equals("CTRL_RIGHT")) {
                                                }
                                                else {
                                                    goto label_58;
                                                }
                                            }
                                            else {
                                                goto label_185;
                                            }
                                        }
                                        else {
                                        label_58:
                                            return new MarkerLabel("RCTRL", v5);
                                        label_118:
                                            if(!v0.equals(v6)) {
                                            }
                                            else {
                                            label_121:
                                                return new MarkerLabel(v6, v8, v4, ((DefaultConstructorMarker)v8));
                                            label_124:
                                                if(!v0.equals("DEL")) {
                                                    goto label_197;
                                                label_189:
                                                    if(!v0.equals("LEFTCTRL")) {
                                                    }
                                                    else {
                                                    label_193:
                                                        return new MarkerLabel("LCTRL", v5);
                                                    label_62:
                                                        if(!v0.equals("LEFTALT")) {
                                                        }
                                                        else {
                                                            goto label_177;
                                                        }
                                                    }
                                                }
                                                else {
                                                    goto label_136;
                                                }
                                            }
                                        }
                                    }
                                }
                                else {
                                    goto label_92;
                                }
                            }
                            else {
                            label_177:
                                return new MarkerLabel("LALT", v1);
                            label_128:
                                if(!v0.equals("UP")) {
                                }
                                else {
                                label_185:
                                    return new MarkerLabel("↑", v8, v4, ((DefaultConstructorMarker)v8));
                                label_66:
                                    if(!v0.equals("LEFTSHIFT")) {
                                    }
                                    else {
                                        return new MarkerLabel("LSHIFT", v7);
                                    label_132:
                                        if(!v0.equals("BACKSPACE")) {
                                        }
                                        else {
                                        label_136:
                                            return new MarkerLabel("BACK", "BSP");
                                        label_74:
                                            v9_2 = "SPACE";
                                            if(!v0.equals(v9_2)) {
                                            }
                                            else {
                                                return new MarkerLabel(v9_2, "SPC");
                                            label_141:
                                                if(!v0.equals("RIGHTALT")) {
                                                }
                                                else {
                                                    goto label_145;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else {
                    label_145:
                        return new MarkerLabel("RALT", v1);
                    label_82:
                        v9_2 = "SHIFT";
                        if(!v0.equals(v9_2)) {
                        }
                        else {
                            return new MarkerLabel(v9_2, v7);
                        label_149:
                            if(!v0.equals("RIGHTSHIFT")) {
                            }
                            else {
                                return new MarkerLabel("RSHIFT", v7);
                            label_89:
                                if(!v0.equals(v2)) {
                                }
                                else {
                                label_92:
                                    return new MarkerLabel("→", v8, v4, ((DefaultConstructorMarker)v8));
                                label_157:
                                    if(!v0.equals("DPAD_LEFT")) {
                                    }
                                    else {
                                    label_161:
                                        return new MarkerLabel("←", v8, v4, ((DefaultConstructorMarker)v8));
                                    label_96:
                                        v9_2 = "ENTER";
                                        if(!v0.equals(v9_2)) {
                                        }
                                        else {
                                            return new MarkerLabel(v9_2, "ENT");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            label_197:
                return new MarkerLabel(arg10, v8, v4, ((DefaultConstructorMarker)v8));
            }

            if(v0 != null) {
                switch(v0.hashCode()) {
                    case -2021012075: {
                        goto label_234;
                    }
                    case -1849235639: {
                        goto label_226;
                    }
                    case -1849235638: {
                        goto label_218;
                    }
                    case 2332679: {
                        goto label_211;
                    }
                    case 77974012: {
                        goto label_204;
                    }
                }

                goto label_242;
            label_226:
                if(!v0.equals("SIDE_1")) {
                }
                else {
                    return new MarkerLabel("M4", v8, v4, ((DefaultConstructorMarker)v8));
                label_211:
                    if(!v0.equals(v3)) {
                    }
                    else {
                        return new MarkerLabel("LMB", v8, v4, ((DefaultConstructorMarker)v8));
                    label_234:
                        if(!v0.equals("MIDDLE")) {
                        }
                        else {
                            return new MarkerLabel("MMB", v8, v4, ((DefaultConstructorMarker)v8));
                        label_218:
                            if(!v0.equals("SIDE_2")) {
                            }
                            else {
                                return new MarkerLabel("M5", v8, v4, ((DefaultConstructorMarker)v8));
                            label_204:
                                if(!v0.equals(v2)) {
                                }
                                else {
                                    return new MarkerLabel("RMB", v8, v4, ((DefaultConstructorMarker)v8));
                                }
                            }
                        }
                    }
                }
            }

        label_242:
            return new MarkerLabel(arg10, v8, v4, ((DefaultConstructorMarker)v8));
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final String compact;
    private final String normal;

    static {
        MarkerLabel.Companion = new Companion(null);
    }

    public MarkerLabel(String arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "normal");
        Intrinsics.checkNotNullParameter(arg3, "compact");
        super();
        this.normal = arg2;
        this.compact = arg3;
    }

    public MarkerLabel(String arg1, String arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg1;
        }

        this(arg1, arg2);
    }

    public final String component1() {
        return this.normal;
    }

    public final String component2() {
        return this.compact;
    }

    public final MarkerLabel copy(String arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "normal");
        Intrinsics.checkNotNullParameter(arg2, "compact");
        return new MarkerLabel(arg1, arg2);
    }

    public static MarkerLabel copy$default(MarkerLabel arg0, String arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.normal;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.compact;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((MarkerLabel)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof MarkerLabel)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.normal, ((MarkerLabel)arg5).normal)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.compact, ((MarkerLabel)arg5).compact)) {
            return 0;
        }

        return 1;
    }

    public final String getCompact() {
        return this.compact;
    }

    public final String getNormal() {
        return this.normal;
    }

    public int hashCode() {
        return this.normal.hashCode() * 0x1F + this.compact.hashCode();
    }

    public String toString() {
        return "MarkerLabel(normal=" + this.normal + ", compact=" + this.compact + ")";
    }
}

