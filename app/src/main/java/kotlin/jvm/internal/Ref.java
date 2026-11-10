package kotlin.jvm.internal;

import java.io.Serializable;

public class Ref {
    public final class BooleanRef implements Serializable {
        public boolean element;

        public BooleanRef() {
            super();
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public final class ByteRef implements Serializable {
        public byte element;

        public ByteRef() {
            super();
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public final class CharRef implements Serializable {
        public char element;

        public CharRef() {
            super();
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public final class DoubleRef implements Serializable {
        public double element;

        public DoubleRef() {
            super();
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public final class FloatRef implements Serializable {
        public float element;

        public FloatRef() {
            super();
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public final class IntRef implements Serializable {
        public int element;

        public IntRef() {
            super();
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public final class LongRef implements Serializable {
        public long element;

        public LongRef() {
            super();
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public final class ObjectRef implements Serializable {
        public Object element;

        public ObjectRef() {
            super();
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    public final class ShortRef implements Serializable {
        public short element;

        public ShortRef() {
            super();
        }

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    private Ref() {
        super();
    }
}

