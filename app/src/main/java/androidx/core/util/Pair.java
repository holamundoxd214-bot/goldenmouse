package androidx.core.util;

public class Pair {
    public final Object first;
    public final Object second;

    public Pair(Object arg1, Object arg2) {
        super();
        this.first = arg1;
        this.second = arg2;
    }

    public static Pair create(Object arg1, Object arg2) {
        return new Pair(arg1, arg2);
    }

    public boolean equals(Object arg4) {
        if(!(arg4 instanceof Pair)) {
            return 0;
        }

        if((ObjectsCompat.equals(((Pair)arg4).first, this.first)) && (ObjectsCompat.equals(((Pair)arg4).second, this.second))) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        Object v0 = this.first;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        Object v2 = this.second;
        if(v2 == null) {
        }
        else {
            v1 = v2.hashCode();
        }

        return v0_1 ^ v1;
    }

    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}

