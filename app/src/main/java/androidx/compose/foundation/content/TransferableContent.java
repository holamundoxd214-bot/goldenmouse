package androidx.compose.foundation.content;

import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B-\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0006\u001A\u00020\u0007¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2={"Landroidx/compose/foundation/content/TransferableContent;", "", "clipEntry", "Landroidx/compose/ui/platform/ClipEntry;", "clipMetadata", "Landroidx/compose/ui/platform/ClipMetadata;", "source", "Landroidx/compose/foundation/content/TransferableContent$Source;", "platformTransferableContent", "Landroidx/compose/foundation/content/PlatformTransferableContent;", "<init>", "(Landroidx/compose/ui/platform/ClipEntry;Landroidx/compose/ui/platform/ClipMetadata;ILandroidx/compose/foundation/content/PlatformTransferableContent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getClipEntry", "()Landroidx/compose/ui/platform/ClipEntry;", "getClipMetadata", "()Landroidx/compose/ui/platform/ClipMetadata;", "getSource-kB6V9T0", "()I", "I", "getPlatformTransferableContent", "()Landroidx/compose/foundation/content/PlatformTransferableContent;", "Source", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TransferableContent {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/content/TransferableContent$Source;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Source {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/foundation/content/TransferableContent$Source$Companion;", "", "<init>", "()V", "Keyboard", "Landroidx/compose/foundation/content/TransferableContent$Source;", "getKeyboard-kB6V9T0", "()I", "I", "DragAndDrop", "getDragAndDrop-kB6V9T0", "Clipboard", "getClipboard-kB6V9T0", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            public final int getClipboard-kB6V9T0() {
                return Source.Clipboard;
            }

            public final int getDragAndDrop-kB6V9T0() {
                return Source.DragAndDrop;
            }

            public final int getKeyboard-kB6V9T0() {
                return Source.Keyboard;
            }
        }

        private static final int Clipboard;
        public static final Companion Companion;
        private static final int DragAndDrop;
        private static final int Keyboard;
        private final int value;

        static {
            Source.Companion = new Companion(null);
            Source.Keyboard = Source.constructor-impl(0);
            Source.DragAndDrop = Source.constructor-impl(1);
            Source.Clipboard = Source.constructor-impl(2);
        }

        private Source(int arg1) {
            super();
            this.value = arg1;
        }

        public static final int access$getClipboard$cp() {
            return Source.Clipboard;
        }

        public static final int access$getDragAndDrop$cp() {
            return Source.DragAndDrop;
        }

        public static final int access$getKeyboard$cp() {
            return Source.Keyboard;
        }

        public static final Source box-impl(int arg1) {
            return new Source(arg1);
        }

        public static int constructor-impl(int arg0) {
            return arg0;
        }

        public boolean equals(Object arg1) {
            return Source.equals-impl(this.value, arg1);
        }

        public static boolean equals-impl(int arg2, Object arg3) {
            if(!(arg3 instanceof Source)) {
                return 0;
            }

            if(arg2 != ((Source)arg3).unbox-impl()) {
                return 0;
            }

            return 1;
        }

        public static final boolean equals-impl0(int arg0, int arg1) {
            if(arg0 == arg1) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return Source.hashCode-impl(this.value);
        }

        public static int hashCode-impl(int arg0) {
            return Integer.hashCode(arg0);
        }

        public String toString() {
            return Source.toString-impl(this.value);
        }

        public static String toString-impl(int arg2) {
            if(Source.equals-impl0(arg2, Source.Keyboard)) {
                return "Source.Keyboard";
            }

            if(Source.equals-impl0(arg2, Source.DragAndDrop)) {
                return "Source.DragAndDrop";
            }

            if(Source.equals-impl0(arg2, Source.Clipboard)) {
                return "Source.Clipboard";
            }

            return "Invalid (" + arg2 + ')';
        }

        public final int unbox-impl() {
            return this.value;
        }
    }

    public static final int $stable = 8;
    private final ClipEntry clipEntry;
    private final ClipMetadata clipMetadata;
    private final PlatformTransferableContent platformTransferableContent;
    private final int source;

    static {
    }

    private TransferableContent(ClipEntry arg1, ClipMetadata arg2, int arg3, PlatformTransferableContent arg4) {
        super();
        this.clipEntry = arg1;
        this.clipMetadata = arg2;
        this.source = arg3;
        this.platformTransferableContent = arg4;
    }

    public TransferableContent(ClipEntry arg7, ClipMetadata arg8, int arg9, PlatformTransferableContent arg10, int arg11, DefaultConstructorMarker arg12) {
        if((arg11 & 8) != 0) {
            arg10 = null;
        }

        this(arg7, arg8, arg9, arg10, null);
    }

    public TransferableContent(ClipEntry arg1, ClipMetadata arg2, int arg3, PlatformTransferableContent arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public final ClipEntry getClipEntry() {
        return this.clipEntry;
    }

    public final ClipMetadata getClipMetadata() {
        return this.clipMetadata;
    }

    public final PlatformTransferableContent getPlatformTransferableContent() {
        return this.platformTransferableContent;
    }

    public final int getSource-kB6V9T0() {
        return this.source;
    }
}

