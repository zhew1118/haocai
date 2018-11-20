package dqyhyy.haocai.service.impl;

import dqyhyy.haocai.domain.Haocai;
import dqyhyy.haocai.enums.HaocaiStatusEnum;
import lombok.Data;
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
@Data
public class haocaiServiceImplTest {
    @Autowired
    private haocaiServiceImpl haocaiService;

    @Test
    public void findOne() {
        Haocai haocai = haocaiService.findOne("1");
        Assert.assertEquals("1", haocai.getHaocaiId());
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
        haocai.setHaocaiId("10");
        haocai.setHaocaiName("针筒");
        haocai.setHaocaiAmount(2000);
        haocai.setHaocaiExpirationDate("20191111");
        haocai.setHaocaiPurchaseDate("20181111");
        haocai.setHaocaiStatus(HaocaiStatusEnum.DOWN.getCode());
        haocai.setHaocaiSpec("小型");

        Haocai result = haocaiService.save(haocai);
        Assert.assertNotNull(result);
    }

    @Test
    public void onSale(){
        Haocai result = haocaiService.onSale("10");
        Assert.assertEquals(HaocaiStatusEnum.UP, result.getHaocaiStatusEnum());
    }
}