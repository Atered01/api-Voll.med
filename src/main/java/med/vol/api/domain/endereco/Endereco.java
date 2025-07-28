package med.vol.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String complemento;
    private String uf;
    private Integer numero;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.complemento = dados.complemento();
        this.uf = dados.uf();
        this.numero = dados.numero();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (this.logradouro != null) {
            this.logradouro = dados.logradouro();
        }
        if (this.bairro != null) {
            this.bairro = dados.bairro();
        }
        if (this.cep != null) {
            this.cep = dados.cep();
        }
        if (this.cidade != null) {
            this.cidade = dados.cidade();
        }
        if (this.complemento != null) {
            this.complemento = dados.complemento();
        }
        if (this.uf != null) {
            this.uf = dados.uf();
        }
        if (this.numero != null) {
            this.numero = dados.numero();
        }
    }
}
