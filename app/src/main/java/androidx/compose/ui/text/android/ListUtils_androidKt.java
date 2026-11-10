package androidx.compose.ui.text.android;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001F\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001A8\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A]\u0010\u0006\u001A\u0002H\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b\"\u0010\b\u0002\u0010\u0007*\n\u0012\u0006\b\u0000\u0012\u0002H\b0\t*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001A\u0002H\u00072\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0005H\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\f\u001AJ\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\b0\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u000EH\u0080\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¨\u0006\u000F"}, d2={"fastForEach", "", "T", "", "action", "Lkotlin/Function1;", "fastMapTo", "C", "R", "", "destination", "transform", "(Ljava/util/List;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fastZipWithNext", "Lkotlin/Function2;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ListUtils_androidKt {
    public static final void fastForEach(List arg3, Function1 arg4) {
        int v0 = arg3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4.invoke(arg3.get(v1));
        }
    }

    public static final Collection fastMapTo(List arg3, Collection arg4, Function1 arg5) {
        int v0 = arg3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4.add(arg5.invoke(arg3.get(v1)));
        }

        return arg4;
    }

    public static final List fastZipWithNext(List arg5, Function2 arg6) {
        if(arg5.size() <= 1) {
            return CollectionsKt.emptyList();
        }

        ArrayList v0 = new ArrayList();
        int v1 = 0;
        Object v2 = arg5.get(0);
        int v3 = CollectionsKt.getLastIndex(arg5);
        while(v1 < v3) {
            ++v1;
            Object v4 = arg5.get(v1);
            ((List)v0).add(arg6.invoke(v2, v4));
            v2 = v4;
        }

        return ((List)v0);
    }
}

