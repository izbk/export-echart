package io.github.izbk.export.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author zbk
 * @date 2020/6/10 17:45
 */
public class JsonLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    public JsonLocalDateTimeDeserializer() {
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String text = jsonParser.getText();
        return StringUtils.isEmpty(text) ? null : DateUtil.longToLocalDateTime(Long.parseLong(text));
    }
}
