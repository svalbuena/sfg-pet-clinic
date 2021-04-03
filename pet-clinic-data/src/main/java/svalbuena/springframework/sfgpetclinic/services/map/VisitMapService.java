package svalbuena.springframework.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import svalbuena.springframework.sfgpetclinic.model.Visit;
import svalbuena.springframework.sfgpetclinic.services.VisitService;

@Profile({"default", "map"})
@Service
public class VisitMapService extends AbstractMapService<Visit> implements VisitService {}
