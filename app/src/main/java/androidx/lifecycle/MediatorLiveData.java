package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;

public class MediatorLiveData extends MutableLiveData {
    class Source implements Observer {
        final LiveData mLiveData;
        final Observer mObserver;
        int mVersion;

        Source(LiveData arg2, Observer arg3) {
            super();
            this.mVersion = -1;
            this.mLiveData = arg2;
            this.mObserver = arg3;
        }

        public void onChanged(Object arg3) {
            if(this.mVersion != this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mObserver.onChanged(arg3);
            }
        }

        void plug() {
            this.mLiveData.observeForever(((Observer)this));
        }

        void unplug() {
            this.mLiveData.removeObserver(((Observer)this));
        }
    }

    private SafeIterableMap mSources;

    public MediatorLiveData() {
        super();
        this.mSources = new SafeIterableMap();
    }

    public MediatorLiveData(Object arg1) {
        super(arg1);
        this.mSources = new SafeIterableMap();
    }

    public void addSource(LiveData arg3, Observer arg4) {
        if(arg3 != null) {
            Source v0 = new Source(arg3, arg4);
            Object v3 = this.mSources.putIfAbsent(arg3, v0);
            if(v3 != null) {
                if(((Source)v3).mObserver == arg4) {
                }
                else {
                    throw new IllegalArgumentException("This source was already added with the different observer");
                }
            }

            if(v3 != null) {
            }
            else if(this.hasActiveObservers()) {
                v0.plug();
            }

            return;
        }

        throw new NullPointerException("source cannot be null");
    }

    protected void onActive() {
        Iterator v1 = this.mSources.iterator();
        while(v1.hasNext()) {
            v1.next().getValue().plug();
        }
    }

    protected void onInactive() {
        Iterator v1 = this.mSources.iterator();
        while(v1.hasNext()) {
            v1.next().getValue().unplug();
        }
    }

    public void removeSource(LiveData arg1) {
        Object v0 = this.mSources.remove(arg1);
        if(v0 != null) {
            ((Source)v0).unplug();
        }
    }
}

