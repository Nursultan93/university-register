package com.university.register.universityregister.controller;

import com.university.register.universityregister.dto.request.ProfessionRequest;
import com.university.register.universityregister.dto.response.ProfessionResponse;
import com.university.register.universityregister.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profession")
@RequiredArgsConstructor
public class ProfessionController {

  private final ProfessionService professionService;

  @PostMapping
  public ProfessionResponse create(@RequestBody ProfessionRequest request){
    return professionService.save(request);
  }

  //Butun ixtisaslari getiren service
  //Ixtisadi update eden service
  //Ixtisasi silen service
  //CasCase type duzgun elave etmek. Ixtisas silinende ona bagli student varsa silinmesin.

}
