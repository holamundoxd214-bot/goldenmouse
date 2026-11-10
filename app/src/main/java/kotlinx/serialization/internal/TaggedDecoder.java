package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder$DefaultImpls;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

@Metadata(d1={"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\b\'\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u000B\u001A\u00028\u0000*\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH$¢\u0006\u0002\u0010\u000FJ\u0015\u0010\u0010\u001A\u00020\u00022\u0006\u0010\u0011\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0011\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0015J\u0017\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u0011\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0015J\u0015\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0011\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001CJ\u0015\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0011\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001FJ\u0015\u0010 \u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010!J\u0015\u0010\"\u001A\u00020#2\u0006\u0010\u0011\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010$J\u0015\u0010%\u001A\u00020&2\u0006\u0010\u0011\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\'J\u0015\u0010(\u001A\u00020)2\u0006\u0010\u0011\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010*J\u0015\u0010+\u001A\u00020,2\u0006\u0010\u0011\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010-J\u0015\u0010.\u001A\u00020/2\u0006\u0010\u0011\u001A\u00028\u0000H\u0014¢\u0006\u0002\u00100J\u001D\u00101\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00028\u00002\u0006\u00102\u001A\u00020\fH\u0014¢\u0006\u0002\u00103J\u001D\u00104\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00028\u00002\u0006\u00105\u001A\u00020\fH\u0014¢\u0006\u0002\u00106J1\u00107\u001A\u0002H8\"\n\b\u0001\u00108*\u0004\u0018\u00010\u00022\f\u00109\u001A\b\u0012\u0004\u0012\u0002H80:2\b\u0010;\u001A\u0004\u0018\u0001H8H\u0014¢\u0006\u0002\u0010<J\u0010\u0010=\u001A\u00020\u00032\u0006\u0010>\u001A\u00020\fH\u0016J\b\u0010?\u001A\u00020\u0014H\u0016J\b\u0010@\u001A\u0004\u0018\u00010\u0017J\u0006\u0010A\u001A\u00020\u0014J\u0006\u0010B\u001A\u00020\u001BJ\u0006\u0010C\u001A\u00020\u001EJ\u0006\u0010D\u001A\u00020\u000EJ\u0006\u0010E\u001A\u00020#J\u0006\u0010F\u001A\u00020&J\u0006\u0010G\u001A\u00020)J\u0006\u0010H\u001A\u00020,J\u0006\u0010I\u001A\u00020/J\u000E\u0010J\u001A\u00020\u000E2\u0006\u00102\u001A\u00020\fJ\u0010\u0010K\u001A\u00020\u00042\u0006\u0010>\u001A\u00020\fH\u0016J\u0010\u0010L\u001A\u00020M2\u0006\u0010>\u001A\u00020\fH\u0016J\u0016\u0010N\u001A\u00020\u00142\u0006\u0010>\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EJ\u0016\u0010O\u001A\u00020\u001B2\u0006\u0010>\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EJ\u0016\u0010P\u001A\u00020\u001E2\u0006\u0010>\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EJ\u0016\u0010Q\u001A\u00020\u000E2\u0006\u0010>\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EJ\u0016\u0010R\u001A\u00020#2\u0006\u0010>\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EJ\u0016\u0010S\u001A\u00020&2\u0006\u0010>\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EJ\u0016\u0010T\u001A\u00020)2\u0006\u0010>\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EJ\u0016\u0010U\u001A\u00020,2\u0006\u0010>\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EJ\u0016\u0010V\u001A\u00020/2\u0006\u0010>\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EJ\u0016\u0010W\u001A\u00020\u00032\u0006\u0010>\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EJ?\u0010X\u001A\u0002H8\"\n\b\u0001\u00108*\u0004\u0018\u00010\u00022\u0006\u0010>\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\f\u00109\u001A\b\u0012\u0004\u0012\u0002H80:2\b\u0010;\u001A\u0004\u0018\u0001H8¢\u0006\u0002\u0010YJA\u0010Z\u001A\u0004\u0018\u0001H8\"\b\b\u0001\u00108*\u00020\u00022\u0006\u0010>\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u000E\u00109\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001H80:2\b\u0010;\u001A\u0004\u0018\u0001H8¢\u0006\u0002\u0010YJ)\u0010[\u001A\u0002H\\\"\u0004\b\u0001\u0010\\2\u0006\u0010\u0011\u001A\u00028\u00002\f\u0010]\u001A\b\u0012\u0004\u0012\u0002H\\0^H\u0002¢\u0006\u0002\u0010_J\u0015\u0010j\u001A\u00020M2\u0006\u0010k\u001A\u00028\u0000H\u0004¢\u0006\u0002\u0010lJ\u0016\u0010m\u001A\u00020M2\f\u0010n\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0004J\r\u0010p\u001A\u00028\u0000H\u0004¢\u0006\u0002\u0010gR\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR$\u0010`\u001A\u0012\u0012\u0004\u0012\u00028\u00000aj\b\u0012\u0004\u0012\u00028\u0000`bX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bc\u0010dR\u0014\u0010e\u001A\u00028\u00008DX\u0084\u0004¢\u0006\u0006\u001A\u0004\bf\u0010gR\u0016\u0010h\u001A\u0004\u0018\u00018\u00008DX\u0084\u0004¢\u0006\u0006\u001A\u0004\bi\u0010gR\u000E\u0010o\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006q"}, d2={"Lkotlinx/serialization/internal/TaggedDecoder;", "Tag", "", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "<init>", "()V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "getTag", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "decodeTaggedValue", "tag", "(Ljava/lang/Object;)Ljava/lang/Object;", "decodeTaggedNotNullMark", "", "(Ljava/lang/Object;)Z", "decodeTaggedNull", "", "(Ljava/lang/Object;)Ljava/lang/Void;", "decodeTaggedBoolean", "decodeTaggedByte", "", "(Ljava/lang/Object;)B", "decodeTaggedShort", "", "(Ljava/lang/Object;)S", "decodeTaggedInt", "(Ljava/lang/Object;)I", "decodeTaggedLong", "", "(Ljava/lang/Object;)J", "decodeTaggedFloat", "", "(Ljava/lang/Object;)F", "decodeTaggedDouble", "", "(Ljava/lang/Object;)D", "decodeTaggedChar", "", "(Ljava/lang/Object;)C", "decodeTaggedString", "", "(Ljava/lang/Object;)Ljava/lang/String;", "decodeTaggedEnum", "enumDescriptor", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeTaggedInline", "inlineDescriptor", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeInline", "descriptor", "decodeNotNullMark", "decodeNull", "decodeBoolean", "decodeByte", "decodeShort", "decodeInt", "decodeLong", "decodeFloat", "decodeDouble", "decodeChar", "decodeString", "decodeEnum", "beginStructure", "endStructure", "", "decodeBooleanElement", "decodeByteElement", "decodeShortElement", "decodeIntElement", "decodeLongElement", "decodeFloatElement", "decodeDoubleElement", "decodeCharElement", "decodeStringElement", "decodeInlineElement", "decodeSerializableElement", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeNullableSerializableElement", "tagBlock", "E", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "tagStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTagStack$kotlinx_serialization_core", "()Ljava/util/ArrayList;", "currentTag", "getCurrentTag", "()Ljava/lang/Object;", "currentTagOrNull", "getCurrentTagOrNull", "pushTag", "name", "(Ljava/lang/Object;)V", "copyTagsTo", "other", "flag", "popTag", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @InternalSerializationApi public abstract class TaggedDecoder implements CompositeDecoder, Decoder {
    private boolean flag;
    private final ArrayList tagStack;

    public TaggedDecoder() {
        super();
        this.tagStack = new ArrayList();
    }

    public CompositeDecoder beginStructure(SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this;
    }

    protected final void copyTagsTo(TaggedDecoder arg2) {
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg2.tagStack.addAll(this.tagStack);
    }

    public final boolean decodeBoolean() {
        return this.decodeTaggedBoolean(this.popTag());
    }

    public final boolean decodeBooleanElement(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.decodeTaggedBoolean(this.getTag(arg2, arg3));
    }

    public final byte decodeByte() {
        return this.decodeTaggedByte(this.popTag());
    }

    public final byte decodeByteElement(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.decodeTaggedByte(this.getTag(arg2, arg3));
    }

    public final char decodeChar() {
        return this.decodeTaggedChar(this.popTag());
    }

    public final char decodeCharElement(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.decodeTaggedChar(this.getTag(arg2, arg3));
    }

    public int decodeCollectionSize(SerialDescriptor arg1) {
        return DefaultImpls.decodeCollectionSize(((CompositeDecoder)this), arg1);
    }

    public final double decodeDouble() {
        return this.decodeTaggedDouble(this.popTag());
    }

    public final double decodeDoubleElement(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.decodeTaggedDouble(this.getTag(arg2, arg3));
    }

    public final int decodeEnum(SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "enumDescriptor");
        return this.decodeTaggedEnum(this.popTag(), arg2);
    }

    public final float decodeFloat() {
        return this.decodeTaggedFloat(this.popTag());
    }

    public final float decodeFloatElement(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.decodeTaggedFloat(this.getTag(arg2, arg3));
    }

    public Decoder decodeInline(SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.decodeTaggedInline(this.popTag(), arg2);
    }

    public final Decoder decodeInlineElement(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.decodeTaggedInline(this.getTag(arg2, arg3), arg2.getElementDescriptor(arg3));
    }

    public final int decodeInt() {
        return this.decodeTaggedInt(this.popTag());
    }

    public final int decodeIntElement(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.decodeTaggedInt(this.getTag(arg2, arg3));
    }

    public final long decodeLong() {
        return this.decodeTaggedLong(this.popTag());
    }

    public final long decodeLongElement(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.decodeTaggedLong(this.getTag(arg2, arg3));
    }

    public boolean decodeNotNullMark() {
        Object v0 = this.getCurrentTagOrNull();
        if(v0 == null) {
            return 0;
        }

        return this.decodeTaggedNotNullMark(v0);
    }

    public final Void decodeNull() {
        return null;
    }

    public final Object decodeNullableSerializableElement(SerialDescriptor arg2, int arg3, DeserializationStrategy arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        Intrinsics.checkNotNullParameter(arg4, "deserializer");
        return this.tagBlock(this.getTag(arg2, arg3), new TaggedDecoder$$ExternalSyntheticLambda1(this, arg4, arg5));
    }

    static final Object decodeNullableSerializableElement$lambda$3(TaggedDecoder arg2, DeserializationStrategy arg3, Object arg4) {
        TaggedDecoder v0 = arg2;
        if(!arg3.getDescriptor().isNullable()) {
            if(((Decoder)v0).decodeNotNullMark()) {
            }
            else {
                return ((Decoder)v0).decodeNull();
            }
        }

        return arg2.decodeSerializableValue(arg3, arg4);
    }

    @ExperimentalSerializationApi public Object decodeNullableSerializableValue(DeserializationStrategy arg1) {
        return kotlinx.serialization.encoding.Decoder$DefaultImpls.decodeNullableSerializableValue(((Decoder)this), arg1);
    }

    @ExperimentalSerializationApi public boolean decodeSequentially() {
        return DefaultImpls.decodeSequentially(((CompositeDecoder)this));
    }

    public final Object decodeSerializableElement(SerialDescriptor arg2, int arg3, DeserializationStrategy arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        Intrinsics.checkNotNullParameter(arg4, "deserializer");
        return this.tagBlock(this.getTag(arg2, arg3), new TaggedDecoder$$ExternalSyntheticLambda0(this, arg4, arg5));
    }

    static final Object decodeSerializableElement$lambda$1(TaggedDecoder arg0, DeserializationStrategy arg1, Object arg2) {
        return arg0.decodeSerializableValue(arg1, arg2);
    }

    protected Object decodeSerializableValue(DeserializationStrategy arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "deserializer");
        return this.decodeSerializableValue(arg1);
    }

    public Object decodeSerializableValue(DeserializationStrategy arg1) {
        return kotlinx.serialization.encoding.Decoder$DefaultImpls.decodeSerializableValue(((Decoder)this), arg1);
    }

    public final short decodeShort() {
        return this.decodeTaggedShort(this.popTag());
    }

    public final short decodeShortElement(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.decodeTaggedShort(this.getTag(arg2, arg3));
    }

    public final String decodeString() {
        return this.decodeTaggedString(this.popTag());
    }

    public final String decodeStringElement(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.decodeTaggedString(this.getTag(arg2, arg3));
    }

    protected boolean decodeTaggedBoolean(Object arg1) {
        Object v0 = this.decodeTaggedValue(arg1);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean)v0).booleanValue();
    }

    protected byte decodeTaggedByte(Object arg1) {
        Object v0 = this.decodeTaggedValue(arg1);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte)v0).byteValue();
    }

    protected char decodeTaggedChar(Object arg1) {
        Object v0 = this.decodeTaggedValue(arg1);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Char");
        return ((Character)v0).charValue();
    }

    protected double decodeTaggedDouble(Object arg1) {
        Object v0 = this.decodeTaggedValue(arg1);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Double");
        return ((Double)v0).doubleValue();
    }

    protected int decodeTaggedEnum(Object arg2, SerialDescriptor arg3) {
        Intrinsics.checkNotNullParameter(arg3, "enumDescriptor");
        Object v1 = this.decodeTaggedValue(arg2);
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer)v1).intValue();
    }

    protected float decodeTaggedFloat(Object arg1) {
        Object v0 = this.decodeTaggedValue(arg1);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Float");
        return ((Float)v0).floatValue();
    }

    protected Decoder decodeTaggedInline(Object arg2, SerialDescriptor arg3) {
        Intrinsics.checkNotNullParameter(arg3, "inlineDescriptor");
        this.pushTag(arg2);
        return this;
    }

    protected int decodeTaggedInt(Object arg1) {
        Object v0 = this.decodeTaggedValue(arg1);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer)v0).intValue();
    }

    protected long decodeTaggedLong(Object arg1) {
        Object v0 = this.decodeTaggedValue(arg1);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Long");
        return ((Long)v0).longValue();
    }

    protected boolean decodeTaggedNotNullMark(Object arg1) {
        return 1;
    }

    protected Void decodeTaggedNull(Object arg1) {
        return null;
    }

    protected short decodeTaggedShort(Object arg1) {
        Object v0 = this.decodeTaggedValue(arg1);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.Short");
        return ((Short)v0).shortValue();
    }

    protected String decodeTaggedString(Object arg1) {
        Object v0 = this.decodeTaggedValue(arg1);
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.String");
        return ((String)v0);
    }

    protected Object decodeTaggedValue(Object arg2) {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(this.getClass()) + " can\'t retrieve untyped values");
    }

    public void endStructure(SerialDescriptor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
    }

    protected final Object getCurrentTag() {
        return CollectionsKt.last(this.tagStack);
    }

    protected final Object getCurrentTagOrNull() {
        return CollectionsKt.lastOrNull(this.tagStack);
    }

    public SerializersModule getSerializersModule() {
        return SerializersModuleBuildersKt.EmptySerializersModule();
    }

    protected abstract Object getTag(SerialDescriptor arg1, int arg2);

    public final ArrayList getTagStack$kotlinx_serialization_core() {
        return this.tagStack;
    }

    protected final Object popTag() {
        Object v0 = this.tagStack.remove(CollectionsKt.getLastIndex(this.tagStack));
        this.flag = true;
        return v0;
    }

    protected final void pushTag(Object arg1) {
        this.tagStack.add(arg1);
    }

    private final Object tagBlock(Object arg1, Function0 arg2) {
        this.pushTag(arg1);
        arg1 = arg2.invoke();
        if(!this.flag) {
            this.popTag();
        }

        this.flag = false;
        return arg1;
    }
}

