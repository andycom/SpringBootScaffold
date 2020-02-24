package com.fancv.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemInfoUtilTest {

    @Test
    public void getSystemInfo() {

        String osVersion = SystemInfoUtil.getSystemInfo("os.version");
        Assert.assertNotNull(osVersion);
        System.out.println("操作系统版本：" + osVersion);

        String userPath = SystemInfoUtil.getSystemInfo("user.dir");
        Assert.assertNotNull(userPath);
        System.out.println("用户路径：" + userPath);
    }
}