package br.bonnasys.vaccines.domain.usecase.vaccine.create;

import br.bonnasys.vaccines.domain.model.Vaccine;
import br.bonnasys.vaccines.domain.repository.VaccineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateVaccineUseCaseImpl implements CreateVaccineUseCase{

    private final VaccineRepository vaccineRepository;

    @Override
    public Vaccine execute(CreateVaccineCommand command) {
        Vaccine vaccine = new Vaccine();
        vaccine.setName(command.name());
        vaccine.setProducer(command.producer());
        return vaccineRepository.save(vaccine);
    }

}
