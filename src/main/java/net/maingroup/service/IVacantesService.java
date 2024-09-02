package net.maingroup.service;

import net.maingroup.model.Vacante;

import java.util.List;

public interface IVacantesService {
    public List<Vacante> buscarTodas();
    public Vacante buscarPorId(Integer idVacante);
}
