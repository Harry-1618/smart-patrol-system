package com.hrt.smartpatrolsystem.common.vos;

import com.hrt.smartpatrolsystem.common.dtos.PageRequestDto;

import java.io.Serializable;

/**
 * ClassName: PageResponseResult
 * Package: com.hrt.smartpatrolsystem.common.vos
 * Description:
 *
 * @Author: 黄瑞天
 * @Create: 2025/4/1 - 15:14
 * @Version: v1.0
 */

public class PageResponseResult extends ResponseResult implements Serializable {
    private Integer total;

    public PageResponseResult(Integer total) {
        this.total = total;
    }

    public PageResponseResult() {

    }



    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
