package androidx.core.util;

import java.util.Objects;

public interface Predicate {
    default Predicate and(Predicate arg2) {
        Objects.requireNonNull(arg2);
        return new Predicate$$ExternalSyntheticLambda3(this, arg2);
    }

    static Predicate isEqual(Object arg1) {
        if(arg1 == null) {
            return new Predicate$$ExternalSyntheticLambda1();
        }

        return new Predicate$$ExternalSyntheticLambda2(arg1);
    }

    static boolean lambda$and$0(Predicate arg0, Predicate arg1, Object arg2) {
        if((arg0.test(arg2)) && (arg1.test(arg2))) {
            return 1;
        }

        return 0;
    }

    static boolean lambda$isEqual$3(Object arg0) {
        return Objects.isNull(arg0);
    }

    static boolean lambda$isEqual$4(Object arg0, Object arg1) {
        return arg0.equals(arg1);
    }

    static boolean lambda$negate$1(Predicate arg0, Object arg1) {
        return arg0.test(arg1) ^ 1;
    }

    static boolean lambda$or$2(Predicate arg0, Predicate arg1, Object arg2) {
        if(!arg0.test(arg2)) {
            if(arg1.test(arg2)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    default Predicate negate() {
        return new Predicate$$ExternalSyntheticLambda4(this);
    }

    static Predicate not(Predicate arg0) {
        Objects.requireNonNull(arg0);
        return arg0.negate();
    }

    default Predicate or(Predicate arg2) {
        Objects.requireNonNull(arg2);
        return new Predicate$$ExternalSyntheticLambda0(this, arg2);
    }

    boolean test(Object arg1);
}

