package svalbuena.springframework.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.Specialty;
import svalbuena.springframework.sfgpetclinic.services.SpecialtyService;

@Profile({"default", "map"})
@Service
public class SpecialtyMapService extends AbstractMapService<Specialty> implements SpecialtyService {}
