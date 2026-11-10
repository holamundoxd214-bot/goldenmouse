package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000¢\u0006\u0002\b\tJ!\u0010\n\u001A\u0004\u0018\u00010\b2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\r\u001A\u00020\u0005H\u0082\bJ*\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000F2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u000F0\f2\u0006\u0010\u0011\u001A\u00020\u0012H\u0002J/\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u000F0\u0007\"\u0004\b\u0000\u0010\u000F2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u000F0\f2\u0006\u0010\u0011\u001A\u00020\u0012H\u0000¢\u0006\u0002\b\u0014J1\u0010\u0015\u001A\u0002H\u000F\"\u0004\b\u0000\u0010\u000F2\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00122\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u000F0\fH\u0002¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0019\u001A\u00020\u001AH\u0002J,\u0010\u001B\u001A\u0002H\u001C\"\u0004\b\u0000\u0010\u001C*\u00020\u001D2\u0012\u0010\u001E\u001A\u000E\u0012\u0004\u0012\u00020\u001D\u0012\u0004\u0012\u0002H\u001C0\u001FH\u0082\b¢\u0006\u0002\u0010 J\u0016\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\"\u001A\u00020#H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2={"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "<init>", "()V", "PREFIX", "", "loadMainDispatcherFactory", "", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "loadMainDispatcherFactory$kotlinx_coroutines_core", "createInstanceOf", "baseClass", "Ljava/lang/Class;", "serviceClass", "load", "S", "service", "loader", "Ljava/lang/ClassLoader;", "loadProviders", "loadProviders$kotlinx_coroutines_core", "getProviderInstance", "name", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "parse", "url", "Ljava/net/URL;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "parseFile", "r", "Ljava/io/BufferedReader;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class FastServiceLoader {
    public static final FastServiceLoader INSTANCE = null;
    private static final String PREFIX = "META-INF/services/";

    static {
        FastServiceLoader.INSTANCE = new FastServiceLoader();
    }

    private FastServiceLoader() {
        super();
    }

    private final MainDispatcherFactory createInstanceOf(Class arg2, String arg3) {
        try {
            return arg2.cast(Class.forName(arg3, true, arg2.getClassLoader()).getDeclaredConstructor().newInstance());
        }
        catch(ClassNotFoundException ) {
            return null;
        }
    }

    private final Object getProviderInstance(String arg1, ClassLoader arg2, Class arg3) {
        Class v1 = Class.forName(arg1, false, arg2);
        if(arg3.isAssignableFrom(v1)) {
            return arg3.cast(v1.getDeclaredConstructor().newInstance());
        }

        throw new IllegalArgumentException("Expected service of class " + arg3 + ", but found " + v1.toString());
    }

    private final List load(Class arg1, ClassLoader arg2) {
        try {
            return this.loadProviders$kotlinx_coroutines_core(arg1, arg2);
        }
        catch(Throwable ) {
            return CollectionsKt.toList(ServiceLoader.load(arg1, arg2));
        }
    }

    public final List loadMainDispatcherFactory$kotlinx_coroutines_core() {
        List v1_1;
        Object v2_1;
        Object v3;
        String v2;
        ArrayList v1;
        Class v0 = MainDispatcherFactory.class;
        if(!FastServiceLoaderKt.getANDROID_DETECTED()) {
            return this.load(v0, v0.getClassLoader());
        }

        try {
            v1 = new ArrayList(2);
            v2 = "kotlinx.coroutines.android.AndroidDispatcherFactory";
            v3 = null;
            try {
                v2_1 = v0.cast(Class.forName(v2, true, v0.getClassLoader()).getDeclaredConstructor().newInstance());
            }
            catch(ClassNotFoundException ) {
                v2_1 = v3;
            }
        }
        catch(Throwable ) {
            goto label_39;
        }

        if(v2_1 != null) {
            goto label_26;
        }

        try {
            List v7 = this.load(v0, v0.getClassLoader());
            return v7;
        label_26:
            v1.add(v2_1);
            v2 = "kotlinx.coroutines.test.internal.TestMainDispatcherFactory";
            try {
                v3 = v0.cast(Class.forName(v2, true, v0.getClassLoader()).getDeclaredConstructor().newInstance());
                goto label_36;
            }
            catch(ClassNotFoundException ) {
            label_36:
                if(v3 != null) {
                    try {
                        v1.add(v3);
                    label_38:
                    }
                    catch(Throwable ) {
                    label_39:
                        v1_1 = ((FastServiceLoader)v7).load(v0, v0.getClassLoader());
                    }

                    return v1_1;
                }

                goto label_38;
            }
        }
        catch(Throwable ) {
            goto label_39;
        }

        return v1_1;
    }

    public final List loadProviders$kotlinx_coroutines_core(Class arg4, ClassLoader arg5) {
        ArrayList v3 = Collections.list(arg5.getResources("META-INF/services/" + arg4.getName()));
        Intrinsics.checkNotNullExpressionValue(v3, "list(...)");
        ArrayList v0 = new ArrayList();
        Iterator v3_1 = ((Iterable)v3).iterator();
        while(v3_1.hasNext()) {
            CollectionsKt.addAll(((Collection)v0), FastServiceLoader.INSTANCE.parse(v3_1.next()));
        }

        Set v3_2 = CollectionsKt.toSet(((Iterable)v0));
        if(!v3_2.isEmpty()) {
            v0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v3_2), 10));
            v3_1 = ((Iterable)v3_2).iterator();
        }
        else {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }

        while(v3_1.hasNext()) {
            ((Collection)v0).add(FastServiceLoader.INSTANCE.getProviderInstance(v3_1.next(), arg5, arg4));
        }

        return ((List)v0);
    }

    private final List parse(URL arg5) {
        List v5_3;
        List v4_3;
        BufferedReader v4_2;
        BufferedReader v5_1;
        String v4 = arg5.toString();
        int v2 = 2;
        Object v3 = null;
        if(StringsKt.startsWith$default(v4, "jar", false, v2, v3)) {
            String v5 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(v4, "jar:file:", ((String)v3), v2, v3), '!', ((String)v3), v2, v3);
            v4 = StringsKt.substringAfter$default(v4, "!/", ((String)v3), v2, v3);
            JarFile v0 = new JarFile(v5, false);
            try {
                v5_1 = new BufferedReader(new InputStreamReader(v0.getInputStream(new ZipEntry(v4)), "UTF-8"));
            }
            catch(Throwable v4_1) {
                goto label_35;
            }

            v4_2 = v5_1;
            try {
                v4_3 = FastServiceLoader.INSTANCE.parseFile(v4_2);
                goto label_26;
            }
            catch(Throwable v4_1) {
                try {
                    throw v4_1;
                }
                catch(Throwable v1) {
                    try {
                        CloseableKt.closeFinally(((Closeable)v5_1), v4_1);
                        throw v1;
                    label_26:
                        CloseableKt.closeFinally(((Closeable)v5_1), ((Throwable)v3));
                    }
                    catch(Throwable v4_1) {
                        try {
                        label_35:
                            throw v4_1;
                        }
                        catch(Throwable v5_2) {
                            try {
                                v0.close();
                            }
                            catch(Throwable v5_2) {
                                ExceptionsKt.addSuppressed(v4_1, v5_2);
                                throw v4_1;
                            }

                            throw v5_2;
                        }
                    }
                }
            }

            v0.close();
            return v4_3;
        }

        v4_2 = new BufferedReader(new InputStreamReader(arg5.openStream()));
        try {
            v5_3 = FastServiceLoader.INSTANCE.parseFile(v4_2);
        }
        catch(Throwable v5_2) {
            try {
                throw v5_2;
            }
            catch(Throwable v0_1) {
                CloseableKt.closeFinally(((Closeable)v4_2), v5_2);
                throw v0_1;
            }
        }

        CloseableKt.closeFinally(((Closeable)v4_2), ((Throwable)v3));
        return v5_3;
    }

    private final List parseFile(BufferedReader arg6) {
        LinkedHashSet v5 = new LinkedHashSet();
        while(true) {
            String v0 = arg6.readLine();
            if(v0 == null) {
                break;
            }

            v0 = StringsKt.trim(StringsKt.substringBefore$default(v0, "#", null, 2, null)).toString();
            String v1 = v0;
            int v2;
            for(v2 = 0; v2 < ((CharSequence)v1).length(); ++v2) {
                char v3 = ((CharSequence)v1).charAt(v2);
                if(v3 != 46) {
                    if(Character.isJavaIdentifierPart(v3)) {
                    }
                    else {
                        throw new IllegalArgumentException("Illegal service provider class name: " + v0.toString());
                    }
                }
            }

            if(((CharSequence)v1).length() <= 0) {
                continue;
            }

            ((Set)v5).add(v0);
        }

        return CollectionsKt.toList(((Iterable)v5));
    }

    private final Object use(JarFile arg1, Function1 arg2) {
        Object v0_1;
        try {
            v0_1 = arg2.invoke(arg1);
        }
        catch(Throwable v0) {
            try {
                throw v0;
            }
            catch(Throwable v2) {
                try {
                    arg1.close();
                }
                catch(Throwable v1) {
                    ExceptionsKt.addSuppressed(v0, v1);
                    throw v0;
                }

                throw v2;
            }
        }

        arg1.close();
        return v0_1;
    }
}

