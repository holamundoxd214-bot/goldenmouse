package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;
import java.lang.reflect.InvocationTargetException;

public class FragmentFactory {
    private static final SimpleArrayMap sClassCacheMap;

    static {
        FragmentFactory.sClassCacheMap = new SimpleArrayMap();
    }

    public FragmentFactory() {
        super();
    }

    public Fragment instantiate(ClassLoader arg4, String arg5) {
        String v3 = ": make sure class name exists, is public, and has an empty constructor that is public";
        String v0 = "Unable to instantiate fragment ";
        try {
            return FragmentFactory.loadFragmentClass(arg4, arg5).getConstructor().newInstance();
        }
        catch(InvocationTargetException v3_1) {
            throw new InstantiationException(v0 + arg5 + ": calling Fragment constructor caused an exception", ((Exception)v3_1));
        }
        catch(NoSuchMethodException v3_2) {
            throw new InstantiationException(v0 + arg5 + ": could not find Fragment constructor", ((Exception)v3_2));
        }
        catch(IllegalAccessException v4) {
            throw new InstantiationException(v0 + arg5 + v3, ((Exception)v4));
        }
        catch(java.lang.InstantiationException v4_1) {
            throw new InstantiationException(v0 + arg5 + v3, ((Exception)v4_1));
        }
    }

    static boolean isFragmentClass(ClassLoader arg0, String arg1) {
        try {
            return Fragment.class.isAssignableFrom(FragmentFactory.loadClass(arg0, arg1));
        }
        catch(ClassNotFoundException ) {
            return 0;
        }
    }

    private static Class loadClass(ClassLoader arg2, String arg3) throws ClassNotFoundException {
        SimpleArrayMap v1_1;
        SimpleArrayMap v0 = FragmentFactory.sClassCacheMap;
        Object v1 = v0.get(arg2);
        if(v1 == null) {
            v1_1 = new SimpleArrayMap();
            v0.put(arg2, v1_1);
        }

        Object v0_1 = v1_1.get(arg3);
        if(v0_1 == null) {
            Class v2 = Class.forName(arg3, false, arg2);
            v1_1.put(arg3, v2);
            return v2;
        }

        return ((Class)v0_1);
    }

    public static Class loadFragmentClass(ClassLoader arg3, String arg4) {
        String v0 = "Unable to instantiate fragment ";
        try {
            return FragmentFactory.loadClass(arg3, arg4);
        }
        catch(ClassCastException v3) {
            throw new InstantiationException(v0 + arg4 + ": make sure class is a valid subclass of Fragment", ((Exception)v3));
        }
        catch(ClassNotFoundException v3_1) {
            throw new InstantiationException(v0 + arg4 + ": make sure class name exists", ((Exception)v3_1));
        }
    }
}

