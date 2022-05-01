package htw.berlin.webtech.srandom.service;

import htw.berlin.webtech.srandom.persistence.SrandomEntity;
import htw.berlin.webtech.srandom.persistence.SrandomRepository;
import htw.berlin.webtech.srandom.web.api.Srandom;
import htw.berlin.webtech.srandom.web.api.SrandomCreateOrUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SrandomService {

    private final SrandomRepository srandomRepository;

    public SrandomService(SrandomRepository srandomRepository){
        this.srandomRepository = srandomRepository;

    }

    public List<Srandom> findAll(){
        List<SrandomEntity> srandom = srandomRepository.findAll();
        return srandom.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Srandom findById(Long id){
        var srandomEntity  = srandomRepository.findById(id);
        return srandomEntity.map(this :: transformEntity).orElse(null);
    }
    public Srandom create(SrandomCreateOrUpdateRequest request) {
        var srandomEntity = new SrandomEntity(request.getTitel(), request.getGenre(), request.getAutor(), request.getYtLink(), request.getErscheinungsdatum());
     srandomEntity = srandomRepository.save(srandomEntity);
     return transformEntity(srandomEntity);
    }

    public Srandom update(Long id, SrandomCreateOrUpdateRequest request){
        var srandomEntityOptional = srandomRepository.findById(id);
        if(srandomEntityOptional.isEmpty()){
            return null;

        }
        var srandomEntity = srandomEntityOptional.get();
        srandomEntity.setAutor(request.getAutor());
        srandomEntity.setErscheinungsdatum(request.getErscheinungsdatum());
        srandomEntity.setYtLink(request.getYtLink());
        srandomEntity.setGenre(request.getGenre());
        srandomRepository.save(srandomEntity);

        return transformEntity(srandomEntity);

    }

    private Srandom transformEntity(SrandomEntity srandomEntity){
        return new Srandom (

                srandomEntity.getId(),
                srandomEntity.getTitel(),
                srandomEntity.getGenre(),
                srandomEntity.getYtLink(),
                srandomEntity.getAutor(),
                srandomEntity.getErscheinungsdatum());
    }
}



