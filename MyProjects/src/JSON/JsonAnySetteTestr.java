package JSON;

import java.io.IOException;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class JsonAnySetterTest {

//    {
//        "name":"My bean",
//        "attr2":"val2",
//        "attr1":"val1"
//    }

    public static void main(String[] args) throws JsonProcessingException {
        String json
                = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";

        ExtendableBean bean = new ObjectMapper()
                .readerFor(ExtendableBean.class)
                .readValue(json);

    }

    public static class ExtendableBean {
        public String name;
        private Map<String, String> properties;

        @JsonAnySetter
        public void add(String key, String value) {
            properties.put(key, value);
        }
    }
}
