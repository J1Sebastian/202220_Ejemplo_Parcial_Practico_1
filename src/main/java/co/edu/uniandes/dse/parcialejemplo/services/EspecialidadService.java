package co.edu.uniandes.dse.parcialejemplo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialejemplo.entities.EspecialidadEntity;
import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialejemplo.repositories.EspecialidadRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EspecialidadService {

    @Autowired
    EspecialidadRepository especialidadRepository;

    @Transactional
    public EspecialidadEntity createEspecialidad(EspecialidadEntity especialidad) throws IllegalOperationException {
        log.info("Inicia proceso de creación de la especialidad");

        if (!validateDescripcion(especialidad.getDescripcion()))
			throw new IllegalOperationException("Descripcion is not valid");


        return especialidadRepository.save(especialidad);
    }

    private boolean validateDescripcion(String descripcion) {
		return !(descripcion.length()<10);
	}
    
}
