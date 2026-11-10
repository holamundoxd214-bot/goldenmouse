package androidx.compose.ui.autofill;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2={"Landroidx/compose/ui/autofill/ContentDataType;", "", "Companion", "Landroidx/compose/ui/autofill/AndroidContentDataType;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ContentDataType {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007R\u0011\u0010\u000E\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0007¨\u0006\u0010"}, d2={"Landroidx/compose/ui/autofill/ContentDataType$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/autofill/ContentDataType;", "getNone", "()Landroidx/compose/ui/autofill/ContentDataType;", "Text", "getText", "List", "getList", "Date", "getDate", "Toggle", "getToggle", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        private static final ContentDataType Date;
        private static final ContentDataType List;
        private static final ContentDataType None;
        private static final ContentDataType Text;
        private static final ContentDataType Toggle;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.None = ContentDataType_androidKt.ContentDataType(0);
            Companion.Text = ContentDataType_androidKt.ContentDataType(1);
            Companion.List = ContentDataType_androidKt.ContentDataType(3);
            Companion.Date = ContentDataType_androidKt.ContentDataType(4);
            Companion.Toggle = ContentDataType_androidKt.ContentDataType(2);
        }

        private Companion() {
            super();
        }

        public final ContentDataType getDate() {
            return Companion.Date;
        }

        public final ContentDataType getList() {
            return Companion.List;
        }

        public final ContentDataType getNone() {
            return Companion.None;
        }

        public final ContentDataType getText() {
            return Companion.Text;
        }

        public final ContentDataType getToggle() {
            return Companion.Toggle;
        }
    }

    public static final Companion Companion;

    static {
        ContentDataType.Companion = Companion.$$INSTANCE;
    }
}

