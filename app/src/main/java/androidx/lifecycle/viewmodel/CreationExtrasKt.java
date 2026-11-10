package androidx.lifecycle.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A-\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00012\u0019\b\u0002\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007\u001A\u0019\u0010\b\u001A\u00020\t*\u00020\u00012\n\u0010\n\u001A\u0006\u0012\u0002\b\u00030\u000BH\u0086\u0002\u001A\u0015\u0010\f\u001A\u00020\u0005*\u00020\u00012\u0006\u0010\r\u001A\u00020\u0001H\u0086\u0002\u001A\u0015\u0010\u000E\u001A\u00020\u0006*\u00020\u00052\u0006\u0010\r\u001A\u00020\u0001H\u0086\u0002¨\u0006\u000F"}, d2={"CreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "initialExtras", "builderAction", "Lkotlin/Function1;", "Landroidx/lifecycle/viewmodel/MutableCreationExtras;", "", "Lkotlin/ExtensionFunctionType;", "contains", "", "key", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "plus", "creationExtras", "plusAssign", "lifecycle-viewmodel"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CreationExtrasKt {
    public static final CreationExtras CreationExtras() {
        return CreationExtrasKt.CreationExtras$default(null, null, 3, null);
    }

    public static final CreationExtras CreationExtras(CreationExtras arg2) {
        Intrinsics.checkNotNullParameter(arg2, "initialExtras");
        return CreationExtrasKt.CreationExtras$default(arg2, null, 2, null);
    }

    public static final CreationExtras CreationExtras(CreationExtras arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "initialExtras");
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        MutableCreationExtras v0 = new MutableCreationExtras(arg1);
        arg2.invoke(v0);
        return ((CreationExtras)v0);
    }

    public static CreationExtras CreationExtras$default(CreationExtras arg0, Function1 arg1, int arg2, Object arg3) {
        CreationExtrasKt$$ExternalSyntheticLambda0 v1;
        Empty v0;
        if((arg2 & 1) != 0) {
            v0 = Empty.INSTANCE;
        }

        if((arg2 & 2) != 0) {
            v1 = new CreationExtrasKt$$ExternalSyntheticLambda0();
        }

        return CreationExtrasKt.CreationExtras(((CreationExtras)v0), ((Function1)v1));
    }

    static final Unit CreationExtras$lambda$0(MutableCreationExtras arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Unit.INSTANCE;
    }

    public static final boolean contains(CreationExtras arg1, Key arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getExtras$lifecycle_viewmodel().containsKey(arg2);
    }

    public static final MutableCreationExtras plus(CreationExtras arg1, CreationExtras arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "creationExtras");
        return new MutableCreationExtras(MapsKt.plus(arg1.getExtras$lifecycle_viewmodel(), arg2.getExtras$lifecycle_viewmodel()));
    }

    public static final void plusAssign(MutableCreationExtras arg1, CreationExtras arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "creationExtras");
        arg1.getExtras$lifecycle_viewmodel().putAll(arg2.getExtras$lifecycle_viewmodel());
    }
}

