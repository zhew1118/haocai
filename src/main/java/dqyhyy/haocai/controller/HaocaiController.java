package dqyhyy.haocai.controller;

import dqyhyy.haocai.domain.Haocai;
import dqyhyy.haocai.repository.HaocaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HaocaiController {
    @Autowired
    private HaocaiRepository haocaiRepository;

    @GetMapping(value="/haocai")
    public List<Haocai> haocaiList(){
        return haocaiRepository.findAll();
    }
}
