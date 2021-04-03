package svalbuena.springframework.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.PetType;
import svalbuena.springframework.sfgpetclinic.services.PetTypeService;

@Profile({"default", "map"})
@Service
public class PetTypeMapService extends AbstractMapService<PetType> implements PetTypeService {}
