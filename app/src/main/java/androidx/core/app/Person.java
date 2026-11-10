package androidx.core.app;

import android.app.Person$Builder;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

public class Person {
    class Api22Impl {
        private Api22Impl() {
            super();
        }

        static Person fromPersistableBundle(PersistableBundle arg2) {
            return new Builder().setName(arg2.getString("name")).setUri(arg2.getString("uri")).setKey(arg2.getString("key")).setBot(arg2.getBoolean("isBot")).setImportant(arg2.getBoolean("isImportant")).build();
        }

        static PersistableBundle toPersistableBundle(Person arg3) {
            PersistableBundle v0 = new PersistableBundle();
            String v1 = arg3.mName != null ? arg3.mName.toString() : null;
            v0.putString("name", v1);
            v0.putString("uri", arg3.mUri);
            v0.putString("key", arg3.mKey);
            v0.putBoolean("isBot", arg3.mIsBot);
            v0.putBoolean("isImportant", arg3.mIsImportant);
            return v0;
        }
    }

    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static Person fromAndroidPerson(android.app.Person arg2) {
            Builder v0 = new Builder().setName(arg2.getName());
            IconCompat v1 = arg2.getIcon() != null ? IconCompat.createFromIcon(arg2.getIcon()) : null;
            return v0.setIcon(v1).setUri(arg2.getUri()).setKey(arg2.getKey()).setBot(arg2.isBot()).setImportant(arg2.isImportant()).build();
        }

        static android.app.Person toAndroidPerson(Person arg2) {
            Person$Builder v0 = new Person$Builder().setName(arg2.getName());
            Icon v1 = arg2.getIcon() != null ? arg2.getIcon().toIcon() : null;
            return v0.setIcon(v1).setUri(arg2.getUri()).setKey(arg2.getKey()).setBot(arg2.isBot()).setImportant(arg2.isImportant()).build();
        }
    }

    public class Builder {
        IconCompat mIcon;
        boolean mIsBot;
        boolean mIsImportant;
        String mKey;
        CharSequence mName;
        String mUri;

        public Builder() {
            super();
        }

        Builder(Person arg2) {
            super();
            this.mName = arg2.mName;
            this.mIcon = arg2.mIcon;
            this.mUri = arg2.mUri;
            this.mKey = arg2.mKey;
            this.mIsBot = arg2.mIsBot;
            this.mIsImportant = arg2.mIsImportant;
        }

        public Person build() {
            return new Person(this);
        }

        public Builder setBot(boolean arg1) {
            this.mIsBot = arg1;
            return this;
        }

        public Builder setIcon(IconCompat arg1) {
            this.mIcon = arg1;
            return this;
        }

        public Builder setImportant(boolean arg1) {
            this.mIsImportant = arg1;
            return this;
        }

        public Builder setKey(String arg1) {
            this.mKey = arg1;
            return this;
        }

        public Builder setName(CharSequence arg1) {
            this.mName = arg1;
            return this;
        }

        public Builder setUri(String arg1) {
            this.mUri = arg1;
            return this;
        }
    }

    private static final String ICON_KEY = "icon";
    private static final String IS_BOT_KEY = "isBot";
    private static final String IS_IMPORTANT_KEY = "isImportant";
    private static final String KEY_KEY = "key";
    private static final String NAME_KEY = "name";
    private static final String URI_KEY = "uri";
    IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;
    String mKey;
    CharSequence mName;
    String mUri;

    Person(Builder arg2) {
        super();
        this.mName = arg2.mName;
        this.mIcon = arg2.mIcon;
        this.mUri = arg2.mUri;
        this.mKey = arg2.mKey;
        this.mIsBot = arg2.mIsBot;
        this.mIsImportant = arg2.mIsImportant;
    }

    public boolean equals(Object arg4) {
        if(arg4 == null) {
            return 0;
        }

        if(!(arg4 instanceof Person)) {
            return 0;
        }

        String v1 = this.getKey();
        String v2 = ((Person)arg4).getKey();
        if(v1 == null) {
            if(v2 != null) {
            }
            else {
                if((Objects.equals(Objects.toString(this.getName()), Objects.toString(((Person)arg4).getName()))) && (Objects.equals(this.getUri(), ((Person)arg4).getUri())) && (Objects.equals(Boolean.valueOf(this.isBot()), Boolean.valueOf(((Person)arg4).isBot()))) && (Objects.equals(Boolean.valueOf(this.isImportant()), Boolean.valueOf(((Person)arg4).isImportant())))) {
                    return 1;
                }

                return 0;
            }
        }

        return Objects.equals(v1, v2);
    }

    public static Person fromAndroidPerson(android.app.Person arg0) {
        return Api28Impl.fromAndroidPerson(arg0);
    }

    public static Person fromBundle(Bundle arg3) {
        Bundle v0 = arg3.getBundle("icon");
        Builder v1 = new Builder().setName(arg3.getCharSequence("name"));
        IconCompat v0_1 = v0 != null ? IconCompat.createFromBundle(v0) : null;
        return v1.setIcon(v0_1).setUri(arg3.getString("uri")).setKey(arg3.getString("key")).setBot(arg3.getBoolean("isBot")).setImportant(arg3.getBoolean("isImportant")).build();
    }

    public static Person fromPersistableBundle(PersistableBundle arg0) {
        return Api22Impl.fromPersistableBundle(arg0);
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getKey() {
        return this.mKey;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public String getUri() {
        return this.mUri;
    }

    public int hashCode() {
        String v0 = this.getKey();
        if(v0 != null) {
            return v0.hashCode();
        }

        return Objects.hash(new Object[]{this.getName(), this.getUri(), Boolean.valueOf(this.isBot()), Boolean.valueOf(this.isImportant())});
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    public String resolveToLegacyUri() {
        String v0 = this.mUri;
        if(v0 != null) {
            return v0;
        }

        if(this.mName != null) {
            return "name:" + this.mName;
        }

        return "";
    }

    public android.app.Person toAndroidPerson() {
        return Api28Impl.toAndroidPerson(this);
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public Bundle toBundle() {
        Bundle v0 = new Bundle();
        v0.putCharSequence("name", this.mName);
        IconCompat v1 = this.mIcon;
        Bundle v1_1 = v1 != null ? v1.toBundle() : null;
        v0.putBundle("icon", v1_1);
        v0.putString("uri", this.mUri);
        v0.putString("key", this.mKey);
        v0.putBoolean("isBot", this.mIsBot);
        v0.putBoolean("isImportant", this.mIsImportant);
        return v0;
    }

    public PersistableBundle toPersistableBundle() {
        return Api22Impl.toPersistableBundle(this);
    }
}

