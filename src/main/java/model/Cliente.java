package model;

import java.io.Serializable;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente extends Pessoa implements Serializable{
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "cli_id")
    private Long id;
    
    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*/ 1 cliente -> várias vendas
    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;
    
    public List<Venda> getVendas() { return vendas; }
    public void setVendas(List<Venda> vendas) { this.vendas = vendas; }
   
    */

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    
@Override
public int hashCode() {
    int hash = 3;
    hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
    return hash;
}

@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    
    final Cliente other = (Cliente) obj;
    
    if (this.id == null || other.id == null) {
        return false;
    }
    return this.id.equals(other.id);
}
    
}
