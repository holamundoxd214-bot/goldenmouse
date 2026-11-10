package com.TryJeanPc.goldenmouse.input;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0087\b\u0018\u0000 \u001B2\u00020\u0001:\u0001\u001BB\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u0016\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001A\u00020\u00052\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u0003HÖ\u0001J\t\u0010\u001A\u001A\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\r8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\u00118F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "", "hz", "", "custom", "", "<init>", "(IZ)V", "getHz", "()I", "getCustom", "()Z", "intervalNanos", "", "getIntervalNanos", "()J", "label", "", "getLabel", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MousePollingSelection {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\nR\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection$Companion;", "", "<init>", "()V", "PRESETS", "", "", "parseCustom", "Lcom/TryJeanPc/goldenmouse/input/MousePollingSelection;", "text", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final MousePollingSelection parseCustom(String arg7) {
            Intrinsics.checkNotNullParameter(arg7, "text");
            String v6 = StringsKt.trim(((CharSequence)arg7)).toString();
            arg7 = v6;
            MousePollingSelection v1 = null;
            if(((CharSequence)arg7).length() == 0) {
            }
            else {
                int v2;
                for(v2 = 0; true; ++v2) {
                    int v4 = 1;
                    if(v2 >= ((CharSequence)arg7).length()) {
                        break;
                    }

                    int v3 = ((CharSequence)arg7).charAt(v2);
                    if(0x30 > v3 || v3 >= 58) {
                        v4 = 0;
                    }
                    else {
                    }

                    if(v4 == 0) {
                        return v1;
                    }
                }

                Integer v6_1 = StringsKt.toIntOrNull(v6);
                if(v6_1 != null) {
                    int v7 = v6_1.intValue();
                    if(100 > v7 || v7 >= 1001) {
                        v6_1 = ((Integer)v1);
                    }
                    else {
                    }

                    if(v6_1 == null) {
                        return v1;
                    }

                    return new MousePollingSelection(v6_1.intValue(), true);
                }

                return v1;
            }

            return v1;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Set PRESETS;
    private final boolean custom;
    private final int hz;

    static {
        MousePollingSelection.Companion = new Companion(null);
        MousePollingSelection.PRESETS = SetsKt.setOf(new Integer[]{Integer.valueOf(0), Integer.valueOf(0x7D), Integer.valueOf(0xFA), Integer.valueOf(500), Integer.valueOf(1000)});
    }

    public MousePollingSelection(int arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
        this(0, false);
    }

    public MousePollingSelection(int arg1, boolean arg2) {
        super();
        this.hz = arg1;
        this.custom = arg2;
        if(arg2) {
            arg2 = false;
            if(100 <= arg1 && arg1 < 1001) {
                arg2 = true;
            }
        }
        else {
            arg2 = MousePollingSelection.PRESETS.contains(Integer.valueOf(arg1));
        }

        if(arg2) {
            return;
        }

        throw new IllegalArgumentException("Frecuencia de mouse no válida".toString());
    }

    public MousePollingSelection() {
        this(0, false, 3, null);
    }

    public final int component1() {
        return this.hz;
    }

    public final boolean component2() {
        return this.custom;
    }

    public final MousePollingSelection copy(int arg1, boolean arg2) {
        return new MousePollingSelection(arg1, arg2);
    }

    public static MousePollingSelection copy$default(MousePollingSelection arg0, int arg1, boolean arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.hz;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.custom;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((MousePollingSelection)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof MousePollingSelection)) {
            return 0;
        }

        if(this.hz != ((MousePollingSelection)arg5).hz) {
            return 0;
        }

        if(this.custom != ((MousePollingSelection)arg5).custom) {
            return 0;
        }

        return 1;
    }

    public final boolean getCustom() {
        return this.custom;
    }

    public final int getHz() {
        return this.hz;
    }

    public final long getIntervalNanos() {
        int v4 = this.hz;
        if(v4 == 0) {
            return 0;
        }

        return ((((long)v4)) + 0x3B9AC9FF) / (((long)v4));
    }

    public final String getLabel() {
        int v1 = this.hz;
        if(v1 == 0) {
            return "Nativo";
        }

        return v1 + " Hz";
    }

    public int hashCode() {
        return Integer.hashCode(this.hz) * 0x1F + Boolean.hashCode(this.custom);
    }

    public String toString() {
        return "MousePollingSelection(hz=" + this.hz + ", custom=" + this.custom + ")";
    }
}

