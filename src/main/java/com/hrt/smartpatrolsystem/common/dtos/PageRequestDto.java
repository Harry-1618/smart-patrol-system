package com.hrt.smartpatrolsystem.common.dtos;

import com.hrt.smartpatrolsystem.user.dtos.UserDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class PageRequestDto{

    protected Integer pageSize;
    protected Integer page;

    public void checkParam() {
        if (this.page == null || this.page < 0) {
            this.page=1;
        }
        if (this.pageSize == null || this.pageSize < 0 || this.pageSize > 100) {
            this.pageSize = 10;
        }
    }
}