package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AB\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001C\u0010\u0004\u001A\u0018\u0012\t\u0012\u0007H\u0003¢\u0006\u0002\b\u0006\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u00060\u0005H\u0007\u001A8\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\bH\u0007\u001AJ\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012$\u0010\u0004\u001A \u0012\t\u0012\u0007H\u0003¢\u0006\u0002\b\u0006\u0012\u0011\u0012\u000F\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00060\u0005H\u0007\u001A>\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\n\u001A\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\bH\u0007\u001A\u001E\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007¨\u0006\f"}, d2={"map", "Landroidx/lifecycle/LiveData;", "Y", "X", "transform", "Lkotlin/Function1;", "Lkotlin/jvm/JvmSuppressWildcards;", "mapFunction", "Landroidx/arch/core/util/Function;", "switchMap", "switchMapFunction", "distinctUntilChanged", "lifecycle-livedata"}, k=2, mv={2, 1, 0}, xi=0x30) public final class Transformations {
    public static Unit $r8$lambda$skahzJt915myAFMlecWfN1CaVsE(MediatorLiveData arg0, Object arg1) {
        return Transformations.switchMap$lambda$0$0(arg0, arg1);
    }

    public static final LiveData distinctUntilChanged(LiveData arg3) {
        MediatorLiveData v1;
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        BooleanRef v0 = new BooleanRef();
        v0.element = true;
        if(arg3.isInitialized()) {
            v0.element = false;
            v1 = new MediatorLiveData(arg3.getValue());
        }
        else {
            v1 = new MediatorLiveData();
        }

        v1.addSource(arg3, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$$ExternalSyntheticLambda3(v1, v0)));
        return ((LiveData)v1);
    }

    static final Unit distinctUntilChanged$lambda$0(MediatorLiveData arg2, BooleanRef arg3, Object arg4) {
        Object v0 = arg2.getValue();
        if(!arg3.element) {
            if(v0 == null && arg4 != null) {
                goto label_8;
            }

            if(v0 == null) {
                goto label_11;
            }

            if(Intrinsics.areEqual(v0, arg4)) {
                goto label_11;
            }

            goto label_8;
        }
        else {
        label_8:
            arg3.element = false;
            arg2.setValue(arg4);
        }

    label_11:
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use kotlin functions, instead of outdated arch core Functions") public static final LiveData map(LiveData arg2, Function arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "mapFunction");
        MediatorLiveData v0 = new MediatorLiveData();
        v0.addSource(arg2, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$$ExternalSyntheticLambda4(v0, arg3)));
        return ((LiveData)v0);
    }

    public static final LiveData map(LiveData arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        MediatorLiveData v0 = arg2.isInitialized() ? new MediatorLiveData(arg3.invoke(arg2.getValue())) : new MediatorLiveData();
        v0.addSource(arg2, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$$ExternalSyntheticLambda1(v0, arg3)));
        return ((LiveData)v0);
    }

    static final Unit map$lambda$0(MediatorLiveData arg0, Function1 arg1, Object arg2) {
        arg0.setValue(arg1.invoke(arg2));
        return Unit.INSTANCE;
    }

    static final Unit map$lambda$1(MediatorLiveData arg0, Function arg1, Object arg2) {
        arg0.setValue(arg1.apply(arg2));
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use kotlin functions, instead of outdated arch core Functions") public static final LiveData switchMap(LiveData arg2, Function arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "switchMapFunction");
        MediatorLiveData v0 = new MediatorLiveData();
        v0.addSource(arg2, new Transformations$switchMap$2(arg3, v0));
        return ((LiveData)v0);
    }

    public static final LiveData switchMap(LiveData arg3, Function1 arg4) {
        MediatorLiveData v2;
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "transform");
        ObjectRef v0 = new ObjectRef();
        if(arg3.isInitialized()) {
            Object v1 = arg4.invoke(arg3.getValue());
            if(v1 != null && (((LiveData)v1).isInitialized())) {
                v2 = new MediatorLiveData(((LiveData)v1).getValue());
                goto label_22;
            }

            v2 = new MediatorLiveData();
        }
        else {
            v2 = new MediatorLiveData();
        }

    label_22:
        v2.addSource(arg3, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$$ExternalSyntheticLambda0(arg4, v0, v2)));
        return ((LiveData)v2);
    }

    static final Unit switchMap$lambda$0(Function1 arg0, ObjectRef arg1, MediatorLiveData arg2, Object arg3) {
        Object v0 = arg0.invoke(arg3);
        if(arg1.element != v0) {
            if(arg1.element != null) {
                arg3 = arg1.element;
                Intrinsics.checkNotNull(arg3);
                arg2.removeSource(((LiveData)arg3));
            }

            arg1.element = v0;
            if(arg1.element == null) {
                goto label_18;
            }

            v0 = arg1.element;
            Intrinsics.checkNotNull(v0);
            arg2.addSource(((LiveData)v0), new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$$ExternalSyntheticLambda2(arg2)));
        }

    label_18:
        return Unit.INSTANCE;
    }

    private static final Unit switchMap$lambda$0$0(MediatorLiveData arg0, Object arg1) {
        arg0.setValue(arg1);
        return Unit.INSTANCE;
    }
}

