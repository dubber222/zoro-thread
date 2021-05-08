package com.zoro.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "thread学习相关接口")
@ApiSort(value = 1)
@RequestMapping("/thread")
@Slf4j
public class TestController {

    /**
     * thread
     *
     * @param string
     * @param columnName
     * @param sorting
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/test")
    @ApiOperation("test")
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "columnName", value = "列名", defaultValue = "class_id"),
            @ApiImplicitParam(name = "sorting", value = "排序", defaultValue = "desc")
    })
    public String test(@RequestBody @ApiParam(name = "用户对象", value = "传入JSON格式", required = true) String string,
                       @RequestParam(required = true) String columnName, String sorting) {

        return JSON.toJSONString("");
    }
}
