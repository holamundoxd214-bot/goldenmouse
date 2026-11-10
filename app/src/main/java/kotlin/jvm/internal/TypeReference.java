package kotlin.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\u001B\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B1\bG\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0001\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BB\'\bV\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\f\u001A\u00020\r¢\u0006\u0004\b\n\u0010\u000EJ\u0014\u0010\u001E\u001A\u00020\r2\b\u0010\u001F\u001A\u0004\u0018\u00010 H\u0096\u0082\u0004J\n\u0010!\u001A\u00020\tH\u0096\u0080\u0004J\n\u0010\"\u001A\u00020#H\u0096\u0080\u0004J\u0012\u0010$\u001A\u00020#2\u0006\u0010%\u001A\u00020\rH\u0082\u0080\u0004J\u000E\u0010$\u001A\u00020#*\u00020\u0006H\u0082\u0080\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001B\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u001F\u0010\u0007\u001A\u0004\u0018\u00010\u00018\u0000X\u0081\u0084\b¢\u0006\u000E\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016R\u001D\u0010\b\u001A\u00020\t8\u0000X\u0081\u0084\b¢\u0006\u000E\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001A\u0004\b\u0018\u0010\u0019R\u001B\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u001B0\u00058VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u0012R\u0015\u0010\f\u001A\u00020\r8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\u001DR\u001D\u0010&\u001A\u00020#*\u0006\u0012\u0002\b\u00030\'8BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b(\u0010)¨\u0006+"}, d2={"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "platformTypeUpperBound", "flags", "", "<init>", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getArguments", "()Ljava/util/List;", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "()V", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "getFlags$kotlin_stdlib$annotations", "getFlags$kotlin_stdlib", "()I", "annotations", "", "getAnnotations", "()Z", "equals", "other", "", "hashCode", "toString", "", "asString", "convertPrimitiveToWrapper", "arrayClassName", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class TypeReference implements KType {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0080Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0006\u001A\u00020\u0005X\u0080Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\u0005X\u0080Ô\b¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Lkotlin/jvm/internal/TypeReference$Companion;", "", "<init>", "()V", "IS_MARKED_NULLABLE", "", "IS_MUTABLE_COLLECTION_TYPE", "IS_NOTHING_TYPE", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[KVariance.values().length];
            try {
                v0[KVariance.INVARIANT.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[KVariance.IN.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[KVariance.OUT.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    public static final Companion Companion = null;
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;
    private final List arguments;
    private final KClassifier classifier;
    private final int flags;
    private final KType platformTypeUpperBound;

    static {
        TypeReference.Companion = new Companion(null);
    }

    public TypeReference(KClassifier arg2, List arg3, KType arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg2, "classifier");
        Intrinsics.checkNotNullParameter(arg3, "arguments");
        super();
        this.classifier = arg2;
        this.arguments = arg3;
        this.platformTypeUpperBound = arg4;
        this.flags = arg5;
    }

    public TypeReference(KClassifier arg2, List arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg2, "classifier");
        Intrinsics.checkNotNullParameter(arg3, "arguments");
        this(arg2, arg3, null, ((int)arg4));
    }

    private final String asString(KTypeProjection arg3) {
        String v2_1;
        if(arg3.getVariance() == null) {
            return "*";
        }

        KType v2 = arg3.getType();
        if((v2 instanceof TypeReference)) {
        }
        else {
            v2 = null;
        }

        if(v2 != null) {
            v2_1 = ((TypeReference)v2).asString(true);
            if(v2_1 == null) {
                goto label_13;
            }
        }
        else {
        label_13:
            v2_1 = String.valueOf(arg3.getType());
        }

        int v3 = WhenMappings.$EnumSwitchMapping$0[arg3.getVariance().ordinal()];
        if(v3 != 1) {
            if(v3 == 2) {
                v2_1 = "in " + v2_1;
            }
            else if(v3 == 3) {
                return "out " + v2_1;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }

        return v2_1;
    }

    private final String asString(boolean arg12) {
        String v12;
        KClassifier v0 = this.getClassifier();
        Class v2 = null;
        if((v0 instanceof KClass)) {
        }
        else {
            v0 = ((KClassifier)v2);
        }

        if(v0 != null) {
            v2 = JvmClassMappingKt.getJavaClass(((KClass)v0));
        }

        if(v2 == null) {
            v12 = this.getClassifier().toString();
        }
        else if((this.flags & 4) != 0) {
            v12 = "kotlin.Nothing";
        }
        else if(v2.isArray()) {
            v12 = this.getArrayClassName(v2);
        }
        else {
            if((arg12) && (v2.isPrimitive())) {
                v12 = JvmClassMappingKt.getJavaObjectType(this.getClassifier()).getName();
                goto label_29;
            }

            v12 = v2.getName();
        }

    label_29:
        String v1 = "";
        String v0_1 = this.getArguments().isEmpty() ? v1 : CollectionsKt.joinToString$default(this.getArguments(), ", ", "<", ">", 0, null, new TypeReference$$ExternalSyntheticLambda0(this), 24, null);
        if(this.isMarkedNullable()) {
            v1 = "?";
        }

        v12 = v12 + v0_1 + v1;
        KType v11 = this.platformTypeUpperBound;
        if((v11 instanceof TypeReference)) {
            String v11_1 = ((TypeReference)v11).asString(true);
            if(Intrinsics.areEqual(v11_1, v12)) {
            }
            else if(Intrinsics.areEqual(v11_1, v12 + '?')) {
                return v12 + '!';
            }
            else {
                return "(" + v12 + ".." + v11_1 + ')';
            }
        }

        return v12;
    }

    static final CharSequence asString$lambda$0(TypeReference arg1, KTypeProjection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return arg1.asString(arg2);
    }

    public boolean equals(Object arg3) {
        if(((arg3 instanceof TypeReference)) && (Intrinsics.areEqual(this.getClassifier(), ((TypeReference)arg3).getClassifier())) && (Intrinsics.areEqual(this.getArguments(), ((TypeReference)arg3).getArguments())) && (Intrinsics.areEqual(this.platformTypeUpperBound, ((TypeReference)arg3).platformTypeUpperBound)) && this.flags == ((TypeReference)arg3).flags) {
            return 1;
        }

        return 0;
    }

    public List getAnnotations() {
        return CollectionsKt.emptyList();
    }

    public List getArguments() {
        return this.arguments;
    }

    private final String getArrayClassName(Class arg1) {
        if(Intrinsics.areEqual(arg1, boolean[].class)) {
            return "kotlin.BooleanArray";
        }

        if(Intrinsics.areEqual(arg1, char[].class)) {
            return "kotlin.CharArray";
        }

        if(Intrinsics.areEqual(arg1, byte[].class)) {
            return "kotlin.ByteArray";
        }

        if(Intrinsics.areEqual(arg1, short[].class)) {
            return "kotlin.ShortArray";
        }

        if(Intrinsics.areEqual(arg1, int[].class)) {
            return "kotlin.IntArray";
        }

        if(Intrinsics.areEqual(arg1, float[].class)) {
            return "kotlin.FloatArray";
        }

        if(Intrinsics.areEqual(arg1, long[].class)) {
            return "kotlin.LongArray";
        }

        if(Intrinsics.areEqual(arg1, double[].class)) {
            return "kotlin.DoubleArray";
        }

        return "kotlin.Array";
    }

    public KClassifier getClassifier() {
        return this.classifier;
    }

    public final int getFlags$kotlin_stdlib() {
        return this.flags;
    }

    public static void getFlags$kotlin_stdlib$annotations() {
    }

    public final KType getPlatformTypeUpperBound$kotlin_stdlib() {
        return this.platformTypeUpperBound;
    }

    public static void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    public int hashCode() {
        return (this.getClassifier().hashCode() * 0x1F + this.getArguments().hashCode()) * 0x1F + Integer.hashCode(this.flags);
    }

    public boolean isMarkedNullable() {
        if((this.flags & 1) != 0) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return this.asString(false) + " (Kotlin reflection is not available)";
    }
}

