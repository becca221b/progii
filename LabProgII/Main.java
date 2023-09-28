import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GestorCuenta gestorCuenta= new GestorCuenta();

        CuentaPersona cuenta1 = new CuentaPersona("Pedro", "De La Cuenca");
        gestorCuenta.agregarCuentaPersona(cuenta1);

        CuentaSociedad cuenta2= new CuentaSociedad("UCP", "Fundación");
        gestorCuenta.agregarCuentaSociedad(cuenta2);

        CuentaPersona cuenta3= new CuentaPersona("Roberto","Perez");
        gestorCuenta.agregarCuentaPersona(cuenta3);


        cuenta1.depositar(125);
        cuenta1.retirar(100);
        //cuenta1.mostrarInformacion();

        cuenta2.depositar(1000);
        cuenta2.retirar(200);
        //cuenta2.mostrarInformacion();

        gestorCuenta.mostrarTodasLasCuentas();

        gestorCuenta.eliminarCuentaPersona(5);

        gestorCuenta.mostrarTodasLasCuentas();
    }
}
    
    abstract class Cuenta{
        protected long numeroCuenta;
        protected double saldo;

        static int generador = 1;
        Cuenta(){
            this.numeroCuenta= generador++;
            this.saldo=0;
        }
        
        public double getSaldo(){
            return saldo;
        }
        public void setSaldo(double saldo){
            this.saldo= saldo;
        }
        
        public long getNumeroCuenta(){
            return numeroCuenta;
        }
        public void setNumeroCuenta(long numeroCuenta){
            this.numeroCuenta= numeroCuenta;
        }
        
        //metodos
        public abstract void depositar(double cantidad);
        
        public abstract void retirar(double cantidad);
        
        public abstract void mostrarInformacion();
    }
    
    class CuentaPersona extends Cuenta{
        private String nombre;
        private String apellido;
        
        CuentaPersona(String nombre, String apellido){
            //super.saldo=0;
            this.nombre= nombre;
            this.apellido= apellido;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        @Override
        public void depositar(double cantidad){
            super.saldo+= cantidad;
        }
        
        @Override
        public void retirar(double cantidad){
            super.saldo-= cantidad;
        }
        
        @Override
        public void mostrarInformacion(){
            System.out.println("Numero de cuenta: "+this.numeroCuenta);
            System.out.println("Cliente: "+this.nombre+" "+this.apellido);
            System.out.println("Saldo: "+this.saldo);
        }
        
    }
    
    class CuentaSociedad extends Cuenta{
        private String nombreEmpresa;
        private String tipoEmpresa;
        
        CuentaSociedad(String nombreEmpresa, String tipoEmpresa){
            //super(saldo);
            this.nombreEmpresa= nombreEmpresa;
            this.tipoEmpresa= tipoEmpresa;
        }

        public void setNombreEmpresa(String nombreEmpresa) {
            this.nombreEmpresa = nombreEmpresa;
        }

        public void setTipoEmpresa(String tipoEmpresa) {
            this.tipoEmpresa = tipoEmpresa;
        }

        public String getNombreEmpresa() {
            return nombreEmpresa;
        }

        public String getTipoEmpresa() {
            return tipoEmpresa;
        }

        @Override
        public void depositar(double cantidad){
            super.saldo+= cantidad;
        }
        
        @Override
        public void retirar(double cantidad){
            if(super.saldo>cantidad){
                super.saldo-= cantidad;
            }else{
                System.out.println("Saldo insuficiente");
            }
            
        }
        
        @Override
        public void mostrarInformacion(){
            System.out.println(this.numeroCuenta);
            System.out.println("Cliente: "+this.nombreEmpresa);
            System.out.println("Tipo: "+this.tipoEmpresa);
            System.out.println("Saldo: "+this.saldo);
        }
    }
    
    class GestorCuenta{

    Scanner scanner= new Scanner(System.in);
        private ArrayList<CuentaPersona> listaCuentasPersonas;
        private ArrayList<CuentaSociedad> listaCuentasSociedades;

        public GestorCuenta() {
            this.listaCuentasPersonas = new ArrayList<CuentaPersona>();
            this.listaCuentasSociedades = new ArrayList<CuentaSociedad>();
        }

        public void agregarCuentaPersona(CuentaPersona cuentaPersona){
            listaCuentasPersonas.add(cuentaPersona);
        }

        public void agregarCuentaSociedad(CuentaSociedad cuentaSociedad){
            listaCuentasSociedades.add(cuentaSociedad);
        }

        public void eliminarCuentaPersona(long numeroCuenta){
            for(CuentaPersona cuenta: listaCuentasPersonas){
               if(cuenta.numeroCuenta==numeroCuenta){
                   listaCuentasPersonas.remove(cuenta);
               }else{
                   System.out.println("Cuenta does not exist");
               }
            }
            //listaCuentasPersonas.removeIf(cuenta -> cuenta.numeroCuenta == numeroCuenta);

        }

        public void eliminarCuentaSociedad (long numeroCuenta){
            listaCuentasSociedades.removeIf(cuenta -> cuenta.numeroCuenta == numeroCuenta);
        }

        public void editarCuentaPersona(long numeroCuenta){
            System.out.println("Ingrese el nuevo nombre");
            String nuevoNombre= scanner.next();
            System.out.println("Ingrese el nuevo apellido");
            String nuevoApellido= scanner.next();

            for(CuentaPersona cuenta: listaCuentasPersonas){
                if(cuenta.numeroCuenta==numeroCuenta){
                    cuenta.setNombre(nuevoNombre);
                    cuenta.setApellido(nuevoApellido);
                }
            }
        }

        public void editarCuentaSociedad(long numeroCuenta){
            System.out.println("Ingrese el nuevo nombre de la sociedad");
            String nuevoNombre= scanner.next();
            System.out.println("Ingrese el nuevo tipo de sociedad");
            String nuevoTipo= scanner.next();

            for(CuentaSociedad cuenta: listaCuentasSociedades){
                if(cuenta.numeroCuenta==numeroCuenta){
                    cuenta.setNombreEmpresa(nuevoNombre);
                    cuenta.setTipoEmpresa(nuevoTipo);
                }
            }
        }

        public void mostrarTodasLasCuentas(){
            System.out.println(String.format("%20s\t%20s\t%20s\t%20s","Numero de Cuenta","Nombre", "Apellido/Tipo", "Saldo"));
            for(CuentaPersona cuenta: listaCuentasPersonas){

                System.out.println(String.format("%20s\t%20s\t%20s\t%20s",cuenta.numeroCuenta,cuenta.getNombre(),cuenta.getApellido(),cuenta.saldo));
            }
            //System.out.println("Cuentas de Empresas");
            //System.out.println(String.format("%20s\t%20s\t%20s\t%20s","Numero de Cuenta","Nombre", "Tipo","Saldo"));
            for(CuentaSociedad cuenta: listaCuentasSociedades){

                System.out.println(String.format("%20s\t%20s\t%20s\t%20s",cuenta.numeroCuenta,cuenta.getNombreEmpresa(),cuenta.getTipoEmpresa(),cuenta.saldo));
            }
            System.out.print("\n");

        }
    }

