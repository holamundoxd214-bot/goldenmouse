package androidx.compose.ui.contentcapture;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/ui/contentcapture/ContentCaptureEventType;", "", "<init>", "(Ljava/lang/String;I)V", "VIEW_APPEAR", "VIEW_DISAPPEAR", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) enum ContentCaptureEventType {
    public static final enum ContentCaptureEventType VIEW_APPEAR;
    public static final enum ContentCaptureEventType VIEW_DISAPPEAR;

    private static final ContentCaptureEventType[] $values() {
        return new ContentCaptureEventType[]{ContentCaptureEventType.VIEW_APPEAR, ContentCaptureEventType.VIEW_DISAPPEAR};
    }

    static {
        ContentCaptureEventType.VIEW_APPEAR = new ContentCaptureEventType("VIEW_APPEAR", 0);
        ContentCaptureEventType.VIEW_DISAPPEAR = new ContentCaptureEventType("VIEW_DISAPPEAR", 1);
        ContentCaptureEventType[] v0 = ContentCaptureEventType.$values();
        ContentCaptureEventType.$VALUES = v0;
        ContentCaptureEventType.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private ContentCaptureEventType(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return ContentCaptureEventType.$ENTRIES;
    }

    public static ContentCaptureEventType valueOf(String arg1) {
        return Enum.valueOf(ContentCaptureEventType.class, arg1);
    }

    public static ContentCaptureEventType[] values() {
        return ContentCaptureEventType.$VALUES.clone();
    }
}

