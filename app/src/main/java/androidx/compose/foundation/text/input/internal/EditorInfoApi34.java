package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Landroidx/compose/foundation/text/input/internal/EditorInfoApi34;", "", "<init>", "()V", "setHandwritingGestures", "", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class EditorInfoApi34 {
    public static final EditorInfoApi34 INSTANCE;

    static {
        EditorInfoApi34.INSTANCE = new EditorInfoApi34();
    }

    private EditorInfoApi34() {
        super();
    }

    public final void setHandwritingGestures(EditorInfo arg12) {
        Class[] v11 = new Class[7];
        Class v0 = SelectGesture.class;
        v11[0] = v0;
        Class v2 = DeleteGesture.class;
        v11[1] = v2;
        Class v4 = SelectRangeGesture.class;
        v11[2] = v4;
        Class v6 = DeleteRangeGesture.class;
        v11[3] = v6;
        v11[4] = JoinOrSplitGesture.class;
        v11[5] = InsertGesture.class;
        v11[6] = RemoveSpaceGesture.class;
        arg12.setSupportedHandwritingGestures(CollectionsKt.listOf(((Object[])v11)));
        arg12.setSupportedHandwritingGesturePreviews(SetsKt.setOf(new Class[]{v0, v2, v4, v6}));
    }
}

