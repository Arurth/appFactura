package org.arthurca.appfacturas;

import org.arthurca.appfacturas.model.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setIdFiscal("55344");
        cliente.setNombre("Antonio");

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa descripcion: ");
        String descripcion = sc.nextLine();
        Factura factura = new Factura(descripcion,cliente);


        Producto producto;

        System.out.println();

        for (int i = 0; i < 5 ; i++){

            producto = new Producto();
            System.out.print("Ingresa el N° de producto " + producto.getCodigo() + ": " );
            producto.setNombre(sc.nextLine());

            System.out.print("Ingresa el precio: ");
            producto.setPrecio(sc.nextFloat());

            System.out.print("Ingresa la cantidad: ");

            factura.addAItemFactura(new ItemFactura(sc.nextInt(),producto));

            System.out.println();

        }
        System.out.println(factura.generarDetalle());



    }
}
