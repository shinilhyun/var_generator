package test;

import com.shin.util.RequestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

public class RequestTest {

    private String target = null;
    private String result = null;

    @Before
    public void be(){
        target = "변수 생성기";
    }
    @Test
    public void reqTest(){
        result = RequestUtil.requestPapago(target);
        Assert.notNull(result);
    }

    @After
    public void af() {
        System.out.println(result);
    }
}
