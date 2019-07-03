package com.onekey.baseandroidproject.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * gson工具类。
 *
 * Created by onekey on 19-7-3.
 */

public class GsonTool {

    private GsonTool() {
    }

    /**
     * 将null序列化为空字符串。
     */
    public static final TypeAdapter<String> NON_STRING = new TypeAdapter<String>() {
        @Override
        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }

        @Override
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }
    };

    /**
     * int类型换到double去解析。
     */
    public static final TypeAdapter<Number> DOUBLE_INT = new TypeAdapter<Number>() {
        @Override
        public void write(JsonWriter writer, Number value) throws IOException {
            writer.value(value);
        }

        @Override
        public Number read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return 0;
            }
            return (int) reader.nextDouble();
        }
    };

    private static Gson INSTANCE = null;

    static {
        INSTANCE = new GsonBuilder().registerTypeAdapter(String.class, NON_STRING)
                .registerTypeAdapter(int.class, DOUBLE_INT)
                .create();
    }

    public static final Gson create() {
        return new GsonBuilder().registerTypeAdapter(String.class, NON_STRING)
                .registerTypeAdapter(int.class, DOUBLE_INT)
                .create();
    }

    /**
     * 此Gson会序列化为null的字段。
     *
     * @return Gson对象。
     */
    public static final Gson createIncludeNull() {
        return new GsonBuilder().registerTypeAdapter(String.class, NON_STRING)
                .registerTypeAdapter(int.class, DOUBLE_INT)
                .serializeNulls()
                .create();
    }

    public static <T> String toJson(T t) {
        return INSTANCE.toJson(t);
    }

    public static <T> T fromJson(String json, Class<T> cls) {
        return INSTANCE.fromJson(json, cls);
    }

    public static <T> T fromJson(String json, TypeToken<T> token) {
        return INSTANCE.fromJson(json, token.getType());
    }
}
