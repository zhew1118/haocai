package dqyhyy.haocai.service;

import dqyhyy.haocai.domain.Haocai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HaocaiService {
    /**
     * 根据耗材id查找一种耗材
     * @param haocaiId
     * @return
     */
    Haocai findOne(String haocaiId);


    /**
     * 查询所有上架耗材
     * @return
     */
    List<Haocai> findUpAll();


    /**
     * 分页查询所有耗材
     * @param pageable
     * @return
     */
    Page<Haocai> findAll(Pageable pageable);


    /**
     * 存储一种耗材
     * @param haocai
     * @return
     */
    Haocai save(Haocai haocai);

    /**
     * 耗材上架
     * @param haocaiId
     * @return
     */
    Haocai onSale(String haocaiId);


    /**
     * 耗材下架
     * @param haocaiId
     * @return
     */
    Haocai offSale(String haocaiId);

}
