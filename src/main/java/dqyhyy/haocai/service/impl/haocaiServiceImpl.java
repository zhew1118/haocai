package dqyhyy.haocai.service.impl;

import dqyhyy.haocai.domain.Haocai;
import dqyhyy.haocai.enums.HaocaiStatusEnum;
import dqyhyy.haocai.repository.HaocaiRepository;
import dqyhyy.haocai.service.HaocaiService;
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
}
