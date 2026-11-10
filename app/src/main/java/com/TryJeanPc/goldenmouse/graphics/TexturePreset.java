package com.TryJeanPc.goldenmouse.graphics;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/TexturePreset;", "", "<init>", "(Ljava/lang/String;I)V", "SOFT", "RETRO", "BLOCKS", "CUSTOM", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum TexturePreset {
    public static final enum TexturePreset BLOCKS;
    public static final enum TexturePreset CUSTOM;
    public static final enum TexturePreset RETRO;
    public static final enum TexturePreset SOFT;

    private static final TexturePreset[] $values() {
        return new TexturePreset[]{TexturePreset.SOFT, TexturePreset.RETRO, TexturePreset.BLOCKS, TexturePreset.CUSTOM};
    }

    static {
        TexturePreset.SOFT = new TexturePreset("SOFT", 0);
        TexturePreset.RETRO = new TexturePreset("RETRO", 1);
        TexturePreset.BLOCKS = new TexturePreset("BLOCKS", 2);
        TexturePreset.CUSTOM = new TexturePreset("CUSTOM", 3);
        TexturePreset[] v0 = TexturePreset.$values();
        TexturePreset.$VALUES = v0;
        TexturePreset.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private TexturePreset(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return TexturePreset.$ENTRIES;
    }

    public static TexturePreset valueOf(String arg1) {
        return Enum.valueOf(TexturePreset.class, arg1);
    }

    public static TexturePreset[] values() {
        return TexturePreset.$VALUES.clone();
    }
}

