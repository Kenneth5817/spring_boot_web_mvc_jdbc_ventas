package org.iesvdm.service;

import org.iesvdm.dao.ComercialDAO;
import org.iesvdm.modelo.Comercial;

import java.util.List;
import java.util.Optional;

public class ComercialService {
    private ComercialDAO comercialDAO;

    //Se utiliza inyección automática por constructor del framework Spring.
    //Por tanto, se puede omitir la anotación Autowired
    //@Autowired
    public ComercialService(ComercialDAO comercialDAO) {
        this.comercialDAO = comercialDAO;
    }

    public List<Comercial> listAll() {

        return comercialDAO.getAll();

    }
    public Comercial one(Integer id) {
        Optional<Comercial> optFab = comercialDAO.find(id);
        if (optFab.isPresent())
            return optFab.get();
        else
            return null;
    }

    public void newComercial(Comercial comercial) {

        comercialDAO.create(comercial);

    }

    public void replaceComercial(Comercial comercial) {

        comercialDAO.update(comercial);

    }

    public void deleteComercial(int id) {
        comercialDAO.delete(id);

    }

}
