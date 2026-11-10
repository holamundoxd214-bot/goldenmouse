package androidx.compose.ui.text.android;

import android.text.Layout$Alignment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/ui/text/android/TextAlignmentAdapter;", "", "<init>", "()V", "ALIGN_LEFT_FRAMEWORK", "Landroid/text/Layout$Alignment;", "ALIGN_RIGHT_FRAMEWORK", "get", "value", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextAlignmentAdapter {
    public static final int $stable;
    private static final Layout$Alignment ALIGN_LEFT_FRAMEWORK;
    private static final Layout$Alignment ALIGN_RIGHT_FRAMEWORK;
    public static final TextAlignmentAdapter INSTANCE;

    static {
        TextAlignmentAdapter.INSTANCE = new TextAlignmentAdapter();
        Layout$Alignment[] v0 = Layout$Alignment.values();
        Layout$Alignment v1 = Layout$Alignment.ALIGN_NORMAL;
        Layout$Alignment v2 = Layout$Alignment.ALIGN_NORMAL;
        int v3 = v0.length;
        int v4;
        for(v4 = 0; v4 < v3; ++v4) {
            Layout$Alignment v5 = v0[v4];
            if(Intrinsics.areEqual(v5.name(), "ALIGN_LEFT")) {
                v1 = v5;
            }
            else if(Intrinsics.areEqual(v5.name(), "ALIGN_RIGHT")) {
                v2 = v5;
            }
        }

        TextAlignmentAdapter.ALIGN_LEFT_FRAMEWORK = v1;
        TextAlignmentAdapter.ALIGN_RIGHT_FRAMEWORK = v2;
    }

    private TextAlignmentAdapter() {
        super();
    }

    public final Layout$Alignment get(int arg1) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                if(arg1 != 2) {
                    if(arg1 != 3) {
                        if(arg1 != 4) {
                            return Layout$Alignment.ALIGN_NORMAL;
                        }

                        return TextAlignmentAdapter.ALIGN_RIGHT_FRAMEWORK;
                    }

                    return TextAlignmentAdapter.ALIGN_LEFT_FRAMEWORK;
                }

                return Layout$Alignment.ALIGN_CENTER;
            }

            return Layout$Alignment.ALIGN_OPPOSITE;
        }

        return Layout$Alignment.ALIGN_NORMAL;
    }
}

