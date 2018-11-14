//package dqyhyy.haocai.controller;
//
//import dqyhyy.haocai.domain.Haocai;
//import dqyhyy.haocai.repository.HaocaiRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class HaocaiController {
//    @Autowired
//    private HaocaiRepository haocaiRepository;
//
//    /**
//     * 查询所有耗材列表
//     * @return
//     */
//    @GetMapping(value="/haocai")
//    public List<Haocai> haocaiList(){
//        return haocaiRepository.findAll();
//    }
//
//    /**
//     * 添加一种耗材
//     * @param haocai
//     * @return
//     */
//    @PostMapping(value="/haocai")
//    public Haocai haocaiAdd(Haocai haocai){
//        haocai.setHaocaiAmount(haocai.getHaocaiAmount());
//        haocai.setHaocaiExpirationDate(haocai.getHaocaiExpirationDate());
//        haocai.setHaocaiName(haocai.getHaocaiName());
//        haocai.setHaocaiPurchaseDate(haocai.getHaocaiPurchaseDate());
//        haocai.setHaocaiSpec(haocai.getHaocaiSpec());
//        haocai.setHaocaiType(haocai.getHaocaiType());
//        haocai.setHaocaiUnit(haocai.getHaocaiUnit());
//        haocai.setHaocaiVendor(haocai.getHaocaiVendor());
//
//        return haocaiRepository.save(haocai);
//    }
//
//    /**
//     * 查询一种耗材
//     * @param id
//     * @return
//     */
//    @GetMapping(value = "/haocai/{id}")
//    public Haocai haocaiFindOne(@PathVariable("id") Integer id){
//        return haocaiRepository.findById(id).get();
//    }
//
//    /**
//     * 更改耗材库存数量
//     * @param id
//     * @return
//     */
//    @PutMapping(value = "/haocai/update_amount/{id}")
//    public Haocai haocaiUpdateAmount(@PathVariable("id") Integer id,
//                               @RequestParam("amount") Integer amount){
//        Haocai haocai = new Haocai();
//        haocai.setHaocaiId(id);
//        haocai.setHaocaiAmount(amount);
//
//        return haocaiRepository.save(haocai);
//    }
//
//    /**
//     * 删除一种库存
//     * @param id
//     */
//    @DeleteMapping(value = "/haocai/{id}")
//    public void haocaiDelete(@PathVariable("id") Integer id){
//        haocaiRepository.delete(haocaiRepository.findById(id).get());
//    }
//}
