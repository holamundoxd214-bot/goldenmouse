package kotlin.jvm.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableIterable;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.jvm.internal.markers.KMutableMap$Entry;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.jvm.internal.markers.KMutableSet;

public class TypeIntrinsics {
    public TypeIntrinsics() {
        super();
    }

    public static Collection asMutableCollection(Object arg1) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableCollection)) {
            TypeIntrinsics.throwCce(arg1, "kotlin.collections.MutableCollection");
        }

        return TypeIntrinsics.castToCollection(arg1);
    }

    public static Collection asMutableCollection(Object arg1, String arg2) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableCollection)) {
            TypeIntrinsics.throwCce(arg2);
        }

        return TypeIntrinsics.castToCollection(arg1);
    }

    public static Iterable asMutableIterable(Object arg1) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableIterable)) {
            TypeIntrinsics.throwCce(arg1, "kotlin.collections.MutableIterable");
        }

        return TypeIntrinsics.castToIterable(arg1);
    }

    public static Iterable asMutableIterable(Object arg1, String arg2) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableIterable)) {
            TypeIntrinsics.throwCce(arg2);
        }

        return TypeIntrinsics.castToIterable(arg1);
    }

    public static Iterator asMutableIterator(Object arg1) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableIterator)) {
            TypeIntrinsics.throwCce(arg1, "kotlin.collections.MutableIterator");
        }

        return TypeIntrinsics.castToIterator(arg1);
    }

    public static Iterator asMutableIterator(Object arg1, String arg2) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableIterator)) {
            TypeIntrinsics.throwCce(arg2);
        }

        return TypeIntrinsics.castToIterator(arg1);
    }

    public static List asMutableList(Object arg1) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableList)) {
            TypeIntrinsics.throwCce(arg1, "kotlin.collections.MutableList");
        }

        return TypeIntrinsics.castToList(arg1);
    }

    public static List asMutableList(Object arg1, String arg2) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableList)) {
            TypeIntrinsics.throwCce(arg2);
        }

        return TypeIntrinsics.castToList(arg1);
    }

    public static ListIterator asMutableListIterator(Object arg1) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableListIterator)) {
            TypeIntrinsics.throwCce(arg1, "kotlin.collections.MutableListIterator");
        }

        return TypeIntrinsics.castToListIterator(arg1);
    }

    public static ListIterator asMutableListIterator(Object arg1, String arg2) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableListIterator)) {
            TypeIntrinsics.throwCce(arg2);
        }

        return TypeIntrinsics.castToListIterator(arg1);
    }

    public static Map asMutableMap(Object arg1) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableMap)) {
            TypeIntrinsics.throwCce(arg1, "kotlin.collections.MutableMap");
        }

        return TypeIntrinsics.castToMap(arg1);
    }

    public static Map asMutableMap(Object arg1, String arg2) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableMap)) {
            TypeIntrinsics.throwCce(arg2);
        }

        return TypeIntrinsics.castToMap(arg1);
    }

    public static Map$Entry asMutableMapEntry(Object arg1) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof Entry)) {
            TypeIntrinsics.throwCce(arg1, "kotlin.collections.MutableMap.MutableEntry");
        }

        return TypeIntrinsics.castToMapEntry(arg1);
    }

    public static Map$Entry asMutableMapEntry(Object arg1, String arg2) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof Entry)) {
            TypeIntrinsics.throwCce(arg2);
        }

        return TypeIntrinsics.castToMapEntry(arg1);
    }

    public static Set asMutableSet(Object arg1) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableSet)) {
            TypeIntrinsics.throwCce(arg1, "kotlin.collections.MutableSet");
        }

        return TypeIntrinsics.castToSet(arg1);
    }

    public static Set asMutableSet(Object arg1, String arg2) {
        if(((arg1 instanceof KMappedMarker)) && !(arg1 instanceof KMutableSet)) {
            TypeIntrinsics.throwCce(arg2);
        }

        return TypeIntrinsics.castToSet(arg1);
    }

    public static Object beforeCheckcastToFunctionOfArity(Object arg2, int arg3) {
        if(arg2 != null && !TypeIntrinsics.isFunctionOfArity(arg2, arg3)) {
            TypeIntrinsics.throwCce(arg2, "kotlin.jvm.functions.Function" + arg3);
        }

        return arg2;
    }

    public static Object beforeCheckcastToFunctionOfArity(Object arg0, int arg1, String arg2) {
        if(arg0 != null && !TypeIntrinsics.isFunctionOfArity(arg0, arg1)) {
            TypeIntrinsics.throwCce(arg2);
        }

        return arg0;
    }

    public static Collection castToCollection(Object arg0) {
        return arg0;
        throw TypeIntrinsics.throwCce(v0);
    }

    public static Iterable castToIterable(Object arg0) {
        return arg0;
        throw TypeIntrinsics.throwCce(v0);
    }

    public static Iterator castToIterator(Object arg0) {
        return arg0;
        throw TypeIntrinsics.throwCce(v0);
    }

    public static List castToList(Object arg0) {
        return arg0;
        throw TypeIntrinsics.throwCce(v0);
    }

    public static ListIterator castToListIterator(Object arg0) {
        return arg0;
        throw TypeIntrinsics.throwCce(v0);
    }

    public static Map castToMap(Object arg0) {
        return arg0;
        throw TypeIntrinsics.throwCce(v0);
    }

    public static Map$Entry castToMapEntry(Object arg0) {
        return arg0;
        throw TypeIntrinsics.throwCce(v0);
    }

    public static Set castToSet(Object arg0) {
        return arg0;
        throw TypeIntrinsics.throwCce(v0);
    }

    public static int getFunctionArity(Object arg1) {
        if((arg1 instanceof FunctionBase)) {
            return ((FunctionBase)arg1).getArity();
        }

        if((arg1 instanceof Function0)) {
            return 0;
        }

        if((arg1 instanceof Function1)) {
            return 1;
        }

        if((arg1 instanceof Function2)) {
            return 2;
        }

        if((arg1 instanceof Function3)) {
            return 3;
        }

        if((arg1 instanceof Function4)) {
            return 4;
        }

        if((arg1 instanceof Function5)) {
            return 5;
        }

        if((arg1 instanceof Function6)) {
            return 6;
        }

        if((arg1 instanceof Function7)) {
            return 7;
        }

        if((arg1 instanceof Function8)) {
            return 8;
        }

        if((arg1 instanceof Function9)) {
            return 9;
        }

        if((arg1 instanceof Function10)) {
            return 10;
        }

        if((arg1 instanceof Function11)) {
            return 11;
        }

        if((arg1 instanceof Function12)) {
            return 12;
        }

        if((arg1 instanceof Function13)) {
            return 13;
        }

        if((arg1 instanceof Function14)) {
            return 14;
        }

        if((arg1 instanceof Function15)) {
            return 15;
        }

        if((arg1 instanceof Function16)) {
            return 16;
        }

        if((arg1 instanceof Function17)) {
            return 17;
        }

        if((arg1 instanceof Function18)) {
            return 18;
        }

        if((arg1 instanceof Function19)) {
            return 19;
        }

        if((arg1 instanceof Function20)) {
            return 20;
        }

        if((arg1 instanceof Function21)) {
            return 21;
        }

        if((arg1 instanceof Function22)) {
            return 22;
        }

        return -1;
    }

    public static boolean isFunctionOfArity(Object arg1, int arg2) {
        if(((arg1 instanceof Function)) && TypeIntrinsics.getFunctionArity(arg1) == arg2) {
            return 1;
        }

        return 0;
    }

    public static boolean isMutableCollection(Object arg1) {
        if(((arg1 instanceof Collection)) && (!(arg1 instanceof KMappedMarker) || ((arg1 instanceof KMutableCollection)))) {
            return 1;
        }

        return 0;
    }

    public static boolean isMutableIterable(Object arg1) {
        if(((arg1 instanceof Iterable)) && (!(arg1 instanceof KMappedMarker) || ((arg1 instanceof KMutableIterable)))) {
            return 1;
        }

        return 0;
    }

    public static boolean isMutableIterator(Object arg1) {
        if(((arg1 instanceof Iterator)) && (!(arg1 instanceof KMappedMarker) || ((arg1 instanceof KMutableIterator)))) {
            return 1;
        }

        return 0;
    }

    public static boolean isMutableList(Object arg1) {
        if(((arg1 instanceof List)) && (!(arg1 instanceof KMappedMarker) || ((arg1 instanceof KMutableList)))) {
            return 1;
        }

        return 0;
    }

    public static boolean isMutableListIterator(Object arg1) {
        if(((arg1 instanceof ListIterator)) && (!(arg1 instanceof KMappedMarker) || ((arg1 instanceof KMutableListIterator)))) {
            return 1;
        }

        return 0;
    }

    public static boolean isMutableMap(Object arg1) {
        if(((arg1 instanceof Map)) && (!(arg1 instanceof KMappedMarker) || ((arg1 instanceof KMutableMap)))) {
            return 1;
        }

        return 0;
    }

    public static boolean isMutableMapEntry(Object arg1) {
        if(((arg1 instanceof Map$Entry)) && (!(arg1 instanceof KMappedMarker) || ((arg1 instanceof Entry)))) {
            return 1;
        }

        return 0;
    }

    public static boolean isMutableSet(Object arg1) {
        if(((arg1 instanceof Set)) && (!(arg1 instanceof KMappedMarker) || ((arg1 instanceof KMutableSet)))) {
            return 1;
        }

        return 0;
    }

    private static Throwable sanitizeStackTrace(Throwable arg1) {
        return Intrinsics.sanitizeStackTrace(arg1, TypeIntrinsics.class.getName());
    }

    public static void throwCce(Object arg1, String arg2) {
        String v1 = arg1 == null ? "null" : arg1.getClass().getName();
        TypeIntrinsics.throwCce(v1 + " cannot be cast to " + arg2);
    }

    public static void throwCce(String arg1) {
        throw TypeIntrinsics.throwCce(new ClassCastException(arg1));
    }

    public static ClassCastException throwCce(ClassCastException arg0) {
        throw TypeIntrinsics.sanitizeStackTrace(((Throwable)arg0));
    }
}

