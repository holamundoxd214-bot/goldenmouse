package com.TryJeanPc.goldenmouse.recoil;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b%\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087\b\u0018\u0000 22\u00020\u0001:\u00012Bk\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007\u0012\b\b\u0002\u0010\t\u001A\u00020\u0003\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\u000B\u0012\b\b\u0002\u0010\r\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u000B¢\u0006\u0004\b\u000F\u0010\u0010J\t\u0010\"\u001A\u00020\u0003HÆ\u0003J\t\u0010#\u001A\u00020\u0003HÆ\u0003J\t\u0010$\u001A\u00020\u0003HÆ\u0003J\t\u0010%\u001A\u00020\u0007HÆ\u0003J\t\u0010&\u001A\u00020\u0007HÆ\u0003J\t\u0010\'\u001A\u00020\u0003HÆ\u0003J\t\u0010(\u001A\u00020\u000BHÆ\u0003J\t\u0010)\u001A\u00020\u000BHÆ\u0003J\t\u0010*\u001A\u00020\u0003HÆ\u0003J\t\u0010+\u001A\u00020\u000BHÆ\u0003Jm\u0010,\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u000B2\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u000BHÆ\u0001J\u0013\u0010-\u001A\u00020\u00032\b\u0010.\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001A\u00020\u0007HÖ\u0001J\t\u00100\u001A\u000201HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0016R\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\f\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001AR\u0011\u0010\r\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0012R\u0011\u0010\u000E\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001AR\u0011\u0010\u001E\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u001AR\u0011\u0010 \u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b!\u0010\u001A¨\u00063"}, d2={"Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettings;", "", "enabled", "", "showPanel", "fixedPanel", "panelOpacity", "", "globalPercent", "limitDuration", "maxDurationSeconds", "", "verticalSpeed", "downward", "horizontalSpeed", "<init>", "(ZZZIIZDDZD)V", "getEnabled", "()Z", "getShowPanel", "getFixedPanel", "getPanelOpacity", "()I", "getGlobalPercent", "getLimitDuration", "getMaxDurationSeconds", "()D", "getVerticalSpeed", "getDownward", "getHorizontalSpeed", "coefficient", "getCoefficient", "signedVerticalSpeed", "getSignedVerticalSpeed", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoilSettings {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0005¢\u0006\u0002\u0010\n¨\u0006\u000B"}, d2={"Lcom/TryJeanPc/goldenmouse/recoil/RecoilSettings$Companion;", "", "<init>", "()V", "parseNumber", "", "text", "", "minimum", "maximum", "(Ljava/lang/String;DD)Ljava/lang/Double;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Double parseNumber(String arg7, double arg8, double arg10) {
            Intrinsics.checkNotNullParameter(arg7, "text");
            Double v6 = StringsKt.toDoubleOrNull(StringsKt.replace$default(StringsKt.trim(((CharSequence)arg7)).toString(), ',', '.', false, 4, null));
            Double v7 = null;
            if(v6 != null) {
                double v0 = v6.doubleValue();
                if(Math.abs(v0) <= 1.797693E+308 && arg8 <= v0 && v0 <= arg10) {
                    return v6;
                }
            }

            return v7;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final boolean downward;
    private final boolean enabled;
    private final boolean fixedPanel;
    private final int globalPercent;
    private final double horizontalSpeed;
    private final boolean limitDuration;
    private final double maxDurationSeconds;
    private final int panelOpacity;
    private final boolean showPanel;
    private final double verticalSpeed;

    static {
        RecoilSettings.Companion = new Companion(null);
    }

    public RecoilSettings(boolean arg16, boolean arg17, boolean arg18, int arg19, int arg20, boolean arg21, double arg22, double arg24, boolean arg26, double arg27, int arg29, DefaultConstructorMarker arg30) {
        int v0 = arg29;
        boolean v2 = false;
        boolean v1 = (v0 & 1) != 0 ? false : arg16;
        boolean v3 = (v0 & 2) != 0 ? false : arg17;
        boolean v4 = (v0 & 4) != 0 ? false : arg18;
        int v6 = 100;
        int v5 = (v0 & 8) != 0 ? v6 : arg19;
        if((v0 & 16) != 0) {
        }
        else {
            v6 = arg20;
        }

        boolean v7 = (v0 & 0x20) != 0 ? false : arg21;
        double v8 = (v0 & 0x40) != 0 ? 5 : arg22;
        double v11 = 0;
        double v13 = (v0 & 0x80) != 0 ? v11 : arg24;
        if((v0 & 0x100) != 0) {
        }
        else {
            v2 = arg26;
        }

        double v28 = (v0 & 0x200) != 0 ? v11 : arg27;
        this(v1, v3, v4, v5, v6, v7, v8, v13, v2, v28);
    }

    public RecoilSettings() {
        this(false, false, false, 0, 0, false, 0, 0, false, 0, 0x3FF, null);
    }

    public RecoilSettings(boolean arg3, boolean arg4, boolean arg5, int arg6, int arg7, boolean arg8, double arg9, double arg11, boolean arg13, double arg14) {
        super();
        this.enabled = arg3;
        this.showPanel = arg4;
        this.fixedPanel = arg5;
        this.panelOpacity = arg6;
        this.globalPercent = arg7;
        this.limitDuration = arg8;
        this.maxDurationSeconds = arg9;
        this.verticalSpeed = arg11;
        this.downward = arg13;
        this.horizontalSpeed = arg14;
        String v3 = "Failed requirement.";
        if(10 <= arg6 && arg6 < 101) {
            if(40 <= arg7 && arg7 < 201) {
                double v6 = 1.797693E+308;
                if(Math.abs(arg9) <= v6) {
                    double v4 = 0;
                    if(arg9 > v4 && arg9 <= 60) {
                        if(Math.abs(arg11) <= v6 && v4 <= arg11) {
                            v4 = 100;
                            if(arg11 <= v4) {
                                if(Math.abs(arg14) <= v6 && -100 <= arg14 && arg14 <= v4) {
                                    return;
                                }

                                throw new IllegalArgumentException(v3.toString());
                            }
                        }

                        throw new IllegalArgumentException(v3.toString());
                    }
                }

                throw new IllegalArgumentException(v3.toString());
            }

            throw new IllegalArgumentException(v3.toString());
        }

        throw new IllegalArgumentException(v3.toString());
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final double component10() {
        return this.horizontalSpeed;
    }

    public final boolean component2() {
        return this.showPanel;
    }

    public final boolean component3() {
        return this.fixedPanel;
    }

    public final int component4() {
        return this.panelOpacity;
    }

    public final int component5() {
        return this.globalPercent;
    }

    public final boolean component6() {
        return this.limitDuration;
    }

    public final double component7() {
        return this.maxDurationSeconds;
    }

    public final double component8() {
        return this.verticalSpeed;
    }

    public final boolean component9() {
        return this.downward;
    }

    public final RecoilSettings copy(boolean arg1, boolean arg2, boolean arg3, int arg4, int arg5, boolean arg6, double arg7, double arg9, boolean arg11, double arg12) {
        return new RecoilSettings(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg9, arg11, arg12);
    }

    public static RecoilSettings copy$default(RecoilSettings arg14, boolean arg15, boolean arg16, boolean arg17, int arg18, int arg19, boolean arg20, double arg21, double arg23, boolean arg25, double arg26, int arg28, Object arg29) {
        int v0 = arg28;
        boolean v1 = (v0 & 1) != 0 ? arg14.enabled : arg15;
        boolean v2 = (v0 & 2) != 0 ? arg14.showPanel : arg16;
        boolean v3 = (v0 & 4) != 0 ? arg14.fixedPanel : arg17;
        int v4 = (v0 & 8) != 0 ? arg14.panelOpacity : arg18;
        int v5 = (v0 & 16) != 0 ? arg14.globalPercent : arg19;
        boolean v6 = (v0 & 0x20) != 0 ? arg14.limitDuration : arg20;
        double v7 = (v0 & 0x40) != 0 ? arg14.maxDurationSeconds : arg21;
        double v9 = (v0 & 0x80) != 0 ? arg14.verticalSpeed : arg23;
        boolean v11 = (v0 & 0x100) != 0 ? arg14.downward : arg25;
        double v27 = (v0 & 0x200) != 0 ? arg14.horizontalSpeed : arg26;
        return arg14.copy(v1, v2, v3, v4, v5, v6, v7, v9, v11, v27);
    }

    public boolean equals(Object arg8) {
        if(this == (((RecoilSettings)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof RecoilSettings)) {
            return 0;
        }

        if(this.enabled != ((RecoilSettings)arg8).enabled) {
            return 0;
        }

        if(this.showPanel != ((RecoilSettings)arg8).showPanel) {
            return 0;
        }

        if(this.fixedPanel != ((RecoilSettings)arg8).fixedPanel) {
            return 0;
        }

        if(this.panelOpacity != ((RecoilSettings)arg8).panelOpacity) {
            return 0;
        }

        if(this.globalPercent != ((RecoilSettings)arg8).globalPercent) {
            return 0;
        }

        if(this.limitDuration != ((RecoilSettings)arg8).limitDuration) {
            return 0;
        }

        if(Double.compare(this.maxDurationSeconds, ((RecoilSettings)arg8).maxDurationSeconds) != 0) {
            return 0;
        }

        if(Double.compare(this.verticalSpeed, ((RecoilSettings)arg8).verticalSpeed) != 0) {
            return 0;
        }

        if(this.downward != ((RecoilSettings)arg8).downward) {
            return 0;
        }

        if(Double.compare(this.horizontalSpeed, ((RecoilSettings)arg8).horizontalSpeed) != 0) {
            return 0;
        }

        return 1;
    }

    public final double getCoefficient() {
        return ((double)((((float)this.globalPercent)) / 100f));
    }

    public final boolean getDownward() {
        return this.downward;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getFixedPanel() {
        return this.fixedPanel;
    }

    public final int getGlobalPercent() {
        return this.globalPercent;
    }

    public final double getHorizontalSpeed() {
        return this.horizontalSpeed;
    }

    public final boolean getLimitDuration() {
        return this.limitDuration;
    }

    public final double getMaxDurationSeconds() {
        return this.maxDurationSeconds;
    }

    public final int getPanelOpacity() {
        return this.panelOpacity;
    }

    public final boolean getShowPanel() {
        return this.showPanel;
    }

    public final double getSignedVerticalSpeed() {
        boolean v0 = this.downward;
        double v1 = this.verticalSpeed;
        if(v0) {
            return v1;
        }

        return -v1;
    }

    public final double getVerticalSpeed() {
        return this.verticalSpeed;
    }

    public int hashCode() {
        return ((((((((Boolean.hashCode(this.enabled) * 0x1F + Boolean.hashCode(this.showPanel)) * 0x1F + Boolean.hashCode(this.fixedPanel)) * 0x1F + Integer.hashCode(this.panelOpacity)) * 0x1F + Integer.hashCode(this.globalPercent)) * 0x1F + Boolean.hashCode(this.limitDuration)) * 0x1F + Double.hashCode(this.maxDurationSeconds)) * 0x1F + Double.hashCode(this.verticalSpeed)) * 0x1F + Boolean.hashCode(this.downward)) * 0x1F + Double.hashCode(this.horizontalSpeed);
    }

    public String toString() {
        return "RecoilSettings(enabled=" + this.enabled + ", showPanel=" + this.showPanel + ", fixedPanel=" + this.fixedPanel + ", panelOpacity=" + this.panelOpacity + ", globalPercent=" + this.globalPercent + ", limitDuration=" + this.limitDuration + ", maxDurationSeconds=" + this.maxDurationSeconds + ", verticalSpeed=" + this.verticalSpeed + ", downward=" + this.downward + ", horizontalSpeed=" + this.horizontalSpeed + ")";
    }
}

