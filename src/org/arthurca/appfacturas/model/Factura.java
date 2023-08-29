package org.arthurca.appfacturas.model;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
//
public class Factura {



    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente; // Cliente tiene una relacion con Factura y viceversa
    private ItemFactura[] items;
    private int indiceItems; /// add method with index in a for
    public static final int MAX_ITEMS= 10;
    public static int ultimoIdFactura;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.folio= ++ultimoIdFactura;
        this.fecha = new Date();
    }

    public int getIdFactura() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void addAItemFactura(ItemFactura item){
        if (indiceItems < MAX_ITEMS){
            this.items[indiceItems++] = item;
        }
    }


    public float calcularTotal(){

        float total = 0.0f;

        for (ItemFactura item : this.items){
            if (item == null){
                continue;
            }
            total += item.calcularImporte();

        }
        return total;
    }

    public String generarDetalle(){

        StringBuilder sb = new StringBuilder("Factura N°: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(cliente.getIdFiscal())
                .append("\nDescripcion:")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df= new SimpleDateFormat("dd 'de'  MMMM, yyyy");
        sb.append("Fecha Emision: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");


        for (ItemFactura item :this.items){

            if (item == null){
                continue;
            }
            sb.append(item.toString()) //Se pone de forma explicita para poder verlo al momento de debuggear
                    .append("\n");

        }
        sb.append("\nGran total: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }

    //No creamos un get/sett de indiceItems ya que solo se maneja de forma interna.

}
