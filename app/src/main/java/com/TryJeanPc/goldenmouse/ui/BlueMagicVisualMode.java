package com.TryJeanPc.goldenmouse.ui;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0017\u001A\u00020\u0000R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000E¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/BlueMagicVisualMode;", "", "label", "", "tint", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getLabel", "()Ljava/lang/String;", "getTint", "()I", "POWER_SAVING", "BALANCED", "PERFORMANCE", "fill", "", "getFill", "()[I", "glow", "getGlow", "activeCardColor", "getActiveCardColor", "next", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum BlueMagicVisualMode {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0001¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/BlueMagicVisualMode$Companion;", "", "<init>", "()V", "fromPreference", "Lcom/TryJeanPc/goldenmouse/ui/BlueMagicVisualMode;", "value", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final BlueMagicVisualMode fromPreference(Object arg2) {
            Integer v2;
            EnumEntries v1 = BlueMagicVisualMode.getEntries();
            if((arg2 instanceof Integer)) {
            }
            else {
                v2 = null;
            }

            int v2_1 = 0 != 0 ? v2.intValue() : -1;
            Object v1_1 = CollectionsKt.getOrNull(((List)v1), v2_1);
            if(v1_1 == null) {
                BlueMagicVisualMode v1_2 = BlueMagicVisualMode.POWER_SAVING;
            }

            return ((BlueMagicVisualMode)v1_1);
        }
    }

    public static final enum BlueMagicVisualMode BALANCED;
    public static final Companion Companion;
    public static final enum BlueMagicVisualMode PERFORMANCE;
    public static final enum BlueMagicVisualMode POWER_SAVING;
    private final int activeCardColor;
    private final int[] fill;
    private final int[] glow;
    private final String label;
    private final int tint;

    private static final BlueMagicVisualMode[] $values() {
        return new BlueMagicVisualMode[]{BlueMagicVisualMode.POWER_SAVING, BlueMagicVisualMode.BALANCED, BlueMagicVisualMode.PERFORMANCE};
    }

    static {
        BlueMagicVisualMode.POWER_SAVING = new BlueMagicVisualMode("POWER_SAVING", 0, "Power Saving", -5811);
        BlueMagicVisualMode.BALANCED = new BlueMagicVisualMode("BALANCED", 1, "Balanced", 0xFFBF40FF);
        BlueMagicVisualMode.PERFORMANCE = new BlueMagicVisualMode("PERFORMANCE", 2, "Performance", 0xFFFF355E);
        BlueMagicVisualMode[] v0 = BlueMagicVisualMode.$values();
        BlueMagicVisualMode.$VALUES = v0;
        BlueMagicVisualMode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        BlueMagicVisualMode.Companion = new Companion(null);
    }

    private BlueMagicVisualMode(String arg2, int arg3, String arg4, int arg5) {
        super(arg2, arg3);
        this.label = arg4;
        this.tint = arg5;
        this.fill = new int[]{BlueMagicVisualModeKt.blendBlueMagicColor(arg5, -1, 0.65f), arg5, BlueMagicVisualModeKt.blendBlueMagicColor(arg5, 0xFF000000, 0.55f)};
        this.glow = new int[]{BlueMagicVisualModeKt.blendBlueMagicColor(arg5, -1, 0.9f), BlueMagicVisualModeKt.blendBlueMagicColor(arg5, -1, 0.4f), arg5};
        this.activeCardColor = 0xFFFFFF & arg5 | 0x26000000;
    }

    public final int getActiveCardColor() {
        return this.activeCardColor;
    }

    public static EnumEntries getEntries() {
        return BlueMagicVisualMode.$ENTRIES;
    }

    public final int[] getFill() {
        return this.fill;
    }

    public final int[] getGlow() {
        return this.glow;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getTint() {
        return this.tint;
    }

    public final BlueMagicVisualMode next() {
        return BlueMagicVisualMode.getEntries().get((this.ordinal() + 1) % BlueMagicVisualMode.getEntries().size());
    }

    public static BlueMagicVisualMode valueOf(String arg1) {
        return Enum.valueOf(BlueMagicVisualMode.class, arg1);
    }

    public static BlueMagicVisualMode[] values() {
        return BlueMagicVisualMode.$VALUES.clone();
    }
}

