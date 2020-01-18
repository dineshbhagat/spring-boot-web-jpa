package com.example.notepad.jsonviews;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OrgViews {
    public interface Public {}
    public interface Internal extends Public {}
    public interface Health {}
    public interface HR {}
    // if we make all views as class, then we can not extends multiple classes as following
    public interface Personal extends Internal, Health, HR {}

    /**
     * This enum is used to get/store respective ObjectReader, ObjectWriter, also controls which all
     * view types are allowed for rendering
     */
    enum Views {
        PUBLIC, INTERNAL, PERSONAL
    }
    private static class Helper {
        static final Map<Views, ObjectWriter> objectWriterMap = new HashMap<>();
        static final Map<Views, ObjectReader> objectReaderMap = new HashMap<>();
        static {
            final ObjectMapper objectWriter = new ObjectMapper();
            objectWriter.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
            objectWriterMap.put(Views.PUBLIC, objectWriter.writerWithView(OrgViews.Public.class));
            objectWriterMap.put(Views.INTERNAL, objectWriter.writerWithView(OrgViews.Internal.class));
            objectWriterMap.put(Views.PERSONAL, objectWriter.writerWithView(OrgViews.Personal.class));
        }

        static {
            final ObjectMapper objectReader = new ObjectMapper();
            objectReader.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
            objectReaderMap.put(Views.PUBLIC, objectReader.readerWithView(OrgViews.Public.class));
            objectReaderMap.put(Views.INTERNAL, objectReader.readerWithView(OrgViews.Internal.class));
            objectReaderMap.put(Views.PERSONAL, objectReader.readerWithView(OrgViews.Personal.class));
        }
    }

    public static String serialize(Object object, Views views) throws JsonProcessingException {
        ObjectWriter objectWriter = Helper.objectWriterMap.get(views);
        if (objectWriter != null) {
            return objectWriter.writeValueAsString(object);
        }
        return "";
    }

    public static <T> T deSerialize(Class clazz, String jsonString, Views views) throws IOException {
        ObjectReader objectReader = Helper.objectReaderMap.get(views);

        if (objectReader != null) {
            return objectReader.forType(clazz).readValue(jsonString);
        }
        return null;
    }
}
