package dqyhyy.haocai.controller;

import dqyhyy.haocai.domain.Haocai;
import dqyhyy.haocai.service.HaocaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/admin/haocai")
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
        return new ModelAndView("haocai/list", map);
    }
}
