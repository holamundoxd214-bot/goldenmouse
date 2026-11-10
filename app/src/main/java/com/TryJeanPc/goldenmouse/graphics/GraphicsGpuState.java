package com.TryJeanPc.goldenmouse.graphics;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsGpuState;", "", "<init>", "(Ljava/lang/String;I)V", "ANGLE", "NATIVE_VULKAN", "UNVERIFIABLE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum GraphicsGpuState {
    public static final enum GraphicsGpuState ANGLE;
    public static final enum GraphicsGpuState NATIVE_VULKAN;
    public static final enum GraphicsGpuState UNVERIFIABLE;

    private static final GraphicsGpuState[] $values() {
        return new GraphicsGpuState[]{GraphicsGpuState.ANGLE, GraphicsGpuState.NATIVE_VULKAN, GraphicsGpuState.UNVERIFIABLE};
    }

    static {
        GraphicsGpuState.ANGLE = new GraphicsGpuState("ANGLE", 0);
        GraphicsGpuState.NATIVE_VULKAN = new GraphicsGpuState("NATIVE_VULKAN", 1);
        GraphicsGpuState.UNVERIFIABLE = new GraphicsGpuState("UNVERIFIABLE", 2);
        GraphicsGpuState[] v0 = GraphicsGpuState.$values();
        GraphicsGpuState.$VALUES = v0;
        GraphicsGpuState.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private GraphicsGpuState(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return GraphicsGpuState.$ENTRIES;
    }

    public static GraphicsGpuState valueOf(String arg1) {
        return Enum.valueOf(GraphicsGpuState.class, arg1);
    }

    public static GraphicsGpuState[] values() {
        return GraphicsGpuState.$VALUES.clone();
    }
}

