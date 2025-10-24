package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "vendas")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "venda_id")
    private int id;

    @Column(name = "venda_data_hora", nullable = false)
    private LocalDateTime dataVenda;

    @Column(name = "venda_valor", columnDefinition = "numeric(12,2)")
    private double valorVenda;

    @Enumerated(EnumType.STRING)
    @Column(name = "venda_forma_contrato")
    private FormaContrato formaContrato;

    @Enumerated(EnumType.STRING)
    @Column(name = "venda_forma_pgto")
    private FormaPgto formaPgto;

    @ManyToOne
    @JoinColumn(name = "venda_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "venda_vendedor")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "venda_veiculo")
    private Veiculo veiculo;

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public FormaContrato getFormaContrato() {
        return formaContrato;
    }

    public void setFormaContrato(FormaContrato formaContrato) {
        this.formaContrato = formaContrato;
    }

    public FormaPgto getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(FormaPgto formaPgto) {
        this.formaPgto = formaPgto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String exibirDados() {
        String aux = "VENDA CADASTRADA\n";
        aux += "Data: " + dataVenda + "\n";
        aux += "Valor: " + valorVenda + "\n";
        aux += "Cliente: " + cliente.getNome() + "\n";
        aux += "Vendedor: " + vendedor.getNome() + "\n";
        aux += "Veículo: " + veiculo.getPlaca() + " | " + veiculo.getMarca() + " " + veiculo.getModelo() + "\n";
        aux += "Forma de contrato: " + formaContrato + "\n";
        aux += "Forma de pagamento: " + formaPgto + "\n";

        return aux;
    }

    @Override
    public String toString() {
        return "Venda: { veiculo" + veiculo.getPlaca() + ", cliente: " + cliente.getNome() + ", vendedor: " + vendedor.getNome() + "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
