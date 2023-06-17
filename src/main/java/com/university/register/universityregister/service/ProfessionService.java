package com.university.register.universityregister.service;

import com.university.register.universityregister.domain.Profession;
import com.university.register.universityregister.dto.request.ProfessionRequest;
import com.university.register.universityregister.dto.response.ProfessionResponse;
import com.university.register.universityregister.repository.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

}
