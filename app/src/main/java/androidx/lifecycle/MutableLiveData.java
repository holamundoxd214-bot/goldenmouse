package androidx.lifecycle;

public class MutableLiveData extends LiveData {
    public MutableLiveData() {
        super();
    }

    public MutableLiveData(Object arg1) {
        super(arg1);
    }

    public void postValue(Object arg1) {
        super.postValue(arg1);
    }

    public void setValue(Object arg1) {
        super.setValue(arg1);
    }
}

