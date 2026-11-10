package androidx.profileinstaller;

import android.content.Context;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProfileInstallerInitializer implements Initializer {
    class Handler28Impl {
        private Handler28Impl() {
            super();
        }

        public static Handler createAsync(Looper arg0) {
            return Handler.createAsync(arg0);
        }
    }

    public class Result {
        public Result() {
            super();
        }
    }

    private static final int DELAY_MS = 5000;

    public ProfileInstallerInitializer() {
        super();
    }

    public Result create(Context arg3) {
        Choreographer.getInstance().postFrameCallback(new ProfileInstallerInitializer$$ExternalSyntheticLambda0(this, arg3.getApplicationContext()));
        return new Result();
    }

    public Object create(Context arg1) {
        return this.create(arg1);
    }

    public List dependencies() {
        return Collections.emptyList();
    }

    void installAfterDelay(Context arg5) {
        Handler v4 = Build$VERSION.SDK_INT >= 28 ? Handler28Impl.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper());
        v4.postDelayed(new ProfileInstallerInitializer$$ExternalSyntheticLambda1(arg5), ((long)(new Random().nextInt(Math.max(1000, 1)) + 5000)));
    }

    void lambda$create$0$androidx-profileinstaller-ProfileInstallerInitializer(Context arg1, long arg2) {
        this.installAfterDelay(arg1);
    }

    static void lambda$installAfterDelay$1(Context arg0) {
        ProfileInstallerInitializer.writeInBackground(arg0);
    }

    static void lambda$writeInBackground$2(Context arg0) {
        ProfileInstaller.writeProfile(arg0);
    }

    private static void writeInBackground(Context arg7) {
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new ProfileInstallerInitializer$$ExternalSyntheticLambda2(arg7));
    }
}

