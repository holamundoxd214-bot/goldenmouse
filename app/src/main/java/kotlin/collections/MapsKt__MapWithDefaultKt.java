package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\u001A5\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001A\u0002H\u0002H\u0081\u0080\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001AU\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032!\u0010\b\u001A\u001D\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\tH\u0086\u0080\u0004\u001AZ\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\f2!\u0010\b\u001A\u001D\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000B\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\tH\u0087\u0080\u0004¢\u0006\u0002\b\r¨\u0006\u000E"}, d2={"getOrImplicitDefault", "V", "K", "", "key", "getOrImplicitDefaultNullable", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "withDefault", "defaultValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "withDefaultMutable", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/MapsKt") class MapsKt__MapWithDefaultKt {
    public MapsKt__MapWithDefaultKt() {
        super();
    }

    public static final Object getOrImplicitDefaultNullable(Map arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if((arg2 instanceof MapWithDefault)) {
            return ((MapWithDefault)arg2).getOrImplicitDefault(arg3);
        }

        Object v0 = arg2.get(arg3);
        if(v0 == null) {
            if(arg2.containsKey(arg3)) {
            }
            else {
                throw new NoSuchElementException("Key " + arg3 + " is missing in the map.");
            }
        }

        return v0;
    }

    public static final Map withDefault(Map arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "defaultValue");
        if((arg1 instanceof MapWithDefault)) {
            return MapsKt.withDefault(((MapWithDefault)arg1).getMap(), arg2);
        }

        return new MapWithDefaultImpl(arg1, arg2);
    }

    public static final Map withDefaultMutable(Map arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "defaultValue");
        if((arg1 instanceof MutableMapWithDefault)) {
            return MapsKt.withDefaultMutable(((MutableMapWithDefault)arg1).getMap(), arg2);
        }

        return new MutableMapWithDefaultImpl(arg1, arg2);
    }
}

