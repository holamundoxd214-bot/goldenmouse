package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CompositeDateValidator implements DateValidator {
    class com.google.android.material.datepicker.CompositeDateValidator$1 implements Operator {
        com.google.android.material.datepicker.CompositeDateValidator$1() {
            super();
        }

        public int getId() {
            return 1;
        }

        public boolean isValid(List arg1, long arg2) {
            Iterator v0 = arg1.iterator();
            do {
            label_1:
                if(!v0.hasNext()) {
                    return 0;
                }

                Object v1 = v0.next();
                if(v1 == null) {
                    goto label_1;
                }
            }
            while(!((DateValidator)v1).isValid(arg2));

            return 1;
        }
    }

    class com.google.android.material.datepicker.CompositeDateValidator$2 implements Operator {
        com.google.android.material.datepicker.CompositeDateValidator$2() {
            super();
        }

        public int getId() {
            return 2;
        }

        public boolean isValid(List arg1, long arg2) {
            Iterator v0 = arg1.iterator();
            do {
            label_1:
                if(!v0.hasNext()) {
                    return 1;
                }

                Object v1 = v0.next();
                if(v1 == null) {
                    goto label_1;
                }
            }
            while(((DateValidator)v1).isValid(arg2));

            return 0;
        }
    }

    class com.google.android.material.datepicker.CompositeDateValidator$3 implements Parcelable$Creator {
        com.google.android.material.datepicker.CompositeDateValidator$3() {
            super();
        }

        public CompositeDateValidator createFromParcel(Parcel arg3) {
            Operator v3_1;
            ArrayList v2 = arg3.readArrayList(DateValidator.class.getClassLoader());
            int v3 = arg3.readInt();
            if(v3 == 2) {
                v3_1 = CompositeDateValidator.ALL_OPERATOR;
            }
            else if(v3 == 1) {
                v3_1 = CompositeDateValidator.ANY_OPERATOR;
            }
            else {
                v3_1 = CompositeDateValidator.ALL_OPERATOR;
            }

            return new CompositeDateValidator(Preconditions.checkNotNull(v2), v3_1, null);
        }

        public Object createFromParcel(Parcel arg1) {
            return this.createFromParcel(arg1);
        }

        public CompositeDateValidator[] newArray(int arg1) {
            return new CompositeDateValidator[arg1];
        }

        public Object[] newArray(int arg1) {
            return this.newArray(arg1);
        }
    }

    interface Operator {
        int getId();

        boolean isValid(List arg1, long arg2);
    }

    private static final Operator ALL_OPERATOR = null;
    private static final Operator ANY_OPERATOR = null;
    private static final int COMPARATOR_ALL_ID = 2;
    private static final int COMPARATOR_ANY_ID = 1;
    public static final Parcelable$Creator CREATOR;
    private final Operator operator;
    private final List validators;

    static {
        CompositeDateValidator.ANY_OPERATOR = new com.google.android.material.datepicker.CompositeDateValidator$1();
        CompositeDateValidator.ALL_OPERATOR = new com.google.android.material.datepicker.CompositeDateValidator$2();
        CompositeDateValidator.CREATOR = new com.google.android.material.datepicker.CompositeDateValidator$3();
    }

    private CompositeDateValidator(List arg1, Operator arg2) {
        super();
        this.validators = arg1;
        this.operator = arg2;
    }

    CompositeDateValidator(List arg1, Operator arg2, com.google.android.material.datepicker.CompositeDateValidator$1 arg3) {
        this(arg1, arg2);
    }

    static Operator access$000() {
        return CompositeDateValidator.ALL_OPERATOR;
    }

    static Operator access$100() {
        return CompositeDateValidator.ANY_OPERATOR;
    }

    public static DateValidator allOf(List arg2) {
        return new CompositeDateValidator(arg2, CompositeDateValidator.ALL_OPERATOR);
    }

    public static DateValidator anyOf(List arg2) {
        return new CompositeDateValidator(arg2, CompositeDateValidator.ANY_OPERATOR);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object arg5) {
        if(this == (((CompositeDateValidator)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof CompositeDateValidator)) {
            return 0;
        }

        if((this.validators.equals(((CompositeDateValidator)arg5).validators)) && this.operator.getId() == ((CompositeDateValidator)arg5).operator.getId()) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.validators.hashCode();
    }

    public boolean isValid(long arg2) {
        return this.operator.isValid(this.validators, arg2);
    }

    public void writeToParcel(Parcel arg1, int arg2) {
        arg1.writeList(this.validators);
        arg1.writeInt(this.operator.getId());
    }
}

