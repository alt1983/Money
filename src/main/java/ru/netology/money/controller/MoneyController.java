package ru.netology.money.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.money.MoneyService;
import ru.netology.money.domain.Confirmation;
import ru.netology.money.domain.Transfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "https://serp-ya.github.io")
@RequestMapping("/")
public class MoneyController {

    private MoneyService service;

    public MoneyController(MoneyService service) {
        this.service = service;
    }

    @PostMapping("transfer")
    public Map<String, String> getTransfer(@RequestBody Transfer transfer) {

        HashMap<String, String> map = new HashMap<>();
        map.put("operationId", service.getTransfer(transfer));
        return map;

    }

    @PostMapping("confirmOperation")
    public Map<String, String> getConfirmOperation(@RequestBody Confirmation confirmation) {
        HashMap<String, String> map = new HashMap<>();
        map.put("operationId", service.getConfirmOperation(confirmation));
        return map;

    }


}
