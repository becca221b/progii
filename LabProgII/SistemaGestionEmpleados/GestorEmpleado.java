package SistemaGestionEmpleados;


import java.util.ArrayList;


public class GestorEmpleado {
    private ArrayList<Empleado> empleadosList;

    GestorEmpleado() {
        this.empleadosList = new ArrayList<Empleado>();
    }

    public void agregar(Empleado empleado){
        empleado.setId(empleadosList.size()+1);
        empleadosList.add(empleado);
    }

    public void eliminar(int id){
        for(int i=0;i<empleadosList.size();i++){
            Empleado e= empleadosList.get(i);
            if(e.getId()==id){
                empleadosList.remove(i);
                break;
            }
        }
        
    }
    public void modificar(int id, String nombre){
        for(Empleado empleado : empleadosList){
            if(empleado.getId()==id){
                empleado.setNombre(nombre);
                break;
            }
        }
    }

    @Override
    public String toString() {
        String detalles="";
        for(Empleado empleado : empleadosList){
            detalles+= empleado.getId()+"\t"+empleado.getNombre()+"\t"+empleado.calcularSueldo()+"\n";
        }
        return detalles;
    }

    public ArrayList<Empleado> getEmpleadosList() {
        return empleadosList;
    }
}
