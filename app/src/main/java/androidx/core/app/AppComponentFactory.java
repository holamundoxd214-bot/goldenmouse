package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

public class AppComponentFactory extends android.app.AppComponentFactory {
    public AppComponentFactory() {
        super();
    }

    public final Activity instantiateActivity(ClassLoader arg1, String arg2, Intent arg3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(this.instantiateActivityCompat(arg1, arg2, arg3));
    }

    public Activity instantiateActivityCompat(ClassLoader arg1, String arg2, Intent arg3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            return Class.forName(arg2, false, arg1).asSubclass(Activity.class).getDeclaredConstructor().newInstance();
        }
        catch(NoSuchMethodException v0) {
            throw new RuntimeException("Couldn\'t call constructor", ((Throwable)v0));
        }
    }

    public final Application instantiateApplication(ClassLoader arg1, String arg2) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(this.instantiateApplicationCompat(arg1, arg2));
    }

    public Application instantiateApplicationCompat(ClassLoader arg1, String arg2) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            return Class.forName(arg2, false, arg1).asSubclass(Application.class).getDeclaredConstructor().newInstance();
        }
        catch(NoSuchMethodException v0) {
            throw new RuntimeException("Couldn\'t call constructor", ((Throwable)v0));
        }
    }

    public final ContentProvider instantiateProvider(ClassLoader arg1, String arg2) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(this.instantiateProviderCompat(arg1, arg2));
    }

    public ContentProvider instantiateProviderCompat(ClassLoader arg1, String arg2) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            return Class.forName(arg2, false, arg1).asSubclass(ContentProvider.class).getDeclaredConstructor().newInstance();
        }
        catch(NoSuchMethodException v0) {
            throw new RuntimeException("Couldn\'t call constructor", ((Throwable)v0));
        }
    }

    public final BroadcastReceiver instantiateReceiver(ClassLoader arg1, String arg2, Intent arg3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(this.instantiateReceiverCompat(arg1, arg2, arg3));
    }

    public BroadcastReceiver instantiateReceiverCompat(ClassLoader arg1, String arg2, Intent arg3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            return Class.forName(arg2, false, arg1).asSubclass(BroadcastReceiver.class).getDeclaredConstructor().newInstance();
        }
        catch(NoSuchMethodException v0) {
            throw new RuntimeException("Couldn\'t call constructor", ((Throwable)v0));
        }
    }

    public final Service instantiateService(ClassLoader arg1, String arg2, Intent arg3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(this.instantiateServiceCompat(arg1, arg2, arg3));
    }

    public Service instantiateServiceCompat(ClassLoader arg1, String arg2, Intent arg3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        try {
            return Class.forName(arg2, false, arg1).asSubclass(Service.class).getDeclaredConstructor().newInstance();
        }
        catch(NoSuchMethodException v0) {
            throw new RuntimeException("Couldn\'t call constructor", ((Throwable)v0));
        }
    }
}

