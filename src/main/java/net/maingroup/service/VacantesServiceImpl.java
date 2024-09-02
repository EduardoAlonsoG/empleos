package net.maingroup.service;

import net.maingroup.model.Vacante;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class VacantesServiceImpl implements IVacantesService{
    private List<Vacante> lista = null;

    public VacantesServiceImpl(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lista = new LinkedList<>();
        try {
            Vacante temp = new Vacante();
            temp.setId(1);
            temp.setNombre("Contador");
            temp.setFecha(sdf.parse("21-02-2019"));
            temp.setSalario(6666);
            temp.setDescripcion("ayuda necesito un contador");
            temp.setDestacado(1);
            lista.add(temp);

            Vacante temp1 = new Vacante();
            temp1.setId(2);
            temp1.setNombre("Auxiliar de Cocina");
            temp1.setFecha(sdf.parse("23-04-2019"));
            temp1.setSalario(4748);
            temp1.setDescripcion("Se solicita un ayudante de cocina");
            temp1.setDestacado(0);
            temp1.setImagen("empresa2.png");
            lista.add(temp1);

            Vacante temp2 = new Vacante();
            temp2.setId(3);
            temp2.setNombre("Mesero de Fiestas");
            temp2.setFecha(sdf.parse("29-02-2019"));
            temp2.setSalario(4748);
            temp2.setDescripcion("Se solicita mesero para eventos");
            temp2.setDestacado(1);
            temp2.setImagen("empresa3.png");
            lista.add(temp2);

            Vacante temp3 = new Vacante();
            temp3.setId(4);
            temp3.setNombre("Ingeniero en siste,as");
            temp3.setFecha(sdf.parse("21-02-2019"));
            temp3.setSalario(4748);
            temp3.setDescripcion("Ayuda no puedo usar una impresora");
            temp3.setDestacado(0);
            lista.add(temp3);

            Vacante temp5 = new Vacante();
            temp5.setId(5);
            temp5.setNombre("pastelero");
            temp5.setFecha(sdf.parse("21-02-2019"));
            temp5.setSalario(4748);
            temp5.setDescripcion("Se solicita un pastelero para hacer pruebas de cosas ");
            temp5.setDestacado(1);
            temp5.setImagen("empresa1.png");
            lista.add(temp5);
        }catch (ParseException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Vacante> buscarTodas() {
            return this.lista;
    }

    public Vacante buscarPorId(Integer idVacante){
        for(Vacante v : this.lista){
            if(Objects.equals(v.getId(), idVacante))
                return v;
        }
        return null;
    }
}
