package androidx.compose.runtime.composer.linkbuffer.changelist;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/changelist/ComposerChangeListWriterAddressMode;", "", "<init>", "(Ljava/lang/String;I)V", "AbsoluteAddressing", "AnchorAddressing", "RelativeAddressing", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public enum ComposerChangeListWriterAddressMode {
    public static final enum ComposerChangeListWriterAddressMode AbsoluteAddressing;
    public static final enum ComposerChangeListWriterAddressMode AnchorAddressing;
    public static final enum ComposerChangeListWriterAddressMode RelativeAddressing;

    private static final ComposerChangeListWriterAddressMode[] $values() {
        return new ComposerChangeListWriterAddressMode[]{ComposerChangeListWriterAddressMode.AbsoluteAddressing, ComposerChangeListWriterAddressMode.AnchorAddressing, ComposerChangeListWriterAddressMode.RelativeAddressing};
    }

    static {
        ComposerChangeListWriterAddressMode.AbsoluteAddressing = new ComposerChangeListWriterAddressMode("AbsoluteAddressing", 0);
        ComposerChangeListWriterAddressMode.AnchorAddressing = new ComposerChangeListWriterAddressMode("AnchorAddressing", 1);
        ComposerChangeListWriterAddressMode.RelativeAddressing = new ComposerChangeListWriterAddressMode("RelativeAddressing", 2);
        ComposerChangeListWriterAddressMode[] v0 = ComposerChangeListWriterAddressMode.$values();
        ComposerChangeListWriterAddressMode.$VALUES = v0;
        ComposerChangeListWriterAddressMode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private ComposerChangeListWriterAddressMode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return ComposerChangeListWriterAddressMode.$ENTRIES;
    }

    public static ComposerChangeListWriterAddressMode valueOf(String arg1) {
        return Enum.valueOf(ComposerChangeListWriterAddressMode.class, arg1);
    }

    public static ComposerChangeListWriterAddressMode[] values() {
        return ComposerChangeListWriterAddressMode.$VALUES.clone();
    }
}

