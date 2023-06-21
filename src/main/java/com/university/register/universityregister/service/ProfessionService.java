package com.university.register.universityregister.service;

import com.university.register.universityregister.domain.Profession;
import com.university.register.universityregister.domain.Student;
import com.university.register.universityregister.dto.request.ProfessionRequest;
import com.university.register.universityregister.dto.response.ProfessionResponse;
import com.university.register.universityregister.dto.response.StudentResponse;
import com.university.register.universityregister.repository.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessionService {

  private final ProfessionRepository professionRepository;
  private final ModelMapper mapper;

  public ProfessionResponse save(ProfessionRequest request) {
    var profession = mapper.map(request, Profession.class);

    var newProfession = professionRepository.save(profession);

    var response  = mapper.map(newProfession, ProfessionResponse.class);

    return response;
  }





  public List<ProfessionResponse> getAllStudent() {

    List<Profession> professionList = professionRepository.findAll();

    List<ProfessionResponse> professionResponseList = professionList.stream().map(itm ->
            mapper.map(itm, ProfessionResponse.class)
    ).collect(Collectors.toList());

    return professionResponseList;
  }


  public ProfessionResponse update(ProfessionRequest request, Integer id) {

    var profession = professionRepository.findById(id).orElseThrow(() -> new RuntimeException("Bazada telebe yoxdur"));

    profession = mapper.map(request, Profession.class);
    profession.setId(id);

    var professionNew =  professionRepository.save(profession);

    var professionResponse= mapper.map(professionNew, ProfessionResponse.class);

    return professionResponse;


  }



  public void delete(Integer id){
    professionRepository.deleteById(id);
  }


}
