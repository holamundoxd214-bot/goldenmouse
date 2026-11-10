package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

public final class TaskStackBuilder implements Iterable {
    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    private static final String TAG = "TaskStackBuilder";
    private final ArrayList mIntents;
    private final Context mSourceContext;

    private TaskStackBuilder(Context arg2) {
        super();
        this.mIntents = new ArrayList();
        this.mSourceContext = arg2;
    }

    public TaskStackBuilder addNextIntent(Intent arg2) {
        this.mIntents.add(arg2);
        return this;
    }

    public TaskStackBuilder addNextIntentWithParentStack(Intent arg2) {
        ComponentName v0 = arg2.getComponent();
        if(v0 == null) {
            v0 = arg2.resolveActivity(this.mSourceContext.getPackageManager());
        }

        if(v0 != null) {
            this.addParentStack(v0);
        }

        this.addNextIntent(arg2);
        return this;
    }

    public TaskStackBuilder addParentStack(Activity arg2) {
        Intent v0 = (arg2 instanceof SupportParentable) ? arg2.getSupportParentActivityIntent() : null;
        if(v0 == null) {
            v0 = NavUtils.getParentActivityIntent(arg2);
        }

        if(v0 != null) {
            ComponentName v2 = v0.getComponent();
            if(v2 == null) {
                v2 = v0.resolveActivity(this.mSourceContext.getPackageManager());
            }

            this.addParentStack(v2);
            this.addNextIntent(v0);
        }

        return this;
    }

    public TaskStackBuilder addParentStack(ComponentName arg3) {
        int v0 = this.mIntents.size();
        try {
            Intent v3;
            for(v3 = NavUtils.getParentActivityIntent(this.mSourceContext, arg3); v3 != null; v3 = NavUtils.getParentActivityIntent(this.mSourceContext, v3.getComponent())) {
                this.mIntents.add(v0, v3);
            }
        }
        catch(PackageManager$NameNotFoundException v2) {
            goto label_15;
        }

        return this;
    label_15:
        Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
        throw new IllegalArgumentException(((Throwable)v2));
    }

    public TaskStackBuilder addParentStack(Class arg3) {
        return this.addParentStack(new ComponentName(this.mSourceContext, arg3));
    }

    public static TaskStackBuilder create(Context arg1) {
        return new TaskStackBuilder(arg1);
    }

    public Intent editIntentAt(int arg1) {
        return this.mIntents.get(arg1);
    }

    @Deprecated public static TaskStackBuilder from(Context arg0) {
        return TaskStackBuilder.create(arg0);
    }

    @Deprecated public Intent getIntent(int arg1) {
        return this.editIntentAt(arg1);
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    public Intent[] getIntents() {
        int v0 = this.mIntents.size();
        Intent[] v1 = new Intent[v0];
        if(v0 == 0) {
        }
        else {
            v1[0] = new Intent(this.mIntents.get(0)).addFlags(0x1000C000);
            int v2;
            for(v2 = 1; v2 < v0; ++v2) {
                v1[v2] = new Intent(this.mIntents.get(v2));
            }
        }

        return v1;
    }

    public PendingIntent getPendingIntent(int arg2, int arg3) {
        return this.getPendingIntent(arg2, arg3, null);
    }

    public PendingIntent getPendingIntent(int arg5, int arg6, Bundle arg7) {
        if(!this.mIntents.isEmpty()) {
            Object[] v0 = this.mIntents.toArray(new Intent[0]);
            v0[0] = new Intent(v0[0]).addFlags(0x1000C000);
            return PendingIntent.getActivities(this.mSourceContext, arg5, ((Intent[])v0), arg6, arg7);
        }

        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }

    public PendingIntent getPendingIntent(int arg1, int arg2, Bundle arg3, boolean arg4) {
        return this.getPendingIntent(arg1, PendingIntentCompat.addMutabilityFlags(arg4, arg2), arg3);
    }

    public PendingIntent getPendingIntent(int arg1, int arg2, boolean arg3) {
        return this.getPendingIntent(arg1, PendingIntentCompat.addMutabilityFlags(arg3, arg2));
    }

    @Deprecated public Iterator iterator() {
        return this.mIntents.iterator();
    }

    public void startActivities() {
        this.startActivities(null);
    }

    public void startActivities(Bundle arg5) {
        if(!this.mIntents.isEmpty()) {
            Object[] v0 = this.mIntents.toArray(new Intent[0]);
            v0[0] = new Intent(v0[0]).addFlags(0x1000C000);
            if(!ContextCompat.startActivities(this.mSourceContext, ((Intent[])v0), arg5)) {
                Intent v5 = new Intent(v0[v0.length - 1]);
                v5.addFlags(0x10000000);
                this.mSourceContext.startActivity(v5);
            }

            return;
        }

        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}

