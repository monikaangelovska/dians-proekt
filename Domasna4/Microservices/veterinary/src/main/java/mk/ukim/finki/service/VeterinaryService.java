package mk.ukim.finki.service;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.entity.Veterinary;
import mk.ukim.finki.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VeterinaryService {

    @Autowired
    private VeterinaryRepository veterinaryRepository;

        public List<Veterinary> findAllVeterinaries(){
            List<Veterinary> veterinaries=veterinaryRepository.findAll();
            veterinaries.sort(Veterinary.compareByName);
            return veterinaries;
        }

        public Optional<Veterinary> findByIdVeterinary(Long Id) {
            return veterinaryRepository.findById(Id);
        }

        public List<Veterinary> findByNameVeterinary(String text) {
            if(veterinaryRepository.findByNameIgnoreCaseContains(text).size()>1)
            {
                List<Veterinary> veterinaries=veterinaryRepository.findByNameIgnoreCaseContains(text);
                veterinaries.sort(Veterinary.compareByName);
                return veterinaries;
            }
            return veterinaryRepository.findByNameIgnoreCaseContains(text);
        }

}
