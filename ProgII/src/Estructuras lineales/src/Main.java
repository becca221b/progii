public class Main {
    public static void main(String[] args){
       ListaSimple lista= new ListaSimple();

       lista.agregar(1);
       lista.agregar(2);
       lista.agregar(3);

       /*
       lista.imprimir();

       System.out.print(lista.buscarElem(2)+"\n");

       //lista.eliminarValor(2);
       //lista.imprimir();

       //lista.eliminarPosicion(2);
       //lista.imprimir();


       ListaDoble listaDoble= new ListaDoble();

       listaDoble.agregar("Juan");
       listaDoble.agregar("Pedro");
       listaDoble.agregar("Ana");

       listaDoble.imprimir();


       //lista.agregarAlMedio(7,1);
       //lista.imprimir();

        listaDoble.eliminar(1);
        System.out.print("\n");
        listaDoble.imprimir();
        System.out.print("\n");

        System.out.println(listaDoble.retornarValor(3));

        lista.retornarValor(3);
        */
        ListaCircular circleLinkedList= new ListaCircular();

        circleLinkedList.agregar(1);
        circleLinkedList.agregar(2);
        circleLinkedList.agregar(3);
        circleLinkedList.imprimir();

        circleLinkedList.eliminar(1);
        System.out.print("\n");
        circleLinkedList.imprimir();
        System.out.print("\n");
        circleLinkedList.retornarValor(2);

    }
}
