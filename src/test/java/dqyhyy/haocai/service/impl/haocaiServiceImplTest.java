package dqyhyy.haocai.service.impl;

import dqyhyy.haocai.domain.Haocai;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class haocaiServiceImplTest {
    @Autowired
    private haocaiServiceImpl haocaiService;

    @Test
    public void findOne() {
        Haocai haocai = haocaiService.findOne(1);
        Assert.assertEquals(1, (int)haocai.getHaocaiId());
    }

    @Test
    public void findUpAll() {
        List<Haocai> haocaiList = haocaiService.findUpAll();
        Assert.assertEquals(1, haocaiList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0,2);
        Page<Haocai> haocaiPage = haocaiService.findAll(request);
        Assert.assertEquals(1, haocaiPage.getTotalElements());
    }

    @Test
    public void save() {
        Haocai haocai = new Haocai();
        haocai.setHaocaiName("针筒");
        haocai.setAmount(2000);

        Haocai result = haocaiService.save(haocai);
        Assert.assertNotNull(result);
    }
}