// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: google/protobuf/descriptor.proto
package com.google.protobuf;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class EnumOptions extends Message<EnumOptions, EnumOptions.Builder> {
  public static final ProtoAdapter<EnumOptions> ADAPTER = new ProtoAdapter_EnumOptions();

  private static final long serialVersionUID = 0L;

  public static final Boolean DEFAULT_ALLOW_ALIAS = false;

  public static final Boolean DEFAULT_DEPRECATED = false;

  /**
   * Set this option to true to allow mapping different tag names to the same
   * value.
   */
  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean allow_alias;

  /**
   * Is this enum deprecated?
   * Depending on the target platform, this can emit Deprecated annotations
   * for the enum, or it will be completely ignored; in the very least, this
   * is a formalization for deprecating enums.
   */
  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.ProtoAdapter#BOOL"
  )
  public final Boolean deprecated;

  public EnumOptions(Boolean allow_alias, Boolean deprecated) {
    this(allow_alias, deprecated, ByteString.EMPTY);
  }

  public EnumOptions(Boolean allow_alias, Boolean deprecated, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.allow_alias = allow_alias;
    this.deprecated = deprecated;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.allow_alias = allow_alias;
    builder.deprecated = deprecated;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof EnumOptions)) return false;
    EnumOptions o = (EnumOptions) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(allow_alias, o.allow_alias)
        && Internal.equals(deprecated, o.deprecated);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (allow_alias != null ? allow_alias.hashCode() : 0);
      result = result * 37 + (deprecated != null ? deprecated.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (allow_alias != null) builder.append(", allow_alias=").append(allow_alias);
    if (deprecated != null) builder.append(", deprecated=").append(deprecated);
    return builder.replace(0, 2, "EnumOptions{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<EnumOptions, Builder> {
    public Boolean allow_alias;

    public Boolean deprecated;

    public Builder() {
    }

    /**
     * Set this option to true to allow mapping different tag names to the same
     * value.
     */
    public Builder allow_alias(Boolean allow_alias) {
      this.allow_alias = allow_alias;
      return this;
    }

    /**
     * Is this enum deprecated?
     * Depending on the target platform, this can emit Deprecated annotations
     * for the enum, or it will be completely ignored; in the very least, this
     * is a formalization for deprecating enums.
     */
    public Builder deprecated(Boolean deprecated) {
      this.deprecated = deprecated;
      return this;
    }

    @Override
    public EnumOptions build() {
      return new EnumOptions(allow_alias, deprecated, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_EnumOptions extends ProtoAdapter<EnumOptions> {
    public ProtoAdapter_EnumOptions() {
      super(FieldEncoding.LENGTH_DELIMITED, EnumOptions.class, "type.googleapis.com/google.protobuf.EnumOptions");
    }

    @Override
    public int encodedSize(EnumOptions value) {
      return ProtoAdapter.BOOL.encodedSizeWithTag(2, value.allow_alias)
          + ProtoAdapter.BOOL.encodedSizeWithTag(3, value.deprecated)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, EnumOptions value) throws IOException {
      ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.allow_alias);
      ProtoAdapter.BOOL.encodeWithTag(writer, 3, value.deprecated);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public EnumOptions decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 2: builder.allow_alias(ProtoAdapter.BOOL.decode(reader)); break;
          case 3: builder.deprecated(ProtoAdapter.BOOL.decode(reader)); break;
          default: {
            reader.readUnknownField(tag);
          }
        }
      }
      builder.addUnknownFields(reader.endMessageAndGetUnknownFields(token));
      return builder.build();
    }

    @Override
    public EnumOptions redact(EnumOptions value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}