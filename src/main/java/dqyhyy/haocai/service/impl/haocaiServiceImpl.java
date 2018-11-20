package dqyhyy.haocai.service.impl;

import dqyhyy.haocai.domain.Haocai;
import dqyhyy.haocai.enums.HaocaiStatusEnum;
import dqyhyy.haocai.enums.ResultEnum;
import dqyhyy.haocai.exception.HaocaiException;
import dqyhyy.haocai.repository.HaocaiRepository;
import dqyhyy.haocai.service.HaocaiService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class haocaiServiceImpl implements HaocaiService {

    @Autowired
    private HaocaiRepository haocaiRepository;

    /**
     * 根据耗材id查找一种耗材
     *
     * @param haocaiId
     * @return
     */
    @Override
    public Haocai findOne(String haocaiId) {
        return haocaiRepository.getOne(haocaiId);
    }

    /**
     * 查询所有上架耗材， 1上架， 0下架， 详见HaocaiStatusEnum.java
     *
     * @return
     */
    @Override
    public List<Haocai> findUpAll() {
        return haocaiRepository.findByHaocaiStatus(HaocaiStatusEnum.UP.getCode());
    }

    /**
     * 分页查询所有耗材
     *
     * @param pageable
     * @return
     */
    @Override
    public Page<Haocai> findAll(Pageable pageable) {
        return haocaiRepository.findAll(pageable);
    }

    /**
     * 存储一种耗材
     *
     * @param haocai
     * @return
     */
    @Override
    public Haocai save(Haocai haocai) {
        return haocaiRepository.save(haocai);
    }

    /**
     * 耗材上架
     *
     * @param haocaiId
     * @return
     */
    @Override
    public Haocai onSale(String haocaiId) {
        Haocai haocai = haocaiRepository.getOne(haocaiId);
        if(haocai == null) {
            throw new HaocaiException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(haocai.getHaocaiStatusEnum() == HaocaiStatusEnum.UP){
            throw new HaocaiException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        haocai.setHaocaiStatus(HaocaiStatusEnum.UP.getCode());
        return haocaiRepository.save(haocai);
    }

    /**
     * 耗材下架
     *
     * @param haocaiId
     * @return
     */
    @Override
    public Haocai offSale(String haocaiId) {
        Haocai haocai = haocaiRepository.getOne(haocaiId);
        if(haocai == null) {
            throw new HaocaiException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(haocai.getHaocaiStatusEnum() == HaocaiStatusEnum.DOWN){
            throw new HaocaiException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        haocai.setHaocaiStatus(HaocaiStatusEnum.DOWN.getCode());
        return haocaiRepository.save(haocai);
    }
}
