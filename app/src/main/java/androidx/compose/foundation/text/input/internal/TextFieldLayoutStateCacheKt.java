package androidx.compose.foundation.text.input.internal;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001A6\u0010\u0000\u001A\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u000E\u0010\u0003\u001A\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0002¨\u0006\u0005"}, d2={"mergeNullableLists", "", "T", "first", "second", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldLayoutStateCacheKt {
    public static final List access$mergeNullableLists(List arg0, List arg1) {
        return TextFieldLayoutStateCacheKt.mergeNullableLists(arg0, arg1);
    }

    private static final List mergeNullableLists(List arg2, List arg3) {
        List v0 = arg2;
        if(v0 == null || (((Collection)v0).isEmpty())) {
            List v1 = arg3;
            if(v1 != null) {
                if(((Collection)v1).isEmpty()) {
                }
                else {
                    goto label_9;
                }
            }

            return null;
        }

    label_9:
        if(v0 != null) {
            if(((Collection)v0).isEmpty()) {
            }
            else {
                if(arg3 != null) {
                    if(((Collection)arg3).isEmpty()) {
                    }
                    else {
                        arg2 = CollectionsKt.createListBuilder();
                        arg2.addAll(((Collection)v0));
                        arg2.addAll(((Collection)arg3));
                        arg2 = CollectionsKt.build(arg2);
                    }
                }

                return arg2;
            }
        }

        return arg3;
    }
}

