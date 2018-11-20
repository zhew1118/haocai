package dqyhyy.haocai.controller;

import dqyhyy.haocai.domain.Haocai;
import dqyhyy.haocai.exception.HaocaiException;
import dqyhyy.haocai.form.HaocaiForm;
import dqyhyy.haocai.service.HaocaiService;
import dqyhyy.haocai.utils.KeyUtil;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class HaocaiBackendController {

    @Autowired
    private HaocaiService haocaiService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {
        PageRequest request = PageRequest.of(page-1, size);
        Page<Haocai> haocaiPage = haocaiService.findAll(request);
        map.put("haocaiPage", haocaiPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("admin/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "haocaiId", required = false) String haocaiId,
                              Map<String, Object> map){
        if(!StringUtils.isEmpty(haocaiId)){
            Haocai haocai = haocaiService.findOne(haocaiId);
            map.put("haocai", haocai);
        }

        return new ModelAndView("admin/index", map);
    }

    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("haocaiId") String haocaiId,
                               Map<String, Object> map) {
        try{
            haocaiService.onSale(haocaiId);
        } catch (HaocaiException e) {
            map.put("msg", e.getMessage());
            map.put("url", "list");
            return new ModelAndView("common/error", map);
        }

        map.put("url","list");
        return new ModelAndView("common/success", map);
    }

    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("haocaiId") String haocaiId,
                               Map<String, Object> map) {
        try{
            haocaiService.offSale(haocaiId);
        } catch (HaocaiException e) {
            map.put("msg", e.getMessage());
            map.put("url", "list");
            return new ModelAndView("common/error", map);
        }

        map.put("url","list");
        return new ModelAndView("common/success", map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid HaocaiForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if(bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "index");
            return new ModelAndView("common/error", map);
        }

        Haocai haocai = new Haocai();
        try {
            //如果haocaiId非空， 为更改
            if(!StringUtils.isEmpty(form.getHaocaiId())){
                haocai = haocaiService.findOne(form.getHaocaiId());
            } else {
                //haocaiId为空， 生成id
                form.setHaocaiId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(form, haocai);
            haocaiService.save(haocai);
        } catch (HaocaiException e) {
            map.put("msg", e.getMessage());
            map.put("url", "index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "list");
        return new ModelAndView("common/success", map);
    }
}
