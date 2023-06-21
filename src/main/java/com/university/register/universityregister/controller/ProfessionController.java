package com.university.register.universityregister.controller;

import com.university.register.universityregister.dto.request.ProfessionRequest;
import com.university.register.universityregister.dto.response.ProfessionResponse;
import com.university.register.universityregister.dto.response.StudentResponse;
import com.university.register.universityregister.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profession")
@RequiredArgsConstructor
public class ProfessionController {

  private final ProfessionService professionService;

  @PostMapping
  public ProfessionResponse create(@RequestBody ProfessionRequest request){
    return professionService.save(request);
  }

  @GetMapping
  public List<ProfessionResponse> getAll(){
    return professionService.getAllStudent();
  }

  @PutMapping("/{id}")
  public ProfessionResponse update(@RequestBody ProfessionRequest request, @PathVariable Integer id){
    return professionService.update(request, id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    professionService.delete(id);
  }


  //Butun ixtisaslari getiren service+
  //Ixtisadi update eden service +
  //Ixtisasi silen service +
  //CasCase type duzgun elave etmek. Ixtisas silinende ona bagli student varsa silinmesin.

}
