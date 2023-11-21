public class SimulacionCajero {

    public static void main(String[] args){
        Cola cola= new Cola();
        int cl_encolados=0;
        int cl_desencolados=0;

        //ENCOLAR UN CLIENTE CADA 2 MIN Y DESENCOLAR 1 CLIENTE CADA 4 MIN
        for(int i=0;i<=600;i++){
            if(i%2==0){
                cola.encolar(cl_encolados++);
            }
            if(i!=0&&i%4==0){
                cola.desencolar();
                cl_desencolados++;
            }

        }

        //CANTIDAD DE CLIENTE ATENDIDOS DESPUES DE 10HS
        System.out.print("Cantidad de clientes atendidos en 10 hs: ");
        System.out.println(cl_desencolados);

        //CANTIDAD DE CLIENTE QUE QUEDAN EN LA COLA DESPUES DE 10HS
        System.out.println("Cantidad de clientes que hay en la cola después de 10 hs: ");
        System.out.println(cola.getSize());
        System.out.println(cl_encolados-cl_desencolados);

        //HORA DE LLEGADA DEL PRIMER CLIENTE QUE NO ES ATENDIDO LUEGO DE LAS 10HS
        System.out.println("Hora de llegada del primero en la cola cuando se cumplan las 10hs");
        int tiempo=(cl_desencolados+1)*2;
        System.out.println(tiempo/60+"h "+tiempo%60+"min");

    }

}
