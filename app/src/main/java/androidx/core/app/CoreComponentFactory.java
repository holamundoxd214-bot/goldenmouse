package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

public class CoreComponentFactory extends AppComponentFactory {
    public interface CompatWrapped {
        Object getWrapper();
    }

    public CoreComponentFactory() {
        super();
    }

    static Object checkCompatWrapper(Object arg1) {
        if((arg1 instanceof CompatWrapped)) {
            Object v0 = arg1.getWrapper();
            if(v0 != null) {
                return v0;
            }
        }

        return arg1;
    }

    public Activity instantiateActivity(ClassLoader arg1, String arg2, Intent arg3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(super.instantiateActivity(arg1, arg2, arg3));
    }

    public Application instantiateApplication(ClassLoader arg1, String arg2) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(super.instantiateApplication(arg1, arg2));
    }

    public ContentProvider instantiateProvider(ClassLoader arg1, String arg2) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(super.instantiateProvider(arg1, arg2));
    }

    public BroadcastReceiver instantiateReceiver(ClassLoader arg1, String arg2, Intent arg3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(super.instantiateReceiver(arg1, arg2, arg3));
    }

    public Service instantiateService(ClassLoader arg1, String arg2, Intent arg3) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return CoreComponentFactory.checkCompatWrapper(super.instantiateService(arg1, arg2, arg3));
    }
}

