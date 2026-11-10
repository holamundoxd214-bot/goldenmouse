package com.TryJeanPc.goldenmouse.ui;

import com.TryJeanPc.goldenmouse.R$string;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/DecorativeEffect;", "", "key", "", "title", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getTitle", "()I", "CPU_RING", "RAM_RING", "CPU_PROGRESS", "RAM_PROGRESS", "CPU_OPENING", "RAM_OPENING", "MODE_MOVEMENT", "MODE_COLOR", "CPU_MODE_SWEEP", "RAM_MODE_SWEEP", "NOTIFICATION_FEEDBACK", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum DecorativeEffect {
    public static final enum DecorativeEffect CPU_MODE_SWEEP;
    public static final enum DecorativeEffect CPU_OPENING;
    public static final enum DecorativeEffect CPU_PROGRESS;
    public static final enum DecorativeEffect CPU_RING;
    public static final enum DecorativeEffect MODE_COLOR;
    public static final enum DecorativeEffect MODE_MOVEMENT;
    public static final enum DecorativeEffect NOTIFICATION_FEEDBACK;
    public static final enum DecorativeEffect RAM_MODE_SWEEP;
    public static final enum DecorativeEffect RAM_OPENING;
    public static final enum DecorativeEffect RAM_PROGRESS;
    public static final enum DecorativeEffect RAM_RING;
    private final String key;
    private final int title;

    private static final DecorativeEffect[] $values() {
        return new DecorativeEffect[]{DecorativeEffect.CPU_RING, DecorativeEffect.RAM_RING, DecorativeEffect.CPU_PROGRESS, DecorativeEffect.RAM_PROGRESS, DecorativeEffect.CPU_OPENING, DecorativeEffect.RAM_OPENING, DecorativeEffect.MODE_MOVEMENT, DecorativeEffect.MODE_COLOR, DecorativeEffect.CPU_MODE_SWEEP, DecorativeEffect.RAM_MODE_SWEEP, DecorativeEffect.NOTIFICATION_FEEDBACK};
    }

    static {
        DecorativeEffect.CPU_RING = new DecorativeEffect("CPU_RING", 0, "cpu_ring", string.decorative_cpu_ring);
        DecorativeEffect.RAM_RING = new DecorativeEffect("RAM_RING", 1, "ram_ring", string.decorative_ram_ring);
        DecorativeEffect.CPU_PROGRESS = new DecorativeEffect("CPU_PROGRESS", 2, "cpu_progress", string.decorative_cpu_progress);
        DecorativeEffect.RAM_PROGRESS = new DecorativeEffect("RAM_PROGRESS", 3, "ram_progress", string.decorative_ram_progress);
        DecorativeEffect.CPU_OPENING = new DecorativeEffect("CPU_OPENING", 4, "cpu_opening", string.decorative_cpu_opening);
        DecorativeEffect.RAM_OPENING = new DecorativeEffect("RAM_OPENING", 5, "ram_opening", string.decorative_ram_opening);
        DecorativeEffect.MODE_MOVEMENT = new DecorativeEffect("MODE_MOVEMENT", 6, "mode_movement", string.decorative_mode_movement);
        DecorativeEffect.MODE_COLOR = new DecorativeEffect("MODE_COLOR", 7, "mode_color", string.decorative_mode_color);
        DecorativeEffect.CPU_MODE_SWEEP = new DecorativeEffect("CPU_MODE_SWEEP", 8, "cpu_mode_sweep", string.decorative_cpu_mode_sweep);
        DecorativeEffect.RAM_MODE_SWEEP = new DecorativeEffect("RAM_MODE_SWEEP", 9, "ram_mode_sweep", string.decorative_ram_mode_sweep);
        DecorativeEffect.NOTIFICATION_FEEDBACK = new DecorativeEffect("NOTIFICATION_FEEDBACK", 10, "notification_feedback", string.decorative_notification_feedback);
        DecorativeEffect[] v0 = DecorativeEffect.$values();
        DecorativeEffect.$VALUES = v0;
        DecorativeEffect.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private DecorativeEffect(String arg1, int arg2, String arg3, int arg4) {
        super(arg1, arg2);
        this.key = arg3;
        this.title = arg4;
    }

    public static EnumEntries getEntries() {
        return DecorativeEffect.$ENTRIES;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getTitle() {
        return this.title;
    }

    public static DecorativeEffect valueOf(String arg1) {
        return Enum.valueOf(DecorativeEffect.class, arg1);
    }

    public static DecorativeEffect[] values() {
        return DecorativeEffect.$VALUES.clone();
    }
}

