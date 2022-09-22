package co.edu.uniandes.dse.parcialejemplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.entities.MedicoEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.MedicoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Transactional
    public MedicoEntity createMedico(MedicoEntity medico) throws IllegalOperationException {
        log.info("Inicia proceso de creación de un medico");

        if (!validateRegistroMedico(medico.getRegistroMedico()))
			throw new IllegalOperationException("Registro Medico is not valid");


        return medicoRepository.save(medico);
    }

    private boolean validateRegistroMedico(String registro) {
		return (registro.startsWith("RM"));
	}
    
}
