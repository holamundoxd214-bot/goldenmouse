package androidx.core.content.pm;

import java.util.ArrayList;
import java.util.List;

public abstract class ShortcutInfoCompatSaver {
    public class NoopImpl extends ShortcutInfoCompatSaver {
        public NoopImpl() {
            super();
        }

        public Object addShortcuts(List arg1) {
            return this.addShortcuts(arg1);
        }

        public Void addShortcuts(List arg1) {
            return null;
        }

        public Object removeAllShortcuts() {
            return this.removeAllShortcuts();
        }

        public Void removeAllShortcuts() {
            return null;
        }

        public Object removeShortcuts(List arg1) {
            return this.removeShortcuts(arg1);
        }

        public Void removeShortcuts(List arg1) {
            return null;
        }
    }

    public ShortcutInfoCompatSaver() {
        super();
    }

    public abstract Object addShortcuts(List arg1);

    public List getShortcuts() throws Exception {
        return new ArrayList();
    }

    public abstract Object removeAllShortcuts();

    public abstract Object removeShortcuts(List arg1);
}

