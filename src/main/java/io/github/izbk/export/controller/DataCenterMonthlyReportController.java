package io.github.izbk.export.controller;

import io.github.izbk.export.service.DataCenterReportService;
import io.github.izbk.export.util.DateUtil;
import io.github.izbk.export.util.ResponseUtils;
import io.github.izbk.export.util.ResultUtil;
import io.github.izbk.export.vo.DataCenterMonthlyReportReq;
import net.cdsunrise.common.utility.vo.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbk
 */
@RestController
@RequestMapping("/dataCenterMonthlyReport")
public class DataCenterMonthlyReportController {

    private final DataCenterReportService dataCenterReportService;

    public DataCenterMonthlyReportController(DataCenterReportService dataCenterReportService) {
        this.dataCenterReportService = dataCenterReportService;
    }

    /**
     * 生成大数据中心月报数据
     * @param beginDate
     * @param endDate
     * @return
     */
    @GetMapping("export")
    public ResponseEntity<byte[]> export(@RequestParam("beginDate") Long beginDate,@RequestParam("endDate") Long endDate) {
        return ResponseUtils.buildResponseEntity(dataCenterReportService.export(
                new DataCenterMonthlyReportReq(DateUtil.longToLocalDateTime(beginDate),DateUtil.longToLocalDateTime(endDate))));
    }

    @GetMapping("queryReportData")
    public Result queryReportData(@RequestParam("beginDate") Long beginDate, @RequestParam("endDate") Long endDate) {
        return ResultUtil.buildSuccessResultWithData(dataCenterReportService.queryReportData(
                new DataCenterMonthlyReportReq(DateUtil.longToLocalDateTime(beginDate),DateUtil.longToLocalDateTime(endDate))));
    }

}
