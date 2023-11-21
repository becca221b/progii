class Cola_ {

    class Nodo {
        int info;
        Nodo sig;
    }

    Nodo raiz,fondo;

    Cola_() {
        raiz=null;
        fondo=null;
    }

    boolean vacia (){
        if (raiz == null)
            return true;
        else
            return false;
    }

    void insertar (int info)
    {
        Nodo nuevo;
        nuevo = new Nodo ();
        nuevo.info = info;
        nuevo.sig = null;
        if (vacia ()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }

    int extraer ()
    {
        if (!vacia ())
        {
            int informacion = raiz.info;
            if (raiz == fondo){
                raiz = null;
                fondo = null;
            } else {
                raiz = raiz.sig;
            }
            return informacion;
        } else
            return Integer.MAX_VALUE;
    }

    public void imprimir() {
        Nodo reco=raiz;
        System.out.println("Listado de todos los elementos de la cola.");
        while (reco!=null) {
            System.out.print(reco.info+"-");
            reco=reco.sig;
        }
        System.out.println();
    }

    public int cantidad() {
        int cant=0;
        Nodo reco=raiz;
        while (reco!=null) {
            cant++;
            reco=reco.sig;
        }
        return cant;
    }
}

public class Simulacion_ejemplo {
    public static void main(String[] args) {
        int estado = 0;
        int llegada = 2;
        int salida = -1;
        int cantAtendidas = 0;
        Cola_ cola = new Cola_();
        for (int minuto = 0; minuto < 600; minuto++) {
            if (llegada == minuto) {
                if (estado == 0) {
                    estado = 1;
                    salida = minuto + 4;
                } else {
                    cola.insertar(minuto);
                }
                llegada = minuto + 2 ;
            }
            if (salida == minuto) {
                estado = 0;
                cantAtendidas++;
                if (!cola.vacia()) {
                    cola.extraer();
                    estado = 1;
                    salida = minuto + 4;
                }
            }
        }
        //CANTIDAD DE CLIENTES ATENDIDOS DESPUES DE 10HS
        System.out.println("Atendidos:"+String.valueOf(cantAtendidas));
        System.out.println("En cola"+String.valueOf(cola.cantidad()));
        System.out.println("Minuto llegada:"+String.valueOf(cola.extraer()));
    }
}
