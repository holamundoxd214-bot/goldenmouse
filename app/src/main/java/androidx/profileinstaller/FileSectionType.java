package androidx.profileinstaller;

enum FileSectionType {
    public static final enum FileSectionType AGGREGATION_COUNT;
    public static final enum FileSectionType CLASSES;
    public static final enum FileSectionType DEX_FILES;
    public static final enum FileSectionType EXTRA_DESCRIPTORS;
    public static final enum FileSectionType METHODS;
    private final long mValue;

    private static FileSectionType[] $values() {
        return new FileSectionType[]{FileSectionType.DEX_FILES, FileSectionType.EXTRA_DESCRIPTORS, FileSectionType.CLASSES, FileSectionType.METHODS, FileSectionType.AGGREGATION_COUNT};
    }

    static {
        FileSectionType.DEX_FILES = new FileSectionType("DEX_FILES", 0, 0);
        FileSectionType.EXTRA_DESCRIPTORS = new FileSectionType("EXTRA_DESCRIPTORS", 1, 1);
        FileSectionType.CLASSES = new FileSectionType("CLASSES", 2, 2);
        FileSectionType.METHODS = new FileSectionType("METHODS", 3, 3);
        FileSectionType.AGGREGATION_COUNT = new FileSectionType("AGGREGATION_COUNT", 4, 4);
        FileSectionType.$VALUES = FileSectionType.$values();
    }

    private FileSectionType(String arg1, int arg2, long arg3) {
        super(arg1, arg2);
        this.mValue = arg3;
    }

    static FileSectionType fromValue(long arg4) {
        FileSectionType[] v0 = FileSectionType.values();
        int v1;
        for(v1 = 0; v1 < v0.length; ++v1) {
            if(v0[v1].getValue() == arg4) {
                return v0[v1];
            }
        }

        throw new IllegalArgumentException("Unsupported FileSection Type " + arg4);
    }

    public long getValue() {
        return this.mValue;
    }

    public static FileSectionType valueOf(String arg1) {
        return Enum.valueOf(FileSectionType.class, arg1);
    }

    public static FileSectionType[] values() {
        return FileSectionType.$VALUES.clone();
    }
}

