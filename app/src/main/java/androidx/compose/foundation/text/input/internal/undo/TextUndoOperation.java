package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.text.UndoManager_jvmKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 $2\u00020\u0001:\u0001$BC\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0018\u0010\u0016R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0016R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\u001C\u001A\u00020\u001D¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0011\u0010 \u001A\u00020!8F¢\u0006\u0006\u001A\u0004\b\"\u0010#¨\u0006%"}, d2={"Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "", "index", "", "preText", "", "postText", "preSelection", "Landroidx/compose/ui/text/TextRange;", "postSelection", "timeInMillis", "", "canMerge", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;JJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getPreText", "()Ljava/lang/String;", "getPostText", "getPreSelection-d9O1mEE", "()J", "J", "getPostSelection-d9O1mEE", "getTimeInMillis", "getCanMerge", "()Z", "textEditType", "Landroidx/compose/foundation/text/input/internal/undo/TextEditType;", "getTextEditType", "()Landroidx/compose/foundation/text/input/internal/undo/TextEditType;", "deletionType", "Landroidx/compose/foundation/text/input/internal/undo/TextDeleteType;", "getDeletionType", "()Landroidx/compose/foundation/text/input/internal/undo/TextDeleteType;", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextUndoOperation {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001D\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return TextUndoOperation.Saver;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final Saver Saver;
    private final boolean canMerge;
    private final int index;
    private final long postSelection;
    private final String postText;
    private final long preSelection;
    private final String preText;
    private final TextEditType textEditType;
    private final long timeInMillis;

    static {
        TextUndoOperation.Companion = new Companion(null);
        TextUndoOperation.Saver = new TextUndoOperation$Companion$Saver$1();
    }

    public TextUndoOperation(int arg15, String arg16, String arg17, long arg18, long arg20, long arg22, boolean arg24, int arg25, DefaultConstructorMarker arg26) {
        long v10 = (arg25 & 0x20) != 0 ? UndoManager_jvmKt.timeNowMillis() : arg22;
        boolean v12 = (arg25 & 0x40) != 0 ? true : arg24;
        this(arg15, arg16, arg17, arg18, arg20, v10, v12, null);
    }

    private TextUndoOperation(int arg1, String arg2, String arg3, long arg4, long arg6, long arg8, boolean arg10) {
        TextEditType v1;
        super();
        this.index = arg1;
        this.preText = arg2;
        this.postText = arg3;
        this.preSelection = arg4;
        this.postSelection = arg6;
        this.timeInMillis = arg8;
        this.canMerge = arg10;
        if(arg2.length() == 0) {
            if(arg3.length() != 0) {
            }
            else {
                throw new IllegalArgumentException("Either pre or post text must not be empty");
            }
        }

        if(arg2.length() != 0 || arg3.length() <= 0) {
            if(((CharSequence)arg2).length() > 0 && ((CharSequence)arg3).length() == 0) {
                v1 = TextEditType.Delete;
                goto label_34;
            }

            v1 = TextEditType.Replace;
        }
        else {
            v1 = TextEditType.Insert;
        }

    label_34:
        this.textEditType = v1;
    }

    public TextUndoOperation(int arg1, String arg2, String arg3, long arg4, long arg6, long arg8, boolean arg10, DefaultConstructorMarker arg11) {
        this(arg1, arg2, arg3, arg4, arg6, arg8, arg10);
    }

    public static final Saver access$getSaver$cp() {
        return TextUndoOperation.Saver;
    }

    public final boolean getCanMerge() {
        return this.canMerge;
    }

    public final TextDeleteType getDeletionType() {
        if(this.textEditType != TextEditType.Delete) {
            return TextDeleteType.NotByUser;
        }

        if(!TextRange.getCollapsed-impl(this.postSelection)) {
            return TextDeleteType.NotByUser;
        }

        boolean v0 = TextRange.getCollapsed-impl(this.preSelection);
        long v1 = this.preSelection;
        if(v0) {
            if(TextRange.getStart-impl(v1) > TextRange.getStart-impl(this.postSelection)) {
                return TextDeleteType.Start;
            }

            return TextDeleteType.End;
        }

        if(TextRange.getStart-impl(v1) == TextRange.getStart-impl(this.postSelection) && TextRange.getStart-impl(this.preSelection) == this.index) {
            return TextDeleteType.Inner;
        }

        return TextDeleteType.NotByUser;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getPostSelection-d9O1mEE() {
        return this.postSelection;
    }

    public final String getPostText() {
        return this.postText;
    }

    public final long getPreSelection-d9O1mEE() {
        return this.preSelection;
    }

    public final String getPreText() {
        return this.preText;
    }

    public final TextEditType getTextEditType() {
        return this.textEditType;
    }

    public final long getTimeInMillis() {
        return this.timeInMillis;
    }
}

