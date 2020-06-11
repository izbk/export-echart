package io.github.izbk.export.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.izbk.export.util.JsonLocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author zbk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataCenterMonthlyReportReq {

    /**
     * 开始时间
     */
    @NotNull(message = "开始时间不能为空")
    @JsonDeserialize(using = JsonLocalDateTimeDeserializer.class)
    private LocalDateTime beginDate;

    /**
     * 结束时间
     */
    @NotNull(message = "结束时间不能为空")
    @JsonDeserialize(using = JsonLocalDateTimeDeserializer.class)
    private LocalDateTime endDate;
}
