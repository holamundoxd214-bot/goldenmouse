package androidx.compose.material3.carousel;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0000\b`\u0018\u00002\u00020\u0001J\u001A\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2={"Landroidx/compose/material3/carousel/KeylineListScope;", "", "add", "", "size", "", "isAnchor", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public interface KeylineListScope {
    void add(float arg1, boolean arg2);

    static void add$default(KeylineListScope arg0, float arg1, boolean arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            arg0.add(arg1, false);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: add");
    }
}

